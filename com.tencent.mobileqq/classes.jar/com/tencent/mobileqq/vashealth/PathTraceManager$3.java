package com.tencent.mobileqq.vashealth;

import android.net.Uri;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class PathTraceManager$3
  extends DownloadListener
{
  PathTraceManager$3(PathTraceManager paramPathTraceManager, String paramString1, String paramString2) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("PathTraceManager", 1, "voice down");
    }
    paramDownloadTask = new File(this.jdField_a_of_type_JavaLangString);
    try
    {
      ZipUtils.unZipFile(paramDownloadTask, PathTraceManager.a(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager));
      i = 1;
    }
    catch (IOException paramDownloadTask)
    {
      for (;;)
      {
        QLog.i("PathTraceManager", 1, "unzip fail");
        int i = 0;
      }
    }
    if (i != 0)
    {
      QLog.d("PathTraceManager", 1, "unzip success");
      if (this.b != null) {
        AudioUtil.a(Uri.fromFile(new File(PathTraceManager.a(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager), this.b + ".mp3")), false, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.PathTraceManager.3
 * JD-Core Version:    0.7.0.1
 */