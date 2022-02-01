package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Comparator;

public class FileUtil$MyFileCompare
  implements Comparator<FileInfo>
{
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    if (paramFileInfo1.d())
    {
      if (!paramFileInfo2.d()) {
        return -1;
      }
    }
    else if (paramFileInfo2.d()) {
      return 1;
    }
    if (paramFileInfo1.b() > paramFileInfo2.b()) {
      return -1;
    }
    if (paramFileInfo1.b() == paramFileInfo2.b()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileUtil.MyFileCompare
 * JD-Core Version:    0.7.0.1
 */