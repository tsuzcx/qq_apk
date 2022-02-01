package com.tencent.mobileqq.vassplash.model;

public class SplashUIdata$Builder
{
  public int a;
  public String a;
  private boolean a;
  private int jdField_b_of_type_Int = -1;
  public String b;
  private boolean jdField_b_of_type_Boolean = true;
  private int c;
  public String c;
  private int d;
  public String d;
  private String e = "";
  private String f = "";
  private String g = "";
  
  public SplashUIdata$Builder()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public Builder a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public SplashUIdata a()
  {
    SplashUIdata localSplashUIdata = new SplashUIdata(this.jdField_b_of_type_Int, this.e, this.jdField_c_of_type_Int, this.g, this.jdField_d_of_type_Int, this.f, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    localSplashUIdata.e = this.jdField_b_of_type_JavaLangString;
    localSplashUIdata.f = this.jdField_c_of_type_JavaLangString;
    localSplashUIdata.g = this.jdField_d_of_type_JavaLangString;
    return localSplashUIdata;
  }
  
  public Builder b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public Builder d(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder e(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder f(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder g(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vassplash.model.SplashUIdata.Builder
 * JD-Core Version:    0.7.0.1
 */