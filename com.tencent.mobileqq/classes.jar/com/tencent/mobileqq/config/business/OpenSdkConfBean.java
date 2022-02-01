package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class OpenSdkConfBean
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public static OpenSdkConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    OpenSdkConfBean localOpenSdkConfBean = new OpenSdkConfBean();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= paramArrayOfQConfItem.length) {
          break label187;
        }
        String str = paramArrayOfQConfItem[i].a;
        if (TextUtils.isEmpty(str))
        {
          QLog.d("OpenSdkConfProcessor", 1, "parse, content empty");
        }
        else
        {
          JSONObject localJSONObject = new JSONObject(str);
          if (localJSONObject.has("enable_third_app_share_big_image_by_server"))
          {
            if (localJSONObject.optInt("enable_third_app_share_big_image_by_server", 0) == 1)
            {
              bool = true;
              localOpenSdkConfBean.jdField_a_of_type_Boolean = bool;
            }
          }
          else
          {
            if (localJSONObject.has("sdk_share_verify_appinfo_timeout_duration")) {
              localOpenSdkConfBean.jdField_a_of_type_Long = localJSONObject.optInt("sdk_share_verify_appinfo_timeout_duration", 0);
            }
            if (localJSONObject.has("sdk_login_use_third_transform_pkg_name"))
            {
              if (localJSONObject.optInt("sdk_login_use_third_transform_pkg_name", 0) != 1) {
                break label182;
              }
              bool = true;
              localOpenSdkConfBean.b = bool;
            }
            localStringBuilder.append("config: ").append(str).append(",");
          }
        }
      }
      catch (Exception paramArrayOfQConfItem)
      {
        QLog.e("OpenSdkConfProcessor", 1, "parse, failed!", paramArrayOfQConfItem);
        return null;
      }
      boolean bool = false;
      continue;
      label182:
      bool = false;
      continue;
      label187:
      QLog.d("OpenSdkConfProcessor", 1, "parse, content:" + localStringBuilder.toString());
      return localOpenSdkConfBean;
      i += 1;
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("serverShareImageEnable:").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("timeout_duration:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append("useThirdTransformPkgName:").append(this.b);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkConfBean
 * JD-Core Version:    0.7.0.1
 */