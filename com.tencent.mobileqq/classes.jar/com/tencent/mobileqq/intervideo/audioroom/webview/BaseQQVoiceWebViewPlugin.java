package com.tencent.mobileqq.intervideo.audioroom.webview;

import android.content.Context;
import android.support.annotation.Nullable;
import bgve;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public abstract class BaseQQVoiceWebViewPlugin
  extends WebViewPlugin
{
  private JsBridgeListener a;
  
  public BaseQQVoiceWebViewPlugin()
  {
    this.mPluginNameSpace = getNamespace();
  }
  
  public Context getContext()
  {
    if (this.mRuntime != null) {
      return this.mRuntime.a();
    }
    return null;
  }
  
  protected String getNamespace()
  {
    return getClass().getSimpleName();
  }
  
  @Nullable
  public QQVoiceWebView getWebView()
  {
    if (this.mRuntime != null) {
      return (QQVoiceWebView)this.mRuntime.a();
    }
    return null;
  }
  
  @Deprecated
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase(getNamespace()))) {
      return false;
    }
    this.a = paramJsBridgeListener;
    return handleJsRequest(paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  protected abstract boolean handleJsRequest(String paramString1, String paramString2, String paramString3, String... paramVarArgs);
  
  protected void onJsComplete(Object paramObject)
  {
    if (this.a != null) {
      this.a.a(paramObject);
    }
  }
  
  protected void onJsError(String paramString)
  {
    if (this.a != null) {
      this.a.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.webview.BaseQQVoiceWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */