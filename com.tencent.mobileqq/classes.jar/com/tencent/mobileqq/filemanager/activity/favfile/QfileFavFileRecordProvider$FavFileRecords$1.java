package com.tencent.mobileqq.filemanager.activity.favfile;

import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import java.util.Comparator;

class QfileFavFileRecordProvider$FavFileRecords$1
  implements Comparator<FavFileInfo>
{
  QfileFavFileRecordProvider$FavFileRecords$1(QfileFavFileRecordProvider.FavFileRecords paramFavFileRecords) {}
  
  public int a(FavFileInfo paramFavFileInfo1, FavFileInfo paramFavFileInfo2)
  {
    if (paramFavFileInfo2.c > paramFavFileInfo1.c) {
      return 1;
    }
    if (paramFavFileInfo2.c < paramFavFileInfo1.c) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.FavFileRecords.1
 * JD-Core Version:    0.7.0.1
 */