package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class SoLibraryChecker$2
  implements AsyncCallBack
{
  SoLibraryChecker$2(SoLibraryChecker paramSoLibraryChecker, long paramLong) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("transToLocalUrl loadMode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", time:");
      localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      QLog.i("SoLibraryLoader", 2, localStringBuilder.toString());
    }
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("transToLocalUrl transUrl:");
      localStringBuilder.append(paramString);
      QLog.i("SoLibraryLoader", 4, localStringBuilder.toString());
    }
    paramString = new StringBuilder();
    paramString.append(OfflineEnvHelper.a(SoLibraryChecker.a(this.jdField_a_of_type_ComTencentMobileqqUtilsSoLibraryChecker)));
    paramString.append(SoLibraryChecker.a(this.jdField_a_of_type_ComTencentMobileqqUtilsSoLibraryChecker));
    paramString.append(File.separator);
    paramString.append(SoLibraryChecker.b(this.jdField_a_of_type_ComTencentMobileqqUtilsSoLibraryChecker));
    paramString = paramString.toString();
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file not exist! path = ");
        localStringBuilder.append(paramString);
        QLog.e("SoLibraryLoader", 2, localStringBuilder.toString());
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SoLibraryChecker.a(this.jdField_a_of_type_ComTencentMobileqqUtilsSoLibraryChecker).getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(SoLibraryChecker.b(this.jdField_a_of_type_ComTencentMobileqqUtilsSoLibraryChecker));
    FileUtils.copyFile(paramString, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoLibraryChecker.2
 * JD-Core Version:    0.7.0.1
 */