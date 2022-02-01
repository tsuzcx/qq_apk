package com.tencent.qqmini.sdk.ui;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppInfoLoadingFragment$4$1
  implements Runnable
{
  MiniAppInfoLoadingFragment$4$1(MiniAppInfoLoadingFragment.4 param4, long paramLong, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("getAppInfoById failed. retCode=").append(this.val$retCode).append(" errMsg=");
    if (TextUtils.isEmpty(this.val$errMsg)) {}
    for (String str = "网络请求错误，无法加载";; str = this.val$errMsg)
    {
      QMLog.e("MiniAppInfoLoadingFragment", str);
      MiniAppInfoLoadingFragment.access$300(this.this$1.this$0, this.val$errMsg, this.val$retCode);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.4.1
 * JD-Core Version:    0.7.0.1
 */