package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.RenderInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;
import java.util.Map;

@ClassTag(tag="ApkgLoadAsyncTask")
public class ApkgLoadAsyncTask
  extends AsyncTask
{
  private boolean enableFlutter = false;
  private ApkgInfo mApkgInfo;
  private MiniAppInfo mMiniAppInfo;
  
  public ApkgLoadAsyncTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public void executeAsync()
  {
    loadApkg(getRuntimeLoader().getMiniAppInfo());
  }
  
  public ApkgInfo getApkgInfo()
  {
    return this.mApkgInfo;
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  public void loadApkg(MiniAppInfo paramMiniAppInfo)
  {
    MiniAppReportManager2.reportLaunchPiecewise(206, "", getRuntimeLoader().getMiniAppInfoForReport());
    QMLog.i("BaseRuntimeLoader", "ApkgLoadAsyncTask start loadApkgByConfig");
    if (paramMiniAppInfo != null) {
      paramMiniAppInfo.launchParam.isFlutterMode = this.enableFlutter;
    }
    if ((this.enableFlutter) && (paramMiniAppInfo != null) && (paramMiniAppInfo.supportNativeRenderMode()))
    {
      QMLog.i("BaseRuntimeLoader", "ApkgLoadAsyncTask use flutter url:" + (String)paramMiniAppInfo.renderInfo.renderMaterialMap.get(Integer.valueOf(1)));
      paramMiniAppInfo.downloadUrl = ((String)paramMiniAppInfo.renderInfo.renderMaterialMap.get(Integer.valueOf(1)));
    }
    ApkgManager.getInstance().getApkgInfoByConfig(paramMiniAppInfo, new ApkgLoadAsyncTask.1(this, paramMiniAppInfo));
  }
  
  public void onTaskSucceed()
  {
    super.onTaskSucceed();
    MiniAppReportManager2.reportLaunchPiecewise(207, "", getRuntimeLoader().getMiniAppInfoForReport());
  }
  
  public void setFlutterEnable(boolean paramBoolean)
  {
    this.enableFlutter = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.task.ApkgLoadAsyncTask
 * JD-Core Version:    0.7.0.1
 */