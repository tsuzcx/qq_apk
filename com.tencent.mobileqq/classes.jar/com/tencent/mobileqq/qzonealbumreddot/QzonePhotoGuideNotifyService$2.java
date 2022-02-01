package com.tencent.mobileqq.qzonealbumreddot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class QzonePhotoGuideNotifyService$2
  extends BroadcastReceiver
{
  QzonePhotoGuideNotifyService$2(QzonePhotoGuideNotifyService paramQzonePhotoGuideNotifyService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.qzonex.localalbum.new_photo_notification_feedback_action".equals(paramIntent.getAction())))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzonePhotoGuideNotifyServlet", 2, "QzonePhotoGuideNotifyServlet onReceive");
      }
      if (this.a.c != null) {
        this.a.c.removeCallbacks(this.a.d);
      }
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonealbumreddot.QzonePhotoGuideNotifyService.2
 * JD-Core Version:    0.7.0.1
 */