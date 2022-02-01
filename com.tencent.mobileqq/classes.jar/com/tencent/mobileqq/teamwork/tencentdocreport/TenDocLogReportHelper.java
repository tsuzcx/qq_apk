package com.tencent.mobileqq.teamwork.tencentdocreport;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class TenDocLogReportHelper
{
  public static String a = "";
  private static JSONObject b = new JSONObject();
  private static String[] c = new String[2];
  private static HashMap<String, Long> d = new HashMap();
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "";
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.hashCode());
      localStringBuilder.append("_");
      localStringBuilder.append(System.currentTimeMillis());
      paramString = localStringBuilder.toString();
    }
    a = paramString;
    paramString = new StringBuilder();
    paramString.append("init trace id: ");
    paramString.append(a);
    QLog.d("TenDocLogReportHelper", 2, paramString.toString());
    return a;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    Uri localUri = Uri.parse(paramString1);
    if (!TextUtils.isEmpty(localUri.getQueryParameter("xiaolv_wy_tdoc_tid"))) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("trace url: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",traceId: ");
    localStringBuilder.append(paramString2);
    QLog.d("TenDocLogReportHelper", 2, localStringBuilder.toString());
    paramString1 = localUri.buildUpon();
    paramString1.appendQueryParameter("xiaolv_wy_tdoc_tid", paramString2);
    return paramString1.toString();
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    ReportController.b(paramAppInterface, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a(c, paramString1, paramString3, paramString4, paramString5);
    String[] arrayOfString = c;
    ReportController.b(paramAppInterface, "dc00898", "", "", paramString2, paramString2, 0, 0, "", "", arrayOfString[0], arrayOfString[1]);
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("reportTDW: traceId=");
      paramAppInterface.append(paramString1);
      paramAppInterface.append(" T=");
      paramAppInterface.append(paramString2);
      paramAppInterface.append(" value=");
      paramAppInterface.append(paramString3);
      paramAppInterface.append(" extra1=");
      paramAppInterface.append(paramString4);
      paramAppInterface.append(" extra2=");
      paramAppInterface.append(paramString5);
      QLog.d("TenDocLogReportHelper", 2, paramAppInterface.toString());
    }
  }
  
  public static void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramTeamWorkFileImportInfo.A))
    {
      paramTeamWorkFileImportInfo.A = a(paramTeamWorkFileImportInfo.c);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("has setted trace Id: ");
    localStringBuilder.append(paramTeamWorkFileImportInfo.A);
    QLog.d("TenDocLogReportHelper", 2, localStringBuilder.toString());
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tencentdoc log:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramString3);
    QLog.d(paramString1, 2, localStringBuilder.toString());
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tencentdoc log:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramString4);
    QLog.d(paramString1, 2, localStringBuilder.toString());
  }
  
  private static void a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      b.put("trace", paramString1);
      b.put("value", paramString2);
      b.put("extra1", paramString3);
      b.put("extra2", paramString4);
      paramString1 = b.toString();
      int i = paramString1.length();
      int j = i / 2;
      paramArrayOfString[0] = paramString1.substring(0, j);
      paramArrayOfString[1] = paramString1.substring(j, i);
      return;
    }
    catch (JSONException paramArrayOfString)
    {
      QLog.e("TenDocLogReportHelper", 2, "report fail", paramArrayOfString);
    }
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Uri localUri = Uri.parse(paramString);
    if (!TextUtils.isEmpty(localUri.getQueryParameter("showDiscuss"))) {
      return paramString;
    }
    paramString = localUri.buildUpon();
    paramString.appendQueryParameter("showDiscuss", "true");
    return paramString.toString();
  }
  
  public static void b(String paramString1, String paramString2, String paramString3)
  {
    if (c(paramString1))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ps_key:");
      ((StringBuilder)localObject).append(h(paramString1));
      localObject = ((StringBuilder)localObject).toString();
      paramString1 = d(paramString1);
      if (TextUtils.isEmpty(paramString1))
      {
        a(paramString2, paramString3, (String)localObject);
        return;
      }
      a(paramString2, paramString3, (String)localObject, paramString1);
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (c(paramString1))
    {
      paramString1 = d(paramString1);
      if (TextUtils.isEmpty(paramString1))
      {
        a(paramString2, paramString3, paramString4);
        return;
      }
      a(paramString2, paramString3, paramString4, paramString1);
    }
  }
  
  public static boolean c(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3) {
      if (!paramString.contains("docs.qq.com"))
      {
        bool1 = bool2;
        if (!paramString.contains("docx.qq.com")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static String d(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Uri.parse(paramString).getQueryParameter("xiaolv_wy_tdoc_tid");
  }
  
  public static String e(String paramString)
  {
    String str = d(paramString);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    int i = paramString.indexOf("?");
    str = paramString;
    if (i != -1) {
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public static void f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    d.put(paramString, Long.valueOf(SystemClock.elapsedRealtime()));
  }
  
  public static long g(String paramString)
  {
    paramString = (Long)d.remove(paramString);
    if (paramString != null) {
      return SystemClock.elapsedRealtime() - paramString.longValue();
    }
    return 0L;
  }
  
  private static boolean h(String paramString)
  {
    paramString = CookieManager.getInstance().getCookie(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i];
        if ((arrayOfString != null) && (arrayOfString.contains("p_skey")))
        {
          arrayOfString = arrayOfString.split("=");
          if ((arrayOfString.length > 1) && (!TextUtils.isEmpty(arrayOfString[1]))) {
            return true;
          }
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper
 * JD-Core Version:    0.7.0.1
 */