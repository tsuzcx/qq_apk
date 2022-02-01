package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class VasEmojiManager$2
  extends DownloadListener
{
  VasEmojiManager$2(VasEmojiManager paramVasEmojiManager) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    IEmojiManagerService localIEmojiManagerService = this.a.a();
    Bundle localBundle = paramDownloadTask.b();
    boolean bool;
    if (paramDownloadTask.e() != 3) {
      bool = true;
    } else {
      bool = false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = localBundle.getLong("vas_download_start");
    localIEmojiManagerService.handleEmoticonPackageDownloaded(localBundle, paramDownloadTask, bool, paramDownloadTask.c, paramDownloadTask.r, l1 - l2, 0);
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    Object localObject1 = paramDownloadTask.b();
    int i = ((Bundle)localObject1).getInt(paramDownloadTask.h);
    localObject1 = (EmoticonPackage)((Bundle)localObject1).getSerializable("emoticonPackage");
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("emotionDownloadListener | onDoneFile epId=");
      ((StringBuilder)localObject2).append(((EmoticonPackage)localObject1).epId);
      ((StringBuilder)localObject2).append(",task:");
      ((StringBuilder)localObject2).append(paramDownloadTask);
      QLog.d("VasEmojiManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramDownloadTask.c != 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onDoneFile : ondone error , reportCode = ");
      ((StringBuilder)localObject2).append(paramDownloadTask.c);
      QLog.e("VasEmojiManager", 1, ((StringBuilder)localObject2).toString());
      if (EmojiManagerServiceConstant.isCover(i)) {
        ((IEmojiManagerService)this.a.a.getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager().notifyEmoticonCoverListener((EmoticonPackage)localObject1, i, -1, paramDownloadTask.c);
      }
      localObject1 = ((EmoticonPackage)localObject1).epId;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramDownloadTask.c);
      ((StringBuilder)localObject2).append("");
      VasReportUtils.a("emotionType", "emotionActionDownload", "10", (String)localObject1, "", "", ((StringBuilder)localObject2).toString(), "", "", "");
      return;
    }
    Object localObject2 = this.a.a();
    if (EmojiManagerServiceConstant.isCover(i)) {
      ((IEmojiManagerService)this.a.a.getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager().notifyEmoticonCoverListener((EmoticonPackage)localObject1, i, 0, 0);
    } else if (i == 7) {
      ((IEmojiManagerService)localObject2).handleEmotionEncryptKey(paramDownloadTask);
    }
    if ((((EmoticonPackage)localObject1).jobType == 3) || (((EmoticonPackage)localObject1).jobType == 5)) {
      ((IEmojiManagerService)localObject2).handleMagicOrH5MagicDownloadOnDoneFile(paramDownloadTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.VasEmojiManager.2
 * JD-Core Version:    0.7.0.1
 */