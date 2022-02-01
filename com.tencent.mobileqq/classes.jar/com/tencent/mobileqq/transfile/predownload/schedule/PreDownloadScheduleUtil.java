package com.tencent.mobileqq.transfile.predownload.schedule;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class PreDownloadScheduleUtil
{
  private static final String TAG = "PreDownloadScheduleUtil";
  
  static String getNetworkName(BaseQQAppInterface paramBaseQQAppInterface)
  {
    int i = getNetworkType(paramBaseQQAppInterface.getApp());
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return "unknown";
              }
              return "5G";
            }
            return "4G";
          }
          return "3G";
        }
        return "2G";
      }
      return "Wi-Fi";
    }
    return "none";
  }
  
  public static int getNetworkType(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected()))
        {
          int i = paramContext.getType();
          if (QLog.isColorLevel()) {
            QLog.d("NetworkUtil", 2, new Object[] { "getNetworkType type = ", Integer.valueOf(i) });
          }
          return getNetworkTypeInner(paramContext, i);
        }
        if (paramContext == null)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("NetworkUtil", 2, "getNetworkType networkInfo = null");
            return 0;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("NetworkUtil", 2, new Object[] { "getNetworkType networkInfo isConnected =", Boolean.valueOf(paramContext.isConnected()) });
          return 0;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("NetworkUtil", 2, "getNetworkType could not get ConnectivityManager");
        return 0;
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("NetworkUtil", 2, "getNetworkType exception", paramContext);
        return 0;
      }
    }
    catch (IllegalStateException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NetworkUtil", 2, "getNetworkType IllegalStateException", paramContext);
      }
    }
    return 0;
  }
  
  private static int getNetworkTypeInner(NetworkInfo paramNetworkInfo, int paramInt)
  {
    if (paramInt != 0)
    {
      int i = 1;
      if (paramInt != 1) {
        i = -1;
      }
      return i;
    }
    return getSubType(paramNetworkInfo.getSubtype());
  }
  
  public static String getPreDownloadPathStatic(@NonNull String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduleUtil", 1, "department should not be empty");
      }
      return null;
    }
    Object localObject2;
    if (paramBoolean)
    {
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
        ((StringBuilder)localObject1).append("/tencent/MobileQQ/pddata/");
        localObject1 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PreDownloadScheduleUtil", 1, "Exception:", localException);
        }
        localObject2 = VFSAssistantUtils.getSDKPrivatePath("/sdcard/tencent/MobileQQ/pddata/");
      }
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(MobileQQ.sMobileQQ.getFilesDir());
      ((StringBuilder)localObject2).append("/pddata/");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    Object localObject3 = new File((String)localObject2);
    if (!((File)localObject3).exists()) {
      ((File)localObject3).mkdirs();
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(paramString2);
    ((StringBuilder)localObject3).append("/");
    ((StringBuilder)localObject3).append(paramString1);
    paramString1 = ((StringBuilder)localObject3).toString();
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("[getPreDownloadPath] path = ");
      paramString2.append(paramString1);
      QLog.e("PreDownloadScheduleUtil", 1, paramString2.toString());
    }
    return paramString1;
  }
  
  private static int getSubType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("NetworkUtil", 2, new Object[] { "getNetworkType subType = ", Integer.valueOf(paramInt) });
      }
      break;
    case 13: 
    case 18: 
    case 19: 
      return 4;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
    case 17: 
      return 3;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
    case 16: 
      return 2;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduleUtil
 * JD-Core Version:    0.7.0.1
 */