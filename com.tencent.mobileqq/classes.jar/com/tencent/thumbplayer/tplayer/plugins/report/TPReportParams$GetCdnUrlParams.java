package com.tencent.thumbplayer.tplayer.plugins.report;

import com.tencent.thumbplayer.utils.TPLogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class TPReportParams$GetCdnUrlParams
  implements ITPReportParams
{
  public long endTimeUnix;
  public String errCodeString;
  public String proxyIpString;
  public long starTimeUnix;
  
  public TPReportParams$GetCdnUrlParams(TPReportParams paramTPReportParams) {}
  
  public void paramsToJson(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("stime", this.starTimeUnix);
      paramJSONObject.put("etime", this.endTimeUnix);
      paramJSONObject.put("ip", this.proxyIpString);
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
    paramITPReportProperties.put("ip", this.proxyIpString);
    paramITPReportProperties.put("code", this.errCodeString);
  }
  
  public void reset()
  {
    this.starTimeUnix = 0L;
    this.endTimeUnix = 0L;
    this.proxyIpString = "";
    this.errCodeString = "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams.GetCdnUrlParams
 * JD-Core Version:    0.7.0.1
 */