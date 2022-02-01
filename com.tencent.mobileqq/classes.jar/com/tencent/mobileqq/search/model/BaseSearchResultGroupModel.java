package com.tencent.mobileqq.search.model;

public abstract class BaseSearchResultGroupModel
  extends ISearchResultGroupModel
{
  private int a = 0;
  private int b = 21;
  
  protected void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int e()
  {
    return this.a;
  }
  
  public int f()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.BaseSearchResultGroupModel
 * JD-Core Version:    0.7.0.1
 */