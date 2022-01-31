package com.tencent.qqmini.sdk.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.ResultReceiver;
import besi;
import bffj;
import bffl;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.ui.MoreItem;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.List;

public abstract class MiniAppProxy
{
  public abstract boolean addPublicAccount(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract boolean addShortcut(Activity paramActivity, MiniAppInfo paramMiniAppInfo, AsyncResult paramAsyncResult);
  
  public abstract boolean callServer(String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract boolean chooseLocation(Context paramContext, AsyncResult paramAsyncResult);
  
  public abstract boolean downloadApp(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract boolean enterQRCode(Context paramContext, boolean paramBoolean, AsyncResult paramAsyncResult);
  
  public abstract String getAccount();
  
  public abstract String getAppId();
  
  public abstract String getAppName();
  
  public abstract String getAppVersion();
  
  public abstract String getDeviceInfo();
  
  public abstract Drawable getDrawable(Context paramContext, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable);
  
  public abstract boolean getLocation(Context paramContext, String paramString, boolean paramBoolean, AsyncResult paramAsyncResult);
  
  public abstract byte[] getLoginSig();
  
  public abstract int getLoginType();
  
  public abstract bffl getMoreItemSelectedListener();
  
  public abstract List<MoreItem> getMoreItems(bffj parambffj);
  
  public abstract String getNickName();
  
  public abstract String getPayOpenId();
  
  public abstract String getPayOpenKey();
  
  public abstract String getPlatformId();
  
  public abstract String getPlatformQUA();
  
  public abstract String getPlatformVersionString();
  
  public abstract String getSoPath();
  
  public abstract boolean isDebugVersion();
  
  public abstract boolean jump2PublicAccount(Context paramContext, String paramString1, String paramString2);
  
  public abstract void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void notifyMiniAppInfo(MiniAppInfo paramMiniAppInfo);
  
  public abstract boolean onCapsuleButtonCloseClick(besi parambesi);
  
  public abstract boolean onCapsuleButtonMoreClick(besi parambesi);
  
  public abstract boolean openChoosePhotoActivity(Activity paramActivity, int paramInt, MiniAppProxy.IChoosePhotoListner paramIChoosePhotoListner);
  
  public abstract boolean openImagePreview(Activity paramActivity, int paramInt, List<String> paramList);
  
  public abstract boolean openLocation(Context paramContext, double paramDouble1, double paramDouble2, int paramInt, String paramString1, String paramString2);
  
  public abstract boolean openPermissionSettingsActivity(Activity paramActivity, String paramString1, String paramString2);
  
  public abstract boolean openRobotProfileCard(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean openSchema(Activity paramActivity, String paramString, ResultReceiver paramResultReceiver);
  
  public abstract void sendData(byte[] paramArrayOfByte, MiniAppProxy.SenderListener paramSenderListener);
  
  public abstract boolean startAddFriendActivity(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean startBrowserActivity(Activity paramActivity, Intent paramIntent);
  
  public abstract boolean startBrowserActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract boolean tianshuReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt);
  
  public abstract boolean tianshuRequestAdv(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, AsyncResult paramAsyncResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.MiniAppProxy
 * JD-Core Version:    0.7.0.1
 */