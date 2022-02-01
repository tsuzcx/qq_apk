package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocHistoryTabToastBean
{
  private int a = -1;
  
  public static TencentDocHistoryTabToastBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      paramArrayOfQConfItem = null;
    }
    TencentDocHistoryTabToastBean localTencentDocHistoryTabToastBean;
    do
    {
      return paramArrayOfQConfItem;
      localTencentDocHistoryTabToastBean = new TencentDocHistoryTabToastBean();
      try
      {
        localTencentDocHistoryTabToastBean.a = new JSONObject(paramArrayOfQConfItem[0].a).getInt("show_limit");
        return localTencentDocHistoryTabToastBean;
      }
      catch (JSONException localJSONException)
      {
        paramArrayOfQConfItem = localTencentDocHistoryTabToastBean;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TencentDocHistoryTabToastBean", 1, "exception = " + localJSONException.toString());
    return localTencentDocHistoryTabToastBean;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public boolean a()
  {
    return this.a == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocHistoryTabToastBean
 * JD-Core Version:    0.7.0.1
 */