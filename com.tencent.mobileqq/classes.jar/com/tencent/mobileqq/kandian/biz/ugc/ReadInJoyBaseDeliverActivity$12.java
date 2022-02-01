package com.tencent.mobileqq.kandian.biz.ugc;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyBaseDeliverActivity$12
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyBaseDeliverActivity$12(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.a.o) {
      return;
    }
    paramView = this.a;
    paramView.o = true;
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        paramView.n();
        RIJDeliverUGCReportUtil.c("2");
      }
    }
    else
    {
      paramView.m();
      RIJDeliverUGCReportUtil.c("1");
      this.a.finish();
    }
    this.a.m.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity.12
 * JD-Core Version:    0.7.0.1
 */