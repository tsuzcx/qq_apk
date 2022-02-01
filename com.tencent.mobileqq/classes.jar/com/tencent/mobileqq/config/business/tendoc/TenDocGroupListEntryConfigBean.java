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
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      TenDocGroupListEntryConfigBean localTenDocGroupListEntryConfigBean = new TenDocGroupListEntryConfigBean();
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
        boolean bool = paramArrayOfQConfItem.has("AndroidGroupListJumpURL");
        if (bool)
        {
          localTenDocGroupListEntryConfigBean.jdField_a_of_type_JavaLangString = paramArrayOfQConfItem.getString("AndroidGroupListJumpURL");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleTenDocGroupListEntryConfig mAndroidGroupListJumpURL = ");
            localStringBuilder.append(localTenDocGroupListEntryConfigBean.jdField_a_of_type_JavaLangString);
            QLog.d("TencentDocUserConfigBean", 2, localStringBuilder.toString());
          }
        }
        if (paramArrayOfQConfItem.has("AndroidGroupListWebEnable"))
        {
          localTenDocGroupListEntryConfigBean.jdField_a_of_type_Boolean = paramArrayOfQConfItem.getBoolean("AndroidGroupListWebEnable");
          if (QLog.isColorLevel())
          {
            paramArrayOfQConfItem = new StringBuilder();
            paramArrayOfQConfItem.append("handleTenDocGroupListEntryConfig AndroidGroupListWebEnable = ");
            paramArrayOfQConfItem.append(localTenDocGroupListEntryConfigBean.jdField_a_of_type_Boolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TenDocGroupListEntryConfigBean
 * JD-Core Version:    0.7.0.1
 */