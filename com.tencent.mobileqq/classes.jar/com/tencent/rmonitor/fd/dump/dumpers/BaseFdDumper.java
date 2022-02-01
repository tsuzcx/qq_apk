package com.tencent.rmonitor.fd.dump.dumpers;

import android.os.SystemClock;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import com.tencent.rmonitor.fd.dump.IFdLeakDumper;
import com.tencent.rmonitor.fd.utils.LogUtils;
import java.io.File;

public abstract class BaseFdDumper
  implements IFdLeakDumper
{
  private boolean c(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.exists()) {
      return localFile.isFile();
    }
    return FileUtil.c(paramString);
  }
  
  protected FdLeakDumpResult a(int paramInt)
  {
    return FdLeakDumpResult.failure(a(), paramInt);
  }
  
  protected FdLeakDumpResult a(int paramInt, String paramString)
  {
    return FdLeakDumpResult.failure(a(), paramInt, paramString);
  }
  
  public FdLeakDumpResult a(String paramString)
  {
    long l = SystemClock.uptimeMillis();
    if (!c(paramString))
    {
      LogUtils.c("BaseFdLeakDumper", "dump failed due to invalid file path");
      paramString = a(3, paramString);
    }
    else
    {
      paramString = b(paramString);
    }
    paramString.setDumpDurationMillis(SystemClock.uptimeMillis() - l);
    return paramString;
  }
  
  protected FdLeakDumpResult a(String paramString, Object paramObject)
  {
    return new FdLeakDumpResult(a(), paramString, paramObject);
  }
  
  protected abstract FdLeakDumpResult b(String paramString);
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.dump.dumpers.BaseFdDumper
 * JD-Core Version:    0.7.0.1
 */