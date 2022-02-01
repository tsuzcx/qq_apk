package io.flutter.plugins;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baseflow.permissionhandler.PermissionHandlerPlugin;
import com.dartnative.dart_native.DartNativePlugin;
import com.dnflutter.dn_flutter_plugin.DnFlutterPlugin;
import com.mojitox.mxflutter.MXFlutterPlugin;
import com.peterlmeng.animate_image.AnimateImagePlugin;
import com.qflutter.audio.TencentQflutterAudioPlugin;
import com.qflutter.log.qflutter_log.QflutterLogPlugin;
import com.qflutter.nativeresources.QFlutterSkinEnginePlugin;
import com.qflutter.qflutter_beacon_reporter.QflutterBeaconReporterPlugin;
import com.qflutter.qflutter_native_router.QflutterNativeRouterPlugin;
import com.qflutter.qflutter_network_image.QflutterNetworkImagePlugin;
import com.qflutter.qflutter_qtoast.QflutterQtoastPlugin;
import com.qflutter.qma_message_channel.QmaMessageChannelPlugin;
import com.qflutter.qqcircle.TencentQQCirclePlugin;
import com.qflutter.qqface.QQFacePlugin;
import com.qflutter.resource_loader.QFlutterResourceLoaderPlugin;
import com.qflutter.superchannel.SuperChannelPlugin;
import com.qflutter.video.QflutterVideoviewPlugin;
import com.qflutter.vistaimage.VistaImagePlugin;
import com.qflutter.vistaplayer.VistaPlayerPlugin;
import com.tencent.kandianFlutter.KandianFlutterPlugin;
import com.tencent.mqq.qflutter_qqgame.QflutterQqgamePlugin;
import com.tencent.qq_mxflutter.QqMxflutterPlugin;
import com.tencent.qqexpand.QflutterQqexpandPlugin;
import com.tencent.rainbow.RainbowPlugin;
import com.tencent.tencent_richtext_library.TencentRichtextLibraryPlugin;
import com.tencent.vibrate.QflutterVibratePlugin;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry;
import io.flutter.plugins.deviceinfo.DeviceInfoPlugin;
import io.flutter.plugins.packageinfo.PackageInfoPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;

@Keep
public final class GeneratedPluginRegistrant
{
  public static void registerWith(@NonNull FlutterEngine paramFlutterEngine)
  {
    ShimPluginRegistry localShimPluginRegistry = new ShimPluginRegistry(paramFlutterEngine);
    paramFlutterEngine.getPlugins().add(new MXFlutterPlugin());
    paramFlutterEngine.getPlugins().add(new DnFlutterPlugin());
    paramFlutterEngine.getPlugins().add(new RainbowPlugin());
    paramFlutterEngine.getPlugins().add(new KandianFlutterPlugin());
    paramFlutterEngine.getPlugins().add(new AnimateImagePlugin());
    paramFlutterEngine.getPlugins().add(new QflutterBeaconReporterPlugin());
    paramFlutterEngine.getPlugins().add(new QflutterNativeRouterPlugin());
    paramFlutterEngine.getPlugins().add(new QflutterQqexpandPlugin());
    paramFlutterEngine.getPlugins().add(new QflutterQqgamePlugin());
    paramFlutterEngine.getPlugins().add(new QflutterQtoastPlugin());
    paramFlutterEngine.getPlugins().add(new QflutterVibratePlugin());
    QflutterVideoviewPlugin.registerWith(localShimPluginRegistry.registrarFor("com.qflutter.video.QflutterVideoviewPlugin"));
    paramFlutterEngine.getPlugins().add(new QmaMessageChannelPlugin());
    paramFlutterEngine.getPlugins().add(new QqMxflutterPlugin());
    paramFlutterEngine.getPlugins().add(new TencentQflutterAudioPlugin());
    paramFlutterEngine.getPlugins().add(new TencentQQCirclePlugin());
    paramFlutterEngine.getPlugins().add(new TencentRichtextLibraryPlugin());
    paramFlutterEngine.getPlugins().add(new VistaPlayerPlugin());
    QflutterLogPlugin.registerWith(localShimPluginRegistry.registrarFor("com.qflutter.log.qflutter_log.QflutterLogPlugin"));
    paramFlutterEngine.getPlugins().add(new QFlutterSkinEnginePlugin());
    QflutterNetworkImagePlugin.registerWith(localShimPluginRegistry.registrarFor("com.qflutter.qflutter_network_image.QflutterNetworkImagePlugin"));
    paramFlutterEngine.getPlugins().add(new QQFacePlugin());
    QFlutterResourceLoaderPlugin.registerWith(localShimPluginRegistry.registrarFor("com.qflutter.resource_loader.QFlutterResourceLoaderPlugin"));
    paramFlutterEngine.getPlugins().add(new SuperChannelPlugin());
    paramFlutterEngine.getPlugins().add(new VistaImagePlugin());
    paramFlutterEngine.getPlugins().add(new DartNativePlugin());
    paramFlutterEngine.getPlugins().add(new DeviceInfoPlugin());
    paramFlutterEngine.getPlugins().add(new PackageInfoPlugin());
    PathProviderPlugin.registerWith(localShimPluginRegistry.registrarFor("io.flutter.plugins.pathprovider.PathProviderPlugin"));
    paramFlutterEngine.getPlugins().add(new PermissionHandlerPlugin());
    paramFlutterEngine.getPlugins().add(new SharedPreferencesPlugin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugins.GeneratedPluginRegistrant
 * JD-Core Version:    0.7.0.1
 */