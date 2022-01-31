package com.tencent.mobileqq.mini.appbrand.ui;

import bbmy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PreloadingFragment$6$1
  implements Runnable
{
  PreloadingFragment$6$1(PreloadingFragment.6 param6, JSONObject paramJSONObject) {}
  
  public void run()
  {
    long l = this.val$ret.optLong("retCode");
    String str = this.val$ret.optString("errMsg");
    QLog.e("PreloadingFragment", 1, "GetAppInfoByLink failed. retCode=" + l + " errMsg=" + str);
    try
    {
      bbmy.a(BaseApplicationImpl.getContext(), 1, "" + str, 1).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PreloadingFragment", 1, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.6.1
 * JD-Core Version:    0.7.0.1
 */