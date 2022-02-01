package com.tencent.mobileqq.kandian.base.download;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.Map;
import mqq.os.MqqHandler;

class ReadInJoyDownloader$1
  implements Runnable
{
  ReadInJoyDownloader$1(ReadInJoyDownloader paramReadInJoyDownloader, ReadInJoyDownloader.WrappedDownloadInfo paramWrappedDownloadInfo) {}
  
  public void run()
  {
    Object localObject2 = this.a.a();
    Map localMap = ReadInJoyDownloader.WrappedDownloadInfo.a(this.a);
    String str = ((DownloadInfo)localObject2).d;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[startDownload] url=");
    ((StringBuilder)localObject1).append(str);
    QLog.d("ReadInJoyDownloader", 2, ((StringBuilder)localObject1).toString());
    StringBuilder localStringBuilder1;
    try
    {
      localObject1 = ReadInJoyDownloader.access$100(this.this$0).getDownloadTaskState(str);
    }
    catch (Exception localException1)
    {
      QLog.e("ReadInJoyDownloader", 1, "[startDownload] ", localException1);
      localStringBuilder1 = null;
    }
    if (localStringBuilder1 != null)
    {
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("[startDownload] existingInfo= ");
      localStringBuilder3.append(localStringBuilder1.mState);
      QLog.d("ReadInJoyDownloader", 2, localStringBuilder3.toString());
      if (localStringBuilder1.mState == 4)
      {
        QLog.d("ReadInJoyDownloader", 2, "[startDownload] existingInfo.mState=DownloadSDKTaskState_SUCCEED");
        ReadInJoyDownloader.access$200(this.this$0).onDownloadSDKTaskStateChanged(ReadInJoyDownloader.access$100(this.this$0), str, 4, 0, "");
        return;
      }
      if (localStringBuilder1.mState == 2)
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("[startDownload] already downloading url=");
        localStringBuilder1.append(str);
        QLog.d("ReadInJoyDownloader", 2, localStringBuilder1.toString());
        return;
      }
    }
    int i = 3;
    try
    {
      j = ReadInJoyDownloader.access$100(this.this$0).startDownloadTask(((DownloadInfo)localObject2).d, "application/vnd.android.package-archive", localMap);
      i = j;
      localStringBuilder1 = new StringBuilder();
      i = j;
      localStringBuilder1.append("[startDownload] task url=");
      i = j;
      localStringBuilder1.append(((DownloadInfo)localObject2).d);
      i = j;
      localStringBuilder1.append(" started result=");
      i = j;
      localStringBuilder1.append(j);
      i = j;
      QLog.d("ReadInJoyDownloader", 2, localStringBuilder1.toString());
      i = j;
    }
    catch (Exception localException2)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[startDownload] result=");
      ((StringBuilder)localObject2).append(i);
      QLog.e("ReadInJoyDownloader", 1, ((StringBuilder)localObject2).toString(), localException2);
    }
    int j = ReadInJoyDownloader.WrappedDownloadInfo.b(this.a);
    if ((i != 4) && (j > 0))
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[startDownload] failed, retry, remain retry: ");
      localStringBuilder2.append(j);
      QLog.d("ReadInJoyDownloader", 2, localStringBuilder2.toString());
      ReadInJoyDownloader.WrappedDownloadInfo.c(this.a);
      ThreadManager.getSubThreadHandler().postDelayed(this, ReadInJoyDownloader.WrappedDownloadInfo.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.download.ReadInJoyDownloader.1
 * JD-Core Version:    0.7.0.1
 */