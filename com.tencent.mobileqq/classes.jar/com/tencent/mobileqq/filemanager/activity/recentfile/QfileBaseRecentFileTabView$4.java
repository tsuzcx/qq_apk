package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import java.util.Comparator;

class QfileBaseRecentFileTabView$4
  implements Comparator<OfflineFileInfo>
{
  QfileBaseRecentFileTabView$4(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public int a(OfflineFileInfo paramOfflineFileInfo1, OfflineFileInfo paramOfflineFileInfo2)
  {
    return Long.valueOf(paramOfflineFileInfo1.c).compareTo(Long.valueOf(paramOfflineFileInfo2.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.4
 * JD-Core Version:    0.7.0.1
 */