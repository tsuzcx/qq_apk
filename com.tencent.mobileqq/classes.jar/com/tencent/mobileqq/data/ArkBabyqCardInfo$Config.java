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
    if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
    {
      int i = paramJSONObject.optInt("round", -1);
      if (i != -1) {
        this.round = new Integer(i);
      } else if (paramJSONObject.optBoolean("round")) {
        this.round = new Integer(1);
      }
      i = paramJSONObject.optInt("forward", -1);
      if (i != -1) {
        this.forward = new Integer(i);
      } else if (paramJSONObject.optBoolean("forward")) {
        this.forward = new Integer(1);
      }
      i = paramJSONObject.optInt("autosize", -1);
      if (i != -1) {
        this.autoSize = new Integer(i);
      } else if (paramJSONObject.optBoolean("autosize")) {
        this.autoSize = new Integer(1);
      }
      this.type = paramJSONObject.optString("type", null);
      return true;
    }
    return false;
  }
  
  public boolean fromString(String paramString)
  {
    if (paramString != null) {
      if (paramString.length() == 0) {
        return false;
      }
    }
    try
    {
      boolean bool = fromJson(new JSONObject(paramString));
      return bool;
    }
    catch (Exception paramString) {}
    return false;
    return false;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (this.round != null) {
        localJSONObject2.put("round", this.round.intValue());
      }
      if (this.forward != null) {
        localJSONObject2.put("forward", this.forward.intValue());
      }
      if (this.autoSize != null) {
        localJSONObject2.put("autosize", this.autoSize.intValue());
      }
      localJSONObject1 = localJSONObject2;
      if (this.type == null) {
        break label95;
      }
      localJSONObject2.put("type", this.type);
      return localJSONObject2;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject1;
      label93:
      label95:
      break label93;
    }
    localJSONObject1 = null;
    return localJSONObject1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.ArkBabyqCardInfo.Config
 * JD-Core Version:    0.7.0.1
 */