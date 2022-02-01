package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

final class TroopAvatarWallEditActivity$Indicator
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private Drawable b;
  
  TroopAvatarWallEditActivity$Indicator(@NonNull LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidContentContext = paramLinearLayout.getContext();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BizTroopUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), Color.parseColor("#66ffffff"), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843874));
    this.b = BizTroopUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), Color.parseColor("#ffffffff"), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843874));
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      this.b.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    int i = ScreenUtil.dip2px(7.5F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(i, i);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = ScreenUtil.dip2px(7.0F);
  }
  
  void a(int paramInt)
  {
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    if (paramInt >= 0)
    {
      if (paramInt >= j) {
        return;
      }
      int i = 0;
      while (i < j)
      {
        View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        Drawable localDrawable;
        if (paramInt == i) {
          localDrawable = this.b;
        } else {
          localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        }
        localView.setBackgroundDrawable(localDrawable);
        i += 1;
      }
    }
  }
  
  void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() != paramInt)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      while (paramInt > 0)
      {
        View localView = new View(this.jdField_a_of_type_AndroidContentContext);
        localView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
        paramInt -= 1;
      }
    }
    a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.Indicator
 * JD-Core Version:    0.7.0.1
 */