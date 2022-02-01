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
      Object localObject = localZipEntry.getName();
      if (localObject != null)
      {
        if ((!((String)localObject).contains("../")) && (!((String)localObject).contains("..\\"))) {
          return localZipEntry;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("非法entry路径:");
        ((StringBuilder)localObject).append(localZipEntry.getName());
        throw new SecurityException(((StringBuilder)localObject).toString());
      }
    }
    return localZipEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.utils.SafeZipFile.SafeZipEntryIterator
 * JD-Core Version:    0.7.0.1
 */