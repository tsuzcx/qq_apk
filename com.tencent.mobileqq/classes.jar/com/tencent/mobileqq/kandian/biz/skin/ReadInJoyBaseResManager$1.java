package com.tencent.mobileqq.kandian.biz.skin;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.skin.entity.BaseResData;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class ReadInJoyBaseResManager$1
  extends DownloadListener
{
  ReadInJoyBaseResManager$1(ReadInJoyBaseResManager paramReadInJoyBaseResManager, String paramString1, BaseResData paramBaseResData, String paramString2) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    int i = 0;
    while (i < this.d.e.size())
    {
      ((DownloadListener)this.d.e.get(i)).onCancel(paramDownloadTask);
      i += 1;
    }
    String str = paramDownloadTask.b().getString("resId");
    HashMap localHashMap = this.d.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    localHashMap.remove(localStringBuilder.toString());
    super.onCancel(paramDownloadTask);
    this.d.a("onCancel", paramDownloadTask);
    QLog.d("readinjoy", 2, "mDownloader onCancel");
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Object localObject1 = paramDownloadTask.b();
    String str = ((Bundle)localObject1).getString("resId");
    localObject1 = ((Bundle)localObject1).getString("prefix");
    if (paramDownloadTask.c == 0)
    {
      if (!ReadInJoyBaseResManager.a(this.d, this.a, (String)localObject1, this.b, str, paramDownloadTask)) {}
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("downloadGuide failed: id = ");
      ((StringBuilder)localObject2).append(str);
      QLog.d("ReadInJoyBaseResManager", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.d.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    ((HashMap)localObject2).remove(localStringBuilder.toString());
    this.d.a((String)localObject1, this.b);
    int i = 0;
    while (i < this.d.e.size())
    {
      ((DownloadListener)this.d.e.get(i)).onDone(paramDownloadTask);
      i += 1;
    }
    this.d.a("onDone", paramDownloadTask);
    i = paramDownloadTask.c;
    long l1 = paramDownloadTask.B;
    long l2 = paramDownloadTask.A;
    this.d.a(new String[] { String.valueOf(i), str, String.valueOf(l1 - l2) });
    QLog.d("readinjoy", 2, "mDownloader downLoadFinish");
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    int i = 0;
    while (i < this.d.e.size())
    {
      ((DownloadListener)this.d.e.get(i)).onProgress(paramDownloadTask);
      i += 1;
    }
    super.onProgress(paramDownloadTask);
    this.d.a("onProgress", paramDownloadTask);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    int i = 0;
    while (i < this.d.e.size())
    {
      ((DownloadListener)this.d.e.get(i)).onStart(paramDownloadTask);
      i += 1;
    }
    this.d.a("onStart", paramDownloadTask);
    QLog.d("readinjoy", 2, "mDownloader onStart");
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoyBaseResManager.1
 * JD-Core Version:    0.7.0.1
 */