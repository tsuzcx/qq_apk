package com.tencent.mobileqq.easysync2;

public class StringIterator
{
  private String a;
  private int b = 0;
  
  public StringIterator(String paramString)
  {
    this.a = paramString;
  }
  
  private void d(int paramInt)
  {
    boolean bool;
    if (paramInt <= a()) {
      bool = true;
    } else {
      bool = false;
    }
    Changeset.a(bool, new Object[] { "!(", Integer.valueOf(paramInt), " <= ", Integer.valueOf(a()), ")" });
  }
  
  int a()
  {
    return this.a.length() - this.b;
  }
  
  String a(int paramInt)
  {
    d(paramInt);
    String str = this.a;
    int i = this.b;
    str = str.substring(i, i + paramInt);
    this.b += paramInt;
    return str;
  }
  
  String b(int paramInt)
  {
    d(paramInt);
    String str = this.a;
    int i = this.b;
    return str.substring(i, paramInt + i);
  }
  
  void c(int paramInt)
  {
    d(paramInt);
    this.b += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.StringIterator
 * JD-Core Version:    0.7.0.1
 */