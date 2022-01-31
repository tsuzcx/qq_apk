package com.tencent.tmdownloader.internal.downloadclient;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.internal.b.b;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SyncSDKHandShakeRequest;

class e
  implements Runnable
{
  e(c paramc) {}
  
  public void run()
  {
    if (c.a(this.a) == null) {}
    for (;;)
    {
      return;
      Object localObject = new SyncSDKHandShakeRequest();
      ((SyncSDKHandShakeRequest)localObject).extra = "hello YYB";
      localObject = c.a((JceStruct)localObject, "");
      if ((localObject != null) && (localObject.length > 0)) {
        try
        {
          if (c.a(this.a) != null)
          {
            c.a(this.a).b((byte[])localObject);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadclient.e
 * JD-Core Version:    0.7.0.1
 */