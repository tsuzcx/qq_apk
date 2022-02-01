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
import com.tencent.smtt.utils.f.a;
import com.tencent.smtt.utils.g;
import com.tencent.smtt.utils.q;
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
  private static JSONObject l = null;
  private static long m = -1L;
  
  protected static File a(int paramInt)
  {
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int i1 = arrayOfString.length;
    Object localObject1 = null;
    int n = 0;
    while (n < i1)
    {
      Object localObject2 = arrayOfString[n];
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
      n += 1;
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
    int i2 = arrayOfString.length;
    int n = 0;
    while (n < i2)
    {
      Object localObject = arrayOfString[n];
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
          int i1 = 0;
          while (i1 < localJSONArray.length())
          {
            if (localJSONArray.optInt(i1) == l1)
            {
              i1 = 1;
              break label170;
            }
            i1 += 1;
          }
          i1 = 0;
          label170:
          if (i1 == 0) {
            localJSONArray.put(l1);
          }
        }
      }
      n += 1;
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
    String str2 = b(c);
    String str3 = b.i(c);
    String str4 = b.h(c);
    String str5 = b.k(c);
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
      n = m.a(c).c("tpatch_num");
      bool2 = false;
      if (n >= 5) {
        break label223;
      }
      if (!TbsShareManager.isThirdPartyApp(c)) {
        break label1368;
      }
      n = 2;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        boolean bool2;
        label223:
        label232:
        int i1;
        boolean bool3;
        label590:
        continue;
        int n = 1;
        continue;
        continue;
        if (n == 0)
        {
          i1 = 0;
        }
        else
        {
          i1 = 1;
          continue;
          String str1 = "B";
          continue;
          i1 = 0;
          continue;
          i1 = 0;
          continue;
          n = 1;
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
    ((JSONObject)localObject4).put("REQUEST_TPATCH", n);
    break label232;
    ((JSONObject)localObject4).put("REQUEST_TPATCH", 0);
    ((JSONObject)localObject4).put("TIMEZONEID", localObject3);
    ((JSONObject)localObject4).put("COUNTRYISO", localObject2);
    if (b.b())
    {
      ((JSONObject)localObject4).put("REQUEST_64", 1);
      ((JSONObject)localObject4).put("PROTOCOLVERSION", 1);
      if (TbsShareManager.isThirdPartyApp(c))
      {
        if (QbSdk.c) {
          n = TbsShareManager.a(c, false);
        } else {
          n = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
        }
      }
      else
      {
        if (paramBoolean3) {
          n = p.a().j(c);
        } else {
          n = p.a().n(c);
        }
        i1 = n;
        if (n == 0)
        {
          i1 = n;
          if (p.a().m(c))
          {
            n = -1;
            i1 = n;
            if ("com.tencent.mobileqq".equals(c.getApplicationInfo().packageName))
            {
              TbsDownloadUpload.clear();
              localObject2 = TbsDownloadUpload.getInstance(c);
              ((TbsDownloadUpload)localObject2).a.put("tbs_local_core_version", Integer.valueOf(-1));
              ((TbsDownloadUpload)localObject2).commit();
              TbsPVConfig.releaseInstance();
              i1 = n;
              if (TbsPVConfig.getInstance(c).getLocalCoreVersionMoreTimes() == 1) {
                i1 = p.a().j(c);
              }
            }
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[TbsDownloader.postJsonData] tbsLocalVersion=");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append(" isDownloadForeground=");
        ((StringBuilder)localObject2).append(paramBoolean2);
        TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
        n = i1;
        if (paramBoolean2)
        {
          bool3 = p.a().m(c);
          if (bool3) {
            n = i1;
          } else {
            n = 0;
          }
        }
      }
      if (!paramBoolean1) {
        break label1376;
      }
      ((JSONObject)localObject4).put("FUNCTION", 2);
      localObject2 = "A";
      break label590;
      ((JSONObject)localObject4).put("FUNCTION", i1);
      if (n != 0) {
        break label1392;
      }
      localObject2 = "C";
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("2");
      ((StringBuilder)localObject3).append((String)localObject2);
      q.a(((StringBuilder)localObject3).toString());
      if (TbsShareManager.isThirdPartyApp(c))
      {
        localObject2 = f();
        ((JSONObject)localObject4).put("TBSVLARR", localObject2);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("3is");
        ((StringBuilder)localObject3).append(((JSONArray)localObject2).toString());
        q.a(((StringBuilder)localObject3).toString());
        localTbsDownloadConfig.mSyncMap.put("last_thirdapp_sendrequest_coreversion", ((JSONArray)localObject2).toString());
        localTbsDownloadConfig.commit();
        if (QbSdk.c) {
          ((JSONObject)localObject4).put("THIRDREQ", 1);
        }
      }
      else
      {
        localObject2 = a(paramBoolean3);
        if ((Apn.getApnType(c) != 3) && (((JSONArray)localObject2).length() != 0) && (n == 0) && (paramBoolean1)) {
          ((JSONObject)localObject4).put("TBSBACKUPARR", localObject2);
        }
      }
      ((JSONObject)localObject4).put("APPN", c.getPackageName());
      ((JSONObject)localObject4).put("APPVN", a(localTbsDownloadConfig.mPreferences.getString("app_versionname", null)));
      ((JSONObject)localObject4).put("APPVC", localTbsDownloadConfig.mPreferences.getInt("app_versioncode", 0));
      ((JSONObject)localObject4).put("APPMETA", a(localTbsDownloadConfig.mPreferences.getString("app_metadata", null)));
      ((JSONObject)localObject4).put("TBSSDKV", 44069);
      ((JSONObject)localObject4).put("TBSV", n);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("4is");
      ((StringBuilder)localObject2).append(n);
      q.a(((StringBuilder)localObject2).toString());
      if (!paramBoolean3) {
        break label1400;
      }
      i1 = 1;
      ((JSONObject)localObject4).put("DOWNLOADDECOUPLECORE", i1);
      localObject2 = localTbsDownloadConfig.mSyncMap;
      if (!paramBoolean3) {
        break label1406;
      }
      i1 = 1;
      ((Map)localObject2).put("tbs_downloaddecouplecore", Integer.valueOf(i1));
      localTbsDownloadConfig.commit();
      if (n != 0) {
        ((JSONObject)localObject4).put("TBSBACKUPV", g.c(paramBoolean3));
      }
      ((JSONObject)localObject4).put("CPU", e);
      ((JSONObject)localObject4).put("UA", str2);
      ((JSONObject)localObject4).put("IMSI", a(str3));
      ((JSONObject)localObject4).put("IMEI", a(str4));
      ((JSONObject)localObject4).put("ANDROID_ID", a(str5));
      ((JSONObject)localObject4).put("GUID", b.f(c));
      paramBoolean1 = TbsShareManager.isThirdPartyApp(c);
      if (!paramBoolean1)
      {
        if (n != 0)
        {
          if (!QbSdk.a(c, n)) {
            break label1412;
          }
          n = 0;
          ((JSONObject)localObject4).put("STATUS", n);
        }
        else
        {
          ((JSONObject)localObject4).put("STATUS", 0);
        }
        if (q.b(c)) {
          n = TbsShareManager.getTbsStableCoreVersion(c, 0);
        } else {
          n = p.a().i(c);
        }
        ((JSONObject)localObject4).put("TBSDV", n);
      }
      paramBoolean3 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean("request_full_package", false);
      if (!QbSdk.isEnableSensitiveApi()) {
        break label1417;
      }
      localObject2 = QbSdk.a(c, "can_unlzma", null);
      if ((localObject2 == null) || (!(localObject2 instanceof Boolean))) {
        break label1417;
      }
      paramBoolean1 = ((Boolean)localObject2).booleanValue();
      break label1419;
      if (n != 0) {
        ((JSONObject)localObject4).put("REQUEST_LZMA", 1);
      }
      if (!getOverSea(c)) {
        break label1436;
      }
      ((JSONObject)localObject4).put("OVERSEA", 1);
      if (paramBoolean2) {
        ((JSONObject)localObject4).put("DOWNLOAD_FOREGROUND", 1);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TbsDownloader.postJsonData] jsonData=");
      ((StringBuilder)localObject2).append(((JSONObject)localObject4).toString());
      TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TbsDownloader.postJsonData] jsonData=");
      ((StringBuilder)localObject2).append(((JSONObject)localObject4).toString());
      Log.d("TbsDownload", ((StringBuilder)localObject2).toString());
      return localObject4;
    }
  }
  
  private static void a(JSONArray paramJSONArray)
  {
    String[] arrayOfString = e();
    int i3 = arrayOfString.length;
    int n = 0;
    while (n < i3)
    {
      Object localObject1 = arrayOfString[n];
      int i4 = TbsShareManager.getSharedTbsCoreVersion(c, (String)localObject1);
      if (i4 > 0)
      {
        Object localObject2 = c;
        int i2 = 1;
        localObject2 = TbsShareManager.getPackageContext((Context)localObject2, (String)localObject1, true);
        if ((localObject2 != null) && (!p.a().g((Context)localObject2)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("host check failed,packageName = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          TbsLog.e("TbsDownload", ((StringBuilder)localObject2).toString());
        }
        else if (a(c, i4))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("add CoreVersionToJsonData,version+");
          ((StringBuilder)localObject1).append(i4);
          ((StringBuilder)localObject1).append(" is in black list");
          TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
        }
        else
        {
          int i1 = 0;
          while (i1 < paramJSONArray.length())
          {
            if (paramJSONArray.optInt(i1) == i4)
            {
              i1 = i2;
              break label204;
            }
            i1 += 1;
          }
          i1 = 0;
          label204:
          if (i1 == 0)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("addCoreVersionToJsonData,pkg=");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(";version=");
            ((StringBuilder)localObject2).append(i4);
            TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
            paramJSONArray.put(i4);
          }
        }
      }
      n += 1;
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
    int n;
    if (Build.VERSION.SDK_INT < 8) {
      n = -102;
    }
    for (;;)
    {
      localTbsDownloadConfig.setDownloadInterruptCode(n);
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
        n = -103;
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
      n = -104;
    }
    return true;
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = TbsDownloadConfig.getInstance(paramContext);
    c.a().a(paramContext, Integer.valueOf(1000), new TbsDownloader.1((TbsDownloadConfig)localObject2));
    Object localObject1;
    if (!paramBoolean1)
    {
      paramContext = ((TbsDownloadConfig)localObject2).mPreferences.getString("app_versionname", null);
      int n = ((TbsDownloadConfig)localObject2).mPreferences.getInt("app_versioncode", 0);
      localObject1 = ((TbsDownloadConfig)localObject2).mPreferences.getString("app_metadata", null);
      String str1 = b.d(c);
      int i1 = b.e(c);
      String str2 = b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TbsDownloader.needSendQueryRequest] appVersionName=");
      localStringBuilder.append(str1);
      localStringBuilder.append(" oldAppVersionName=");
      localStringBuilder.append(paramContext);
      localStringBuilder.append(" appVersionCode=");
      localStringBuilder.append(i1);
      localStringBuilder.append(" oldAppVersionCode=");
      localStringBuilder.append(n);
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
      int i2 = TbsPVConfig.getInstance(c).getEmergentCoreVersion();
      int i3 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
      l1 = l2 - l1;
      l5 *= 1000L;
      if (l1 > l5) {
        paramContext = "needSendRequest  true  #1";
      }
      for (;;)
      {
        TbsLog.i("TbsDownload", paramContext);
        for (;;)
        {
          paramContext = null;
          paramBoolean1 = true;
          break label944;
          if ((i2 > p.a().j(c)) && (i2 > i3))
          {
            paramContext = new StringBuilder();
            paramContext.append("emergentCoreVersion is ");
            paramContext.append(i2);
            paramContext.append(" getTbsCoreInstalledVerInNolock is ");
            paramContext.append(p.a().j(c));
            paramContext.append(" responseCoreVersion is ");
            paramContext.append(i3);
            paramContext = paramContext.toString();
            break;
          }
          if ((TbsShareManager.isThirdPartyApp(c)) && (l3 > 0L) && (l2 - l3 > l5) && (l4 < 11L))
          {
            paramContext = "needSendRequest  true  #3";
            break;
          }
          if ((!TbsShareManager.isThirdPartyApp(c)) || (TbsShareManager.findCoreForThirdPartyApp(c) != 0) || (d())) {
            break label710;
          }
          TbsLog.i("TbsDownload", "needSendRequest  true  #4");
          p.a().e(c);
        }
        label710:
        if ((str1 == null) || (i1 == 0) || (str2 == null)) {
          break;
        }
        if ((str1.equals(paramContext)) && (i1 == n) && (str2.equals(localObject1))) {
          break label940;
        }
        paramContext = "needSendRequest  true  #5";
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
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append(" appMetadata is ");
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append(" oldAppVersionName is ");
        ((StringBuilder)localObject2).append(paramContext);
        ((StringBuilder)localObject2).append(" oldAppVersionCode is ");
        ((StringBuilder)localObject2).append(n);
        ((StringBuilder)localObject2).append(" oldAppVersionMetadata is ");
        ((StringBuilder)localObject2).append((String)localObject1);
        paramContext = ((StringBuilder)localObject2).toString();
      }
      else
      {
        label940:
        paramContext = null;
      }
      paramBoolean1 = false;
    }
    else
    {
      label944:
      TbsLog.i("TbsDownload", "needSendRequest  true  #6");
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
    bool = TextUtils.isEmpty(paramString);
    Integer localInteger = Integer.valueOf(0);
    Boolean localBoolean = Boolean.valueOf(false);
    if (bool)
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
    int n = localJSONObject.getInt("RET");
    if (n != 0)
    {
      if (paramBoolean1) {
        paramInt = -109;
      } else {
        paramInt = -209;
      }
      localTbsDownloadConfig.setDownloadInterruptCode(paramInt);
      paramString = new StringBuilder();
      paramString.append("[TbsDownloader.readResponse] return #2,returnCode=");
      paramString.append(n);
      TbsLog.i("TbsDownload", paramString.toString());
      return false;
    }
    int i5 = localJSONObject.getInt("RESPONSECODE");
    String str2 = localJSONObject.getString("DOWNLOADURL");
    String str3 = localJSONObject.optString("URLLIST", "");
    int i6 = localJSONObject.getInt("TBSAPKSERVERVERSION");
    int i7 = localJSONObject.getInt("DOWNLOADMAXFLOW");
    int i8 = localJSONObject.getInt("DOWNLOAD_MIN_FREE_SPACE");
    int i9 = localJSONObject.getInt("DOWNLOAD_SUCCESS_MAX_RETRYTIMES");
    int i10 = localJSONObject.getInt("DOWNLOAD_FAILED_MAX_RETRYTIMES");
    long l3 = localJSONObject.getLong("DOWNLOAD_SINGLE_TIMEOUT");
    long l4 = localJSONObject.getLong("TBSAPKFILESIZE");
    long l1 = localJSONObject.optLong("RETRY_INTERVAL", 0L);
    int i11 = localJSONObject.optInt("FLOWCTR", -1);
    paramString = new StringBuilder();
    paramString.append("5is");
    paramString.append(i6);
    q.a(paramString.toString());
    try
    {
      if (TextUtils.isEmpty(str2))
      {
        paramString = "A";
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(i6);
        if (str2.contains(paramString.toString())) {
          paramString = "B";
        } else {
          paramString = str2;
        }
      }
    }
    catch (Throwable paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("throwable is ");
      ((StringBuilder)localObject1).append(Log.getStackTraceString(paramString));
      TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
      paramString = "";
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("6is");
    ((StringBuilder)localObject1).append(paramString);
    q.a(((StringBuilder)localObject1).toString());
    try
    {
      n = localJSONObject.getInt("USEBBACKUPVER");
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject2;
        continue;
        bool = false;
        continue;
        bool = false;
        continue;
        bool = false;
        continue;
        bool = false;
        continue;
        bool = false;
        continue;
      }
    }
    n = 0;
    localTbsDownloadConfig.mSyncMap.put("use_backup_version", Integer.valueOf(n));
    if ((paramBoolean1) && (QbSdk.i) && (TbsShareManager.isThirdPartyApp(c)))
    {
      try
      {
        n = localJSONObject.optInt("BUGLY", 0);
        paramString = TbsExtensionFunctionManager.getInstance();
        localObject1 = c;
        if (n != 1) {
          break label3363;
        }
        bool = true;
        paramString.setFunctionEnable((Context)localObject1, "bugly_switch.txt", bool);
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
      if (paramBoolean1) {
        try
        {
          n = localJSONObject.optInt("TEMPLATESWITCH", 0);
          if ((n & 0x1) == 0) {
            break label3369;
          }
          bool = true;
          TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, "cookie_switch.txt", bool);
          paramString = new StringBuilder();
          paramString.append("useCookieCompatiable:");
          paramString.append(bool);
          TbsLog.w("TbsDownload", paramString.toString());
          if ((n & 0x2) == 0) {
            break label3375;
          }
          bool = true;
          TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, "disable_get_apk_version_switch.txt", bool);
          paramString = new StringBuilder();
          paramString.append("disableGetApkVersionByReadFile:");
          paramString.append(bool);
          TbsLog.w("TbsDownload", paramString.toString());
          if ((n & 0x4) == 0) {
            break label3381;
          }
          bool = true;
          TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, "disable_unpreinit.txt", bool);
          QbSdk.setDisableUnpreinitBySwitch(bool);
          paramString = new StringBuilder();
          paramString.append("disableUnpreinitBySwitch:");
          paramString.append(bool);
          TbsLog.i("TbsDownload", paramString.toString());
          if ((n & 0x8) == 0) {
            break label3387;
          }
          bool = true;
          TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, "disable_use_host_backup_core.txt", bool);
          QbSdk.setDisableUseHostBackupCoreBySwitch(bool);
          paramString = new StringBuilder();
          paramString.append("disableUseHostBackupCoreBySwitch:");
          paramString.append(bool);
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
      try
      {
        paramString = localJSONObject.getString("PKGMD5");
      }
      catch (Exception paramString)
      {
        int i1;
        int i2;
        Object localObject3;
        int i3;
        label1086:
        label1089:
        break label1114;
      }
      try
      {
        i1 = localJSONObject.getInt("RESETX5");
      }
      catch (Exception localException1)
      {
        break label1111;
      }
      try
      {
        i2 = localJSONObject.getInt("UPLOADLOG");
      }
      catch (Exception localException2)
      {
        break label1105;
      }
      try
      {
        if (localJSONObject.has("RESETTOKEN"))
        {
          n = localJSONObject.getInt("RESETTOKEN");
          if (n != 0) {
            n = 1;
          } else {
            n = 0;
          }
        }
        else
        {
          n = 0;
        }
        localObject3 = "";
        localObject1 = localObject3;
        localObject2 = localObject3;
      }
      catch (Exception localException3)
      {
        break label1089;
      }
      try
      {
        if (localJSONObject.has("SETTOKEN"))
        {
          localObject2 = localObject3;
          localObject1 = localJSONObject.getString("SETTOKEN");
        }
        localObject2 = localObject1;
        if (localJSONObject.has("ENABLE_LOAD_RENAME_FILE_LOCK_WAIT"))
        {
          localObject2 = localObject1;
          i3 = localJSONObject.getInt("ENABLE_LOAD_RENAME_FILE_LOCK_WAIT");
          if (i3 == 0)
          {
            bool = false;
            break label1086;
          }
        }
        bool = true;
      }
      catch (Exception localException4)
      {
        str1 = paramString;
        paramString = (String)localObject2;
        break label1131;
      }
      localObject2 = "";
      n = 0;
      localObject1 = paramString;
      paramString = (String)localObject2;
      break label1131;
      label1105:
      localObject1 = paramString;
      break label1122;
      label1111:
      break label1116;
      label1114:
      paramString = null;
      label1116:
      i1 = 0;
      localObject1 = paramString;
      label1122:
      paramString = "";
      n = 0;
      i2 = 0;
      label1131:
      localObject2 = paramString;
      bool = true;
      paramString = (String)localObject1;
      localObject1 = localObject2;
      try
      {
        i4 = localJSONObject.getInt("RESETDECOUPLECORE");
      }
      catch (Exception localException7)
      {
        int i4;
        label1157:
        break label1157;
      }
      i4 = 0;
      try
      {
        i3 = localJSONObject.getInt("RESETTODECOUPLECORE");
      }
      catch (Exception localException8)
      {
        label1173:
        break label1173;
      }
      i3 = 0;
      localObject2 = f;
      if (n == 0) {
        break label3393;
      }
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
        if (i1 == 1)
        {
          if (paramBoolean1) {
            paramInt = -110;
          } else {
            paramInt = -210;
          }
          localTbsDownloadConfig.setDownloadInterruptCode(paramInt);
          paramString = c;
          if (i3 == 1) {
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
        if (!bool) {
          localTbsDownloadConfig.setTbsCoreLoadRenameFileLockWaitEnable(bool);
        }
        if (i4 == 1) {
          QbSdk.resetDecoupleCore(c);
        }
        if (i2 == 1)
        {
          d.removeMessages(104);
          Message.obtain(d, 104).sendToTarget();
        }
        if (i11 == 1)
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
        label1557:
        for (;;)
        {
          label1531:
          throw paramString;
        }
      }
      try
      {
        n = localJSONObject.getInt("DECOUPLECOREVERSION");
      }
      catch (Exception localException5)
      {
        break label1531;
      }
      n = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
      break label3396;
      n = 0;
      try
      {
        i1 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_downloaddecouplecore", 0);
      }
      catch (Exception localException6)
      {
        break label1557;
      }
      i1 = 0;
      i2 = n;
      if (paramBoolean1)
      {
        i2 = n;
        if (!TbsShareManager.isThirdPartyApp(c))
        {
          i2 = n;
          if (n == 0) {
            i2 = p.a().i(c);
          }
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("in response decoupleCoreVersion is ");
      ((StringBuilder)localObject1).append(i2);
      TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
      localTbsDownloadConfig.mSyncMap.put("tbs_decouplecoreversion", Integer.valueOf(i2));
      localTbsDownloadConfig.mSyncMap.put("tbs_downloaddecouplecore", Integer.valueOf(i1));
      if (!TbsShareManager.isThirdPartyApp(c)) {
        if ((i2 > 0) && (i2 != p.a().i(c)) && (i2 == p.a().j(c))) {
          p.a().o(c);
        } else if (i2 != 0) {}
      }
      try
      {
        FileUtil.b(p.a().q(c));
      }
      catch (Throwable localThrowable)
      {
        label1750:
        String str1;
        break label1750;
      }
      if ((TextUtils.isEmpty(str2)) && (TbsShareManager.isThirdPartyApp(c)))
      {
        localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", localBoolean);
        localTbsDownloadConfig.commit();
        if (paramBoolean1) {
          TbsShareManager.writeCoreInfoForThirdPartyApp(c, i6, false);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.readResponse] return #4,current app is third app...");
        return false;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("in response responseCode is ");
      ((StringBuilder)localObject1).append(i5);
      TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
      if (i5 == 0)
      {
        localTbsDownloadConfig.mSyncMap.put("tbs_responsecode", Integer.valueOf(i5));
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
      i3 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
      if (i3 > i6)
      {
        g.c();
        p.a().p(c);
      }
      if (!TbsShareManager.isThirdPartyApp(c))
      {
        i2 = p.a().e(c, 0);
        if (i2 >= i6) {
          n = 1;
        } else {
          n = 0;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("tmpCoreVersion is ");
        ((StringBuilder)localObject1).append(i2);
        ((StringBuilder)localObject1).append(" tbsDownloadVersion is");
        ((StringBuilder)localObject1).append(i6);
        TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
      }
      else
      {
        n = 0;
      }
      i2 = paramInt;
      if (((i2 >= i6) || (TextUtils.isEmpty(str2)) || (n != 0)) && (i1 != 1))
      {
        localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", localBoolean);
        if (paramBoolean1)
        {
          if (TextUtils.isEmpty(str2))
          {
            paramString = localTbsDownloadConfig.mSyncMap;
            paramInt = -124;
          }
          for (;;)
          {
            paramString.put("tbs_download_interrupt_code_reason", Integer.valueOf(paramInt));
            break;
            if (i6 <= 0)
            {
              paramString = localTbsDownloadConfig.mSyncMap;
              paramInt = -125;
            }
            else if (i2 >= i6)
            {
              paramString = localTbsDownloadConfig.mSyncMap;
              paramInt = -127;
            }
            else
            {
              paramString = localTbsDownloadConfig.mSyncMap;
              paramInt = -112;
            }
          }
        }
        paramInt = -212;
        if (TextUtils.isEmpty(str2)) {
          paramInt = -217;
        } else if (i6 <= 0) {
          paramInt = -218;
        } else if (i2 >= i6) {
          paramInt = -219;
        }
        localTbsDownloadConfig.mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(paramInt));
        localTbsDownloadConfig.setDownloadInterruptCode(paramInt);
        localTbsDownloadConfig.commit();
        paramString = new StringBuilder();
        paramString.append("version error or downloadUrl empty ,return ahead tbsLocalVersion=");
        paramString.append(i2);
        paramString.append(" tbsDownloadVersion=");
        paramString.append(i6);
        paramString.append(" tbsLastDownloadVersion=");
        paramString.append(i3);
        paramString.append(" downloadUrl=");
        paramString.append(str2);
        TbsLog.i("TbsDownload", paramString.toString());
        return false;
      }
      if (!str2.equals(localTbsDownloadConfig.mPreferences.getString("tbs_downloadurl", null)))
      {
        g.c();
        localObject2 = localTbsDownloadConfig.mSyncMap;
        localObject1 = localInteger;
        ((Map)localObject2).put("tbs_download_failed_retrytimes", localObject1);
        localTbsDownloadConfig.mSyncMap.put("tbs_download_success_retrytimes", localObject1);
      }
      localTbsDownloadConfig.mSyncMap.put("tbs_download_version", Integer.valueOf(i6));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("put KEY_TBS_DOWNLOAD_V is ");
      ((StringBuilder)localObject1).append(i6);
      TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
      if (i6 > 0)
      {
        if (i1 == 1) {
          localTbsDownloadConfig.mSyncMap.put("tbs_download_version_type", Integer.valueOf(1));
        } else {
          localTbsDownloadConfig.mSyncMap.put("tbs_download_version_type", localInteger);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("put KEY_TBS_DOWNLOAD_V_TYPE is ");
        ((StringBuilder)localObject1).append(i1);
        TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
      }
      localTbsDownloadConfig.mSyncMap.put("tbs_downloadurl", str2);
      localTbsDownloadConfig.mSyncMap.put("tbs_downloadurl_list", str3);
      localTbsDownloadConfig.mSyncMap.put("tbs_responsecode", Integer.valueOf(i5));
      localTbsDownloadConfig.mSyncMap.put("tbs_download_maxflow", Integer.valueOf(i7 * 2));
      localTbsDownloadConfig.mSyncMap.put("tbs_download_min_free_space", Integer.valueOf(i8));
      localTbsDownloadConfig.mSyncMap.put("tbs_download_success_max_retrytimes", Integer.valueOf(i9));
      localTbsDownloadConfig.mSyncMap.put("tbs_download_failed_max_retrytimes", Integer.valueOf(i10));
      localTbsDownloadConfig.mSyncMap.put("tbs_single_timeout", Long.valueOf(l3));
      localTbsDownloadConfig.mSyncMap.put("tbs_apkfilesize", Long.valueOf(l4));
      localTbsDownloadConfig.commit();
      if (paramString != null) {
        localTbsDownloadConfig.mSyncMap.put("tbs_apk_md5", paramString);
      }
      if ((!paramBoolean2) && (paramBoolean3) && (p.a().b(c, i6)))
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
        break label3254;
        if ((!paramBoolean2) && (paramBoolean3))
        {
          paramString = g;
          if ((i5 != 1) && (i5 != 2)) {
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
      label3254:
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
    int i1 = localObject2.length;
    Object localObject1 = null;
    int n = 0;
    while (n < i1)
    {
      String str1 = localObject2[n];
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
      n += 1;
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
    Object localObject = Build.VERSION.RELEASE;
    try
    {
      String str = new String(((String)localObject).getBytes("UTF-8"), "ISO8859-1");
      localObject = str;
    }
    catch (Exception localException2)
    {
      label50:
      break label50;
    }
    if (localObject == null) {}
    while (((String)localObject).length() <= 0)
    {
      localStringBuffer.append("1.0");
      break;
    }
    localStringBuffer.append((String)localObject);
    localStringBuffer.append("; ");
    localObject = localLocale.getLanguage();
    if (localObject != null)
    {
      localStringBuffer.append(((String)localObject).toLowerCase());
      localObject = localLocale.getCountry();
      if (localObject == null) {
        break label141;
      }
      localStringBuffer.append("-");
      localObject = ((String)localObject).toLowerCase();
    }
    else
    {
      localObject = "en";
    }
    localStringBuffer.append((String)localObject);
    label141:
    if ("REL".equals(Build.VERSION.CODENAME)) {
      paramContext = q.d(paramContext);
    }
    try
    {
      localObject = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = (Context)localObject;
    }
    catch (Exception localException1)
    {
      label178:
      break label178;
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
      int i3 = p.a().a(TbsShareManager.getHostCorePathAppDefined());
      int i2 = 0;
      int n = 0;
      int i1;
      for (;;)
      {
        i1 = i2;
        if (n >= paramJSONArray.length()) {
          break;
        }
        if (paramJSONArray.optInt(n) == i3)
        {
          i1 = 1;
          break;
        }
        n += 1;
      }
      if (i1 == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addAppDefinedToCoreVersions, version=");
        localStringBuilder.append(i3);
        TbsLog.i("TbsDownload", localStringBuilder.toString());
        paramJSONArray.put(i3);
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
    if (p.a().d(c))
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
      e = b.a();
      localTbsDownloadConfig.mSyncMap.put("device_cpuabi", e);
      localTbsDownloadConfig.commit();
    }
    if (!TextUtils.isEmpty(e)) {}
    try
    {
      localObject1 = Pattern.compile("i686|mips|x86_64").matcher(e);
    }
    catch (Exception localException1)
    {
      label659:
      int n;
      break label659;
    }
    localObject1 = null;
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
      n = 1;
    }
    else
    {
      n = 0;
    }
    localTbsDownloadConfig.mSyncMap.put("app_versionname", b.d(c));
    localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(b.e(c)));
    localTbsDownloadConfig.commit();
    localObject2 = a(paramBoolean1, paramBoolean2, paramBoolean3);
    label1453:
    label1590:
    label1593:
    label1641:
    try
    {
      i1 = ((JSONObject)localObject2).getInt("TBSV");
    }
    catch (Exception localException2)
    {
      int i1;
      label894:
      break label894;
    }
    i1 = -1;
    if ((n == 0) && (i1 == -1)) {}
    do
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
      localTbsDownloadConfig.mSyncMap.put("app_versionname", b.d(c));
      localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(b.e(c)));
      localTbsDownloadConfig.mSyncMap.put("app_metadata", b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
      localTbsDownloadConfig.commit();
    } while (n == 0);
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
    if ((i1 == -1) && (!paramBoolean3))
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
      localObject3 = com.tencent.smtt.utils.n.a(c).g();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[TbsDownloader.sendRequest] postUrl=");
      ((StringBuilder)localObject1).append((String)localObject3);
      TbsLog.i("TbsDownload", ((StringBuilder)localObject1).toString());
      if (!paramBoolean1) {}
    }
    catch (Throwable localThrowable2) {}
    for (;;)
    {
      try
      {
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(148));
        ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_sent", Integer.valueOf(1));
        ((TbsDownloadUpload)localObject1).commit();
        localObject1 = "sendRequest query 148";
        TbsLog.i("TbsDownload", (String)localObject1);
        break label1453;
        if (!paramBoolean3)
        {
          localObject1 = TbsDownloadUpload.getInstance(c);
          ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(168));
          ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_sent", Integer.valueOf(1));
          ((TbsDownloadUpload)localObject1).commit();
          localObject1 = "sendRequest download 168";
          break;
        }
        if (paramBoolean1) {
          l = (JSONObject)localObject2;
        }
        paramBoolean3 = q.e(c);
        if (!paramBoolean3) {}
      }
      catch (Throwable localThrowable4)
      {
        continue;
        break label1590;
        break label1641;
      }
      try
      {
        n = ((JSONObject)localObject2).getInt("FUNCTION");
        if ((n == 0) && (!TextUtils.isEmpty(com.tencent.smtt.utils.n.a(c).f())))
        {
          localObject1 = com.tencent.smtt.utils.n.a(c).f();
          continue;
        }
        if ((n == 1) && (!TextUtils.isEmpty(com.tencent.smtt.utils.n.a(c).e())))
        {
          localObject1 = com.tencent.smtt.utils.n.a(c).e();
          continue;
        }
        if ((n == 2) && (!TextUtils.isEmpty(com.tencent.smtt.utils.n.a(c).d())))
        {
          localObject1 = com.tencent.smtt.utils.n.a(c).d();
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable localThrowable3)
      {
        break label1593;
      }
    }
    localObject1 = null;
    if (localObject1 == null)
    {
      localObject1 = ((JSONObject)localObject2).toString().getBytes("utf-8");
      localObject2 = new TbsDownloader.3(localTbsDownloadConfig, paramBoolean1);
      localObject1 = com.tencent.smtt.utils.f.a((String)localObject3, (byte[])localObject1, (f.a)localObject2, false);
      paramBoolean2 = a((String)localObject1, i1, paramBoolean1, paramBoolean2, paramBoolean4);
      try
      {
        TbsLog.i("TbsDownload", "sendrequest return false #2");
        return paramBoolean2;
      }
      catch (Throwable localThrowable1) {}
      paramBoolean2 = false;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendrequest return false ");
      ((StringBuilder)localObject2).append(Log.getStackTraceString(localThrowable2));
      TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
      localThrowable2.printStackTrace();
      if (paramBoolean1) {
        n = -106;
      } else {
        n = -206;
      }
      localTbsDownloadConfig.setDownloadInterruptCode(n);
      return paramBoolean2;
    }
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
  
  private static void c(int paramInt)
  {
    if (paramInt < 32) {
      return;
    }
    try
    {
      localObject1 = l;
      if (localObject1 == null) {
        return;
      }
      if (paramInt == 64) {
        l.put("REQUEST_64", 1);
      } else if (paramInt == 32) {
        l.remove("REQUEST_64");
      }
      l.put("FUNCTION", 2);
      l.put("DOWNLOADDECOUPLECORE", 1);
      n = TbsShareManager.getTbsStableCoreVersion(c, paramInt);
      l.put("TBSDV", n);
      l.put("TBSV", 0);
      localObject1 = com.tencent.smtt.utils.n.a(c).g();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TbsDownloader.sendRequestForOtherStableCore] postUrl=");
      ((StringBuilder)localObject2).append((String)localObject1);
      TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TbsDownloader.sendRequestForOtherStableCore] mJsonDataQuery=");
      ((StringBuilder)localObject2).append(l.toString());
      TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
      localObject1 = com.tencent.smtt.utils.f.a((String)localObject1, l.toString().getBytes("utf-8"), new TbsDownloader.4(), false);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TbsDownloader.sendRequestForOtherStableCore] response=");
      ((StringBuilder)localObject2).append((String)localObject1);
      TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
      localObject3 = new JSONObject((String)localObject1);
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      Object localObject3;
      Object localObject4;
      int i1;
      label395:
      Object localObject5;
      StringBuilder localStringBuilder;
      label549:
      long l1;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("stack is ");
      ((StringBuilder)localObject2).append(Log.getStackTraceString(localThrowable));
      Log.d("TbsDownload", ((StringBuilder)localObject2).toString());
    }
    try
    {
      if (((JSONObject)localObject3).getInt("RESETDECOUPLECORE") != 1) {
        break label549;
      }
      localObject1 = TbsShareManager.getPackageContext(c, "com.tencent.mm", false);
      if (localObject1 == null) {
        localObject1 = new File(FileUtil.a(c, "com.tencent.mm", 4, true));
      } else {
        localObject1 = new File(FileUtil.a((Context)localObject1, 4));
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TbsDownloader.sendRequestForOtherStableCore] resetDecoupleCore mFilePathStable is ");
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString(), true);
      localObject2 = ((File)localObject1).listFiles();
      localObject4 = Pattern.compile(a.a(false, paramInt));
      i1 = localObject2.length;
      n = 0;
    }
    catch (Exception localException)
    {
      break label549;
      n += 1;
      break label395;
    }
    if (n < i1)
    {
      localObject5 = localObject2[n];
      if ((((Pattern)localObject4).matcher(localObject5.getName()).find()) && (localObject5.isFile()) && (localObject5.exists()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("resetStableCore file is ");
        localStringBuilder.append(localObject5.getAbsolutePath());
        TbsLog.i("TbsDownload", localStringBuilder.toString(), true);
        localObject5.delete();
      }
    }
    else
    {
      localObject1 = new File((File)localObject1, getBackupFileName(false, paramInt));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("resetStableCore file is ");
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString(), true);
      ((File)localObject1).delete();
      localObject1 = ((JSONObject)localObject3).getString("DOWNLOADURL");
      l1 = ((JSONObject)localObject3).getLong("TBSAPKFILESIZE");
      localObject2 = ((JSONObject)localObject3).getString("PKGMD5");
      n = ((JSONObject)localObject3).getInt("TBSAPKSERVERVERSION");
      if ((q.b(c)) && (TbsShareManager.getTbsStableCoreVersion(c, paramInt) < n))
      {
        localObject3 = TbsDownloadConfig.getInstance(c);
        ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_downloadurl", localObject1);
        ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_apkfilesize", Long.valueOf(l1));
        ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_cpu_type_other_stable_core", Integer.valueOf(paramInt));
        localObject4 = ((TbsDownloadConfig)localObject3).mSyncMap;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((Map)localObject4).put("tbs_apk_md5", localObject1);
        ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_downloaddecouplecore", Integer.valueOf(1));
        ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_download_version", Integer.valueOf(n));
        ((TbsDownloadConfig)localObject3).commit();
        g.b(false, true);
        return;
      }
      return;
    }
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
      int i3 = arrayOfString.length;
      int n = 0;
      while (n < i3)
      {
        String str2 = arrayOfString[n];
        int i4 = TbsShareManager.getBackupCoreVersion(c, str2);
        int i2 = 1;
        Object localObject;
        if (i4 > 0)
        {
          localObject = TbsShareManager.getPackageContext(c, str2, false);
          if ((localObject != null) && (!p.a().g((Context)localObject))) {
            localObject = new StringBuilder();
          }
        }
        for (String str1 = "addBackupVersionToJsonData,host check failed,packageName = ";; str1 = "host check failed,packageName = ")
        {
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append(str2);
          TbsLog.e("TbsDownload", ((StringBuilder)localObject).toString());
          break label437;
          if (a(c, i4))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("add addBackupVersionToJsonData,version+");
            ((StringBuilder)localObject).append(i4);
            ((StringBuilder)localObject).append(" is in black list");
            TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
            break label437;
          }
          i1 = 0;
          while (i1 < paramJSONArray.length())
          {
            if (paramJSONArray.optInt(i1) == i4)
            {
              i1 = 1;
              break label216;
            }
            i1 += 1;
          }
          i1 = 0;
          label216:
          if (i1 == 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("addBackupVersionToJsonData,pkg=");
            ((StringBuilder)localObject).append(str2);
            ((StringBuilder)localObject).append(";version=");
            ((StringBuilder)localObject).append(i4);
            TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
            paramJSONArray.put(i4);
          }
          i4 = TbsShareManager.getBackupDecoupleCoreVersion(c, str2);
          if (i4 <= 0) {
            break label437;
          }
          localObject = TbsShareManager.getPackageContext(c, str2, false);
          if ((localObject == null) || (p.a().g((Context)localObject))) {
            break;
          }
          localObject = new StringBuilder();
        }
        int i1 = 0;
        while (i1 < paramJSONArray.length())
        {
          if (paramJSONArray.optInt(i1) == i4)
          {
            i1 = i2;
            break label373;
          }
          i1 += 1;
        }
        i1 = 0;
        label373:
        if (i1 == 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("addBackupVersionToJsonDataByDecouple,pkg=");
          ((StringBuilder)localObject).append(str2);
          ((StringBuilder)localObject).append(";version=");
          ((StringBuilder)localObject).append(i4);
          TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
          paramJSONArray.put(i4);
        }
        label437:
        n += 1;
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
      int n = arrayOfString2.length;
      arrayOfString1 = new String[n + 1];
      System.arraycopy(arrayOfString2, 0, arrayOfString1, 0, n);
      arrayOfString1[n] = str;
    }
    return arrayOfString1;
  }
  
  private static JSONArray f()
  {
    if (TbsShareManager.isThirdPartyApp(c))
    {
      JSONArray localJSONArray = new JSONArray();
      a(localJSONArray);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getHostCoreVersions addCoreVersionToJsonData is ");
      localStringBuilder.append(localJSONArray.toString());
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      c(localJSONArray);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getHostCoreVersions addBackupVersionToJsonData is ");
      localStringBuilder.append(localJSONArray.toString());
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      b(localJSONArray);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getHostCoreVersions addAppDefinedToCoreVersions is ");
      localStringBuilder.append(localJSONArray.toString());
      TbsLog.i("TbsDownload", localStringBuilder.toString());
      return localJSONArray;
    }
    return null;
  }
  
  private static boolean g()
  {
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    int n;
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_success_retrytimes", 0) >= localTbsDownloadConfig.getDownloadSuccessMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
      n = -115;
    }
    for (;;)
    {
      localTbsDownloadConfig.setDownloadInterruptCode(n);
      return false;
      if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_failed_retrytimes", 0) >= localTbsDownloadConfig.getDownloadFailedMaxRetrytimes())
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
        n = -116;
      }
      else if (!FileUtil.b(c))
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
        n = -117;
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
        n = -120;
      }
    }
    return true;
  }
  
  public static String getBackupFileName(boolean paramBoolean)
  {
    return getBackupFileName(paramBoolean, 0);
  }
  
  public static String getBackupFileName(boolean paramBoolean, int paramInt)
  {
    boolean bool;
    if (paramInt == 64) {
      bool = true;
    } else if (paramInt == 32) {
      bool = false;
    } else {
      bool = b.b();
    }
    if (paramBoolean)
    {
      if (bool) {
        return "x5.tbs.decouple.64";
      }
      return "x5.tbs.decouple";
    }
    if (bool) {
      return "x5.tbs.org.64";
    }
    return "x5.tbs.org";
  }
  
  public static int getCoreShareDecoupleCoreVersion()
  {
    return p.a().i(c);
  }
  
  public static int getCoreShareDecoupleCoreVersionByContext(Context paramContext)
  {
    return p.a().i(paramContext);
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
    return m;
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
    c = paramContext.getApplicationContext();
    q.a("1");
    TbsLog.initIfNeed(paramContext);
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
    Object localObject2 = p.a();
    if (f.a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((p)localObject2).b(paramContext, bool);
    int n = p.a().b(paramContext);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[TbsDownloader.needDownload],renameRet=");
    ((StringBuilder)localObject2).append(n);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
    if (n != 0)
    {
      localObject2 = TbsLogReport.getInstance(paramContext).tbsLogInfo();
      ((TbsLogReport.TbsLogInfo)localObject2).a = 129;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("code=2");
      localStringBuilder.append(n);
      ((TbsLogReport.TbsLogInfo)localObject2).setFailDetail(localStringBuilder.toString());
      TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, (TbsLogReport.TbsLogInfo)localObject2);
    }
    if (n < 0)
    {
      paramContext = new StringBuilder();
      paramContext.append("[TbsDownloader.needDownload],needReNameFile=");
      paramContext.append(n);
      TbsLog.i("TbsDownload", paramContext.toString());
      return false;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[TbsDownloader.needDownload] oversea=");
    ((StringBuilder)localObject2).append(paramBoolean1);
    ((StringBuilder)localObject2).append(",isDownloadForeground=");
    ((StringBuilder)localObject2).append(paramBoolean2);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject2).toString());
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
      n = p.a().n(c);
      paramContext = new StringBuilder();
      paramContext.append("[TbsDownloader.needDownload]#7,tbsLocalVersion=");
      paramContext.append(n);
      paramContext.append(",needSendRequest=");
      paramContext.append(bool);
      TbsLog.i("TbsDownload", paramContext.toString());
      if ((!bool) && (n > 0)) {}
      for (n = -119;; n = -121)
      {
        ((TbsDownloadConfig)localObject2).setDownloadInterruptCode(n);
        break;
        d.removeMessages(103);
        if ((n <= 0) && (!bool)) {
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
      n = 170;
    } else {
      n = 174;
    }
    paramContext.put("tbs_needdownload_return", Integer.valueOf(n));
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
    int n = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    return (n > 0) && (n != p.a().i(c)) && (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) != n);
  }
  
  public static boolean needSendRequest(Context paramContext, boolean paramBoolean)
  {
    c = paramContext.getApplicationContext();
    TbsLog.initIfNeed(paramContext);
    if (!a(c, paramBoolean)) {
      return false;
    }
    int n = p.a().n(paramContext);
    paramContext = new StringBuilder();
    paramContext.append("[TbsDownloader.needSendRequest] localTbsVersion=");
    paramContext.append(n);
    TbsLog.i("TbsDownload", paramContext.toString());
    if (n > 0) {
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
      m = paramLong;
    }
    paramContext = new StringBuilder();
    paramContext.append("mRetryIntervalInSeconds is ");
    paramContext.append(m);
    TbsLog.i("TbsDownload", paramContext.toString());
  }
  
  public static boolean startDecoupleCoreIfNeeded()
  {
    boolean bool = startDecoupleCoreIfNeededImpl();
    if ((!bool) && (q.b(c)))
    {
      int i1 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_cpu_type_other_stable_core", 0);
      int n = 64;
      if (i1 == 0)
      {
        if (b.b()) {
          n = 32;
        }
        c(n);
        return bool;
      }
      if ((i1 == 32) || (i1 == 64))
      {
        TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
        localTbsDownloadConfig.mSyncMap.put("tbs_downloadurl", "");
        localTbsDownloadConfig.mSyncMap.put("tbs_apkfilesize", Integer.valueOf(0));
        localTbsDownloadConfig.mSyncMap.put("tbs_cpu_type_other_stable_core", Integer.valueOf(0));
        localTbsDownloadConfig.mSyncMap.put("tbs_apk_md5", "");
        localTbsDownloadConfig.mSyncMap.put("tbs_downloaddecouplecore", Integer.valueOf(0));
        localTbsDownloadConfig.mSyncMap.put("tbs_download_version", Integer.valueOf(0));
        localTbsDownloadConfig.commit();
      }
    }
    return bool;
  }
  
  public static boolean startDecoupleCoreIfNeededImpl()
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
    int i1 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    int n;
    if (q.b(c)) {
      n = TbsShareManager.getTbsStableCoreVersion(c, 0);
    } else {
      n = p.a().i(c);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startDecoupleCoreIfNeeded coreVersionForThirdApp is ");
    ((StringBuilder)localObject).append(n);
    TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
    if ((i1 > 0) && (i1 != n))
    {
      if ((TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) == i1) && (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0) != 1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is ");
        ((StringBuilder)localObject).append(TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0));
        ((StringBuilder)localObject).append(" deCoupleCoreVersion is ");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(" KEY_TBS_DOWNLOAD_V_TYPE is ");
        ((StringBuilder)localObject).append(TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0));
        localObject = ((StringBuilder)localObject).toString();
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
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" getTbsCoreShareDecoupleCoreVersion is ");
      ((StringBuilder)localObject).append(n);
      localObject = ((StringBuilder)localObject).toString();
    }
    TbsLog.i("TbsDownload", (String)localObject);
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
        TbsLog.initIfNeed(paramContext);
        TbsDownloadUpload localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
        localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(160));
        localTbsDownloadUpload.commit();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[TbsDownloader.startDownload] sAppContext=");
        ((StringBuilder)localObject).append(c);
        TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
        if (p.b)
        {
          localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(161));
          localTbsDownloadUpload.commit();
          return;
        }
        localObject = p.a();
        int i1 = f.a;
        int n = 0;
        if (i1 == 0)
        {
          bool = true;
          ((p)localObject).b(paramContext, bool);
          i1 = p.a().b(paramContext);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[TbsDownloader.needDownload],renameRet=");
          ((StringBuilder)localObject).append(i1);
          TbsLog.i("TbsDownload", ((StringBuilder)localObject).toString());
          if (i1 != 0)
          {
            localObject = TbsLogReport.getInstance(paramContext).tbsLogInfo();
            ((TbsLogReport.TbsLogInfo)localObject).a = 129;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("code=2");
            localStringBuilder.append(i1);
            ((TbsLogReport.TbsLogInfo)localObject).setFailDetail(localStringBuilder.toString());
            TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, (TbsLogReport.TbsLogInfo)localObject);
          }
          if (i1 < 0)
          {
            paramContext = new StringBuilder();
            paramContext.append("[TbsDownloader.needDownload],needReNameFile=");
            paramContext.append(i1);
            TbsLog.i("TbsDownload", paramContext.toString());
            return;
          }
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
          if (paramBoolean) {
            n = 1;
          }
          paramContext.arg1 = n;
          paramContext.sendToTarget();
          return;
        }
      }
      finally {}
      boolean bool = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader
 * JD-Core Version:    0.7.0.1
 */