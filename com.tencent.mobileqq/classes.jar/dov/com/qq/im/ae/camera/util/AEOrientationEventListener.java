package dov.com.qq.im.ae.camera.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.OrientationListener;
import com.tencent.ttpic.baseutils.log.LogUtils;

public abstract class AEOrientationEventListener
{
  private static final boolean DEBUG = false;
  public static final int ORIENTATION_UNKNOWN = -1;
  private static final String TAG = "MOEL";
  private static final boolean localLOGV = false;
  private boolean mEnabled = false;
  private OrientationListener mOldListener;
  private int mOrientation = -1;
  private int mRate;
  private Sensor mSensor;
  private SensorEventListener mSensorEventListener;
  private SensorManager mSensorManager;
  
  public AEOrientationEventListener(Context paramContext)
  {
    this(paramContext, 3);
  }
  
  public AEOrientationEventListener(Context paramContext, int paramInt)
  {
    this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.mRate = paramInt;
    this.mSensor = this.mSensorManager.getDefaultSensor(1);
    if (this.mSensor != null) {
      this.mSensorEventListener = new AEOrientationEventListener.SensorEventListenerImpl(this);
    }
  }
  
  public boolean canDetectOrientation()
  {
    return this.mSensor != null;
  }
  
  public void disable()
  {
    if (this.mSensor == null) {
      LogUtils.w("MOEL", "Cannot detect sensors. Invalid disable");
    }
    while (this.mEnabled != true) {
      return;
    }
    this.mSensorManager.unregisterListener(this.mSensorEventListener);
    this.mEnabled = false;
  }
  
  public void enable()
  {
    if (this.mSensor == null) {
      LogUtils.w("MOEL", "Cannot detect sensors. Not enabled");
    }
    while (this.mEnabled) {
      return;
    }
    this.mSensorManager.registerListener(this.mSensorEventListener, this.mSensor, this.mRate);
    this.mEnabled = true;
  }
  
  public abstract void onOrientationChanged(int paramInt);
  
  public abstract void onPoseChanged(float paramFloat1, float paramFloat2, float paramFloat3);
  
  void registerListener(OrientationListener paramOrientationListener)
  {
    this.mOldListener = paramOrientationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.util.AEOrientationEventListener
 * JD-Core Version:    0.7.0.1
 */