package com.tencent.mobileqq.filemanager.core;

import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Observable;
import mqq.os.MqqHandler;

public class FileManagerNotifyCenter
  extends Observable
{
  QQAppInterface a;
  MqqHandler b = new FileManagerNotifyCenter.1(this, Looper.getMainLooper());
  
  public FileManagerNotifyCenter(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    paramQQAppInterface.setHandler(getClass(), this.b);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("averageSpeed", String.valueOf(0.0F));
    ((HashMap)localObject).put("peerUin", String.valueOf(paramFileManagerEntity.peerUin));
    ((HashMap)localObject).put("fileType", FileUtil.a(paramFileManagerEntity.fileName));
    if (paramInt != 5)
    {
      if (paramInt != 6)
      {
        if (paramInt != 7)
        {
          if (paramInt != 8)
          {
            if (paramInt != 10) {
              switch (paramInt)
              {
              default: 
                paramString = new StringBuilder();
                paramString.append("what type is report?!nSessionId[");
                paramString.append(String.valueOf(paramFileManagerEntity.nSessionId));
                paramString.append("],may be not report!");
                QLog.e("FileManagerNotifyCenter<FileAssistant>", 1, paramString.toString());
                return;
              case 64: 
                localObject = "actFileTroop2Disc";
                break;
              case 63: 
                localObject = "actFileTroop2Of";
                break;
              case 62: 
                localObject = "actFileDisc2Disc";
                break;
              case 61: 
                localObject = "actFileDisc2Of";
                break;
              }
            } else {
              localObject = "actFileFav2Disc";
            }
          }
          else {
            localObject = "actFileWy2Of";
          }
        }
        else {
          localObject = "actFileOf2Wy";
        }
      }
      else {
        localObject = "actFileOf2Of";
      }
      FileManagerUtil.a(this.a, paramFileManagerEntity.nSessionId, (String)localObject, 1L, paramString, paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 0L, 0L, paramFileManagerEntity.fileSize, 0, null);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, Object paramObject, int paramInt3, String paramString2)
  {
    setChanged();
    if (paramObject == null)
    {
      notifyObservers(new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), paramString2 });
      return;
    }
    notifyObservers(new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, Integer.valueOf(paramInt1), paramObject });
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    b(paramFileManagerEntity, paramInt, paramString);
    ThreadManager.executeOnSubThread(new FileManagerNotifyCenter.2(this, paramFileManagerEntity, paramInt));
  }
  
  public void a(boolean paramBoolean, int paramInt, Object paramObject)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramObject });
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter
 * JD-Core Version:    0.7.0.1
 */