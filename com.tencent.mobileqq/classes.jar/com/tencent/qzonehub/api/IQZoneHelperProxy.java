package com.tencent.qzonehub.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQZoneHelperProxy
  extends QRouteApi
{
  public abstract void addQZoneStatis(Intent paramIntent, int paramInt);
  
  public abstract void bindQzonePublishQueueService(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection);
  
  public abstract void cleanAllQZconfig();
  
  public abstract AppRuntime createQZoneLiveMainRuntime(Context paramContext, String paramString);
  
  public abstract AppRuntime createQZoneMainRuntime(Context paramContext, String paramString);
  
  public abstract void createShortcut(AppRuntime paramAppRuntime, Intent paramIntent, String paramString, Bitmap paramBitmap);
  
  public abstract void deleteAllH5Data(AppRuntime paramAppRuntime);
  
  public abstract void forwardH5QZone(String paramString, Context paramContext);
  
  public abstract boolean forwardToQZoneFriendFeedActivity(Context paramContext, Intent paramIntent, boolean paramBoolean);
  
  public abstract void forwardToQzoneVideoCaptureNew(Activity paramActivity, Bundle paramBundle, int paramInt);
  
  public abstract void forwardToQzoneVideoCaptureNew(AppRuntime paramAppRuntime, Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, boolean paramBoolean3, boolean paramBoolean4, String paramString3, boolean paramBoolean5, String paramString4, String paramString5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, String paramString6, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, int paramInt2, boolean paramBoolean13, Bundle paramBundle);
  
  public abstract void forwardToWriteMood(Activity paramActivity, AppRuntime paramAppRuntime, Intent paramIntent, int paramInt, boolean paramBoolean);
  
  public abstract Intent getJumpQzoneTabIntent(Context paramContext, Intent paramIntent);
  
  public abstract Intent getQQBrowserActivityIntent(Context paramContext);
  
  public abstract Intent getQZoneVideoDownloadActivityIntent(Context paramContext);
  
  public abstract int getQzoneManagerInQQManagerFactory();
  
  public abstract Intent getQzoneVerticalVideoDownloadActivityIntent(Context paramContext);
  
  public abstract QIPCModule getQzoneVideoSoDownloadModule();
  
  public abstract int getSendSizeSpecNOR();
  
  public abstract int getSendSizeSpecRAW();
  
  public abstract Intent getShortcutIntent(Context paramContext);
  
  public abstract boolean getSimpleQZoneUISwitch();
  
  public abstract boolean isInQZoneEnvironment();
  
  public abstract void killQZoneProcess();
  
  public abstract void launchPluginService(BaseApplication paramBaseApplication, PreloadProcHitPluginSession paramPreloadProcHitPluginSession, String paramString, Intent paramIntent);
  
  public abstract void preloadQunAlbum(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void putQzoneSourceName(Intent paramIntent);
  
  public abstract void putWebViewPluginPackageName(Intent paramIntent);
  
  public abstract void reportTroopAlbumExp();
  
  public abstract int sendRemoteHandleManagerData(String paramString, Bundle paramBundle, boolean paramBoolean);
  
  public abstract void startTranslucentBrowserActivityForResult(Context paramContext, String paramString1, int paramInt, Bundle paramBundle, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQZoneHelperProxy
 * JD-Core Version:    0.7.0.1
 */