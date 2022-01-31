package com.tencent.plato.sdk.element;

import com.tencent.plato.layout.LayoutEngine;
import com.tencent.plato.sdk.render.PScrollView;

public class PScrollElement
  extends PDivElement
{
  private boolean horizonotal = false;
  private boolean refresingData = false;
  
  private PScrollElement(LayoutEngine paramLayoutEngine, int paramInt)
  {
    super(paramLayoutEngine, paramInt);
  }
  
  public String getElementType()
  {
    return "scrollview";
  }
  
  @Property("horizontal")
  public void horizontal(String paramString)
  {
    if (paramString.equals("true")) {}
    for (this.horizonotal = true;; this.horizonotal = false)
    {
      addUIStyle("horizontal", this.horizonotal);
      return;
    }
  }
  
  @Property("refresingData")
  public void refresingData(String paramString)
  {
    if (paramString.equals("true")) {}
    for (this.refresingData = true;; this.refresingData = false)
    {
      addUIStyle("refresingData", this.refresingData);
      return;
    }
  }
  
  public static class Provider
    implements IElement.IProvider<PScrollElement, PScrollView>
  {
    public PScrollElement createElement(LayoutEngine paramLayoutEngine, int paramInt)
    {
      return new PScrollElement(paramLayoutEngine, paramInt, null);
    }
    
    public PScrollView createView()
    {
      return new PScrollView();
    }
    
    public String getName()
    {
      return "scrollview";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.element.PScrollElement
 * JD-Core Version:    0.7.0.1
 */