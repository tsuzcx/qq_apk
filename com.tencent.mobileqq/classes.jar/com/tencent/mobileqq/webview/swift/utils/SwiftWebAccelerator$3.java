package com.tencent.mobileqq.webview.swift.utils;

import android.os.Bundle;
import bcfo;
import bcgn;
import bcgp;
import com.tencent.qphone.base.util.QLog;

public class SwiftWebAccelerator$3
  implements Runnable
{
  public SwiftWebAccelerator$3(bcgn parambcgn, long paramLong, Bundle paramBundle) {}
  
  public void run()
  {
    bcgp.b();
    bcfo.X = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    QLog.i("WebLog_SwiftWebAccelerator", 1, "initX5Environment on sub thread, cost " + bcfo.X + "ms.");
    this.this$0.a(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.3
 * JD-Core Version:    0.7.0.1
 */