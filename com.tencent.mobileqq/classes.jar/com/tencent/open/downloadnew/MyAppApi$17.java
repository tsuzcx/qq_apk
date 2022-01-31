package com.tencent.open.downloadnew;

import android.app.Activity;
import baig;
import bcdn;
import bcds;
import bcgg;
import bchb;
import bchm;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class MyAppApi$17
  implements Runnable
{
  public MyAppApi$17(bchb parambchb, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    bcds.c("MyAppApi", "---isAutoInstall:" + bcgg.c() + " url:" + bcgg.a() + " interval:" + bcgg.a());
    if ((bcdn.b(this.jdField_a_of_type_AndroidAppActivity)) && (bcdn.c(this.jdField_a_of_type_AndroidAppActivity)))
    {
      boolean bool1 = bcgg.b();
      boolean bool2 = bcgg.j();
      String str = baig.j(this.jdField_a_of_type_AndroidAppActivity, "wifiAutoPreDown");
      if ((!this.this$0.b()) && (bool1) && (bool2) && ("true".equals(str)))
      {
        ThreadManager.getUIHandler().post(new MyAppApi.17.1(this));
        bcds.c("MyAppApi", "---startDownloadYYB---");
        this.this$0.a = new bchm(this.this$0);
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