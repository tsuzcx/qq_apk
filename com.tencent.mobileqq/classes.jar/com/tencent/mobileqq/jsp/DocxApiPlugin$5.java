package com.tencent.mobileqq.jsp;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.util.ArrayList;
import java.util.Iterator;

class DocxApiPlugin$5
  implements Runnable
{
  DocxApiPlugin$5(DocxApiPlugin paramDocxApiPlugin, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      TeamWorkHandlerUtils.a(this.this$0.mRuntime.a().getCurrentAccountUin(), TeamWorkHandlerUtils.a(str), str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin.5
 * JD-Core Version:    0.7.0.1
 */