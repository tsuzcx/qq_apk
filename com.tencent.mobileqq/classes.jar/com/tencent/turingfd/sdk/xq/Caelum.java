package com.tencent.turingfd.sdk.xq;

public final class Caelum
  extends case
  implements Cloneable
{
  public static Bootes Q = new Bootes();
  public int R = 0;
  public Bootes S = null;
  public long U = 0L;
  
  public void a(byte parambyte)
  {
    parambyte.a(this.R, 0);
    Bootes localBootes = this.S;
    if (localBootes != null) {
      parambyte.a(localBootes, 1);
    }
    parambyte.a(this.U, 2);
  }
  
  public void a(try paramtry)
  {
    this.R = paramtry.a(this.R, 0, true);
    this.S = ((Bootes)paramtry.a(Q, 1, false));
    this.U = paramtry.a(this.U, 2, true);
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (m) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (Caelum)paramObject;
    } while ((!char.equals(this.R, paramObject.R)) || (!char.equals(this.S, paramObject.S)) || (!char.a(this.U, paramObject.U)));
    return true;
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
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Caelum
 * JD-Core Version:    0.7.0.1
 */