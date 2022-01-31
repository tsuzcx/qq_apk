package com.tencent.mobileqq.search.model;

public abstract class ISearchResultPositionModel
  implements ISearchResultModel
{
  private int a;
  private int b;
  
  public void b(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int c()
  {
    return this.a;
  }
  
  public int d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.ISearchResultPositionModel
 * JD-Core Version:    0.7.0.1
 */