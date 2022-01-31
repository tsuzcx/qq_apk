package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import agwj;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public final class a
  implements Serializable
{
  private transient String a;
  private transient byte[] b;
  private Map c = new HashMap();
  private Map d = new HashMap();
  
  public static a a(QQAppInterface paramQQAppInterface)
  {
    String str = a(paramQQAppInterface);
    try
    {
      paramQQAppInterface = (a)agwj.a(str);
      Object localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject = new a();
      }
      ((a)localObject).a = str;
      ((a)localObject).b = new byte[0];
      if (((a)localObject).d == null) {
        ((a)localObject).d = new HashMap();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApkgConfigHolder", 2, "readApkgConfigHolder:" + localObject);
      }
      return localObject;
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
        paramQQAppInterface = null;
      }
    }
  }
  
  private static String a(AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramAppRuntime.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/miniapp/").append(paramAppRuntime.getAccount()).append("/");
    localStringBuilder.append(".ApkgConfigs");
    return localStringBuilder.toString();
  }
  
  public static void a(ApkgConfig paramApkgConfig)
  {
    if (paramApkgConfig != null)
    {
      PreloadManager.a(paramApkgConfig.apkg_url, false, 0);
      if (paramApkgConfig.sub_apkg_urls != null)
      {
        Iterator localIterator = paramApkgConfig.sub_apkg_urls.values().iterator();
        while (localIterator.hasNext()) {
          PreloadManager.a((String)localIterator.next(), false, 0);
        }
      }
      com.tencent.mobileqq.microapp.b.a.a(g.a(paramApkgConfig), false);
    }
  }
  
  public void a()
  {
    ThreadManager.getFileThreadHandler().post(new b(this));
  }
  
  public void a(LaunchParam paramLaunchParam)
  {
    if (paramLaunchParam == null) {
      return;
    }
    int j = 0;
    int i = j;
    ApkgConfig localApkgConfig;
    if (!TextUtils.isEmpty(paramLaunchParam.extraKey))
    {
      i = j;
      if (paramLaunchParam.scene == 1207)
      {
        localIterator = this.d.entrySet().iterator();
        do
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
          localApkgConfig = ((a.a)((Map.Entry)localIterator.next()).getValue()).a;
        } while (!paramLaunchParam.extraKey.equals(localApkgConfig.qq_qr_code));
        localIterator.remove();
        i = 1;
      }
    }
    j = i;
    if (i == 0) {
      switch (paramLaunchParam.scene)
      {
      default: 
        this.c.remove(paramLaunchParam.miniAppId);
        j = i;
      }
    }
    do
    {
      if (j == 0) {
        break;
      }
      a();
      return;
      j = i;
    } while (TextUtils.isEmpty(paramLaunchParam.extraKey));
    Iterator localIterator = this.c.entrySet().iterator();
    label193:
    if (localIterator.hasNext())
    {
      localApkgConfig = ((a.a)((Map.Entry)localIterator.next()).getValue()).a;
      if ((paramLaunchParam.scene == 1207) && (paramLaunchParam.extraKey.equals(localApkgConfig.qq_qr_code)))
      {
        localIterator.remove();
        i = 1;
      }
    }
    for (;;)
    {
      j = i;
      break;
      if ((paramLaunchParam.scene != 1208) || (!paramLaunchParam.extraKey.equals(localApkgConfig.wx_qr_code))) {
        break label193;
      }
      localIterator.remove();
      i = 1;
    }
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ApkgConfig localApkgConfig = (ApkgConfig)localIterator.next();
        if ((localApkgConfig != null) && (!TextUtils.isEmpty(localApkgConfig.mini_appid))) {
          if (localApkgConfig.getRuntimeType() == 1)
          {
            paramList = (a.a)this.d.get(localApkgConfig.mini_appid);
            if ((paramList != null) && (!paramList.a.qq_qr_code.equals(localApkgConfig.qq_qr_code))) {
              a(paramList.a);
            }
            this.d.put(localApkgConfig.mini_appid, new a.a(localApkgConfig));
          }
          else
          {
            a.a locala = (a.a)this.c.get(localApkgConfig.mini_appid);
            paramList = locala;
            if (locala == null)
            {
              paramList = new a.a();
              this.c.put(localApkgConfig.mini_appid, new a.a(localApkgConfig));
            }
            paramList.a(localApkgConfig);
          }
        }
      }
      a();
    }
  }
  
  public ApkgConfig b(LaunchParam paramLaunchParam)
  {
    label4:
    Iterator localIterator;
    ApkgConfig localApkgConfig;
    if (paramLaunchParam == null)
    {
      break label165;
      return null;
    }
    else
    {
      if ((!TextUtils.isEmpty(paramLaunchParam.extraKey)) && (paramLaunchParam.scene == 1207))
      {
        localIterator = this.d.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localApkgConfig = ((a.a)((Map.Entry)localIterator.next()).getValue()).a;
          if (paramLaunchParam.extraKey.equals(localApkgConfig.qq_qr_code)) {
            return localApkgConfig;
          }
        }
      }
      switch (paramLaunchParam.scene)
      {
      default: 
        paramLaunchParam = (a.a)this.c.get(paramLaunchParam.miniAppId);
        if (paramLaunchParam == null) {
          break;
        }
      }
    }
    for (paramLaunchParam = paramLaunchParam.a;; paramLaunchParam = null)
    {
      return paramLaunchParam;
      if (TextUtils.isEmpty(paramLaunchParam.extraKey)) {
        break label4;
      }
      localIterator = this.c.entrySet().iterator();
      label165:
      if (!localIterator.hasNext()) {
        break label4;
      }
      localApkgConfig = ((a.a)((Map.Entry)localIterator.next()).getValue()).a;
      if ((paramLaunchParam.scene == 1207) && (paramLaunchParam.extraKey.equals(localApkgConfig.qq_qr_code))) {
        return localApkgConfig;
      }
      if ((paramLaunchParam.scene != 1208) || (!paramLaunchParam.extraKey.equals(localApkgConfig.wx_qr_code))) {
        break;
      }
      return localApkgConfig;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.a
 * JD-Core Version:    0.7.0.1
 */