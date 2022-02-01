package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.fastweb.data.ImageData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;
import mqq.os.MqqHandler;

class WebFastImageViewCreator$ImageViewHolder$1
  implements URLDrawableDownListener
{
  WebFastImageViewCreator$ImageViewHolder$1(WebFastImageViewCreator.ImageViewHolder paramImageViewHolder) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    paramView = new StringBuilder();
    paramView.append(" onLoadFailed: ");
    paramView.append(paramURLDrawable.getURL().toString());
    paramView.append(" retryCnt: ");
    paramView.append(WebFastImageViewCreator.ImageViewHolder.a(this.a));
    QLog.d("Q.readinjoy.fast_web", 2, paramView.toString());
    paramThrowable = (ImageData)this.a.a;
    boolean bool = WebFastImageViewCreator.a(paramURLDrawable.getURL().getFile());
    IPublicAccountHttpDownloader localIPublicAccountHttpDownloader = (IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class);
    if (bool) {
      paramView = WebFastImageViewCreator.a(paramThrowable.jdField_a_of_type_JavaLangString, paramThrowable);
    } else {
      paramView = paramThrowable.jdField_a_of_type_JavaLangString;
    }
    paramView = localIPublicAccountHttpDownloader.makeURL(paramView, 4);
    if ((paramView != null) && (paramView.equals(paramURLDrawable.getURL())))
    {
      if (WebFastImageViewCreator.ImageViewHolder.b(this.a) < 2) {
        WebFastImageViewCreator.ImageViewHolder.c(this.a);
      }
      WebFastImageViewCreator.ImageViewHolder.d(this.a);
      if ((bool) && (WebFastImageViewCreator.ImageViewHolder.a(this.a) < 3))
      {
        paramThrowable.jdField_a_of_type_Boolean = false;
        ThreadManager.getUIHandler().post(new WebFastImageViewCreator.ImageViewHolder.1.1(this, paramThrowable));
      }
      paramView = new HashMap();
      paramView.put("isSharpP", String.valueOf(bool));
      paramView.put("url", paramThrowable.jdField_a_of_type_JavaLangString);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "NativeWebImageUI", false, 0L, 0L, paramView, "", true);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    ImageData localImageData = (ImageData)this.a.a;
    boolean bool = WebFastImageViewCreator.a(paramURLDrawable.getURL().getFile());
    IPublicAccountHttpDownloader localIPublicAccountHttpDownloader = (IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class);
    if (bool) {
      paramView = WebFastImageViewCreator.a(localImageData.jdField_a_of_type_JavaLangString, localImageData);
    } else {
      paramView = localImageData.jdField_a_of_type_JavaLangString;
    }
    paramView = localIPublicAccountHttpDownloader.makeURL(paramView, 4);
    if ((paramView != null) && (paramView.equals(paramURLDrawable.getURL())))
    {
      if ((localImageData.jdField_a_of_type_Int == 0) || (localImageData.b == 0))
      {
        WebFastImageViewCreator.ImageViewHolder.a(this.a, paramURLDrawable);
        WebFastImageViewCreator.ImageViewHolder.a(this.a).setImageDrawable(paramURLDrawable);
      }
      paramView = new HashMap();
      paramView.put("isSharpP", String.valueOf(bool));
      paramView.put("url", localImageData.jdField_a_of_type_JavaLangString);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "NativeWebImageUI", true, 0L, 0L, paramView, "", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastImageViewCreator.ImageViewHolder.1
 * JD-Core Version:    0.7.0.1
 */