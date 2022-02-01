package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class MiniAppInfoLoadingFragment$2$2
  implements Runnable
{
  MiniAppInfoLoadingFragment$2$2(MiniAppInfoLoadingFragment.2 param2, JSONObject paramJSONObject) {}
  
  public void run()
  {
    String str = "";
    long l = 0L;
    if (this.val$ret != null)
    {
      l = this.val$ret.optLong("retCode");
      str = this.val$ret.optString("errMsg");
    }
    QMLog.e("MiniAppInfoLoadingFragment", "GetAppInfoByLink failed. retCode=" + l + " errMsg=" + str);
    MiniAppInfoLoadingFragment.access$200(this.this$1.this$0, str, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.2.2
 * JD-Core Version:    0.7.0.1
 */