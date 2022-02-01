package com.tencent.mobileqq.webview.swift;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;

class WebViewPlugin$1
  implements ThreadExcutor.IThreadListener
{
  WebViewPlugin$1(WebViewPlugin paramWebViewPlugin) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    this.a.onPostPluginAsyncTask();
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPlugin.1
 * JD-Core Version:    0.7.0.1
 */