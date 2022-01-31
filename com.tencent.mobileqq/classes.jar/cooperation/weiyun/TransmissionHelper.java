package cooperation.weiyun;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import anpa;
import anpb;
import anpd;
import anpe;
import anpf;
import anpg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.AppInfo;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadFile.UploadBatch;
import com.tencent.weiyun.transmission.upload.UploadManager;
import cooperation.weiyun.sdk.download.DownloadFile;
import cooperation.weiyun.sdk.download.WyDownloader;
import cooperation.weiyun.upload.WyUploadJob;
import cooperation.weiyun.utils.WyLog;
import mqq.app.AppRuntime;

public final class TransmissionHelper
{
  private static String jdField_a_of_type_JavaLangString;
  private static volatile boolean jdField_a_of_type_Boolean;
  
  public static UploadFile a(String paramString, UploadFile.UploadBatch paramUploadBatch, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramUploadBatch == null) || (paramInt < 0)) {
      return null;
    }
    String str = Build.MODEL;
    paramString = UploadFile.createUploadFile(1, BaseApplicationImpl.getApplication().getRuntime().getAccount(), str, str, str, paramString, false, paramUploadBatch, paramInt);
    paramString.autoBackupFlag = false;
    return paramString;
  }
  
  public static DownloadFile a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString4))) {
      return null;
    }
    if (TextUtils.isEmpty(paramString3)) {
      paramString3 = "0";
    }
    for (;;)
    {
      return DownloadFile.a(10, paramString1, paramString2, paramString3, paramLong, paramInt, BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramString4, paramString5);
    }
  }
  
  private static String a()
  {
    if (jdField_a_of_type_JavaLangString == null) {
      jdField_a_of_type_JavaLangString = "V1_AND_WY_VersionName_" + RichMediaUtil.a() + "_ChannelId_" + "B";
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static void a(int paramInt)
  {
    new Thread(new anpf(paramInt)).start();
  }
  
  public static void a(Application paramApplication, boolean paramBoolean)
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    WeiyunTransmissionGlobal.AppInfo localAppInfo = new WeiyunTransmissionGlobal.AppInfo(a(), 1000269, "mobileqq", RichMediaUtil.a(), 0, "unknown");
    WeiyunTransmissionGlobal localWeiyunTransmissionGlobal = WeiyunTransmissionGlobal.getInstance();
    if (paramBoolean) {}
    for (String str = "weiyun_";; str = "qq_")
    {
      localWeiyunTransmissionGlobal.initTransmission(localAppInfo, paramApplication, new anpg(str), WyLog.a());
      WeiyunTransmissionGlobal.getInstance().getUploadManager().setSpareUploader(new WyUploadJob());
      WeiyunTransmissionStatus.getInstance().setTranOnlyWifi(0, true, BaseApplicationImpl.getApplication().getRuntime().getAccount());
      WeiyunTransmissionStatus.getInstance().setLoginStatus(0, BaseApplicationImpl.getApplication().getRuntime().getAccount());
      AppNetConnInfo.registerNetChangeReceiver(null, new anpa());
      WyDownloader.a().a(new anpb(), paramApplication);
      WyDownloader.a().a(new anpd());
      WeiyunTransmissionGlobal.getInstance().getUploadManager().addGlobalObserver(new anpe());
      jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public static void a(boolean paramBoolean, long paramLong)
  {
    WeiyunTransmissionStatus localWeiyunTransmissionStatus = WeiyunTransmissionStatus.getInstance();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localWeiyunTransmissionStatus.setLoginStatus(i, Long.toString(paramLong));
      WeiyunHelper.c();
      return;
    }
  }
  
  public static UploadFile b(String paramString, UploadFile.UploadBatch paramUploadBatch, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramUploadBatch == null) || (paramInt < 0)) {
      return null;
    }
    String[] arrayOfString = WeiyunHelper.a();
    paramString = UploadFile.createUploadFile(0, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "QQ", arrayOfString[1], arrayOfString[0], paramString, false, paramUploadBatch, paramInt);
    paramString.autoBackupFlag = false;
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.TransmissionHelper
 * JD-Core Version:    0.7.0.1
 */