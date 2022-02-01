package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AudioDataCache
{
  private String a;
  private String b;
  private FileOutputStream c;
  
  public AudioDataCache(String paramString)
  {
    this.a = paramString;
    paramString = new StringBuilder();
    paramString.append(this.a);
    paramString.append(File.separator);
    paramString.append("audio_data_cache");
    paramString.append(File.separator);
    this.a = paramString.toString();
    paramString = new File(this.a);
    boolean bool1 = paramString.mkdirs();
    boolean bool2 = paramString.isDirectory();
    if (!bool1)
    {
      if (bool2) {
        return;
      }
      paramString = new StringBuilder();
      paramString.append("AudioDataCache: mkd=");
      paramString.append(bool1);
      paramString.append(" isdir=");
      paramString.append(bool2);
      throw new RuntimeException(paramString.toString());
    }
  }
  
  private static void a(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] ");
        localStringBuilder.append(paramString);
        QLog.d("AudioDataCache", 2, localStringBuilder.toString(), paramThrowable);
        return;
      }
      paramThrowable = new StringBuilder();
      paramThrowable.append("[@] ");
      paramThrowable.append(paramString);
      QLog.d("AudioDataCache", 2, paramThrowable.toString());
    }
  }
  
  public void a(RMVideoStateMgr paramRMVideoStateMgr)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initCache: oldpath=");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(" mOutStream=");
    ((StringBuilder)localObject).append(this.c);
    a(((StringBuilder)localObject).toString(), null);
    b(paramRMVideoStateMgr);
    this.b = VidUtil.generateVid();
    paramRMVideoStateMgr = new StringBuilder();
    paramRMVideoStateMgr.append(this.a);
    paramRMVideoStateMgr.append(this.b);
    paramRMVideoStateMgr = paramRMVideoStateMgr.toString();
    localObject = new File(paramRMVideoStateMgr);
    if (!((File)localObject).exists()) {}
    try
    {
      this.c = new FileOutputStream((File)localObject);
    }
    catch (FileNotFoundException paramRMVideoStateMgr)
    {
      label123:
      break label123;
    }
    this.c = null;
    paramRMVideoStateMgr = new StringBuilder();
    paramRMVideoStateMgr.append("initCache: newPath=");
    paramRMVideoStateMgr.append(this.b);
    a(paramRMVideoStateMgr.toString(), null);
    return;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AudioDataCache: file exists| ");
    ((StringBuilder)localObject).append(paramRMVideoStateMgr);
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    FileOutputStream localFileOutputStream = this.c;
    if (localFileOutputStream != null) {
      try
      {
        localFileOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
        return true;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        a("writeData: exp=", paramArrayOfByte);
      }
    }
    return false;
  }
  
  public String b(RMVideoStateMgr paramRMVideoStateMgr)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("closeCache: path=");
    ((StringBuilder)localObject).append(this.b);
    a(((StringBuilder)localObject).toString(), null);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(this.b);
    localObject = ((StringBuilder)localObject).toString();
    if ((this.c == null) || (paramRMVideoStateMgr != null)) {}
    try
    {
      paramRMVideoStateMgr.o();
      this.c.close();
    }
    catch (IOException paramRMVideoStateMgr)
    {
      label86:
      break label86;
    }
    this.c = null;
    this.b = null;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.AudioDataCache
 * JD-Core Version:    0.7.0.1
 */