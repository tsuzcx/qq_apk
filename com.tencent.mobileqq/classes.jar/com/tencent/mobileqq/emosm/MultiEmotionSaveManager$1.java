package com.tencent.mobileqq.emosm;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.multimsg.save.FileSaveErrorInfo;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class MultiEmotionSaveManager$1
  implements Runnable
{
  MultiEmotionSaveManager$1(MultiEmotionSaveManager paramMultiEmotionSaveManager, File paramFile1, File paramFile2, String paramString, EmotionSaveResult paramEmotionSaveResult) {}
  
  public void run()
  {
    int j = 1;
    int k = 0;
    try
    {
      StringBuilder localStringBuilder1;
      if (this.a != null)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("savePhotoToSysAlbum...destFile=");
          localStringBuilder1.append(this.a);
          QLog.i("MultiEmotionSaveManager", 2, localStringBuilder1.toString());
        }
        if (!this.a.getParentFile().exists())
        {
          boolean bool = this.a.getParentFile().mkdir();
          if (QLog.isColorLevel())
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("savePhotoToSysAlbum...destFile.getParentFile() not exist mkdir=");
            localStringBuilder1.append(bool);
            QLog.i("MultiEmotionSaveManager", 2, localStringBuilder1.toString());
          }
        }
      }
      if ((this.a != null) && (FileUtils.copyFile(this.b, this.a)))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("savePhotoToSysAlbum...path=");
          localStringBuilder1.append(this.c);
          QLog.e("MultiEmotionSaveManager", 2, localStringBuilder1.toString());
        }
        BaseImageUtil.b(MobileQQ.getContext(), this.a.getAbsolutePath());
        i = 1;
        break label365;
      }
      if ((QLog.isColorLevel()) && (this.a != null))
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("copyFile error destFile = ");
        localStringBuilder1.append(this.a.getAbsolutePath());
        QLog.e("MultiEmotionSaveManager", 2, localStringBuilder1.toString());
      }
      this.d.e = 10004;
      this.d.f = FileSaveErrorInfo.a(this.d.e);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("save exception = ");
        localStringBuilder2.append(localException.getMessage());
        QLog.e("MultiEmotionSaveManager", 2, localStringBuilder2.toString());
      }
      localObject = this.d;
      ((EmotionSaveResult)localObject).e = 10005;
      ((EmotionSaveResult)localObject).f = FileSaveErrorInfo.a(((EmotionSaveResult)localObject).e);
    }
    int i = 0;
    label365:
    if (i == 0) {
      j = 2;
    }
    Object localObject = this.d;
    if (i != 0) {
      i = k;
    } else {
      i = -1;
    }
    ((EmotionSaveResult)localObject).d = i;
    localObject = MultiEmotionSaveManager.a(this.this$0).obtainMessage(j);
    ((Message)localObject).obj = this.d;
    MultiEmotionSaveManager.a(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.MultiEmotionSaveManager.1
 * JD-Core Version:    0.7.0.1
 */