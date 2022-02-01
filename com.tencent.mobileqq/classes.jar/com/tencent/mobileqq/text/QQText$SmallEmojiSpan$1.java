package com.tencent.mobileqq.text;

import asih;
import asiw;
import awyr;
import bhyo;
import bhyq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

class QQText$SmallEmojiSpan$1
  implements Runnable
{
  QQText$SmallEmojiSpan$1(QQText.SmallEmojiSpan paramSmallEmojiSpan) {}
  
  public void run()
  {
    Object localObject2 = EmoticonUtils.emoticonJsonFilePath.replace("[epId]", Integer.toString(this.this$0.mEpId));
    boolean bool = FileUtils.fileExists((String)localObject2);
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(QQText.access$000());
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
            break label385;
          }
          localObject1 = ((awyr)localObject3).a(Integer.toString(this.this$0.mEpId), Integer.toString(this.this$0.mEId));
          if (localObject1 != null)
          {
            localObject1 = ((awyr)localObject3).a(Integer.toString(this.this$0.mEpId));
            if ((localObject1 != null) && (((EmoticonPackage)localObject1).isAPNG == 0))
            {
              localObject3 = new ArrayList();
              localObject2 = FileUtils.fileToBytes(new File((String)localObject2));
              asiw.a(localQQAppInterface2, (EmoticonPackage)localObject1, asih.c, (byte[])localObject2, (ArrayList)localObject3);
            }
            this.this$0.updateApngFlag((EmoticonPackage)localObject1);
            return;
          }
        }
        Object localObject3 = EmoticonUtils.smallEmoticonJsonUrl.replace("[epId]", Integer.toString(this.this$0.mEpId));
        localObject1 = new File((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("QQText", 2, "small emoji json not exist. epId:" + this.this$0.mEpId + ",downloadUrl:" + (String)localObject3);
        }
        localObject2 = new bhyo((String)localObject3, (File)localObject1);
        ((bhyo)localObject2).j = true;
        int i = bhyq.a((bhyo)localObject2, localQQAppInterface2);
        localObject2 = new EmoticonPackage();
        ((EmoticonPackage)localObject2).epId = Integer.toString(this.this$0.mEpId);
        ((EmoticonPackage)localObject2).jobType = 4;
        if (i != 0) {
          continue;
        }
        if (((File)localObject1).exists())
        {
          localObject1 = FileUtils.fileToBytes((File)localObject1);
          localObject3 = new ArrayList();
          asiw.a(localQQAppInterface2, (EmoticonPackage)localObject2, asih.c, (byte[])localObject1, (ArrayList)localObject3);
          this.this$0.updateApngFlag((EmoticonPackage)localObject2);
          return;
        }
        localObject1 = null;
        continue;
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        return;
      }
      label385:
      Object localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.SmallEmojiSpan.1
 * JD-Core Version:    0.7.0.1
 */