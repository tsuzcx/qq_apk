package com.tencent.qqmini.sdk.manager;

import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

class MiniLoadingAdManager$3$1
  implements AdProxy.ILoadingAdListener
{
  MiniLoadingAdManager$3$1(MiniLoadingAdManager.3 param3, long paramLong) {}
  
  public void getLoadingAdLayoutReady() {}
  
  public void onAdClick(int paramInt) {}
  
  public void onAdDismiss(boolean paramBoolean) {}
  
  public void onAdShow(View paramView) {}
  
  public void onDownloadAdEnd(String paramString1, long paramLong, String paramString2) {}
  
  public void onPreloadAdReceive(int paramInt)
  {
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("预加载接口 onPreloadAdReceive success：");
    ((StringBuilder)localObject).append(bool);
    QMLog.d("MiniLoadingAdManager", ((StringBuilder)localObject).toString());
    if (bool)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.val$preloadStartTime;
      SDKMiniProgramLpReportDC04239.reportMiniAppEvent(this.this$0.val$miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(this.this$0.val$miniAppInfo), null, "ad", "ad_loading", "preload_success", String.valueOf(l1 - l2));
      MiniLoadingAdManager.access$400(this.this$0.val$miniAppInfo.appId, this.this$0.val$uin, 1);
      MiniLoadingAdManager.access$500(this.this$0.val$miniAppInfo.appId, this.this$0.val$uin);
      return;
    }
    localObject = this.this$0.val$miniAppInfo;
    String str = SDKMiniProgramLpReportDC04239.getAppType(this.this$0.val$miniAppInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    SDKMiniProgramLpReportDC04239.reportMiniAppEvent((MiniAppInfo)localObject, str, null, "ad", "ad_loading", "preload_fail", localStringBuilder.toString());
  }
  
  public void onSelectAdProcessDone(String paramString, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.3.1
 * JD-Core Version:    0.7.0.1
 */