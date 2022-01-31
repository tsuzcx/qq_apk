package com.tencent.mobileqq.emosm;

import anqf;
import anrs;
import bbev;
import com.tencent.mobileqq.app.QQAppInterface;

public class CameraRoamingStrategy$5
  implements Runnable
{
  public CameraRoamingStrategy$5(anqf paramanqf) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!bbev.d(this.this$0.a.getApp()))) {
      return;
    }
    ((anrs)this.this$0.a.getManager(334)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.5
 * JD-Core Version:    0.7.0.1
 */