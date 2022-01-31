package com.tencent.mobileqq.mini.widget.media;

import android.util.Log;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import wab;

class MiniAppCamera$6
  implements Runnable
{
  MiniAppCamera$6(MiniAppCamera paramMiniAppCamera, String paramString1, String[] paramArrayOfString, WebviewContainer paramWebviewContainer, String paramString2, int paramInt, String paramString3) {}
  
  public void run()
  {
    new File(this.val$outPath).deleteOnExit();
    try
    {
      Thread.sleep(50L);
      QLog.i("MiniAppCamera", 2, "execCommand start ");
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        try
        {
          MiniAppCamera.access$600(this.this$0).a(this.val$cmds, new MiniAppCamera.6.1(this));
          return;
        }
        catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
        {
          Log.e("MiniAppCamera", "run: ", localFFmpegCommandAlreadyRunningException);
          MiniAppCamera.access$500(this.this$0, this.val$srcPath, this.val$wc, this.val$event, this.val$callBackId);
          this.val$wc.hideLoading();
        }
        localInterruptedException = localInterruptedException;
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppCamera.6
 * JD-Core Version:    0.7.0.1
 */