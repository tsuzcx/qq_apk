package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

@SuppressLint({"NewApi"})
public class TraeAudioManager
  extends BroadcastReceiver
{
  public static final String ACTION_TRAEAUDIOMANAGER_NOTIFY = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY";
  public static final String ACTION_TRAEAUDIOMANAGER_REQUEST = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST";
  public static final String ACTION_TRAEAUDIOMANAGER_RES = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES";
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP = 128;
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES = 256;
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER = 512;
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO = 16;
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_CARKIT = 64;
  static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_HEADSET = 32;
  static final int AUDIO_DEVICE_OUT_EARPIECE = 1;
  static final int AUDIO_DEVICE_OUT_SPEAKER = 2;
  static final int AUDIO_DEVICE_OUT_WIRED_HEADPHONE = 8;
  static final int AUDIO_DEVICE_OUT_WIRED_HEADSET = 4;
  public static final int AUDIO_MANAGER_ACTIVE_NONE = 0;
  public static final int AUDIO_MANAGER_ACTIVE_RING = 2;
  public static final int AUDIO_MANAGER_ACTIVE_VOICECALL = 1;
  static final String AUDIO_PARAMETER_STREAM_ROUTING = "routing";
  public static final String CONNECTDEVICE_DEVICENAME = "CONNECTDEVICE_DEVICENAME";
  public static final String CONNECTDEVICE_RESULT_DEVICENAME = "CONNECTDEVICE_RESULT_DEVICENAME";
  public static final String DEVICE_BLUETOOTHHEADSET = "DEVICE_BLUETOOTHHEADSET";
  public static final String DEVICE_EARPHONE = "DEVICE_EARPHONE";
  public static final String DEVICE_NONE = "DEVICE_NONE";
  public static final String DEVICE_SPEAKERPHONE = "DEVICE_SPEAKERPHONE";
  public static final int DEVICE_STATUS_CONNECTED = 2;
  public static final int DEVICE_STATUS_CONNECTING = 1;
  public static final int DEVICE_STATUS_DISCONNECTED = 0;
  public static final int DEVICE_STATUS_DISCONNECTING = 3;
  public static final int DEVICE_STATUS_ERROR = -1;
  public static final int DEVICE_STATUS_UNCHANGEABLE = 4;
  public static final String DEVICE_WIREDHEADSET = "DEVICE_WIREDHEADSET";
  public static final int EARACTION_AWAY = 0;
  public static final int EARACTION_CLOSE = 1;
  public static final String EXTRA_DATA_AVAILABLEDEVICE_LIST = "EXTRA_DATA_AVAILABLEDEVICE_LIST";
  public static final String EXTRA_DATA_CONNECTEDDEVICE = "EXTRA_DATA_CONNECTEDDEVICE";
  public static final String EXTRA_DATA_DEVICECONFIG = "EXTRA_DATA_DEVICECONFIG";
  public static final String EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME = "EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME";
  public static final String EXTRA_DATA_PREV_CONNECTEDDEVICE = "EXTRA_DATA_PREV_CONNECTEDDEVICE";
  public static final String EXTRA_DATA_ROUTESWITCHEND_DEV = "EXTRA_DATA_ROUTESWITCHEND_DEV";
  public static final String EXTRA_DATA_ROUTESWITCHEND_TIME = "EXTRA_DATA_ROUTESWITCHEND_TIME";
  public static final String EXTRA_DATA_ROUTESWITCHSTART_FROM = "EXTRA_DATA_ROUTESWITCHSTART_FROM";
  public static final String EXTRA_DATA_ROUTESWITCHSTART_TO = "EXTRA_DATA_ROUTESWITCHSTART_TO";
  public static final String EXTRA_DATA_STREAMTYPE = "EXTRA_DATA_STREAMTYPE";
  public static final String EXTRA_EARACTION = "EXTRA_EARACTION";
  public static final int FORCE_ANALOG_DOCK = 8;
  public static final int FORCE_BT_A2DP = 4;
  public static final int FORCE_BT_CAR_DOCK = 6;
  public static final int FORCE_BT_DESK_DOCK = 7;
  public static final int FORCE_BT_SCO = 3;
  public static final int FORCE_DEFAULT = 0;
  public static final int FORCE_DIGITAL_DOCK = 9;
  public static final int FORCE_HEADPHONES = 2;
  public static final int FORCE_NONE = 0;
  public static final int FORCE_NO_BT_A2DP = 10;
  public static final int FORCE_SPEAKER = 1;
  public static final int FORCE_WIRED_ACCESSORY = 5;
  public static final int FOR_COMMUNICATION = 0;
  public static final int FOR_DOCK = 3;
  public static final int FOR_MEDIA = 1;
  public static final int FOR_RECORD = 2;
  public static final String GETCONNECTEDDEVICE_RESULT_LIST = "GETCONNECTEDDEVICE_REULT_LIST";
  public static final String GETCONNECTINGDEVICE_RESULT_LIST = "GETCONNECTINGDEVICE_REULT_LIST";
  public static final String ISDEVICECHANGABLED_RESULT_ISCHANGABLED = "ISDEVICECHANGABLED_REULT_ISCHANGABLED";
  public static boolean IsEarPhoneSupported = false;
  public static boolean IsMusicScene = false;
  public static boolean IsUpdateSceneFlag = false;
  public static final int MODE_MUSIC_PLAYBACK = 2;
  public static final int MODE_MUSIC_PLAY_RECORD = 1;
  public static final int MODE_MUSIC_PLAY_RECORD_HIGH_QUALITY = 3;
  public static final int MODE_MUSIC_PLAY_RECORD_LOW_QUALITY = 5;
  public static final int MODE_VOICE_CHAT = 0;
  public static final int MODE_VOICE_PLAYBACK = 4;
  public static final String MUSIC_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_WIREDHEADSET;DEVICE_BLUETOOTHHEADSET;";
  public static final String NOTIFY_DEVICECHANGABLE_UPDATE = "NOTIFY_DEVICECHANGABLE_UPDATE";
  public static final String NOTIFY_DEVICECHANGABLE_UPDATE_DATE = "NOTIFY_DEVICECHANGABLE_UPDATE_DATE";
  public static final String NOTIFY_DEVICELIST_UPDATE = "NOTIFY_DEVICELISTUPDATE";
  public static final String NOTIFY_RING_COMPLETION = "NOTIFY_RING_COMPLETION";
  public static final String NOTIFY_ROUTESWITCHEND = "NOTIFY_ROUTESWITCHEND";
  public static final String NOTIFY_ROUTESWITCHSTART = "NOTIFY_ROUTESWITCHSTART";
  public static final String NOTIFY_SERVICE_STATE = "NOTIFY_SERVICE_STATE";
  public static final String NOTIFY_SERVICE_STATE_DATE = "NOTIFY_SERVICE_STATE_DATE";
  public static final String NOTIFY_STREAMTYPE_UPDATE = "NOTIFY_STREAMTYPE_UPDATE";
  private static final int NUM_FORCE_CONFIG = 11;
  private static final int NUM_FORCE_USE = 4;
  public static final String OPERATION_CONNECTDEVICE = "OPERATION_CONNECTDEVICE";
  public static final String OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE = "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE";
  public static final String OPERATION_EARACTION = "OPERATION_EARACTION";
  public static final String OPERATION_GETCONNECTEDDEVICE = "OPERATION_GETCONNECTEDDEVICE";
  public static final String OPERATION_GETCONNECTINGDEVICE = "OPERATION_GETCONNECTINGDEVICE";
  public static final String OPERATION_GETDEVICELIST = "OPERATION_GETDEVICELIST";
  public static final String OPERATION_GETSTREAMTYPE = "OPERATION_GETSTREAMTYPE";
  public static final String OPERATION_ISDEVICECHANGABLED = "OPERATION_ISDEVICECHANGABLED";
  public static final String OPERATION_RECOVER_AUDIO_FOCUS = "OPERATION_RECOVER_AUDIO_FOCUS";
  public static final String OPERATION_REGISTERAUDIOSESSION = "OPERATION_REGISTERAUDIOSESSION";
  public static final String OPERATION_REQUEST_RELEASE_AUDIO_FOCUS = "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS";
  public static final String OPERATION_STARTRING = "OPERATION_STARTRING";
  public static final String OPERATION_STARTSERVICE = "OPERATION_STARTSERVICE";
  public static final String OPERATION_STOPRING = "OPERATION_STOPRING";
  public static final String OPERATION_STOPSERVICE = "OPERATION_STOPSERVICE";
  public static final String OPERATION_VOICECALL_AUDIOPARAM_CHANGED = "OPERATION_VOICECALL_AUDIOPARAM_CHANGED";
  public static final String OPERATION_VOICECALL_POSTPROCESS = "OPERATION_VOICECALL_POSTROCESS";
  public static final String OPERATION_VOICECALL_PREPROCESS = "OPERATION_VOICECALL_PREPROCESS";
  public static final String PARAM_DEVICE = "PARAM_DEVICE";
  public static final String PARAM_ERROR = "PARAM_ERROR";
  public static final String PARAM_ISHOSTSIDE = "PARAM_ISHOSTSIDE";
  public static final String PARAM_MODEPOLICY = "PARAM_MODEPOLICY";
  public static final String PARAM_OPERATION = "PARAM_OPERATION";
  public static final String PARAM_RES_ERRCODE = "PARAM_RES_ERRCODE";
  public static final String PARAM_RING_DATASOURCE = "PARAM_RING_DATASOURCE";
  public static final String PARAM_RING_FILEPATH = "PARAM_RING_FILEPATH";
  public static final String PARAM_RING_LOOP = "PARAM_RING_LOOP";
  public static final String PARAM_RING_LOOPCOUNT = "PARAM_RING_LOOPCOUNT";
  public static final String PARAM_RING_MODE = "PARAM_RING_MODE";
  public static final String PARAM_RING_RSID = "PARAM_RING_RSID";
  public static final String PARAM_RING_URI = "PARAM_RING_URI";
  public static final String PARAM_RING_USERDATA_STRING = "PARAM_RING_USERDATA_STRING";
  public static final String PARAM_SESSIONID = "PARAM_SESSIONID";
  public static final String PARAM_STATUS = "PARAM_STATUS";
  public static final String PARAM_STREAMTYPE = "PARAM_STREAMTYPE";
  public static final String REGISTERAUDIOSESSION_ISREGISTER = "REGISTERAUDIOSESSION_ISREGISTER";
  public static final int RES_ERRCODE_DEVICE_BTCONNCECTED_TIMEOUT = 10;
  public static final int RES_ERRCODE_DEVICE_NOT_VISIABLE = 8;
  public static final int RES_ERRCODE_DEVICE_UNCHANGEABLE = 9;
  public static final int RES_ERRCODE_DEVICE_UNKOWN = 7;
  public static final int RES_ERRCODE_NONE = 0;
  public static final int RES_ERRCODE_RING_NOT_EXIST = 5;
  public static final int RES_ERRCODE_SERVICE_OFF = 1;
  public static final int RES_ERRCODE_STOPRING_INTERRUPT = 4;
  public static final int RES_ERRCODE_VOICECALLPOST_INTERRUPT = 6;
  public static final int RES_ERRCODE_VOICECALL_EXIST = 2;
  public static final int RES_ERRCODE_VOICECALL_NOT_EXIST = 3;
  private static final String TAG = "TraeAudioManager";
  public static final String VIDEO_CONFIG = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  public static final String VOICECALL_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  static int _gHostProcessId = -1;
  static TraeAudioManager _ginstance;
  static ReentrantLock _glock = new ReentrantLock();
  public static boolean enableDeviceSwitchFlag = true;
  static final String[] forceName = { "FORCE_NONE", "FORCE_SPEAKER", "FORCE_HEADPHONES", "FORCE_BT_SCO", "FORCE_BT_A2DP", "FORCE_WIRED_ACCESSORY", "FORCE_BT_CAR_DOCK", "FORCE_BT_DESK_DOCK", "FORCE_ANALOG_DOCK", "FORCE_NO_BT_A2DP", "FORCE_DIGITAL_DOCK" };
  boolean IsBluetoothA2dpExisted = true;
  boolean IsServiceReadytoStop = false;
  int _activeMode = 0;
  AudioManager _am = null;
  TraeAudioSessionHost _audioSessionHost = new TraeAudioSessionHost();
  TraeAudioManager.BluetoohHeadsetCheckInterface _bluetoothCheck = null;
  final boolean[] _bluetooth_sco_connect = { false };
  Context _context = null;
  TraeAudioManager.DeviceConfigManager _deviceConfigManager = new TraeAudioManager.DeviceConfigManager(this);
  ReentrantLock _gSwitchTreadlock = new ReentrantLock();
  ReentrantLock _lock = new ReentrantLock();
  int _modePolicy = -1;
  int _prevMode = 0;
  int _streamType = 0;
  TraeAudioManager.switchThread _switchThread = null;
  private int bluetoothState = 4;
  TraeAudioManager.TraeAudioManagerLooper mTraeAudioManagerLooper = null;
  String sessionConnectedDev = "DEVICE_NONE";
  
  static
  {
    _ginstance = null;
  }
  
  TraeAudioManager(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" context:");
    localStringBuilder.append(paramContext);
    AudioDeviceInterface.LogTraceEntry(localStringBuilder.toString());
    if (paramContext == null) {
      return;
    }
    this._context = paramContext;
    this.mTraeAudioManagerLooper = new TraeAudioManager.TraeAudioManagerLooper(this, this);
    paramContext = this.mTraeAudioManagerLooper;
    AudioDeviceInterface.LogTraceExit();
  }
  
  static boolean IsEabiLowVersion()
  {
    String str2 = Build.CPU_ABI;
    if (Build.VERSION.SDK_INT >= 8) {}
    try
    {
      str1 = (String)Build.class.getDeclaredField("CPU_ABI2").get(null);
    }
    catch (Exception localException)
    {
      String str1;
      label32:
      StringBuilder localStringBuilder;
      break label32;
    }
    return IsEabiLowVersionByAbi(str2);
    str1 = "unknown";
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("IsEabiVersion CPU_ABI:");
      localStringBuilder.append(str2);
      localStringBuilder.append(" CPU_ABI2:");
      localStringBuilder.append(str1);
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    }
    return (IsEabiLowVersionByAbi(str2)) && (IsEabiLowVersionByAbi(str1));
  }
  
  public static boolean IsEabiLowVersionByAbi(String paramString)
  {
    if (paramString == null) {
      return true;
    }
    if (paramString.contains("x86")) {
      return false;
    }
    if (paramString.contains("mips")) {
      return false;
    }
    if (paramString.equalsIgnoreCase("armeabi")) {
      return true;
    }
    if (paramString.equalsIgnoreCase("armeabi-v7a")) {
      return false;
    }
    return !paramString.equalsIgnoreCase("arm64-v8a");
  }
  
  public static int SetSpeakerForTest(Context paramContext, boolean paramBoolean)
  {
    _glock.lock();
    TraeAudioManager localTraeAudioManager = _ginstance;
    int i;
    if (localTraeAudioManager != null)
    {
      i = localTraeAudioManager.InternalSetSpeaker(paramContext, paramBoolean);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "TraeAudioManager|static SetSpeakerForTest|null == _ginstance");
      }
      i = -1;
    }
    _glock.unlock();
    return i;
  }
  
  public static boolean checkDevName(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return ("DEVICE_SPEAKERPHONE".equals(paramString)) || ("DEVICE_EARPHONE".equals(paramString)) || ("DEVICE_WIREDHEADSET".equals(paramString)) || ("DEVICE_BLUETOOTHHEADSET".equals(paramString));
  }
  
  static int connectDevice(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    if (paramString2 == null) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("CONNECTDEVICE_DEVICENAME", paramString2);
    localHashMap.put("PARAM_DEVICE", paramString2);
    return sendMessage(32775, localHashMap);
  }
  
  static int connectHighestPriorityDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32789, localHashMap);
  }
  
  static int disableDeviceSwitch()
  {
    enableDeviceSwitchFlag = false;
    return 0;
  }
  
  static int earAction(String paramString, long paramLong, boolean paramBoolean, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_EARACTION", Integer.valueOf(paramInt));
    return sendMessage(32776, localHashMap);
  }
  
  static void forceVolumeControlStream(AudioManager paramAudioManager, int paramInt)
  {
    if (Build.MANUFACTURER.equals("Google"))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "forceVolumeControlStream, Google phone nothing to do");
      }
      return;
    }
    Object localObject = new Object[1];
    localObject[0] = Integer.valueOf(paramInt);
    Class[] arrayOfClass = new Class[localObject.length];
    arrayOfClass[0] = Integer.TYPE;
    paramAudioManager = invokeMethod(paramAudioManager, "forceVolumeControlStream", (Object[])localObject, arrayOfClass);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("forceVolumeControlStream  streamType:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" res:");
      ((StringBuilder)localObject).append(paramAudioManager);
      QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  static int getAudioSource(int paramInt)
  {
    boolean bool = IsMusicScene;
    int i = 0;
    if (bool) {
      return 0;
    }
    StringBuilder localStringBuilder;
    if (IsEabiLowVersion())
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Config] armeabi low Version, getAudioSource _audioSourcePolicy:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" source:");
        localStringBuilder.append(0);
        QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
      }
      return 0;
    }
    int j = Build.VERSION.SDK_INT;
    if (paramInt >= 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Config] getAudioSource _audioSourcePolicy:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" source:");
        localStringBuilder.append(paramInt);
        QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
      }
      return paramInt;
    }
    if (j >= 11) {
      i = 7;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Config] getAudioSource _audioSourcePolicy:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" source:");
      localStringBuilder.append(i);
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  static int getAudioStreamType(int paramInt)
  {
    if (IsMusicScene) {
      return 3;
    }
    StringBuilder localStringBuilder;
    if (IsEabiLowVersion())
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Config] armeabi low Version, getAudioStreamType audioStreamTypePolicy:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" streamType:");
        localStringBuilder.append(3);
        QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
      }
      return 3;
    }
    int i = Build.VERSION.SDK_INT;
    if (paramInt >= 0) {
      i = paramInt;
    } else if (i >= 9) {
      i = 0;
    } else {
      i = 3;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Config] getAudioStreamType audioStreamTypePolicy:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" streamType:");
      localStringBuilder.append(i);
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  static int getCallAudioMode(int paramInt)
  {
    boolean bool = IsMusicScene;
    int i = 0;
    if (bool) {
      return 0;
    }
    StringBuilder localStringBuilder;
    if (IsEabiLowVersion())
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Config] armeabi low Version, getCallAudioMode modePolicy:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" mode:");
        localStringBuilder.append(0);
        QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
      }
      return 0;
    }
    int j = Build.VERSION.SDK_INT;
    if (paramInt >= 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Config] getCallAudioMode modePolicy:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" mode:");
        localStringBuilder.append(paramInt);
        QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
      }
      return paramInt;
    }
    if (j >= 11) {
      i = 3;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Config] getCallAudioMode _modePolicy:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" mode:");
      localStringBuilder.append(i);
      localStringBuilder.append("facturer:");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append(" model:");
      localStringBuilder.append(Build.MODEL);
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  static int getConnectedDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32778, localHashMap);
  }
  
  static int getConnectingDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32779, localHashMap);
  }
  
  static int getDeviceList(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32774, localHashMap);
  }
  
  static String getForceConfigName(int paramInt)
  {
    if (paramInt >= 0)
    {
      String[] arrayOfString = forceName;
      if (paramInt < arrayOfString.length) {
        return arrayOfString[paramInt];
      }
    }
    return "unknow";
  }
  
  static int getForceUse(int paramInt)
  {
    Integer localInteger = Integer.valueOf(0);
    Object localObject = new Object[1];
    localObject[0] = Integer.valueOf(paramInt);
    Class[] arrayOfClass = new Class[localObject.length];
    arrayOfClass[0] = Integer.TYPE;
    localObject = invokeStaticMethod("android.media.AudioSystem", "getForceUse", (Object[])localObject, arrayOfClass);
    if (localObject != null) {
      localInteger = (Integer)localObject;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getForceUse  usage:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" config:");
      ((StringBuilder)localObject).append(localInteger);
      ((StringBuilder)localObject).append(" ->");
      ((StringBuilder)localObject).append(getForceConfigName(localInteger.intValue()));
      QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
    }
    return localInteger.intValue();
  }
  
  static int getStreamType(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32784, localHashMap);
  }
  
  public static int init(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TraeAudioManager init _ginstance:");
    localStringBuilder.append(_ginstance);
    QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(" _ginstance:");
    localStringBuilder.append(_ginstance);
    AudioDeviceInterface.LogTraceEntry(localStringBuilder.toString());
    _glock.lock();
    if (_ginstance == null) {
      _ginstance = new TraeAudioManager(paramContext);
    }
    _glock.unlock();
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    try
    {
      paramObject = paramObject.getClass().getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("invokeMethod Exception:");
        paramString.append(paramObject.getMessage());
        QLog.w("TraeAudioManager", 2, paramString.toString());
      }
    }
    return null;
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    try
    {
      paramArrayOfObject = Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass).invoke(null, paramArrayOfObject);
      return paramArrayOfObject;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("invokeStaticMethod Exception:");
        paramString2.append(paramString1.getMessage());
        QLog.w("TraeAudioManager", 2, paramString2.toString());
        return null;
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("InvocationTarget:");
          paramString1.append(paramString2);
          QLog.w("TraeAudioManager", 2, paramString1.toString());
          return null;
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("IllegalAccess:");
            paramString1.append(paramString2);
            QLog.w("TraeAudioManager", 2, paramString1.toString());
            return null;
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder();
              paramString1.append("IllegalArgument:");
              paramString1.append(paramString2);
              QLog.w("TraeAudioManager", 2, paramString1.toString());
              return null;
              if (QLog.isColorLevel())
              {
                paramString1 = new StringBuilder();
                paramString1.append("NoSuchMethod:");
                paramString1.append(paramString2);
                QLog.w("TraeAudioManager", 2, paramString1.toString());
                return null;
                if (QLog.isColorLevel())
                {
                  paramString2 = new StringBuilder();
                  paramString2.append("ClassNotFound:");
                  paramString2.append(paramString1);
                  QLog.w("TraeAudioManager", 2, paramString2.toString());
                }
              }
            }
          }
        }
      }
      return null;
    }
    catch (ClassNotFoundException paramString2)
    {
      break label221;
    }
    catch (NoSuchMethodException paramString1)
    {
      break label181;
    }
    catch (IllegalArgumentException paramString1)
    {
      break label141;
    }
    catch (IllegalAccessException paramString1)
    {
      label141:
      label181:
      label221:
      break label101;
    }
    catch (InvocationTargetException paramString1)
    {
      label61:
      label101:
      break label61;
    }
  }
  
  static boolean isCloseSystemAPM(int paramInt)
  {
    if (paramInt != -1) {
      return false;
    }
    if (Build.MANUFACTURER.equals("Xiaomi"))
    {
      if (Build.MODEL.equals("MI 2")) {
        return true;
      }
      if (Build.MODEL.equals("MI 2A")) {
        return true;
      }
      if (Build.MODEL.equals("MI 2S")) {
        return true;
      }
      if (Build.MODEL.equals("MI 2SC")) {
        return true;
      }
    }
    else if ((Build.MANUFACTURER.equals("samsung")) && (Build.MODEL.equals("SCH-I959")))
    {
      return true;
    }
    return false;
  }
  
  static int isDeviceChangabled(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32777, localHashMap);
  }
  
  public static boolean isHandfree(String paramString)
  {
    if (!checkDevName(paramString)) {
      return false;
    }
    return "DEVICE_SPEAKERPHONE".equals(paramString);
  }
  
  static int recoverAudioFocus(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32791, localHashMap);
  }
  
  public static int registerAudioSession(TraeAudioSession paramTraeAudioSession, boolean paramBoolean, long paramLong, Context paramContext)
  {
    _glock.lock();
    Object localObject = _ginstance;
    int i;
    if (localObject != null)
    {
      if (paramBoolean)
      {
        localObject = ((TraeAudioManager)localObject)._audioSessionHost;
        if (localObject != null)
        {
          ((TraeAudioSessionHost)localObject).add(paramTraeAudioSession, paramLong, paramContext);
          if (QLog.isColorLevel())
          {
            paramTraeAudioSession = new StringBuilder();
            paramTraeAudioSession.append("[register] add AudioSession: ");
            paramTraeAudioSession.append(paramLong);
            QLog.d("TraeAudioManager", 2, paramTraeAudioSession.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("TraeAudioManager", 2, "_ginstance._audioSessionHost is null");
        }
      }
      else
      {
        paramTraeAudioSession = ((TraeAudioManager)localObject)._audioSessionHost;
        if (paramTraeAudioSession != null)
        {
          paramTraeAudioSession.remove(paramLong);
          if (QLog.isColorLevel())
          {
            paramTraeAudioSession = new StringBuilder();
            paramTraeAudioSession.append("[register] remove AudioSession: ");
            paramTraeAudioSession.append(paramLong);
            QLog.d("TraeAudioManager", 2, paramTraeAudioSession.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("TraeAudioManager", 2, "_ginstance._audioSessionHost is null");
        }
      }
      i = 0;
    }
    else
    {
      i = -1;
    }
    _glock.unlock();
    return i;
  }
  
  static int requestReleaseAudioFocus(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32790, localHashMap);
  }
  
  public static int sendMessage(int paramInt, HashMap<String, Object> paramHashMap)
  {
    _glock.lock();
    TraeAudioManager localTraeAudioManager = _ginstance;
    if (localTraeAudioManager != null) {
      paramInt = localTraeAudioManager.internalSendMessage(paramInt, paramHashMap);
    } else {
      paramInt = -1;
    }
    _glock.unlock();
    return paramInt;
  }
  
  static void setForceUse(int paramInt1, int paramInt2)
  {
    Object localObject1 = new Object[2];
    localObject1[0] = Integer.valueOf(paramInt1);
    localObject1[1] = Integer.valueOf(paramInt2);
    Object localObject2 = new Class[localObject1.length];
    localObject2[0] = Integer.TYPE;
    localObject2[1] = Integer.TYPE;
    localObject1 = invokeStaticMethod("android.media.AudioSystem", "setForceUse", (Object[])localObject1, (Class[])localObject2);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setForceUse  usage:");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" config:");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" ->");
      ((StringBuilder)localObject2).append(getForceConfigName(paramInt2));
      ((StringBuilder)localObject2).append(" res:");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  static void setParameters(String paramString)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramString;
    Class[] arrayOfClass = new Class[arrayOfObject.length];
    arrayOfClass[0] = String.class;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setParameters  :");
      localStringBuilder.append(paramString);
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    }
    invokeStaticMethod("android.media.AudioSystem", "setParameters", arrayOfObject, arrayOfClass);
  }
  
  static void setPhoneState(int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    Class[] arrayOfClass = new Class[arrayOfObject.length];
    arrayOfClass[0] = Integer.TYPE;
    invokeStaticMethod("android.media.AudioSystem", "setPhoneState", arrayOfObject, arrayOfClass);
  }
  
  static int startRing(String paramString1, long paramLong, boolean paramBoolean1, int paramInt1, int paramInt2, Uri paramUri, String paramString2, boolean paramBoolean2, int paramInt3, String paramString3, boolean paramBoolean3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean1));
    localHashMap.put("PARAM_RING_DATASOURCE", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_RING_RSID", Integer.valueOf(paramInt2));
    localHashMap.put("PARAM_RING_URI", paramUri);
    localHashMap.put("PARAM_RING_FILEPATH", paramString2);
    localHashMap.put("PARAM_RING_LOOP", Boolean.valueOf(paramBoolean2));
    localHashMap.put("PARAM_RING_LOOPCOUNT", Integer.valueOf(paramInt3));
    localHashMap.put("PARAM_RING_MODE", Boolean.valueOf(paramBoolean3));
    localHashMap.put("PARAM_RING_USERDATA_STRING", paramString3);
    return sendMessage(32782, localHashMap);
  }
  
  static int startService(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    if (paramString2.length() <= 0) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_DATA_DEVICECONFIG", paramString2);
    return sendMessage(32772, localHashMap);
  }
  
  static int stopRing(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32783, localHashMap);
  }
  
  static int stopService(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32773, localHashMap);
  }
  
  public static void uninit()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TraeAudioManager uninit _ginstance:");
    ((StringBuilder)localObject).append(_ginstance);
    QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" _ginstance:");
    ((StringBuilder)localObject).append(_ginstance);
    AudioDeviceInterface.LogTraceEntry(((StringBuilder)localObject).toString());
    _glock.lock();
    localObject = _ginstance;
    if (localObject != null)
    {
      ((TraeAudioManager)localObject).release();
      _ginstance = null;
    }
    _glock.unlock();
    AudioDeviceInterface.LogTraceExit();
  }
  
  static int voiceCallAudioParamChanged(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    return sendMessage(32788, localHashMap);
  }
  
  static int voicecallPostprocess(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32781, localHashMap);
  }
  
  static int voicecallPreprocess(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    return sendMessage(32780, localHashMap);
  }
  
  public TraeAudioManager.BluetoohHeadsetCheckInterface CreateBluetoothCheck(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 11) {
      localObject1 = new TraeAudioManager.BluetoohHeadsetCheck(this);
    } else if (Build.VERSION.SDK_INT != 18) {
      localObject1 = new TraeAudioManager.BluetoohHeadsetCheckFor2x(this);
    } else {
      localObject1 = new TraeAudioManager.BluetoohHeadsetCheckFake(this);
    }
    Object localObject2 = localObject1;
    if (!((TraeAudioManager.BluetoohHeadsetCheckInterface)localObject1).init(paramContext, paramDeviceConfigManager)) {
      localObject2 = new TraeAudioManager.BluetoohHeadsetCheckFake(this);
    }
    if (QLog.isColorLevel())
    {
      paramDeviceConfigManager = new StringBuilder();
      paramDeviceConfigManager.append("CreateBluetoothCheck:");
      paramDeviceConfigManager.append(((TraeAudioManager.BluetoohHeadsetCheckInterface)localObject2).interfaceDesc());
      paramDeviceConfigManager.append(" skip android4.3:");
      if (Build.VERSION.SDK_INT == 18) {
        paramContext = "Y";
      } else {
        paramContext = "N";
      }
      paramDeviceConfigManager.append(paramContext);
      QLog.w("TraeAudioManager", 2, paramDeviceConfigManager.toString());
    }
    return localObject2;
  }
  
  int InternalConnectDevice(String paramString, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" devName:");
    localStringBuilder.append(paramString);
    AudioDeviceInterface.LogTraceEntry(localStringBuilder.toString());
    if (paramString == null) {
      return -1;
    }
    if ((!paramBoolean) && (!"DEVICE_BLUETOOTHHEADSET".equals(paramString)) && (!this._deviceConfigManager.getConnectedDevice().equals("DEVICE_NONE")) && (paramString.equals(this._deviceConfigManager.getConnectedDevice()))) {
      return 0;
    }
    if ((checkDevName(paramString) == true) && (this._deviceConfigManager.getVisible(paramString) == true))
    {
      if (InternalIsDeviceChangeable() != true)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " InternalIsDeviceChangeable fail");
        }
        return -1;
      }
      if (this.IsServiceReadytoStop)
      {
        QLog.e("TraeAudioManager", 2, " InternalConnectDevice fail,ready to stopService");
        return -1;
      }
      this._gSwitchTreadlock.lock();
      if (!this.IsServiceReadytoStop)
      {
        this._deviceConfigManager.setConnecting(paramString);
        if (this._switchThread != null)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("_switchThread:");
          localStringBuilder.append(this._switchThread.getDeviceName());
          QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
          this._switchThread.quit();
          this._switchThread = null;
        }
        if (paramString.equals("DEVICE_EARPHONE")) {
          this._switchThread = new TraeAudioManager.earphoneSwitchThread(this);
        } else if (paramString.equals("DEVICE_SPEAKERPHONE")) {
          this._switchThread = new TraeAudioManager.speakerSwitchThread(this);
        } else if (paramString.equals("DEVICE_WIREDHEADSET")) {
          this._switchThread = new TraeAudioManager.headsetSwitchThread(this);
        } else if (paramString.equals("DEVICE_BLUETOOTHHEADSET")) {
          this._switchThread = new TraeAudioManager.bluetoothHeadsetSwitchThread(this);
        }
        paramString = this._switchThread;
        if (paramString != null)
        {
          paramString.setDeviceConnectParam(paramHashMap);
          this._switchThread.start();
        }
      }
      this._gSwitchTreadlock.unlock();
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TraeAudioManager", 2, " checkDevName fail");
    }
    return -1;
  }
  
  boolean InternalIsDeviceChangeable()
  {
    String str = this._deviceConfigManager.getConnectingDevice();
    return (str == null) || (str.equals("DEVICE_NONE")) || (str.equals(""));
  }
  
  int InternalNotifyDeviceChangableUpdate()
  {
    if (this._context == null) {
      return -1;
    }
    boolean bool = InternalIsDeviceChangeable();
    new Handler(Looper.getMainLooper()).post(new TraeAudioManager.3(this, bool));
    return 0;
  }
  
  int InternalNotifyDeviceListUpdate()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this._context == null) {
      return -1;
    }
    Object localObject = this._deviceConfigManager.getSnapParams();
    ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
    String str1 = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
    localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
    String str2 = this._deviceConfigManager.getBluetoothName();
    new Handler(Looper.getMainLooper()).post(new TraeAudioManager.2(this, localArrayList, str1, (String)localObject, str2));
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  int InternalSessionConnectDevice(HashMap<String, Object> paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (paramHashMap != null)
    {
      if (this._context == null) {
        return -1;
      }
      if (IsMusicScene)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "MusicScene: InternalSessionConnectDevice failed");
        }
        return -1;
      }
      String str = (String)paramHashMap.get("PARAM_DEVICE");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ConnectDevice: ");
      ((StringBuilder)localObject).append(str);
      Log.w("TraeAudioManager", ((StringBuilder)localObject).toString());
      if ((!IsEarPhoneSupported) && (str.equals("DEVICE_EARPHONE")))
      {
        if (QLog.isColorLevel())
        {
          paramHashMap = new StringBuilder();
          paramHashMap.append("InternalSessionConnectDevice IsEarPhoneSupported = false, Connect device:");
          paramHashMap.append(str);
          paramHashMap.append(" failed");
          QLog.e("TraeAudioManager", 2, paramHashMap.toString());
        }
        return -1;
      }
      boolean bool = InternalIsDeviceChangeable();
      int i;
      if (checkDevName(str) != true) {
        i = 7;
      } else if (!this._deviceConfigManager.getVisible(str)) {
        i = 8;
      } else if (!bool) {
        i = 9;
      } else {
        i = 0;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sessonID:");
        localStringBuilder.append((Long)paramHashMap.get("PARAM_SESSIONID"));
        localStringBuilder.append(" devName:");
        localStringBuilder.append(str);
        localStringBuilder.append(" bChangabled:");
        if (bool) {
          localObject = "Y";
        } else {
          localObject = "N";
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" err:");
        localStringBuilder.append(i);
        QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
      }
      if (i != 0)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
        sendResBroadcast((Intent)localObject, paramHashMap, i);
        return -1;
      }
      if (str.equals(this._deviceConfigManager.getConnectedDevice()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " --has connected!");
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
        sendResBroadcast((Intent)localObject, paramHashMap, i);
        return 0;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, " --connecting...");
      }
      InternalConnectDevice(str, paramHashMap, false);
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
    return -1;
  }
  
  int InternalSessionEarAction(HashMap<String, Object> paramHashMap)
  {
    return 0;
  }
  
  int InternalSessionGetConnectedDevice(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTEDDEVICE_REULT_LIST", this._deviceConfigManager.getConnectedDevice());
    sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  int InternalSessionGetConnectingDevice(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTINGDEVICE_REULT_LIST", this._deviceConfigManager.getConnectingDevice());
    sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  int InternalSessionIsDeviceChangabled(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", InternalIsDeviceChangeable());
    sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  void InternalSetMode(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SetMode entry:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this._am;
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setMode:");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" fail am=null");
        QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    ((AudioManager)localObject).setMode(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMode:");
      localStringBuilder.append(paramInt);
      if (this._am.getMode() != paramInt) {
        localObject = "fail";
      } else {
        localObject = "success";
      }
      localStringBuilder.append((String)localObject);
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    }
  }
  
  int InternalSetSpeaker(Context paramContext, boolean paramBoolean)
  {
    int i = -1;
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, "Could not InternalSetSpeaker - no context");
      }
      return -1;
    }
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    if (localAudioManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, "Could not InternalSetSpeaker - no audio manager");
      }
      return -1;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("InternalSetSpeaker entry:speaker:");
      boolean bool = localAudioManager.isSpeakerphoneOn();
      localObject = "Y";
      if (bool) {
        paramContext = "Y";
      } else {
        paramContext = "N";
      }
      localStringBuilder.append(paramContext);
      localStringBuilder.append("-->:");
      if (paramBoolean) {
        paramContext = (Context)localObject;
      } else {
        paramContext = "N";
      }
      localStringBuilder.append(paramContext);
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    }
    if ((isCloseSystemAPM(this._modePolicy)) && (this._activeMode != 2)) {
      return InternalSetSpeakerSpe(localAudioManager, paramBoolean);
    }
    try
    {
      if (localAudioManager.isSpeakerphoneOn() != paramBoolean) {
        localAudioManager.setSpeakerphoneOn(paramBoolean);
      }
    }
    catch (Exception paramContext)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setSpeakerphoneOn failed with ");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      QLog.e("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
    }
    if (localAudioManager.isSpeakerphoneOn() == paramBoolean) {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("InternalSetSpeaker exit:");
      paramContext.append(paramBoolean);
      paramContext.append(" res:");
      paramContext.append(i);
      paramContext.append(" mode:");
      paramContext.append(localAudioManager.getMode());
      QLog.w("TraeAudioManager", 2, paramContext.toString());
    }
    return i;
  }
  
  int InternalSetSpeakerSpe(AudioManager paramAudioManager, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("InternalSetSpeakerSpe fac:");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append(" model:");
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append(" st:");
      localStringBuilder.append(this._streamType);
      localStringBuilder.append(" media_force_use:");
      localStringBuilder.append(getForceUse(1));
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    }
    int i = 0;
    if (paramBoolean)
    {
      InternalSetMode(0);
      paramAudioManager.setSpeakerphoneOn(true);
      setForceUse(1, 1);
    }
    else
    {
      InternalSetMode(3);
      paramAudioManager.setSpeakerphoneOn(false);
      setForceUse(1, 0);
    }
    if (paramAudioManager.isSpeakerphoneOn() != paramBoolean) {
      i = -1;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("InternalSetSpeakerSpe exit:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" res:");
      localStringBuilder.append(i);
      localStringBuilder.append(" mode:");
      localStringBuilder.append(paramAudioManager.getMode());
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  void _updateEarphoneVisable()
  {
    TraeAudioManager.DeviceConfigManager localDeviceConfigManager = this._deviceConfigManager;
    if (localDeviceConfigManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "_deviceConfigManager is null");
      }
      return;
    }
    if ((!localDeviceConfigManager.getVisible("DEVICE_WIREDHEADSET")) && (!this._deviceConfigManager.getVisible("DEVICE_BLUETOOTHHEADSET")))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, " detected headset plugout,so enable earphone");
      }
      this._deviceConfigManager.setVisible("DEVICE_EARPHONE", true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, " detected headset plugin,so disable earphone");
    }
    this._deviceConfigManager.setVisible("DEVICE_EARPHONE", false);
  }
  
  void checkAutoDeviceListUpdate(boolean paramBoolean)
  {
    TraeAudioManager.DeviceConfigManager localDeviceConfigManager = this._deviceConfigManager;
    if (localDeviceConfigManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "_deviceConfigManager is null");
      }
      return;
    }
    if ((paramBoolean) || (localDeviceConfigManager.getVisiableUpdateFlag()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "checkAutoDeviceListUpdate got update!");
      }
      _updateEarphoneVisable();
      this._deviceConfigManager.resetVisiableUpdateFlag();
      internalSendMessage(32785, new HashMap());
    }
  }
  
  void checkDevicePlug(String paramString, boolean paramBoolean)
  {
    Object localObject = this._deviceConfigManager;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "_deviceConfigManager is null");
      }
      return;
    }
    if (((TraeAudioManager.DeviceConfigManager)localObject).getVisiableUpdateFlag() == true)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkDevicePlug got update dev:");
        localStringBuilder.append(paramString);
        if (paramBoolean) {
          localObject = " piugin";
        } else {
          localObject = " plugout";
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" connectedDev:");
        localStringBuilder.append(this._deviceConfigManager.getConnectedDevice());
        QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
      }
      _updateEarphoneVisable();
      this._deviceConfigManager.resetVisiableUpdateFlag();
      if (paramBoolean)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("PARAM_DEVICE", paramString);
        internalSendMessage(32786, (HashMap)localObject);
        return;
      }
      localObject = this._deviceConfigManager.getConnectedDevice();
      if ((!((String)localObject).equals(paramString)) && (!((String)localObject).equals("DEVICE_NONE")))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(" ---No switch,plugout:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" connectedDev:");
          localStringBuilder.append((String)localObject);
          QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
        }
        internalSendMessage(32793, new HashMap());
        return;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("PARAM_DEVICE", paramString);
      internalSendMessage(32787, (HashMap)localObject);
    }
  }
  
  int internalSendMessage(int paramInt, HashMap<String, Object> paramHashMap)
  {
    TraeAudioManager.TraeAudioManagerLooper localTraeAudioManagerLooper = this.mTraeAudioManagerLooper;
    if (localTraeAudioManagerLooper != null) {
      return localTraeAudioManagerLooper.sendMessage(paramInt, paramHashMap);
    }
    return -1;
  }
  
  void onHeadsetPlug(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("name");
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = "unkonw";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(" [");
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("] ");
    localObject = ((StringBuilder)localObject).toString();
    int i = paramIntent.getIntExtra("state", -1);
    paramContext = (Context)localObject;
    if (i != -1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      if (i == 0) {
        paramContext = "unplugged";
      } else {
        paramContext = "plugged";
      }
      localStringBuilder.append(paramContext);
      paramContext = localStringBuilder.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append(" mic:");
    localObject = ((StringBuilder)localObject).toString();
    int j = paramIntent.getIntExtra("microphone", -1);
    boolean bool = true;
    paramContext = (Context)localObject;
    if (j != -1)
    {
      paramIntent = new StringBuilder();
      paramIntent.append((String)localObject);
      if (j == 1) {
        paramContext = "Y";
      } else {
        paramContext = "unkown";
      }
      paramIntent.append(paramContext);
      paramContext = paramIntent.toString();
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onHeadsetPlug:: ");
      paramIntent.append(paramContext);
      QLog.w("TraeAudioManager", 2, paramIntent.toString());
    }
    paramContext = this._deviceConfigManager;
    if (paramContext != null)
    {
      if (1 != i) {
        bool = false;
      }
      paramContext.setVisible("DEVICE_WIREDHEADSET", bool);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "onHeadsetPlug exit");
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramContext != null))
    {
      try
      {
        String str2 = paramIntent.getAction();
        String str1 = paramIntent.getStringExtra("PARAM_OPERATION");
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("TraeAudioManager|onReceive::Action:");
          ((StringBuilder)localObject).append(paramIntent.getAction());
          QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
        }
        if (this._deviceConfigManager == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("TraeAudioManager", 2, "_deviceConfigManager null!");
          return;
        }
        boolean bool1 = this._deviceConfigManager.getVisible("DEVICE_WIREDHEADSET");
        boolean bool2 = this._deviceConfigManager.getVisible("DEVICE_BLUETOOTHHEADSET");
        if ("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction()))
        {
          onHeadsetPlug(paramContext, paramIntent);
          if ((!bool1) && (this._deviceConfigManager.getVisible("DEVICE_WIREDHEADSET") == true)) {
            checkDevicePlug("DEVICE_WIREDHEADSET", true);
          }
          if ((bool1 == true) && (!this._deviceConfigManager.getVisible("DEVICE_WIREDHEADSET"))) {
            checkDevicePlug("DEVICE_WIREDHEADSET", false);
          }
        }
        else
        {
          if ("android.media.AUDIO_BECOMING_NOISY".equals(paramIntent.getAction())) {
            return;
          }
          if ("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST".equals(str2))
          {
            if (QLog.isColorLevel())
            {
              paramContext = new StringBuilder();
              paramContext.append("   OPERATION:");
              paramContext.append(str1);
              QLog.w("TraeAudioManager", 2, paramContext.toString());
            }
            bool1 = "OPERATION_STARTSERVICE".equals(str1);
            if (bool1)
            {
              startService(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("EXTRA_DATA_DEVICECONFIG"));
              return;
            }
            if ("OPERATION_STOPSERVICE".equals(str1))
            {
              stopService(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
              return;
            }
            if ("OPERATION_GETDEVICELIST".equals(str1))
            {
              getDeviceList(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
              return;
            }
            if ("OPERATION_GETSTREAMTYPE".equals(str1))
            {
              getStreamType(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
              return;
            }
            if ("OPERATION_CONNECTDEVICE".equals(str1))
            {
              connectDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("CONNECTDEVICE_DEVICENAME"));
              return;
            }
            if ("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE".equals(str1))
            {
              connectHighestPriorityDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
              return;
            }
            if ("OPERATION_EARACTION".equals(str1))
            {
              earAction(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getIntExtra("EXTRA_EARACTION", -1));
              return;
            }
            if ("OPERATION_ISDEVICECHANGABLED".equals(str1))
            {
              isDeviceChangabled(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
              return;
            }
            if ("OPERATION_GETCONNECTEDDEVICE".equals(str1))
            {
              getConnectedDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
              return;
            }
            if ("OPERATION_GETCONNECTINGDEVICE".equals(str1))
            {
              getConnectingDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
              return;
            }
            bool1 = "OPERATION_VOICECALL_PREPROCESS".equals(str1);
            int i;
            int j;
            if (bool1)
            {
              i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
              j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
              voicecallPreprocess(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
              return;
            }
            if ("OPERATION_VOICECALL_POSTROCESS".equals(str1))
            {
              voicecallPostprocess(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
              return;
            }
            if ("OPERATION_VOICECALL_AUDIOPARAM_CHANGED".equals(str1))
            {
              i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
              j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
              voiceCallAudioParamChanged(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
              return;
            }
            if ("OPERATION_STARTRING".equals(str1))
            {
              i = paramIntent.getIntExtra("PARAM_RING_DATASOURCE", -1);
              j = paramIntent.getIntExtra("PARAM_RING_RSID", -1);
              paramContext = (Uri)paramIntent.getParcelableExtra("PARAM_RING_URI");
              str2 = paramIntent.getStringExtra("PARAM_RING_FILEPATH");
              bool1 = paramIntent.getBooleanExtra("PARAM_RING_LOOP", false);
              localObject = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
              int k = paramIntent.getIntExtra("PARAM_RING_LOOPCOUNT", 1);
              bool2 = paramIntent.getBooleanExtra("PARAM_RING_MODE", false);
              startRing(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j, paramContext, str2, bool1, k, (String)localObject, bool2);
              return;
            }
            if ("OPERATION_STOPRING".equals(str1)) {
              stopRing(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
            }
          }
          else if (this._deviceConfigManager != null)
          {
            if (this._bluetoothCheck != null) {
              this._bluetoothCheck.onReceive(paramContext, paramIntent, this._deviceConfigManager);
            }
            if ((!bool2) && (this._deviceConfigManager.getVisible("DEVICE_BLUETOOTHHEADSET") == true)) {
              checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
            }
            if ((bool2 == true) && (!this._deviceConfigManager.getVisible("DEVICE_BLUETOOTHHEADSET")))
            {
              checkDevicePlug("DEVICE_BLUETOOTHHEADSET", false);
              return;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("deal with receiver failed.");
          paramIntent.append(paramContext.getMessage());
          QLog.e("TraeAudioManager", 2, paramIntent.toString());
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("TraeAudioManager", 2, "onReceive intent or context is null!");
      }
      return;
    }
  }
  
  void printDevices()
  {
    AudioDeviceInterface.LogTraceEntry("");
    Object localObject = this._deviceConfigManager;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "_deviceConfigManager is null");
      }
      return;
    }
    int k = ((TraeAudioManager.DeviceConfigManager)localObject).getDeviceNumber();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("   ConnectedDevice:");
      ((StringBuilder)localObject).append(this._deviceConfigManager.getConnectedDevice());
      QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("   ConnectingDevice:");
      ((StringBuilder)localObject).append(this._deviceConfigManager.getConnectingDevice());
      QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("   prevConnectedDevice:");
      ((StringBuilder)localObject).append(this._deviceConfigManager.getPrevConnectedDevice());
      QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("   AHPDevice:");
      ((StringBuilder)localObject).append(this._deviceConfigManager.getAvailabledHighestPriorityDevice());
      QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("   deviceNamber:");
      ((StringBuilder)localObject).append(k);
      QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
    }
    int j = 0;
    int i = 0;
    StringBuilder localStringBuilder1;
    while (i < k)
    {
      localObject = this._deviceConfigManager.getDeviceName(i);
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("      ");
        localStringBuilder1.append(i);
        localStringBuilder1.append(" devName:");
        localStringBuilder1.append((String)localObject);
        localStringBuilder1.append(" Visible:");
        localStringBuilder1.append(this._deviceConfigManager.getVisible((String)localObject));
        localStringBuilder1.append(" Priority:");
        localStringBuilder1.append(this._deviceConfigManager.getPriority((String)localObject));
        QLog.w("TraeAudioManager", 2, localStringBuilder1.toString());
      }
      i += 1;
    }
    localObject = (String[])this._deviceConfigManager.getAvailableDeviceList().toArray(new String[0]);
    i = j;
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("   AvailableNamber:");
      localStringBuilder1.append(localObject.length);
      QLog.w("TraeAudioManager", 2, localStringBuilder1.toString());
      i = j;
    }
    while (i < localObject.length)
    {
      localStringBuilder1 = localObject[i];
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("      ");
        localStringBuilder2.append(i);
        localStringBuilder2.append(" devName:");
        localStringBuilder2.append(localStringBuilder1);
        localStringBuilder2.append(" Visible:");
        localStringBuilder2.append(this._deviceConfigManager.getVisible(localStringBuilder1));
        localStringBuilder2.append(" Priority:");
        localStringBuilder2.append(this._deviceConfigManager.getPriority(localStringBuilder1));
        QLog.w("TraeAudioManager", 2, localStringBuilder2.toString());
      }
      i += 1;
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void release()
  {
    AudioDeviceInterface.LogTraceEntry("");
    TraeAudioManager.TraeAudioManagerLooper localTraeAudioManagerLooper = this.mTraeAudioManagerLooper;
    if (localTraeAudioManagerLooper != null)
    {
      localTraeAudioManagerLooper.quit();
      this.mTraeAudioManagerLooper = null;
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  int sendResBroadcast(Intent paramIntent, HashMap<String, Object> paramHashMap, int paramInt)
  {
    if (this._context == null) {
      return -1;
    }
    Long localLong = (Long)paramHashMap.get("PARAM_SESSIONID");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" sessonID:");
      localStringBuilder.append(localLong);
      localStringBuilder.append(" ");
      localStringBuilder.append((String)paramHashMap.get("PARAM_OPERATION"));
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    }
    if ((localLong != null) && (localLong.longValue() != -9223372036854775808L))
    {
      localLong = (Long)paramHashMap.get("PARAM_SESSIONID");
      paramHashMap = (String)paramHashMap.get("PARAM_OPERATION");
      if ("OPERATION_VOICECALL_PREPROCESS".equals(paramHashMap))
      {
        paramIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
        paramIntent.putExtra("PARAM_SESSIONID", localLong);
        paramIntent.putExtra("PARAM_OPERATION", paramHashMap);
        paramIntent.putExtra("PARAM_RES_ERRCODE", paramInt);
        paramHashMap = this._audioSessionHost;
        if (paramHashMap != null) {
          paramHashMap.sendToAudioSessionMessage(paramIntent);
        }
      }
      else
      {
        new Handler(Looper.getMainLooper()).post(new TraeAudioManager.1(this, paramIntent, localLong, paramHashMap, paramInt));
      }
      return 0;
    }
    InternalNotifyDeviceListUpdate();
    if (QLog.isColorLevel()) {
      QLog.e("TraeAudioManager", 2, "sendResBroadcast sid null,don't send res");
    }
    return -1;
  }
  
  void updateDeviceStatus()
  {
    Object localObject1 = this._deviceConfigManager;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "_deviceConfigManager is null");
      }
      return;
    }
    int j = ((TraeAudioManager.DeviceConfigManager)localObject1).getDeviceNumber();
    int i = 0;
    while (i < j)
    {
      localObject1 = this._deviceConfigManager.getDeviceName(i);
      Object localObject2;
      if (localObject1 != null)
      {
        if (((String)localObject1).equals("DEVICE_BLUETOOTHHEADSET"))
        {
          localObject2 = this._bluetoothCheck;
          if (localObject2 == null)
          {
            bool = this._deviceConfigManager.setVisible((String)localObject1, false);
            break label161;
          }
          bool = this._deviceConfigManager.setVisible((String)localObject1, ((TraeAudioManager.BluetoohHeadsetCheckInterface)localObject2).isConnected());
          break label161;
        }
        if (((String)localObject1).equals("DEVICE_WIREDHEADSET"))
        {
          bool = this._deviceConfigManager.setVisible((String)localObject1, this._am.isWiredHeadsetOn());
          break label161;
        }
        if (((String)localObject1).equals("DEVICE_SPEAKERPHONE")) {
          this._deviceConfigManager.setVisible((String)localObject1, true);
        }
      }
      boolean bool = false;
      label161:
      if ((bool == true) && (QLog.isColorLevel()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("pollUpdateDevice dev:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" Visible:");
        ((StringBuilder)localObject2).append(this._deviceConfigManager.getVisible((String)localObject1));
        QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject2).toString());
      }
      i += 1;
    }
    checkAutoDeviceListUpdate(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager
 * JD-Core Version:    0.7.0.1
 */