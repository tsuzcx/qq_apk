package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.config.QConfItem;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocPreloadConfigBean
{
  private boolean a;
  private boolean b;
  private boolean c;
  
  public static TencentDocPreloadConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      return null;
    }
    TencentDocPreloadConfigBean localTencentDocPreloadConfigBean = new TencentDocPreloadConfigBean();
    try
    {
      paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].a);
      localTencentDocPreloadConfigBean.a = paramArrayOfQConfItem.getBoolean("fastload");
      localTencentDocPreloadConfigBean.b = paramArrayOfQConfItem.getBoolean("prefetch");
      localTencentDocPreloadConfigBean.c = paramArrayOfQConfItem.getBoolean("preloadWebView");
      QLog.v("TencentDocPreloadConfigBean", 0, "fastload = " + localTencentDocPreloadConfigBean.a + ", prefetch = " + localTencentDocPreloadConfigBean.b + ", preloadWebView = " + localTencentDocPreloadConfigBean.c);
      return localTencentDocPreloadConfigBean;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      QLog.e("TencentDocPreloadConfigBean", 1, paramArrayOfQConfItem.getLocalizedMessage(), paramArrayOfQConfItem);
    }
    return localTencentDocPreloadConfigBean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigBean
 * JD-Core Version:    0.7.0.1
 */