package com.tencent.thumbplayer.tplayer.plugins.report;

import com.tencent.thumbplayer.utils.TPLogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class TPReportParams$FirstLoadParams
  implements ITPReportParams
{
  public String cdnUrlString;
  public int cgiUrlIndex;
  public long endTimeUnix;
  public String errCodeString;
  public long firstOpenTimeUnix;
  public long firstPacketReadTimeUnix;
  public long starTimeUnix;
  
  public TPReportParams$FirstLoadParams(TPReportParams paramTPReportParams) {}
  
  public void paramsToJson(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("stime", this.starTimeUnix);
      paramJSONObject.put("etime", this.endTimeUnix);
      paramJSONObject.put("fileopenedtime", this.firstOpenTimeUnix);
      paramJSONObject.put("firstpacketreadtime", this.firstPacketReadTimeUnix);
      paramJSONObject.put("url", this.cdnUrlString);
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
    paramITPReportProperties.put("fileopenedtime", this.firstOpenTimeUnix);
    paramITPReportProperties.put("firstpacketreadtime", this.firstPacketReadTimeUnix);
    paramITPReportProperties.put("url", this.cdnUrlString);
    paramITPReportProperties.put("urlindex", this.cgiUrlIndex);
    paramITPReportProperties.put("code", this.errCodeString);
  }
  
  public void reset()
  {
    this.starTimeUnix = 0L;
    this.firstOpenTimeUnix = 0L;
    this.firstPacketReadTimeUnix = 0L;
    this.endTimeUnix = 0L;
    this.cdnUrlString = "";
    this.cgiUrlIndex = 0;
    this.errCodeString = "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams.FirstLoadParams
 * JD-Core Version:    0.7.0.1
 */