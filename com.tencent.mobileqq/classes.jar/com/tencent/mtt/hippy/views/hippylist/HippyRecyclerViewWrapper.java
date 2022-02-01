package com.tencent.mtt.hippy.views.hippylist;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.HippyRecyclerExtension;
import androidx.recyclerview.widget.HippyRecyclerPool;
import com.tencent.mtt.a.a.a.c.b;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;

public class HippyRecyclerViewWrapper<HRCV extends HippyRecyclerView>
  extends FrameLayout
  implements b, HippyViewBase
{
  protected final HippyEngineContext hpContext;
  private NativeGestureDispatcher nativeGestureDispatcher;
  protected HRCV recyclerView;
  
  public HippyRecyclerViewWrapper(@NonNull Context paramContext, HRCV paramHRCV)
  {
    super(paramContext);
    this.recyclerView = paramHRCV;
    addView(paramHRCV, new FrameLayout.LayoutParams(-1, -1));
    this.hpContext = ((HippyInstanceContext)paramContext).getEngineContext();
    paramContext = new HippyRecyclerExtension(paramHRCV, this.hpContext, paramHRCV.getNodePositionHelper());
    paramHRCV.setViewCacheExtension(paramContext);
    paramHRCV.setHeaderHost(this);
    paramContext = new HippyRecyclerPool(this.hpContext, this, paramContext, paramHRCV.getNodePositionHelper());
    paramContext.setViewAboundListener(paramHRCV);
    paramHRCV.setRecycledViewPool(paramContext);
  }
  
  public void addOnLayoutListener(ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    getViewTreeObserver().addOnGlobalLayoutListener(paramOnGlobalLayoutListener);
  }
  
  public void attachHeader(View paramView, FrameLayout.LayoutParams paramLayoutParams)
  {
    addView(paramView, paramLayoutParams);
    layout(getLeft(), getTop(), getRight(), getBottom());
    getViewTreeObserver().dispatchOnGlobalLayout();
  }
  
  public int computeVerticalScrollOffset()
  {
    return this.recyclerView.computeVerticalScrollOffset();
  }
  
  public View getChildAtWithCaches(int paramInt)
  {
    return this.recyclerView.getChildAtWithCaches(paramInt);
  }
  
  public int getChildCountWithCaches()
  {
    return this.recyclerView.getChildCountWithCaches();
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return this.nativeGestureDispatcher;
  }
  
  public HRCV getRecyclerView()
  {
    return this.recyclerView;
  }
  
  public RecyclerViewEventHelper getRecyclerViewEventHelper()
  {
    return this.recyclerView.getRecyclerViewEventHelper();
  }
  
  @RequiresApi(api=16)
  public void removeOnLayoutListener(ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    getViewTreeObserver().removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
  }
  
  public void scrollToContentOffset(double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt)
  {
    this.recyclerView.scrollToContentOffset(paramDouble1, paramDouble2, paramBoolean, paramInt);
  }
  
  public void scrollToIndex(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    this.recyclerView.scrollToIndex(paramInt1, paramInt2, paramBoolean, paramInt3);
  }
  
  public void scrollToTop()
  {
    this.recyclerView.scrollToTop();
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher)
  {
    this.nativeGestureDispatcher = paramNativeGestureDispatcher;
  }
  
  public void setListData()
  {
    this.recyclerView.setListData();
  }
  
  public void setRowShouldSticky(boolean paramBoolean)
  {
    this.recyclerView.setRowShouldSticky(paramBoolean);
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.recyclerView.setScrollEnable(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewWrapper
 * JD-Core Version:    0.7.0.1
 */