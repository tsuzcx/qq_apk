package com.tencent.mobileqq.wink.pick.circle;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.wink.pick.circle.widget.WinkCancelableProgressDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.CountDownLatch;

class WinkCirclePhotoListLogic$7
  implements View.OnClickListener
{
  WinkCirclePhotoListLogic$7(WinkCirclePhotoListLogic paramWinkCirclePhotoListLogic) {}
  
  public void onClick(View paramView)
  {
    AEQLog.b("WinkCirclePhotoListLogic", "batchCompressDialog cancel clicked");
    WinkCirclePhotoListLogic.b(this.a, true);
    this.a.n();
    if (WinkCirclePhotoListLogic.d(this.a) != null) {
      WinkCirclePhotoListLogic.d(this.a).countDown();
    }
    WinkCirclePhotoListLogic.c(this.a).cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic.7
 * JD-Core Version:    0.7.0.1
 */