package com.tencent.mobileqq.webview.swift.component;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;

final class SwiftBrowserCookieMonster$7
  implements ThreadExcutor.IThreadListener
{
  long a = 0L;
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SwiftBrowserCookieMonster", 2, "Web_qqbrowser_pre_get_key, cost=" + (System.currentTimeMillis() - this.a));
    }
    this.a = 0L;
  }
  
  public void onPreRun()
  {
    this.a = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.7
 * JD-Core Version:    0.7.0.1
 */