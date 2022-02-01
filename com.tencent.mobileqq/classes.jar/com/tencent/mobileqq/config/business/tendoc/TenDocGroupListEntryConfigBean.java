package com.tencent.mobileqq.config.business.tendoc;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TenDocGroupListEntryConfigBean
{
  private String a = "";
  private boolean b = false;
  
  public static TenDocGroupListEntryConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      TenDocGroupListEntryConfigBean localTenDocGroupListEntryConfigBean = new TenDocGroupListEntryConfigBean();
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].b);
        boolean bool = paramArrayOfQConfItem.has("AndroidGroupListJumpURL");
        if (bool)
        {
          localTenDocGroupListEntryConfigBean.a = paramArrayOfQConfItem.getString("AndroidGroupListJumpURL");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleTenDocGroupListEntryConfig mAndroidGroupListJumpURL = ");
            localStringBuilder.append(localTenDocGroupListEntryConfigBean.a);
            QLog.d("TencentDocUserConfigBean", 2, localStringBuilder.toString());
          }
        }
        if (paramArrayOfQConfItem.has("AndroidGroupListWebEnable"))
        {
          localTenDocGroupListEntryConfigBean.b = paramArrayOfQConfItem.getBoolean("AndroidGroupListWebEnable");
          if (QLog.isColorLevel())
          {
            paramArrayOfQConfItem = new StringBuilder();
            paramArrayOfQConfItem.append("handleTenDocGroupListEntryConfig AndroidGroupListWebEnable = ");
            paramArrayOfQConfItem.append(localTenDocGroupListEntryConfigBean.b);
            QLog.d("TencentDocUserConfigBean", 2, paramArrayOfQConfItem.toString());
            return localTenDocGroupListEntryConfigBean;
          }
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
      }
      return localTenDocGroupListEntryConfigBean;
    }
    return null;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.a)) {
      return null;
    }
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TenDocGroupListEntryConfigBean
 * JD-Core Version:    0.7.0.1
 */