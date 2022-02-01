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
    Object localObject = null;
    if (paramJSONObject == null) {
      return null;
    }
    String str1 = paramJSONObject.optString("url");
    String str2 = paramJSONObject.optString("md5");
    paramJSONObject = localObject;
    if (!TextUtils.isEmpty(str1))
    {
      if (TextUtils.isEmpty(str2)) {
        return null;
      }
      paramJSONObject = new RelatedFileInfo();
      paramJSONObject.url = str1;
      paramJSONObject.md5 = str2;
    }
    return paramJSONObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ri{u='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.RelatedFileInfo
 * JD-Core Version:    0.7.0.1
 */