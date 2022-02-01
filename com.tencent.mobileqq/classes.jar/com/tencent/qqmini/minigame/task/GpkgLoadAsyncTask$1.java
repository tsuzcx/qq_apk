package com.tencent.qqmini.minigame.task;

import android.text.TextUtils;
import com.tencent.qqmini.minigame.gpkg.GpkgManager.Info;
import com.tencent.qqmini.minigame.gpkg.GpkgManager.OnInitGpkgListener;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.ui.LoadingStatus.Builder;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import java.util.Locale;

class GpkgLoadAsyncTask$1
  implements GpkgManager.OnInitGpkgListener
{
  private float lastProgress = 0.0F;
  
  GpkgLoadAsyncTask$1(GpkgLoadAsyncTask paramGpkgLoadAsyncTask, long paramLong) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    if (paramFloat - this.lastProgress > 0.1F)
    {
      this.lastProgress = paramFloat;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(100.0F * paramFloat) }));
      ((StringBuilder)localObject).append("%");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Gpkg]");
      localStringBuilder.append(paramMiniAppInfo.appId);
      localStringBuilder.append("(");
      localStringBuilder.append(paramMiniAppInfo.name);
      localStringBuilder.append("), progress ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", size=");
      localStringBuilder.append(paramLong);
      QMLog.i("GpkgLoadAsyncTask", localStringBuilder.toString());
      paramMiniAppInfo = (MiniAppInfo)localObject;
    }
    else
    {
      paramMiniAppInfo = "";
    }
    if (!TextUtils.isEmpty(paramMiniAppInfo))
    {
      paramMiniAppInfo = new LoadingStatus.Builder().setProgress(paramFloat).build();
      this.this$0.getRuntimeLoader().notifyRuntimeEvent(2001, new Object[] { paramMiniAppInfo });
    }
  }
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString, GpkgManager.Info paramInfo)
  {
    GpkgLoadAsyncTask.access$002(this.this$0, paramInfo);
    paramInfo = new StringBuilder();
    paramInfo.append("[Gpkg] getGpkgInfoByConfig end, resCode=");
    paramInfo.append(paramInt);
    paramInfo.append(", msg=");
    paramInfo.append(paramString);
    paramInfo.append(" ,timecost=");
    paramInfo.append(System.currentTimeMillis() - this.val$startTime);
    QMLog.i("GpkgLoadAsyncTask", paramInfo.toString());
    if ((paramInt == 0) && (paramMiniGamePkg != null))
    {
      paramString = new StringBuilder();
      paramString.append("[Gpkg] getGpkgInfoByConfig appid=");
      paramString.append(paramMiniGamePkg.appId);
      paramString.append(", appName=");
      paramString.append(paramMiniGamePkg.apkgName);
      paramString.append(" success");
      QMLog.i("GpkgLoadAsyncTask", paramString.toString());
      GpkgLoadAsyncTask.access$102(this.this$0, paramMiniGamePkg);
      GpkgLoadAsyncTask.access$202(this.this$0, null);
      this.this$0.onTaskSucceed();
      return;
    }
    paramInfo = new StringBuilder();
    paramInfo.append("[Gpkg] getGpkgInfoByConfig appid=");
    if (paramMiniGamePkg != null) {
      paramMiniGamePkg = paramMiniGamePkg.appId;
    } else {
      paramMiniGamePkg = "unknown appid";
    }
    paramInfo.append(paramMiniGamePkg);
    paramInfo.append(", fail ");
    paramInfo.append(paramString);
    QMLog.e("GpkgLoadAsyncTask", paramInfo.toString());
    GpkgLoadAsyncTask.access$102(this.this$0, null);
    GpkgLoadAsyncTask.access$202(this.this$0, null);
    this.this$0.onTaskFailed(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.task.GpkgLoadAsyncTask.1
 * JD-Core Version:    0.7.0.1
 */