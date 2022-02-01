package com.tencent.qqmini.sdk.ui;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppInfoLoadingFragment$3
  implements Runnable
{
  MiniAppInfoLoadingFragment$3(MiniAppInfoLoadingFragment paramMiniAppInfoLoadingFragment, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getAppInfoById failed. retCode=");
    ((StringBuilder)localObject).append(this.val$retCode);
    ((StringBuilder)localObject).append(" errMsg=");
    boolean bool = TextUtils.isEmpty(this.val$errMsg);
    String str2 = "网络请求错误，无法加载";
    String str1;
    if (bool) {
      str1 = "网络请求错误，无法加载";
    } else {
      str1 = this.val$errMsg;
    }
    ((StringBuilder)localObject).append(str1);
    QMLog.e("MiniAppInfoLoadingFragment", ((StringBuilder)localObject).toString());
    localObject = this.this$0;
    if (TextUtils.isEmpty(this.val$errMsg)) {
      str1 = str2;
    } else {
      str1 = this.val$errMsg;
    }
    MiniAppInfoLoadingFragment.access$300((MiniAppInfoLoadingFragment)localObject, str1, this.val$retCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.3
 * JD-Core Version:    0.7.0.1
 */