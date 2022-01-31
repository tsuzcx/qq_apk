package com.tencent.qqmini.sdk.core.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy.MultiUserInfo;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy.VoIPListener;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

public class VoIPManager
{
  public static final String TAG = "VoIPManager";
  public static final int UNKNOWN = -1;
  public static volatile VoIPManager sInstance;
  private VoIPManager.EventListener mEventListener;
  private VoIPManager.JoinRoomListener mJoinRoomListener;
  private VoIPManager.MuteConfig mMuteConfig;
  private boolean mQAvHasEnterRoom;
  private boolean mQAvHasInitSDK;
  private AtomicBoolean mQAvRealEnterRoom = new AtomicBoolean(false);
  private final BroadcastReceiver mReceiver = new VoIPManager.1(this);
  private Map<Long, VoIPManager.UserModel> mRoomUserModelList = new ConcurrentHashMap();
  private int mSelfMicStat = -1;
  private int mSelfMuteStat = -1;
  private long mSelfUin = -1L;
  private VoIPProxy.VoIPListener mVoIPListener = new VoIPManager.2(this);
  private VoIPProxy mVoIPProxy = (VoIPProxy)ProxyManager.get(VoIPProxy.class);
  
  private void doExitRoom()
  {
    QMLog.i("VoIPManager", "exitRoom!");
    this.mVoIPProxy.exitRoom();
    this.mVoIPProxy.unInit();
    this.mQAvHasInitSDK = false;
    this.mQAvRealEnterRoom.set(false);
  }
  
