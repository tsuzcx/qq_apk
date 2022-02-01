package com.tencent.mobileqq.qqlive.filter;

import java.io.File;
import java.io.FilenameFilter;

class QQLiveAEResManager$5
  implements FilenameFilter
{
  QQLiveAEResManager$5(QQLiveAEResManager paramQQLiveAEResManager) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.toLowerCase().endsWith(".png");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.QQLiveAEResManager.5
 * JD-Core Version:    0.7.0.1
 */