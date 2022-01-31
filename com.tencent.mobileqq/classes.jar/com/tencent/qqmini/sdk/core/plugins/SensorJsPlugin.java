package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Vibrator;
import bdcy;
import bdcz;
import bdew;
import bdfz;
import bdgi;
import bdnw;
import java.util.List;

public class SensorJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_ACCELEROMETER_STATE_CHANGE = "onAccelerometerChange";
  public static final String EVENT_COMPASS_STATE_CHANGE = "onCompassChange";
  public static final String EVENT_DEVICE_MOTION_STATE_CHANGE = "onDeviceMotionChange";
  public static final String EVENT_GYROSCOPE_STATE_CHANGE = "onGyroscopeChange";
  private static final String TAG = "SensorJsPlugin";
  private Sensor gyroscopeSensor;
  private SensorJsPlugin.GyroscopeSensorJsPlugin gyroscopeSensorJsPlugin;
  private boolean hasEnableDeviceMotionChangeListening;
  private boolean hasEnableGyroscope;
  private boolean mIsGetCompass;
  private Sensor magneticSensor;
  private SensorJsPlugin.MiniAppSensorJsPlugin miniAppSensorJsPlugin;
  private Sensor orientationSensor;
  private SensorJsPlugin.RotationSensorJsPlugin orientationSensorJsPlugin;
  private Sensor senAccelerometer;
  private SensorManager senSensorManager;
  private Vibrator vibrator;
  
  private void doVibrate(long paramLong)
  {
    try
    {
      if (this.vibrator != null) {
        this.vibrator.vibrate(paramLong);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("SensorJsPlugin", "exception when doVibrate.", localThrowable);
    }
  }
  
  private void initSensor()
  {
    if (this.senSensorManager == null)
    {
      this.senSensorManager = ((SensorManager)this.mContext.getSystemService("sensor"));
      this.magneticSensor = this.senSensorManager.getDefaultSensor(2);
      this.gyroscopeSensor = this.senSensorManager.getDefaultSensor(4);
      this.orientationSensor = this.senSensorManager.getDefaultSensor(3);
    }
    if (this.vibrator == null) {
      this.vibrator = ((Vibrator)this.mContext.getSystemService("vibrator"));
    }
    if (this.senAccelerometer == null)
    {
      List localList = this.senSensorManager.getSensorList(1);
      if (localList.size() > 0) {
        this.senAccelerometer = ((Sensor)localList.get(0));
      }
    }
  }
  
  public String enableAccelerometer(bdfz parambdfz)
  {
    bdgi.a(new SensorJsPlugin.1(this, parambdfz));
    return "";
  }
  
  public String enableCompass(bdfz parambdfz)
  {
    bdgi.a(new SensorJsPlugin.2(this, parambdfz));
    return "";
  }
  
  public String enableDeviceMotionChangeListening(bdfz parambdfz)
  {
    bdgi.a(new SensorJsPlugin.4(this, parambdfz));
    return "";
  }
  
  public String enableGyroscope(bdfz parambdfz)
  {
    bdgi.a(new SensorJsPlugin.3(this, parambdfz));
    return "";
  }
  
  public void onCreate(bdcz parambdcz)
  {
    super.onCreate(parambdcz);
  }
  
  public final boolean startAccelerometer(bdcy parambdcy, int paramInt)
  {
    if (this.senSensorManager == null) {}
    while (this.senAccelerometer == null) {
      return false;
    }
    if (this.miniAppSensorJsPlugin != null) {
      stopAccelerometer();
    }
    this.miniAppSensorJsPlugin = new SensorJsPlugin.MiniAppSensorJsPlugin(this, null);
    this.senSensorManager.registerListener(this.miniAppSensorJsPlugin, this.senAccelerometer, paramInt);
    this.senSensorManager.registerListener(this.miniAppSensorJsPlugin, this.magneticSensor, paramInt);
    this.senSensorManager.registerListener(this.miniAppSensorJsPlugin, this.gyroscopeSensor, paramInt);
    return true;
  }
  
  public final boolean startGyroscope(bdcy parambdcy, int paramInt)
  {
    if ((this.senSensorManager == null) || (this.gyroscopeSensor == null)) {
      return false;
    }
    if (this.gyroscopeSensorJsPlugin != null) {
      stopGyroscope();
    }
    this.gyroscopeSensorJsPlugin = new SensorJsPlugin.GyroscopeSensorJsPlugin(this, null);
    this.senSensorManager.registerListener(this.gyroscopeSensorJsPlugin, this.gyroscopeSensor, paramInt);
    return true;
  }
  
  public final boolean startRotationListening(bdcy parambdcy, int paramInt)
  {
    if ((this.senSensorManager == null) || (this.orientationSensor == null)) {
      return false;
    }
    if (this.orientationSensorJsPlugin != null) {
      stopRotationListening();
    }
    this.orientationSensorJsPlugin = new SensorJsPlugin.RotationSensorJsPlugin(this, null);
    this.orientationSensorJsPlugin.setJsService(parambdcy);
    this.senSensorManager.registerListener(this.orientationSensorJsPlugin, this.orientationSensor, paramInt);
    return true;
  }
  
  public final void stopAccelerometer()
  {
    if ((this.senSensorManager != null) && (this.miniAppSensorJsPlugin != null))
    {
      this.senSensorManager.unregisterListener(this.miniAppSensorJsPlugin);
      this.miniAppSensorJsPlugin = null;
    }
  }
  
  public final void stopGyroscope()
  {
    if ((this.senSensorManager != null) && (this.gyroscopeSensorJsPlugin != null))
    {
      this.senSensorManager.unregisterListener(this.gyroscopeSensorJsPlugin);
      this.gyroscopeSensorJsPlugin = null;
    }
  }
  
  public final void stopRotationListening()
  {
    if ((this.senSensorManager != null) && (this.orientationSensorJsPlugin != null))
    {
      this.senSensorManager.unregisterListener(this.orientationSensorJsPlugin);
      this.orientationSensorJsPlugin = null;
    }
  }
  
  public String vibrateLong(bdfz parambdfz)
  {
    initSensor();
    bdew.a(new SensorJsPlugin.6(this), 16, null, true);
    parambdfz.a();
    return "";
  }
  
  public String vibrateShort(bdfz parambdfz)
  {
    initSensor();
    bdew.a(new SensorJsPlugin.5(this), 16, null, true);
    parambdfz.a();
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SensorJsPlugin
 * JD-Core Version:    0.7.0.1
 */