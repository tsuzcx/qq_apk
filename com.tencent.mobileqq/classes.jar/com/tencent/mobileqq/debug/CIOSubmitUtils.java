package com.tencent.mobileqq.debug;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqutils.api.IQQUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.ZipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class CIOSubmitUtils
{
  protected static final Handler a;
  private static final HandlerThread jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("CIOSubmitThread", 1);
  static String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory() + File.separator + "cio_mobile_qq" + File.separator;
  
  static
  {
    jdField_a_of_type_AndroidOsHandlerThread.start();
    jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  static Pair<String, String> a(String paramString1, String paramString2)
  {
    paramString2 = paramString2 + "@23@android_cio_reporter.zip";
    String str = System.currentTimeMillis() + "=";
    paramString2 = str + paramString2;
    str = jdField_a_of_type_JavaLangString + paramString2;
    if (QLog.isColorLevel()) {
      QLog.d("CIOSubmitUtils", 2, "start to zip log files");
    }
    try
    {
      ZipUtils.a(paramString1, str);
      return new Pair(paramString2, str);
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  static String a()
  {
    int i = Calendar.getInstance().get(7);
    return new String[] { "remilelei;zhuoxu;", "zhuoxu;v_zzyzeng;", "v_zzyzeng;v_fxincheng;", "v_fxincheng;v_binhhe;", "v_binhhe;ronxu;", "ronxu;rejectliu;", "rejectliu;remilelei;" }[(i - 1)];
  }
  
  private static String a(int paramInt)
  {
    if (paramInt == 0) {
      return HardCodeUtil.a(2131699526);
    }
    if (paramInt == 1) {
      return HardCodeUtil.a(2131699515);
    }
    if (paramInt == 2) {
      return HardCodeUtil.a(2131699521);
    }
    if (paramInt == 3) {
      return HardCodeUtil.a(2131699516);
    }
    throw new IllegalStateException("Illegal priority.");
  }
  
  public static JSONObject a(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("version", paramString3);
    localJSONObject.put("manu", Build.BRAND);
    localJSONObject.put("device", Build.MODEL);
    localJSONObject.put("api_ver", 1);
    localJSONObject.put("plugin_ver", 1);
    localJSONObject.put("client_identify", UUID.randomUUID());
    localJSONObject.put("platform", "android");
    localJSONObject.put("plugin", 133);
    localJSONObject.put("p_id", 1);
    localJSONObject.put("rdmuuid", "0");
    localJSONObject.put("os", Build.VERSION.RELEASE);
    localJSONObject.put("uin", paramString1);
    localJSONObject.put("deviceid", ((IQQUtilsApi)QRoute.api(IQQUtilsApi.class)).getDeviceId());
    localJSONObject.put("fileObj", paramString2);
    return localJSONObject;
  }
  
  static void a()
  {
    Object localObject = new File(jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          File localFile = localObject[i];
          if (QLog.isColorLevel()) {
            QLog.d("CIOSubmitUtils", 2, "filename:" + localFile.getAbsolutePath());
          }
          if (localFile.getAbsolutePath().endsWith("@23@android_cio_reporter.zip")) {
            FileUtils.a(localFile);
          }
          i += 1;
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    FileUtils.a(paramString, false);
    new File(paramString).mkdir();
    if (QLog.isColorLevel()) {
      QLog.d("CIOSubmitUtils", 2, "touch folder:" + paramString + " completed");
    }
  }
  
  public static String b()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime == null) {
      return "0";
    }
    if (localAppRuntime.getAccount() == null) {
      return "0";
    }
    return localAppRuntime.getAccount();
  }
  
  private static String b(int paramInt)
  {
    if (paramInt == 0) {
      return HardCodeUtil.a(2131699509);
    }
    if (paramInt == 1) {
      return HardCodeUtil.a(2131699517);
    }
    if (paramInt == 2) {
      return HardCodeUtil.a(2131699519);
    }
    if (paramInt == 3) {
      return HardCodeUtil.a(2131699512);
    }
    throw new IllegalStateException("Illegal level.");
  }
  
  private static String b(String paramString1, String paramString2)
  {
    CIOSubmitUtils.UploadFileUtil localUploadFileUtil = new CIOSubmitUtils.UploadFileUtil();
    if (QLog.isColorLevel())
    {
      QLog.d("CIOSubmitUtils", 2, "deviceID:" + DeviceInfoUtil.a());
      QLog.d("CIOSubmitUtils", 2, "versionName:8.5.5.5105");
      QLog.d("CIOSubmitUtils", 2, "firma" + Build.MODEL);
      QLog.d("CIOSubmitUtils", 2, "operationSysandroid " + Build.VERSION.RELEASE);
      QLog.d("CIOSubmitUtils", 2, "platformandroid");
      QLog.d("CIOSubmitUtils", 2, "mzipname:" + paramString1 + " allName:" + paramString2);
    }
    localUploadFileUtil.a("deviceId", DeviceInfoUtil.a());
    localUploadFileUtil.a("versionName", "8.5.5.5105");
    localUploadFileUtil.a("firma", Build.MODEL);
    localUploadFileUtil.a("operationSys", "android " + Build.VERSION.RELEASE);
    localUploadFileUtil.a("platform", "android");
    localUploadFileUtil.a(paramString2);
    paramString1 = localUploadFileUtil.a();
    if (QLog.isColorLevel()) {
      QLog.d("CIOSubmitUtils", 2, "the result:" + paramString1);
    }
    return paramString1;
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    String str1;
    String str2;
    String str3;
    if ("de12fadd".equals("0"))
    {
      str1 = LocalInfoUtils.a();
      str2 = ((Time)localObject).year + "-" + (((Time)localObject).month + 1) + "-" + ((Time)localObject).monthDay + " " + ((Time)localObject).hour + ":" + ((Time)localObject).minute + ":" + ((Time)localObject).second;
      str3 = a();
      if (!TextUtils.isEmpty(LocalInfoUtils.b())) {
        break label334;
      }
    }
    label334:
    for (localObject = "RDM";; localObject = LocalInfoUtils.b())
    {
      paramString2 = HardCodeUtil.a(2131699524) + "8.5.5.5105" + "\r\n" + HardCodeUtil.a(2131699525) + paramString2 + "\r\n【Android版本】: " + Build.VERSION.RELEASE + "\r\n" + HardCodeUtil.a(2131699522) + str2 + "\r\n\r\n【title】: " + paramString3 + "\r\n" + HardCodeUtil.a(2131699514) + paramString4 + "\r\n【svn】: " + str1 + " \r\n" + HardCodeUtil.a(2131699527) + (String)localObject + "\r\n\r\ncio:" + str3 + "\r\nuin: " + paramString5;
      FileUtils.a(paramString1 + "/param.txt", paramString2);
      return;
      str1 = "de12fadd";
      break;
    }
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    String str1;
    String str2;
    if ("de12fadd".equals("0"))
    {
      str1 = LocalInfoUtils.a();
      str2 = ((Time)localObject).year + "-" + (((Time)localObject).month + 1) + "-" + ((Time)localObject).monthDay + " " + ((Time)localObject).hour + ":" + ((Time)localObject).minute + ":" + ((Time)localObject).second;
      if (!TextUtils.isEmpty(LocalInfoUtils.b())) {
        break label435;
      }
    }
    label435:
    for (localObject = "RDM";; localObject = LocalInfoUtils.b())
    {
      paramString4 = HardCodeUtil.a(2131699528) + "8.5.5.5105" + "\r\n" + HardCodeUtil.a(2131699520) + paramString2 + "\r\n【Android版本】: " + Build.VERSION.RELEASE + "\r\n" + HardCodeUtil.a(2131699523) + str2 + "\r\n\r\n【title】: " + paramString3 + "\r\n【activityName】: " + paramString6 + "\r\n" + HardCodeUtil.a(2131699518) + paramString4 + "\r\n【svn】: " + str1 + " \r\n" + HardCodeUtil.a(2131699511) + (String)localObject + "\r\n";
      if (paramInt1 == 1)
      {
        paramString3 = paramString4;
        if (paramInt2 == 1) {}
      }
      else
      {
        paramString3 = paramString4 + HardCodeUtil.a(2131699510) + b(paramInt2) + "\r\n" + HardCodeUtil.a(2131699513) + a(paramInt1) + "\r\n";
      }
      paramString2 = paramString3 + "\r\ncio:" + paramString2 + "\r\nuin: " + paramString5;
      FileUtils.a(paramString1 + "/param.txt", paramString2);
      return;
      str1 = "de12fadd";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.CIOSubmitUtils
 * JD-Core Version:    0.7.0.1
 */