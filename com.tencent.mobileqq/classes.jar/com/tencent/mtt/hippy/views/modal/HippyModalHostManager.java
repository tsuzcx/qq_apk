package com.tencent.mtt.hippy.views.modal;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.uimanager.HippyGroupController;

@HippyController(name="Modal")
public class HippyModalHostManager
  extends HippyGroupController<HippyModalHostView>
{
  public static final String HIPPY_CLASS = "Modal";
  
  protected HippyModalHostView createModalHostView(Context paramContext)
  {
    return new HippyModalHostView(paramContext);
  }
  
  protected StyleNode createNode(boolean paramBoolean)
  {
    return new ModalStyleNode();
  }
  
  protected View createViewImpl(Context paramContext)
  {
    paramContext = createModalHostView(paramContext);
    paramContext.setOnRequestCloseListener(new HippyModalHostManager.1(this, paramContext));
    paramContext.setOnShowListener(new HippyModalHostManager.2(this, paramContext));
    return paramContext;
  }
  
  public void onAfterUpdateProps(HippyModalHostView paramHippyModalHostView)
  {
    super.onAfterUpdateProps(paramHippyModalHostView);
    paramHippyModalHostView.showOrUpdate();
  }
  
  public void onViewDestroy(HippyModalHostView paramHippyModalHostView)
  {
    super.onViewDestroy(paramHippyModalHostView);
    paramHippyModalHostView.onInstanceDestroy(paramHippyModalHostView.getId());
  }
  
  @HippyControllerProps(defaultString="none", defaultType="string", name="animationType")
  public void setAnimationType(HippyModalHostView paramHippyModalHostView, String paramString)
  {
    paramHippyModalHostView.setAnimationType(paramString);
  }
  
  @HippyControllerProps(defaultType="boolean", name="immersionStatusBar")
  public void setEnterImmersionStatusBar(HippyModalHostView paramHippyModalHostView, boolean paramBoolean)
  {
    paramHippyModalHostView.setEnterImmersionStatusBar(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="darkStatusBarText")
  public void setImmersionStatusBarTextDarkColor(HippyModalHostView paramHippyModalHostView, boolean paramBoolean)
  {
    paramHippyModalHostView.setImmersionStatusBarTextDarkColor(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="transparent")
  public void setTransparent(HippyModalHostView paramHippyModalHostView, boolean paramBoolean)
  {
    paramHippyModalHostView.setTransparent(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.modal.HippyModalHostManager
 * JD-Core Version:    0.7.0.1
 */