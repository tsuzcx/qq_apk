package com.tencent.mobileqq.guild.chatpie.manager;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GuildPngFrameManager$4
  implements Runnable
{
  GuildPngFrameManager$4(GuildPngFrameManager paramGuildPngFrameManager, GuildPngFrameManager.RandomDrawableParam paramRandomDrawableParam) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func showPngFrame, zip NOT exist, download from Server.");
    }
    Object localObject3 = (IEmoticonManagerService)this.this$0.a.getRuntimeService(IEmoticonManagerService.class);
    Object localObject2 = ((IEmoticonManagerService)localObject3).syncFindEmoticonPackageById(this.a.d);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = this.a.d;
      ((EmoticonPackage)localObject1).aio = true;
    }
    ((EmoticonPackage)localObject1).rscType = 1;
    ((IEmoticonManagerService)localObject3).saveEmoticonPackage((EmoticonPackage)localObject1);
    Object localObject4 = this.a.c.a.getEmoticon().eId;
    localObject2 = EmotionPanelConstans.emoticonPNGZIPUrl.replace("[eIdSub]", ((String)localObject4).substring(0, 2)).replace("[eId]", (CharSequence)localObject4);
    localObject1 = EmotionPanelConstans.emoticonEncryptPath.replace("[epId]", this.a.d).replace("[eId]", (CharSequence)localObject4);
    localObject3 = EmotionPanelConstans.emoticonAIOPreviewExtensionUrl.replace("[eIdSub]", ((String)localObject4).substring(0, 2)).replace("[eId]", (CharSequence)localObject4).replace("[width]", "200").replace("[height]", "200");
    String str = EmotionPanelConstans.emoticonAIOPreviewPath.replace("[epId]", this.a.d).replace("[eId]", (CharSequence)localObject4);
    localObject4 = new ArrayList();
    HashMap localHashMap = new HashMap();
    ((List)localObject4).add(localObject2);
    localHashMap.put(localObject2, new File((String)localObject1));
    ((List)localObject4).add(localObject3);
    localHashMap.put(localObject3, new File(str));
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("random_magicface_");
    ((StringBuilder)localObject2).append(this.a.d);
    localObject2 = new DownloadTask((List)localObject4, localHashMap, ((StringBuilder)localObject2).toString());
    ((DownloadTask)localObject2).J = true;
    this.this$0.f.startDownload((DownloadTask)localObject2, new GuildPngFrameManager.4.1(this, (String)localObject1), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.manager.GuildPngFrameManager.4
 * JD-Core Version:    0.7.0.1
 */