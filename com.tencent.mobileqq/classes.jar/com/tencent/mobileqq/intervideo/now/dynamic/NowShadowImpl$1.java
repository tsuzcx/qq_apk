package com.tencent.mobileqq.intervideo.now.dynamic;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.intervideo.IVPluginManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.EnterCallback;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

class NowShadowImpl$1
  implements Runnable
{
  NowShadowImpl$1(NowShadowImpl paramNowShadowImpl, Context paramContext, String paramString1, String paramString2, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback) {}
  
  public void run()
  {
    try
    {
      IVPluginManager localIVPluginManager = NowShadowImpl.a(this.this$0);
      if (localIVPluginManager == null) {
        try
        {
          QLog.i("NowPluginManager", 1, "create PluginManager");
          NowShadowImpl.a(this.this$0, this.this$0.a(this.a, this.b, this.c));
        }
        catch (ExecutionException localExecutionException)
        {
          localExecutionException.printStackTrace();
          NowShadowImpl.a(this.this$0, localExecutionException.getMessage());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("enter error, e=");
          localStringBuilder.append(localExecutionException.toString());
          QLog.e("NowShadowImpl", 1, localStringBuilder.toString());
        }
        catch (TimeoutException localTimeoutException)
        {
          localTimeoutException.printStackTrace();
          NowShadowImpl.a(this.this$0, localTimeoutException.getMessage());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("enter error, e=");
          localStringBuilder.append(localTimeoutException.toString());
          QLog.e("NowShadowImpl", 1, localStringBuilder.toString());
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          NowShadowImpl.a(this.this$0, localInterruptedException.getMessage());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("enter error, e=");
          localStringBuilder.append(localInterruptedException.toString());
          QLog.e("NowShadowImpl", 1, localStringBuilder.toString());
        }
      }
      QLog.d("NowPluginManager", 1, "enterShadowSdk start");
      if (NowShadowImpl.a(this.this$0) != null) {
        NowShadowImpl.a(this.this$0).enter(this.a, this.d, this.e, this.f);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.NowShadowImpl.1
 * JD-Core Version:    0.7.0.1
 */