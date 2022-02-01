package io.flutter.plugins.webviewflutter;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebViewClient;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.platform.PlatformView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FlutterWebView
  implements MethodChannel.MethodCallHandler, PlatformView
{
  private static final String JS_CHANNEL_NAMES_FIELD = "javascriptChannelNames";
  public static final String LOG_TAG = "FlutterWebView";
  private final FlutterWebViewClient flutterWebViewClient;
  private final MethodChannel methodChannel;
  private final Handler platformThreadHandler;
  private final InputAwareWebView webView;
  
  @TargetApi(17)
  FlutterWebView(Context paramContext, BinaryMessenger paramBinaryMessenger, int paramInt, Map<String, Object> paramMap, View paramView)
  {
    DisplayListenerProxy localDisplayListenerProxy = new DisplayListenerProxy();
    DisplayManager localDisplayManager = (DisplayManager)paramContext.getSystemService("display");
    localDisplayListenerProxy.onPreWebViewInitialization(localDisplayManager);
    this.webView = new InputAwareWebView(paramContext, paramView);
    localDisplayListenerProxy.onPostWebViewInitialization(localDisplayManager);
    this.platformThreadHandler = new Handler(paramContext.getMainLooper());
    this.webView.getSettings().setDomStorageEnabled(true);
    paramContext = new StringBuilder();
    paramContext.append("plugins.flutter.io/webview_");
    paramContext.append(paramInt);
    this.methodChannel = new MethodChannel(paramBinaryMessenger, paramContext.toString());
    this.methodChannel.setMethodCallHandler(this);
    this.flutterWebViewClient = new FlutterWebViewClient(this.methodChannel);
    applySettings((Map)paramMap.get("settings"));
    if (paramMap.containsKey("javascriptChannelNames")) {
      registerJavaScriptChannelNames((List)paramMap.get("javascriptChannelNames"));
    }
    updateAutoMediaPlaybackPolicy(((Integer)paramMap.get("autoMediaPlaybackPolicy")).intValue());
    if (paramMap.containsKey("userAgent")) {
      updateUserAgent((String)paramMap.get("userAgent"));
    }
    Log.i("FlutterWebView", "init");
    if (paramMap.containsKey("initialUrl"))
    {
      paramContext = (String)paramMap.get("initialUrl");
      this.webView.loadUrl(paramContext);
      paramBinaryMessenger = new StringBuilder();
      paramBinaryMessenger.append("loadUrl ");
      paramBinaryMessenger.append(paramContext);
      Log.i("FlutterWebView", paramBinaryMessenger.toString());
    }
  }
  
  private void addJavaScriptChannels(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    registerJavaScriptChannelNames((List)paramMethodCall.arguments);
    paramResult.success(null);
  }
  
  private void applySettings(Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      int i = -1;
      int j = ((String)localObject).hashCode();
      if (j != -1151668596)
      {
        if (j != -1069908877)
        {
          if (j != 311430650)
          {
            if ((j == 858297331) && (((String)localObject).equals("hasNavigationDelegate"))) {
              i = 1;
            }
          }
          else if (((String)localObject).equals("userAgent")) {
            i = 3;
          }
        }
        else if (((String)localObject).equals("debuggingEnabled")) {
          i = 2;
        }
      }
      else if (((String)localObject).equals("jsMode")) {
        i = 0;
      }
      if (i != 0)
      {
        boolean bool;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              updateUserAgent((String)paramMap.get(localObject));
            }
            else
            {
              paramMap = new StringBuilder();
              paramMap.append("Unknown WebView setting: ");
              paramMap.append((String)localObject);
              throw new IllegalArgumentException(paramMap.toString());
            }
          }
          else
          {
            bool = ((Boolean)paramMap.get(localObject)).booleanValue();
            localObject = this.webView;
            InputAwareWebView.setWebContentsDebuggingEnabled(bool);
          }
        }
        else
        {
          bool = ((Boolean)paramMap.get(localObject)).booleanValue();
          localObject = this.flutterWebViewClient.createWebViewClient(bool);
          this.webView.setWebViewClient((WebViewClient)localObject);
          this.webView.setWebChromeClient(this.flutterWebViewClient.createWebChromeClient());
        }
      }
      else
      {
        updateJsMode(((Integer)paramMap.get(localObject)).intValue());
      }
    }
  }
  
  private void canGoBack(MethodChannel.Result paramResult)
  {
    paramResult.success(Boolean.valueOf(this.webView.canGoBack()));
  }
  
  private void canGoForward(MethodChannel.Result paramResult)
  {
    paramResult.success(Boolean.valueOf(this.webView.canGoForward()));
  }
  
  private void clearCache(MethodChannel.Result paramResult)
  {
    this.webView.clearCache(true);
    WebStorage.getInstance().deleteAllData();
    paramResult.success(null);
  }
  
  private void currentUrl(MethodChannel.Result paramResult)
  {
    paramResult.success(this.webView.getUrl());
  }
  
  @TargetApi(19)
  private void evaluateJavaScript(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    paramMethodCall = (String)paramMethodCall.arguments;
    if (paramMethodCall != null)
    {
      this.webView.evaluateJavascript(paramMethodCall, new FlutterWebView.1(this, paramResult));
      return;
    }
    throw new UnsupportedOperationException("JavaScript string cannot be null");
  }
  
  private void getTitle(MethodChannel.Result paramResult)
  {
    paramResult.success(this.webView.getTitle());
  }
  
  private void goBack(MethodChannel.Result paramResult)
  {
    if (this.webView.canGoBack()) {
      this.webView.goBack();
    }
    paramResult.success(null);
  }
  
  private void goForward(MethodChannel.Result paramResult)
  {
    if (this.webView.canGoForward()) {
      this.webView.goForward();
    }
    paramResult.success(null);
  }
  
  private void loadUrl(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    paramMethodCall = (Map)paramMethodCall.arguments;
    String str = (String)paramMethodCall.get("url");
    Object localObject = (Map)paramMethodCall.get("headers");
    paramMethodCall = (MethodCall)localObject;
    if (localObject == null) {
      paramMethodCall = Collections.emptyMap();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadUrl from methodCall");
    ((StringBuilder)localObject).append(str);
    Log.i("FlutterWebView", ((StringBuilder)localObject).toString());
    this.webView.loadUrl(str, paramMethodCall);
    paramResult.success(null);
  }
  
  private void registerJavaScriptChannelNames(List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      this.webView.addJavascriptInterface(new JavaScriptChannel(this.methodChannel, str, this.platformThreadHandler), str);
    }
  }
  
  private void reload(MethodChannel.Result paramResult)
  {
    this.webView.reload();
    paramResult.success(null);
  }
  
  private void removeJavaScriptChannels(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    paramMethodCall = ((List)paramMethodCall.arguments).iterator();
    while (paramMethodCall.hasNext())
    {
      String str = (String)paramMethodCall.next();
      this.webView.removeJavascriptInterface(str);
    }
    paramResult.success(null);
  }
  
  private void updateAutoMediaPlaybackPolicy(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 1) {
      bool = false;
    }
    this.webView.getSettings().setMediaPlaybackRequiresUserGesture(bool);
  }
  
  private void updateJsMode(int paramInt)
  {
    boolean bool;
    Object localObject;
    if (paramInt != 0)
    {
      bool = true;
      if (paramInt == 1)
      {
        localObject = this.webView.getSettings();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Trying to set unknown JavaScript mode: ");
        ((StringBuilder)localObject).append(paramInt);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      localObject = this.webView.getSettings();
      bool = false;
    }
    ((WebSettings)localObject).setJavaScriptEnabled(bool);
  }
  
  private void updateSettings(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    applySettings((Map)paramMethodCall.arguments);
    paramResult.success(null);
  }
  
  private void updateUserAgent(String paramString)
  {
    this.webView.getSettings().setUserAgentString(paramString);
  }
  
  public void dispose()
  {
    this.methodChannel.setMethodCallHandler(null);
    this.webView.dispose();
    this.webView.destroy();
  }
  
  public View getView()
  {
    return this.webView;
  }
  
  public void onFlutterViewAttached(View paramView)
  {
    this.webView.setContainerView(paramView);
  }
  
  public void onFlutterViewDetached()
  {
    this.webView.setContainerView(null);
  }
  
  public void onInputConnectionLocked()
  {
    this.webView.lockInputConnection();
  }
  
  public void onInputConnectionUnlocked()
  {
    this.webView.unlockInputConnection();
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    String str = paramMethodCall.method;
    switch (str.hashCode())
    {
    default: 
      break;
    case 1966196898: 
      if (str.equals("getTitle")) {
        i = 12;
      }
      break;
    case 1937913574: 
      if (str.equals("evaluateJavascript")) {
        i = 8;
      }
      break;
    case 651673601: 
      if (str.equals("removeJavascriptChannels")) {
        i = 10;
      }
      break;
    case 336631465: 
      if (str.equals("loadUrl")) {
        i = 0;
      }
      break;
    case -317054497: 
      if (str.equals("canGoBack")) {
        i = 2;
      }
      break;
    case -318289731: 
      if (str.equals("goForward")) {
        i = 5;
      }
      break;
    case -759238347: 
      if (str.equals("clearCache")) {
        i = 11;
      }
      break;
    case -934641255: 
      if (str.equals("reload")) {
        i = 6;
      }
      break;
    case -1067273523: 
      if (str.equals("canGoForward")) {
        i = 3;
      }
      break;
    case -1088982730: 
      if (str.equals("currentUrl")) {
        i = 7;
      }
      break;
    case -1241591313: 
      if (str.equals("goBack")) {
        i = 4;
      }
      break;
    case -1707388194: 
      if (str.equals("addJavascriptChannels")) {
        i = 9;
      }
      break;
    case -1990164468: 
      if (str.equals("updateSettings")) {
        i = 1;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      paramResult.notImplemented();
      return;
    case 12: 
      getTitle(paramResult);
      return;
    case 11: 
      clearCache(paramResult);
      return;
    case 10: 
      removeJavaScriptChannels(paramMethodCall, paramResult);
      return;
    case 9: 
      addJavaScriptChannels(paramMethodCall, paramResult);
      return;
    case 8: 
      evaluateJavaScript(paramMethodCall, paramResult);
      return;
    case 7: 
      currentUrl(paramResult);
      return;
    case 6: 
      reload(paramResult);
      return;
    case 5: 
      goForward(paramResult);
      return;
    case 4: 
      goBack(paramResult);
      return;
    case 3: 
      canGoForward(paramResult);
      return;
    case 2: 
      canGoBack(paramResult);
      return;
    case 1: 
      updateSettings(paramMethodCall, paramResult);
      return;
    }
    loadUrl(paramMethodCall, paramResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.FlutterWebView
 * JD-Core Version:    0.7.0.1
 */