package com.tencent.thumbplayer.tplayer.plugins.report;

import com.tencent.thumbplayer.utils.TPLogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class TPReportParams$UserSeekOnceParams
  implements ITPReportParams
{
  public long endPresentTimeLong;
  public String errCodeString;
  public int formatInt;
  public long seekEndTimeUnix;
  public long seekStartTimeUnix;
  public long startPresentTimeLong;
  
  public TPReportParams$UserSeekOnceParams(TPReportParams paramTPReportParams) {}
  
  public void paramsToJson(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("format", this.formatInt);
      paramJSONObject.put("pstime", this.startPresentTimeLong);
      paramJSONObject.put("petime", this.endPresentTimeLong);
      paramJSONObject.put("lstime", this.seekStartTimeUnix);
      paramJSONObject.put("letime", this.seekEndTimeUnix);
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
    paramITPReportProperties.put("format", this.formatInt);
    paramITPReportProperties.put("pstime", this.startPresentTimeLong);
    paramITPReportProperties.put("petime", this.endPresentTimeLong);
    paramITPReportProperties.put("lstime", this.seekStartTimeUnix);
    paramITPReportProperties.put("letime", this.seekEndTimeUnix);
    paramITPReportProperties.put("code", this.errCodeString);
  }
  
  public void reset()
  {
    this.startPresentTimeLong = 0L;
    this.endPresentTimeLong = 0L;
    this.seekStartTimeUnix = 0L;
    this.seekEndTimeUnix = 0L;
    this.errCodeString = "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams.UserSeekOnceParams
 * JD-Core Version:    0.7.0.1
 */