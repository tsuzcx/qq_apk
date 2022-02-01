package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmotionJsonUtils;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import java.io.File;
import java.util.ArrayList;

class ForwardPluginShareStructMsgOption$2
  implements Runnable
{
  ForwardPluginShareStructMsgOption$2(ForwardPluginShareStructMsgOption paramForwardPluginShareStructMsgOption, String paramString) {}
  
  public void run()
  {
    Object localObject1 = EmotionPanelConstans.emoticonJsonFilePath.replace("[epId]", this.a);
    boolean bool = FileUtils.fileExists((String)localObject1);
    Object localObject2 = EmotionPanelConstans.smallEmoticonJsonUrl.replace("[epId]", this.a);
    localObject1 = new File((String)localObject1);
    if (!bool)
    {
      localObject2 = new DownloadTask((String)localObject2, (File)localObject1);
      ((DownloadTask)localObject2).D = true;
      if (DownloaderFactory.a((DownloadTask)localObject2, this.this$0.q) != 0) {
        return;
      }
    }
    localObject2 = new EmoticonPackage();
    ((EmoticonPackage)localObject2).epId = this.a;
    ((EmoticonPackage)localObject2).jobType = 4;
    localObject1 = FileUtils.fileToBytes((File)localObject1);
    ArrayList localArrayList = new ArrayList();
    EmotionJsonUtils.parseSmallJson(this.this$0.q, (EmoticonPackage)localObject2, EmojiManagerServiceConstant.JSON_EMOSM_MALL, (byte[])localObject1, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption.2
 * JD-Core Version:    0.7.0.1
 */