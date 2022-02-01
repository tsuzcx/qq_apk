package com.tencent.turingfd.sdk.xq;

public final class Norma
  extends else
  implements Cloneable
{
  public static Lyra a = new Lyra();
  public int c = 0;
  public Lyra d = null;
  public long e = 0L;
  
  public void a(case paramcase)
  {
    paramcase.a(this.c, 0);
    Lyra localLyra = this.d;
    if (localLyra != null) {
      paramcase.a(localLyra, 1);
    }
    paramcase.a(this.e, 2);
  }
  
  public void a(try paramtry)
  {
    this.c = paramtry.a(this.c, 0, true);
    this.d = ((Lyra)paramtry.a(a, 1, false));
    this.e = paramtry.a(this.e, 2, true);
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    if (b) {
      return null;
    }
    throw new AssertionError();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (Norma)paramObject;
    boolean bool1 = bool2;
    if (goto.a(this.c, paramObject.c))
    {
      bool1 = bool2;
      if (this.d.equals(paramObject.d))
      {
        bool1 = bool2;
        if (goto.a(this.e, paramObject.e)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Norma
 * JD-Core Version:    0.7.0.1
 */