package com.tencent.mobileqq.qqgift.updatasystem;

import java.io.File;
import java.io.FilenameFilter;

class QQGiftResUpdateManager$3$1
  implements FilenameFilter
{
  QQGiftResUpdateManager$3$1(QQGiftResUpdateManager.3 param3) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.toLowerCase().startsWith("animation.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.updatasystem.QQGiftResUpdateManager.3.1
 * JD-Core Version:    0.7.0.1
 */