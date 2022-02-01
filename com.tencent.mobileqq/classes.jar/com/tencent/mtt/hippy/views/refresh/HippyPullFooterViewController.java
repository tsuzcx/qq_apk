package com.tencent.mtt.hippy.views.refresh;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.uimanager.h;
import com.tencent.mtt.hippy.views.list.HippyListView;

@HippyController(isLazyLoad=true, name="PullFooterView")
public class HippyPullFooterViewController
  extends HippyViewController<HippyPullFooterView>
{
  public static final String CLASS_NAME = "PullFooterView";
  
  public RenderNode createRenderNode(int paramInt, HippyMap paramHippyMap, String paramString, HippyRootView paramHippyRootView, ControllerManager paramControllerManager, boolean paramBoolean)
  {
    return new h(paramInt, paramHippyMap, paramString, paramHippyRootView, paramControllerManager, paramBoolean);
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyPullFooterView(paramContext);
  }
  
  public void dispatchFunction(HippyPullFooterView paramHippyPullFooterView, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramHippyPullFooterView, paramString, paramHippyArray);
    paramHippyPullFooterView = paramHippyPullFooterView.getParentView();
    if (((paramHippyPullFooterView instanceof HippyListView)) && ("collapsePullFooter".equals(paramString))) {
      ((HippyListView)paramHippyPullFooterView).onFooterRefreshFinish();
    }
  }
  
  @HippyControllerProps(defaultType="boolean", name="sticky")
  public void setStickEnabled(HippyPullFooterView paramHippyPullFooterView, boolean paramBoolean)
  {
    paramHippyPullFooterView.setStickEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.refresh.HippyPullFooterViewController
 * JD-Core Version:    0.7.0.1
 */