package com.tencent.mobileqq.config.splashlogo;

import aozn;
import bkbq;
import com.tencent.qphone.base.util.QLog;

public class KandianConfigServlet$1
  implements Runnable
{
  public KandianConfigServlet$1(aozn paramaozn) {}
  
  public void run()
  {
    bkbq.a("remote_kd_tab_switch");
    QLog.i("KandianConfigServlet", 1, "preload sp file finish!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.KandianConfigServlet.1
 * JD-Core Version:    0.7.0.1
 */