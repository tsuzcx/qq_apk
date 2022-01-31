package com.tencent.mobileqq.leba.UITemplate;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PicUITemplateInfo
  extends BaseUITemplateInfo
{
  public List a;
  public int b;
  
  public boolean a(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    try
    {
      a(paramJSONObject);
      Object localObject = paramJSONObject.optJSONObject("params");
      this.b = ((JSONObject)localObject).optInt("image_count");
      localObject = ((JSONObject)localObject).optJSONArray("image_urls");
      this.a = new ArrayList();
      int i = 0;
      boolean bool1;
      for (;;)
      {
        bool1 = bool2;
        if (i >= ((JSONArray)localObject).length()) {
          break;
        }
        this.a.add(((JSONArray)localObject).getString(i));
        i += 1;
      }
      return bool1;
    }
    catch (Exception localException)
    {
      QLog.e("new_leba", 1, "pareseJson fail,  json = " + paramJSONObject.toString(), localException);
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.UITemplate.PicUITemplateInfo
 * JD-Core Version:    0.7.0.1
 */