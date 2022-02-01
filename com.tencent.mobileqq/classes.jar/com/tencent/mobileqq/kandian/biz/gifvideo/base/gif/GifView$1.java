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
    if (GifView.access$000(this.g))
    {
      if (GifView.access$100(this.g)) {
        GifView.access$200(this.g);
      } else {
        this.f.restartDownload();
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoadFialed! mIsBigImg=");
      ((StringBuilder)localObject).append(GifView.access$100(this.g));
      ((StringBuilder)localObject).append(" w=");
      ((StringBuilder)localObject).append(GifView.access$300(this.g));
      ((StringBuilder)localObject).append(" h=");
      ((StringBuilder)localObject).append(GifView.access$400(this.g));
      QLog.d("gifvideo.GifView", 1, ((StringBuilder)localObject).toString());
      localObject = this.g;
      ((GifView)localObject).mTryCounts += 1;
    }
  }
  
  public void onFileDownloadStarted()
  {
    this.a.set(System.currentTimeMillis());
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.b.set(System.currentTimeMillis() - this.c);
    this.d.set(System.currentTimeMillis() - this.a.get());
    this.e.set(paramLong);
    QLog.d("gifvideo.GifView", 1, "gif download success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.gif.GifView.1
 * JD-Core Version:    0.7.0.1
 */