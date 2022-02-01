package com.tencent.open.business.viareport;

import com.tencent.open.base.LogUtility;

class ReportManager$2
  implements Runnable
{
  ReportManager$2(ReportManager paramReportManager, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      LogUtility.b("viareport", "isUploading ---return");
    }
    while (!this.this$0.a(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.this$0.a(this.jdField_a_of_type_JavaLangString, null, true, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportManager.2
 * JD-Core Version:    0.7.0.1
 */