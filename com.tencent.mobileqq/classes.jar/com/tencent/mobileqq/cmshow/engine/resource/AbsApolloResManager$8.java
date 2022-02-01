package com.tencent.mobileqq.cmshow.engine.resource;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.model.ApolloPreDownloadData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class AbsApolloResManager$8
  extends DownloadListener
{
  AbsApolloResManager$8(AbsApolloResManager paramAbsApolloResManager) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    if (paramDownloadTask.c != 0)
    {
      QLog.e("[cmshow]cm_res", 1, new Object[] { "preDownloadListener task error:", Integer.valueOf(paramDownloadTask.e()) });
      return;
    }
    String str = paramDownloadTask.h;
    paramDownloadTask = paramDownloadTask.b();
    if (paramDownloadTask != null)
    {
      ApolloPreDownloadData localApolloPreDownloadData = (ApolloPreDownloadData)paramDownloadTask.getSerializable(str);
      if (localApolloPreDownloadData == null)
      {
        QLog.e("[cmshow]cm_res", 1, "preDownloadListener res onDoneFile but preDownload data is null");
        return;
      }
      if (!TextUtils.isEmpty(localApolloPreDownloadData.zipDir))
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append(this.a.d(localApolloPreDownloadData.dirType));
        localObject = localApolloPreDownloadData.zipDir;
      }
      else
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/pre_download/");
        paramDownloadTask.append(localApolloPreDownloadData.resId);
        localObject = ".zip";
      }
      paramDownloadTask.append((String)localObject);
      paramDownloadTask = paramDownloadTask.toString();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.d(localApolloPreDownloadData.dirType));
      ((StringBuilder)localObject).append(localApolloPreDownloadData.dir);
      localObject = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]cm_res", 2, new Object[] { "preDownloadListener res zip done reportId:", localApolloPreDownloadData.reportId, ", url:", str });
      }
      ThreadManager.getSubThreadHandler().post(new AbsApolloResManager.8.1(this, localApolloPreDownloadData, paramDownloadTask, (String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.8
 * JD-Core Version:    0.7.0.1
 */