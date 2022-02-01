package com.tencent.mobileqq.filemanager.app.impl;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy.QQFavProxyListener;
import java.util.HashSet;
import java.util.Iterator;

class QQFavProxyImpl$2
  implements Runnable
{
  QQFavProxyImpl$2(QQFavProxyImpl paramQQFavProxyImpl, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    Iterator localIterator = QQFavProxyImpl.access$100(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((IQQFavProxy.QQFavProxyListener)localIterator.next()).a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.impl.QQFavProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */