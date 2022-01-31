package com.tencent.mobileqq.webview.swift.utils;

import android.os.Bundle;
import beiy;
import bejx;
import bejz;
import com.tencent.qphone.base.util.QLog;

public class SwiftWebAccelerator$3
  implements Runnable
{
  public SwiftWebAccelerator$3(bejx parambejx, long paramLong, Bundle paramBundle) {}
  
  public void run()
  {
    bejz.b();
    beiy.X = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.i("WebLog_SwiftWebAccelerator", 1, "initX5Environment on sub thread, cost " + beiy.X + "ms.");
    this.this$0.a(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.3
 * JD-Core Version:    0.7.0.1
 */