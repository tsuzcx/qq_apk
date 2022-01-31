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
  
  public String getClickEvent()
  {
    return PTSValueConvertUtil.getString(get("bindtap"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeAttribute
 * JD-Core Version:    0.7.0.1
 */