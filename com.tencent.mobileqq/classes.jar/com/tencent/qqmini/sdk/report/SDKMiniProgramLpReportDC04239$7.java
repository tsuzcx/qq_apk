package com.tencent.qqmini.sdk.report;

import bdnw;
import bdsx;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import org.json.JSONObject;

public final class SDKMiniProgramLpReportDC04239$7
  implements Runnable
{
  public void run()
  {
    Object localObject;
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion())
    {
      localObject = new StringBuilder().append("gameInnerReport() called with args: ");
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        break label106;
      }
    }
    label106:
    for (String str1 = this.jdField_a_of_type_OrgJsonJSONObject.toString();; str1 = "empty")
    {
      bdnw.a("MiniProgramLpReportDC04239", str1);
      if (this.jdField_a_of_type_OrgJsonJSONObject != null)
      {
        str1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("actiontype");
        localObject = this.jdField_a_of_type_OrgJsonJSONObject.optString("sub_actiontype");
        String str2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("reserves_action");
        bdsx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, "1", null, str1, (String)localObject, str2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.7
 * JD-Core Version:    0.7.0.1
 */