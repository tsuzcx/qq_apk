package com.tencent.mobileqq.kandian.biz.search;

import com.tencent.mobileqq.kandian.biz.config.IReadInJoySearchJumpUrlConfBean;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ReadInjoySearchJumpurlConfBean
  implements IReadInJoySearchJumpUrlConfBean
{
  public String a = "";
  public String b = "";
  public String c = "";
  public int d = 1;
  public String e = "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$";
  
  public String a()
  {
    return this.a;
  }
  
  public void a(Integer paramInteger)
  {
    this.d = paramInteger.intValue();
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
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
    return this.e;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public IReadInJoySearchJumpUrlConfBean e(String paramString)
  {
    ReadInjoySearchJumpurlConfBean localReadInjoySearchJumpurlConfBean = new ReadInjoySearchJumpurlConfBean();
    try
    {
      localObject = new JSONObject(paramString);
      localReadInjoySearchJumpurlConfBean.a(((JSONObject)localObject).optString("kQQPASearchDiscoverPageUrl"));
      localReadInjoySearchJumpurlConfBean.b(((JSONObject)localObject).optString("kQQPASearchListTitleIconUrl"));
      localReadInjoySearchJumpurlConfBean.c(((JSONObject)localObject).optString("kQQPAClickAssociationalWordWebUrl"));
      localReadInjoySearchJumpurlConfBean.a(Integer.valueOf(((JSONObject)localObject).optInt("kQQPAClickAssociationalWordToWebSearch", 1)));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfBean", 2, new Object[] { "loadConfig292Data json = ", paramString });
      }
      localReadInjoySearchJumpurlConfBean.d(((JSONObject)localObject).optString("kQQPASearchJumpUrl", "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$"));
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("loadConfig292Data(). readinjoy_search_jump_url=");
        paramString.append(localReadInjoySearchJumpurlConfBean.d());
        paramString.append(", discoveryPageUrl = ");
        paramString.append(localReadInjoySearchJumpurlConfBean.a());
        QLog.d("ReadInjoySearchJumpurlConfBean", 2, paramString.toString());
        return localReadInjoySearchJumpurlConfBean;
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel()) {
        QLog.e("ReadInjoySearchJumpurlConfBean", 2, "loadPublicAccountCenterUrlConfig error", paramString);
      }
      localReadInjoySearchJumpurlConfBean.d("https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadConfig292Data(). use the default url. exception=");
        ((StringBuilder)localObject).append(paramString.getStackTrace());
        QLog.d("ReadInjoySearchJumpurlConfBean", 2, ((StringBuilder)localObject).toString());
      }
    }
    return localReadInjoySearchJumpurlConfBean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kQQPASearchDiscoverPageUrl = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("kQQPASearchListTitleIconUrl = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("kQQPAClickAssociationalWordWebUrl = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("kQQPAClickAssociationalWordToWebSearch = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("kQQPASearchJumpUrl = ");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.ReadInjoySearchJumpurlConfBean
 * JD-Core Version:    0.7.0.1
 */