package com.tencent.richframework.data.base;

public class UIStateData$ModifyListRecord
{
  private final int a;
  private final int b;
  private final int c;
  
  private UIStateData$ModifyListRecord(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.c = paramInt2;
    this.b = paramInt3;
  }
  
  public static ModifyListRecord a()
  {
    return new ModifyListRecord(0, -1, -1);
  }
  
  public static ModifyListRecord a(int paramInt1, int paramInt2)
  {
    return new ModifyListRecord(2, paramInt1, paramInt2);
  }
  
  public int b()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.data.base.UIStateData.ModifyListRecord
 * JD-Core Version:    0.7.0.1
 */