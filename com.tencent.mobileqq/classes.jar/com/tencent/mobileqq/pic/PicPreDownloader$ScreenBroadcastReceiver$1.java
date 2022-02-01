package com.tencent.mobileqq.pic;

import bbqp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class PicPreDownloader$ScreenBroadcastReceiver$1
  implements Runnable
{
  PicPreDownloader$ScreenBroadcastReceiver$1(PicPreDownloader.ScreenBroadcastReceiver paramScreenBroadcastReceiver) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.this$0.a);
      if (localObject1 != null)
      {
        PicPreDownloader localPicPreDownloader = ((QQAppInterface)localObject1).getPicPreDownloader();
        localObject1 = (bbqp)((QQAppInterface)localObject1).getManager(95);
        if (localPicPreDownloader != null)
        {
          localPicPreDownloader.d();
          PicPreDownloader.a(localPicPreDownloader);
        }
        if (localObject1 != null) {
          ((bbqp)localObject1).d();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.ScreenBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */