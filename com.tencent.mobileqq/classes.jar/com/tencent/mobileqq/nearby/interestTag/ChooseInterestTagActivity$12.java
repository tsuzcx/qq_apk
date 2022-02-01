package com.tencent.mobileqq.nearby.interestTag;

import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

class ChooseInterestTagActivity$12
  implements ShowTagNamePopupWindow.IShowTagNamePopupWindowCallback
{
  ChooseInterestTagActivity$12(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void a(long paramLong)
  {
    int i = 0;
    while (i < ChooseInterestTagActivity.access$600(this.a).getChildCount())
    {
      InterestTagInfo localInterestTagInfo = (InterestTagInfo)ChooseInterestTagActivity.access$600(this.a).getChildAt(i).getTag();
      if ((localInterestTagInfo != null) && (paramLong == localInterestTagInfo.tagId))
      {
        ChooseInterestTagActivity.access$2200(this.a).remove(localInterestTagInfo);
        ChooseInterestTagActivity.access$3400(this.a, localInterestTagInfo);
        ChooseInterestTagActivity.access$3500(this.a, localInterestTagInfo);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.12
 * JD-Core Version:    0.7.0.1
 */