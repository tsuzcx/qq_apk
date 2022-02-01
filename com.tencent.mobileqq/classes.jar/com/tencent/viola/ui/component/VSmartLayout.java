package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
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
  public VSmartLayout(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  protected VFrameLayout initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VSmartView(paramContext);
    paramContext.bindComponent(this);
    return paramContext;
  }
  
  public void notifyParentWhenChildAddEnd()
  {
    if ((this.mHost == null) || (!(this.mHost instanceof VSmartView))) {}
    VSmartView localVSmartView;
    int i;
    label34:
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
      if (!(localObject instanceof VSmartHeader)) {
        break label103;
      }
      localVSmartView.setSmartHeaderView((VSmartHeaderView)((VComponent)localObject).mHost);
    } while (((VComponent)localObject).getDomObject() == null);
    localVSmartView.setOffset(ViolaUtils.getFloat(((VComponent)localObject).getDomObject().getAttributes().get("offset")));
    label103:
    while (!(localObject instanceof VPageSlider))
    {
      i += 1;
      break label34;
      break;
    }
    Object localObject = (VPageSlider)localObject;
    localVSmartView.setViewPager((VPageSliderView)((VPageSlider)localObject).mHost);
    int j = 0;
    label133:
    VComponent localVComponent;
    if (j < ((VPageSlider)localObject).getChildCount())
    {
      localVComponent = ((VPageSlider)localObject).getChild(j);
      if ((localVComponent instanceof VPage))
      {
        localVComponent = ((VPage)localVComponent).getChild(0);
        if ((localVComponent instanceof VRecyclerList)) {
          if (j == 0) {
            break label206;
          }
        }
      }
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      localVSmartView.addRecyclerView((VRecyclerView)localVComponent.mHost, bool);
      j += 1;
      break label133;
      break;
    }
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