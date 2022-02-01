package com.tencent.qg.loader;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

final class QGLoader$3
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.endsWith(".so"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.loader.QGLoader.3
 * JD-Core Version:    0.7.0.1
 */