package com.tencent.mobileqq.qqlive.player;

import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

class IlivePlayerWrapper$10
  implements Runnable
{
  IlivePlayerWrapper$10(IlivePlayerWrapper paramIlivePlayerWrapper, String paramString) {}
  
  public void run()
  {
    if (IlivePlayerWrapper.l(this.this$0) == null)
    {
      QLog.e("CachePlayer", 1, "set loadUrl mPlayer = null");
      return;
    }
    IlivePlayerWrapper.m(this.this$0).set(true);
    try
    {
      IlivePlayerWrapper.l(this.this$0).setDataSource(this.a);
      IlivePlayerWrapper.l(this.this$0).prepareAsync();
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadUrl error ");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.e("CachePlayer", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.player.IlivePlayerWrapper.10
 * JD-Core Version:    0.7.0.1
 */