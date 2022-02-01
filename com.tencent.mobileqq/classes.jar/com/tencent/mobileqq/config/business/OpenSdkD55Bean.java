package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSdkD55Bean
{
  private boolean a;
  
  public static OpenSdkD55Bean a(QConfItem[] paramArrayOfQConfItem)
  {
    OpenSdkD55Bean localOpenSdkD55Bean = new OpenSdkD55Bean();
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        int j = paramArrayOfQConfItem.length;
        int i = 0;
        if (i < j)
        {
          String str = paramArrayOfQConfItem[i].a;
          QLog.d("OpenSdkD55Processor", 1, new Object[] { "content=", str });
          JSONObject localJSONObject = new JSONObject(str);
          if (localJSONObject.has("enable_d55"))
          {
            if (localJSONObject.optInt("enable_d55", 0) == 1)
            {
              bool = true;
              localOpenSdkD55Bean.a = bool;
            }
          }
          else
          {
            localStringBuilder.append("config: ").append(str).append(",");
            i += 1;
          }
        }
        else
        {
          QLog.d("OpenSdkD55Processor", 1, "parse, content:" + localStringBuilder.toString());
          return localOpenSdkD55Bean;
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        QLog.e("OpenSdkD55Processor", 1, "JSONException", paramArrayOfQConfItem);
        return null;
      }
      boolean bool = false;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String toString()
  {
    new StringBuilder().append("isSwitchOpen:").append(this.a);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkD55Bean
 * JD-Core Version:    0.7.0.1
 */