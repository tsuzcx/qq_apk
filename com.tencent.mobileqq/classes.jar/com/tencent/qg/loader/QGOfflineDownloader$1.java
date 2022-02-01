package com.tencent.qg.loader;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class QGOfflineDownloader$1
  implements AsyncBack
{
  public void loaded(String paramString, int paramInt)
  {
    if (((paramInt != 0) || (paramString == null) || (!paramString.contains("url"))) && (paramInt != 7)) {
      QGLoader.a.set(false);
    }
    this.jdField_a_of_type_ComTencentQgLoaderQGOfflineDownloader.a = -1;
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    default: 
      this.jdField_a_of_type_ComTencentQgLoaderQGOfflineDownloader.a(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QGDownloader.offline", 2, new Object[] { "onSoDownload loaded. code = ", Integer.valueOf(paramInt), ", param1:", paramString, ", DownloadStatus = " + this.jdField_a_of_type_ComTencentQgLoaderQGOfflineDownloader.a });
      }
      return;
      this.jdField_a_of_type_ComTencentQgLoaderQGOfflineDownloader.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
      continue;
      if (paramString == null) {
        this.jdField_a_of_type_ComTencentQgLoaderQGOfflineDownloader.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
      }
    }
  }
  
  public void progress(int paramInt)
  {
    this.jdField_a_of_type_ComTencentQgLoaderQGOfflineDownloader.a(this.jdField_a_of_type_JavaLangString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qg.loader.QGOfflineDownloader.1
 * JD-Core Version:    0.7.0.1
 */