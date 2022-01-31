package com.tencent.qqmini.sdk.launcher;

import android.text.TextUtils;
import bgqq;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class MiniAppInfoLoadingFragment$2$1
  implements Runnable
{
  public MiniAppInfoLoadingFragment$2$1(bgqq parambgqq, JSONObject paramJSONObject) {}
  
  public void run()
  {
    long l = this.jdField_a_of_type_OrgJsonJSONObject.optLong("retCode");
    String str2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("errMsg");
    QMLog.e("MiniAppInfoLoadingFragment", "GetAppInfoByLink failed. retCode=" + l + " errMsg=" + str2);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "网络请求错误，无法加载";
    }
    MiniAppInfoLoadingFragment.a(this.jdField_a_of_type_Bgqq.a, str1, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment.2.1
 * JD-Core Version:    0.7.0.1
 */