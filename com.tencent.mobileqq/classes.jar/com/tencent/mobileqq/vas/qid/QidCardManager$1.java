package com.tencent.mobileqq.vas.qid;

import android.app.Activity;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

final class QidCardManager$1
  extends DownloadListener
{
  QidCardManager$1(Activity paramActivity, QidPagView paramQidPagView, QidPagView.QidData paramQidData) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    super.onCancel(paramDownloadTask);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      int i;
      if ((paramDownloadTask.e() == 3) && (paramDownloadTask.c == 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.b.a(this.c);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QID_QR,download,error:");
      ((StringBuilder)localObject).append(paramDownloadTask.c);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramDownloadTask.d);
      QLog.d("QidCardManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidCardManager", 2, "QID_QR,download,start");
    }
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qid.QidCardManager.1
 * JD-Core Version:    0.7.0.1
 */