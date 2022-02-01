package com.tencent.qqexpand;

import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/qqexpand/QflutterQqexpandPlugin$Companion;", "", "()V", "registerWith", "", "registrar", "Lio/flutter/plugin/common/PluginRegistry$Registrar;", "qflutter_qqexpand_release"}, k=1, mv={1, 1, 11})
public final class QflutterQqexpandPlugin$Companion
{
  @JvmStatic
  public final void registerWith(@NotNull PluginRegistry.Registrar paramRegistrar)
  {
    Intrinsics.checkParameterIsNotNull(paramRegistrar, "registrar");
    new MethodChannel(paramRegistrar.messenger(), "qflutter_qqexpand").setMethodCallHandler((MethodChannel.MethodCallHandler)new QflutterQqexpandPlugin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqexpand.QflutterQqexpandPlugin.Companion
 * JD-Core Version:    0.7.0.1
 */