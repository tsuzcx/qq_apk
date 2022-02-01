package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class SlideShowStoryConfigBean
{
  public String a = "";
  
  public static SlideShowStoryConfigBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        SlideShowStoryConfigBean localSlideShowStoryConfigBean = new SlideShowStoryConfigBean();
        paramString = new JSONObject(paramString);
        if (paramString.has("contents")) {
          localSlideShowStoryConfigBean.a = paramString.getJSONArray("contents").toString();
        }
        return localSlideShowStoryConfigBean;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("SlideShowStoryConfigBean", 2, paramString.getMessage());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.SlideShowStoryConfigBean
 * JD-Core Version:    0.7.0.1
 */