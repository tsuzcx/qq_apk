package com.tencent.mobileqq.qshadow.utils;

import java.io.File;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SafeZipFile
  extends ZipFile
{
  public SafeZipFile(File paramFile)
  {
    super(paramFile);
  }
  
  public Enumeration<? extends ZipEntry> entries()
  {
    return new SafeZipFile.SafeZipEntryIterator(super.entries(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.utils.SafeZipFile
 * JD-Core Version:    0.7.0.1
 */