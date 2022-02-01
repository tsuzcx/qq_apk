package com.tencent.mobileqq.qwallet.preload.impl;

import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

class PreloadServiceImpl$2
  extends DownloadListener
{
  PreloadServiceImpl$2(PreloadServiceImpl paramPreloadServiceImpl, DownloadParam paramDownloadParam, IPreloadService.OnGetPathListener paramOnGetPathListener, WeakReference paramWeakReference) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    super.onDoneFile(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "RealTime onDoneFile|" + paramDownloadTask.jdField_a_of_type_Int + "|" + paramDownloadTask.jdField_a_of_type_JavaLangString + "|" + ((File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.jdField_a_of_type_JavaLangString)).getAbsolutePath());
    }
    Object localObject2;
    Object localObject1;
    if ((paramDownloadTask.jdField_a_of_type_Int == 0) && (paramDownloadTask.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(paramDownloadTask.jdField_a_of_type_JavaLangString)))
    {
      localObject2 = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.jdField_a_of_type_JavaLangString);
      if (localObject2 == null)
      {
        localObject1 = "";
        localObject1 = MD5Coding.encodeFile2HexStr((String)localObject1);
        if ((localObject2 == null) || (!((File)localObject2).exists()) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label266;
        }
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.md5ForChecked)) || (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.md5ForChecked.equalsIgnoreCase((String)localObject1))) {
          break label236;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$OnGetPathListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$OnGetPathListener.onResult(2, IPreloadService.PathResult.getFailRes(paramDownloadTask.jdField_a_of_type_JavaLangString));
        }
        PreloadStaticApi.a(paramDownloadTask.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.filePos);
        SpringHbMonitorReporter.a(2, paramDownloadTask.c, paramDownloadTask.jdField_a_of_type_Int);
      }
    }
    label236:
    label376:
    label378:
    do
    {
      for (;;)
      {
        return;
        localObject1 = ((File)localObject2).getAbsolutePath();
        break;
        ResUtil.a(paramDownloadTask.jdField_a_of_type_JavaLangString, (String)localObject1, NetConnInfoCenter.getServerTimeMillis(), this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.filePos);
        SpringHbMonitorReporter.a(0, paramDownloadTask.c, paramDownloadTask.jdField_a_of_type_Int);
        for (;;)
        {
          if (!PreloadServiceImpl.isManagerValid((PreloadServiceImpl)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
            break label376;
          }
          if (paramDownloadTask.jdField_a_of_type_Int != 0) {
            break label378;
          }
          localObject1 = ResUtil.a(paramDownloadTask.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.isForceUnzip, 0, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadDownloadParam.filePos);
          localObject2 = new IPreloadService.PathResult();
          ((IPreloadService.PathResult)localObject2).url = paramDownloadTask.jdField_a_of_type_JavaLangString;
          ((IPreloadService.PathResult)localObject2).filePath = ((ResourceInfo)localObject1).filePath;
          ((IPreloadService.PathResult)localObject2).folderPath = ((ResourceInfo)localObject1).folderPath;
          if (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$OnGetPathListener == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$OnGetPathListener.onResult(0, (IPreloadService.PathResult)localObject2);
          return;
          SpringHbMonitorReporter.a(1, paramDownloadTask.c, paramDownloadTask.jdField_a_of_type_Int);
        }
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$OnGetPathListener == null);
    label266:
    this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$OnGetPathListener.onResult(1, IPreloadService.PathResult.getFailRes(paramDownloadTask.jdField_a_of_type_JavaLangString, paramDownloadTask.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */