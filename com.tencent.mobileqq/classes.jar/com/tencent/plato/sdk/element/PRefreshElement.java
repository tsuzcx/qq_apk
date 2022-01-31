package com.tencent.plato.sdk.element;

import com.tencent.plato.layout.LayoutEngine;
import com.tencent.plato.sdk.render.PRefreshView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PRefreshElement
  extends PDivElement
{
  public PRefreshElement(LayoutEngine paramLayoutEngine, int paramInt)
  {
    super(paramLayoutEngine, paramInt);
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
    return "refreshcontrol";
  }
  
  public boolean isNotCalculate()
  {
    return true;
  }
  
  @Property("refreshing")
  public void refreshing(Boolean paramBoolean)
  {
    addUIStyle("refreshing", paramBoolean);
  }
  
  public static class Provider
    implements IElement.IProvider<PRefreshElement, PRefreshView>
  {
    public PRefreshElement createElement(LayoutEngine paramLayoutEngine, int paramInt)
    {
      return new PRefreshElement(paramLayoutEngine, paramInt);
    }
    
    public PRefreshView createView()
    {
      return new PRefreshView();
    }
    
    public String getName()
    {
      return "refreshcontrol";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.element.PRefreshElement
 * JD-Core Version:    0.7.0.1
 */