package com.tencent.qqmini.sdk.core.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.MultiUserInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

@MiniKeep
public class VoIPManager
{
  private static final int ROOM_STATE_ENTERED = 2;
  private static final int ROOM_STATE_ENTERING = 1;
  private static final int ROOM_STATE_INITIAL = 0;
  public static final String TAG = "VoIPManager";
  public static final int UNKNOWN = -1;
  public static volatile VoIPManager sInstance;
  private VoIPManager.EventListener mEventListener;
  private VoIPManager.JoinRoomListener mJoinRoomListener;
  private VoIPManager.MuteConfig mMuteConfig;
  private boolean mQAvHasInitSDK;
  private volatile AtomicInteger mQAvRoomState = new AtomicInteger(0);
  private final BroadcastReceiver mReceiver = new VoIPManager.1(this);
  private Map<Long, VoIPManager.UserModel> mRoomUserModelList = new ConcurrentHashMap();
  private int mSelfMicStat = -1;
  private int mSelfMuteStat = -1;
  private long mSelfUin = -1L;
  private VoIPProxy.VoIPListener mVoIPListener = new VoIPManager.2(this);
  private VoIPProxy mVoIPProxy = (VoIPProxy)ProxyManager.get(VoIPProxy.class);
  private boolean needExitRoomImmediatelyAfterEntering = false;
  
  private void doExitRoom()
  {
    QMLog.i("VoIPManager", "exitRoom!");
    MiniAppEnv.g().getContext().unregisterReceiver(this.mReceiver);
    this.mVoIPProxy.exitRoom();
    this.mVoIPProxy.unInit();
    this.mQAvHasInitSDK = false;
    this.mQAvRoomState.set(0);
  }
  
