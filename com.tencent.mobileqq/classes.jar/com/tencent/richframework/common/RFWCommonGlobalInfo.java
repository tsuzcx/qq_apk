package com.tencent.richframework.common;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.richframework.config.RFWCommonConfig;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;

public class RFWCommonGlobalInfo
{
  private static String a = "";
  
  public static String a()
  {
    if (TextUtils.isEmpty(a))
    {
      SharedPreferences localSharedPreferences = RFWCommonConfig.a();
      if (localSharedPreferences != null) {
        a = localSharedPreferences.getString("rfw_common_msf_server_id", "production");
      }
    }
    return a;
  }
  
  public static void a(String paramString)
  {
    a = paramString;
    QCircleHostGlobalInfo.setCurMsfServerId(a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.common.RFWCommonGlobalInfo
 * JD-Core Version:    0.7.0.1
 */