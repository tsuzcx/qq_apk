package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

class n$b
{
  private Map<String, n.a> b = new HashMap();
  
  n$b(n paramn, File paramFile)
  {
    this.b.clear();
    a(paramFile);
  }
  
  private void a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if ((paramFile != null) || (Build.VERSION.SDK_INT < 26)) {}
    }
    while (!paramFile.isFile()) {
      for (;;)
      {
        return;
        int i = 0;
        while (i < paramFile.length)
        {
          a(paramFile[i]);
          i += 1;
        }
      }
    }
    a(paramFile.getName(), paramFile.length(), paramFile.lastModified());
  }
  
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    if ((paramString != null) && (paramString.length() > 0) && (paramLong1 > 0L) && (paramLong2 > 0L))
    {
      n.a locala = new n.a(this.a, paramString, paramLong1, paramLong2);
      if (!this.b.containsKey(paramString)) {
        this.b.put(paramString, locala);
      }
    }
  }
  
  Map<String, n.a> a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.n.b
 * JD-Core Version:    0.7.0.1
 */