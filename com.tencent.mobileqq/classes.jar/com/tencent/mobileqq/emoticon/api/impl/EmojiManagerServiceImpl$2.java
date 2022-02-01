package com.tencent.mobileqq.emoticon.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class EmojiManagerServiceImpl$2
  extends DownloadListener
{
  EmojiManagerServiceImpl$2(EmojiManagerServiceImpl paramEmojiManagerServiceImpl, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject = paramDownloadTask.a();
    int j = ((Bundle)localObject).getInt(paramDownloadTask.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel())
    {
      String str = EmojiManagerServiceImpl.access$000();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("coverDownloadListener| onDone:epId=");
      localStringBuilder.append(((EmoticonPackage)localObject).epId);
      localStringBuilder.append(" task:");
      localStringBuilder.append(paramDownloadTask);
      localStringBuilder.append(" localVersion=");
      localStringBuilder.append(((EmoticonPackage)localObject).localVersion);
      localStringBuilder.append(",latestVersion=");
      localStringBuilder.append(((EmoticonPackage)localObject).latestVersion);
      localStringBuilder.append(",updateFlag=");
      localStringBuilder.append(((EmoticonPackage)localObject).updateFlag);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    int i;
    if (paramDownloadTask.a() != 3)
    {
      i = EmosmUtils.a(paramDownloadTask.a);
      if (EmojiManagerServiceConstant.isCover(j)) {
        EmojiManagerServiceImpl.listenerManager.notifyEmoticonCoverListener((EmoticonPackage)localObject, j, -1, i);
      }
      EmojiManagerServiceImpl.listenerManager.a((EmoticonPackage)localObject, i, this.a.mApp);
    }
    else
    {
      EmojiManagerServiceImpl.listenerManager.notifyEmoticonCoverListener((EmoticonPackage)localObject, j, 0, 0);
      i = 0;
    }
    long l1 = paramDownloadTask.h;
    long l2 = paramDownloadTask.g;
    this.a.reportEmoticonDownData((EmoticonPackage)localObject, i, l1 - l2, paramDownloadTask.d);
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    Object localObject = paramDownloadTask.a();
    int i = ((Bundle)localObject).getInt(paramDownloadTask.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel())
    {
      String str = EmojiManagerServiceImpl.access$000();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("coverDownloadListener | onProgress:epId=");
      localStringBuilder.append(((EmoticonPackage)localObject).epId);
      localStringBuilder.append(paramDownloadTask);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (EmojiManagerServiceConstant.isCover(i)) {
      EmojiManagerServiceImpl.listenerManager.notifyEmoticonCoverListener((EmoticonPackage)localObject, i, 0, 0);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */