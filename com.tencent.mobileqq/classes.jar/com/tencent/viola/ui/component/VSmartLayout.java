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
    if (!this.hasSetupPagerSlider) {}
    Object localObject;
    do
    {
      VComponent localVComponent;
      do
      {
        do
        {
          do
          {
            return;
            localObject = ViolaUtils.getDomActionContext(getInstance().getInstanceId());
          } while (localObject == null);
          localVComponent = ((DOMActionContext)localObject).getComponent(paramDomObject.getRef());
        } while (localVComponent == null);
        localObject = paramDomObject.getDomParent();
      } while (localObject == null);
      tryAddVList(localVComponent, true, ((DomObject)localObject).indexOf(paramDomObject));
      paramDomObject = (VSmartView)getHostView();
    } while (paramDomObject.getViewPager() == null);
    paramDomObject.getViewPager().setOffscreenPageLimit(((DomObject)localObject).getDomChildCount());
  }
  
  private void setupSmartLayout()
  {
    if ((this.mHost == null) || (!(this.mHost instanceof VSmartView))) {}
    VSmartView localVSmartView;
    int i;
    label34:
    Object localObject;
    do
    {
      return;
      localVSmartView = (VSmartView)this.mHost;
      int k = getChildCount();
      i = 0;
      if (i >= k) {
        break;
      }
      localObject = getChild(i);
      if ((!(localObject instanceof VSmartHeader)) || (this.hasSetupHeader)) {
        break label115;
      }
      localVSmartView.setSmartHeaderView((VSmartHeaderView)((VComponent)localObject).mHost);
    } while (((VComponent)localObject).getDomObject() == null);
    localVSmartView.setOffset(ViolaUtils.getFloat(((VComponent)localObject).getDomObject().getAttributes().get("offset")));
    this.hasSetupHeader = true;
    for (;;)
    {
      i += 1;
      break label34;
      break;
      label115:
      if (((localObject instanceof VPageSlider)) && (!this.hasSetupPagerSlider))
      {
        localObject = (VPageSlider)localObject;
        localVSmartView.setViewPager((VPageSliderView)((VPageSlider)localObject).mHost);
        int j = 0;
        if (j < ((VPageSlider)localObject).getChildCount())
        {
          VComponent localVComponent = ((VPageSlider)localObject).getChild(j);
          if (j != 0) {}
          for (boolean bool = true;; bool = false)
          {
            tryAddVList(localVComponent, bool, j);
            j += 1;
            break;
          }
        }
        this.hasSetupPagerSlider = true;
      }
    }
  }
  
  private void tryAddVList(VComponent paramVComponent, boolean paramBoolean, int paramInt)
  {
    if ((paramVComponent instanceof VPage)) {
      paramVComponent = ((VPage)paramVComponent).getChild(0);
    }
    for (;;)
    {
      if ((paramVComponent instanceof VRecyclerList)) {
        ((VSmartView)this.mHost).addRecyclerView((VRecyclerView)((VRecyclerList)paramVComponent).getHostView(), paramBoolean, paramInt);
      }
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.component.VSmartLayout
 * JD-Core Version:    0.7.0.1
 */