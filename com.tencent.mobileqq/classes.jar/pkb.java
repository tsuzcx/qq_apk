import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyEntityManagerFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class pkb
{
  public static int a()
  {
    SharedPreferences localSharedPreferences = a(pkh.a());
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
    paramAppRuntime = "readinjoy_sp_reset_" + paramAppRuntime.getAccount();
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramAppRuntime, 0);
  }
  
  public static void a()
  {
    int i = bhhr.O(BaseApplicationImpl.getApplication(), pkh.a());
    int j = a();
    QLog.d("ReadInJoyResetUtils", 2, "[maybeClearAllConfigs] remoteVersion=" + i + ", localVersion=" + j);
    if (i != j) {
      try
      {
        b();
        pkw.a();
        d();
        e();
        f();
        a(i);
        QLog.i("ReadInJoyResetUtils", 1, "[maybeClearAllConfigs] done resetting, update local version to " + i);
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
  
  private static void a(int paramInt)
  {
    SharedPreferences localSharedPreferences = a(pkh.a());
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
      List localList = rsw.a(paramSharedPreferences.getAll().keySet(), new pkc());
      paramSharedPreferences = paramSharedPreferences.edit();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        paramSharedPreferences.remove((String)localIterator.next());
      }
      paramSharedPreferences.commit();
      QLog.d("ReadInJoyResetUtils", 2, "[removeReadInJoyKeysInSharedPreferences] removed " + localList);
    }
  }
  
  public static void b()
  {
    QLog.i("ReadInJoyResetUtils", 1, "[resetKandianRelatedManageConfigVersions] set type READINJOY_COMMON_CONFIG - 92 to 0");
    bhhr.q(BaseApplicationImpl.getApplication(), 0, pkh.a());
    QLog.i("ReadInJoyResetUtils", 1, "[resetKandianRelatedManageConfigVersions] set type READINJOY_MERGE_CONFIG_CMD - 79 to 0");
    bhhr.p(BaseApplicationImpl.getApplication(), 0, pkh.a());
    QLog.i("ReadInJoyResetUtils", 1, "[resetKandianRelatedManageConfigVersions] set type READINJOY_FOLDER_CONFIG_CMD - 72 to 0");
    bhhr.s(BaseApplicationImpl.getApplication(), pkh.a(), 0);
    QLog.i("ReadInJoyResetUtils", 1, "[resetKandianRelatedManageConfigVersions] set type READINJOY_FOLDER_SETTING_CMD - 72 to 0");
    bhhr.n(BaseApplicationImpl.getApplication(), 0);
    QLog.i("ReadInJoyResetUtils", 1, "[resetKandianRelatedManageConfigVersions] set type READINJOY_SEARCH_JUMP_URL_CONFIG - 292 to 0");
    bhhr.a(BaseApplicationImpl.getApplication(), "readinjoy_search_jump_url_version", pkh.a(), 0);
  }
  
  public static void c()
  {
    QLog.d("ReadInJoyResetUtils", 2, "[clearSkinResInDefaultSP] clear stuff in mobileQQ SP");
    a(BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4));
    QLog.d("ReadInJoyResetUtils", 2, "[clearSkinResInDefaultSP] clear stuff in mobileQQ SP success");
    QLog.d("ReadInJoyResetUtils", 2, "[clearSkinResInDefaultSP] clear stuff in default SP");
    a(PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()));
    QLog.d("ReadInJoyResetUtils", 2, "[clearSkinResInDefaultSP] clear stuff in default SP success");
  }
  
  public static void d()
  {
    QLog.d("ReadInJoyResetUtils", 2, "[clearReadInJoySharedPreferences] ");
    Object localObject = bmhv.a(pkh.a(), true, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).clear();
      if (((SharedPreferences.Editor)localObject).commit())
      {
        QLog.d("ReadInJoyResetUtils", 2, "[clearReadInJoySharedPreferences] clear account related sp success");
        localObject = bmhv.a(pkh.a(), false, true);
        if (localObject == null) {
          break label138;
        }
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).clear();
        if (!((SharedPreferences.Editor)localObject).commit()) {
          break label126;
        }
        QLog.d("ReadInJoyResetUtils", 2, "[clearReadInJoySharedPreferences] clear account unrelated sp success");
      }
    }
    for (;;)
    {
      c();
      g();
      return;
      QLog.e("ReadInJoyResetUtils", 1, "[clearReadInJoySharedPreferences] fail when commit account related sp");
      break;
      QLog.e("ReadInJoyResetUtils", 1, "[clearReadInJoySharedPreferences] sp is null");
      break;
      label126:
      QLog.e("ReadInJoyResetUtils", 1, "[clearReadInJoySharedPreferences] fail when commit account unrelated sp");
      continue;
      label138:
      QLog.e("ReadInJoyResetUtils", 1, "[clearReadInJoySharedPreferences] sp is null");
    }
  }
  
  public static void e()
  {
    QLog.d("ReadInJoyResetUtils", 2, "clearReadInJoyDatabase");
    try
    {
      EntityManagerFactory localEntityManagerFactory = pvj.a().a();
      if ((localEntityManagerFactory instanceof ReadInJoyEntityManagerFactory)) {
        ((ReadInJoyEntityManagerFactory)localEntityManagerFactory).a();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyResetUtils", 2, "clearReadInJoyDatabase: ", localException);
    }
  }
  
  public static void f()
  {
    QLog.d("ReadInJoyResetUtils", 2, "clearReadInJoyLocalFiles");
    h();
    i();
    j();
  }
  
  private static void g()
  {
    QLog.d("ReadInJoyResetUtils", 2, "[clearSettings] QQSETTING_KANDIAN_DOWNLOAD_PIC_IN_WIFI_ONLY set to false");
    SettingCloneUtil.writeValue(BaseApplicationImpl.getApplication(), pkh.a(), null, "qqsetting_kandian_download_pic_flag", false);
    QLog.d("ReadInJoyResetUtils", 2, "[clearSettings] done");
  }
  
  private static void h()
  {
    QLog.d("ReadInJoyResetUtils", 2, "clearSkinRes");
    Object localObject = new File(bjht.e());
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            String str = localObject[i];
            try
            {
              if (str.getName().toLowerCase().contains("readinjoy"))
              {
                str = str.getAbsolutePath();
                FileUtils.delete(str, false);
                QLog.d("ReadInJoyResetUtils", 2, "[clearSkinRes] deleted " + str);
              }
              i += 1;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                QLog.e("ReadInJoyResetUtils", 1, "[clearSkinRes] ", localException2);
              }
            }
          }
        }
      }
    }
    try
    {
      localObject = (rmt)pkh.a().getManager(QQManagerFactory.READ_IN_JOY_OPERATION_MANAGER);
      if (localObject != null)
      {
        ((rmt)localObject).b();
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
  
  private static void i()
  {
    QLog.d("ReadInJoyResetUtils", 2, "clearProteusStyles");
    tmz.c();
  }
  
  private static void j()
  {
    QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint");
    try
    {
      Object localObject = ((QQAppInterface)pkh.a()).getMessageFacade();
      ((QQMessageFacade)localObject).clearHistory(AppConstants.KANDIAN_MERGE_UIN, 7220);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: KANDIAN_MERGE_UIN cleared");
      ((QQMessageFacade)localObject).clearHistory(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: KANDIAN_SUBSCRIBE_UIN cleared");
      ((QQMessageFacade)localObject).clearHistory(AppConstants.NEW_KANDIAN_UIN, 1008);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: NEW_KANDIAN_UIN UIN_TYPE_PUBLIC_ACCOUNT cleared");
      ((QQMessageFacade)localObject).clearHistory(AppConstants.NEW_KANDIAN_UIN, 0);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: NEW_KANDIAN_UIN UIN_TYPE_FRIEND cleared");
      ((QQMessageFacade)localObject).clearHistory(AppConstants.OLD_KANDIAN_UIN, 1008);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: OLD_KANDIAN_UIN UIN_TYPE_PUBLIC_ACCOUNT cleared");
      ((QQMessageFacade)localObject).clearHistory(AppConstants.OLD_KANDIAN_UIN, 0);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: NEW_KANDIAN_UIN UIN_TYPE_FRIEND cleared");
      ((QQMessageFacade)localObject).clearHistory(AppConstants.WEISHI_UIN, 1008);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: WEISHI_UIN cleared");
      ((QQMessageFacade)localObject).clearHistory(AppConstants.KANDIAN_DAILY_UIN, 1008);
      QLog.d("ReadInJoyResetUtils", 2, "clearRedPoint: KANDIAN_DAILY cleared");
      localObject = bmhv.a((QQAppInterface)pkh.a(), 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pkb
 * JD-Core Version:    0.7.0.1
 */