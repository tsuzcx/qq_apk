package com.tencent.mobileqq.filemanager.activity.favfile;

import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;

class QfileFavFileRecordProvider$FileRecordGroup
{
  ArrayList<FavFileInfo> a = new ArrayList();
  ArrayList<FavFileInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList<FavFileInfo> c = new ArrayList();
  ArrayList<FavFileInfo> d = new ArrayList();
  ArrayList<FavFileInfo> e = new ArrayList();
  
  QfileFavFileRecordProvider$FileRecordGroup(QfileFavFileRecordProvider paramQfileFavFileRecordProvider) {}
  
  ArrayList<FavFileInfo> a(String paramString)
  {
    int i = FileManagerUtil.a(paramString);
    if (i == 0) {
      return this.a;
    }
    if ((i == 3) || (i == 6) || (i == 7) || (i == 9) || (i == 10)) {
      return this.jdField_b_of_type_JavaUtilArrayList;
    }
    if (i == 2) {
      return this.c;
    }
    if (i == 5) {
      return this.d;
    }
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.FileRecordGroup
 * JD-Core Version:    0.7.0.1
 */