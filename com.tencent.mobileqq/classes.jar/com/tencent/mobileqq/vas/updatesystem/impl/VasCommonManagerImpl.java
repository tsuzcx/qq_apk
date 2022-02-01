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
import com.tencent.vas.update.factory.api.ICommonManager;
import java.io.File;
import mqq.app.MobileQQ;

public class VasCommonManagerImpl
  implements ICommonManager
{
  public long a()
  {
    return 500L;
  }
  
  public String a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uncompressZip: type = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" srcFile = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("VasUpdate_CommonManagerImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 1) {
      return null;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      QLog.e("VasUpdate_CommonManagerImpl", 1, "uncompressZip file un exist");
      return null;
    }
    paramString = new StringBuilder();
    paramString.append(((File)localObject).getParent());
    paramString.append(File.separator);
    paramString = paramString.toString();
    try
    {
      localObject = VasUpdateUtil.a((File)localObject, paramString);
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append((String)localObject);
        paramString = localStringBuilder.toString();
        if (!QLog.isColorLevel()) {
          return paramString;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("uncompressZip result = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("VasUpdate_CommonManagerImpl", 2, ((StringBuilder)localObject).toString());
        return paramString;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("VasUpdate_CommonManagerImpl", 2, "uncompressZip fail");
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("VasUpdate_CommonManagerImpl", 1, "uncompressZip error : ", paramString);
    }
    return null;
    return paramString;
  }
  
  public String a(String paramString)
  {
    return ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).getFileMd5(paramString);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bsPatch: srcFile = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" patchFile = ");
      localStringBuilder.append(paramString2);
      QLog.d("VasUpdate_CommonManagerImpl", 2, localStringBuilder.toString());
    }
    return ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).patch(paramString1, paramString2, paramString1);
  }
  
  public Context b()
  {
    return MobileQQ.getContext();
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {
      try
      {
        boolean bool = FileUtils.copyFile(paramString1, FileUtils.createFile(paramString2));
        return bool;
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return false;
  }
  
  public String c()
  {
    return VasUpdateConstants.a;
  }
  
  public String d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_CommonManagerImpl", 2, "getAppVersion = 8.8.17");
    }
    return "8.8.17";
  }
  
  public String e()
  {
    return "8.8.17.5770";
  }
  
  public int f()
  {
    int i;
    switch ()
    {
    case -1: 
    default: 
      i = 0;
      break;
    case 4: 
      i = 3;
      break;
    case 3: 
      i = 4;
      break;
    case 2: 
      i = 5;
      break;
    case 1: 
    case 5: 
      i = 2;
      break;
    case 0: 
      i = 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNetType netType = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" local = ");
      localStringBuilder.append(HttpUtil.getNetWorkType());
      QLog.d("VasUpdate_CommonManagerImpl", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public long g()
  {
    return NetConnInfoCenter.getServerTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.impl.VasCommonManagerImpl
 * JD-Core Version:    0.7.0.1
 */