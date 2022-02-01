package com.tencent.mobileqq.troop.homework.recite.utils;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class SoLibraryChecker$3
  extends DownloadListener
{
  SoLibraryChecker$3(SoLibraryChecker paramSoLibraryChecker, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate loaded json = " + paramDownloadTask.c + " code = " + paramDownloadTask.jdField_a_of_type_Int);
    }
    boolean bool = SoLibraryChecker.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsSoLibraryChecker, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate unCompressOffline " + bool);
    }
    SoLibraryChecker.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsSoLibraryChecker);
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    int i = (int)(paramDownloadTask.jdField_a_of_type_Float * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel())) {
      QLog.d("SoLibraryLoader", 2, "downding progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker.3
 * JD-Core Version:    0.7.0.1
 */