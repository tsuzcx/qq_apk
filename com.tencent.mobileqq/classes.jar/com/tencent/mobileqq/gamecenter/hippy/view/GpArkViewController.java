package com.tencent.mobileqq.gamecenter.hippy.view;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
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
  private static final String TAG = "GpArkViewController";
  private int mHippyEngineId = -2147483648;
  
  public View createView(HippyRootView paramHippyRootView, int paramInt, HippyEngineContext paramHippyEngineContext, String paramString, HippyMap paramHippyMap)
  {
    if (paramHippyEngineContext != null) {
      this.mHippyEngineId = paramHippyEngineContext.getEngineId();
    }
    return super.createView(paramHippyRootView, paramInt, paramHippyEngineContext, paramString, paramHippyMap);
  }
  
  public View createViewImpl(Context paramContext)
  {
    return null;
  }
  
  public View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    paramContext = new HippyArkView(paramContext);
    paramContext.init(QQGameHelper.a(paramHippyMap));
    return paramContext;
  }
  
  public void dispatchFunction(HippyArkView paramHippyArkView, String paramString, HippyArray paramHippyArray)
  {
    try
    {
      if ("init".equals(paramString))
      {
        paramHippyArkView.init(paramHippyArray);
        paramHippyArkView.postDraw();
      }
      for (;;)
      {
        super.dispatchFunction(paramHippyArkView, paramString, paramHippyArray);
        return;
        if (!"destory".equals(paramString)) {
          break;
        }
        paramHippyArkView.destory();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        continue;
        if ("resume".equals(paramString)) {
          paramHippyArkView.resume();
        } else if ("pause".equals(paramString)) {
          paramHippyArkView.pause();
        }
      }
    }
  }
  
  public void onAfterUpdateProps(HippyArkView paramHippyArkView)
  {
    paramHippyArkView.onAfterUpdateProps();
  }
  
  public void onViewDestroy(HippyArkView paramHippyArkView)
  {
    if (paramHippyArkView != null) {
      paramHippyArkView.destory();
    }
  }
  
  @HippyControllerProps(defaultType="map", name="src")
  public void setSrc(HippyArkView paramHippyArkView, HippyMap paramHippyMap)
  {
    paramHippyArkView.setSrc(paramHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.view.GpArkViewController
 * JD-Core Version:    0.7.0.1
 */