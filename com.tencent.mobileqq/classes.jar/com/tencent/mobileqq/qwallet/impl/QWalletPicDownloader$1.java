package com.tencent.mobileqq.qwallet.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

class QWalletPicDownloader$1
  implements IPreloadService.OnGetPathListener
{
  QWalletPicDownloader$1(QWalletPicDownloader paramQWalletPicDownloader, File paramFile, AtomicBoolean paramAtomicBoolean) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult arg2)
  {
    if ((paramInt != 0) || (TextUtils.isEmpty(???.filePath)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadImage file not succeed, pathRes=");
      localStringBuilder.append(???);
      QLog.e("QWalletPicDownloader", 2, localStringBuilder.toString());
    }
    synchronized (this.jdField_a_of_type_JavaIoFile)
    {
      this.jdField_a_of_type_JavaIoFile.notify();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletPicDownloader.1
 * JD-Core Version:    0.7.0.1
 */