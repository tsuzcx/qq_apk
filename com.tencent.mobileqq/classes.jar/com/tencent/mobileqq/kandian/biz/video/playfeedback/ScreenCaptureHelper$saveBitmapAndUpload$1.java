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
    IImageUploadListener localIImageUploadListener = this.c;
    if (localIImageUploadListener != null) {
      localIImageUploadListener.a(2, "");
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    ScreenCaptureHelper.a(this.a, this.b, this.c);
    if (!this.d.isRecycled()) {
      this.d.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeedback.ScreenCaptureHelper.saveBitmapAndUpload.1
 * JD-Core Version:    0.7.0.1
 */