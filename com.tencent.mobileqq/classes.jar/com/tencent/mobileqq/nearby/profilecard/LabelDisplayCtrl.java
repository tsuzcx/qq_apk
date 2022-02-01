package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;

public class LabelDisplayCtrl
  extends LabelBaseCtrl
{
  protected View a;
  
  protected int a()
  {
    return 2131561340;
  }
  
  protected LabelContainer a(View paramView, int paramInt1, InterestTag paramInterestTag, int paramInt2)
  {
    paramInterestTag = (ImageView)paramView.findViewById(2131380840);
    if (paramInt1 == 7) {
      paramInterestTag.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() != 0)
      {
        paramInterestTag = (LinearLayout.LayoutParams)paramView.getLayoutParams();
        paramInterestTag.topMargin = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 16.0F);
        paramView.setLayoutParams(paramInterestTag);
      }
      paramInt1 = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      paramInt2 = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      paramView = (LabelContainer)paramView.findViewById(2131370030);
      paramView.setSpace(paramInt1, paramInt2);
      return paramView;
      paramInterestTag.setImageResource(b[paramInt1]);
    }
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout, View paramView)
  {
    super.a(paramContext, paramLinearLayout);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean a(InterestTag[] paramArrayOfInterestTag)
  {
    if (super.a(paramArrayOfInterestTag))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.LabelDisplayCtrl
 * JD-Core Version:    0.7.0.1
 */