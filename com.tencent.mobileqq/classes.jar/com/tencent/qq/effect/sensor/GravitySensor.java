package com.tencent.qq.effect.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class GravitySensor
  implements SensorEventListener
{
  private static final String TAG = "GravitySensor";
  float[] mGravity = { 0.0F, 0.0F, 0.0F };
  private ArrayList<WeakReference<GravitySensor.GravitySensorListener>> mGravitySensorListenerList;
  private boolean mIsInitial = false;
  private boolean mIsPause = false;
  private boolean mIsReset = false;
  float[] mPreGravity = { 0.0F, 0.0F, 0.0F };
  private Sensor mSensor;
  private SensorManager mSensorManager;
  
  private float[] calibrateSensorData(SensorEvent paramSensorEvent)
  {
    this.mGravity[0] = (paramSensorEvent.values[0] / 9.8F);
    this.mGravity[1] = (paramSensorEvent.values[1] / 9.8F);
    this.mGravity[2] = (paramSensorEvent.values[2] / 9.8F);
    return this.mGravity;
  }
  
  public void addListener(GravitySensor.GravitySensorListener paramGravitySensorListener)
  {
    resume();
    try
    {
      this.mGravitySensorListenerList.add(new WeakReference(paramGravitySensorListener));
      return;
    }
    finally {}
  }
  
  public void destroy()
  {
    SensorManager localSensorManager = this.mSensorManager;
    if (localSensorManager == null)
    {
      Log.e("GravitySensor", "clear but mSensorManager is null.");
      return;
    }
    if (this.mSensor != null) {
      localSensorManager.unregisterListener(this);
    }
    this.mIsInitial = false;
    this.mGravitySensorListenerList.clear();
  }
  
  public void init(Context paramContext)
  {
    this.mIsInitial = true;
    this.mGravitySensorListenerList = new ArrayList();
    this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.mSensor = this.mSensorManager.getDefaultSensor(9);
    this.mSensorManager.registerListener(this, this.mSensor, 1);
  }
  
  public boolean isInit()
  {
    return this.mIsInitial;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.mIsPause) {
      return;
    }
    float f1 = Math.round(paramSensorEvent.values[0] * 10.0F);
    float f2 = Math.round(paramSensorEvent.values[1] * 10.0F);
    float f3 = Math.round(paramSensorEvent.values[2] * 10.0F);
    Object localObject = this.mPreGravity;
    if ((localObject[0] == f1) && (localObject[1] == f2) && (localObject[2] == f3)) {
      return;
    }
    localObject = this.mPreGravity;
    localObject[0] = f1;
    localObject[1] = f2;
    localObject[2] = f3;
    localObject = this.mGravitySensorListenerList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      GravitySensor.GravitySensorListener localGravitySensorListener = (GravitySensor.GravitySensorListener)((WeakReference)((Iterator)localObject).next()).get();
      if (localGravitySensorListener != null) {
        localGravitySensorListener.updateGravityData(calibrateSensorData(paramSensorEvent), this.mIsReset);
      }
    }
    this.mIsReset = false;
  }
  
  public void pause()
  {
    this.mIsPause = true;
  }
  
  public void removeListener(GravitySensor.GravitySensorListener paramGravitySensorListener)
  {
    resume();
    try
    {
      Iterator localIterator = this.mGravitySensorListenerList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (paramGravitySensorListener == localWeakReference.get())
        {
          this.mGravitySensorListenerList.remove(localWeakReference);
          return;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramGravitySensorListener;
    }
  }
  
  public void resume()
  {
    this.mIsPause = false;
    this.mIsReset = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.sensor.GravitySensor
 * JD-Core Version:    0.7.0.1
 */