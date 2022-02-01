package com.tencent.open.business.viareport;

import android.os.Bundle;
import bjko;
import bjmd;
import bjmg;
import bjmh;

public class ReportManager$1
  implements Runnable
{
  public ReportManager$1(bjmh parambjmh, boolean paramBoolean1, bjmd parambjmd, Bundle paramBundle, String paramString, boolean paramBoolean2) {}
  
  public void run()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bjmd == null)) {
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.this$0.b(this.jdField_a_of_type_AndroidOsBundle.getString("appid_for_getting_config")))) {
        this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, false, this.b);
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Bjmd != null) && (this.jdField_a_of_type_Bjmd.a()) && (this.this$0.b(null))) {
        bjmg.a().a("table_new_data", this.jdField_a_of_type_Bjmd);
      }
      if (this.this$0.jdField_a_of_type_Boolean)
      {
        bjko.b("viareport", "isUploading ---return");
        return;
      }
    } while ((!this.jdField_a_of_type_Boolean) && (!this.this$0.a(this.jdField_a_of_type_JavaLangString)) && (!this.this$0.a()));
    bjmh localbjmh = this.this$0;
    String str = this.jdField_a_of_type_JavaLangString;
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (this.jdField_a_of_type_Bjmd != null) {
      bool = true;
    }
    localbjmh.a(str, localBundle, bool, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportManager.1
 * JD-Core Version:    0.7.0.1
 */