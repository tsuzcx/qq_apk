package com.tencent.turingfd.sdk.ams.ga;

public final class interface
  extends try
  implements Cloneable
{
  public static volatile B = new volatile();
  public int C = 0;
  public volatile D = null;
  public long F = 0L;
  
  public void a(int paramint)
  {
    this.C = paramint.a(this.C, 0, true);
    this.D = ((volatile)paramint.a(B, 1, false));
    this.F = paramint.a(this.F, 2, true);
  }
  
  public void a(new paramnew)
  {
    paramnew.b(this.C, 0);
    volatile localvolatile = this.D;
    if (localvolatile != null) {
      paramnew.a(localvolatile, 1);
    }
    paramnew.a(this.F, 2);
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
    if (r) {
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
    paramObject = (interface)paramObject;
    boolean bool1 = bool2;
    if (byte.equals(this.C, paramObject.C))
    {
      bool1 = bool2;
      if (byte.equals(this.D, paramObject.D))
      {
        bool1 = bool2;
        if (byte.a(this.F, paramObject.F)) {
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
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.interface
 * JD-Core Version:    0.7.0.1
 */