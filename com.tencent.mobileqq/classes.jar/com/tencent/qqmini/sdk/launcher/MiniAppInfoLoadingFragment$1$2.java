package com.tencent.qqmini.sdk.launcher;

import android.text.TextUtils;
import bguw;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class MiniAppInfoLoadingFragment$1$2
  implements Runnable
{
  public MiniAppInfoLoadingFragment$1$2(bguw parambguw, JSONObject paramJSONObject) {}
  
  public void run()
  {
    String str1 = "";
    long l = 0L;
    if (this.jdField_a_of_type_OrgJsonJSONObject != null)
    {
      l = this.jdField_a_of_type_OrgJsonJSONObject.optLong("retCode");
      str1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("errMsg");
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = "网络请求错误，无法加载";
    }
    QMLog.e("MiniAppInfoLoadingFragment", "getAppInfoById failed. retCode=" + l + " errMsg=" + str2);
    MiniAppInfoLoadingFragment.a(this.jdField_a_of_type_Bguw.a, str2, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment.1.2
 * JD-Core Version:    0.7.0.1
 */