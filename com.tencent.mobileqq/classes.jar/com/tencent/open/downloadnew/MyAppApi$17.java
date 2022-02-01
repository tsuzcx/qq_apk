package com.tencent.open.downloadnew;

import android.app.Activity;
import bhsi;
import bjts;
import bjtx;
import bjwj;
import bjxd;
import bjxo;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class MyAppApi$17
  implements Runnable
{
  public MyAppApi$17(bjxd parambjxd, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    bjtx.c("MyAppApi", "---isAutoInstall:" + bjwj.c() + " url:" + bjwj.a() + " interval:" + bjwj.a());
    if ((bjts.b(this.jdField_a_of_type_AndroidAppActivity)) && (bjts.c(this.jdField_a_of_type_AndroidAppActivity)))
    {
      boolean bool1 = bjwj.b();
      boolean bool2 = bjwj.j();
      String str = bhsi.k(this.jdField_a_of_type_AndroidAppActivity, "wifiAutoPreDown");
      if ((!this.this$0.b()) && (bool1) && (bool2) && ("true".equals(str)))
      {
        ThreadManager.getUIHandler().post(new MyAppApi.17.1(this));
        bjtx.c("MyAppApi", "---startDownloadYYB---");
        this.this$0.a = new bjxo(this.this$0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.17
 * JD-Core Version:    0.7.0.1
 */