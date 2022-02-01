package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import mqq.app.MobileQQ;

class FavEmoSingleSend$1
  extends TimerTask
{
  FavEmoSingleSend$1(FavEmoSingleSend paramFavEmoSingleSend) {}
  
  public void run()
  {
    QLog.e("FavEmoSingleSend", 1, "doStep, upload not complete");
    ((ITransFileController)((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getRuntimeService(ITransFileController.class)).stop(FavEmoSingleSend.a(this.this$0));
    this.this$0.a("failed", 0, 4, 0);
    synchronized (FavEmoSingleSend.a(this.this$0))
    {
      FavEmoSingleSend.a(this.this$0).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend.1
 * JD-Core Version:    0.7.0.1
 */