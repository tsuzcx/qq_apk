package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import java.util.Comparator;

class QfileLocalFileDelMediaTabView$1$1
  implements Comparator<Long>
{
  QfileLocalFileDelMediaTabView$1$1(QfileLocalFileDelMediaTabView.1 param1) {}
  
  public int a(Long paramLong1, Long paramLong2)
  {
    if (paramLong1.equals(paramLong2)) {
      return 1;
    }
    return (int)(paramLong1.longValue() - paramLong2.longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView.1.1
 * JD-Core Version:    0.7.0.1
 */