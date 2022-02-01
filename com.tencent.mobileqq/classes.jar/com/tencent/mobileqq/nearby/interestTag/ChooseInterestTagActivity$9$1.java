package com.tencent.mobileqq.nearby.interestTag;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;

class ChooseInterestTagActivity$9$1
  implements Runnable
{
  ChooseInterestTagActivity$9$1(ChooseInterestTagActivity.9 param9, int paramInt) {}
  
  public void run()
  {
    if (this.a >= 0)
    {
      ((RelativeLayout.LayoutParams)ChooseInterestTagActivity.access$3000(this.b.a).getLayoutParams()).leftMargin = ((int)(this.a + ChooseInterestTagActivity.access$3100(this.b.a) * 7.0F));
      ChooseInterestTagActivity.access$3000(this.b.a).requestLayout();
    }
    if (ChooseInterestTagActivity.access$600(this.b.a).getChildCount() <= 0)
    {
      ChooseInterestTagActivity.access$500(this.b.a).setVisibility(8);
      if (ChooseInterestTagActivity.access$3200(this.b.a))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)ChooseInterestTagActivity.access$3000(this.b.a).getLayoutParams();
        localLayoutParams.height = 1;
        int i;
        if (ChooseInterestTagActivity.access$100(this.b.a))
        {
          double d = ChooseInterestTagActivity.access$3100(this.b.a) * 7.0F;
          Double.isNaN(d);
          i = (int)(d + 0.5D);
        }
        else
        {
          i = 0;
        }
        localLayoutParams.topMargin = i;
        localLayoutParams.bottomMargin = i;
        ChooseInterestTagActivity.access$3000(this.b.a).setLayoutParams(localLayoutParams);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.9.1
 * JD-Core Version:    0.7.0.1
 */