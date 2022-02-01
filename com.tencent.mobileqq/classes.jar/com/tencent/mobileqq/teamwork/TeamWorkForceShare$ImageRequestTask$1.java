package com.tencent.mobileqq.teamwork;

import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;

class TeamWorkForceShare$ImageRequestTask$1
  implements URLDrawableHandler
{
  TeamWorkForceShare$ImageRequestTask$1(TeamWorkForceShare.ImageRequestTask paramImageRequestTask) {}
  
  public void doCancel() {}
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    String str = TeamWorkForceShare.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download failed, code = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", url = ");
    localStringBuilder.append(TeamWorkForceShare.ImageRequestTask.a(this.a));
    QLog.d(str, 1, localStringBuilder.toString());
    TeamWorkForceShare.ImageRequestTask.a(this.a, true);
  }
  
  public void onFileDownloadStarted()
  {
    String str = TeamWorkForceShare.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start download, url = ");
    localStringBuilder.append(TeamWorkForceShare.ImageRequestTask.a(this.a));
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    String str = TeamWorkForceShare.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download success, size = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", url = ");
    localStringBuilder.append(TeamWorkForceShare.ImageRequestTask.a(this.a));
    QLog.d(str, 1, localStringBuilder.toString());
    TeamWorkForceShare.ImageRequestTask.a(this.a, true);
  }
  
  public void publishProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare.ImageRequestTask.1
 * JD-Core Version:    0.7.0.1
 */