  public static VoIPManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new VoIPManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private JSONArray getRoomOpenIdList()
  {
    Object localObject1 = this.mRoomUserModelList;
    if (localObject1 != null)
    {
      localObject2 = ((Map)localObject1).keySet();
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
    else
    {
      localObject1 = null;
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
    Object localObject = this.mRoomUserModelList;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((VoIPManager.UserModel)localEntry.getValue()).mSpeaking) {
          localJSONArray.put(((VoIPManager.UserModel)localEntry.getValue()).mOpenId);
        }
      }
    }
    return localJSONArray;
  }
  
  private VoIPManager.UserModel getUserModel(long paramLong)
  {
    Map localMap = this.mRoomUserModelList;
    if (localMap != null) {
      return (VoIPManager.UserModel)localMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  private void handleOnEnterRoom()
  {
    QMLog.d("VoIPManager", "onEnterRoom");
    this.mQAvRoomState.set(2);
    VoIPManager.MuteConfig localMuteConfig = this.mMuteConfig;
    if (localMuteConfig != null) {
      updateMuteConfig(localMuteConfig, null);
    }
    this.mVoIPProxy.updateRoomInfo();
    switchAudioRoute();
    if (this.needExitRoomImmediatelyAfterEntering)
    {
      exitRoom();
      this.needExitRoomImmediatelyAfterEntering = false;
    }
  }
  
  private void handleOnError(int paramInt)
  {
    QMLog.d("VoIPManager", String.format("onEnterRoom errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    Object localObject;
    if ((paramInt != 2) && (paramInt != 1))
    {
      if (paramInt == 4)
      {
        localObject = this.mEventListener;
        if (localObject != null) {
          ((VoIPManager.EventListener)localObject).onInterrupt(4, "第三方通话中断");
        }
      }
      else if (paramInt == 3)
      {
        localObject = this.mEventListener;
        if (localObject != null) {
          ((VoIPManager.EventListener)localObject).onInterrupt(3, "网络原因中断");
        }
      }
    }
    else
    {
      localObject = this.mJoinRoomListener;
      if (localObject != null)
      {
        ((VoIPManager.JoinRoomListener)localObject).onError(paramInt);
        this.mJoinRoomListener = null;
      }
    }
  }
  
  private void handleOnUserEnter(VoIPProxy.MultiUserInfo paramMultiUserInfo)
  {
    QMLog.d("VoIPManager", String.format("onUserEnter userInfo=%s", new Object[] { paramMultiUserInfo }));
    if ((this.mJoinRoomListener == null) && (getUserModel(paramMultiUserInfo.mUin) == null))
    {
      VoIPManager.UserModel localUserModel = new VoIPManager.UserModel(this, null);
      localUserModel.mUin = paramMultiUserInfo.mUin;
      localUserModel.mOpenId = paramMultiUserInfo.mOpenId;
      localUserModel.mMicStat = 1;
      putUserModel(localUserModel);
      paramMultiUserInfo = this.mEventListener;
      if (paramMultiUserInfo != null) {
        paramMultiUserInfo.onRoomMemberChange(getRoomOpenIdList());
      }
    }
  }
  
  private void handleOnUserExit(VoIPProxy.MultiUserInfo paramMultiUserInfo)
  {
    QMLog.d("VoIPManager", String.format("onUserExit userInfo=%s", new Object[] { paramMultiUserInfo }));
    if (this.mJoinRoomListener == null)
    {
      removeUserModel(paramMultiUserInfo.mUin);
      paramMultiUserInfo = this.mEventListener;
      if (paramMultiUserInfo != null) {
        paramMultiUserInfo.onRoomMemberChange(getRoomOpenIdList());
      }
    }
  }
  
  private void handleOnUserSpecking(VoIPProxy.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    QMLog.d("VoIPManager", String.format("onUserSpeaking userInfo=%s speaking=%s", new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) }));
    paramMultiUserInfo = getUserModel(paramMultiUserInfo.mUin);
    if (paramMultiUserInfo != null)
    {
      paramMultiUserInfo.mSpeaking = paramBoolean;
      paramMultiUserInfo = this.mEventListener;
      if (paramMultiUserInfo != null) {
        paramMultiUserInfo.onRoomMemberSpeaking(getSpeakingOpenIdList());
      }
    }
    else
    {
      QMLog.e("VoIPManager", "onUserSpeaking userModel==null");
    }
  }
  
  private void handleOnUserUpdate(List<VoIPProxy.MultiUserInfo> paramList)
  {
    if ((this.mJoinRoomListener != null) && (paramList != null))
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        VoIPProxy.MultiUserInfo localMultiUserInfo = (VoIPProxy.MultiUserInfo)localIterator.next();
        if (localMultiUserInfo.mUin != 0L) {
          localJSONArray.put(localMultiUserInfo.mOpenId);
        }
      }
      this.mJoinRoomListener.onJoinRoom(localJSONArray);
      updateUserModelList(paramList);
      this.mJoinRoomListener = null;
    }
  }
  
  private boolean isBluetoothOn()
  {
    return ((AudioManager)MiniAppEnv.g().getContext().getSystemService("audio")).isBluetoothA2dpOn();
  }
  
  private boolean isHeadsetPlugged()
  {
    return ((AudioManager)MiniAppEnv.g().getContext().getSystemService("audio")).isWiredHeadsetOn();
  }
  
  /* Error */
  private boolean isMicAvailable()
  {
    // Byte code:
    //   0: iconst_1
    //   1: invokestatic 332	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4: astore_1
    //   5: new 374	android/media/AudioRecord
    //   8: dup
    //   9: iconst_1
    //   10: ldc_w 375
    //   13: bipush 16
    //   15: iconst_1
    //   16: ldc_w 375
    //   19: invokespecial 378	android/media/AudioRecord:<init>	(IIIII)V
    //   22: astore_2
    //   23: aload_2
    //   24: invokevirtual 382	android/media/AudioRecord:getRecordingState	()I
    //   27: iconst_1
    //   28: if_icmpeq +8 -> 36
    //   31: iconst_0
    //   32: invokestatic 332	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   35: astore_1
    //   36: aload_2
    //   37: invokevirtual 385	android/media/AudioRecord:startRecording	()V
    //   40: aload_2
    //   41: invokevirtual 382	android/media/AudioRecord:getRecordingState	()I
    //   44: iconst_3
    //   45: if_icmpeq +12 -> 57
    //   48: aload_2
    //   49: invokevirtual 388	android/media/AudioRecord:stop	()V
    //   52: iconst_0
    //   53: invokestatic 332	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   56: astore_1
    //   57: aload_2
    //   58: invokevirtual 388	android/media/AudioRecord:stop	()V
    //   61: aload_2
    //   62: invokevirtual 391	android/media/AudioRecord:release	()V
    //   65: aload_1
    //   66: invokevirtual 394	java/lang/Boolean:booleanValue	()Z
    //   69: ireturn
    //   70: astore_1
    //   71: goto +19 -> 90
    //   74: astore_1
    //   75: ldc 16
    //   77: ldc_w 396
    //   80: aload_1
    //   81: invokestatic 399	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   84: aload_2
    //   85: invokevirtual 391	android/media/AudioRecord:release	()V
    //   88: iconst_0
    //   89: ireturn
    //   90: aload_2
    //   91: invokevirtual 391	android/media/AudioRecord:release	()V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	VoIPManager
    //   4	62	1	localBoolean	Boolean
    //   70	1	1	localObject	Object
    //   74	21	1	localThrowable	java.lang.Throwable
    //   22	69	2	localAudioRecord	android.media.AudioRecord
    // Exception table:
    //   from	to	target	type
    //   23	36	70	finally
    //   36	40	70	finally
    //   40	57	70	finally
    //   57	61	70	finally
    //   75	84	70	finally
    //   23	36	74	java/lang/Throwable
    //   36	40	74	java/lang/Throwable
    //   40	57	74	java/lang/Throwable
    //   57	61	74	java/lang/Throwable
  }
  
  private void putUserModel(VoIPManager.UserModel paramUserModel)
  {
    Map localMap = this.mRoomUserModelList;
    if (localMap != null) {
      localMap.put(Long.valueOf(paramUserModel.mUin), paramUserModel);
    }
  }
  
  private void qavInitSDK(long paramLong)
  {
    QMLog.i("VoIPManager", "qavInitSDK");
    this.mVoIPProxy.init(paramLong, this.mVoIPListener);
  }
  
  private int qavOpMic(boolean paramBoolean)
  {
    int j = this.mQAvRoomState.get();
    int i = 2;
    if (j != 2)
    {
      QMLog.e("VoIPManager", "cant op mic currently");
      return -1;
    }
    j = this.mVoIPProxy.enableLocalAudio(paramBoolean);
    if (j == 0)
    {
      if (paramBoolean) {
        i = 1;
      }
      this.mSelfMicStat = i;
      Object localObject = getUserModel(this.mSelfUin);
      if (localObject != null) {
        ((VoIPManager.UserModel)localObject).mMicStat = this.mSelfMicStat;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OpMic ");
      ((StringBuilder)localObject).append(paramBoolean);
      QMLog.i("VoIPManager", ((StringBuilder)localObject).toString());
      return j;
    }
    QMLog.e("VoIPManager", "multiOperator null");
    return j;
  }
  
  private int qavOpMute(boolean paramBoolean)
  {
    int j = this.mQAvRoomState.get();
    int i = 2;
    if (j != 2)
    {
      QMLog.e("VoIPManager", "cant op mute currently");
      return -1;
    }
    j = this.mVoIPProxy.enableRemoteAudio(paramBoolean);
    if (j == 0)
    {
      if (paramBoolean) {
        i = 1;
      }
      this.mSelfMuteStat = i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OpMute ");
      localStringBuilder.append(paramBoolean);
      QMLog.i("VoIPManager", localStringBuilder.toString());
      return j;
    }
    QMLog.e("VoIPManager", "multiOperator null");
    return j;
  }
  
  private VoIPManager.UserModel removeUserModel(long paramLong)
  {
    Map localMap = this.mRoomUserModelList;
    if (localMap != null) {
      return (VoIPManager.UserModel)localMap.remove(Long.valueOf(paramLong));
    }
    return null;
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
    int i = 0;
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
        i = 1;
      }
    }
    if (i != 0)
    {
      paramList = this.mEventListener;
      if (paramList != null) {
        paramList.onRoomMemberChange(getRoomOpenIdList());
      }
    }
  }
  
  public void exitRoom()
  {
    try
    {
      int i = this.mQAvRoomState.get();
      if (i != 1)
      {
        if (i == 2)
        {
          doExitRoom();
          this.mQAvRoomState.set(0);
        }
      }
      else {
        this.needExitRoomImmediatelyAfterEntering = true;
      }
      return;
    }
    finally {}
  }
  
  public boolean isEarPhoneMute()
  {
    try
    {
      int i = this.mSelfMuteStat;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isInRoom()
  {
    return this.mQAvRoomState.get() == 2;
  }
  
  public boolean isMicMute()
  {
    try
    {
      int i = this.mSelfMicStat;
      boolean bool;
      if (i == 2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void joinRoom(VoIPManager.IdResult paramIdResult, VoIPManager.MuteConfig paramMuteConfig, byte[] paramArrayOfByte, VoIPManager.JoinRoomListener paramJoinRoomListener)
  {
    try
    {
      if (this.mQAvRoomState.get() != 0)
      {
        QMLog.e("VoIPManager", "不能重复进房");
        if (paramJoinRoomListener != null) {
          paramJoinRoomListener.onError(-3);
        }
        return;
      }
      exitRoom();
      if (!this.mQAvHasInitSDK) {
        if (isMicAvailable())
        {
          qavInitSDK(paramIdResult.tinyId);
          this.mQAvHasInitSDK = true;
        }
        else
        {
          if (paramJoinRoomListener != null) {
            paramJoinRoomListener.onError(-2);
          }
          return;
        }
      }
      this.mJoinRoomListener = paramJoinRoomListener;
      this.mSelfUin = paramIdResult.tinyId;
      int i = this.mVoIPProxy.joinRoom(paramIdResult.tinyId, paramIdResult.roomId, paramIdResult.openId, paramArrayOfByte);
      if (i == 0)
      {
        this.mMuteConfig = paramMuteConfig;
        this.mQAvRoomState.set(1);
        paramIdResult = new IntentFilter();
        paramIdResult.addAction("android.intent.action.HEADSET_PLUG");
        paramIdResult.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        paramIdResult.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        MiniAppEnv.g().getContext().registerReceiver(this.mReceiver, paramIdResult);
        this.mRoomUserModelList.clear();
      }
      else
      {
        paramIdResult = new StringBuilder();
        paramIdResult.append("joinRoom ret = ");
        paramIdResult.append(i);
        QMLog.e("VoIPManager", paramIdResult.toString());
        if (this.mJoinRoomListener != null)
        {
          this.mJoinRoomListener.onError(i);
          this.mJoinRoomListener = null;
        }
      }
      return;
    }
    finally {}
  }
  
  public void setEventListener(VoIPManager.EventListener paramEventListener)
  {
    this.mEventListener = paramEventListener;
  }
  
  public void updateMuteConfig(VoIPManager.MuteConfig paramMuteConfig, VoIPManager.MuteConfigListener paramMuteConfigListener)
  {
    for (;;)
    {
      try
      {
        if (!paramMuteConfig.isMuteMicrophone)
        {
          bool = true;
          int i = qavOpMic(bool);
          int j = qavOpMute(paramMuteConfig.isMuteEarphone);
          if ((i == 0) && (j == 0))
          {
            if (paramMuteConfigListener != null) {
              paramMuteConfigListener.onSuccess();
            }
          }
          else if (paramMuteConfigListener != null) {
            paramMuteConfigListener.onFail(-1);
          }
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.VoIPManager
 * JD-Core Version:    0.7.0.1
 */