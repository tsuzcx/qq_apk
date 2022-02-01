package com.tencent.qqmini.flutter.core.task;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.qqmini.flutter.core.NativeAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.core.tissue.TissueEnv;
import com.tencent.qqmini.sdk.core.tissue.TissueGlobal;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.proxy.IFlutterProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.MainThreadTask;
import io.flutter.view.FlutterNativeView;
import java.io.File;
import java.lang.reflect.Method;

@ClassTag(tag="NativeRuntimeCreateTask")
public class NativeRuntimeCreateTask
  extends MainThreadTask
{
  public static final String FLUTTER_LOG_TAG = "miniapp-start-TISSUE";
  private static volatile String mLoadedAssetResPath;
  private IFlutterProxy flutterProxy = null;
  
  public NativeRuntimeCreateTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  private static boolean isFileExists(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        boolean bool = new File(paramString).exists();
        return bool;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramString.getMessage());
        QMLog.e("Tools.isFileExists", localStringBuilder.toString());
      }
    }
    return false;
  }
  
  private boolean loadAssetRes(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("/res.apk");
    paramString = ((StringBuilder)localObject).toString();
    boolean bool;
    if ((mLoadedAssetResPath == null) || (!mLoadedAssetResPath.equals(paramString)))
    {
      if (isFileExists(paramString)) {
        try
        {
          long l1 = System.currentTimeMillis();
          localObject = getContext().getAssets();
          Method localMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
          localMethod.setAccessible(true);
          localMethod.invoke(localObject, new Object[] { paramString });
          long l2 = System.currentTimeMillis();
          try
          {
            mLoadedAssetResPath = paramString;
            QMLog.d("miniapp-start-TISSUE", String.format("load asset file %s cost %s ms", new Object[] { paramString, Long.valueOf(l2 - l1) }));
          }
          catch (Exception paramString)
          {
            bool = true;
          }
          QMLog.e("miniapp-start-TISSUE", "loadAsset", paramString);
        }
        catch (Exception paramString)
        {
          bool = false;
        }
      } else {
        QMLog.e("miniapp-start-TISSUE", String.format("assetsPath: %s not exist", new Object[] { paramString }));
      }
    }
    else {
      bool = true;
    }
    if (QMLog.isColorLevel()) {
      QMLog.d("miniapp-start-TISSUE", String.format("loadAssetRes, isSuccess: %s", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  public void executeInMainThread()
  {
    MiniAppReportManager2.reportLaunchPiecewise(200, "", getRuntimeLoader().getMiniAppInfoForReport());
    if (TissueGlobal.tissueEnv != null)
    {
      if (!loadAssetRes(TissueGlobal.tissueEnv.getNativeLibDir())) {
        QMLog.e("miniapp-start-TISSUE", "flutter loadAssetRes failed!!! enableFlutter=false");
      }
    }
    else {
      QMLog.e("miniapp-start-TISSUE", "enableFlutter=false, tissueEnv is null");
    }
    if (this.flutterProxy == null) {
      QMLog.e("miniapp-start-TISSUE", "enableFlutter=false, flutterProxy is null");
    }
    try
    {
      BaseRuntime localBaseRuntime = getRuntimeLoader().getRuntime();
      if (localBaseRuntime == null)
      {
        onTaskFailed();
        return;
      }
      localBaseRuntime.onRuntimeCreate();
      this.flutterProxy.initFlutterRuntime(localBaseRuntime, getContext());
      FlutterNativeView localFlutterNativeView = new FlutterNativeView(this.mContext.getApplicationContext());
      ((NativeAppBrandRuntime)localBaseRuntime).setFlutterNativeView(localFlutterNativeView);
      onTaskSucceed();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start", "RuntimeCreateTask exception!", localThrowable);
      onTaskFailed();
    }
  }
  
  public void executeStartTime()
  {
    MiniAppReportManager2.reportLaunchPiecewise(221, "", getRuntimeLoader().getMiniAppInfoForReport());
  }
  
  public BaseAppBrandRuntime getAppBrandRuntime()
  {
    return (BaseAppBrandRuntime)getRuntimeLoader().getRuntime();
  }
  
  public void onTaskSucceed()
  {
    super.onTaskSucceed();
    MiniAppReportManager2.reportLaunchPiecewise(201, "", getRuntimeLoader().getMiniAppInfoForReport());
  }
  
  public void reset()
  {
    super.reset();
  }
  
  public void setFlutterProxy(IFlutterProxy paramIFlutterProxy)
  {
    this.flutterProxy = paramIFlutterProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.task.NativeRuntimeCreateTask
 * JD-Core Version:    0.7.0.1
 */