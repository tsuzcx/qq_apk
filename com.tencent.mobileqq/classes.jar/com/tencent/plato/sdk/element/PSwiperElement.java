package com.tencent.plato.sdk.element;

import com.tencent.plato.layout.LayoutEngine;
import com.tencent.plato.sdk.render.PSwiperView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PSwiperElement
  extends PDivElement
{
  public PSwiperElement(LayoutEngine paramLayoutEngine, int paramInt)
  {
    super(paramLayoutEngine, paramInt);
  }
  
  @Property("dotColorOff")
  public void dotColorOff(String paramString)
  {
    addUIStyle("dotColorOff", paramString);
  }
  
  @Property("dotColorOn")
  public void dotColorOn(String paramString)
  {
    addUIStyle("dotColorOn", paramString);
  }
  
  @Property("dotSize")
  public void dotSize(String paramString)
  {
    addUIStyle("dotSize", paramString);
  }
  
  public JSONObject dumpNode(JSONObject paramJSONObject)
  {
    paramJSONObject = super.dumpNode(paramJSONObject);
    if (getChildCount() > 0) {}
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < getChildCount())
      {
        localJSONArray.put(getChildAt(i).dumpNode(null));
        i += 1;
      }
      paramJSONObject.put("children", localJSONArray);
      return paramJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramJSONObject;
  }
  
  public String getElementType()
  {
    return "swiper";
  }
  
  public boolean isBlockType()
  {
    return true;
  }
  
  @Property("needDot")
  public void needDot(String paramString)
  {
    addUIStyle("needDot", paramString);
  }
  
  @Property("scrollTime")
  public void scrollTime(String paramString)
  {
    addUIStyle("scrollTime", paramString);
  }
  
  public static class Provider
    implements IElement.IProvider<PSwiperElement, PSwiperView>
  {
    public PSwiperElement createElement(LayoutEngine paramLayoutEngine, int paramInt)
    {
      return new PSwiperElement(paramLayoutEngine, paramInt);
    }
    
    public PSwiperView createView()
    {
      return new PSwiperView();
    }
    
    public String getName()
    {
      return "swiper";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.element.PSwiperElement
 * JD-Core Version:    0.7.0.1
 */