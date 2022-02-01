package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;

class MMApkFileSafeChecker$CheckTask$1
  implements MMApkFileSafeChecker.IGetDigestResult
{
  MMApkFileSafeChecker$CheckTask$1(MMApkFileSafeChecker.CheckTask paramCheckTask, long paramLong) {}
  
  public void a(boolean paramBoolean, MMApkFileSafeChecker.FileDigestInfo paramFileDigestInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$CheckTask.jdField_a_of_type_Boolean) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$CheckTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.f = HexUtil.bytes2HexStr(paramFileDigestInfo.a);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$CheckTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.g = HexUtil.bytes2HexStr(paramFileDigestInfo.b);
    }
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$CheckTask.jdField_a_of_type_Int + "> on get digest result:" + paramBoolean + " cost:" + (l1 - l2) + " fileMd5:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$CheckTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.f + " fileSha:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$CheckTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.g);
    new Handler(Looper.getMainLooper()).post(new MMApkFileSafeChecker.CheckTask.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.1
 * JD-Core Version:    0.7.0.1
 */