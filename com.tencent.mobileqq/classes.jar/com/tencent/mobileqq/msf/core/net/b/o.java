package com.tencent.mobileqq.msf.core.net.b;

public abstract class o
{
  protected i[] f = { new j("http://sqimg.qq.com/qq_product_operations/nettest/index.html", "MobileQQ1"), new j("http://sqimg.qq.com/qq_product_operations/nettest/index2.html", "MobileQQ2") };
  
  protected a a(i parami, int paramInt, a.a parama)
  {
    switch (parami.d)
    {
    case 0: 
    case 1: 
    default: 
      return null;
    }
    return new b(paramInt, ((j)parami).f, parami.e, 10000, parama);
  }
  
  public abstract void a();
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.o
 * JD-Core Version:    0.7.0.1
 */