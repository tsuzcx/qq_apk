package com.tencent.mobileqq.guild.chatpie.manager;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import java.io.File;

class GuildPngFrameManager$2
  implements Runnable
{
  GuildPngFrameManager$2(GuildPngFrameManager paramGuildPngFrameManager, GuildPngFrameManager.RandomDrawableParam paramRandomDrawableParam) {}
  
  public void run()
  {
    File localFile = new File(EmotionPanelConstans.emoticonJsonFilePath.replace("[epId]", this.a.d));
    IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)this.this$0.a.getRuntimeService(IEmoticonManagerService.class);
    ??? = localIEmoticonManagerService.syncFindEmoticonPackageById(this.a.d);
    Object localObject1 = ???;
    if (??? == null)
    {
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = this.a.d;
      ((EmoticonPackage)localObject1).aio = true;
    }
    synchronized (this.this$0)
    {
      if (this.this$0.e != null) {
        if (localFile.exists())
        {
          this.a.a = this.this$0.d.a(localFile);
          this.this$0.e.obtainMessage(224, this.a).sendToTarget();
          ((EmoticonPackage)localObject1).rscType = this.a.a;
          localIEmoticonManagerService.saveEmoticonPackage((EmoticonPackage)localObject1);
        }
        else
        {
          DownloadTask localDownloadTask = new DownloadTask(EmoticonPanelUtils.c(this.a.d), localFile);
          localDownloadTask.D = true;
          if ((DownloaderFactory.a(localDownloadTask, this.this$0.a) == 0) && (this.this$0.d != null) && (this.this$0.e != null))
          {
            this.a.a = this.this$0.d.a(localFile);
            ((EmoticonPackage)localObject1).rscType = this.a.a;
            localIEmoticonManagerService.saveEmoticonPackage((EmoticonPackage)localObject1);
            this.this$0.e.obtainMessage(224, this.a).sendToTarget();
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.manager.GuildPngFrameManager.2
 * JD-Core Version:    0.7.0.1
 */