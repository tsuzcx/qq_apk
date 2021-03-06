package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.content.Context;
import android.hardware.SensorManager;
import android.util.Log;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;

public class SensorManagerWorker
{
  private static final String TAG = "MicroMsg.LightSensor";
  private boolean mHasStarted = false;
  private SensorManagerWorker.LightSensorListener mLightSensorListener;
  private SensorManagerWorker.OnGetValue mOnGetValue;
  private SensorManager mSensorManager;
  
  public static SensorManagerWorker getInstance()
  {
    return SensorManagerWorker.Singleton.access$000();
  }
  
  public float getLux()
  {
    if (this.mLightSensorListener != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Light lux: ");
      localStringBuilder.append(SensorManagerWorker.LightSensorListener.access$300(this.mLightSensorListener));
      Log.d("MicroMsg.LightSensor", localStringBuilder.toString());
      return SensorManagerWorker.LightSensorListener.access$300(this.mLightSensorListener);
    }
    return -1.0F;
  }
  
  public int start(Context paramContext, SensorManagerWorker.OnGetValue paramOnGetValue)
  {
    if (this.mHasStarted)
    {
      YTAGReflectLiveCheckJNIInterface.nativeLog("MicroMsg.LightSensor", "[SensorManagerWorker.start] light sensor has started");
      return 2;
    }
    this.mHasStarted = true;
    this.mSensorManager = ((SensorManager)paramContext.getApplicationContext().getSystemService("sensor"));
    paramContext = this.mSensorManager.getDefaultSensor(5);
    if (paramContext != null)
    {
      this.mLightSensorListener = new SensorManagerWorker.LightSensorListener(this, null);
      this.mSensorManager.registerListener(this.mLightSensorListener, paramContext, 3);
      this.mOnGetValue = paramOnGetValue;
      return 0;
    }
    YTAGReflectLiveCheckJNIInterface.nativeLog("MicroMsg.LightSensor", "[SensorManagerWorker.start] System do not have lightSensor");
    return 1;
  }
  
  public void stop()
  {
    if (this.mHasStarted)
    {
      SensorManager localSensorManager = this.mSensorManager;
      if (localSensorManager == null) {
        return;
      }
      this.mHasStarted = false;
      localSensorManager.unregisterListener(this.mLightSensorListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.worker.SensorManagerWorker
 * JD-Core Version:    0.7.0.1
 */