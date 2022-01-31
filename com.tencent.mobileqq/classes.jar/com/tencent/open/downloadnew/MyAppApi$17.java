package com.tencent.open.downloadnew;

import android.app.Activity;
import bbkb;
import bdid;
import bdii;
import bdkw;
import bdlr;
import bdmc;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class MyAppApi$17
  implements Runnable
{
  public MyAppApi$17(bdlr parambdlr, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    bdii.c("MyAppApi", "---isAutoInstall:" + bdkw.c() + " url:" + bdkw.a() + " interval:" + bdkw.a());
    if ((bdid.b(this.jdField_a_of_type_AndroidAppActivity)) && (bdid.c(this.jdField_a_of_type_AndroidAppActivity)))
    {
      boolean bool1 = bdkw.b();
      boolean bool2 = bdkw.j();
      String str = bbkb.j(this.jdField_a_of_type_AndroidAppActivity, "wifiAutoPreDown");
      if ((!this.this$0.b()) && (bool1) && (bool2) && ("true".equals(str)))
      {
        ThreadManager.getUIHandler().post(new MyAppApi.17.1(this));
        bdii.c("MyAppApi", "---startDownloadYYB---");
        this.this$0.a = new bdmc(this.this$0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.17
 * JD-Core Version:    0.7.0.1
 */