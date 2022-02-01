package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Comparator;

final class FileCategoryUtil$1
  implements Comparator<FileInfo>
{
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    return -Long.valueOf(paramFileInfo1.g()).compareTo(Long.valueOf(paramFileInfo2.g()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileCategoryUtil.1
 * JD-Core Version:    0.7.0.1
 */