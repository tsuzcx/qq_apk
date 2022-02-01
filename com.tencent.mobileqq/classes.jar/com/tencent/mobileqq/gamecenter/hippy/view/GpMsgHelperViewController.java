package com.tencent.mobileqq.gamecenter.hippy.view;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

@HippyController(name="gpMsgHelperView")
public class GpMsgHelperViewController
  extends HippyViewController<GpMsgHelperView>
{
  public static final String CLASS_NAME = "gpMsgHelperView";
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
    return new GpMsgHelperView(paramContext, this.mHippyEngineId);
  }
  
  public void onViewDestroy(GpMsgHelperView paramGpMsgHelperView)
  {
    if (paramGpMsgHelperView != null) {}
    try
    {
      paramGpMsgHelperView.destory();
      return;
    }
    catch (Throwable paramGpMsgHelperView)
    {
      paramGpMsgHelperView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.view.GpMsgHelperViewController
 * JD-Core Version:    0.7.0.1
 */