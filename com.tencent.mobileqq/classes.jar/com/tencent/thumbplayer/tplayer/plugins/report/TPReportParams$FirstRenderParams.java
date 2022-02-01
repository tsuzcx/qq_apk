package com.tencent.thumbplayer.tplayer.plugins.report;

import com.tencent.thumbplayer.utils.TPLogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class TPReportParams$FirstRenderParams
  implements ITPReportParams
{
  public long endTimeUnix;
  public String errCodeString;
  public long starTimeUnix;
  
  public TPReportParams$FirstRenderParams(TPReportParams paramTPReportParams) {}
  
  public void paramsToJson(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("stime", this.starTimeUnix);
      paramJSONObject.put("etime", this.endTimeUnix);
      paramJSONObject.put("code", this.errCodeString);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      TPLogUtil.e("TPReportParams", paramJSONObject);
    }
  }
  
  public void paramsToProperties(ITPReportProperties paramITPReportProperties)
  {
    paramITPReportProperties.put("stime", this.starTimeUnix);
    paramITPReportProperties.put("etime", this.endTimeUnix);
    paramITPReportProperties.put("code", this.errCodeString);
  }
  
  public void reset()
  {
    this.starTimeUnix = 0L;
    this.endTimeUnix = 0L;
    this.errCodeString = "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams.FirstRenderParams
 * JD-Core Version:    0.7.0.1
 */