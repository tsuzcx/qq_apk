package com.tencent.wcdb;

import android.database.CharArrayBuffer;

public abstract class AbstractWindowedCursor
  extends AbstractCursor
{
  protected CursorWindow g;
  
  public CursorWindow a()
  {
    return this.g;
  }
  
  public void a(CursorWindow paramCursorWindow)
  {
    if (paramCursorWindow != this.g)
    {
      d();
      this.g = paramCursorWindow;
    }
  }
  
  protected void a(String paramString)
  {
    CursorWindow localCursorWindow = this.g;
    if (localCursorWindow == null)
    {
      this.g = new CursorWindow(paramString);
      return;
    }
    localCursorWindow.b();
  }
  
  protected void b()
  {
    super.b();
    d();
  }
  
  protected void c()
  {
    super.c();
    if (this.g != null) {
      return;
    }
    throw new StaleDataException("Attempting to access a closed CursorWindow.Most probable cause: cursor is deactivated prior to calling this method.");
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    c();
    this.g.a(this.b, paramInt, paramCharArrayBuffer);
  }
  
  protected void d()
  {
    CursorWindow localCursorWindow = this.g;
    if (localCursorWindow != null)
    {
      localCursorWindow.close();
      this.g = null;
    }
  }
  
  public byte[] getBlob(int paramInt)
  {
    c();
    return this.g.b(this.b, paramInt);
  }
  
  public double getDouble(int paramInt)
  {
    c();
    return this.g.e(this.b, paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    c();
    return this.g.h(this.b, paramInt);
  }
  
  public int getInt(int paramInt)
  {
    c();
    return this.g.g(this.b, paramInt);
  }
  
  public long getLong(int paramInt)
  {
    c();
    return this.g.d(this.b, paramInt);
  }
  
  public short getShort(int paramInt)
  {
    c();
    return this.g.f(this.b, paramInt);
  }
  
  public String getString(int paramInt)
  {
    c();
    return this.g.c(this.b, paramInt);
  }
  
  public int getType(int paramInt)
  {
    c();
    return this.g.a(this.b, paramInt);
  }
  
  public boolean isNull(int paramInt)
  {
    c();
    return this.g.a(this.b, paramInt) == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.AbstractWindowedCursor
 * JD-Core Version:    0.7.0.1
 */