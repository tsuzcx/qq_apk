package com.tencent.mobileqq.weiyun;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.mobileqq.weiyun.model.DownloadFile;
import com.tencent.mobileqq.weiyun.sdk.download.WyDownloader;
import com.tencent.mobileqq.weiyun.sdk.upload.WyUploadJob;
import com.tencent.mobileqq.weiyun.utils.WyLog;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.AppInfo;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadFile.UploadBatch;
import com.tencent.weiyun.transmission.upload.UploadManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class TransmissionHelper
{
  private static String a;
  private static volatile boolean b = false;
  
  public static DownloadFile a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString4)) {
        return null;
      }
      if (TextUtils.isEmpty(paramString3)) {
        paramString3 = "0";
      }
      return DownloadFile.a(10, paramString1, paramString2, paramString3, paramLong, paramInt, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), paramString4, paramString5);
    }
    return null;
  }
  
  public static UploadFile a(String paramString, UploadFile.UploadBatch paramUploadBatch, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramUploadBatch != null))
    {
      if (paramInt < 0) {
        return null;
      }
      String str = Build.MODEL;
      paramString = UploadFile.createUploadFile(1, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), str, str, str, paramString, false, paramUploadBatch, paramInt);
      paramString.autoBackupFlag = false;
      return paramString;
    }
    return null;
  }
  
  private static String a()
  {
    if (a == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("V1_AND_WY_VersionName_");
      localStringBuilder.append(TransFileUtil.getVersionCode());
      localStringBuilder.append("_ChannelId_");
      localStringBuilder.append("B");
      a = localStringBuilder.toString();
    }
    return a;
  }
  
  public static void a(int paramInt)
  {
    new Thread(new TransmissionHelper.5(paramInt)).start();
  }
  
  public static void a(Application paramApplication, boolean paramBoolean)
  {
    if (b) {
      return;
    }
    WeiyunTransmissionGlobal.AppInfo localAppInfo = new WeiyunTransmissionGlobal.AppInfo(a(), 1000269, "mobileqq", TransFileUtil.getVersionCode(), 0, "unknown");
    WeiyunTransmissionGlobal localWeiyunTransmissionGlobal = WeiyunTransmissionGlobal.getInstance();
    String str;
    if (paramBoolean) {
      str = "weiyun_";
    } else {
      str = "qq_";
    }
    localWeiyunTransmissionGlobal.initTransmission(localAppInfo, paramApplication, new TransmissionHelper.TransmissionHostInterfaceImpl(str), WyLog.a());
    WeiyunTransmissionGlobal.getInstance().getUploadManager().setSpareUploader(new WyUploadJob());
    WeiyunTransmissionStatus.getInstance().setTranOnlyWifi(0, true, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
    WeiyunTransmissionStatus.getInstance().setLoginStatus(0, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
    AppNetConnInfo.registerNetChangeReceiver(null, new TransmissionHelper.1());
    WyDownloader.a().a(new TransmissionHelper.2(), paramApplication);
    WyDownloader.a().a(new TransmissionHelper.3());
    WeiyunTransmissionGlobal.getInstance().getUploadManager().addGlobalObserver(new TransmissionHelper.4());
    b = true;
  }
  
  public static void a(boolean paramBoolean, long paramLong)
  {
    WeiyunTransmissionStatus.getInstance().setLoginStatus(paramBoolean ^ true, Long.toString(paramLong));
    ((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).clearDefaultUploadDirKey();
  }
  
  public static UploadFile b(String paramString, UploadFile.UploadBatch paramUploadBatch, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramUploadBatch != null))
    {
      if (paramInt < 0) {
        return null;
      }
      String[] arrayOfString = ((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).getDefaultUploadDirKey();
      paramString = UploadFile.createUploadFile(0, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "QQ", arrayOfString[1], arrayOfString[0], paramString, false, paramUploadBatch, paramInt);
      paramString.autoBackupFlag = false;
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.TransmissionHelper
 * JD-Core Version:    0.7.0.1
 */