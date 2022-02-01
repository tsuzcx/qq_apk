package com.tencent.ttpic.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.aekit.api.standard.AEModule;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SensorUtil
  implements SensorEventListener
{
  private static final int MAX_QUEUE_SIZE = 200;
  private float[] center1 = new float[4];
  private float[] center2 = new float[4];
  private float[] center3 = new float[4];
  private float[] centerUp = new float[6];
  private HashMap<Long, float[]> centerUpMap = new HashMap();
  private List<float[]> floatArrayPool = Collections.synchronizedList(new LinkedList());
  private HandlerThread ht;
  private float[] mAdjustRotationMatrix = new float[16];
  private Handler mHandler;
  private float[] mRotationMatrix = new float[16];
  private Sensor mRotationSensor = this.mSensorManager.getDefaultSensor(11);
  private SensorManager mSensorManager = (SensorManager)AEModule.getContext().getSystemService("sensor");
  private final Object mStartLock = new Object();
  private Queue<Map.Entry<Long, float[]>> matrixQueue = new ConcurrentLinkedQueue();
  private long maxSensorTime = -1L;
  private boolean needCalAjust;
  private float[] oCenter = { 0.0F, 0.0F, -1.0F, 0.0F };
  private float[] oUp = { 0.0F, 1.0F, 0.0F, 0.0F };
  private long offset;
  private boolean restart;
  private float[] up1 = new float[4];
  private float[] up2 = new float[4];
  private float[] up3 = new float[4];
  
  public SensorUtil()
  {
    Matrix.setIdentityM(this.mRotationMatrix, 0);
    Matrix.setIdentityM(this.mAdjustRotationMatrix, 0);
    this.offset = (SystemClock.elapsedRealtimeNanos() - System.nanoTime());
  }
  
  private void calAdjust(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat1 = new float[4];
    float[] arrayOfFloat2 = new float[4];
    multiplyMatrixVector(paramArrayOfFloat1, this.oCenter, arrayOfFloat1);
    arrayOfFloat2[0] = (-arrayOfFloat1[0]);
    arrayOfFloat2[1] = (-arrayOfFloat1[2]);
    arrayOfFloat2[2] = arrayOfFloat1[1];
    double d1 = arrayOfFloat2[2];
    double d2 = Math.sqrt(arrayOfFloat2[0] * arrayOfFloat2[0] + arrayOfFloat2[2] * arrayOfFloat2[2]);
    Double.isNaN(d1);
    d2 = Math.acos(d1 / d2);
    d1 = d2;
    if (arrayOfFloat2[0] < 0.0F) {
      d1 = 6.283185307179586D - d2;
    }
    d1 = -d1 + 3.141592653589793D;
    paramArrayOfFloat2[0] = ((float)Math.cos(d1));
    paramArrayOfFloat2[1] = 0.0F;
    paramArrayOfFloat2[2] = ((float)Math.sin(d1));
    paramArrayOfFloat2[3] = 0.0F;
    paramArrayOfFloat2[4] = 0.0F;
    paramArrayOfFloat2[5] = 1.0F;
    paramArrayOfFloat2[6] = 0.0F;
    paramArrayOfFloat2[7] = 0.0F;
    paramArrayOfFloat2[8] = ((float)-Math.sin(d1));
    paramArrayOfFloat2[9] = 0.0F;
    paramArrayOfFloat2[10] = ((float)Math.cos(d1));
    paramArrayOfFloat2[11] = 0.0F;
    paramArrayOfFloat2[12] = 0.0F;
    paramArrayOfFloat2[13] = 0.0F;
    paramArrayOfFloat2[14] = 0.0F;
    paramArrayOfFloat2[15] = 1.0F;
  }
  
  private float[] getFloatArray()
  {
    if (this.floatArrayPool.isEmpty()) {
      return new float[16];
    }
    return (float[])this.floatArrayPool.remove(0);
  }
  
  private void multiplyMatrixVector(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    if (paramArrayOfFloat1.length == 16)
    {
      paramArrayOfFloat3[0] = (paramArrayOfFloat1[0] * paramArrayOfFloat2[0] + paramArrayOfFloat1[1] * paramArrayOfFloat2[1] + paramArrayOfFloat1[2] * paramArrayOfFloat2[2] + paramArrayOfFloat1[3] * paramArrayOfFloat2[3]);
      paramArrayOfFloat3[1] = (paramArrayOfFloat1[4] * paramArrayOfFloat2[0] + paramArrayOfFloat1[5] * paramArrayOfFloat2[1] + paramArrayOfFloat1[6] * paramArrayOfFloat2[2] + paramArrayOfFloat1[7] * paramArrayOfFloat2[3]);
      paramArrayOfFloat3[2] = (paramArrayOfFloat1[8] * paramArrayOfFloat2[0] + paramArrayOfFloat1[9] * paramArrayOfFloat2[1] + paramArrayOfFloat1[10] * paramArrayOfFloat2[2] + paramArrayOfFloat1[11] * paramArrayOfFloat2[3]);
      paramArrayOfFloat3[3] = (paramArrayOfFloat1[12] * paramArrayOfFloat2[0] + paramArrayOfFloat1[13] * paramArrayOfFloat2[1] + paramArrayOfFloat1[14] * paramArrayOfFloat2[2] + paramArrayOfFloat1[15] * paramArrayOfFloat2[3]);
      return;
    }
    paramArrayOfFloat3[0] = (paramArrayOfFloat1[0] * paramArrayOfFloat2[0] + paramArrayOfFloat1[1] * paramArrayOfFloat2[1] + paramArrayOfFloat1[2] * paramArrayOfFloat2[2]);
    paramArrayOfFloat3[1] = (paramArrayOfFloat1[3] * paramArrayOfFloat2[0] + paramArrayOfFloat1[4] * paramArrayOfFloat2[1] + paramArrayOfFloat1[5] * paramArrayOfFloat2[2]);
    paramArrayOfFloat3[2] = (paramArrayOfFloat1[6] * paramArrayOfFloat2[0] + paramArrayOfFloat1[7] * paramArrayOfFloat2[1] + paramArrayOfFloat1[8] * paramArrayOfFloat2[2]);
  }
  
  private void releaseFloatArray(float[] paramArrayOfFloat)
  {
    this.floatArrayPool.add(paramArrayOfFloat);
  }
  
  private void updateMatrix(long paramLong)
  {
    if (this.matrixQueue.isEmpty()) {
      return;
    }
    Map.Entry localEntry3 = (Map.Entry)this.matrixQueue.poll();
    Map.Entry localEntry4 = (Map.Entry)this.matrixQueue.peek();
    Map.Entry localEntry1 = localEntry3;
    Map.Entry localEntry2;
    for (;;)
    {
      localEntry2 = localEntry3;
      if (localEntry4 == null) {
        break;
      }
      if (((Long)localEntry4.getKey()).longValue() > paramLong)
      {
        if (paramLong - ((Long)localEntry1.getKey()).longValue() > ((Long)localEntry4.getKey()).longValue() - paramLong)
        {
          releaseFloatArray((float[])localEntry1.getValue());
          localEntry2 = (Map.Entry)this.matrixQueue.poll();
          break;
        }
        localEntry2 = localEntry1;
        break;
      }
      releaseFloatArray((float[])localEntry1.getValue());
      localEntry1 = (Map.Entry)this.matrixQueue.poll();
      localEntry4 = (Map.Entry)this.matrixQueue.peek();
    }
    System.arraycopy(localEntry2.getValue(), 0, this.mRotationMatrix, 0, 16);
    releaseFloatArray((float[])localEntry2.getValue());
    if (this.needCalAjust)
    {
      calAdjust(this.mRotationMatrix, this.mAdjustRotationMatrix);
      this.needCalAjust = false;
    }
  }
  
  public float[] centerUp(long paramLong)
  {
    float[] arrayOfFloat1;
    try
    {
      synchronized (this.mStartLock)
      {
        if (this.restart) {
          this.mStartLock.wait();
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      if (this.centerUpMap.containsKey(Long.valueOf(paramLong))) {
        return (float[])this.centerUpMap.get(Long.valueOf(paramLong));
      }
      this.centerUpMap.clear();
      updateMatrix(paramLong);
      multiplyMatrixVector(this.mRotationMatrix, this.oCenter, this.center1);
      multiplyMatrixVector(this.mRotationMatrix, this.oUp, this.up1);
      ??? = this.center2;
      arrayOfFloat1 = this.center1;
      ???[0] = (-arrayOfFloat1[0]);
      ???[1] = (-arrayOfFloat1[2]);
      ???[2] = arrayOfFloat1[1];
      ???[3] = 0.0F;
      arrayOfFloat1 = this.up2;
      float[] arrayOfFloat2 = this.up1;
      arrayOfFloat1[0] = arrayOfFloat2[0];
      arrayOfFloat1[1] = arrayOfFloat2[2];
      arrayOfFloat1[2] = (-arrayOfFloat2[1]);
      arrayOfFloat1[3] = 0.0F;
      multiplyMatrixVector(this.mAdjustRotationMatrix, (float[])???, this.center3);
      multiplyMatrixVector(this.mAdjustRotationMatrix, this.up2, this.up3);
      ??? = this.centerUp;
      arrayOfFloat1 = this.center3;
      ???[0] = arrayOfFloat1[0];
      ???[1] = arrayOfFloat1[1];
      ???[2] = arrayOfFloat1[2];
      arrayOfFloat1 = this.up3;
      ???[3] = arrayOfFloat1[0];
      ???[4] = arrayOfFloat1[1];
      ???[5] = arrayOfFloat1[2];
      this.centerUpMap.put(Long.valueOf(paramLong), this.centerUp);
      return this.centerUp;
    }
    for (;;)
    {
      throw arrayOfFloat1;
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.matrixQueue.size() > 200) {
      while (this.matrixQueue.size() > 100) {
        this.matrixQueue.remove();
      }
    }
    float[] arrayOfFloat = getFloatArray();
    SensorManager.getRotationMatrixFromVector(arrayOfFloat, paramSensorEvent.values);
    if (this.restart) {
      synchronized (this.mStartLock)
      {
        this.restart = false;
        this.mStartLock.notifyAll();
        this.needCalAjust = true;
      }
    }
    long l = paramSensorEvent.timestamp;
    this.matrixQueue.add(new SensorUtil.1(this, l, arrayOfFloat));
  }
  
  public void start()
  {
    this.ht = new HandlerThread("sensorUtil", 10);
    this.ht.start();
    this.mHandler = new Handler(this.ht.getLooper());
    this.restart = this.mSensorManager.registerListener(this, this.mRotationSensor, 1, this.mHandler);
  }
  
  public void stop()
  {
    this.mSensorManager.unregisterListener(this);
    this.ht.quitSafely();
    this.restart = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.util.SensorUtil
 * JD-Core Version:    0.7.0.1
 */