package com.tencent.mobileqq.studyroom.webview;

import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public abstract class StudyRoomBaseWebViewPlugin
  extends WebViewPlugin
{
  private JsBridgeListener a;
  
  public StudyRoomBaseWebViewPlugin()
  {
    this.mPluginNameSpace = a();
  }
  
  protected String a()
  {
    return getClass().getSimpleName();
  }
  
  protected abstract boolean a(String paramString1, String paramString2, String paramString3, String... paramVarArgs);
  
  @Deprecated
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase(a()))) {
      return false;
    }
    this.a = paramJsBridgeListener;
    return a(paramString1, paramString2, paramString3, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.webview.StudyRoomBaseWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */