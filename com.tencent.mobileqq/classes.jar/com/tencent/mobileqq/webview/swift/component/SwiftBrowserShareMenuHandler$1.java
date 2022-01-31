package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Intent;
import bcfh;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import wij;

public class SwiftBrowserShareMenuHandler$1
  implements TeleScreenRunnable
{
  public SwiftBrowserShareMenuHandler$1(bcfh parambcfh, WeakReference paramWeakReference, Intent paramIntent) {}
  
  public void run()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localActivity == null) || (localActivity.isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "canceled");
      }
      return;
    }
    try
    {
      localActivity.startActivity(this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      wij.a(1, 2131695573);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.1
 * JD-Core Version:    0.7.0.1
 */