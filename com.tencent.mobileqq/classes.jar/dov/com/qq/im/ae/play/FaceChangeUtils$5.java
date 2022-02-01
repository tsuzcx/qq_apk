package dov.com.qq.im.ae.play;

import android.graphics.Bitmap;

final class FaceChangeUtils$5
  implements Runnable
{
  FaceChangeUtils$5(Bitmap paramBitmap, FaceChangeUtils.CropFaceCallback paramCropFaceCallback) {}
  
  public void run()
  {
    try
    {
      FaceChangeUtils.access$300(this.val$photo, this.val$callback);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.val$callback.onFail(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.FaceChangeUtils.5
 * JD-Core Version:    0.7.0.1
 */