package com.tencent.mobileqq.qqexpand.flutter;

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
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils;", "", "()V", "AUDIO_PLAYER_TAG", "", "EXPAND_QFLUTTER_TAG", "PAG_TAG", "TAG", "animateImageLog", "com/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$animateImageLog$1", "Lcom/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$animateImageLog$1;", "apngRenderFactory", "com/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$apngRenderFactory$1", "apngRenderFactory$annotations", "Lcom/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$apngRenderFactory$1;", "audioPlayerLog", "com/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$audioPlayerLog$1", "Lcom/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$audioPlayerLog$1;", "mIsEnginePrepared", "", "getIsEnginePrepared", "initApng", "", "initAudioPlayer", "initNativeRouter", "initReporter", "initToast", "setEnginePrepared", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterUtils
{
  private static final ExpandFlutterUtils.animateImageLog.1 jdField_a_of_type_ComTencentMobileqqQqexpandFlutterExpandFlutterUtils$animateImageLog$1 = new ExpandFlutterUtils.animateImageLog.1();
  private static final ExpandFlutterUtils.apngRenderFactory.1 jdField_a_of_type_ComTencentMobileqqQqexpandFlutterExpandFlutterUtils$apngRenderFactory$1;
  private static final ExpandFlutterUtils.audioPlayerLog.1 jdField_a_of_type_ComTencentMobileqqQqexpandFlutterExpandFlutterUtils$audioPlayerLog$1 = new ExpandFlutterUtils.audioPlayerLog.1();
  public static final ExpandFlutterUtils a;
  private static boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqQqexpandFlutterExpandFlutterUtils = new ExpandFlutterUtils();
    jdField_a_of_type_ComTencentMobileqqQqexpandFlutterExpandFlutterUtils$apngRenderFactory$1 = new ExpandFlutterUtils.apngRenderFactory.1();
  }
  
  public final void a()
  {
    RouterManager.a.a().a();
    QflutterNativeRouterPlugin.Companion.setRouter((NativeRouter)new ExpandFlutterUtils.initNativeRouter.1());
  }
  
  public final boolean a()
  {
    return jdField_a_of_type_Boolean;
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
    AnimateImagePlugin.registerRenderFactory("png", (IRenderWorkerFactory)jdField_a_of_type_ComTencentMobileqqQqexpandFlutterExpandFlutterUtils$apngRenderFactory$1);
    AnimateImagePlugin.registerRenderFactory("apng", (IRenderWorkerFactory)jdField_a_of_type_ComTencentMobileqqQqexpandFlutterExpandFlutterUtils$apngRenderFactory$1);
    AnimateImagePlugin.setLog((com.peterlmeng.animate_image.support.log.ILog)jdField_a_of_type_ComTencentMobileqqQqexpandFlutterExpandFlutterUtils$animateImageLog$1);
  }
  
  public final void e()
  {
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      localLogUtils.a().a("ExpandFlutterUtils", 2, "initAudioPlayer...");
    }
    TencentQflutterAudioPlugin.setLog((com.qflutter.audio.log.ILog)jdField_a_of_type_ComTencentMobileqqQqexpandFlutterExpandFlutterUtils$audioPlayerLog$1);
    TencentQflutterAudioPlugin.setPlayer((BasePlayer)new ExpandAudioPlayer());
  }
  
  public final void f()
  {
    jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.ExpandFlutterUtils
 * JD-Core Version:    0.7.0.1
 */