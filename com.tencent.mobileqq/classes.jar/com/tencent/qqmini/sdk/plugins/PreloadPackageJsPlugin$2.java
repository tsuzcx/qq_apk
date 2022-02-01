package com.tencent.qqmini.sdk.plugins;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class PreloadPackageJsPlugin$2
  extends MiniCmdCallback.Stub
{
  PreloadPackageJsPlugin$2(PreloadPackageJsPlugin paramPreloadPackageJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onCmdResult(boolean paramBoolean, @NonNull Bundle paramBundle)
  {
    if (paramBoolean)
    {
      int i = paramBundle.getInt("retCode");
      paramBundle = paramBundle.getString("errMsg");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("retCode,");
      localStringBuilder.append(i);
      localStringBuilder.append(" , errMsg,");
      localStringBuilder.append(paramBundle);
      paramBundle = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("download pkg msg:");
      localStringBuilder.append(paramBundle);
      QMLog.d("PreloadPackageJsPlugin", localStringBuilder.toString());
      if (i == 0)
      {
        PreloadPackageJsPlugin.a(this.b, this.a, PreloadPackageJsPlugin.PreloadResult.PRELOAD_SUCCESS);
        return;
      }
      PreloadPackageJsPlugin.a(this.b, this.a, PreloadPackageJsPlugin.PreloadResult.GET_GPKG_INFO_FAIL, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PreloadPackageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */