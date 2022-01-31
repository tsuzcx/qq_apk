package com.tencent.mobileqq.data;

import org.json.JSONObject;

public class ArkBabyqCardInfo$Config
{
  public Integer autoSize;
  public Integer forward;
  public Integer round;
  public String type;
  
  public boolean fromJson(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      return false;
    }
    int i = paramJSONObject.optInt("round", -1);
    if (i != -1)
    {
      this.round = new Integer(i);
      i = paramJSONObject.optInt("forward", -1);
      if (i == -1) {
        break label125;
      }
      this.forward = new Integer(i);
      label63:
      i = paramJSONObject.optInt("autosize", -1);
      if (i == -1) {
        break label149;
      }
      this.autoSize = new Integer(i);
    }
    for (;;)
    {
      this.type = paramJSONObject.optString("type", null);
      return true;
      if (!paramJSONObject.optBoolean("round")) {
        break;
      }
      this.round = new Integer(1);
      break;
      label125:
      if (!paramJSONObject.optBoolean("forward")) {
        break label63;
      }
      this.forward = new Integer(1);
      break label63;
      label149:
      if (paramJSONObject.optBoolean("autosize")) {
        this.autoSize = new Integer(1);
      }
    }
  }
  
  public boolean fromString(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    try
    {
      boolean bool = fromJson(new JSONObject(paramString));
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.round != null) {
        localJSONObject.put("round", this.round.intValue());
      }
      if (this.forward != null) {
        localJSONObject.put("forward", this.forward.intValue());
      }
      if (this.autoSize != null) {
        localJSONObject.put("autosize", this.autoSize.intValue());
      }
      if (this.type != null) {
        localJSONObject.put("type", this.type);
      }
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String toString()
  {
    JSONObject localJSONObject = toJson();
    if (localJSONObject == null) {
      return null;
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.data.ArkBabyqCardInfo.Config
 * JD-Core Version:    0.7.0.1
 */