package com.tencent.plato.sdk.element;

import com.tencent.plato.layout.LayoutEngine;
import com.tencent.plato.sdk.render.PListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PListElement
  extends PDivElement
{
  private PListElement(LayoutEngine paramLayoutEngine, int paramInt)
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
    return "list";
  }
  
  public boolean isBlockType()
  {
    return true;
  }
  
  public static class Provider
    implements IElement.IProvider<PListElement, PListView>
  {
    public PListElement createElement(LayoutEngine paramLayoutEngine, int paramInt)
    {
      return new PListElement(paramLayoutEngine, paramInt, null);
    }
    
    public PListView createView()
    {
      return new PListView();
    }
    
    public String getName()
    {
      return "list";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.element.PListElement
 * JD-Core Version:    0.7.0.1
 */