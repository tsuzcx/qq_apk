package com.tencent.mobileqq.hotpic;

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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class HotPicPageView$MyVideoViewHolder
  extends HotPicPageView.MyViewHolder
  implements URLDrawable.DownloadListener, HotVideoMongoliaRelativeLayout.OnVideoControlStateListener
{
  public int a;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  WeakReference<HotVideoData> jdField_a_of_type_JavaLangRefWeakReference;
  public boolean a;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  TextView d;
  
  public HotPicPageView$MyVideoViewHolder(HotPicPageView paramHotPicPageView, View paramView, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramHotPicPageView, paramView, paramOnHolderItemClickListener);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -10;
    if (this.itemView != null) {
      this.itemView.setOnTouchListener(null);
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368304));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368310));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368309));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380762));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380768));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380692));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373023));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380703));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380763));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364639);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380554));
  }
  
  public HotVideoData a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference == null) {
      return null;
    }
    return (HotVideoData)localWeakReference.get();
  }
  
  public HotVideoMongoliaRelativeLayout a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null)
    {
      if (((RelativeLayout)localObject).getChildCount() == 0) {
        return null;
      }
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewWithTag("HotVideoControlTag");
      if (localObject == null) {
        return null;
      }
      if ((localObject instanceof HotVideoMongoliaRelativeLayout)) {
        return (HotVideoMongoliaRelativeLayout)localObject;
      }
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
    ThreadManager.getUIHandler().post(new HotPicPageView.MyVideoViewHolder.2(this, paramInt));
  }
  
  public void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (HotPicPageView.b())
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        return;
      }
      ThreadManager.getUIHandler().post(new HotPicPageView.MyVideoViewHolder.1(this, paramDrawable));
    }
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
    ThreadManager.getUIHandler().post(new HotPicPageView.MyVideoViewHolder.6(this, paramString));
  }
  
  public boolean a(HotVideoData paramHotVideoData)
  {
    if (paramHotVideoData == null) {
      return false;
    }
    HotVideoData localHotVideoData = a();
    if (localHotVideoData == null) {
      return false;
    }
    return localHotVideoData.equals(paramHotVideoData);
  }
  
  public void b()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
    localValueAnimator.setTarget(this.itemView);
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new HotPicPageView.MyVideoViewHolder.4(this));
    localValueAnimator.start();
  }
  
  public void b(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    c();
    Object localObject;
    if (paramInt != -11)
    {
      if (paramInt != -10)
      {
        switch (paramInt)
        {
        default: 
          break;
        case 6: 
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.itemView.setContentDescription(HardCodeUtil.a(2131705698));
          break;
        case 5: 
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.itemView.setContentDescription(HardCodeUtil.a(2131705697));
          break;
        case 4: 
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.itemView.setContentDescription(HardCodeUtil.a(2131705696));
          b();
          break;
        case 3: 
          if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0)
          {
            int i = this.jdField_a_of_type_Int;
            if ((i == 1) || (i == 2))
            {
              localObject = new AlphaAnimation(1.0F, 0.8F);
              ((AlphaAnimation)localObject).setDuration(600L);
              ((AlphaAnimation)localObject).setAnimationListener(new HotPicPageView.MyVideoViewHolder.3(this));
              this.jdField_d_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
              break label381;
            }
          }
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.itemView.setContentDescription(HardCodeUtil.a(2131705694));
          break;
        case 1: 
        case 2: 
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
          break;
        case 0: 
          label381:
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          a();
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.itemView.setContentDescription(HardCodeUtil.a(2131705695));
          break;
        }
      }
      else
      {
        d();
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.setContentDescription("");
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      a();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.itemView.setContentDescription(HardCodeUtil.a(2131705692));
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Int = paramInt;
    if ((paramInt == 0) && (this.jdField_a_of_type_Boolean))
    {
      localObject = a();
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.c(this, ((HotVideoData)localObject).picIndex);
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void b(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (HotPicPageView.b())
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        return;
      }
      ThreadManager.getUIHandler().post(new HotPicPageView.MyVideoViewHolder.5(this, paramDrawable));
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicOnHolderItemClickListener != null)
    {
      int i = this.jdField_a_of_type_Int;
      if ((i == 0) || (i == -11))
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicOnHolderItemClickListener.c(this, getPosition());
        break label52;
      }
    }
    if (this.jdField_a_of_type_Int == 1) {
      a(0);
    }
    label52:
    EventCollector.getInstance().onViewClicked(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.MyVideoViewHolder
 * JD-Core Version:    0.7.0.1
 */