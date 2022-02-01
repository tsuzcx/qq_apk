package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VFrameLayout;
import com.tencent.viola.ui.view.VPageSliderView;
import com.tencent.viola.ui.view.VSmartHeaderView;
import com.tencent.viola.ui.view.VSmartView;
import com.tencent.viola.ui.view.list.VRecyclerView;
import com.tencent.viola.utils.ViolaUtils;

public class VSmartLayout
  extends VDiv
{
  private boolean hasSetupHeader;
  private boolean hasSetupPagerSlider;
  
  public VSmartLayout(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void setupPage(DomObject paramDomObject)
  {
    if (!this.hasSetupPagerSlider) {
      return;
    }
    Object localObject = ViolaUtils.getDomActionContext(getInstance().getInstanceId());
    if (localObject == null) {
      return;
    }
    VComponent localVComponent = ((DOMActionContext)localObject).getComponent(paramDomObject.getRef());
    if (localVComponent == null) {
      return;
    }
    localObject = paramDomObject.getDomParent();
    if (localObject != null)
    {
      tryAddVList(localVComponent, true, ((DomObject)localObject).indexOf(paramDomObject));
      paramDomObject = (VSmartView)getHostView();
      if (paramDomObject.getViewPager() != null) {
        paramDomObject.getViewPager().setOffscreenPageLimit(((DomObject)localObject).getDomChildCount());
      }
    }
  }
  
  private void setupSmartLayout()
  {
    if (this.mHost != null)
    {
      if (!(this.mHost instanceof VSmartView)) {
        return;
      }
      VSmartView localVSmartView = (VSmartView)this.mHost;
      int k = getChildCount();
      int i = 0;
      while (i < k)
      {
        Object localObject = getChild(i);
        if (((localObject instanceof VSmartHeader)) && (!this.hasSetupHeader))
        {
          localVSmartView.setSmartHeaderView((VSmartHeaderView)((VComponent)localObject).mHost);
          if (((VComponent)localObject).getDomObject() == null) {
            return;
          }
          localVSmartView.setOffset(ViolaUtils.getFloat(((VComponent)localObject).getDomObject().getAttributes().get("offset")));
          this.hasSetupHeader = true;
        }
        else if (((localObject instanceof VPageSlider)) && (!this.hasSetupPagerSlider))
        {
          localObject = (VPageSlider)localObject;
          localVSmartView.setViewPager((VPageSliderView)((VPageSlider)localObject).mHost);
          int j = 0;
          while (j < ((VPageSlider)localObject).getChildCount())
          {
            VComponent localVComponent = ((VPageSlider)localObject).getChild(j);
            boolean bool;
            if (j != 0) {
              bool = true;
            } else {
              bool = false;
            }
            tryAddVList(localVComponent, bool, j);
            j += 1;
          }
          this.hasSetupPagerSlider = true;
        }
        i += 1;
      }
    }
  }
  
  private void tryAddVList(VComponent paramVComponent, boolean paramBoolean, int paramInt)
  {
    VComponent localVComponent = paramVComponent;
    if ((paramVComponent instanceof VPage)) {
      localVComponent = ((VPage)paramVComponent).getChild(0);
    }
    if ((localVComponent instanceof VRecyclerList)) {
      ((VSmartView)this.mHost).addRecyclerView((VRecyclerView)((VRecyclerList)localVComponent).getHostView(), paramBoolean, paramInt);
    }
  }
  
  protected VFrameLayout initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VSmartView(paramContext);
    paramContext.bindComponent(this);
    return paramContext;
  }
  
  public void notifyParentWhenChildAddEnd()
  {
    setupSmartLayout();
  }
  
  public void notifyWhenChange(String paramString, DomObject paramDomObject)
  {
    if (paramDomObject == null) {
      return;
    }
    if (("add".equals(paramString)) && ("page-slider".equals(paramDomObject.getType())))
    {
      setupSmartLayout();
      return;
    }
    if (("add".equals(paramString)) && ("page".equals(paramDomObject.getType())))
    {
      setupPage(paramDomObject);
      return;
    }
    super.notifyWhenChange(paramString, paramDomObject);
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    if ((getHostView() instanceof VSmartView)) {
      ((VSmartView)getHostView()).destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VSmartLayout
 * JD-Core Version:    0.7.0.1
 */