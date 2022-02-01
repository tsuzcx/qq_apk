package io.flutter.plugins;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.dartnative.dart_native.DartNativePlugin;
import com.peterlmeng.animate_image.AnimateImagePlugin;
import com.qflutter.log.qflutter_log.QflutterLogPlugin;
import com.qflutter.nativeresources.QFlutterSkinEnginePlugin;
import com.qflutter.qflutter_beacon_reporter.QflutterBeaconReporterPlugin;
import com.qflutter.qflutter_native_router.QflutterNativeRouterPlugin;
import com.qflutter.qflutter_network_image.QflutterNetworkImagePlugin;
import com.qflutter.qflutter_qtoast.QflutterQtoastPlugin;
import com.qflutter.qqcircle.TencentQQCirclePlugin;
import com.qflutter.qqface.QQFacePlugin;
import com.qflutter.resource_loader.QFlutterResourceLoaderPlugin;
import com.qflutter.tencent_vista_image.TencentVistaImagePlugin;
import com.qflutter.video.QflutterVideoviewPlugin;
import com.tencent.qqexpand.QflutterQqexpandPlugin;
import com.tencent.tencent_richtext_library.TencentRichtextLibraryPlugin;
import com.tencent.vibrate.QflutterVibratePlugin;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry;
import io.flutter.plugins.packageinfo.PackageInfoPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;

@Keep
public final class GeneratedPluginRegistrant
{
  public static void registerWith(@NonNull FlutterEngine paramFlutterEngine)
  {
    ShimPluginRegistry localShimPluginRegistry = new ShimPluginRegistry(paramFlutterEngine);
    paramFlutterEngine.getPlugins().add(new AnimateImagePlugin());
    paramFlutterEngine.getPlugins().add(new QflutterBeaconReporterPlugin());
    paramFlutterEngine.getPlugins().add(new QflutterNativeRouterPlugin());
    paramFlutterEngine.getPlugins().add(new QflutterQqexpandPlugin());
    paramFlutterEngine.getPlugins().add(new QflutterQtoastPlugin());
    paramFlutterEngine.getPlugins().add(new QflutterVibratePlugin());
    QflutterVideoviewPlugin.registerWith(localShimPluginRegistry.registrarFor("com.qflutter.video.QflutterVideoviewPlugin"));
    paramFlutterEngine.getPlugins().add(new TencentQQCirclePlugin());
    paramFlutterEngine.getPlugins().add(new TencentRichtextLibraryPlugin());
    paramFlutterEngine.getPlugins().add(new TencentVistaImagePlugin());
    QflutterLogPlugin.registerWith(localShimPluginRegistry.registrarFor("com.qflutter.log.qflutter_log.QflutterLogPlugin"));
    paramFlutterEngine.getPlugins().add(new QFlutterSkinEnginePlugin());
    QflutterNetworkImagePlugin.registerWith(localShimPluginRegistry.registrarFor("com.qflutter.qflutter_network_image.QflutterNetworkImagePlugin"));
    paramFlutterEngine.getPlugins().add(new QQFacePlugin());
    QFlutterResourceLoaderPlugin.registerWith(localShimPluginRegistry.registrarFor("com.qflutter.resource_loader.QFlutterResourceLoaderPlugin"));
    paramFlutterEngine.getPlugins().add(new DartNativePlugin());
    paramFlutterEngine.getPlugins().add(new PackageInfoPlugin());
    PathProviderPlugin.registerWith(localShimPluginRegistry.registrarFor("io.flutter.plugins.pathprovider.PathProviderPlugin"));
    paramFlutterEngine.getPlugins().add(new SharedPreferencesPlugin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugins.GeneratedPluginRegistrant
 * JD-Core Version:    0.7.0.1
 */