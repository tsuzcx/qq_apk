package com.tencent.mobileqq.leba.view;

import aejo;
import aejp;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.LebaFeedInfo;
import com.tencent.mobileqq.leba.LebaFeedsAdapter.ListItem;
import com.tencent.mobileqq.leba.LebaUtils;
import com.tencent.mobileqq.leba.UITemplate.ARKUITemplateInfo;
import com.tencent.mobileqq.leba.ark.LebaArkReporter;
import com.tencent.mobileqq.leba.ark.LebaFeedsArkHelper;
import com.tencent.mobileqq.leba.ark.LebaFeedsArkHelper.CacheItem;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class LebaFeedsArkView
  extends LebaFeedsViewBase
  implements View.OnTouchListener
{
  protected static int a;
  protected static int b;
  protected float a;
  protected FrameLayout a;
  protected TextView a;
  protected ArkAppContainer a;
  protected ArkAppLoadLayout a;
  public ArkAppView a;
  protected ARKUITemplateInfo a;
  protected float b;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -1;
  }
  
  public LebaFeedsArkView(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2130969488, this, true);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363062));
    this.e = ((RelativeLayout)super.findViewById(2131363113));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366696));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366695));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366697));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131366701);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)super.findViewById(2131365252));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131366694));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366698));
    if (jdField_a_of_type_Int < 0) {
      jdField_a_of_type_Int = (int)(DeviceInfoUtil.n() - AIOUtils.a(40.0F, getResources()));
    }
    if (jdField_b_of_type_Int < 0) {
      jdField_b_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    super.h();
    e();
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaFeedsArkView", 2, "refreshArkView.");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqLebaUITemplateARKUITemplateInfo == null))
    {
      QLog.d("LebaFeedsArkView", 1, "refreshArkView. feedInfo or templateInfo is null");
      return;
    }
    Object localObject = LebaFeedsArkHelper.a().a(getContext(), this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo.feedID, this.jdField_a_of_type_ComTencentMobileqqLebaUITemplateARKUITemplateInfo);
    if (localObject == null)
    {
      QLog.d("LebaFeedsArkView", 1, "refreshArkView. cacheItem is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((LebaFeedsArkHelper.CacheItem)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer = ((LebaFeedsArkHelper.CacheItem)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
      }
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
  }
  
  public void a(LebaFeedsAdapter.ListItem paramListItem)
  {
    if ((paramListItem == null) || (paramListItem.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo == null) || (paramListItem.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo.templateInfo == null) || (!(paramListItem.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo.templateInfo instanceof ARKUITemplateInfo))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo = paramListItem.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo;
    Object localObject = (ARKUITemplateInfo)this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo.templateInfo;
    ARKUITemplateInfo localARKUITemplateInfo = this.jdField_a_of_type_ComTencentMobileqqLebaUITemplateARKUITemplateInfo;
    this.jdField_a_of_type_ComTencentMobileqqLebaUITemplateARKUITemplateInfo = ((ARKUITemplateInfo)localObject);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqLebaUITemplateARKUITemplateInfo.h))
    {
      a(this.jdField_c_of_type_AndroidWidgetTextView, "", false);
      if (TextUtils.isEmpty(paramListItem.c)) {
        break label334;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = jdField_d_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = jdField_d_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramListItem = URLDrawable.getDrawable(paramListItem.c, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramListItem);
    }
    for (;;)
    {
      if ((localARKUITemplateInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqLebaUITemplateARKUITemplateInfo.equals(localARKUITemplateInfo))) {
        a();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new aejo(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(new aejp(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.a(jdField_a_of_type_Int, jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this);
      }
      c();
      LebaArkReporter.a().b();
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqLebaUITemplateARKUITemplateInfo.i))
      {
        a(this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqLebaUITemplateARKUITemplateInfo.h, false);
        break;
      }
      a(this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqLebaUITemplateARKUITemplateInfo.h + "-" + this.jdField_a_of_type_ComTencentMobileqqLebaUITemplateARKUITemplateInfo.i, false);
      break;
      label334:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      QLog.i("LebaFeedsArkView", 2, "fillData, provider icon is null, feedsId=" + paramListItem.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo.feedID);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaFeedsArkView", 2, "pauseArk");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.doOnEvent(0);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaFeedsArkView", 2, "resumeArk");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.doOnEvent(1);
    }
  }
  
  public void d()
  {
    super.d();
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setPressed(false);
  }
  
  public void e()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(LebaUtils.c(2)));
    }
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(LebaUtils.d(0));
    }
    super.g();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer != null) {
          bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.onTouch(paramView, paramMotionEvent);
        }
      }
      return bool1;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setPressed(true);
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      continue;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setPressed(false);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = this.jdField_a_of_type_Float;
      float f4 = this.jdField_a_of_type_Float;
      float f5 = this.jdField_b_of_type_Float;
      if ((f1 - f4) * (f1 - f3) + (f2 - this.jdField_b_of_type_Float) * (f2 - f5) <= jdField_b_of_type_Int * jdField_b_of_type_Int)
      {
        super.onClick(this.jdField_d_of_type_AndroidWidgetRelativeLayout);
        continue;
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setPressed(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaFeedsArkView
 * JD-Core Version:    0.7.0.1
 */