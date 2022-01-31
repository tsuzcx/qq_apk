package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class TbsInstaller$5
  implements FileFilter
{
  TbsInstaller$5(TbsInstaller paramTbsInstaller) {}
  
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".dex")) && (!paramFile.getName().endsWith(".jar_is_first_load_dex_flag_file"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsInstaller.5
 * JD-Core Version:    0.7.0.1
 */