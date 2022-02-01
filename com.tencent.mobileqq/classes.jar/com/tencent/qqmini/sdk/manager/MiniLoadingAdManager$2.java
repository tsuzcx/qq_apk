package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;

class MiniLoadingAdManager$2
  implements AdProxy.ILoadingAdListener
{
  MiniLoadingAdManager$2(MiniLoadingAdManager paramMiniLoadingAdManager, MiniLoadingAdManager.OnChooseAdEndListener paramOnChooseAdEndListener) {}
  
  public void getLoadingAdLayoutReady() {}
  
  public void onAdClick(int paramInt) {}
  
  public void onAdDismiss(boolean paramBoolean) {}
  
  public void onAdShow(View paramView) {}
  
  public void onDownloadAdEnd(String paramString1, long paramLong, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("processSelectAdWithUncachedAd downloadRealTimeAdPic onDownloadAdEnd adJson:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" aid:");
    localStringBuilder.append(paramLong);
    QMLog.d("MiniLoadingAdManager", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString1))
    {
      if (MiniLoadingAdManager.access$300() != null) {
        MiniLoadingAdManager.access$300().put(Long.valueOf(paramLong), paramString2);
      }
      this.val$onChooseAdEndListener.onDownloadAdEnd(paramString1, paramLong);
      return;
    }
    this.val$onChooseAdEndListener.onDownloadAdEnd(null, -1L);
  }
  
  public void onPreloadAdReceive(int paramInt) {}
  
  public void onSelectAdProcessDone(String paramString, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.2
 * JD-Core Version:    0.7.0.1
 */