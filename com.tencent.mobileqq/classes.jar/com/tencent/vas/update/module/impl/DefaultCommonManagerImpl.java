package com.tencent.vas.update.module.impl;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.vas.update.callback.ICommonManager;
import com.tencent.vas.update.util.FileUtil;
import com.tencent.vas.update.util.MD5Utils;
import java.io.File;

public class DefaultCommonManagerImpl
  implements ICommonManager
{
  public boolean copyFile(String paramString1, String paramString2)
  {
    boolean bool = false;
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    try
    {
      bool = FileUtil.copyFile(paramString1, FileUtil.createFile(paramString2));
      return bool;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public boolean filePatch(String paramString1, String paramString2)
  {
    return false;
  }
  
  public String getAppVersion()
  {
    return "1.0.0";
  }
  
  public Context getApplicationContext()
  {
    return null;
  }
  
  public String getFileMd5(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return MD5Utils.encodeFileHexStr(paramString);
  }
  
  public int getNetType()
  {
    return 1;
  }
  
  public String getReportVersion()
  {
    return getAppVersion();
  }
  
  public String getSeqConfigPath()
  {
    return Environment.getExternalStorageDirectory() + "/A_VasUpdateSystem/seq/";
  }
  
  public long getServiceTime()
  {
    return System.currentTimeMillis();
  }
  
  public long getTimerDelay()
  {
    return 500L;
  }
  
  public String unCompressFile(int paramInt, String paramString)
  {
    return FileUtil.unZipFile(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.module.impl.DefaultCommonManagerImpl
 * JD-Core Version:    0.7.0.1
 */