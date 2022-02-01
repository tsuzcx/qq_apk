package com.tencent.open.appstore.dl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadQueryListener;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.TMAssistantGetAppDetailTool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class DownloadProxy
{
  private static volatile DownloadProxy a;
  private final Object b = new Object();
  private ConcurrentHashMap<String, Integer> c = new ConcurrentHashMap();
  private ITMAssistantExchangeURLListenner d = new DownloadProxy.1(this);
  
  private int a(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    if ("biz_src_jc_update".equals(paramString)) {
      StaticAnalyz.a("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(DownloadConstants.K));
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[doDownloadActionBySDK] pParmas =");
    ((StringBuilder)localObject1).append(paramBundle);
    LogUtility.b("DownloadResolver", ((StringBuilder)localObject1).toString());
    localObject1 = paramBundle.getString(DownloadConstants.j);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      LogUtility.e("DownloadResolver", "[doDownloadActionBySDK] url is empty");
      return -1;
    }
    String str12 = paramBundle.getString(DownloadConstants.f);
    int i = paramBundle.getInt(DownloadConstants.k);
    String str13 = paramBundle.getString(DownloadConstants.i);
    String str14 = paramBundle.getString(DownloadConstants.l);
    String str16 = paramBundle.getString(DownloadConstants.F);
    int j = paramBundle.getInt(DownloadConstants.J);
    String str10 = paramBundle.getString(DownloadConstants.K);
    boolean bool1 = paramBundle.getBoolean(DownloadConstants.o);
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.z, true);
    boolean bool3 = paramBundle.getBoolean("is_qq_self_update_task", false);
    boolean bool4 = paramBundle.getBoolean(DownloadConstants.h, true);
    boolean bool5 = paramBundle.getBoolean(DownloadConstants.y);
    int k = paramBundle.getInt(DownloadConstants.E, 0);
    boolean bool6 = paramBundle.getBoolean(DownloadConstants.L, false);
    String str15 = paramBundle.getString("appId");
    String str1 = paramBundle.getString("apkId", "");
    String str2 = paramBundle.getString("recommendId", "");
    String str3 = paramBundle.getString(DownloadConstants.M, "");
    String str4 = paramBundle.getString("sourceFromServer", "");
    String str5 = paramBundle.getString("pageId", "");
    String str6 = paramBundle.getString("moduleId", "");
    String str7 = paramBundle.getString("positionId", "");
    String str8 = paramBundle.getString("sendTime", "");
    String str9 = paramBundle.getString("big_brother_ref_source_key", "");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramBundle.getInt("hideInstallSuccessPage", 0));
    ((StringBuilder)localObject2).append("");
    String str11 = ((StringBuilder)localObject2).toString();
    localObject2 = null;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 5)
        {
          if (i != 10)
          {
            if (i != 12)
            {
              paramString = (String)localObject2;
            }
            else
            {
              localObject2 = ((String)localObject1).trim();
              paramString = new DownloadInfo(str15, (String)localObject2, str12, str14, str13, null, paramString, bool2);
              paramString.v = i;
              paramString.w = bool4;
              paramString.x = bool5;
              paramString.p = 0;
              paramString.n = paramBundle.getInt(DownloadConstants.e);
              paramString.F = str10;
              if ((paramApkUpdateDetail != null) && (paramString.n != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
                paramString.n = paramApkUpdateDetail.versioncode;
              }
              if (!TextUtils.isEmpty(str8)) {
                paramString.g = str8;
              }
              paramString.m = str1;
              paramString.J = str2;
              paramString.K = str4;
              paramString.L = str3;
              paramString.M = str5;
              paramString.N = str6;
              paramString.O = str7;
              paramString.P = bool3;
              paramString.a("big_brother_ref_source_key", str9);
              paramString.a("hideInstallSuccessPage", str11);
              paramString.b();
              DownloadManagerV2.a().b(paramString);
              paramBundle = new StringBuilder();
              paramBundle.append("[doDownloadActionBySDK] action == Downloader.ACTION_UPDATE ");
              paramBundle.append(bool1);
              LogUtility.c("DownloadResolver", paramBundle.toString());
              paramBundle = (Bundle)localObject1;
              break label649;
            }
          }
          else
          {
            DownloadManagerV2.a().a((String)localObject1, true);
            paramString = (String)localObject2;
          }
        }
        else
        {
          paramApkUpdateDetail = (ApkUpdateDetail)localObject1;
          if (bool2) {
            break label655;
          }
          paramString = (String)localObject2;
        }
        for (;;)
        {
          paramBundle = (Bundle)localObject1;
          label649:
          localObject1 = paramBundle;
          break;
          label655:
          StaticAnalyz.a("305", str13, str15, str10);
          localObject2 = DownloadManagerV2.a().b(paramApkUpdateDetail);
          paramString = (String)localObject2;
          if (localObject2 == null)
          {
            paramString = new DownloadInfo();
            paramString.c = str15;
            paramString.d = paramApkUpdateDetail.trim();
            paramString.e = str12;
            paramString.f = str14;
            paramString.h = str13;
            paramString.l = paramBundle.getString(DownloadConstants.c);
            paramString.n = paramBundle.getInt(DownloadConstants.e);
            paramString.A = paramBundle.getBoolean(DownloadConstants.z, true);
            paramString.z = k;
            paramString.B = str16;
            paramString.p = 0;
            paramString.F = str10;
            if (!TextUtils.isEmpty(str8)) {
              paramString.g = str8;
            }
            paramString.m = str1;
            paramString.J = str2;
            paramString.K = str4;
            paramString.L = str3;
            paramString.M = str5;
            paramString.N = str6;
            paramString.O = str7;
            paramString.b();
          }
          paramString.P = bool3;
          paramString.a("big_brother_ref_source_key", str9);
          paramString.a("hideInstallSuccessPage", str11);
          DownloadManagerV2.a().d(paramString);
        }
      }
      return DownloadManagerV2.a().e((String)localObject1);
    }
    paramApkUpdateDetail = ((String)localObject1).trim();
    paramString = new DownloadInfo(str15, paramApkUpdateDetail, str12, str14, str13, null, paramString, bool2);
    paramString.v = i;
    if (bool2)
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
    paramString.B = str16;
    paramString.C = j;
    paramString.F = str10;
    paramString.G = bool6;
    paramString.p = 0;
    try
    {
      paramString.n = paramBundle.getInt(DownloadConstants.e);
      paramString.I = paramBundle.getLong(DownloadConstants.I);
      label1010:
      paramString.m = str1;
      paramString.J = str2;
      paramString.K = str4;
      paramString.L = str3;
      paramString.M = str5;
      paramString.N = str6;
      paramString.O = str7;
      paramString.P = bool3;
      if (!TextUtils.isEmpty(str8)) {
        paramString.g = str8;
      }
      paramString.a("big_brother_ref_source_key", str9);
      paramString.a("hideInstallSuccessPage", str11);
      paramString.b();
      LogUtility.b("DownloadResolver", "[doDownloadActionBySDK] action == Downloader.ACTION_DOWNLOAD");
      DownloadManagerV2.a().b(paramString);
      paramBundle = paramString;
      paramString = paramBundle;
      DownloadInfoReport.a(11, (String)localObject1, i, paramString);
      return 0;
    }
    catch (NumberFormatException paramBundle)
    {
      break label1010;
    }
  }
  
  public static DownloadProxy a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new DownloadProxy();
        }
      }
      finally {}
    }
    return a;
  }
  
  private String a(TMAssistantDownloadTaskInfo paramTMAssistantDownloadTaskInfo)
  {
    if (paramTMAssistantDownloadTaskInfo == null) {
      return "null";
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("[mSavePath=");
    localStringBuilder2.append(paramTMAssistantDownloadTaskInfo.mSavePath);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("\n");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mState=");
    localStringBuilder2.append(paramTMAssistantDownloadTaskInfo.mState);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("\n");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mReceiveDataLen=");
    localStringBuilder2.append(paramTMAssistantDownloadTaskInfo.mReceiveDataLen);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("\n");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mTotalDataLen=");
    localStringBuilder2.append(paramTMAssistantDownloadTaskInfo.mTotalDataLen);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("\n");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mContentType=");
    localStringBuilder2.append(paramTMAssistantDownloadTaskInfo.mContentType);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("\n");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mTaskPackageName=");
    localStringBuilder2.append(paramTMAssistantDownloadTaskInfo.mTaskPackageName);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("\n");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mTaskVersionCode=");
    localStringBuilder2.append(paramTMAssistantDownloadTaskInfo.mTaskVersionCode);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    DownloadApi.a(paramActivity, paramBundle);
  }
  
  public static boolean a(Bundle paramBundle)
  {
    if (paramBundle.getInt(DownloadConstants.k) == 5)
    {
      Object localObject2 = paramBundle.getString(DownloadConstants.j);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        LogUtility.e("DownloadResolver", "[installApp] url is empty");
        return false;
      }
      String str1 = paramBundle.getString(DownloadConstants.f);
      String str2 = paramBundle.getString(DownloadConstants.i);
      String str3 = paramBundle.getString(DownloadConstants.l);
      Object localObject1 = paramBundle.getString(DownloadConstants.K);
      String str4 = paramBundle.getString("appId");
      String str5 = paramBundle.getString("apkId", "");
      String str6 = paramBundle.getString("recommendId", "");
      String str7 = paramBundle.getString(DownloadConstants.M, "");
      String str8 = paramBundle.getString("sourceFromServer", "");
      String str9 = paramBundle.getString("pageId", "");
      String str10 = paramBundle.getString("moduleId", "");
      String str11 = paramBundle.getString("positionId", "");
      String str12 = paramBundle.getString("big_brother_ref_source_key", "");
      String str13 = paramBundle.getString("big_brother_source_key");
      StaticAnalyz.a("305", str2, str4, (String)localObject1);
      localObject1 = DownloadManagerV2.a().b((String)localObject2);
      if (localObject1 == null)
      {
        localObject1 = new DownloadInfo();
        ((DownloadInfo)localObject1).c = str4;
        ((DownloadInfo)localObject1).d = ((String)localObject2).trim();
        ((DownloadInfo)localObject1).e = str1;
        ((DownloadInfo)localObject1).f = str3;
        ((DownloadInfo)localObject1).h = str2;
        ((DownloadInfo)localObject1).l = paramBundle.getString(DownloadConstants.c);
        ((DownloadInfo)localObject1).m = paramBundle.getString(DownloadConstants.d);
        ((DownloadInfo)localObject1).n = paramBundle.getInt(DownloadConstants.e);
        ((DownloadInfo)localObject1).F = paramBundle.getString(DownloadConstants.K);
        ((DownloadInfo)localObject1).m = str5;
        ((DownloadInfo)localObject1).J = str6;
        ((DownloadInfo)localObject1).K = str8;
        ((DownloadInfo)localObject1).L = str7;
        ((DownloadInfo)localObject1).M = str9;
        ((DownloadInfo)localObject1).N = str10;
        ((DownloadInfo)localObject1).O = str11;
        ((DownloadInfo)localObject1).r = str13;
        ((DownloadInfo)localObject1).a("big_brother_ref_source_key", str12);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramBundle.getInt("hideInstallSuccessPage", 0));
        ((StringBuilder)localObject2).append("");
        ((DownloadInfo)localObject1).a("hideInstallSuccessPage", ((StringBuilder)localObject2).toString());
        ((DownloadInfo)localObject1).b();
        paramBundle = (Bundle)localObject1;
      }
      else
      {
        if (!TextUtils.isEmpty(str2)) {
          ((DownloadInfo)localObject1).h = str2;
        }
        if (!TextUtils.isEmpty(str12)) {
          ((DownloadInfo)localObject1).a("big_brother_ref_source_key", str12);
        }
        if (!TextUtils.isEmpty(str13)) {
          ((DownloadInfo)localObject1).r = str13;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramBundle.getInt("hideInstallSuccessPage", 0));
        ((StringBuilder)localObject2).append("");
        ((DownloadInfo)localObject1).a("hideInstallSuccessPage", ((StringBuilder)localObject2).toString());
        paramBundle = (Bundle)localObject1;
      }
      return DownloadManagerV2.a().d(paramBundle);
    }
    return false;
  }
  
  private void b(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[doDownloadActionByMyApp] pParmas =");
    ((StringBuilder)localObject1).append(paramBundle);
    ((StringBuilder)localObject1).append(" myAppConfig = ");
    ((StringBuilder)localObject1).append(paramInt);
    LogUtility.b("DownloadResolver", ((StringBuilder)localObject1).toString());
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      StaticAnalyz.a("300", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(DownloadConstants.K));
    }
    if (paramBundle.getInt(DownloadConstants.e, -10) < 0)
    {
      ??? = TMAssistantGetAppDetailTool.getInstance(this.d, CommonDataAdapter.a().b());
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
          synchronized (this.b)
          {
            this.b.wait(5000L);
          }
          localObject1 = (Integer)((ConcurrentHashMap)???).remove(localObject1);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          ??? = this.c;
          if (??? == null) {
            break label316;
          }
        }
        if (localObject1 == null)
        {
          DownloadManagerV2.a().h(CommonDataAdapter.a().b().getString(2131892305));
          return;
        }
        paramBundle.putInt(DownloadConstants.e, ((Integer)localObject1).intValue());
        break label316;
        throw paramActivity;
      }
    }
    label316:
    if (paramApkUpdateDetail != null)
    {
      paramBundle.putInt(DownloadConstants.u, paramApkUpdateDetail.patchsize);
      paramBundle.putInt(DownloadConstants.v, paramApkUpdateDetail.newapksize);
    }
    if (paramInt == 1)
    {
      paramBundle.putString("source", paramString);
      paramBundle.putInt("dialogType", 1);
      MyAppApi.l().a(paramActivity, paramBundle, new DownloadProxy.4(this, paramBundle, paramString, paramApkUpdateDetail));
      return;
    }
    if ((paramInt == 2) || (paramInt == 0)) {
      MyAppApi.l().b(paramActivity, paramBundle, new DownloadProxy.5(this, paramBundle, paramString, paramApkUpdateDetail));
    }
  }
  
  public static void b(Bundle paramBundle)
  {
    DownloadApi.a(paramBundle);
  }
  
  public static void c(Bundle paramBundle)
  {
    DownloadApi.b(paramBundle);
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(CommonDataAdapter.a().b()) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadAction", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      StaticAnalyz.a("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(DownloadConstants.K));
    }
    ThreadManager.getSubThreadHandler().post(new DownloadProxy.3(this, paramBundle, paramString, paramInt, paramActivity, paramApkUpdateDetail));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadProxy.6(this, paramString, paramBoolean), 32, null, true);
  }
  
  public void a(List<DownloadInfo> paramList, DownloadQueryListener paramDownloadQueryListener)
  {
    if (paramList == null)
    {
      LogUtility.b("DownloadResolver", "[queryByDownloadManagerV2] infos == null");
      return;
    }
    if (paramDownloadQueryListener == null) {
      LogUtility.b("DownloadResolver", "[queryByDownloadManagerV2] listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadProxy.2(this, paramList, paramDownloadQueryListener));
  }
  
  public List<DownloadInfo> b()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = DownloadManagerV2.a().d();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("DownloadManagerV2 tasks:");
    Object localObject1;
    if (localObject2 == null) {
      localObject1 = "0";
    } else {
      localObject1 = Integer.valueOf(((Map)localObject2).size());
    }
    ((StringBuilder)localObject3).append(localObject1);
    LogUtility.b("DownloadResolver", ((StringBuilder)localObject3).toString());
    if ((localObject2 != null) && (((Map)localObject2).size() != 0))
    {
      localObject2 = new HashMap((Map)localObject2);
      localObject1 = new ArrayList();
      if (((Map)localObject2).size() > 0)
      {
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          long l2 = System.currentTimeMillis();
          Object localObject4 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (DownloadInfo)((Map.Entry)localObject3).getValue();
          if ((((DownloadInfo)localObject3).o == 0) && (!TextUtils.isEmpty(((DownloadInfo)localObject3).e)) && (((DownloadInfo)localObject3).A))
          {
            localArrayList.add(localObject3);
            localObject4 = DownloadManagerV2.a().g(((DownloadInfo)localObject3).d);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("\ninfo=");
            localStringBuilder.append(((DownloadInfo)localObject3).toString());
            localStringBuilder.append("\ntaskInfo:");
            localStringBuilder.append(a((TMAssistantDownloadTaskInfo)localObject4));
            LogUtility.b("DownloadResolver", localStringBuilder.toString());
          }
          else
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("Info is not SDK && APK task!! \ninfo=");
            ((StringBuilder)localObject4).append(((DownloadInfo)localObject3).toString());
            LogUtility.e("DownloadResolver", ((StringBuilder)localObject4).toString());
          }
          ((List)localObject1).add(Long.valueOf(System.currentTimeMillis() - l2));
        }
      }
      LogUtility.e("DownloadResolver", "infos is empty!!");
      localObject2 = new Long[((List)localObject1).size()];
      ((List)localObject1).toArray((Object[])localObject2);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Total time Cost:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
      ((StringBuilder)localObject1).append(";Every loop time cost:");
      ((StringBuilder)localObject1).append(Arrays.toString((Object[])localObject2));
      LogUtility.e("DownloadResolver", ((StringBuilder)localObject1).toString());
      return localArrayList;
    }
    LogUtility.e("DownloadResolver", "infos is null!!");
    return localArrayList;
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadProxy.7(this, paramString, paramBoolean), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy
 * JD-Core Version:    0.7.0.1
 */