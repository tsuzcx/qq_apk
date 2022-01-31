package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import bdcz;
import bdel;
import bdfr;
import bdgb;
import bdhg;
import bdnw;
import bdzf;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.IChoosePhotoListner;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.SenderListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.ui.MiniTranslucentFragmentActivity;
import com.tencent.qqmini.sdk.ui.MoreFragment;
import java.util.List;

public class MiniAppProxyDefault
  extends MiniAppProxy
{
  private static final String TAG = "MiniAppProxyDefault";
  private static boolean isOpenMonitor;
  
  private void showMoreFragment(bdcz parambdcz, Activity paramActivity, Intent paramIntent)
  {
    MiniTranslucentFragmentActivity.a(paramActivity, paramIntent, MoreFragment.class, 9527);
    paramActivity.overridePendingTransition(0, 0);
    bdel.a().a(new MiniAppProxyDefault.1(this, parambdcz));
  }
  
  public boolean addPublicAccount(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public boolean callServer(String paramString1, String paramString2, Bundle paramBundle)
  {
    return false;
  }
  
  public boolean chooseLocation(Context paramContext, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public boolean enterQRCode(Context paramContext, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public String getAccount()
  {
    return "10000";
  }
  
  public String getAppName()
  {
    return "sdk";
  }
  
  public String getAppVersion()
  {
    return "8.0.5";
  }
  
  public Class getBrowserClass()
  {
    return null;
  }
  
  public String getDeviceInfo()
  {
    return "android";
  }
  
  public Drawable getDrawable(Context paramContext, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    return null;
  }
  
  public boolean getEnableDebug(String paramString)
  {
    return bdzf.a().getBoolean(paramString + "_debug", false);
  }
  
  public boolean getLocation(String paramString, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public byte[] getLoginSig()
  {
    return new byte[0];
  }
  
  public int getLoginType()
  {
    return 3;
  }
  
  public String getNickName()
  {
    return null;
  }
  
  public String getPayOpenId()
  {
    return "123";
  }
  
  public String getPayOpenKey()
  {
    return "ABC";
  }
  
  public String getPlatformId()
  {
    return "16";
  }
  
  public String getPlatformQUA()
  {
    return "";
  }
  
  public boolean isDebugVersion()
  {
    return false;
  }
  
  public boolean jump2PublicAccount(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    switch (paramInt)
    {
    default: 
      if (paramThrowable == null)
      {
        Log.v(paramString1, paramString2);
        return;
      }
      break;
    case 2: 
      if (paramThrowable == null)
      {
        Log.d(paramString1, paramString2);
        return;
      }
      Log.d(paramString1, paramString2, paramThrowable);
      return;
    case 3: 
      if (paramThrowable == null)
      {
        Log.i(paramString1, paramString2);
        return;
      }
      Log.i(paramString1, paramString2, paramThrowable);
      return;
    case 4: 
      if (paramThrowable == null)
      {
        Log.w(paramString1, paramString2);
        return;
      }
      Log.w(paramString1, paramString2, paramThrowable);
      return;
    case 5: 
      if (paramThrowable == null)
      {
        Log.e(paramString1, paramString2);
        return;
      }
      Log.e(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.v(paramString1, paramString2, paramThrowable);
  }
  
  public void onCapsuleButtonMoreClick(bdcz parambdcz)
  {
    bdnw.a("MiniAppProxyDefault", "onCapsuleButtonMoreClick");
    Activity localActivity = parambdcz.a();
    if ((localActivity == null) || (localActivity.isFinishing()))
    {
      bdnw.c("MiniAppProxyDefault", "Activity is not exiting, no need to response more button");
      return;
    }
    MiniAppInfo localMiniAppInfo = parambdcz.a();
    if (localMiniAppInfo == null)
    {
      bdnw.c("MiniAppProxyDefault", "MiniAppInfo is null, no need to response more button");
      return;
    }
    bdgb localbdgb = (bdgb)parambdcz.a(bdfr.a());
    if (localMiniAppInfo.verType != 3)
    {
      localbdgb.b = true;
      localbdgb.c = true;
    }
    if (bdhg.a("MiniApp", "mini_app_share_to_wx_switcher", 1) != 1)
    {
      localbdgb.f = false;
      localbdgb.g = false;
    }
    localbdgb.a = parambdcz.f();
    Intent localIntent = new Intent();
    localIntent.putExtra("miniAppID", localMiniAppInfo.appId);
    localIntent.putExtra("miniAppName", localMiniAppInfo.name);
    localIntent.putExtra("isOpenMonitorPanel", isOpenMonitor);
    localIntent.putExtra("debugEnable", getEnableDebug(localMiniAppInfo.appId));
    localIntent.putExtra("showDebug", localbdgb.b);
    localIntent.putExtra("showMonitor", localbdgb.c);
    localIntent.putExtra("menuStyle", MiniAppEnv.g().getMenuStyle());
    localIntent.putExtra("showShareQQ", localbdgb.e);
    localIntent.putExtra("showShareQzone", localbdgb.d);
    localIntent.putExtra("showShareWeChatFriends", localbdgb.f);
    localIntent.putExtra("showShareWeChatMoment", localbdgb.g);
    localIntent.putExtra("showDetail", true);
    localIntent.putExtra("showComplaint", true);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("addShortcut", bool);
      localIntent.putExtra("showBackHome", -1);
      localIntent.putExtra("isLandscape", localbdgb.a);
      localIntent.putExtra("isSpecialMiniApp", false);
      localIntent.putExtra("key_mini_app_version_type", 1);
      localIntent.putExtra("key_mini_app_info", localMiniAppInfo);
      localIntent.putExtra("key_mini_app_is_game", true);
      showMoreFragment(parambdcz, localActivity, localIntent);
      return;
    }
  }
  
  public boolean openAppDetailPage(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public boolean openChoosePhotoActivity(Activity paramActivity, int paramInt, MiniAppProxy.IChoosePhotoListner paramIChoosePhotoListner)
  {
    return false;
  }
  
  public boolean openImagePreview(Activity paramActivity, int paramInt, List<String> paramList)
  {
    return false;
  }
  
  public boolean openLocation(Context paramContext, double paramDouble1, double paramDouble2, int paramInt, String paramString1, String paramString2)
  {
    return false;
  }
  
  public boolean openRobotProfileCard(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public void sendData(byte[] paramArrayOfByte, MiniAppProxy.SenderListener paramSenderListener)
  {
    FakeServer.sendData(paramArrayOfByte, paramSenderListener);
  }
  
  public boolean startAddFriendActivity(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.MiniAppProxyDefault
 * JD-Core Version:    0.7.0.1
 */