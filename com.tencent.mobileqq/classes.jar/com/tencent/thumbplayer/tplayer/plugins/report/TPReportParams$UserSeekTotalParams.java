package com.tencent.thumbplayer.tplayer.plugins.report;

import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TPReportParams$UserSeekTotalParams
  implements ITPReportParams
{
  public int seekBufferingCountInt;
  public int seekBufferingDurationInt;
  public List<TPReportParams.UserSeekOnceParams> seekOnceParamsList = new LinkedList();
  public int seekTotalCountInt;
  
  public TPReportParams$UserSeekTotalParams(TPReportParams paramTPReportParams) {}
  
  public void paramsToJson(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("scount", this.seekTotalCountInt);
      paramJSONObject.put("tbcount", this.seekBufferingCountInt);
      paramJSONObject.put("tbduration", this.seekBufferingDurationInt);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.seekOnceParamsList.iterator();
      while (localIterator.hasNext())
      {
        TPReportParams.UserSeekOnceParams localUserSeekOnceParams = (TPReportParams.UserSeekOnceParams)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        localUserSeekOnceParams.paramsToJson(localJSONObject);
        localJSONArray.put(localJSONObject);
      }
      paramJSONObject.put("val", localJSONArray);
    }
    catch (JSONException paramJSONObject)
    {
      TPLogUtil.e("TPReportParams", paramJSONObject);
      return;
    }
  }
  
  public void paramsToProperties(ITPReportProperties paramITPReportProperties)
  {
    paramITPReportProperties.put("scount", this.seekTotalCountInt);
    paramITPReportProperties.put("tbcount", this.seekBufferingCountInt);
    paramITPReportProperties.put("tbduration", this.seekBufferingDurationInt);
  }
  
  public void reset()
  {
    this.seekTotalCountInt = 0;
    this.seekBufferingCountInt = 0;
    this.seekBufferingDurationInt = 0;
    this.seekOnceParamsList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams.UserSeekTotalParams
 * JD-Core Version:    0.7.0.1
 */