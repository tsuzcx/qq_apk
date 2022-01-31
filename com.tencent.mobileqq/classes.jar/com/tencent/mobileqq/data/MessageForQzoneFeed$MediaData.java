package com.tencent.mobileqq.data;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class MessageForQzoneFeed$MediaData
{
  public Map<String, String> extendInfo;
  public String strImgUrl;
  public int uType;
  
  public static MediaData createFromJson(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    MediaData localMediaData = new MediaData();
    paramString = new JSONObject(paramString);
    localMediaData.strImgUrl = paramString.optString("strImgUrl");
    localMediaData.uType = paramString.optInt("uType");
    paramString = paramString.optString("extendInfo");
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      localMediaData.extendInfo = new HashMap();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localMediaData.extendInfo.put(str, paramString.optString(str));
      }
    }
    return localMediaData;
  }
  
  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("strImgUrl", this.strImgUrl);
    localJSONObject.put("uType", this.uType);
    if ((this.extendInfo != null) && (!this.extendInfo.isEmpty())) {
      localJSONObject.put("extendInfo", new JSONObject(this.extendInfo).toString());
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQzoneFeed.MediaData
 * JD-Core Version:    0.7.0.1
 */