package com.tencent.mobileqq.qqexpand.flutter;

import android.text.TextUtils;
import com.peterlmeng.animate_image.AnimateImagePlugin;
import com.peterlmeng.animate_image.renderer.IRenderWorkerFactory;
import com.qflutter.audio.BasePlayer;
import com.qflutter.audio.TencentQflutterAudioPlugin;
import com.qflutter.qflutter_beacon_reporter.QflutterBeaconReporterPlugin;
import com.qflutter.qflutter_beacon_reporter.QflutterBeaconReporterPlugin.Companion;
import com.qflutter.qflutter_beacon_reporter.QflutterBeaconReporterPlugin.QFlutterReporter;
import com.qflutter.qflutter_native_router.NativeRouter;
import com.qflutter.qflutter_native_router.QflutterNativeRouterPlugin;
import com.qflutter.qflutter_native_router.QflutterNativeRouterPlugin.Companion;
import com.qflutter.qflutter_qtoast.QFlutterToast;
import com.qflutter.qflutter_qtoast.QflutterQtoastPlugin;
import com.qflutter.qflutter_qtoast.QflutterQtoastPlugin.Companion;
import com.tencent.mobileqq.qqexpand.flutter.audio.ExpandAudioPlayer;
import com.tencent.mobileqq.qqexpand.flutter.router.RouterManager;
import com.tencent.mobileqq.qqexpand.flutter.router.RouterManager.Companion;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils;", "", "()V", "AUDIO_PLAYER_TAG", "", "EXPAND_QFLUTTER_TAG", "PAG_TAG", "TAG", "animateImageLog", "com/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$animateImageLog$1", "Lcom/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$animateImageLog$1;", "apngRenderFactory", "com/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$apngRenderFactory$1", "apngRenderFactory$annotations", "Lcom/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$apngRenderFactory$1;", "audioPlayerLog", "com/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$audioPlayerLog$1", "Lcom/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$audioPlayerLog$1;", "mIsEnginePrepared", "", "sWithoutSchemaList", "", "getIsEnginePrepared", "initApng", "", "initAudioPlayer", "initNativeRouter", "initReporter", "initToast", "isWithoutSchema", "schema", "setEnginePrepared", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterUtils
{
  public static final ExpandFlutterUtils a = new ExpandFlutterUtils();
  private static boolean b;
  private static final List<String> c = CollectionsKt.listOf(new String[] { "mqqapi://expand/conversation", "mqqapi://expand/aio", "mqqapi://expand/main", "mqqapi://expand/edit_profile", "mqqapi://expand/jump", "mqqapi://expand/voiceMatch", "mqqapi://expand/birth_dialog" });
  private static final ExpandFlutterUtils.apngRenderFactory.1 d = new ExpandFlutterUtils.apngRenderFactory.1();
  private static final ExpandFlutterUtils.animateImageLog.1 e = new ExpandFlutterUtils.animateImageLog.1();
  private static final ExpandFlutterUtils.audioPlayerLog.1 f = new ExpandFlutterUtils.audioPlayerLog.1();
  
  public final void a()
  {
    RouterManager.a.a().a();
    QflutterNativeRouterPlugin.Companion.setRouter((NativeRouter)new ExpandFlutterUtils.initNativeRouter.1());
  }
  
  public final boolean a(@Nullable String paramString)
  {
    boolean bool2 = TextUtils.isEmpty((CharSequence)paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    Iterator localIterator = ((Iterable)c).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      String str = (String)localObject;
      if (paramString == null) {
        Intrinsics.throwNpe();
      }
      if (StringsKt.startsWith$default(paramString, str, false, 2, null))
      {
        paramString = localObject;
        break label82;
      }
    }
    paramString = null;
    label82:
    if (paramString != null) {
      bool1 = true;
    }
    return bool1;
  }
  
  public final void b()
  {
    QflutterQtoastPlugin.Companion.setToast((QFlutterToast)new ExpandFlutterUtils.initToast.1());
  }
  
  public final void c()
  {
    QflutterBeaconReporterPlugin.Companion.setReporter((QflutterBeaconReporterPlugin.QFlutterReporter)new ExpandFlutterUtils.initReporter.1());
  }
  
  public final void d()
  {
    AnimateImagePlugin.registerRenderFactory("png", (IRenderWorkerFactory)d);
    AnimateImagePlugin.registerRenderFactory("apng", (IRenderWorkerFactory)d);
    AnimateImagePlugin.setLog((com.peterlmeng.animate_image.support.log.ILog)e);
  }
  
  public final void e()
  {
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      localLogUtils.a().a("ExpandFlutterUtils", 2, "initAudioPlayer...");
    }
    TencentQflutterAudioPlugin.setLog((com.qflutter.audio.log.ILog)f);
    TencentQflutterAudioPlugin.setPlayer((BasePlayer)new ExpandAudioPlayer());
  }
  
  public final boolean f()
  {
    return b;
  }
  
  public final void g()
  {
    b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.ExpandFlutterUtils
 * JD-Core Version:    0.7.0.1
 */