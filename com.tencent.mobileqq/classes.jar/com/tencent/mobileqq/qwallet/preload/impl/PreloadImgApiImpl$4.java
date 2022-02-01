package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class PreloadImgApiImpl$4
  implements ThreadExcutor.IThreadListener
{
  PreloadImgApiImpl$4(PreloadImgApiImpl paramPreloadImgApiImpl, List paramList, Map paramMap, Bundle paramBundle) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      DownloadTask localDownloadTask = new DownloadTask(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilMap, UUID.randomUUID().toString());
      localDownloadTask.a(this.jdField_a_of_type_AndroidOsBundle);
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadImgApiImpl.mDownloaderInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadImgApiImpl.mDownloaderInterface.startDownload(localDownloadTask, PreloadImgApiImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadImgApiImpl), null);
      }
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadImgApiImpl.4
 * JD-Core Version:    0.7.0.1
 */