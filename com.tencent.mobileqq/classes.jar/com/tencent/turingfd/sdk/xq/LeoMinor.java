package com.tencent.turingfd.sdk.xq;

public final class LeoMinor
  extends case
  implements Cloneable
{
  public static Lacerta aa = new Lacerta();
  public int ba = 0;
  public Lacerta ca = null;
  public long da = 0L;
  
  public void a(byte parambyte)
  {
    parambyte.b(this.ba, 0);
    Lacerta localLacerta = this.ca;
    if (localLacerta != null) {
      parambyte.a(localLacerta, 1);
    }
    parambyte.a(this.da, 2);
  }
  
  public void a(try paramtry)
  {
    this.ba = paramtry.a(this.ba, 0, true);
    this.ca = ((Lacerta)paramtry.a(aa, 1, false));
    this.da = paramtry.a(this.da, 2, true);
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
    paramObject = (LeoMinor)paramObject;
    boolean bool1 = bool2;
    if (char.equals(this.ba, paramObject.ba))
    {
      bool1 = bool2;
      if (char.equals(this.ca, paramObject.ca))
      {
        bool1 = bool2;
        if (char.a(this.da, paramObject.da)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.LeoMinor
 * JD-Core Version:    0.7.0.1
 */