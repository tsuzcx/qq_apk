package com.tencent.open.business.viareport;

import bisy;
import biuu;

public class ReportManager$2
  implements Runnable
{
  public ReportManager$2(biuu parambiuu, String paramString) {}
  
  public void run()
  {
    if (this.this$0.a) {
      bisy.b("viareport", "isUploading ---return");
    }
    while (!this.this$0.a(this.a)) {
      return;
    }
    this.this$0.a(this.a, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportManager.2
 * JD-Core Version:    0.7.0.1
 */