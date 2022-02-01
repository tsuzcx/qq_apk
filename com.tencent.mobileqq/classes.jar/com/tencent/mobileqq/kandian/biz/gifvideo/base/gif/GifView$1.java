package com.tencent.mobileqq.kandian.biz.gifvideo.base.gif;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

class GifView$1
  implements URLDrawable.DownloadListener
{
  GifView$1(GifView paramGifView, AtomicLong paramAtomicLong1, AtomicLong paramAtomicLong2, long paramLong, AtomicLong paramAtomicLong3, AtomicLong paramAtomicLong4, URLDrawable paramURLDrawable) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (GifView.access$000(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView))
    {
      if (GifView.access$100(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView)) {
        GifView.access$200(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView);
      } else {
        this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoadFialed! mIsBigImg=");
      ((StringBuilder)localObject).append(GifView.access$100(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView));
      ((StringBuilder)localObject).append(" w=");
      ((StringBuilder)localObject).append(GifView.access$300(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView));
      ((StringBuilder)localObject).append(" h=");
      ((StringBuilder)localObject).append(GifView.access$400(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView));
      QLog.d("gifvideo.GifView", 1, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView;
      ((GifView)localObject).mTryCounts += 1;
    }
  }
  
  public void onFileDownloadStarted()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(System.currentTimeMillis());
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.b.set(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    this.c.set(System.currentTimeMillis() - this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get());
    this.d.set(paramLong);
    QLog.d("gifvideo.GifView", 1, "gif download success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.gif.GifView.1
 * JD-Core Version:    0.7.0.1
 */