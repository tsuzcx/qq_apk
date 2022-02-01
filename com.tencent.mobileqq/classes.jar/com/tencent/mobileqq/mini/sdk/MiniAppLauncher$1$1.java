package com.tencent.mobileqq.mini.sdk;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONObject;

class MiniAppLauncher$1$1
  implements Runnable
{
  MiniAppLauncher$1$1(MiniAppLauncher.1 param1, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if (this.val$ret != null)
    {
      String str = this.val$ret.optString("errMsg");
      QQToast.a(BaseApplicationImpl.getContext(), 1, str, 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131694387, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppLauncher.1.1
 * JD-Core Version:    0.7.0.1
 */