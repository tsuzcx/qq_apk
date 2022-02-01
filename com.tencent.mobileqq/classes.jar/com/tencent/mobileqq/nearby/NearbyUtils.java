package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.widget.api.INearbyUtilsDelegate;
import com.tencent.mobileqq.qroute.QRoute;

public final class NearbyUtils
{
  private static INearbyUtilsDelegate a = (INearbyUtilsDelegate)QRoute.api(INearbyUtilsDelegate.class);
  
  public static String a(String paramString)
  {
    return a.filterBlankSpace(paramString);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    a.log(paramInt, paramString1, paramString2, paramVarArgs);
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    a.startBindPhonePageForResult(paramActivity, paramInt);
  }
  
  public static void a(EditText paramEditText, int paramInt)
  {
    a.truncateEditText(paramEditText, paramInt);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    a.requestSig(paramAppInterface, paramString, paramInt);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    a.reportNearbySafetyCheck(paramAppInterface, paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a.printLog(paramString1, paramString2, paramVarArgs);
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    a.printColorLevelLog(paramString, paramVarArgs);
  }
  
  public static boolean a()
  {
    return a.isDevelopLevel();
  }
  
  public static boolean a(int paramInt)
  {
    return a.isSigError(paramInt);
  }
  
  public static boolean a(Context paramContext)
  {
    return a.isNetworkConnected(paramContext);
  }
  
  public static String b(int paramInt)
  {
    return a.convertFrom4Report(paramInt);
  }
  
  public static void b(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    a.reportHomeEvent(paramAppInterface, paramString, paramInt);
  }
  
  public static boolean b()
  {
    return a.isColorLevel();
  }
  
  public static boolean c()
  {
    return a.isNearbyModule();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyUtils
 * JD-Core Version:    0.7.0.1
 */