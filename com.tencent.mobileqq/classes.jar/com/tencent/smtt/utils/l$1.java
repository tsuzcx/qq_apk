package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;

final class l$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (!TextUtils.isEmpty(paramFile)) && (paramFile.endsWith(".dex"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.utils.l.1
 * JD-Core Version:    0.7.0.1
 */