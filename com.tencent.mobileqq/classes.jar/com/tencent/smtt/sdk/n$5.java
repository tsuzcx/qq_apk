package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class n$5
  implements FileFilter
{
  n$5(n paramn) {}
  
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".dex")) && (!paramFile.getName().endsWith(".jar_is_first_load_dex_flag_file"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.n.5
 * JD-Core Version:    0.7.0.1
 */