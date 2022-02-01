package com.tencent.wcdb.support;

import android.util.Printer;

public class PrefixPrinter
  implements Printer
{
  private final Printer a;
  private final String b;
  
  public void println(String paramString)
  {
    Printer localPrinter = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(paramString);
    localPrinter.println(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.support.PrefixPrinter
 * JD-Core Version:    0.7.0.1
 */