package com.tencent.viola.ui.dom;

import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import org.json.JSONObject;

public class DomObjectSlider
  extends DomObject
{
  public void parseFromJson(JSONObject paramJSONObject)
  {
    super.parseFromJson(paramJSONObject);
    if (getAttributes().containsKey("cellWidth")) {
      setStyleWidth((int)FlexConvertUtils.converPxByViewportToRealPx(getAttributes().get("cellWidth"), 750));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectSlider
 * JD-Core Version:    0.7.0.1
 */