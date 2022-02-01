package com.tencent.mtt.hippy.views.refresh;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.uimanager.i;
import com.tencent.mtt.hippy.views.list.HippyListView;

@HippyController(isLazyLoad=true, name="PullHeaderView")
public class HippyPullHeaderViewController
  extends HippyViewController<HippyPullHeaderView>
{
  public static final String CLASS_NAME = "PullHeaderView";
  
  public RenderNode createRenderNode(int paramInt, HippyMap paramHippyMap, String paramString, HippyRootView paramHippyRootView, ControllerManager paramControllerManager, boolean paramBoolean)
  {
    return new i(paramInt, paramHippyMap, paramString, paramHippyRootView, paramControllerManager, paramBoolean);
  }
  
  public View createViewImpl(Context paramContext)
  {
    return new HippyPullHeaderView(paramContext);
  }
  
  public void dispatchFunction(HippyPullHeaderView paramHippyPullHeaderView, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramHippyPullHeaderView, paramString, paramHippyArray);
    paramHippyPullHeaderView = paramHippyPullHeaderView.getParentView();
    int i;
    if ((paramHippyPullHeaderView != null) && ((paramHippyPullHeaderView instanceof HippyListView)))
    {
      i = -1;
      switch (paramString.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (paramString.equals("collapsePullHeader"))
        {
          i = 0;
          continue;
          if (paramString.equals("expandPullHeader")) {
            i = 1;
          }
        }
        break;
      }
    }
    ((HippyListView)paramHippyPullHeaderView).onHeaderRefreshFinish();
    return;
    ((HippyListView)paramHippyPullHeaderView).onHeaderRefresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.refresh.HippyPullHeaderViewController
 * JD-Core Version:    0.7.0.1
 */