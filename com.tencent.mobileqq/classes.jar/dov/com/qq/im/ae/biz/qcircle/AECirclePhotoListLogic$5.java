package dov.com.qq.im.ae.biz.qcircle;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.view.AEEditorCancelableProgressDialog;
import java.util.concurrent.CountDownLatch;

class AECirclePhotoListLogic$5
  implements View.OnClickListener
{
  AECirclePhotoListLogic$5(AECirclePhotoListLogic paramAECirclePhotoListLogic) {}
  
  public void onClick(View paramView)
  {
    AEQLog.b("AECirclePhotoListLogic", "batchCompressDialog cancel clicked");
    AECirclePhotoListLogic.a(this.a, true);
    this.a.c();
    if (AECirclePhotoListLogic.a(this.a) != null) {
      AECirclePhotoListLogic.a(this.a).countDown();
    }
    AECirclePhotoListLogic.a(this.a).cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic.5
 * JD-Core Version:    0.7.0.1
 */