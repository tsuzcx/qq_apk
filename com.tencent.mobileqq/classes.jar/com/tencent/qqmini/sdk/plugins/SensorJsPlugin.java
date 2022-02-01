package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Vibrator;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import org.json.JSONObject;

@JsPlugin
public class SensorJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_ACCELEROMETER_STATE_CHANGE = "onAccelerometerChange";
  public static final String EVENT_COMPASS_STATE_CHANGE = "onCompassChange";
  public static final String EVENT_DEVICE_MOTION_STATE_CHANGE = "onDeviceMotionChange";
  public static final String EVENT_GYROSCOPE_STATE_CHANGE = "onGyroscopeChange";
  public static final String SENSOR_INTERVAL_GAME = "game";
  public static final int SENSOR_INTERVAL_GAME_NUMBER = 20;
  public static final String SENSOR_INTERVAL_NORMAL = "normal";
  public static final int SENSOR_INTERVAL_NORMAL_NUMBER = 200;
  public static final String SENSOR_INTERVAL_UI = "ui";
  public static final int SENSOR_INTERVAL_UI_NUMBER = 60;
  private static final String TAG = "SensorJsPlugin";
  private Sensor accelerometerSensor;
  private SensorJsPlugin.AccelerometerSensorJsPlugin accelerometerSensorJsPlugin;
  private SensorJsPlugin.CompassSensorJsPlugin compassSensorJsPlugin;
  private Sensor gyroscopeSensor;
  private SensorJsPlugin.GyroscopeSensorJsPlugin gyroscopeSensorJsPlugin;
  private boolean mIsPause;
  private Sensor magneticSensor;
  private Sensor orientationSensor;
  private SensorJsPlugin.RotationSensorJsPlugin orientationSensorJsPlugin;
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
      QMLog.e("SensorJsPlugin", "exception when doVibrate.", localThrowable);
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
    if (this.accelerometerSensor == null)
    {
      List localList = this.senSensorManager.getSensorList(1);
      if (localList.size() > 0) {
        this.accelerometerSensor = ((Sensor)localList.get(0));
      }
    }
  }
  
  @JsEvent({"enableAccelerometer"})
  public String enableAccelerometer(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new SensorJsPlugin.1(this, paramRequestEvent));
    return "";
  }
  
  @JsEvent({"enableCompass"})
  public String enableCompass(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new SensorJsPlugin.2(this, paramRequestEvent));
    return "";
  }
  
  @JsEvent({"enableDeviceMotionChangeListening"})
  public String enableDeviceMotionChangeListening(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new SensorJsPlugin.4(this, paramRequestEvent));
    return "";
  }
  
  @JsEvent({"enableGyroscope"})
  public String enableGyroscope(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new SensorJsPlugin.3(this, paramRequestEvent));
    return "";
  }
  
  public int getInterval(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("interval");
    int i = paramJSONObject.optInt("interval", -1);
    if (i == -1) {
      if (!"game".equals(str)) {}
    }
    while (i == 20)
    {
      return 1;
      if ("ui".equals(str)) {
        return 2;
      }
      if (!"normal".equals(str)) {
        break;
      }
      return 3;
    }
    if (i == 60) {
      return 2;
    }
    if (i == 200) {
      return 3;
    }
    return 3;
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    stopAccelerometer();
    stopCompass();
    stopGyroscope();
    stopRotationListening();
  }
  
  public void onPause()
  {
    super.onPause();
    this.mIsPause = true;
  }
  
  public void onResume()
  {
    super.onResume();
    this.mIsPause = false;
  }
  
  public final boolean startAccelerometer(IJsService paramIJsService, int paramInt)
  {
    if ((this.senSensorManager == null) || (this.accelerometerSensor == null)) {
      return false;
    }
    if (this.accelerometerSensorJsPlugin != null) {
      stopAccelerometer();
    }
    this.accelerometerSensorJsPlugin = new SensorJsPlugin.AccelerometerSensorJsPlugin(this, paramIJsService);
    return this.senSensorManager.registerListener(this.accelerometerSensorJsPlugin, this.accelerometerSensor, paramInt);
  }
  
  public final boolean startCompass(IJsService paramIJsService, int paramInt)
  {
    if ((this.senSensorManager == null) || (this.accelerometerSensor == null) || (this.magneticSensor == null)) {}
    do
    {
      return false;
      if (this.compassSensorJsPlugin != null) {
        stopAccelerometer();
      }
      this.compassSensorJsPlugin = new SensorJsPlugin.CompassSensorJsPlugin(this, paramIJsService);
    } while ((!this.senSensorManager.registerListener(this.compassSensorJsPlugin, this.accelerometerSensor, paramInt)) || (!this.senSensorManager.registerListener(this.compassSensorJsPlugin, this.magneticSensor, paramInt)));
    return true;
  }
  
  public final boolean startGyroscope(IJsService paramIJsService, int paramInt)
  {
    if ((this.senSensorManager == null) || (this.gyroscopeSensor == null)) {
      return false;
    }
    if (this.gyroscopeSensorJsPlugin != null) {
      stopGyroscope();
    }
    this.gyroscopeSensorJsPlugin = new SensorJsPlugin.GyroscopeSensorJsPlugin(this, paramIJsService);
    return this.senSensorManager.registerListener(this.gyroscopeSensorJsPlugin, this.gyroscopeSensor, paramInt);
  }
  
  public final boolean startRotationListening(IJsService paramIJsService, int paramInt)
  {
    if ((this.senSensorManager == null) || (this.orientationSensor == null)) {
      return false;
    }
    if (this.orientationSensorJsPlugin != null) {
      stopRotationListening();
    }
    this.orientationSensorJsPlugin = new SensorJsPlugin.RotationSensorJsPlugin(this, paramIJsService);
    return this.senSensorManager.registerListener(this.orientationSensorJsPlugin, this.orientationSensor, paramInt);
  }
  
  public final void stopAccelerometer()
  {
    if ((this.senSensorManager != null) && (this.accelerometerSensorJsPlugin != null))
    {
      this.senSensorManager.unregisterListener(this.accelerometerSensorJsPlugin);
      this.accelerometerSensorJsPlugin = null;
    }
  }
  
  public final void stopCompass()
  {
    if ((this.senSensorManager != null) && (this.compassSensorJsPlugin != null))
    {
      this.senSensorManager.unregisterListener(this.compassSensorJsPlugin);
      this.compassSensorJsPlugin = null;
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
  
  @JsEvent({"vibrateLong"})
  public String vibrateLong(RequestEvent paramRequestEvent)
  {
    initSensor();
    ThreadManager.executeOnComputationThreadPool(new SensorJsPlugin.6(this));
    paramRequestEvent.ok();
    return "";
  }
  
  @JsEvent({"vibrateShort"})
  public String vibrateShort(RequestEvent paramRequestEvent)
  {
    initSensor();
    ThreadManager.executeOnComputationThreadPool(new SensorJsPlugin.5(this));
    paramRequestEvent.ok();
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SensorJsPlugin
 * JD-Core Version:    0.7.0.1
 */