package com.tencent.mobileqq.microapp.apkg;

public final class j
  implements Cloneable
{
  public l a;
  
  public j a()
  {
    j localj;
    try
    {
      localj = (j)super.clone();
      try
      {
        localj.a = this.a.a();
        return localj;
      }
      catch (Throwable localThrowable1) {}
      localThrowable2.printStackTrace();
    }
    catch (Throwable localThrowable2)
    {
      localj = null;
    }
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.j
 * JD-Core Version:    0.7.0.1
 */