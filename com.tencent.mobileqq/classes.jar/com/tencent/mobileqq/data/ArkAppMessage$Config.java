package com.tencent.mobileqq.data;

import org.json.JSONObject;

public class ArkAppMessage$Config
{
  public Integer autoSize;
  public Integer fitWidthAndCentered;
  public Integer forward;
  public Integer height;
  public Integer hintHeight;
  public Integer hintWidth;
  public Integer round;
  public Integer showSender;
  public String type;
  public Integer width;
  
  public boolean fromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramJSONObject.length() == 0) {
        return false;
      }
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
      if ((paramJSONObject.has("width")) && (paramJSONObject.has("height")))
      {
        this.width = Integer.valueOf(paramJSONObject.optInt("width", -1));
        this.height = Integer.valueOf(paramJSONObject.optInt("height", -1));
      }
      i = paramJSONObject.optInt("showSender", -1);
      if (i != -1) {
        this.showSender = new Integer(i);
      } else if (paramJSONObject.optBoolean("showSender", true)) {
        this.showSender = new Integer(1);
      } else {
        this.showSender = new Integer(0);
      }
      this.fitWidthAndCentered = Integer.valueOf(paramJSONObject.optInt("fitWidthAndCentered", 0));
      if ((paramJSONObject.has("hintWidth")) && (paramJSONObject.has("hintHeight")))
      {
        this.hintWidth = Integer.valueOf(paramJSONObject.optInt("hintWidth", -1));
        this.hintHeight = Integer.valueOf(paramJSONObject.optInt("hintHeight", -1));
      }
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
      if (this.type != null) {
        localJSONObject2.put("type", this.type);
      }
      if (this.width != null) {
        localJSONObject2.put("width", this.width.intValue());
      }
      if (this.height != null) {
        localJSONObject2.put("height", this.height.intValue());
      }
      if (this.showSender != null) {
        localJSONObject2.put("showSender", this.showSender.intValue());
      }
      if (this.fitWidthAndCentered != null) {
        localJSONObject2.put("fitWidthAndCentered", this.fitWidthAndCentered.intValue());
      }
      if (this.hintWidth != null) {
        localJSONObject2.put("hintWidth", this.hintWidth.intValue());
      }
      localJSONObject1 = localJSONObject2;
      if (this.hintHeight == null) {
        break label221;
      }
      localJSONObject2.put("hintHeight", this.hintHeight.intValue());
      return localJSONObject2;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject1;
      label219:
      label221:
      break label219;
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
 * Qualified Name:     com.tencent.mobileqq.data.ArkAppMessage.Config
 * JD-Core Version:    0.7.0.1
 */