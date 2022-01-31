package com.tencent.mobileqq.leba.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.LebaFeedInfo;
import com.tencent.mobileqq.leba.LebaFeedsAdapter.ListItem;
import com.tencent.mobileqq.leba.LebaUtils;
import com.tencent.mobileqq.leba.UITemplate.BaseUITemplateInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class LebaFeedsNativeViewBase
  extends LebaFeedsViewBase
{
  protected FrameLayout a;
  protected TextView a;
  protected TextView b;
  
  public LebaFeedsNativeViewBase(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2130969494, this, true);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131362840));
    this.e = ((RelativeLayout)super.findViewById(2131363109));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366697));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366698));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366699));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131366703);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131363057));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363378));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363538));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131366706));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    super.h();
    e();
  }
  
  public void a(LebaFeedsAdapter.ListItem paramListItem)
  {
    if ((paramListItem == null) || (paramListItem.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo == null)) {
      return;
    }
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo = paramListItem.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo.templateInfo;
    if (localObject == null)
    {
      QLog.e("LebaFeedsNativeViewBase", 1, "fillData template info is null");
      return;
    }
    a(this.jdField_a_of_type_AndroidWidgetTextView, ((BaseUITemplateInfo)localObject).f, true);
    a(this.jdField_b_of_type_AndroidWidgetTextView, ((BaseUITemplateInfo)localObject).g, true);
    if (TextUtils.isEmpty(((BaseUITemplateInfo)localObject).h)) {
      a(this.jdField_c_of_type_AndroidWidgetTextView, "", false);
    }
    while (!TextUtils.isEmpty(paramListItem.c))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = jdField_d_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = jdField_d_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramListItem = URLDrawable.getDrawable(paramListItem.c, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramListItem);
      return;
      if (TextUtils.isEmpty(((BaseUITemplateInfo)localObject).i)) {
        a(this.jdField_c_of_type_AndroidWidgetTextView, ((BaseUITemplateInfo)localObject).h, false);
      } else {
        a(this.jdField_c_of_type_AndroidWidgetTextView, ((BaseUITemplateInfo)localObject).h + "-" + ((BaseUITemplateInfo)localObject).i, false);
      }
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    QLog.i("LebaFeedsNativeViewBase", 2, "fillData, provider icon is null, feedsId=" + paramListItem.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo.feedID);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(LebaUtils.c(0)));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(LebaUtils.c(1)));
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(LebaUtils.c(2)));
    }
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(LebaUtils.d(0));
    }
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaFeedsNativeViewBase
 * JD-Core Version:    0.7.0.1
 */