package com.tencent.mobileqq.kandian.biz.gifvideo.base.gif;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

class GifView$2
  implements URLDrawableDownListener
{
  GifView$2(GifView paramGifView, long paramLong, AtomicLong paramAtomicLong1, AtomicLong paramAtomicLong2, AtomicLong paramAtomicLong3, AtomicLong paramAtomicLong4, StringBuilder paramStringBuilder, URLDrawable paramURLDrawable) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (GifView.access$000(this.h))
    {
      if (GifView.access$100(this.h)) {
        GifView.access$200(this.h);
      } else {
        this.g.restartDownload();
      }
      paramView = new StringBuilder();
      paramView.append("onLoadFialed! mIsBigImg=");
      paramView.append(GifView.access$100(this.h));
      paramView.append(" w=");
      paramView.append(GifView.access$300(this.h));
      paramView.append(" h=");
      paramView.append(GifView.access$400(this.h));
      paramView.append(" progress: ");
      paramView.append(this.f);
      QLog.d("gifvideo.GifView", 1, paramView.toString());
      paramView = this.h;
      paramView.mTryCounts += 1;
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    paramView = this.f;
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append(System.currentTimeMillis());
    paramURLDrawable.append(" ");
    paramURLDrawable.append(paramInt);
    paramURLDrawable.append(" ");
    paramView.append(paramURLDrawable.toString());
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.a;
    if (this.b.get() != 0L) {
      l1 -= this.b.get();
    } else {
      l1 = l2;
    }
    int i;
    if (this.c.longValue() == 0L) {
      i = 1;
    } else {
      i = 0;
    }
    paramView = new StringBuilder();
    paramView.append("gif status: ");
    paramView.append(i);
    paramView.append(" file size: ");
    paramView.append(this.d);
    paramView.append(" download time: ");
    paramView.append(this.c);
    paramView.append(" load time: ");
    paramView.append(l2);
    QLog.d("gifvideo.GifView", 2, paramView.toString());
    paramView = new StringBuilder();
    paramView.append("gif status: ");
    paramView.append(i);
    paramView.append(" file size: ");
    paramView.append(this.d);
    paramView.append(" download time2: ");
    paramView.append(this.e);
    paramView.append(" load time2: ");
    paramView.append(l1);
    QLog.d("gifvideo.GifView", 2, paramView.toString());
    paramView = new StringBuilder();
    paramView.append(this.d);
    paramView.append("");
    paramView = paramView.toString();
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append(this.e);
    paramURLDrawable.append("");
    paramURLDrawable = paramURLDrawable.toString();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append(l2);
    PublicAccountReportUtils.a(null, "", "0X800A148", "0X800A148", 0, i, paramView, paramURLDrawable, (String)localObject, localStringBuilder.toString(), false);
    GifView.access$500(this.h);
    paramView = new StringBuilder();
    paramView.append("onLoadSuccess! mIsBigImg=");
    paramView.append(GifView.access$100(this.h));
    paramView.append(" w=");
    paramView.append(GifView.access$300(this.h));
    paramView.append(" h=");
    paramView.append(GifView.access$400(this.h));
    paramView.append(" progress: ");
    paramView.append(this.f);
    QLog.d("gifvideo.GifView", 1, paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.gif.GifView.2
 * JD-Core Version:    0.7.0.1
 */