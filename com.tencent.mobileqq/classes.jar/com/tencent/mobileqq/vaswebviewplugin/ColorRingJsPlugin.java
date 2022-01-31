package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ColorRingJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BusinessName = "colorRing";
  public static final String Method_ChangeTab = "changeTab";
  public static final String Method_GetCurrentId = "getCurrentId";
  public static final String Method_Play = "play";
  public static final String Method_SetUp = "setup";
  public static final String TAG = "ColorRingJsPlugin";
  public Activity mActivity;
  public BrowserAppInterface mBrowserApp;
  
  public ColorRingJsPlugin()
  {
    this.mPluginNameSpace = "colorRing";
  }
  
  void changeTab(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingJsPlugin", 2, "changeTab");
    }
    SwiftBrowserMiscHandler localSwiftBrowserMiscHandler = (SwiftBrowserMiscHandler)super.getBrowserComponent(32);
    if (localSwiftBrowserMiscHandler != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("callbackId", paramString);
      paramString = localSwiftBrowserMiscHandler.a.obtainMessage(5, localBundle);
      localSwiftBrowserMiscHandler.a.dispatchMessage(paramString);
    }
  }
  
  void getCurrentId(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingJsPlugin", 2, "getCurrentId");
    }
    ThreadManager.post(new ColorRingJsPlugin.1(this, paramString1, paramString2), 5, null, true);
  }
  
  protected long getPluginBusiness()
  {
    return 2151677952L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingJsPlugin", 2, "handleJsRequest, url=" + paramString1);
    }
    if ((!"colorRing".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {
      bool = false;
    }
    long l;
    int i;
    for (;;)
    {
      return bool;
      try
      {
        paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (paramString1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorRingJsPlugin", 2, "handleJsRequest JSON = " + paramString1.toString());
          }
          paramJsBridgeListener = paramString1.optString("callback");
          l = paramString1.optLong("id");
          i = paramString1.optInt("status");
          paramString1 = paramString1.optString("type", "comering");
          if ("getCurrentId".equals(paramString3))
          {
            getCurrentId(paramString1, paramJsBridgeListener);
            return true;
          }
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    if ("play".equals(paramString3))
    {
      play(l, paramString1, paramJsBridgeListener);
      return true;
    }
    if ("setup".equals(paramString3))
    {
      setup(l, i, paramString1, paramJsBridgeListener);
      return true;
    }
    if ("changeTab".equals(paramString3))
    {
      changeTab(paramJsBridgeListener);
      return true;
    }
    throw new Exception("No Such Method:" + paramString3);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mActivity = this.mRuntime.a();
    this.mBrowserApp = ((BrowserAppInterface)this.mRuntime.a());
  }
  
  void play(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingJsPlugin", 2, "play, id=" + paramLong);
    }
    SwiftBrowserMiscHandler localSwiftBrowserMiscHandler = (SwiftBrowserMiscHandler)super.getBrowserComponent(32);
    if (localSwiftBrowserMiscHandler != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("id", paramLong);
      localBundle.putString("callbackId", paramString2);
      localBundle.putString("type", paramString1);
      paramString1 = localSwiftBrowserMiscHandler.a.obtainMessage(3, localBundle);
      localSwiftBrowserMiscHandler.a.dispatchMessage(paramString1);
    }
  }
  
  void setup(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingJsPlugin", 2, "setup, id=" + paramLong);
    }
    SwiftBrowserMiscHandler localSwiftBrowserMiscHandler = (SwiftBrowserMiscHandler)super.getBrowserComponent(32);
    if (localSwiftBrowserMiscHandler != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("id", paramLong);
      localBundle.putInt("status", paramInt);
      localBundle.putString("type", paramString1);
      localBundle.putString("callbackId", paramString2);
      paramString1 = localSwiftBrowserMiscHandler.a.obtainMessage(4, localBundle);
      localSwiftBrowserMiscHandler.a.dispatchMessage(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin
 * JD-Core Version:    0.7.0.1
 */