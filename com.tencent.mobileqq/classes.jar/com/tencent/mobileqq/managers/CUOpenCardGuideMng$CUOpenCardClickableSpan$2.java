package com.tencent.mobileqq.managers;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;

class CUOpenCardGuideMng$CUOpenCardClickableSpan$2
  implements Runnable
{
  CUOpenCardGuideMng$CUOpenCardClickableSpan$2(CUOpenCardGuideMng.CUOpenCardClickableSpan paramCUOpenCardClickableSpan) {}
  
  public void run()
  {
    String str;
    if (this.this$0.a == 1) {
      str = "0X8008127";
    }
    for (;;)
    {
      break;
      if (this.this$0.a == 2) {
        str = "0X8008125";
      } else if ((this.this$0.a != 3) && (this.this$0.a != 4)) {
        str = null;
      } else {
        str = "0X800813F";
      }
    }
    if (!TextUtils.isEmpty(str)) {
      ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.CUOpenCardGuideMng.CUOpenCardClickableSpan.2
 * JD-Core Version:    0.7.0.1
 */