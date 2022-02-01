package com.tencent.mobileqq.kandian.glue.pts;

import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;

public class StyleConfigHelper$TemplateFactoryWrapper
{
  public String a;
  public String b;
  public TemplateFactory c;
  
  public StyleConfigHelper$TemplateFactoryWrapper(String paramString, TemplateFactory paramTemplateFactory, boolean paramBoolean)
  {
    if (paramString != null)
    {
      this.c = paramTemplateFactory;
      if (paramBoolean)
      {
        this.a = paramString;
        return;
      }
      this.b = paramString;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public String a()
  {
    String str2 = this.a;
    String str1 = str2;
    if (str2 == null) {
      str1 = this.b;
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper.TemplateFactoryWrapper
 * JD-Core Version:    0.7.0.1
 */