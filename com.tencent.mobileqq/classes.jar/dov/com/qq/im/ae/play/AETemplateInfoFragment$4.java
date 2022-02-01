package dov.com.qq.im.ae.play;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;

class AETemplateInfoFragment$4
  implements FaceChangeUtils.CropFaceCallback
{
  AETemplateInfoFragment$4(AETemplateInfoFragment paramAETemplateInfoFragment, boolean[] paramArrayOfBoolean, String paramString) {}
  
  public void onFail(int paramInt)
  {
    this.val$success[0] = false;
  }
  
  public void onSuccess(Bitmap paramBitmap)
  {
    this.val$success[0] = true;
    BitmapUtils.saveBitmap(paramBitmap, this.val$outImagePath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AETemplateInfoFragment.4
 * JD-Core Version:    0.7.0.1
 */