package com.tencent.mobileqq.shortvideo.panoramicvideo.utils;

import android.opengl.Matrix;

public class OrientationHelper
{
  public static final int IGNORE_ROTATION_AXIS_X = 8;
  public static final int IGNORE_ROTATION_AXIS_Y = 16;
  public static final int IGNORE_ROTATION_AXIS_Z = 32;
  public static final int IGNORE_ROTATION_NONE = 0;
  public static final int LOCK_MODE_ALL_AXIS = 7;
  public static final int LOCK_MODE_AXIS_X = 1;
  public static final int LOCK_MODE_AXIS_Y = 2;
  public static final int LOCK_MODE_AXIS_Z = 4;
  public static final int LOCK_MODE_NONE = 0;
  private static final String TAG = "OrientationHelper";
  private float[] currentRotation = new float[3];
  private int ignoreRotationMode = 0;
  private float[] initialRotation = new float[3];
  private int lockAxisMode = 0;
  private boolean rotationRecorded = false;
  float[] tmp = new float[16];
  
  private void convertToDegrees(float[] paramArrayOfFloat)
  {
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      paramArrayOfFloat[i] = ((float)Math.toDegrees(paramArrayOfFloat[i]));
      i += 1;
    }
  }
  
  public float[] getCurrentRotation()
  {
    return this.currentRotation;
  }
  
  public int getIgnoreRotationMode()
  {
    return this.ignoreRotationMode;
  }
  
  public int getLockAxisMode()
  {
    return this.lockAxisMode;
  }
  
  public void recordRotation(float[] paramArrayOfFloat)
  {
    if (!this.rotationRecorded)
    {
      Matrix.transposeM(this.tmp, 0, paramArrayOfFloat, 0);
      SensorUtil.getOrientationFromRotationMatrix(this.tmp, this.initialRotation);
      convertToDegrees(this.initialRotation);
      this.rotationRecorded = true;
      return;
    }
    Matrix.transposeM(this.tmp, 0, paramArrayOfFloat, 0);
    SensorUtil.getOrientationFromRotationMatrix(this.tmp, this.currentRotation);
    convertToDegrees(this.currentRotation);
  }
  
  public void revertRotation(float[] paramArrayOfFloat)
  {
    if ((this.lockAxisMode == 0) && (this.ignoreRotationMode == 0)) {
      return;
    }
    if (this.ignoreRotationMode != 0)
    {
      Matrix.setIdentityM(this.tmp, 0);
      if ((this.ignoreRotationMode & 0x20) == 0) {
        Matrix.rotateM(this.tmp, 0, -this.currentRotation[0], 0.0F, 0.0F, 1.0F);
      }
      if ((this.ignoreRotationMode & 0x8) == 0) {
        Matrix.rotateM(this.tmp, 0, -this.currentRotation[1], 1.0F, 0.0F, 0.0F);
      }
      if ((this.ignoreRotationMode & 0x10) == 0) {
        Matrix.rotateM(this.tmp, 0, this.currentRotation[2], 0.0F, 1.0F, 0.0F);
      }
      System.arraycopy(this.tmp, 0, paramArrayOfFloat, 0, 16);
      Matrix.transposeM(this.tmp, 0, paramArrayOfFloat, 0);
      SensorUtil.getOrientationFromRotationMatrix(this.tmp, this.currentRotation);
      convertToDegrees(this.currentRotation);
    }
    if (this.lockAxisMode != 0)
    {
      Matrix.setIdentityM(this.tmp, 0);
      int i = this.lockAxisMode;
      float f3 = 0.0F;
      float f1;
      if ((i & 0x4) != 0) {
        f1 = this.initialRotation[0];
      } else {
        f1 = 0.0F;
      }
      float f2;
      if ((this.lockAxisMode & 0x1) != 0) {
        f2 = this.initialRotation[1];
      } else {
        f2 = 0.0F;
      }
      if ((this.lockAxisMode & 0x2) != 0) {
        f3 = -this.initialRotation[2];
      }
      Matrix.rotateM(this.tmp, 0, -this.currentRotation[0] + f1, 0.0F, 0.0F, 1.0F);
      Matrix.rotateM(this.tmp, 0, -this.currentRotation[1] + f2, 1.0F, 0.0F, 0.0F);
      Matrix.rotateM(this.tmp, 0, this.currentRotation[2] + f3, 0.0F, 1.0F, 0.0F);
      System.arraycopy(this.tmp, 0, paramArrayOfFloat, 0, 16);
      Matrix.transposeM(this.tmp, 0, paramArrayOfFloat, 0);
      SensorUtil.getOrientationFromRotationMatrix(this.tmp, this.currentRotation);
      convertToDegrees(this.currentRotation);
    }
  }
  
  public void setIgnoreRotationMode(int paramInt)
  {
    this.ignoreRotationMode = paramInt;
  }
  
  public void setLockAxisMode(int paramInt)
  {
    this.lockAxisMode = paramInt;
  }
  
  public void setRotationRecorded(boolean paramBoolean)
  {
    this.rotationRecorded = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.utils.OrientationHelper
 * JD-Core Version:    0.7.0.1
 */