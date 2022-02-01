package com.tencent.mobileqq.qcircle.api.hybird;

import org.json.JSONObject;

public class QCircleJsPlugin$SafeJsonObject
  extends JSONObject
{
  public QCircleJsPlugin$SafeJsonObject(QCircleJsPlugin paramQCircleJsPlugin, String paramString)
  {
    super(paramString);
  }
  
  public int getInt(String paramString)
  {
    if (!has(paramString)) {
      return 0;
    }
    return super.getInt(paramString);
  }
  
  public String getString(String paramString)
  {
    if (!has(paramString)) {
      return "";
    }
    return super.getString(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.hybird.QCircleJsPlugin.SafeJsonObject
 * JD-Core Version:    0.7.0.1
 */