package com.tencent.mobileqq.microapp.apkg;

public final class l
  implements Cloneable
{
  public i a;
  public boolean b;
  
  public l a()
  {
    l locall;
    try
    {
      locall = (l)super.clone();
      try
      {
        locall.a = this.a.a();
        return locall;
      }
      catch (Throwable localThrowable1) {}
      localThrowable2.printStackTrace();
    }
    catch (Throwable localThrowable2)
    {
      locall = null;
    }
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.l
 * JD-Core Version:    0.7.0.1
 */