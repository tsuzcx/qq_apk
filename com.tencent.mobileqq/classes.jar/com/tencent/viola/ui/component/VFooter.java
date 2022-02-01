package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VFooterLayout;
import com.tencent.viola.ui.view.refresh.VRefreshViewGroup;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class VFooter
  extends VComponentContainer<VFooterLayout>
{
  public VFooter(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public void addEvent(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        super.addEvent(paramString);
        return;
        if (paramString.equals("pulling"))
        {
          i = 0;
          continue;
          if (paramString.equals("idle"))
          {
            i = 1;
            continue;
            if (paramString.equals("refresh")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    this.mAppendEvents.add(paramString);
    return;
    this.mAppendEvents.add(paramString);
    return;
    this.mAppendEvents.add(paramString);
  }
  
  public void destroy()
  {
    super.destroy();
    VFooterLayout localVFooterLayout = (VFooterLayout)getHostView();
    if (localVFooterLayout != null) {
      localVFooterLayout.destroy();
    }
  }
  
  public void footerFireEvent(String paramString, JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    if (!this.mAppendEvents.contains(paramString)) {
      return;
    }
    fireEvent(paramString, paramJSONArray, paramJSONObject);
  }
  
  public VFooterLayout initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VFooterLayout(paramContext);
    paramContext.bindComponent(this);
    return paramContext;
  }
  
  @JSMethod(uiThread=true)
  public void refreshFinish()
  {
    if (((getHostView() instanceof VFooterLayout)) && ((((VFooterLayout)getHostView()).getParent() instanceof VRefreshViewGroup))) {
      ((VRefreshViewGroup)((VFooterLayout)getHostView()).getParent()).stopLoadMore();
    }
  }
  
  public boolean resetAttr(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!super.resetAttr(paramString))
    {
      bool1 = bool2;
      if (paramString.equals("refreshStick"))
      {
        setRefreshStick(false);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @VComponentProp(name="refreshStick")
  public void setRefreshStick(boolean paramBoolean)
  {
    ((VFooterLayout)getHostView()).setRefreshStick(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VFooter
 * JD-Core Version:    0.7.0.1
 */