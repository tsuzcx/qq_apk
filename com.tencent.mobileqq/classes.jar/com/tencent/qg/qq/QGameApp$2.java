package com.tencent.qg.qq;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

class QGameApp$2
  implements FilenameFilter
{
  QGameApp$2(QGameApp paramQGameApp) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.endsWith(".so"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.qq.QGameApp.2
 * JD-Core Version:    0.7.0.1
 */