package com.tencent.mobileqq.soload.biz.entity;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONObject;

public class RelatedFileInfo
  implements Serializable
{
  public String md5;
  public String url;
  
  public static RelatedFileInfo create(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    String str;
    do
    {
      return null;
      str = paramJSONObject.optString("url");
      paramJSONObject = paramJSONObject.optString("md5");
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramJSONObject)));
    RelatedFileInfo localRelatedFileInfo = new RelatedFileInfo();
    localRelatedFileInfo.url = str;
    localRelatedFileInfo.md5 = paramJSONObject;
    return localRelatedFileInfo;
  }
  
  public String toString()
  {
    return "ri{u='" + this.url + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.RelatedFileInfo
 * JD-Core Version:    0.7.0.1
 */