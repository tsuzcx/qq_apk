package com.tencent.mobileqq.config.business.tendoc;

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
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      TencentDocUserConfigBean localTencentDocUserConfigBean = new TencentDocUserConfigBean();
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].a);
        boolean bool = paramArrayOfQConfItem.has("AndroidDrawerJumpURL");
        if (bool)
        {
          localTencentDocUserConfigBean.a = paramArrayOfQConfItem.getString("AndroidDrawerJumpURL");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleTencentDocUserConfigCmd AndroidDrawerJumpURL = ");
            localStringBuilder.append(localTencentDocUserConfigBean.a);
            QLog.d("TencentDocUserConfigBean", 2, localStringBuilder.toString());
          }
        }
        if (paramArrayOfQConfItem.has("AndroidAioJumpURL"))
        {
          localTencentDocUserConfigBean.b = paramArrayOfQConfItem.getString("AndroidAioJumpURL");
          if (QLog.isColorLevel())
          {
            paramArrayOfQConfItem = new StringBuilder();
            paramArrayOfQConfItem.append("handleTencentDocUserConfigCmd AndroidAioJumpURL = ");
            paramArrayOfQConfItem.append(localTencentDocUserConfigBean.b);
            QLog.d("TencentDocUserConfigBean", 2, paramArrayOfQConfItem.toString());
            return localTencentDocUserConfigBean;
          }
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
      }
      return localTencentDocUserConfigBean;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocUserConfigBean
 * JD-Core Version:    0.7.0.1
 */