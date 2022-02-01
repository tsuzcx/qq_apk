package com.tencent.thumbplayer.tplayer.plugins.report;

import com.tencent.thumbplayer.utils.TPLogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class TPReportParams$PlayerInitParams
  implements ITPReportParams
{
  public String errCodeString;
  public long playEndTimeUnix;
  public long playStarTimeUnix;
  
  public TPReportParams$PlayerInitParams(TPReportParams paramTPReportParams) {}
  
  public void paramsToJson(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("stime", this.playStarTimeUnix);
      paramJSONObject.put("etime", this.playEndTimeUnix);
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
    paramITPReportProperties.put("stime", this.playStarTimeUnix);
    paramITPReportProperties.put("etime", this.playEndTimeUnix);
    paramITPReportProperties.put("code", this.errCodeString);
  }
  
  public void reset()
  {
    this.playStarTimeUnix = 0L;
    this.playEndTimeUnix = 0L;
    this.errCodeString = "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams.PlayerInitParams
 * JD-Core Version:    0.7.0.1
 */