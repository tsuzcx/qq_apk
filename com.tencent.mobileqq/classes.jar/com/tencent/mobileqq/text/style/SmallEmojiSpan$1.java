package com.tencent.mobileqq.text.style;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmotionJsonUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

class SmallEmojiSpan$1
  implements Runnable
{
  SmallEmojiSpan$1(SmallEmojiSpan paramSmallEmojiSpan) {}
  
  public void run()
  {
    Object localObject2 = EmoticonUtils.emoticonJsonFilePath.replace("[epId]", Integer.toString(this.this$0.b));
    boolean bool = FileUtils.a((String)localObject2);
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(SmallEmojiSpan.a(this.this$0));
        if (localQQAppInterface1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQText", 2, "appInterface is null. return");
          }
          return;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        localClassCastException.printStackTrace();
        QQAppInterface localQQAppInterface2 = null;
        continue;
        if (bool)
        {
          localObject3 = EmoticonUtils.getEmoticonManager();
          if (localObject3 == null) {
            break label389;
          }
          localObject1 = ((EmoticonManager)localObject3).a(Integer.toString(this.this$0.b), Integer.toString(this.this$0.c));
          if (localObject1 != null)
          {
            localObject1 = ((EmoticonManager)localObject3).a(Integer.toString(this.this$0.b));
            if ((localObject1 != null) && (((EmoticonPackage)localObject1).isAPNG == 0))
            {
              localObject3 = new ArrayList();
              localObject2 = FileUtils.a(new File((String)localObject2));
              EmotionJsonUtils.a(localQQAppInterface2, (EmoticonPackage)localObject1, EmojiManager.c, (byte[])localObject2, (ArrayList)localObject3);
            }
            this.this$0.a((EmoticonPackage)localObject1);
            return;
          }
        }
        Object localObject3 = EmoticonUtils.smallEmoticonJsonUrl.replace("[epId]", Integer.toString(this.this$0.b));
        localObject1 = new File((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("QQText", 2, "small emoji json not exist. epId:" + this.this$0.b + ",downloadUrl:" + (String)localObject3);
        }
        localObject2 = new DownloadTask((String)localObject3, (File)localObject1);
        ((DownloadTask)localObject2).j = true;
        int i = DownloaderFactory.a((DownloadTask)localObject2, localQQAppInterface2);
        localObject2 = new EmoticonPackage();
        ((EmoticonPackage)localObject2).epId = Integer.toString(this.this$0.b);
        ((EmoticonPackage)localObject2).jobType = 4;
        if (i != 0) {
          continue;
        }
        if (((File)localObject1).exists())
        {
          localObject1 = FileUtils.a((File)localObject1);
          localObject3 = new ArrayList();
          EmotionJsonUtils.a(localQQAppInterface2, (EmoticonPackage)localObject2, EmojiManager.c, (byte[])localObject1, (ArrayList)localObject3);
          this.this$0.a((EmoticonPackage)localObject2);
          return;
        }
        localObject1 = null;
        continue;
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        return;
      }
      label389:
      Object localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.SmallEmojiSpan.1
 * JD-Core Version:    0.7.0.1
 */