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

public class QFlutterEngineData
  extends XmlData
  implements FilesListHolder
{
  public static final String[] ENGINE_FILENAME_LIST = { "libflutter.so" };
  private static final String LIB_FLUTTER_ENGINE_NAME = "libflutter.so";
  public static final String SP_NAME = "qflutter_engine_downloader_sp";
  public static final String STR_RES_NAME = "qq.android.flutter.engine.v8.5.5_v2";
  public static final String TAG = "QFlutterEngineData";
  @saveInSP(a=true, b=true)
  public String libEngineSoMD5 = "";
  
  public static QFlutterDownloader<QFlutterEngineData> createDownloader(QQAppInterface paramQQAppInterface)
  {
    return new QFlutterDownloader("qq.android.flutter.engine.v8.5.5_v2", paramQQAppInterface, new QFlutterDownloader.DownloadConfig(QFlutterEngineData.class, QFlutterEngineData.class.getSimpleName(), 10092, "prd", 0));
  }
  
  public String[] filesList()
  {
    return ENGINE_FILENAME_LIST;
  }
  
  public Map<String, String> filesValidateMap()
  {
    String str = QFlutterResConfigProcessor.a().a("qq.android.flutter.engine.v8.5.5_v2");
    HashMap localHashMap = new HashMap();
    if (!TextUtils.equals(this.strPkgName, str))
    {
      QLog.e("QFlutterEngineData", 1, new Object[] { "app not match gray config res: ", this.strPkgName, " gray: ", str });
      localHashMap.put("ResName-NotMatch", "");
      return localHashMap;
    }
    localHashMap.put("libflutter.so", this.libEngineSoMD5);
    return localHashMap;
  }
  
  public String getSharedPreferencesName()
  {
    return "early_qflutter_engine_downloader_sp";
  }
  
  public String getStrResName()
  {
    return "qq.android.flutter.engine.v8.5.5_v2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QFlutterEngineData
 * JD-Core Version:    0.7.0.1
 */