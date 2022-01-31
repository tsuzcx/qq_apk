package com.tencent.mobileqq.emosm;

import android.os.Handler;
import android.os.Message;
import anrb;
import anrs;
import asuq;
import bbef;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import gp;
import java.io.File;

public class MultiEmotionSaveManager$1
  implements Runnable
{
  public MultiEmotionSaveManager$1(anrs paramanrs, File paramFile1, File paramFile2, String paramString1, String paramString2, anrb paramanrb) {}
  
  public void run()
  {
    j = 1;
    int k = 0;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoFile != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MultiEmotionSaveManager", 2, "savePhotoToSysAlbum...destFile=" + this.jdField_a_of_type_JavaIoFile);
          }
          if (!this.jdField_a_of_type_JavaIoFile.getParentFile().exists())
          {
            boolean bool = this.jdField_a_of_type_JavaIoFile.getParentFile().mkdir();
            if (QLog.isColorLevel()) {
              QLog.i("MultiEmotionSaveManager", 2, "savePhotoToSysAlbum...destFile.getParentFile() not exist mkdir=" + bool);
            }
          }
        }
        if ((this.jdField_a_of_type_JavaIoFile == null) || (!gp.a(this.jdField_b_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("MultiEmotionSaveManager", 2, "savePhotoToSysAlbum...path=" + this.jdField_a_of_type_JavaLangString);
        }
        bbef.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        i = 1;
        if (i == 0) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MultiEmotionSaveManager", 2, "save exception = " + localException.getMessage());
        this.jdField_a_of_type_Anrb.b = 10005;
        this.jdField_a_of_type_Anrb.c = asuq.a(this.jdField_a_of_type_Anrb.b);
        continue;
        j = 2;
        continue;
        int i = -1;
        continue;
      }
      localObject = this.jdField_a_of_type_Anrb;
      if (i == 0) {
        continue;
      }
      i = k;
      ((anrb)localObject).a = i;
      localObject = anrs.a(this.this$0).obtainMessage(j);
      ((Message)localObject).obj = this.jdField_a_of_type_Anrb;
      anrs.a(this.this$0).sendMessage((Message)localObject);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("MultiEmotionSaveManager", 2, "copyFile error destFileName = " + this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Anrb.b = 10004;
      this.jdField_a_of_type_Anrb.c = asuq.a(this.jdField_a_of_type_Anrb.b);
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.MultiEmotionSaveManager.1
 * JD-Core Version:    0.7.0.1
 */