package com.tencent.mobileqq.soload.config;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONObject;

public class SoConfig$SoDetailInfo
  implements Serializable
{
  public long crc = -1L;
  public String md5;
  public String url;
  public String ver;
  
  public static SoDetailInfo create(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {}
    String str1;
    String str2;
    do
    {
      return null;
      str1 = paramJSONObject.optString("url");
      str2 = paramJSONObject.optString("md5");
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)));
    long l = paramJSONObject.optLong("so_crc", -1L);
    paramJSONObject = new SoDetailInfo();
    paramJSONObject.md5 = str2;
    paramJSONObject.url = str1;
    paramJSONObject.ver = paramString;
    paramJSONObject.crc = l;
    return paramJSONObject;
  }
  
  public String toString()
  {
    return "SDInfo{url='" + this.url + '\'' + ", md5='" + this.md5 + '\'' + ", v='" + this.ver + '\'' + ", c='" + this.crc + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo
 * JD-Core Version:    0.7.0.1
 */