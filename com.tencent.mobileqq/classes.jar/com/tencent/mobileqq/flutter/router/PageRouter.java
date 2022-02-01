package com.tencent.mobileqq.flutter.router;

public class PageRouter
{
  public String a;
  public String b = "unknown";
  public SerializableMap c;
  public String d;
  public boolean e;
  public boolean f;
  public boolean g;
  
  public PageRouter()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("-");
    localStringBuilder.append(hashCode());
    this.d = localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PageRouter{entryPoint='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pageName='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", params=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", uniqueId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", needStatusBarTransparent=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", needStatusTextDark=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.router.PageRouter
 * JD-Core Version:    0.7.0.1
 */