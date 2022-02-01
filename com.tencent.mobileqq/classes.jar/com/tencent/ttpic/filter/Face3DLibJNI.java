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
  private String mModelPath = null;
  
  public static Face3DLibJNI getInstance()
  {
    if (mInstance == null) {
      mInstance = new Face3DLibJNI();
    }
    return mInstance;
  }
  
  private native int nativeDestroy(long paramLong);
  
  private native long nativeInitHandle(String paramString, boolean paramBoolean);
  
  private native void nativeQQDestroy(long paramLong);
  
  private native void nativeQQGenerateFaceExpression(long paramLong, int paramInt1, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt2);
  
  private native void nativeQQGeneratePartExpression(long paramLong, int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, int paramInt3);
  
  private native String nativeQQGetExpressionNameWithID(long paramLong, int paramInt);
  
  private native int[] nativeQQGetHighLvFaceExpressions(long paramLong);
  
  private native int[] nativeQQGetMidLvFaceExpressions(long paramLong);
  
  private native long nativeQQInitDataWithBundlePath(String paramString);
  
  private native int nativeTrack(long paramLong, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat);
  
  public void QQDestroy(long paramLong)
  {
    nativeQQDestroy(paramLong);
  }
  
  public void QQGenerateFaceExpression(long paramLong, int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramArrayOfFloat1 != null) && (paramArrayOfFloat2 != null)) {
      nativeQQGenerateFaceExpression(paramLong, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat1.length / 3);
    }
  }
  
  public void QQGeneratePartExpression(long paramLong, int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    if ((paramArrayOfFloat2 != null) && (paramArrayOfFloat3 != null) && (paramArrayOfFloat2.length <= paramArrayOfFloat3.length)) {
      nativeQQGeneratePartExpression(paramLong, paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3, paramArrayOfFloat2.length / 3);
    }
  }
  
  public String QQGetExpressNameById(long paramLong, int paramInt)
  {
    return nativeQQGetExpressionNameWithID(paramLong, paramInt);
  }
  
  public int[] QQGetHighLvFaceExpressions(long paramLong)
  {
    return nativeQQGetHighLvFaceExpressions(paramLong);
  }
  
  public int[] QQGetMidLvFaceExpressions(long paramLong)
  {
    return nativeQQGetMidLvFaceExpressions(paramLong);
  }
  
  public long QQInitDataWithBundle()
  {
    return nativeQQInitDataWithBundlePath(this.mModelPath);
  }
  
  public int destroy()
  {
    if (this._face3d_handle_mesh != 0L) {
      return nativeDestroy(this._face3d_handle_mesh);
    }
    if (this._face3d_handle_avatar != 0L) {
      return nativeDestroy(this._face3d_handle_avatar);
    }
    return -1;
  }
  
  public String getModelPath()
  {
    return this.mModelPath;
  }
  
  public boolean init(String paramString)
  {
    this.mModelPath = paramString;
    this._face3d_handle_mesh = nativeInitHandle(FileUtils.genSeperateFileDir(paramString), true);
    this._face3d_handle_avatar = nativeInitHandle(FileUtils.genSeperateFileDir(paramString), false);
    return (this._face3d_handle_mesh != 0L) && (this._face3d_handle_avatar != 0L);
  }
  
  public int track(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat)
  {
    if (paramBoolean1) {}
    for (long l = this._face3d_handle_mesh; l == 0L; l = this._face3d_handle_avatar) {
      return -1;
    }
    return nativeTrack(l, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3, paramArrayOfFloat4, paramArrayOfFloat5, paramInt1, paramInt2, 2, paramBoolean1, paramBoolean2, paramBoolean3, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.Face3DLibJNI
 * JD-Core Version:    0.7.0.1
 */