package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appstore.dl.DownloadInfoReport;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.TMAssistantGetAppDetailTool;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class DownloadApi
{
  protected static final String a = "com.tencent.open.downloadnew.DownloadApi";
  public static Object b = new Object();
  protected static ConcurrentHashMap<String, Integer> c = new ConcurrentHashMap();
  protected static ITMAssistantExchangeURLListenner d = new DownloadApi.15();
  
  public static int a()
  {
    return 3;
  }
  
  public static int a(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    if ("biz_src_jc_update".equals(paramString)) {
      StaticAnalyz.a("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(DownloadConstants.K));
    }
    String str1 = a;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("doDownloadActionBySDK pParmas =");
    ((StringBuilder)localObject1).append(paramBundle);
    LogUtility.a(str1, ((StringBuilder)localObject1).toString());
    String str3 = paramBundle.getString(DownloadConstants.b);
    String str4 = paramBundle.getString(DownloadConstants.j);
    String str5 = paramBundle.getString(DownloadConstants.f);
    int i = paramBundle.getInt(DownloadConstants.k);
    String str6 = paramBundle.getString(DownloadConstants.i);
    String str7 = paramBundle.getString(DownloadConstants.l);
    paramBundle.getString(DownloadConstants.m);
    String str2 = paramBundle.getString(DownloadConstants.F);
    int j = paramBundle.getInt(DownloadConstants.J);
    localObject1 = paramBundle.getString(DownloadConstants.K);
    boolean bool1 = paramBundle.getBoolean(DownloadConstants.o);
    boolean bool3 = paramBundle.getBoolean(DownloadConstants.z, true);
    boolean bool4 = paramBundle.getBoolean(DownloadConstants.h, true);
    boolean bool5 = paramBundle.getBoolean(DownloadConstants.y);
    int k = paramBundle.getInt(DownloadConstants.E, 0);
    boolean bool6 = paramBundle.getBoolean(DownloadConstants.L, false);
    str1 = paramBundle.getString("big_brother_source_key");
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.A, false);
    if (TextUtils.isEmpty(paramString)) {
      paramString = str1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "[UniteDownload] jsapi doDownloadActionBySDK: invoked. ", " sourceFromJsApi: ", str1, " source: ", paramString, " isUniteDownload: ", Boolean.valueOf(bool2) });
    }
    str1 = paramBundle.getString("big_brother_ref_source_key", "");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramBundle.getInt("hideInstallSuccessPage", 0));
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    if (i != 2) {
      if (i != 3) {
        if (i != 5) {
          if (i != 10) {
            if (i == 12) {}
          }
        }
      }
    }
    for (;;)
    {
      return 0;
      paramString = new DownloadInfo(str3, str4.trim(), str5, str7, str6, null, paramString, bool3);
      paramString.v = i;
      paramString.w = bool4;
      paramString.x = bool5;
      paramString.p = 0;
      paramString.V = bool2;
      paramString.n = paramBundle.getInt(DownloadConstants.e);
      paramString.F = ((String)localObject1);
      if ((paramApkUpdateDetail != null) && (paramString.n != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
        paramString.n = paramApkUpdateDetail.versioncode;
      }
      paramString.a("big_brother_ref_source_key", str1);
      paramString.a("hideInstallSuccessPage", (String)localObject2);
      bool3 = OpenConfig.a(CommonDataAdapter.a().b(), null).g("Common_QQ_Patch_Switch");
      if (!bool1) {
        a(paramString, bool2);
      } else if (bool3) {
        DownloadManager.b().a(paramString, paramApkUpdateDetail);
      } else {
        a(paramString, bool2);
      }
      paramBundle = a;
      paramString = new StringBuilder();
      paramString.append("doDownloadAction action == Downloader.ACTION_UPDATE ");
      paramString.append(bool1);
      LogUtility.c(paramBundle, paramString.toString());
      continue;
      DownloadManager.b().a(str3, null, true);
      continue;
      if (bool3)
      {
        StaticAnalyz.a("305", str6, str3, (String)localObject1);
        paramApkUpdateDetail = DownloadManager.b().d(str3);
        paramString = paramApkUpdateDetail;
        if (paramApkUpdateDetail == null)
        {
          paramString = new DownloadInfo();
          paramString.c = str3;
          paramString.d = str4.trim();
          paramString.e = str5;
          paramString.f = str7;
          paramString.h = str6;
          paramString.l = paramBundle.getString(DownloadConstants.c);
          paramString.m = paramBundle.getString(DownloadConstants.d);
          paramString.n = paramBundle.getInt(DownloadConstants.e);
          paramString.A = paramBundle.getBoolean(DownloadConstants.z, true);
          paramString.z = k;
          paramString.B = str2;
          paramString.p = 0;
          paramString.F = ((String)localObject1);
        }
        paramString.a("big_brother_ref_source_key", str1);
        paramString.a("hideInstallSuccessPage", (String)localObject2);
        DownloadManager.b().d(paramString);
        continue;
        return DownloadManager.b().g(str3);
        paramString = new DownloadInfo(str3, str4.trim(), str5, str7, str6, null, paramString, bool3);
        paramString.v = i;
        if (bool3)
        {
          paramString.w = bool4;
          paramString.x = bool5;
        }
        else
        {
          paramString.w = false;
          paramString.x = true;
          paramString.j = 2;
        }
        paramString.z = k;
        paramString.B = str2;
        paramString.C = j;
        paramString.F = ((String)localObject1);
        paramString.G = bool6;
        paramString.p = 0;
        paramString.V = bool2;
      }
      try
      {
        localObject1 = DownloadConstants.e;
        paramApkUpdateDetail = paramString;
      }
      catch (NumberFormatException paramBundle)
      {
        label917:
        break label917;
      }
      try
      {
        paramApkUpdateDetail.n = paramBundle.getInt((String)localObject1);
        paramApkUpdateDetail.I = paramBundle.getLong(DownloadConstants.I);
      }
      catch (NumberFormatException paramBundle)
      {
        break label917;
      }
      LogUtility.c(a, "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
      paramString.a("big_brother_ref_source_key", str1);
      paramString.a("hideInstallSuccessPage", (String)localObject2);
      a(paramString, bool2);
    }
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramActivity == null) {
        return;
      }
      ThreadManager.executeOnSubThread(new DownloadApi.2(paramActivity, paramBundle));
    }
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(CommonDataAdapter.a().b()) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadAction", System.currentTimeMillis());
    }
    if (paramString == "biz_src_jc_update") {
      StaticAnalyz.a("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(DownloadConstants.K));
    }
    Object localObject = new Throwable().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    while (i < localObject.length)
    {
      localStringBuilder.append(localObject[i].toString());
      i += 1;
    }
    localObject = paramBundle.getString(DownloadConstants.b);
    String str = paramBundle.getString(DownloadConstants.j);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      DownloadInfoReport.a.put(localObject, localStringBuilder.toString());
    } else if (!TextUtils.isEmpty(str)) {
      DownloadInfoReport.a.put(str, localStringBuilder.toString());
    }
    ThreadManager.getSubThreadHandler().post(new DownloadApi.1(paramBundle, paramString, paramInt, paramActivity, paramApkUpdateDetail));
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new DownloadApi.3(paramBundle));
  }
  
  private static void a(DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      DownloadManagerV2.a().b(paramDownloadInfo);
      return;
    }
    DownloadManager.b().a(paramDownloadInfo);
  }
  
  public static void a(DownloadListener paramDownloadListener)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.11(paramDownloadListener));
  }
  
  public static void a(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.10(paramString));
  }
  
  public static void a(String paramString, DownloadQueryListener paramDownloadQueryListener)
  {
    if (paramString == null)
    {
      LogUtility.a(a, "getQueryDownloadActionByVia via == null");
      return;
    }
    if (paramDownloadQueryListener == null) {
      LogUtility.a(a, "getQueryDownloadActionByVia listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadApi.6(paramString, paramDownloadQueryListener));
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadApi.7(paramString1, paramString2, paramBoolean), 32, null, true);
  }
  
  public static void a(List<DownloadInfo> paramList, DownloadQueryListener paramDownloadQueryListener)
  {
    if (paramList == null)
    {
      LogUtility.a(a, "getQueryDownloadAction infos == null");
      return;
    }
    if (paramDownloadQueryListener == null) {
      LogUtility.a(a, "getQueryDownloadAction listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadApi.5(paramList, paramDownloadQueryListener));
  }
  
  public static boolean a(ApkWriteCodeListener paramApkWriteCodeListener)
  {
    DownloadManagerV2.a().a(paramApkWriteCodeListener);
    return DownloadManager.b().a(paramApkWriteCodeListener);
  }
  
  protected static void b(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    Object localObject1 = a;
    ??? = new StringBuilder();
    ((StringBuilder)???).append("doDownloadActionByMyApp pParmas =");
    ((StringBuilder)???).append(paramBundle);
    ((StringBuilder)???).append(" myAppConfig = ");
    ((StringBuilder)???).append(paramInt);
    LogUtility.a((String)localObject1, ((StringBuilder)???).toString());
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      StaticAnalyz.a("300", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(DownloadConstants.K));
    }
    if (paramBundle.getInt(DownloadConstants.e, -10) < 0)
    {
      ??? = TMAssistantGetAppDetailTool.getInstance(d, CommonDataAdapter.a().b());
      localObject1 = paramBundle.getString(DownloadConstants.f);
      Object localObject3 = paramBundle.getString(DownloadConstants.D);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        StringBuilder localStringBuilder = new StringBuilder((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localStringBuilder.append(";");
          localStringBuilder.append((String)localObject3);
        }
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localStringBuilder.toString());
        ((TMAssistantGetAppDetailTool)???).exchangeUrlsFromPackageNames((ArrayList)localObject3);
        try
        {
          synchronized (b)
          {
            b.wait(5000L);
          }
          localObject1 = (Integer)((ConcurrentHashMap)???).remove(localObject1);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          ??? = c;
          if (??? == null) {
            break label317;
          }
        }
        if (localObject1 == null)
        {
          DownloadManager.b().j(CommonDataAdapter.a().b().getString(2131892305));
          return;
        }
        paramBundle.putInt(DownloadConstants.e, ((Integer)localObject1).intValue());
        break label317;
        throw paramActivity;
      }
    }
    label317:
    if (paramApkUpdateDetail != null)
    {
      paramBundle.putInt(DownloadConstants.u, paramApkUpdateDetail.patchsize);
      paramBundle.putInt(DownloadConstants.v, paramApkUpdateDetail.newapksize);
    }
    if (paramInt == 1)
    {
      paramBundle.putString("source", paramString);
      MyAppApi.l().a(paramActivity, paramBundle, new DownloadApi.13(paramBundle, paramString, paramApkUpdateDetail));
      return;
    }
    if ((paramInt == 2) || (paramInt == 0)) {
      MyAppApi.l().b(paramActivity, paramBundle, new DownloadApi.14(paramBundle, paramString, paramApkUpdateDetail));
    }
  }
  
  public static void b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new DownloadApi.4(paramBundle));
  }
  
  public static void b(DownloadListener paramDownloadListener)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.12(paramDownloadListener));
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadApi.8(paramString1, paramString2, paramBoolean), 32, null, true);
  }
  
  public static boolean b(ApkWriteCodeListener paramApkWriteCodeListener)
  {
    DownloadManagerV2.a().b(paramApkWriteCodeListener);
    return DownloadManager.b().b(paramApkWriteCodeListener);
  }
  
  public static boolean b(String paramString)
  {
    paramString = DownloadManager.b().d(paramString);
    return (paramString != null) && (paramString.o == 1);
  }
  
  public static boolean c(Bundle paramBundle)
  {
    if (paramBundle.getInt(DownloadConstants.k) == 5)
    {
      Object localObject = paramBundle.getString(DownloadConstants.b);
      String str1 = paramBundle.getString(DownloadConstants.j);
      String str2 = paramBundle.getString(DownloadConstants.f);
      String str3 = paramBundle.getString(DownloadConstants.i);
      String str4 = paramBundle.getString(DownloadConstants.l);
      StaticAnalyz.a("305", str3, (String)localObject, paramBundle.getString(DownloadConstants.K));
      DownloadInfo localDownloadInfo = DownloadManager.b().d((String)localObject);
      if (localDownloadInfo == null)
      {
        localDownloadInfo = new DownloadInfo();
        localDownloadInfo.c = ((String)localObject);
        localDownloadInfo.d = str1.trim();
        localDownloadInfo.e = str2;
        localDownloadInfo.f = str4;
        localDownloadInfo.h = str3;
        localDownloadInfo.l = paramBundle.getString(DownloadConstants.c);
        localDownloadInfo.m = paramBundle.getString(DownloadConstants.d);
        localDownloadInfo.n = paramBundle.getInt(DownloadConstants.e);
        localDownloadInfo.F = paramBundle.getString(DownloadConstants.K);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramBundle.getInt("hideInstallSuccessPage", 0));
        ((StringBuilder)localObject).append("");
        localDownloadInfo.a("hideInstallSuccessPage", ((StringBuilder)localObject).toString());
        paramBundle = localDownloadInfo;
      }
      else
      {
        if (!TextUtils.isEmpty(str3)) {
          localDownloadInfo.h = str3;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramBundle.getInt("hideInstallSuccessPage", 0));
        ((StringBuilder)localObject).append("");
        localDownloadInfo.a("hideInstallSuccessPage", ((StringBuilder)localObject).toString());
        paramBundle = localDownloadInfo;
      }
      DownloadManager.b().d(paramBundle);
      return true;
    }
    return false;
  }
  
  public static boolean c(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi
 * JD-Core Version:    0.7.0.1
 */