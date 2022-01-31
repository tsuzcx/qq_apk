package com.tencent.viola.ui.dom;

import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.dom.style.FlexPositionType;
import org.json.JSONObject;

public class DomObjectModal
  extends DomObject
{
  public DomObjectModal()
  {
    setStyleHeight(FlexConvertUtils.getScreenHeight());
    setStyleWidth(FlexConvertUtils.getScreenWidth());
    setPositionType(FlexPositionType.ABSOLUTE);
    setPositionLeft(0.0F);
    setPositionTop(0.0F);
  }
  
  public void parseFromJson(JSONObject paramJSONObject)
  {
    super.parseFromJson(paramJSONObject);
    if ((getAttributes().containsKey("autoLayout")) && (((Boolean)getAttributes().get("autoLayout")).booleanValue())) {
      setStyleHeight(FlexConvertUtils.getScreenContentHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectModal
 * JD-Core Version:    0.7.0.1
 */