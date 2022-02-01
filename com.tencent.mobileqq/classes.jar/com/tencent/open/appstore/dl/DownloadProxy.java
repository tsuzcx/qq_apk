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
  private static volatile DownloadProxy jdField_a_of_type_ComTencentOpenAppstoreDlDownloadProxy = null;
  private ITMAssistantExchangeURLListenner jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner = new DownloadProxy.1(this);
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private int a(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    if ("biz_src_jc_update".equals(paramString)) {
      StaticAnalyz.a("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(DownloadConstants.J));
    }
    LogUtility.b("DownloadResolver", "[doDownloadActionBySDK] pParmas =" + paramBundle);
    String str1 = paramBundle.getString(DownloadConstants.j);
    if (TextUtils.isEmpty(str1))
    {
      LogUtility.e("DownloadResolver", "[doDownloadActionBySDK] url is empty");
      return -1;
    }
    String str14 = paramBundle.getString(DownloadConstants.f);
    int i = paramBundle.getInt(DownloadConstants.k);
    String str15 = paramBundle.getString(DownloadConstants.i);
    String str16 = paramBundle.getString(DownloadConstants.l);
    String str13 = paramBundle.getString(DownloadConstants.E);
    int j = paramBundle.getInt(DownloadConstants.I);
    String str12 = paramBundle.getString(DownloadConstants.J);
    boolean bool1 = paramBundle.getBoolean(DownloadConstants.o);
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.y, true);
    boolean bool3 = paramBundle.getBoolean("is_qq_self_update_task", false);
    boolean bool4 = paramBundle.getBoolean(DownloadConstants.jdField_h_of_type_JavaLangString, true);
    boolean bool5 = paramBundle.getBoolean(DownloadConstants.x);
    int k = paramBundle.getInt(DownloadConstants.D, 0);
    boolean bool6 = paramBundle.getBoolean(DownloadConstants.K, false);
    String str17 = paramBundle.getString("appId");
    String str2 = paramBundle.getString("apkId", "");
    String str3 = paramBundle.getString("recommendId", "");
    String str4 = paramBundle.getString(DownloadConstants.L, "");
    String str5 = paramBundle.getString("sourceFromServer", "");
    String str6 = paramBundle.getString("pageId", "");
    String str7 = paramBundle.getString("moduleId", "");
    String str8 = paramBundle.getString("positionId", "");
    String str9 = paramBundle.getString("sendTime", "");
    String str10 = paramBundle.getString("big_brother_ref_source_key", "");
    String str11 = paramBundle.getInt("hideInstallSuccessPage", 0) + "";
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (i)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      DownloadInfoReport.a(11, str1, i, localObject1);
      return 0;
      localObject1 = new DownloadInfo(str17, str1.trim(), str14, str16, str15, null, paramString, bool2);
      ((DownloadInfo)localObject1).jdField_g_of_type_Int = i;
      if (bool2)
      {
        ((DownloadInfo)localObject1).jdField_a_of_type_Boolean = bool4;
        ((DownloadInfo)localObject1).jdField_b_of_type_Boolean = bool5;
        label469:
        ((DownloadInfo)localObject1).jdField_h_of_type_Int = k;
        ((DownloadInfo)localObject1).n = str13;
        ((DownloadInfo)localObject1).i = j;
        ((DownloadInfo)localObject1).o = str12;
        ((DownloadInfo)localObject1).jdField_d_of_type_Boolean = bool6;
        ((DownloadInfo)localObject1).jdField_d_of_type_Int = 0;
      }
      try
      {
        ((DownloadInfo)localObject1).jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.jdField_e_of_type_JavaLangString);
        ((DownloadInfo)localObject1).jdField_d_of_type_Long = paramBundle.getLong(DownloadConstants.H);
        label534:
        ((DownloadInfo)localObject1).k = str2;
        ((DownloadInfo)localObject1).q = str3;
        ((DownloadInfo)localObject1).r = str5;
        ((DownloadInfo)localObject1).s = str4;
        ((DownloadInfo)localObject1).t = str6;
        ((DownloadInfo)localObject1).u = str7;
        ((DownloadInfo)localObject1).v = str8;
        ((DownloadInfo)localObject1).jdField_e_of_type_Boolean = bool3;
        if (!TextUtils.isEmpty(str9)) {
          ((DownloadInfo)localObject1).jdField_g_of_type_JavaLangString = str9;
        }
        ((DownloadInfo)localObject1).a("big_brother_ref_source_key", str10);
        ((DownloadInfo)localObject1).a("hideInstallSuccessPage", str11);
        ((DownloadInfo)localObject1).a();
        LogUtility.b("DownloadResolver", "[doDownloadActionBySDK] action == Downloader.ACTION_DOWNLOAD");
        DownloadManagerV2.a().b((DownloadInfo)localObject1);
        continue;
        ((DownloadInfo)localObject1).jdField_a_of_type_Boolean = false;
        ((DownloadInfo)localObject1).jdField_b_of_type_Boolean = true;
        ((DownloadInfo)localObject1).jdField_a_of_type_Int = 2;
        break label469;
        localObject1 = new DownloadInfo(str17, str1.trim(), str14, str16, str15, null, paramString, bool2);
        ((DownloadInfo)localObject1).jdField_g_of_type_Int = i;
        ((DownloadInfo)localObject1).jdField_a_of_type_Boolean = bool4;
        ((DownloadInfo)localObject1).jdField_b_of_type_Boolean = bool5;
        ((DownloadInfo)localObject1).jdField_d_of_type_Int = 0;
        ((DownloadInfo)localObject1).jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.jdField_e_of_type_JavaLangString);
        ((DownloadInfo)localObject1).o = str12;
        if ((paramApkUpdateDetail != null) && (((DownloadInfo)localObject1).jdField_b_of_type_Int != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
          ((DownloadInfo)localObject1).jdField_b_of_type_Int = paramApkUpdateDetail.versioncode;
        }
        if (!TextUtils.isEmpty(str9)) {
          ((DownloadInfo)localObject1).jdField_g_of_type_JavaLangString = str9;
        }
        ((DownloadInfo)localObject1).k = str2;
        ((DownloadInfo)localObject1).q = str3;
        ((DownloadInfo)localObject1).r = str5;
        ((DownloadInfo)localObject1).s = str4;
        ((DownloadInfo)localObject1).t = str6;
        ((DownloadInfo)localObject1).u = str7;
        ((DownloadInfo)localObject1).v = str8;
        ((DownloadInfo)localObject1).jdField_e_of_type_Boolean = bool3;
        ((DownloadInfo)localObject1).a("big_brother_ref_source_key", str10);
        ((DownloadInfo)localObject1).a("hideInstallSuccessPage", str11);
        ((DownloadInfo)localObject1).a();
        DownloadManagerV2.a().b((DownloadInfo)localObject1);
        LogUtility.c("DownloadResolver", "[doDownloadActionBySDK] action == Downloader.ACTION_UPDATE " + bool1);
        continue;
        return DownloadManagerV2.a().a(str1);
        localObject1 = localObject2;
        if (!bool2) {
          continue;
        }
        StaticAnalyz.a("305", str15, str17, str12);
        paramString = DownloadManagerV2.a().b(str1);
        localObject1 = paramString;
        if (paramString == null)
        {
          localObject1 = new DownloadInfo();
          ((DownloadInfo)localObject1).jdField_c_of_type_JavaLangString = str17;
          ((DownloadInfo)localObject1).jdField_d_of_type_JavaLangString = str1.trim();
          ((DownloadInfo)localObject1).jdField_e_of_type_JavaLangString = str14;
          ((DownloadInfo)localObject1).f = str16;
          ((DownloadInfo)localObject1).jdField_h_of_type_JavaLangString = str15;
          ((DownloadInfo)localObject1).j = paramBundle.getString(DownloadConstants.jdField_c_of_type_JavaLangString);
          ((DownloadInfo)localObject1).jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.jdField_e_of_type_JavaLangString);
          ((DownloadInfo)localObject1).jdField_c_of_type_Boolean = paramBundle.getBoolean(DownloadConstants.y, true);
          ((DownloadInfo)localObject1).jdField_h_of_type_Int = k;
          ((DownloadInfo)localObject1).n = str13;
          ((DownloadInfo)localObject1).jdField_d_of_type_Int = 0;
          ((DownloadInfo)localObject1).o = str12;
          if (!TextUtils.isEmpty(str9)) {
            ((DownloadInfo)localObject1).jdField_g_of_type_JavaLangString = str9;
          }
          ((DownloadInfo)localObject1).k = str2;
          ((DownloadInfo)localObject1).q = str3;
          ((DownloadInfo)localObject1).r = str5;
          ((DownloadInfo)localObject1).s = str4;
          ((DownloadInfo)localObject1).t = str6;
          ((DownloadInfo)localObject1).u = str7;
          ((DownloadInfo)localObject1).v = str8;
          ((DownloadInfo)localObject1).a();
        }
        ((DownloadInfo)localObject1).jdField_e_of_type_Boolean = bool3;
        ((DownloadInfo)localObject1).a("big_brother_ref_source_key", str10);
        ((DownloadInfo)localObject1).a("hideInstallSuccessPage", str11);
        DownloadManagerV2.a().a((DownloadInfo)localObject1);
        continue;
        DownloadManagerV2.a().a(str1, true);
        localObject1 = localObject2;
      }
      catch (NumberFormatException paramBundle)
      {
        break label534;
      }
    }
  }
  
  public static DownloadProxy a()
  {
    if (jdField_a_of_type_ComTencentOpenAppstoreDlDownloadProxy == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentOpenAppstoreDlDownloadProxy == null) {
        jdField_a_of_type_ComTencentOpenAppstoreDlDownloadProxy = new DownloadProxy();
      }
      return jdField_a_of_type_ComTencentOpenAppstoreDlDownloadProxy;
    }
    finally {}
  }
  
  private String a(TMAssistantDownloadTaskInfo paramTMAssistantDownloadTaskInfo)
  {
    if (paramTMAssistantDownloadTaskInfo == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[mSavePath=" + paramTMAssistantDownloadTaskInfo.mSavePath);
    localStringBuilder.append("\n");
    localStringBuilder.append("mState=" + paramTMAssistantDownloadTaskInfo.mState);
    localStringBuilder.append("\n");
    localStringBuilder.append("mReceiveDataLen=" + paramTMAssistantDownloadTaskInfo.mReceiveDataLen);
    localStringBuilder.append("\n");
    localStringBuilder.append("mTotalDataLen=" + paramTMAssistantDownloadTaskInfo.mTotalDataLen);
    localStringBuilder.append("\n");
    localStringBuilder.append("mContentType=" + paramTMAssistantDownloadTaskInfo.mContentType);
    localStringBuilder.append("\n");
    localStringBuilder.append("mTaskPackageName=" + paramTMAssistantDownloadTaskInfo.mTaskPackageName);
    localStringBuilder.append("\n");
    localStringBuilder.append("mTaskVersionCode=" + paramTMAssistantDownloadTaskInfo.mTaskVersionCode);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    DownloadApi.a(paramActivity, paramBundle);
  }
  
  public static void a(Bundle paramBundle)
  {
    DownloadApi.a(paramBundle);
  }
  
  public static boolean a(Bundle paramBundle)
  {
    if (paramBundle.getInt(DownloadConstants.k) == 5)
    {
      String str1 = paramBundle.getString(DownloadConstants.j);
      if (TextUtils.isEmpty(str1))
      {
        LogUtility.e("DownloadResolver", "[installApp] url is empty");
        return false;
      }
      String str2 = paramBundle.getString(DownloadConstants.f);
      String str3 = paramBundle.getString(DownloadConstants.i);
      String str4 = paramBundle.getString(DownloadConstants.l);
      Object localObject = paramBundle.getString(DownloadConstants.J);
      String str5 = paramBundle.getString("appId");
      String str6 = paramBundle.getString("apkId", "");
      String str7 = paramBundle.getString("recommendId", "");
      String str8 = paramBundle.getString(DownloadConstants.L, "");
      String str9 = paramBundle.getString("sourceFromServer", "");
      String str10 = paramBundle.getString("pageId", "");
      String str11 = paramBundle.getString("moduleId", "");
      String str12 = paramBundle.getString("positionId", "");
      String str13 = paramBundle.getString("big_brother_ref_source_key", "");
      String str14 = paramBundle.getString("big_brother_source_key");
      StaticAnalyz.a("305", str3, str5, (String)localObject);
      localObject = DownloadManagerV2.a().b(str1);
      if (localObject == null)
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).jdField_c_of_type_JavaLangString = str5;
        ((DownloadInfo)localObject).jdField_d_of_type_JavaLangString = str1.trim();
        ((DownloadInfo)localObject).jdField_e_of_type_JavaLangString = str2;
        ((DownloadInfo)localObject).f = str4;
        ((DownloadInfo)localObject).jdField_h_of_type_JavaLangString = str3;
        ((DownloadInfo)localObject).j = paramBundle.getString(DownloadConstants.jdField_c_of_type_JavaLangString);
        ((DownloadInfo)localObject).k = paramBundle.getString(DownloadConstants.jdField_d_of_type_JavaLangString);
        ((DownloadInfo)localObject).jdField_b_of_type_Int = paramBundle.getInt(DownloadConstants.jdField_e_of_type_JavaLangString);
        ((DownloadInfo)localObject).o = paramBundle.getString(DownloadConstants.J);
        ((DownloadInfo)localObject).k = str6;
        ((DownloadInfo)localObject).q = str7;
        ((DownloadInfo)localObject).r = str9;
        ((DownloadInfo)localObject).s = str8;
        ((DownloadInfo)localObject).t = str10;
        ((DownloadInfo)localObject).u = str11;
        ((DownloadInfo)localObject).v = str12;
        ((DownloadInfo)localObject).m = str14;
        ((DownloadInfo)localObject).a("big_brother_ref_source_key", str13);
        ((DownloadInfo)localObject).a("hideInstallSuccessPage", paramBundle.getInt("hideInstallSuccessPage", 0) + "");
        ((DownloadInfo)localObject).a();
      }
      for (paramBundle = (Bundle)localObject;; paramBundle = (Bundle)localObject)
      {
        return DownloadManagerV2.a().a(paramBundle);
        if (!TextUtils.isEmpty(str3)) {
          ((DownloadInfo)localObject).jdField_h_of_type_JavaLangString = str3;
        }
        if (!TextUtils.isEmpty(str13)) {
          ((DownloadInfo)localObject).a("big_brother_ref_source_key", str13);
        }
        if (!TextUtils.isEmpty(str14)) {
          ((DownloadInfo)localObject).m = str14;
        }
        ((DownloadInfo)localObject).a("hideInstallSuccessPage", paramBundle.getInt("hideInstallSuccessPage", 0) + "");
      }
    }
    return false;
  }
  
  private void b(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    LogUtility.b("DownloadResolver", "[doDownloadActionByMyApp] pParmas =" + paramBundle + " myAppConfig = " + paramInt);
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      StaticAnalyz.a("300", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(DownloadConstants.J));
    }
    Object localObject1;
    if (paramBundle.getInt(DownloadConstants.jdField_e_of_type_JavaLangString, -10) < 0)
    {
      ??? = TMAssistantGetAppDetailTool.getInstance(this.jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner, CommonDataAdapter.a().a());
      localObject1 = paramBundle.getString(DownloadConstants.f);
      Object localObject3 = paramBundle.getString(DownloadConstants.C);
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
      }
    }
    label292:
    do
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait(5000L);
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
            break label292;
          }
          localObject1 = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject1);
          if (localObject1 == null)
          {
            DownloadManagerV2.a().b(CommonDataAdapter.a().a().getString(2131694653));
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      paramBundle.putInt(DownloadConstants.jdField_e_of_type_JavaLangString, ((Integer)localObject1).intValue());
      if (paramApkUpdateDetail != null)
      {
        paramBundle.putInt(DownloadConstants.t, paramApkUpdateDetail.patchsize);
        paramBundle.putInt(DownloadConstants.u, paramApkUpdateDetail.newapksize);
      }
      if (paramInt == 1)
      {
        paramBundle.putString("source", paramString);
        paramBundle.putInt("dialogType", 1);
        MyAppApi.a().a(paramActivity, paramBundle, new DownloadProxy.4(this, paramBundle, paramString, paramApkUpdateDetail));
        return;
      }
    } while ((paramInt != 2) && (paramInt != 0));
    MyAppApi.a().b(paramActivity, paramBundle, new DownloadProxy.5(this, paramBundle, paramString, paramApkUpdateDetail));
  }
  
  public static void b(Bundle paramBundle)
  {
    DownloadApi.b(paramBundle);
  }
  
  public List<DownloadInfo> a()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = DownloadManagerV2.a().a();
    Object localObject3 = new StringBuilder().append("DownloadManagerV2 tasks:");
    if (localObject2 == null) {}
    for (Object localObject1 = "0";; localObject1 = Integer.valueOf(((Map)localObject2).size()))
    {
      LogUtility.b("DownloadResolver", localObject1);
      if ((localObject2 != null) && (((Map)localObject2).size() != 0)) {
        break;
      }
      LogUtility.e("DownloadResolver", "infos is null!!");
      return localArrayList;
    }
    localObject2 = new HashMap((Map)localObject2);
    localObject1 = new ArrayList();
    if (((Map)localObject2).size() > 0)
    {
      localObject2 = ((Map)localObject2).entrySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        long l2 = System.currentTimeMillis();
        Object localObject4 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (DownloadInfo)((Map.Entry)localObject3).getValue();
        if ((((DownloadInfo)localObject3).jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(((DownloadInfo)localObject3).jdField_e_of_type_JavaLangString)) && (((DownloadInfo)localObject3).jdField_c_of_type_Boolean))
        {
          localArrayList.add(localObject3);
          localObject4 = DownloadManagerV2.a().a(((DownloadInfo)localObject3).jdField_d_of_type_JavaLangString);
          LogUtility.b("DownloadResolver", "\ninfo=" + ((DownloadInfo)localObject3).toString() + "\ntaskInfo:" + a((TMAssistantDownloadTaskInfo)localObject4));
        }
        for (;;)
        {
          ((List)localObject1).add(Long.valueOf(System.currentTimeMillis() - l2));
          break;
          LogUtility.e("DownloadResolver", "Info is not SDK && APK task!! \ninfo=" + ((DownloadInfo)localObject3).toString());
        }
      }
    }
    else
    {
      LogUtility.e("DownloadResolver", "infos is empty!!");
    }
    localObject2 = new Long[((List)localObject1).size()];
    ((List)localObject1).toArray((Object[])localObject2);
    LogUtility.e("DownloadResolver", "Total time Cost:" + (System.currentTimeMillis() - l1) + ";Every loop time cost:" + Arrays.toString((Object[])localObject2));
    return localArrayList;
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(CommonDataAdapter.a().a()) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadAction", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      StaticAnalyz.a("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(DownloadConstants.J));
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
  
  public void b(String paramString, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadProxy.7(this, paramString, paramBoolean), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy
 * JD-Core Version:    0.7.0.1
 */