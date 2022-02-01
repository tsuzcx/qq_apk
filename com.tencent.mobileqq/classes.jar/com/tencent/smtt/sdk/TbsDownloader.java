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
    Object localObject1 = null;
    int n = arrayOfString.length;
    int m = 0;
    Object localObject2 = localObject1;
    if (m < n)
    {
      localObject2 = arrayOfString[m];
      if (!((String)localObject2).equals(c.getApplicationInfo().packageName)) {}
    }
    for (;;)
    {
      m += 1;
      break;
      localObject2 = FileUtil.a(c, (String)localObject2, 4, false);
      if (getOverSea(c)) {}
      for (localObject1 = "x5.oversea.tbs.org";; localObject1 = getBackupFileName(false))
      {
        localObject1 = new File((String)localObject2, (String)localObject1);
        if ((localObject1 == null) || (!((File)localObject1).exists())) {
          break label159;
        }
        if (a.a(c, (File)localObject1) != paramInt) {
          break;
        }
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject1).getAbsolutePath());
        localObject2 = localObject1;
        return localObject2;
      }
      TbsLog.i("TbsDownload", "version is not match");
      continue;
      label159:
      TbsLog.i("TbsDownload", "can not find local backup core file");
    }
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
    Object localObject;
    label60:
    label73:
    long l1;
    if (m < i1)
    {
      localObject = arrayOfString[m];
      if (paramBoolean)
      {
        String str = FileUtil.a(c, (String)localObject, 4, false);
        if (getOverSea(c))
        {
          localObject = "x5.oversea.tbs.org";
          localObject = new File(str, (String)localObject);
          if ((localObject != null) && (((File)localObject).exists()))
          {
            l1 = a.a(c, (File)localObject);
            if (l1 > 0L)
            {
              n = 0;
              label106:
              if (n >= localJSONArray.length()) {
                break label192;
              }
              if (localJSONArray.optInt(n) != l1) {
                break label182;
              }
            }
          }
        }
      }
    }
    label182:
    label192:
    for (int n = 1;; n = 0)
    {
      if (n == 0) {
        localJSONArray.put(l1);
      }
      m += 1;
      break;
      localObject = getBackupFileName(false);
      break label60;
      localObject = new File(FileUtil.a(c, (String)localObject, 4, false), "x5.tbs.decouple");
      break label73;
      n += 1;
      break label106;
      return localJSONArray;
    }
  }
  
  private static JSONObject a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = 0;
    TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData]isQuery: " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    String str1 = b(c);
    String str2 = b.g(c);
    String str3 = b.f(c);
    String str4 = b.i(c);
    Object localObject1 = TimeZone.getDefault().getID();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      try
      {
        localObject3 = (TelephonyManager)c.getSystemService("phone");
        if (localObject3 == null) {
          break label766;
        }
        localObject3 = ((TelephonyManager)localObject3).getSimCountryIso();
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
          label130:
          localException2.printStackTrace();
          continue;
          localException2.put("REQUEST_TPATCH", 0);
          continue;
          m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
        }
      }
      if (localObject1 != null) {
        localObject3 = new JSONObject();
      }
    }
    try
    {
      if (m.a(c).c("tpatch_num") >= 5) {
        break label769;
      }
      ((JSONObject)localObject3).put("REQUEST_TPATCH", 1);
      ((JSONObject)localObject3).put("TIMEZONEID", localObject2);
      ((JSONObject)localObject3).put("COUNTRYISO", localObject1);
      if (b.d()) {
        ((JSONObject)localObject3).put("REQUEST_64", 1);
      }
      ((JSONObject)localObject3).put("PROTOCOLVERSION", 1);
      if (!TbsShareManager.isThirdPartyApp(c)) {
        break label803;
      }
      if (!QbSdk.c) {
        break label781;
      }
      m = TbsShareManager.a(c, false);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int m;
        label230:
        label243:
        int n;
        label306:
        label606:
        label766:
        continue;
        for (;;)
        {
          label769:
          label781:
          label803:
          label1068:
          label1090:
          break;
          label1055:
          m = 0;
        }
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
        }
      }
    }
    if (paramBoolean1)
    {
      ((JSONObject)localObject3).put("FUNCTION", 2);
      if (TbsShareManager.isThirdPartyApp(c))
      {
        localObject1 = f();
        ((JSONObject)localObject3).put("TBSVLARR", localObject1);
        localTbsDownloadConfig.mSyncMap.put("last_thirdapp_sendrequest_coreversion", ((JSONArray)localObject1).toString());
        localTbsDownloadConfig.commit();
        if (QbSdk.c) {
          ((JSONObject)localObject3).put("THIRDREQ", 1);
        }
        ((JSONObject)localObject3).put("APPN", c.getPackageName());
        ((JSONObject)localObject3).put("APPVN", a(localTbsDownloadConfig.mPreferences.getString("app_versionname", null)));
        ((JSONObject)localObject3).put("APPVC", localTbsDownloadConfig.mPreferences.getInt("app_versioncode", 0));
        ((JSONObject)localObject3).put("APPMETA", a(localTbsDownloadConfig.mPreferences.getString("app_metadata", null)));
        ((JSONObject)localObject3).put("TBSSDKV", 43973);
        ((JSONObject)localObject3).put("TBSV", m);
        if (!paramBoolean3) {
          break label1138;
        }
        n = 1;
        ((JSONObject)localObject3).put("DOWNLOADDECOUPLECORE", n);
        localObject1 = localTbsDownloadConfig.mSyncMap;
        if (!paramBoolean3) {
          break label1144;
        }
        n = 1;
        ((Map)localObject1).put("tbs_downloaddecouplecore", Integer.valueOf(n));
        localTbsDownloadConfig.commit();
        if (m != 0) {
          ((JSONObject)localObject3).put("TBSBACKUPV", g.c(paramBoolean3));
        }
        ((JSONObject)localObject3).put("CPU", e);
        ((JSONObject)localObject3).put("UA", str1);
        ((JSONObject)localObject3).put("IMSI", a(str2));
        ((JSONObject)localObject3).put("IMEI", a(str3));
        ((JSONObject)localObject3).put("ANDROID_ID", a(str4));
        ((JSONObject)localObject3).put("GUID", b.e(c));
        if (!TbsShareManager.isThirdPartyApp(c))
        {
          if (m == 0) {
            break label1055;
          }
          if (!QbSdk.a(c, m)) {
            break label1150;
          }
          m = 0;
          ((JSONObject)localObject3).put("STATUS", m);
          ((JSONObject)localObject3).put("TBSDV", p.a().h(c));
        }
        paramBoolean3 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean("request_full_package", false);
        localObject1 = QbSdk.a(c, "can_unlzma", null);
        if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
          break label1068;
        }
        paramBoolean1 = ((Boolean)localObject1).booleanValue();
        break label1090;
      }
      for (;;)
      {
        if (m != 0) {
          ((JSONObject)localObject3).put("REQUEST_LZMA", 1);
        }
        if (getOverSea(c)) {
          ((JSONObject)localObject3).put("OVERSEA", 1);
        }
        if (paramBoolean2) {
          ((JSONObject)localObject3).put("DOWNLOAD_FOREGROUND", 1);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + ((JSONObject)localObject3).toString());
        return localObject3;
        if (paramBoolean3) {}
        for (n = p.a().i(c);; n = p.a().m(c))
        {
          m = n;
          if (n == 0)
          {
            m = n;
            if (p.a().l(c))
            {
              n = -1;
              m = n;
              if ("com.tencent.mobileqq".equals(c.getApplicationInfo().packageName))
              {
                TbsDownloadUpload.clear();
                localObject1 = TbsDownloadUpload.getInstance(c);
                ((TbsDownloadUpload)localObject1).a.put("tbs_local_core_version", Integer.valueOf(-1));
                ((TbsDownloadUpload)localObject1).commit();
                TbsPVConfig.releaseInstance();
                m = n;
                if (TbsPVConfig.getInstance(c).getLocalCoreVersionMoreTimes() == 1) {
                  m = p.a().i(c);
                }
              }
            }
          }
          TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + m + " isDownloadForeground=" + paramBoolean2);
          if (!paramBoolean2) {
            break;
          }
          if (!p.a().l(c)) {
            break label1117;
          }
          break label1114;
        }
        localException2.put("FUNCTION", n);
        break label243;
        localObject1 = a(paramBoolean3);
        if ((Apn.getApnType(c) == 3) || (((JSONArray)localObject1).length() == 0) || (m != 0) || (!paramBoolean1)) {
          break label306;
        }
        localException2.put("TBSBACKUPARR", localObject1);
        break label306;
        localException2.put("STATUS", 0);
        break label606;
        paramBoolean1 = false;
        break label1090;
        break label230;
        localObject1 = "";
        break label130;
        localObject2 = "";
        break;
        m = i1;
        if (paramBoolean1)
        {
          m = i1;
          if (!paramBoolean3) {
            m = 1;
          }
        }
      }
    }
  }
  
  private static void a(JSONArray paramJSONArray)
  {
    String[] arrayOfString = e();
    int i1 = arrayOfString.length;
    int m = 0;
    int i2;
    if (m < i1)
    {
      String str = arrayOfString[m];
      i2 = TbsShareManager.getSharedTbsCoreVersion(c, str);
      if (i2 > 0)
      {
        Context localContext = TbsShareManager.getPackageContext(c, str, true);
        if ((localContext == null) || (p.a().f(localContext))) {
          break label97;
        }
        TbsLog.e("TbsDownload", "host check failed,packageName = " + str);
      }
    }
    label145:
    label190:
    for (;;)
    {
      m += 1;
      break;
      label97:
      if (a(c, i2))
      {
        TbsLog.i("TbsDownload", "add CoreVersionToJsonData,version+" + i2 + " is in black list");
      }
      else
      {
        int n = 0;
        if (n < paramJSONArray.length()) {
          if (paramJSONArray.optInt(n) != i2) {}
        }
        for (n = 1;; n = 0)
        {
          if (n != 0) {
            break label190;
          }
          paramJSONArray.put(i2);
          break;
          n += 1;
          break label145;
          return;
        }
      }
    }
  }
  
  private static void a(boolean paramBoolean1, TbsDownloader.TbsDownloaderCallback paramTbsDownloaderCallback, boolean paramBoolean2)
  {
    int n = 1;
    TbsLog.i("TbsDownload", "[TbsDownloader.queryConfig]");
    d.removeMessages(100);
    Message localMessage = Message.obtain(d, 100);
    if (paramTbsDownloaderCallback != null) {
      localMessage.obj = paramTbsDownloaderCallback;
    }
    localMessage.arg1 = 0;
    if (paramBoolean1)
    {
      m = 1;
      localMessage.arg1 = m;
      if (!paramBoolean2) {
        break label81;
      }
    }
    label81:
    for (int m = n;; m = 0)
    {
      localMessage.arg2 = m;
      localMessage.sendToTarget();
      return;
      m = 0;
      break;
    }
  }
  
  static boolean a(Context paramContext)
  {
    return TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1;
  }
  
  static boolean a(Context paramContext, int paramInt)
  {
    return (Build.VERSION.SDK_INT > 28) && (paramContext.getApplicationInfo().targetSdkVersion > 28) && (paramInt > 0) && (paramInt < 45114);
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean)
  {
    Object localObject = null;
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(paramContext);
    if (Build.VERSION.SDK_INT < 8)
    {
      localTbsDownloadConfig.setDownloadInterruptCode(-102);
      return false;
    }
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
      TbsLog.i("TbsDownload", "needDownload-first-called--isoversea = " + bool);
    }
    if ((getOverSea(paramContext)) && (Build.VERSION.SDK_INT != 16) && (Build.VERSION.SDK_INT != 17) && (Build.VERSION.SDK_INT != 18))
    {
      TbsLog.i("TbsDownload", "needDownload- return false,  because of  version is " + Build.VERSION.SDK_INT + ", and overea");
      localTbsDownloadConfig.setDownloadInterruptCode(-103);
      return false;
    }
    e = localTbsDownloadConfig.mPreferences.getString("device_cpuabi", null);
    if (!TextUtils.isEmpty(e)) {}
    try
    {
      paramContext = Pattern.compile("i686|mips|x86_64").matcher(e);
      if ((paramContext != null) && (paramContext.find()))
      {
        TbsLog.e("TbsDownload", "can not support x86 devices!!");
        localTbsDownloadConfig.setDownloadInterruptCode(-104);
        return false;
      }
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = TbsDownloadConfig.getInstance(paramContext);
    e.a().a(1000, new TbsDownloader.1(paramContext));
    Object localObject;
    int m;
    String str1;
    String str2;
    int n;
    String str3;
    long l2;
    long l3;
    long l1;
    long l4;
    long l5;
    int i1;
    int i2;
    if (!paramBoolean1)
    {
      localObject = paramContext.mPreferences.getString("app_versionname", null);
      m = paramContext.mPreferences.getInt("app_versioncode", 0);
      str1 = paramContext.mPreferences.getString("app_metadata", null);
      str2 = b.c(c);
      n = b.d(c);
      str3 = b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] appVersionName=" + str2 + " oldAppVersionName=" + (String)localObject + " appVersionCode=" + n + " oldAppVersionCode=" + m + " appMetadata=" + str3 + " oldAppVersionMetadata=" + str1);
      l2 = System.currentTimeMillis();
      l3 = paramContext.mPreferences.getLong("last_check", 0L);
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] timeLastCheck=" + l3 + " timeNow=" + l2);
      l1 = l3;
      if (paramBoolean2)
      {
        paramBoolean1 = paramContext.mPreferences.contains("last_check");
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + paramBoolean1);
        l1 = l3;
        if (paramBoolean1)
        {
          l1 = l3;
          if (l3 == 0L) {
            l1 = l2;
          }
        }
      }
      l3 = paramContext.mPreferences.getLong("last_request_success", 0L);
      l4 = paramContext.mPreferences.getLong("count_request_fail_in_24hours", 0L);
      l5 = paramContext.getRetryInterval();
      TbsLog.i("TbsDownload", "retryInterval = " + l5 + " s");
      TbsPVConfig.releaseInstance();
      i1 = TbsPVConfig.getInstance(c).getEmergentCoreVersion();
      i2 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
      if (l2 - l1 > 1000L * l5)
      {
        paramBoolean1 = true;
        paramContext = null;
      }
    }
    for (;;)
    {
      if ((!paramBoolean1) && (TbsShareManager.isThirdPartyApp(c)))
      {
        localObject = TbsLogReport.getInstance(c).tbsLogInfo();
        ((TbsLogReport.TbsLogInfo)localObject).setErrorCode(-119);
        ((TbsLogReport.TbsLogInfo)localObject).setFailDetail(paramContext);
        TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject);
      }
      return paramBoolean1;
      if ((i1 > p.a().i(c)) && (i1 > i2))
      {
        paramBoolean1 = true;
        paramContext = null;
      }
      else if ((TbsShareManager.isThirdPartyApp(c)) && (l3 > 0L) && (l2 - l3 > l5 * 1000L) && (l4 < 11L))
      {
        paramBoolean1 = true;
        paramContext = null;
      }
      else if ((TbsShareManager.isThirdPartyApp(c)) && (TbsShareManager.findCoreForThirdPartyApp(c) == 0) && (!d()))
      {
        p.a().d(c);
        paramBoolean1 = true;
        paramContext = null;
      }
      else
      {
        if ((str2 != null) && (n != 0) && (str3 != null))
        {
          if ((!str2.equals(localObject)) || (n != m) || (!str3.equals(str1)))
          {
            paramBoolean1 = true;
            paramContext = null;
          }
        }
        else if (TbsShareManager.isThirdPartyApp(c))
        {
          paramContext = "timeNow - timeLastCheck is " + (l2 - l1) + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + TbsShareManager.findCoreForThirdPartyApp(c) + " sendRequestWithSameHostCoreVersion() is " + d() + " appVersionName is " + str2 + " appVersionCode is " + n + " appMetadata is " + str3 + " oldAppVersionName is " + (String)localObject + " oldAppVersionCode is " + m + " oldAppVersionMetadata is " + str1;
          paramBoolean1 = false;
          continue;
          paramBoolean1 = true;
          paramContext = null;
          continue;
        }
        paramContext = null;
        paramBoolean1 = false;
      }
    }
  }
  
  /* Error */
  @TargetApi(11)
  private static boolean a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: ldc 12
    //   2: new 107	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 680
    //   12: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 682
    //   22: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload 4
    //   27: invokevirtual 162	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   39: invokestatic 170	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   42: astore 30
    //   44: aload_0
    //   45: invokestatic 528	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifeq +35 -> 83
    //   51: iload_2
    //   52: ifeq +20 -> 72
    //   55: aload 30
    //   57: bipush 148
    //   59: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   62: ldc 12
    //   64: ldc_w 684
    //   67: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: iconst_0
    //   71: ireturn
    //   72: aload 30
    //   74: sipush -208
    //   77: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   80: goto -18 -> 62
    //   83: new 203	org/json/JSONObject
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 686	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   91: astore 31
    //   93: aload 31
    //   95: ldc_w 688
    //   98: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   101: istore 5
    //   103: iload 5
    //   105: ifeq +53 -> 158
    //   108: iload_2
    //   109: ifeq +38 -> 147
    //   112: aload 30
    //   114: bipush 147
    //   116: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   119: ldc 12
    //   121: new 107	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   128: ldc_w 692
    //   131: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: iload 5
    //   136: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: iconst_0
    //   146: ireturn
    //   147: aload 30
    //   149: sipush -209
    //   152: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   155: goto -36 -> 119
    //   158: aload 31
    //   160: ldc_w 694
    //   163: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   166: istore 12
    //   168: aload 31
    //   170: ldc_w 696
    //   173: invokevirtual 698	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: astore 32
    //   178: aload 31
    //   180: ldc_w 700
    //   183: ldc 136
    //   185: invokevirtual 703	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   188: astore 33
    //   190: aload 31
    //   192: ldc_w 705
    //   195: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   198: istore 11
    //   200: aload 31
    //   202: ldc_w 707
    //   205: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   208: istore 13
    //   210: aload 31
    //   212: ldc_w 709
    //   215: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   218: istore 14
    //   220: aload 31
    //   222: ldc_w 711
    //   225: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   228: istore 15
    //   230: aload 31
    //   232: ldc_w 713
    //   235: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   238: istore 16
    //   240: aload 31
    //   242: ldc_w 715
    //   245: invokevirtual 718	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   248: lstore 23
    //   250: aload 31
    //   252: ldc_w 720
    //   255: invokevirtual 718	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   258: lstore 25
    //   260: aload 31
    //   262: ldc_w 722
    //   265: lconst_0
    //   266: invokevirtual 725	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   269: lstore 21
    //   271: aload 31
    //   273: ldc_w 727
    //   276: iconst_m1
    //   277: invokevirtual 729	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   280: istore 17
    //   282: iconst_0
    //   283: istore 5
    //   285: aload 31
    //   287: ldc_w 731
    //   290: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   293: istore 6
    //   295: iload 6
    //   297: istore 5
    //   299: aload 30
    //   301: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   304: ldc_w 733
    //   307: iload 5
    //   309: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   312: invokeinterface 261 3 0
    //   317: pop
    //   318: iload_2
    //   319: ifeq +59 -> 378
    //   322: getstatic 734	com/tencent/smtt/sdk/QbSdk:i	Z
    //   325: ifeq +53 -> 378
    //   328: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   331: invokestatic 235	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   334: ifeq +44 -> 378
    //   337: aload 31
    //   339: ldc_w 736
    //   342: iconst_0
    //   343: invokevirtual 729	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   346: istore 5
    //   348: invokestatic 741	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   351: astore_0
    //   352: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   355: astore 27
    //   357: iload 5
    //   359: iconst_1
    //   360: if_icmpne +658 -> 1018
    //   363: iconst_1
    //   364: istore 18
    //   366: aload_0
    //   367: aload 27
    //   369: ldc_w 743
    //   372: iload 18
    //   374: invokevirtual 747	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   377: pop
    //   378: iload_2
    //   379: ifeq +229 -> 608
    //   382: aload 31
    //   384: ldc_w 749
    //   387: iconst_0
    //   388: invokevirtual 729	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   391: istore 5
    //   393: iload 5
    //   395: iconst_1
    //   396: iand
    //   397: ifeq +660 -> 1057
    //   400: iconst_1
    //   401: istore 18
    //   403: invokestatic 741	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   406: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   409: ldc_w 751
    //   412: iload 18
    //   414: invokevirtual 747	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   417: pop
    //   418: ldc 12
    //   420: new 107	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   427: ldc_w 753
    //   430: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: iload 18
    //   435: invokevirtual 162	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   438: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 756	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   444: iload 5
    //   446: iconst_2
    //   447: iand
    //   448: ifeq +615 -> 1063
    //   451: iconst_1
    //   452: istore 18
    //   454: invokestatic 741	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   457: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   460: ldc_w 758
    //   463: iload 18
    //   465: invokevirtual 747	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   468: pop
    //   469: ldc 12
    //   471: new 107	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   478: ldc_w 760
    //   481: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: iload 18
    //   486: invokevirtual 162	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   489: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 756	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: iload 5
    //   497: iconst_4
    //   498: iand
    //   499: ifeq +570 -> 1069
    //   502: iconst_1
    //   503: istore 18
    //   505: invokestatic 741	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   508: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   511: ldc_w 762
    //   514: iload 18
    //   516: invokevirtual 747	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   519: pop
    //   520: iload 18
    //   522: invokestatic 766	com/tencent/smtt/sdk/QbSdk:setDisableUnpreinitBySwitch	(Z)V
    //   525: ldc 12
    //   527: new 107	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   534: ldc_w 768
    //   537: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: iload 18
    //   542: invokevirtual 162	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   545: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: iload 5
    //   553: bipush 8
    //   555: iand
    //   556: ifeq +519 -> 1075
    //   559: iconst_1
    //   560: istore 18
    //   562: invokestatic 741	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   565: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   568: ldc_w 770
    //   571: iload 18
    //   573: invokevirtual 747	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   576: pop
    //   577: iload 18
    //   579: invokestatic 773	com/tencent/smtt/sdk/QbSdk:setDisableUseHostBackupCoreBySwitch	(Z)V
    //   582: ldc 12
    //   584: new 107	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   591: ldc_w 775
    //   594: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: iload 18
    //   599: invokevirtual 162	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   602: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   608: aconst_null
    //   609: astore 27
    //   611: iconst_0
    //   612: istore 6
    //   614: iconst_0
    //   615: istore 8
    //   617: iconst_1
    //   618: istore 20
    //   620: iconst_1
    //   621: istore 18
    //   623: ldc 136
    //   625: astore 29
    //   627: aload 31
    //   629: ldc_w 777
    //   632: invokevirtual 698	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   635: astore_0
    //   636: aload 31
    //   638: ldc_w 779
    //   641: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   644: istore 5
    //   646: aload 31
    //   648: ldc_w 781
    //   651: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   654: istore 7
    //   656: aload 31
    //   658: ldc_w 783
    //   661: invokevirtual 786	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   664: ifeq +2525 -> 3189
    //   667: aload 31
    //   669: ldc_w 783
    //   672: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   675: istore 6
    //   677: iload 6
    //   679: ifeq +435 -> 1114
    //   682: iconst_1
    //   683: istore 6
    //   685: aload 29
    //   687: astore 27
    //   689: aload 29
    //   691: astore 28
    //   693: iload 20
    //   695: istore 19
    //   697: aload 31
    //   699: ldc_w 788
    //   702: invokevirtual 786	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   705: ifeq +21 -> 726
    //   708: aload 29
    //   710: astore 28
    //   712: iload 20
    //   714: istore 19
    //   716: aload 31
    //   718: ldc_w 788
    //   721: invokevirtual 698	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   724: astore 27
    //   726: aload 27
    //   728: astore 28
    //   730: iload 20
    //   732: istore 19
    //   734: aload 31
    //   736: ldc_w 790
    //   739: invokevirtual 786	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   742: ifeq +28 -> 770
    //   745: aload 27
    //   747: astore 28
    //   749: iload 20
    //   751: istore 19
    //   753: aload 31
    //   755: ldc_w 790
    //   758: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   761: ifeq +359 -> 1120
    //   764: iconst_1
    //   765: istore 18
    //   767: goto +2428 -> 3195
    //   770: aload 27
    //   772: astore 28
    //   774: iload 18
    //   776: istore 19
    //   778: aload 31
    //   780: ldc_w 792
    //   783: invokevirtual 786	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   786: ifeq +2397 -> 3183
    //   789: aload 27
    //   791: astore 28
    //   793: iload 18
    //   795: istore 19
    //   797: aload 31
    //   799: ldc_w 792
    //   802: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   805: istore 8
    //   807: iload 8
    //   809: ifeq +317 -> 1126
    //   812: iconst_1
    //   813: istore 19
    //   815: iload 7
    //   817: istore 8
    //   819: iload 6
    //   821: istore 9
    //   823: iload 5
    //   825: istore 7
    //   827: iload 8
    //   829: istore 6
    //   831: iload 9
    //   833: istore 5
    //   835: aload 31
    //   837: ldc_w 794
    //   840: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   843: istore 8
    //   845: iconst_0
    //   846: istore 9
    //   848: aload 31
    //   850: ldc_w 796
    //   853: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   856: istore 10
    //   858: iload 10
    //   860: istore 9
    //   862: getstatic 39	com/tencent/smtt/sdk/TbsDownloader:f	Ljava/lang/Object;
    //   865: astore 28
    //   867: aload 28
    //   869: monitorenter
    //   870: iload 5
    //   872: ifeq +19 -> 891
    //   875: aload 30
    //   877: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   880: ldc_w 798
    //   883: ldc 136
    //   885: invokeinterface 261 3 0
    //   890: pop
    //   891: aload 27
    //   893: invokestatic 528	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   896: ifne +58 -> 954
    //   899: aload 27
    //   901: invokevirtual 799	java/lang/String:length	()I
    //   904: bipush 96
    //   906: if_icmpne +48 -> 954
    //   909: new 107	java/lang/StringBuilder
    //   912: dup
    //   913: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   916: aload 27
    //   918: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: ldc_w 801
    //   924: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: invokestatic 805	com/tencent/smtt/utils/g:c	()Ljava/lang/String;
    //   930: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   936: astore 27
    //   938: aload 30
    //   940: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   943: ldc_w 798
    //   946: aload 27
    //   948: invokeinterface 261 3 0
    //   953: pop
    //   954: aload 28
    //   956: monitorexit
    //   957: iload 7
    //   959: iconst_1
    //   960: if_icmpne +244 -> 1204
    //   963: iload_2
    //   964: ifeq +224 -> 1188
    //   967: aload 30
    //   969: bipush 146
    //   971: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   974: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   977: astore_0
    //   978: iload 9
    //   980: iconst_1
    //   981: if_icmpne +218 -> 1199
    //   984: iconst_1
    //   985: istore_3
    //   986: aload_0
    //   987: iload_3
    //   988: invokestatic 809	com/tencent/smtt/sdk/QbSdk:reset	(Landroid/content/Context;Z)V
    //   991: ldc 12
    //   993: new 107	java/lang/StringBuilder
    //   996: dup
    //   997: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1000: ldc_w 811
    //   1003: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: iload_2
    //   1007: invokevirtual 162	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1010: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1013: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1016: iconst_0
    //   1017: ireturn
    //   1018: iconst_0
    //   1019: istore 18
    //   1021: goto -655 -> 366
    //   1024: astore_0
    //   1025: ldc_w 813
    //   1028: new 107	java/lang/StringBuilder
    //   1031: dup
    //   1032: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1035: ldc_w 815
    //   1038: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: aload_0
    //   1042: invokevirtual 816	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1045: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1051: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1054: goto -676 -> 378
    //   1057: iconst_0
    //   1058: istore 18
    //   1060: goto -657 -> 403
    //   1063: iconst_0
    //   1064: istore 18
    //   1066: goto -612 -> 454
    //   1069: iconst_0
    //   1070: istore 18
    //   1072: goto -567 -> 505
    //   1075: iconst_0
    //   1076: istore 18
    //   1078: goto -516 -> 562
    //   1081: astore_0
    //   1082: ldc_w 813
    //   1085: new 107	java/lang/StringBuilder
    //   1088: dup
    //   1089: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1092: ldc_w 815
    //   1095: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: aload_0
    //   1099: invokevirtual 816	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1102: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1108: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1111: goto -503 -> 608
    //   1114: iconst_0
    //   1115: istore 6
    //   1117: goto -432 -> 685
    //   1120: iconst_0
    //   1121: istore 18
    //   1123: goto +2072 -> 3195
    //   1126: iconst_0
    //   1127: istore 19
    //   1129: goto -314 -> 815
    //   1132: astore_0
    //   1133: iconst_1
    //   1134: istore 18
    //   1136: iconst_0
    //   1137: istore 5
    //   1139: ldc 136
    //   1141: astore_0
    //   1142: iload 8
    //   1144: istore 7
    //   1146: iload 6
    //   1148: istore 8
    //   1150: aload 27
    //   1152: astore 28
    //   1154: iload 7
    //   1156: istore 6
    //   1158: iconst_1
    //   1159: istore 19
    //   1161: aload_0
    //   1162: astore 27
    //   1164: iload 8
    //   1166: istore 7
    //   1168: aload 28
    //   1170: astore_0
    //   1171: goto -336 -> 835
    //   1174: astore 28
    //   1176: iconst_0
    //   1177: istore 8
    //   1179: goto -334 -> 845
    //   1182: astore_0
    //   1183: aload 28
    //   1185: monitorexit
    //   1186: aload_0
    //   1187: athrow
    //   1188: aload 30
    //   1190: sipush -210
    //   1193: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1196: goto -222 -> 974
    //   1199: iconst_0
    //   1200: istore_3
    //   1201: goto -215 -> 986
    //   1204: iload 18
    //   1206: ifne +10 -> 1216
    //   1209: aload 30
    //   1211: iload 18
    //   1213: invokevirtual 819	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockEnable	(Z)V
    //   1216: iload 19
    //   1218: ifne +10 -> 1228
    //   1221: aload 30
    //   1223: iload 19
    //   1225: invokevirtual 822	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockWaitEnable	(Z)V
    //   1228: iload 8
    //   1230: iconst_1
    //   1231: if_icmpne +9 -> 1240
    //   1234: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1237: invokestatic 825	com/tencent/smtt/sdk/QbSdk:resetDecoupleCore	(Landroid/content/Context;)V
    //   1240: iload 6
    //   1242: iconst_1
    //   1243: if_icmpne +22 -> 1265
    //   1246: getstatic 463	com/tencent/smtt/sdk/TbsDownloader:d	Landroid/os/Handler;
    //   1249: bipush 104
    //   1251: invokevirtual 469	android/os/Handler:removeMessages	(I)V
    //   1254: getstatic 463	com/tencent/smtt/sdk/TbsDownloader:d	Landroid/os/Handler;
    //   1257: bipush 104
    //   1259: invokestatic 475	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   1262: invokevirtual 488	android/os/Message:sendToTarget	()V
    //   1265: iload 17
    //   1267: iconst_1
    //   1268: if_icmpne +1904 -> 3172
    //   1271: lload 21
    //   1273: ldc2_w 826
    //   1276: lcmp
    //   1277: ifle +1903 -> 3180
    //   1280: ldc2_w 826
    //   1283: lstore 21
    //   1285: lload 21
    //   1287: lconst_0
    //   1288: lcmp
    //   1289: ifle +1883 -> 3172
    //   1292: invokestatic 830	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1295: lconst_0
    //   1296: lcmp
    //   1297: iflt +8 -> 1305
    //   1300: invokestatic 830	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1303: lstore 21
    //   1305: aload 30
    //   1307: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1310: ldc_w 832
    //   1313: lload 21
    //   1315: invokestatic 837	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1318: invokeinterface 261 3 0
    //   1323: pop
    //   1324: iconst_0
    //   1325: istore 5
    //   1327: iconst_0
    //   1328: istore 6
    //   1330: iload_2
    //   1331: ifeq +261 -> 1592
    //   1334: aload 31
    //   1336: ldc_w 839
    //   1339: invokevirtual 690	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1342: istore 7
    //   1344: iload 7
    //   1346: istore 5
    //   1348: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1351: invokestatic 170	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1354: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1357: ldc_w 308
    //   1360: iconst_0
    //   1361: invokeinterface 295 3 0
    //   1366: istore 7
    //   1368: iload 7
    //   1370: istore 6
    //   1372: iload 5
    //   1374: istore 7
    //   1376: iload_2
    //   1377: ifeq +36 -> 1413
    //   1380: iload 5
    //   1382: istore 7
    //   1384: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1387: invokestatic 235	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1390: ifne +23 -> 1413
    //   1393: iload 5
    //   1395: istore 7
    //   1397: iload 5
    //   1399: ifne +14 -> 1413
    //   1402: invokestatic 351	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   1405: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1408: invokevirtual 354	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;)I
    //   1411: istore 7
    //   1413: ldc 12
    //   1415: new 107	java/lang/StringBuilder
    //   1418: dup
    //   1419: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1422: ldc_w 841
    //   1425: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: iload 7
    //   1430: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1433: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1436: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1439: aload 30
    //   1441: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1444: ldc_w 843
    //   1447: iload 7
    //   1449: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1452: invokeinterface 261 3 0
    //   1457: pop
    //   1458: aload 30
    //   1460: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1463: ldc_w 308
    //   1466: iload 6
    //   1468: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1471: invokeinterface 261 3 0
    //   1476: pop
    //   1477: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1480: invokestatic 235	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1483: ifne +46 -> 1529
    //   1486: iload 7
    //   1488: ifle +131 -> 1619
    //   1491: iload 7
    //   1493: invokestatic 351	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   1496: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1499: invokevirtual 354	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;)I
    //   1502: if_icmpeq +117 -> 1619
    //   1505: iload 7
    //   1507: invokestatic 351	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   1510: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1513: invokevirtual 386	com/tencent/smtt/sdk/p:i	(Landroid/content/Context;)I
    //   1516: if_icmpne +103 -> 1619
    //   1519: invokestatic 351	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   1522: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1525: invokevirtual 846	com/tencent/smtt/sdk/p:n	(Landroid/content/Context;)Z
    //   1528: pop
    //   1529: aload 32
    //   1531: invokestatic 528	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1534: ifeq +110 -> 1644
    //   1537: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1540: invokestatic 235	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1543: ifeq +101 -> 1644
    //   1546: aload 30
    //   1548: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1551: ldc_w 848
    //   1554: iconst_0
    //   1555: invokestatic 514	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1558: invokeinterface 261 3 0
    //   1563: pop
    //   1564: aload 30
    //   1566: invokevirtual 264	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1569: iload_2
    //   1570: ifeq +12 -> 1582
    //   1573: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1576: iload 11
    //   1578: iconst_0
    //   1579: invokestatic 852	com/tencent/smtt/sdk/TbsShareManager:writeCoreInfoForThirdPartyApp	(Landroid/content/Context;IZ)V
    //   1582: ldc 12
    //   1584: ldc_w 854
    //   1587: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1590: iconst_0
    //   1591: ireturn
    //   1592: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1595: invokestatic 170	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1598: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1601: ldc_w 843
    //   1604: iconst_0
    //   1605: invokeinterface 295 3 0
    //   1610: istore 7
    //   1612: iload 7
    //   1614: istore 5
    //   1616: goto -268 -> 1348
    //   1619: iload 7
    //   1621: ifne -92 -> 1529
    //   1624: invokestatic 351	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   1627: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1630: invokevirtual 858	com/tencent/smtt/sdk/p:p	(Landroid/content/Context;)Ljava/io/File;
    //   1633: invokestatic 861	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   1636: goto -107 -> 1529
    //   1639: astore 27
    //   1641: goto -112 -> 1529
    //   1644: ldc 12
    //   1646: new 107	java/lang/StringBuilder
    //   1649: dup
    //   1650: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1653: ldc_w 863
    //   1656: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1659: iload 12
    //   1661: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1664: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1667: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1670: iload 12
    //   1672: ifne +122 -> 1794
    //   1675: aload 30
    //   1677: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1680: ldc_w 865
    //   1683: iload 12
    //   1685: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1688: invokeinterface 261 3 0
    //   1693: pop
    //   1694: aload 30
    //   1696: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1699: ldc_w 848
    //   1702: iconst_0
    //   1703: invokestatic 514	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1706: invokeinterface 261 3 0
    //   1711: pop
    //   1712: iload_2
    //   1713: ifeq +50 -> 1763
    //   1716: aload 30
    //   1718: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1721: ldc_w 867
    //   1724: bipush 145
    //   1726: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1729: invokeinterface 261 3 0
    //   1734: pop
    //   1735: aload 30
    //   1737: invokevirtual 264	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1740: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1743: invokestatic 235	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1746: ifne +7 -> 1753
    //   1749: invokestatic 870	com/tencent/smtt/sdk/TbsDownloader:startDecoupleCoreIfNeeded	()Z
    //   1752: pop
    //   1753: ldc 12
    //   1755: ldc_w 872
    //   1758: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1761: iconst_0
    //   1762: ireturn
    //   1763: aload 30
    //   1765: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1768: ldc_w 867
    //   1771: sipush -211
    //   1774: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1777: invokeinterface 261 3 0
    //   1782: pop
    //   1783: aload 30
    //   1785: sipush -211
    //   1788: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1791: goto -56 -> 1735
    //   1794: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1797: invokestatic 170	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1800: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1803: ldc_w 384
    //   1806: iconst_0
    //   1807: invokeinterface 295 3 0
    //   1812: istore 8
    //   1814: iload 8
    //   1816: iload 11
    //   1818: if_icmple +18 -> 1836
    //   1821: getstatic 318	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/l;
    //   1824: invokevirtual 874	com/tencent/smtt/sdk/l:c	()V
    //   1827: invokestatic 351	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   1830: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1833: invokevirtual 877	com/tencent/smtt/sdk/p:o	(Landroid/content/Context;)V
    //   1836: iconst_0
    //   1837: istore 5
    //   1839: iconst_0
    //   1840: istore 7
    //   1842: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1845: invokestatic 235	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1848: ifne +66 -> 1914
    //   1851: invokestatic 351	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   1854: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1857: iconst_0
    //   1858: invokevirtual 880	com/tencent/smtt/sdk/p:e	(Landroid/content/Context;I)I
    //   1861: istore 9
    //   1863: iload 7
    //   1865: istore 5
    //   1867: iload 9
    //   1869: iload 11
    //   1871: if_icmplt +6 -> 1877
    //   1874: iconst_1
    //   1875: istore 5
    //   1877: ldc 12
    //   1879: new 107	java/lang/StringBuilder
    //   1882: dup
    //   1883: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1886: ldc_w 882
    //   1889: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1892: iload 9
    //   1894: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1897: ldc_w 884
    //   1900: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1903: iload 11
    //   1905: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1908: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1911: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1914: iload_1
    //   1915: iload 11
    //   1917: if_icmpge +16 -> 1933
    //   1920: aload 32
    //   1922: invokestatic 528	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1925: ifne +8 -> 1933
    //   1928: iload 5
    //   1930: ifeq +274 -> 2204
    //   1933: iload 6
    //   1935: iconst_1
    //   1936: if_icmpeq +268 -> 2204
    //   1939: aload 30
    //   1941: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1944: ldc_w 848
    //   1947: iconst_0
    //   1948: invokestatic 514	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1951: invokeinterface 261 3 0
    //   1956: pop
    //   1957: iload_2
    //   1958: ifeq +172 -> 2130
    //   1961: aload 32
    //   1963: invokestatic 528	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1966: ifeq +87 -> 2053
    //   1969: aload 30
    //   1971: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1974: ldc_w 867
    //   1977: bipush 132
    //   1979: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1982: invokeinterface 261 3 0
    //   1987: pop
    //   1988: aload 30
    //   1990: invokevirtual 264	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1993: ldc 12
    //   1995: new 107	java/lang/StringBuilder
    //   1998: dup
    //   1999: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   2002: ldc_w 886
    //   2005: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2008: iload_1
    //   2009: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2012: ldc_w 888
    //   2015: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2018: iload 11
    //   2020: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2023: ldc_w 890
    //   2026: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2029: iload 8
    //   2031: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2034: ldc_w 892
    //   2037: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2040: aload 32
    //   2042: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2045: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2048: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2051: iconst_0
    //   2052: ireturn
    //   2053: iload 11
    //   2055: ifgt +25 -> 2080
    //   2058: aload 30
    //   2060: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2063: ldc_w 867
    //   2066: bipush 131
    //   2068: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2071: invokeinterface 261 3 0
    //   2076: pop
    //   2077: goto -89 -> 1988
    //   2080: iload_1
    //   2081: iload 11
    //   2083: if_icmplt +25 -> 2108
    //   2086: aload 30
    //   2088: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2091: ldc_w 867
    //   2094: bipush 129
    //   2096: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2099: invokeinterface 261 3 0
    //   2104: pop
    //   2105: goto -117 -> 1988
    //   2108: aload 30
    //   2110: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2113: ldc_w 867
    //   2116: bipush 144
    //   2118: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2121: invokeinterface 261 3 0
    //   2126: pop
    //   2127: goto -139 -> 1988
    //   2130: sipush -212
    //   2133: istore 5
    //   2135: aload 32
    //   2137: invokestatic 528	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2140: ifeq +37 -> 2177
    //   2143: sipush -217
    //   2146: istore 5
    //   2148: aload 30
    //   2150: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2153: ldc_w 867
    //   2156: iload 5
    //   2158: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2161: invokeinterface 261 3 0
    //   2166: pop
    //   2167: aload 30
    //   2169: iload 5
    //   2171: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2174: goto -186 -> 1988
    //   2177: iload 11
    //   2179: ifgt +11 -> 2190
    //   2182: sipush -218
    //   2185: istore 5
    //   2187: goto -39 -> 2148
    //   2190: iload_1
    //   2191: iload 11
    //   2193: if_icmplt -45 -> 2148
    //   2196: sipush -219
    //   2199: istore 5
    //   2201: goto -53 -> 2148
    //   2204: aload 32
    //   2206: aload 30
    //   2208: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2211: ldc_w 894
    //   2214: aconst_null
    //   2215: invokeinterface 285 3 0
    //   2220: invokevirtual 80	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2223: ifne +45 -> 2268
    //   2226: getstatic 318	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/l;
    //   2229: invokevirtual 874	com/tencent/smtt/sdk/l:c	()V
    //   2232: aload 30
    //   2234: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2237: ldc_w 896
    //   2240: iconst_0
    //   2241: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2244: invokeinterface 261 3 0
    //   2249: pop
    //   2250: aload 30
    //   2252: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2255: ldc_w 898
    //   2258: iconst_0
    //   2259: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2262: invokeinterface 261 3 0
    //   2267: pop
    //   2268: aload 30
    //   2270: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2273: ldc_w 384
    //   2276: iload 11
    //   2278: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2281: invokeinterface 261 3 0
    //   2286: pop
    //   2287: ldc 12
    //   2289: new 107	java/lang/StringBuilder
    //   2292: dup
    //   2293: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   2296: ldc_w 900
    //   2299: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2302: iload 11
    //   2304: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2307: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2310: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2313: iload 11
    //   2315: ifle +53 -> 2368
    //   2318: iload 6
    //   2320: iconst_1
    //   2321: if_icmpne +346 -> 2667
    //   2324: aload 30
    //   2326: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2329: ldc_w 902
    //   2332: iconst_1
    //   2333: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2336: invokeinterface 261 3 0
    //   2341: pop
    //   2342: ldc 12
    //   2344: new 107	java/lang/StringBuilder
    //   2347: dup
    //   2348: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   2351: ldc_w 904
    //   2354: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2357: iload 6
    //   2359: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2362: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2365: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2368: aload 30
    //   2370: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2373: ldc_w 894
    //   2376: aload 32
    //   2378: invokeinterface 261 3 0
    //   2383: pop
    //   2384: aload 30
    //   2386: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2389: ldc_w 906
    //   2392: aload 33
    //   2394: invokeinterface 261 3 0
    //   2399: pop
    //   2400: aload 30
    //   2402: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2405: ldc_w 865
    //   2408: iload 12
    //   2410: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2413: invokeinterface 261 3 0
    //   2418: pop
    //   2419: aload 30
    //   2421: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2424: ldc_w 908
    //   2427: iload 13
    //   2429: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2432: invokeinterface 261 3 0
    //   2437: pop
    //   2438: aload 30
    //   2440: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2443: ldc_w 910
    //   2446: iload 14
    //   2448: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2451: invokeinterface 261 3 0
    //   2456: pop
    //   2457: aload 30
    //   2459: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2462: ldc_w 912
    //   2465: iload 15
    //   2467: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2470: invokeinterface 261 3 0
    //   2475: pop
    //   2476: aload 30
    //   2478: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2481: ldc_w 914
    //   2484: iload 16
    //   2486: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2489: invokeinterface 261 3 0
    //   2494: pop
    //   2495: aload 30
    //   2497: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2500: ldc_w 916
    //   2503: lload 23
    //   2505: invokestatic 837	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2508: invokeinterface 261 3 0
    //   2513: pop
    //   2514: aload 30
    //   2516: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2519: ldc_w 918
    //   2522: lload 25
    //   2524: invokestatic 837	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2527: invokeinterface 261 3 0
    //   2532: pop
    //   2533: aload 30
    //   2535: invokevirtual 264	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2538: aload_0
    //   2539: ifnull +18 -> 2557
    //   2542: aload 30
    //   2544: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2547: ldc_w 920
    //   2550: aload_0
    //   2551: invokeinterface 261 3 0
    //   2556: pop
    //   2557: iload_3
    //   2558: ifne +161 -> 2719
    //   2561: iload 4
    //   2563: ifeq +156 -> 2719
    //   2566: invokestatic 351	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   2569: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2572: iload 11
    //   2574: invokevirtual 922	com/tencent/smtt/sdk/p:b	(Landroid/content/Context;I)Z
    //   2577: ifeq +142 -> 2719
    //   2580: iload_2
    //   2581: ifeq +107 -> 2688
    //   2584: aload 30
    //   2586: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2589: ldc_w 867
    //   2592: bipush 143
    //   2594: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2597: invokeinterface 261 3 0
    //   2602: pop
    //   2603: aload 30
    //   2605: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2608: ldc_w 848
    //   2611: iconst_0
    //   2612: invokestatic 514	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2615: invokeinterface 261 3 0
    //   2620: pop
    //   2621: ldc 12
    //   2623: ldc_w 924
    //   2626: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2629: aload 31
    //   2631: ldc_w 926
    //   2634: iconst_0
    //   2635: invokevirtual 729	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2638: iconst_1
    //   2639: if_icmpne +21 -> 2660
    //   2642: aload 30
    //   2644: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2647: ldc_w 928
    //   2650: iconst_1
    //   2651: invokestatic 514	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2654: invokeinterface 261 3 0
    //   2659: pop
    //   2660: aload 30
    //   2662: invokevirtual 264	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2665: iconst_1
    //   2666: ireturn
    //   2667: aload 30
    //   2669: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2672: ldc_w 902
    //   2675: iconst_0
    //   2676: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2679: invokeinterface 261 3 0
    //   2684: pop
    //   2685: goto -343 -> 2342
    //   2688: aload 30
    //   2690: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2693: ldc_w 867
    //   2696: sipush -213
    //   2699: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2702: invokeinterface 261 3 0
    //   2707: pop
    //   2708: aload 30
    //   2710: sipush -213
    //   2713: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2716: goto -113 -> 2603
    //   2719: iload_3
    //   2720: ifne +155 -> 2875
    //   2723: iload 4
    //   2725: ifeq +150 -> 2875
    //   2728: getstatic 318	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/l;
    //   2731: astore_0
    //   2732: iload 12
    //   2734: iconst_1
    //   2735: if_icmpeq +9 -> 2744
    //   2738: iload 12
    //   2740: iconst_2
    //   2741: if_icmpne +112 -> 2853
    //   2744: iconst_1
    //   2745: istore 4
    //   2747: aload_0
    //   2748: iload_3
    //   2749: iload 4
    //   2751: invokevirtual 931	com/tencent/smtt/sdk/l:a	(ZZ)Z
    //   2754: ifeq +121 -> 2875
    //   2757: aload 30
    //   2759: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2762: ldc_w 848
    //   2765: iconst_0
    //   2766: invokestatic 514	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2769: invokeinterface 261 3 0
    //   2774: pop
    //   2775: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2778: invokestatic 622	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2781: invokevirtual 626	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2784: astore_0
    //   2785: aload_0
    //   2786: bipush 100
    //   2788: invokevirtual 631	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   2791: aload_0
    //   2792: new 107	java/lang/StringBuilder
    //   2795: dup
    //   2796: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   2799: ldc_w 933
    //   2802: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2805: getstatic 318	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/l;
    //   2808: getfield 935	com/tencent/smtt/sdk/l:a	Ljava/lang/String;
    //   2811: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2814: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2817: invokevirtual 635	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   2820: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2823: invokestatic 937	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   2826: ifeq +33 -> 2859
    //   2829: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2832: invokestatic 622	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2835: getstatic 940	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2838: aload_0
    //   2839: invokevirtual 645	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2842: ldc 12
    //   2844: ldc_w 942
    //   2847: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2850: goto -221 -> 2629
    //   2853: iconst_0
    //   2854: istore 4
    //   2856: goto -109 -> 2747
    //   2859: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2862: invokestatic 622	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2865: getstatic 641	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2868: aload_0
    //   2869: invokevirtual 645	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2872: goto -30 -> 2842
    //   2875: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2878: invokestatic 170	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2881: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2884: ldc_w 902
    //   2887: iconst_0
    //   2888: invokeinterface 295 3 0
    //   2893: iconst_1
    //   2894: if_icmpne +124 -> 3018
    //   2897: getstatic 318	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/l;
    //   2900: invokevirtual 944	com/tencent/smtt/sdk/l:a	()Z
    //   2903: ifeq +115 -> 3018
    //   2906: aload 30
    //   2908: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2911: ldc_w 848
    //   2914: iconst_0
    //   2915: invokestatic 514	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2918: invokeinterface 261 3 0
    //   2923: pop
    //   2924: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2927: invokestatic 622	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2930: invokevirtual 626	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2933: astore_0
    //   2934: aload_0
    //   2935: bipush 100
    //   2937: invokevirtual 631	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   2940: aload_0
    //   2941: new 107	java/lang/StringBuilder
    //   2944: dup
    //   2945: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   2948: ldc_w 946
    //   2951: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2954: getstatic 318	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/l;
    //   2957: getfield 935	com/tencent/smtt/sdk/l:a	Ljava/lang/String;
    //   2960: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2963: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2966: invokevirtual 635	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   2969: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2972: invokestatic 937	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   2975: ifeq +27 -> 3002
    //   2978: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2981: invokestatic 622	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2984: getstatic 940	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2987: aload_0
    //   2988: invokevirtual 645	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2991: ldc 12
    //   2993: ldc_w 948
    //   2996: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2999: goto -370 -> 2629
    //   3002: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3005: invokestatic 622	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3008: getstatic 641	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3011: aload_0
    //   3012: invokevirtual 645	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3015: goto -24 -> 2991
    //   3018: iload_2
    //   3019: ifne +11 -> 3030
    //   3022: aload 30
    //   3024: sipush -216
    //   3027: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3030: aload 30
    //   3032: getfield 253	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3035: ldc_w 848
    //   3038: iconst_1
    //   3039: invokestatic 514	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3042: invokeinterface 261 3 0
    //   3047: pop
    //   3048: ldc 12
    //   3050: ldc_w 950
    //   3053: invokestatic 125	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3056: goto -427 -> 2629
    //   3059: astore 27
    //   3061: goto -1689 -> 1372
    //   3064: astore 27
    //   3066: goto -1718 -> 1348
    //   3069: astore 28
    //   3071: goto -2209 -> 862
    //   3074: astore 27
    //   3076: aload_0
    //   3077: astore 27
    //   3079: iconst_0
    //   3080: istore 5
    //   3082: ldc 136
    //   3084: astore_0
    //   3085: iconst_1
    //   3086: istore 18
    //   3088: iload 8
    //   3090: istore 7
    //   3092: goto -1946 -> 1146
    //   3095: astore 27
    //   3097: iload 5
    //   3099: istore 6
    //   3101: aload_0
    //   3102: astore 27
    //   3104: ldc 136
    //   3106: astore_0
    //   3107: iconst_1
    //   3108: istore 18
    //   3110: iconst_0
    //   3111: istore 5
    //   3113: iload 8
    //   3115: istore 7
    //   3117: goto -1971 -> 1146
    //   3120: astore 27
    //   3122: iload 5
    //   3124: istore 6
    //   3126: aload_0
    //   3127: astore 27
    //   3129: iconst_1
    //   3130: istore 18
    //   3132: iconst_0
    //   3133: istore 5
    //   3135: ldc 136
    //   3137: astore_0
    //   3138: goto -1992 -> 1146
    //   3141: astore 27
    //   3143: iload 19
    //   3145: istore 18
    //   3147: iload 5
    //   3149: istore 8
    //   3151: aload_0
    //   3152: astore 27
    //   3154: aload 28
    //   3156: astore_0
    //   3157: iload 6
    //   3159: istore 5
    //   3161: iload 8
    //   3163: istore 6
    //   3165: goto -2019 -> 1146
    //   3168: astore_0
    //   3169: goto -2870 -> 299
    //   3172: ldc2_w 951
    //   3175: lstore 21
    //   3177: goto -1885 -> 1292
    //   3180: goto -1895 -> 1285
    //   3183: iconst_1
    //   3184: istore 19
    //   3186: goto -2371 -> 815
    //   3189: iconst_0
    //   3190: istore 6
    //   3192: goto -2507 -> 685
    //   3195: goto -2425 -> 770
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3198	0	paramString	String
    //   0	3198	1	paramInt	int
    //   0	3198	2	paramBoolean1	boolean
    //   0	3198	3	paramBoolean2	boolean
    //   0	3198	4	paramBoolean3	boolean
    //   101	3059	5	m	int
    //   293	2898	6	n	int
    //   654	2462	7	i1	int
    //   615	2547	8	i2	int
    //   821	1072	9	i3	int
    //   856	3	10	i4	int
    //   198	2375	11	i5	int
    //   166	2576	12	i6	int
    //   208	2220	13	i7	int
    //   218	2229	14	i8	int
    //   228	2238	15	i9	int
    //   238	2247	16	i10	int
    //   280	989	17	i11	int
    //   364	2782	18	bool1	boolean
    //   695	2490	19	bool2	boolean
    //   618	132	20	bool3	boolean
    //   269	2907	21	l1	long
    //   248	2256	23	l2	long
    //   258	2265	25	l3	long
    //   355	808	27	localObject1	Object
    //   1639	1	27	localThrowable	Throwable
    //   3059	1	27	localException1	Exception
    //   3064	1	27	localException2	Exception
    //   3074	1	27	localException3	Exception
    //   3077	1	27	str1	String
    //   3095	1	27	localException4	Exception
    //   3102	1	27	str2	String
    //   3120	1	27	localException5	Exception
    //   3127	1	27	str3	String
    //   3141	1	27	localException6	Exception
    //   3152	1	27	str4	String
    //   691	478	28	localObject2	Object
    //   1174	10	28	localException7	Exception
    //   3069	86	28	localException8	Exception
    //   625	84	29	str5	String
    //   42	2989	30	localTbsDownloadConfig	TbsDownloadConfig
    //   91	2539	31	localJSONObject	JSONObject
    //   176	2201	32	str6	String
    //   188	2205	33	str7	String
    // Exception table:
    //   from	to	target	type
    //   337	357	1024	java/lang/Throwable
    //   366	378	1024	java/lang/Throwable
    //   382	393	1081	java/lang/Throwable
    //   403	444	1081	java/lang/Throwable
    //   454	495	1081	java/lang/Throwable
    //   505	551	1081	java/lang/Throwable
    //   562	608	1081	java/lang/Throwable
    //   627	636	1132	java/lang/Exception
    //   835	845	1174	java/lang/Exception
    //   875	891	1182	finally
    //   891	954	1182	finally
    //   954	957	1182	finally
    //   1183	1186	1182	finally
    //   1624	1636	1639	java/lang/Throwable
    //   1348	1368	3059	java/lang/Exception
    //   1334	1344	3064	java/lang/Exception
    //   1592	1612	3064	java/lang/Exception
    //   848	858	3069	java/lang/Exception
    //   636	646	3074	java/lang/Exception
    //   646	656	3095	java/lang/Exception
    //   656	677	3120	java/lang/Exception
    //   697	708	3141	java/lang/Exception
    //   716	726	3141	java/lang/Exception
    //   734	745	3141	java/lang/Exception
    //   753	764	3141	java/lang/Exception
    //   778	789	3141	java/lang/Exception
    //   797	807	3141	java/lang/Exception
    //   285	295	3168	java/lang/Exception
  }
  
  protected static File b(int paramInt)
  {
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    Object localObject = null;
    int n = arrayOfString.length;
    int m = 0;
    for (;;)
    {
      String str1;
      String str2;
      if (m < n)
      {
        str1 = arrayOfString[m];
        str2 = FileUtil.a(c, str1, 4, false);
        if (!getOverSea(c)) {
          break label110;
        }
      }
      label110:
      for (localObject = "x5.oversea.tbs.org";; localObject = getBackupFileName(false))
      {
        localObject = new File(str2, (String)localObject);
        if ((localObject == null) || (!((File)localObject).exists()) || (a.a(c, (File)localObject) != paramInt)) {
          break;
        }
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject).getAbsolutePath());
        return localObject;
      }
      localObject = new File(FileUtil.a(c, str1, 4, false), "x5.tbs.decouple");
      if ((localObject != null) && (((File)localObject).exists()) && (a.a(c, (File)localObject) == paramInt))
      {
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject).getAbsolutePath());
        return localObject;
      }
      m += 1;
    }
  }
  
  static String b(Context paramContext)
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    Locale localLocale = Locale.getDefault();
    localStringBuffer = new StringBuffer();
    paramContext = Build.VERSION.RELEASE;
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        String str;
        continue;
        if (paramContext.length() > 0)
        {
          localStringBuffer.append(paramContext);
        }
        else
        {
          localStringBuffer.append("1.0");
          continue;
          localStringBuffer.append("en");
        }
      }
    }
    if (paramContext == null)
    {
      localStringBuffer.append("1.0");
      localStringBuffer.append("; ");
      paramContext = localLocale.getLanguage();
      if (paramContext == null) {
        break label252;
      }
      localStringBuffer.append(paramContext.toLowerCase());
      paramContext = localLocale.getCountry();
      if (paramContext != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append(paramContext.toLowerCase());
      }
      if ("REL".equals(Build.VERSION.CODENAME)) {
        paramContext = Build.MODEL;
      }
    }
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        continue;
        if (paramContext.length() > 0)
        {
          localStringBuffer.append("; ");
          localStringBuffer.append(paramContext);
          continue;
          paramContext = Build.ID;
          continue;
          if (paramContext.length() > 0)
          {
            localStringBuffer.append(" Build/");
            localStringBuffer.append(paramContext);
          }
        }
      }
    }
    if (paramContext == null)
    {
      localStringBuffer.append("; ");
      if (Build.ID != null) {
        break label291;
      }
      paramContext = "";
      paramContext = paramContext.replaceAll("[一-龥]", "");
      if (paramContext != null) {
        break label298;
      }
      localStringBuffer.append(" Build/");
      localStringBuffer.append("00");
      paramContext = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[] { localStringBuffer });
      b = paramContext;
      return paramContext;
    }
  }
  
  private static void b(JSONArray paramJSONArray)
  {
    int i1 = 0;
    int i2;
    int m;
    if (TbsShareManager.getHostCorePathAppDefined() != null)
    {
      i2 = p.a().a(TbsShareManager.getHostCorePathAppDefined());
      m = 0;
    }
    for (;;)
    {
      int n = i1;
      if (m < paramJSONArray.length())
      {
        if (paramJSONArray.optInt(m) == i2) {
          n = 1;
        }
      }
      else
      {
        if (n == 0) {
          paramJSONArray.put(i2);
        }
        return;
      }
      m += 1;
    }
  }
  
  private static boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(144));
      ((TbsDownloadUpload)localObject1).commit();
      if ((QbSdk.n == null) || (!QbSdk.n.containsKey("SET_SENDREQUEST_AND_UPLOAD")) || (!QbSdk.n.get("SET_SENDREQUEST_AND_UPLOAD").equals("false"))) {
        break label204;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
      if (!paramBoolean1) {
        break label164;
      }
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(145));
      ((TbsDownloadUpload)localObject1).commit();
    }
    for (;;)
    {
      return false;
      if (paramBoolean3) {
        break;
      }
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(164));
      ((TbsDownloadUpload)localObject1).commit();
      break;
      label164:
      if (!paramBoolean3)
      {
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(165));
        ((TbsDownloadUpload)localObject1).commit();
      }
    }
    label204:
    TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest]isQuery: " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
    if (p.a().c(c))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
      if (paramBoolean1)
      {
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(146));
        ((TbsDownloadUpload)localObject1).commit();
      }
      for (;;)
      {
        return false;
        if (!paramBoolean3)
        {
          localObject1 = TbsDownloadUpload.getInstance(c);
          ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(166));
          ((TbsDownloadUpload)localObject1).commit();
        }
      }
    }
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    Object localObject2 = FileUtil.a(c, 1);
    if (getOverSea(c)) {
      localObject1 = "x5.oversea.tbs.org";
    }
    for (;;)
    {
      localObject2 = new File((String)localObject2, (String)localObject1);
      Object localObject3 = FileUtil.a(c, 2);
      label402:
      label437:
      label472:
      label509:
      int n;
      if (getOverSea(c))
      {
        localObject1 = "x5.oversea.tbs.org";
        localObject3 = new File((String)localObject3, (String)localObject1);
        Object localObject4 = FileUtil.a(c, 3);
        if (!getOverSea(c)) {
          break label1008;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject4 = new File((String)localObject4, (String)localObject1);
        String str2 = FileUtil.a(c, 4);
        if (!getOverSea(c)) {
          break label1017;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject1 = new File(str2, (String)localObject1);
        if (!((File)localObject1).exists())
        {
          if (!((File)localObject4).exists()) {
            break label1026;
          }
          ((File)localObject4).renameTo((File)localObject1);
        }
        if (e == null)
        {
          e = b.b();
          localTbsDownloadConfig.mSyncMap.put("device_cpuabi", e);
          localTbsDownloadConfig.commit();
        }
        n = 0;
        m = n;
        if (!TextUtils.isEmpty(e)) {
          localObject1 = null;
        }
      }
      try
      {
        localObject2 = Pattern.compile("i686|mips|x86_64").matcher(e);
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        label580:
        break label580;
      }
      int m = n;
      if (localObject1 != null)
      {
        m = n;
        if (((Matcher)localObject1).find())
        {
          if (!TbsShareManager.isThirdPartyApp(c)) {
            break label1083;
          }
          TbsLog.e("TbsDownload", "don't support x86 devices,skip send request");
          localObject1 = TbsLogReport.getInstance(c).tbsLogInfo();
          if (!paramBoolean1) {
            break label1064;
          }
          localTbsDownloadConfig.setDownloadInterruptCode(-104);
          ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-104);
          label647:
          ((TbsLogReport.TbsLogInfo)localObject1).setFailDetail("mycpu is " + e);
          TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject1);
          label688:
          m = 1;
        }
      }
      localTbsDownloadConfig.mSyncMap.put("app_versionname", b.c(c));
      localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(b.d(c)));
      localTbsDownloadConfig.commit();
      localObject1 = a(paramBoolean1, paramBoolean2, paramBoolean3);
      try
      {
        n = ((JSONObject)localObject1).getInt("TBSV");
        if ((m != 0) || (n != -1))
        {
          long l2 = System.currentTimeMillis();
          if (TbsShareManager.isThirdPartyApp(c))
          {
            l1 = localTbsDownloadConfig.mPreferences.getLong("request_fail", 0L);
            long l3 = localTbsDownloadConfig.mPreferences.getLong("count_request_fail_in_24hours", 0L);
            if (l2 - l1 < localTbsDownloadConfig.getRetryInterval() * 1000L)
            {
              l1 = 1L + l3;
              localTbsDownloadConfig.mSyncMap.put("count_request_fail_in_24hours", Long.valueOf(l1));
            }
          }
          else
          {
            localTbsDownloadConfig.mSyncMap.put("request_fail", Long.valueOf(l2));
            localTbsDownloadConfig.mSyncMap.put("app_versionname", b.c(c));
            localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(b.d(c)));
            localTbsDownloadConfig.mSyncMap.put("app_metadata", b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
            localTbsDownloadConfig.commit();
            if (m == 0) {
              break label1162;
            }
            if (!paramBoolean1) {
              break label1122;
            }
            localObject1 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(147));
            ((TbsDownloadUpload)localObject1).commit();
            return false;
            localObject1 = getBackupFileName(false);
            continue;
            localObject1 = getBackupFileName(false);
            break label402;
            label1008:
            localObject1 = getBackupFileName(false);
            break label437;
            label1017:
            localObject1 = getBackupFileName(false);
            break label472;
            label1026:
            if (((File)localObject3).exists())
            {
              ((File)localObject3).renameTo((File)localObject1);
              break label509;
            }
            if (!((File)localObject2).exists()) {
              break label509;
            }
            ((File)localObject2).renameTo((File)localObject1);
            break label509;
            label1064:
            localTbsDownloadConfig.setDownloadInterruptCode(-205);
            ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-205);
            break label647;
            label1083:
            if (paramBoolean1)
            {
              localTbsDownloadConfig.setDownloadInterruptCode(-104);
              break label688;
            }
            localTbsDownloadConfig.setDownloadInterruptCode(-205);
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          n = -1;
          continue;
          long l1 = 1L;
          continue;
          label1122:
          if (!paramBoolean3)
          {
            localObject1 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(167));
            ((TbsDownloadUpload)localObject1).commit();
          }
        }
        label1162:
        if ((n != -1) || (paramBoolean3))
        {
          try
          {
            String str1 = com.tencent.smtt.utils.m.a(c).d();
            TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] postUrl=" + str1);
            if (paramBoolean1)
            {
              localObject3 = TbsDownloadUpload.getInstance(c);
              ((TbsDownloadUpload)localObject3).a.put("tbs_needdownload_code", Integer.valueOf(148));
              ((TbsDownloadUpload)localObject3).a.put("tbs_needdownload_sent", Integer.valueOf(1));
              ((TbsDownloadUpload)localObject3).commit();
              TbsLog.i("TbsDownload", "sendRequest query 148");
            }
            for (;;)
            {
              return a(f.a(str1, ((JSONObject)localObject1).toString().getBytes("utf-8"), new TbsDownloader.3(localTbsDownloadConfig, paramBoolean1), false), n, paramBoolean1, paramBoolean2, paramBoolean4);
              if (!paramBoolean3)
              {
                localObject3 = TbsDownloadUpload.getInstance(c);
                ((TbsDownloadUpload)localObject3).a.put("tbs_startdownload_code", Integer.valueOf(168));
                ((TbsDownloadUpload)localObject3).a.put("tbs_startdownload_sent", Integer.valueOf(1));
                ((TbsDownloadUpload)localObject3).commit();
                TbsLog.i("TbsDownload", "sendRequest download 168");
              }
            }
            localTbsDownloadConfig.setDownloadInterruptCode(-106);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            if (!paramBoolean1) {}
          }
          for (;;)
          {
            return false;
            localTbsDownloadConfig.setDownloadInterruptCode(-206);
          }
        }
        TbsDownloadUpload localTbsDownloadUpload;
        if (paramBoolean1)
        {
          localTbsDownloadUpload = TbsDownloadUpload.getInstance(c);
          localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(149));
          localTbsDownloadUpload.commit();
          return false;
        }
        if (!paramBoolean3)
        {
          localTbsDownloadUpload = TbsDownloadUpload.getInstance(c);
          localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(169));
          localTbsDownloadUpload.commit();
        }
        return false;
      }
    }
  }
  
  private static void c()
  {
    try
    {
      if (h == null) {
        h = n.a();
      }
      try
      {
        g = new l(c);
        d = new TbsDownloader.2(h.getLooper());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i = true;
          TbsLog.e("TbsDownload", "TbsApkDownloader init has Exception");
        }
      }
      return;
    }
    finally {}
  }
  
  @TargetApi(11)
  static void c(Context paramContext)
  {
    TbsDownloadConfig.getInstance(paramContext).clear();
    TbsLogReport.getInstance(paramContext).clear();
    l.c(paramContext);
    SharedPreferences localSharedPreferences;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 4);
      localSharedPreferences.edit().clear().commit();
      if (Build.VERSION.SDK_INT < 11) {
        break label99;
      }
    }
    label99:
    for (paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);; paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0))
    {
      paramContext.edit().clear().commit();
      return;
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 0);
      break;
    }
  }
  
  private static void c(JSONArray paramJSONArray)
  {
    String str;
    int i2;
    Context localContext;
    if (!TbsPVConfig.getInstance(c).isDisableHostBackupCore())
    {
      String[] arrayOfString = e();
      int i1 = arrayOfString.length;
      int m = 0;
      if (m < i1)
      {
        str = arrayOfString[m];
        i2 = TbsShareManager.getBackupCoreVersion(c, str);
        if (i2 > 0)
        {
          localContext = TbsShareManager.getPackageContext(c, str, false);
          if ((localContext != null) && (!p.a().f(localContext))) {
            TbsLog.e("TbsDownload", "host check failed,packageName = " + str);
          }
          for (;;)
          {
            m += 1;
            break;
            if (!a(c, i2)) {
              break label155;
            }
            TbsLog.i("TbsDownload", "add addBackupVersionToJsonData,version+" + i2 + " is in black list");
          }
          label155:
          n = 0;
          label157:
          if (n >= paramJSONArray.length()) {
            break label315;
          }
          if (paramJSONArray.optInt(n) != i2) {
            break label259;
          }
        }
      }
    }
    label259:
    label268:
    label313:
    label315:
    for (int n = 1;; n = 0)
    {
      if (n == 0) {
        paramJSONArray.put(i2);
      }
      i2 = TbsShareManager.getBackupDecoupleCoreVersion(c, str);
      if (i2 <= 0) {
        break;
      }
      localContext = TbsShareManager.getPackageContext(c, str, false);
      if ((localContext != null) && (!p.a().f(localContext)))
      {
        TbsLog.e("TbsDownload", "host check failed,packageName = " + str);
        break;
        n += 1;
        break label157;
      }
      n = 0;
      if (n < paramJSONArray.length()) {
        if (paramJSONArray.optInt(n) != i2) {}
      }
      for (n = 1;; n = 0)
      {
        if (n != 0) {
          break label313;
        }
        paramJSONArray.put(i2);
        break;
        n += 1;
        break label268;
        return;
      }
      break;
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
    catch (Exception localException) {}
    return false;
  }
  
  private static String[] e()
  {
    if (QbSdk.getOnlyDownload()) {
      return new String[] { c.getApplicationContext().getPackageName() };
    }
    String[] arrayOfString1 = TbsShareManager.getCoreProviderAppList();
    String str = c.getApplicationContext().getPackageName();
    if (str.equals(TbsShareManager.f(c)))
    {
      int m = arrayOfString1.length;
      String[] arrayOfString2 = new String[m + 1];
      System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, m);
      arrayOfString2[m] = str;
      return arrayOfString2;
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
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_success_retrytimes", 0) >= localTbsDownloadConfig.getDownloadSuccessMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-115);
      return false;
    }
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_failed_retrytimes", 0) >= localTbsDownloadConfig.getDownloadFailedMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-116);
      return false;
    }
    if (!FileUtil.b(c))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-117);
      return false;
    }
    if (System.currentTimeMillis() - localTbsDownloadConfig.mPreferences.getLong("tbs_downloadstarttime", 0L) <= 86400000L)
    {
      long l1 = localTbsDownloadConfig.mPreferences.getLong("tbs_downloadflow", 0L);
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] downloadFlow=" + l1);
      if (l1 >= localTbsDownloadConfig.getDownloadMaxflow())
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
        localTbsDownloadConfig.setDownloadInterruptCode(-120);
        return false;
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
          TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  first called. sOverSea = " + j);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  sOverSea = " + j);
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
    return (g != null) && (g.d());
  }
  
  public static boolean isDownloading()
  {
    try
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.isDownloading] is " + a);
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
    TbsLog.i("TbsDownload", "needDownload,process=" + QbSdk.getCurrentProcessName(paramContext) + "stack=" + Log.getStackTraceString(new Throwable()));
    TbsDownloadUpload.clear();
    TbsDownloadUpload localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
    localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(140));
    localTbsDownloadUpload.commit();
    TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] oversea=" + paramBoolean1 + ",isDownloadForeground=" + paramBoolean2);
    boolean bool1 = false;
    TbsLog.initIfNeed(paramContext);
    if (p.b)
    {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#1,return " + false);
      localTbsDownloadUpload.a.put("tbs_needdownload_return", Integer.valueOf(171));
      localTbsDownloadUpload.commit();
    }
    TbsDownloadConfig localTbsDownloadConfig;
    do
    {
      return false;
      TbsLog.app_extra("TbsDownload", paramContext);
      c = paramContext.getApplicationContext();
      localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
      localTbsDownloadConfig.setDownloadInterruptCode(-100);
      if (a(c, paramBoolean1)) {
        break;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#2,return " + false);
      localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(141));
      localTbsDownloadUpload.commit();
      localTbsDownloadUpload.a.put("tbs_needdownload_return", Integer.valueOf(172));
      localTbsDownloadUpload.commit();
    } while (paramTbsDownloaderCallback == null);
    paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
    return false;
    c();
    if (i)
    {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      localTbsDownloadConfig.setDownloadInterruptCode(-105);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#3,return " + false);
      localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(142));
      localTbsDownloadUpload.commit();
      localTbsDownloadUpload.a.put("tbs_needdownload_return", Integer.valueOf(173));
      localTbsDownloadUpload.commit();
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      return false;
    }
    boolean bool2 = a(c, paramBoolean2, false);
    TbsLog.i("TbsDownload", "[TbsDownloader.needDownload],needSendRequest=" + bool2);
    if (bool2)
    {
      a(paramBoolean2, paramTbsDownloaderCallback, paramBoolean3);
      localTbsDownloadConfig.setDownloadInterruptCode(-114);
      d.removeMessages(102);
      Message.obtain(d, 102).sendToTarget();
      paramBoolean2 = false;
      if (!QbSdk.c)
      {
        paramBoolean1 = bool1;
        if (TbsShareManager.isThirdPartyApp(paramContext)) {}
      }
      else
      {
        paramBoolean2 = localTbsDownloadConfig.mPreferences.contains("tbs_needdownload");
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] hasNeedDownloadKey=" + paramBoolean2);
        if ((paramBoolean2) || (TbsShareManager.isThirdPartyApp(paramContext))) {
          break label753;
        }
        paramBoolean1 = true;
      }
      label589:
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#4,needDownload=" + paramBoolean1 + ",hasNeedDownloadKey=" + paramBoolean2);
      if (!paramBoolean1) {
        break label789;
      }
      if (g()) {
        break label771;
      }
      paramBoolean1 = false;
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#5,set needDownload = false");
      label644:
      if ((!bool2) && (paramTbsDownloaderCallback != null)) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=" + paramBoolean1);
      paramContext = localTbsDownloadUpload.a;
      if (!paramBoolean1) {
        break label920;
      }
    }
    label771:
    label789:
    label920:
    for (int m = 170;; m = 174)
    {
      paramContext.put("tbs_needdownload_return", Integer.valueOf(m));
      localTbsDownloadUpload.commit();
      return paramBoolean1;
      localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(143));
      localTbsDownloadUpload.commit();
      break;
      label753:
      paramBoolean1 = localTbsDownloadConfig.mPreferences.getBoolean("tbs_needdownload", false);
      break label589;
      localTbsDownloadConfig.setDownloadInterruptCode(-118);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#6");
      break label644;
      m = p.a().m(c);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + m + ",needSendRequest=" + bool2);
      if ((bool2) || (m <= 0))
      {
        d.removeMessages(103);
        if ((m <= 0) && (!bool2)) {
          Message.obtain(d, 103, 0, 0, c).sendToTarget();
        }
        for (;;)
        {
          localTbsDownloadConfig.setDownloadInterruptCode(-121);
          break;
          Message.obtain(d, 103, 1, 0, c).sendToTarget();
        }
      }
      localTbsDownloadConfig.setDownloadInterruptCode(-119);
      break label644;
    }
  }
  
  public static boolean needDownloadDecoupleCore()
  {
    if (TbsShareManager.isThirdPartyApp(c)) {}
    int m;
    do
    {
      long l1;
      do
      {
        do
        {
          return false;
        } while (a(c));
        l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
      } while (System.currentTimeMillis() - l1 < 1000L * TbsDownloadConfig.getInstance(c).getRetryInterval());
      m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    } while ((m <= 0) || (m == p.a().h(c)) || (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) == m));
    return true;
  }
  
  public static boolean needSendRequest(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    c = paramContext.getApplicationContext();
    TbsLog.initIfNeed(paramContext);
    if (!a(c, paramBoolean)) {}
    int m;
    do
    {
      return false;
      m = p.a().m(paramContext);
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] localTbsVersion=" + m);
    } while (m > 0);
    if (a(c, false, true)) {
      return true;
    }
    paramContext = TbsDownloadConfig.getInstance(c);
    paramBoolean = paramContext.mPreferences.contains("tbs_needdownload");
    TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] hasNeedDownloadKey=" + paramBoolean);
    if (!paramBoolean)
    {
      paramBoolean = true;
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] needDownload=" + paramBoolean);
      if ((!paramBoolean) || (!g())) {
        break label207;
      }
    }
    label207:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] ret=" + paramBoolean);
      return paramBoolean;
      paramBoolean = paramContext.mPreferences.getBoolean("tbs_needdownload", false);
      break;
    }
  }
  
  public static void pauseDownload()
  {
    TbsLog.i("TbsDownload", "called pauseDownload,downloader=" + g);
    if (g != null) {
      g.e();
    }
  }
  
  public static void resumeDownload()
  {
    TbsLog.i("TbsDownload", "called resumeDownload,downloader=" + g);
    if (d != null)
    {
      d.removeMessages(109);
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
    TbsLog.i("TbsDownload", "mRetryIntervalInSeconds is " + l);
  }
  
  public static boolean startDecoupleCoreIfNeeded()
  {
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded ");
    if (TbsShareManager.isThirdPartyApp(c)) {}
    long l1;
    do
    {
      do
      {
        return false;
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #1");
      } while ((a(c)) || (d == null));
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #2");
      l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
    } while (System.currentTimeMillis() - l1 < 1000L * TbsDownloadConfig.getInstance(c).getRetryInterval());
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #3");
    int m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    if ((m > 0) && (m != p.a().h(c)))
    {
      if ((TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) != m) || (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0) == 1))
      {
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #4");
        a = true;
        d.removeMessages(108);
        Message localMessage = Message.obtain(d, 108, QbSdk.m);
        localMessage.arg1 = 0;
        localMessage.sendToTarget();
        TbsDownloadConfig.getInstance(c).mSyncMap.put("last_download_decouple_core", Long.valueOf(System.currentTimeMillis()));
        return true;
      }
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) + " deCoupleCoreVersion is " + m + " KEY_TBS_DOWNLOAD_V_TYPE is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0));
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is " + m + " getTbsCoreShareDecoupleCoreVersion is " + p.a().h(c));
    return false;
  }
  
  public static void startDownload(Context paramContext)
  {
    startDownload(paramContext, false);
  }
  
  public static void startDownload(Context paramContext, boolean paramBoolean)
  {
    int m = 1;
    for (;;)
    {
      TbsDownloadUpload localTbsDownloadUpload;
      try
      {
        localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
        localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(160));
        localTbsDownloadUpload.commit();
        TbsLog.i("TbsDownload", "[TbsDownloader.startDownload] sAppContext=" + c);
        if (p.b)
        {
          localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(161));
          localTbsDownloadUpload.commit();
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
          continue;
        }
        c();
      }
      finally {}
      if (!i) {
        break;
      }
      QbSdk.m.onDownloadFinish(121);
      TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-202);
      localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(163));
      localTbsDownloadUpload.commit();
    }
    if (paramBoolean) {
      stopDownload();
    }
    d.removeMessages(101);
    d.removeMessages(100);
    paramContext = Message.obtain(d, 101, QbSdk.m);
    if (paramBoolean) {}
    for (;;)
    {
      paramContext.arg1 = m;
      paramContext.sendToTarget();
      break;
      m = 0;
    }
  }
  
  public static void stopDownload()
  {
    if (i) {}
    do
    {
      return;
      TbsLog.i("TbsDownload", "[TbsDownloader.stopDownload]");
      if (g != null) {
        g.b();
      }
    } while (d == null);
    d.removeMessages(100);
    d.removeMessages(101);
    d.removeMessages(108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader
 * JD-Core Version:    0.7.0.1
 */