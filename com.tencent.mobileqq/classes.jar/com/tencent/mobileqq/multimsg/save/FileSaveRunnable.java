package com.tencent.mobileqq.multimsg.save;

import android.os.Handler;
import android.os.Message;
import awdc;
import awde;
import bfvo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import fd;
import java.io.File;

public class FileSaveRunnable
  implements Runnable
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private awde jdField_a_of_type_Awde;
  private File jdField_a_of_type_JavaIoFile;
  private boolean jdField_a_of_type_Boolean;
  private File b;
  
  public FileSaveRunnable(File paramFile1, File paramFile2, Handler paramHandler, awde paramawde, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile1;
    this.b = paramFile2;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Awde = paramawde;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    j = 1;
    int k = 0;
    Object localObject;
    if ((this.jdField_a_of_type_JavaIoFile == null) || (!this.jdField_a_of_type_JavaIoFile.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureSaveRunnable", 2, "save file fail");
      }
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      this.jdField_a_of_type_Awde.b = 10003;
      this.jdField_a_of_type_Awde.jdField_a_of_type_JavaLangString = awdc.a(this.jdField_a_of_type_Awde.b);
      ((Message)localObject).obj = this.jdField_a_of_type_Awde;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (this.b != null) && (this.b.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureSaveRunnable", 2, "desFile exist");
      }
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
      ((Message)localObject).obj = this.jdField_a_of_type_Awde;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
    }
    for (;;)
    {
      try
      {
        if (this.b != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PictureSaveRunnable", 2, "FileSaveRunnable run savePhotoToSysAlbum...destFile=" + this.b);
          }
          if (!this.b.getParentFile().exists())
          {
            boolean bool = this.b.getParentFile().mkdir();
            if (QLog.isColorLevel()) {
              QLog.i("PictureSaveRunnable", 2, "FileSaveRunnable run savePhotoToSysAlbum...destFile.getParentFile() not exist mkdir=" + bool);
            }
          }
        }
        if ((this.b == null) || (!fd.a(this.jdField_a_of_type_JavaIoFile, this.b))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("PictureSaveRunnable", 2, "savePhotoToSysAlbum...");
        }
        bfvo.a(BaseApplicationImpl.getContext(), this.b.getAbsolutePath());
        i = 1;
        if (i == 0) {
          continue;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PictureSaveRunnable", 2, "save exception = " + localException.getMessage());
        this.jdField_a_of_type_Awde.b = 10005;
        this.jdField_a_of_type_Awde.jdField_a_of_type_JavaLangString = awdc.a(this.jdField_a_of_type_Awde.b);
        continue;
        j = 2;
        continue;
        int i = -1;
        continue;
      }
      localObject = this.jdField_a_of_type_Awde;
      if (i == 0) {
        continue;
      }
      i = k;
      ((awde)localObject).jdField_a_of_type_Int = i;
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(j);
      ((Message)localObject).obj = this.jdField_a_of_type_Awde;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("PictureSaveRunnable", 2, "copyFile error");
      }
      this.jdField_a_of_type_Awde.b = 10004;
      this.jdField_a_of_type_Awde.jdField_a_of_type_JavaLangString = awdc.a(this.jdField_a_of_type_Awde.b);
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.FileSaveRunnable
 * JD-Core Version:    0.7.0.1
 */