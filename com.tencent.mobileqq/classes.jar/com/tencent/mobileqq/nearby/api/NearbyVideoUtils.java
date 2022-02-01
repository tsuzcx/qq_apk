package com.tencent.mobileqq.nearby.api;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

public class NearbyVideoUtils
{
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt)
  {
    ((INearbyVideoUtilsDelegate)QRoute.api(INearbyVideoUtilsDelegate.class)).showPtvPanel(paramActivity, paramAppInterface, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    ((INearbyVideoUtilsDelegate)QRoute.api(INearbyVideoUtilsDelegate.class)).startPlayerActivity(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((INearbyVideoUtilsDelegate)QRoute.api(INearbyVideoUtilsDelegate.class)).uploadThumbPhoto(paramQQAppInterface, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, TransProcessorHandler paramTransProcessorHandler)
  {
    ((INearbyVideoUtilsDelegate)QRoute.api(INearbyVideoUtilsDelegate.class)).upload640Video(paramQQAppInterface, paramString, paramTransProcessorHandler);
  }
  
  public static void a(String paramString)
  {
    ((INearbyVideoUtilsDelegate)QRoute.api(INearbyVideoUtilsDelegate.class)).setAuthVideoConfig(paramString);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    ((INearbyVideoUtilsDelegate)QRoute.api(INearbyVideoUtilsDelegate.class)).report(paramString1, paramString2, paramInt1, paramInt2, paramVarArgs);
  }
  
  public static void a(String paramString, String... paramVarArgs)
  {
    ((INearbyVideoUtilsDelegate)QRoute.api(INearbyVideoUtilsDelegate.class)).report(paramString, paramVarArgs);
  }
  
  public static boolean a()
  {
    return ((INearbyVideoUtilsDelegate)QRoute.api(INearbyVideoUtilsDelegate.class)).isAuthVideoEnable();
  }
  
  public static boolean a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    return ((INearbyVideoUtilsDelegate)QRoute.api(INearbyVideoUtilsDelegate.class)).showTakeAuthVideoGuideDialog(paramActivity, paramQQAppInterface);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return ((INearbyVideoUtilsDelegate)QRoute.api(INearbyVideoUtilsDelegate.class)).isNeedShowGuideDialog(paramQQAppInterface);
  }
  
  public static String b(String paramString)
  {
    return ((INearbyVideoUtilsDelegate)QRoute.api(INearbyVideoUtilsDelegate.class)).getVideoThumb(paramString);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    ((INearbyVideoUtilsDelegate)QRoute.api(INearbyVideoUtilsDelegate.class)).disableShowGuideDialog(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyVideoUtils
 * JD-Core Version:    0.7.0.1
 */