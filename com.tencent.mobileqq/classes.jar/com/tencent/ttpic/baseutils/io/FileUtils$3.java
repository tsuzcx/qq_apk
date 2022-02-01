package com.tencent.ttpic.baseutils.io;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.io.FileUtils.3
 * JD-Core Version:    0.7.0.1
 */