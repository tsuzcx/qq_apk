package com.tencent.mobileqq.intervideo.audioroom.webview;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;

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
      return this.mRuntime.d();
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
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 != null) && (paramString2.equalsIgnoreCase(getNamespace())))
    {
      this.a = paramJsBridgeListener;
      return handleJsRequest(paramString1, paramString2, paramString3, paramVarArgs);
    }
    return false;
  }
  
  protected abstract boolean handleJsRequest(String paramString1, String paramString2, String paramString3, String... paramVarArgs);
  
  protected void onJsComplete(Object paramObject)
  {
    JsBridgeListener localJsBridgeListener = this.a;
    if (localJsBridgeListener != null) {
      localJsBridgeListener.a(paramObject);
    }
  }
  
  protected void onJsError(String paramString)
  {
    JsBridgeListener localJsBridgeListener = this.a;
    if (localJsBridgeListener != null) {
      localJsBridgeListener.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.webview.BaseQQVoiceWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */