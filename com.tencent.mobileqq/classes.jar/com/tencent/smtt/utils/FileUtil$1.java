package com.tencent.smtt.utils;

import java.io.InputStream;
import java.util.zip.ZipEntry;

final class FileUtil$1
  implements FileUtil.b
{
  FileUtil$1(String paramString) {}
  
  public boolean a(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString)
  {
    try
    {
      boolean bool = FileUtil.a(paramInputStream, paramZipEntry, this.a, paramString);
      return bool;
    }
    catch (Exception paramInputStream)
    {
      throw new Exception("copyFileIfChanged Exception", paramInputStream);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.FileUtil.1
 * JD-Core Version:    0.7.0.1
 */