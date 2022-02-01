package com.tencent.qzonehub.api.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.webviewwrapper.IWebviewOnClassLoaded;
import mqq.app.NewIntent;

@QAPI(process={"all"})
public abstract interface IQzoneVideoHelper
  extends QRouteApi
{
  public static final String IS_QZONE_LIVE_LAUNCH = "is_qzone_live_launch";
  public static final int LAUNCH_LIVE_VIDEO = 1;
  public static final String QZONE_LIVE_PROCESS_ID = "qzone_live_process_id";
  public static final int WATCH_LIVE_VIDEO = 3;
  
  public abstract void bindService(Context paramContext, String paramString, ServiceConnection paramServiceConnection);
  
  public abstract void cancel(String paramString);
  
  public abstract void forwardToBrowser(Activity paramActivity, String paramString1, int paramInt, Bundle paramBundle, String paramString2);
  
  public abstract String getCacheDir(String paramString);
  
  public abstract String getLiveVideoDownLoadClassName();
  
  public abstract NewIntent getTcSdkDownloadReportServlet(Context paramContext);
  
  public abstract Object getVideoComponentCallback();
  
  public abstract boolean instanceofQzoneVerticalVideoPluginProxyActivity(Activity paramActivity);
  
  public abstract void launchPluginActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt);
  
  public abstract void preInitWebview(IWebviewOnClassLoaded paramIWebviewOnClassLoaded);
  
  public abstract int trimByFFmpeg(String paramString, String[] paramArrayOfString);
  
  public abstract int trimByFFmpeg(String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.utils.IQzoneVideoHelper
 * JD-Core Version:    0.7.0.1
 */