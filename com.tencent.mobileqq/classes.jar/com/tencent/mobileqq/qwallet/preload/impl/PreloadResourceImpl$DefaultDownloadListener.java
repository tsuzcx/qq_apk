package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
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
    if ((paramDownloadTask != null) && (paramDownloadTask.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(paramDownloadTask.jdField_a_of_type_JavaLangString)))
    {
      Object localObject1 = paramDownloadTask.a();
      PreloadModuleImpl localPreloadModuleImpl = (PreloadModuleImpl)((Bundle)localObject1).getSerializable("module");
      Object localObject2 = (PreloadResourceImpl)((Bundle)localObject1).getSerializable("resource");
      Object localObject3 = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.jdField_a_of_type_JavaLangString);
      if (localObject3 == null) {
        localObject1 = "";
      } else {
        localObject1 = ((File)localObject3).getAbsolutePath();
      }
      int i = paramDownloadTask.jdField_a_of_type_Int;
      boolean bool = false;
      if ((i == 0) && (localObject2 != null))
      {
        String str = MD5Coding.encodeFile2HexStr((String)localObject1);
        if ((localObject3 != null) && (((File)localObject3).exists()) && (!TextUtils.isEmpty(str)))
        {
          if ((!TextUtils.isEmpty(((PreloadResourceImpl)localObject2).md5)) && (!str.equalsIgnoreCase(((PreloadResourceImpl)localObject2).md5)))
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("preload onDoneFile md5 not match|");
              ((StringBuilder)localObject3).append(((PreloadResourceImpl)localObject2).mResId);
              ((StringBuilder)localObject3).append("|");
              ((StringBuilder)localObject3).append(str);
              ((StringBuilder)localObject3).append("|");
              ((StringBuilder)localObject3).append(((PreloadResourceImpl)localObject2).md5);
              QLog.d("PreloadResource", 2, ((StringBuilder)localObject3).toString());
            }
            QWalletTools.a((String)localObject1);
            ResDownRecordUtil.a(paramDownloadTask.jdField_a_of_type_JavaLangString, 5, this.a.getFilePos());
            paramDownloadTask.jdField_a_of_type_Int = -1;
            i = 1;
            break label316;
          }
          ResUtil.a(paramDownloadTask.jdField_a_of_type_JavaLangString, str, NetConnInfoCenter.getServerTimeMillis(), this.a.getFilePos());
          if (PreloadResourceImpl.access$000(this.a, (String)localObject1, paramDownloadTask.jdField_a_of_type_JavaLangString)) {
            this.a.unzip((String)localObject1, paramDownloadTask.jdField_a_of_type_JavaLangString);
          }
        }
      }
      i = 0;
      label316:
      if (paramDownloadTask.jdField_a_of_type_Int == -118) {
        i = 1;
      }
      if ((i != 0) && (localPreloadModuleImpl != null)) {
        localPreloadModuleImpl.removeResource((PreloadResourceImpl)localObject2);
      }
      localObject2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      if (paramDownloadTask.jdField_a_of_type_Int == 0) {
        bool = true;
      }
      i = a((String)localObject2, bool);
      paramDownloadTask.a().putInt("scene", i);
      if ((i == 7) && (paramDownloadTask.jdField_a_of_type_Int == 0)) {
        ResUtil.a(paramDownloadTask.jdField_a_of_type_JavaLangString, this.a.getFilePos());
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("preload onDoneFile|");
        ((StringBuilder)localObject2).append(paramDownloadTask.jdField_a_of_type_Int);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(paramDownloadTask.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(i);
        QLog.d("PreloadResource", 2, ((StringBuilder)localObject2).toString());
      }
      super.onDoneFile(paramDownloadTask);
      if (this.a.isNeedReport(paramDownloadTask.jdField_a_of_type_JavaLangString)) {
        this.a.reportDownload(paramDownloadTask.jdField_a_of_type_JavaLangString, paramDownloadTask.jdField_a_of_type_Int, localPreloadModuleImpl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadResourceImpl.DefaultDownloadListener
 * JD-Core Version:    0.7.0.1
 */