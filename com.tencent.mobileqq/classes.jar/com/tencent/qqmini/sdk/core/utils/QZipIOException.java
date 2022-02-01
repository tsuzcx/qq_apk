package com.tencent.qqmini.sdk.core.utils;

import java.io.IOException;
import java.util.zip.ZipEntry;

public class QZipIOException
  extends IOException
{
  public static boolean isInvalidEntry(ZipEntry paramZipEntry)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.QZipIOException
 * JD-Core Version:    0.7.0.1
 */