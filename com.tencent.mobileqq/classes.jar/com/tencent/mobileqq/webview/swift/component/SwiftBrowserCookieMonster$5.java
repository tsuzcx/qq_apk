package com.tencent.mobileqq.webview.swift.component;

import bejn;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import myl;

final class SwiftBrowserCookieMonster$5
  implements Runnable
{
  SwiftBrowserCookieMonster$5(List paramList, bejn parambejn) {}
  
  public void run()
  {
    Set localSet = myl.a().a("pskey");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!localSet.contains(str))
      {
        if (QLog.isColorLevel()) {
          QLog.i("SwiftBrowserCookieMonster", 2, str + " doesn't need pskey any more,so delete! ");
        }
        this.jdField_a_of_type_Bejn.b(str, "p_skey");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.5
 * JD-Core Version:    0.7.0.1
 */