package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.ui.view.refresh.VRefreshViewGroup;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class VRefresh
  extends VComponentContainer<VRefreshLayout>
{
  public VRefresh(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public void addEvent(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1085444827: 
      if (paramString.equals("refresh")) {
        i = 4;
      }
      break;
    case 3227604: 
      if (paramString.equals("idle")) {
        i = 3;
      }
      break;
    case -177721437: 
      if (paramString.equals("disappear")) {
        i = 1;
      }
      break;
    case -226130051: 
      if (paramString.equals("pulling")) {
        i = 2;
      }
      break;
    case -1411068523: 
      if (paramString.equals("appear")) {
        i = 0;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              super.addEvent(paramString);
              return;
            }
            this.mAppendEvents.add(paramString);
            return;
          }
          this.mAppendEvents.add(paramString);
          return;
        }
        this.mAppendEvents.add(paramString);
        return;
      }
      this.mAppendEvents.add(paramString);
      return;
    }
    this.mAppendEvents.add(paramString);
  }
  
  public void destroy()
  {
    super.destroy();
    if (getHostView() != null) {
      ((VRefreshLayout)getHostView()).destroy();
    }
  }
  
  public VRefreshLayout initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VRefreshLayout(paramContext);
    paramContext.bindComponent(this);
    return paramContext;
  }
  
  @JSMethod(uiThread=true)
  public void refresh()
  {
    if (((getHostView() instanceof VRefreshLayout)) && ((((VRefreshLayout)getHostView()).getParent() instanceof VRefreshViewGroup))) {
      ((VRefreshViewGroup)((VRefreshLayout)getHostView()).getParent()).scrollerToTop(true, false);
    }
  }
  
  @JSMethod(uiThread=true)
  public void refreshFinish(Object paramObject)
  {
    if (((getHostView() instanceof VRefreshLayout)) && ((((VRefreshLayout)getHostView()).getParent() instanceof VRefreshViewGroup)))
    {
      ((VRefreshViewGroup)((VRefreshLayout)getHostView()).getParent()).stopRefresh();
      ViolaLogUtils.d("VComponent", "refreshFinish :下拉刷新回调成功");
    }
  }
  
  public void refreshFireEvent(String paramString, JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    if (!this.mAppendEvents.contains(paramString)) {
      return;
    }
    fireEvent(paramString, paramJSONArray, paramJSONObject);
  }
  
  protected boolean resetAttr(String paramString)
  {
    if ((!super.resetAttr(paramString)) && (paramString.equals("refreshStick")))
    {
      setRefreshStick(false);
      return true;
    }
    return false;
  }
  
  @VComponentProp(name="refreshStick")
  public void setRefreshStick(boolean paramBoolean)
  {
    ((VRefreshLayout)getHostView()).setRefreshStick(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VRefresh
 * JD-Core Version:    0.7.0.1
 */