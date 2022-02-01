package com.tencent.mobileqq.emoticon.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class EmojiManagerServiceImpl$3
  extends DownloadListener
{
  EmojiManagerServiceImpl$3(EmojiManagerServiceImpl paramEmojiManagerServiceImpl, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    for (;;)
    {
      try
      {
        super.onDone(paramDownloadTask);
        Bundle localBundle = paramDownloadTask.b();
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
        this.a.statusMap.remove(localEmoticonPackage.epId);
        int i = localBundle.getInt("businessType");
        if (paramDownloadTask.e() != 3)
        {
          bool = true;
          long l1 = paramDownloadTask.B;
          long l2 = paramDownloadTask.A;
          this.a.handleEmoticonPackageDownloaded(localBundle, paramDownloadTask, bool, paramDownloadTask.c, paramDownloadTask.r, l1 - l2, i);
          return;
        }
      }
      catch (Exception paramDownloadTask)
      {
        QLog.e(EmojiManagerServiceImpl.access$000(), 1, "onDone failed", paramDownloadTask);
        return;
      }
      boolean bool = false;
    }
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    try
    {
      Object localObject2 = paramDownloadTask.b();
      int i = ((Bundle)localObject2).getInt(paramDownloadTask.h);
      Object localObject1 = (EmoticonPackage)((Bundle)localObject2).getSerializable("emoticonPackage");
      if (localObject1 == null) {
        return;
      }
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = EmojiManagerServiceImpl.access$000();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("emotionDownloadListener | onDoneFile epId=");
        localStringBuilder.append(((EmoticonPackage)localObject1).epId);
        localStringBuilder.append(",task:");
        localStringBuilder.append(paramDownloadTask);
        QLog.d((String)localObject3, 2, localStringBuilder.toString());
      }
      EmojiManagerServiceImpl.listenerManager.notifyPackageProgress((EmoticonPackage)localObject1, (int)paramDownloadTask.j, (int)paramDownloadTask.k);
      if (i == 9)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramDownloadTask.h);
        ((StringBuilder)localObject3).append("emoticonId");
        localObject2 = ((Bundle)localObject2).getString(((StringBuilder)localObject3).toString());
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          EmojiManagerServiceImpl.access$100(this.a, ((EmoticonPackage)localObject1).epId, (String)localObject2, paramDownloadTask.c);
        }
      }
      if (paramDownloadTask.c != 0)
      {
        localObject2 = EmojiManagerServiceImpl.access$000();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onDoneFile : ondone error , reportCode = ");
        ((StringBuilder)localObject3).append(paramDownloadTask.c);
        QLog.e((String)localObject2, 1, ((StringBuilder)localObject3).toString());
        if (EmojiManagerServiceConstant.isCover(i)) {
          EmojiManagerServiceImpl.listenerManager.notifyEmoticonCoverListener((EmoticonPackage)localObject1, i, -1, paramDownloadTask.c);
        }
        localObject1 = ((EmoticonPackage)localObject1).epId;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramDownloadTask.c);
        ((StringBuilder)localObject2).append("");
        VasReportUtils.a("emotionType", "emotionActionDownload", "10", (String)localObject1, "", "", ((StringBuilder)localObject2).toString(), "", "", "");
        return;
      }
      if (EmojiManagerServiceConstant.isCover(i)) {
        EmojiManagerServiceImpl.listenerManager.notifyEmoticonCoverListener((EmoticonPackage)localObject1, i, 0, 0);
      } else if (i == 7) {
        this.a.handleEmotionEncryptKey(paramDownloadTask);
      }
      if ((((EmoticonPackage)localObject1).jobType == 3) || (((EmoticonPackage)localObject1).jobType == 5))
      {
        this.a.handleMagicOrH5MagicDownloadOnDoneFile(paramDownloadTask);
        return;
      }
    }
    catch (Exception paramDownloadTask)
    {
      QLog.e(EmojiManagerServiceImpl.access$000(), 1, "onDoneFile failed", paramDownloadTask);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramDownloadTask.b().getSerializable("emoticonPackage");
    EmojiManagerServiceImpl.listenerManager.notifyPackageStart(localEmoticonPackage);
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */