package com.tencent.qqmini.sdk.ui;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppInfoLoadingFragment$5$1
  implements Runnable
{
  MiniAppInfoLoadingFragment$5$1(MiniAppInfoLoadingFragment.5 param5, long paramLong, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAppInfoByLink failed. retCode=");
    localStringBuilder.append(this.val$retCode);
    localStringBuilder.append(" errMsg=");
    String str;
    if (TextUtils.isEmpty(this.val$errMsg)) {
      str = "网络请求错误，无法加载";
    } else {
      str = this.val$errMsg;
    }
    localStringBuilder.append(str);
    QMLog.e("MiniAppInfoLoadingFragment", localStringBuilder.toString());
    MiniAppInfoLoadingFragment.access$300(this.this$1.this$0, this.val$errMsg, this.val$retCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.5.1
 * JD-Core Version:    0.7.0.1
 */