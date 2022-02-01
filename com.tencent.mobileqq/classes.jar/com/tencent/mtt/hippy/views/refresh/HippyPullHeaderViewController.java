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
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerListAdapter;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;
import com.tencent.mtt.hippy.views.hippylist.PullHeaderEventHelper;
import com.tencent.mtt.hippy.views.list.HippyListView;

@HippyController(isLazyLoad=true, name="PullHeaderView")
public class HippyPullHeaderViewController
  extends HippyViewController<HippyPullHeaderView>
{
  public static final String CLASS_NAME = "PullHeaderView";
  public static final String COLLAPSE_PULL_HEADER = "collapsePullHeader";
  public static final String EXPAND_PULL_HEADER = "expandPullHeader";
  
  public RenderNode createRenderNode(int paramInt, HippyMap paramHippyMap, String paramString, HippyRootView paramHippyRootView, ControllerManager paramControllerManager, boolean paramBoolean)
  {
    return new i(paramInt, paramHippyMap, paramString, paramHippyRootView, paramControllerManager, paramBoolean);
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyPullHeaderView(paramContext);
  }
  
  public void dispatchFunction(HippyPullHeaderView paramHippyPullHeaderView, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramHippyPullHeaderView, paramString, paramHippyArray);
    paramHippyPullHeaderView = paramHippyPullHeaderView.getParentView();
    boolean bool = paramHippyPullHeaderView instanceof HippyListView;
    int j = 0;
    int i = 0;
    if (bool)
    {
      j = paramString.hashCode();
      if (j != -2068662420)
      {
        if ((j == -259784513) && (paramString.equals("collapsePullHeader"))) {
          break label82;
        }
      }
      else if (paramString.equals("expandPullHeader"))
      {
        i = 1;
        break label82;
      }
      i = -1;
      label82:
      if (i != 0)
      {
        if (i != 1) {
          return;
        }
        ((HippyListView)paramHippyPullHeaderView).onHeaderRefresh();
        return;
      }
      ((HippyListView)paramHippyPullHeaderView).onHeaderRefreshFinish();
      return;
    }
    if ((paramHippyPullHeaderView instanceof HippyRecyclerView))
    {
      paramHippyPullHeaderView = ((HippyRecyclerView)paramHippyPullHeaderView).getAdapter().getHeaderEventHelper();
      if (paramHippyPullHeaderView != null)
      {
        i = paramString.hashCode();
        if (i != -2068662420)
        {
          if ((i == -259784513) && (paramString.equals("collapsePullHeader")))
          {
            i = j;
            break label189;
          }
        }
        else if (paramString.equals("expandPullHeader"))
        {
          i = 1;
          break label189;
        }
        i = -1;
        label189:
        if (i != 0)
        {
          if (i != 1) {
            return;
          }
          paramHippyPullHeaderView.onHeaderRefresh();
          return;
        }
        paramHippyPullHeaderView.onHeaderRefreshFinish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.refresh.HippyPullHeaderViewController
 * JD-Core Version:    0.7.0.1
 */