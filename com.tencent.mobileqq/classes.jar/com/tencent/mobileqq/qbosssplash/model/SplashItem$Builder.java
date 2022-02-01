package com.tencent.mobileqq.qbosssplash.model;

import com.tencent.mobileqq.qbosssplash.common.QbossSplashUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;

public class SplashItem$Builder
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString = "";
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i;
  private String j = "-1";
  private String k;
  
  public Builder a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public SplashItem a()
  {
    for (;;)
    {
      try
      {
        switch (this.jdField_a_of_type_Int)
        {
        case 0: 
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_b_of_type_Boolean = false;
          }
          return new SplashItem(this.k, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_e_of_type_JavaLangString, this.jdField_c_of_type_Int, this.f, this.jdField_a_of_type_Boolean, this.jdField_c_of_type_Boolean, this.jdField_b_of_type_Boolean, this.i, this.jdField_d_of_type_Int, this.g, this.h, this.jdField_e_of_type_Int, this.j);
        }
      }
      catch (Exception localException)
      {
        QLog.e("QSplash@SplashItem", 1, localException, new Object[0]);
        return null;
      }
      this.i = (VFSAssistantUtils.getSDKPrivatePath(QbossSplashUtil.jdField_a_of_type_JavaLangString) + "pic/" + this.jdField_d_of_type_JavaLangString.hashCode());
      continue;
      this.i = (VFSAssistantUtils.getSDKPrivatePath(QbossSplashUtil.jdField_a_of_type_JavaLangString) + "gif/" + this.jdField_d_of_type_JavaLangString.hashCode());
      this.i = (VFSAssistantUtils.getSDKPrivatePath(QbossSplashUtil.jdField_a_of_type_JavaLangString) + "video/" + this.jdField_d_of_type_JavaLangString.hashCode());
    }
  }
  
  public Builder b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder e(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public Builder e(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder f(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder g(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public Builder h(String paramString)
  {
    this.k = paramString;
    return this;
  }
  
  public Builder i(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public Builder j(String paramString)
  {
    this.h = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qbosssplash.model.SplashItem.Builder
 * JD-Core Version:    0.7.0.1
 */