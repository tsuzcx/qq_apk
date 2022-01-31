package com.tencent.qqmini.sdk.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import bdcz;
import bddc;
import bdsx;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;

public abstract class MiniAppProxy
{
  public abstract boolean addPublicAccount(String paramString1, String paramString2, AsyncResult paramAsyncResult);
  
  public abstract boolean callServer(String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract boolean chooseLocation(Context paramContext, AsyncResult paramAsyncResult);
  
  public abstract boolean enterQRCode(Context paramContext, boolean paramBoolean, AsyncResult paramAsyncResult);
  
  public abstract String getAccount();
  
  public abstract String getAppName();
  
  public abstract String getAppVersion();
  
  public abstract Class getBrowserClass();
  
  public abstract String getDeviceInfo();
  
  public abstract Drawable getDrawable(Context paramContext, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable);
  
  public abstract boolean getLocation(String paramString, boolean paramBoolean, AsyncResult paramAsyncResult);
  
  public abstract byte[] getLoginSig();
  
  public abstract int getLoginType();
  
  public abstract String getNickName();
  
  public abstract String getPayOpenId();
  
  public abstract String getPayOpenKey();
  
  public abstract String getPlatformId();
  
  public abstract String getPlatformQUA();
  
  public abstract boolean isDebugVersion();
  
  public abstract boolean jump2PublicAccount(Context paramContext, String paramString1, String paramString2);
  
  public abstract void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void onCapsuleButtonMoreClick(bdcz parambdcz);
  
  public abstract boolean openAppDetailPage(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean openChoosePhotoActivity(Activity paramActivity, int paramInt, MiniAppProxy.IChoosePhotoListner paramIChoosePhotoListner);
  
  public abstract boolean openImagePreview(Activity paramActivity, int paramInt, List<String> paramList);
  
  public abstract boolean openLocation(Context paramContext, double paramDouble1, double paramDouble2, int paramInt, String paramString1, String paramString2);
  
  public abstract boolean openRobotProfileCard(Context paramContext, String paramString1, String paramString2);
  
  public void reportApiInvoke(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if ((bddc.a != null) && (bddc.a.contains(paramString))) {
      bdsx.a(paramMiniAppInfo, paramString);
    }
  }
  
  public abstract void sendData(byte[] paramArrayOfByte, MiniAppProxy.SenderListener paramSenderListener);
  
  public abstract boolean startAddFriendActivity(Context paramContext, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.MiniAppProxy
 * JD-Core Version:    0.7.0.1
 */