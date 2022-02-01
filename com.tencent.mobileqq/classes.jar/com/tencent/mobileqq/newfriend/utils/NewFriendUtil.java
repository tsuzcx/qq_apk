package com.tencent.mobileqq.newfriend.utils;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.newfriend.ui.fragment.NewFriendVerifyBlockedListFragment;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.ThemeLabelTextView;

public class NewFriendUtil
{
  public static void a(Activity paramActivity)
  {
    NewFriendVerifyBlockedListFragment.a(paramActivity);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130839395);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839393);
      return;
    }
    paramView.setBackgroundResource(2130839390);
  }
  
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    int i;
    int j;
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        paramTextView.setBackgroundResource(2130846056);
        i = 0;
        j = 0;
      }
      else
      {
        paramTextView.setBackgroundResource(2130846054);
        if ((paramStringBuilder != null) && (AppSetting.d)) {
          paramStringBuilder.append(",女");
        }
        i = 1;
        j = 2130846053;
      }
    }
    else
    {
      j = 2130846055;
      paramTextView.setBackgroundResource(2130846056);
      if ((paramStringBuilder != null) && (AppSetting.d)) {
        paramStringBuilder.append(",男");
      }
      i = 1;
    }
    if ((paramInt2 > 0) && ((paramInt1 == 0) || (paramInt1 == 1)))
    {
      paramTextView.setText(String.valueOf(paramInt2));
      if ((paramStringBuilder != null) && (AppSetting.d))
      {
        paramStringBuilder.append(",");
        paramStringBuilder.append(String.valueOf(paramInt2));
      }
      i = 1;
    }
    else
    {
      paramTextView.setText("");
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
    if (i != 0)
    {
      if ((paramTextView instanceof ThemeLabelTextView)) {
        ((ThemeLabelTextView)paramTextView).setSupportMaskView(true);
      }
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.utils.NewFriendUtil
 * JD-Core Version:    0.7.0.1
 */