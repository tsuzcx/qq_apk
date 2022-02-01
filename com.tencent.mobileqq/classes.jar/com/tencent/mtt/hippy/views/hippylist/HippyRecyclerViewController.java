package com.tencent.mtt.hippy.views.hippylist;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.EasyLinearLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.uimanager.e;

@HippyController(name="RecyclerView")
public class HippyRecyclerViewController<HRW extends HippyRecyclerViewWrapper>
  extends HippyViewController<HRW>
{
  public static final String CLASS_NAME = "RecyclerView";
  public static final String COLLAPSE_PULL_HEADER = "collapsePullHeader";
  public static final String EXPAND_PULL_HEADER = "expandPullHeader";
  public static final String SCROLL_TO_CONTENT_OFFSET = "scrollToContentOffset";
  public static final String SCROLL_TO_INDEX = "scrollToIndex";
  public static final String SCROLL_TO_TOP = "scrollToTop";
  
  private HippyRecyclerListAdapter getAdapter(HRW paramHRW)
  {
    return paramHRW.getRecyclerView().getAdapter();
  }
  
  public static HippyRecyclerView initDefault(Context paramContext, HippyMap paramHippyMap, HippyRecyclerView paramHippyRecyclerView)
  {
    EasyLinearLayoutManager localEasyLinearLayoutManager = new EasyLinearLayoutManager(paramContext);
    paramHippyRecyclerView.setItemAnimator(null);
    if ((paramHippyMap != null) && (paramHippyMap.containsKey("horizontal"))) {
      localEasyLinearLayoutManager.setOrientation(0);
    }
    paramHippyRecyclerView.setLayoutManager(localEasyLinearLayoutManager);
    paramHippyRecyclerView.setHippyEngineContext(((HippyInstanceContext)paramContext).getEngineContext());
    paramHippyRecyclerView.initRecyclerView();
    return paramHippyRecyclerView;
  }
  
  public RenderNode createRenderNode(int paramInt, HippyMap paramHippyMap, String paramString, HippyRootView paramHippyRootView, ControllerManager paramControllerManager, boolean paramBoolean)
  {
    return new e(paramInt, paramHippyMap, paramString, paramHippyRootView, paramControllerManager, paramBoolean);
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return createViewImpl(paramContext, null);
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    return new HippyRecyclerViewWrapper(paramContext, initDefault(paramContext, paramHippyMap, new HippyRecyclerView(paramContext)));
  }
  
  public void dispatchFunction(HRW paramHRW, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramHRW, paramString, paramHippyArray);
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2055128589: 
      if (paramString.equals("scrollToTop")) {
        i = 2;
      }
      break;
    case -259784513: 
      if (paramString.equals("collapsePullHeader")) {
        i = 3;
      }
      break;
    case -716578934: 
      if (paramString.equals("scrollToIndex")) {
        i = 0;
      }
      break;
    case -1101593308: 
      if (paramString.equals("scrollToContentOffset")) {
        i = 1;
      }
      break;
    case -2068662420: 
      if (paramString.equals("expandPullHeader")) {
        i = 4;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return;
            }
            getAdapter(paramHRW).getHeaderEventHelper().onHeaderRefresh();
            return;
          }
          getAdapter(paramHRW).getHeaderEventHelper().onHeaderRefreshFinish();
          return;
        }
        paramHRW.scrollToTop();
        return;
      }
      paramHRW.scrollToContentOffset(paramHippyArray.getDouble(0), paramHippyArray.getDouble(1), paramHippyArray.getBoolean(2), paramHippyArray.getInt(3));
      return;
    }
    paramHRW.scrollToIndex(paramHippyArray.getInt(0), paramHippyArray.getInt(1), paramHippyArray.getBoolean(2), paramHippyArray.getInt(3));
  }
  
  public View getChildAt(HRW paramHRW, int paramInt)
  {
    return paramHRW.getChildAtWithCaches(paramInt);
  }
  
  public int getChildCount(HRW paramHRW)
  {
    return paramHRW.getChildCountWithCaches();
  }
  
  public void onBatchComplete(HRW paramHRW)
  {
    super.onBatchComplete(paramHRW);
    paramHRW.setListData();
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="exposureEventEnabled")
  public void setExposureEventEnable(HRW paramHRW, boolean paramBoolean)
  {
    paramHRW.getRecyclerViewEventHelper().setExposureEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onMomentumScrollBegin")
  public void setMomentumScrollBeginEventEnable(HRW paramHRW, boolean paramBoolean)
  {
    paramHRW.getRecyclerViewEventHelper().setMomentumScrollBeginEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onMomentumScrollEnd")
  public void setMomentumScrollEndEventEnable(HRW paramHRW, boolean paramBoolean)
  {
    paramHRW.getRecyclerViewEventHelper().setMomentumScrollEndEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onScrollEnable")
  public void setOnScrollEventEnable(HRW paramHRW, boolean paramBoolean)
  {
    paramHRW.getRecyclerViewEventHelper().setOnScrollEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(name="preloadItemNumber")
  public void setPreloadItemNumber(HRW paramHRW, int paramInt)
  {
    getAdapter(paramHRW).setPreloadItemNumber(paramInt);
  }
  
  @HippyControllerProps(name="rowShouldSticky")
  public void setRowShouldSticky(HRW paramHRW, boolean paramBoolean)
  {
    paramHRW.setRowShouldSticky(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onScrollBeginDrag")
  public void setScrollBeginDragEventEnable(HRW paramHRW, boolean paramBoolean)
  {
    paramHRW.getRecyclerViewEventHelper().setScrollBeginDragEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=true, defaultType="boolean", name="scrollEnabled")
  public void setScrollEnable(HRW paramHRW, boolean paramBoolean)
  {
    paramHRW.setScrollEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onScrollEndDrag")
  public void setScrollEndDragEventEnable(HRW paramHRW, boolean paramBoolean)
  {
    paramHRW.getRecyclerViewEventHelper().setScrollEndDragEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultNumber=30.0D, defaultType="number", name="scrollEventThrottle")
  public void setscrollEventThrottle(HRW paramHRW, int paramInt)
  {
    paramHRW.getRecyclerViewEventHelper().setScrollEventThrottle(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewController
 * JD-Core Version:    0.7.0.1
 */