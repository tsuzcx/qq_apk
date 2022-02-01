package dov.com.qq.im.ae.play;

import android.graphics.Bitmap;

public abstract interface FaceChangeUtils$CropFaceCallback
{
  public static final int ERROR_FAILED_DETECT_FACE = -2;
  public static final int ERROR_INTERNAL_EXCEPTION = -1;
  public static final int ERROR_INVALID_PHOTO = -3;
  
  public abstract void onFail(int paramInt);
  
  public abstract void onSuccess(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.FaceChangeUtils.CropFaceCallback
 * JD-Core Version:    0.7.0.1
 */