package com.tencent.mobileqq.emosm;

import asct;
import aseg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;

public class CameraRoamingStrategy$5
  implements Runnable
{
  public CameraRoamingStrategy$5(asct paramasct) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!NetworkUtil.isNetSupport(this.this$0.a.getApp()))) {
      return;
    }
    ((aseg)this.this$0.a.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.5
 * JD-Core Version:    0.7.0.1
 */