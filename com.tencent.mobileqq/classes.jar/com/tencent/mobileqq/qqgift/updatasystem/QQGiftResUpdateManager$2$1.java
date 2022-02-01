package com.tencent.mobileqq.qqgift.updatasystem;

import java.io.File;
import java.io.FilenameFilter;

class QQGiftResUpdateManager$2$1
  implements FilenameFilter
{
  QQGiftResUpdateManager$2$1(QQGiftResUpdateManager.2 param2) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.toLowerCase().startsWith("animation.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.updatasystem.QQGiftResUpdateManager.2.1
 * JD-Core Version:    0.7.0.1
 */