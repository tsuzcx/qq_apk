package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocPreloadConfigBean
{
  private boolean a;
  private boolean b;
  private boolean c;
  
  public static TencentDocPreloadConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      TencentDocPreloadConfigBean localTencentDocPreloadConfigBean = new TencentDocPreloadConfigBean();
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].a);
        localTencentDocPreloadConfigBean.a = paramArrayOfQConfItem.getBoolean("fastload");
        localTencentDocPreloadConfigBean.b = paramArrayOfQConfItem.getBoolean("prefetch");
        localTencentDocPreloadConfigBean.c = paramArrayOfQConfItem.getBoolean("preloadWebView");
        paramArrayOfQConfItem = new StringBuilder();
        paramArrayOfQConfItem.append("fastload = ");
        paramArrayOfQConfItem.append(localTencentDocPreloadConfigBean.a);
        paramArrayOfQConfItem.append(", prefetch = ");
        paramArrayOfQConfItem.append(localTencentDocPreloadConfigBean.b);
        paramArrayOfQConfItem.append(", preloadWebView = ");
        paramArrayOfQConfItem.append(localTencentDocPreloadConfigBean.c);
        QLog.d("TencentDocPreloadConfigBean", 2, paramArrayOfQConfItem.toString());
        return localTencentDocPreloadConfigBean;
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        QLog.e("TencentDocPreloadConfigBean", 1, paramArrayOfQConfItem.getLocalizedMessage(), paramArrayOfQConfItem);
        return localTencentDocPreloadConfigBean;
      }
    }
    return null;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigBean
 * JD-Core Version:    0.7.0.1
 */