package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FileTransferObserver
{
  public void a() {}
  
  void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof String)))
    {
      paramObject = (Object[])paramObject;
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onUpdate : type[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("], isSuccess[");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append("]");
        QLog.d("FileTransferObserver<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            paramObject = new StringBuilder();
            paramObject.append("onUpdate : Can Not process type");
            paramObject.append(paramInt);
            QLog.e("FileTransferObserver<FileAssistant>", 1, paramObject.toString());
          }
          break;
        }
      case 5007: 
        for (;;)
        {
          return;
          b(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (List)paramObject[1]);
          continue;
          a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (List)paramObject[1]);
          continue;
          b(paramBoolean, (FileUploadInfo)paramObject[0], (StatictisInfo)paramObject[1], (List)paramObject[2]);
          continue;
          a(paramBoolean, (Long)paramObject[0]);
          continue;
          localObject = (Long)paramObject[0];
          String str1 = (String)paramObject[1];
          String str2 = (String)paramObject[2];
          String str3 = (String)paramObject[3];
          String str4 = (String)paramObject[4];
          Integer localInteger = (Integer)paramObject[5];
          String str5 = (String)paramObject[6];
          String str6 = (String)paramObject[7];
          paramObject = (Bundle)paramObject[8];
          a(paramBoolean, ((Long)localObject).longValue(), str1, str2, str3, str4, localInteger.intValue(), str5, str6, paramObject);
          continue;
          paramBoolean = ((Boolean)paramObject[0]).booleanValue();
          long l = ((Long)paramObject[1]).longValue();
          paramInt = ((Integer)paramObject[2]).intValue();
          a(paramBoolean, l, ((Long)paramObject[3]).longValue(), paramInt, ((Long)paramObject[4]).longValue());
          continue;
          a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue(), (String)paramObject[5], (String)paramObject[6], ((Integer)paramObject[7]).intValue(), ((Long)paramObject[8]).longValue(), (Bundle)paramObject[9]);
          continue;
          b(paramBoolean, (FileUploadInfo)paramObject[0], (StatictisInfo)paramObject[1]);
        }
      case 5006: 
        a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], (String)paramObject[2], (ByteStringMicro)paramObject[3], ((Boolean)paramObject[4]).booleanValue(), (String)paramObject[5], ((Short)paramObject[6]).shortValue(), (String)paramObject[7], (List)paramObject[8], ((Integer)paramObject[9]).intValue(), (String)paramObject[10], (String)paramObject[11], (String)paramObject[12], ((Long)paramObject[13]).longValue(), (Bundle)paramObject[14]);
        return;
      case 5005: 
        a(paramBoolean, (FileUploadInfo)paramObject[0], (StatictisInfo)paramObject[1]);
        return;
      }
      a(paramBoolean, (FileUploadInfo)paramObject[0], (StatictisInfo)paramObject[1], (List)paramObject[2]);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, long paramLong3) {}
  
  protected void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, FileUploadInfo paramFileUploadInfo, StatictisInfo paramStatictisInfo) {}
  
  protected void a(boolean paramBoolean, FileUploadInfo paramFileUploadInfo, StatictisInfo paramStatictisInfo, List<String> paramList) {}
  
  protected void a(boolean paramBoolean, Long paramLong) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<OfflineFileInfo> paramList) {}
  
  protected void b(boolean paramBoolean, FileUploadInfo paramFileUploadInfo, StatictisInfo paramStatictisInfo) {}
  
  protected void b(boolean paramBoolean, FileUploadInfo paramFileUploadInfo, StatictisInfo paramStatictisInfo, List<String> paramList) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, List<OfflineFileInfo> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferObserver
 * JD-Core Version:    0.7.0.1
 */