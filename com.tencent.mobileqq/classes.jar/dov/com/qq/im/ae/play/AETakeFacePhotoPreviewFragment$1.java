package dov.com.qq.im.ae.play;

import android.graphics.Bitmap;
import bnjs;

class AETakeFacePhotoPreviewFragment$1
  implements FaceChangeUtils.CropFaceCallback
{
  AETakeFacePhotoPreviewFragment$1(AETakeFacePhotoPreviewFragment paramAETakeFacePhotoPreviewFragment) {}
  
  public void onFail(int paramInt) {}
  
  public void onSuccess(Bitmap paramBitmap)
  {
    AETakeFacePhotoPreviewFragment.access$002(bnjs.a(this.this$0.getActivity(), paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment.1
 * JD-Core Version:    0.7.0.1
 */