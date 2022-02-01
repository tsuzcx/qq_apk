package com.tencent.qmsp.sdk.f;

import java.io.File;

public class d
{
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    if (paramString.isFile())
    {
      paramString.delete();
      return;
    }
    File[] arrayOfFile = paramString.listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      a(arrayOfFile[i].getAbsolutePath(), paramBoolean);
      i += 1;
    }
    if (!paramBoolean) {
      paramString.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.f.d
 * JD-Core Version:    0.7.0.1
 */