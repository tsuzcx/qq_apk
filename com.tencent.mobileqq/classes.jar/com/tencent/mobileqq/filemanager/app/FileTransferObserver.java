package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FileTransferObserver
{
  public void a() {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject == null) || ((paramObject instanceof String))) {
      return;
    }
    Object localObject = (Object[])paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferObserver<FileAssistant>", 2, "onUpdate : type[" + paramInt + "], isSuccess[" + paramBoolean + "]");
    }
    switch (paramInt)
    {
    case 5008: 
    case 5009: 
    case 5010: 
    case 5011: 
    case 5012: 
    case 5017: 
    case 5018: 
    case 5019: 
    default: 
      QLog.e("FileTransferObserver<FileAssistant>", 1, "onUpdate : Can Not process type" + paramInt);
      return;
    case 5004: 
      a(paramBoolean, (FileTransferHandler.FileUploadInfo)localObject[0], (MessageObserver.StatictisInfo)localObject[1], (List)localObject[2]);
      return;
    case 5005: 
      a(paramBoolean, (FileTransferHandler.FileUploadInfo)localObject[0], (MessageObserver.StatictisInfo)localObject[1]);
      return;
    case 5006: 
      a(paramBoolean, ((Long)localObject[0]).longValue(), (String)localObject[1], (String)localObject[2], (ByteStringMicro)localObject[3], (String)localObject[4], ((Short)localObject[5]).shortValue(), (String)localObject[6], (List)localObject[7], ((Integer)localObject[8]).intValue(), (String)localObject[9], ((Long)localObject[10]).longValue());
      return;
    case 5007: 
      b(paramBoolean, (FileTransferHandler.FileUploadInfo)localObject[0], (MessageObserver.StatictisInfo)localObject[1]);
      return;
    case 5013: 
      a(paramBoolean, ((Long)localObject[0]).longValue(), (String)localObject[1], (String)localObject[2], (String)localObject[3], ((Integer)localObject[4]).intValue(), (String)localObject[5], (String)localObject[6], ((Integer)localObject[7]).intValue(), ((Long)localObject[8]).longValue());
      return;
    case 5014: 
      paramBoolean = ((Boolean)localObject[0]).booleanValue();
      long l = ((Long)localObject[1]).longValue();
      paramInt = ((Integer)localObject[2]).intValue();
      a(paramBoolean, l, ((Long)localObject[3]).longValue(), paramInt);
      return;
    case 5015: 
      paramObject = (Long)localObject[0];
      String str1 = (String)localObject[1];
      String str2 = (String)localObject[2];
      String str3 = (String)localObject[3];
      String str4 = (String)localObject[4];
      Integer localInteger = (Integer)localObject[5];
      String str5 = (String)localObject[6];
      localObject = (String)localObject[7];
      a(paramBoolean, paramObject.longValue(), str1, str2, str3, str4, localInteger.intValue(), str5, (String)localObject);
      return;
    case 5016: 
      a(paramBoolean, (Long)localObject[0]);
      return;
    }
    b(paramBoolean, (FileTransferHandler.FileUploadInfo)localObject[0], (MessageObserver.StatictisInfo)localObject[1], (List)localObject[2]);
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, String paramString3, short paramShort, String paramString4, List paramList, int paramInt, String paramString5, long paramLong2) {}
  
  public void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6) {}
  
  public void a(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo) {}
  
  public void a(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo, List paramList) {}
  
  public void a(boolean paramBoolean, Long paramLong) {}
  
  public void b(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo) {}
  
  public void b(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo, List paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferObserver
 * JD-Core Version:    0.7.0.1
 */