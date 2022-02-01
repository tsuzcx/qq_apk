package com.tencent.mtt.hippy.views.custom;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.RenderManager;

@HippyController(name="CustomProps")
public class HippyCustomPropsController
  extends HippyViewController
{
  public static final String CLASS_NAME = "CustomProps";
  public static final String DT_EBLID = "dt_elementBizLeafIdentifier";
  
  protected View createViewImpl(Context paramContext)
  {
    return null;
  }
  
  protected void onSetDTElementBizLeafIdentifier(View paramView)
  {
    if (paramView == null) {
      return;
    }
    Object localObject = paramView.getContext();
    if ((localObject instanceof HippyInstanceContext))
    {
      localObject = ((HippyInstanceContext)localObject).getEngineContext();
      if (localObject == null) {
        return;
      }
      paramView = ((HippyEngineContext)localObject).getRenderManager().getRenderNode(paramView.getId());
      if (paramView != null) {
        paramView.mHasSetDteblId = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.custom.HippyCustomPropsController
 * JD-Core Version:    0.7.0.1
 */