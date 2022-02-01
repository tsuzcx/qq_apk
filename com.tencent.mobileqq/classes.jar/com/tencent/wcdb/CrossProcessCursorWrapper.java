package com.tencent.wcdb;

public class CrossProcessCursorWrapper
  extends CursorWrapper
  implements CrossProcessCursor
{
  public CursorWindow a()
  {
    if ((this.a instanceof CrossProcessCursor)) {
      return ((CrossProcessCursor)this.a).a();
    }
    return null;
  }
  
  public void a(int paramInt, CursorWindow paramCursorWindow)
  {
    if ((this.a instanceof CrossProcessCursor))
    {
      ((CrossProcessCursor)this.a).a(paramInt, paramCursorWindow);
      return;
    }
    DatabaseUtils.a(this.a, paramInt, paramCursorWindow);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((this.a instanceof CrossProcessCursor)) {
      return ((CrossProcessCursor)this.a).a(paramInt1, paramInt2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.CrossProcessCursorWrapper
 * JD-Core Version:    0.7.0.1
 */