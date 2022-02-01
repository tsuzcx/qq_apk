package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.DownloadCallback;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

class PreloadServiceImpl$6
  extends DownloadListener
{
  PreloadServiceImpl$6(PreloadServiceImpl paramPreloadServiceImpl, IPreloadService.DownloadCallback paramDownloadCallback) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    int i = -5;
    super.onDoneFile(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "downloadRes|done" + paramDownloadTask.jdField_a_of_type_JavaLangString + "|" + paramDownloadTask.jdField_a_of_type_Int);
    }
    Object localObject = paramDownloadTask.a();
    PreloadModuleImpl localPreloadModuleImpl = (PreloadModuleImpl)((Bundle)localObject).getSerializable("module");
    localObject = (PreloadResourceImpl)((Bundle)localObject).getSerializable("resource");
    if (paramDownloadTask.jdField_a_of_type_Int == 0)
    {
      i = 0;
      if (localObject != null) {
        break label146;
      }
    }
    label146:
    for (localObject = null;; localObject = ((PreloadResourceImpl)localObject).getResInfo(localPreloadModuleImpl))
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$DownloadCallback.onDownloadResFinished(localPreloadModuleImpl.mid, i, ((File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.jdField_a_of_type_JavaLangString)).getAbsolutePath(), (ResourceInfo)localObject);
      return;
      if (paramDownloadTask.jdField_a_of_type_Int == -5) {
        break;
      }
      i = -6;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.6
 * JD-Core Version:    0.7.0.1
 */