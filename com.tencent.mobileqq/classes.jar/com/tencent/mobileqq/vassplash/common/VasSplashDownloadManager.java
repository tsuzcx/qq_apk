package com.tencent.mobileqq.vassplash.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.vassplash.model.SplashItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class VasSplashDownloadManager
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[download]:");
          ((StringBuilder)localObject).append(paramString3);
          ((StringBuilder)localObject).append(",url:");
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append(",id:");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(",type:");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("splash.tag.QSplash@VasSplashDownloadManager", 2, ((StringBuilder)localObject).toString());
          IPreDownloadController localIPreDownloadController = (IPreDownloadController)paramQQAppInterface.getRuntimeService(IPreDownloadController.class);
          boolean bool = localIPreDownloadController.isEnable();
          if (bool)
          {
            if (paramInt != 2) {
              break label251;
            }
            localObject = "vas_splash_ad_res_video";
            i = 10082;
            j = 1;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("downloadPicAGifAVideoRes request adid");
            localStringBuilder.append(paramString1);
            QLog.i("QSplash@VasSplashUtil", 1, localStringBuilder.toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString3);
            localStringBuilder.append(".splashtemp");
            localIPreDownloadController.requestPreDownload(i, "vas", paramString2, 0, paramString2, localStringBuilder.toString(), j, 0, true, new VasSplashDownloadManager.1(paramQQAppInterface, (String)localObject, paramString1, paramString3, paramInt, paramString4, paramString2));
            return;
          }
          QLog.i("QSplash@VasSplashUtil", 1, "ctrl.isEnable() = false");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      continue;
      label251:
      Object localObject = "vas_splash_ad_res_png";
      int i = 10081;
      int j = 2;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Collection<SplashItem> paramCollection)
  {
    try
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        SplashItem localSplashItem = (SplashItem)paramCollection.next();
        if (!localSplashItem.b())
        {
          QLog.i("splash.tag.QSplash@VasSplashDownloadManager", 1, "adEntry should not requestRes");
        }
        else
        {
          int i = localSplashItem.e;
          if (i != 0)
          {
            if (i != 1)
            {
              if (i == 2) {
                a(paramQQAppInterface, localSplashItem.b, localSplashItem.f, localSplashItem.k, 2, localSplashItem.o);
              }
            }
            else {
              a(paramQQAppInterface, localSplashItem.b, localSplashItem.f, localSplashItem.k, 1, localSplashItem.o);
            }
          }
          else {
            a(paramQQAppInterface, localSplashItem.b, localSplashItem.f, localSplashItem.k, 0, localSplashItem.o);
          }
          if ((localSplashItem.w == 2) || (localSplashItem.w == 1)) {
            a(paramQQAppInterface, localSplashItem.b, localSplashItem.x, localSplashItem.y, 0, localSplashItem.o);
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject = VasSplashUtil.a(BaseApplicationImpl.getContext(), paramString1);
    paramString1 = ((SharedPreferences)localObject).edit();
    QLog.i("splash.tag.QSplash@VasSplashDownloadManager", 1, "pic or gif download succ! MD5 checkok");
    boolean bool = ((SharedPreferences)localObject).getBoolean("vas_exposure_is_low_device_limit_", false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isLowerDeviceLimit = ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("splash.tag.QSplash@VasSplashDownloadManager", 1, ((StringBuilder)localObject).toString());
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("vas_splash_ad_is_limited_");
      ((StringBuilder)localObject).append(paramString2);
      paramString1.putBoolean(((StringBuilder)localObject).toString(), true);
      localObject = VasSplashUtil.e;
      if ((localObject != null) && (((HashMap)localObject).containsKey(paramString2))) {
        ((SplashItem)((HashMap)localObject).get(paramString2)).r = true;
      }
    }
    paramString1.apply();
  }
  
  private static void b(String paramString1, AppInterface paramAppInterface, String paramString2)
  {
    if (paramAppInterface == null) {
      return;
    }
    try
    {
      paramAppInterface = (IPreDownloadController)paramAppInterface.getRuntimeService(IPreDownloadController.class, "");
      if (paramAppInterface.isEnable()) {
        paramAppInterface.preDownloadSuccess(paramString1, -1L);
      }
      return;
    }
    catch (Exception paramString1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vassplash.common.VasSplashDownloadManager
 * JD-Core Version:    0.7.0.1
 */