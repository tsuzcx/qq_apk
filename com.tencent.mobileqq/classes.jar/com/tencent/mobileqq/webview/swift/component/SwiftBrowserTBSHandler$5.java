package com.tencent.mobileqq.webview.swift.component;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;

class SwiftBrowserTBSHandler$5
  implements Runnable
{
  public void run()
  {
    ??? = this.this$0;
    ((SwiftBrowserTBSHandler)???).a(MsfSdkUtils.insertMtype("Web", ((SwiftBrowserTBSHandler)???).i), 0);
    synchronized (this.this$0.e)
    {
      this.this$0.g = Boolean.valueOf(true);
      this.this$0.e.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.5
 * JD-Core Version:    0.7.0.1
 */