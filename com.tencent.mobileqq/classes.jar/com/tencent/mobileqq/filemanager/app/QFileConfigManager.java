package com.tencent.mobileqq.filemanager.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.qfile.IConfigMgr;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingC2CDownloadConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingC2CUploadConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingGroupDownloadConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingGroupUploadConfigBean;
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
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.util.QStorage;
import com.tencent.mobileqq.filemanager.data.DownloadFileConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QFileConfigManager
  implements IConfigMgr
{
  private int jdField_a_of_type_Int = 0;
  private IQFileExcitingC2CDownloadConfigBean jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingC2CDownloadConfigBean;
  private IQFileExcitingC2CUploadConfigBean jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingC2CUploadConfigBean;
  private IQFileExcitingGroupDownloadConfigBean jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingGroupDownloadConfigBean;
  private IQFileExcitingGroupUploadConfigBean jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingGroupUploadConfigBean;
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
  
  public QFileConfigManager(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    d();
  }
  
  public static QFileConfigManager a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {
      try
      {
        paramAppRuntime = (QFileConfigManager)((IQFileConfigManager)paramAppRuntime.getRuntimeService(IQFileConfigManager.class, "all")).getQFileConfigManager();
        return paramAppRuntime;
      }
      finally
      {
        break label46;
      }
    }
    throw new NullPointerException("app is null!");
    label46:
    throw paramAppRuntime;
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadYYBPromoteActionConfig: load download config. ");
      localStringBuilder.append(paramString);
      QLog.i("QFileConfigManager", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileAppStorePromoteConfigBean = ((QFileAppStorePromoteConfigBean)QStorage.a(paramString, QFileAppStorePromoteConfigBean.class));
  }
  
  private void d()
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
    c();
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadYYBPromoteDialogConfig: load download config. ");
      localStringBuilder.append(paramString);
      QLog.i("QFileConfigManager", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileAppStorePromoteDialogConfigBean = ((QFileAppStorePromoteDialogConfigBean)QStorage.a(paramString, QFileAppStorePromoteDialogConfigBean.class));
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    this.jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("troop_video_preivew", false);
    this.jdField_b_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("troop_video_preivew_for_svip", false);
    this.c = ((SharedPreferences)localObject).getBoolean("troop_video_preivew_for_yearsvip", false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initTroopFileVideoPreviewConfig: load common config. enableTroopVidePreview[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject).append("] enableTroopVidePreviewForSVIP[");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
    ((StringBuilder)localObject).append("] enableTroopVidePreviewForYearSVIP[");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject).toString());
  }
  
  private void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadFileReaderConfig: load download config. ");
      localStringBuilder.append(paramString);
      QLog.i("QFileConfigManager", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileFileReaderConfigBean = ((QFileFileReaderConfigBean)QStorage.a(paramString, QFileFileReaderConfigBean.class));
    ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).setCheckShowTbsReaderBar(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileFileReaderConfigBean.isShowReaderBar);
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    this.g = ((SharedPreferences)localObject).getBoolean("ipv6_all_switch", false);
    this.h = ((SharedPreferences)localObject).getBoolean("ipv6_c2c_switch", false);
    this.i = ((SharedPreferences)localObject).getBoolean("ipv6_group_switch", false);
    this.j = ((SharedPreferences)localObject).getBoolean("ipv6_disc_switch", false);
    this.k = ((SharedPreferences)localObject).getBoolean("ipv6_dataline_switch", false);
    this.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("ipv6_strategy", 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initFileIPv6Config: load config. enableFileIPv6[");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append("] enableC2CIPv6[");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append("] enableGroupIPv6[");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append("] enableDiscIPv6[");
    ((StringBuilder)localObject).append(this.j);
    ((StringBuilder)localObject).append("] enableDatalineIPv6[");
    ((StringBuilder)localObject).append(this.k);
    ((StringBuilder)localObject).append("] strategy[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject).toString());
  }
  
  private void f(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadDatalineConfig: load dataline config. ");
      localStringBuilder.append(paramString);
      QLog.i("QFileConfigManager", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileDatalineConfigBean = ((QFileDatalineConfigBean)QStorage.a(paramString, QFileDatalineConfigBean.class));
  }
  
  private void g()
  {
    Context localContext = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    c(localContext.getSharedPreferences(localStringBuilder.toString(), 0).getString("yyb_promote_action_key", "{}"));
  }
  
  private void g(String paramString)
  {
    Object localObject = (QFileDownloadConfigBean)QStorage.a(paramString, QFileDownloadConfigBean.class);
    if (localObject != null)
    {
      k();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap.putAll(((QFileDownloadConfigBean)localObject).jdField_a_of_type_JavaUtilHashMap);
    }
    if (TextUtils.isEmpty(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadFileDownloadConfig: load download config. ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void h()
  {
    Context localContext = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    d(localContext.getSharedPreferences(localStringBuilder.toString(), 0).getString("yyb_promote_dialog_key", "{}"));
  }
  
  private void i()
  {
    Context localContext = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    e(localContext.getSharedPreferences(localStringBuilder.toString(), 0).getString("file_reader_key", "{}"));
  }
  
  private void j()
  {
    Context localContext = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    f(localContext.getSharedPreferences(localStringBuilder.toString(), 0).getString("file_dataline_key", "{}"));
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
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString("qfile_file_auto_download", "{}");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("initFileDownloadConfig: load download config [");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    QLog.i("QFileConfigManager", 1, localStringBuilder.toString());
    g((String)localObject);
  }
  
  private void m()
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("c2cfile_excitingupload_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    localObject1 = ((Context)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getString("qfile_c2cfile_excitingupload", "{}");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("load Exciting-C2C-Upload Config [");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new QFileExcitingC2CUploadConfigBean();
    ((QFileExcitingC2CUploadConfigBean)localObject2).a((String)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingC2CUploadConfigBean = ((IQFileExcitingC2CUploadConfigBean)localObject2);
  }
  
  private void n()
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("c2cfile_excitingdownload_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    localObject1 = ((Context)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getString("qfile_c2cfile_excitingdownload", "{}");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("load Exciting-C2C-Download Config [");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new QFileExcitingC2CDownloadConfigBean();
    ((QFileExcitingC2CDownloadConfigBean)localObject2).a((String)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingC2CDownloadConfigBean = ((IQFileExcitingC2CDownloadConfigBean)localObject2);
  }
  
  private void o()
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("groupfile_excitingupload_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    localObject1 = ((Context)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getString("qfile_groupfile_excitingupload", "{}");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("load Exciting-Group-Upload Config [");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new QFileExcitingGroupUploadConfigBean();
    ((QFileExcitingGroupUploadConfigBean)localObject2).a((String)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingGroupUploadConfigBean = ((IQFileExcitingGroupUploadConfigBean)localObject2);
  }
  
  private void p()
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("groupfile_excitingdownload_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    localObject1 = ((Context)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getString("qfile_groupfile_excitingdownload", "{}");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("load Exciting-Group-Download Config [");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new QFileExcitingGroupDownloadConfigBean();
    ((QFileExcitingGroupDownloadConfigBean)localObject2).a((String)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingGroupDownloadConfigBean = ((IQFileExcitingGroupDownloadConfigBean)localObject2);
  }
  
  private void q()
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("qfile_file_assistant_tips");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    localObject1 = ((Context)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getString("qfile_file_assistant_tips", "{}");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("load QFILE_CONFIG_FILE_ASSISTANT_TIPS Config [");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new QfileFileAssistantTipsConfigBean();
    ((QfileFileAssistantTipsConfigBean)localObject2).a((String)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig = ((IFileAssistantTipsConfig)localObject2);
  }
  
  private void r()
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    this.d = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("enable_file_media_platform", false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initMediaPlatformConfig: load common config. enableFileMediaPlatform[");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject).toString());
  }
  
  private void s()
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
    this.l = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("apkcheck_enable_switch", false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initMMApkFileCheckConfig: load apkcheckconfig. enable[");
    ((StringBuilder)localObject).append(this.l);
    ((StringBuilder)localObject).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject).toString());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public IQFileExcitingC2CDownloadConfigBean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingC2CDownloadConfigBean;
  }
  
  public IQFileExcitingC2CUploadConfigBean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingC2CUploadConfigBean;
  }
  
  public IQFileExcitingGroupDownloadConfigBean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingGroupDownloadConfigBean;
  }
  
  public IQFileExcitingGroupUploadConfigBean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingGroupUploadConfigBean;
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
  
  public void a()
  {
    ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).setCheckShowTbsReaderBar(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileFileReaderConfigBean.isShowReaderBar);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.2(this, paramBundle));
  }
  
  public void a(IQFileExcitingC2CDownloadConfigBean paramIQFileExcitingC2CDownloadConfigBean)
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingC2CDownloadConfigBean = paramIQFileExcitingC2CDownloadConfigBean;
  }
  
  public void a(IQFileExcitingC2CUploadConfigBean paramIQFileExcitingC2CUploadConfigBean)
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingC2CUploadConfigBean = paramIQFileExcitingC2CUploadConfigBean;
  }
  
  public void a(IQFileExcitingGroupDownloadConfigBean paramIQFileExcitingGroupDownloadConfigBean)
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingGroupDownloadConfigBean = paramIQFileExcitingGroupDownloadConfigBean;
  }
  
  public void a(IQFileExcitingGroupUploadConfigBean paramIQFileExcitingGroupUploadConfigBean)
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileIQFileExcitingGroupUploadConfigBean = paramIQFileExcitingGroupUploadConfigBean;
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
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).setCheckShowTbsReaderBar(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQfileQFileFileReaderConfigBean.isShowReaderBar);
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
  
  public void b() {}
  
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
  
  public void c()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "3636666661";
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean c()
  {
    return this.c;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set apkcheckConfig enable:");
    localStringBuilder.append(paramBoolean);
    QLog.i("QFileConfigManager", 1, localStringBuilder.toString());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager
 * JD-Core Version:    0.7.0.1
 */