package com.tencent.mobileqq.nearby.interestTag;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import auwk;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;

public class ChooseInterestTagActivity$9$1
  implements Runnable
{
  public ChooseInterestTagActivity$9$1(auwk paramauwk, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int >= 0)
    {
      ((RelativeLayout.LayoutParams)ChooseInterestTagActivity.a(this.jdField_a_of_type_Auwk.a).getLayoutParams()).leftMargin = ((int)(this.jdField_a_of_type_Int + ChooseInterestTagActivity.a(this.jdField_a_of_type_Auwk.a) * 7.0F));
      ChooseInterestTagActivity.a(this.jdField_a_of_type_Auwk.a).requestLayout();
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (ChooseInterestTagActivity.a(this.jdField_a_of_type_Auwk.a).getChildCount() <= 0)
    {
      ChooseInterestTagActivity.a(this.jdField_a_of_type_Auwk.a).setVisibility(8);
      if (ChooseInterestTagActivity.b(this.jdField_a_of_type_Auwk.a))
      {
        localLayoutParams = (RelativeLayout.LayoutParams)ChooseInterestTagActivity.a(this.jdField_a_of_type_Auwk.a).getLayoutParams();
        localLayoutParams.height = 1;
        if (!ChooseInterestTagActivity.a(this.jdField_a_of_type_Auwk.a)) {
          break label183;
        }
      }
    }
    label183:
    for (int i = (int)(ChooseInterestTagActivity.a(this.jdField_a_of_type_Auwk.a) * 7.0F + 0.5D);; i = 0)
    {
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = i;
      ChooseInterestTagActivity.a(this.jdField_a_of_type_Auwk.a).setLayoutParams(localLayoutParams);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.9.1
 * JD-Core Version:    0.7.0.1
 */