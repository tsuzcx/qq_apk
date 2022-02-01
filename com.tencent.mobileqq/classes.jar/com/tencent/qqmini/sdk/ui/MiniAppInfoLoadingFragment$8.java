package com.tencent.qqmini.sdk.ui;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppInfoLoadingFragment$8
  implements Runnable
{
  MiniAppInfoLoadingFragment$8(MiniAppInfoLoadingFragment paramMiniAppInfoLoadingFragment, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject = new StringBuilder().append("getAppInfoByLink failed. retCode=").append(this.val$retCode).append(" errMsg=");
    if (TextUtils.isEmpty(this.val$errMsg))
    {
      str = "网络请求错误，无法加载";
      QMLog.e("MiniAppInfoLoadingFragment", str);
      localObject = this.this$0;
      if (!TextUtils.isEmpty(this.val$errMsg)) {
        break label87;
      }
    }
    label87:
    for (String str = "网络请求错误，无法加载";; str = this.val$errMsg)
    {
      MiniAppInfoLoadingFragment.access$300((MiniAppInfoLoadingFragment)localObject, str, this.val$retCode);
      return;
      str = this.val$errMsg;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.8
 * JD-Core Version:    0.7.0.1
 */