package com.tencent.wcdb.support;

import android.util.Printer;

public class LogPrinter
  implements Printer
{
  private final int a;
  private final String b;
  
  public void println(String paramString)
  {
    Log.a(this.a, this.b, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.support.LogPrinter
 * JD-Core Version:    0.7.0.1
 */