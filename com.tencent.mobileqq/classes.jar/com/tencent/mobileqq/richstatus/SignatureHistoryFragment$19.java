package com.tencent.mobileqq.richstatus;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SignatureHistoryFragment$19
  implements View.OnClickListener
{
  SignatureHistoryFragment$19(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A98A", "0X800A98A", 1, 0, "0", "0", "", "");
    SignatureHistoryFragment.d(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.19
 * JD-Core Version:    0.7.0.1
 */