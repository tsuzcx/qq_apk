package io.flutter.plugins;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.idlefish.flutterboost.FlutterBoostPlugin;
import com.qflutter.log.qflutter_log.QflutterLogPlugin;
import com.qflutter.native_resources.QFlutterSkinEnginePlugin;
import com.qflutter.qflutter_network_image.QflutterNetworkImagePlugin;
import com.qflutter.qqcircle.TencentQQCirclePlugin;
import com.qflutter.qqface.QQFacePlugin;
import com.qflutter.resource_loader.QFlutterResourceLoaderPlugin;
import com.qflutter.video.QflutterVideoviewPlugin;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry;
import io.flutter.plugins.packageinfo.PackageInfoPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;

@Keep
public final class GeneratedPluginRegistrant
{
  public static void registerWith(@NonNull FlutterEngine paramFlutterEngine)
  {
    ShimPluginRegistry localShimPluginRegistry = new ShimPluginRegistry(paramFlutterEngine);
    paramFlutterEngine.getPlugins().add(new PackageInfoPlugin());
    PathProviderPlugin.registerWith(localShimPluginRegistry.registrarFor("io.flutter.plugins.pathprovider.PathProviderPlugin"));
    QflutterVideoviewPlugin.registerWith(localShimPluginRegistry.registrarFor("com.qflutter.video.QflutterVideoviewPlugin"));
    FlutterBoostPlugin.registerWith(localShimPluginRegistry.registrarFor("com.idlefish.flutterboost.FlutterBoostPlugin"));
    QflutterLogPlugin.registerWith(localShimPluginRegistry.registrarFor("com.qflutter.log.qflutter_log.QflutterLogPlugin"));
    QFlutterSkinEnginePlugin.registerWith(localShimPluginRegistry.registrarFor("com.qflutter.native_resources.QFlutterSkinEnginePlugin"));
    QflutterNetworkImagePlugin.registerWith(localShimPluginRegistry.registrarFor("com.qflutter.qflutter_network_image.QflutterNetworkImagePlugin"));
    paramFlutterEngine.getPlugins().add(new TencentQQCirclePlugin());
    paramFlutterEngine.getPlugins().add(new QQFacePlugin());
    QFlutterResourceLoaderPlugin.registerWith(localShimPluginRegistry.registrarFor("com.qflutter.resource_loader.QFlutterResourceLoaderPlugin"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugins.GeneratedPluginRegistrant
 * JD-Core Version:    0.7.0.1
 */