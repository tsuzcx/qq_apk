package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.AppState;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import com.tencent.qqmini.sdk.launcher.ui.MoreItemList.Builder;
import com.tencent.qqmini.sdk.launcher.ui.OnAppCloseAction;
import com.tencent.qqmini.sdk.launcher.ui.OnMoreItemSelectedListener;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

public abstract class MiniAppProxy
{
  public abstract boolean addShortcut(Context paramContext, MiniAppInfo paramMiniAppInfo, AsyncResult paramAsyncResult);
  
  public abstract boolean chooseLocation(Context paramContext, AsyncResult paramAsyncResult);
  
  public abstract boolean downloadApp(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract boolean enterQRCode(Context paramContext, boolean paramBoolean, AsyncResult paramAsyncResult);
  
  public abstract String getA2();
  
  public abstract String getAccount();
  
  public abstract String getAmsAppId();
  
  public abstract String getAppId();
  
  public abstract String getAppName();
  
  public abstract void getAppUpdate(Activity paramActivity, MiniAppProxy.IAppUpdateListener paramIAppUpdateListener);
  
  public abstract String getAppVersion();
  
  public abstract Drawable getDrawable(Context paramContext, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable);
  
  public abstract String getImei();
  
  public abstract String getLocation(Context paramContext);
  
  public abstract boolean getLocation(Context paramContext, String paramString, boolean paramBoolean, AsyncResult paramAsyncResult);
  
  public abstract byte[] getLoginSig();
  
  public abstract int getLoginType();
  
  public abstract OnMoreItemSelectedListener getMoreItemSelectedListener();
  
  public abstract ArrayList<MoreItem> getMoreItems(MoreItemList.Builder paramBuilder);
  
  public abstract String getNickName();
  
  public abstract String getPayAccessToken();
  
  public abstract int getPayMode();
  
  public abstract String getPayOpenId();
  
  public abstract String getPayOpenKey();
  
  public abstract String getPlatformId();
  
  public abstract String getPlatformQUA();
  
  public abstract String getSoPath();
  
  public abstract int getTbsVersion();
  
  public abstract boolean isDebugVersion();
  
  public abstract void muteAudioFocus(Context paramContext, boolean paramBoolean);
  
  public abstract void notifyMiniAppInfo(int paramInt, MiniAppInfo paramMiniAppInfo);
  
  public abstract OnAppCloseAction onAppClose(MiniAppInfo paramMiniAppInfo, Closeable paramCloseable);
  
  public abstract void onAppStateChange(MiniAppInfo paramMiniAppInfo, @AppState int paramInt);
  
  public abstract boolean onCapsuleButtonCloseClick(IMiniAppContext paramIMiniAppContext, DialogInterface.OnClickListener paramOnClickListener);
  
  public abstract boolean onCapsuleButtonMoreClick(IMiniAppContext paramIMiniAppContext);
  
  public abstract boolean openChoosePhotoActivity(Context paramContext, int paramInt, MiniAppProxy.IChoosePhotoListner paramIChoosePhotoListner);
  
  public abstract boolean openImagePreview(Context paramContext, int paramInt, List<String> paramList);
  
  public abstract boolean openLocation(Context paramContext, double paramDouble1, double paramDouble2, int paramInt, String paramString1, String paramString2);
  
  public abstract boolean openNativePage(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public abstract boolean openSchema(Context paramContext, String paramString, int paramInt, ResultReceiver paramResultReceiver);
  
  public abstract void sendData(byte[] paramArrayOfByte, MiniAppProxy.SenderListener paramSenderListener);
  
  public abstract void sendRequestByMsf(byte[] paramArrayOfByte, String paramString, MiniAppProxy.SenderListener paramSenderListener);
  
  public abstract void setDrawableCallback(Drawable paramDrawable, MiniAppProxy.IDrawableLoadedCallBack paramIDrawableLoadedCallBack);
  
  public abstract boolean startBrowserActivity(Context paramContext, Intent paramIntent);
  
  public abstract boolean verifyFile(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
 * JD-Core Version:    0.7.0.1
 */