package com.tencent.mobileqq.filemanager.guild;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class FileUtils
{
  public static boolean a()
  {
    return ((IFMConfig)QRoute.api(IFMConfig.class)).preDownloadThumb();
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (paramBaseQQAppInterface != null)
    {
      if (paramFileManagerEntity == null) {
        return false;
      }
      if ((!a()) && (QQFileManagerUtil.h())) {
        return false;
      }
      int i = QQFileManagerUtil.k(paramFileManagerEntity.fileName);
      if (i == 0) {
        b(paramBaseQQAppInterface, paramFileManagerEntity);
      } else if (i == 2) {
        c(paramBaseQQAppInterface, paramFileManagerEntity);
      }
      return true;
    }
    return false;
  }
  
  private static void b(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).isNeedCompressCut(paramFileManagerEntity))
    {
      paramFileManagerEntity.strThumbPath = ((QQAppInterface)paramBaseQQAppInterface).getFileManagerEngine().b(paramFileManagerEntity, 7);
      if (QLog.isColorLevel())
      {
        paramBaseQQAppInterface = new StringBuilder();
        paramBaseQQAppInterface.append("PreloadThumb Id[");
        paramBaseQQAppInterface.append(paramFileManagerEntity.nSessionId);
        paramBaseQQAppInterface.append("] is badPic Preload 750 Thumb[");
        paramBaseQQAppInterface.append(paramFileManagerEntity.strThumbPath);
        paramBaseQQAppInterface.append("]");
        QLog.i("FileUtils", 1, paramBaseQQAppInterface.toString());
      }
    }
    else
    {
      paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
      paramFileManagerEntity.strThumbPath = paramBaseQQAppInterface.getFileManagerEngine().b(paramFileManagerEntity, 5);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PreloadThumb Id[");
        localStringBuilder.append(paramFileManagerEntity.nSessionId);
        localStringBuilder.append("] Preload 384 Thumb[");
        localStringBuilder.append(paramFileManagerEntity.strThumbPath);
        localStringBuilder.append("]");
        QLog.i("FileUtils", 1, localStringBuilder.toString());
      }
      if (!QQFileManagerUtil.h())
      {
        paramFileManagerEntity.strThumbPath = paramBaseQQAppInterface.getFileManagerEngine().b(paramFileManagerEntity, 7);
        if (QLog.isColorLevel())
        {
          paramBaseQQAppInterface = new StringBuilder();
          paramBaseQQAppInterface.append("PreloadThumb Id[");
          paramBaseQQAppInterface.append(paramFileManagerEntity.nSessionId);
          paramBaseQQAppInterface.append("] is Wi-Fi Preload 750 Thumb[");
          paramBaseQQAppInterface.append(paramFileManagerEntity.strThumbPath);
          paramBaseQQAppInterface.append("]");
          QLog.i("FileUtils", 1, paramBaseQQAppInterface.toString());
        }
      }
    }
  }
  
  private static void c(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    paramBaseQQAppInterface = ((QQAppInterface)paramBaseQQAppInterface).getFileManagerEngine().a(paramFileManagerEntity);
    if (paramBaseQQAppInterface != null) {
      paramFileManagerEntity.strLargeThumPath = paramBaseQQAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.guild.FileUtils
 * JD-Core Version:    0.7.0.1
 */