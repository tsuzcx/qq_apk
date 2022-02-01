package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.f.a;
import com.tencent.smtt.utils.g;
import java.io.File;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class TbsDownloader
{
  public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
  public static boolean DOWNLOAD_OVERSEA_TBS = false;
  public static final String LOGTAG = "TbsDownload";
  public static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
  static boolean a;
  private static String b;
  private static Context c;
  private static Handler d;
  private static String e;
  private static Object f = new byte[0];
  private static l g;
  private static HandlerThread h;
  private static boolean i = false;
  private static boolean j = false;
  private static boolean k = false;
  private static long l = -1L;
  
  protected static File a(int paramInt)
  {
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int n = arrayOfString.length;
    Object localObject1 = null;
    int m = 0;
    while (m < n)
    {
      Object localObject2 = arrayOfString[m];
      if (!((String)localObject2).equals(c.getApplicationInfo().packageName))
      {
        localObject2 = FileUtil.a(c, (String)localObject2, 4, false);
        if (getOverSea(c)) {
          localObject1 = "x5.oversea.tbs.org";
        } else {
          localObject1 = getBackupFileName(false);
        }
        localObject2 = new File((String)localObject2, (String)localObject1);
        if (((File)localObject2).exists())
        {
          if (a.a(c, (File)localObject2) == paramInt)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("local tbs version fond,path = ");
            ((StringBuilder)localObject1).append(((File)localObject2).getAbsolutePath());
            TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
            return localObject2;
          }
          localObject1 = "version is not match";
        }
        else
        {
          localObject1 = "can not find local backup core file";
        }
        TbsLog.i("TbsDownload", (String)localObject1);
        localObject1 = localObject2;
      }
      m += 1;
    }
    return localObject1;
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static JSONArray a(boolean paramBoolean)
  {
    JSONArray localJSONArray = new JSONArray();
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int i1 = arrayOfString.length;
    int m = 0;
    while (m < i1)
    {
      Object localObject = arrayOfString[m];
      if (paramBoolean)
      {
        String str = FileUtil.a(c, (String)localObject, 4, false);
        if (getOverSea(c)) {
          localObject = "x5.oversea.tbs.org";
        } else {
          localObject = getBackupFileName(false);
        }
        localObject = new File(str, (String)localObject);
      }
      else
      {
        localObject = new File(FileUtil.a(c, (String)localObject, 4, false), "x5.tbs.decouple");
      }
      if (((File)localObject).exists())
      {
        long l1 = a.a(c, (File)localObject);
        if (l1 > 0L)
        {
          int n = 0;
          while (n < localJSONArray.length())
          {
            if (localJSONArray.optInt(n) == l1)
            {
              n = 1;
              break label170;
            }
            n += 1;
          }
          n = 0;
          label170:
          if (n == 0) {
            localJSONArray.put(l1);
          }
        }
      }
      m += 1;
    }
    return localJSONArray;
  }
  
  private static JSONObject a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[TbsDownloader.postJsonData]isQuery: ");
    ((StringBuilder)localObject1).append(paramBoolean1);
    ((StringBuilder)localObject1).append(" forDecoupleCore is ");
    ((StringBuilder)localObject1).append(paramBoolean3);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    String str1 = b(c);
    String str2 = b.g(c);
    String str3 = b.f(c);
    String str4 = b.i(c);
    Object localObject4 = TimeZone.getDefault().getID();
    Object localObject3;
    if (localObject4 != null) {
      localObject3 = localObject4;
    } else {
      localObject3 = "";
    }
    Object localObject2;
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)c.getSystemService("phone");
      localObject1 = localObject4;
      if (localTelephonyManager != null) {
        localObject1 = localTelephonyManager.getSimCountryIso();
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      localObject2 = localObject4;
    }
    if (localObject2 == null) {
      localObject2 = "";
    }
    localObject4 = new JSONObject();
    try
    {
      m = m.a(c).c("tpatch_num");
      bool2 = false;
      if (m < 5) {
        ((JSONObject)localObject4).put("REQUEST_TPATCH", 1);
      } else {
        ((JSONObject)localObject4).put("REQUEST_TPATCH", 0);
      }
      ((JSONObject)localObject4).put("TIMEZONEID", localObject3);
      ((JSONObject)localObject4).put("COUNTRYISO", localObject2);
      if (!b.d()) {
        break label1168;
      }
      ((JSONObject)localObject4).put("REQUEST_64", 1);
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        int m;
        boolean bool2;
        int n;
        boolean bool3;
        continue;
        continue;
        if (m == 0)
        {
          n = 0;
        }
        else
        {
          n = 1;
          continue;
          n = 0;
          continue;
          n = 0;
          continue;
          m = 1;
          continue;
          paramBoolean1 = false;
          boolean bool1;
          if (paramBoolean1) {
            bool1 = paramBoolean3 ^ true;
          } else {
            bool1 = bool2;
          }
        }
      }
    }
    ((JSONObject)localObject4).put("PROTOCOLVERSION", 1);
    if (TbsShareManager.isThirdPartyApp(c))
    {
      if (QbSdk.c) {
        m = TbsShareManager.a(c, false);
      } else {
        m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
      }
    }
    else
    {
      if (paramBoolean3) {
        m = p.a().i(c);
      } else {
        m = p.a().m(c);
      }
      n = m;
      if (m == 0)
      {
        n = m;
        if (p.a().l(c))
        {
          m = -1;
          n = m;
          if ("com.tencent.mobileqq".equals(c.getApplicationInfo().packageName))
          {
            TbsDownloadUpload.clear();
            localObject2 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject2).a.put("tbs_local_core_version", Integer.valueOf(-1));
            ((TbsDownloadUpload)localObject2).commit();
            TbsPVConfig.releaseInstance();
            n = m;
            if (TbsPVConfig.getInstance(c).getLocalCoreVersionMoreTimes() == 1) {
              n = p.a().i(c);
            }
          }
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TbsDownloader.postJsonData] tbsLocalVersion=");
      ((StringBuilder)localObject2).append(n);
      ((StringBuilder)localObject2).append(" isDownloadForeground=");
      ((StringBuilder)localObject2).append(paramBoolean2);
      TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
      m = n;
      if (paramBoolean2)
      {
        bool3 = p.a().l(c);
        if (bool3) {
          m = n;
        } else {
          m = 0;
        }
      }
    }
    if (paramBoolean1)
    {
      ((JSONObject)localObject4).put("FUNCTION", 2);
      break label562;
      ((JSONObject)localObject4).put("FUNCTION", n);
      label562:
      if (TbsShareManager.isThirdPartyApp(c))
      {
        localObject2 = f();
        ((JSONObject)localObject4).put("TBSVLARR", localObject2);
        localTbsDownloadConfig.mSyncMap.put("last_thirdapp_sendrequest_coreversion", ((JSONArray)localObject2).toString());
        localTbsDownloadConfig.commit();
        if (QbSdk.c) {
          ((JSONObject)localObject4).put("THIRDREQ", 1);
        }
      }
      else
      {
        localObject2 = a(paramBoolean3);
        if ((Apn.getApnType(c) != 3) && (((JSONArray)localObject2).length() != 0) && (m == 0) && (paramBoolean1)) {
          ((JSONObject)localObject4).put("TBSBACKUPARR", localObject2);
        }
      }
      ((JSONObject)localObject4).put("APPN", c.getPackageName());
      ((JSONObject)localObject4).put("APPVN", a(localTbsDownloadConfig.mPreferences.getString("app_versionname", null)));
      ((JSONObject)localObject4).put("APPVC", localTbsDownloadConfig.mPreferences.getInt("app_versioncode", 0));
      ((JSONObject)localObject4).put("APPMETA", a(localTbsDownloadConfig.mPreferences.getString("app_metadata", null)));
      ((JSONObject)localObject4).put("TBSSDKV", 43973);
      ((JSONObject)localObject4).put("TBSV", m);
      if (!paramBoolean3) {
        break label1187;
      }
      n = 1;
      ((JSONObject)localObject4).put("DOWNLOADDECOUPLECORE", n);
      localObject2 = localTbsDownloadConfig.mSyncMap;
      if (!paramBoolean3) {
        break label1193;
      }
      n = 1;
      ((Map)localObject2).put("tbs_downloaddecouplecore", Integer.valueOf(n));
      localTbsDownloadConfig.commit();
      if (m != 0) {
        ((JSONObject)localObject4).put("TBSBACKUPV", g.c(paramBoolean3));
      }
      ((JSONObject)localObject4).put("CPU", e);
      ((JSONObject)localObject4).put("UA", str1);
      ((JSONObject)localObject4).put("IMSI", a(str2));
      ((JSONObject)localObject4).put("IMEI", a(str3));
      ((JSONObject)localObject4).put("ANDROID_ID", a(str4));
      ((JSONObject)localObject4).put("GUID", b.e(c));
      paramBoolean1 = TbsShareManager.isThirdPartyApp(c);
      if (!paramBoolean1)
      {
        if (m != 0)
        {
          if (!QbSdk.a(c, m)) {
            break label1199;
          }
          m = 0;
          ((JSONObject)localObject4).put("STATUS", m);
        }
        else
        {
          ((JSONObject)localObject4).put("STATUS", 0);
        }
        ((JSONObject)localObject4).put("TBSDV", p.a().h(c));
      }
      paramBoolean3 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean("request_full_package", false);
      localObject2 = QbSdk.a(c, "can_unlzma", null);
      if ((localObject2 == null) || (!(localObject2 instanceof Boolean))) {
        break label1204;
      }
      paramBoolean1 = ((Boolean)localObject2).booleanValue();
      break label1206;
      if (m != 0) {
        ((JSONObject)localObject4).put("REQUEST_LZMA", 1);
      }
      if (!getOverSea(c)) {
        break label1223;
      }
      ((JSONObject)localObject4).put("OVERSEA", 1);
      if (paramBoolean2) {
        ((JSONObject)localObject4).put("DOWNLOAD_FOREGROUND", 1);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TbsDownloader.postJsonData] jsonData=");
      ((StringBuilder)localObject2).append(((JSONObject)localObject4).toString());
      TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
      return localObject4;
    }
  }
  
  private static void a(JSONArray paramJSONArray)
  {
    String[] arrayOfString = e();
    int i2 = arrayOfString.length;
    int m = 0;
    while (m < i2)
    {
      Object localObject1 = arrayOfString[m];
      int i3 = TbsShareManager.getSharedTbsCoreVersion(c, (String)localObject1);
      if (i3 > 0)
      {
        Object localObject2 = c;
        int i1 = 1;
        localObject2 = TbsShareManager.getPackageContext((Context)localObject2, (String)localObject1, true);
        if ((localObject2 != null) && (!p.a().f((Context)localObject2)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("host check failed,packageName = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          TbsLog.e("TbsDownload", ((StringBuilder)localObject2).toString());
        }
        else if (a(c, i3))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("add CoreVersionToJsonData,version+");
          ((StringBuilder)localObject1).append(i3);
          ((StringBuilder)localObject1).append(" is in black list");
          TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
        }
        else
        {
          int n = 0;
          while (n < paramJSONArray.length())
          {
            if (paramJSONArray.optInt(n) == i3)
            {
              n = i1;
              break label204;
            }
            n += 1;
          }
          n = 0;
          label204:
          if (n == 0) {
            paramJSONArray.put(i3);
          }
        }
      }
      m += 1;
    }
  }
  
  private static void a(boolean paramBoolean1, TbsDownloader.TbsDownloaderCallback paramTbsDownloaderCallback, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  static boolean a(Context paramContext)
  {
    paramContext = TbsDownloadConfig.getInstance(paramContext).mPreferences;
    boolean bool = false;
    if (paramContext.getInt("tbs_downloaddecouplecore", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  static boolean a(Context paramContext, int paramInt)
  {
    return (Build.VERSION.SDK_INT > 28) && (paramContext.getApplicationInfo().targetSdkVersion > 28) && (paramInt > 0) && (paramInt < 45114);
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean)
  {
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(paramContext);
    int m;
    if (Build.VERSION.SDK_INT < 8) {
      m = -102;
    }
    for (;;)
    {
      localTbsDownloadConfig.setDownloadInterruptCode(m);
      return false;
      Object localObject;
      if (!localTbsDownloadConfig.mPreferences.contains("is_oversea"))
      {
        boolean bool = paramBoolean;
        if (paramBoolean)
        {
          bool = paramBoolean;
          if (!"com.tencent.mm".equals(paramContext.getApplicationInfo().packageName))
          {
            TbsLog.i("TbsDownload", "needDownload-oversea is true, but not WX");
            bool = false;
          }
        }
        localTbsDownloadConfig.mSyncMap.put("is_oversea", Boolean.valueOf(bool));
        localTbsDownloadConfig.commit();
        j = bool;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("needDownload-first-called--isoversea = ");
        ((StringBuilder)localObject).append(bool);
        TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
      }
      if ((getOverSea(paramContext)) && (Build.VERSION.SDK_INT != 16) && (Build.VERSION.SDK_INT != 17) && (Build.VERSION.SDK_INT != 18))
      {
        paramContext = new StringBuilder();
        paramContext.append("needDownload- return false,  because of  version is ");
        paramContext.append(Build.VERSION.SDK_INT);
        paramContext.append(", and overea");
        TbsLog.i("TbsDownload", paramContext.toString());
        m = -103;
      }
      else
      {
        localObject = localTbsDownloadConfig.mPreferences;
        paramContext = null;
        e = ((SharedPreferences)localObject).getString("device_cpuabi", null);
        if (TextUtils.isEmpty(e)) {
          break;
        }
      }
      try
      {
        localObject = Pattern.compile("i686|mips|x86_64").matcher(e);
        paramContext = (Context)localObject;
      }
      catch (Exception localException)
      {
        label264:
        break label264;
      }
      if ((paramContext == null) || (!paramContext.find())) {
        break;
      }
      TbsLog.e("TbsDownload", "can not support x86 devices!!");
      m = -104;
    }
    return true;
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = TbsDownloadConfig.getInstance(paramContext);
    e.a().a(1000, new TbsDownloader.1((TbsDownloadConfig)localObject2));
    Object localObject1;
    if (!paramBoolean1)
    {
      paramContext = ((TbsDownloadConfig)localObject2).mPreferences.getString("app_versionname", null);
      int m = ((TbsDownloadConfig)localObject2).mPreferences.getInt("app_versioncode", 0);
      localObject1 = ((TbsDownloadConfig)localObject2).mPreferences.getString("app_metadata", null);
      String str1 = b.c(c);
      int n = b.d(c);
      String str2 = b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TbsDownloader.needSendQueryRequest] appVersionName=");
      localStringBuilder.append(str1);
      localStringBuilder.append(" oldAppVersionName=");
      localStringBuilder.append(paramContext);
      localStringBuilder.append(" appVersionCode=");
      localStringBuilder.append(n);
      localStringBuilder.append(" oldAppVersionCode=");
      localStringBuilder.append(m);
      localStringBuilder.append(" appMetadata=");
      localStringBuilder.append(str2);
      localStringBuilder.append(" oldAppVersionMetadata=");
      localStringBuilder.append((String)localObject1);
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      long l2 = System.currentTimeMillis();
      long l3 = ((TbsDownloadConfig)localObject2).mPreferences.getLong("last_check", 0L);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TbsDownloader.needSendQueryRequest] timeLastCheck=");
      localStringBuilder.append(l3);
      localStringBuilder.append(" timeNow=");
      localStringBuilder.append(l2);
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      long l1 = l3;
      if (paramBoolean2)
      {
        paramBoolean1 = ((TbsDownloadConfig)localObject2).mPreferences.contains("last_check");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=");
        localStringBuilder.append(paramBoolean1);
        TbsLog.i("TbsDownload", localStringBuilder.toString());
        l1 = l3;
        if (paramBoolean1)
        {
          l1 = l3;
          if (l3 == 0L) {
            l1 = l2;
          }
        }
      }
      l3 = ((TbsDownloadConfig)localObject2).mPreferences.getLong("last_request_success", 0L);
      long l4 = ((TbsDownloadConfig)localObject2).mPreferences.getLong("count_request_fail_in_24hours", 0L);
      long l5 = ((TbsDownloadConfig)localObject2).getRetryInterval();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("retryInterval = ");
      ((StringBuilder)localObject2).append(l5);
      ((StringBuilder)localObject2).append(" s");
      TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
      TbsPVConfig.releaseInstance();
      int i1 = TbsPVConfig.getInstance(c).getEmergentCoreVersion();
      int i2 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
      l1 = l2 - l1;
      l5 *= 1000L;
      if (l1 > l5) {}
      for (;;)
      {
        paramContext = null;
        paramBoolean1 = true;
        break label849;
        if (((i1 <= p.a().i(c)) || (i1 <= i2)) && ((!TbsShareManager.isThirdPartyApp(c)) || (l3 <= 0L) || (l2 - l3 <= l5) || (l4 >= 11L))) {
          if ((TbsShareManager.isThirdPartyApp(c)) && (TbsShareManager.findCoreForThirdPartyApp(c) == 0) && (!d()))
          {
            p.a().d(c);
          }
          else
          {
            if ((str1 == null) || (n == 0) || (str2 == null)) {
              break;
            }
            if ((str1.equals(paramContext)) && (n == m)) {
              if (str2.equals(localObject1)) {
                break label845;
              }
            }
          }
        }
      }
      if (TbsShareManager.isThirdPartyApp(c))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("timeNow - timeLastCheck is ");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(" TbsShareManager.findCoreForThirdPartyApp(sAppContext) is ");
        ((StringBuilder)localObject2).append(TbsShareManager.findCoreForThirdPartyApp(c));
        ((StringBuilder)localObject2).append(" sendRequestWithSameHostCoreVersion() is ");
        ((StringBuilder)localObject2).append(d());
        ((StringBuilder)localObject2).append(" appVersionName is ");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(" appVersionCode is ");
        ((StringBuilder)localObject2).append(n);
        ((StringBuilder)localObject2).append(" appMetadata is ");
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append(" oldAppVersionName is ");
        ((StringBuilder)localObject2).append(paramContext);
        ((StringBuilder)localObject2).append(" oldAppVersionCode is ");
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append(" oldAppVersionMetadata is ");
        ((StringBuilder)localObject2).append((String)localObject1);
        paramContext = ((StringBuilder)localObject2).toString();
      }
      else
      {
        label845:
        paramContext = null;
      }
      paramBoolean1 = false;
    }
    else
    {
      label849:
      paramContext = null;
      paramBoolean1 = true;
    }
    if ((!paramBoolean1) && (TbsShareManager.isThirdPartyApp(c)))
    {
      localObject1 = TbsLogReport.getInstance(c).tbsLogInfo();
      ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-119);
      ((TbsLogReport.TbsLogInfo)localObject1).setFailDetail(paramContext);
      TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject1);
    }
    return paramBoolean1;
  }
  
  @TargetApi(11)
  private static boolean a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[TbsDownloader.readResponse] response=");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("isNeedInstall=");
    ((StringBuilder)localObject1).append(paramBoolean3);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    bool1 = TextUtils.isEmpty(paramString);
    Integer localInteger = Integer.valueOf(0);
    Boolean localBoolean = Boolean.valueOf(false);
    if (bool1)
    {
      if (paramBoolean1) {
        paramInt = -108;
      } else {
        paramInt = -208;
      }
      localTbsDownloadConfig.setDownloadInterruptCode(paramInt);
      TbsLog.i("TbsDownload", "[TbsDownloader.readResponse] return #1,response is empty...");
      return false;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    int m = localJSONObject.getInt("RET");
    if (m != 0)
    {
      if (paramBoolean1) {
        paramInt = -109;
      } else {
        paramInt = -209;
      }
      localTbsDownloadConfig.setDownloadInterruptCode(paramInt);
      paramString = new StringBuilder();
      paramString.append("[TbsDownloader.readResponse] return #2,returnCode=");
      paramString.append(m);
      TbsLog.i("TbsDownload", paramString.toString());
      return false;
    }
    int i4 = localJSONObject.getInt("RESPONSECODE");
    String str3 = localJSONObject.getString("DOWNLOADURL");
    String str4 = localJSONObject.optString("URLLIST", "");
    int i5 = localJSONObject.getInt("TBSAPKSERVERVERSION");
    int i6 = localJSONObject.getInt("DOWNLOADMAXFLOW");
    int i7 = localJSONObject.getInt("DOWNLOAD_MIN_FREE_SPACE");
    int i8 = localJSONObject.getInt("DOWNLOAD_SUCCESS_MAX_RETRYTIMES");
    int i9 = localJSONObject.getInt("DOWNLOAD_FAILED_MAX_RETRYTIMES");
    long l3 = localJSONObject.getLong("DOWNLOAD_SINGLE_TIMEOUT");
    long l4 = localJSONObject.getLong("TBSAPKFILESIZE");
    long l1 = localJSONObject.optLong("RETRY_INTERVAL", 0L);
    int i10 = localJSONObject.optInt("FLOWCTR", -1);
    try
    {
      m = localJSONObject.getInt("USEBBACKUPVER");
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject2;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
      }
    }
    m = 0;
    localTbsDownloadConfig.mSyncMap.put("use_backup_version", Integer.valueOf(m));
    if ((paramBoolean1) && (QbSdk.i) && (TbsShareManager.isThirdPartyApp(c)))
    {
      try
      {
        m = localJSONObject.optInt("BUGLY", 0);
        paramString = TbsExtensionFunctionManager.getInstance();
        localObject1 = c;
        if (m == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        try
        {
          paramString.setFunctionEnable((Context)localObject1, "bugly_switch.txt", bool1);
        }
        catch (Throwable paramString) {}
        localObject1 = new StringBuilder();
      }
      catch (Throwable paramString) {}
      ((StringBuilder)localObject1).append("throwable:");
      ((StringBuilder)localObject1).append(paramString.toString());
      TbsLog.i("qbsdk", ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean1)
    {
      try
      {
        m = localJSONObject.optInt("TEMPLATESWITCH", 0);
        if ((m & 0x1) == 0) {
          break label3263;
        }
        bool1 = true;
        TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, "cookie_switch.txt", bool1);
        paramString = new StringBuilder();
        paramString.append("useCookieCompatiable:");
        paramString.append(bool1);
        TbsLog.w("TbsDownload", paramString.toString());
        if ((m & 0x2) == 0) {
          break label3269;
        }
        bool1 = true;
        TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, "disable_get_apk_version_switch.txt", bool1);
        paramString = new StringBuilder();
        paramString.append("disableGetApkVersionByReadFile:");
        paramString.append(bool1);
        TbsLog.w("TbsDownload", paramString.toString());
        if ((m & 0x4) == 0) {
          break label3275;
        }
        bool1 = true;
        TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, "disable_unpreinit.txt", bool1);
        QbSdk.setDisableUnpreinitBySwitch(bool1);
        paramString = new StringBuilder();
        paramString.append("disableUnpreinitBySwitch:");
        paramString.append(bool1);
        TbsLog.i("TbsDownload", paramString.toString());
        if ((m & 0x8) == 0) {
          break label3281;
        }
        bool1 = true;
        TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, "disable_use_host_backup_core.txt", bool1);
        QbSdk.setDisableUseHostBackupCoreBySwitch(bool1);
        paramString = new StringBuilder();
        paramString.append("disableUseHostBackupCoreBySwitch:");
        paramString.append(bool1);
        TbsLog.i("TbsDownload", paramString.toString());
      }
      catch (Throwable paramString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("throwable:");
        ((StringBuilder)localObject1).append(paramString.toString());
        TbsLog.i("qbsdk", ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      label1044:
      label1060:
      label3143:
      try
      {
        paramString = localJSONObject.getString("PKGMD5");
      }
      catch (Exception paramString)
      {
        int n;
        int i1;
        Object localObject3;
        int i2;
        boolean bool2;
        label970:
        label973:
        label989:
        label995:
        label998:
        label1000:
        label1006:
        label1015:
        label1022:
        break label998;
      }
      try
      {
        n = localJSONObject.getInt("RESETX5");
      }
      catch (Exception localException1)
      {
        break label995;
      }
      try
      {
        i1 = localJSONObject.getInt("UPLOADLOG");
      }
      catch (Exception localException2)
      {
        break label989;
      }
      try
      {
        if (localJSONObject.has("RESETTOKEN"))
        {
          m = localJSONObject.getInt("RESETTOKEN");
          if (m != 0) {
            m = 1;
          } else {
            m = 0;
          }
        }
        else
        {
          m = 0;
        }
        localObject3 = "";
        localObject1 = localObject3;
        localObject2 = localObject3;
      }
      catch (Exception localException3)
      {
        break label973;
      }
      try
      {
        if (localJSONObject.has("SETTOKEN"))
        {
          localObject2 = localObject3;
          localObject1 = localJSONObject.getString("SETTOKEN");
        }
        localObject2 = localObject1;
        if (localJSONObject.has("ENABLE_LOAD_RENAME_FILE_LOCK"))
        {
          localObject2 = localObject1;
          i2 = localJSONObject.getInt("ENABLE_LOAD_RENAME_FILE_LOCK");
          if (i2 != 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
        else
        {
          bool1 = true;
        }
      }
      catch (Exception localException4)
      {
        str1 = paramString;
        paramString = (String)localObject2;
        break label1015;
      }
      try
      {
        if (localJSONObject.has("ENABLE_LOAD_RENAME_FILE_LOCK_WAIT"))
        {
          i2 = localJSONObject.getInt("ENABLE_LOAD_RENAME_FILE_LOCK_WAIT");
          if (i2 == 0)
          {
            bool2 = false;
            break label970;
          }
        }
        bool2 = true;
      }
      catch (Exception localException7)
      {
        str2 = paramString;
        paramString = str1;
        break label1022;
      }
      localObject2 = "";
      m = 0;
      localObject1 = paramString;
      paramString = (String)localObject2;
      break label1015;
      localObject1 = paramString;
      break label1006;
      break label1000;
      paramString = null;
      n = 0;
      localObject1 = paramString;
      paramString = "";
      m = 0;
      i1 = 0;
      bool1 = true;
      localObject2 = localObject1;
      localObject1 = paramString;
      bool2 = true;
      paramString = (String)localObject2;
      try
      {
        i3 = localJSONObject.getInt("RESETDECOUPLECORE");
      }
      catch (Exception localException8)
      {
        int i3;
        break label1044;
      }
      i3 = 0;
      try
      {
        i2 = localJSONObject.getInt("RESETTODECOUPLECORE");
      }
      catch (Exception localException9)
      {
        break label1060;
      }
      i2 = 0;
      localObject2 = f;
      if (m == 0) {
        break label3287;
      }
      for (;;)
      {
        try
        {
          localTbsDownloadConfig.mSyncMap.put("tbs_deskey_token", "");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).length() == 96))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append("&");
            ((StringBuilder)localObject3).append(g.c());
            localObject1 = ((StringBuilder)localObject3).toString();
            localTbsDownloadConfig.mSyncMap.put("tbs_deskey_token", localObject1);
          }
          if (n == 1)
          {
            if (paramBoolean1) {
              paramInt = -110;
            } else {
              paramInt = -210;
            }
            localTbsDownloadConfig.setDownloadInterruptCode(paramInt);
            paramString = c;
            if (i2 == 1) {
              paramBoolean2 = true;
            } else {
              paramBoolean2 = false;
            }
            QbSdk.reset(paramString, paramBoolean2);
            paramString = new StringBuilder();
            paramString.append("[TbsDownloader.readResponse] return #3,needResetTbs=1,isQuery=");
            paramString.append(paramBoolean1);
            TbsLog.i("TbsDownload", paramString.toString());
            return false;
          }
          if (!bool1) {
            localTbsDownloadConfig.setTbsCoreLoadRenameFileLockEnable(bool1);
          }
          if (!bool2) {
            localTbsDownloadConfig.setTbsCoreLoadRenameFileLockWaitEnable(bool2);
          }
          if (i3 == 1) {
            QbSdk.resetDecoupleCore(c);
          }
          if (i1 == 1)
          {
            d.removeMessages(104);
            Message.obtain(d, 104).sendToTarget();
          }
          if (i10 == 1)
          {
            long l2 = 604800L;
            if (l1 > 604800L) {
              l1 = l2;
            }
            if (l1 > 0L) {}
          }
          else
          {
            l1 = 86400L;
          }
          if (getRetryIntervalInSeconds() >= 0L) {
            l1 = getRetryIntervalInSeconds();
          }
          localTbsDownloadConfig.mSyncMap.put("retry_interval", Long.valueOf(l1));
          if (!paramBoolean1) {}
        }
        finally
        {
          continue;
          throw paramString;
          continue;
        }
        try
        {
          m = localJSONObject.getInt("DECOUPLECOREVERSION");
        }
        catch (Exception localException5)
        {
          continue;
        }
        m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
        break label3290;
        m = 0;
        try
        {
          n = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_downloaddecouplecore", 0);
        }
        catch (Exception localException6)
        {
          continue;
        }
        n = 0;
        i1 = m;
        if (paramBoolean1)
        {
          i1 = m;
          if (!TbsShareManager.isThirdPartyApp(c))
          {
            i1 = m;
            if (m == 0) {
              i1 = p.a().h(c);
            }
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("in response decoupleCoreVersion is ");
        ((StringBuilder)localObject1).append(i1);
        TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
        localTbsDownloadConfig.mSyncMap.put("tbs_decouplecoreversion", Integer.valueOf(i1));
        localTbsDownloadConfig.mSyncMap.put("tbs_downloaddecouplecore", Integer.valueOf(n));
        if (!TbsShareManager.isThirdPartyApp(c)) {
          if ((i1 > 0) && (i1 != p.a().h(c)) && (i1 == p.a().i(c))) {
            p.a().n(c);
          } else if (i1 != 0) {}
        }
        try
        {
          FileUtil.b(p.a().p(c));
        }
        catch (Throwable localThrowable)
        {
          String str1;
          String str2;
          continue;
        }
        if ((TextUtils.isEmpty(str3)) && (TbsShareManager.isThirdPartyApp(c)))
        {
          localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", localBoolean);
          localTbsDownloadConfig.commit();
          if (paramBoolean1) {
            TbsShareManager.writeCoreInfoForThirdPartyApp(c, i5, false);
          }
          TbsLog.i("TbsDownload", "[TbsDownloader.readResponse] return #4,current app is third app...");
          return false;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("in response responseCode is ");
        ((StringBuilder)localObject1).append(i4);
        TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
        if (i4 == 0)
        {
          localTbsDownloadConfig.mSyncMap.put("tbs_responsecode", Integer.valueOf(i4));
          localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", localBoolean);
          if (paramBoolean1)
          {
            localTbsDownloadConfig.mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-111));
          }
          else
          {
            localTbsDownloadConfig.mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-211));
            localTbsDownloadConfig.setDownloadInterruptCode(-211);
          }
          localTbsDownloadConfig.commit();
          if (!TbsShareManager.isThirdPartyApp(c)) {
            startDecoupleCoreIfNeeded();
          }
          TbsLog.i("TbsDownload", "[TbsDownloader.readResponse] return #5,responseCode=0");
          return false;
        }
        i2 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
        if (i2 > i5)
        {
          g.c();
          p.a().o(c);
        }
        if (!TbsShareManager.isThirdPartyApp(c))
        {
          i1 = p.a().e(c, 0);
          if (i1 >= i5) {
            m = 1;
          } else {
            m = 0;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("tmpCoreVersion is ");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append(" tbsDownloadVersion is");
          ((StringBuilder)localObject1).append(i5);
          TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
        }
        else
        {
          m = 0;
        }
        i1 = paramInt;
        if (((i1 < i5) && (!TextUtils.isEmpty(str3)) && (m == 0)) || (n == 1)) {
          continue;
        }
        localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", localBoolean);
        if (paramBoolean1)
        {
          if (TextUtils.isEmpty(str3))
          {
            paramString = localTbsDownloadConfig.mSyncMap;
            paramInt = -124;
            paramString.put("tbs_download_interrupt_code_reason", Integer.valueOf(paramInt));
          }
          else
          {
            if (i5 <= 0)
            {
              paramString = localTbsDownloadConfig.mSyncMap;
              paramInt = -125;
              continue;
            }
            if (i1 >= i5)
            {
              paramString = localTbsDownloadConfig.mSyncMap;
              paramInt = -127;
              continue;
            }
            paramString = localTbsDownloadConfig.mSyncMap;
            paramInt = -112;
            continue;
          }
        }
        else
        {
          paramInt = -212;
          if (TextUtils.isEmpty(str3)) {
            paramInt = -217;
          } else if (i5 <= 0) {
            paramInt = -218;
          } else if (i1 >= i5) {
            paramInt = -219;
          }
          localTbsDownloadConfig.mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(paramInt));
          localTbsDownloadConfig.setDownloadInterruptCode(paramInt);
        }
        localTbsDownloadConfig.commit();
        paramString = new StringBuilder();
        paramString.append("version error or downloadUrl empty ,return ahead tbsLocalVersion=");
        paramString.append(i1);
        paramString.append(" tbsDownloadVersion=");
        paramString.append(i5);
        paramString.append(" tbsLastDownloadVersion=");
        paramString.append(i2);
        paramString.append(" downloadUrl=");
        paramString.append(str3);
      }
      if (!str3.equals(localTbsDownloadConfig.mPreferences.getString("tbs_downloadurl", null)))
      {
        g.c();
        localObject2 = localTbsDownloadConfig.mSyncMap;
        localObject1 = localInteger;
        ((Map)localObject2).put("tbs_download_failed_retrytimes", localObject1);
        localTbsDownloadConfig.mSyncMap.put("tbs_download_success_retrytimes", localObject1);
      }
      localTbsDownloadConfig.mSyncMap.put("tbs_download_version", Integer.valueOf(i5));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("put KEY_TBS_DOWNLOAD_V is ");
      ((StringBuilder)localObject1).append(i5);
      TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
      if (i5 > 0)
      {
        if (n == 1) {
          localTbsDownloadConfig.mSyncMap.put("tbs_download_version_type", Integer.valueOf(1));
        } else {
          localTbsDownloadConfig.mSyncMap.put("tbs_download_version_type", localInteger);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("put KEY_TBS_DOWNLOAD_V_TYPE is ");
        ((StringBuilder)localObject1).append(n);
        TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
      }
      localTbsDownloadConfig.mSyncMap.put("tbs_downloadurl", str3);
      localTbsDownloadConfig.mSyncMap.put("tbs_downloadurl_list", str4);
      localTbsDownloadConfig.mSyncMap.put("tbs_responsecode", Integer.valueOf(i4));
      localTbsDownloadConfig.mSyncMap.put("tbs_download_maxflow", Integer.valueOf(i6));
      localTbsDownloadConfig.mSyncMap.put("tbs_download_min_free_space", Integer.valueOf(i7));
      localTbsDownloadConfig.mSyncMap.put("tbs_download_success_max_retrytimes", Integer.valueOf(i8));
      localTbsDownloadConfig.mSyncMap.put("tbs_download_failed_max_retrytimes", Integer.valueOf(i9));
      localTbsDownloadConfig.mSyncMap.put("tbs_single_timeout", Long.valueOf(l3));
      localTbsDownloadConfig.mSyncMap.put("tbs_apkfilesize", Long.valueOf(l4));
      localTbsDownloadConfig.commit();
      if (paramString != null) {
        localTbsDownloadConfig.mSyncMap.put("tbs_apk_md5", paramString);
      }
      if ((!paramBoolean2) && (paramBoolean3) && (p.a().b(c, i5)))
      {
        if (paramBoolean1)
        {
          localTbsDownloadConfig.mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-113));
        }
        else
        {
          localTbsDownloadConfig.mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-213));
          localTbsDownloadConfig.setDownloadInterruptCode(-213);
        }
        localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", localBoolean);
        paramString = "[TbsDownloader.readResponse] ##6 set needDownload=false";
      }
      for (;;)
      {
        TbsLog.i("TbsDownload", paramString);
        break label3143;
        if ((!paramBoolean2) && (paramBoolean3))
        {
          paramString = g;
          if ((i4 != 1) && (i4 != 2)) {
            paramBoolean3 = false;
          } else {
            paramBoolean3 = true;
          }
          if (paramString.a(paramBoolean2, paramBoolean3))
          {
            localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", localBoolean);
            localObject2 = TbsLogReport.getInstance(c).tbsLogInfo();
            ((TbsLogReport.TbsLogInfo)localObject2).setErrorCode(100);
            paramString = new StringBuilder();
            paramString.append("use local backup apk in needDownload");
            paramString.append(g.a);
            ((TbsLogReport.TbsLogInfo)localObject2).setFailDetail(paramString.toString());
            if (a(c))
            {
              paramString = TbsLogReport.getInstance(c);
              localObject1 = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
            }
            else
            {
              paramString = TbsLogReport.getInstance(c);
              localObject1 = TbsLogReport.EventType.TYPE_DOWNLOAD;
            }
            paramString.eventReport((TbsLogReport.EventType)localObject1, (TbsLogReport.TbsLogInfo)localObject2);
            paramString = "[TbsDownloader.readResponse] ##7 set needDownload=false";
            continue;
          }
        }
        if ((TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0) != 1) || (!g.a())) {
          break;
        }
        localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", localBoolean);
        localObject2 = TbsLogReport.getInstance(c).tbsLogInfo();
        ((TbsLogReport.TbsLogInfo)localObject2).setErrorCode(100);
        paramString = new StringBuilder();
        paramString.append("installDecoupleCoreFromBackup");
        paramString.append(g.a);
        ((TbsLogReport.TbsLogInfo)localObject2).setFailDetail(paramString.toString());
        if (a(c))
        {
          paramString = TbsLogReport.getInstance(c);
          localObject1 = TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
        }
        else
        {
          paramString = TbsLogReport.getInstance(c);
          localObject1 = TbsLogReport.EventType.TYPE_DOWNLOAD;
        }
        paramString.eventReport((TbsLogReport.EventType)localObject1, (TbsLogReport.TbsLogInfo)localObject2);
        paramString = "[TbsDownloader.readResponse] ##8 set needDownload=false";
      }
      if (!paramBoolean1) {
        localTbsDownloadConfig.setDownloadInterruptCode(-216);
      }
      localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
      TbsLog.i("TbsDownload", "[TbsDownloader.readResponse] ##9 set needDownload=true");
      if (localJSONObject.optInt("stop_pre_oat", 0) == 1) {
        localTbsDownloadConfig.mSyncMap.put("tbs_stop_preoat", Boolean.valueOf(true));
      }
      localTbsDownloadConfig.commit();
      return true;
    }
  }
  
  protected static File b(int paramInt)
  {
    Object localObject2 = TbsShareManager.getCoreProviderAppList();
    int n = localObject2.length;
    Object localObject1 = null;
    int m = 0;
    while (m < n)
    {
      String str1 = localObject2[m];
      String str2 = FileUtil.a(c, str1, 4, false);
      if (getOverSea(c)) {
        localObject1 = "x5.oversea.tbs.org";
      } else {
        localObject1 = getBackupFileName(false);
      }
      localObject1 = new File(str2, (String)localObject1);
      if ((((File)localObject1).exists()) && (a.a(c, (File)localObject1) == paramInt)) {}
      for (localObject2 = new StringBuilder();; localObject2 = new StringBuilder())
      {
        ((StringBuilder)localObject2).append("local tbs version fond,path = ");
        ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
        TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
        return localObject1;
        localObject1 = new File(FileUtil.a(c, str1, 4, false), "x5.tbs.decouple");
        if ((!((File)localObject1).exists()) || (a.a(c, (File)localObject1) != paramInt)) {
          break;
        }
      }
      m += 1;
    }
    return localObject1;
  }
  
  static String b(Context paramContext)
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    Locale localLocale = Locale.getDefault();
    StringBuffer localStringBuffer = new StringBuffer();
    paramContext = Build.VERSION.RELEASE;
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException1)
    {
      String str;
      label49:
      break label49;
    }
    if (paramContext == null) {}
    while (paramContext.length() <= 0)
    {
      localStringBuffer.append("1.0");
      break;
    }
    localStringBuffer.append(paramContext);
    localStringBuffer.append("; ");
    paramContext = localLocale.getLanguage();
    if (paramContext != null)
    {
      localStringBuffer.append(paramContext.toLowerCase());
      paramContext = localLocale.getCountry();
      if (paramContext == null) {
        break label138;
      }
      localStringBuffer.append("-");
      paramContext = paramContext.toLowerCase();
    }
    else
    {
      paramContext = "en";
    }
    localStringBuffer.append(paramContext);
    label138:
    if ("REL".equals(Build.VERSION.CODENAME)) {
      paramContext = Build.MODEL;
    }
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException2)
    {
      label174:
      break label174;
    }
    if (paramContext == null)
    {
      localStringBuffer.append("; ");
    }
    else if (paramContext.length() > 0)
    {
      localStringBuffer.append("; ");
      localStringBuffer.append(paramContext);
    }
    if (Build.ID == null) {
      paramContext = "";
    } else {
      paramContext = Build.ID;
    }
    paramContext = paramContext.replaceAll("[一-龥]", "");
    if (paramContext == null)
    {
      localStringBuffer.append(" Build/");
      paramContext = "00";
    }
    for (;;)
    {
      localStringBuffer.append(paramContext);
      break;
      if (paramContext.length() <= 0) {
        break;
      }
      localStringBuffer.append(" Build/");
    }
    paramContext = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[] { localStringBuffer });
    b = paramContext;
    return paramContext;
  }
  
  private static void b(JSONArray paramJSONArray)
  {
    if (TbsShareManager.getHostCorePathAppDefined() != null)
    {
      int i2 = p.a().a(TbsShareManager.getHostCorePathAppDefined());
      int i1 = 0;
      int m = 0;
      int n;
      for (;;)
      {
        n = i1;
        if (m >= paramJSONArray.length()) {
          break;
        }
        if (paramJSONArray.optInt(m) == i2)
        {
          n = 1;
          break;
        }
        m += 1;
      }
      if (n == 0) {
        paramJSONArray.put(i2);
      }
    }
  }
  
  private static boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramBoolean1)
    {
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(144));
    }
    for (;;)
    {
      ((TbsDownloadUpload)localObject1).commit();
      break;
      if (paramBoolean3) {
        break;
      }
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(164));
    }
    if ((QbSdk.n != null) && (QbSdk.n.containsKey("SET_SENDREQUEST_AND_UPLOAD")) && (QbSdk.n.get("SET_SENDREQUEST_AND_UPLOAD").equals("false")))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
      if (paramBoolean1)
      {
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(145));
      }
      for (;;)
      {
        ((TbsDownloadUpload)localObject1).commit();
        return false;
        if (paramBoolean3) {
          break;
        }
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(165));
      }
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[TbsDownloader.sendRequest]isQuery: ");
    ((StringBuilder)localObject1).append(paramBoolean1);
    ((StringBuilder)localObject1).append(" forDecoupleCore is ");
    ((StringBuilder)localObject1).append(paramBoolean3);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
    if (p.a().c(c))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
      if (paramBoolean1)
      {
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(146));
      }
      for (;;)
      {
        ((TbsDownloadUpload)localObject1).commit();
        return false;
        if (paramBoolean3) {
          break;
        }
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(166));
      }
      return false;
    }
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    Object localObject3 = FileUtil.a(c, 1);
    boolean bool = getOverSea(c);
    Object localObject2 = "x5.oversea.tbs.org";
    if (bool) {
      localObject1 = "x5.oversea.tbs.org";
    } else {
      localObject1 = getBackupFileName(false);
    }
    localObject3 = new File((String)localObject3, (String)localObject1);
    Object localObject4 = FileUtil.a(c, 2);
    if (getOverSea(c)) {
      localObject1 = "x5.oversea.tbs.org";
    } else {
      localObject1 = getBackupFileName(false);
    }
    localObject4 = new File((String)localObject4, (String)localObject1);
    Object localObject5 = FileUtil.a(c, 3);
    if (getOverSea(c)) {
      localObject1 = "x5.oversea.tbs.org";
    } else {
      localObject1 = getBackupFileName(false);
    }
    localObject5 = new File((String)localObject5, (String)localObject1);
    String str = FileUtil.a(c, 4);
    if (getOverSea(c)) {
      localObject1 = localObject2;
    } else {
      localObject1 = getBackupFileName(false);
    }
    localObject1 = new File(str, (String)localObject1);
    if (!((File)localObject1).exists()) {
      if (((File)localObject5).exists()) {
        ((File)localObject5).renameTo((File)localObject1);
      } else if (((File)localObject4).exists()) {
        ((File)localObject4).renameTo((File)localObject1);
      } else if (((File)localObject3).exists()) {
        ((File)localObject3).renameTo((File)localObject1);
      }
    }
    if (e == null)
    {
      e = b.b();
      localTbsDownloadConfig.mSyncMap.put("device_cpuabi", e);
      localTbsDownloadConfig.commit();
    }
    if (!TextUtils.isEmpty(e)) {
      localObject1 = null;
    }
    try
    {
      localObject2 = Pattern.compile("i686|mips|x86_64").matcher(e);
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      label663:
      int m;
      break label663;
    }
    if ((localObject1 != null) && (((Matcher)localObject1).find()))
    {
      if (TbsShareManager.isThirdPartyApp(c))
      {
        TbsLog.e("TbsDownload", "don't support x86 devices,skip send request");
        localObject1 = TbsLogReport.getInstance(c).tbsLogInfo();
        if (paramBoolean1)
        {
          localTbsDownloadConfig.setDownloadInterruptCode(-104);
          ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-104);
        }
        else
        {
          localTbsDownloadConfig.setDownloadInterruptCode(-205);
          ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-205);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mycpu is ");
        ((StringBuilder)localObject2).append(e);
        ((TbsLogReport.TbsLogInfo)localObject1).setFailDetail(((StringBuilder)localObject2).toString());
        TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject1);
      }
      else if (paramBoolean1)
      {
        localTbsDownloadConfig.setDownloadInterruptCode(-104);
      }
      else
      {
        localTbsDownloadConfig.setDownloadInterruptCode(-205);
      }
      m = 1;
    }
    else
    {
      m = 0;
    }
    localTbsDownloadConfig.mSyncMap.put("app_versionname", b.c(c));
    localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(b.d(c)));
    localTbsDownloadConfig.commit();
    localObject3 = a(paramBoolean1, paramBoolean2, paramBoolean3);
    try
    {
      n = ((JSONObject)localObject3).getInt("TBSV");
    }
    catch (Exception localException1)
    {
      int n;
      label895:
      break label895;
    }
    n = -1;
    if ((m == 0) && (n == -1)) {}
    for (;;)
    {
      break;
      long l2 = System.currentTimeMillis();
      if (TbsShareManager.isThirdPartyApp(c))
      {
        long l1 = localTbsDownloadConfig.mPreferences.getLong("request_fail", 0L);
        long l3 = localTbsDownloadConfig.mPreferences.getLong("count_request_fail_in_24hours", 0L);
        if (l2 - l1 < localTbsDownloadConfig.getRetryInterval() * 1000L) {
          l1 = l3 + 1L;
        } else {
          l1 = 1L;
        }
        localTbsDownloadConfig.mSyncMap.put("count_request_fail_in_24hours", Long.valueOf(l1));
      }
      localTbsDownloadConfig.mSyncMap.put("request_fail", Long.valueOf(l2));
      localTbsDownloadConfig.mSyncMap.put("app_versionname", b.c(c));
      localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(b.d(c)));
      localTbsDownloadConfig.mSyncMap.put("app_metadata", b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
      localTbsDownloadConfig.commit();
      if (m != 0)
      {
        if (paramBoolean1)
        {
          localObject1 = TbsDownloadUpload.getInstance(c);
          ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(147));
        }
        for (;;)
        {
          ((TbsDownloadUpload)localObject1).commit();
          break;
          if (paramBoolean3) {
            break;
          }
          localObject1 = TbsDownloadUpload.getInstance(c);
          ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(167));
        }
        return false;
      }
    }
    if ((n == -1) && (!paramBoolean3))
    {
      if (paramBoolean1)
      {
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(149));
      }
      for (;;)
      {
        ((TbsDownloadUpload)localObject1).commit();
        break;
        if (paramBoolean3) {
          break;
        }
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(169));
      }
      return false;
    }
    try
    {
      localObject2 = com.tencent.smtt.utils.m.a(c).d();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[TbsDownloader.sendRequest] postUrl=");
      ((StringBuilder)localObject1).append((String)localObject2);
      TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
      if (paramBoolean1)
      {
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(148));
        ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_sent", Integer.valueOf(1));
        ((TbsDownloadUpload)localObject1).commit();
      }
      for (localObject1 = "sendRequest query 148";; localObject1 = "sendRequest download 168")
      {
        TbsLog.i("TbsDownload", (String)localObject1);
        break;
        if (paramBoolean3) {
          break;
        }
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(168));
        ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_sent", Integer.valueOf(1));
        ((TbsDownloadUpload)localObject1).commit();
      }
      localObject1 = ((JSONObject)localObject3).toString().getBytes("utf-8");
      localObject3 = new TbsDownloader.3(localTbsDownloadConfig, paramBoolean1);
      try
      {
        paramBoolean2 = a(f.a((String)localObject2, (byte[])localObject1, (f.a)localObject3, false), n, paramBoolean1, paramBoolean2, paramBoolean4);
        return paramBoolean2;
      }
      catch (Throwable localThrowable1) {}
      localThrowable2.printStackTrace();
    }
    catch (Throwable localThrowable2) {}
    if (paramBoolean1) {
      m = -106;
    } else {
      m = -206;
    }
    localTbsDownloadConfig.setDownloadInterruptCode(m);
    return false;
  }
  
  private static void c()
  {
    label47:
    try
    {
      if (h == null) {
        h = n.a();
      }
    }
    finally {}
    try
    {
      g = new l(c);
      d = new TbsDownloader.2(h.getLooper());
    }
    catch (Exception localException)
    {
      break label47;
    }
    i = true;
    TbsLog.e("TbsDownload", "TbsApkDownloader init has Exception");
    return;
  }
  
  @TargetApi(11)
  static void c(Context paramContext)
  {
    TbsDownloadConfig.getInstance(paramContext).clear();
    TbsLogReport.getInstance(paramContext).clear();
    l.c(paramContext);
    SharedPreferences localSharedPreferences;
    if (Build.VERSION.SDK_INT >= 11) {
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 4);
    } else {
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 0);
    }
    localSharedPreferences.edit().clear().commit();
    if (Build.VERSION.SDK_INT >= 11) {
      paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
    } else {
      paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
    }
    paramContext.edit().clear().commit();
  }
  
  private static void c(JSONArray paramJSONArray)
  {
    if (!TbsPVConfig.getInstance(c).isDisableHostBackupCore())
    {
      String[] arrayOfString = e();
      int i2 = arrayOfString.length;
      int m = 0;
      while (m < i2)
      {
        String str = arrayOfString[m];
        int i3 = TbsShareManager.getBackupCoreVersion(c, str);
        int i1 = 1;
        if (i3 > 0)
        {
          localObject = TbsShareManager.getPackageContext(c, str, false);
          if ((localObject == null) || (p.a().f((Context)localObject))) {}
        }
        for (Object localObject = new StringBuilder();; localObject = new StringBuilder())
        {
          ((StringBuilder)localObject).append("host check failed,packageName = ");
          ((StringBuilder)localObject).append(str);
          TbsLog.e("TbsDownload", ((StringBuilder)localObject).toString());
          break label322;
          if (a(c, i3))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("add addBackupVersionToJsonData,version+");
            ((StringBuilder)localObject).append(i3);
            ((StringBuilder)localObject).append(" is in black list");
            TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
            break label322;
          }
          n = 0;
          while (n < paramJSONArray.length())
          {
            if (paramJSONArray.optInt(n) == i3)
            {
              n = 1;
              break label212;
            }
            n += 1;
          }
          n = 0;
          label212:
          if (n == 0) {
            paramJSONArray.put(i3);
          }
          i3 = TbsShareManager.getBackupDecoupleCoreVersion(c, str);
          if (i3 <= 0) {
            break label322;
          }
          localObject = TbsShareManager.getPackageContext(c, str, false);
          if ((localObject == null) || (p.a().f((Context)localObject))) {
            break;
          }
        }
        int n = 0;
        while (n < paramJSONArray.length())
        {
          if (paramJSONArray.optInt(n) == i3)
          {
            n = i1;
            break label311;
          }
          n += 1;
        }
        n = 0;
        label311:
        if (n == 0) {
          paramJSONArray.put(i3);
        }
        label322:
        m += 1;
      }
    }
  }
  
  private static boolean d()
  {
    try
    {
      JSONArray localJSONArray = f();
      boolean bool = TbsDownloadConfig.getInstance(c).mPreferences.getString("last_thirdapp_sendrequest_coreversion", "").equals(localJSONArray.toString());
      return bool;
    }
    catch (Exception localException)
    {
      label33:
      break label33;
    }
    return false;
  }
  
  private static String[] e()
  {
    if (QbSdk.getOnlyDownload()) {
      return new String[] { c.getApplicationContext().getPackageName() };
    }
    String[] arrayOfString2 = TbsShareManager.getCoreProviderAppList();
    String str = c.getApplicationContext().getPackageName();
    String[] arrayOfString1 = arrayOfString2;
    if (str.equals(TbsShareManager.f(c)))
    {
      int m = arrayOfString2.length;
      arrayOfString1 = new String[m + 1];
      System.arraycopy(arrayOfString2, 0, arrayOfString1, 0, m);
      arrayOfString1[m] = str;
    }
    return arrayOfString1;
  }
  
  private static JSONArray f()
  {
    if (TbsShareManager.isThirdPartyApp(c))
    {
      JSONArray localJSONArray = new JSONArray();
      a(localJSONArray);
      c(localJSONArray);
      b(localJSONArray);
      return localJSONArray;
    }
    return null;
  }
  
  private static boolean g()
  {
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    int m;
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_success_retrytimes", 0) >= localTbsDownloadConfig.getDownloadSuccessMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
      m = -115;
    }
    for (;;)
    {
      localTbsDownloadConfig.setDownloadInterruptCode(m);
      return false;
      if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_failed_retrytimes", 0) >= localTbsDownloadConfig.getDownloadFailedMaxRetrytimes())
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
        m = -116;
      }
      else if (!FileUtil.b(c))
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
        m = -117;
      }
      else
      {
        if (System.currentTimeMillis() - localTbsDownloadConfig.mPreferences.getLong("tbs_downloadstarttime", 0L) > 86400000L) {
          break;
        }
        long l1 = localTbsDownloadConfig.mPreferences.getLong("tbs_downloadflow", 0L);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[TbsDownloader.needStartDownload] downloadFlow=");
        localStringBuilder.append(l1);
        TbsLog.i("TbsDownload", localStringBuilder.toString());
        if (l1 < localTbsDownloadConfig.getDownloadMaxflow()) {
          break;
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
        m = -120;
      }
    }
    return true;
  }
  
  public static String getBackupFileName(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (b.d()) {
        return "x5.tbs.decouple.64";
      }
      return "x5.tbs.decouple";
    }
    if (b.d()) {
      return "x5.tbs.org.64";
    }
    return "x5.tbs.org";
  }
  
  public static int getCoreShareDecoupleCoreVersion()
  {
    return p.a().h(c);
  }
  
  public static int getCoreShareDecoupleCoreVersionByContext(Context paramContext)
  {
    return p.a().h(paramContext);
  }
  
  public static boolean getOverSea(Context paramContext)
  {
    try
    {
      if (!k)
      {
        k = true;
        paramContext = TbsDownloadConfig.getInstance(paramContext);
        if (paramContext.mPreferences.contains("is_oversea"))
        {
          j = paramContext.mPreferences.getBoolean("is_oversea", false);
          paramContext = new StringBuilder();
          paramContext.append("[TbsDownloader.getOverSea]  first called. sOverSea = ");
          paramContext.append(j);
          TbsLog.i("TbsDownload", paramContext.toString());
        }
        paramContext = new StringBuilder();
        paramContext.append("[TbsDownloader.getOverSea]  sOverSea = ");
        paramContext.append(j);
        TbsLog.i("TbsDownload", paramContext.toString());
      }
      boolean bool = j;
      return bool;
    }
    finally {}
  }
  
  public static long getRetryIntervalInSeconds()
  {
    return l;
  }
  
  public static HandlerThread getsTbsHandlerThread()
  {
    return h;
  }
  
  public static boolean isDownloadForeground()
  {
    l locall = g;
    return (locall != null) && (locall.d());
  }
  
  public static boolean isDownloading()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TbsDownloader.isDownloading] is ");
      localStringBuilder.append(a);
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      boolean bool = a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean)
  {
    return needDownload(paramContext, paramBoolean, false, true, null);
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, TbsDownloader.TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    return needDownload(paramContext, paramBoolean1, paramBoolean2, true, paramTbsDownloaderCallback);
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TbsDownloader.TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("needDownload,process=");
    ((StringBuilder)localObject1).append(QbSdk.getCurrentProcessName(paramContext));
    ((StringBuilder)localObject1).append("stack=");
    ((StringBuilder)localObject1).append(Log.getStackTraceString(new Throwable()));
    TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
    TbsDownloadUpload.clear();
    localObject1 = TbsDownloadUpload.getInstance(paramContext);
    ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(140));
    ((TbsDownloadUpload)localObject1).commit();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[TbsDownloader.needDownload] oversea=");
    ((StringBuilder)localObject2).append(paramBoolean1);
    ((StringBuilder)localObject2).append(",isDownloadForeground=");
    ((StringBuilder)localObject2).append(paramBoolean2);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
    TbsLog.initIfNeed(paramContext);
    if (p.b)
    {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      paramContext = new StringBuilder();
      paramContext.append("[TbsDownloader.needDownload]#1,return ");
      paramContext.append(false);
      TbsLog.i("TbsDownload", paramContext.toString());
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_return", Integer.valueOf(171));
      ((TbsDownloadUpload)localObject1).commit();
      return false;
    }
    TbsLog.app_extra("TbsDownload", paramContext);
    c = paramContext.getApplicationContext();
    localObject2 = TbsDownloadConfig.getInstance(c);
    ((TbsDownloadConfig)localObject2).setDownloadInterruptCode(-100);
    if (!a(c, paramBoolean1))
    {
      paramContext = new StringBuilder();
      paramContext.append("[TbsDownloader.needDownload]#2,return ");
      paramContext.append(false);
      TbsLog.i("TbsDownload", paramContext.toString());
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(141));
      ((TbsDownloadUpload)localObject1).commit();
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_return", Integer.valueOf(172));
      ((TbsDownloadUpload)localObject1).commit();
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      return false;
    }
    c();
    if (i)
    {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      ((TbsDownloadConfig)localObject2).setDownloadInterruptCode(-105);
      paramContext = new StringBuilder();
      paramContext.append("[TbsDownloader.needDownload]#3,return ");
      paramContext.append(false);
      TbsLog.i("TbsDownload", paramContext.toString());
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(142));
      ((TbsDownloadUpload)localObject1).commit();
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_return", Integer.valueOf(173));
      ((TbsDownloadUpload)localObject1).commit();
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      return false;
    }
    boolean bool = a(c, paramBoolean2, false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[TbsDownloader.needDownload],needSendRequest=");
    localStringBuilder.append(bool);
    TbsLog.i("TbsDownload", localStringBuilder.toString());
    if (bool)
    {
      a(paramBoolean2, paramTbsDownloaderCallback, paramBoolean3);
      ((TbsDownloadConfig)localObject2).setDownloadInterruptCode(-114);
    }
    else
    {
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(143));
      ((TbsDownloadUpload)localObject1).commit();
    }
    d.removeMessages(102);
    Message.obtain(d, 102).sendToTarget();
    if ((!QbSdk.c) && (TbsShareManager.isThirdPartyApp(paramContext)))
    {
      paramBoolean1 = false;
      paramBoolean2 = false;
    }
    else
    {
      paramBoolean2 = ((TbsDownloadConfig)localObject2).mPreferences.contains("tbs_needdownload");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TbsDownloader.needDownload] hasNeedDownloadKey=");
      localStringBuilder.append(paramBoolean2);
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      if ((!paramBoolean2) && (!TbsShareManager.isThirdPartyApp(paramContext))) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = ((TbsDownloadConfig)localObject2).mPreferences.getBoolean("tbs_needdownload", false);
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("[TbsDownloader.needDownload]#4,needDownload=");
    paramContext.append(paramBoolean1);
    paramContext.append(",hasNeedDownloadKey=");
    paramContext.append(paramBoolean2);
    TbsLog.i("TbsDownload", paramContext.toString());
    int m;
    if (paramBoolean1)
    {
      if (!g())
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#5,set needDownload = false");
        paramBoolean1 = false;
      }
      else
      {
        ((TbsDownloadConfig)localObject2).setDownloadInterruptCode(-118);
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#6");
      }
    }
    else
    {
      m = p.a().m(c);
      paramContext = new StringBuilder();
      paramContext.append("[TbsDownloader.needDownload]#7,tbsLocalVersion=");
      paramContext.append(m);
      paramContext.append(",needSendRequest=");
      paramContext.append(bool);
      TbsLog.i("TbsDownload", paramContext.toString());
      if ((!bool) && (m > 0)) {}
      for (m = -119;; m = -121)
      {
        ((TbsDownloadConfig)localObject2).setDownloadInterruptCode(m);
        break;
        d.removeMessages(103);
        if ((m <= 0) && (!bool)) {
          paramContext = Message.obtain(d, 103, 0, 0, c);
        } else {
          paramContext = Message.obtain(d, 103, 1, 0, c);
        }
        paramContext.sendToTarget();
      }
    }
    if ((!bool) && (paramTbsDownloaderCallback != null)) {
      paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
    }
    paramContext = new StringBuilder();
    paramContext.append("[TbsDownloader.needDownload] needDownload=");
    paramContext.append(paramBoolean1);
    TbsLog.i("TbsDownload", paramContext.toString());
    paramContext = ((TbsDownloadUpload)localObject1).a;
    if (paramBoolean1) {
      m = 170;
    } else {
      m = 174;
    }
    paramContext.put("tbs_needdownload_return", Integer.valueOf(m));
    ((TbsDownloadUpload)localObject1).commit();
    return paramBoolean1;
  }
  
  public static boolean needDownloadDecoupleCore()
  {
    if (TbsShareManager.isThirdPartyApp(c)) {
      return false;
    }
    if (a(c)) {
      return false;
    }
    long l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
    if (System.currentTimeMillis() - l1 < TbsDownloadConfig.getInstance(c).getRetryInterval() * 1000L) {
      return false;
    }
    int m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    return (m > 0) && (m != p.a().h(c)) && (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) != m);
  }
  
  public static boolean needSendRequest(Context paramContext, boolean paramBoolean)
  {
    c = paramContext.getApplicationContext();
    TbsLog.initIfNeed(paramContext);
    if (!a(c, paramBoolean)) {
      return false;
    }
    int m = p.a().m(paramContext);
    paramContext = new StringBuilder();
    paramContext.append("[TbsDownloader.needSendRequest] localTbsVersion=");
    paramContext.append(m);
    TbsLog.i("TbsDownload", paramContext.toString());
    if (m > 0) {
      return false;
    }
    paramContext = c;
    boolean bool = true;
    if (a(paramContext, false, true)) {
      return true;
    }
    paramContext = TbsDownloadConfig.getInstance(c);
    paramBoolean = paramContext.mPreferences.contains("tbs_needdownload");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[TbsDownloader.needSendRequest] hasNeedDownloadKey=");
    localStringBuilder.append(paramBoolean);
    TbsLog.i("TbsDownload", localStringBuilder.toString());
    if (!paramBoolean) {
      paramBoolean = true;
    } else {
      paramBoolean = paramContext.mPreferences.getBoolean("tbs_needdownload", false);
    }
    paramContext = new StringBuilder();
    paramContext.append("[TbsDownloader.needSendRequest] needDownload=");
    paramContext.append(paramBoolean);
    TbsLog.i("TbsDownload", paramContext.toString());
    if ((paramBoolean) && (g())) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    paramContext = new StringBuilder();
    paramContext.append("[TbsDownloader.needSendRequest] ret=");
    paramContext.append(paramBoolean);
    TbsLog.i("TbsDownload", paramContext.toString());
    return paramBoolean;
  }
  
  public static void pauseDownload()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("called pauseDownload,downloader=");
    ((StringBuilder)localObject).append(g);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
    localObject = g;
    if (localObject != null) {
      ((l)localObject).e();
    }
  }
  
  public static void resumeDownload()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("called resumeDownload,downloader=");
    ((StringBuilder)localObject).append(g);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
    localObject = d;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(109);
      d.sendEmptyMessage(109);
    }
  }
  
  public static void setAppContext(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getApplicationContext() != null)) {
      c = paramContext.getApplicationContext();
    }
  }
  
  public static void setRetryIntervalInSeconds(Context paramContext, long paramLong)
  {
    if (paramContext == null) {
      return;
    }
    if (paramContext.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
      l = paramLong;
    }
    paramContext = new StringBuilder();
    paramContext.append("mRetryIntervalInSeconds is ");
    paramContext.append(l);
    TbsLog.i("TbsDownload", paramContext.toString());
  }
  
  public static boolean startDecoupleCoreIfNeeded()
  {
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded ");
    if (TbsShareManager.isThirdPartyApp(c)) {
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #1");
    if (a(c)) {
      return false;
    }
    if (d == null) {
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #2");
    long l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
    if (System.currentTimeMillis() - l1 < TbsDownloadConfig.getInstance(c).getRetryInterval() * 1000L) {
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #3");
    int m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    Object localObject;
    if ((m > 0) && (m != p.a().h(c)))
    {
      if ((TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) == m) && (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0) != 1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is ");
        ((StringBuilder)localObject).append(TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0));
        ((StringBuilder)localObject).append(" deCoupleCoreVersion is ");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(" KEY_TBS_DOWNLOAD_V_TYPE is ");
        m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0);
      }
      else
      {
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #4");
        a = true;
        d.removeMessages(108);
        localObject = Message.obtain(d, 108, QbSdk.m);
        ((Message)localObject).arg1 = 0;
        ((Message)localObject).sendToTarget();
        TbsDownloadConfig.getInstance(c).mSyncMap.put("last_download_decouple_core", Long.valueOf(System.currentTimeMillis()));
        return true;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is ");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(" getTbsCoreShareDecoupleCoreVersion is ");
      m = p.a().h(c);
    }
    ((StringBuilder)localObject).append(m);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
    return false;
  }
  
  public static void startDownload(Context paramContext)
  {
    startDownload(paramContext, false);
  }
  
  public static void startDownload(Context paramContext, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        TbsDownloadUpload localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
        localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(160));
        localTbsDownloadUpload.commit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[TbsDownloader.startDownload] sAppContext=");
        localStringBuilder.append(c);
        TbsLog.i("TbsDownload", localStringBuilder.toString());
        if (p.b)
        {
          localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(161));
          localTbsDownloadUpload.commit();
          return;
        }
        m = 1;
        a = true;
        c = paramContext.getApplicationContext();
        TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-200);
        if (Build.VERSION.SDK_INT < 8)
        {
          QbSdk.m.onDownloadFinish(110);
          TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-201);
          localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(162));
          localTbsDownloadUpload.commit();
          return;
        }
        c();
        if (i)
        {
          QbSdk.m.onDownloadFinish(121);
          TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-202);
          localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(163));
          localTbsDownloadUpload.commit();
          return;
        }
        if (paramBoolean) {
          stopDownload();
        }
        d.removeMessages(101);
        d.removeMessages(100);
        paramContext = Message.obtain(d, 101, QbSdk.m);
        if (paramBoolean)
        {
          paramContext.arg1 = m;
          paramContext.sendToTarget();
          return;
        }
      }
      finally {}
      int m = 0;
    }
  }
  
  public static void stopDownload()
  {
    if (i) {
      return;
    }
    TbsLog.i("TbsDownload", "[TbsDownloader.stopDownload]");
    Object localObject = g;
    if (localObject != null) {
      ((l)localObject).b();
    }
    localObject = d;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(100);
      d.removeMessages(101);
      d.removeMessages(108);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader
 * JD-Core Version:    0.7.0.1
 */