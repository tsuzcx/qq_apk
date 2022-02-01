package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Comparator;

final class FileCategoryUtil$3
  implements Comparator<FileInfo>
{
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    return (int)(paramFileInfo2.b() / 1000L - paramFileInfo1.b() / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileCategoryUtil.3
 * JD-Core Version:    0.7.0.1
 */