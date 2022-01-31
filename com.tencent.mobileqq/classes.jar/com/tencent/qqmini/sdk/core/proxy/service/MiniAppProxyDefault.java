package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import beil;
import beru;
import besi;
import besl;
import beyu;
import bffj;
import bffk;
import bffl;
import com.tencent.qqmini.sdk.core.auth.ui.PermissionSettingFragment;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.IChoosePhotoListner;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.SenderListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.ui.MiniTranslucentFragmentActivity;
import com.tencent.qqmini.sdk.ui.MoreFragment;
import com.tencent.qqmini.sdk.ui.MoreItem;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.ArrayList;
import java.util.List;

public class MiniAppProxyDefault
  extends MiniAppProxy
{
  private static final String TAG = "MiniAppProxyDefault";
  
  private void reportClick(besi parambesi, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!parambesi.a().isEngineTypeMiniGame()) {
      return;
    }
    beyu.a(parambesi.a(), beyu.a(parambesi.a()), null, "user_click", "more_button", paramString);
  }
  
  public boolean addPublicAccount(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public boolean addShortcut(Activity paramActivity, MiniAppInfo paramMiniAppInfo, AsyncResult paramAsyncResult)
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
  
  public boolean downloadApp(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
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
  
  public String getAppId()
  {
    return "";
  }
  
  public String getAppName()
  {
    return "sdk";
  }
  
  public String getAppVersion()
  {
    return "8.0.5";
  }
  
  public String getDeviceInfo()
  {
    return "android";
  }
  
  public Drawable getDrawable(Context paramContext, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    return null;
  }
  
  public boolean getLocation(Context paramContext, String paramString, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public byte[] getLoginSig()
  {
    return new byte[0];
  }
  
  public int getLoginType()
  {
    return 0;
  }
  
  public bffl getMoreItemSelectedListener()
  {
    return new DefaultMoreItemSelectedListener();
  }
  
  public ArrayList<MoreItem> getMoreItems(bffj parambffj)
  {
    parambffj.a("QQ", 2130840731).b("QQ空间", 2130840732).c("微信好友", 2130840733).d("微信朋友圈", 2130840734).e("关于", 2130840697).f("举报", 2130840730).g("调试", 2130840697).h("性能", 2130840697);
    return parambffj.a();
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
  
  public String getPlatformVersionString()
  {
    return null;
  }
  
  public String getSoPath()
  {
    return null;
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
  
  public void notifyMiniAppInfo(MiniAppInfo paramMiniAppInfo) {}
  
  public boolean onCapsuleButtonCloseClick(besi parambesi)
  {
    return false;
  }
  
  public boolean onCapsuleButtonMoreClick(besi parambesi)
  {
    besl.a("MiniAppProxyDefault", "onCapsuleButtonMoreClick");
    if (parambesi == null)
    {
      besl.c("MiniAppProxyDefault", "miniRuntime is null, no need to response more button");
      return true;
    }
    Activity localActivity = parambesi.a();
    if ((localActivity == null) || (localActivity.isFinishing()))
    {
      besl.c("MiniAppProxyDefault", "Activity is not exiting, no need to response more button");
      return true;
    }
    MiniAppInfo localMiniAppInfo = parambesi.a();
    if (localMiniAppInfo == null)
    {
      besl.c("MiniAppProxyDefault", "MiniAppInfo is null, no need to response more button");
      return true;
    }
    beru localberu = parambesi.a();
    if (localberu == null)
    {
      besl.c("MiniAppProxyDefault", "ShareState is null, no need to response more button");
      return true;
    }
    Intent localIntent = new Intent();
    Object localObject = new bffk();
    ((bffk)localObject).a = localberu.e;
    ((bffk)localObject).b = localberu.d;
    ((bffk)localObject).c = localberu.f;
    ((bffk)localObject).d = localberu.g;
    ((bffk)localObject).e = localberu.b;
    ((bffk)localObject).f = localberu.c;
    ((bffk)localObject).g = true;
    ((bffk)localObject).h = true;
    localObject = getMoreItems(new bffj().a((bffk)localObject));
    localIntent.putExtra("key_orientation_landscape", localberu.a);
    localIntent.putExtra("key_mini_app_info", localMiniAppInfo);
    localIntent.putParcelableArrayListExtra("key_more_item_list", (ArrayList)localObject);
    beil.a().a(new MiniAppProxyDefault.1(this, parambesi));
    MiniTranslucentFragmentActivity.a(localActivity, localIntent, MoreFragment.class, 9527);
    reportClick(parambesi, "open");
    return true;
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
  
  public boolean openPermissionSettingsActivity(Activity paramActivity, String paramString1, String paramString2)
  {
    PermissionSettingFragment.a(paramActivity, paramString1, paramString2, 5);
    return true;
  }
  
  public boolean openRobotProfileCard(Context paramContext, String paramString1, String paramString2)
  {
    return false;
  }
  
  public boolean openSchema(Activity paramActivity, String paramString, ResultReceiver paramResultReceiver)
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
  
  public boolean startBrowserActivity(Activity paramActivity, Intent paramIntent)
  {
    paramIntent.setAction("android.intent.action.VIEW");
    paramIntent.setData(Uri.parse(paramIntent.getStringExtra("url")));
    paramActivity.startActivity(paramIntent);
    return true;
  }
  
  public boolean startBrowserActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    paramIntent.setAction("android.intent.action.VIEW");
    paramIntent.setData(Uri.parse(paramIntent.getStringExtra("url")));
    paramActivity.startActivityForResult(paramIntent, paramInt);
    return false;
  }
  
  public boolean tianshuReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    return false;
  }
  
  public boolean tianshuRequestAdv(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, AsyncResult paramAsyncResult)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.MiniAppProxyDefault
 * JD-Core Version:    0.7.0.1
 */