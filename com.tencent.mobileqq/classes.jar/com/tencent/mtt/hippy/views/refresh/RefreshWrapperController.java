package com.tencent.mtt.hippy.views.refresh;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.uimanager.HippyGroupController;

@HippyController(name="RefreshWrapper")
public class RefreshWrapperController
  extends HippyGroupController<RefreshWrapper>
{
  final String RefreshComplected = "refreshComplected";
  final String StartRefresh = "startRefresh";
  
  @HippyControllerProps(defaultNumber=300.0D, defaultType="number", name="bounceTime")
  public void bounceTime(RefreshWrapper paramRefreshWrapper, int paramInt)
  {
    paramRefreshWrapper.setTime(paramInt);
  }
  
  public View createViewImpl(Context paramContext)
  {
    return new RefreshWrapper(paramContext);
  }
  
  public void dispatchFunction(RefreshWrapper paramRefreshWrapper, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramRefreshWrapper, paramString, paramHippyArray);
    if ("refreshComplected".equals(paramString)) {
      paramRefreshWrapper.refreshComplected();
    }
    while (!"startRefresh".equals(paramString)) {
      return;
    }
    paramRefreshWrapper.startRefresh();
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onScrollEnable")
  public void setOnScrollEventEnable(RefreshWrapper paramRefreshWrapper, boolean paramBoolean)
  {
    paramRefreshWrapper.setOnScrollEventEnable(paramBoolean);
  }
  
  @HippyControllerProps(defaultNumber=30.0D, defaultType="number", name="scrollEventThrottle")
  public void setscrollEventThrottle(RefreshWrapper paramRefreshWrapper, int paramInt)
  {
    paramRefreshWrapper.setScrollEventThrottle(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.refresh.RefreshWrapperController
 * JD-Core Version:    0.7.0.1
 */