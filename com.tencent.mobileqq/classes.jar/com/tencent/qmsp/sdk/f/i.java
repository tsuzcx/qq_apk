package com.tencent.qmsp.sdk.f;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class i
  extends ZipInputStream
{
  public i(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public ZipEntry getNextEntry()
  {
    ZipEntry localZipEntry = super.getNextEntry();
    if (!h.a(localZipEntry)) {
      return localZipEntry;
    }
    throw new h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.f.i
 * JD-Core Version:    0.7.0.1
 */