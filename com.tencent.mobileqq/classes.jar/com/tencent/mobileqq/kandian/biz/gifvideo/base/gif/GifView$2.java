package com.tencent.mobileqq.kandian.biz.gifvideo.base.gif;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

class GifView$2
  implements URLDrawableDownListener
{
  GifView$2(GifView paramGifView, long paramLong, AtomicLong paramAtomicLong1, AtomicLong paramAtomicLong2, AtomicLong paramAtomicLong3, AtomicLong paramAtomicLong4, StringBuilder paramStringBuilder, URLDrawable paramURLDrawable) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (GifView.access$000(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView))
    {
      if (GifView.access$100(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView)) {
        GifView.access$200(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView);
      } else {
        this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
      }
      paramView = new StringBuilder();
      paramView.append("onLoadFialed! mIsBigImg=");
      paramView.append(GifView.access$100(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView));
      paramView.append(" w=");
      paramView.append(GifView.access$300(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView));
      paramView.append(" h=");
      paramView.append(GifView.access$400(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView));
      paramView.append(" progress: ");
      paramView.append(this.jdField_a_of_type_JavaLangStringBuilder);
      QLog.d("gifvideo.GifView", 1, paramView.toString());
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView;
      paramView.mTryCounts += 1;
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    paramView = this.jdField_a_of_type_JavaLangStringBuilder;
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
    long l2 = l1 - this.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get() != 0L) {
      l1 -= this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
    } else {
      l1 = l2;
    }
    int i;
    if (this.b.longValue() == 0L) {
      i = 1;
    } else {
      i = 0;
    }
    paramView = new StringBuilder();
    paramView.append("gif status: ");
    paramView.append(i);
    paramView.append(" file size: ");
    paramView.append(this.c);
    paramView.append(" download time: ");
    paramView.append(this.b);
    paramView.append(" load time: ");
    paramView.append(l2);
    QLog.d("gifvideo.GifView", 2, paramView.toString());
    paramView = new StringBuilder();
    paramView.append("gif status: ");
    paramView.append(i);
    paramView.append(" file size: ");
    paramView.append(this.c);
    paramView.append(" download time2: ");
    paramView.append(this.d);
    paramView.append(" load time2: ");
    paramView.append(l1);
    QLog.d("gifvideo.GifView", 2, paramView.toString());
    paramView = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append(this.c);
    paramURLDrawable.append("");
    paramURLDrawable = paramURLDrawable.toString();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.d);
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append(l2);
    paramView.publicAccountReportClickEvent(null, "", "0X800A148", "0X800A148", 0, i, paramURLDrawable, (String)localObject1, (String)localObject2, localStringBuilder.toString(), false);
    GifView.access$500(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView);
    paramView = new StringBuilder();
    paramView.append("onLoadSuccess! mIsBigImg=");
    paramView.append(GifView.access$100(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView));
    paramView.append(" w=");
    paramView.append(GifView.access$300(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView));
    paramView.append(" h=");
    paramView.append(GifView.access$400(this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseGifGifView));
    paramView.append(" progress: ");
    paramView.append(this.jdField_a_of_type_JavaLangStringBuilder);
    QLog.d("gifvideo.GifView", 1, paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.gif.GifView.2
 * JD-Core Version:    0.7.0.1
 */