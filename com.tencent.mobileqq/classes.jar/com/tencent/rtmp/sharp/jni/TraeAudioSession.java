package com.tencent.rtmp.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Process;

public class TraeAudioSession
  extends BroadcastReceiver
{
  static int s_nSessionIdAllocator;
  final String TRAE_ACTION_PHONE_STATE;
  private boolean _canSwtich2Earphone;
  private String _connectedDev;
  private TraeAudioSession.ITraeAudioCallback mCallback;
  private Context mContext;
  private boolean mIsHostside;
  private long mSessionId;
  
  public TraeAudioSession(Context paramContext, TraeAudioSession.ITraeAudioCallback paramITraeAudioCallback)
  {
    boolean bool = false;
    this.mIsHostside = false;
    this.mSessionId = -9223372036854775808L;
    this._connectedDev = "DEVICE_NONE";
    this._canSwtich2Earphone = true;
    this.TRAE_ACTION_PHONE_STATE = "android.intent.action.PHONE_STATE";
    if (Process.myPid() == TraeAudioManager._gHostProcessId) {
      bool = true;
    }
    this.mIsHostside = bool;
    this.mSessionId = requestSessionId();
    this.mCallback = paramITraeAudioCallback;
    this.mContext = paramContext;
    if ((paramContext == null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AudioSession | Invalid parameters: ctx = ");
      String str2 = "null";
      String str1;
      if (paramContext == null) {
        str1 = "null";
      } else {
        str1 = "{object}";
      }
      localStringBuilder.append(str1);
      localStringBuilder.append("; cb = ");
      if (paramITraeAudioCallback == null) {
        paramITraeAudioCallback = str2;
      } else {
        paramITraeAudioCallback = "{object}";
      }
      localStringBuilder.append(paramITraeAudioCallback);
      QLog.w("TRAE", 2, localStringBuilder.toString());
    }
    paramITraeAudioCallback = new IntentFilter();
    paramITraeAudioCallback.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
    paramITraeAudioCallback.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    if (paramContext != null) {
      try
      {
        paramContext.registerReceiver(this, paramITraeAudioCallback);
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel())
        {
          paramITraeAudioCallback = new StringBuilder();
          paramITraeAudioCallback.append("registerReceiver Exception: ");
          paramITraeAudioCallback.append(paramContext.getMessage());
          QLog.e("TRAE", 2, paramITraeAudioCallback.toString());
        }
      }
    }
    registerAudioSession(this, true);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("TraeAudioSession create, mSessionId: ");
      paramContext.append(this.mSessionId);
      QLog.w("TRAE", 2, paramContext.toString());
    }
  }
  
  public static void ExConnectDevice(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null))
    {
      if (paramString.length() <= 0) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      localIntent.putExtra("PARAM_SESSIONID", -9223372036854775808L);
      localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECTDEVICE");
      localIntent.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
      paramContext.sendBroadcast(localIntent);
    }
  }
  
  private int registerAudioSession(TraeAudioSession paramTraeAudioSession, boolean paramBoolean)
  {
    Context localContext = this.mContext;
    if (localContext == null) {
      return -1;
    }
    return TraeAudioManager.registerAudioSession(paramTraeAudioSession, paramBoolean, this.mSessionId, localContext);
  }
  
  public static long requestSessionId()
  {
    long l = Process.myPid();
    int i = s_nSessionIdAllocator + 1;
    s_nSessionIdAllocator = i;
    return (l << 32) + i;
  }
  
  public int EarAction(int paramInt)
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.earAction("OPERATION_EARACTION", this.mSessionId, bool, paramInt);
    }
    if ((this.mContext != null) && ((paramInt == 0) || (paramInt == 1)))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
      localIntent.putExtra("PARAM_OPERATION", "OPERATION_EARACTION");
      localIntent.putExtra("EXTRA_EARACTION", paramInt);
      this.mContext.sendBroadcast(localIntent);
      return 0;
    }
    return -1;
  }
  
  public int connectDevice(String paramString)
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.connectDevice("OPERATION_CONNECTDEVICE", this.mSessionId, bool, paramString);
    }
    if ((this.mContext != null) && (paramString != null) && (paramString.length() > 0))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
      localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECTDEVICE");
      localIntent.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
      this.mContext.sendBroadcast(localIntent);
      return 0;
    }
    return -1;
  }
  
  public int connectHighestPriorityDevice()
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.connectHighestPriorityDevice("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE", this.mSessionId, bool);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int disableDeviceSwitch()
  {
    return TraeAudioManager.disableDeviceSwitch();
  }
  
  public int getConnectedDevice()
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.getConnectedDevice("OPERATION_GETCONNECTEDDEVICE", this.mSessionId, bool);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETCONNECTEDDEVICE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int getConnectingDevice()
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.getConnectingDevice("OPERATION_GETCONNECTINGDEVICE", this.mSessionId, bool);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETCONNECTINGDEVICE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int getDeviceList()
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.getDeviceList("OPERATION_GETDEVICELIST", this.mSessionId, bool);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETDEVICELIST");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int getStreamType()
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.getStreamType("OPERATION_GETSTREAMTYPE", this.mSessionId, bool);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETSTREAMTYPE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int isDeviceChangabled()
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.isDeviceChangabled("OPERATION_ISDEVICECHANGABLED", this.mSessionId, bool);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_ISDEVICECHANGABLED");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    try
    {
      if (!QLog.isColorLevel()) {
        break label1995;
      }
      QLog.w("TRAE", 2, "[ERROR] intent = null!!");
      return;
    }
    catch (Exception paramContext)
    {
      long l;
      int j;
      String str1;
      String str2;
      String str3;
      StringBuilder localStringBuilder;
      if (!QLog.isColorLevel()) {
        break label1994;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioSession| nSessinId = ");
      ((StringBuilder)localObject).append(this.mSessionId);
      ((StringBuilder)localObject).append(" onReceive::intent:");
      ((StringBuilder)localObject).append(paramIntent.toString());
      ((StringBuilder)localObject).append(" intent.getAction():");
      ((StringBuilder)localObject).append(paramIntent.getAction());
      ((StringBuilder)localObject).append(" Exception:");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      QLog.e("TRAE", 2, ((StringBuilder)localObject).toString());
    }
    l = paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L);
    paramContext = paramIntent.getStringExtra("PARAM_OPERATION");
    j = paramIntent.getIntExtra("PARAM_RES_ERRCODE", 0);
    boolean bool = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY".equals(paramIntent.getAction());
    int i;
    if (bool)
    {
      if ("NOTIFY_SERVICE_STATE".equals(paramContext))
      {
        bool = paramIntent.getBooleanExtra("NOTIFY_SERVICE_STATE_DATE", false);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("AudioSession|[onServiceStateUpdate]");
          if (!bool) {
            break label1996;
          }
          paramContext = "on";
          ((StringBuilder)localObject).append(paramContext);
          QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
        }
        if (this.mCallback != null) {
          this.mCallback.onServiceStateUpdate(bool);
        }
      }
      else if ("NOTIFY_DEVICELISTUPDATE".equals(paramContext))
      {
        localObject = paramIntent.getStringArrayExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST");
        str1 = paramIntent.getStringExtra("EXTRA_DATA_CONNECTEDDEVICE");
        str2 = paramIntent.getStringExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE");
        str3 = paramIntent.getStringExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME");
        paramContext = "\n";
        i = 0;
        bool = true;
        label207:
        if (i < localObject.length)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramContext);
          localStringBuilder.append("AudioSession|    ");
          localStringBuilder.append(i);
          localStringBuilder.append(" ");
          localStringBuilder.append(localObject[i]);
          localStringBuilder.append("\n");
          paramContext = localStringBuilder.toString();
          if (localObject[i].equals("DEVICE_WIREDHEADSET")) {
            break label2003;
          }
          if (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET")) {
            break label2006;
          }
          break label2003;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext);
        localStringBuilder.append("\n");
        paramContext = localStringBuilder.toString();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("AudioSession|[onDeviceListUpdate]  connected:");
          localStringBuilder.append(str1);
          localStringBuilder.append(" prevConnected:");
          localStringBuilder.append(str2);
          localStringBuilder.append(" bt:");
          localStringBuilder.append(str3);
          localStringBuilder.append(" Num:");
          localStringBuilder.append(localObject.length);
          localStringBuilder.append(paramContext);
          QLog.w("TRAE", 2, localStringBuilder.toString());
        }
        this._canSwtich2Earphone = bool;
        this._connectedDev = str1;
        if (this.mCallback != null) {
          this.mCallback.onDeviceListUpdate((String[])localObject, str1, str2, str3);
        }
      }
      else if ("NOTIFY_DEVICECHANGABLE_UPDATE".equals(paramContext))
      {
        bool = paramIntent.getBooleanExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", true);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("AudioSession|[onDeviceChangabledUpdate]");
          paramContext.append(bool);
          QLog.w("TRAE", 2, paramContext.toString());
        }
        if (this.mCallback != null) {
          this.mCallback.onDeviceChangabledUpdate(bool);
        }
      }
      else if ("NOTIFY_STREAMTYPE_UPDATE".equals(paramContext))
      {
        i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
        if ((j != 0) && (QLog.isColorLevel()))
        {
          paramContext = new StringBuilder();
          paramContext.append("AudioSession|[onStreamTypeUpdate] err:");
          paramContext.append(j);
          paramContext.append(" st:");
          paramContext.append(i);
          QLog.w("TRAE", 2, paramContext.toString());
        }
        if (this.mCallback != null) {
          this.mCallback.onStreamTypeUpdate(i);
        }
      }
      else if ("NOTIFY_ROUTESWITCHSTART".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_FROM");
        localObject = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_TO");
        if ((this.mCallback != null) && (paramContext != null) && (localObject != null)) {
          this.mCallback.onAudioRouteSwitchStart(paramContext, (String)localObject);
        }
      }
      else if ("NOTIFY_ROUTESWITCHEND".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHEND_DEV");
        l = paramIntent.getLongExtra("EXTRA_DATA_ROUTESWITCHEND_TIME", -1L);
        if ((this.mCallback != null) && (paramContext != null) && (l != -1L)) {
          this.mCallback.onAudioRouteSwitchEnd(paramContext, l);
        }
      }
    }
    else if ("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES".equals(paramIntent.getAction()))
    {
      if (this.mSessionId != l) {
        return;
      }
      if ("OPERATION_GETDEVICELIST".equals(paramContext))
      {
        localObject = paramIntent.getStringArrayExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST");
        str1 = paramIntent.getStringExtra("EXTRA_DATA_CONNECTEDDEVICE");
        str2 = paramIntent.getStringExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE");
        str3 = paramIntent.getStringExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME");
        paramContext = "\n";
        i = 0;
        bool = true;
        label848:
        if (i < localObject.length)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramContext);
          localStringBuilder.append("AudioSession|    ");
          localStringBuilder.append(i);
          localStringBuilder.append(" ");
          localStringBuilder.append(localObject[i]);
          localStringBuilder.append("\n");
          paramContext = localStringBuilder.toString();
          if (localObject[i].equals("DEVICE_WIREDHEADSET")) {
            break label2013;
          }
          if (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET")) {
            break label2016;
          }
          break label2013;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext);
        localStringBuilder.append("\n");
        paramContext = localStringBuilder.toString();
        this._canSwtich2Earphone = bool;
        this._connectedDev = str1;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("AudioSession|[onGetDeviceListRes] err:");
          localStringBuilder.append(j);
          localStringBuilder.append(" connected:");
          localStringBuilder.append(str1);
          localStringBuilder.append(" prevConnected:");
          localStringBuilder.append(str2);
          localStringBuilder.append(" bt:");
          localStringBuilder.append(str3);
          localStringBuilder.append(" Num:");
          localStringBuilder.append(localObject.length);
          localStringBuilder.append(paramContext);
          QLog.w("TRAE", 2, localStringBuilder.toString());
        }
        if (this.mCallback != null) {
          this.mCallback.onGetDeviceListRes(j, (String[])localObject, str1, str2, str3);
        }
      }
      else
      {
        bool = "OPERATION_CONNECTDEVICE".equals(paramContext);
        if (bool)
        {
          paramContext = paramIntent.getStringExtra("CONNECTDEVICE_RESULT_DEVICENAME");
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("AudioSession|[onConnectDeviceRes] err:");
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append(" dev:");
            ((StringBuilder)localObject).append(paramContext);
            QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
          }
          if (this.mCallback != null)
          {
            localObject = this.mCallback;
            if (j != 0) {
              break label2023;
            }
            bool = true;
            label1243:
            ((TraeAudioSession.ITraeAudioCallback)localObject).onConnectDeviceRes(j, paramContext, bool);
          }
        }
        else
        {
          if ("OPERATION_EARACTION".equals(paramContext))
          {
            i = paramIntent.getIntExtra("EXTRA_EARACTION", -1);
            if (QLog.isColorLevel())
            {
              paramContext = new StringBuilder();
              paramContext.append("AudioSession|[onConnectDeviceRes] err:");
              paramContext.append(j);
              paramContext.append(" earAction:");
              paramContext.append(i);
              QLog.w("TRAE", 2, paramContext.toString());
            }
            paramContext = this.mCallback;
            return;
          }
          if ("OPERATION_ISDEVICECHANGABLED".equals(paramContext))
          {
            bool = paramIntent.getBooleanExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", false);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("AudioSession|[onIsDeviceChangabledRes] err:");
              ((StringBuilder)localObject).append(j);
              ((StringBuilder)localObject).append(" Changabled:");
              if (!bool) {
                break label2029;
              }
              paramContext = "Y";
            }
          }
        }
      }
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(paramContext);
      QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
      if (this.mCallback != null)
      {
        this.mCallback.onIsDeviceChangabledRes(j, bool);
        return;
        if ("OPERATION_GETCONNECTEDDEVICE".equals(paramContext))
        {
          paramContext = paramIntent.getStringExtra("GETCONNECTEDDEVICE_REULT_LIST");
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("AudioSession|[onGetConnectedDeviceRes] err:");
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append(" dev:");
            ((StringBuilder)localObject).append(paramContext);
            QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
          }
          if (this.mCallback != null) {
            this.mCallback.onGetConnectedDeviceRes(j, paramContext);
          }
        }
        else if ("OPERATION_GETCONNECTINGDEVICE".equals(paramContext))
        {
          paramContext = paramIntent.getStringExtra("GETCONNECTINGDEVICE_REULT_LIST");
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("AudioSession|[onGetConnectingDeviceRes] err:");
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append(" dev:");
            ((StringBuilder)localObject).append(paramContext);
            QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
          }
          if (this.mCallback != null) {
            this.mCallback.onGetConnectingDeviceRes(j, paramContext);
          }
        }
        else if ("OPERATION_GETSTREAMTYPE".equals(paramContext))
        {
          i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("AudioSession|[onGetStreamTypeRes] err:");
            paramContext.append(j);
            paramContext.append(" st:");
            paramContext.append(i);
            QLog.w("TRAE", 2, paramContext.toString());
          }
          if (this.mCallback != null) {
            this.mCallback.onGetStreamTypeRes(j, i);
          }
        }
        else if ("NOTIFY_RING_COMPLETION".equals(paramContext))
        {
          paramContext = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("AudioSession|[onRingCompletion] err:");
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append(" userData:");
            ((StringBuilder)localObject).append(paramContext);
            QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
          }
          if (this.mCallback != null) {
            this.mCallback.onRingCompletion(j, paramContext);
          }
        }
        else if ("OPERATION_VOICECALL_PREPROCESS".equals(paramContext))
        {
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("AudioSession|[onVoicecallPreprocess] err:");
            paramContext.append(j);
            QLog.w("TRAE", 2, paramContext.toString());
          }
          if (this.mCallback != null)
          {
            this.mCallback.onVoicecallPreprocessRes(j);
            return;
          }
        }
      }
      label1994:
      return;
      label1995:
      return;
      label1996:
      paramContext = "off";
      break;
      label2003:
      bool = false;
      label2006:
      i += 1;
      break label207;
      label2013:
      bool = false;
      label2016:
      i += 1;
      break label848;
      label2023:
      bool = false;
      break label1243;
      label2029:
      paramContext = "N";
    }
  }
  
  public void onReceiveCallback(Intent paramIntent)
  {
    if (paramIntent == null) {}
    try
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.w("TRAE", 2, "[ERROR] intent = null!!");
      return;
    }
    catch (Exception localException)
    {
      long l;
      Object localObject;
      int i;
      if (!QLog.isColorLevel()) {
        break label243;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AudioSession| nSessinId = ");
      localStringBuilder.append(this.mSessionId);
      localStringBuilder.append(" onReceive::intent:");
      localStringBuilder.append(paramIntent.toString());
      localStringBuilder.append(" intent.getAction():");
      localStringBuilder.append(paramIntent.getAction());
      localStringBuilder.append(" Exception:");
      localStringBuilder.append(localException.getMessage());
      QLog.e("TRAE", 2, localStringBuilder.toString());
    }
    l = paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L);
    localObject = paramIntent.getStringExtra("PARAM_OPERATION");
    i = paramIntent.getIntExtra("PARAM_RES_ERRCODE", 0);
    if ("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES".equals(paramIntent.getAction()))
    {
      if (this.mSessionId != l) {
        return;
      }
      if ("OPERATION_VOICECALL_PREPROCESS".equals(localObject))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("AudioSession|[onReceiveCallback onVoicecallPreprocess] err:");
          ((StringBuilder)localObject).append(i);
          QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
        }
        if (this.mCallback != null)
        {
          this.mCallback.onVoicecallPreprocessRes(i);
          return;
        }
      }
    }
    label243:
    return;
  }
  
  public int recoverAudioFocus()
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.recoverAudioFocus("OPERATION_RECOVER_AUDIO_FOCUS", this.mSessionId, bool);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_RECOVER_AUDIO_FOCUS");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void release()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TraeAudioSession release, mSessionId: ");
      ((StringBuilder)localObject).append(this.mSessionId);
      QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mContext;
    if (localObject != null) {
      try
      {
        ((Context)localObject).unregisterReceiver(this);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unregisterReceiver failed.");
          localStringBuilder.append(localException.getMessage());
          QLog.e("TRAE", 2, localStringBuilder.toString());
        }
      }
    }
    registerAudioSession(this, false);
    this.mContext = null;
    this.mCallback = null;
  }
  
  public int requestReleaseAudioFocus()
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.requestReleaseAudioFocus("OPERATION_REQUEST_RELEASE_AUDIO_FOCUS", this.mSessionId, bool);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void setCallback(TraeAudioSession.ITraeAudioCallback paramITraeAudioCallback)
  {
    this.mCallback = paramITraeAudioCallback;
  }
  
  public int startRing(int paramInt1, int paramInt2, Uri paramUri, String paramString, boolean paramBoolean)
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.startRing("OPERATION_STARTRING", this.mSessionId, bool, paramInt1, paramInt2, paramUri, paramString, paramBoolean, 1, "normal-ring", false);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean);
    localIntent.putExtra("PARAM_RING_MODE", false);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", "normal-ring");
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int startRing(int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean, int paramInt3, String paramString2)
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.startRing("OPERATION_STARTRING", this.mSessionId, bool, paramInt1, paramInt2, paramUri, paramString1, paramBoolean, paramInt3, paramString2, false);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString1);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean);
    localIntent.putExtra("PARAM_RING_LOOPCOUNT", paramInt3);
    localIntent.putExtra("PARAM_RING_MODE", false);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", paramString2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int startRing(int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean1, int paramInt3, String paramString2, boolean paramBoolean2)
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.startRing("OPERATION_STARTRING", this.mSessionId, bool, paramInt1, paramInt2, paramUri, paramString1, paramBoolean1, paramInt3, paramString2, paramBoolean2);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString1);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean1);
    localIntent.putExtra("PARAM_RING_LOOPCOUNT", paramInt3);
    localIntent.putExtra("PARAM_RING_MODE", paramBoolean2);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", paramString2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int startService(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 0) {}
    }
    else
    {
      str = "internal_disable_dev_switch";
    }
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.startService("OPERATION_STARTSERVICE", this.mSessionId, bool, str);
    }
    if (this.mContext == null) {
      return -1;
    }
    paramString = new Intent();
    paramString.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    paramString.putExtra("PARAM_SESSIONID", this.mSessionId);
    paramString.putExtra("PARAM_OPERATION", "OPERATION_STARTSERVICE");
    paramString.putExtra("EXTRA_DATA_DEVICECONFIG", str);
    this.mContext.sendBroadcast(paramString);
    return 0;
  }
  
  public int stopRing()
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.stopRing("OPERATION_STOPRING", this.mSessionId, bool);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPRING");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int stopService()
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.stopService("OPERATION_STOPSERVICE", this.mSessionId, bool);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPSERVICE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int voiceCallAudioParamChanged(int paramInt1, int paramInt2)
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.voiceCallAudioParamChanged("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST", this.mSessionId, bool, paramInt1, paramInt2);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_AUDIOPARAM_CHANGED");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int voiceCallPostprocess()
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.voicecallPostprocess("OPERATION_VOICECALL_POSTROCESS", this.mSessionId, bool);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_POSTROCESS");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int voiceCallPreprocess(int paramInt1, int paramInt2)
  {
    boolean bool = this.mIsHostside;
    if (bool) {
      return TraeAudioManager.voicecallPreprocess("OPERATION_VOICECALL_PREPROCESS", this.mSessionId, bool, paramInt1, paramInt2);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_PREPROCESS");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioSession
 * JD-Core Version:    0.7.0.1
 */