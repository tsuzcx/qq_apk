package com.tencent.mobileqq.datareportviewer;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportData
  implements Serializable
{
  public String actionName;
  public boolean isLightBlueBg;
  public String mainAction;
  public int opType;
  public String r2;
  public String r3;
  public String r4;
  public String r5;
  public int result;
  public String subAction;
  public String table;
  
  public ReportData(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.table = paramString1;
    this.mainAction = paramString2;
    this.subAction = paramString3;
    this.actionName = paramString4;
    this.opType = paramInt1;
    this.result = paramInt2;
    this.r2 = paramString5;
    this.r3 = paramString6;
    this.r4 = paramString7;
    this.r5 = paramString8;
  }
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("table", this.table);
      localJSONObject.put("mainAction", this.mainAction);
      localJSONObject.put("subAction", this.subAction);
      localJSONObject.put("actionName", this.actionName);
      localJSONObject.put("opType", this.opType);
      localJSONObject.put("result", this.result);
      localJSONObject.put("r2", this.r2);
      localJSONObject.put("r3", this.r3);
      localJSONObject.put("r4", this.r4);
      localJSONObject.put("r5", this.r5);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.ReportData
 * JD-Core Version:    0.7.0.1
 */