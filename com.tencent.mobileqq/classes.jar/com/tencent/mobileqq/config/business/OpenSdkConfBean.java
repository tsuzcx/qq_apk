package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.open.agent.util.SSOLog;
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
        int j = paramArrayOfQConfItem.length;
        boolean bool2 = true;
        if (i < j)
        {
          String str = paramArrayOfQConfItem[i].a;
          if (TextUtils.isEmpty(str))
          {
            SSOLog.a("OpenSdkConfProcessor", new Object[] { "parse, content empty" });
            break label258;
          }
          JSONObject localJSONObject = new JSONObject(str);
          if (localJSONObject.has("enable_third_app_share_big_image_by_server"))
          {
            if (localJSONObject.optInt("enable_third_app_share_big_image_by_server", 0) == 1)
            {
              bool1 = true;
              localOpenSdkConfBean.jdField_a_of_type_Boolean = bool1;
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
                break label253;
              }
              bool1 = bool2;
              localOpenSdkConfBean.b = bool1;
            }
            localStringBuilder.append("config: ");
            localStringBuilder.append(str);
            localStringBuilder.append(",");
            break label258;
          }
        }
        else
        {
          paramArrayOfQConfItem = new StringBuilder();
          paramArrayOfQConfItem.append("parse, content:");
          paramArrayOfQConfItem.append(localStringBuilder.toString());
          SSOLog.a("OpenSdkConfProcessor", new Object[] { paramArrayOfQConfItem.toString() });
          return localOpenSdkConfBean;
        }
      }
      catch (Exception paramArrayOfQConfItem)
      {
        SSOLog.a("OpenSdkConfProcessor", "parse, failed!", paramArrayOfQConfItem);
        return null;
      }
      boolean bool1 = false;
      continue;
      label253:
      bool1 = false;
      continue;
      label258:
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
    localStringBuilder.append("serverShareImageEnable:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("timeout_duration:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("useThirdTransformPkgName:");
    localStringBuilder.append(this.b);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkConfBean
 * JD-Core Version:    0.7.0.1
 */