package com.tencent.tvkbeacon.d;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class ModuleImpl$a
  implements FileFilter
{
  ModuleImpl$a(ModuleImpl paramModuleImpl) {}
  
  public final boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.d.ModuleImpl.a
 * JD-Core Version:    0.7.0.1
 */