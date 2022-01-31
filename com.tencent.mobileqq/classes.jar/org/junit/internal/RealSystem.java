package org.junit.internal;

import java.io.PrintStream;

public class RealSystem
  implements JUnitSystem
{
  @Deprecated
  public void exit(int paramInt)
  {
    System.exit(paramInt);
  }
  
  public PrintStream out()
  {
    return System.out;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.internal.RealSystem
 * JD-Core Version:    0.7.0.1
 */