package com.tencent.mobileqq.leba.UITemplate;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public abstract class BaseUITemplateInfo
{
  public int a;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  public static BaseUITemplateInfo a(String paramString)
  {
    PicUITemplateInfo localPicUITemplateInfo = null;
    Object localObject3 = null;
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {
      return localObject2;
    }
    localObject2 = localObject3;
    for (;;)
    {
      int k;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject2 = localObject3;
        k = localJSONObject.optInt("template_id");
        if (1 == k)
        {
          localObject2 = localObject3;
          localPicUITemplateInfo = new PicUITemplateInfo();
          localObject2 = localPicUITemplateInfo;
          if (localPicUITemplateInfo == null) {
            break;
          }
          localObject2 = localPicUITemplateInfo;
          localPicUITemplateInfo.a(localJSONObject);
          return localPicUITemplateInfo;
        }
      }
      catch (Exception localException)
      {
        QLog.e("new_leba", 1, "pareseJson fail,  json = " + paramString, localException);
        return localObject2;
      }
      Object localObject1;
      if (2 == k)
      {
        localObject2 = localObject3;
        localObject1 = new VideoUITemplateInfo();
      }
      else if (3 == k)
      {
        localObject2 = localObject3;
        localObject1 = new ARKUITemplateInfo();
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("template_id");
    paramJSONObject = paramJSONObject.optJSONObject("common");
    this.e = paramJSONObject.optString("version");
    this.f = paramJSONObject.optString("title");
    this.g = paramJSONObject.optString("sub_title");
    this.h = paramJSONObject.optString("provider");
    this.i = paramJSONObject.optString("comment");
    this.j = paramJSONObject.optString("jump_url");
  }
  
  public abstract boolean a(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.UITemplate.BaseUITemplateInfo
 * JD-Core Version:    0.7.0.1
 */