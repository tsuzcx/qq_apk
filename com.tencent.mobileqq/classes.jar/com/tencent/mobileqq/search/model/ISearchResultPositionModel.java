package com.tencent.mobileqq.search.model;

public abstract class ISearchResultPositionModel
  implements ISearchResultModel
{
  private int a;
  private int b;
  public boolean g = true;
  public int u;
  public int v = 0;
  
  public int a()
  {
    return this.a;
  }
  
  public Object a(String paramString)
  {
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.v = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.ISearchResultPositionModel
 * JD-Core Version:    0.7.0.1
 */