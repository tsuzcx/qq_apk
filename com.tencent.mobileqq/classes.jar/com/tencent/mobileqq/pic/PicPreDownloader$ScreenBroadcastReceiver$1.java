package com.tencent.mobileqq.pic;

import awjj;
import azdo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class PicPreDownloader$ScreenBroadcastReceiver$1
  implements Runnable
{
  public PicPreDownloader$ScreenBroadcastReceiver$1(awjj paramawjj) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.this$0.a);
      if (localObject1 != null)
      {
        PicPreDownloader localPicPreDownloader = ((QQAppInterface)localObject1).a();
        localObject1 = (azdo)((QQAppInterface)localObject1).getManager(95);
        if (localPicPreDownloader != null)
        {
          localPicPreDownloader.f();
          localPicPreDownloader.e();
        }
        if (localObject1 != null) {
          ((azdo)localObject1).d();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.ScreenBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */