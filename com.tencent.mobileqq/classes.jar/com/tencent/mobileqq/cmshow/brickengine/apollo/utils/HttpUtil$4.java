package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import com.tencent.mobileqq.apollo.utils.ApolloHttpCallBack;
import com.tencent.mobileqq.apollo.utils.ApolloHttpUtil;

final class HttpUtil$4
  implements Runnable
{
  HttpUtil$4(String paramString1, String paramString2, String[] paramArrayOfString, ApolloHttpCallBack paramApolloHttpCallBack, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString.toUpperCase();
    if (str.equals("GET"))
    {
      ApolloHttpUtil.a(this.b, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloHttpCallBack);
      return;
    }
    if (str.equals("POST"))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        ApolloHttpUtil.a(this.b, this.c, this.d, this.e, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloHttpCallBack);
        return;
      }
      ApolloHttpUtil.a(this.b, this.c, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloHttpCallBack);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.HttpUtil.4
 * JD-Core Version:    0.7.0.1
 */