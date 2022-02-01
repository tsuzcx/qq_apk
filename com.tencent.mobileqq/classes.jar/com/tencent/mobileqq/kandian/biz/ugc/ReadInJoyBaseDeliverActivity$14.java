package com.tencent.mobileqq.kandian.biz.ugc;

import android.view.View;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyBaseDeliverActivity$14
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyBaseDeliverActivity$14(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity, boolean paramBoolean1, long paramLong, boolean paramBoolean2, int paramInt) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.e.o) {
      return;
    }
    paramView = this.e;
    paramView.o = true;
    if (paramInt == 0)
    {
      if (this.a)
      {
        ForwardSdkShareOption.a(paramView, true, "shareToQQ", this.b);
        this.e.moveTaskToBack(true);
      }
      this.e.finish();
      this.e.g();
      if (this.c)
      {
        paramView = new StringBuilder();
        paramView.append(this.d);
        paramView.append("");
        PublicAccountReportUtils.a(null, "", "0X8008661", "0X8008661", 0, 0, paramView.toString(), "", "", ReadInJoyBaseDeliverActivity.h(), false);
      }
    }
    this.e.l.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity.14
 * JD-Core Version:    0.7.0.1
 */