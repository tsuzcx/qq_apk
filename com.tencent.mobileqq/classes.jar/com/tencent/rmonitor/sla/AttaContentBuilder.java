package com.tencent.rmonitor.sla;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.common.logger.Logger;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class AttaContentBuilder
  implements IAttaContentBuilder
{
  private static final Random a = new Random(System.currentTimeMillis());
  private final AttaParam b;
  
  public AttaContentBuilder(@NotNull AttaParam paramAttaParam)
  {
    this.b = paramAttaParam;
  }
  
  private void b(StringBuilder paramStringBuilder)
  {
    int i = 0;
    while (i < 10)
    {
      String str = this.b.a(i);
      if (!TextUtils.isEmpty(str))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("param_");
        ((StringBuilder)localObject).append(i);
        localObject = ((StringBuilder)localObject).toString();
        paramStringBuilder.append("&");
        paramStringBuilder.append((String)localObject);
        paramStringBuilder.append("=");
        paramStringBuilder.append(a(str));
      }
      i += 1;
    }
  }
  
  public String a()
  {
    Object localObject = new StringBuilder(300);
    a((StringBuilder)localObject);
    b((StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    Logger.b.d(new String[] { "RMonitor_sla_AttaContentBuilder", "makeReportContent, content = ", localObject });
    return localObject;
  }
  
  public String a(long paramLong)
  {
    try
    {
      Object localObject = new Date(paramLong);
      localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format((Date)localObject);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Logger.b.e(new String[] { "RMonitor_sla_AttaContentBuilder", "getFormatTime", localThrowable.getMessage() });
    }
    return String.valueOf(paramLong);
  }
  
  public String a(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      return b(paramString.replace("$", "\\$"));
    }
    return "";
  }
  
  public void a(StringBuilder paramStringBuilder)
  {
    String str1 = c().toString();
    String str2 = BaseInfo.userMeta.deviceId;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseInfo.userMeta.appKey);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(BaseInfo.userMeta.appId);
    String str3 = ((StringBuilder)localObject).toString();
    String str4 = BaseInfo.userMeta.version;
    String str5 = a(this.b.h);
    String str6 = a(System.currentTimeMillis());
    String str7 = BaseInfo.userMeta.uin;
    long l = Math.abs(a.nextLong());
    if (BaseInfo.app != null) {
      localObject = BaseInfo.app.getPackageName();
    } else {
      localObject = "";
    }
    paramStringBuilder.append("attaid");
    paramStringBuilder.append("=");
    this.b.getClass();
    paramStringBuilder.append("08e00055686");
    paramStringBuilder.append("&");
    paramStringBuilder.append("token");
    paramStringBuilder.append("=");
    this.b.getClass();
    paramStringBuilder.append("8666841551");
    paramStringBuilder.append("&");
    paramStringBuilder.append("client_type");
    paramStringBuilder.append("=");
    this.b.getClass();
    paramStringBuilder.append("android");
    paramStringBuilder.append("&");
    paramStringBuilder.append("debug");
    paramStringBuilder.append("=");
    paramStringBuilder.append(this.b.i);
    paramStringBuilder.append("&");
    paramStringBuilder.append("error_code");
    paramStringBuilder.append("=");
    paramStringBuilder.append(this.b.g);
    paramStringBuilder.append("&");
    paramStringBuilder.append("event_code");
    paramStringBuilder.append("=");
    paramStringBuilder.append(this.b.d);
    paramStringBuilder.append("&");
    paramStringBuilder.append("event_cost");
    paramStringBuilder.append("=");
    paramStringBuilder.append(this.b.e);
    paramStringBuilder.append("&");
    paramStringBuilder.append("event_result");
    paramStringBuilder.append("=");
    paramStringBuilder.append(this.b.f);
    paramStringBuilder.append("&");
    paramStringBuilder.append("event_time");
    paramStringBuilder.append("=");
    paramStringBuilder.append(str5);
    paramStringBuilder.append("&");
    paramStringBuilder.append("sdk_version");
    paramStringBuilder.append("=");
    paramStringBuilder.append("1.0.1.25");
    paramStringBuilder.append("&");
    paramStringBuilder.append("upload_time");
    paramStringBuilder.append("=");
    paramStringBuilder.append(str6);
    paramStringBuilder.append("&");
    paramStringBuilder.append("_dc");
    paramStringBuilder.append("=");
    paramStringBuilder.append(l);
    paramStringBuilder.append("&");
    paramStringBuilder.append("app_bundle_id");
    paramStringBuilder.append("=");
    paramStringBuilder.append(a((String)localObject));
    paramStringBuilder.append("&");
    paramStringBuilder.append("app_key");
    paramStringBuilder.append("=");
    paramStringBuilder.append(a(str3));
    paramStringBuilder.append("&");
    paramStringBuilder.append("app_version");
    paramStringBuilder.append("=");
    paramStringBuilder.append(a(str4));
    paramStringBuilder.append("&");
    paramStringBuilder.append("device_id");
    paramStringBuilder.append("=");
    paramStringBuilder.append(a(str2));
    paramStringBuilder.append("&");
    paramStringBuilder.append("user_id");
    paramStringBuilder.append("=");
    paramStringBuilder.append(a(str7));
    paramStringBuilder.append("&");
    paramStringBuilder.append("app_name");
    paramStringBuilder.append("=");
    paramStringBuilder.append(a(str1));
  }
  
  public AttaParam b()
  {
    return this.b;
  }
  
  public String b(String paramString)
  {
    Object localObject1 = paramString;
    Object localObject2 = paramString;
    try
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        localObject2 = paramString;
        localObject1 = new String(paramString.getBytes(), StandardCharsets.UTF_8);
      }
      localObject2 = localObject1;
      paramString = URLEncoder.encode((String)localObject1, "UTF-8");
      return paramString;
    }
    catch (Throwable paramString)
    {
      localObject1 = Logger.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("encode, value = ");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(", e = ");
      localStringBuilder.append(paramString.getMessage());
      ((Logger)localObject1).e(new String[] { "RMonitor_sla_AttaContentBuilder", localStringBuilder.toString() });
    }
    return localObject2;
  }
  
  public CharSequence c()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2;
    try
    {
      if (BaseInfo.app != null)
      {
        localObject1 = BaseInfo.app.getPackageName();
        localObject4 = BaseInfo.app.getPackageManager();
        localObject1 = ((PackageManager)localObject4).getApplicationLabel(((PackageManager)localObject4).getApplicationInfo((String)localObject1, 128));
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.b.e(new String[] { "RMonitor_sla_AttaContentBuilder", "getAppName", localThrowable.getMessage() });
      localObject2 = localObject3;
    }
    localObject3 = Logger.b;
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("getAppName, name: ");
    ((StringBuilder)localObject4).append(localObject2);
    ((Logger)localObject3).i(new String[] { "RMonitor_sla_AttaContentBuilder", ((StringBuilder)localObject4).toString() });
    localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = "";
    }
    return localObject3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.sla.AttaContentBuilder
 * JD-Core Version:    0.7.0.1
 */