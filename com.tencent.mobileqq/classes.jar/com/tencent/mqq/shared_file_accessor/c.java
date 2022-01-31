package com.tencent.mqq.shared_file_accessor;

public final class c
{
  public int a = 0;
  private String b = null;
  
  private c(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (!(paramObject instanceof Integer)) {
        break;
      }
    } while (this.a != ((Integer)paramObject).intValue());
    return true;
    if ((paramObject instanceof String)) {
      return this.b.equals(paramObject);
    }
    return super.equals(paramObject);
  }
  
  public final String toString()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.c
 * JD-Core Version:    0.7.0.1
 */