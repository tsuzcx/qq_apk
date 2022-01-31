package com.tencent.open.downloadnew;

import android.app.Activity;
import bdht;
import bdkh;
import bdlc;
import bdln;

public class MyAppApi$19
  implements Runnable
{
  public MyAppApi$19(bdlc parambdlc, boolean paramBoolean, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    bdht.c("MyAppApi", "---isAutoInstall:" + bdkh.c() + " url:" + bdkh.a() + " interval:" + bdkh.a());
    boolean bool = bdkh.b();
    if ((!this.this$0.b()) && (bool))
    {
      bdht.c("MyAppApi", "---startDownloadYYB---");
      this.this$0.a = new bdln(this.this$0);
      this.this$0.a.jdField_a_of_type_Boolean = true;
      this.this$0.a.b = false;
      this.this$0.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      this.this$0.a.jdField_a_of_type_AndroidOsBundle = null;
      this.this$0.a.jdField_a_of_type_Int = -1;
      if (this.jdField_a_of_type_Boolean) {
        this.this$0.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0);
      }
    }
    else
    {
      return;
    }
    this.this$0.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.19
 * JD-Core Version:    0.7.0.1
 */