package com.tencent.qqmini.sdk.ui;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class MiniAppInfoLoadingFragment$1$2
  implements Runnable
{
  MiniAppInfoLoadingFragment$1$2(MiniAppInfoLoadingFragment.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    String str1 = "";
    long l = 0L;
    if (this.val$ret != null)
    {
      l = this.val$ret.optLong("retCode");
      str1 = this.val$ret.optString("errMsg");
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = "网络请求错误，无法加载";
    }
    QMLog.e("MiniAppInfoLoadingFragment", "getAppInfoById failed. retCode=" + l + " errMsg=" + str2);
    MiniAppInfoLoadingFragment.access$200(this.this$1.this$0, str2, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.1.2
 * JD-Core Version:    0.7.0.1
 */