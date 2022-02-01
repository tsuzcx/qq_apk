package com.tencent.mobileqq.flutter.router;

public class PageRouter
{
  public SerializableMap a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  
  public PageRouter()
  {
    this.jdField_b_of_type_JavaLangString = "unknown";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("-");
    localStringBuilder.append(hashCode());
    this.c = localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PageRouter{entryPoint='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pageName='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", params=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFlutterRouterSerializableMap);
    localStringBuilder.append(", uniqueId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", needStatusBarTransparent=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", needStatusTextDark=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.router.PageRouter
 * JD-Core Version:    0.7.0.1
 */