package com.tencent.open.business.viareport;

import bdii;
import bdkg;

public class ReportManager$2
  implements Runnable
{
  public ReportManager$2(bdkg parambdkg, String paramString) {}
  
  public void run()
  {
    if (this.this$0.a) {
      bdii.b("viareport", "isUploading ---return");
    }
    while (!this.this$0.a(this.a)) {
      return;
    }
    this.this$0.a(this.a, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportManager.2
 * JD-Core Version:    0.7.0.1
 */