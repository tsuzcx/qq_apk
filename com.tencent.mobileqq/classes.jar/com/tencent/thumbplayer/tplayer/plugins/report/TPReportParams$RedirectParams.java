package com.tencent.thumbplayer.tplayer.plugins.report;

import com.tencent.thumbplayer.utils.TPLogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class TPReportParams$RedirectParams
  implements ITPReportParams
{
  public int cdnTypeInt;
  public long endTimeUnix;
  public String errCodeString;
  public int redirectCountInt;
  public String redirectedUrlString;
  public long starTimeUnix;
  
  public TPReportParams$RedirectParams(TPReportParams paramTPReportParams) {}
  
  public void paramsToJson(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("etime", this.endTimeUnix);
      paramJSONObject.put("url", this.redirectedUrlString);
      paramJSONObject.put("vt", this.cdnTypeInt);
      paramJSONObject.put("t302", this.redirectCountInt);
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
    paramITPReportProperties.put("etime", this.endTimeUnix);
    paramITPReportProperties.put("url", this.redirectedUrlString);
    paramITPReportProperties.put("vt", this.cdnTypeInt);
    paramITPReportProperties.put("t302", this.redirectCountInt);
    paramITPReportProperties.put("code", this.errCodeString);
  }
  
  public void reset()
  {
    this.starTimeUnix = 0L;
    this.endTimeUnix = 0L;
    this.redirectedUrlString = "";
    this.cdnTypeInt = 0;
    this.redirectCountInt = 0;
    this.errCodeString = "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams.RedirectParams
 * JD-Core Version:    0.7.0.1
 */