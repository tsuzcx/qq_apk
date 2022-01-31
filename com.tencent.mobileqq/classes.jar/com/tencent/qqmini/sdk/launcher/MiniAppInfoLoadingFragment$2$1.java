package com.tencent.qqmini.sdk.launcher;

import bdlw;
import bdnw;
import bdyl;
import org.json.JSONObject;

public class MiniAppInfoLoadingFragment$2$1
  implements Runnable
{
  public MiniAppInfoLoadingFragment$2$1(bdlw parambdlw, JSONObject paramJSONObject) {}
  
  public void run()
  {
    long l = this.jdField_a_of_type_OrgJsonJSONObject.optLong("retCode");
    Object localObject = this.jdField_a_of_type_OrgJsonJSONObject.optString("errMsg");
    bdnw.d("MiniAppInfoLoadingFragment", "GetAppInfoByLink failed. retCode=" + l + " errMsg=" + (String)localObject);
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append("").append((String)localObject);
      if (bdyl.a()) {}
      for (localObject = Long.valueOf(l);; localObject = "")
      {
        localObject = localObject;
        MiniAppInfoLoadingFragment.a(this.jdField_a_of_type_Bdlw.a, (String)localObject);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("MiniAppInfoLoadingFragment", "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment.2.1
 * JD-Core Version:    0.7.0.1
 */