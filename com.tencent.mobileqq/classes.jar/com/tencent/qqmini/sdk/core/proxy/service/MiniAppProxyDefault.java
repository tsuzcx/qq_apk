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
import bejc;
import besl;
import besz;
import betc;
import bezl;
import bfga;
import bfgb;
import bfgc;
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
  
  private void reportClick(besz parambesz, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!parambesz.a().isEngineTypeMiniGame()) {
      return;
    }
    bezl.a(parambesz.a(), bezl.a(parambesz.a()), null, "user_click", "more_button", paramString);
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
  
  public bfgc getMoreItemSelectedListener()
  {
    return new DefaultMoreItemSelectedListener();
  }
  
  public ArrayList<MoreItem> getMoreItems(bfga parambfga)
  {
    parambfga.a("QQ", 2130840728).b("QQ空间", 2130840729).c("微信好友", 2130840730).d("微信朋友圈", 2130840731).e("关于", 2130840694).f("举报", 2130840727).g("调试", 2130840694).h("性能", 2130840694);
    return parambfga.a();
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
  
  public boolean onCapsuleButtonCloseClick(besz parambesz)
  {
    return false;
  }
  
  public boolean onCapsuleButtonMoreClick(besz parambesz)
  {
    betc.a("MiniAppProxyDefault", "onCapsuleButtonMoreClick");
    if (parambesz == null)
    {
      betc.c("MiniAppProxyDefault", "miniRuntime is null, no need to response more button");
      return true;
    }
    Activity localActivity = parambesz.a();
    if ((localActivity == null) || (localActivity.isFinishing()))
    {
      betc.c("MiniAppProxyDefault", "Activity is not exiting, no need to response more button");
      return true;
    }
    MiniAppInfo localMiniAppInfo = parambesz.a();
    if (localMiniAppInfo == null)
    {
      betc.c("MiniAppProxyDefault", "MiniAppInfo is null, no need to response more button");
      return true;
    }
    besl localbesl = parambesz.a();
    if (localbesl == null)
    {
      betc.c("MiniAppProxyDefault", "ShareState is null, no need to response more button");
      return true;
    }
    Intent localIntent = new Intent();
    Object localObject = new bfgb();
    ((bfgb)localObject).a = localbesl.e;
    ((bfgb)localObject).b = localbesl.d;
    ((bfgb)localObject).c = localbesl.f;
    ((bfgb)localObject).d = localbesl.g;
    ((bfgb)localObject).e = localbesl.b;
    ((bfgb)localObject).f = localbesl.c;
    ((bfgb)localObject).g = true;
    ((bfgb)localObject).h = true;
    localObject = getMoreItems(new bfga().a((bfgb)localObject));
    localIntent.putExtra("key_orientation_landscape", localbesl.a);
    localIntent.putExtra("key_mini_app_info", localMiniAppInfo);
    localIntent.putParcelableArrayListExtra("key_more_item_list", (ArrayList)localObject);
    bejc.a().a(new MiniAppProxyDefault.1(this, parambesz));
    MiniTranslucentFragmentActivity.a(localActivity, localIntent, MoreFragment.class, 9527);
    reportClick(parambesz, "open");
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