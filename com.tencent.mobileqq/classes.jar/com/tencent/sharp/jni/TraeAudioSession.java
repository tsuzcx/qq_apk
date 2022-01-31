package com.tencent.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Process;
import bhmp;
import com.tencent.qphone.base.util.QLog;
import mwd;

public class TraeAudioSession
  extends BroadcastReceiver
{
  static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -9223372036854775808L;
  private Context jdField_a_of_type_AndroidContentContext;
  private bhmp jdField_a_of_type_Bhmp;
  private String jdField_a_of_type_JavaLangString = "DEVICE_NONE";
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  
  public TraeAudioSession(Context paramContext, bhmp parambhmp)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "TraeAudioSession create");
    }
    boolean bool;
    Object localObject;
    if (Process.myPid() == TraeAudioManager.e)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Long = a();
      this.jdField_a_of_type_Bhmp = parambhmp;
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      if ((paramContext == null) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder().append("AudioSession | Invalid parameters: ctx = ");
        if (paramContext != null) {
          break label182;
        }
        localObject = "null";
        label101:
        localObject = localStringBuilder.append((String)localObject).append("; cb = ");
        if (parambhmp != null) {
          break label189;
        }
      }
    }
    label182:
    label189:
    for (parambhmp = "null";; parambhmp = "{object}")
    {
      QLog.w("TRAE", 2, parambhmp);
      parambhmp = new IntentFilter();
      parambhmp.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
      parambhmp.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
      if ((paramContext != null) && (paramContext.registerReceiver(this, parambhmp) == null)) {}
      a(true);
      return;
      bool = false;
      break;
      localObject = "{object}";
      break label101;
    }
  }
  
  private int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a(paramBoolean, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidContentContext);
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_REGISTERAUDIOSESSION");
    localIntent.putExtra("REGISTERAUDIOSESSION_ISREGISTER", paramBoolean);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public static long a()
  {
    long l = Process.myPid();
    int i = jdField_a_of_type_Int + 1;
    jdField_a_of_type_Int = i;
    return (l << 32) + i;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.c("OPERATION_STOPSERVICE", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPSERVICE");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a("OPERATION_VOICECALL_PREPROCESS", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_PREPROCESS");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int a(long paramLong)
  {
    return TraeAudioManager.a(paramLong);
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean, int paramInt3, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a(paramLong, "OPERATION_STARTRING", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramInt1, paramInt2, paramUri, paramString1, paramBoolean, paramInt3, paramString2, false);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString1);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean);
    localIntent.putExtra("PARAM_RING_LOOPCOUNT", paramInt3);
    localIntent.putExtra("PARAM_RING_MODE", false);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", paramString2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    mwd.a(localIntent, paramLong);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean1, int paramInt3, String paramString2, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a(paramLong, "OPERATION_STARTRING", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramInt1, paramInt2, paramUri, paramString1, paramBoolean1, paramInt3, paramString2, paramBoolean2);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString1);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean1);
    localIntent.putExtra("PARAM_RING_LOOPCOUNT", paramInt3);
    localIntent.putExtra("PARAM_RING_MODE", paramBoolean2);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", paramString2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    mwd.a(localIntent, paramLong);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a(paramLong, "OPERATION_CONNECTDEVICE", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramString);
    }
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (paramString == null) || (paramString.length() <= 0)) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECTDEVICE");
    localIntent.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
    mwd.a(localIntent, paramLong);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int a(long paramLong, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a(paramLong, "OPERATION_STARTSERVICE", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramString1, paramString2);
    }
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (paramString1 == null) || (paramString1.length() <= 0)) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTSERVICE");
    localIntent.putExtra("EXTRA_DATA_DEVICECONFIG", paramString1);
    localIntent.putExtra("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON", paramString2);
    mwd.a(localIntent, paramLong);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  @Deprecated
  public int a(String paramString)
  {
    return a(0L, paramString);
  }
  
  @Deprecated
  public int a(String paramString1, String paramString2)
  {
    return a(0L, paramString1, paramString2);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null) {}
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this);
      label15:
      a(false);
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_Bhmp = null;
      return;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a("OPERATION_GETDEVICELIST", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETDEVICELIST");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.b("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_AUDIOPARAM_CHANGED");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int b(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.a(paramLong, "OPERATION_GETCONNECTEDDEVICE", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETCONNECTEDDEVICE");
    mwd.a(localIntent, paramLong);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.b("OPERATION_GETSTREAMTYPE", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETSTREAMTYPE");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int c(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.b(paramLong, "OPERATION_STOPRING", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPRING");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.d("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_Boolean) {
      return TraeAudioManager.g("OPERATION_VOICECALL_POSTROCESS", this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.jdField_a_of_type_Long);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_POSTROCESS");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    Object localObject;
    int j;
    long l2;
    boolean bool;
    label306:
    int i;
    label362:
    label1265:
    do
    {
      do
      {
        String str1;
        String str2;
        String str3;
        do
        {
          long l1;
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              for (;;)
                              {
                                return;
                                try
                                {
                                  paramContext = paramIntent.getAction();
                                  l1 = paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L);
                                  localObject = paramIntent.getStringExtra("PARAM_OPERATION");
                                  j = paramIntent.getIntExtra("PARAM_RES_ERRCODE", 0);
                                  l2 = mwd.a(paramIntent);
                                  if (QLog.isDevelopLevel()) {
                                    QLog.w("TraeAudioSession", 1, "onReceive, action[" + paramContext + "], nSessionId[" + l1 + "], strOperation[" + (String)localObject + "], errCode[" + j + "], seq[" + l2 + "]");
                                  }
                                  if (!"com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY".equals(paramContext)) {
                                    break label922;
                                  }
                                  if (!"NOTIFY_SERVICE_STATE".equals(localObject)) {
                                    break label306;
                                  }
                                  bool = paramIntent.getBooleanExtra("NOTIFY_SERVICE_STATE_DATE", false);
                                  if (QLog.isColorLevel()) {
                                    QLog.w("TraeAudioSession", 1, "onReceive.onServiceStateUpdate, on[" + bool + "], seq[" + l2 + "]");
                                  }
                                  if (this.jdField_a_of_type_Bhmp != null)
                                  {
                                    this.jdField_a_of_type_Bhmp.a(l2, bool);
                                    return;
                                  }
                                }
                                catch (Exception paramContext) {}
                              }
                            } while (!QLog.isColorLevel());
                            QLog.e("TRAE", 2, "AudioSession| nSessinId = " + this.jdField_a_of_type_Long + " onReceive::intent:" + paramIntent.toString() + " intent.getAction():" + paramIntent.getAction() + " Exception:" + paramContext.getMessage());
                            return;
                            if (!"NOTIFY_DEVICELISTUPDATE".equals(localObject)) {
                              break;
                            }
                            localObject = paramIntent.getStringArrayExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST");
                            str1 = paramIntent.getStringExtra("EXTRA_DATA_CONNECTEDDEVICE");
                            str2 = paramIntent.getStringExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE");
                            str3 = paramIntent.getStringExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME");
                            paramContext = "\n";
                            bool = true;
                            i = 0;
                            if (i < localObject.length)
                            {
                              paramContext = paramContext + "AudioSession|    " + i + " " + localObject[i] + "\n";
                              if (localObject[i].equals("DEVICE_WIREDHEADSET")) {
                                break label2007;
                              }
                              if (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET")) {
                                break label2010;
                              }
                              break label2007;
                            }
                            paramContext = paramContext + "\n";
                            if (QLog.isColorLevel()) {
                              QLog.w("TRAE", 2, "AudioSession|[onDeviceListUpdate]  connected:" + str1 + " prevConnected:" + str2 + " bt:" + str3 + " Num:" + localObject.length + paramContext);
                            }
                            this.b = bool;
                            this.jdField_a_of_type_JavaLangString = str1;
                          } while (this.jdField_a_of_type_Bhmp == null);
                          this.jdField_a_of_type_Bhmp.a(l2, (String[])localObject, str1, str2, str3);
                          return;
                          if (!"NOTIFY_DEVICECHANGABLE_UPDATE".equals(localObject)) {
                            break;
                          }
                          bool = paramIntent.getBooleanExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", true);
                          if (QLog.isColorLevel()) {
                            QLog.w("TraeAudioSession", 1, "onReceive.onDeviceChangabledUpdate, bIsChangabled[" + bool + "], seq[" + l2 + "]");
                          }
                        } while (this.jdField_a_of_type_Bhmp == null);
                        this.jdField_a_of_type_Bhmp.a(bool);
                        return;
                        if (!"NOTIFY_STREAMTYPE_UPDATE".equals(localObject)) {
                          break;
                        }
                        i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
                        if (QLog.isColorLevel()) {
                          QLog.w("TraeAudioSession", 1, "onReceive.NOTIFY_STREAMTYPE_UPDATE, errCode[" + j + "], st[" + i + "], seq[" + l2 + "]");
                        }
                      } while (this.jdField_a_of_type_Bhmp == null);
                      this.jdField_a_of_type_Bhmp.a(l2, i);
                      return;
                      if (!"NOTIFY_ROUTESWITCHSTART".equals(localObject)) {
                        break;
                      }
                      paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_FROM");
                      localObject = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_TO");
                    } while ((this.jdField_a_of_type_Bhmp == null) || (paramContext == null) || (localObject == null));
                    this.jdField_a_of_type_Bhmp.a(paramContext, (String)localObject);
                    return;
                    if (!"NOTIFY_ROUTESWITCHEND".equals(localObject)) {
                      break;
                    }
                    paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHEND_DEV");
                    l1 = paramIntent.getLongExtra("EXTRA_DATA_ROUTESWITCHEND_TIME", -1L);
                  } while ((this.jdField_a_of_type_Bhmp == null) || (paramContext == null) || (l1 == -1L));
                  this.jdField_a_of_type_Bhmp.a(paramContext, l1);
                  return;
                } while (!"NOTIFY_BEGIN_CONNECTED_DEVICE".equals(localObject));
                paramContext = paramIntent.getStringExtra("CONNECTDEVICE_DEVICENAME");
              } while (this.jdField_a_of_type_Bhmp == null);
              this.jdField_a_of_type_Bhmp.a(paramContext);
              return;
            } while (!"com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES".equals(paramContext));
            QLog.w("TraeAudioSession", 1, "ACTION_TRAEAUDIOMANAGER_RES, mSessionId[" + this.jdField_a_of_type_Long + "], nSessionId[" + l1 + "], strOperation[" + (String)localObject + "], seq[" + l2 + "]");
          } while (this.jdField_a_of_type_Long != l1);
          if (!"OPERATION_GETDEVICELIST".equals(localObject)) {
            break;
          }
          localObject = paramIntent.getStringArrayExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST");
          str1 = paramIntent.getStringExtra("EXTRA_DATA_CONNECTEDDEVICE");
          str2 = paramIntent.getStringExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE");
          str3 = paramIntent.getStringExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME");
          paramContext = "\n";
          bool = true;
          i = 0;
          if (i < localObject.length)
          {
            paramContext = paramContext + "AudioSession|    " + i + " " + localObject[i] + "\n";
            if (localObject[i].equals("DEVICE_WIREDHEADSET")) {
              break label2017;
            }
            if (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET")) {
              break label2020;
            }
            break label2017;
          }
          paramContext = paramContext + "\n";
          this.b = bool;
          this.jdField_a_of_type_JavaLangString = str1;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("OPERATION_GETDEVICELIST, errCode[").append(j).append("], connected[").append(str1).append("], prevConnected[").append(str2).append("], bt[").append(str3).append("], Num[").append(localObject.length).append("], mCallback[");
            if (this.jdField_a_of_type_Bhmp == null) {
              break label2027;
            }
            bool = true;
            QLog.w("TraeAudioSession", 1, bool + "], seq[" + l2 + "], str[" + paramContext + "]");
          }
        } while (this.jdField_a_of_type_Bhmp == null);
        this.jdField_a_of_type_Bhmp.a(j, (String[])localObject, str1, str2, str3);
        return;
        if (!"OPERATION_CONNECTDEVICE".equals(localObject)) {
          break;
        }
        paramContext = paramIntent.getStringExtra("CONNECTDEVICE_RESULT_DEVICENAME");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + j + " dev:" + paramContext);
        }
      } while (this.jdField_a_of_type_Bhmp == null);
      localObject = this.jdField_a_of_type_Bhmp;
      if (j != 0) {
        break label2033;
      }
      bool = true;
      ((bhmp)localObject).a(j, paramContext, bool);
      return;
      if (!"OPERATION_EARACTION".equals(localObject)) {
        break;
      }
      i = paramIntent.getIntExtra("EXTRA_EARACTION", -1);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + j + " earAction:" + i);
      }
    } while (this.jdField_a_of_type_Bhmp == null);
    label922:
    label1065:
    return;
    label1418:
    if ("OPERATION_ISDEVICECHANGABLED".equals(localObject))
    {
      bool = paramIntent.getBooleanExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("AudioSession|[onIsDeviceChangabledRes] err:").append(j).append(" Changabled:");
        if (!bool) {
          break label2039;
        }
      }
    }
    label2007:
    label2010:
    label2017:
    label2020:
    label2027:
    label2033:
    label2039:
    for (paramContext = "Y";; paramContext = "N")
    {
      QLog.w("TRAE", 2, paramContext);
      if (this.jdField_a_of_type_Bhmp == null) {
        break;
      }
      this.jdField_a_of_type_Bhmp.a(j, bool);
      return;
      if ("OPERATION_GETCONNECTEDDEVICE".equals(localObject))
      {
        paramContext = paramIntent.getStringExtra("GETCONNECTEDDEVICE_REULT_LIST");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onGetConnectedDeviceRes] err:" + j + " dev:" + paramContext);
        }
        if (this.jdField_a_of_type_Bhmp == null) {
          break;
        }
        this.jdField_a_of_type_Bhmp.a(j, paramContext);
        return;
      }
      if ("OPERATION_GETCONNECTINGDEVICE".equals(localObject))
      {
        paramContext = paramIntent.getStringExtra("GETCONNECTINGDEVICE_REULT_LIST");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onGetConnectingDeviceRes] err:" + j + " dev:" + paramContext);
        }
        if (this.jdField_a_of_type_Bhmp == null) {
          break;
        }
        this.jdField_a_of_type_Bhmp.b(j, paramContext);
        return;
      }
      if ("OPERATION_GETSTREAMTYPE".equals(localObject))
      {
        i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onGetStreamTypeRes] err:" + j + " st:" + i);
        }
        if (this.jdField_a_of_type_Bhmp == null) {
          break;
        }
        this.jdField_a_of_type_Bhmp.a(j, i);
        return;
      }
      if ("NOTIFY_RING_COMPLETION".equals(localObject))
      {
        paramContext = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 1, "\"AudioSession|[onRingCompletion], errCode[" + j + "], userData[" + paramContext + "], seq[" + l2 + "]");
        }
        if (this.jdField_a_of_type_Bhmp == null) {
          break;
        }
        this.jdField_a_of_type_Bhmp.a(l2, j, paramContext);
        return;
      }
      if (!"OPERATION_VOICECALL_PREPROCESS".equals(localObject)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "AudioSession|[onVoicecallPreprocess] err:" + j);
      }
      if (this.jdField_a_of_type_Bhmp == null) {
        break;
      }
      this.jdField_a_of_type_Bhmp.a(j);
      return;
      bool = false;
      i += 1;
      break label362;
      bool = false;
      i += 1;
      break label1065;
      bool = false;
      break label1265;
      bool = false;
      break label1418;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioSession
 * JD-Core Version:    0.7.0.1
 */