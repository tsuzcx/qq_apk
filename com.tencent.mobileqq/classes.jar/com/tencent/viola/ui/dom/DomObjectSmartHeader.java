package com.tencent.viola.ui.dom;

import org.json.JSONObject;

public class DomObjectSmartHeader
  extends DomObject
{
  public void parseFromJson(JSONObject paramJSONObject)
  {
    super.parseFromJson(paramJSONObject);
    paramJSONObject = getStyle();
    paramJSONObject.put("position", "absolute");
    paramJSONObject.put("left", "0");
    paramJSONObject.put("top", "0");
    paramJSONObject.put("right", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectSmartHeader
 * JD-Core Version:    0.7.0.1
 */