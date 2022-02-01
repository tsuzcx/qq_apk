package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Comparator;

class FileManagerUtilImpl$2
  implements Comparator<FileInfo>
{
  FileManagerUtilImpl$2(FileManagerUtilImpl paramFileManagerUtilImpl) {}
  
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    return (int)(paramFileInfo2.b() / 1000L - paramFileInfo1.b() / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FileManagerUtilImpl.2
 * JD-Core Version:    0.7.0.1
 */