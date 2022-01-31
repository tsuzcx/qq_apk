package com.tencent.mobileqq.hotpic;

import adqs;
import adqt;
import adqu;
import adqv;
import adqw;
import adqx;
import adqy;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class HotPicPageView$MyVideoViewHolder
  extends adqy
  implements URLDrawable.DownloadListener, HotVideoMongoliaRelativeLayout.OnVideoControlStateListener
{
  public int a;
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public boolean a;
  public ImageView b;
  RelativeLayout b;
  public TextView b;
  ImageView c;
  public RelativeLayout c;
  public TextView c;
  TextView d;
  
  public HotPicPageView$MyVideoViewHolder(HotPicPageView paramHotPicPageView, View paramView, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramHotPicPageView, paramView, paramOnHolderItemClickListener);
    this.jdField_a_of_type_Int = -10;
    if (this.itemView != null) {
      this.itemView.setOnTouchListener(null);
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362993));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362997));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362996));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362999));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363000));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363001));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363002));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363003));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362998));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363004);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362995));
  }
  
  public HotVideoData a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (HotVideoData)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public HotVideoMongoliaRelativeLayout a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() == 0)) {
      return null;
    }
    View localView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewWithTag("HotVideoControlTag");
    if (localView == null) {
      return null;
    }
    if ((localView instanceof HotVideoMongoliaRelativeLayout)) {
      return (HotVideoMongoliaRelativeLayout)localView;
    }
    return null;
  }
  
  public void a()
  {
    c();
    HotVideoMongoliaRelativeLayout localHotVideoMongoliaRelativeLayout = a();
    if (localHotVideoMongoliaRelativeLayout != null)
    {
      localHotVideoMongoliaRelativeLayout.setVidoeControlListener(null);
      localHotVideoMongoliaRelativeLayout.setControlStateListener(null);
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder == this) {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder = null;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localHotVideoMongoliaRelativeLayout);
    }
  }
  
  public void a(int paramInt)
  {
    if (HotPicPageView.b())
    {
      b(paramInt);
      return;
    }
    ThreadManager.getUIHandler().post(new adqt(this, paramInt));
  }
  
  public void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (HotPicPageView.b()) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      }
    }
    else {
      return;
    }
    ThreadManager.getUIHandler().post(new adqs(this, paramDrawable));
  }
  
  public void a(HotVideoData paramHotVideoData)
  {
    if (paramHotVideoData == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHotVideoData);
  }
  
  public void a(String paramString)
  {
    if (HotPicPageView.b())
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
      return;
    }
    ThreadManager.getUIHandler().post(new adqx(this, paramString));
  }
  
  public boolean a(HotVideoData paramHotVideoData)
  {
    if (paramHotVideoData == null) {}
    HotVideoData localHotVideoData;
    do
    {
      return false;
      localHotVideoData = a();
    } while (localHotVideoData == null);
    return localHotVideoData.equals(paramHotVideoData);
  }
  
  public void b()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
    localValueAnimator.setTarget(this.itemView);
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new adqv(this));
    localValueAnimator.start();
  }
  
  public void b(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    c();
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      if ((paramInt != 0) || (!this.jdField_a_of_type_Boolean)) {
        break;
      }
      Object localObject = a();
      if (localObject == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.c(this, ((HotVideoData)localObject).picIndex);
      this.jdField_a_of_type_Boolean = false;
      return;
      d();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.setContentDescription("");
      this.jdField_a_of_type_Boolean = false;
      continue;
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      a();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.itemView.setContentDescription("选中视频");
      continue;
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      a();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.itemView.setContentDescription("选中视频");
      this.jdField_a_of_type_Boolean = false;
      continue;
      this.jdField_a_of_type_Boolean = false;
      if (paramInt == 1) {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a(this);
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      continue;
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.itemView.setContentDescription("暂停播放");
      continue;
      if ((this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0) && ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)))
      {
        localObject = new AlphaAnimation(1.0F, 0.8F);
        ((AlphaAnimation)localObject).setDuration(600L);
        ((AlphaAnimation)localObject).setAnimationListener(new adqu(this));
        this.jdField_d_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.itemView.setContentDescription("暂停播放");
        break;
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.itemView.setContentDescription("开始播放");
      b();
      continue;
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.itemView.setContentDescription("开始播放");
    }
  }
  
  public void b(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (HotPicPageView.b()) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      }
    }
    else {
      return;
    }
    ThreadManager.getUIHandler().post(new adqw(this, paramDrawable));
  }
  
  public void c()
  {
    this.itemView.clearAnimation();
  }
  
  public void c(int paramInt)
  {
    a(paramInt);
  }
  
  public void d()
  {
    this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_Int = -10;
    a();
    e();
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void e()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(0));
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicOnHolderItemClickListener != null) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == -11))) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicOnHolderItemClickListener.c(this, getPosition());
    }
    while (this.jdField_a_of_type_Int != 1) {
      return;
    }
    a(0);
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "HotPreview Download onFileDownloadFailed");
    }
    HotVideoData localHotVideoData = a();
    if ((localHotVideoData != null) && (localHotVideoData.picIndex == paramInt)) {
      a(-10);
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher.a();
  }
  
  public void onFileDownloadStarted()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "HotPreview Download onFileDownloadStarted");
    }
    a();
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "HotPreview Download onFileDownloadSucceed");
    }
    HotVideoData localHotVideoData = a();
    if ((localHotVideoData != null) && (localHotVideoData.picIndex == paramLong))
    {
      if (this.jdField_a_of_type_Int == -10) {
        a(0);
      }
      if (localHotVideoData.CheckIsNeedBlurBackground())
      {
        b(new ColorDrawable(Color.parseColor("#7f000000")));
        if ((Build.VERSION.SDK_INT >= 17) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.a()) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager != null)) {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoBlurTaskManager.a(this, localHotVideoData);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher.a();
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.MyVideoViewHolder
 * JD-Core Version:    0.7.0.1
 */