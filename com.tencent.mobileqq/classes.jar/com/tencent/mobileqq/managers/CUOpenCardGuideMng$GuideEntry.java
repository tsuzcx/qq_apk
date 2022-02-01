package com.tencent.mobileqq.managers;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class CUOpenCardGuideMng$GuideEntry
{
  public String a;
  public String b;
  public String c;
  
  public static GuideEntry a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject;
    if (paramJSONObject != null)
    {
      try
      {
        Object localObject = new GuideEntry();
        try
        {
          boolean bool = paramJSONObject.has("tip");
          if (bool) {
            ((GuideEntry)localObject).a = paramJSONObject.getString("tip");
          } else {
            ((GuideEntry)localObject).a = "";
          }
          if (paramJSONObject.has("key_word")) {
            ((GuideEntry)localObject).b = paramJSONObject.getString("key_word");
          } else {
            ((GuideEntry)localObject).b = "";
          }
          if (paramJSONObject.has("jump_url"))
          {
            ((GuideEntry)localObject).c = paramJSONObject.getString("jump_url");
            return localObject;
          }
          ((GuideEntry)localObject).c = "";
          return localObject;
        }
        catch (Exception localException2)
        {
          paramJSONObject = (JSONObject)localObject;
          localObject = localException2;
        }
        localJSONObject = paramJSONObject;
      }
      catch (Exception localException1)
      {
        paramJSONObject = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.i("CUOpenCardGuideMng", 2, "GuideEntry-parse", localException1);
        return paramJSONObject;
      }
    }
    else
    {
      localJSONObject = null;
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[tip:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", key_word:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", jump_url:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.CUOpenCardGuideMng.GuideEntry
 * JD-Core Version:    0.7.0.1
 */