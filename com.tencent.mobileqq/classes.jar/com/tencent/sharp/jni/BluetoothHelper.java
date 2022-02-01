package com.tencent.sharp.jni;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class BluetoothHelper
  implements BluetoothProfile.ServiceListener
{
  private static final String jdField_a_of_type_JavaLangString = "BluetoothHelper";
  private volatile int jdField_a_of_type_Int = 1;
  private BluetoothAdapter jdField_a_of_type_AndroidBluetoothBluetoothAdapter = null;
  private BluetoothProfile jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
  private BluetoothHelper.IStateChangeListener jdField_a_of_type_ComTencentSharpJniBluetoothHelper$IStateChangeListener = null;
  private DeviceConfigManager jdField_a_of_type_ComTencentSharpJniDeviceConfigManager = DeviceConfigManager.a();
  public volatile boolean a;
  
  public BluetoothHelper()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  static String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknown";
      break;
    case 13: 
      str = "STATE_TURNING_OFF";
      break;
    case 12: 
      str = "STATE_ON";
      break;
    case 11: 
      str = "STATE_TURNING_ON";
      break;
    case 10: 
      str = "STATE_OFF";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  static void a(IntentFilter paramIntentFilter)
  {
    paramIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    paramIntentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
    paramIntentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
    paramIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    paramIntentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
    paramIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
    paramIntentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
  }
  
  static String b(int paramInt)
  {
    String str;
    if (paramInt != -1)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            str = "unknown";
          } else {
            str = "SCO_AUDIO_STATE_CONNECTING";
          }
        }
        else {
          str = "SCO_AUDIO_STATE_CONNECTED";
        }
      }
      else {
        str = "SCO_AUDIO_STATE_DISCONNECTED";
      }
    }
    else {
      str = "SCO_AUDIO_STATE_ERROR";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  static String c(int paramInt)
  {
    String str;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            str = "unknown";
          } else {
            str = "STATE_DISCONNECTING";
          }
        }
        else {
          str = "STATE_CONNECTED";
        }
      }
      else {
        str = "STATE_CONNECTING";
      }
    }
    else {
      str = "STATE_DISCONNECTED";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null)
      {
        if (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) {
          this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        }
        this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
        return;
      }
    }
    catch (Exception localException)
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" release exception[");
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Intent paramIntent)
  {
    int i;
    int j;
    Object localObject1;
    if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
      j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
      if (QLog.isColorLevel())
      {
        paramIntent = jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("receive BluetoothAdapter.ACTION_STATE_CHANGED[");
        ((StringBuilder)localObject1).append(a(i));
        ((StringBuilder)localObject1).append(" <- ");
        ((StringBuilder)localObject1).append(a(j));
        ((StringBuilder)localObject1).append("]");
        QLog.w(paramIntent, 2, ((StringBuilder)localObject1).toString());
      }
      if (i == 10)
      {
        this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a("DEVICE_BLUETOOTH_HEADSET", false);
        return;
      }
      if (i == 12) {
        this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a("DEVICE_BLUETOOTH_HEADSET", true);
      }
    }
    else
    {
      boolean bool = "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction());
      localObject1 = "unknown";
      Object localObject2;
      Object localObject3;
      if (bool)
      {
        i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
        j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
        localObject2 = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (QLog.isColorLevel())
        {
          localObject3 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("receive BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED[");
          localStringBuilder.append(c(i));
          localStringBuilder.append(" <- ");
          localStringBuilder.append(c(j));
          localStringBuilder.append("], device[");
          if (localObject2 != null) {
            paramIntent = ((BluetoothDevice)localObject2).getName();
          } else {
            paramIntent = "unknown";
          }
          localStringBuilder.append(paramIntent);
          localStringBuilder.append("]");
          QLog.w((String)localObject3, 2, localStringBuilder.toString());
        }
        if (i == 2)
        {
          this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a("DEVICE_BLUETOOTH_HEADSET", true);
          paramIntent = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager;
          if (localObject2 != null) {
            localObject1 = ((BluetoothDevice)localObject2).getName();
          }
          paramIntent.a((String)localObject1);
          return;
        }
        if (i == 0) {
          this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a("DEVICE_BLUETOOTH_HEADSET", false);
        }
      }
      else
      {
        if ("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(paramIntent.getAction()))
        {
          i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
          if (QLog.isColorLevel())
          {
            paramIntent = jdField_a_of_type_JavaLangString;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("receive BluetoothHeadset.ACTION_AUDIO_STATE_CHANGED[");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("]");
            QLog.w(paramIntent, 2, ((StringBuilder)localObject1).toString());
          }
          if (i == 12) {
            this.jdField_a_of_type_Int = 5;
          } else if (i == 10) {
            if (this.jdField_a_of_type_Boolean)
            {
              if (QLog.isColorLevel()) {
                QLog.i(jdField_a_of_type_JavaLangString, 2, "self stop bluetooth");
              }
              this.jdField_a_of_type_Int = 3;
            }
            else
            {
              this.jdField_a_of_type_Int = 1;
              this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a("DEVICE_BLUETOOTH_HEADSET", false);
            }
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()))
        {
          i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
          if (QLog.isColorLevel())
          {
            paramIntent = jdField_a_of_type_JavaLangString;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("receive BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED[");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("]");
            QLog.w(paramIntent, 2, ((StringBuilder)localObject1).toString());
          }
          if (i != 0)
          {
            if (i != 2) {
              return;
            }
            this.jdField_a_of_type_Int = 2;
            this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a("DEVICE_BLUETOOTH_HEADSET", true);
            return;
          }
          this.jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a("DEVICE_BLUETOOTH_HEADSET", false);
          return;
        }
        if ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(paramIntent.getAction()))
        {
          i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
          j = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
          localObject3 = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
          bool = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c("DEVICE_BLUETOOTH_HEADSET");
          if (QLog.isColorLevel())
          {
            paramIntent = jdField_a_of_type_JavaLangString;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("receive AudioManager.ACTION_SCO_AUDIO_STATE_UPDATED[");
            ((StringBuilder)localObject2).append(b(i));
            ((StringBuilder)localObject2).append(" <- ");
            ((StringBuilder)localObject2).append(b(j));
            ((StringBuilder)localObject2).append("], device[");
            if (localObject3 != null) {
              localObject1 = ((BluetoothDevice)localObject3).getName();
            }
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("] , visible[");
            ((StringBuilder)localObject2).append(bool);
            ((StringBuilder)localObject2).append("]");
            QLog.w(paramIntent, 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_AndroidBluetoothBluetoothProfile;
    if (localObject != null) {
      try
      {
        localObject = ((BluetoothProfile)localObject).getConnectedDevices();
        if (localObject != null)
        {
          boolean bool = ((List)localObject).isEmpty();
          if (!bool) {
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isConnected exception[");
        localStringBuilder.append(localException.getMessage());
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public boolean a(Context paramContext, BluetoothHelper.IStateChangeListener paramIStateChangeListener)
  {
    Object localObject;
    if (paramContext != null)
    {
      localObject = BluetoothAdapter.getDefaultAdapter();
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter = ((BluetoothAdapter)localObject);
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper$IStateChangeListener = paramIStateChangeListener;
        if (paramIStateChangeListener != null)
        {
          if ((this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.isEnabled()) && (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile == null) && (!this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.getProfileProxy(paramContext, this, 1)))
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "init err, getProfileProxy HEADSET fail");
            }
            return false;
          }
          return true;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramIStateChangeListener = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init err, mContext[");
      ((StringBuilder)localObject).append(paramContext);
      paramContext = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("], mBluetoothAdapter[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter);
      ((StringBuilder)localObject).append("], mStateChangeListener[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper$IStateChangeListener);
      ((StringBuilder)localObject).append("]");
      QLog.e(paramIStateChangeListener, 2, new Object[] { paramContext, ((StringBuilder)localObject).toString() });
    }
    return false;
  }
  
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    if (paramInt == 1)
    {
      Object localObject = this.jdField_a_of_type_AndroidBluetoothBluetoothProfile;
      if ((localObject != null) && (localObject != paramBluetoothProfile))
      {
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onServiceConnected: HEADSET connected proxy[");
          localStringBuilder.append(paramBluetoothProfile);
          localStringBuilder.append("], profile[");
          localStringBuilder.append(this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
          localStringBuilder.append("]");
          QLog.w((String)localObject, 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
      }
      this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = paramBluetoothProfile;
      ThreadManager.post(new BluetoothHelper.1(this), 5, null, false);
    }
  }
  
  public void onServiceDisconnected(int paramInt)
  {
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "onServiceDisconnected");
      }
      if (a()) {
        this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper$IStateChangeListener.a(false);
      }
      BluetoothProfile localBluetoothProfile = this.jdField_a_of_type_AndroidBluetoothBluetoothProfile;
      if (localBluetoothProfile != null)
      {
        this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, localBluetoothProfile);
        this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.sharp.jni.BluetoothHelper
 * JD-Core Version:    0.7.0.1
 */