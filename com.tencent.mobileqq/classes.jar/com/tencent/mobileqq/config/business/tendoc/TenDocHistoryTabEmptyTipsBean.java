package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfItem;
import org.json.JSONException;
import org.json.JSONObject;

public class TenDocHistoryTabEmptyTipsBean
{
  private String a = HardCodeUtil.a(2131714715);
  private String b = "";
  
  public static TenDocHistoryTabEmptyTipsBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      return null;
    }
    TenDocHistoryTabEmptyTipsBean localTenDocHistoryTabEmptyTipsBean = new TenDocHistoryTabEmptyTipsBean();
    try
    {
      paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].a);
      localTenDocHistoryTabEmptyTipsBean.a = paramArrayOfQConfItem.getString("emptyShowWording");
      localTenDocHistoryTabEmptyTipsBean.b = paramArrayOfQConfItem.getString("linkWord");
      return localTenDocHistoryTabEmptyTipsBean;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      paramArrayOfQConfItem.printStackTrace();
      return localTenDocHistoryTabEmptyTipsBean;
    }
    catch (NullPointerException paramArrayOfQConfItem)
    {
      paramArrayOfQConfItem.printStackTrace();
    }
    return localTenDocHistoryTabEmptyTipsBean;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TenDocHistoryTabEmptyTipsBean
 * JD-Core Version:    0.7.0.1
 */