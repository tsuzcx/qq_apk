package com.tencent.thumbplayer.tplayer.plugins.report;

import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TPReportParams$BufferingTotalParams
  implements ITPReportParams
{
  public int bufferingCountInt;
  public int bufferingDurationInt;
  public List<TPReportParams.BufferingOnceParams> bufferingOnceParamsList = new LinkedList();
  
  public TPReportParams$BufferingTotalParams(TPReportParams paramTPReportParams) {}
  
  public void paramsToJson(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("bcount", this.bufferingCountInt);
      paramJSONObject.put("tduration", this.bufferingDurationInt);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.bufferingOnceParamsList.iterator();
      while (localIterator.hasNext())
      {
        TPReportParams.BufferingOnceParams localBufferingOnceParams = (TPReportParams.BufferingOnceParams)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        localBufferingOnceParams.paramsToJson(localJSONObject);
        localJSONArray.put(localJSONObject);
      }
      paramJSONObject.put("val", localJSONArray);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      TPLogUtil.e("TPReportParams", paramJSONObject);
    }
  }
  
  public void paramsToProperties(ITPReportProperties paramITPReportProperties)
  {
    paramITPReportProperties.put("bcount", this.bufferingCountInt);
    paramITPReportProperties.put("tduration", this.bufferingDurationInt);
  }
  
  public void reset()
  {
    this.bufferingCountInt = 0;
    this.bufferingDurationInt = 0;
    this.bufferingOnceParamsList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams.BufferingTotalParams
 * JD-Core Version:    0.7.0.1
 */