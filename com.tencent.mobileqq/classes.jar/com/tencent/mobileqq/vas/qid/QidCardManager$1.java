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
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.a == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView.a(this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView$QidData);
      return;
    }
    QLog.d("QidCardManager", 2, "QID_QR,download,error:" + paramDownloadTask.a + "," + paramDownloadTask.b);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidCardManager", 2, "QID_QR,download,start");
    }
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qid.QidCardManager.1
 * JD-Core Version:    0.7.0.1
 */