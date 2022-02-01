package com.tencent.qzonehub.api;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import cooperation.qzone.QZoneShareData;
import java.io.File;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IQzoneShareApi
  extends QRouteApi
{
  public static final String BROADCAST_SHARE_UPDATE = "com.tencent.qq.shareupdate";
  public static final int MINIPROGRAMTHUMSIZE = 400;
  public static final String PHOTO_PATH;
  public static final String QZONE_WEIXINDOWNLOAD = "https://app.qq.com/#id=detail&appid=100733732";
  public static final String TAG = "WXShareFromQzone";
  public static final int TYPE_ON_GET_OPENID = 1;
  public static final String WX_APPID = "wx34b037fdb0f655ee";
  public static final String WX_DEBUG_APPID = "wxf22d22dbcb68a585";
  public static final String WX_DEBUG_APPID_EXPERIMENTAL = "wxc577faa50460d9e5";
  public static final String WX_RELEASE_APPID = "wx34b037fdb0f655ee";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("photo/");
    PHOTO_PATH = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public abstract void addObserver(IQzoneShareApi.WXShareListener paramWXShareListener);
  
  public abstract String buildTransaction(String paramString);
  
  public abstract boolean checkAndroidNotBelowN();
  
  public abstract boolean checkVersionValid(Context paramContext);
  
  public abstract void dontShowContact();
  
  public abstract void handleWXEntryActivityIntent(Activity paramActivity, Intent paramIntent);
  
  public abstract boolean isWXinstalled();
  
  @Deprecated
  public abstract boolean isWXsupportApi();
  
  public abstract boolean isWxSupportMiniProgramm();
  
  public abstract boolean isWxSupportTimeLine();
  
  public abstract void jmpWeixinDetail(Activity paramActivity);
  
  @Deprecated
  public abstract boolean jumpToQzoneShare(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener);
  
  @Deprecated
  public abstract boolean jumpToQzoneShare(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt);
  
  @Deprecated
  public abstract boolean jumpToQzoneShare(String paramString, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt);
  
  public abstract void onReq(BaseReq paramBaseReq);
  
  public abstract void onResp(BaseResp paramBaseResp);
  
  public abstract void publishToQzone(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener);
  
  public abstract void publishToQzone(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt);
  
  public abstract void publishToQzoneFromMiniApp(Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt);
  
  public abstract void registerApp();
  
  public abstract void removeObserver(IQzoneShareApi.WXShareListener paramWXShareListener);
  
  public abstract void shareImage(Context paramContext, String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public abstract void shareMiniProgram(String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt);
  
  public abstract void shareMutilPicToWehat(Context paramContext, ArrayList<File> paramArrayList);
  
  public abstract void shareQzoneForMini(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, int paramInt4, String paramString7, boolean paramBoolean);
  
  public abstract void shareText(String paramString, int paramInt);
  
  public abstract void shareToQzone(Context paramContext, String paramString, QZoneShareData paramQZoneShareData, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt);
  
  public abstract void shareToQzoneFromAskAnonymously(Context paramContext, String paramString, QZoneShareData paramQZoneShareData, int paramInt);
  
  public abstract void shareWebPage(String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, int paramInt);
  
  public abstract void startShareServlet(Context paramContext, String paramString, long paramLong, QZoneShareData paramQZoneShareData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQzoneShareApi
 * JD-Core Version:    0.7.0.1
 */