package com.tencent.mobileqq.webview.swift.component;

import bedq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import ndq;

class SwiftBrowserCookieMonster$1$1
  implements Runnable
{
  SwiftBrowserCookieMonster$1$1(SwiftBrowserCookieMonster.1 param1) {}
  
  public void run()
  {
    Iterator localIterator = this.a.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (String)localIterator.next();
      Object localObject2 = (CopyOnWriteArrayList)this.a.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject3);
      if (this.a.a == null) {}
      for (Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();; localObject1 = this.a.a)
      {
        localObject1 = this.a.this$0.a((String)localObject3, (AppRuntime)localObject1);
        localObject2 = ((CopyOnWriteArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bedq)((Iterator)localObject2).next();
          if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserCookieMonster", 2, "post callback onSetCookiesFinished " + ndq.b((String)localObject1, new String[0]) + ", errorCode: " + this.a.this$0.jdField_a_of_type_Long);
          }
          if (this.a.this$0.b) {
            QLog.i("SwiftBrowserCookieMonster", 1, "cookie is wrong, need do jump ptlogin! " + ndq.b((String)localObject1, new String[0]));
          }
          ((bedq)localObject3).a((String)localObject1, null, this.a.this$0.jdField_a_of_type_Long);
        }
        break;
      }
    }
    if ((this.a.this$0.b) || (this.a.this$0.jdField_a_of_type_Long > 0L))
    {
      this.a.this$0.b();
      return;
    }
    this.a.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.1.1
 * JD-Core Version:    0.7.0.1
 */