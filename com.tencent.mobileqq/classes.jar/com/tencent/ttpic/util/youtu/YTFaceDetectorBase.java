package com.tencent.ttpic.util.youtu;

public enum YTFaceDetectorBase
{
  INSTANCE;
  
  private static final String TAG = YTFaceDetectorBase.class.getSimpleName();
  
  private YTFaceDetectorBase() {}
  
  public static YTFaceDetectorBase getInstance()
  {
    return INSTANCE;
  }
  
  private native void nativeDestructor();
  
  public void destroy()
  {
    nativeDestructor();
  }
  
  public native int nativeInitCameraFaceTrack(String paramString);
  
  public native int nativeInitCommon(String paramString);
  
  public native int nativeInitPictureFaceTrack(String paramString);
  
  public native void nativeSetRefine(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.YTFaceDetectorBase
 * JD-Core Version:    0.7.0.1
 */