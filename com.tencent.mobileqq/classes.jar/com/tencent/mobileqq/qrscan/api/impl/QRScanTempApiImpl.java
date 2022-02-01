package com.tencent.mobileqq.qrscan.api.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.subscript.SubscriptUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.qrscan.ARLauncher;
import com.tencent.mobileqq.qrscan.api.IQRScanTempApi;
import com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.sharpP.SharpPUtils;
import mqq.app.AppRuntime;

public class QRScanTempApiImpl
  implements IQRScanTempApi
{
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
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ContactUtils.e((QQAppInterface)paramAppRuntime, paramAppRuntime.getCurrentAccountUin());
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
    return ScanEntranceDPC.a().f;
  }
  
  public boolean isMiniCodeDetectSwitchOn()
  {
    return ScanEntranceDPC.a().g;
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
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).isRingEqualsZero();
    }
    return false;
  }
  
  public boolean isRingerSilent(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).isRingerSilent();
    }
    return false;
  }
  
  public boolean isRingerVibrate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).isRingerVibrate();
    }
    return false;
  }
  
  public boolean isVideoChatting(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).isVideoChatting();
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
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)localAppRuntime).setTalkbackSwitch();
    }
  }
  
  public void speak(String paramString)
  {
    QQAppInterface.speak(paramString);
  }
  
  public void startActivity(Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AddFriendActivity.a(paramContext, paramBoolean1, paramString, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.impl.QRScanTempApiImpl
 * JD-Core Version:    0.7.0.1
 */