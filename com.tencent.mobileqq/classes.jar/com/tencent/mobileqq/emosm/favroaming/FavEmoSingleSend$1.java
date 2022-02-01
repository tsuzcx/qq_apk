package com.tencent.mobileqq.emosm.favroaming;

import bdzi;
import bojl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class FavEmoSingleSend$1
  extends TimerTask
{
  FavEmoSingleSend$1(FavEmoSingleSend paramFavEmoSingleSend) {}
  
  public void run()
  {
    QLog.e("FavEmoSingleSend", 1, "doStep, upload not complete");
    ((QQAppInterface)bojl.a()).a().a(FavEmoSingleSend.a(this.this$0));
    this.this$0.a("failed", 0, 4, 0);
    synchronized (FavEmoSingleSend.a(this.this$0))
    {
      FavEmoSingleSend.a(this.this$0).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend.1
 * JD-Core Version:    0.7.0.1
 */