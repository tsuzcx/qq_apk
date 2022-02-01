package com.tencent.mobileqq.magicface.drawable;

import java.io.File;

public class PngPlayParam
{
  public int a;
  public int b;
  public int c;
  public int d;
  public String[] e;
  public String[] f;
  public boolean g;
  
  public PngPlayParam()
  {
    b();
  }
  
  private void b()
  {
    this.a = 0;
    this.b = 1;
    this.c = 100;
    this.d = 0;
    this.e = null;
    this.f = null;
  }
  
  public boolean a()
  {
    String[] arrayOfString = this.e;
    int i;
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfString = this.e;
        if (i >= arrayOfString.length) {
          break;
        }
        if (!new File(arrayOfString[i]).exists()) {
          return false;
        }
        i += 1;
      }
    }
    arrayOfString = this.f;
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfString = this.f;
        if (i >= arrayOfString.length) {
          break;
        }
        if (!new File(arrayOfString[i]).exists()) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngPlayParam
 * JD-Core Version:    0.7.0.1
 */