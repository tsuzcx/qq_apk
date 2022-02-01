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

@HippyController(name="ListView")
public class HippyListViewController
  extends HippyViewController<HippyListView>
{
  public static final String CLASS_NAME = "ListView";
  
  public void addView(ViewGroup paramViewGroup, View paramView, int paramInt) {}
  
  public RenderNode createRenderNode(int paramInt, HippyMap paramHippyMap, String paramString, HippyRootView paramHippyRootView, ControllerManager paramControllerManager, boolean paramBoolean)
  {
    return new e(paramInt, paramHippyMap, paramString, paramHippyRootView, paramControllerManager, paramBoolean);
  }
  
  public View createViewImpl(Context paramContext)
  {
    return new HippyListView(paramContext, 1);
  }
  
  public View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    if ((paramHippyMap != null) && (paramHippyMap.containsKey("horizontal"))) {
      return new HippyListView(paramContext, 0);
    }
    return new HippyListView(paramContext, 1);
  }
  
  public void deleteChild(ViewGroup paramViewGroup, View paramView, int paramInt)
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
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (paramString.equals("scrollToIndex"))
        {
          i = 0;
          continue;
          if (paramString.equals("scrollToContentOffset"))
          {
            i = 1;
            continue;
            if (paramString.equals("scrollToTop")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    paramHippyListView.scrollToIndex(paramHippyArray.getInt(0), paramHippyArray.getInt(1), paramHippyArray.getBoolean(2), paramHippyArray.getInt(3));
    return;
    paramHippyListView.scrollToContentOffset(paramHippyArray.getDouble(0), paramHippyArray.getDouble(1), paramHippyArray.getBoolean(2), paramHippyArray.getInt(3));
    return;
    paramHippyListView.scrollToTop(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.list.HippyListViewController
 * JD-Core Version:    0.7.0.1
 */