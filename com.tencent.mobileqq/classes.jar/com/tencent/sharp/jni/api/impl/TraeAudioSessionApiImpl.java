package com.tencent.sharp.jni.api.impl;

import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.Notifier;
import com.tencent.sharp.jni.api.ITraeAudioSessionApi;
import com.tencent.sharp.jni.callback.ITraeAudioCallback;
import java.util.HashMap;

public class TraeAudioSessionApiImpl
  implements TraeAudioManager.Notifier, ITraeAudioSessionApi
{
  private static final String TAG = "TraeAudioSessionApiImpl";
  private static int s_nSessionIdAllocator;
  private ITraeAudioCallback mCallback;
  private TraeAudioSessionApiImpl.CallbackHandler mCallbackHandler;
  private long mSessionId;
  
  private void registerAudioSession(boolean paramBoolean)
  {
    TraeAudioManager.a().a(paramBoolean, this);
  }
  
  private static long requestSessionId()
  {
    long l = Process.myPid();
    int i = s_nSessionIdAllocator + 1;
    s_nSessionIdAllocator = i;
    return (l << 32) + i;
  }
  
  public int connectDevice(long paramLong, String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_SESSION_ID", Long.valueOf(this.mSessionId));
    localHashMap.put("KEY_OPERATION", "OPERATION_CONNECT_DEVICE");
    localHashMap.put("PARAM_DEVICE_NAME", paramString);
    return TraeAudioManager.a().a(32773, localHashMap);
  }
  
  public int connectHighestPriorityDevice()
  {
    HashMap localHashMap = new HashMap();
    return TraeAudioManager.a().a(32774, localHashMap);
  }
  
  public int getConnectedDevice(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_SESSION_ID", Long.valueOf(this.mSessionId));
    localHashMap.put("KEY_OPERATION", "OPERATION_GET_CONNECTED_DEVICE");
    return TraeAudioManager.a().a(32775, localHashMap);
  }
  
  public int getDeviceList()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_SESSION_ID", Long.valueOf(this.mSessionId));
    localHashMap.put("KEY_OPERATION", "OPERATION_GET_DEVICE_LIST");
    return TraeAudioManager.a().a(32771, localHashMap);
  }
  
  public int getStreamType()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_SESSION_ID", Long.valueOf(this.mSessionId));
    localHashMap.put("KEY_OPERATION", "OPERATION_GET_STREAM_TYPE");
    return TraeAudioManager.a().a(32772, localHashMap);
  }
  
  public void init(ITraeAudioCallback paramITraeAudioCallback)
  {
    this.mCallback = paramITraeAudioCallback;
    this.mSessionId = requestSessionId();
    this.mCallbackHandler = new TraeAudioSessionApiImpl.CallbackHandler(this, Looper.getMainLooper());
    registerAudioSession(true);
  }
  
  public void notify(int paramInt, HashMap<String, Object> paramHashMap)
  {
    TraeAudioSessionApiImpl.CallbackHandler localCallbackHandler = this.mCallbackHandler;
    if (localCallbackHandler != null) {
      localCallbackHandler.a(paramInt, paramHashMap);
    }
  }
  
  public void release()
  {
    registerAudioSession(false);
    this.mCallback = null;
  }
  
  public int startRing(long paramLong, int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean1, int paramInt3, String paramString2, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_RING_DATA_SOURCE", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_RING_RESOURCE_ID", Integer.valueOf(paramInt2));
    localHashMap.put("PARAM_RING_URI", paramUri);
    localHashMap.put("PARAM_RING_FILEPATH", paramString1);
    localHashMap.put("PARAM_RING_LOOP", Boolean.valueOf(paramBoolean1));
    localHashMap.put("PARAM_RING_LOOP_COUNT", Integer.valueOf(paramInt3));
    localHashMap.put("PARAM_RING_MODE", Boolean.valueOf(paramBoolean2));
    localHashMap.put("PARAM_RING_USERDATA_STRING", paramString2);
    return TraeAudioManager.a().a(32779, localHashMap);
  }
  
  public int startService(long paramLong, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_DEVICE_CONFIG", paramString1);
    localHashMap.put("PARAM_CONNECT_DEVICE_WHEN_START_SERVICE", paramString2);
    return TraeAudioManager.a().a(32769, localHashMap);
  }
  
  public int stopRing(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    return TraeAudioManager.a().a(32780, localHashMap);
  }
  
  public int stopService()
  {
    HashMap localHashMap = new HashMap();
    return TraeAudioManager.a().a(32770, localHashMap);
  }
  
  public int voiceCallAudioParamChanged(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_STREAM_TYPE", Integer.valueOf(paramInt));
    return TraeAudioManager.a().a(32778, localHashMap);
  }
  
  public int voiceCallPostProcess()
  {
    HashMap localHashMap = new HashMap();
    return TraeAudioManager.a().a(32777, localHashMap);
  }
  
  public int voiceCallPreProcess(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_SESSION_ID", Long.valueOf(this.mSessionId));
    localHashMap.put("KEY_OPERATION", "OPERATION_VOICE_CALL_PRE_PROCESS");
    localHashMap.put("PARAM_MODE_POLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAM_TYPE", Integer.valueOf(paramInt2));
    return TraeAudioManager.a().a(32776, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.sharp.jni.api.impl.TraeAudioSessionApiImpl
 * JD-Core Version:    0.7.0.1
 */