package com.tencent.mobileqq.qcircle.tempapi.api;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.ServiceConnection;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.regex.Pattern;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface IQZoneService
  extends IRuntimeService
{
  public abstract String BUSINESS_ID_QZONE_SAY();
  
  public abstract String EMO_PREFIX();
  
  public abstract String EMO_TAIL();
  
  public abstract int HARDWARE_HIGHLEVEL();
  
  public abstract int HARDWARE_LOWLEVEL();
  
  public abstract String KEY_UPLOAD_KEEP_VIDEO_CACHE();
  
  public abstract String KEY_VIDEO_COMPRESS_SPEED();
  
  public abstract String PARAM_FROM_AIO();
  
  public abstract String QZONE_MODULE_UPLOAD_SO();
  
  public abstract int QZONE_PHOTO_DANMAKU();
  
  public abstract String QZONE_SHARE_IMAGES();
  
  public abstract String QZONE_SHARE_SUMMERY();
  
  public abstract int QZ_GET_LOCATION_FOR_POI();
  
  public abstract String SIGN_ICON_URL_END();
  
  public abstract String SIGN_ICON_URL_PREFIX();
  
  public abstract Pattern SMILEY_PATTERN();
  
  public abstract String VIDEO_PARAM_ISUPLOADORIGIN();
  
  public abstract void bindQzoneVideoService(Context paramContext, String paramString, ServiceConnection paramServiceConnection);
  
  public abstract boolean checkIfNeedUpdate(String paramString);
  
  public abstract void cleanQCirclePush();
  
  public abstract Animatable createZipAnimationDrawable(String paramString, int paramInt, Drawable.Callback paramCallback);
  
  public abstract void downloadModule(String paramString, IQCirclrModuleDownloadListener paramIQCirclrModuleDownloadListener);
  
  public abstract void draw(Animatable paramAnimatable, Canvas paramCanvas);
  
  public abstract Looper getBackGroundLooper();
  
  public abstract Looper getBusinessThreadLooper();
  
  public abstract String getDeviceInfo();
  
  public abstract String getDeviceName();
  
  public abstract int getEmoCount(String paramString);
  
  public abstract String getEmoUrlFromConfig(String paramString);
  
  public abstract String getHighPriorityConfig(String paramString1, String paramString2, String paramString3);
  
  public abstract String getIMSI();
  
  public abstract String getModuleFilePath(String paramString);
  
  public abstract int getNetworkType();
  
  public abstract String getNetworkTypeString();
  
  public abstract String getQUA3();
  
  public abstract String getRealProperties(String paramString, int paramInt1, int paramInt2);
  
  public abstract Looper getRealTimeLooper();
  
  public abstract String getRecordUrl(String paramString);
  
  public abstract String getSDCardCapabilityForDisplay();
  
  public abstract String getSDCardRemainForDisplay();
  
  public abstract boolean getTrimSupportIsAvailable();
  
  public abstract String getVersionForPic();
  
  public abstract int getVideoCanCompressLimitMs();
  
  public abstract String getVideoFileCacheDir();
  
  public abstract int getVideoThreadId();
  
  public abstract boolean isExternalAvailable();
  
  public abstract void jumpToQzoneShare(String paramString, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt);
  
  public abstract boolean meetHardwareRestriction(int paramInt1, int paramInt2);
  
  public abstract void postBackGoundThread(Runnable paramRunnable, long paramLong);
  
  public abstract void postNormalThread(Runnable paramRunnable, long paramLong);
  
  public abstract void postRealTimeThread(Runnable paramRunnable, long paramLong);
  
  public abstract void postReportThreadThread(Runnable paramRunnable, long paramLong);
  
  public abstract void postVideoThread(Runnable paramRunnable, long paramLong);
  
  public abstract void release(Animatable paramAnimatable);
  
  public abstract void removeBackGroundThreadTask(Runnable paramRunnable);
  
  public abstract void removeRealTimeThreadTask(Runnable paramRunnable);
  
  public abstract String replaceEmoCode(String paramString1, String paramString2);
  
  public abstract void retentionReport(int paramInt);
  
  public abstract void setBounds(Animatable paramAnimatable, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract String splash2Emo(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService
 * JD-Core Version:    0.7.0.1
 */