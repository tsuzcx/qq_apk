package com.tencent.mobileqq.mini.activity;

import android.app.Activity;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class LoadingFragment$3$2
  implements Runnable
{
  LoadingFragment$3$2(LoadingFragment.3 param3, JSONObject paramJSONObject) {}
  
  public void run()
  {
    String str = "";
    long l = 0L;
    if (this.val$ret != null)
    {
      l = this.val$ret.optLong("retCode");
      str = this.val$ret.optString("errMsg");
    }
    QLog.e("LoadingActivity", 1, "getAppInfoById failed. retCode=" + l + " errMsg=" + str);
    bbmy.a(BaseApplicationImpl.getContext(), 1, "" + str, 1).a();
    this.this$1.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.LoadingFragment.3.2
 * JD-Core Version:    0.7.0.1
 */