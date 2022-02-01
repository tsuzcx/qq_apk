package com.tencent.mobileqq.nearby.interestTag;

import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ChooseInterestTagActivity$11
  implements View.OnClickListener
{
  ChooseInterestTagActivity$11(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ChooseInterestTagActivity.access$000(this.a) != 3) && (ChooseInterestTagActivity.access$000(this.a) != 2) && (ChooseInterestTagActivity.access$000(this.a) != 1) && (ChooseInterestTagActivity.access$000(this.a) != 4))
    {
      try
      {
        int[] arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        if (arrayOfInt[0] > 0)
        {
          InterestTagInfo localInterestTagInfo = (InterestTagInfo)paramView.getTag();
          if (localInterestTagInfo == null) {
            return;
          }
          Paint localPaint = new Paint();
          float f1 = ChooseInterestTagActivity.access$3100(this.a);
          double d1 = f1 * 14.0F;
          Double.isNaN(d1);
          f1 = (float)(d1 + 0.5D);
          localPaint.setTextSize(f1);
          localPaint.setColor(this.a.getResources().getColor(2131167116));
          localPaint.setFakeBoldText(false);
          localPaint.setAntiAlias(true);
          Object localObject2 = localInterestTagInfo.tagName;
          Object localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = " ";
          }
          localObject2 = localObject1;
          if (((String)localObject1).length() > 8)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((String)localObject1).substring(0, 8));
            ((StringBuilder)localObject2).append("...");
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          f1 = localPaint.measureText((String)localObject2);
          float f2 = ChooseInterestTagActivity.access$3100(this.a);
          d1 = f2 * 64.0F;
          Double.isNaN(d1);
          double d2 = f1;
          Double.isNaN(d2);
          int i = (int)(d1 + 0.5D + d2);
          localObject1 = new ShowTagNamePopupWindow(this.a, arrayOfInt[0], i);
          ((ShowTagNamePopupWindow)localObject1).a(ChooseInterestTagActivity.access$3600(this.a));
          ((ShowTagNamePopupWindow)localObject1).a(localInterestTagInfo);
          ((ShowTagNamePopupWindow)localObject1).showAsDropDown(paramView, -(int)((i - ChooseInterestTagActivity.access$3100(this.a) * 40.0F) / 2.0F), 10);
          return;
        }
      }
      catch (Exception paramView)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("choose_interest_tag", 4, paramView.getMessage());
        }
      }
      return;
    }
    paramView = (InterestTagInfo)paramView.getTag();
    if (paramView != null)
    {
      ChooseInterestTagActivity.access$2200(this.a).remove(paramView);
      ChooseInterestTagActivity.access$3400(this.a, paramView);
      ChooseInterestTagActivity.access$3500(this.a, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.11
 * JD-Core Version:    0.7.0.1
 */