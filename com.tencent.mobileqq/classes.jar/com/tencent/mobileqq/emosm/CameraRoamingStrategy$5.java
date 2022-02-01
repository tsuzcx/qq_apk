package com.tencent.mobileqq.emosm;

import asel;
import asfy;
import bhnv;
import com.tencent.mobileqq.app.QQAppInterface;

public class CameraRoamingStrategy$5
  implements Runnable
{
  public CameraRoamingStrategy$5(asel paramasel) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!bhnv.d(this.this$0.a.getApp()))) {
      return;
    }
    ((asfy)this.this$0.a.getManager(334)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.5
 * JD-Core Version:    0.7.0.1
 */