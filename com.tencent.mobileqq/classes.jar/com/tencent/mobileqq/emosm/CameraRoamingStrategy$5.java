package com.tencent.mobileqq.emosm;

import aqyj;
import aqzw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;

public class CameraRoamingStrategy$5
  implements Runnable
{
  public CameraRoamingStrategy$5(aqyj paramaqyj) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!NetworkUtil.isNetSupport(this.this$0.a.getApp()))) {
      return;
    }
    ((aqzw)this.this$0.a.getManager(334)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.5
 * JD-Core Version:    0.7.0.1
 */