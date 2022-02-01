package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Comparator;

class QfileBaseRecentFileTabView$1
  implements Comparator<FileManagerEntity>
{
  QfileBaseRecentFileTabView$1(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public int a(FileManagerEntity paramFileManagerEntity1, FileManagerEntity paramFileManagerEntity2)
  {
    if (paramFileManagerEntity2.srvTime > paramFileManagerEntity1.srvTime) {
      return 1;
    }
    if (paramFileManagerEntity2.srvTime < paramFileManagerEntity1.srvTime) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.1
 * JD-Core Version:    0.7.0.1
 */