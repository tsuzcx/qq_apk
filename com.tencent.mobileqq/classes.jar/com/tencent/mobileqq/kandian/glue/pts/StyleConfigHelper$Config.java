package com.tencent.mobileqq.kandian.glue.pts;

public class StyleConfigHelper$Config
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public StyleConfigHelper$Config(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Config)) {
      return false;
    }
    paramObject = (Config)paramObject;
    String str = this.b;
    if ((str != null) && (str.equals(paramObject.b)))
    {
      str = this.c;
      return (str != null) && (str.equals(paramObject.c));
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" bid :");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" localPath:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("  ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper.Config
 * JD-Core Version:    0.7.0.1
 */