package com.tencent.mobileqq.vas.updatesystem.impl;

import android.os.Bundle;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.vas.update.callback.listener.IDownloadListener;

class VasHttpDownloaderImpl$2
  extends DownloadListener
{
  VasHttpDownloaderImpl$2(VasHttpDownloaderImpl paramVasHttpDownloaderImpl) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    int j = 0;
    if ((VasHttpDownloaderImpl.a(this.a) == null) || (paramDownloadTask == null)) {
      return;
    }
    Object localObject;
    String str;
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.jdField_a_of_type_Int == 0))
    {
      i = 1;
      localObject = paramDownloadTask.a();
      if ((localObject != null) && (((Bundle)localObject).getString("from") != null) && (((Bundle)localObject).getString("from").contains("silent_download"))) {
        VasHttpDownloaderImpl.a(this.a, paramDownloadTask.c, paramDownloadTask.jdField_a_of_type_Long);
      }
      localObject = VasHttpDownloaderImpl.a(this.a);
      str = paramDownloadTask.jdField_a_of_type_JavaLangString;
      if (i == 0) {
        break label130;
      }
    }
    label130:
    for (int i = j;; i = 8)
    {
      ((IDownloadListener)localObject).onCompleted(str, i, paramDownloadTask.jdField_a_of_type_Int, paramDownloadTask.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
      break;
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    if ((VasHttpDownloaderImpl.a(this.a) != null) && (paramDownloadTask != null)) {
      VasHttpDownloaderImpl.a(this.a).onProgress(paramDownloadTask.jdField_a_of_type_JavaLangString, paramDownloadTask.jdField_b_of_type_Long, paramDownloadTask.jdField_a_of_type_Long, (int)paramDownloadTask.jdField_a_of_type_Float);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return false;
    }
    if (VasHttpDownloaderImpl.a(this.a) != null) {
      VasHttpDownloaderImpl.a(this.a).onDownloadStart(paramDownloadTask.jdField_a_of_type_JavaLangString);
    }
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.impl.VasHttpDownloaderImpl.2
 * JD-Core Version:    0.7.0.1
 */