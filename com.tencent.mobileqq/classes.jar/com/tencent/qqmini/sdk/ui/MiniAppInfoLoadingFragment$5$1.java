package com.tencent.qqmini.sdk.ui;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppInfoLoadingFragment$5$1
  implements Runnable
{
  MiniAppInfoLoadingFragment$5$1(MiniAppInfoLoadingFragment.5 param5, long paramLong, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("getAppInfoByLink failed. retCode=").append(this.val$retCode).append(" errMsg=");
    if (TextUtils.isEmpty(this.val$errMsg)) {}
    for (String str = "网络请求错误，无法加载";; str = this.val$errMsg)
    {
      QMLog.e("MiniAppInfoLoadingFragment", str);
      MiniAppInfoLoadingFragment.access$300(this.this$1.this$0, this.val$errMsg, this.val$retCode);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.5.1
 * JD-Core Version:    0.7.0.1
 */