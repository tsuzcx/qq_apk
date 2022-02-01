package com.tencent.mobileqq.kandian.biz.viola.video;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class VideoInfo
{
  public int a;
  public String b;
  public int c;
  public int d;
  public int e;
  public String f;
  public String g;
  public long h;
  public String i;
  public int j;
  public String k;
  public int l;
  public boolean m;
  public Map<String, Object> n = new HashMap();
  
  public VideoInfo() {}
  
  public VideoInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (paramJSONObject.has("busiType")) {
      this.a = paramJSONObject.getInt("busiType");
    }
    if (paramJSONObject.has("vid")) {
      this.b = paramJSONObject.getString("vid");
    }
    if (paramJSONObject.has("width")) {
      this.c = paramJSONObject.getInt("width");
    }
    if (paramJSONObject.has("height")) {
      this.d = paramJSONObject.getInt("height");
    }
    if (paramJSONObject.has("duration")) {
      this.e = paramJSONObject.getInt("duration");
    }
    if (paramJSONObject.has("poster")) {
      this.f = paramJSONObject.getString("poster");
    }
    if (paramJSONObject.has("title")) {
      this.g = paramJSONObject.getString("title");
    }
    if (paramJSONObject.has("xgFileSize")) {
      this.h = paramJSONObject.getLong("xgFileSize");
    }
    if (paramJSONObject.has("videoUrl")) {
      this.i = paramJSONObject.getString("videoUrl");
    }
    if (paramJSONObject.has("fromType")) {
      this.j = paramJSONObject.getInt("fromType");
    }
    if (paramJSONObject.has("dt_pgid")) {
      this.l = paramJSONObject.optInt("dt_pgid");
    }
    if (paramJSONObject.has("isAd")) {
      this.m = paramJSONObject.optBoolean("isAd");
    }
    if (paramJSONObject.has("dt_extraParams"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("dt_extraParams");
      if (paramJSONObject != null)
      {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.n.put(str, paramJSONObject.optString(str));
        }
        this.k = paramJSONObject.optString("rowkey");
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoInfo{busiType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", xgFileSize=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", videoUrl='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.video.VideoInfo
 * JD-Core Version:    0.7.0.1
 */