package com.tencent.mobileqq.intervideo.lite_now_biz.config;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.intervideo.now.NowProxyParamParser;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;

public class NowAppHelper
{
  private static int a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = Uri.parse(paramBundle.getString("mqqScheme")).getQueryParameter("first");
      if ((!TextUtils.isEmpty(paramBundle)) && (PortalUtils.a(paramBundle))) {
        return Integer.valueOf(paramBundle).intValue();
      }
    }
    return 2;
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    long l = NowProxyParamParser.a(paramBundle);
    Object localObject = NowProxyParamParser.d(paramBundle);
    String str1 = NowProxyParamParser.b(paramBundle);
    int i;
    String str2;
    if (NowProxyParamParser.a(paramBundle))
    {
      i = 1;
      str2 = NowProxyParamParser.e(paramBundle);
      if (!str1.equals("1")) {
        break label137;
      }
      localObject = "tnow://openpage/record?" + str2;
    }
    for (;;)
    {
      QLog.i("NowAppHelper", 1, "开始跳转独立版 nowScheme = " + (String)localObject);
      localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
      if (paramBundle != null) {
        ((Intent)localObject).putExtras(paramBundle);
      }
      ((Intent)localObject).setFlags(268435456);
      paramContext.startActivity((Intent)localObject);
      return;
      i = 0;
      break;
      label137:
      str1 = NowProxyParamParser.a(paramBundle);
      String str3 = NowProxyParamParser.c(paramBundle);
      str1 = "tnow://openpage/enterroom?roomid=" + l + "&roomtype=" + str1 + "&fromid=" + (String)localObject + "&startsrc=" + str3 + "&enter_record_if_finish=" + i;
      localObject = str1;
      if (!TextUtils.isEmpty(str2)) {
        localObject = str1 + "&" + str2;
      }
    }
  }
  
  public static boolean a(Context paramContext, Bundle paramBundle)
  {
    return (a(paramBundle) == 1) && (!"0".equals(PackageUtil.a(paramContext, "com.tencent.now")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.config.NowAppHelper
 * JD-Core Version:    0.7.0.1
 */