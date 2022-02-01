package com.tencent.mobileqq.kandian.glue.pts;

import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;

public class StyleConfigHelper$TemplateFactoryWrapper
{
  public TemplateFactory a;
  public String a;
  public String b;
  
  public StyleConfigHelper$TemplateFactoryWrapper(String paramString, TemplateFactory paramTemplateFactory, boolean paramBoolean)
  {
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsFactoryTemplateFactory = paramTemplateFactory;
      if (paramBoolean)
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        return;
      }
      this.b = paramString;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public String a()
  {
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (str2 == null) {
      str1 = this.b;
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper.TemplateFactoryWrapper
 * JD-Core Version:    0.7.0.1
 */