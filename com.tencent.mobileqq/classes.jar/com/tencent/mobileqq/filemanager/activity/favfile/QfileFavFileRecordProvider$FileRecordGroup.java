package com.tencent.mobileqq.filemanager.activity.favfile;

import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import java.util.ArrayList;

class QfileFavFileRecordProvider$FileRecordGroup
{
  ArrayList<FavFileInfo> d = new ArrayList();
  ArrayList<FavFileInfo> e = new ArrayList();
  ArrayList<FavFileInfo> f = new ArrayList();
  ArrayList<FavFileInfo> g = new ArrayList();
  ArrayList<FavFileInfo> h = new ArrayList();
  
  ArrayList<FavFileInfo> a(String paramString)
  {
    int i = QQFileManagerUtil.k(paramString);
    if (i == 0) {
      return this.d;
    }
    if ((i != 3) && (i != 6) && (i != 7) && (i != 9) && (i != 10))
    {
      if (i == 2) {
        return this.f;
      }
      if (i == 5) {
        return this.g;
      }
      return this.h;
    }
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.FileRecordGroup
 * JD-Core Version:    0.7.0.1
 */