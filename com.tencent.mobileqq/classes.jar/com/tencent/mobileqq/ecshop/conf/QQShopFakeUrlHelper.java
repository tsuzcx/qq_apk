package com.tencent.mobileqq.ecshop.conf;

import android.net.Uri;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class QQShopFakeUrlHelper
{
  public static String a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    JSONObject localJSONObject = a();
    if (localJSONObject == null) {
      return "";
    }
    paramString = localJSONObject.optString(paramString);
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    try
    {
      boolean bool = "qqshop".equals(Uri.parse(paramString).getScheme());
      if (!bool) {
        return "";
      }
      return paramString;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQShopFakeUrlHelper", 1, localThrowable, new Object[0]);
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = a();
    if (localJSONObject == null) {
      return "";
    }
    try
    {
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        Uri localUri = Uri.parse(localJSONObject.optString((String)localIterator.next()));
        if ((localUri != null) && (localUri.getHost() != null) && (localUri.getHost().equals(paramString1)))
        {
          paramString1 = localUri.getQueryParameter(paramString2);
          return paramString1;
        }
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("QQShopFakeUrlHelper", 1, paramString1, new Object[0]);
    }
    return "";
  }
  
  private static JSONObject a()
  {
    IQWalletConfigService localIQWalletConfigService = (IQWalletConfigService)AppUtils.a().getRuntimeService(IQWalletConfigService.class, "");
    if ((localIQWalletConfigService != null) && (localIQWalletConfigService.getConfigObj("qqshop") != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" getQQShopConfig: ");
        localStringBuilder.append(localIQWalletConfigService.getConfigObj("qqshop"));
        QLog.i("QQShopFakeUrlHelper", 2, localStringBuilder.toString());
      }
      return localIQWalletConfigService.getConfigObj("qqshop");
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    paramString = a(paramString);
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = Uri.parse(paramString).getHost();
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.e("QQShopFakeUrlHelper", 1, paramString, new Object[0]);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.conf.QQShopFakeUrlHelper
 * JD-Core Version:    0.7.0.1
 */