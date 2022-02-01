package com.tencent.mobileqq.vas.hippy.view.waterfall;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.RenderNode;

@HippyController(isLazyLoad=true, name="WaterfallViewItem", names={"WaterfallViewItem"})
public class HippyWaterfallItemViewController
  extends HippyViewController<HippyWaterfallItemView>
{
  public static final String CLASS_NAME = "WaterfallViewItem";
  
  public RenderNode createRenderNode(int paramInt, HippyMap paramHippyMap, String paramString, HippyRootView paramHippyRootView, ControllerManager paramControllerManager, boolean paramBoolean)
  {
    return new HippyWaterfallItemRenderNode(paramInt, paramHippyMap, paramString, paramHippyRootView, paramControllerManager, paramBoolean);
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyWaterfallItemView(paramContext);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="type")
  public void setListItemType(HippyWaterfallItemView paramHippyWaterfallItemView, int paramInt)
  {
    paramHippyWaterfallItemView.setType(paramInt);
  }
  
  protected boolean shouldInterceptLayout(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent instanceof ViewGroup))
    {
      int i = ((ViewGroup)localViewParent).getPaddingLeft();
      if (i > 0)
      {
        paramInt1 += i;
        paramView.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallItemViewController
 * JD-Core Version:    0.7.0.1
 */