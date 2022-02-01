package com.tencent.mobileqq.kandian.biz.search;

import com.tencent.mobileqq.kandian.biz.config.IReadInJoySearchJumpUrlConfBean;
import com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfBeanFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ReadInjoySearchJumpurlConfBean
  implements IReadInJoySearchJumpUrlConfBean
{
  public int a;
  public String a;
  public String b = "";
  public String c = "";
  public String d = "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$";
  
  public ReadInjoySearchJumpurlConfBean()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
  }
  
  public IReadInJoySearchJumpUrlConfBean a(String paramString)
  {
    IReadInJoySearchJumpUrlConfBean localIReadInJoySearchJumpUrlConfBean = ((IReadInJoySearchJumpUrlConfBeanFactory)QRoute.api(IReadInJoySearchJumpUrlConfBeanFactory.class)).createConfBean();
    try
    {
      localObject = new JSONObject(paramString);
      localIReadInJoySearchJumpUrlConfBean.a(((JSONObject)localObject).optString("kQQPASearchDiscoverPageUrl"));
      localIReadInJoySearchJumpUrlConfBean.b(((JSONObject)localObject).optString("kQQPASearchListTitleIconUrl"));
      localIReadInJoySearchJumpUrlConfBean.c(((JSONObject)localObject).optString("kQQPAClickAssociationalWordWebUrl"));
      localIReadInJoySearchJumpUrlConfBean.a(Integer.valueOf(((JSONObject)localObject).optInt("kQQPAClickAssociationalWordToWebSearch", 1)));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfBean", 2, new Object[] { "loadConfig292Data json = ", paramString });
      }
      localIReadInJoySearchJumpUrlConfBean.d(((JSONObject)localObject).optString("kQQPASearchJumpUrl", "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$"));
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("loadConfig292Data(). readinjoy_search_jump_url=");
        paramString.append(localIReadInJoySearchJumpUrlConfBean.d());
        paramString.append(", discoveryPageUrl = ");
        paramString.append(localIReadInJoySearchJumpUrlConfBean.a());
        QLog.d("ReadInjoySearchJumpurlConfBean", 2, paramString.toString());
        return localIReadInJoySearchJumpUrlConfBean;
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel()) {
        QLog.e("ReadInjoySearchJumpurlConfBean", 2, "loadPublicAccountCenterUrlConfig error", paramString);
      }
      localIReadInJoySearchJumpUrlConfBean.d("https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadConfig292Data(). use the default url. exception=");
        ((StringBuilder)localObject).append(paramString.getStackTrace());
        QLog.d("ReadInjoySearchJumpurlConfBean", 2, ((StringBuilder)localObject).toString());
      }
    }
    return localIReadInJoySearchJumpUrlConfBean;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(Integer paramInteger)
  {
    this.jdField_a_of_type_Int = paramInteger.intValue();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kQQPASearchDiscoverPageUrl = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("kQQPASearchListTitleIconUrl = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("kQQPAClickAssociationalWordWebUrl = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("kQQPAClickAssociationalWordToWebSearch = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("kQQPASearchJumpUrl = ");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.ReadInjoySearchJumpurlConfBean
 * JD-Core Version:    0.7.0.1
 */