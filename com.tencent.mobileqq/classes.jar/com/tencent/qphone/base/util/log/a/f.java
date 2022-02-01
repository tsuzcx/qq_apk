package com.tencent.qphone.base.util.log.a;

import java.io.File;
import java.util.Comparator;

class f
  implements Comparator
{
  f(e parame) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile1.lastModified() > paramFile2.lastModified()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.a.f
 * JD-Core Version:    0.7.0.1
 */