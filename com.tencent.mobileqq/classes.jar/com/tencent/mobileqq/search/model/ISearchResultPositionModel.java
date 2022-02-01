package com.tencent.mobileqq.search.model;

public abstract class ISearchResultPositionModel
  extends ISearchResultModel
{
  private int a;
  public int af;
  public boolean ag = true;
  public int ah = 0;
  private int b;
  private int c = 21;
  private boolean d = false;
  
  public Object a(String paramString)
  {
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void c(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (this.d) {
      f(2);
    }
  }
  
  public int ck_()
  {
    return this.a;
  }
  
  public int cl_()
  {
    return this.b;
  }
  
  public void e(int paramInt)
  {
    this.ah = paramInt;
  }
  
  protected void f(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int z()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.ISearchResultPositionModel
 * JD-Core Version:    0.7.0.1
 */