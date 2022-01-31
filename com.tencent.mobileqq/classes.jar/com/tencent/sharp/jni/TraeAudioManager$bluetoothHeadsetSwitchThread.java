package com.tencent.sharp.jni;

import android.media.AudioManager;
import android.os.Build.VERSION;
import bhmk;
import com.tencent.qphone.base.util.QLog;

class TraeAudioManager$bluetoothHeadsetSwitchThread
  extends TraeAudioManager.switchThread
{
  TraeAudioManager$bluetoothHeadsetSwitchThread(TraeAudioManager paramTraeAudioManager, long paramLong)
  {
    super(paramTraeAudioManager, paramLong);
  }
  
  public String a()
  {
    return "DEVICE_BLUETOOTHHEADSET";
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 2, "bluetoothHeadsetSwitchThread start connect 1000.,sBluetoothDelayTime: " + TraeAudioManager.a());
      }
      Thread.sleep(1000L);
    }
    catch (InterruptedException localInterruptedException4)
    {
      for (;;)
      {
        int i;
        int n;
        label371:
        continue;
        label437:
        label444:
        int j = n;
        continue;
        int m = 0;
        continue;
        int k = 0;
      }
    }
    if (TraeAudioManager.a(this.this$0) == 7)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread, WIREDHEADSET plugout, bluetoothState == Bluetooth_State.SCO_CONNECTED force to HEADSET_AVAILABLE, reconnect");
      }
      TraeAudioManager.a(this.this$0, 4);
    }
    i = 0;
    while (TraeAudioManager.a(this.this$0) != 4)
    {
      j = i + 1;
      if (i >= 10) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread waiting Bluetooth_State HEADSET_AVAILABLE, " + TraeAudioManager.a(this.this$0));
      }
      try
      {
        Thread.sleep(1000L);
        i = j;
      }
      catch (InterruptedException localInterruptedException1)
      {
        i = j;
      }
    }
    if (TraeAudioManager.a(this.this$0) != 4)
    {
      k = 1;
      if ((k == 0) && (this.jdField_a_of_type_Boolean == true))
      {
        TraeAudioManager.a(this.this$0, 6);
        c();
        QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread _startBluetoothSco");
        m = 1;
        i = 0;
        j = 0;
        for (;;)
        {
          String str;
          if (this.jdField_a_of_type_Boolean == true)
          {
            n = j + 1;
            if ((j < 5) && (k == 0))
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("bluetoothHeadsetSwitchThread ");
                localStringBuilder.append("i:");
                localStringBuilder.append(n);
                localStringBuilder.append(" sco:");
                if (!this.this$0.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()) {
                  break label437;
                }
                str = "Y";
                localStringBuilder.append(str);
                localStringBuilder.append(" :");
                localStringBuilder.append(this.this$0.jdField_a_of_type_Bhmk.a());
                localStringBuilder.append("\n");
                QLog.w(this.jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
              }
              if (TraeAudioManager.a(this.this$0) != 7) {
                break label444;
              }
              QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread bluetoothState ==  Bluetooth_State.SCO_CONNECTED 1");
              e();
            }
          }
          do
          {
            for (;;)
            {
              if (TraeAudioManager.a(this.this$0) != 7)
              {
                if ((QLog.isColorLevel()) && (k == 0)) {
                  QLog.e(this.jdField_a_of_type_JavaLangString, 2, "bluetoothHeadsetSwitchThread sco fail,remove btheadset");
                }
                this.this$0.jdField_a_of_type_Bhmk.a(a(), false);
                a(10);
                this.this$0.a(this.jdField_a_of_type_Long);
              }
              return;
              str = "N";
              break;
              try
              {
                Thread.sleep(3000L);
                if (TraeAudioManager.a(this.this$0) == 7)
                {
                  QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread bluetoothState ==  Bluetooth_State.SCO_CONNECTED 2");
                  e();
                }
              }
              catch (InterruptedException localInterruptedException2)
              {
                for (;;)
                {
                  QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread InterruptedException 1");
                  i = 1;
                }
              }
            }
          } while (i != 0);
          if (m == 1)
          {
            d();
            try
            {
              Thread.sleep(1000L);
              if (i != 0) {
                break label371;
              }
              c();
              QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread retry start sco");
              j = n;
            }
            catch (InterruptedException localInterruptedException3)
            {
              for (;;)
              {
                QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread InterruptedException 2");
                i = 1;
              }
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (this.this$0.jdField_a_of_type_AndroidMediaAudioManager == null) {
      return;
    }
    d();
  }
  
  void c()
  {
    try
    {
      this.this$0.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(true);
      if (Build.VERSION.SDK_INT > 8) {
        this.this$0.jdField_a_of_type_AndroidMediaAudioManager.startBluetoothSco();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  void d()
  {
    if (Build.VERSION.SDK_INT > 8) {
      this.this$0.jdField_a_of_type_AndroidMediaAudioManager.stopBluetoothSco();
    }
    this.this$0.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.bluetoothHeadsetSwitchThread
 * JD-Core Version:    0.7.0.1
 */