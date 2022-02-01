package com.tencent.open.business.viareport;

import android.os.Bundle;
import bjtx;
import bjvp;
import bjvs;
import bjvt;

public class ReportManager$1
  implements Runnable
{
  public ReportManager$1(bjvt parambjvt, boolean paramBoolean, bjvp parambjvp, Bundle paramBundle, String paramString) {}
  
  public void run()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bjvp == null)) {
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.this$0.b(this.jdField_a_of_type_AndroidOsBundle.getString("appid_for_getting_config")))) {
        this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, false);
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Bjvp != null) && (this.jdField_a_of_type_Bjvp.a()) && (this.this$0.b(null))) {
        bjvs.a().a("table_new_data", this.jdField_a_of_type_Bjvp);
      }
      if (this.this$0.jdField_a_of_type_Boolean)
      {
        bjtx.b("viareport", "isUploading ---return");
        return;
      }
    } while ((!this.jdField_a_of_type_Boolean) && (!this.this$0.a(this.jdField_a_of_type_JavaLangString)) && (!this.this$0.a()));
    bjvt localbjvt = this.this$0;
    String str = this.jdField_a_of_type_JavaLangString;
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (this.jdField_a_of_type_Bjvp != null) {
      bool = true;
    }
    localbjvt.a(str, localBundle, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportManager.1
 * JD-Core Version:    0.7.0.1
 */