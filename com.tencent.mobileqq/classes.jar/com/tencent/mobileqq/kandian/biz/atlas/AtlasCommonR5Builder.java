package com.tencent.mobileqq.kandian.biz.atlas;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AtlasCommonR5Builder
{
  private JSONObject a = new JSONObject();
  
  public AtlasCommonR5Builder a()
  {
    try
    {
      this.a.put("network", GalleryReportedUtils.a(BaseApplicationImpl.getApplication().getApplicationContext()));
      this.a.put("version", VideoReporter.a);
      this.a.put("os", "1");
      this.a.put("uin", RIJQQAppInterfaceUtil.a());
      this.a.put("city", GalleryReportedUtils.b());
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public AtlasCommonR5Builder a(int paramInt)
  {
    if (paramInt == 41516) {
      paramInt = 3;
    } else if (paramInt == 41522) {
      paramInt = 16;
    } else {
      paramInt = 0;
    }
    try
    {
      this.a.put("source", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public String a()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.AtlasCommonR5Builder
 * JD-Core Version:    0.7.0.1
 */