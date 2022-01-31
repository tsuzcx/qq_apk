package com.tencent.mobileqq.emosm;

import anqk;
import anrx;
import bbfj;
import com.tencent.mobileqq.app.QQAppInterface;

public class CameraRoamingStrategy$5
  implements Runnable
{
  public CameraRoamingStrategy$5(anqk paramanqk) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!bbfj.d(this.this$0.a.getApp()))) {
      return;
    }
    ((anrx)this.this$0.a.getManager(334)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.5
 * JD-Core Version:    0.7.0.1
 */