package com.tencent.open.business.viareport;

import com.tencent.open.base.LogUtility;

class ReportManager$2
  implements Runnable
{
  ReportManager$2(ReportManager paramReportManager, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.e)
    {
      LogUtility.b("viareport", "isUploading ---return");
      return;
    }
    if (this.this$0.a(this.a)) {
      this.this$0.a(this.a, null, true, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportManager.2
 * JD-Core Version:    0.7.0.1
 */