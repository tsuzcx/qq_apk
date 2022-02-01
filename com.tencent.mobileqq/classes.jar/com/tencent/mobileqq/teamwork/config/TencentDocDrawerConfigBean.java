package com.tencent.mobileqq.teamwork.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocDrawerConfigBean
{
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  private String c = "我的腾讯文档";
  
  public static TencentDocDrawerConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      TencentDocDrawerConfigBean localTencentDocDrawerConfigBean = new TencentDocDrawerConfigBean();
      try
      {
        localObject = new JSONObject(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleTencentDocUserConfigCmd jsonConfig = ");
          localStringBuilder.append(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
          QLog.d("TencentDocDrawerConfigBean", 2, localStringBuilder.toString());
        }
        if (((JSONObject)localObject).has("DrawerJumpURL"))
        {
          localTencentDocDrawerConfigBean.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("DrawerJumpURL");
          if (QLog.isColorLevel())
          {
            paramArrayOfQConfItem = new StringBuilder();
            paramArrayOfQConfItem.append("handleTencentDocUserConfigCmd AndroidDrawerJumpURL = ");
            paramArrayOfQConfItem.append(localTencentDocDrawerConfigBean.jdField_a_of_type_JavaLangString);
            QLog.d("TencentDocDrawerConfigBean", 2, paramArrayOfQConfItem.toString());
          }
        }
        if (((JSONObject)localObject).has("isShowInDrawer"))
        {
          localTencentDocDrawerConfigBean.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(((JSONObject)localObject).getBoolean("isShowInDrawer"));
          if (QLog.isColorLevel())
          {
            paramArrayOfQConfItem = new StringBuilder();
            paramArrayOfQConfItem.append("handleTencentDocUserConfigCmd isShowInDrawer = ");
            paramArrayOfQConfItem.append(localTencentDocDrawerConfigBean.jdField_a_of_type_JavaLangBoolean);
            QLog.d("TencentDocDrawerConfigBean", 2, paramArrayOfQConfItem.toString());
          }
        }
        if (((JSONObject)localObject).has("DrawerIconURL"))
        {
          localTencentDocDrawerConfigBean.b = ((JSONObject)localObject).getString("DrawerIconURL");
          if (QLog.isColorLevel())
          {
            paramArrayOfQConfItem = new StringBuilder();
            paramArrayOfQConfItem.append("handleTencentDocUserConfigCmd mAndroidDrawerIconURL = ");
            paramArrayOfQConfItem.append(localTencentDocDrawerConfigBean.b);
            QLog.d("TencentDocDrawerConfigBean", 2, paramArrayOfQConfItem.toString());
          }
        }
        if (((JSONObject)localObject).has("DrawerText"))
        {
          localTencentDocDrawerConfigBean.c = ((JSONObject)localObject).getString("DrawerText");
          if (QLog.isColorLevel())
          {
            paramArrayOfQConfItem = new StringBuilder();
            paramArrayOfQConfItem.append("handleTencentDocUserConfigCmd AndroidDrawerText = ");
            paramArrayOfQConfItem.append(localTencentDocDrawerConfigBean.c);
            QLog.d("TencentDocDrawerConfigBean", 2, paramArrayOfQConfItem.toString());
            return localTencentDocDrawerConfigBean;
          }
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TencentDocDrawerConfigBean parse error = ");
        ((StringBuilder)localObject).append(paramArrayOfQConfItem);
        QLog.e("TencentDocDrawerConfigBean", 1, ((StringBuilder)localObject).toString());
      }
      return localTencentDocDrawerConfigBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocDrawerConfigBean", 2, "config is empty = ");
    }
    return null;
  }
  
  public Boolean a()
  {
    return this.jdField_a_of_type_JavaLangBoolean;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return null;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.b)) {
      return null;
    }
    return this.b;
  }
  
  public String c()
  {
    if (TextUtils.isEmpty(this.c)) {
      return null;
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.config.TencentDocDrawerConfigBean
 * JD-Core Version:    0.7.0.1
 */