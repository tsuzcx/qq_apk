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
  private static ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$GifPlayOnceEventMultiCaster = new ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster(null);
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private ReadInJoyCapsuleView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView;
  private ChannelCoverInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo;
  private boolean jdField_a_of_type_Boolean;
  
  ReadInJoyFeedsHeaderViewController$CapsuleViewStateController(ReadInJoyCapsuleView paramReadInJoyCapsuleView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView = paramReadInJoyCapsuleView;
  }
  
  private void a(boolean paramBoolean)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = ReadInJoyFeedsHeaderViewController.a();
    localURLDrawableOptions.mFailedDrawable = ReadInJoyFeedsHeaderViewController.a();
    localURLDrawableOptions.mPlayGifImage = paramBoolean;
    try
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(new URL(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo.externalExposureBackgroundUrl), localURLDrawableOptions);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView.setBackgroundSrc(this.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      QLog.e("ReadInJoyFeedsHeaderVie", 2, "fail to set background", localMalformedURLException);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView.setTextColor(Color.parseColor("#777777"));
    int i = ReadInJoyFeedsHeaderViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo.mChannelCoverId, false);
    if (i != 0)
    {
      ReadInJoyCapsuleView localReadInJoyCapsuleView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView;
      localReadInJoyCapsuleView.setDrawableLeft(localReadInJoyCapsuleView.getContext().getResources().getDrawable(i));
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView.setBackgroundSrc(new ColorDrawable(Color.parseColor("#F1F3F6")));
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = true;
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView.setColorFilter(ReadInJoyFeedsHeaderViewController.a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView.setTextColor(-1);
    int i = ReadInJoyFeedsHeaderViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo.mChannelCoverId, true);
    if (i != 0)
    {
      ReadInJoyCapsuleView localReadInJoyCapsuleView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView;
      localReadInJoyCapsuleView.setDrawableLeft(localReadInJoyCapsuleView.getContext().getResources().getDrawable(i));
    }
  }
  
  private void e()
  {
    a(true);
    URLDrawable localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localURLDrawable != null)
    {
      localURLDrawable.setURLDrawableListener(this);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) {
        onLoadSuccessed(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
    }
  }
  
  public ChannelCoverInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo;
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPlayOnce: pause the animation - ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo.mChannelCoverName);
    QLog.d("ReadInJoyFeedsHeaderVie", 2, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localObject != null)
    {
      localObject = ((URLDrawable)localObject).getCurrDrawable();
      if ((localObject instanceof GifDrawable))
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable.setIndividualPause(true);
        ((GifDrawable)localObject).getImage().reset();
        this.jdField_a_of_type_ComTencentImageURLDrawable.setGIFPlayOnceListener(null);
        a(false);
        QLog.d("ReadInJoyFeedsHeaderVie", 2, "reset gif");
      }
    }
  }
  
  void a(ChannelCoverInfo paramChannelCoverInfo, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo = paramChannelCoverInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView.setOnClickListener(new ReadInJoyFeedsHeaderViewController.CapsuleViewStateController.1(this, paramOnClickListener));
    if ((!TextUtils.isEmpty(paramChannelCoverInfo.externalExposureBackgroundUrl)) && (!ReadInJoyHelper.b(paramChannelCoverInfo.mChannelCoverId)))
    {
      e();
      return;
    }
    c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$GifPlayOnceEventMultiCaster.a();
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadCanceled: ");
    paramURLDrawable.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo.externalExposureBackgroundUrl);
    QLog.d("ReadInJoyFeedsHeaderVie", 2, paramURLDrawable.toString());
    c();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadFialed: ");
    paramURLDrawable.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo.externalExposureBackgroundUrl);
    QLog.d("ReadInJoyFeedsHeaderVie", 2, paramURLDrawable.toString());
    c();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadSuccessed: ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo.mChannelCoverName);
    QLog.d("ReadInJoyFeedsHeaderVie", 2, localStringBuilder.toString());
    d();
    AbstractGifImage.resumeAll();
    jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$GifPlayOnceEventMultiCaster.a(this, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyFeedsHeaderViewController.CapsuleViewStateController
 * JD-Core Version:    0.7.0.1
 */