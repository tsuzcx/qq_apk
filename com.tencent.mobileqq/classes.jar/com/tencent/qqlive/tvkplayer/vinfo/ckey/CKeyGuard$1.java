package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsLog;

final class CKeyGuard$1
  implements Runnable
{
  CKeyGuard$1(Context paramContext) {}
  
  public void run()
  {
    try
    {
      if (this.val$context != null) {
        CKeyGuard.access$000(this.val$context);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      CKeyGuard.bLoadSucc = false;
      VsLog.info(CKeyGuard.access$100(), new Object[] { " guard init err" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyGuard.1
 * JD-Core Version:    0.7.0.1
 */