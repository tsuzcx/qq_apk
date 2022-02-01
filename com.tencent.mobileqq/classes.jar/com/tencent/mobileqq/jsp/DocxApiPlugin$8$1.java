package com.tencent.mobileqq.jsp;

import com.tencent.biz.ui.TouchWebView;

class DocxApiPlugin$8$1
  implements Runnable
{
  DocxApiPlugin$8$1(DocxApiPlugin.8 param8, String paramString) {}
  
  public void run()
  {
    TouchWebView localTouchWebView = this.this$0.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:window.injectLocalTcntDocData(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(")");
    localTouchWebView.loadUrl(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin.8.1
 * JD-Core Version:    0.7.0.1
 */