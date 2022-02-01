package com.tencent.viola.ui.component;

import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;

public class VGif
  extends VImage
{
  public VGif(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public boolean isVGif()
  {
    return true;
  }
  
  public void setRemoteSrc(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.setRemoteSrc(paramString, paramBoolean1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.component.VGif
 * JD-Core Version:    0.7.0.1
 */