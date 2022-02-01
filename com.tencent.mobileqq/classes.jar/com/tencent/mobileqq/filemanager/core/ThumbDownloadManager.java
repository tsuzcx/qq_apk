package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ThumbDownloadManager
{
  private Handler a;
  private QQAppInterface b;
  private LinkedHashMap<String, ThumbDownloadManager.ThumbTask> c = new LinkedHashMap();
  private List<ThumbDownloadManager.ThumbTask> d = new ArrayList();
  private List<String> e = new ArrayList();
  private HttpThumbDownloader.ThumbEventCallback f = new ThumbDownloadManager.4(this);
  
  public ThumbDownloadManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.a = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private void a()
  {
    this.a.post(new ThumbDownloadManager.3(this));
  }
  
  private void a(ThumbDownloadManager.ThumbTask paramThumbTask)
  {
    if (paramThumbTask == null) {
      return;
    }
    this.c.put(paramThumbTask.a, paramThumbTask);
    if (QLog.isColorLevel())
    {
      paramThumbTask = new StringBuilder();
      paramThumbTask.append("addDownloadingTask : MapDowloadingTask currentSize[");
      paramThumbTask.append(this.c.size());
      paramThumbTask.append("]");
      QLog.i("ThumbDownloadManager", 2, paramThumbTask.toString());
    }
  }
  
  private void a(String paramString)
  {
    this.a.post(new ThumbDownloadManager.2(this, paramString));
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (this.e.contains(paramString2)) {
      return false;
    }
    return !FileUtil.b(paramString1);
  }
  
  private void b(ThumbDownloadManager.ThumbTask paramThumbTask)
  {
    if (paramThumbTask == null) {
      return;
    }
    new HttpThumbDownloader(this.b).a(paramThumbTask.c, paramThumbTask.b, paramThumbTask.a, this.f);
  }
  
  private void b(String paramString)
  {
    this.c.remove(paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("removeDownloadingTask : MapDowloadingTask currentSize[");
      paramString.append(this.c.size());
      paramString.append("]");
      QLog.i("ThumbDownloadManager", 2, paramString.toString());
    }
  }
  
  private boolean b(long paramLong, String paramString1, String paramString2)
  {
    paramString2 = FileManagerUtil.u(paramString2);
    if (!a(paramString1, paramString2)) {
      return false;
    }
    ThumbDownloadManager.ThumbTask localThumbTask = new ThumbDownloadManager.ThumbTask();
    localThumbTask.b = paramString1;
    localThumbTask.a = paramString2;
    localThumbTask.c = paramLong;
    this.e.add(paramString2);
    this.d.add(localThumbTask);
    return true;
  }
  
  private void c(String paramString)
  {
    if (!this.e.remove(paramString))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeDownloadingList : ListDownloadTask remove task fail, thumbUrl[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("ThumbDownloadManager", 2, localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("removeDownloadingList : ListDownloadTask currentSize[");
      paramString.append(this.e.size());
      paramString.append("]");
      QLog.i("ThumbDownloadManager", 2, paramString.toString());
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    this.a.post(new ThumbDownloadManager.1(this, paramLong, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownloadManager
 * JD-Core Version:    0.7.0.1
 */