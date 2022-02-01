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
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      TencentDocHistoryTabToastBean localTencentDocHistoryTabToastBean = new TencentDocHistoryTabToastBean();
      try
      {
        localTencentDocHistoryTabToastBean.a = new JSONObject(paramArrayOfQConfItem[0].b).getInt("show_limit");
        return localTencentDocHistoryTabToastBean;
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("exception = ");
          localStringBuilder.append(paramArrayOfQConfItem.toString());
          QLog.e("TencentDocHistoryTabToastBean", 1, localStringBuilder.toString());
        }
        return localTencentDocHistoryTabToastBean;
      }
    }
    return null;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.a == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocHistoryTabToastBean
 * JD-Core Version:    0.7.0.1
 */