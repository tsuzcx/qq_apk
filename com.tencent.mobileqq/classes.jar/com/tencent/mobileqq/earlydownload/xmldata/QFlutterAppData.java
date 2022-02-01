package com.tencent.mobileqq.earlydownload.xmldata;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig;
import com.tencent.mobileqq.config.business.qflutter.QFlutterResConfigProcessor;
import com.tencent.mobileqq.flutter.download.QFlutterDownloader;
import com.tencent.mobileqq.flutter.download.QFlutterDownloader.DownloadConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class QFlutterAppData
  extends XmlData
  implements FilesListHolder
{
  public static final String[] APP_FILENAME_LIST = { "libapp.so", "libqflutter-resource-loader.so", "res.apk", "libQFlutterLog.so", "libdart_native.so" };
  private static final String ASSET_RES_NAME = "res.apk";
  public static final String LIB_DART_NATIVE_NAME = "libdart_native.so";
  private static final String LIB_FLUTTER_APP_NAME = "libapp.so";
  public static final String LIB_LOG_NAME = "libQFlutterLog.so";
  public static final String LIB_RESOURCE_LOADER_NAME = "libqflutter-resource-loader.so";
  public static final String SP_NAME = "qflutter_app_downloader_sp";
  public static final String STR_RES_NAME = "qq.android.flutter.app.v8.7.0_release";
  public static final String TAG = "QFlutterAppData";
  @saveInSP(a=true, b=true)
  public String assetResMD5 = "";
  @saveInSP(a=true, b=true)
  public String libAppSoMD5 = "";
  @saveInSP(a=true, b=true)
  public String libDartNativeMD5 = "";
  @saveInSP(a=true, b=true)
  public String libLogSoMD5 = "";
  @saveInSP(a=true, b=true)
  public String libSkinSoMD5 = "";
  
  public static QFlutterDownloader<QFlutterAppData> createDownloader(QQAppInterface paramQQAppInterface)
  {
    return new QFlutterDownloader("qq.android.flutter.app.v8.7.0_release", paramQQAppInterface, new QFlutterDownloader.DownloadConfig(QFlutterAppData.class, QFlutterAppData.class.getSimpleName(), 10093, "prd", 1));
  }
  
  public String[] filesList()
  {
    return APP_FILENAME_LIST;
  }
  
  public Map<String, String> filesValidateMap()
  {
    String str = QFlutterResConfigProcessor.a().a("qq.android.flutter.app.v8.7.0_release");
    HashMap localHashMap = new HashMap();
    if (!TextUtils.equals(this.strPkgName, str))
    {
      QLog.e("QFlutterAppData", 1, new Object[] { "app not match gray config res: ", this.strPkgName, " gray: ", str });
      localHashMap.put("ResName-NotMatch", "");
      return localHashMap;
    }
    localHashMap.put("libapp.so", this.libAppSoMD5);
    localHashMap.put("libqflutter-resource-loader.so", this.libSkinSoMD5);
    localHashMap.put("libQFlutterLog.so", this.libLogSoMD5);
    localHashMap.put("res.apk", this.assetResMD5);
    localHashMap.put("libdart_native.so", this.libDartNativeMD5);
    return localHashMap;
  }
  
  public String getSharedPreferencesName()
  {
    return "early_qflutter_app_downloader_sp";
  }
  
  public String getStrResName()
  {
    return "qq.android.flutter.app.v8.7.0_release";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData
 * JD-Core Version:    0.7.0.1
 */