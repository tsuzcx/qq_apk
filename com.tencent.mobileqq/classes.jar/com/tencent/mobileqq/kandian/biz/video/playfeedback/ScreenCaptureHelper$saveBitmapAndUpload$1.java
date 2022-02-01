package com.tencent.mobileqq.kandian.biz.video.playfeedback;

import android.graphics.Bitmap;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.kandian.biz.ugc.upload.IImageUploadListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/video/playfeedback/ScreenCaptureHelper$saveBitmapAndUpload$1", "Lcom/tencent/image/URLDrawable$DownloadListener;", "onFileDownloadFailed", "", "p0", "", "onFileDownloadStarted", "onFileDownloadSucceed", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ScreenCaptureHelper$saveBitmapAndUpload$1
  implements URLDrawable.DownloadListener
{
  ScreenCaptureHelper$saveBitmapAndUpload$1(String paramString, IImageUploadListener paramIImageUploadListener, Bitmap paramBitmap) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    IImageUploadListener localIImageUploadListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIImageUploadListener;
    if (localIImageUploadListener != null) {
      localIImageUploadListener.a(2, "");
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    ScreenCaptureHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedbackScreenCaptureHelper, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIImageUploadListener);
    if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeedback.ScreenCaptureHelper.saveBitmapAndUpload.1
 * JD-Core Version:    0.7.0.1
 */