package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import com.tencent.smtt.sdk.QbSdk;

class AppStateManager$3
  implements Runnable
{
  AppStateManager$3(AppStateManager paramAppStateManager, int paramInt, BaseRuntime paramBaseRuntime, Activity paramActivity, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (AppStateManager.access$300(this.this$0, l, this.val$type, this.val$baseRuntime)) {
      return;
    }
    int i = QbSdk.getTbsVersion(this.val$activity);
    int j = QbSdk.getTmpDirTbsVersion(this.val$activity);
    if ((WnsConfig.getConfig("qqminiapp", "mini_app_enable_show_clean_check_x5", 1) > 0) && (i == 0) && (j == 0))
    {
      QMLog.e("minisdk-start_RuntimeState", "whitescreen without x5, start x5 guide");
      try
      {
        AppStateManager.access$402(true);
        BaseRuntime localBaseRuntime = AppStateManager.access$000(this.this$0).getRuntime();
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).startDownloadX5(localBaseRuntime);
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("minisdk-start_RuntimeState", "start X5 guide exception.", localThrowable);
        return;
      }
    }
    int k = this.val$type;
    if (k == 1) {
      str = "小程序启动碰到了异常.";
    } else if (k == 2) {
      str = "小程序启动可能碰到了问题.";
    } else {
      str = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" \n   tbsVersion=");
    localStringBuilder.append(i);
    localStringBuilder.append(" \n   tmpDirTbsVersion=");
    localStringBuilder.append(j);
    String str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("\n是否需要清理当前小程序缓存，并重新启动小程序？");
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("show Dialig :");
    localStringBuilder.append(str);
    QMLog.e("minisdk-start_RuntimeState", localStringBuilder.toString());
    DialogUtil.createCustomDialog(this.val$activity, 230, "小程序启动", str, R.string.mini_sdk_cancel, R.string.mini_sdk_ok, new AppStateManager.3.1(this), new AppStateManager.3.2(this)).show();
    AppStateManager.access$502(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppStateManager.3
 * JD-Core Version:    0.7.0.1
 */