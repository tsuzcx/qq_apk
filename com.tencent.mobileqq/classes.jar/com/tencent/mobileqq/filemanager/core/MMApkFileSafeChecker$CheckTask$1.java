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
    paramFileDigestInfo = new StringBuilder();
    paramFileDigestInfo.append("[MMApkCheck] <");
    paramFileDigestInfo.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$CheckTask.jdField_a_of_type_Int);
    paramFileDigestInfo.append("> on get digest result:");
    paramFileDigestInfo.append(paramBoolean);
    paramFileDigestInfo.append(" cost:");
    paramFileDigestInfo.append(l1 - l2);
    paramFileDigestInfo.append(" fileMd5:");
    paramFileDigestInfo.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$CheckTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.f);
    paramFileDigestInfo.append(" fileSha:");
    paramFileDigestInfo.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$CheckTask.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.g);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, paramFileDigestInfo.toString());
    new Handler(Looper.getMainLooper()).post(new MMApkFileSafeChecker.CheckTask.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.1
 * JD-Core Version:    0.7.0.1
 */