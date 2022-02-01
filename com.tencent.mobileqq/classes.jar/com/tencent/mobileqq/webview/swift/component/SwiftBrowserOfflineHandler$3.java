package com.tencent.mobileqq.webview.swift.component;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class SwiftBrowserOfflineHandler$3
  implements Runnable
{
  SwiftBrowserOfflineHandler$3(SwiftBrowserOfflineHandler paramSwiftBrowserOfflineHandler) {}
  
  public void run()
  {
    if ((QLog.isColorLevel()) && (this.this$0.b.size() != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("now post offline callback, bid is ");
      ((StringBuilder)localObject).append(this.this$0.d);
      ((StringBuilder)localObject).append(", mode: ");
      ((StringBuilder)localObject).append(this.this$0.e.get());
      QLog.i("SwiftBrowserOfflineHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.this$0.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((SwiftBrowserOfflineHandler.CheckOfflineCallback)((Iterator)localObject).next()).onCheckOfflineFinish(this.this$0.e.get());
    }
    this.this$0.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.3
 * JD-Core Version:    0.7.0.1
 */