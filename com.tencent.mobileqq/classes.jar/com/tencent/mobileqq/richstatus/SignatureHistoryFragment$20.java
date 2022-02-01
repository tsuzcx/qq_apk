package com.tencent.mobileqq.richstatus;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SignatureHistoryFragment$20
  implements View.OnClickListener
{
  SignatureHistoryFragment$20(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A98A", "0X800A98A", 2, 0, "0", "0", "", "");
    SignatureHistoryFragment.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.20
 * JD-Core Version:    0.7.0.1
 */