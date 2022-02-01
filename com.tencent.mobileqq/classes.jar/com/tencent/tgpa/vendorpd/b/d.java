package com.tencent.tgpa.vendorpd.b;

import java.io.File;

public class d
{
  public static File a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new File(paramString);
  }
  
  public static boolean a(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists());
  }
  
  public static String b(File paramFile)
  {
    if (paramFile != null) {
      return paramFile.getName();
    }
    return null;
  }
  
  public static boolean b(String paramString)
  {
    return a(a(paramString));
  }
  
  public static String c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return b(a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.b.d
 * JD-Core Version:    0.7.0.1
 */