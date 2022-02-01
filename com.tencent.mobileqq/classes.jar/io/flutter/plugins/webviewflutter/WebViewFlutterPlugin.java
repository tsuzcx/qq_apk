package io.flutter.plugins.webviewflutter;

import android.util.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugin.platform.PlatformViewsController;

public class WebViewFlutterPlugin
  implements FlutterPlugin
{
  private FlutterCookieManager flutterCookieManager;
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    paramRegistrar.platformViewRegistry().registerViewFactory("plugins.flutter.io/webview", new WebViewFactory(paramRegistrar.messenger(), paramRegistrar.view()));
    new FlutterCookieManager(paramRegistrar.messenger());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("register with registrar");
    localStringBuilder.append(paramRegistrar);
    Log.i("FlutterWebView", localStringBuilder.toString());
  }
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Object localObject = paramFlutterPluginBinding.getFlutterEngine().getDartExecutor();
    paramFlutterPluginBinding.getFlutterEngine().getPlatformViewsController().getRegistry().registerViewFactory("plugins.flutter.io/webview", new WebViewFactory((BinaryMessenger)localObject, null));
    this.flutterCookieManager = new FlutterCookieManager((BinaryMessenger)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("attachedToEngine bindings:");
    ((StringBuilder)localObject).append(paramFlutterPluginBinding);
    ((StringBuilder)localObject).append(",engine:");
    ((StringBuilder)localObject).append(paramFlutterPluginBinding.getFlutterEngine());
    Log.i("FlutterWebView", ((StringBuilder)localObject).toString());
  }
  
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("detachedFromEngine bindings:");
    localStringBuilder.append(paramFlutterPluginBinding);
    localStringBuilder.append(",engine:");
    localStringBuilder.append(paramFlutterPluginBinding.getFlutterEngine());
    Log.i("FlutterWebView", localStringBuilder.toString());
    paramFlutterPluginBinding = this.flutterCookieManager;
    if (paramFlutterPluginBinding == null) {
      return;
    }
    paramFlutterPluginBinding.dispose();
    this.flutterCookieManager = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.WebViewFlutterPlugin
 * JD-Core Version:    0.7.0.1
 */