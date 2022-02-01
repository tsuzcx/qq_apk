package com.tencent.mobileqq.filemanager.util;

import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.IOException;

final class QQFileManagerUtilImpl$11
  implements QQFileManagerUtil.IGetVideoCallback
{
  QQFileManagerUtilImpl$11(QQFileManagerUtil.IThumbResult paramIThumbResult, String paramString1, String paramString2) {}
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilQQFileManagerUtil$IThumbResult;
      if (paramBitmap != null) {
        paramBitmap.a(null);
      }
      return;
    }
    try
    {
      FileUtil.a(paramBitmap, this.jdField_a_of_type_JavaLangString);
      paramBitmap.recycle();
      int i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getImageDegree(this.b);
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).setImageDegree(this.jdField_a_of_type_JavaLangString, i);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilQQFileManagerUtil$IThumbResult != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilQQFileManagerUtil$IThumbResult.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap.printStackTrace();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("createThumbnail OutOfMemoryError:");
      localStringBuilder.append(paramBitmap.getMessage());
      QLog.w("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilQQFileManagerUtil$IThumbResult;
      if (paramBitmap != null)
      {
        paramBitmap.a(null);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      paramBitmap.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createThumbnail IOException:");
      localStringBuilder.append(paramBitmap.getMessage());
      QLog.w("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilQQFileManagerUtil$IThumbResult;
      if (paramBitmap != null)
      {
        paramBitmap.a(null);
        return;
      }
    }
    catch (FileNotFoundException paramBitmap)
    {
      QQFileManagerUtilImpl.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilQQFileManagerUtil$IThumbResult, paramBitmap, "createThumbnail FileNotFoundException:");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.11
 * JD-Core Version:    0.7.0.1
 */