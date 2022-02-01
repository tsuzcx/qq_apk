package com.tencent.xweb.util;

public class h$a
{
  StringBuilder a = new StringBuilder();
  int b = 0;
  
  public h$a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public a a(int paramInt, Object paramObject)
  {
    return a(paramObject);
  }
  
  public a a(Object paramObject)
  {
    if (this.a.length() > 0) {
      this.a.append(",");
    }
    this.a.append(paramObject.toString());
    return this;
  }
  
  public String a()
  {
    String str = this.a.toString();
    h.a(this.b, this.a.toString());
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.util.h.a
 * JD-Core Version:    0.7.0.1
 */