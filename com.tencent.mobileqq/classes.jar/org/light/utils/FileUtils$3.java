package org.light.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

final class FileUtils$3
  implements FileUtils.AssetFileComparator
{
  public boolean equals(Context paramContext, String paramString, File paramFile)
  {
    paramContext = FileUtils.getAssetsMD5(paramContext, paramString, "aekit");
    paramString = FileUtils.getMD5(paramFile.getAbsolutePath(), "aekit");
    if ((TextUtils.isEmpty(paramContext)) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    return paramContext.equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.utils.FileUtils.3
 * JD-Core Version:    0.7.0.1
 */