package com.tencent.mobileqq.miniapp;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qg.qq.QGameApp;
import com.tencent.qphone.base.util.QLog;

public class MiniAppLauncher
{
  private boolean a(IApp paramIApp, MiniAppOptions paramMiniAppOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "checkMemory. cacheKey=", paramIApp.a.h });
    }
    return true;
  }
  
  IApp a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "createApp type=", Integer.valueOf(paramInt) });
    }
    switch (paramInt)
    {
    default: 
      QLog.e("MiniAppLauncher", 1, "createApp error. unknown appType");
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 5: 
      return null;
    }
    return new QGameApp(paramMiniAppActivity, paramString, paramInt);
  }
  
  void a(IApp paramIApp, MiniAppOptions paramMiniAppOptions)
  {
    if (!a(paramIApp, paramMiniAppOptions)) {
      return;
    }
    DeviceInfoUtil.a();
    paramIApp.a();
  }
  
  void a(MiniAppInfo paramMiniAppInfo, @NonNull IDownloader paramIDownloader)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher", 2, new Object[] { "downloadApp. cacheKey=", paramMiniAppInfo.h });
    }
    paramIDownloader.a(paramMiniAppInfo.f, "MiniAppLauncher", paramMiniAppInfo.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppLauncher
 * JD-Core Version:    0.7.0.1
 */