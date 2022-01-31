package com.tencent.open.downloadnew;

import android.app.Activity;
import bdne;
import bflk;
import bflp;
import bfoc;
import bfox;
import bfpi;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class MyAppApi$17
  implements Runnable
{
  public MyAppApi$17(bfox parambfox, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    bflp.c("MyAppApi", "---isAutoInstall:" + bfoc.c() + " url:" + bfoc.a() + " interval:" + bfoc.a());
    if ((bflk.b(this.jdField_a_of_type_AndroidAppActivity)) && (bflk.c(this.jdField_a_of_type_AndroidAppActivity)))
    {
      boolean bool1 = bfoc.b();
      boolean bool2 = bfoc.j();
      String str = bdne.k(this.jdField_a_of_type_AndroidAppActivity, "wifiAutoPreDown");
      if ((!this.this$0.b()) && (bool1) && (bool2) && ("true".equals(str)))
      {
        ThreadManager.getUIHandler().post(new MyAppApi.17.1(this));
        bflp.c("MyAppApi", "---startDownloadYYB---");
        this.this$0.a = new bfpi(this.this$0);
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