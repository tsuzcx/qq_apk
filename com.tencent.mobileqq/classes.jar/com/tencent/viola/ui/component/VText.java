package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.view.MotionEvent;
import com.tencent.viola.annotation.VComponentField;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObjectText;
import com.tencent.viola.ui.dom.ImageSpanLoadListener;
import com.tencent.viola.ui.dom.style.StyleSpace;
import com.tencent.viola.ui.view.VTextView;
import com.tencent.viola.utils.ViolaUtils;

public class VText
  extends VComponent<VTextView>
  implements ImageSpanLoadListener
{
  public static final String RICH_TEXT_DETECT_ENABLE = "detectRichText";
  @VComponentField(nativeReturnMethod="getVisibility", propertyName="visibility")
  private String mVisibility;
  
  public VText(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void tryDetectRichTextClick(String paramString, MotionEvent paramMotionEvent)
  {
    if ((this.mDomObj.getAttributes().containsKey("detectRichText")) && (ViolaUtils.getBoolean(this.mDomObj.getAttributes().get("detectRichText")))) {
      return;
    }
    if ((this.mDomObj instanceof DomObjectText))
    {
      if (!((DomObjectText)this.mDomObj).isRichText()) {
        return;
      }
      if (!"click".equals(paramString)) {
        return;
      }
      paramString = (VTextView)getHostView();
      if (paramString == null) {
        return;
      }
      paramString.onTouchEvent(paramMotionEvent);
    }
  }
  
  protected void fireClickAction(String paramString, MotionEvent paramMotionEvent)
  {
    tryDetectRichTextClick(paramString, paramMotionEvent);
    super.fireClickAction(paramString, paramMotionEvent);
  }
  
  public VTextView initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VTextView(paramContext);
    paramContext.bindComponent(this);
    if ((this.mDomObj instanceof DomObjectText)) {
      ((DomObjectText)this.mDomObj).setImageSpanLoadListener(this);
    }
    return paramContext;
  }
  
  public void onLoadFinish(boolean paramBoolean)
  {
    if (getHostView() != null) {
      ((VTextView)getHostView()).postInvalidate();
    }
  }
  
  public void resetComponent()
  {
    if ((getHostView() != null) && (((VTextView)getHostView()).mIsRich)) {
      ((VTextView)getHostView()).setText("");
    }
  }
  
  protected boolean resetStyle(String paramString)
  {
    if (!super.resetStyle(paramString))
    {
      int i = -1;
      int j = paramString.hashCode();
      if (j != -823812830)
      {
        if ((j == 111972721) && (paramString.equals("value"))) {
          i = 0;
        }
      }
      else if (paramString.equals("values")) {
        i = 1;
      }
      if ((i != 0) && (i != 1)) {
        return false;
      }
      if (this.mHost != null) {
        ((VTextView)this.mHost).setText("");
      }
      return true;
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VText
 * JD-Core Version:    0.7.0.1
 */