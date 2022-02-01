package com.tencent.qzonehub.api.utils.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import cooperation.qzone.video.QZoneVideoCompressor;
import cooperation.qzone.video.QzoneLiveVideoInterface;
import cooperation.qzone.video.QzoneVerticalVideoPluginProxyActivity;
import cooperation.qzone.video.QzoneVideoPluginProxyService;
import cooperation.qzone.video.TcSdkDownloadReportServlet;
import cooperation.qzone.video.VideoComponentCallback;
import cooperation.qzone.webviewwrapper.IWebviewOnClassLoaded;
import mqq.app.NewIntent;

public class QzoneVideoHelperImpl
  implements IQzoneVideoHelper
{
  public void bindService(Context paramContext, String paramString, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramContext, QzoneVideoPluginProxyService.class);
    localIntent.putExtra("qzone_uin", paramString);
    QzoneVideoPluginProxyService.bindService(paramContext, paramString, localIntent, paramServiceConnection);
  }
  
  public void cancel(String paramString)
  {
    QZoneVideoCompressor.cancel(paramString);
  }
  
  public void forwardToBrowser(Activity paramActivity, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    QzoneLiveVideoInterface.forwardToBrowser(paramActivity, paramString1, paramInt, paramBundle, paramString2);
  }
  
  public String getCacheDir(String paramString)
  {
    return QzoneLiveVideoInterface.getCacheDir(paramString);
  }
  
  public String getLiveVideoDownLoadClassName()
  {
    return QzoneLiveVideoInterface.getLiveVideoDownLoadClassName();
  }
  
  public NewIntent getTcSdkDownloadReportServlet(Context paramContext)
  {
    return new NewIntent(paramContext, TcSdkDownloadReportServlet.class);
  }
  
  public Object getVideoComponentCallback()
  {
    return new VideoComponentCallback();
  }
  
  public boolean instanceofQzoneVerticalVideoPluginProxyActivity(Activity paramActivity)
  {
    return paramActivity instanceof QzoneVerticalVideoPluginProxyActivity;
  }
  
  public void launchPluginActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    QzoneVerticalVideoPluginProxyActivity.launchPluginActivityForResult(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public void preInitWebview(IWebviewOnClassLoaded paramIWebviewOnClassLoaded)
  {
    QzoneLiveVideoInterface.preInitWebview(paramIWebviewOnClassLoaded);
  }
  
  public int trimByFFmpeg(String paramString, String[] paramArrayOfString)
  {
    return QZoneVideoCompressor.trimByFFmpeg(paramString, paramArrayOfString);
  }
  
  public int trimByFFmpeg(String[] paramArrayOfString)
  {
    return QZoneVideoCompressor.trimByFFmpeg(paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.utils.impl.QzoneVideoHelperImpl
 * JD-Core Version:    0.7.0.1
 */