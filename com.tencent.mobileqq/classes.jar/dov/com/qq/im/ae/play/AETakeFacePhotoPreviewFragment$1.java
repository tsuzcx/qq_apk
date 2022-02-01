package dov.com.qq.im.ae.play;

import android.graphics.Bitmap;
import dov.com.qq.im.ae.config.CameraPeakServiceHandler;

class AETakeFacePhotoPreviewFragment$1
  implements FaceChangeUtils.CropFaceCallback
{
  AETakeFacePhotoPreviewFragment$1(AETakeFacePhotoPreviewFragment paramAETakeFacePhotoPreviewFragment) {}
  
  public void onFail(int paramInt) {}
  
  public void onSuccess(Bitmap paramBitmap)
  {
    AETakeFacePhotoPreviewFragment.access$002(CameraPeakServiceHandler.a(this.this$0.getActivity(), paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment.1
 * JD-Core Version:    0.7.0.1
 */