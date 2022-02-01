package com.tencent.mobileqq.troop.troopapps;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AppsSearchViewBuilder
  extends AppsBaseBuilder
  implements View.OnClickListener, View.OnTouchListener
{
  AppsSearchViewBuilder(Context paramContext, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Bundle paramBundle)
  {
    super(paramContext, paramQQAppInterface, paramFragmentActivity, null, paramBundle);
  }
  
  private void a(View paramView)
  {
    ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800AFBF", "0X800AFBF", 0, 0, String.valueOf(this.jdField_b_of_type_Long), "", "", "");
    if (!TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) {
      return;
    }
    TroopAppShortcutUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new AppsSearchViewBuilder.ItemViewHolder();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559987, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370312));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131377599));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      if (!this.jdField_b_of_type_Boolean) {
        break label180;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      label95:
      if (AppSetting.d) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131720042));
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label192;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      localView.setBackgroundColor(-16777216);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
      return localView;
      paramViewGroup = (AppsSearchViewBuilder.ItemViewHolder)paramView.getTag();
      localView = paramView;
      break;
      label180:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label95;
      label192:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public Object a()
  {
    return null;
  }
  
  public void a_(Object paramObject) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramView.setAlpha(0.5F);
        continue;
        if (Build.VERSION.SDK_INT >= 11) {
          paramView.setAlpha(1.0F);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.AppsSearchViewBuilder
 * JD-Core Version:    0.7.0.1
 */