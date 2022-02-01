package com.tencent.mobileqq.filemanager.app.impl;

import com.tencent.mobileqq.filemanager.app.IQQFavProxy.QQFavProxyListener;
import java.util.HashSet;
import java.util.Iterator;

class QQFavProxyImpl$3
  implements Runnable
{
  QQFavProxyImpl$3(QQFavProxyImpl paramQQFavProxyImpl, long paramLong, int paramInt, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = QQFavProxyImpl.access$100(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((IQQFavProxy.QQFavProxyListener)localIterator.next()).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.impl.QQFavProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */