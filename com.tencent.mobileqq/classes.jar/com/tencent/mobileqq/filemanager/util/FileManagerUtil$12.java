package com.tencent.mobileqq.filemanager.util;

import android.graphics.Bitmap;
import com.dataline.util.file.MediaStoreUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.IOException;

final class FileManagerUtil$12
  implements FileManagerUtil.IGetVideoCallback
{
  FileManagerUtil$12(FileManagerUtil.IThumbResult paramIThumbResult, String paramString1, String paramString2) {}
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult.a(null);
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          FileUtil.a(paramBitmap, this.jdField_a_of_type_JavaLangString);
          paramBitmap.recycle();
          int i = MediaStoreUtil.a(this.b);
          MediaStoreUtil.a(this.jdField_a_of_type_JavaLangString, i);
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult.a(this.jdField_a_of_type_JavaLangString);
            return;
          }
        }
        catch (FileNotFoundException paramBitmap)
        {
          paramBitmap.printStackTrace();
          QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail FileNotFoundException:" + paramBitmap.getMessage());
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult.a(null);
            return;
          }
        }
        catch (IOException paramBitmap)
        {
          paramBitmap.printStackTrace();
          QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail IOException:" + paramBitmap.getMessage());
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult.a(null);
            return;
          }
        }
        catch (OutOfMemoryError paramBitmap)
        {
          paramBitmap.printStackTrace();
          QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + paramBitmap.getMessage());
        }
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileManagerUtil$IThumbResult.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.12
 * JD-Core Version:    0.7.0.1
 */