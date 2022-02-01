package com.tencent.open.downloadnew;

import android.app.Activity;
import com.tencent.open.base.LogUtility;

class MyAppApi$21
  implements Runnable
{
  MyAppApi$21(MyAppApi paramMyAppApi, boolean paramBoolean, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("---isAutoInstall:");
    ((StringBuilder)localObject).append(ControlPolicyUtil.c());
    ((StringBuilder)localObject).append(" url:");
    ((StringBuilder)localObject).append(ControlPolicyUtil.a());
    ((StringBuilder)localObject).append(" interval:");
    ((StringBuilder)localObject).append(ControlPolicyUtil.a());
    LogUtility.c("MyAppApi", ((StringBuilder)localObject).toString());
    boolean bool = ControlPolicyUtil.b();
    if ((!MyAppApi.b()) && (bool))
    {
      LogUtility.c("MyAppApi", "---startDownloadYYB---");
      localObject = this.this$0;
      ((MyAppApi)localObject).a = new MyAppApi.InstallParams((MyAppApi)localObject);
      this.this$0.a.jdField_a_of_type_Boolean = true;
      this.this$0.a.b = false;
      this.this$0.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      this.this$0.a.jdField_a_of_type_AndroidOsBundle = null;
      this.this$0.a.jdField_a_of_type_Int = -1;
      if (this.jdField_a_of_type_Boolean)
      {
        this.this$0.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0, "", "");
        return;
      }
      this.this$0.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 1, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.21
 * JD-Core Version:    0.7.0.1
 */