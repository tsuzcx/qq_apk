package com.tencent.mobileqq.managers;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;

class CUOpenCardGuideMng$CUOpenCardClickableSpan$1
  implements Runnable
{
  CUOpenCardGuideMng$CUOpenCardClickableSpan$1(CUOpenCardGuideMng.CUOpenCardClickableSpan paramCUOpenCardClickableSpan) {}
  
  public void run()
  {
    String str;
    if (this.this$0.d == 1) {
      str = "0X8008124";
    }
    for (;;)
    {
      break;
      if (this.this$0.d == 2) {
        str = "0X8008126";
      } else if ((this.this$0.d != 3) && (this.this$0.d != 4)) {
        str = null;
      } else {
        str = "0X800813E";
      }
    }
    if (!TextUtils.isEmpty(str)) {
      ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.CUOpenCardGuideMng.CUOpenCardClickableSpan.1
 * JD-Core Version:    0.7.0.1
 */