package com.tencent.qqmini.sdk.launcher;

import bdit;
import bdlv;
import bdnw;
import bdyl;
import org.json.JSONObject;

public class MiniAppInfoLoadingFragment$1$2
  implements Runnable
{
  public MiniAppInfoLoadingFragment$1$2(bdlv parambdlv, JSONObject paramJSONObject) {}
  
  public void run()
  {
    String str = "";
    long l = 0L;
    if (this.jdField_a_of_type_OrgJsonJSONObject != null)
    {
      l = this.jdField_a_of_type_OrgJsonJSONObject.optLong("retCode");
      str = this.jdField_a_of_type_OrgJsonJSONObject.optString("errMsg");
    }
    bdnw.d("MiniAppInfoLoadingFragment", "getAppInfoById failed. retCode=" + l + " errMsg=" + str);
    if (bdyl.a())
    {
      bdit.a(this.jdField_a_of_type_Bdlv.a.getActivity(), 1, "" + str + l, 1).a();
      return;
    }
    bdit.a(this.jdField_a_of_type_Bdlv.a.getActivity(), 1, "" + str, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment.1.2
 * JD-Core Version:    0.7.0.1
 */