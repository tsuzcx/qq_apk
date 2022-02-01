package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSdkFakeMsgBean
{
  private boolean a;
  
  public static OpenSdkFakeMsgBean a(QConfItem[] paramArrayOfQConfItem)
  {
    OpenSdkFakeMsgBean localOpenSdkFakeMsgBean = new OpenSdkFakeMsgBean();
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        int j = paramArrayOfQConfItem.length;
        int i = 0;
        if (i < j)
        {
          String str = paramArrayOfQConfItem[i].b;
          QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, new Object[] { "content=", str });
          JSONObject localJSONObject = new JSONObject(str);
          if (localJSONObject.has("enable_fake_msg"))
          {
            if (localJSONObject.optInt("enable_fake_msg", 0) == 1)
            {
              bool = true;
              localOpenSdkFakeMsgBean.a = bool;
            }
          }
          else
          {
            localStringBuilder.append("config: ");
            localStringBuilder.append(str);
            localStringBuilder.append(",");
            i += 1;
          }
        }
        else
        {
          paramArrayOfQConfItem = new StringBuilder();
          paramArrayOfQConfItem.append("parse, content:");
          paramArrayOfQConfItem.append(localStringBuilder.toString());
          QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, paramArrayOfQConfItem.toString());
          return localOpenSdkFakeMsgBean;
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        QLog.e("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, "JSONException", paramArrayOfQConfItem);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isEnableFakeMsg:");
    localStringBuilder.append(this.a);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkFakeMsgBean
 * JD-Core Version:    0.7.0.1
 */