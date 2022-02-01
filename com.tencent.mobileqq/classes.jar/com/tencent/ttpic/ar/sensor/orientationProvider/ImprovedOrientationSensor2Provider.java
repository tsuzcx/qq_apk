package com.tencent.ttpic.ar.sensor.orientationProvider;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.ttpic.ar.sensor.representation.MatrixF4x4;
import com.tencent.ttpic.ar.sensor.representation.Quaternion;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.List;

public class ImprovedOrientationSensor2Provider
  extends OrientationProvider
{
  private static final double EPSILON = 0.1000000014901161D;
  private static final float INDIRECT_INTERPOLATION_WEIGHT = 0.01F;
  private static final float NS2S = 1.0E-009F;
  private static final float OUTLIER_PANIC_THRESHOLD = 0.75F;
  private static final float OUTLIER_THRESHOLD = 0.85F;
  private static final int PANIC_THRESHOLD = 60;
  private final Quaternion correctedQuaternion = new Quaternion();
  private final Quaternion deltaQuaternion = new Quaternion();
  private double gyroscopeRotationVelocity = 0.0D;
  private final Quaternion interpolatedQuaternion = new Quaternion();
  private int panicCounter;
  private boolean positionInitialised = false;
  private Quaternion quaternionGyroscope = new Quaternion();
  private Quaternion quaternionRotationVector = new Quaternion();
  private final float[] temporaryQuaternion = new float[4];
  private long timestamp;
  
  public ImprovedOrientationSensor2Provider(SensorManager paramSensorManager)
  {
    super(paramSensorManager);
    this.sensorList.add(paramSensorManager.getDefaultSensor(4));
    this.sensorList.add(paramSensorManager.getDefaultSensor(11));
  }
  
  private void setOrientationQuaternionAndMatrix(Quaternion paramQuaternion)
  {
    this.correctedQuaternion.set(paramQuaternion);
    ??? = this.correctedQuaternion;
    ((Quaternion)???).w(-((Quaternion)???).w());
    synchronized (this.synchronizationToken)
    {
      this.currentOrientationQuaternion.copyVec4(paramQuaternion);
      SensorManager.getRotationMatrixFromVector(this.currentOrientationRotationMatrix.matrix, this.correctedQuaternion.array());
      return;
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    Object localObject;
    if (paramSensorEvent.sensor.getType() == 11)
    {
      SensorManager.getQuaternionFromVector(this.temporaryQuaternion, paramSensorEvent.values);
      paramSensorEvent = this.quaternionRotationVector;
      localObject = this.temporaryQuaternion;
      paramSensorEvent.setXYZW(localObject[1], localObject[2], localObject[3], -localObject[0]);
      if (!this.positionInitialised)
      {
        this.quaternionGyroscope.set(this.quaternionRotationVector);
        this.positionInitialised = true;
      }
    }
    else if (paramSensorEvent.sensor.getType() == 4)
    {
      if (this.timestamp != 0L)
      {
        float f7 = (float)(paramSensorEvent.timestamp - this.timestamp);
        float f6 = paramSensorEvent.values[0];
        float f5 = paramSensorEvent.values[1];
        float f4 = paramSensorEvent.values[2];
        this.gyroscopeRotationVelocity = Math.sqrt(f6 * f6 + f5 * f5 + f4 * f4);
        double d1 = this.gyroscopeRotationVelocity;
        float f3 = f4;
        float f2 = f6;
        float f1 = f5;
        if (d1 > 0.1000000014901161D)
        {
          d2 = f6;
          Double.isNaN(d2);
          f2 = (float)(d2 / d1);
          d2 = f5;
          Double.isNaN(d2);
          f1 = (float)(d2 / d1);
          d2 = f4;
          Double.isNaN(d2);
          f3 = (float)(d2 / d1);
        }
        d1 = this.gyroscopeRotationVelocity;
        double d2 = f7 * 1.0E-009F;
        Double.isNaN(d2);
        d2 = d1 * d2 / 2.0D;
        d1 = Math.sin(d2);
        d2 = Math.cos(d2);
        localObject = this.deltaQuaternion;
        double d3 = f2;
        Double.isNaN(d3);
        ((Quaternion)localObject).setX((float)(d3 * d1));
        localObject = this.deltaQuaternion;
        d3 = f1;
        Double.isNaN(d3);
        ((Quaternion)localObject).setY((float)(d3 * d1));
        localObject = this.deltaQuaternion;
        d3 = f3;
        Double.isNaN(d3);
        ((Quaternion)localObject).setZ((float)(d1 * d3));
        this.deltaQuaternion.setW(-(float)d2);
        localObject = this.deltaQuaternion;
        Quaternion localQuaternion = this.quaternionGyroscope;
        ((Quaternion)localObject).multiplyByQuat(localQuaternion, localQuaternion);
        f1 = this.quaternionGyroscope.dotProduct(this.quaternionRotationVector);
        if (Math.abs(f1) < 0.85F)
        {
          if (Math.abs(f1) < 0.75F) {
            this.panicCounter += 1;
          }
          setOrientationQuaternionAndMatrix(this.quaternionGyroscope);
        }
        else
        {
          this.quaternionGyroscope.slerp(this.quaternionRotationVector, this.interpolatedQuaternion, (float)(this.gyroscopeRotationVelocity * 0.009999999776482582D));
          setOrientationQuaternionAndMatrix(this.interpolatedQuaternion);
          this.quaternionGyroscope.copyVec4(this.interpolatedQuaternion);
          this.panicCounter = 0;
        }
        if (this.panicCounter > 60)
        {
          LogUtils.d("Rotation Vector", "Panic counter is bigger than threshold; this indicates a Gyroscope failure. Panic reset is imminent.");
          d1 = this.gyroscopeRotationVelocity;
          if (d1 < 3.0D)
          {
            LogUtils.d("Rotation Vector", "Performing Panic-reset. Resetting orientation to rotation-vector value.");
            setOrientationQuaternionAndMatrix(this.quaternionRotationVector);
            this.quaternionGyroscope.copyVec4(this.quaternionRotationVector);
            this.panicCounter = 0;
          }
          else
          {
            LogUtils.d("Rotation Vector", String.format("Panic reset delayed due to ongoing motion (user is still shaking the device). Gyroscope Velocity: %.2f > 3", new Object[] { Double.valueOf(d1) }));
          }
        }
      }
      this.timestamp = paramSensorEvent.timestamp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.ar.sensor.orientationProvider.ImprovedOrientationSensor2Provider
 * JD-Core Version:    0.7.0.1
 */