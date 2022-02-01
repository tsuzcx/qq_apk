package com.tencent.mobileqq.guild.chatpie.manager;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.magicface.drawable.PngGifEngine;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class GuildPngFrameManager$3$1
  extends DownloadListener
{
  GuildPngFrameManager$3$1(GuildPngFrameManager.3 param3) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onDone.【aio preview】");
    }
    synchronized (this.a.this$0)
    {
      if (this.a.this$0.e != null) {
        if (paramDownloadTask.e() != 3)
        {
          this.a.this$0.e.obtainMessage(226, this.a.b).sendToTarget();
        }
        else
        {
          paramDownloadTask = PngGifEngine.b(this.a.a);
          this.a.b.h = paramDownloadTask;
          this.a.this$0.e.obtainMessage(227, this.a.b).sendToTarget();
          GlobalImageCache.a.put(this.a.a, paramDownloadTask);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.manager.GuildPngFrameManager.3.1
 * JD-Core Version:    0.7.0.1
 */