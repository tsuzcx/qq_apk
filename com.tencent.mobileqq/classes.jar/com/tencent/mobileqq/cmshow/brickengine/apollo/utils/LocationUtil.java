package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class LocationUtil
{
  public static void a(long paramLong, int paramInt, String paramString)
  {
    Object localObject = CmGameUtil.a(Thread.currentThread().getId());
    int j = 1;
    int i = j;
    if (localObject != null)
    {
      localObject = ((CmGameLauncher)localObject).a();
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((CmGameInitParams)localObject).accessTokenRet == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]BitmapUtil", 2, "getlocation, NOT need login.");
          }
          i = 0;
          localObject = ApolloRender.getCurrentRenderView();
          if (localObject == null) {
            return;
          }
          Activity localActivity = (Activity)((View)localObject).getContext();
          IDoraemonService localIDoraemonService = (IDoraemonService)QRoute.api(IDoraemonService.class);
          localIDoraemonService.prepare();
          a((View)localObject, localIDoraemonService.createAPIManager(localActivity, 5, paramString), paramLong, paramInt, paramString);
        }
      }
    }
    if (i != 0) {
      b(paramLong, paramInt, paramString);
    }
  }
  
  public static void a(View paramView, DoraemonAPIManager paramDoraemonAPIManager, long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, String paramString1, int paramInt, String paramString2)
  {
    paramDoraemonAPIManager.b();
    ((ApolloSurfaceView)paramView).getRender().getSavaWrapper().locationCallBack(paramLong, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramString1, paramInt, paramString2);
  }
  
  public static void a(View paramView, DoraemonAPIManager paramDoraemonAPIManager, long paramLong, int paramInt, String paramString)
  {
    paramDoraemonAPIManager.a("getLocation", null, new LocationUtil.2(paramView, paramDoraemonAPIManager, paramLong, paramInt));
  }
  
  public static void b(long paramLong, int paramInt, String paramString)
  {
    View localView = ApolloRender.getCurrentRenderView();
    if (localView == null) {
      return;
    }
    Object localObject = (Activity)localView.getContext();
    ((IDoraemonService)QRoute.api(IDoraemonService.class)).prepare();
    localObject = ((IDoraemonService)QRoute.api(IDoraemonService.class)).createAPIManager((Activity)localObject, 5, paramString);
    ((DoraemonAPIManager)localObject).a("login", null, new LocationUtil.3(localView, (DoraemonAPIManager)localObject, paramLong, paramInt, paramString));
  }
  
  private static void b(View paramView, DoraemonAPIManager paramDoraemonAPIManager, long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    paramDoraemonAPIManager.a("getCity", null, new LocationUtil.1(paramView, paramDoraemonAPIManager, paramLong, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.LocationUtil
 * JD-Core Version:    0.7.0.1
 */