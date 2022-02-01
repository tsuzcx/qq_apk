package com.tencent.mobileqq.miniapp;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qg.qq.QGameApp;
import com.tencent.qphone.base.util.QLog;

public class MiniAppLauncher
{
  private boolean b(IApp paramIApp, MiniAppOptions paramMiniAppOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "checkMemory. cacheKey=", paramIApp.b.p });
    }
    return true;
  }
  
  IApp a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "createApp type=", Integer.valueOf(paramInt) });
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt != 0)
    {
      localObject1 = localObject2;
      if (paramInt != 1)
      {
        localObject1 = localObject2;
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if ((paramInt != 4) && (paramInt != 5)) {
              QLog.e("MiniAppLauncher", 1, "createApp error. unknown appType");
            }
            return null;
          }
          localObject1 = new QGameApp(paramMiniAppActivity, paramString, paramInt);
        }
      }
    }
    return localObject1;
  }
  
  void a(IApp paramIApp, MiniAppOptions paramMiniAppOptions)
  {
    if (!b(paramIApp, paramMiniAppOptions)) {
      return;
    }
    DeviceInfoUtil.A();
    paramIApp.a();
  }
  
  void a(MiniAppInfo paramMiniAppInfo, @NonNull IDownloader paramIDownloader)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "downloadApp. cacheKey=", paramMiniAppInfo.p });
    }
    paramIDownloader.a(paramMiniAppInfo.j, "MiniAppLauncher", paramMiniAppInfo.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppLauncher
 * JD-Core Version:    0.7.0.1
 */