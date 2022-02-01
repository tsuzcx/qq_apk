package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSdkIFrameBean
{
  private boolean a = true;
  
  public static OpenSdkIFrameBean a(QConfItem[] paramArrayOfQConfItem)
  {
    OpenSdkIFrameBean localOpenSdkIFrameBean = new OpenSdkIFrameBean();
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
          if (localJSONObject.has("enableIframe"))
          {
            if (localJSONObject.optInt("enableIframe", 1) != 0)
            {
              bool = true;
              localOpenSdkIFrameBean.a = bool;
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
          QLog.d("OpenSdkIFrameProcessor", 1, paramArrayOfQConfItem.toString());
          return localOpenSdkIFrameBean;
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        QLog.e("OpenSdkIFrameProcessor", 1, "JSONException", paramArrayOfQConfItem);
        return null;
      }
      boolean bool = false;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkIFrameBean
 * JD-Core Version:    0.7.0.1
 */