package com.tencent.mobileqq.richstatus;

import com.tencent.smtt.sdk.WebView;

class StatusJsHandler$2
  implements Runnable
{
  StatusJsHandler$2(StatusJsHandler paramStatusJsHandler, String paramString1, String paramString2, WebView paramWebView) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("javascript:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      this.c.loadUrl((String)localObject);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (this.a.equals(this.this$0.h))
    {
      this.this$0.e = false;
      return;
    }
    if (this.a.equals(this.this$0.g)) {
      this.this$0.f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusJsHandler.2
 * JD-Core Version:    0.7.0.1
 */