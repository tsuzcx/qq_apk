package com.tencent.mobileqq.testassister;

import android.text.format.Time;
import java.io.File;
import java.io.FilenameFilter;

class ShareAppLogHelper$3
  implements FilenameFilter
{
  ShareAppLogHelper$3(ShareAppLogHelper paramShareAppLogHelper) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if ((!paramString.endsWith(".log")) && (!paramString.endsWith(".zip")) && (!paramString.endsWith(".qlog"))) {
      return false;
    }
    paramFile = ShareAppLogHelper.a(this.a, paramString);
    if ((paramFile != null) && (paramFile.toMillis(false) >= ShareAppLogHelper.a(this.a).toMillis(false))) {
      return paramFile.toMillis(false) <= ShareAppLogHelper.b(this.a).toMillis(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.testassister.ShareAppLogHelper.3
 * JD-Core Version:    0.7.0.1
 */