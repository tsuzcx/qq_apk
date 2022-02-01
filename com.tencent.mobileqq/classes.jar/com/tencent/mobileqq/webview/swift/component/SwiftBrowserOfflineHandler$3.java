package com.tencent.mobileqq.webview.swift.component;

import bihf;
import bihi;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SwiftBrowserOfflineHandler$3
  implements Runnable
{
  public SwiftBrowserOfflineHandler$3(bihf parambihf) {}
  
  public void run()
  {
    if ((QLog.isColorLevel()) && (this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != 0)) {
      QLog.i("SwiftBrowserOfflineHandler", 2, "now post offline callback, bid is " + this.this$0.jdField_a_of_type_JavaLangString + ", mode: " + this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    }
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bihi)localIterator.next()).onCheckOfflineFinish(this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.3
 * JD-Core Version:    0.7.0.1
 */