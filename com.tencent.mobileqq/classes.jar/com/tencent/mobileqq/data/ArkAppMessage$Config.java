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
    boolean bool2 = true;
    boolean bool1;
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
    {
      bool1 = false;
      return bool1;
    }
    int i = paramJSONObject.optInt("round", -1);
    if (i != -1)
    {
      this.round = new Integer(i);
      label43:
      i = paramJSONObject.optInt("forward", -1);
      if (i == -1) {
        break label267;
      }
      this.forward = new Integer(i);
      label68:
      i = paramJSONObject.optInt("autosize", -1);
      if (i == -1) {
        break label291;
      }
      this.autoSize = new Integer(i);
      label93:
      this.type = paramJSONObject.optString("type", null);
      if ((paramJSONObject.has("width")) && (paramJSONObject.has("height")))
      {
        this.width = Integer.valueOf(paramJSONObject.optInt("width", -1));
        this.height = Integer.valueOf(paramJSONObject.optInt("height", -1));
      }
      i = paramJSONObject.optInt("showSender", -1);
      if (i == -1) {
        break label315;
      }
      this.showSender = new Integer(i);
    }
    for (;;)
    {
      this.fitWidthAndCentered = Integer.valueOf(paramJSONObject.optInt("fitWidthAndCentered", 0));
      bool1 = bool2;
      if (!paramJSONObject.has("hintWidth")) {
        break;
      }
      bool1 = bool2;
      if (!paramJSONObject.has("hintHeight")) {
        break;
      }
      this.hintWidth = Integer.valueOf(paramJSONObject.optInt("hintWidth", -1));
      this.hintHeight = Integer.valueOf(paramJSONObject.optInt("hintHeight", -1));
      return true;
      if (!paramJSONObject.optBoolean("round")) {
        break label43;
      }
      this.round = new Integer(1);
      break label43;
      label267:
      if (!paramJSONObject.optBoolean("forward")) {
        break label68;
      }
      this.forward = new Integer(1);
      break label68;
      label291:
      if (!paramJSONObject.optBoolean("autosize")) {
        break label93;
      }
      this.autoSize = new Integer(1);
      break label93;
      label315:
      if (paramJSONObject.optBoolean("showSender", true)) {
        this.showSender = new Integer(1);
      } else {
        this.showSender = new Integer(0);
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
      if (this.width != null) {
        localJSONObject.put("width", this.width.intValue());
      }
      if (this.height != null) {
        localJSONObject.put("height", this.height.intValue());
      }
      if (this.showSender != null) {
        localJSONObject.put("showSender", this.showSender.intValue());
      }
      if (this.fitWidthAndCentered != null) {
        localJSONObject.put("fitWidthAndCentered", this.fitWidthAndCentered.intValue());
      }
      if (this.hintWidth != null) {
        localJSONObject.put("hintWidth", this.hintWidth.intValue());
      }
      if (this.hintHeight != null) {
        localJSONObject.put("hintHeight", this.hintHeight.intValue());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ArkAppMessage.Config
 * JD-Core Version:    0.7.0.1
 */