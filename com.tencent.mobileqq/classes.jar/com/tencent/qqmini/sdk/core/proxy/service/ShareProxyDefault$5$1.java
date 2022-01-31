package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import bemw;
import besl;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import java.util.List;
import java.util.Map;

class ShareProxyDefault$5$1
  implements DownloaderProxy.DownloadListener
{
  ShareProxyDefault$5$1(ShareProxyDefault.5 param5, ProgressDialog paramProgressDialog) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    besl.d("ShareProxy", "shareNetworkPicMessage failed, because of picture downloadFailed");
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    if (paramString != null) {}
    for (paramInt = 1;; paramInt = 0)
    {
      this.val$loadingDialog.dismiss();
      if (paramInt == 0) {
        bemw.a(this.this$1.val$activity, 1, "网络异常，图片分享失败", 1).b(this.this$1.val$activity.getResources().getDimensionPixelSize(2131297229));
      }
      if (paramInt == 0) {
        break;
      }
      this.this$1.val$shareData.a = true;
      this.this$1.val$shareData.b = paramString;
      ShareProxyDefault.access$000(this.this$1.this$0, this.this$1.val$shareData);
      return;
    }
    besl.d("ShareProxy", "shareNetworkPicMessage failed, because of picture downloadFailed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ShareProxyDefault.5.1
 * JD-Core Version:    0.7.0.1
 */