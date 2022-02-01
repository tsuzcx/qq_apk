package com.tencent.mobileqq.microapp.webview;

import com.tencent.qphone.base.util.QLog;

final class a
  implements Runnable
{
  a(BaseAppBrandWebview paramBaseAppBrandWebview, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WeixinJSBridge.subscribeHandler(\"");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("\",");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(0);
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      String str = BaseAppBrandWebview.access$000();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("evaluateSubcribeJS: ");
      localStringBuilder.append((String)localObject);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.d.evaluateJavascript((String)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.webview.a
 * JD-Core Version:    0.7.0.1
 */