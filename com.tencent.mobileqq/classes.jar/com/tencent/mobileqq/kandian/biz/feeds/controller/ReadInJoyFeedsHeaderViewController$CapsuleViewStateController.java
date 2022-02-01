package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyCapsuleView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

class ReadInJoyFeedsHeaderViewController$CapsuleViewStateController
  implements URLDrawable.URLDrawableListener, ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.GifStateListener
{
  private static ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster a = new ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster(null);
  private ReadInJoyCapsuleView b;
  private ChannelCoverInfo c;
  private URLDrawable d;
  private boolean e;
  
  ReadInJoyFeedsHeaderViewController$CapsuleViewStateController(ReadInJoyCapsuleView paramReadInJoyCapsuleView)
  {
    this.b = paramReadInJoyCapsuleView;
  }
  
  private void a(boolean paramBoolean)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = ReadInJoyFeedsHeaderViewController.i();
    localURLDrawableOptions.mFailedDrawable = ReadInJoyFeedsHeaderViewController.i();
    localURLDrawableOptions.mPlayGifImage = paramBoolean;
    try
    {
      this.d = URLDrawable.getDrawable(new URL(this.c.externalExposureBackgroundUrl), localURLDrawableOptions);
      this.b.setBackgroundSrc(this.d);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      QLog.e("ReadInJoyFeedsHeaderVie", 2, "fail to set background", localMalformedURLException);
    }
  }
  
  private void e()
  {
    this.e = false;
    this.b.a();
    this.b.setTextColor(Color.parseColor("#777777"));
    int i = ReadInJoyFeedsHeaderViewController.a(this.c.mChannelCoverId, false);
    if (i != 0)
    {
      ReadInJoyCapsuleView localReadInJoyCapsuleView = this.b;
      localReadInJoyCapsuleView.setDrawableLeft(localReadInJoyCapsuleView.getContext().getResources().getDrawable(i));
    }
    this.b.setBackgroundSrc(new ColorDrawable(Color.parseColor("#F1F3F6")));
  }
  
  private void f()
  {
    this.e = true;
    a(true);
    this.b.setColorFilter(ReadInJoyFeedsHeaderViewController.h());
    this.b.setTextColor(-1);
    int i = ReadInJoyFeedsHeaderViewController.a(this.c.mChannelCoverId, true);
    if (i != 0)
    {
      ReadInJoyCapsuleView localReadInJoyCapsuleView = this.b;
      localReadInJoyCapsuleView.setDrawableLeft(localReadInJoyCapsuleView.getContext().getResources().getDrawable(i));
    }
  }
  
  private void g()
  {
    a(true);
    URLDrawable localURLDrawable = this.d;
    if (localURLDrawable != null)
    {
      localURLDrawable.setURLDrawableListener(this);
      if (this.d.getStatus() == 1) {
        onLoadSuccessed(this.d);
      }
    }
  }
  
  public ChannelCoverInfo a()
  {
    return this.c;
  }
  
  void a(ChannelCoverInfo paramChannelCoverInfo, View.OnClickListener paramOnClickListener)
  {
    this.c = paramChannelCoverInfo;
    this.b.setOnClickListener(new ReadInJoyFeedsHeaderViewController.CapsuleViewStateController.1(this, paramOnClickListener));
    if ((!TextUtils.isEmpty(paramChannelCoverInfo.externalExposureBackgroundUrl)) && (!ReadInJoyHelper.h(paramChannelCoverInfo.mChannelCoverId)))
    {
      g();
      return;
    }
    e();
  }
  
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPlayOnce: pause the animation - ");
    ((StringBuilder)localObject).append(this.c.mChannelCoverName);
    QLog.d("ReadInJoyFeedsHeaderVie", 2, ((StringBuilder)localObject).toString());
    localObject = this.d;
    if (localObject != null)
    {
      localObject = ((URLDrawable)localObject).getCurrDrawable();
      if ((localObject instanceof GifDrawable))
      {
        this.d.setIndividualPause(true);
        ((GifDrawable)localObject).getImage().reset();
        this.d.setGIFPlayOnceListener(null);
        a(false);
        QLog.d("ReadInJoyFeedsHeaderVie", 2, "reset gif");
      }
    }
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public void d()
  {
    a.a();
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadCanceled: ");
    paramURLDrawable.append(this.c.externalExposureBackgroundUrl);
    QLog.d("ReadInJoyFeedsHeaderVie", 2, paramURLDrawable.toString());
    e();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadFialed: ");
    paramURLDrawable.append(this.c.externalExposureBackgroundUrl);
    QLog.d("ReadInJoyFeedsHeaderVie", 2, paramURLDrawable.toString());
    e();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadSuccessed: ");
    localStringBuilder.append(this.c.mChannelCoverName);
    QLog.d("ReadInJoyFeedsHeaderVie", 2, localStringBuilder.toString());
    f();
    AbstractGifImage.resumeAll();
    a.a(this, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyFeedsHeaderViewController.CapsuleViewStateController
 * JD-Core Version:    0.7.0.1
 */