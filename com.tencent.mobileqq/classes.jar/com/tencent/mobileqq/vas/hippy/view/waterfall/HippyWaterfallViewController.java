package com.tencent.mobileqq.vas.hippy.view.waterfall;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.RenderNode;

@HippyController(name="WaterfallView")
public class HippyWaterfallViewController
  extends HippyViewController<HippyWaterfallView>
{
  public static final String CLASS_NAME = "WaterfallView";
  static final String TAG = "WaterfallView";
  
  protected void addView(ViewGroup paramViewGroup, View paramView, int paramInt) {}
  
  public RenderNode createRenderNode(int paramInt, HippyMap paramHippyMap, String paramString, HippyRootView paramHippyRootView, ControllerManager paramControllerManager, boolean paramBoolean)
  {
    return new HippyWaterfallViewNode(paramInt, paramHippyMap, paramString, paramHippyRootView, paramControllerManager, paramBoolean);
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyWaterfallView(paramContext);
  }
  
  public void dispatchFunction(HippyWaterfallView paramHippyWaterfallView, String paramString, HippyArray paramHippyArray)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatchFunction ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramHippyArray.toString());
    Log.e("WaterfallView", localStringBuilder.toString());
    super.dispatchFunction(paramHippyWaterfallView, paramString, paramHippyArray);
    int i = paramString.hashCode();
    int j = 4;
    switch (i)
    {
    default: 
      break;
    case 1972516829: 
      if (paramString.equals("startLoadMore")) {
        i = 1;
      }
      break;
    case 1963419417: 
      if (paramString.equals("callExposureReport")) {
        i = 4;
      }
      break;
    case 304763924: 
      if (paramString.equals("endReachedCompleted")) {
        i = 0;
      }
      break;
    case -716578934: 
      if (paramString.equals("scrollToIndex")) {
        i = 2;
      }
      break;
    case -1101593308: 
      if (paramString.equals("scrollToContentOffset")) {
        i = 3;
      }
      break;
    }
    i = -1;
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
            paramHippyWaterfallView.onScrollStateChanged(paramHippyWaterfallView.getScrollState(), paramHippyWaterfallView.getScrollState());
            return;
          }
          paramHippyWaterfallView.a(paramHippyArray.getDouble(0), paramHippyArray.getDouble(1), paramHippyArray.getBoolean(2));
          return;
        }
        paramHippyWaterfallView.a(paramHippyArray.getInt(0), paramHippyArray.getInt(1), paramHippyArray.getBoolean(2));
        return;
      }
      paramHippyWaterfallView.a();
      return;
    }
    int k = paramHippyArray.getInt(0);
    paramString = paramHippyArray.getString(1);
    if (k != 0)
    {
      i = j;
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4) {
              i = 1;
            } else {
              i = 0;
            }
          }
          else {
            i = 100;
          }
        }
        else {
          i = 6;
        }
      }
    }
    else
    {
      i = 2;
    }
    paramHippyWaterfallView.a(i, paramString);
  }
  
  public View getChildAt(HippyWaterfallView paramHippyWaterfallView, int paramInt)
  {
    return ((HippyWaterfallAdapter)paramHippyWaterfallView.getAdapter()).getRecyclerItemView(paramInt);
  }
  
  public int getChildCount(HippyWaterfallView paramHippyWaterfallView)
  {
    return ((HippyWaterfallAdapter)paramHippyWaterfallView.getAdapter()).getRecyclerItemCount();
  }
  
  public void onBatchComplete(HippyWaterfallView paramHippyWaterfallView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBatchComplete #");
    localStringBuilder.append(paramHippyWaterfallView.getId());
    Log.d("WaterfallView", localStringBuilder.toString());
    super.onBatchComplete(paramHippyWaterfallView);
    paramHippyWaterfallView.setListData();
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="bannerViewMatch")
  public void setBannerViewMatch(HippyWaterfallView paramHippyWaterfallView, boolean paramBoolean)
  {
    ((HippyWaterfallLayoutManager)paramHippyWaterfallView.getLayoutManager()).c(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="containBannerView")
  public void setContainBannerView(HippyWaterfallView paramHippyWaterfallView, boolean paramBoolean)
  {
    ((HippyWaterfallLayoutManager)paramHippyWaterfallView.getLayoutManager()).a(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="enableLoadingFooter")
  public void setEnableLoadingFooter(HippyWaterfallView paramHippyWaterfallView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramHippyWaterfallView.b = true;
      paramHippyWaterfallView.a(2, "");
      return;
    }
    paramHippyWaterfallView.a(0, "");
    paramHippyWaterfallView.b = false;
  }
  
  @HippyControllerProps(defaultBoolean=true, defaultType="boolean", name="enableOnScrollForReport")
  public void setEnableOnScrollForReport(HippyWaterfallView paramHippyWaterfallView, boolean paramBoolean)
  {
    paramHippyWaterfallView.setEnableScrollForReport(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="enableRefresh")
  public void setEnableRefresh(HippyWaterfallView paramHippyWaterfallView, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramHippyWaterfallView.c)) {
      return;
    }
    paramHippyWaterfallView.setRefreshEnabled(paramBoolean);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="itemGap")
  public void setItemGap(HippyWaterfallView paramHippyWaterfallView, int paramInt)
  {
    ((HippyWaterfallLayoutManager)paramHippyWaterfallView.getLayoutManager()).b(ViewUtils.dip2px(paramInt));
  }
  
  @HippyControllerProps(defaultNumber=2.0D, defaultType="number", name="numberOfColumns")
  public void setNumberOfColumns(HippyWaterfallView paramHippyWaterfallView, int paramInt)
  {
    ((HippyWaterfallLayoutManager)paramHippyWaterfallView.getLayoutManager()).a(paramInt);
  }
  
  @HippyControllerProps(defaultBoolean=true, defaultType="boolean", name="enableExposureReport")
  public void setOnExposureReport(HippyWaterfallView paramHippyWaterfallView, boolean paramBoolean)
  {
    paramHippyWaterfallView.setEnableExposureReport(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=true, defaultType="boolean", name="paddingStartZero")
  public void setPaddingStartZero(HippyWaterfallView paramHippyWaterfallView, boolean paramBoolean)
  {
    ((HippyWaterfallLayoutManager)paramHippyWaterfallView.getLayoutManager()).b(paramBoolean);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="preloadItemNumber")
  public void setPreloadItemNumber(HippyWaterfallView paramHippyWaterfallView, int paramInt)
  {
    paramHippyWaterfallView.setPreloadItemNumber(paramInt);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="preloadPixel")
  public void setPreloadPixel(HippyWaterfallView paramHippyWaterfallView, int paramInt)
  {
    paramHippyWaterfallView.setPreloadPixel(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallViewController
 * JD-Core Version:    0.7.0.1
 */