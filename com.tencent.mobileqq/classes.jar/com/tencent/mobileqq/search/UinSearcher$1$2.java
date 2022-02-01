package com.tencent.mobileqq.search;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnDismissListener;

class UinSearcher$1$2
  implements ActionSheet.OnDismissListener
{
  UinSearcher$1$2(UinSearcher.1 param1, QQAppInterface paramQQAppInterface) {}
  
  public void onDismiss()
  {
    ReportController.b(this.a, "dc00898", "", "", "0X800A92E", "0X800A92E", UinSearcher.i(this.b.a), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher.1.2
 * JD-Core Version:    0.7.0.1
 */