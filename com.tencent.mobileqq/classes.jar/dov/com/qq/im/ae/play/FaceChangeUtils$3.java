package dov.com.qq.im.ae.play;

import android.graphics.Bitmap;
import com.tencent.ttpic.openapi.PTFaceAttr;

final class FaceChangeUtils$3
  implements Runnable
{
  FaceChangeUtils$3(PTFaceAttr[] paramArrayOfPTFaceAttr, Bitmap paramBitmap) {}
  
  public void run()
  {
    this.val$result[0] = FaceChangeUtils.detectFace(this.val$bitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.FaceChangeUtils.3
 * JD-Core Version:    0.7.0.1
 */