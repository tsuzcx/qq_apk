package com.tencent.mobileqq.webview.swift.component;

import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.OfflineWebResManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class SwiftBrowserOfflineHandler$1$1
  implements AsyncCallBack
{
  SwiftBrowserOfflineHandler$1$1(SwiftBrowserOfflineHandler.1 param1, long paramLong) {}
  
  public void loaded(int paramInt, String paramString)
  {
    this.b.this$0.e.set(paramInt);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("now offline bid has checked, bid ");
      paramString.append(this.b.this$0.d);
      paramString.append(", loadMode: ");
      paramString.append(this.b.this$0.e.get());
      paramString.append(", cost: ");
      paramString.append(System.currentTimeMillis() - this.a);
      QLog.i("SwiftBrowserOfflineHandler", 2, paramString.toString());
    }
    if (paramInt != 0)
    {
      OfflinePlugin.f(this.b.this$0.d);
      OfflineWebResManager.a(this.b.a);
    }
    this.b.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.1.1
 * JD-Core Version:    0.7.0.1
 */