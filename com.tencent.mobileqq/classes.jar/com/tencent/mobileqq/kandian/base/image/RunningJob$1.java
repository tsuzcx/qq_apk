package com.tencent.mobileqq.kandian.base.image;

import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import com.tencent.qphone.base.util.QLog;

class RunningJob$1
  implements RIJImageRequestHandler
{
  RunningJob$1(RunningJob paramRunningJob, StringBuilder paramStringBuilder) {}
  
  public void a(String paramString)
  {
    this.b.b.s = paramString;
  }
  
  public void doCancel() {}
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    String str = RunningJob.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receive image data error: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" progress: ");
    localStringBuilder.append(this.a);
    QLog.d(str, 1, localStringBuilder.toString());
    this.b.b.q = paramInt;
  }
  
  public void onFileDownloadStarted()
  {
    RIJImageOptReport.b(3, this.b.b);
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    RunningJob.a(this.b);
    this.b.b.t = paramLong;
    String str = RunningJob.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receive image data success, total size: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" progress: ");
    localStringBuilder.append(this.a);
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  public void publishProgress(int paramInt)
  {
    StringBuilder localStringBuilder1 = this.a;
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(System.currentTimeMillis());
    localStringBuilder2.append(" ");
    localStringBuilder2.append(paramInt);
    localStringBuilder2.append(" ");
    localStringBuilder1.append(localStringBuilder2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RunningJob.1
 * JD-Core Version:    0.7.0.1
 */