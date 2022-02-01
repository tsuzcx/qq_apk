package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

final class EngineInstaller$1
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.endsWith(".so")) || (paramString.endsWith(".jar")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineInstaller.1
 * JD-Core Version:    0.7.0.1
 */