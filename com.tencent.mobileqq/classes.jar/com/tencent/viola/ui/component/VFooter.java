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
    int i = paramString.hashCode();
    if (i != -226130051)
    {
      if (i != 3227604)
      {
        if ((i == 1085444827) && (paramString.equals("refresh")))
        {
          i = 2;
          break label70;
        }
      }
      else if (paramString.equals("idle"))
      {
        i = 1;
        break label70;
      }
    }
    else if (paramString.equals("pulling"))
    {
      i = 0;
      break label70;
    }
    i = -1;
    label70:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
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
    ((VFooterLayout)getHostView()).setRefreshStick(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VFooter
 * JD-Core Version:    0.7.0.1
 */