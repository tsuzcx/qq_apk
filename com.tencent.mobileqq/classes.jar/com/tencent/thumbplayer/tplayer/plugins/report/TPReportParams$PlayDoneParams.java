package com.tencent.thumbplayer.tplayer.plugins.report;

import com.tencent.thumbplayer.utils.TPLogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class TPReportParams$PlayDoneParams
  implements ITPReportParams
{
  public long endTimeUnix;
  public String errCodeString;
  public float playDurationFloat;
  public int reasonInt;
  
  public TPReportParams$PlayDoneParams(TPReportParams paramTPReportParams) {}
  
  public void paramsToJson(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("reason", this.reasonInt);
      paramJSONObject.put("etime", this.endTimeUnix);
      paramJSONObject.put("playduration", this.playDurationFloat);
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
    paramITPReportProperties.put("reason", this.reasonInt);
    paramITPReportProperties.put("etime", this.endTimeUnix);
    paramITPReportProperties.put("playduration", this.playDurationFloat);
    paramITPReportProperties.put("code", this.errCodeString);
  }
  
  public void reset()
  {
    this.reasonInt = 0;
    this.endTimeUnix = 0L;
    this.playDurationFloat = 0.0F;
    this.errCodeString = "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams.PlayDoneParams
 * JD-Core Version:    0.7.0.1
 */