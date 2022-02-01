package com.tencent.mobileqq.together.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.together.TogetherEntryData;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.mobileqq.utils.ViewUtils;

public class TogetherPopupDialog$TogetherEntryHolder
{
  TogetherPopupDialog.TogetherEntryItem a = null;
  TogetherPopupDialog.TogetherEntryItem b = null;
  
  void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (this.a == null) {
      this.a = new TogetherPopupDialog.TogetherEntryItem();
    }
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369970));
    this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView = ((RoundRectView)paramView.findViewById(2131369935));
    this.a.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369969));
    this.a.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369979));
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView = ((RoundRectUrlImageView)paramView.findViewById(2131369966));
    this.a.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369950));
    this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiHeadsPanelAnimationView = new HeadsPanelAnimationView();
    if (this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiHeadsPanelAnimationView.a() != null)
    {
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiHeadsPanelAnimationView.a());
    }
  }
  
  void a(TogetherEntryData paramTogetherEntryData, View.OnClickListener paramOnClickListener, Context paramContext)
  {
    if ((paramTogetherEntryData != null) && (paramOnClickListener != null))
    {
      if (paramContext == null) {
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setAllRadius(ViewUtils.b(12.0F));
      this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setBgColor(paramTogetherEntryData.d);
      this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setTag(paramTogetherEntryData);
      this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setOnClickListener(paramOnClickListener);
      if (AppSetting.d) {
        this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setContentDescription(paramTogetherEntryData.jdField_a_of_type_JavaLangString);
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramTogetherEntryData.jdField_a_of_type_JavaLangString);
      if (paramTogetherEntryData.jdField_a_of_type_Boolean)
      {
        this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiHeadsPanelAnimationView.a(paramTogetherEntryData.jdField_a_of_type_JavaUtilArrayList);
      }
      else
      {
        this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(paramTogetherEntryData.a());
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setAllRadius(ViewUtils.b(12.0F));
      if (!TextUtils.isEmpty(paramTogetherEntryData.c))
      {
        paramOnClickListener = URLDrawable.URLDrawableOptions.obtain();
        paramOnClickListener.mLoadingDrawable = TogetherEntryData.a(paramContext, paramTogetherEntryData);
        paramOnClickListener.mFailedDrawable = TogetherEntryData.a(paramContext, paramTogetherEntryData);
        paramTogetherEntryData = URLDrawable.getDrawable(paramTogetherEntryData.c, paramOnClickListener);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setImageDrawable(paramTogetherEntryData);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setImageResource(paramTogetherEntryData.e);
    }
  }
  
  void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (this.b == null) {
      this.b = new TogetherPopupDialog.TogetherEntryItem();
    }
    this.b.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376584));
    this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView = ((RoundRectView)paramView.findViewById(2131376550));
    this.b.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376583));
    this.b.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376595));
    this.b.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView = ((RoundRectUrlImageView)paramView.findViewById(2131376580));
    this.b.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376567));
    this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiHeadsPanelAnimationView = new HeadsPanelAnimationView();
    if (this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiHeadsPanelAnimationView.a() != null)
    {
      this.b.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.b.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiHeadsPanelAnimationView.a());
    }
  }
  
  void b(TogetherEntryData paramTogetherEntryData, View.OnClickListener paramOnClickListener, Context paramContext)
  {
    if ((paramTogetherEntryData != null) && (paramOnClickListener != null))
    {
      if (paramContext == null) {
        return;
      }
      this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setAllRadius(ViewUtils.b(12.0F));
      this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setBgColor(paramTogetherEntryData.d);
      this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setTag(paramTogetherEntryData);
      this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setOnClickListener(paramOnClickListener);
      if (AppSetting.d) {
        this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setContentDescription(paramTogetherEntryData.jdField_a_of_type_JavaLangString);
      }
      this.b.jdField_a_of_type_AndroidWidgetTextView.setText(paramTogetherEntryData.jdField_a_of_type_JavaLangString);
      if (paramTogetherEntryData.jdField_a_of_type_Boolean)
      {
        this.b.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiHeadsPanelAnimationView.a(paramTogetherEntryData.jdField_a_of_type_JavaUtilArrayList);
      }
      else
      {
        this.b.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      this.b.jdField_b_of_type_AndroidWidgetTextView.setText(paramTogetherEntryData.a());
      this.b.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setAllRadius(ViewUtils.b(12.0F));
      if (!TextUtils.isEmpty(paramTogetherEntryData.c))
      {
        paramOnClickListener = URLDrawable.URLDrawableOptions.obtain();
        paramOnClickListener.mLoadingDrawable = TogetherEntryData.a(paramContext, paramTogetherEntryData);
        paramOnClickListener.mFailedDrawable = TogetherEntryData.a(paramContext, paramTogetherEntryData);
        paramTogetherEntryData = URLDrawable.getDrawable(paramTogetherEntryData.c, paramOnClickListener);
        this.b.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setImageDrawable(paramTogetherEntryData);
        return;
      }
      this.b.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setImageResource(paramTogetherEntryData.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.TogetherPopupDialog.TogetherEntryHolder
 * JD-Core Version:    0.7.0.1
 */