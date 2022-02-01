package com.tencent.mobileqq.emoticon.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmotionJsonUtils;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class EmojiManagerServiceImpl$1
  extends DownloadListener
{
  EmojiManagerServiceImpl$1(EmojiManagerServiceImpl paramEmojiManagerServiceImpl, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    try
    {
      Object localObject2 = paramDownloadTask.a();
      Object localObject1 = (EmoticonPackage)((Bundle)localObject2).getSerializable("emoticonPackage");
      if (localObject1 == null) {
        return;
      }
      if ((QLog.isColorLevel()) && (localObject1 != null))
      {
        str = EmojiManagerServiceImpl.access$000();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("jsonDownloadListener : onDone epid = ");
        localStringBuilder.append(((EmoticonPackage)localObject1).epId);
        localStringBuilder.append(";task status = ");
        localStringBuilder.append(paramDownloadTask.a());
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (paramDownloadTask.a() == 3)
      {
        boolean bool = ((Bundle)localObject2).getBoolean("isSmallEmotion");
        str = EmotionJsonUtils.handleJsonFileDownload(this.a.mApp, paramDownloadTask, bool);
        if (str != null)
        {
          localObject2 = EmojiManagerServiceImpl.access$000();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("jsonDownloadListener : parse json error : = ");
          localStringBuilder.append(str);
          QLog.e((String)localObject2, 1, localStringBuilder.toString());
          this.a.reportEmoticonDownData((EmoticonPackage)localObject1, 11008, 0L, paramDownloadTask.d);
          return;
        }
        EmojiManagerServiceImpl.listenerManager.a((EmoticonPackage)localObject1, 0, (Bundle)localObject2);
        return;
      }
      String str = EmojiManagerServiceImpl.access$000();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jsonDownloadListener : ondone error , reportCode = ");
      localStringBuilder.append(paramDownloadTask.a);
      QLog.e(str, 1, localStringBuilder.toString());
      EmojiManagerServiceImpl.listenerManager.a((EmoticonPackage)localObject1, -1, (Bundle)localObject2);
      localObject1 = ((EmoticonPackage)localObject1).epId;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramDownloadTask.a);
      ((StringBuilder)localObject2).append("");
      VasReportUtils.a("emotionType", "emotionActionDownload", "3", (String)localObject1, "", "", ((StringBuilder)localObject2).toString(), "", "", "");
      return;
    }
    catch (Exception paramDownloadTask)
    {
      QLog.e(EmojiManagerServiceImpl.access$000(), 1, "json download fail", paramDownloadTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */