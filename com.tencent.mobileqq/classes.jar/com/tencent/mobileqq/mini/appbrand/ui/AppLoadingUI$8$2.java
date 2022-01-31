package com.tencent.mobileqq.mini.appbrand.ui;

import android.app.Activity;
import bcpw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AppLoadingUI$8$2
  implements Runnable
{
  AppLoadingUI$8$2(AppLoadingUI.8 param8, JSONObject paramJSONObject) {}
  
  public void run()
  {
    String str = "";
    long l = 0L;
    if (this.val$ret != null)
    {
      l = this.val$ret.optLong("retCode");
      str = this.val$ret.optString("errMsg");
    }
    QLog.e("miniapp-start_AppLoadingUI", 1, "getAppInfoById failed. retCode=" + l + " errMsg=" + str);
    bcpw.a(BaseApplicationImpl.getContext(), 1, "" + str, 1).a();
    this.this$1.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI.8.2
 * JD-Core Version:    0.7.0.1
 */