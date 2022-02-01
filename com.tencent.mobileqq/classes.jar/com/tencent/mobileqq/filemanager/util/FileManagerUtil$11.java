package com.tencent.mobileqq.filemanager.util;

import android.graphics.Bitmap;
import com.dataline.util.file.MediaStoreUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.IOException;

final class FileManagerUtil$11
  implements Runnable
{
  FileManagerUtil$11(String paramString1, FileManagerUtil.IThumbResult paramIThumbResult, String paramString2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (FileUtil.b(this.jdField_a_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult.a(this.jdField_a_of_type_JavaLangString);
      }
    }
    do
    {
      for (;;)
      {
        return;
        Bitmap localBitmap = MediaStoreUtil.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        if (localBitmap == null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult != null) {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult.a(null);
          }
        }
        else {
          try
          {
            FileUtil.a(localBitmap, this.jdField_a_of_type_JavaLangString);
            localBitmap.recycle();
            int i = MediaStoreUtil.a(this.jdField_b_of_type_JavaLangString);
            MediaStoreUtil.a(this.jdField_a_of_type_JavaLangString, i);
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult.a(this.jdField_a_of_type_JavaLangString);
              return;
            }
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            localFileNotFoundException.printStackTrace();
            QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail FileNotFoundException:" + localFileNotFoundException.getMessage());
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult.a(null);
              return;
            }
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
            QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail IOException:" + localIOException.getMessage());
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult.a(null);
              return;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            localOutOfMemoryError.printStackTrace();
            QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + localOutOfMemoryError.getMessage());
          }
        }
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.11
 * JD-Core Version:    0.7.0.1
 */