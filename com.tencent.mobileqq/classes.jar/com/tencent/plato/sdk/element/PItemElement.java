package com.tencent.plato.sdk.element;

import com.tencent.plato.layout.LayoutEngine;
import com.tencent.plato.sdk.render.PDivView;
import org.json.JSONObject;

public class PItemElement
  extends PElement
{
  private PItemElement(LayoutEngine paramLayoutEngine, int paramInt)
  {
    super(paramLayoutEngine, paramInt);
  }
  
  public JSONObject dumpNode(JSONObject paramJSONObject)
  {
    return super.dumpNode(paramJSONObject);
  }
  
  public String getElementType()
  {
    return "item";
  }
  
  @Property("reuseid")
  public void reuseid(String paramString)
  {
    addUIStyle("reuseid", paramString);
  }
  
  public static class Provider
    implements IElement.IProvider<PItemElement, PDivView>
  {
    public PItemElement createElement(LayoutEngine paramLayoutEngine, int paramInt)
    {
      return new PItemElement(paramLayoutEngine, paramInt, null);
    }
    
    public PDivView createView()
    {
      return new PDivView();
    }
    
    public String getName()
    {
      return "item";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.element.PItemElement
 * JD-Core Version:    0.7.0.1
 */