package com.tencent.mobileqq.qrscan.api.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.pubaccount.subscript.SubscriptUtil;
import com.tencent.biz.qrcode.processor.ScanQQAppInterfaceProcessor;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qrscan.ARLauncher;
import com.tencent.mobileqq.qrscan.IQQAppInterfaceProcessor;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy;
import com.tencent.sharpP.SharpPUtils;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QRScanAbilityApiImpl
  implements IQRScanAbilityApi
{
  private static ArrayList<IQQAppInterfaceProcessor> sAppProcessorList;
  @ConfigInject(configPath="Business/qqqrscan-impl/src/main/resources/Inject_QRQQAppInterfaceProcessor.yml", version=1)
  private static ArrayList<Class<? extends IQQAppInterfaceProcessor>> sInjectProcessorClasses = new ArrayList();
  
  static
  {
    sInjectProcessorClasses.add(ScanQQAppInterfaceProcessor.class);
    sAppProcessorList = new ArrayList();
    Iterator localIterator = sInjectProcessorClasses.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Class)localIterator.next();
      try
      {
        localObject = (IQQAppInterfaceProcessor)((Class)localObject).newInstance();
        sAppProcessorList.add(localObject);
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  private static boolean isNoHistoryActivity(Context paramContext)
  {
    try
    {
      if (Class.forName("com.tencent.mobileqq.activity.SplashActivity").isInstance(paramContext)) {
        return true;
      }
      boolean bool = Class.forName("com.tencent.mobileqq.activity.ChatActivity").isInstance(paramContext);
      if (bool) {
        return true;
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public Bitmap decodeSharpP(String paramString)
  {
    return SharpPUtils.decodeSharpP(paramString);
  }
  
  public int getEarlyDownBusId(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 101) {
              return 0;
            }
            return 10040;
          }
          return 10090;
        }
        return 10085;
      }
      return 10084;
    }
    return 10083;
  }
  
  public String getFriendDisplayNameJustCache(AppRuntime paramAppRuntime, String paramString)
  {
    Iterator localIterator = sAppProcessorList.iterator();
    if (localIterator.hasNext()) {
      return ((IQQAppInterfaceProcessor)localIterator.next()).a(paramAppRuntime, paramString);
    }
    return paramString;
  }
  
  public int getQmcfGpuSupportType()
  {
    return QmcfDevicesStrategy.a();
  }
  
  public int getQmcfGpuSupportTypeWithoutGPURule()
  {
    return QmcfDevicesStrategy.b();
  }
  
  public String getUin(String paramString)
  {
    return SubscriptUtil.a(paramString);
  }
  
  public boolean isMiniCodeDecodeSwitchOn()
  {
    return ScanEntranceDPC.a().j;
  }
  
  public boolean isMiniCodeDetectSwitchOn()
  {
    return ScanEntranceDPC.a().k;
  }
  
  public boolean isQmcfSupport(int paramInt)
  {
    return paramInt > 0;
  }
  
  public boolean isQmcfSupportGLElseCL(int paramInt)
  {
    return paramInt == 4;
  }
  
  public boolean isRingEqualsZero(AppRuntime paramAppRuntime)
  {
    Iterator localIterator = sAppProcessorList.iterator();
    if (localIterator.hasNext()) {
      return ((IQQAppInterfaceProcessor)localIterator.next()).e(paramAppRuntime);
    }
    return false;
  }
  
  public boolean isRingerSilent(AppRuntime paramAppRuntime)
  {
    Iterator localIterator = sAppProcessorList.iterator();
    if (localIterator.hasNext()) {
      return ((IQQAppInterfaceProcessor)localIterator.next()).d(paramAppRuntime);
    }
    return false;
  }
  
  public boolean isRingerVibrate(AppRuntime paramAppRuntime)
  {
    Iterator localIterator = sAppProcessorList.iterator();
    if (localIterator.hasNext()) {
      return ((IQQAppInterfaceProcessor)localIterator.next()).c(paramAppRuntime);
    }
    return false;
  }
  
  public boolean isVideoChatting(AppRuntime paramAppRuntime)
  {
    Iterator localIterator = sAppProcessorList.iterator();
    if (localIterator.hasNext()) {
      return ((IQQAppInterfaceProcessor)localIterator.next()).b(paramAppRuntime);
    }
    return false;
  }
  
  public void launchAR(Activity paramActivity, AppRuntime paramAppRuntime, String paramString, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    new ARLauncher(paramActivity, paramAppRuntime, paramString, paramLong1, paramBoolean1, paramBoolean2, paramLong2).a();
  }
  
  public void reportQBarSoLoadFail(boolean paramBoolean)
  {
    ScanEntranceReport.a().a(paramBoolean);
  }
  
  public void setTalkbackSwitch()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Iterator localIterator = sAppProcessorList.iterator();
    while (localIterator.hasNext()) {
      ((IQQAppInterfaceProcessor)localIterator.next()).a(localAppRuntime);
    }
  }
  
  public void speak(String paramString)
  {
    Iterator localIterator = sAppProcessorList.iterator();
    while (localIterator.hasNext()) {
      ((IQQAppInterfaceProcessor)localIterator.next()).a(paramString);
    }
  }
  
  public void startActivity(Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramContext, "/base/activity/AddFriendActivity");
    localActivityURIRequest.extra().putBoolean("btroop", paramBoolean1);
    localActivityURIRequest.extra().putBoolean("performAutoAction", paramBoolean2);
    if (isNoHistoryActivity(paramContext))
    {
      localActivityURIRequest.setFlags(1073741824);
      localActivityURIRequest.extra().putBoolean("needFinish", true);
    }
    if (paramString != null) {
      if (paramBoolean1) {
        localActivityURIRequest.extra().putString("troopuin", paramString);
      } else {
        localActivityURIRequest.extra().putString("uin", paramString);
      }
    }
    QRoute.startUri(localActivityURIRequest, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.impl.QRScanAbilityApiImpl
 * JD-Core Version:    0.7.0.1
 */