package com.tencent.open.downloadnew;

import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import mqq.os.MqqHandler;

class MyAppApi$17
  implements Runnable
{
  MyAppApi$17(MyAppApi paramMyAppApi, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    LogUtility.c("MyAppApi", "---isAutoInstall:" + ControlPolicyUtil.c() + " url:" + ControlPolicyUtil.a() + " interval:" + ControlPolicyUtil.a());
    if ((APNUtil.b(this.jdField_a_of_type_AndroidAppActivity)) && (APNUtil.c(this.jdField_a_of_type_AndroidAppActivity)))
    {
      boolean bool1 = ControlPolicyUtil.b();
      boolean bool2 = ControlPolicyUtil.j();
      String str = SharedPreUtils.k(this.jdField_a_of_type_AndroidAppActivity, "wifiAutoPreDown");
      if ((!this.this$0.b()) && (bool1) && (bool2) && ("true".equals(str)))
      {
        ThreadManager.getUIHandler().post(new MyAppApi.17.1(this));
        LogUtility.c("MyAppApi", "---startDownloadYYB---");
        this.this$0.a = new MyAppApi.InstallParams(this.this$0);
        this.this$0.a.jdField_a_of_type_Boolean = true;
        this.this$0.a.b = false;
        this.this$0.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
        this.this$0.a.jdField_a_of_type_AndroidOsBundle = null;
        this.this$0.a.jdField_a_of_type_Int = -1;
        this.this$0.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.17
 * JD-Core Version:    0.7.0.1
 */