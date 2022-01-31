package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import bcnf;
import bcng;
import bcnh;
import bcnk;
import bcnp;
import bcns;
import bcnt;
import bcnv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.PushManager;
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
  private bcns mQavMultiObserver = new VoIPManager.3(this);
  private final BroadcastReceiver mReceiver = new VoIPManager.1(this);
  private Map<Long, VoIPManager.UserModel> mRoomUserModelList = new ConcurrentHashMap();
  private int mSelfMicStat = -1;
  private int mSelfMuteStat = -1;
  private long mSelfUin = -1L;
  
  private void doExitRoom()
  {
    QLog.i("VoIPManager", 1, "exitRoom!");
    bcnp localbcnp = bcnh.a().a();
    if (localbcnp != null) {
      localbcnp.a();
    }
    qavDeInitSDK();
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
  
  private boolean isHeadsetPlugged()
  {
    return ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).isWiredHeadsetOn();
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
        QLog.e("VoIPManager", 1, "validateMicAvailability", localThrowable);
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
  
  private void qavDeInitSDK()
  {
    QLog.i("VoIPManager", 1, "qavDeInitSDK");
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName());
    bcnh localbcnh = bcnh.a();
    localbcnh.b(this.mQavMultiObserver);
    localbcnh.a();
  }
  
  private void qavInitSDK(long paramLong)
  {
    QLog.i("VoIPManager", 1, "qavInitSDK");
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    ((PushManager)((AppRuntime)localObject).getManager(5)).registProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName(), "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c" });
    bcnt.a(new bcnv());
    bcnk localbcnk = bcnk.a();
    localbcnk.a((AppRuntime)localObject);
    localbcnk.a(new VoIPManager.2(this));
    localObject = bcnh.a();
    ((bcnh)localObject).a(BaseApplicationImpl.getApplication().getApplicationContext(), paramLong, localbcnk);
    ((bcnh)localObject).a(this.mQavMultiObserver);
  }
  
  private int qavOpMic(boolean paramBoolean)
  {
    if (!this.mQAvRealEnterRoom.get())
    {
      QLog.e("VoIPManager", 1, "cant op mic currently");
      return -1;
    }
    Object localObject = bcnh.a().a();
    if (localObject != null)
    {
      ((bcnp)localObject).a(paramBoolean);
      if (paramBoolean) {}
      for (int i = 1;; i = 2)
      {
        this.mSelfMicStat = i;
        localObject = getUserModel(this.mSelfUin);
        if (localObject != null) {
          ((VoIPManager.UserModel)localObject).mMicStat = this.mSelfMicStat;
        }
        QLog.i("VoIPManager", 1, "OpMic " + paramBoolean);
        return 0;
      }
    }
    QLog.e("VoIPManager", 1, "multiOperator null");
    return -2;
  }
  
  private int qavOpMute(boolean paramBoolean)
  {
    if (!this.mQAvRealEnterRoom.get())
    {
      QLog.e("VoIPManager", 1, "cant op mute currently");
      return -1;
    }
    bcnp localbcnp = bcnh.a().a();
    if (localbcnp != null)
    {
      boolean bool;
      if (!paramBoolean)
      {
        bool = true;
        localbcnp.b(bool);
        if (!paramBoolean) {
          break label92;
        }
      }
      label92:
      for (int i = 1;; i = 2)
      {
        this.mSelfMuteStat = i;
        QLog.i("VoIPManager", 1, "OpMute " + paramBoolean);
        return 0;
        bool = false;
        break;
      }
    }
    QLog.e("VoIPManager", 1, "multiOperator null");
    return -2;
  }
  
  private VoIPManager.UserModel removeUserModel(long paramLong)
  {
    VoIPManager.UserModel localUserModel = null;
    if (this.mRoomUserModelList != null) {
      localUserModel = (VoIPManager.UserModel)this.mRoomUserModelList.remove(Long.valueOf(paramLong));
    }
    return localUserModel;
  }
  
  private void switchAudioRoute(int paramInt)
  {
    QLog.d("VoIPManager", 1, "switchAudioRoute " + paramInt);
    bcnp localbcnp = bcnh.a().a();
    if (localbcnp != null)
    {
      if (paramInt != -1) {
        break label65;
      }
      if (!isHeadsetPlugged()) {
        break label57;
      }
      localbcnp.a(0);
    }
    label57:
    label65:
    do
    {
      return;
      localbcnp.a(1);
      return;
      if (paramInt == 1)
      {
        localbcnp.a(0);
        return;
      }
    } while (paramInt != 2);
    localbcnp.a(1);
  }
  
  private void updateUserModelList(List<bcng> paramList)
  {
    Object localObject1 = this.mRoomUserModelList.keySet();
    Object localObject2 = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((Set)localObject2).add(Long.valueOf(((bcng)localIterator.next()).jdField_a_of_type_Long));
    }
    ((Set)localObject1).retainAll((Collection)localObject2);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (bcng)paramList.next();
      if (getUserModel(((bcng)localObject1).jdField_a_of_type_Long) == null)
      {
        localObject2 = new VoIPManager.UserModel(this, null);
        ((VoIPManager.UserModel)localObject2).mUin = ((bcng)localObject1).jdField_a_of_type_Long;
        ((VoIPManager.UserModel)localObject2).mOpenId = ((bcng)localObject1).jdField_a_of_type_JavaLangString;
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
        BaseApplicationImpl.getContext().unregisterReceiver(this.mReceiver);
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
    //   5: getfield 59	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VoIPManager:mSelfMuteStat	I
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
    //   3: getfield 57	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VoIPManager:mSelfMicStat	I
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
      try
      {
        if (this.mQAvHasEnterRoom)
        {
          QLog.e("VoIPManager", 1, "不能重复进房");
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
          bcnp localbcnp = bcnh.a().a();
          if (localbcnp == null) {
            break label257;
          }
          bcnf localbcnf = new bcnf();
          localbcnf.jdField_a_of_type_Int = 11;
          localbcnf.b = 14;
          localbcnf.c = 1;
          localbcnf.d = paramIdResult.roomId;
          localbcnf.jdField_a_of_type_Long = paramIdResult.tinyId;
          localbcnf.jdField_a_of_type_JavaLangString = paramIdResult.openId;
          localbcnf.e = 1;
          localbcnf.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          int i = localbcnp.a(localbcnf);
          if (i != 0) {
            paramJoinRoomListener.onError(i);
          }
          this.mMuteConfig = paramMuteConfig;
          this.mQAvHasEnterRoom = true;
          paramIdResult = new IntentFilter();
          paramIdResult.addAction("android.intent.action.HEADSET_PLUG");
          BaseApplicationImpl.getContext().registerReceiver(this.mReceiver, paramIdResult);
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
      label257:
      QLog.e("VoIPManager", 1, "multiOperator null");
      if (this.mJoinRoomListener != null)
      {
        this.mJoinRoomListener.onError(-4);
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
    //   3: getfield 527	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VoIPManager$MuteConfig:isMuteMicrophone	Z
    //   6: ifne +46 -> 52
    //   9: iconst_1
    //   10: istore 5
    //   12: aload_0
    //   13: iload 5
    //   15: invokespecial 529	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VoIPManager:qavOpMic	(Z)I
    //   18: istore_3
    //   19: aload_0
    //   20: aload_1
    //   21: getfield 532	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VoIPManager$MuteConfig:isMuteEarphone	Z
    //   24: invokespecial 534	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VoIPManager:qavOpMute	(Z)I
    //   27: istore 4
    //   29: iload_3
    //   30: ifne +8 -> 38
    //   33: iload 4
    //   35: ifeq +23 -> 58
    //   38: aload_2
    //   39: ifnull +10 -> 49
    //   42: aload_2
    //   43: iconst_m1
    //   44: invokeinterface 539 2 0
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: iconst_0
    //   53: istore 5
    //   55: goto -43 -> 12
    //   58: aload_2
    //   59: ifnull -10 -> 49
    //   62: aload_2
    //   63: invokeinterface 542 1 0
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPManager
 * JD-Core Version:    0.7.0.1
 */