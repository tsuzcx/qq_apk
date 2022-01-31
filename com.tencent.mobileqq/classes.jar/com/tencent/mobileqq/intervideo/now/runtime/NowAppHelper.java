package com.tencent.mobileqq.intervideo.now.runtime;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.now.NowProxyParamParser;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class NowAppHelper
{
  public static String a(String paramString1, String paramString2, Bundle paramBundle)
  {
    String str2 = NowProxyParamParser.b(paramBundle);
    int i;
    String str1;
    if (NowProxyParamParser.a(paramBundle))
    {
      i = 1;
      str1 = NowProxyParamParser.e(paramBundle);
      QLog.i("NowAppHelper", 1, "已安装独立版，开始跳转独立版,is_record = is_record enter_record_if_finish = " + i + " nowapp_param = " + str1);
      if (!str2.equals("1")) {
        break label132;
      }
      paramString1 = "tnow://openpage/record?" + str1;
    }
    for (;;)
    {
      paramString2 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      if (paramBundle != null) {
        paramString2.putExtras(paramBundle);
      }
      paramString2.setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(paramString2);
      return paramString1;
      i = 0;
      break;
      label132:
      str2 = NowProxyParamParser.a(paramBundle);
      String str3 = NowProxyParamParser.c(paramBundle);
      if (TextUtils.isEmpty(str2))
      {
        paramString1 = "tnow://openpage/anchor?roomid=" + paramString2 + "&fromid=" + paramString1 + "&startsrc=" + str3;
      }
      else
      {
        paramString2 = "tnow://openpage/enterroom?roomid=" + paramString2 + "&roomtype=" + str2 + "&fromid=" + paramString1 + "&startsrc=" + str3 + "&enter_record_if_finish=" + i;
        paramString1 = paramString2;
        if (TextUtils.isEmpty(str1)) {
          paramString1 = paramString2 + "&" + str1;
        }
      }
    }
  }
  
  public static boolean a()
  {
    return PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.runtime.NowAppHelper
 * JD-Core Version:    0.7.0.1
 */