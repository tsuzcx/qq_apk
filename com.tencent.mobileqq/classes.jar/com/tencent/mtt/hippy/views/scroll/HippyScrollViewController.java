package com.tencent.mtt.hippy.views.scroll;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyGroupController;
import com.tencent.mtt.hippy.utils.PixelUtil;

@HippyController(name="ScrollView")
public class HippyScrollViewController<T extends ViewGroup,  extends HippyScrollView>
  extends HippyGroupController
{
  public static final String CLASS_NAME = "ScrollView";
  protected static final String SCROLL_TO = "scrollTo";
  private static final String SCROLL_TO_WITHOPTIONS = "scrollToWithOptions";
  
  public View createViewImpl(Context paramContext)
  {
    return null;
  }
  
  public View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    if ((paramHippyMap != null) && (paramHippyMap.containsKey("horizontal")) && (paramHippyMap.getBoolean("horizontal"))) {
      return new HippyHorizontalScrollView(paramContext);
    }
    return new HippyVerticalScrollView(paramContext);
  }
  
  public void dispatchFunction(View paramView, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramView, paramString, paramHippyArray);
    int i;
    int j;
    if ((paramView instanceof HippyScrollView)) {
      if (TextUtils.equals("scrollTo", paramString))
      {
        i = Math.round(PixelUtil.dp2px(paramHippyArray.getDouble(0)));
        j = Math.round(PixelUtil.dp2px(paramHippyArray.getDouble(1)));
        if (!paramHippyArray.getBoolean(2)) {
          break label156;
        }
        ((HippyScrollView)paramView).callSmoothScrollTo(i, j, 0);
      }
    }
    for (;;)
    {
      if ((TextUtils.equals("scrollToWithOptions", paramString)) && (paramHippyArray != null) && (paramHippyArray.size() > 0))
      {
        paramString = paramHippyArray.getMap(0);
        i = Math.round(PixelUtil.dp2px(paramString.getInt("x")));
        j = Math.round(PixelUtil.dp2px(paramString.getInt("y")));
        int k = paramString.getInt("duration");
        if (k <= 0) {
          break;
        }
        ((HippyScrollView)paramView).callSmoothScrollTo(i, j, k);
      }
      return;
      label156:
      paramView.scrollTo(i, j);
    }
    paramView.scrollTo(i, j);
  }
  
  @HippyControllerProps(name="contentOffset4Reuse")
  public void setContentOffset4Reuse(HippyScrollView paramHippyScrollView, HippyMap paramHippyMap)
  {
    paramHippyScrollView.setContentOffset4Reuse(paramHippyMap);
  }
  
  @HippyControllerProps(defaultBoolean=true, defaultType="boolean", name="flingEnabled")
  public void setFlingEnabled(HippyScrollView paramHippyScrollView, boolean paramBoolean)
  {
    paramHippyScrollView.setFlingEnabled(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onMomentumScrollBegin")
  public void setMomentumScrollBeginEventEnable(HippyScrollView paramHippyScrollView, boolean paramBoolean)
  {
    paramHippyScrollView.setMomentumScrollBeginEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onMomentumScrollEnd")
  public void setMomentumScrollEndEventEnable(HippyScrollView paramHippyScrollView, boolean paramBoolean)
  {
    paramHippyScrollView.setMomentumScrollEndEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="pagingEnabled")
  public void setPagingEnabled(HippyScrollView paramHippyScrollView, boolean paramBoolean)
  {
    paramHippyScrollView.setPagingEnabled(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onScrollAnimationEnd")
  public void setScrollAnimationEndEventEnable(HippyScrollView paramHippyScrollView, boolean paramBoolean)
  {
    paramHippyScrollView.setScrollAnimationEndEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onScrollBeginDrag")
  public void setScrollBeginDragEventEnable(HippyScrollView paramHippyScrollView, boolean paramBoolean)
  {
    paramHippyScrollView.setScrollBeginDragEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=true, defaultType="boolean", name="scrollEnabled")
  public void setScrollEnabled(HippyScrollView paramHippyScrollView, boolean paramBoolean)
  {
    paramHippyScrollView.setScrollEnabled(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onScrollEndDrag")
  public void setScrollEndDragEventEnable(HippyScrollView paramHippyScrollView, boolean paramBoolean)
  {
    paramHippyScrollView.setScrollEndDragEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onScrollEnable")
  public void setScrollEventEnable(HippyScrollView paramHippyScrollView, boolean paramBoolean)
  {
    paramHippyScrollView.setScrollEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultNumber=30.0D, defaultType="number", name="scrollEventThrottle")
  public void setScrollEventThrottle(HippyScrollView paramHippyScrollView, int paramInt)
  {
    paramHippyScrollView.setScrollEventThrottle(paramInt);
  }
  
  @HippyControllerProps(defaultNumber=5.0D, defaultType="number", name="scrollMinOffset")
  public void setScrollMinOffset(HippyScrollView paramHippyScrollView, int paramInt)
  {
    paramHippyScrollView.setScrollMinOffset(paramInt);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="showScrollIndicator")
  public void setShowScrollIndicator(HippyScrollView paramHippyScrollView, boolean paramBoolean)
  {
    paramHippyScrollView.showScrollIndicator(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.scroll.HippyScrollViewController
 * JD-Core Version:    0.7.0.1
 */