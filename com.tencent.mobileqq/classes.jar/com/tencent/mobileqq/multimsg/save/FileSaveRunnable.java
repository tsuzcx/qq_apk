package com.tencent.mobileqq.multimsg.save;

import android.os.Handler;
import android.os.Message;
import com.dataline.util.file.FileUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FileSaveRunnable
  implements Runnable
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FileSaveResult jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveResult;
  private File jdField_a_of_type_JavaIoFile;
  private boolean jdField_a_of_type_Boolean;
  private File b;
  
  public FileSaveRunnable(File paramFile1, File paramFile2, Handler paramHandler, FileSaveResult paramFileSaveResult, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile1;
    this.b = paramFile2;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveResult = paramFileSaveResult;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_JavaIoFile;
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = this.b;
        if ((localObject1 != null) && (((File)localObject1).exists()))
        {
          if (QLog.isColorLevel()) {
            QLog.e("PictureSaveRunnable", 2, "desFile exist");
          }
          localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
          ((Message)localObject1).obj = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveResult;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
          return;
        }
      }
      int j = 1;
      int k = 0;
      try
      {
        if (this.b != null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("FileSaveRunnable run savePhotoToSysAlbum...destFile=");
            ((StringBuilder)localObject1).append(this.b);
            QLog.i("PictureSaveRunnable", 2, ((StringBuilder)localObject1).toString());
          }
          if (!this.b.getParentFile().exists())
          {
            boolean bool = this.b.getParentFile().mkdir();
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("FileSaveRunnable run savePhotoToSysAlbum...destFile.getParentFile() not exist mkdir=");
              ((StringBuilder)localObject1).append(bool);
              QLog.i("PictureSaveRunnable", 2, ((StringBuilder)localObject1).toString());
            }
          }
        }
        if ((this.b != null) && (FileUtil.a(this.jdField_a_of_type_JavaIoFile, this.b)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("PictureSaveRunnable", 2, "savePhotoToSysAlbum...");
          }
          ImageUtil.a(BaseApplicationImpl.getApplication(), this.b);
          ImageUtil.a(BaseApplicationImpl.getContext(), this.b.getAbsolutePath());
          i = 1;
          break label397;
        }
        if (QLog.isColorLevel()) {
          QLog.e("PictureSaveRunnable", 2, "copyFile error");
        }
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveResult.b = 10004;
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveResult.jdField_a_of_type_JavaLangString = FileSaveErrorInfo.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveResult.b);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("save exception = ");
          ((StringBuilder)localObject3).append(localException.getMessage());
          QLog.e("PictureSaveRunnable", 2, ((StringBuilder)localObject3).toString());
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveResult;
        ((FileSaveResult)localObject2).b = 10005;
        ((FileSaveResult)localObject2).jdField_a_of_type_JavaLangString = FileSaveErrorInfo.a(((FileSaveResult)localObject2).b);
      }
      int i = 0;
      label397:
      if (i == 0) {
        j = 2;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveResult;
      if (i != 0) {
        i = k;
      } else {
        i = -1;
      }
      ((FileSaveResult)localObject2).jdField_a_of_type_Int = i;
      localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(j);
      ((Message)localObject2).obj = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveResult;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PictureSaveRunnable", 2, "save file fail");
    }
    Object localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveResult;
    ((FileSaveResult)localObject3).b = 10003;
    ((FileSaveResult)localObject3).jdField_a_of_type_JavaLangString = FileSaveErrorInfo.a(((FileSaveResult)localObject3).b);
    ((Message)localObject2).obj = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveResult;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.FileSaveRunnable
 * JD-Core Version:    0.7.0.1
 */