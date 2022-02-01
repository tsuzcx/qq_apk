package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.ServiceConnection;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcircle.tempapi.api.IQCirclrModuleDownloadListener;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.QZoneVideoCommonUtils.VideoSupport;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.networkedmodule.QzoneModuleConfigManager;
import cooperation.qzone.networkedmodule.QzoneModuleConfigManager.QzoneModuleRecord;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.push.MsgNotification;
import cooperation.qzone.report.retention.RetentionReport;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QzoneHardwareRestriction;
import cooperation.qzone.widget.QzoneEmotionUtils;
import cooperation.qzone.zipanimate.ZipAnimationDrawable;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QZoneServiceImpl
  implements IQZoneService
{
  private static final String TAG = "QZoneServiceImpl";
  private AppRuntime mAppRuntime;
  
  private QQAppInterface getQQAppInterface()
  {
    QQAppInterface localQQAppInterface = null;
    if ((this.mAppRuntime instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)this.mAppRuntime;
    }
    return localQQAppInterface;
  }
  
  public String BUSINESS_ID_QZONE_SAY()
  {
    return "qzone_say";
  }
  
  public String EMO_PREFIX()
  {
    return "[em]";
  }
  
  public String EMO_TAIL()
  {
    return "[/em]";
  }
  
  public int HARDWARE_HIGHLEVEL()
  {
    return 2;
  }
  
  public int HARDWARE_LOWLEVEL()
  {
    return 0;
  }
  
  public String KEY_UPLOAD_KEEP_VIDEO_CACHE()
  {
    return "ServerKeepVideoCache";
  }
  
  public String KEY_VIDEO_COMPRESS_SPEED()
  {
    return "key_video_compress_speed";
  }
  
  public String PARAM_FROM_AIO()
  {
    return "param.fromAIO";
  }
  
  public String QZONE_MODULE_UPLOAD_SO()
  {
    return "upload.so";
  }
  
  public int QZONE_PHOTO_DANMAKU()
  {
    return 3;
  }
  
  public String QZONE_SHARE_IMAGES()
  {
    return "images";
  }
  
  public String QZONE_SHARE_SUMMERY()
  {
    return "summary";
  }
  
  public int QZ_GET_LOCATION_FOR_POI()
  {
    return 201208;
  }
  
  public String SIGN_ICON_URL_END()
  {
    return ".gif";
  }
  
  public String SIGN_ICON_URL_PREFIX()
  {
    return "https://qzonestyle.gtimg.cn/qzone/em/";
  }
  
  public Pattern SMILEY_PATTERN()
  {
    return QzoneEmotionUtils.SMILEY_PATTERN;
  }
  
  public String VIDEO_PARAM_ISUPLOADORIGIN()
  {
    return "param.isUploadOrigin";
  }
  
  public void bindQzoneVideoService(Context paramContext, String paramString, ServiceConnection paramServiceConnection)
  {
    QZoneHelper.bindQzoneVideoService(paramContext, paramString, paramServiceConnection);
  }
  
  public boolean checkIfNeedUpdate(String paramString)
  {
    return QzoneModuleManager.getInstance().checkIfNeedUpdate(paramString);
  }
  
  public void cleanQCirclePush() {}
  
  public Animatable createZipAnimationDrawable(String paramString, int paramInt, Drawable.Callback paramCallback)
  {
    ZipAnimationDrawable localZipAnimationDrawable = new ZipAnimationDrawable();
    localZipAnimationDrawable.setAnimationRes(paramString, paramInt);
    localZipAnimationDrawable.setCallback(paramCallback);
    localZipAnimationDrawable.setScale(DisplayUtil.getScreenWidth(MobileQQ.sMobileQQ) / 720.0F);
    localZipAnimationDrawable.clearFirstFrame();
    localZipAnimationDrawable.setRepeatAnimation(true);
    localZipAnimationDrawable.setShowLastFrameWhenStop(true);
    localZipAnimationDrawable.start();
    return localZipAnimationDrawable;
  }
  
  public void downloadModule(String paramString, IQCirclrModuleDownloadListener paramIQCirclrModuleDownloadListener)
  {
    QzoneModuleManager.getInstance().downloadModule(paramString, new QZoneServiceImpl.1(this, paramIQCirclrModuleDownloadListener));
  }
  
  public void draw(Animatable paramAnimatable, Canvas paramCanvas)
  {
    if ((paramAnimatable != null) && ((paramAnimatable instanceof ZipAnimationDrawable))) {
      ((ZipAnimationDrawable)paramAnimatable).draw(paramCanvas);
    }
  }
  
  public Looper getBackGroundLooper()
  {
    return QzoneHandlerThreadFactory.getHandlerThreadLooper("BackGround_HandlerThread");
  }
  
  public Looper getBusinessThreadLooper()
  {
    return QzoneHandlerThreadFactory.getHandlerThread("Business_HandlerThread").getLooper();
  }
  
  public String getDeviceInfo()
  {
    return PlatformInfor.g().getDeviceInfor();
  }
  
  public String getDeviceName()
  {
    PlatformInfor.g();
    return PlatformInfor.getDeviceName();
  }
  
  public int getEmoCount(String paramString)
  {
    return QzoneEmotionUtils.getEmoCount(paramString);
  }
  
  public String getEmoUrlFromConfig(String paramString)
  {
    return QzoneEmotionUtils.getEmoUrlFromConfig(paramString);
  }
  
  public String getHighPriorityConfig(String paramString1, String paramString2, String paramString3)
  {
    return QZConfigProviderUtil.a(paramString1, paramString2, paramString3);
  }
  
  public String getIMSI()
  {
    return PlatformInfor.g().getIMSI();
  }
  
  public String getModuleFilePath(String paramString)
  {
    return QzoneModuleManager.getInstance().getModuleFilePath(paramString);
  }
  
  public int getNetworkType()
  {
    return NetworkState.getNetworkType();
  }
  
  public String getNetworkTypeString()
  {
    return NetworkState.getNetworkTypeString();
  }
  
  public String getQUA3()
  {
    return QUA.getQUA3();
  }
  
  public String getRealProperties(String paramString, int paramInt1, int paramInt2)
  {
    return TrimNative.getRealProperties(paramString, paramInt1, paramInt2);
  }
  
  public Looper getRealTimeLooper()
  {
    return QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").getLooper();
  }
  
  public String getRecordUrl(String paramString)
  {
    paramString = QzoneModuleConfigManager.getInstance().getModuleRecord(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.mNewVersion.mUrl;
  }
  
  public String getSDCardCapabilityForDisplay()
  {
    return CacheManager.getSDCardCapabilityForDisplay();
  }
  
  public String getSDCardRemainForDisplay()
  {
    return CacheManager.getSDCardRemainForDisplay();
  }
  
  public boolean getTrimSupportIsAvailable()
  {
    return QZoneVideoCommonUtils.getTrimSupport().isAvailable();
  }
  
  public String getVersionForPic()
  {
    return QUA.getVersionForPic();
  }
  
  public int getVideoCanCompressLimitMs()
  {
    return QZoneHelper.getVideoCanCompressLimitMs();
  }
  
  public String getVideoFileCacheDir()
  {
    return CacheManager.getVideoFileCacheDir();
  }
  
  public int getVideoThreadId()
  {
    return QzoneHandlerThreadFactory.getHandlerThread("Video_HandlerThread").getHandlerThread().getThreadId();
  }
  
  public boolean isExternalAvailable()
  {
    return CacheManager.isExternalAvailable();
  }
  
  public void jumpToQzoneShare(String paramString, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    QZoneShareManager.jumpToQzoneShare(paramString, paramContext, paramBundle, paramOnDismissListener, paramInt);
  }
  
  public boolean meetHardwareRestriction(int paramInt1, int paramInt2)
  {
    return QzoneHardwareRestriction.meetHardwareRestriction(paramInt1, paramInt2);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void postBackGoundThread(Runnable paramRunnable, long paramLong)
  {
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").postDelayed(paramRunnable, paramLong);
  }
  
  public void postNormalThread(Runnable paramRunnable, long paramLong)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").postDelayed(paramRunnable, paramLong);
  }
  
  public void postRealTimeThread(Runnable paramRunnable, long paramLong)
  {
    QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").postDelayed(paramRunnable, paramLong);
  }
  
  public void postReportThreadThread(Runnable paramRunnable, long paramLong)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").removeTask(paramRunnable);
  }
  
  public void postVideoThread(Runnable paramRunnable, long paramLong)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Video_HandlerThread").postDelayed(paramRunnable, paramLong);
  }
  
  public void release(Animatable paramAnimatable)
  {
    if ((paramAnimatable != null) && ((paramAnimatable instanceof ZipAnimationDrawable))) {
      ((ZipAnimationDrawable)paramAnimatable).release();
    }
  }
  
  public void removeBackGroundThreadTask(Runnable paramRunnable)
  {
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").removeTask(paramRunnable);
  }
  
  public void removeRealTimeThreadTask(Runnable paramRunnable)
  {
    QzoneHandlerThreadFactory.getHandlerThread("RealTime_HandlerThread").removeTask(paramRunnable);
  }
  
  public String replaceEmoCode(String paramString1, String paramString2)
  {
    return QzoneEmotionUtils.replaceEmoCode(paramString1, paramString2);
  }
  
  public void retentionReport(int paramInt)
  {
    RetentionReport.report(paramInt);
  }
  
  public void setBounds(Animatable paramAnimatable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramAnimatable != null) && ((paramAnimatable instanceof ZipAnimationDrawable))) {
      ((ZipAnimationDrawable)paramAnimatable).setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public String splash2Emo(String paramString)
  {
    return QzoneEmotionUtils.splash2Emo(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.impl.QZoneServiceImpl
 * JD-Core Version:    0.7.0.1
 */