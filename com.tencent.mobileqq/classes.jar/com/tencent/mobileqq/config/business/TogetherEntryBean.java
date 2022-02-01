package com.tencent.mobileqq.config.business;

import android.graphics.Color;
import com.tencent.mobileqq.together.TogetherEntryData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public class TogetherEntryBean
{
  public boolean a = false;
  public int b = 10;
  public ArrayList<TogetherEntryData> c = new ArrayList(4);
  
  public static TogetherEntryBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      TogetherEntryBean localTogetherEntryBean = new TogetherEntryBean();
      paramString = new JSONObject(paramString);
      localTogetherEntryBean.a = paramString.optBoolean("showEntrance", false);
      localTogetherEntryBean.b = paramString.optInt("bannerInterval", 10);
      paramString = paramString.optJSONArray("array");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          TogetherEntryData localTogetherEntryData = new TogetherEntryData();
          localTogetherEntryData.g = localJSONObject.optInt("id");
          localTogetherEntryData.h = localJSONObject.optInt("order");
          localTogetherEntryData.i = localJSONObject.optString("title");
          localTogetherEntryData.j = localJSONObject.optString("subTitle");
          localTogetherEntryData.k = Color.parseColor(localJSONObject.optString("bgColor"));
          localTogetherEntryData.l = localJSONObject.optString("imageUrl");
          localTogetherEntryBean.c.add(localTogetherEntryData);
          i += 1;
        }
      }
      Collections.sort(localTogetherEntryBean.c, new TogetherEntryBean.1());
      paramString = new StringBuilder();
      paramString.append("confBean = ");
      paramString.append(localTogetherEntryBean.toString());
      QLog.d("TogetherEntryConfProcessor", 2, paramString.toString());
      return localTogetherEntryBean;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TogetherEntryConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      }
    }
    return null;
  }
  
  public String toString()
  {
    return 50;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TogetherEntryBean
 * JD-Core Version:    0.7.0.1
 */