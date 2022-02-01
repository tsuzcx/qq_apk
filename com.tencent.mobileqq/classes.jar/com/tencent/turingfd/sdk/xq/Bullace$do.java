package com.tencent.turingfd.sdk.xq;

public class Bullace$do
  implements Crux
{
  public void a(String paramString, int paramInt1, int paramInt2, Pyxis paramPyxis)
  {
    long l = Math.abs(paramPyxis.b - Bullace.d);
    Bullace.d = System.currentTimeMillis();
    if (l < Bullace.e) {
      return;
    }
    if ((paramInt2 != 2) && (paramInt2 != 3)) {
      synchronized (Bullace.a)
      {
        Bullace.a.a(new Cantaloupe(paramString, paramInt2, paramPyxis));
        return;
      }
    }
    synchronized (Bullace.b)
    {
      Bullace.b.a(new Cantaloupe(paramString, paramInt2, paramPyxis));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Bullace.do
 * JD-Core Version:    0.7.0.1
 */