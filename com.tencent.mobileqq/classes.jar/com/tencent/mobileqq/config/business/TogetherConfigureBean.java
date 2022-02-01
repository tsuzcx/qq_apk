package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TogetherConfigureBean
{
  public WatchTogetherBean a;
  public boolean a;
  
  public TogetherConfigureBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessWatchTogetherBean = new WatchTogetherBean();
  }
  
  public static TogetherConfigureBean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        TogetherConfigureBean localTogetherConfigureBean = new TogetherConfigureBean();
        paramString = new JSONObject(paramString);
        localTogetherConfigureBean.jdField_a_of_type_Boolean = paramString.optBoolean("showTogetherWatchInTroopSettingCard", false);
        paramString = paramString.optJSONObject("watchTogether");
        if (paramString != null)
        {
          WatchTogetherBean localWatchTogetherBean = new WatchTogetherBean();
          localWatchTogetherBean.a(paramString.optInt("version"));
          localWatchTogetherBean.b(paramString.optInt("jumpType"));
          localWatchTogetherBean.a(paramString.optString("jumpUrl"));
          localWatchTogetherBean.b(paramString.optString("jumpExtensionInfo"));
          localTogetherConfigureBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessWatchTogetherBean = localWatchTogetherBean;
        }
        QLog.d("TogetherBusinessConfProcessor", 2, "confBean = " + localTogetherConfigureBean.toString());
        return localTogetherConfigureBean;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("TogetherBusinessConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TogetherConfigureBean{showTogetherWatchInTroopSettingCard=").append(this.jdField_a_of_type_Boolean).append(", watchTogether=");
    if (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessWatchTogetherBean == null) {}
    for (String str = "null";; str = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessWatchTogetherBean.toString()) {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TogetherConfigureBean
 * JD-Core Version:    0.7.0.1
 */