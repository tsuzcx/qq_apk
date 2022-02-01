package com.tencent.qqprotect.singleupdate;

public class QPUpdFileOperation
{
  public static String a(String paramString)
  {
    String str = paramString;
    if (a(paramString))
    {
      int i = paramString.length() - 1;
      while ((i >= 0) && (paramString.charAt(i) != '\\') && (paramString.charAt(i) != '/')) {
        i -= 1;
      }
      str = paramString.substring(i + 1);
    }
    return str;
  }
  
  public static boolean a(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j) {
      if ((paramString.charAt(i) != '\\') && (paramString.charAt(i) != '/')) {
        i += 1;
      } else {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPUpdFileOperation
 * JD-Core Version:    0.7.0.1
 */