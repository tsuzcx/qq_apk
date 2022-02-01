package com.tencent.qqexpand;

import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/qqexpand/QflutterQqexpandPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "qflutter_qqexpand_release"}, k=1, mv={1, 1, 11})
public final class QflutterQqexpandPlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  public static final QflutterQqexpandPlugin.Companion Companion = new QflutterQqexpandPlugin.Companion(null);
  
  @JvmStatic
  public static final void registerWith(@NotNull PluginRegistry.Registrar paramRegistrar)
  {
    Companion.registerWith(paramRegistrar);
  }
  
  public void onAttachedToEngine(@NonNull @NotNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Intrinsics.checkParameterIsNotNull(paramFlutterPluginBinding, "flutterPluginBinding");
    new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "qflutter_qqexpand").setMethodCallHandler((MethodChannel.MethodCallHandler)new QflutterQqexpandPlugin());
  }
  
  public void onDetachedFromEngine(@NonNull @NotNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Intrinsics.checkParameterIsNotNull(paramFlutterPluginBinding, "binding");
  }
  
  public void onMethodCall(@NonNull @NotNull MethodCall paramMethodCall, @NonNull @NotNull MethodChannel.Result paramResult)
  {
    Intrinsics.checkParameterIsNotNull(paramMethodCall, "call");
    Intrinsics.checkParameterIsNotNull(paramResult, "result");
    if (Intrinsics.areEqual(paramMethodCall.method, "getPlatformVersion"))
    {
      paramMethodCall = new StringBuilder();
      paramMethodCall.append("Android ");
      paramMethodCall.append(Build.VERSION.RELEASE);
      paramResult.success(paramMethodCall.toString());
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqexpand.QflutterQqexpandPlugin
 * JD-Core Version:    0.7.0.1
 */