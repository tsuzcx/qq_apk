package com.tencent.mobileqq.kandian.glue.video.report;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoR5
{
  private JSONObject a;
  
  public VideoR5(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.a = new JSONObject();
        return;
      }
      this.a = new JSONObject(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public VideoR5(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = new JSONObject();
    VideoReporter.b(paramString1, paramString2, paramString3, paramString4, this.a);
  }
  
  public VideoR5(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1);
    VideoReporter.b(paramString2, paramString3, paramString4, paramString5, this.a);
  }
  
  public String a()
  {
    return this.a.toString();
  }
  
  protected void a(String paramString, Object paramObject)
  {
    try
    {
      this.a.put(paramString, paramObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.report.VideoR5
 * JD-Core Version:    0.7.0.1
 */