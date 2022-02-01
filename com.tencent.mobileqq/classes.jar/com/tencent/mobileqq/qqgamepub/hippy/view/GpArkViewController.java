package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

@HippyController(name="gpArkView")
public class GpArkViewController
  extends HippyViewController<HippyArkView>
{
  public static final String CLASS_NAME = "gpArkView";
  private static final String TAG = "QQGamePub_GpArkViewController";
  private int mHippyEngineId = -2147483648;
  
  public View createView(HippyRootView paramHippyRootView, int paramInt, HippyEngineContext paramHippyEngineContext, String paramString, HippyMap paramHippyMap)
  {
    if (paramHippyEngineContext != null) {
      this.mHippyEngineId = paramHippyEngineContext.getEngineId();
    }
    return super.createView(paramHippyRootView, paramInt, paramHippyEngineContext, paramString, paramHippyMap);
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return null;
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    paramContext = new HippyArkView(paramContext);
    paramContext.a(((IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class)).getMsgInfoByHippyMap(paramHippyMap));
    return paramContext;
  }
  
  public void dispatchFunction(HippyArkView paramHippyArkView, String paramString, HippyArray paramHippyArray)
  {
    try
    {
      if ("init".equals(paramString))
      {
        paramHippyArkView.a(paramHippyArray);
        paramHippyArkView.a();
      }
      else if ("destory".equals(paramString))
      {
        paramHippyArkView.b();
      }
      else if ("resume".equals(paramString))
      {
        paramHippyArkView.c();
      }
      else if ("pause".equals(paramString))
      {
        paramHippyArkView.e();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    super.dispatchFunction(paramHippyArkView, paramString, paramHippyArray);
  }
  
  public void onAfterUpdateProps(HippyArkView paramHippyArkView)
  {
    paramHippyArkView.d();
  }
  
  public void onViewDestroy(HippyArkView paramHippyArkView)
  {
    if (paramHippyArkView != null) {
      paramHippyArkView.b();
    }
  }
  
  @HippyControllerProps(defaultType="map", name="src")
  public void setSrc(HippyArkView paramHippyArkView, HippyMap paramHippyMap)
  {
    paramHippyArkView.setSrc(paramHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.view.GpArkViewController
 * JD-Core Version:    0.7.0.1
 */