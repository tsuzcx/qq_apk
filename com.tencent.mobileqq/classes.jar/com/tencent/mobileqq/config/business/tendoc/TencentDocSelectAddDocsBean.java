package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.config.QConfItem;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocSelectAddDocsBean
{
  private boolean a = false;
  
  public static TencentDocSelectAddDocsBean a(QConfItem[] paramArrayOfQConfItem)
  {
    TencentDocSelectAddDocsBean localTencentDocSelectAddDocsBean;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      localTencentDocSelectAddDocsBean = new TencentDocSelectAddDocsBean();
    }
    for (;;)
    {
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].b);
        if (paramArrayOfQConfItem.has("SendAsTxDoc"))
        {
          int i = paramArrayOfQConfItem.getJSONObject("SendAsTxDoc").getInt("enableSendAsTxDoc");
          bool = true;
          if (i != 1) {
            break label81;
          }
          localTencentDocSelectAddDocsBean.a = bool;
          return localTencentDocSelectAddDocsBean;
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
      }
      return localTencentDocSelectAddDocsBean;
      return null;
      label81:
      boolean bool = false;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocSelectAddDocsBean
 * JD-Core Version:    0.7.0.1
 */