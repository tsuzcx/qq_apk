package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocMiniProgramGrayTipsBean
{
  private boolean a;
  private String b = "";
  
  public static TencentDocMiniProgramGrayTipsBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      TencentDocMiniProgramGrayTipsBean localTencentDocMiniProgramGrayTipsBean = new TencentDocMiniProgramGrayTipsBean();
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].b);
        localTencentDocMiniProgramGrayTipsBean.a = paramArrayOfQConfItem.getBoolean("enable");
        localTencentDocMiniProgramGrayTipsBean.b = paramArrayOfQConfItem.getString("content");
        return localTencentDocMiniProgramGrayTipsBean;
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        QLog.e("TencentDocMiniProgramGrayTipsBean", 1, paramArrayOfQConfItem.getLocalizedMessage(), paramArrayOfQConfItem);
        return localTencentDocMiniProgramGrayTipsBean;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocMiniProgramGrayTipsBean
 * JD-Core Version:    0.7.0.1
 */