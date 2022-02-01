package com.tencent.qqmini.miniapp.proxy;

import com.tencent.qqmini.miniapp.util.VideoCompress.Listener;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.LocalMediaInfo;
import java.io.File;

class VideoCompressProxyDefault$1
  implements Runnable
{
  VideoCompressProxyDefault$1(VideoCompressProxyDefault paramVideoCompressProxyDefault) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start compress ");
    ((StringBuilder)localObject).append(VideoCompressProxyDefault.access$000(this.this$0).path);
    QMLog.i("VideoCompress", ((StringBuilder)localObject).toString());
    VideoCompressProxyDefault.access$100(this.this$0).onStart();
    localObject = new File(VideoCompressProxyDefault.access$200(this.this$0).path);
    File localFile = new File(VideoCompressProxyDefault.access$300(this.this$0));
    int i = 1;
    boolean bool = false;
    for (;;)
    {
      if (i <= 100) {}
      try
      {
        Thread.sleep(Math.round(Math.random() * 200.0D));
        label108:
        if (i == 50) {
          bool = FileUtils.copyFile((File)localObject, localFile);
        }
        VideoCompressProxyDefault.access$400(this.this$0).onProgress(String.format("progress:%s", new Object[] { Integer.valueOf(i) }), i / 100.0F);
        i += 1;
        continue;
        if (bool) {
          VideoCompressProxyDefault.access$500(this.this$0).onSuccess("compress success");
        } else {
          VideoCompressProxyDefault.access$600(this.this$0).onFailure("compress failed");
        }
        VideoCompressProxyDefault.access$700(this.this$0).onFinish(bool);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label108;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.proxy.VideoCompressProxyDefault.1
 * JD-Core Version:    0.7.0.1
 */