package com.tencent.mobileqq.forward;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.agent.report.ReportCenter;

class ForwardSdkShareOption$11
  implements DialogInterface.OnClickListener
{
  ForwardSdkShareOption$11(ForwardSdkShareOption paramForwardSdkShareOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.F) {
      ReportCenter.a().a(this.a.q.getAccount(), "", String.valueOf(this.a.G), "1000", "51", "0", false, true);
    }
    ForwardSdkBaseOption.a(this.a.s, true, "addToQQFavorites", this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.11
 * JD-Core Version:    0.7.0.1
 */