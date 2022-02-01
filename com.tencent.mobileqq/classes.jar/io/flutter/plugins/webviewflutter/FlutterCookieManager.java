package io.flutter.plugins.webviewflutter;

import android.os.Build.VERSION;
import android.webkit.CookieManager;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

class FlutterCookieManager
  implements MethodChannel.MethodCallHandler
{
  private final MethodChannel methodChannel;
  
  FlutterCookieManager(BinaryMessenger paramBinaryMessenger)
  {
    this.methodChannel = new MethodChannel(paramBinaryMessenger, "plugins.flutter.io/cookie_manager");
    this.methodChannel.setMethodCallHandler(this);
  }
  
  private static void clearCookies(MethodChannel.Result paramResult)
  {
    CookieManager localCookieManager = CookieManager.getInstance();
    boolean bool = localCookieManager.hasCookies();
    if (Build.VERSION.SDK_INT >= 21)
    {
      localCookieManager.removeAllCookies(new FlutterCookieManager.1(paramResult, bool));
      return;
    }
    localCookieManager.removeAllCookie();
    paramResult.success(Boolean.valueOf(bool));
  }
  
  void dispose()
  {
    this.methodChannel.setMethodCallHandler(null);
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    paramMethodCall = paramMethodCall.method;
    int i;
    if ((paramMethodCall.hashCode() == 928375682) && (paramMethodCall.equals("clearCookies"))) {
      i = 0;
    } else {
      i = -1;
    }
    if (i != 0)
    {
      paramResult.notImplemented();
      return;
    }
    clearCookies(paramResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.FlutterCookieManager
 * JD-Core Version:    0.7.0.1
 */