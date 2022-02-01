package com.tencent.mobileqq.qzonealbumreddot;

import com.tencent.qphone.base.util.QLog;

class QzonePhotoGuideNotifyService$1
  implements Runnable
{
  QzonePhotoGuideNotifyService$1(QzonePhotoGuideNotifyService paramQzonePhotoGuideNotifyService) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzonePhotoGuideNotifyServlet", 2, "sendRedRunnable");
    }
    if (this.this$0.a != null) {
      this.this$0.a.a();
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qzonealbumreddot.QzonePhotoGuideNotifyService.1
 * JD-Core Version:    0.7.0.1
 */