  public static VoIPManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new VoIPManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  private JSONArray getRoomOpenIdList()
  {
    Object localObject1 = null;
    if (this.mRoomUserModelList != null)
    {
      localObject2 = this.mRoomUserModelList.keySet();
      localObject1 = new HashSet();
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        VoIPManager.UserModel localUserModel = getUserModel(((Long)((Iterator)localObject2).next()).longValue());
        if (localUserModel != null) {
          ((Set)localObject1).add(localUserModel.mOpenId);
        }
      }
      localObject1 = new JSONArray((Collection)localObject1);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new JSONArray();
    }
    return localObject2;
  }
  
  private JSONArray getSpeakingOpenIdList()
  {
    JSONArray localJSONArray = new JSONArray();
    if (this.mRoomUserModelList != null)
    {
      Iterator localIterator = this.mRoomUserModelList.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((VoIPManager.UserModel)localEntry.getValue()).mSpeaking) {
          localJSONArray.put(((VoIPManager.UserModel)localEntry.getValue()).mOpenId);
        }
      }
    }
    return localJSONArray;
  }
  
  private VoIPManager.UserModel getUserModel(long paramLong)
  {
    VoIPManager.UserModel localUserModel = null;
    if (this.mRoomUserModelList != null) {
      localUserModel = (VoIPManager.UserModel)this.mRoomUserModelList.get(Long.valueOf(paramLong));
    }
    return localUserModel;
  }
  
  private boolean isBluetoothOn()
  {
    return ((AudioManager)AppLoaderFactory.g().getMiniAppEnv().getContext().getSystemService("audio")).isBluetoothA2dpOn();
  }
  
  private boolean isHeadsetPlugged()
  {
    return ((AudioManager)AppLoaderFactory.g().getMiniAppEnv().getContext().getSystemService("audio")).isWiredHeadsetOn();
  }
  
  private boolean isMicAvailable()
  {
    AudioRecord localAudioRecord = new AudioRecord(1, 44100, 16, 1, 44100);
    for (;;)
    {
      try
      {
        if (localAudioRecord.getRecordingState() != 1)
        {
          Boolean localBoolean1 = Boolean.valueOf(false);
          localAudioRecord.startRecording();
          if (localAudioRecord.getRecordingState() != 3)
          {
            localAudioRecord.stop();
            localBoolean1 = Boolean.valueOf(false);
          }
          localAudioRecord.stop();
          return localBoolean1.booleanValue();
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("VoIPManager", "validateMicAvailability", localThrowable);
        return false;
      }
      finally
      {
        localAudioRecord.release();
      }
      Boolean localBoolean2 = Boolean.valueOf(true);
    }
  }
  
  private void putUserModel(VoIPManager.UserModel paramUserModel)
  {
    if (this.mRoomUserModelList != null) {
      this.mRoomUserModelList.put(Long.valueOf(paramUserModel.mUin), paramUserModel);
    }
  }
  
  private void qavInitSDK(long paramLong)
  {
    QMLog.i("VoIPManager", "qavInitSDK");
    this.mVoIPProxy.init(paramLong, this.mVoIPListener);
  }
  
  private int qavOpMic(boolean paramBoolean)
  {
    if (!this.mQAvRealEnterRoom.get())
    {
      QMLog.e("VoIPManager", "cant op mic currently");
      return -1;
    }
    int j = this.mVoIPProxy.enableLocalAudio(paramBoolean);
    int i;
    if (j == 0) {
      if (paramBoolean)
      {
        i = 1;
        this.mSelfMicStat = i;
        VoIPManager.UserModel localUserModel = getUserModel(this.mSelfUin);
        if (localUserModel != null) {
          localUserModel.mMicStat = this.mSelfMicStat;
        }
        QMLog.i("VoIPManager", "OpMic " + paramBoolean);
      }
    }
    for (;;)
    {
      return j;
      i = 2;
      break;
      QMLog.e("VoIPManager", "multiOperator null");
    }
  }
  
  private int qavOpMute(boolean paramBoolean)
  {
    if (!this.mQAvRealEnterRoom.get())
    {
      QMLog.e("VoIPManager", "cant op mute currently");
      return -1;
    }
    int j = this.mVoIPProxy.enableRemoteAudio(paramBoolean);
    int i;
    if (j == 0) {
      if (paramBoolean)
      {
        i = 1;
        this.mSelfMuteStat = i;
        QMLog.i("VoIPManager", "OpMute " + paramBoolean);
      }
    }
    for (;;)
    {
      return j;
      i = 2;
      break;
      QMLog.e("VoIPManager", "multiOperator null");
    }
  }
  
  private VoIPManager.UserModel removeUserModel(long paramLong)
  {
    VoIPManager.UserModel localUserModel = null;
    if (this.mRoomUserModelList != null) {
      localUserModel = (VoIPManager.UserModel)this.mRoomUserModelList.remove(Long.valueOf(paramLong));
    }
    return localUserModel;
  }
  
  private void switchAudioRoute()
  {
    QMLog.d("VoIPManager", String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s", new Object[] { Boolean.valueOf(isHeadsetPlugged()), Boolean.valueOf(isBluetoothOn()) }));
    if (isHeadsetPlugged())
    {
      this.mVoIPProxy.setAudioRoute(0);
      return;
    }
    if (isBluetoothOn())
    {
      this.mVoIPProxy.setAudioRoute(2);
      return;
    }
    this.mVoIPProxy.setAudioRoute(1);
  }
  
  private void switchAudioRoute(int paramInt)
  {
    QMLog.d("VoIPManager", String.format("switchAudioRoute route=%s isHeadsetPlugged=%s isBluetoothOn=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(isHeadsetPlugged()), Boolean.valueOf(isBluetoothOn()) }));
    this.mVoIPProxy.setAudioRoute(paramInt);
  }
  
  private void updateUserModelList(List<VoIPProxy.MultiUserInfo> paramList)
  {
    Object localObject1 = this.mRoomUserModelList.keySet();
    Object localObject2 = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((Set)localObject2).add(Long.valueOf(((VoIPProxy.MultiUserInfo)localIterator.next()).mUin));
    }
    ((Set)localObject1).retainAll((Collection)localObject2);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (VoIPProxy.MultiUserInfo)paramList.next();
      if (getUserModel(((VoIPProxy.MultiUserInfo)localObject1).mUin) == null)
      {
        localObject2 = new VoIPManager.UserModel(this, null);
        ((VoIPManager.UserModel)localObject2).mUin = ((VoIPProxy.MultiUserInfo)localObject1).mUin;
        ((VoIPManager.UserModel)localObject2).mOpenId = ((VoIPProxy.MultiUserInfo)localObject1).mOpenId;
        ((VoIPManager.UserModel)localObject2).mMicStat = 1;
        putUserModel((VoIPManager.UserModel)localObject2);
      }
    }
  }
  
  public void exitRoom()
  {
    try
    {
      if (this.mQAvHasEnterRoom)
      {
        AppLoaderFactory.g().getMiniAppEnv().getContext().unregisterReceiver(this.mReceiver);
        doExitRoom();
        this.mQAvHasEnterRoom = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean isEarPhoneMute()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 71	com/tencent/qqmini/sdk/core/manager/VoIPManager:mSelfMuteStat	I
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmpne +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	VoIPManager
    //   8	4	1	i	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  public boolean isInRoom()
  {
    try
    {
      boolean bool = this.mQAvHasEnterRoom;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean isMicMute()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 69	com/tencent/qqmini/sdk/core/manager/VoIPManager:mSelfMicStat	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_2
    //   9: if_icmpne +9 -> 18
    //   12: iconst_1
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	VoIPManager
    //   6	4	1	i	int
    //   13	7	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	23	finally
  }
  
  public void joinRoom(VoIPManager.IdResult paramIdResult, VoIPManager.MuteConfig paramMuteConfig, byte[] paramArrayOfByte, VoIPManager.JoinRoomListener paramJoinRoomListener)
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.mQAvHasEnterRoom)
        {
          QMLog.e("VoIPManager", "不能重复进房");
          if (paramJoinRoomListener != null) {
            paramJoinRoomListener.onError(-3);
          }
          return;
        }
        exitRoom();
        if (!this.mQAvHasInitSDK)
        {
          if (isMicAvailable())
          {
            qavInitSDK(paramIdResult.tinyId);
            this.mQAvHasInitSDK = true;
          }
        }
        else
        {
          this.mJoinRoomListener = paramJoinRoomListener;
          this.mSelfUin = paramIdResult.tinyId;
          i = this.mVoIPProxy.joinRoom(paramIdResult.tinyId, paramIdResult.roomId, paramIdResult.openId, paramArrayOfByte);
          if (i != 0) {
            break label199;
          }
          this.mMuteConfig = paramMuteConfig;
          this.mQAvHasEnterRoom = true;
          paramIdResult = new IntentFilter();
          paramIdResult.addAction("android.intent.action.HEADSET_PLUG");
          paramIdResult.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
          paramIdResult.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
          AppLoaderFactory.g().getMiniAppEnv().getContext().registerReceiver(this.mReceiver, paramIdResult);
          this.mRoomUserModelList.clear();
          continue;
        }
        if (paramJoinRoomListener == null) {
          continue;
        }
      }
      finally {}
      paramJoinRoomListener.onError(-2);
      continue;
      label199:
      QMLog.e("VoIPManager", "joinRoom ret = " + i);
      if (this.mJoinRoomListener != null)
      {
        this.mJoinRoomListener.onError(i);
        this.mJoinRoomListener = null;
      }
    }
  }
  
  public void setEventListener(VoIPManager.EventListener paramEventListener)
  {
    this.mEventListener = paramEventListener;
  }
  
  /* Error */
  public void updateMuteConfig(VoIPManager.MuteConfig paramMuteConfig, VoIPManager.MuteConfigListener paramMuteConfigListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 476	com/tencent/qqmini/sdk/core/manager/VoIPManager$MuteConfig:isMuteMicrophone	Z
    //   6: ifne +46 -> 52
    //   9: iconst_1
    //   10: istore 5
    //   12: aload_0
    //   13: iload 5
    //   15: invokespecial 478	com/tencent/qqmini/sdk/core/manager/VoIPManager:qavOpMic	(Z)I
    //   18: istore_3
    //   19: aload_0
    //   20: aload_1
    //   21: getfield 481	com/tencent/qqmini/sdk/core/manager/VoIPManager$MuteConfig:isMuteEarphone	Z
    //   24: invokespecial 483	com/tencent/qqmini/sdk/core/manager/VoIPManager:qavOpMute	(Z)I
    //   27: istore 4
    //   29: iload_3
    //   30: ifne +8 -> 38
    //   33: iload 4
    //   35: ifeq +23 -> 58
    //   38: aload_2
    //   39: ifnull +10 -> 49
    //   42: aload_2
    //   43: iconst_m1
    //   44: invokeinterface 488 2 0
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: iconst_0
    //   53: istore 5
    //   55: goto -43 -> 12
    //   58: aload_2
    //   59: ifnull -10 -> 49
    //   62: aload_2
    //   63: invokeinterface 491 1 0
    //   68: goto -19 -> 49
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	VoIPManager
    //   0	76	1	paramMuteConfig	VoIPManager.MuteConfig
    //   0	76	2	paramMuteConfigListener	VoIPManager.MuteConfigListener
    //   18	12	3	i	int
    //   27	7	4	j	int
    //   10	44	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	71	finally
    //   12	29	71	finally
    //   42	49	71	finally
    //   62	68	71	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.VoIPManager
 * JD-Core Version:    0.7.0.1
 */