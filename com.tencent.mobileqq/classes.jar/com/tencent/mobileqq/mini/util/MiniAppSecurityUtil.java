package com.tencent.mobileqq.mini.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiniAppSecurityUtil
{
  public static final String SAFE_BLOCK_MINIAPP_OPTIMIZATION_TVALUE_HANDLE = "0X800AA17";
  public static final String SAFE_BLOCK_MINIAPP_OPTIMIZATION_TVALUE_QUIT = "0X800AA16";
  public static final String SAFE_BLOCK_MINIAPP_OPTIMIZATION_TVALUE_SHOW = "0X800AA15";
  public static final String TAG = "MiniAppSecurityUtil";
  private static final String kLoginMiniAppForbidToken = "kLoginMiniAppForbidToken";
  private static final String kLoginMiniAppUin = "kLoginMiniAppUin";
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
        paramString = getLoginMiniAppUin(BaseApplicationImpl.sApplication);
        if (!TextUtils.isEmpty(paramString))
        {
          boolean bool = TextUtils.isEmpty(getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), paramString));
          if (!bool) {
            return true;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.e("MiniAppSecurityUtil", 1, "doCheckSafeUnblockWithLogin error: " + paramString.getMessage());
    }
    return false;
  }
  
  public static void doClearAfterLoginSuccess()
  {
    try
    {
      String str = getLoginMiniAppUin(BaseApplicationImpl.sApplication);
      if (!TextUtils.isEmpty(str))
      {
        removeLoginMiniAppForbidToken(BaseApplicationImpl.sApplication, str);
        removeLoginMiniAppUin(BaseApplicationImpl.sApplication);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniAppSecurityUtil", 1, "remove LoginMiniAppData error: " + localException.getMessage());
    }
  }
  
  private static Map<String, String> getArguments(String paramString)
  {
    int i = 0;
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        paramString = paramString.split("&");
        int j = paramString.length;
        if (i < j)
        {
          String[] arrayOfString = paramString[i].split("=");
          if ((arrayOfString == null) || (arrayOfString.length != 2)) {
            break label69;
          }
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
      }
      catch (Exception paramString) {}
      return localHashMap;
      label69:
      i += 1;
    }
  }
  
  public static Map<String, String> getArgumentsFromURL(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      int i = paramString.indexOf("?");
      localObject1 = localObject2;
      if (-1 != i) {
        localObject1 = getArguments(paramString.substring(i + 1));
      }
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = new HashMap();
    }
    return paramString;
  }
  
  public static String getLoginMiniAppForbidToken(Context paramContext, String paramString)
  {
    try
    {
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "kLoginMiniAppForbidToken", "");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      QLog.e("MiniAppSecurityUtil", 1, "getLoginMiniAppForbidToken error: " + paramContext.getMessage());
    }
    return "";
  }
  
  public static String getLoginMiniAppUin(Context paramContext)
  {
    try
    {
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("kLoginMiniAppUin", "");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      QLog.e("MiniAppSecurityUtil", 1, "getLoginMiniAppUin error: " + paramContext.getMessage());
    }
    return "";
  }
  
  public static void modifyIntentDataWithoutLogin(Intent paramIntent, String paramString)
  {
    if ((paramIntent != null) && (doCheckSafeUnblockWithLogin(paramString)))
    {
      paramIntent.putExtra("isOpenMonitorPanel", false);
      paramIntent.putExtra("debugEnable", false);
      paramIntent.putExtra("showDebug", false);
      paramIntent.putExtra("showMonitor", false);
      paramIntent.putExtra("showShareQQ", false);
      paramIntent.putExtra("showShareQzone", false);
      paramIntent.putExtra("showShareWeChatFriends", false);
      paramIntent.putExtra("showShareWeChatMoment", false);
      paramIntent.putExtra("topType", -11);
      paramIntent.putExtra("showDetail", true);
      paramIntent.putExtra("showSetting", false);
      paramIntent.putExtra("showComplaint", true);
      paramIntent.putExtra("addShortcut", false);
      paramIntent.putExtra("showBackHome", -1);
      paramIntent.putExtra("key_color_note", 0);
      paramIntent.putExtra("isSpecialMiniApp", false);
      paramIntent.putExtra("showKingcardTip", false);
      paramIntent.putExtra("showChatNewsList", false);
      paramIntent.putExtra("showRestartMiniApp", false);
    }
  }
  
  public static void removeLoginMiniAppForbidToken(Context paramContext, String paramString)
  {
    try
    {
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.remove(paramString + "_" + "kLoginMiniAppForbidToken");
      paramContext.commit();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("MiniAppSecurityUtil", 1, "removeLoginMiniAppForbidToken error: " + paramContext.getMessage());
    }
  }
  
  public static void removeLoginMiniAppUin(Context paramContext)
  {
    try
    {
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.remove("kLoginMiniAppUin");
      paramContext.commit();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("MiniAppSecurityUtil", 1, "removeLoginMiniAppUin error: " + paramContext.getMessage());
    }
  }
  
  public static void updateLoginMiniAppForbidToken(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putString(paramString1 + "_" + "kLoginMiniAppForbidToken", paramString2);
      paramContext.commit();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("MiniAppSecurityUtil", 1, "updateLoginMiniAppForbidToken error: " + paramContext.getMessage());
    }
  }
  
  public static void updateLoginMiniAppUin(Context paramContext, String paramString)
  {
    try
    {
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putString("kLoginMiniAppUin", paramString);
      paramContext.commit();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("MiniAppSecurityUtil", 1, "updateLoginMiniAppUin error: " + paramContext.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.MiniAppSecurityUtil
 * JD-Core Version:    0.7.0.1
 */