package com.tencent.qqmini.sdk.manager;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

class MiniLoadingAdManager$4
  implements AdProxy.ILoadingAdListener
{
  MiniLoadingAdManager$4(MiniLoadingAdManager paramMiniLoadingAdManager, MiniAppInfo paramMiniAppInfo, MiniLoadingAdManager.OnDismissListener paramOnDismissListener, Activity paramActivity) {}
  
  public void getLoadingAdLayoutReady() {}
  
  public void onAdClick()
  {
    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppInfo), null, "ad", "ad_loading", "click", null);
  }
  
  public void onAdDismiss(boolean paramBoolean)
  {
    if (paramBoolean) {
      SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppInfo), null, "ad", "ad_loading", "skip", null);
    }
    if (this.val$onDismissListener != null) {
      this.val$onDismissListener.onDismiss();
    }
  }
  
  public void onAdShow(View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)this.val$activity.getWindow().getDecorView();
    if (localViewGroup == null)
    {
      QMLog.e("MiniLoadingAdManager", "onAdShow, root view is null");
      return;
    }
    String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
    if ((localViewGroup instanceof FrameLayout)) {
      localViewGroup.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    }
    for (;;)
    {
      MiniLoadingAdManager.access$300(this.val$miniAppInfo.appId, str, 0);
      SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.val$miniAppInfo), null, "ad", "ad_loading", "expo_success", null);
      return;
      if ((localViewGroup instanceof RelativeLayout)) {
        localViewGroup.addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
      }
    }
  }
  
  public void onDownloadAdEnd(String paramString1, long paramLong, String paramString2) {}
  
  public void onPreloadAdReceive(int paramInt) {}
  
  public void onSelectAdProcessDone(String paramString, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.4
 * JD-Core Version:    0.7.0.1
 */