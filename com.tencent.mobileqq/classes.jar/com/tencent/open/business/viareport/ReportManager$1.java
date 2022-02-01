package com.tencent.open.business.viareport;

import android.os.Bundle;
import com.tencent.open.base.LogUtility;

class ReportManager$1
  implements Runnable
{
  ReportManager$1(ReportManager paramReportManager, boolean paramBoolean1, BatchReportInfo paramBatchReportInfo, Bundle paramBundle, String paramString, boolean paramBoolean2) {}
  
  public void run()
  {
    boolean bool2 = this.jdField_a_of_type_Boolean;
    boolean bool1 = false;
    if ((bool2) && (this.jdField_a_of_type_ComTencentOpenBusinessViareportBatchReportInfo == null))
    {
      localObject = this.jdField_a_of_type_AndroidOsBundle;
      if ((localObject != null) && (this.this$0.b(((Bundle)localObject).getString("appid_for_getting_config")))) {
        this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, false, this.b);
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentOpenBusinessViareportBatchReportInfo;
    if ((localObject != null) && (((BatchReportInfo)localObject).a()) && (this.this$0.b(null))) {
      ReportDbHelper.a().a("table_new_data", this.jdField_a_of_type_ComTencentOpenBusinessViareportBatchReportInfo);
    }
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      LogUtility.b("viareport", "isUploading ---return");
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) && (!this.this$0.a(this.jdField_a_of_type_JavaLangString)) && (!this.this$0.a())) {
      return;
    }
    localObject = this.this$0;
    String str = this.jdField_a_of_type_JavaLangString;
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (this.jdField_a_of_type_ComTencentOpenBusinessViareportBatchReportInfo != null) {
      bool1 = true;
    }
    ((ReportManager)localObject).a(str, localBundle, bool1, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportManager.1
 * JD-Core Version:    0.7.0.1
 */