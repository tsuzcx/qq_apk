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
      paramBitmap = this.a;
      if (paramBitmap != null) {
        paramBitmap.a(null);
      }
      return;
    }
    try
    {
      FileUtil.a(paramBitmap, this.b);
      paramBitmap.recycle();
      int i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getImageDegree(this.c);
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).setImageDegree(this.b, i);
      if (this.a != null)
      {
        this.a.a(this.b);
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
      paramBitmap = this.a;
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
      paramBitmap = this.a;
      if (paramBitmap != null)
      {
        paramBitmap.a(null);
        return;
      }
    }
    catch (FileNotFoundException paramBitmap)
    {
      QQFileManagerUtilImpl.a(this.a, paramBitmap, "createThumbnail FileNotFoundException:");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.11
 * JD-Core Version:    0.7.0.1
 */