package com.tencent.qqmini.sdk.core.utils;

import java.util.Comparator;

public class FileUtils$MyFileCompare
  implements Comparator<FileInfo>
{
  public int compare(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    if (paramFileInfo1.isDirectory())
    {
      if (!paramFileInfo2.isDirectory()) {
        return -1;
      }
    }
    else if (paramFileInfo2.isDirectory()) {
      return 1;
    }
    if (paramFileInfo1.getDate() > paramFileInfo2.getDate()) {
      return -1;
    }
    if (paramFileInfo1.getDate() == paramFileInfo2.getDate()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.FileUtils.MyFileCompare
 * JD-Core Version:    0.7.0.1
 */