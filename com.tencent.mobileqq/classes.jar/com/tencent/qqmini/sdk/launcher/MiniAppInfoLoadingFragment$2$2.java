package com.tencent.qqmini.sdk.launcher;

import bgux;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class MiniAppInfoLoadingFragment$2$2
  implements Runnable
{
  public MiniAppInfoLoadingFragment$2$2(bgux parambgux, JSONObject paramJSONObject) {}
  
  public void run()
  {
    String str = "";
    long l = 0L;
    if (this.jdField_a_of_type_OrgJsonJSONObject != null)
    {
      l = this.jdField_a_of_type_OrgJsonJSONObject.optLong("retCode");
      str = this.jdField_a_of_type_OrgJsonJSONObject.optString("errMsg");
    }
    QMLog.e("MiniAppInfoLoadingFragment", "GetAppInfoByLink failed. retCode=" + l + " errMsg=" + str);
    MiniAppInfoLoadingFragment.a(this.jdField_a_of_type_Bgux.a, str, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment.2.2
 * JD-Core Version:    0.7.0.1
 */