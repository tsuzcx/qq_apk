package com.tencent.mobileqq.emosm;

import android.os.Handler;
import android.os.Message;
import apij;
import apja;
import auln;
import bdda;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import ey;
import java.io.File;

public class MultiEmotionSaveManager$1
  implements Runnable
{
  public MultiEmotionSaveManager$1(apja paramapja, File paramFile1, File paramFile2, String paramString1, String paramString2, apij paramapij) {}
  
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
        if ((this.jdField_a_of_type_JavaIoFile == null) || (!ey.a(this.jdField_b_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("MultiEmotionSaveManager", 2, "savePhotoToSysAlbum...path=" + this.jdField_a_of_type_JavaLangString);
        }
        bdda.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
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
        this.jdField_a_of_type_Apij.b = 10005;
        this.jdField_a_of_type_Apij.c = auln.a(this.jdField_a_of_type_Apij.b);
        continue;
        j = 2;
        continue;
        int i = -1;
        continue;
      }
      localObject = this.jdField_a_of_type_Apij;
      if (i == 0) {
        continue;
      }
      i = k;
      ((apij)localObject).a = i;
      localObject = apja.a(this.this$0).obtainMessage(j);
      ((Message)localObject).obj = this.jdField_a_of_type_Apij;
      apja.a(this.this$0).sendMessage((Message)localObject);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("MultiEmotionSaveManager", 2, "copyFile error destFileName = " + this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Apij.b = 10004;
      this.jdField_a_of_type_Apij.c = auln.a(this.jdField_a_of_type_Apij.b);
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.MultiEmotionSaveManager.1
 * JD-Core Version:    0.7.0.1
 */