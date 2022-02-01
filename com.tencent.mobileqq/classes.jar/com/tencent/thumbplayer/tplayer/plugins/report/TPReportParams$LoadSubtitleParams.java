package com.tencent.thumbplayer.tplayer.plugins.report;

import com.tencent.thumbplayer.utils.TPLogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class TPReportParams$LoadSubtitleParams
  implements ITPReportParams
{
  public int bufferingDurationInt;
  public int cdnTypeInt;
  public int cgiUrlIndex;
  public long endTimeUnix;
  public String errCodeString;
  public long starTimeUnix;
  public String subtitleUrlString;
  
  public TPReportParams$LoadSubtitleParams(TPReportParams paramTPReportParams) {}
  
  public void paramsToJson(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("stime", this.starTimeUnix);
      paramJSONObject.put("etime", this.endTimeUnix);
      paramJSONObject.put("bufferduration", this.bufferingDurationInt);
      paramJSONObject.put("url", this.subtitleUrlString);
      paramJSONObject.put("vt", this.cdnTypeInt);
      paramJSONObject.put("urlindex", this.cgiUrlIndex);
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
    paramITPReportProperties.put("bufferduration", this.bufferingDurationInt);
    paramITPReportProperties.put("url", this.subtitleUrlString);
    paramITPReportProperties.put("vt", this.cdnTypeInt);
    paramITPReportProperties.put("urlindex", this.cgiUrlIndex);
    paramITPReportProperties.put("code", this.errCodeString);
  }
  
  public void reset()
  {
    this.starTimeUnix = 0L;
    this.endTimeUnix = 0L;
    this.bufferingDurationInt = 0;
    this.subtitleUrlString = "";
    this.cdnTypeInt = 0;
    this.cgiUrlIndex = 0;
    this.errCodeString = "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams.LoadSubtitleParams
 * JD-Core Version:    0.7.0.1
 */