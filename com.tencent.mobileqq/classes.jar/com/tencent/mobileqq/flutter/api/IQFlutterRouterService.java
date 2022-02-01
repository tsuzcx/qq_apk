package com.tencent.mobileqq.flutter.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.flutter.router.PageRouter;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.Map;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQFlutterRouterService
  extends IRuntimeService
{
  public abstract void openPage(Activity paramActivity, PageRouter paramPageRouter, int paramInt);
  
  public abstract void openPage(Activity paramActivity, String paramString1, String paramString2, Map<String, Object> paramMap);
  
  public abstract void openPageByMainProcess(Context paramContext, PageRouter paramPageRouter, Bundle paramBundle);
  
  public abstract void openPageForQCircle(Context paramContext, PageRouter paramPageRouter, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.api.IQFlutterRouterService
 * JD-Core Version:    0.7.0.1
 */