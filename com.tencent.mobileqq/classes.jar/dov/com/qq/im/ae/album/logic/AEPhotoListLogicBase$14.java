package dov.com.qq.im.ae.album.logic;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.view.AEEditorCancelableProgressDialog;
import java.util.concurrent.CountDownLatch;

class AEPhotoListLogicBase$14
  implements View.OnClickListener
{
  AEPhotoListLogicBase$14(AEPhotoListLogicBase paramAEPhotoListLogicBase) {}
  
  public void onClick(View paramView)
  {
    AEQLog.b("AEPhotoListLogicBase", "batchCompressDialog cancel clicked");
    AEPhotoListLogicBase.a(this.a, true);
    this.a.i();
    if (AEPhotoListLogicBase.a(this.a) != null) {
      AEPhotoListLogicBase.a(this.a).countDown();
    }
    AEPhotoListLogicBase.a(this.a).cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.14
 * JD-Core Version:    0.7.0.1
 */