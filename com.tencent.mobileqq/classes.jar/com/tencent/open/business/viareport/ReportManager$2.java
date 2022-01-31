package com.tencent.open.business.viareport;

import bflp;
import bfnm;

public class ReportManager$2
  implements Runnable
{
  public ReportManager$2(bfnm parambfnm, String paramString) {}
  
  public void run()
  {
    if (this.this$0.a) {
      bflp.b("viareport", "isUploading ---return");
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