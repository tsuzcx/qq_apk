package com.tencent.plato.sdk.element;

import com.tencent.plato.layout.LayoutEngine;
import com.tencent.plato.sdk.render.PCanvasView;

public class PCanvasElement
  extends PElement
{
  public PCanvasElement(LayoutEngine paramLayoutEngine, int paramInt)
  {
    super(paramLayoutEngine, paramInt);
  }
  
  public String getElementType()
  {
    return "canvas";
  }
  
  public static class Provider
    implements IElement.IProvider<PCanvasElement, PCanvasView>
  {
    public PCanvasElement createElement(LayoutEngine paramLayoutEngine, int paramInt)
    {
      return new PCanvasElement(paramLayoutEngine, paramInt);
    }
    
    public PCanvasView createView()
    {
      return new PCanvasView();
    }
    
    public String getName()
    {
      return "canvas";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.element.PCanvasElement
 * JD-Core Version:    0.7.0.1
 */