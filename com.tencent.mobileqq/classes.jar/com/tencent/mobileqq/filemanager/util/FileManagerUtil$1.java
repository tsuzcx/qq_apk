package com.tencent.mobileqq.filemanager.util;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import java.util.UUID;

final class FileManagerUtil$1
  implements IForwardCallBack
{
  FileManagerUtil$1(QQAppInterface paramQQAppInterface) {}
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3)
  {
    return a(paramString1, paramInt1, paramString2, paramInt2, paramString3, paramString4, paramString5, paramLong, paramInt3, 0L, 0);
  }
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong1, int paramInt3, long paramLong2, int paramInt4)
  {
    return 0L;
  }
  
  public String a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, int paramInt3)
  {
    if (paramInt1 == 3000) {
      paramInt1 = 106;
    } else if (paramInt1 == 6000) {
      paramInt1 = 38;
    } else {
      paramInt1 = 3;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a, Long.valueOf(paramString2).longValue());
    if (localTroopFileTransferManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, "send2Troop: troopuin error");
      }
      return null;
    }
    paramInt2 = Math.abs(new Random().nextInt());
    FileManagerEntity localFileManagerEntity = this.a.getFileManagerDataCenter().a(paramLong2);
    paramString3 = localTroopFileTransferManager.a(paramString3, paramString4, null, paramLong1, paramInt1, paramInt2, Long.valueOf(paramString1).longValue(), paramLong2, localFileManagerEntity);
    if (paramString3 == null)
    {
      QLog.e("FileManagerUtil<FileAssistant>", 1, "startCopy2TroopFromOfflineOrDisc return null!");
      return "";
    }
    long l = 0L;
    paramInt1 = FileManagerUtil.a(paramString3.jdField_a_of_type_JavaLangString);
    if ((FileUtil.b(paramString3.jdField_a_of_type_JavaLangString)) && ((paramInt1 == 0) || (paramInt1 == 2)))
    {
      if (paramInt1 == 0)
      {
        paramString1 = new BitmapFactory.Options();
        paramString1.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString3.jdField_a_of_type_JavaLangString, paramString1);
        paramLong1 = TroopFileUtils.a(this.a, paramString2, paramString3.g, paramString3.c, paramString3.jdField_a_of_type_JavaUtilUUID.toString(), paramInt2, String.valueOf(paramString3.b), paramLong2, paramString1.outWidth, paramString1.outHeight, paramLong3, paramInt3);
      }
      else
      {
        paramLong1 = l;
        if (paramInt1 == 2)
        {
          paramString1 = ShortVideoUtils.getVideoFileRtAndTime(paramString3.jdField_a_of_type_JavaLangString);
          paramLong1 = TroopFileUtils.a(this.a, paramString2, paramString3.g, paramString3.c, paramString3.jdField_a_of_type_JavaUtilUUID.toString(), paramInt2, String.valueOf(paramString3.b), paramLong2, paramString1[0], paramString1[1], paramString1[2], paramLong3, paramInt3);
        }
      }
    }
    else
    {
      paramString1 = localFileManagerEntity;
      if (paramString1 != null) {
        paramLong1 = TroopFileUtils.a(this.a, paramString2, paramString4, paramLong1, paramString3.jdField_a_of_type_JavaUtilUUID.toString(), paramInt2, String.valueOf(8888L), paramLong2, paramString1.imgWidth, paramString1.imgHeight, 0, paramLong3, paramInt3);
      } else {
        paramLong1 = TroopFileUtils.a(this.a, paramString2, paramString4, paramLong1, paramString3.jdField_a_of_type_JavaUtilUUID.toString(), paramInt2, String.valueOf(8888L), paramLong2, paramLong3, paramInt3);
      }
    }
    if (localFileManagerEntity != null)
    {
      localFileManagerEntity.structMsgSeq = paramLong1;
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("prepareForward2Troop==>InsertAIOMsg, msgSeq:");
        paramString1.append(paramLong1);
        QLog.d("FileManagerUtil<FileAssistant>", 2, paramString1.toString());
      }
    }
    return paramString3.jdField_a_of_type_JavaUtilUUID.toString();
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void a(boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopProcessCallback->onResult2Troop{bSuccess[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("],troopFileUuid[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("],nSessionId[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("],retCode[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("],retMsg[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("],troopUin[");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("],newFilePath[");
      localStringBuilder.append(paramString4);
      localStringBuilder.append("]}");
      QLog.i("FileManagerUtil<FileAssistant>", 2, localStringBuilder.toString());
    }
    paramString3 = TroopFileTransferManager.a(this.a, Long.valueOf(paramString3).longValue());
    if (paramString3 != null) {
      paramString3.a(paramLong, UUID.fromString(paramString1), null, paramInt, paramString4, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.1
 * JD-Core Version:    0.7.0.1
 */