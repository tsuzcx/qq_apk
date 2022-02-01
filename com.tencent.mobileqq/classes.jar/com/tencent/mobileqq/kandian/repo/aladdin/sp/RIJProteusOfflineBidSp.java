package com.tencent.mobileqq.kandian.repo.aladdin.sp;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.pts.ProteusReportUtil;

public class RIJProteusOfflineBidSp
{
  public static String a(String paramString)
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), true, true);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(paramString, "0");
    }
    return "0";
  }
  
  public static void a(String paramString1, String paramString2)
  {
    ProteusReportUtil.a(1, paramString2);
    Object localObject = RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), true, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp
 * JD-Core Version:    0.7.0.1
 */