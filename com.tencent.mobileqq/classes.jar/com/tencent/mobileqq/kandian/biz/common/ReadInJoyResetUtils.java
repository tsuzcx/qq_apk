package com.tencent.mobileqq.kandian.biz.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.CollectionUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.OfflineUtils;
import com.tencent.mobileqq.kandian.biz.skin.CommonSkinRes;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyOperationManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyEntityManagerFactory;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.aladdin.QQAladdinPrefUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.open.appcommon.Common;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class ReadInJoyResetUtils
{
  public static int a()
  {
    SharedPreferences localSharedPreferences = a(RIJQQAppInterfaceUtil.e());
    if (localSharedPreferences == null)
    {
      QLog.d("ReadInJoyResetUtils", 2, "[getLocalResetVersion] return 0 for sp is null");
      return 0;
    }
    return localSharedPreferences.getInt("readinjoy_local_reset_config_version", 0);
  }
  
  private static SharedPreferences a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("ReadInJoyResetUtils", 1, "[getSharedPreferences] return null for runtime is null");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_sp_reset_");
    localStringBuilder.append(paramAppRuntime.getAccount());
    paramAppRuntime = localStringBuilder.toString();
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramAppRuntime, 0);
  }
  
  private static void a(int paramInt)
  {
    SharedPreferences localSharedPreferences = a(RIJQQAppInterfaceUtil.e());
    if (localSharedPreferences == null)
    {
      QLog.d("ReadInJoyResetUtils", 2, "[putLocalResetVersion] sp == null");
      return;
    }
    localSharedPreferences.edit().putInt("readinjoy_local_reset_config_version", paramInt).apply();
  }
  
  private static void a(SharedPreferences paramSharedPreferences)
  {
    if (paramSharedPreferences != null)
    {
      List localList = CollectionUtils.a(paramSharedPreferences.getAll().keySet(), new ReadInJoyResetUtils.1());
      paramSharedPreferences = paramSharedPreferences.edit();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        paramSharedPreferences.remove((String)localIterator.next());
      }
      paramSharedPreferences.commit();
      paramSharedPreferences = new StringBuilder();
      paramSharedPreferences.append("[removeReadInJoyKeysInSharedPreferences] removed ");
      paramSharedPreferences.append(localList);
      QLog.d("ReadInJoyResetUtils", 2, paramSharedPreferences.toString());
    }
  }
  
  public static void b()
  {
    int i = SharedPreUtils.V(BaseApplicationImpl.getApplication(), RIJQQAppInterfaceUtil.d());
    int j = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[maybeClearAllConfigs] remoteVersion=");
    localStringBuilder.append(i);
    localStringBuilder.append(", localVersion=");
    localStringBuilder.append(j);
    QLog.d("ReadInJoyResetUtils", 2, localStringBuilder.toString());
    if (i != j) {
      try
      {
        c();
        QQAladdinPrefUtils.a();
        e();
        f();
        g();
        a(i);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[maybeClearAllConfigs] done resetting, update local version to ");
        localStringBuilder.append(i);
        QLog.i("ReadInJoyResetUtils", 1, localStringBuilder.toString());
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ReadInJoyResetUtils", 1, "[maybeClearAllConfigs] ", localException);
        return;
      }
    }
    QLog.d("ReadInJoyResetUtils", 2, "[maybeClearAllConfigs] won't reset");
  }
  
  public static void c()
  {
    QLog.i("ReadInJoyResetUtils", 1, "[resetKandianRelatedManageConfigVersions] set type READINJOY_COMMON_CONFIG - 92 to 0");
    SharedPreUtils.o(BaseApplicationImpl.getApplication(), 0, RIJQQAppInterfaceUtil.d());
    QLog.i("ReadInJoyResetUtils", 1, "[resetKandianRelatedManageConfigVersions] set type READINJOY_MERGE_CONFIG_CMD - 79 to 0");
    SharedPreUtils.n(BaseApplicationImpl.getApplication(), 0, RIJQQAppInterfaceUtil.d());
    QLog.i("ReadInJoyResetUtils", 1, "[resetKandianRelatedManageConfigVersions] set type READINJOY_FOLDER_CONFIG_CMD - 72 to 0");
    SharedPreUtils.p(BaseApplicationImpl.getApplication(), RIJQQAppInterfaceUtil.d(), 0);
    QLog.i("ReadInJoyResetUtils", 1, "[resetKandianRelatedManageConfigVersions] set type READINJOY_FOLDER_SETTING_CMD - 72 to 0");
    SharedPreUtils.o(BaseApplicationImpl.getApplication(), 0);
    QLog.i("ReadInJoyResetUtils", 1, "[resetKandianRelatedManageConfigVersions] set type READINJOY_SEARCH_JUMP_URL_CONFIG - 292 to 0");
    SharedPreUtils.a(BaseApplicationImpl.getApplication(), "readinjoy_search_jump_url_version", RIJQQAppInterfaceUtil.d(), 0);
  }
  
  public static void d()
  {
    QLog.d("ReadInJoyResetUtils", 2, "[clearSkinResInDefaultSP] clear stuff in mobileQQ SP");
    a(BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4));
    QLog.d("ReadInJoyResetUtils", 2, "[clearSkinResInDefaultSP] clear stuff in mobileQQ SP success");
    QLog.d("ReadInJoyResetUtils", 2, "[clearSkinResInDefaultSP] clear stuff in default SP");
    a(PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()));
    QLog.d("ReadInJoyResetUtils", 2, "[clearSkinResInDefaultSP] clear stuff in default SP success");
  }
  
  public static void e()
  {
    QLog.d("ReadInJoyResetUtils", 2, "[clearReadInJoySharedPreferences] ");
    Object localObject = RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), true, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).clear();
      if (((SharedPreferences.Editor)localObject).commit()) {
        QLog.d("ReadInJoyResetUtils", 2, "[clearReadInJoySharedPreferences] clear account related sp success");
      } else {
        QLog.e("ReadInJoyResetUtils", 1, "[clearReadInJoySharedPreferences] fail when commit account related sp");
      }
    }
    else
    {
      QLog.e("ReadInJoyResetUtils", 1, "[clearReadInJoySharedPreferences] sp is null");
    }
    localObject = RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), false, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).clear();
      if (((SharedPreferences.Editor)localObject).commit()) {
        QLog.d("ReadInJoyResetUtils", 2, "[clearReadInJoySharedPreferences] clear account unrelated sp success");
      } else {
        QLog.e("ReadInJoyResetUtils", 1, "[clearReadInJoySharedPreferences] fail when commit account unrelated sp");
      }
    }
    else
    {
      QLog.e("ReadInJoyResetUtils", 1, "[clearReadInJoySharedPreferences] sp is null");
    }
    d();
    j();
  }
  
  public static void f()
  {
    QLog.d("ReadInJoyResetUtils", 2, "clearReadInJoyDatabase");
    try
    {
      EntityManagerFactory localEntityManagerFactory = ReadInJoyLogicEngine.a().b();
      if ((localEntityManagerFactory instanceof ReadInJoyEntityManagerFactory))
      {
        ((ReadInJoyEntityManagerFactory)localEntityManagerFactory).a();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyResetUtils", 2, "clearReadInJoyDatabase: ", localException);
    }
  }
  
  public static void g()
  {
    QLog.d("ReadInJoyResetUtils", 2, "clearReadInJoyLocalFiles");
    k();
    l();
    m();
  }
  
  public static String h()
  {
    return TextUtils.join("\n", new String[] { CommonSkinRes.c(), OfflineUtils.d() });
  }
  
  public static void i()
  {
    a(0);
  }
  
  private static void j()
  {
    QLog.d("ReadInJoyResetUtils", 2, "[clearSettings] QQSETTING_KANDIAN_DOWNLOAD_PIC_IN_WIFI_ONLY set to false");
    SettingCloneUtil.writeValue(BaseApplicationImpl.getApplication(), RIJQQAppInterfaceUtil.d(), null, "qqsetting_kandian_download_pic_flag", false);
    QLog.d("ReadInJoyResetUtils", 2, "[clearSettings] done");
  }
  
  private static void k()
  {
    QLog.d("ReadInJoyResetUtils", 2, "clearSkinRes");
    Object localObject = new File(Common.f());
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject[i];
          try
          {
            if (str.getName().toLowerCase().contains("readinjoy"))
            {
              str = str.getAbsolutePath();
              FileUtils.delete(str, false);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("[clearSkinRes] deleted ");
              localStringBuilder.append(str);
              QLog.d("ReadInJoyResetUtils", 2, localStringBuilder.toString());
            }
          }
          catch (Exception localException2)
          {
            QLog.e("ReadInJoyResetUtils", 1, "[clearSkinRes] ", localException2);
          }
          i += 1;
        }
      }
    }
    try
    {
      localObject = (ReadInJoyOperationManager)RIJQQAppInterfaceUtil.e().getManager(QQManagerFactory.READ_IN_JOY_OPERATION_MANAGER);
      if (localObject != null)
      {
        ((ReadInJoyOperationManager)localObject).a();
        QLog.d("ReadInJoyResetUtils", 2, "[clearSkinRes] successfully delete guide data in db");
        return;
      }
      QLog.e("ReadInJoyResetUtils", 1, "[clearSkinRes] operation manager is null");
      return;
    }
    catch (Exception localException1)
    {
      QLog.e("ReadInJoyResetUtils", 1, "[clearSkinRes] ", localException1);
    }
  }
  
  private static void l()
  {
    QLog.d("ReadInJoyResetUtils", 2, "clearProteusStyles");
    OfflineUtils.c();
  }
  
  private static void m()
  {
    QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint");
    try
    {
      Object localObject = ((QQAppInterface)RIJQQAppInterfaceUtil.e()).getMessageFacade();
      ((QQMessageFacade)localObject).c(AppConstants.KANDIAN_MERGE_UIN, 7220);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: KANDIAN_MERGE_UIN cleared");
      ((QQMessageFacade)localObject).c(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: KANDIAN_SUBSCRIBE_UIN cleared");
      ((QQMessageFacade)localObject).c(AppConstants.NEW_KANDIAN_UIN, 1008);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: NEW_KANDIAN_UIN UIN_TYPE_PUBLIC_ACCOUNT cleared");
      ((QQMessageFacade)localObject).c(AppConstants.NEW_KANDIAN_UIN, 0);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: NEW_KANDIAN_UIN UIN_TYPE_FRIEND cleared");
      ((QQMessageFacade)localObject).c(AppConstants.OLD_KANDIAN_UIN, 1008);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: OLD_KANDIAN_UIN UIN_TYPE_PUBLIC_ACCOUNT cleared");
      ((QQMessageFacade)localObject).c(AppConstants.OLD_KANDIAN_UIN, 0);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: NEW_KANDIAN_UIN UIN_TYPE_FRIEND cleared");
      ((QQMessageFacade)localObject).c(AppConstants.WEISHI_UIN, 1008);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: WEISHI_UIN cleared");
      ((QQMessageFacade)localObject).c(AppConstants.KANDIAN_DAILY_UIN, 1008);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: KANDIAN_DAILY cleared");
      localObject = ReadInJoyHelper.a((QQAppInterface)RIJQQAppInterfaceUtil.e(), 1);
      if (localObject != null)
      {
        if (((SharedPreferences)localObject).edit().clear().commit())
        {
          QLog.d("ReadInJoyResetUtils", 2, "[clearRedPoint] clear red point in sp xml success");
          return;
        }
        QLog.d("ReadInJoyResetUtils", 2, "[clearRedPoint] clear red point in sp xml failed");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyResetUtils", 2, "clearRedPoint: ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyResetUtils
 * JD-Core Version:    0.7.0.1
 */