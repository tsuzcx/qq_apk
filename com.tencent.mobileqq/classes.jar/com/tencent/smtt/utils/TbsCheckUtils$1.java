package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;

final class TbsCheckUtils$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (!TextUtils.isEmpty(paramFile)) && (paramFile.endsWith(".dex"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsCheckUtils.1
 * JD-Core Version:    0.7.0.1
 */