package com.tencent.mobileqq.qshadow.utils;

import java.util.Enumeration;
import java.util.zip.ZipEntry;

class SafeZipFile$SafeZipEntryIterator
  implements Enumeration<ZipEntry>
{
  private final Enumeration<? extends ZipEntry> delegate;
  
  private SafeZipFile$SafeZipEntryIterator(Enumeration<? extends ZipEntry> paramEnumeration)
  {
    this.delegate = paramEnumeration;
  }
  
  public boolean hasMoreElements()
  {
    return this.delegate.hasMoreElements();
  }
  
  public ZipEntry nextElement()
  {
    ZipEntry localZipEntry = (ZipEntry)this.delegate.nextElement();
    if (localZipEntry != null)
    {
      String str = localZipEntry.getName();
      if ((str != null) && ((str.contains("../")) || (str.contains("..\\")))) {
        throw new SecurityException("非法entry路径:" + localZipEntry.getName());
      }
    }
    return localZipEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.utils.SafeZipFile.SafeZipEntryIterator
 * JD-Core Version:    0.7.0.1
 */