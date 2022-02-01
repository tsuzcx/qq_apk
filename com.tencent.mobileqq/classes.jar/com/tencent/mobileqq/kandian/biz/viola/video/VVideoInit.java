package com.tencent.mobileqq.kandian.biz.viola.video;

import org.json.JSONException;
import org.json.JSONObject;

public class VVideoInit
{
  public static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("muted", false);
      localJSONObject.put("autoplay", true);
      localJSONObject.put("resize", "contain");
      localJSONObject.put("controlType", 0);
      localJSONObject.put("timeupdateRate", 1000);
      localJSONObject.put("disableFullScreen", false);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.video.VVideoInit
 * JD-Core Version:    0.7.0.1
 */