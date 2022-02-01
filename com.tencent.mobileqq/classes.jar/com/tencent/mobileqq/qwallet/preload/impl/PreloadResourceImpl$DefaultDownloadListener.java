package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class PreloadResourceImpl$DefaultDownloadListener
  extends PreloadResourceImpl.DownloadListenerWrapper
{
  public PreloadResourceImpl$DefaultDownloadListener(PreloadResourceImpl paramPreloadResourceImpl, DownloadListener paramDownloadListener)
  {
    super(paramDownloadListener);
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    int i = ResDownRecordUtil.a(paramString, 0, this.a.getFilePos());
    if (i == 0)
    {
      if (paramBoolean) {
        ResDownRecordUtil.a(paramString, 1, this.a.getFilePos());
      }
      return 1;
    }
    if (i == 1) {
      return 7;
    }
    if (paramBoolean) {
      ResDownRecordUtil.a(paramString, 1, this.a.getFilePos());
    }
    return i;
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    boolean bool = true;
    Object localObject1;
    PreloadModuleImpl localPreloadModuleImpl;
    Object localObject2;
    File localFile;
    String str;
    int i;
    if ((paramDownloadTask != null) && (paramDownloadTask.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(paramDownloadTask.jdField_a_of_type_JavaLangString)))
    {
      localObject1 = paramDownloadTask.a();
      localPreloadModuleImpl = (PreloadModuleImpl)((Bundle)localObject1).getSerializable("module");
      localObject2 = (PreloadResourceImpl)((Bundle)localObject1).getSerializable("resource");
      localFile = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.jdField_a_of_type_JavaLangString);
      if (localFile != null) {
        break label430;
      }
      localObject1 = "";
      if ((paramDownloadTask.jdField_a_of_type_Int != 0) || (localObject2 == null)) {
        break label507;
      }
      str = MD5Coding.encodeFile2HexStr((String)localObject1);
      if ((localFile == null) || (!localFile.exists()) || (TextUtils.isEmpty(str))) {
        break label502;
      }
      if ((TextUtils.isEmpty(((PreloadResourceImpl)localObject2).md5)) || (str.equalsIgnoreCase(((PreloadResourceImpl)localObject2).md5))) {
        break label440;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, "preload onDoneFile md5 not match|" + ((PreloadResourceImpl)localObject2).mResId + "|" + str + "|" + ((PreloadResourceImpl)localObject2).md5);
      }
      QWalletTools.a((String)localObject1);
      ResDownRecordUtil.a(paramDownloadTask.jdField_a_of_type_JavaLangString, 5, this.a.getFilePos());
      paramDownloadTask.jdField_a_of_type_Int = -1;
      SpringHbMonitorReporter.a(localPreloadModuleImpl, 2, paramDownloadTask.c, paramDownloadTask.jdField_a_of_type_Int);
      i = 1;
      if (paramDownloadTask.jdField_a_of_type_Int == -118) {
        i = 1;
      }
      if ((i != 0) && (localPreloadModuleImpl != null)) {
        localPreloadModuleImpl.removeResource((PreloadResourceImpl)localObject2);
      }
      localObject2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      if (paramDownloadTask.jdField_a_of_type_Int != 0) {
        break label524;
      }
    }
    for (;;)
    {
      i = a((String)localObject2, bool);
      paramDownloadTask.a().putInt("scene", i);
      if ((i == 7) && (paramDownloadTask.jdField_a_of_type_Int == 0)) {
        ResUtil.a(paramDownloadTask.jdField_a_of_type_JavaLangString, this.a.getFilePos());
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, "preload onDoneFile|" + paramDownloadTask.jdField_a_of_type_Int + "|" + paramDownloadTask.jdField_a_of_type_JavaLangString + "|" + (String)localObject1 + "|" + i);
      }
      super.onDoneFile(paramDownloadTask);
      if (this.a.isNeedReport(paramDownloadTask.jdField_a_of_type_JavaLangString)) {
        this.a.reportDownload(paramDownloadTask.jdField_a_of_type_JavaLangString, paramDownloadTask.jdField_a_of_type_Int, localPreloadModuleImpl);
      }
      return;
      label430:
      localObject1 = localFile.getAbsolutePath();
      break;
      label440:
      ResUtil.a(paramDownloadTask.jdField_a_of_type_JavaLangString, str, NetConnInfoCenter.getServerTimeMillis(), this.a.getFilePos());
      if (PreloadResourceImpl.access$000(this.a, (String)localObject1, paramDownloadTask.jdField_a_of_type_JavaLangString)) {
        this.a.unzip((String)localObject1, paramDownloadTask.jdField_a_of_type_JavaLangString);
      }
      SpringHbMonitorReporter.a(localPreloadModuleImpl, 0, paramDownloadTask.c, paramDownloadTask.jdField_a_of_type_Int);
      for (;;)
      {
        label502:
        i = 0;
        break;
        label507:
        SpringHbMonitorReporter.a(localPreloadModuleImpl, 1, paramDownloadTask.c, paramDownloadTask.jdField_a_of_type_Int);
      }
      label524:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadResourceImpl.DefaultDownloadListener
 * JD-Core Version:    0.7.0.1
 */