package com.tencent.mobileqq.data;

import android.text.TextUtils;
import org.json.JSONObject;

public class MessageForQCircleFeed$MediaData
{
  public String mediaUrl;
  public int type;
  
  public static MediaData createFromJson(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    MediaData localMediaData = new MediaData();
    paramString = new JSONObject(paramString);
    localMediaData.mediaUrl = paramString.optString("mediaUrl");
    localMediaData.type = paramString.optInt("type");
    return localMediaData;
  }
  
  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("mediaUrl", this.mediaUrl);
    localJSONObject.put("type", this.type);
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQCircleFeed.MediaData
 * JD-Core Version:    0.7.0.1
 */