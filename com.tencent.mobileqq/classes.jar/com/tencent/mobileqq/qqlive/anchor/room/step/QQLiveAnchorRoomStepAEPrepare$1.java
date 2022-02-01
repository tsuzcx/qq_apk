package com.tencent.mobileqq.qqlive.anchor.room.step;

import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class QQLiveAnchorRoomStepAEPrepare$1
  implements Runnable
{
  public void run()
  {
    if (!((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEBaseSoReady())
    {
      if (((IAEKitForQQ)QRoute.api(IAEKitForQQ.class)).init())
      {
        QQLiveAnchorRoomStepAEPrepare.a(this.this$0);
        return;
      }
      QLog.e("QQLiveAnchorRoomStepAEPrepare", 4, "[loadAERes] IAEKitForQQ init failed");
      return;
    }
    QLog.d("QQLiveAnchorRoomStepAEPrepare", 4, "[loadAERes] isAEBaseSoReady");
    QQLiveAnchorRoomStepAEPrepare.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.step.QQLiveAnchorRoomStepAEPrepare.1
 * JD-Core Version:    0.7.0.1
 */