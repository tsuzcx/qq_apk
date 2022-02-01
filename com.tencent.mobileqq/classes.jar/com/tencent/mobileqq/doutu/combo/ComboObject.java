package com.tencent.mobileqq.doutu.combo;

public class ComboObject
{
  public String a;
  public int b;
  public boolean c;
  
  public ComboObject(String paramString, int paramInt)
  {
    this(paramString, paramInt, true);
  }
  
  public ComboObject(String paramString, int paramInt, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramBoolean;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ComboObject:");
    localStringBuffer.append(this.a);
    localStringBuffer.append(',');
    localStringBuffer.append(this.b);
    localStringBuffer.append(',');
    localStringBuffer.append(this.c);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboObject
 * JD-Core Version:    0.7.0.1
 */