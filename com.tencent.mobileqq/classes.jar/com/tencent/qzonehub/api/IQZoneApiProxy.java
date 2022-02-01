package com.tencent.qzonehub.api;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.api.QZoneApiProxy.QZoneLoadCallback;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQZoneApiProxy
  extends QRouteApi
{
  public abstract Fragment createLebaFragment(@NonNull Activity paramActivity, @NonNull AppRuntime paramAppRuntime, @NonNull String paramString);
  
  public abstract AppRuntime getLastRuntime();
  
  public abstract boolean initEnv(@NonNull Context paramContext, @NonNull AppRuntime paramAppRuntime);
  
  public abstract void initSchoolExtendListCreator();
  
  public abstract boolean initServlet(@NonNull Context paramContext, @NonNull AppRuntime paramAppRuntime);
  
  public abstract boolean isInQZoneEnvironment();
  
  public abstract boolean isIsQzoneInstalled();
  
  public abstract boolean isQzoneInstalled();
  
  public abstract boolean isQzonePluginInstalledAndVersionRight(@Nullable QZoneApiProxy.QZoneLoadCallback paramQZoneLoadCallback);
  
  public abstract boolean isQzoneVersionRight();
  
  public abstract boolean isRightAndroidVersionForStickyNote();
  
  public abstract boolean needLoadQZoneEnv();
  
  public abstract boolean needLoadQZoneEnv(QZoneApiProxy.QZoneLoadCallback paramQZoneLoadCallback);
  
  public abstract boolean needShowAioFeedList(@Nullable Activity paramActivity, @Nullable AppRuntime paramAppRuntime);
  
  public abstract boolean needShowMsgFeedList(@Nullable Activity paramActivity, @Nullable AppRuntime paramAppRuntime);
  
  public abstract boolean needShowQzoneFrame(@Nullable Context paramContext, @Nullable AppRuntime paramAppRuntime);
  
  public abstract boolean needShowSchoolExtendFeed(@Nullable Activity paramActivity, @Nullable AppRuntime paramAppRuntime);
  
  public abstract boolean needShowSubFeedList(@Nullable Activity paramActivity, @Nullable AppRuntime paramAppRuntime);
  
  public abstract void onAccountChange(@NonNull Context paramContext, @NonNull AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQZoneApiProxy
 * JD-Core Version:    0.7.0.1
 */