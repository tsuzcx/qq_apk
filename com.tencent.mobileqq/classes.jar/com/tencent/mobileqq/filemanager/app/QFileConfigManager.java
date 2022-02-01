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
  private int A = 65799;
  private boolean B = false;
  private String C = "101.91.91.150";
  private boolean D = false;
  private AppRuntime a;
  private HashMap<String, DownloadFileConfig> b;
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
  private int n = 0;
  private boolean o = false;
  private IQFileExcitingC2CUploadConfigBean p;
  private IQFileExcitingC2CDownloadConfigBean q;
  private IQFileExcitingGroupUploadConfigBean r;
  private IQFileExcitingGroupDownloadConfigBean s;
  private IFileAssistantTipsConfig t;
  private QFileAppStorePromoteConfigBean u;
  private QFileAppStorePromoteDialogConfigBean v;
  private QFileFileReaderConfigBean w;
  private QFileDatalineConfigBean x;
  private String y = "";
  private boolean z = false;
  
  public QFileConfigManager(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
    F();
  }
  
  private void F()
  {
    N();
    G();
    T();
    H();
    O();
    P();
    Q();
    R();
    S();
    I();
    J();
    K();
    U();
    L();
    A();
  }
  
  private void G()
  {
    Object localObject = this.a.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.a.getCurrentUin());
    localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    this.c = ((SharedPreferences)localObject).getBoolean("troop_video_preivew", false);
    this.d = ((SharedPreferences)localObject).getBoolean("troop_video_preivew_for_svip", false);
    this.e = ((SharedPreferences)localObject).getBoolean("troop_video_preivew_for_yearsvip", false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initTroopFileVideoPreviewConfig: load common config. enableTroopVidePreview[");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("] enableTroopVidePreviewForSVIP[");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("] enableTroopVidePreviewForYearSVIP[");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject).toString());
  }
  
  private void H()
  {
    Object localObject = this.a.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.a.getCurrentUin());
    localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    this.i = ((SharedPreferences)localObject).getBoolean("ipv6_all_switch", false);
    this.j = ((SharedPreferences)localObject).getBoolean("ipv6_c2c_switch", false);
    this.k = ((SharedPreferences)localObject).getBoolean("ipv6_group_switch", false);
    this.l = ((SharedPreferences)localObject).getBoolean("ipv6_disc_switch", false);
    this.m = ((SharedPreferences)localObject).getBoolean("ipv6_dataline_switch", false);
    this.n = ((SharedPreferences)localObject).getInt("ipv6_strategy", 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initFileIPv6Config: load config. enableFileIPv6[");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append("] enableC2CIPv6[");
    ((StringBuilder)localObject).append(this.j);
    ((StringBuilder)localObject).append("] enableGroupIPv6[");
    ((StringBuilder)localObject).append(this.k);
    ((StringBuilder)localObject).append("] enableDiscIPv6[");
    ((StringBuilder)localObject).append(this.l);
    ((StringBuilder)localObject).append("] enableDatalineIPv6[");
    ((StringBuilder)localObject).append(this.m);
    ((StringBuilder)localObject).append("] strategy[");
    ((StringBuilder)localObject).append(this.n);
    ((StringBuilder)localObject).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject).toString());
  }
  
  private void I()
  {
    Context localContext = this.a.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.a.getCurrentUin());
    d(localContext.getSharedPreferences(localStringBuilder.toString(), 0).getString("yyb_promote_action_key", "{}"));
  }
  
  private void J()
  {
    Context localContext = this.a.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.a.getCurrentUin());
    e(localContext.getSharedPreferences(localStringBuilder.toString(), 0).getString("yyb_promote_dialog_key", "{}"));
  }
  
  private void K()
  {
    Context localContext = this.a.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.a.getCurrentUin());
    f(localContext.getSharedPreferences(localStringBuilder.toString(), 0).getString("file_reader_key", "{}"));
  }
  
  private void L()
  {
    Context localContext = this.a.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.a.getCurrentUin());
    g(localContext.getSharedPreferences(localStringBuilder.toString(), 0).getString("file_dataline_key", "{}"));
  }
  
  private void M()
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
  }
  
  private void N()
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    Object localObject = this.a.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.a.getCurrentUin());
    localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString("qfile_file_auto_download", "{}");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("initFileDownloadConfig: load download config [");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    QLog.i("QFileConfigManager", 1, localStringBuilder.toString());
    h((String)localObject);
  }
  
  private void O()
  {
    Object localObject1 = this.a.getApplicationContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("c2cfile_excitingupload_");
    ((StringBuilder)localObject2).append(this.a.getCurrentUin());
    localObject1 = ((Context)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getString("qfile_c2cfile_excitingupload", "{}");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("load Exciting-C2C-Upload Config [");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new QFileExcitingC2CUploadConfigBean();
    ((QFileExcitingC2CUploadConfigBean)localObject2).a((String)localObject1);
    this.p = ((IQFileExcitingC2CUploadConfigBean)localObject2);
  }
  
  private void P()
  {
    Object localObject1 = this.a.getApplicationContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("c2cfile_excitingdownload_");
    ((StringBuilder)localObject2).append(this.a.getCurrentUin());
    localObject1 = ((Context)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getString("qfile_c2cfile_excitingdownload", "{}");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("load Exciting-C2C-Download Config [");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new QFileExcitingC2CDownloadConfigBean();
    ((QFileExcitingC2CDownloadConfigBean)localObject2).a((String)localObject1);
    this.q = ((IQFileExcitingC2CDownloadConfigBean)localObject2);
  }
  
  private void Q()
  {
    Object localObject1 = this.a.getApplicationContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("groupfile_excitingupload_");
    ((StringBuilder)localObject2).append(this.a.getCurrentUin());
    localObject1 = ((Context)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getString("qfile_groupfile_excitingupload", "{}");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("load Exciting-Group-Upload Config [");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new QFileExcitingGroupUploadConfigBean();
    ((QFileExcitingGroupUploadConfigBean)localObject2).a((String)localObject1);
    this.r = ((IQFileExcitingGroupUploadConfigBean)localObject2);
  }
  
  private void R()
  {
    Object localObject1 = this.a.getApplicationContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("groupfile_excitingdownload_");
    ((StringBuilder)localObject2).append(this.a.getCurrentUin());
    localObject1 = ((Context)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getString("qfile_groupfile_excitingdownload", "{}");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("load Exciting-Group-Download Config [");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new QFileExcitingGroupDownloadConfigBean();
    ((QFileExcitingGroupDownloadConfigBean)localObject2).a((String)localObject1);
    this.s = ((IQFileExcitingGroupDownloadConfigBean)localObject2);
  }
  
  private void S()
  {
    Object localObject1 = this.a.getApplicationContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("qfile_file_assistant_tips");
    ((StringBuilder)localObject2).append(this.a.getCurrentUin());
    localObject1 = ((Context)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getString("qfile_file_assistant_tips", "{}");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("load QFILE_CONFIG_FILE_ASSISTANT_TIPS Config [");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new QfileFileAssistantTipsConfigBean();
    ((QfileFileAssistantTipsConfigBean)localObject2).a((String)localObject1);
    this.t = ((IFileAssistantTipsConfig)localObject2);
  }
  
  private void T()
  {
    Object localObject = this.a.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.a.getCurrentUin());
    this.f = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("enable_file_media_platform", false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initMediaPlatformConfig: load common config. enableFileMediaPlatform[");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject).toString());
  }
  
  private void U()
  {
    Object localObject = this.a.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(this.a.getCurrentUin());
    this.o = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("apkcheck_enable_switch", false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initMMApkFileCheckConfig: load apkcheckconfig. enable[");
    ((StringBuilder)localObject).append(this.o);
    ((StringBuilder)localObject).append("]");
    QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject).toString());
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
        break label49;
      }
    }
    throw new NullPointerException("app is null!");
    label49:
    throw paramAppRuntime;
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadYYBPromoteActionConfig: load download config. ");
      localStringBuilder.append(paramString);
      QLog.i("QFileConfigManager", 1, localStringBuilder.toString());
    }
    this.u = ((QFileAppStorePromoteConfigBean)QStorage.a(paramString, QFileAppStorePromoteConfigBean.class));
  }
  
  private void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadYYBPromoteDialogConfig: load download config. ");
      localStringBuilder.append(paramString);
      QLog.i("QFileConfigManager", 1, localStringBuilder.toString());
    }
    this.v = ((QFileAppStorePromoteDialogConfigBean)QStorage.a(paramString, QFileAppStorePromoteDialogConfigBean.class));
  }
  
  private void f(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadFileReaderConfig: load download config. ");
      localStringBuilder.append(paramString);
      QLog.i("QFileConfigManager", 1, localStringBuilder.toString());
    }
    this.w = ((QFileFileReaderConfigBean)QStorage.a(paramString, QFileFileReaderConfigBean.class));
    ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).setCheckShowTbsReaderBar(this.w.isShowReaderBar);
  }
  
  private void g(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadDatalineConfig: load dataline config. ");
      localStringBuilder.append(paramString);
      QLog.i("QFileConfigManager", 1, localStringBuilder.toString());
    }
    this.x = ((QFileDatalineConfigBean)QStorage.a(paramString, QFileDatalineConfigBean.class));
  }
  
  private void h(String paramString)
  {
    Object localObject = (QFileDownloadConfigBean)QStorage.a(paramString, QFileDownloadConfigBean.class);
    if (localObject != null)
    {
      M();
      this.b.clear();
      this.b.putAll(((QFileDownloadConfigBean)localObject).a);
    }
    if (TextUtils.isEmpty(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadFileDownloadConfig: load download config. ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QFileConfigManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void A()
  {
    if (TextUtils.isEmpty(this.y)) {
      this.y = "3636666661";
    }
  }
  
  public String B()
  {
    return this.y;
  }
  
  public int C()
  {
    return this.A;
  }
  
  public boolean D()
  {
    return this.B;
  }
  
  public String E()
  {
    return this.C;
  }
  
  public DownloadFileConfig a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramString.toLowerCase();
    }
    M();
    localObject = (DownloadFileConfig)this.b.get(localObject);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = (DownloadFileConfig)this.b.get("*");
    }
    localObject = paramString;
    if (paramString == null)
    {
      h("{}");
      localObject = (DownloadFileConfig)this.b.get("*");
    }
    return localObject;
  }
  
  public void a(int paramInt)
  {
    this.A = paramInt;
  }
  
  public void a(Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.2(this, paramBundle));
  }
  
  public void a(IQFileExcitingC2CDownloadConfigBean paramIQFileExcitingC2CDownloadConfigBean)
  {
    this.q = paramIQFileExcitingC2CDownloadConfigBean;
  }
  
  public void a(IQFileExcitingC2CUploadConfigBean paramIQFileExcitingC2CUploadConfigBean)
  {
    this.p = paramIQFileExcitingC2CUploadConfigBean;
  }
  
  public void a(IQFileExcitingGroupDownloadConfigBean paramIQFileExcitingGroupDownloadConfigBean)
  {
    this.s = paramIQFileExcitingGroupDownloadConfigBean;
  }
  
  public void a(IQFileExcitingGroupUploadConfigBean paramIQFileExcitingGroupUploadConfigBean)
  {
    this.r = paramIQFileExcitingGroupUploadConfigBean;
  }
  
  public void a(QFileAppStorePromoteConfigBean paramQFileAppStorePromoteConfigBean)
  {
    if (paramQFileAppStorePromoteConfigBean != null) {
      this.u = paramQFileAppStorePromoteConfigBean;
    }
  }
  
  public void a(QFileAppStorePromoteDialogConfigBean paramQFileAppStorePromoteDialogConfigBean)
  {
    if (paramQFileAppStorePromoteDialogConfigBean != null) {
      this.v = paramQFileAppStorePromoteDialogConfigBean;
    }
  }
  
  public void a(QFileDatalineConfigBean paramQFileDatalineConfigBean)
  {
    if (paramQFileDatalineConfigBean != null) {
      this.x = paramQFileDatalineConfigBean;
    }
  }
  
  public void a(QFileFileReaderConfigBean paramQFileFileReaderConfigBean)
  {
    if (paramQFileFileReaderConfigBean != null)
    {
      this.w = paramQFileFileReaderConfigBean;
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).setCheckShowTbsReaderBar(this.w.isShowReaderBar);
    }
  }
  
  public void a(IFileAssistantTipsConfig paramIFileAssistantTipsConfig)
  {
    this.t = paramIFileAssistantTipsConfig;
  }
  
  public void a(HashMap<String, DownloadFileConfig> paramHashMap)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.1(this, paramHashMap));
  }
  
  public void a(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b(Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.3(this, paramBundle));
  }
  
  public void b(String paramString)
  {
    this.y = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public void c(String paramString)
  {
    this.C = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public void d(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }
  
  public boolean d()
  {
    return this.i;
  }
  
  public void e(boolean paramBoolean)
  {
    this.o = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set apkcheckConfig enable:");
    localStringBuilder.append(paramBoolean);
    QLog.i("QFileConfigManager", 1, localStringBuilder.toString());
  }
  
  public boolean e()
  {
    return this.j;
  }
  
  public void f(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  public boolean f()
  {
    return this.k;
  }
  
  public boolean g()
  {
    return this.l;
  }
  
  public boolean h()
  {
    return this.m;
  }
  
  public int i()
  {
    return this.n;
  }
  
  public QFileAppStorePromoteConfigBean j()
  {
    return this.u;
  }
  
  public QFileAppStorePromoteDialogConfigBean k()
  {
    return this.v;
  }
  
  public QFileFileReaderConfigBean l()
  {
    return this.w;
  }
  
  public void m()
  {
    ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).setCheckShowTbsReaderBar(this.w.isShowReaderBar);
  }
  
  public boolean n()
  {
    return this.z;
  }
  
  public QFileDatalineConfigBean o()
  {
    return this.x;
  }
  
  public void p() {}
  
  public IQFileExcitingC2CUploadConfigBean q()
  {
    return this.p;
  }
  
  public IQFileExcitingC2CDownloadConfigBean r()
  {
    return this.q;
  }
  
  public IQFileExcitingGroupUploadConfigBean s()
  {
    return this.r;
  }
  
  public IQFileExcitingGroupDownloadConfigBean t()
  {
    return this.s;
  }
  
  public IFileAssistantTipsConfig u()
  {
    return this.t;
  }
  
  public boolean v()
  {
    if (this.g) {
      return this.h;
    }
    return this.f;
  }
  
  public boolean w()
  {
    return this.g;
  }
  
  public boolean x()
  {
    return this.h;
  }
  
  public boolean y()
  {
    return this.D;
  }
  
  public boolean z()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager
 * JD-Core Version:    0.7.0.1
 */