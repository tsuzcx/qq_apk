package com.tencent.smtt.sdk;

import android.os.Build.VERSION;
import java.io.File;
import java.io.FileFilter;

final class p$2
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    if (paramFile == null) {
      return false;
    }
    if (paramFile.endsWith(".jar_is_first_load_dex_flag_file")) {
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 21) && (paramFile.endsWith(".dex"))) {
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 26) && (paramFile.endsWith(".prof"))) {
      return false;
    }
    return (Build.VERSION.SDK_INT < 26) || (!paramFile.equals("oat"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.p.2
 * JD-Core Version:    0.7.0.1
 */