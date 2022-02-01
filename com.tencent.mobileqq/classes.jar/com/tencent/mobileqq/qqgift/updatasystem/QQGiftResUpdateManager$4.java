package com.tencent.mobileqq.qqgift.updatasystem;

import java.io.File;
import java.io.FilenameFilter;

class QQGiftResUpdateManager$4
  implements FilenameFilter
{
  QQGiftResUpdateManager$4(QQGiftResUpdateManager paramQQGiftResUpdateManager) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.toLowerCase().startsWith("animation.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.updatasystem.QQGiftResUpdateManager.4
 * JD-Core Version:    0.7.0.1
 */