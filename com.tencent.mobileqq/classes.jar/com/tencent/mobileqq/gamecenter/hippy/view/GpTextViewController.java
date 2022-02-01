package com.tencent.mobileqq.gamecenter.hippy.view;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.gamecenter.view.TextHeaderView;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

@HippyController(name="gpTextView")
public class GpTextViewController
  extends HippyViewController<TextHeaderView>
{
  public static final String CLASS_NAME = "gpTextView";
  private static final String TAG = "GpTextViewController";
  private int mHippyEngineId = -2147483648;
  public TextHeaderView textHeaderView;
  
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
    return new TextHeaderView(paramContext);
  }
  
  public void dispatchFunction(TextHeaderView paramTextHeaderView, String paramString, HippyArray paramHippyArray)
  {
    if ("init".equals(paramString))
    {
      paramTextHeaderView.a(paramHippyArray);
      paramTextHeaderView.d();
    }
    else if ("destory".equals(paramString))
    {
      paramTextHeaderView.c();
    }
    else if ("resume".equals(paramString))
    {
      paramTextHeaderView.a();
    }
    super.dispatchFunction(paramTextHeaderView, paramString, paramHippyArray);
  }
  
  public void onAfterUpdateProps(TextHeaderView paramTextHeaderView)
  {
    paramTextHeaderView.e();
  }
  
  public void onViewDestroy(TextHeaderView paramTextHeaderView)
  {
    if (paramTextHeaderView != null) {
      paramTextHeaderView.c();
    }
  }
  
  @HippyControllerProps(defaultType="map", name="src")
  public void setSrc(TextHeaderView paramTextHeaderView, HippyMap paramHippyMap)
  {
    paramTextHeaderView.setSrc(paramHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.view.GpTextViewController
 * JD-Core Version:    0.7.0.1
 */