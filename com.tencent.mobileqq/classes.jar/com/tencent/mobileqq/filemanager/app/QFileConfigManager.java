package com.tencent.mobileqq.filemanager.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.qfile.IExcitingC2CDownloadConfig;
import com.tencent.mobileqq.config.business.qfile.IExcitingC2CUploadConfig;
import com.tencent.mobileqq.config.business.qfile.IExcitingGroupDownloadConfig;
import com.tencent.mobileqq.config.business.qfile.IExcitingGroupUploadConfig;
import com.tencent.mobileqq.config.business.qfile.QFileAppStorePromoteConfigBean;
import com.tencent.mobileqq.config.business.qfile.QFileAppStorePromoteDialogConfigBean;
import com.tencent.mobileqq.config.business.qfile.QFileDatalineConfigBean;
import com.tencent.mobileqq.config.business.qfile.QFileDownloadConfigBean;
import com.tencent.mobileqq.config.business.qfile.QFileExcitingC2CDownloadConfigBean;
import com.tencent.mobileqq.config.business.qfile.QFileExcitingC2CUploadConfigBean;
import com.tencent.mobileqq.config.business.qfile.QFileExcitingGroupDownloadConfigBean;
import com.tencent.mobileqq.config.business.qfile.QFileExcitingGroupUploadConfigBean;
import com.tencent.mobileqq.config.business.qfile.QFileFileReaderConfigBean;
import com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.api.util.QStorage;
import com.tencent.mobileqq.filemanager.data.DownloadFileConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class QFileConfigManager
  implements Manager
{
  private static QFileConfigManager jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileConfigManager = null;
  private int jdField_a_of_type_Int = 0;
  private IExcitingC2CDownloadConfig jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingC2CDownloadConfig;
  private IExcitingC2CUploadConfig jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingC2CUploadConfig;
  private IExcitingGroupDownloadConfig jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingGroupDownloadConfig;
  private IExcitingGroupUploadConfig jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingGroupUploadConfig;
  private QFileAppStorePromoteConfigBean jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileAppStorePromoteConfigBean;
  private QFileAppStorePromoteDialogConfigBean jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileAppStorePromoteDialogConfigBean;
  private QFileDatalineConfigBean jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileDatalineConfigBean;
  private QFileFileReaderConfigBean jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileFileReaderConfigBean;
  private IFileAssistantTipsConfig jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig;
  private String jdField_a_of_type_JavaLangString = "";
  private HashMap<String, DownloadFileConfig> jdField_a_of_type_JavaUtilHashMap;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 65799;
  private String jdField_b_of_type_JavaLangString = "101.91.91.150";
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  
  public static QFileConfigManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileConfigManager == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QFileConfigManager", 1, "[QFileConfigManager-getInstance] create");
        }
        jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileConfigManager = new QFileConfigManager();
      }
      QFileConfigManager localQFileConfigManager = jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileConfigManager;
      return localQFileConfigManager;
    }
    finally {}
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.i("QFileConfigManager", 1, "loadYYBPromoteActionConfig: load download config. " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileAppStorePromoteConfigBean = ((QFileAppStorePromoteConfigBean)QStorage.a(paramString, QFileAppStorePromoteConfigBean.class));
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.i("QFileConfigManager", 1, "loadYYBPromoteDialogConfig: load download config. " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileAppStorePromoteDialogConfigBean = ((QFileAppStorePromoteDialogConfigBean)QStorage.a(paramString, QFileAppStorePromoteDialogConfigBean.class));
  }
  
  private void e()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext().getSharedPreferences("file_config_" + this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), 0);
    this.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("troop_video_preivew", false);
    this.jdField_b_of_type_Boolean = localSharedPreferences.getBoolean("troop_video_preivew_for_svip", false);
    this.c = localSharedPreferences.getBoolean("troop_video_preivew_for_yearsvip", false);
    QLog.i("QFileConfigManager", 1, "initTroopFileVideoPreviewConfig: load common config. enableTroopVidePreview[" + this.jdField_a_of_type_Boolean + "] enableTroopVidePreviewForSVIP[" + this.jdField_b_of_type_Boolean + "] enableTroopVidePreviewForYearSVIP[" + this.c + "]");
  }
  
  private void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.i("QFileConfigManager", 1, "loadFileReaderConfig: load download config. " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileFileReaderConfigBean = ((QFileFileReaderConfigBean)QStorage.a(paramString, QFileFileReaderConfigBean.class));
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).setCheckShowTbsReaderBarByLocalTbsViewManager(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileFileReaderConfigBean.jdField_a_of_type_Boolean);
  }
  
  private void f()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext().getSharedPreferences("file_config_" + this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), 0);
    this.g = localSharedPreferences.getBoolean("ipv6_all_switch", false);
    this.h = localSharedPreferences.getBoolean("ipv6_c2c_switch", false);
    this.i = localSharedPreferences.getBoolean("ipv6_group_switch", false);
    this.j = localSharedPreferences.getBoolean("ipv6_disc_switch", false);
    this.k = localSharedPreferences.getBoolean("ipv6_dataline_switch", false);
    this.jdField_a_of_type_Int = localSharedPreferences.getInt("ipv6_strategy", 0);
    QLog.i("QFileConfigManager", 1, "initFileIPv6Config: load config. enableFileIPv6[" + this.g + "] enableC2CIPv6[" + this.h + "] enableGroupIPv6[" + this.i + "] enableDiscIPv6[" + this.j + "] enableDatalineIPv6[" + this.k + "] strategy[" + this.jdField_a_of_type_Int + "]");
  }
  
  private void f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.i("QFileConfigManager", 1, "loadDatalineConfig: load dataline config. " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileDatalineConfigBean = ((QFileDatalineConfigBean)QStorage.a(paramString, QFileDatalineConfigBean.class));
  }
  
  private void g()
  {
    c(this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext().getSharedPreferences("file_config_" + this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), 0).getString("yyb_promote_action_key", "{}"));
  }
  
  private void g(String paramString)
  {
    QFileDownloadConfigBean localQFileDownloadConfigBean = (QFileDownloadConfigBean)QStorage.a(paramString, QFileDownloadConfigBean.class);
    if (localQFileDownloadConfigBean != null)
    {
      k();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap.putAll(localQFileDownloadConfigBean.jdField_a_of_type_JavaUtilHashMap);
    }
    if (TextUtils.isEmpty(paramString)) {
      QLog.i("QFileConfigManager", 1, "loadFileDownloadConfig: load download config. " + paramString);
    }
  }
  
  private void h()
  {
    d(this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext().getSharedPreferences("file_config_" + this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), 0).getString("yyb_promote_dialog_key", "{}"));
  }
  
  private void i()
  {
    e(this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext().getSharedPreferences("file_config_" + this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), 0).getString("file_reader_key", "{}"));
  }
  
  private void j()
  {
    f(this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext().getSharedPreferences("file_config_" + this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), 0).getString("file_dataline_key", "{}"));
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext().getSharedPreferences("file_config_" + this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), 0).getString("qfile_file_auto_download", "{}");
    QLog.i("QFileConfigManager", 1, "initFileDownloadConfig: load download config [" + str + "]");
    g(str);
  }
  
  private void m()
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext().getSharedPreferences("c2cfile_excitingupload_" + this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), 0).getString("qfile_c2cfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Upload Config [" + str + "]");
    QFileExcitingC2CUploadConfigBean localQFileExcitingC2CUploadConfigBean = new QFileExcitingC2CUploadConfigBean();
    localQFileExcitingC2CUploadConfigBean.a(str);
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingC2CUploadConfig = localQFileExcitingC2CUploadConfigBean;
  }
  
  private void n()
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext().getSharedPreferences("c2cfile_excitingdownload_" + this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), 0).getString("qfile_c2cfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Download Config [" + str + "]");
    QFileExcitingC2CDownloadConfigBean localQFileExcitingC2CDownloadConfigBean = new QFileExcitingC2CDownloadConfigBean();
    localQFileExcitingC2CDownloadConfigBean.a(str);
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingC2CDownloadConfig = localQFileExcitingC2CDownloadConfigBean;
  }
  
  private void o()
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext().getSharedPreferences("groupfile_excitingupload_" + this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), 0).getString("qfile_groupfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Upload Config [" + str + "]");
    QFileExcitingGroupUploadConfigBean localQFileExcitingGroupUploadConfigBean = new QFileExcitingGroupUploadConfigBean();
    localQFileExcitingGroupUploadConfigBean.a(str);
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingGroupUploadConfig = localQFileExcitingGroupUploadConfigBean;
  }
  
  private void p()
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext().getSharedPreferences("groupfile_excitingdownload_" + this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), 0).getString("qfile_groupfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Download Config [" + str + "]");
    QFileExcitingGroupDownloadConfigBean localQFileExcitingGroupDownloadConfigBean = new QFileExcitingGroupDownloadConfigBean();
    localQFileExcitingGroupDownloadConfigBean.a(str);
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingGroupDownloadConfig = localQFileExcitingGroupDownloadConfigBean;
  }
  
  private void q()
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext().getSharedPreferences("qfile_file_assistant_tips" + this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), 0).getString("qfile_file_assistant_tips", "{}");
    QLog.i("QFileConfigManager", 1, "load QFILE_CONFIG_FILE_ASSISTANT_TIPS Config [" + str + "]");
    QfileFileAssistantTipsConfigBean localQfileFileAssistantTipsConfigBean = new QfileFileAssistantTipsConfigBean();
    localQfileFileAssistantTipsConfigBean.a(str);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig = localQfileFileAssistantTipsConfigBean;
  }
  
  private void r()
  {
    this.d = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext().getSharedPreferences("file_config_" + this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), 0).getBoolean("enable_file_media_platform", false);
    QLog.i("QFileConfigManager", 1, "initMediaPlatformConfig: load common config. enableFileMediaPlatform[" + this.d + "]");
  }
  
  private void s()
  {
    this.l = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext().getSharedPreferences("file_config_" + this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), 0).getBoolean("apkcheck_enable_switch", false);
    QLog.i("QFileConfigManager", 1, "initMMApkFileCheckConfig: load apkcheckconfig. enable[" + this.l + "]");
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public IExcitingC2CDownloadConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingC2CDownloadConfig;
  }
  
  public IExcitingC2CUploadConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingC2CUploadConfig;
  }
  
  public IExcitingGroupDownloadConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingGroupDownloadConfig;
  }
  
  public IExcitingGroupUploadConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingGroupUploadConfig;
  }
  
  public QFileAppStorePromoteConfigBean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileAppStorePromoteConfigBean;
  }
  
  public QFileAppStorePromoteDialogConfigBean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileAppStorePromoteDialogConfigBean;
  }
  
  public QFileDatalineConfigBean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileDatalineConfigBean;
  }
  
  public QFileFileReaderConfigBean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileFileReaderConfigBean;
  }
  
  public IFileAssistantTipsConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig;
  }
  
  public DownloadFileConfig a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramString.toLowerCase();
    }
    k();
    localObject = (DownloadFileConfig)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = (DownloadFileConfig)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    localObject = paramString;
    if (paramString == null)
    {
      g("{}");
      localObject = (DownloadFileConfig)this.jdField_a_of_type_JavaUtilHashMap.get("*");
    }
    return localObject;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public AppRuntime a()
  {
    return this.jdField_a_of_type_MqqAppAppRuntime;
  }
  
  public void a()
  {
    l();
    e();
    r();
    f();
    m();
    n();
    o();
    p();
    q();
    g();
    h();
    i();
    s();
    j();
    d();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.2(this, paramBundle));
  }
  
  public void a(IExcitingC2CDownloadConfig paramIExcitingC2CDownloadConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingC2CDownloadConfig = paramIExcitingC2CDownloadConfig;
  }
  
  public void a(IExcitingC2CUploadConfig paramIExcitingC2CUploadConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingC2CUploadConfig = paramIExcitingC2CUploadConfig;
  }
  
  public void a(IExcitingGroupDownloadConfig paramIExcitingGroupDownloadConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingGroupDownloadConfig = paramIExcitingGroupDownloadConfig;
  }
  
  public void a(IExcitingGroupUploadConfig paramIExcitingGroupUploadConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIExcitingGroupUploadConfig = paramIExcitingGroupUploadConfig;
  }
  
  public void a(QFileAppStorePromoteConfigBean paramQFileAppStorePromoteConfigBean)
  {
    if (paramQFileAppStorePromoteConfigBean != null) {
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileAppStorePromoteConfigBean = paramQFileAppStorePromoteConfigBean;
    }
  }
  
  public void a(QFileAppStorePromoteDialogConfigBean paramQFileAppStorePromoteDialogConfigBean)
  {
    if (paramQFileAppStorePromoteDialogConfigBean != null) {
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileAppStorePromoteDialogConfigBean = paramQFileAppStorePromoteDialogConfigBean;
    }
  }
  
  public void a(QFileDatalineConfigBean paramQFileDatalineConfigBean)
  {
    if (paramQFileDatalineConfigBean != null) {
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileDatalineConfigBean = paramQFileDatalineConfigBean;
    }
  }
  
  public void a(QFileFileReaderConfigBean paramQFileFileReaderConfigBean)
  {
    if (paramQFileFileReaderConfigBean != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileFileReaderConfigBean = paramQFileFileReaderConfigBean;
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).setCheckShowTbsReaderBarByLocalTbsViewManager(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileFileReaderConfigBean.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(IFileAssistantTipsConfig paramIFileAssistantTipsConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig = paramIFileAssistantTipsConfig;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(HashMap<String, DownloadFileConfig> paramHashMap)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.1(this, paramHashMap));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b()
  {
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).setCheckShowTbsReaderBarByLocalTbsViewManager(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileFileReaderConfigBean.jdField_a_of_type_Boolean);
  }
  
  public void b(Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.3(this, paramBundle));
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c() {}
  
  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public void d()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "3636666661";
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public boolean d()
  {
    return this.g;
  }
  
  public void e(boolean paramBoolean)
  {
    this.l = paramBoolean;
    QLog.i("QFileConfigManager", 1, "set apkcheckConfig enable:" + paramBoolean);
  }
  
  public boolean e()
  {
    return this.h;
  }
  
  public void f(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public boolean f()
  {
    return this.i;
  }
  
  public boolean g()
  {
    return this.j;
  }
  
  public boolean h()
  {
    return this.k;
  }
  
  public boolean i()
  {
    return this.m;
  }
  
  public boolean j()
  {
    if (this.e) {
      return this.f;
    }
    return this.d;
  }
  
  public boolean k()
  {
    return this.e;
  }
  
  public boolean l()
  {
    return this.f;
  }
  
  public boolean m()
  {
    return this.o;
  }
  
  public boolean n()
  {
    return this.l;
  }
  
  public boolean o()
  {
    return this.n;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager
 * JD-Core Version:    0.7.0.1
 */