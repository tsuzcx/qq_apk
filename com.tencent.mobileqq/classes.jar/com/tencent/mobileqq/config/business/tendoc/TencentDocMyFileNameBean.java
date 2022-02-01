package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfItem;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocMyFileNameBean
{
  public String a = HardCodeUtil.a(2131714700);
  public String b = HardCodeUtil.a(2131714707);
  public String c = HardCodeUtil.a(2131714703);
  public String d = HardCodeUtil.a(2131714705);
  public String e = HardCodeUtil.a(2131714698);
  
  public static TencentDocMyFileNameBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      return null;
    }
    TencentDocMyFileNameBean localTencentDocMyFileNameBean = new TencentDocMyFileNameBean();
    try
    {
      paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].a).optJSONObject("MyFileNameConfig");
      localTencentDocMyFileNameBean.a = paramArrayOfQConfItem.optString("tdfileTabName");
      localTencentDocMyFileNameBean.b = paramArrayOfQConfItem.optString("wyfileTabName");
      localTencentDocMyFileNameBean.c = paramArrayOfQConfItem.optString("tdlistTabviewName");
      localTencentDocMyFileNameBean.d = paramArrayOfQConfItem.optString("createTXDocTitle");
      localTencentDocMyFileNameBean.e = paramArrayOfQConfItem.optString("safeShareToastWording");
      return localTencentDocMyFileNameBean;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      QLog.e("TencentDocMyFileNameBean", 1, paramArrayOfQConfItem.getLocalizedMessage(), paramArrayOfQConfItem);
    }
    return localTencentDocMyFileNameBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameBean
 * JD-Core Version:    0.7.0.1
 */