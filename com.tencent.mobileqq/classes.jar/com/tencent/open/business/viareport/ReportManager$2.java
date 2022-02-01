package com.tencent.open.business.viareport;

import bjko;
import bjmh;

public class ReportManager$2
  implements Runnable
{
  public ReportManager$2(bjmh parambjmh, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      bjko.b("viareport", "isUploading ---return");
    }
    while (!this.this$0.a(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.this$0.a(this.jdField_a_of_type_JavaLangString, null, true, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportManager.2
 * JD-Core Version:    0.7.0.1
 */