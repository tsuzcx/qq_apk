package com.tencent.ttpic.ar.sensor.orientationProvider;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.ttpic.ar.sensor.representation.MatrixF4x4;
import com.tencent.ttpic.ar.sensor.representation.Quaternion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class OrientationProvider
  implements SensorEventListener
{
  protected final Quaternion currentOrientationQuaternion;
  protected final MatrixF4x4 currentOrientationRotationMatrix;
  protected List<Sensor> sensorList = new ArrayList();
  protected SensorManager sensorManager;
  protected final Object synchronizationToken = new Object();
  
  public OrientationProvider(SensorManager paramSensorManager)
  {
    this.sensorManager = paramSensorManager;
    this.currentOrientationRotationMatrix = new MatrixF4x4();
    this.currentOrientationQuaternion = new Quaternion();
  }
  
  public void getEulerAngles(float[] paramArrayOfFloat)
  {
    synchronized (this.synchronizationToken)
    {
      SensorManager.getOrientation(this.currentOrientationRotationMatrix.matrix, paramArrayOfFloat);
      paramArrayOfFloat[0] = ((float)Math.toDegrees(paramArrayOfFloat[0]));
      paramArrayOfFloat[1] = ((float)Math.toDegrees(paramArrayOfFloat[1]));
      paramArrayOfFloat[2] = (-(float)Math.toDegrees(paramArrayOfFloat[2]));
      return;
    }
  }
  
  public void getQuaternion(Quaternion paramQuaternion)
  {
    synchronized (this.synchronizationToken)
    {
      paramQuaternion.set(this.currentOrientationQuaternion);
      return;
    }
  }
  
  public void getRotationMatrix(MatrixF4x4 paramMatrixF4x4)
  {
    synchronized (this.synchronizationToken)
    {
      paramMatrixF4x4.set(this.currentOrientationRotationMatrix);
      return;
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void start()
  {
    Iterator localIterator = this.sensorList.iterator();
    while (localIterator.hasNext())
    {
      Sensor localSensor = (Sensor)localIterator.next();
      this.sensorManager.registerListener(this, localSensor, 1);
    }
  }
  
  public void stop()
  {
    Iterator localIterator = this.sensorList.iterator();
    while (localIterator.hasNext())
    {
      Sensor localSensor = (Sensor)localIterator.next();
      this.sensorManager.unregisterListener(this, localSensor);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.ar.sensor.orientationProvider.OrientationProvider
 * JD-Core Version:    0.7.0.1
 */