package com.tencent.mobileqq.kandian.repo.aladdin.sp;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.qphone.base.util.QLog;

public class RIJPersonalHomePageConfigSp
{
  public static String a()
  {
    return Aladdin.getConfig(360).getString("web_page_url", ReadInJoyConstants.k);
  }
  
  public static void a()
  {
    String str = (String)RIJSPUtils.a("readinjoy_viola_url_personal_homepage", ReadInJoyConstants.g);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPersonalHomePageConfig result=");
      localStringBuilder.append(str);
      QLog.d("Q.readinjoy.tt_report", 2, localStringBuilder.toString());
    }
    ReadInJoyConstants.g = str;
    ReadInJoyConstants.k = str;
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updatePersonalHomePageConfig value=");
      localStringBuilder.append(paramString);
      QLog.d("Q.readinjoy.tt_report", 2, localStringBuilder.toString());
    }
    RIJSPUtils.a("readinjoy_viola_url_personal_homepage", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJPersonalHomePageConfigSp
 * JD-Core Version:    0.7.0.1
 */