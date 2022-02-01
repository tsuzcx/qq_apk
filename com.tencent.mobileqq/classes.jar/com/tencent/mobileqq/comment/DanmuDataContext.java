package com.tencent.mobileqq.comment;

public class DanmuDataContext
{
  public long a;
  public long b;
  public int c;
  public boolean d;
  public long e;
  public long f;
  
  public DanmuDataContext(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    this.b = paramLong1;
    this.a = paramLong2;
    this.c = paramInt;
    this.d = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof DanmuDataContext;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (DanmuDataContext)paramObject;
      bool1 = bool2;
      if (paramObject.a == this.a)
      {
        bool1 = bool2;
        if (paramObject.b == this.b) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuDataContext
 * JD-Core Version:    0.7.0.1
 */