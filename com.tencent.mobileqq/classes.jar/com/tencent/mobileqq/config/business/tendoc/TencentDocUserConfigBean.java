package com.tencent.mobileqq.config.business.tendoc;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocUserConfigBean
{
  private String a = "";
  private String b = "";
  
  public static TencentDocUserConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      paramArrayOfQConfItem = null;
    }
    TencentDocUserConfigBean localTencentDocUserConfigBean;
    for (;;)
    {
      return paramArrayOfQConfItem;
      localTencentDocUserConfigBean = new TencentDocUserConfigBean();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem[0].a);
        if (localJSONObject.has("AndroidDrawerJumpURL"))
        {
          localTencentDocUserConfigBean.a = localJSONObject.getString("AndroidDrawerJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidDrawerJumpURL = " + localTencentDocUserConfigBean.a);
          }
        }
        paramArrayOfQConfItem = localTencentDocUserConfigBean;
        if (localJSONObject.has("AndroidAioJumpURL"))
        {
          localTencentDocUserConfigBean.b = localJSONObject.getString("AndroidAioJumpURL");
          paramArrayOfQConfItem = localTencentDocUserConfigBean;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidAioJumpURL = " + localTencentDocUserConfigBean.b);
            return localTencentDocUserConfigBean;
          }
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
      }
    }
    return localTencentDocUserConfigBean;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.a)) {
      return null;
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocUserConfigBean
 * JD-Core Version:    0.7.0.1
 */