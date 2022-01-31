package com.tencent.mobileqq.msf.core.a;

public class g
{
  private static final String b = "WeakNetworkConfig";
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static boolean a()
  {
    return a.bt() != 0;
  }
  
  public static g.a b()
  {
    g.a locala;
    switch ()
    {
    default: 
      locala = c();
    }
    while ((!a) && (locala == null))
    {
      throw new AssertionError();
      locala = c();
      continue;
      locala = new g.a(2, false, 2000, 2000, 2, 1, 2000, 20, 1000, 2000, 1000);
    }
    return locala;
  }
  
  public static g.a c()
  {
    return new g.a(1, true, 3000, 3000, 2, 2, 2000, 20, 2000, 3000, 500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.g
 * JD-Core Version:    0.7.0.1
 */