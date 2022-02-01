package com.tencent.mobileqq.emoticon.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;

class EmojiManagerServiceImpl$4
  implements Runnable
{
  EmojiManagerServiceImpl$4(EmojiManagerServiceImpl paramEmojiManagerServiceImpl, boolean paramBoolean, String paramString, int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.a) {
      localObject1 = EmotionPanelConstans.smallEmoticonJsonUrl.replace("[epId]", this.b);
    } else {
      localObject1 = EmoticonPanelUtils.c(this.b);
    }
    Object localObject2 = this.this$0.getDownloader().getTask((String)localObject1);
    int i;
    if ((localObject2 != null) && (!((DownloadTask)localObject2).f())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = EmojiManagerServiceImpl.access$000();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startDownloadEmosmJson|epId is in downloading:");
        ((StringBuilder)localObject2).append(this.b);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    Object localObject3 = this.this$0.getEmoticonManager().syncFindEmoticonPackageById(this.b, this.c);
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = EmojiManagerServiceImpl.access$000();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("startDownloadEmosmJson|emoPackage is not exist:");
        ((StringBuilder)localObject3).append(this.b);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      localObject2 = new EmoticonPackage();
      ((EmoticonPackage)localObject2).epId = this.b;
      ((EmoticonPackage)localObject2).status = 0;
      i = this.c;
      if (i == 0) {
        ((EmoticonPackage)localObject2).aio = true;
      } else if (i == 1) {
        ((EmoticonPackage)localObject2).kandian = true;
      }
      this.this$0.getEmoticonManager().saveEmoticonPackage((EmoticonPackage)localObject2);
    }
    if (QLog.isColorLevel())
    {
      localObject3 = EmojiManagerServiceImpl.access$000();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownloadEmosmJson epId:");
      localStringBuilder.append(((EmoticonPackage)localObject2).epId);
      QLog.d((String)localObject3, 2, localStringBuilder.toString());
    }
    Object localObject1 = new DownloadTask((String)localObject1, new File(EmotionPanelConstans.emoticonJsonFilePath.replace("[epId]", this.b)));
    localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("jsonType", this.d);
    ((Bundle)localObject3).putSerializable("emoticonPackage", (Serializable)localObject2);
    ((Bundle)localObject3).putBoolean("isSmallEmotion", this.a);
    localObject2 = this.e;
    if (localObject2 != null) {
      ((Bundle)localObject3).putBundle("jsonReqParams", (Bundle)localObject2);
    }
    ((DownloadTask)localObject1).y = this.this$0.limitSize;
    ((DownloadTask)localObject1).J = true;
    this.this$0.getDownloader().startDownload((DownloadTask)localObject1, this.this$0.jsonDownloadListener, (Bundle)localObject3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */