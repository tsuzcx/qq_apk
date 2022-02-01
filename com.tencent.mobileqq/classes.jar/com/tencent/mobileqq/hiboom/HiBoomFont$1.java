package com.tencent.mobileqq.hiboom;

import java.io.File;
import java.io.FilenameFilter;

final class HiBoomFont$1
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".hy")) || (paramString.endsWith(".fz")) || (paramString.endsWith(".hy3")) || (paramString.endsWith(".fz4"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFont.1
 * JD-Core Version:    0.7.0.1
 */