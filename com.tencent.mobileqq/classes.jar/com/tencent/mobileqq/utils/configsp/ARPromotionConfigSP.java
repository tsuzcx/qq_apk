package com.tencent.mobileqq.utils.configsp;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionUtil;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.confighandler.ConfigHandler;
import com.tencent.qphone.base.util.QLog;

public class ARPromotionConfigSP
{
  public static int a(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return ConfigHandler.getConfigVer(paramString, "config", "ver");
    }
    return 0;
  }
  
  public static SharedPreferences a(String paramString)
  {
    return BaseConfigSP.a(PromotionUtil.a, paramString, "config_qq.android.ar_");
  }
  
  public static SharedPreferences a(String paramString1, String paramString2)
  {
    String str = PromotionUtil.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("res_qq.android.ar_");
    localStringBuilder.append(paramString2);
    return BaseConfigSP.a(str, paramString1, localStringBuilder.toString());
  }
  
  public static PromotionConfigInfo a(String paramString1, String paramString2)
  {
    int i = 0;
    for (Object localObject = paramString2;; localObject = paramString2)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2))
        {
          localObject = a(paramString1);
          if (localObject == null) {
            break label139;
          }
          localObject = ((SharedPreferences)localObject).getString("config", null);
          i = 1;
        }
        paramString2 = PromotionUtil.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ConfigInfo.get, step[");
        localStringBuilder.append(i);
        localStringBuilder.append("], configText[");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("]");
        QLog.w(paramString2, 1, localStringBuilder.toString());
        paramString2 = new PromotionConfigInfo();
        paramString2.setUin(paramString1);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramString2.tryParse(PromotionUtil.a, (String)localObject);
        }
        return paramString2;
      }
      finally {}
      label139:
      i = 2;
    }
  }
  
  public static String a(String paramString)
  {
    SharedPreferences localSharedPreferences = b(paramString);
    paramString = null;
    if (localSharedPreferences != null) {
      paramString = localSharedPreferences.getString("config", null);
    }
    return paramString;
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    String str = PromotionUtil.a;
    paramString1 = a(paramString1, paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("md5_");
    paramString2.append(paramInt);
    BusinessCommonConfig.saveMd5(str, paramString1, paramString2.toString(), paramString3);
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(PromotionUtil.a);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    paramString1 = a(paramString1, paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("md5_");
    paramString2.append(paramInt);
    return BusinessCommonConfig.isResReady((String)localObject, paramString1, paramString2.toString(), paramString3, paramString4);
  }
  
  public static int b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return ConfigHandler.getConfigVer(paramString, "config", "ver");
    }
    return 0;
  }
  
  public static SharedPreferences b(String paramString)
  {
    return BaseConfigSP.a(PromotionUtil.a, paramString, "res_qq.android.ar_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.configsp.ARPromotionConfigSP
 * JD-Core Version:    0.7.0.1
 */