package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Layout;
import com.tencent.viola.annotation.VComponentField;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObjectText;
import com.tencent.viola.ui.dom.style.StyleSpace;
import com.tencent.viola.ui.view.VTextView;

public class VText
  extends VComponent<VTextView>
{
  @VComponentField(nativeReturnMethod="getVisibility", propertyName="visibility")
  private String mVisibility;
  
  public VText(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public VTextView initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VTextView(paramContext);
    paramContext.bindComponent(this);
    return paramContext;
  }
  
  public void resetComponent()
  {
    if ((getHostView() != null) && (((VTextView)getHostView()).mIsRich)) {
      ((VTextView)getHostView()).setText("");
    }
  }
  
  public boolean resetStyle(String paramString)
  {
    int i;
    if (!super.resetStyle(paramString))
    {
      i = -1;
      switch (paramString.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return false;
        if (paramString.equals("value"))
        {
          i = 0;
          continue;
          if (paramString.equals("values")) {
            i = 1;
          }
        }
        break;
      }
    }
    if (this.mHost != null) {
      ((VTextView)this.mHost).setText("");
    }
    return true;
  }
  
  public void updateExtra(Object paramObject)
  {
    if ((paramObject instanceof Layout))
    {
      Layout localLayout = (Layout)paramObject;
      if ((getHostView() != null) && (!paramObject.equals(((VTextView)getHostView()).getTextLayout())))
      {
        ((VTextView)getHostView()).setRichText(((DomObjectText)this.mDomObj).isRichText(), ((DomObjectText)this.mDomObj).getLineSpace());
        paramObject = this.mDomObj.getPadding();
        ((VTextView)getHostView()).setTextLayout(localLayout, paramObject.get(0), paramObject.get(1));
        ((VTextView)getHostView()).invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.component.VText
 * JD-Core Version:    0.7.0.1
 */