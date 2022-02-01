package com.tencent.mobileqq.utils.dialogutils;

public class QQCustomMenuItem
{
  String a;
  int b;
  int c;
  int d;
  boolean e = false;
  
  public QQCustomMenuItem(int paramInt, String paramString)
  {
    this.a = paramString;
    this.b = paramInt;
    this.d = QQCustomMenuItemPriorityHelper.a(paramString);
  }
  
  public QQCustomMenuItem(int paramInt1, String paramString, int paramInt2)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = QQCustomMenuItemPriorityHelper.a(paramString);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQCustomMenuItem{title='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", special=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", priority=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem
 * JD-Core Version:    0.7.0.1
 */