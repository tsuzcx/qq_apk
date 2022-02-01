package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.config.QConfItem;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocSelectAddDocsBean
{
  private boolean a = false;
  
  public static TencentDocSelectAddDocsBean a(QConfItem[] paramArrayOfQConfItem)
  {
    boolean bool = true;
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0))
    {
      paramArrayOfQConfItem = null;
      return paramArrayOfQConfItem;
    }
    TencentDocSelectAddDocsBean localTencentDocSelectAddDocsBean = new TencentDocSelectAddDocsBean();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem[0].a);
        paramArrayOfQConfItem = localTencentDocSelectAddDocsBean;
        if (!localJSONObject.has("SendAsTxDoc")) {
          break;
        }
        if (localJSONObject.getJSONObject("SendAsTxDoc").getInt("enableSendAsTxDoc") == 1)
        {
          localTencentDocSelectAddDocsBean.a = bool;
          return localTencentDocSelectAddDocsBean;
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
        return localTencentDocSelectAddDocsBean;
      }
      bool = false;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocSelectAddDocsBean
 * JD-Core Version:    0.7.0.1
 */