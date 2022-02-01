package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PreloadingFragment$7$1
  implements Runnable
{
  PreloadingFragment$7$1(PreloadingFragment.7 param7, JSONObject paramJSONObject) {}
  
  public void run()
  {
    long l = this.val$ret.optLong("retCode");
    String str = this.val$ret.optString("errMsg");
    QLog.e("PreloadingFragment", 1, "GetAppInfoByLink failed. retCode=" + l + " errMsg=" + str);
    try
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, "" + str, 1).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PreloadingFragment", 1, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.7.1
 * JD-Core Version:    0.7.0.1
 */