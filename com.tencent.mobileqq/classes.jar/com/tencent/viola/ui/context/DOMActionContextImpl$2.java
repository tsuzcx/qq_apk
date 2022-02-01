package com.tencent.viola.ui.context;

import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObject.Consumer;
import com.tencent.viola.ui.dom.style.FlexLayout;
import com.tencent.viola.ui.dom.style.FlexStyle;
import com.tencent.viola.ui.dom.style.Layout;
import com.tencent.viola.ui.dom.style.StyleSpace;

class DOMActionContextImpl$2
  implements DomObject.Consumer
{
  DOMActionContextImpl$2(DOMActionContextImpl paramDOMActionContextImpl) {}
  
  public void accept(DomObject paramDomObject)
  {
    if (paramDomObject.hasUpdate())
    {
      if (DOMActionContextImpl.access$300(this.this$0)) {
        return;
      }
      if (!Float.isNaN(paramDomObject.flexStyle.minHeight)) {
        synchronized (DomObject.LOCK)
        {
          if (paramDomObject.flexStyle.minHeight <= paramDomObject.flexLayout.dimensions[1])
          {
            paramDomObject.flexStyle.dimensions[1] = paramDomObject.flexStyle.minHeight;
            float[] arrayOfFloat;
            if (paramDomObject.flexStyle.margin.get(1) > 0.0F)
            {
              arrayOfFloat = paramDomObject.flexLayout.position;
              arrayOfFloat[1] -= paramDomObject.flexStyle.margin.get(1);
            }
            if (paramDomObject.flexStyle.margin.get(0) > 0.0F)
            {
              arrayOfFloat = paramDomObject.flexLayout.position;
              arrayOfFloat[0] -= paramDomObject.flexStyle.margin.get(0);
            }
            if (paramDomObject.flexStyle.margin.get(2) > 0.0F)
            {
              arrayOfFloat = paramDomObject.flexLayout.position;
              arrayOfFloat[2] -= paramDomObject.flexStyle.margin.get(2);
            }
            if (paramDomObject.flexStyle.margin.get(3) > 0.0F)
            {
              arrayOfFloat = paramDomObject.flexLayout.position;
              arrayOfFloat[3] -= paramDomObject.flexStyle.margin.get(3);
            }
            Layout.layoutNode(DOMActionContextImpl.access$400(this.this$0), paramDomObject, paramDomObject.flexLayout.dimensions[0], null);
          }
        }
      }
      paramDomObject.layoutAfter();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.context.DOMActionContextImpl.2
 * JD-Core Version:    0.7.0.1
 */