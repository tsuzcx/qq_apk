package com.tencent.mobileqq.config.business.tendoc;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TenDocGroupListEntryConfigBean
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  
  public static TenDocGroupListEntryConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      paramArrayOfQConfItem = null;
    }
    TenDocGroupListEntryConfigBean localTenDocGroupListEntryConfigBean;
    for (;;)
    {
      return paramArrayOfQConfItem;
      localTenDocGroupListEntryConfigBean = new TenDocGroupListEntryConfigBean();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("AndroidGroupListJumpURL"))
        {
          localTenDocGroupListEntryConfigBean.jdField_a_of_type_JavaLangString = localJSONObject.getString("AndroidGroupListJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig mAndroidGroupListJumpURL = " + localTenDocGroupListEntryConfigBean.jdField_a_of_type_JavaLangString);
          }
        }
        paramArrayOfQConfItem = localTenDocGroupListEntryConfigBean;
        if (localJSONObject.has("AndroidGroupListWebEnable"))
        {
          localTenDocGroupListEntryConfigBean.jdField_a_of_type_Boolean = localJSONObject.getBoolean("AndroidGroupListWebEnable");
          paramArrayOfQConfItem = localTenDocGroupListEntryConfigBean;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTenDocGroupListEntryConfig AndroidGroupListWebEnable = " + localTenDocGroupListEntryConfigBean.jdField_a_of_type_Boolean);
            return localTenDocGroupListEntryConfigBean;
          }
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
      }
    }
    return localTenDocGroupListEntryConfigBean;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return null;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TenDocGroupListEntryConfigBean
 * JD-Core Version:    0.7.0.1
 */