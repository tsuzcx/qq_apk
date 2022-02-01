package com.tencent.mobileqq.vas.updatesystem.impl;

import android.content.Context;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.ICommonManager;
import java.io.File;
import mqq.app.MobileQQ;

public class VasCommonManagerImpl
  implements ICommonManager
{
  public boolean copyFile(String paramString1, String paramString2)
  {
    boolean bool = false;
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    try
    {
      bool = FileUtils.a(paramString1, FileUtils.a(paramString2));
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
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_CommonManagerImpl", 2, "bsPatch: srcFile = " + paramString1 + " patchFile = " + paramString2);
    }
    return ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).patch(paramString1, paramString2, paramString1);
  }
  
  public String getAppVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_CommonManagerImpl", 2, "getAppVersion = 8.5.5");
    }
    return "8.5.5";
  }
  
  public Context getApplicationContext()
  {
    return MobileQQ.getContext();
  }
  
  public String getFileMd5(String paramString)
  {
    return ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).getFileMd5(paramString);
  }
  
  public int getNetType()
  {
    int j = 0;
    int i = j;
    switch (HttpUtil.getNetWorkType())
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasUpdate_CommonManagerImpl", 2, "getNetType netType = " + i + " local = " + HttpUtil.getNetWorkType());
      }
      return i;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 5;
      continue;
      i = 4;
      continue;
      i = 3;
    }
  }
  
  public String getReportVersion()
  {
    return "8.5.5.5105";
  }
  
  public String getSeqConfigPath()
  {
    return VasUpdateConstants.a;
  }
  
  public long getServiceTime()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  public long getTimerDelay()
  {
    return 500L;
  }
  
  public String unCompressFile(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_CommonManagerImpl", 2, "uncompressZip: type = " + paramInt + " srcFile = " + paramString);
    }
    if (paramInt != 1) {}
    for (;;)
    {
      return null;
      Object localObject = new File(paramString);
      if (!((File)localObject).exists())
      {
        QLog.e("VasUpdate_CommonManagerImpl", 1, "uncompressZip file un exist");
        return null;
      }
      paramString = ((File)localObject).getParent() + File.separator;
      try
      {
        localObject = VasUpdateUtil.a((File)localObject, paramString);
        if (localObject != null)
        {
          paramString = paramString + (String)localObject;
          if (QLog.isColorLevel()) {
            QLog.d("VasUpdate_CommonManagerImpl", 2, "uncompressZip result = " + paramString);
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("VasUpdate_CommonManagerImpl", 2, "uncompressZip fail");
          return null;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("VasUpdate_CommonManagerImpl", 1, "uncompressZip error : ", paramString);
        return null;
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.impl.VasCommonManagerImpl
 * JD-Core Version:    0.7.0.1
 */