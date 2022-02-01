package com.tencent.mtt.hippy.views.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.uimanager.e;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Recycler;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewItem;
import java.util.concurrent.CopyOnWriteArrayList;

@HippyController(name="ListView")
public class HippyListViewController
  extends HippyViewController<HippyListView>
{
  public static final String CLASS_NAME = "ListView";
  
  protected void addView(ViewGroup paramViewGroup, View paramView, int paramInt) {}
  
  public RenderNode createRenderNode(int paramInt, HippyMap paramHippyMap, String paramString, HippyRootView paramHippyRootView, ControllerManager paramControllerManager, boolean paramBoolean)
  {
    return new e(paramInt, paramHippyMap, paramString, paramHippyRootView, paramControllerManager, paramBoolean);
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyListView(paramContext, 1);
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    if ((paramHippyMap != null) && (paramHippyMap.containsKey("horizontal"))) {
      return new HippyListView(paramContext, 0);
    }
    return new HippyListView(paramContext, 1);
  }
  
  protected void deleteChild(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    if ((paramView instanceof RecyclerViewItem)) {
      ((RecyclerViewItem)paramView).removeAllViews();
    }
    if ((paramInt >= 0) && ((paramViewGroup instanceof HippyListView))) {
      ((HippyListView)paramViewGroup).getRecycler().updateHolderPositionWhenDelete(paramInt);
    }
  }
  
  public void dispatchFunction(HippyListView paramHippyListView, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramHippyListView, paramString, paramHippyArray);
    int i = paramString.hashCode();
    if (i != -1101593308)
    {
      if (i != -716578934)
      {
        if ((i == 2055128589) && (paramString.equals("scrollToTop")))
        {
          i = 2;
          break label85;
        }
      }
      else if (paramString.equals("scrollToIndex"))
      {
        i = 0;
        break label85;
      }
    }
    else if (paramString.equals("scrollToContentOffset"))
    {
      i = 1;
      break label85;
    }
    i = -1;
    label85:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        paramHippyListView.scrollToTop(null);
        return;
      }
      paramHippyListView.scrollToContentOffset(paramHippyArray.getDouble(0), paramHippyArray.getDouble(1), paramHippyArray.getBoolean(2), paramHippyArray.getInt(3));
      return;
    }
    paramHippyListView.scrollToIndex(paramHippyArray.getInt(0), paramHippyArray.getInt(1), paramHippyArray.getBoolean(2), paramHippyArray.getInt(3));
  }
  
  public View getChildAt(HippyListView paramHippyListView, int paramInt)
  {
    return ((HippyListAdapter)paramHippyListView.getAdapter()).getRecyclerItemView(paramInt);
  }
  
  public int getChildCount(HippyListView paramHippyListView)
  {
    return ((HippyListAdapter)paramHippyListView.getAdapter()).getRecyclerItemCount();
  }
  
  public void onBatchComplete(HippyListView paramHippyListView)
  {
    super.onBatchComplete(paramHippyListView);
    paramHippyListView.setListData();
  }
  
  public void onViewDestroy(HippyListView paramHippyListView)
  {
    super.onViewDestroy(paramHippyListView);
    if ((paramHippyListView != null) && (paramHippyListView.mListScrollListeners != null)) {
      paramHippyListView.mListScrollListeners.clear();
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="exposureEventEnabled")
  public void setExposureEventEnable(HippyListView paramHippyListView, boolean paramBoolean)
  {
    paramHippyListView.setExposureEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onMomentumScrollBegin")
  public void setMomentumScrollBeginEventEnable(HippyListView paramHippyListView, boolean paramBoolean)
  {
    paramHippyListView.setMomentumScrollBeginEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onMomentumScrollEnd")
  public void setMomentumScrollEndEventEnable(HippyListView paramHippyListView, boolean paramBoolean)
  {
    paramHippyListView.setMomentumScrollEndEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onScrollEnable")
  public void setOnScrollEventEnable(HippyListView paramHippyListView, boolean paramBoolean)
  {
    paramHippyListView.setOnScrollEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=true, defaultType="boolean", name="overScrollEnabled")
  public void setOverScrollEnabled(HippyListView paramHippyListView, boolean paramBoolean)
  {
    paramHippyListView.setOverScrollEnabled(paramBoolean);
  }
  
  @HippyControllerProps(name="preloadItemNumber")
  public void setPreloadItemNumber(HippyListView paramHippyListView, int paramInt)
  {
    paramHippyListView = paramHippyListView.getAdapter();
    if ((paramHippyListView instanceof HippyListAdapter)) {
      ((HippyListAdapter)paramHippyListView).setPreloadItemNumber(paramInt);
    }
  }
  
  @HippyControllerProps(name="rowShouldSticky")
  public void setRowShouldSticky(HippyListView paramHippyListView, boolean paramBoolean)
  {
    paramHippyListView.setHasSuspentedItem(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onScrollBeginDrag")
  public void setScrollBeginDragEventEnable(HippyListView paramHippyListView, boolean paramBoolean)
  {
    paramHippyListView.setScrollBeginDragEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=true, defaultType="boolean", name="scrollEnabled")
  public void setScrollEnable(HippyListView paramHippyListView, boolean paramBoolean)
  {
    paramHippyListView.setScrollEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onScrollEndDrag")
  public void setScrollEndDragEventEnable(HippyListView paramHippyListView, boolean paramBoolean)
  {
    paramHippyListView.setScrollEndDragEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultNumber=30.0D, defaultType="number", name="scrollEventThrottle")
  public void setscrollEventThrottle(HippyListView paramHippyListView, int paramInt)
  {
    paramHippyListView.setScrollEventThrottle(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.list.HippyListViewController
 * JD-Core Version:    0.7.0.1
 */