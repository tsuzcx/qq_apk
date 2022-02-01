package com.tencent.open.downloadnew;

import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import mqq.os.MqqHandler;

class MyAppApi$19
  implements Runnable
{
  MyAppApi$19(MyAppApi paramMyAppApi, Activity paramActivity, String paramString) {}
  
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
    if ((APNUtil.b(this.jdField_a_of_type_AndroidAppActivity)) && (APNUtil.c(this.jdField_a_of_type_AndroidAppActivity)))
    {
      boolean bool1 = ControlPolicyUtil.b();
      boolean bool2 = ControlPolicyUtil.q();
      localObject = SharedPreUtils.i(this.jdField_a_of_type_AndroidAppActivity, "wifiAutoPreDown");
      if ((!MyAppApi.b()) && (bool1) && (bool2) && ("true".equals(localObject)))
      {
        ThreadManager.getUIHandler().post(new MyAppApi.19.1(this));
        LogUtility.c("MyAppApi", "---startDownloadYYB---");
        localObject = this.this$0;
        ((MyAppApi)localObject).a = new MyAppApi.InstallParams((MyAppApi)localObject);
        this.this$0.a.jdField_a_of_type_Boolean = true;
        this.this$0.a.b = false;
        this.this$0.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
        this.this$0.a.jdField_a_of_type_AndroidOsBundle = null;
        this.this$0.a.jdField_a_of_type_Int = -1;
        this.this$0.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 1, "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.19
 * JD-Core Version:    0.7.0.1
 */