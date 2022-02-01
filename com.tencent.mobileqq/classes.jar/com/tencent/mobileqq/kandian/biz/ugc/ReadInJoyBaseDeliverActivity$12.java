package com.tencent.mobileqq.kandian.biz.ugc;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyBaseDeliverActivity$12
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyBaseDeliverActivity$12(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.a) {
      return;
    }
    paramView = this.a;
    paramView.a = true;
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        paramView.j();
        RIJDeliverUGCReportUtil.c("2");
      }
    }
    else
    {
      paramView.i();
      RIJDeliverUGCReportUtil.c("1");
      this.a.finish();
    }
    this.a.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity.12
 * JD-Core Version:    0.7.0.1
 */