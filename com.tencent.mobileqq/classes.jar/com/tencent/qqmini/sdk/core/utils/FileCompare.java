package com.tencent.qqmini.sdk.core.utils;

import java.util.Comparator;

public class FileCompare
  implements Comparator<FileInfo>
{
  public int compare(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    if (paramFileInfo1.isDirectory())
    {
      if (!paramFileInfo2.isDirectory()) {
        return -1000;
      }
    }
    else if (paramFileInfo2.isDirectory()) {
      return 1000;
    }
    return paramFileInfo1.getName().compareToIgnoreCase(paramFileInfo2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.FileCompare
 * JD-Core Version:    0.7.0.1
 */