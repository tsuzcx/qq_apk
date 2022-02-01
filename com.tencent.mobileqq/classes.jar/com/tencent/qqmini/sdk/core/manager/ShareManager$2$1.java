package com.tencent.qqmini.sdk.core.manager;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import com.tencent.qqmini.sdk.R.dimen;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.util.List;
import java.util.Map;

class ShareManager$2$1
  implements DownloaderProxy.DownloadListener
{
  ShareManager$2$1(ShareManager.2 param2, ProgressDialog paramProgressDialog) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    QMLog.e("ShareManager", "shareNetworkPicMessage failed, because of picture downloadFailed");
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    if (paramString != null) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    this.val$loadingDialog.dismiss();
    if (paramInt == 0) {
      MiniToast.makeText(this.this$1.val$activity, 1, "网络异常，图片分享失败", 1).show(this.this$1.val$activity.getResources().getDimensionPixelSize(R.dimen.mini_sdk_title_bar_height));
    }
    if (paramInt != 0)
    {
      this.this$1.val$shareData.isLocalPic = true;
      this.this$1.val$shareData.sharePicPath = paramString;
      ShareManager.access$100(this.this$1.this$0, this.this$1.val$shareData);
      return;
    }
    QMLog.e("ShareManager", "shareNetworkPicMessage failed, because of picture downloadFailed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ShareManager.2.1
 * JD-Core Version:    0.7.0.1
 */