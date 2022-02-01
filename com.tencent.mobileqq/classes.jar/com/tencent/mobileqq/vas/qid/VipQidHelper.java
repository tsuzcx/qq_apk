package com.tencent.mobileqq.vas.qid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class VipQidHelper
{
  public static String a = "VipQidHelper";
  
  public static void a(Activity paramActivity, ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(QVipQidProcessor.c().a);
    if (paramProfileCardInfo != null) {
      str = "&from=icon";
    } else {
      str = "&from=set";
    }
    ((StringBuilder)localObject).append(str);
    String str = ((StringBuilder)localObject).toString();
    localObject = VasUtil.a().getQQBrowserIntent();
    ((Intent)localObject).putExtra("uin", VasUtil.a());
    ((Intent)localObject).putExtra("url", str);
    ((Intent)localObject).putExtra("hide_more_button", true);
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    if (paramActivity != null) {
      paramActivity.startActivity((Intent)localObject);
    }
    a("0X800B60D", paramProfileCardInfo);
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (paramAppInterface == null) {
      return;
    }
    paramAppInterface.getApp().getSharedPreferences("qq_vip_configs", 4).edit().putBoolean("qid_keyword_open", paramBoolean).apply();
  }
  
  public static void a(String paramString, int paramInt)
  {
    ReportController.b(VasUtil.a(), "dc00898", "", "", "", paramString, 0, 0, String.valueOf(paramInt), "", "", "");
    if (QLog.isColorLevel())
    {
      paramString = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QID_LOG,reportQIdEvent,entry:");
      localStringBuilder.append(paramInt);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
  }
  
  public static void a(String paramString, ProfileCardInfo paramProfileCardInfo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return false;
    }
    return paramAppInterface.getApp().getSharedPreferences("qq_vip_configs", 4).getBoolean("qid_keyword_open", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qid.VipQidHelper
 * JD-Core Version:    0.7.0.1
 */