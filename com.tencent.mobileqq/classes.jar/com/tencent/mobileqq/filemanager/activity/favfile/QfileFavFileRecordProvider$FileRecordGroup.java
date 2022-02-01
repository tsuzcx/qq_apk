package com.tencent.mobileqq.filemanager.activity.favfile;

import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import java.util.ArrayList;

class QfileFavFileRecordProvider$FileRecordGroup
{
  ArrayList<FavFileInfo> a = new ArrayList();
  ArrayList<FavFileInfo> b = new ArrayList();
  ArrayList<FavFileInfo> c = new ArrayList();
  ArrayList<FavFileInfo> d = new ArrayList();
  ArrayList<FavFileInfo> e = new ArrayList();
  
  ArrayList<FavFileInfo> a(String paramString)
  {
    int i = QQFileManagerUtil.b(paramString);
    if (i == 0) {
      return this.a;
    }
    if ((i != 3) && (i != 6) && (i != 7) && (i != 9) && (i != 10))
    {
      if (i == 2) {
        return this.c;
      }
      if (i == 5) {
        return this.d;
      }
      return this.e;
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.FileRecordGroup
 * JD-Core Version:    0.7.0.1
 */