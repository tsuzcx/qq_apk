package com.tencent.qqmini.flutter.core.task;

import android.content.Context;
import android.os.Handler;
import com.tencent.qqmini.flutter.Registry;
import com.tencent.qqmini.flutter.core.NativeAppBrandRuntime;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterRunArguments;

public class TissueEngineInitTask
  extends AsyncTask
{
  public TissueEngineInitTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public void executeAsync()
  {
    Object localObject = (NativeAppBrandRuntime)getRuntimeLoader().getRuntime();
    FlutterNativeView localFlutterNativeView = ((NativeAppBrandRuntime)localObject).getFlutterNativeView();
    Registry.registerWith(localFlutterNativeView.getPluginRegistry());
    ((NativeAppBrandRuntime)localObject).initTissueChannels(new TissueEngineInitTask.1(this));
    localObject = new FlutterRunArguments();
    ((FlutterRunArguments)localObject).bundlePath = FlutterMain.findAppBundlePath();
    ((FlutterRunArguments)localObject).entrypoint = "main";
    this.mainHander.post(new TissueEngineInitTask.2(this, localFlutterNativeView, (FlutterRunArguments)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.task.TissueEngineInitTask
 * JD-Core Version:    0.7.0.1
 */