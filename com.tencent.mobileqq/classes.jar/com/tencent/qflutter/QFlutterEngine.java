package com.tencent.qflutter;

import android.app.Application;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoost.ConfigBuilder;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import io.flutter.embedding.android.FlutterView.RenderMode;

public class QFlutterEngine
{
  public static void initializeFlutterBoost(Application paramApplication, INativeRouter paramINativeRouter, QFlutterEngine.EventListener paramEventListener)
  {
    paramEventListener = new QFlutterEngine.1(paramEventListener);
    paramApplication = new FlutterBoost.ConfigBuilder(paramApplication, paramINativeRouter).isDebug(true).whenEngineStart(FlutterBoost.ConfigBuilder.ANY_ACTIVITY_CREATED).renderMode(FlutterView.RenderMode.texture).pluginsRegister(paramEventListener).build();
    FlutterBoost.instance().init(paramApplication);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qflutter.QFlutterEngine
 * JD-Core Version:    0.7.0.1
 */