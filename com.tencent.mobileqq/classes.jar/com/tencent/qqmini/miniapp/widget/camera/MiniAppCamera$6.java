package com.tencent.qqmini.miniapp.widget.camera;

import android.util.Log;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

class MiniAppCamera$6
  implements Runnable
{
  MiniAppCamera$6(MiniAppCamera paramMiniAppCamera, String paramString1, String[] paramArrayOfString, RequestEvent paramRequestEvent, String paramString2) {}
  
  public void run()
  {
    new File(this.val$outPath).deleteOnExit();
    try
    {
      Thread.sleep(50L);
      QMLog.i("MiniAppCamera", "execCommand start ");
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        try
        {
          ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
          if (localChannelProxy != null) {
            localChannelProxy.ffmpegExecCommand(this.val$cmds, new MiniAppCamera.6.1(this));
          }
          return;
        }
        catch (Exception localException)
        {
          Log.e("MiniAppCamera", "run: ", localException);
          MiniAppCamera.access$400(this.this$0, this.val$srcPath, this.val$req);
          MiniAppCamera.access$300(this.this$0);
        }
        localInterruptedException = localInterruptedException;
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.6
 * JD-Core Version:    0.7.0.1
 */