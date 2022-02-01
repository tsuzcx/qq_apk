package com.tencent.mobileqq.flutter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.flutter.api.IQFlutterRouterService;
import com.tencent.mobileqq.flutter.router.PageRouter;
import com.tencent.mobileqq.flutter.router.QFlutterPageRouter;
import java.util.Map;
import mqq.app.AppRuntime;

public class QFlutterRouterServiceImpl
  implements IQFlutterRouterService
{
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy() {}
  
  public void openPage(Activity paramActivity, PageRouter paramPageRouter, int paramInt)
  {
    QFlutterPageRouter.a(paramActivity, paramPageRouter, paramInt);
  }
  
  public void openPage(Activity paramActivity, String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    QFlutterPageRouter.a(paramActivity, paramString1, paramString2, paramMap);
  }
  
  public void openPageByMainProcess(Context paramContext, PageRouter paramPageRouter, Bundle paramBundle)
  {
    QFlutterPageRouter.b(paramContext, paramPageRouter, paramBundle);
  }
  
  public void openPageForQCircle(Context paramContext, PageRouter paramPageRouter, Bundle paramBundle)
  {
    QFlutterPageRouter.a(paramContext, paramPageRouter, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.api.impl.QFlutterRouterServiceImpl
 * JD-Core Version:    0.7.0.1
 */