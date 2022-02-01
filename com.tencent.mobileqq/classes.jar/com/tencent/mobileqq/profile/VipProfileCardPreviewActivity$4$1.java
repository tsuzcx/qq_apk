package com.tencent.mobileqq.profile;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class VipProfileCardPreviewActivity$4$1
  extends DownloadListener
{
  VipProfileCardPreviewActivity$4$1(VipProfileCardPreviewActivity.4 param4) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style end download, url : %s, resultCode : %d ", new Object[] { paramDownloadTask.b, Integer.valueOf(paramDownloadTask.c) }));
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    int i = (int)paramDownloadTask.l;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style progress, url : %s, progress : %d", new Object[] { paramDownloadTask.b, Integer.valueOf(i) }));
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style start download, url : %s, position : %s ", new Object[] { paramDownloadTask.b, Integer.valueOf(this.a.a) }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.4.1
 * JD-Core Version:    0.7.0.1
 */