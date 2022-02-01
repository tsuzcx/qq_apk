package com.tencent.mobileqq.mini.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiniAppSecurityUtil
{
  private static final String DEFAULT_SIMPLE_UIN = "0";
  public static final String SAFE_BLOCK_MINIAPP_OPTIMIZATION_TVALUE_HANDLE = "0X800AA17";
  public static final String SAFE_BLOCK_MINIAPP_OPTIMIZATION_TVALUE_QUIT = "0X800AA16";
  public static final String SAFE_BLOCK_MINIAPP_OPTIMIZATION_TVALUE_SHOW = "0X800AA15";
  public static final String TAG = "MiniAppSecurityUtil";
  private static final String kLoginMiniAppForbidToken = "kLoginMiniAppForbidToken";
  private static final String kLoginMiniAppUin = "kLoginMiniAppUin";
  public static final String kMiniAppSecurityUtilSP = "MiniAppSecurityUtil_Shared_Prefs";
  private static final List<String> sMiniAppLoginSecurityList = Arrays.asList(new String[] { "1109048181", "1109907872", "1109664704", "1108149324" });
  
  public static boolean checkMiniAppForLogin(String paramString)
  {
    paramString = getArgumentsFromURL(paramString);
    if (paramString != null)
    {
      paramString = (String)paramString.get("_mappid");
      if ((!TextUtils.isEmpty(paramString)) && (sMiniAppLoginSecurityList.contains(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean doCheckSafeUnblockWithLogin(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (sMiniAppLoginSecurityList.contains(paramString)))
      {
        paramString = getLoginMiniAppUin(BaseApplication.getContext());
        if (!TextUtils.isEmpty(paramString))
        {
          boolean bool = TextUtils.isEmpty(getLoginMiniAppForbidToken(BaseApplication.getContext(), paramString));
          if (!bool) {
            return true;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doCheckSafeUnblockWithLogin error: ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("MiniAppSecurityUtil", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  public static void doClearAfterLoginSuccess(boolean paramBoolean)
  {
    try
    {
      String str = getLoginMiniAppUin(BaseApplication.getContext());
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("doClearAfterLoginSuccess uin: ");
        localStringBuilder.append(getSimpleUin(str));
        QLog.d("MiniAppSecurityUtil", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(str))
      {
        if (paramBoolean)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doClearAfterLoginSuccess, forbid_token: ");
          localStringBuilder.append(getLoginMiniAppForbidToken(BaseApplication.getContext(), str));
          QLog.e("MiniAppSecurityUtil", 1, localStringBuilder.toString());
        }
        removeLoginMiniAppForbidToken(BaseApplication.getContext(), str);
        removeLoginMiniAppUin(BaseApplication.getContext());
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remove LoginMiniAppData error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("MiniAppSecurityUtil", 1, localStringBuilder.toString());
    }
  }
  
  private static Map<String, String> getArguments(String paramString)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
      return localHashMap;
    }
    catch (Exception paramString) {}
    return localHashMap;
  }
  
  public static Map<String, String> getArgumentsFromURL(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.indexOf("?");
      if (-1 != i)
      {
        paramString = getArguments(paramString.substring(i + 1));
        break label32;
      }
    }
    paramString = null;
    label32:
    Object localObject = paramString;
    if (paramString == null) {
      localObject = new HashMap();
    }
    return localObject;
  }
  
  public static String getLoginMiniAppForbidToken(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("MiniAppSecurityUtil_Shared_Prefs", 4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append("kLoginMiniAppForbidToken");
      paramContext = paramContext.getString(localStringBuilder.toString(), "");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getLoginMiniAppForbidToken uin: ");
        localStringBuilder.append(getSimpleUin(paramString));
        QLog.d("MiniAppSecurityUtil", 2, localStringBuilder.toString());
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("getLoginMiniAppForbidToken error: ");
      paramString.append(paramContext.getMessage());
      QLog.e("MiniAppSecurityUtil", 1, paramString.toString());
    }
    return "";
  }
  
  public static String getLoginMiniAppUin(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("MiniAppSecurityUtil_Shared_Prefs", 4).getString("kLoginMiniAppUin", "");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLoginMiniAppUin error: ");
      localStringBuilder.append(paramContext.getMessage());
      QLog.e("MiniAppSecurityUtil", 1, localStringBuilder.toString());
    }
    return "";
  }
  
  private static String getSimpleUin(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return "0";
      }
      paramString = paramString.substring(paramString.length() - 4);
      return paramString;
    }
    catch (Exception paramString) {}
    return "0";
  }
  
  public static void removeLoginMiniAppForbidToken(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("MiniAppSecurityUtil_Shared_Prefs", 4).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append("kLoginMiniAppForbidToken");
      paramContext.remove(localStringBuilder.toString());
      paramContext.commit();
      return;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("removeLoginMiniAppForbidToken error: ");
      paramString.append(paramContext.getMessage());
      QLog.e("MiniAppSecurityUtil", 1, paramString.toString());
    }
  }
  
  public static void removeLoginMiniAppUin(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("MiniAppSecurityUtil_Shared_Prefs", 4).edit();
      paramContext.remove("kLoginMiniAppUin");
      paramContext.commit();
      return;
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeLoginMiniAppUin error: ");
      localStringBuilder.append(paramContext.getMessage());
      QLog.e("MiniAppSecurityUtil", 1, localStringBuilder.toString());
    }
  }
  
  public static void updateLoginMiniAppForbidToken(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("MiniAppSecurityUtil_Shared_Prefs", 4).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append("kLoginMiniAppForbidToken");
      paramContext.putString(localStringBuilder.toString(), paramString2);
      paramContext.commit();
      return;
    }
    catch (Exception paramContext)
    {
      paramString1 = new StringBuilder();
      paramString1.append("updateLoginMiniAppForbidToken error: ");
      paramString1.append(paramContext.getMessage());
      QLog.e("MiniAppSecurityUtil", 1, paramString1.toString());
    }
  }
  
  public static void updateLoginMiniAppUin(Context paramContext, String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateLoginMiniAppUin uin: ");
        localStringBuilder.append(getSimpleUin(paramString));
        QLog.d("MiniAppSecurityUtil", 2, localStringBuilder.toString());
      }
      paramContext = paramContext.getSharedPreferences("MiniAppSecurityUtil_Shared_Prefs", 4).edit();
      paramContext.putString("kLoginMiniAppUin", paramString);
      paramContext.commit();
      return;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("updateLoginMiniAppUin error: ");
      paramString.append(paramContext.getMessage());
      QLog.e("MiniAppSecurityUtil", 1, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.MiniAppSecurityUtil
 * JD-Core Version:    0.7.0.1
 */