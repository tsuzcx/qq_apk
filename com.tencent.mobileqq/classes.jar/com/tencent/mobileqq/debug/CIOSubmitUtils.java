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
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.ZipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.IUtilApi;
import com.tencent.util.Pair;
import com.tencent.util.UtilApi;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class CIOSubmitUtils
{
  protected static final Handler a;
  static String b;
  private static final HandlerThread c = ThreadManager.newFreeHandlerThread("CIOSubmitThread", 1);
  
  static
  {
    c.start();
    a = new Handler(c.getLooper());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("cio_mobile_qq");
    localStringBuilder.append(File.separator);
    b = localStringBuilder.toString();
  }
  
  static Pair<String, String> a(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("@23@android_cio_reporter.zip");
    paramString2 = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append("=");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b);
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.d("CIOSubmitUtils", 2, "start to zip log files");
    }
    try
    {
      ZipUtils.a(paramString1, (String)localObject);
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return new Pair(paramString2, localObject);
  }
  
  static String a()
  {
    int i = Calendar.getInstance().get(7);
    return new String[] { "remilelei;zhuoxu;", "zhuoxu;v_zzyzeng;", "v_zzyzeng;v_fxincheng;", "v_fxincheng;v_binhhe;", "v_binhhe;ronxu;", "ronxu;rejectliu;", "rejectliu;remilelei;" }[(i - 1)];
  }
  
  private static String a(int paramInt)
  {
    if (paramInt == 0) {
      return HardCodeUtil.a(2131897664);
    }
    if (paramInt == 1) {
      return HardCodeUtil.a(2131897653);
    }
    if (paramInt == 2) {
      return HardCodeUtil.a(2131897659);
    }
    if (paramInt == 3) {
      return HardCodeUtil.a(2131897654);
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
    localJSONObject.put("deviceid", UtilApi.b.b());
    localJSONObject.put("fileObj", paramString2);
    return localJSONObject;
  }
  
  public static void a(String paramString)
  {
    FileUtils.delete(paramString, false);
    new File(paramString).mkdir();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("touch folder:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" completed");
      QLog.d("CIOSubmitUtils", 2, localStringBuilder.toString());
    }
  }
  
  private static String b(int paramInt)
  {
    if (paramInt == 0) {
      return HardCodeUtil.a(2131897647);
    }
    if (paramInt == 1) {
      return HardCodeUtil.a(2131897655);
    }
    if (paramInt == 2) {
      return HardCodeUtil.a(2131897657);
    }
    if (paramInt == 3) {
      return HardCodeUtil.a(2131897650);
    }
    throw new IllegalStateException("Illegal level.");
  }
  
  static void b()
  {
    Object localObject = new File(b);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          File localFile = localObject[i];
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("filename:");
            localStringBuilder.append(localFile.getAbsolutePath());
            QLog.d("CIOSubmitUtils", 2, localStringBuilder.toString());
          }
          if (localFile.getAbsolutePath().endsWith("@23@android_cio_reporter.zip")) {
            FileUtils.deleteFile(localFile);
          }
          i += 1;
        }
      }
    }
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Object localObject1 = new Time();
    ((Time)localObject1).setToNow();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((Time)localObject1).year);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(((Time)localObject1).month + 1);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(((Time)localObject1).monthDay);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(((Time)localObject1).hour);
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(((Time)localObject1).minute);
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(((Time)localObject1).second);
    localObject2 = ((StringBuilder)localObject2).toString();
    String str = a();
    if (TextUtils.isEmpty(LocalInfoUtils.b())) {
      localObject1 = "RDM";
    } else {
      localObject1 = LocalInfoUtils.b();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131897662));
    localStringBuilder.append("8.8.17.5770");
    localStringBuilder.append("\r\n");
    localStringBuilder.append(HardCodeUtil.a(2131897663));
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\r\n【Android版本】: ");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append("\r\n");
    localStringBuilder.append(HardCodeUtil.a(2131897660));
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("\r\n\r\n【title】: ");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("\r\n");
    localStringBuilder.append(HardCodeUtil.a(2131897652));
    localStringBuilder.append(paramString4);
    localStringBuilder.append("\r\n【svn】: ");
    localStringBuilder.append("846a9bfd");
    localStringBuilder.append(" \r\n");
    localStringBuilder.append(HardCodeUtil.a(2131897665));
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("\r\n\r\ncio:");
    localStringBuilder.append(str);
    localStringBuilder.append("\r\nuin: ");
    localStringBuilder.append(paramString5);
    paramString2 = localStringBuilder.toString();
    paramString3 = new StringBuilder();
    paramString3.append(paramString1);
    paramString3.append("/param.txt");
    FileUtils.writeFile(paramString3.toString(), paramString2);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2)
  {
    Object localObject1 = new Time();
    ((Time)localObject1).setToNow();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((Time)localObject1).year);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(((Time)localObject1).month + 1);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(((Time)localObject1).monthDay);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(((Time)localObject1).hour);
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(((Time)localObject1).minute);
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(((Time)localObject1).second);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (TextUtils.isEmpty(LocalInfoUtils.b())) {
      localObject1 = "RDM";
    } else {
      localObject1 = LocalInfoUtils.b();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131897666));
    localStringBuilder.append("8.8.17.5770");
    localStringBuilder.append("\r\n");
    localStringBuilder.append(HardCodeUtil.a(2131897658));
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\r\n【Android版本】: ");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append("\r\n");
    localStringBuilder.append(HardCodeUtil.a(2131897661));
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("\r\n\r\n【title】: ");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("\r\n【activityName】: ");
    localStringBuilder.append(paramString6);
    localStringBuilder.append("\r\n");
    localStringBuilder.append(HardCodeUtil.a(2131897656));
    localStringBuilder.append(paramString4);
    localStringBuilder.append("\r\n【svn】: ");
    localStringBuilder.append("846a9bfd");
    localStringBuilder.append(" \r\n");
    localStringBuilder.append(HardCodeUtil.a(2131897649));
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("\r\n");
    paramString4 = localStringBuilder.toString();
    if (paramInt1 == 1)
    {
      paramString3 = paramString4;
      if (paramInt2 == 1) {}
    }
    else
    {
      paramString3 = new StringBuilder();
      paramString3.append(paramString4);
      paramString3.append(HardCodeUtil.a(2131897648));
      paramString3.append(b(paramInt2));
      paramString3.append("\r\n");
      paramString3.append(HardCodeUtil.a(2131897651));
      paramString3.append(a(paramInt1));
      paramString3.append("\r\n");
      paramString3 = paramString3.toString();
    }
    paramString4 = new StringBuilder();
    paramString4.append(paramString3);
    paramString4.append("\r\ncio:");
    paramString4.append(paramString2);
    paramString4.append("\r\nuin: ");
    paramString4.append(paramString5);
    paramString2 = paramString4.toString();
    paramString3 = new StringBuilder();
    paramString3.append(paramString1);
    paramString3.append("/param.txt");
    FileUtils.writeFile(paramString3.toString(), paramString2);
  }
  
  public static String c()
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
  
  private static String c(String paramString1, String paramString2)
  {
    CIOSubmitUtils.UploadFileUtil localUploadFileUtil = new CIOSubmitUtils.UploadFileUtil();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deviceID:");
      localStringBuilder.append(DeviceInfoUtil.b());
      QLog.d("CIOSubmitUtils", 2, localStringBuilder.toString());
      QLog.d("CIOSubmitUtils", 2, "versionName:8.8.17.5770");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("firma");
      localStringBuilder.append(Build.MODEL);
      QLog.d("CIOSubmitUtils", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("operationSysandroid ");
      localStringBuilder.append(Build.VERSION.RELEASE);
      QLog.d("CIOSubmitUtils", 2, localStringBuilder.toString());
      QLog.d("CIOSubmitUtils", 2, "platformandroid");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mzipname:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" allName:");
      localStringBuilder.append(paramString2);
      QLog.d("CIOSubmitUtils", 2, localStringBuilder.toString());
    }
    localUploadFileUtil.a("deviceId", DeviceInfoUtil.b());
    localUploadFileUtil.a("versionName", "8.8.17.5770");
    localUploadFileUtil.a("firma", Build.MODEL);
    paramString1 = new StringBuilder();
    paramString1.append("android ");
    paramString1.append(Build.VERSION.RELEASE);
    localUploadFileUtil.a("operationSys", paramString1.toString());
    localUploadFileUtil.a("platform", "android");
    localUploadFileUtil.a(paramString2);
    paramString1 = localUploadFileUtil.a();
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("the result:");
      paramString2.append(paramString1);
      QLog.d("CIOSubmitUtils", 2, paramString2.toString());
    }
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.CIOSubmitUtils
 * JD-Core Version:    0.7.0.1
 */