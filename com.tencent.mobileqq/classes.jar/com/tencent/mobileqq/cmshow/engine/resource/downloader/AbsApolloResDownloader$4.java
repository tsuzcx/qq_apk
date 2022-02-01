package com.tencent.mobileqq.cmshow.engine.resource.downloader;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class AbsApolloResDownloader$4
  extends DownloadListener
{
  AbsApolloResDownloader$4(AbsApolloResDownloader paramAbsApolloResDownloader, String paramString, IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener, File paramFile) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.d.b();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkDownloadFaceData onDone url");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" task.getStatus():");
      localStringBuilder.append(paramDownloadTask.e());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (3 != paramDownloadTask.e())
    {
      paramDownloadTask = this.b;
      if (paramDownloadTask != null) {
        paramDownloadTask.a(false, AbsApolloResDownloader.c);
      }
      return;
    }
    if (!CMResUtil.b(this.c))
    {
      paramDownloadTask = this.b;
      if (paramDownloadTask != null) {
        paramDownloadTask.a(false, AbsApolloResDownloader.b);
      }
      return;
    }
    try
    {
      paramDownloadTask = this.c;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.c.getParent());
      ((StringBuilder)localObject).append(File.separator);
      ZipUtils.unZipFile(paramDownloadTask, ((StringBuilder)localObject).toString());
      if (this.b != null) {
        this.b.a(true, 0);
      }
      return;
    }
    catch (OutOfMemoryError paramDownloadTask)
    {
      this.c.delete();
      localObject = this.d.b();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkDownloadFaceData unZipFile file error->");
      localStringBuilder.append(paramDownloadTask);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
      paramDownloadTask = this.b;
      if (paramDownloadTask != null)
      {
        paramDownloadTask.a(false, AbsApolloResDownloader.a);
        return;
      }
    }
    catch (Exception paramDownloadTask)
    {
      this.c.delete();
      QLog.e(this.d.b(), 1, "checkDownloadFaceData unZipFile file error->", paramDownloadTask);
      paramDownloadTask = this.b;
      if (paramDownloadTask != null) {
        paramDownloadTask.a(false, AbsApolloResDownloader.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.downloader.AbsApolloResDownloader.4
 * JD-Core Version:    0.7.0.1
 */