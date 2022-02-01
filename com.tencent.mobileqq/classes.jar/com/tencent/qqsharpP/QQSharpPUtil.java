package com.tencent.qqsharpP;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoLoaderService;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class QQSharpPUtil
{
  public static boolean a = false;
  
  public static LoadExtResult a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    LoadExtResult localLoadExtResult = b(paramString);
    long l2 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadAndDownloadSo. soName = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", result = ");
    localStringBuilder.append(localLoadExtResult);
    localStringBuilder.append(", time len = ");
    localStringBuilder.append(l2 - l1);
    localStringBuilder.append(", so path = ");
    if (localLoadExtResult != null) {
      paramString = localLoadExtResult.getSoLoadPath(paramString);
    } else {
      paramString = "null";
    }
    localStringBuilder.append(paramString);
    QLog.i("QQSharpPUtil", 1, localStringBuilder.toString());
    return localLoadExtResult;
  }
  
  public static File a(File paramFile)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
    ((StringBuilder)localObject).append(".shp");
    localObject = new File(((StringBuilder)localObject).toString());
    if (paramFile.exists()) {
      paramFile.renameTo((File)localObject);
    }
    return localObject;
  }
  
  public static boolean a()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.vip_individuation.name());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length >= 2) && (!"0".equals(localObject[1]))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = a();
    if ((!a) && (bool)) {
      a = c();
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isSharpPAvaliable: ");
      paramContext.append(a);
      QLog.d("QQSharpPUtil", 2, paramContext.toString());
    }
    return (a) && (bool);
  }
  
  public static LoadExtResult b(String paramString)
  {
    ISoLoaderService localISoLoaderService = (ISoLoaderService)QRoute.api(ISoLoaderService.class);
    if (localISoLoaderService != null) {
      return localISoLoaderService.loadSync(paramString, null);
    }
    return null;
  }
  
  public static String b(File paramFile)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile.getAbsolutePath());
    localStringBuilder.append(".shp");
    return localStringBuilder.toString();
  }
  
  public static boolean b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.CPU_ABI);
    ((StringBuilder)localObject).append(Build.CPU_ABI2);
    localObject = ((StringBuilder)localObject).toString();
    if (Build.VERSION.SDK_INT < 14) {
      return false;
    }
    return (((String)localObject).contains("armeabi-v7a")) || (((String)localObject).contains("armeabi"));
  }
  
  public static boolean c()
  {
    LoadExtResult localLoadExtResult = a("TcHevcDec");
    return (localLoadExtResult != null) && (localLoadExtResult.isSucc());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqsharpP.QQSharpPUtil
 * JD-Core Version:    0.7.0.1
 */