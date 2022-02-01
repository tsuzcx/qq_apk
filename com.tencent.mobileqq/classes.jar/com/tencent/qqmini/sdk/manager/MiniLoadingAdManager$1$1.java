package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;

class MiniLoadingAdManager$1$1
  implements AdProxy.ILoadingAdListener
{
  MiniLoadingAdManager$1$1(MiniLoadingAdManager.1 param1) {}
  
  public void getLoadingAdLayoutReady() {}
  
  public void onAdClick() {}
  
  public void onAdDismiss(boolean paramBoolean) {}
  
  public void onAdShow(View paramView) {}
  
  public void onDownloadAdEnd(String paramString1, long paramLong, String paramString2) {}
  
  public void onPreloadAdReceive(int paramInt) {}
  
  public void onSelectAdProcessDone(String paramString, long paramLong)
  {
    boolean bool = false;
    QMLog.d("MiniLoadingAdManager", "选单接口 onSelectAdProcessDone adJson：" + paramString + " aid：" + paramLong);
    if (!TextUtils.isEmpty(paramString))
    {
      if (!MiniLoadingAdManager.access$200().containsKey(Long.valueOf(paramLong))) {
        bool = true;
      }
      this.this$1.val$onChooseAdEndListener.onChooseAdEnd(paramString, paramLong, bool);
      return;
    }
    this.this$1.val$onChooseAdEndListener.onChooseAdEnd(null, -1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.1.1
 * JD-Core Version:    0.7.0.1
 */