package com.tencent.mobileqq.emosm;

import apmb;
import apno;
import bdin;
import com.tencent.mobileqq.app.QQAppInterface;

public class CameraRoamingStrategy$5
  implements Runnable
{
  public CameraRoamingStrategy$5(apmb paramapmb) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!bdin.d(this.this$0.a.getApp()))) {
      return;
    }
    ((apno)this.this$0.a.getManager(334)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.5
 * JD-Core Version:    0.7.0.1
 */