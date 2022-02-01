package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class PtvFilterSoLoad$SVFilterSoLoadStatus
{
  private static final String[] a = { "libgnustl_shared.so", "libSNPE.so", "libQMCF_snpe.so" };
  
  private static boolean b()
  {
    String str = PtvFilterSoLoad.c();
    synchronized (PtvFilterSoLoad.i())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("libQMCF.so");
      boolean bool1 = FileUtils.fileExists(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(a[2]);
      boolean bool2 = FileUtils.fileExists(localStringBuilder.toString());
      if (QLog.isColorLevel()) {
        QLog.i("SVAF_SoLoad", 2, String.format("isArtFilterSoExist, qmcfso[%s], snpeso[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad.SVFilterSoLoadStatus
 * JD-Core Version:    0.7.0.1
 */