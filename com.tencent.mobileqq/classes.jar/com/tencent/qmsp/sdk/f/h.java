package com.tencent.qmsp.sdk.f;

import java.io.IOException;
import java.util.zip.ZipEntry;

public class h
  extends IOException
{
  public static boolean a(ZipEntry paramZipEntry)
  {
    if (paramZipEntry != null)
    {
      paramZipEntry = paramZipEntry.getName();
      if ((paramZipEntry != null) && ((paramZipEntry.contains("../")) || (paramZipEntry.contains("..\\")))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.f.h
 * JD-Core Version:    0.7.0.1
 */