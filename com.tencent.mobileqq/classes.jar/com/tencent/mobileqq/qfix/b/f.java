package com.tencent.mobileqq.qfix.b;

import java.io.Closeable;
import java.io.File;
import java.util.zip.ZipFile;

public class f
{
  static void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    try
    {
      if ((paramObject instanceof Closeable)) {
        ((Closeable)paramObject).close();
      }
      if ((paramObject instanceof ZipFile)) {
        ((ZipFile)paramObject).close();
      }
      return;
    }
    catch (Throwable paramObject) {}
  }
  
  static boolean a(File paramFile)
  {
    boolean bool1 = true;
    if (paramFile == null) {
      return true;
    }
    if (paramFile.exists())
    {
      boolean bool2 = paramFile.delete();
      bool1 = bool2;
      if (!bool2)
      {
        paramFile.deleteOnExit();
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.equals(paramString2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.b.f
 * JD-Core Version:    0.7.0.1
 */