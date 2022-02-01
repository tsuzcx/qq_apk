package com.tencent.mobileqq.tribe.data;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f;
  public long g;
  public int h;
  public int i;
  public boolean j;
  private int k = 1;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("vid", this.b);
      localJSONObject.put("url", this.a);
      localJSONObject.put("video_md5", this.c);
      localJSONObject.put("video_thumbe_url", this.d);
      localJSONObject.put("text", this.e);
      localJSONObject.put("duration", this.f);
      localJSONObject.put("size", this.g);
      localJSONObject.put("width", this.h);
      localJSONObject.put("height", this.i);
      localJSONObject.put("isLocalVideo", this.j);
      localJSONObject.put("takeVideoMode", this.k);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoInfo: ");
        localStringBuilder.append(QLog.getStackTraceString(localJSONException));
        QLog.e("VideoInfo", 2, localStringBuilder.toString());
      }
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.data.VideoInfo
 * JD-Core Version:    0.7.0.1
 */