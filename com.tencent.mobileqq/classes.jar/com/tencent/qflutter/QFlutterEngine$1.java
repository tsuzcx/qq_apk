package com.tencent.qflutter;

import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoost.BoostLifecycleListener;
import com.idlefish.flutterboost.FlutterBoostPlugin;
import io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugins.GeneratedPluginRegistrant;

final class QFlutterEngine$1
  implements FlutterBoost.BoostLifecycleListener
{
  QFlutterEngine$1(QFlutterEngine.EventListener paramEventListener) {}
  
  public void beforeCreateEngine() {}
  
  public void onEngineCreated()
  {
    GeneratedPluginRegistrant.registerWith(FlutterBoost.instance().engineProvider());
    PluginRegistry.Registrar localRegistrar = new ShimPluginRegistry(FlutterBoost.instance().engineProvider()).registrarFor("TextPlatformViewPlugin");
    TextPlatformViewPlugin.register(localRegistrar);
    if (this.val$eventListener != null) {
      this.val$eventListener.onInited(localRegistrar.messenger());
    }
    FlutterBoostPlugin.singleton().addEventListener("test_open_native", new QFlutterEngine.1.1(this));
  }
  
  public void onEngineDestroy() {}
  
  public void onPluginsRegistered() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qflutter.QFlutterEngine.1
 * JD-Core Version:    0.7.0.1
 */