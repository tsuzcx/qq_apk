package com.tencent.mobileqq.qwallet.preload.impl;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.io.File;
import java.util.Map;

class PreloadComDownloader$1
  extends PreloadResourceImpl.DownloadListenerWrapper
{
  PreloadComDownloader$1(PreloadComDownloader paramPreloadComDownloader, DownloadListener paramDownloadListener)
  {
    super(paramDownloadListener);
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    long l2 = -1L;
    super.onDoneFile(paramDownloadTask);
    if ((paramDownloadTask != null) && (paramDownloadTask.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(paramDownloadTask.jdField_a_of_type_JavaLangString)))
    {
      File localFile = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.jdField_a_of_type_JavaLangString);
      if (localFile != null)
      {
        Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject != null)
        {
          localObject = (PreDownloadController)((QQAppInterface)localObject).getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
          String str = paramDownloadTask.jdField_a_of_type_JavaLangString;
          long l1 = l2;
          if (paramDownloadTask.jdField_a_of_type_Int == 0)
          {
            l1 = l2;
            if (localFile.exists()) {
              l1 = localFile.length();
            }
          }
          ((PreDownloadController)localObject).preDownloadSuccess(str, l1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadComDownloader.1
 * JD-Core Version:    0.7.0.1
 */