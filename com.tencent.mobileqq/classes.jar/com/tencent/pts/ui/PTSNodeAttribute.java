package com.tencent.pts.ui;

import com.tencent.pts.utils.PTSStrToObjMap;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.util.Map;
import org.json.JSONObject;

public class PTSNodeAttribute
  extends PTSStrToObjMap
{
  public PTSNodeAttribute() {}
  
  public PTSNodeAttribute(Map<String, Object> paramMap)
  {
    super(paramMap);
  }
  
  public PTSNodeAttribute(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public String getAttributeID()
  {
    return PTSValueConvertUtil.getString(get("id"));
  }
  
  public String getEventBindTap()
  {
    return PTSValueConvertUtil.getString(get("bindtap"));
  }
  
  public String getEventPtsOnExposure()
  {
    return PTSValueConvertUtil.getString(get("pts:on-exposure"));
  }
  
  public String getEventPtsOnTap()
  {
    return PTSValueConvertUtil.getString(get("pts:on-tap"));
  }
  
  public String getImageURL()
  {
    return PTSValueConvertUtil.getString(get("src"));
  }
  
  public String getPTSCellType()
  {
    return PTSValueConvertUtil.getString(get("pts:cell-type"));
  }
  
  public String getViewID()
  {
    return PTSValueConvertUtil.getString(get("viewID"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeAttribute
 * JD-Core Version:    0.7.0.1
 */