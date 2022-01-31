package com.tencent.mobileqq.soload.config;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONObject;

public class SoConfig$SoDetailInfo
  implements Serializable
{
  public String md5;
  public String url;
  public String ver;
  
  public static SoDetailInfo create(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {}
    String str;
    do
    {
      return null;
      str = paramJSONObject.optString("url");
      paramJSONObject = paramJSONObject.optString("md5");
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramJSONObject)));
    SoDetailInfo localSoDetailInfo = new SoDetailInfo();
    localSoDetailInfo.md5 = paramJSONObject;
    localSoDetailInfo.url = str;
    localSoDetailInfo.ver = paramString;
    return localSoDetailInfo;
  }
  
  public String toString()
  {
    return "SDInfo{url='" + this.url + '\'' + ", md5='" + this.md5 + '\'' + ", v='" + this.ver + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo
 * JD-Core Version:    0.7.0.1
 */