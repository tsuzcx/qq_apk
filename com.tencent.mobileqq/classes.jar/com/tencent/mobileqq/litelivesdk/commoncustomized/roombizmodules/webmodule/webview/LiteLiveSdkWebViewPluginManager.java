package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import com.tencent.common.app.BaseApplicationImpl;

public class LiteLiveSdkWebViewPluginManager
{
  private static LiteLiveSdkWebViewPluginManager a;
  private static Object b = new Object();
  private LiteLiveSdkWebViewRuntime c;
  
  public static LiteLiveSdkWebViewPluginManager a()
  {
    if (a == null) {
      synchronized (b)
      {
        if (a == null) {
          a = new LiteLiveSdkWebViewPluginManager();
        }
      }
    }
    return a;
  }
  
  public void a(LiteLiveSdkWebViewRuntime paramLiteLiveSdkWebViewRuntime)
  {
    this.c = paramLiteLiveSdkWebViewRuntime;
  }
  
  public LiteLiveSdkWebViewRuntime b()
  {
    if (this.c == null) {
      synchronized (b)
      {
        if (this.c == null)
        {
          LiteLiveSdkWebViewRuntime localLiteLiveSdkWebViewRuntime = new LiteLiveSdkWebViewRuntime(BaseApplicationImpl.getApplication(), "LiteLiveSdk");
          localLiteLiveSdkWebViewRuntime.onCreate(null);
          this.c = localLiteLiveSdkWebViewRuntime;
        }
      }
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.LiteLiveSdkWebViewPluginManager
 * JD-Core Version:    0.7.0.1
 */