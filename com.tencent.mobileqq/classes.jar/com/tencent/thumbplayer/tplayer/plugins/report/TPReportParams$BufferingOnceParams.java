package com.tencent.thumbplayer.tplayer.plugins.report;

import com.tencent.thumbplayer.utils.TPLogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class TPReportParams$BufferingOnceParams
  implements ITPReportParams
{
  public long bufferingPresentTimeLong;
  public long endTimeUnix;
  public String errCodeString;
  public int formatInt;
  public int lastEventInt;
  public int reasonInt;
  public int sceneInt;
  public long starTimeUnix;
  public String urlString;
  
  public TPReportParams$BufferingOnceParams(TPReportParams paramTPReportParams) {}
  
  public void paramsToJson(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("scene", this.sceneInt);
      paramJSONObject.put("levent", this.lastEventInt);
      paramJSONObject.put("reason", this.reasonInt);
      paramJSONObject.put("format", this.formatInt);
      paramJSONObject.put("ptime", this.bufferingPresentTimeLong);
      paramJSONObject.put("stime", this.starTimeUnix);
      paramJSONObject.put("etime", this.endTimeUnix);
      paramJSONObject.put("url", this.urlString);
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
    paramITPReportProperties.put("scene", this.sceneInt);
    paramITPReportProperties.put("levent", this.lastEventInt);
    paramITPReportProperties.put("reason", this.reasonInt);
    paramITPReportProperties.put("format", this.formatInt);
    paramITPReportProperties.put("ptime", this.bufferingPresentTimeLong);
    paramITPReportProperties.put("stime", this.starTimeUnix);
    paramITPReportProperties.put("etime", this.endTimeUnix);
    paramITPReportProperties.put("url", this.urlString);
    paramITPReportProperties.put("code", this.errCodeString);
  }
  
  public void reset()
  {
    this.sceneInt = 1;
    this.lastEventInt = 0;
    this.reasonInt = 1400100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams.BufferingOnceParams
 * JD-Core Version:    0.7.0.1
 */