package com.tencent.tavcut.util;

import java.io.File;
import java.io.FilenameFilter;

final class Util$1
  implements FilenameFilter
{
  Util$1(String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.val$extension);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.util.Util.1
 * JD-Core Version:    0.7.0.1
 */