package com.tencent.sharp.jni;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.av.utils.SeqUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TraeAudioManager$BluetoothHeadsetCheck
  extends TraeAudioManager.BluetoothHeadsetCheckInterface
  implements BluetoothProfile.ServiceListener
{
  BluetoothAdapter jdField_a_of_type_AndroidBluetoothBluetoothAdapter = null;
  BluetoothProfile jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
  Context jdField_a_of_type_AndroidContentContext = null;
  TraeAudioManager.DeviceConfigManager jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager = null;
  final String jdField_a_of_type_JavaLangString = "BluetoothHeadsetCheck";
  
  TraeAudioManager$BluetoothHeadsetCheck(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public String a()
  {
    return "BluetoothHeadsetCheck";
  }
  
  public void a()
  {
    AudioDeviceInterface.LogTraceEntry("_profile:" + this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
    try
    {
      if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null)
      {
        if (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) {
          this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        }
        this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
      }
      AudioDeviceInterface.LogTraceExit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("BluetoothHeadsetCheck", 2, " closeProfileProxy:e:" + localException.getMessage());
        }
      }
    }
  }
  
  void a(Context paramContext, Intent paramIntent)
  {
    long l = SeqUtil.a(paramIntent);
    int i;
    if ("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
      if (QLog.isColorLevel()) {
        QLog.w("BluetoothHeadsetCheck", 1, "_onReceive.ACTION_AUDIO_STATE_CHANGED, state[" + i + "], bluetoothState[" + TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager) + "], seq[" + l + "]");
      }
      if (i == 12) {
        if (TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager) == 6) {
          QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread ACTION_AUDIO_STATE_CHANGED +++ Bluetooth audio SCO is now connected, SCO_CONNECTED");
        }
      }
    }
    label124:
    int j;
    label478:
    boolean bool;
    label537:
    label543:
    do
    {
      do
      {
        do
        {
          do
          {
            TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, 7);
            break label124;
            break label124;
            do
            {
              do
              {
                return;
              } while ((i == 11) || (i != 10));
              QLog.w("TRAE", 2, "ACTION_AUDIO_STATE_CHANGED +++ Bluetooth audio SCO is STATE_AUDIO_DISCONNECTED");
              TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, 8);
              return;
              if (!"android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction())) {
                break;
              }
              switch (paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1))
              {
              case 1: 
              default: 
                return;
              case 0: 
                TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, 3);
                this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET", false);
              }
            } while (!QLog.isColorLevel());
            QLog.w("TRAE", 2, "jeringtest BluetoothHeadset ACTION_CONNECTION_STATE_CHANGED BluetoothProfile.STATE_DISCONNECTED");
            return;
            TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, 4);
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET", true);
          } while (!QLog.isColorLevel());
          QLog.w("TRAE", 2, "jeringtest  BluetoothHeadset ACTION_CONNECTION_STATE_CHANGED BluetoothProfile.STATE_CONNECTED");
          return;
          if (!"android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction())) {
            break;
          }
          i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
          j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
          paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
          Object localObject;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuffer(100);
            ((StringBuffer)localObject).append("_onReceive BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE " + c(i));
            ((StringBuffer)localObject).append("    EXTRA_PREVIOUS_CONNECTION_STATE " + c(j));
            StringBuilder localStringBuilder = new StringBuilder().append("    EXTRA_DEVICE ").append(paramIntent).append(" ");
            if (paramIntent != null)
            {
              paramContext = paramIntent.getName();
              ((StringBuffer)localObject).append(paramContext);
              QLog.w("BluetoothHeadsetCheck", 2, ((StringBuffer)localObject).toString());
            }
          }
          else
          {
            if (i != 2) {
              continue;
            }
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("   dev:");
              if (paramIntent == null) {
                break label537;
              }
              paramContext = paramIntent.getName();
              QLog.w("BluetoothHeadsetCheck", 2, paramContext + " connected,start sco...");
            }
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET", true);
            localObject = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager;
            if (paramIntent == null) {
              break label543;
            }
          }
          for (paramContext = paramIntent.getName();; paramContext = "unkown")
          {
            ((TraeAudioManager.DeviceConfigManager)localObject).a(paramContext);
            return;
            paramContext = " ";
            break;
            paramContext = "null";
            break label478;
          }
        } while (i != 0);
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET", false);
        return;
      } while (!"android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(paramIntent.getAction()));
      i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      j = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
      paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      bool = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b("DEVICE_BLUETOOTHHEADSET");
    } while (!QLog.isColorLevel());
    paramIntent = new StringBuffer(100);
    paramIntent.append("_onReceive BT ACTION_SCO_AUDIO_STATE_UPDATED |   EXTRA_CONNECTION_STATE dev: ");
    if (paramContext == null) {}
    for (paramContext = "null";; paramContext = paramContext.toString())
    {
      paramIntent.append(paramContext);
      paramIntent.append(" | EXTRA_SCO_AUDIO_STATE ");
      paramIntent.append(b(i));
      paramIntent.append(" | Bluetooth visible:" + bool);
      paramIntent.append(" | EXTRA_SCO_AUDIO_PREVIOUS_STATE " + b(j));
      QLog.w("BluetoothHeadsetCheck", 2, paramIntent.toString());
      return;
    }
  }
  
  void a(IntentFilter paramIntentFilter)
  {
    if (QLog.isColorLevel()) {
      QLog.w("BluetoothHeadsetCheck", 2, " " + a() + " _addAction");
    }
    paramIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    paramIntentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
    paramIntentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
    paramIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) {
      try
      {
        List localList = this.jdField_a_of_type_AndroidBluetoothBluetoothProfile.getConnectedDevices();
        if (localList == null) {
          return false;
        }
        int i = localList.size();
        if (i > 0) {
          return true;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BluetoothHeadsetCheck", 2, " isConnected e = " + localException);
        }
      }
    }
    return false;
  }
  
  public boolean a(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramContext == null) || (paramDeviceConfigManager == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("BluetoothHeadsetCheck", 2, " err ctx==null||_devCfg==null");
      }
    }
    do
    {
      do
      {
        return false;
        this.jdField_a_of_type_AndroidContentContext = paramContext;
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager = paramDeviceConfigManager;
        this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("BluetoothHeadsetCheck", 2, " err getDefaultAdapter fail!");
      return false;
      if ((!this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.isEnabled()) || (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) || (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.getProfileProxy(this.jdField_a_of_type_AndroidContentContext, this, 1))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("BluetoothHeadsetCheck", 2, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
    return false;
    AudioDeviceInterface.LogTraceExit();
    return true;
  }
  
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    if (paramInt == 1)
    {
      if ((this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) && (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != paramBluetoothProfile))
      {
        if (QLog.isColorLevel()) {
          QLog.w("BluetoothHeadsetCheck", 2, "BluetoothHeadsetCheck: HEADSET Connected proxy:" + paramBluetoothProfile + " _profile:" + this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        }
        this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
      }
      this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = paramBluetoothProfile;
      ThreadManager.post(new TraeAudioManager.BluetoothHeadsetCheck.1(this), 5, null, false);
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void onServiceDisconnected(int paramInt)
  {
    AudioDeviceInterface.LogTraceEntry("_profile:" + this.jdField_a_of_type_AndroidBluetoothBluetoothProfile + " profile:" + paramInt);
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("BluetoothHeadsetCheck", 2, "TRAEBluetoothProxy: HEADSET Disconnected");
      }
      if (a()) {
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a("DEVICE_BLUETOOTHHEADSET", false);
      }
      if (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null)
      {
        this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
      }
    }
    AudioDeviceInterface.LogTraceExit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.BluetoothHeadsetCheck
 * JD-Core Version:    0.7.0.1
 */