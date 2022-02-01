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
      if (this.jdField_a_of_type_JavaIoFile != null)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("savePhotoToSysAlbum...destFile=");
          localStringBuilder1.append(this.jdField_a_of_type_JavaIoFile);
          QLog.i("MultiEmotionSaveManager", 2, localStringBuilder1.toString());
        }
        if (!this.jdField_a_of_type_JavaIoFile.getParentFile().exists())
        {
          boolean bool = this.jdField_a_of_type_JavaIoFile.getParentFile().mkdir();
          if (QLog.isColorLevel())
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("savePhotoToSysAlbum...destFile.getParentFile() not exist mkdir=");
            localStringBuilder1.append(bool);
            QLog.i("MultiEmotionSaveManager", 2, localStringBuilder1.toString());
          }
        }
      }
      if ((this.jdField_a_of_type_JavaIoFile != null) && (FileUtils.copyFile(this.b, this.jdField_a_of_type_JavaIoFile)))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("savePhotoToSysAlbum...path=");
          localStringBuilder1.append(this.jdField_a_of_type_JavaLangString);
          QLog.e("MultiEmotionSaveManager", 2, localStringBuilder1.toString());
        }
        BaseImageUtil.a(MobileQQ.getContext(), this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        i = 1;
        break label365;
      }
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_JavaIoFile != null))
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("copyFile error destFile = ");
        localStringBuilder1.append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        QLog.e("MultiEmotionSaveManager", 2, localStringBuilder1.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmEmotionSaveResult.b = 10004;
      this.jdField_a_of_type_ComTencentMobileqqEmosmEmotionSaveResult.c = FileSaveErrorInfo.a(this.jdField_a_of_type_ComTencentMobileqqEmosmEmotionSaveResult.b);
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmEmotionSaveResult;
      ((EmotionSaveResult)localObject).b = 10005;
      ((EmotionSaveResult)localObject).c = FileSaveErrorInfo.a(((EmotionSaveResult)localObject).b);
    }
    int i = 0;
    label365:
    if (i == 0) {
      j = 2;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmEmotionSaveResult;
    if (i != 0) {
      i = k;
    } else {
      i = -1;
    }
    ((EmotionSaveResult)localObject).a = i;
    localObject = MultiEmotionSaveManager.a(this.this$0).obtainMessage(j);
    ((Message)localObject).obj = this.jdField_a_of_type_ComTencentMobileqqEmosmEmotionSaveResult;
    MultiEmotionSaveManager.a(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.MultiEmotionSaveManager.1
 * JD-Core Version:    0.7.0.1
 */