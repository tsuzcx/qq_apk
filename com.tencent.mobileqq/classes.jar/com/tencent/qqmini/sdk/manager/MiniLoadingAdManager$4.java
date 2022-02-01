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
  
  public void onAdClick(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAdClick, unknown type:");
        ((StringBuilder)localObject).append(paramInt);
        QMLog.e("MiniLoadingAdManager", ((StringBuilder)localObject).toString());
        return;
      }
      localObject = this.val$miniAppInfo;
      SDKMiniProgramLpReportDC04239.reportMiniAppEvent((MiniAppInfo)localObject, SDKMiniProgramLpReportDC04239.getAppType((MiniAppInfo)localObject), null, "ad", "ad_loading", "click_bar", null);
      return;
    }
    Object localObject = this.val$miniAppInfo;
    SDKMiniProgramLpReportDC04239.reportMiniAppEvent((MiniAppInfo)localObject, SDKMiniProgramLpReportDC04239.getAppType((MiniAppInfo)localObject), null, "ad", "ad_loading", "click", null);
  }
  
  public void onAdDismiss(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.val$miniAppInfo;
      SDKMiniProgramLpReportDC04239.reportMiniAppEvent((MiniAppInfo)localObject, SDKMiniProgramLpReportDC04239.getAppType((MiniAppInfo)localObject), null, "ad", "ad_loading", "skip", null);
    }
    Object localObject = this.val$onDismissListener;
    if (localObject != null) {
      ((MiniLoadingAdManager.OnDismissListener)localObject).onDismiss();
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
    } else if ((localViewGroup instanceof RelativeLayout)) {
      localViewGroup.addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
    }
    MiniLoadingAdManager.access$400(this.val$miniAppInfo.appId, str, 0);
    paramView = this.val$miniAppInfo;
    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(paramView, SDKMiniProgramLpReportDC04239.getAppType(paramView), null, "ad", "ad_loading", "expo_success", null);
  }
  
  public void onDownloadAdEnd(String paramString1, long paramLong, String paramString2) {}
  
  public void onPreloadAdReceive(int paramInt) {}
  
  public void onSelectAdProcessDone(String paramString, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.4
 * JD-Core Version:    0.7.0.1
 */