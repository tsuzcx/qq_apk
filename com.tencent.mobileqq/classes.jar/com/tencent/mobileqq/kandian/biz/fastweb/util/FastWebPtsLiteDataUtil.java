package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.mobileqq.kandian.repo.pts.entity.PtsData;
import org.json.JSONObject;

public class FastWebPtsLiteDataUtil
{
  static boolean a(JSONObject paramJSONObject)
  {
    return (paramJSONObject != null) && (paramJSONObject.has("pts_page_name"));
  }
  
  static PtsData b(JSONObject paramJSONObject)
  {
    String str = c(paramJSONObject);
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.toString();
    } else {
      paramJSONObject = "";
    }
    paramJSONObject = new PtsData(str, str, paramJSONObject);
    paramJSONObject.b();
    return paramJSONObject;
  }
  
  private static String c(JSONObject paramJSONObject)
  {
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.optString("pts_page_name", "");
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPtsLiteDataUtil
 * JD-Core Version:    0.7.0.1
 */