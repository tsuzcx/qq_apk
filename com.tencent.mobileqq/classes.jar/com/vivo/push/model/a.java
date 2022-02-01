package com.vivo.push.model;

public final class a
{
  private String a;
  private String b;
  
  public a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (a)paramObject;
    String str = this.a;
    if (str == null)
    {
      if (paramObject.a != null) {
        return false;
      }
    }
    else if (!str.equals(paramObject.a)) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    String str = this.a;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    return i + 31;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConfigItem{mKey='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mValue='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.model.a
 * JD-Core Version:    0.7.0.1
 */