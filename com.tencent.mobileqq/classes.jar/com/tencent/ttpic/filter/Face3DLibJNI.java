package com.tencent.ttpic.filter;

import com.tencent.ttpic.baseutils.io.FileUtils;

public class Face3DLibJNI
{
  public static final int EXP_COUNT = 52;
  public static final int FACE_COUNT = 6736;
  public static final int VERTEX_COUNT = 3448;
  private static Face3DLibJNI mInstance;
  private long _face3d_handle_avatar;
  private long _face3d_handle_mesh;
  
  public static Face3DLibJNI getInstance()
  {
    if (mInstance == null) {
      mInstance = new Face3DLibJNI();
    }
    return mInstance;
  }
  
  private native int nativeDestroy(long paramLong);
  
  private native long nativeInitHandle(String paramString, boolean paramBoolean);
  
  private native int nativeTrack(long paramLong, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat);
  
  public int destroy()
  {
    long l = this._face3d_handle_mesh;
    if (l != 0L) {
      return nativeDestroy(l);
    }
    l = this._face3d_handle_avatar;
    if (l != 0L) {
      return nativeDestroy(l);
    }
    return -1;
  }
  
  public boolean init(String paramString)
  {
    this._face3d_handle_mesh = nativeInitHandle(FileUtils.genSeperateFileDir(paramString), true);
    paramString = FileUtils.genSeperateFileDir(paramString);
    boolean bool2 = false;
    this._face3d_handle_avatar = nativeInitHandle(paramString, false);
    boolean bool1 = bool2;
    if (this._face3d_handle_mesh != 0L)
    {
      bool1 = bool2;
      if (this._face3d_handle_avatar != 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int track(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat)
  {
    long l;
    if (paramBoolean1) {
      l = this._face3d_handle_mesh;
    } else {
      l = this._face3d_handle_avatar;
    }
    if (l == 0L) {
      return -1;
    }
    return nativeTrack(l, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3, paramArrayOfFloat4, paramArrayOfFloat5, paramInt1, paramInt2, 2, paramBoolean1, paramBoolean2, paramBoolean3, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.Face3DLibJNI
 * JD-Core Version:    0.7.0.1
 */