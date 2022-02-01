package com.tencent.ttpic.filter;

import java.io.File;

public class Face3DLibJNI
{
  public static final int EXP_COUNT = 52;
  public static final int FACE_COUNT = 6736;
  public static final int VERTEX_COUNT = 3448;
  private static Face3DLibJNI mInstance;
  private long mHandle;
  
  public static Face3DLibJNI getInstance()
  {
    if (mInstance == null) {
      mInstance = new Face3DLibJNI();
    }
    return mInstance;
  }
  
  private native int nativeDestroy(long paramLong);
  
  private native long nativeInitHandle(String paramString);
  
  private native int nativeTrack(long paramLong, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public int destroy()
  {
    if (this.mHandle != 0L) {
      return nativeDestroy(this.mHandle);
    }
    return -1;
  }
  
  public boolean init(String paramString)
  {
    this.mHandle = nativeInitHandle(paramString + File.separator);
    return this.mHandle != 0L;
  }
  
  public int track(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.mHandle != 0L) {
      return nativeTrack(this.mHandle, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3, paramArrayOfFloat4, paramArrayOfFloat5, paramInt1, paramInt2, 2, paramBoolean);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.Face3DLibJNI
 * JD-Core Version:    0.7.0.1
 */