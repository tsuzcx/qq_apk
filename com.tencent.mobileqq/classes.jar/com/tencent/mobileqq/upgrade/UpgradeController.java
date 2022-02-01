package com.tencent.mobileqq.upgrade;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.apkupdate.ApkUpdateParam;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.bannerprocessor.InstallUpgradeBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.UpgradeBannerProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.managers.TimUpgradeHongdianManager;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.DownloadQueryListener;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.util.URLUtil;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;

public final class UpgradeController
  implements Handler.Callback, AuthCodeWriter.ICheckCodeListener, DownloadListener, DownloadQueryListener, UpdateManager.OnCheckUpdateListener
{
  private static UpgradeController jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController;
  private int jdField_a_of_type_Int;
  private BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  private AuthCodeWriter jdField_a_of_type_ComTencentMobileqqUpgradeAuthCodeWriter;
  private UpgradeController.AutoDownloadInWifiController jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController$AutoDownloadInWifiController;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  private DownloadInfo jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  public volatile String a;
  private WeakReference<UpgradeController.OnHandleUpgradeFinishListener> jdField_a_of_type_JavaLangRefWeakReference;
  private final ArrayList<UpgradeController.OnStateChangedListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private volatile boolean b;
  private volatile boolean c;
  private boolean d;
  private boolean e = false;
  
  private UpgradeController()
  {
    this.jdField_a_of_type_Boolean = true;
    a(false);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (((paramInt1 == 12) || (paramInt1 == 2)) && (a() == 4)) {
      return 0;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
    if (localObject != null)
    {
      if (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null) {
        return 1;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
      if ((localObject != null) && (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_JavaLangString != null)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_JavaLangString;
      } else {
        localObject = "新版手Q";
      }
      Bundle localBundle = new Bundle();
      localBundle.putString(DownloadConstants.b, "100686848");
      localBundle.putString(DownloadConstants.j, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
      localBundle.putString(DownloadConstants.f, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName());
      localBundle.putInt(DownloadConstants.k, paramInt1);
      if (paramInt1 == 12) {
        localBundle.putBoolean(DownloadConstants.o, true);
      }
      localBundle.putString(DownloadConstants.i, "ANDROIDQQ.QQUPDATE");
      localBundle.putString(DownloadConstants.l, (String)localObject);
      int i;
      if (paramInt2 != 0)
      {
        localBundle.putString(DownloadConstants.m, "_100686848");
        localBundle.putBoolean(DownloadConstants.y, false);
        i = paramInt2;
        if (paramInt1 != 5)
        {
          i = paramInt2;
          if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade == 0) {
            i = 0;
          }
        }
      }
      else
      {
        localBundle.putBoolean(DownloadConstants.y, true);
        i = paramInt2;
      }
      localBundle.putString(DownloadConstants.jdField_c_of_type_JavaLangString, "6633");
      localBundle.putInt(DownloadConstants.e, this.jdField_a_of_type_Int);
      localBundle.putBoolean(DownloadConstants.g, true);
      localBundle.putBoolean(DownloadConstants.h, true);
      localBundle.putInt(DownloadConstants.n, 1);
      localBundle.putInt(DownloadConstants.C, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bGray);
      DownloadApi.a(BaseActivity.sTopActivity, localBundle, "biz_src_jc_update", this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, i);
      return 0;
    }
    return 1;
  }
  
  private static PackageInfo a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
  }
  
  public static UpgradeController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController == null) {
      jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController = new UpgradeController();
    }
    return jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController;
  }
  
  public static String a()
  {
    Object localObject2 = a();
    String str = "";
    Object localObject1 = str;
    if (localObject2 != null)
    {
      localObject2 = ((UpgradeController)localObject2).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(((UpgradeDetailWrapper)localObject2).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    return localObject1;
  }
  
  public static String a(String paramString)
  {
    return URLUtil.a(paramString, "nt", UpgradeConstants.a());
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = a();
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((UpgradeController)localObject).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null)
        {
          bool2 = bool3;
          if (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType > 0)
          {
            bool2 = bool3;
            if (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch == 1) {
              bool2 = true;
            }
          }
          bool1 = bool2;
          if (bool2) {
            bool1 = ConfigHandler.a(paramQQAppInterface, ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iNewTimeStamp) ^ true;
          }
        }
      }
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = ((TimUpgradeHongdianManager)paramQQAppInterface.getManager(QQManagerFactory.TIM_UPGRADE_HONGDIAN_MANAGER)).a();
    }
    return bool2;
  }
  
  private boolean a(Signature[] paramArrayOfSignature1, Signature[] paramArrayOfSignature2)
  {
    if (paramArrayOfSignature1 == null) {
      return false;
    }
    if (paramArrayOfSignature2 == null) {
      return false;
    }
    HashSet localHashSet = new HashSet();
    int j = paramArrayOfSignature1.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(paramArrayOfSignature1[i]);
      i += 1;
    }
    paramArrayOfSignature1 = new HashSet();
    j = paramArrayOfSignature2.length;
    i = 0;
    while (i < j)
    {
      paramArrayOfSignature1.add(paramArrayOfSignature2[i]);
      i += 1;
    }
    return localHashSet.equals(paramArrayOfSignature1);
  }
  
  public static String b()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((UpgradeController)localObject).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
      if ((localObject != null) && (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null))
      {
        i = ((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType;
        break label37;
      }
    }
    int i = 0;
    label37:
    return String.valueOf(i);
  }
  
  private void b(int paramInt)
  {
    try
    {
      ConfigHandler localConfigHandler = (ConfigHandler)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime()).getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
      String str = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt);
      this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      this.jdField_a_of_type_Int = paramInt;
      localConfigHandler.a(str, paramInt, this.jdField_a_of_type_JavaLangString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = UpgradeManager.a(paramQQAppInterface);
    boolean bool2;
    boolean bool1;
    if (paramQQAppInterface.a())
    {
      bool2 = paramQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("UpgradeController", 2, String.format("needShowDialog needShowInstallDialog=%s", new Object[] { Boolean.valueOf(bool2) }));
        return bool2;
      }
    }
    else
    {
      bool2 = paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("UpgradeController", 2, String.format("needShowDialog needShowDownloadDialog=%s", new Object[] { Boolean.valueOf(bool2) }));
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  private void c(int paramInt)
  {
    if (this.c) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (UpgradeController.OnHandleUpgradeFinishListener)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) {
          ((UpgradeController.OnHandleUpgradeFinishListener)localObject).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper, this);
        }
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
    }
  }
  
  private void d(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("invokeStateChangedToListeners:");
      ((StringBuilder)???).append(paramInt);
      QLog.d("UpgradeController", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((UpgradeController.OnStateChangedListener)localIterator.next()).a(paramInt, this);
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_c_of_type_JavaLangString = "100686848";
    localDownloadInfo.e = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName();
    localDownloadInfo.j = "6633";
    localDownloadInfo.b = this.jdField_a_of_type_Int;
    localArrayList.add(localDownloadInfo);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryDownloadInfo:");
      localStringBuilder.append(localDownloadInfo);
      QLog.d("UpgradeController", 2, localStringBuilder.toString());
    }
    DownloadApi.a(localArrayList, this);
  }
  
  private void g()
  {
    try
    {
      if (!a())
      {
        this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController$AutoDownloadInWifiController = new UpgradeController.AutoDownloadInWifiController(this);
        this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController$AutoDownloadInWifiController.a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void h()
  {
    try
    {
      if (a())
      {
        this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController$AutoDownloadInWifiController.b();
        this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController$AutoDownloadInWifiController = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void i()
  {
    int i = 1;
    d(true);
    Object localObject = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X800716C", "0X800716C", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Boolean = false;
    if (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl)) {
      i = 0;
    }
    ((QQAppInterface)localObject).getPreferences().edit().putInt("APPID_SHOULD_DOWNLOAD", a().jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId);
    localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", Integer.toString(i));
    ((HashMap)localObject).put("param_ErrMsg", "success");
    StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).collectPerformance("", "UpgradeErr", true, 0L, 0L, (HashMap)localObject, "", true);
  }
  
  private void j()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initDownloadEnv: ");
        localStringBuilder.append(this.d);
        QLog.d("UpgradeController", 2, localStringBuilder.toString());
      }
      if (!this.d)
      {
        UpdateManager.a().a(this);
        DownloadApi.a(this);
        this.d = true;
      }
      return;
    }
    finally {}
  }
  
  private void k()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("releaseDownloadEnv: ");
        localStringBuilder.append(this.d);
        QLog.d("UpgradeController", 2, localStringBuilder.toString());
      }
      if (this.d)
      {
        UpdateManager.a().b(this);
        UpdateManager.a().a();
        if (this.jdField_a_of_type_ComTencentMobileqqUpgradeAuthCodeWriter != null)
        {
          DownloadApi.b(this.jdField_a_of_type_ComTencentMobileqqUpgradeAuthCodeWriter);
          this.jdField_a_of_type_ComTencentMobileqqUpgradeAuthCodeWriter = null;
        }
        this.jdField_a_of_type_Int = 0;
        DownloadApi.b(this);
        this.d = false;
      }
      return;
    }
    finally {}
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo;
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      int k = ((DownloadInfo)localObject).a();
      i = j;
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              i = j;
              if (k != 10) {
                if (k != 20) {
                  i = j;
                } else {
                  i = 3;
                }
              }
            }
            else
            {
              i = 4;
            }
          }
          else {
            i = 2;
          }
        }
        else {
          i = 1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDownloadState: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("UpgradeController", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public UpgradeDetailWrapper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
    if ((localObject != null) && (((UpgradeDetailWrapper)localObject).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType != 1) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo;
      if ((localObject != null) && (((DownloadInfo)localObject).jdField_c_of_type_Int == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, "MYAPP has work, do not allow download by wifi");
        }
        ConfigHandler.b(localQQAppInterface, false);
        d(false);
        return;
      }
      if (!this.b) {
        b(ConfigHandler.a(localQQAppInterface, false));
      }
    }
  }
  
  public void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInt));
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).collectPerformance("", "UpgradeWritten", bool, 0L, 0L, localHashMap, "", true);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onException:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString);
      QLog.d("UpgradeController", 2, localStringBuilder.toString());
    }
    c(0);
  }
  
  public void a(Context paramContext)
  {
    paramContext = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo;
    if (paramContext != null) {
      if (paramContext.a() != 4) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramContext = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo;
        int j = 1;
        i = j;
        if (paramContext != null)
        {
          if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_c_of_type_Int != 1) {
            break label74;
          }
          i = j;
        }
        a(5, i);
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, "installApk:", paramContext);
        }
      }
      return;
      label74:
      int i = 0;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    int i = a();
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, String.format("showUpgradeDialog downloadState=%s", new Object[] { Integer.valueOf(i) }));
    }
    if (i == 4)
    {
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        ThreadManagerV2.getUIHandlerV2().post(new UpgradeController.2(this));
        return;
      }
      BannerManager.a().b(InstallUpgradeBannerProcessor.jdField_a_of_type_Int, 3000);
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(new UpgradeController.3(this));
      return;
    }
    BannerManager.a().b(UpgradeBannerProcessor.jdField_a_of_type_Int, 3000);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, String.format("showUpgradeDialog needDesc=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    String str = ConfigHandler.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity != null) && (str != null) && (!str.startsWith("com.tencent.av.")) && (!str.equals("com.tencent.mobileqq.activity.UserguideActivity")) && (!str.equals("com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity"))) {
      localBaseActivity.runOnUiThread(new UpgradeController.4(this, paramBoolean, paramQQAppInterface));
    }
  }
  
  public void a(UpgradeController.OnStateChangedListener paramOnStateChangedListener)
  {
    if (paramOnStateChangedListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramOnStateChangedListener)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramOnStateChangedListener);
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "onCheckUpdateFailed");
    }
    b(this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int);
  }
  
  public void a(ArrayList<ApkUpdateDetail> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (ApkUpdateDetail)paramArrayList.get(0);
      if (paramArrayList != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int == paramArrayList.versioncode) {
          this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail = paramArrayList;
        }
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onCheckUpdateSucceed:");
          localStringBuilder.append(paramArrayList.url);
          localStringBuilder.append(" -- ");
          localStringBuilder.append(paramArrayList.updatemethod);
          QLog.d("UpgradeController", 4, localStringBuilder.toString());
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.versioncode);
      return;
    }
    b(this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int);
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = ((DownloadInfo)paramList.get(0));
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onResult Status:");
      paramList.append(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
      QLog.d("UpgradeController", 2, paramList.toString());
    }
    c(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      UpgradeDetailWrapper localUpgradeDetailWrapper = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
      if ((localUpgradeDetailWrapper != null) && (localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType == 2)) {
        return;
      }
    }
    c();
    this.c = paramBoolean;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
    k();
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = BaseApplicationImpl.getApplication();
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = null;
    this.jdField_a_of_type_Boolean = true;
    if ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper == null)) {
      this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = new UpgradeDetailWrapper(null, null);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.c;
        if (bool) {
          return;
        }
        if (paramString1.equals(this.jdField_a_of_type_JavaLangString))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqUpgradeAuthCodeWriter == null)
          {
            i = 1;
            if (paramBoolean)
            {
              if (i != 0) {
                f();
              }
              this.jdField_a_of_type_ComTencentMobileqqUpgradeAuthCodeWriter = new AuthCodeWriter(paramString2, this);
              DownloadApi.a(this.jdField_a_of_type_ComTencentMobileqqUpgradeAuthCodeWriter);
            }
            else if (i != 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = new UpgradeInfo();
              this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo = null;
              c(-1);
            }
            this.jdField_a_of_type_JavaLangString = null;
          }
        }
        else {
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeController$AutoDownloadInWifiController != null;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool;
    if (paramInt == this.jdField_a_of_type_Int) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!bool) && (this.jdField_a_of_type_JavaLangString == null)) {
      b(paramInt);
    }
    return bool;
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: new 693	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 695	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 698	java/io/File:exists	()Z
    //   13: ifeq +134 -> 147
    //   16: new 700	java/io/FileInputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 703	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_3
    //   25: aload_3
    //   26: astore_1
    //   27: iconst_2
    //   28: newarray byte
    //   30: astore 4
    //   32: aload_3
    //   33: astore_1
    //   34: aload_3
    //   35: aload 4
    //   37: invokevirtual 707	java/io/FileInputStream:read	([B)I
    //   40: pop
    //   41: aload 4
    //   43: iconst_0
    //   44: baload
    //   45: bipush 80
    //   47: if_icmpne +23 -> 70
    //   50: aload 4
    //   52: iconst_1
    //   53: baload
    //   54: istore_2
    //   55: iload_2
    //   56: bipush 75
    //   58: if_icmpeq +6 -> 64
    //   61: goto +9 -> 70
    //   64: aload_3
    //   65: invokevirtual 710	java/io/FileInputStream:close	()V
    //   68: iconst_1
    //   69: ireturn
    //   70: aload_3
    //   71: invokevirtual 710	java/io/FileInputStream:close	()V
    //   74: iconst_0
    //   75: ireturn
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual 713	java/io/IOException:printStackTrace	()V
    //   81: iconst_0
    //   82: ireturn
    //   83: astore 4
    //   85: goto +13 -> 98
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_1
    //   91: goto +38 -> 129
    //   94: astore 4
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: astore_1
    //   100: ldc_w 336
    //   103: iconst_1
    //   104: ldc 214
    //   106: aload 4
    //   108: invokestatic 715	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_3
    //   112: ifnull +35 -> 147
    //   115: aload_3
    //   116: invokevirtual 710	java/io/FileInputStream:close	()V
    //   119: iconst_1
    //   120: ireturn
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 713	java/io/IOException:printStackTrace	()V
    //   126: iconst_1
    //   127: ireturn
    //   128: astore_3
    //   129: aload_1
    //   130: ifnull +15 -> 145
    //   133: aload_1
    //   134: invokevirtual 710	java/io/FileInputStream:close	()V
    //   137: goto +8 -> 145
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual 713	java/io/IOException:printStackTrace	()V
    //   145: aload_3
    //   146: athrow
    //   147: iconst_1
    //   148: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	UpgradeController
    //   0	149	1	paramString	String
    //   54	5	2	i	int
    //   24	47	3	localFileInputStream	java.io.FileInputStream
    //   88	1	3	localObject1	Object
    //   97	19	3	localObject2	Object
    //   128	18	3	localObject3	Object
    //   30	21	4	arrayOfByte	byte[]
    //   83	1	4	localThrowable1	Throwable
    //   94	13	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   70	74	76	java/io/IOException
    //   27	32	83	java/lang/Throwable
    //   34	41	83	java/lang/Throwable
    //   16	25	88	finally
    //   16	25	94	java/lang/Throwable
    //   64	68	121	java/io/IOException
    //   115	119	121	java/io/IOException
    //   27	32	128	finally
    //   34	41	128	finally
    //   100	111	128	finally
    //   133	137	140	java/io/IOException
  }
  
  public boolean a(String paramString, PackageInfo paramPackageInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageManager();
    if ((paramPackageInfo.signatures != null) && (paramPackageInfo.signatures.length > 0))
    {
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName(), 64);
        if (((PackageInfo)localObject).packageName.equals(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName()))
        {
          if ((((PackageInfo)localObject).signatures != null) && (((PackageInfo)localObject).signatures.length > 0))
          {
            if (a(((PackageInfo)localObject).signatures, paramPackageInfo.signatures))
            {
              if (!QLog.isColorLevel()) {
                break label226;
              }
              QLog.d("UpgradeConfigManager", 2, "target apk's signature is same with mobileqq");
              break label226;
            }
            if (!QLog.isColorLevel()) {
              break label228;
            }
            paramPackageInfo = new StringBuilder();
            paramPackageInfo.append("target apk's signature is wrong! path=");
            paramPackageInfo.append(paramString);
            QLog.d("UpgradeConfigManager", 2, paramPackageInfo.toString());
            return false;
          }
          if (QLog.isColorLevel()) {
            QLog.d("UpgradeConfigManager", 2, "WTF? cannot get signature from local mobileqq");
          }
          return false;
        }
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeConfigManager", 2, "WTF? cannot find mobileqq in local app");
        }
        return false;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramPackageInfo = new StringBuilder();
        paramPackageInfo.append("cannot get signature from apk:");
        paramPackageInfo.append(paramString);
        QLog.d("UpgradeConfigManager", 2, paramPackageInfo.toString());
      }
      return false;
    }
    label226:
    return true;
    label228:
    return false;
  }
  
  public boolean a(UpgradeInfo paramUpgradeInfo, UpgradeController.OnHandleUpgradeFinishListener paramOnHandleUpgradeFinishListener)
  {
    UpgradeDetailWrapper localUpgradeDetailWrapper = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
    localUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = paramUpgradeInfo;
    localUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo = ConfigHandler.a(paramUpgradeInfo);
    if (paramOnHandleUpgradeFinishListener != null)
    {
      if (paramUpgradeInfo == null) {
        return false;
      }
      if (paramUpgradeInfo.iUpgradeType == 0) {
        return false;
      }
      if (this.c) {
        return false;
      }
      if ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime() == null) {
        return false;
      }
      j();
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnHandleUpgradeFinishListener);
      if (QLog.isColorLevel())
      {
        paramOnHandleUpgradeFinishListener = new StringBuilder();
        paramOnHandleUpgradeFinishListener.append("handleUpgradeInfo packageName = ");
        paramOnHandleUpgradeFinishListener.append(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName());
        paramOnHandleUpgradeFinishListener.append(", bGray = ");
        paramOnHandleUpgradeFinishListener.append(paramUpgradeInfo.bGray);
        paramOnHandleUpgradeFinishListener.append(", versioncode = ");
        paramOnHandleUpgradeFinishListener.append(this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int);
        QLog.d("UpgradeController", 2, paramOnHandleUpgradeFinishListener.toString());
      }
      paramUpgradeInfo = new ApkUpdateParam(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName(), paramUpgradeInfo.bGray, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int);
      paramOnHandleUpgradeFinishListener = new ArrayList();
      paramOnHandleUpgradeFinishListener.add(paramUpgradeInfo);
      UpdateManager.a().b(paramOnHandleUpgradeFinishListener);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if ((this.b) && (a())) {
      c();
    }
  }
  
  public void b(UpgradeController.OnStateChangedListener paramOnStateChangedListener)
  {
    if (paramOnStateChangedListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramOnStateChangedListener)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramOnStateChangedListener);
      }
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownload:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("UpgradeController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
    if (a() == 4) {
      return;
    }
    if (!this.b)
    {
      ConfigHandler.b((QQAppInterface)localObject, paramBoolean);
      if (paramBoolean)
      {
        g();
        return;
      }
      c(false);
    }
  }
  
  public boolean b()
  {
    if (a() == 4)
    {
      Object localObject = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo;
      if (localObject != null)
      {
        String str2 = ((DownloadInfo)localObject).l;
        if (TextUtils.isEmpty(str2))
        {
          QLog.e("UpgradeConfigManager", 1, "checkJacking：  cannot get path to apk");
          return true;
        }
        localObject = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageManager();
        String str1 = null;
        StringBuilder localStringBuilder;
        try
        {
          localObject = ((PackageManager)localObject).getPackageArchiveInfo(str2, 64);
        }
        catch (Throwable localThrowable)
        {
          QLog.d("UpgradeController", 1, localThrowable, new Object[0]);
          localStringBuilder = null;
        }
        if (localStringBuilder != null)
        {
          if (localStringBuilder.packageName.equals(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName()))
          {
            String str3 = PluginStatic.encodeFile(str2);
            QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
            if (localQQAppInterface != null) {
              str1 = localQQAppInterface.getPreferences().getString("upgrade_check_md5", "");
            }
            if (!str3.equals(str1))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("checkJacking：  failed... md5 is different. apkMd5File=");
              localStringBuilder.append(str3);
              localStringBuilder.append(" apkMd5Record=");
              localStringBuilder.append(str1);
              QLog.d("UpgradeConfigManager", 1, localStringBuilder.toString());
              return true;
            }
            if (a(str2, localStringBuilder))
            {
              if (a(str2))
              {
                QLog.d("UpgradeConfigManager", 1, "checkJacking：  success!!! i think it is safe");
                return false;
              }
              QLog.d("UpgradeConfigManager", 1, "checkJacking：  failed... dex injected");
              return true;
            }
            QLog.d("UpgradeConfigManager", 1, "checkJacking：  failed... signature is wrong.");
            return true;
          }
          QLog.d("UpgradeConfigManager", 1, "checkJacking：  package name is wrong!");
          return true;
        }
      }
    }
    QLog.e("UpgradeConfigManager", 1, "checkJacking：  apk has not been downloaded or cannot get download info");
    return true;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 334	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +13 -> 18
    //   8: ldc_w 336
    //   11: iconst_2
    //   12: ldc_w 822
    //   15: invokestatic 350	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: getfield 276	com/tencent/mobileqq/upgrade/UpgradeController:b	Z
    //   22: ifeq +21 -> 43
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 276	com/tencent/mobileqq/upgrade/UpgradeController:b	Z
    //   30: aload_0
    //   31: invokevirtual 824	com/tencent/mobileqq/upgrade/UpgradeController:e	()V
    //   34: aload_0
    //   35: invokespecial 826	com/tencent/mobileqq/upgrade/UpgradeController:h	()V
    //   38: ldc 142
    //   40: invokestatic 828	com/tencent/open/downloadnew/DownloadApi:a	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_1
    //   52: goto -18 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	UpgradeController
    //   46	4	1	localObject	Object
    //   51	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	18	46	finally
    //   18	30	46	finally
    //   30	34	46	finally
    //   34	43	46	finally
    //   30	34	51	java/lang/Exception
  }
  
  void c(boolean paramBoolean)
  {
    if (!this.b)
    {
      this.b = true;
      int i;
      if ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 4)) {
        i = 12;
      } else {
        i = 2;
      }
      a(i, paramBoolean ^ true);
    }
  }
  
  public void d()
  {
    boolean bool = QLog.isColorLevel();
    int j = 2;
    if (bool) {
      QLog.d("UpgradeController", 2, "resumeDownload:");
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo == null) {
      return;
    }
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 4) {
        i = 12;
      }
    }
    a(i, a() ^ true);
  }
  
  public void d(boolean paramBoolean)
  {
    ThreadManager.post(new UpgradeController.1(this, paramBoolean), 5, null, false);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "pauseDownload:");
    }
    a(3, a() ^ true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      paramMessage = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
      if (!this.e) {
        break label75;
      }
      i = 2131694620;
    }
    catch (Throwable paramMessage)
    {
      for (;;)
      {
        continue;
        label75:
        int i = 2131694619;
      }
    }
    Toast.makeText(paramMessage, i, 0).show();
    paramMessage = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime()).getHandler(Conversation.class);
    if ((paramMessage != null) && (a().a() == 4)) {
      paramMessage.obtainMessage(1134019).sendToTarget();
    }
    return true;
  }
  
  public void installSucceed(String paramString1, String paramString2) {}
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.jdField_c_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadCancel");
    }
    this.b = false;
    h();
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    d(a());
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (!"100686848".equals(paramDownloadInfo.jdField_c_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    this.b = false;
    h();
    if (QLog.isColorLevel())
    {
      paramDownloadInfo = new StringBuilder();
      paramDownloadInfo.append("onDownloadError: ");
      paramDownloadInfo.append(paramInt1);
      paramDownloadInfo.append(", ");
      paramDownloadInfo.append(paramString);
      QLog.d("UpgradeController", 2, paramDownloadInfo.toString());
    }
    d(a());
    paramInt2 = paramInt1;
    if (NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl)) {
      paramInt2 = paramInt1 | 0x1;
    }
    paramDownloadInfo = new HashMap();
    paramDownloadInfo.put("param_FailCode", Integer.toString(paramInt2));
    paramDownloadInfo.put("param_ErrMsg", paramString);
    StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).collectPerformance("", "UpgradeErr", false, 0L, 0L, paramDownloadInfo, "", true);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    Object localObject2 = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
    if (!"100686848".equals(paramDownloadInfo.jdField_c_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadFinish");
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    this.b = false;
    String str = paramDownloadInfo.l;
    Object localObject1 = str;
    if (TextUtils.isEmpty(str))
    {
      localObject1 = str;
      if (paramDownloadInfo.jdField_c_of_type_Int == 1)
      {
        paramDownloadInfo = DownloadManager.a().a(paramDownloadInfo);
        localObject1 = str;
        if (paramDownloadInfo != null) {
          localObject1 = paramDownloadInfo.mSavePath;
        }
      }
    }
    paramDownloadInfo = a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, (String)localObject1);
    int i;
    if (paramDownloadInfo != null)
    {
      i = paramDownloadInfo.versionCode;
      paramDownloadInfo = paramDownloadInfo.packageName;
    }
    else
    {
      paramDownloadInfo = "";
      i = 0;
    }
    int j = ApkUtils.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    str = PluginStatic.encodeFile((String)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upgradeDownloadFinish md5=");
    localStringBuilder.append(str);
    QLog.i("UpgradeController", 1, localStringBuilder.toString());
    if ((this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName().equals(paramDownloadInfo)) && (j > 0) && (i >= j))
    {
      if (localObject2 == null) {
        return;
      }
      d(a());
      ((QQAppInterface)localObject2).getPreferences().edit().putLong("YELLOW_BAR_LAST_SHOW", 0L).putString("upgrade_check_md5", str).commit();
      i();
      h();
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_a_of_type_Boolean;
    if (bool)
    {
      DownloadApi.a("_100686848");
    }
    else
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_a_of_type_Boolean = false;
      a(10, true ^ a());
    }
    h();
    localObject1 = new File((String)localObject1);
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
    localObject1 = new HashMap();
    if (i < j) {
      i = 101;
    } else {
      i = 9527;
    }
    ((HashMap)localObject1).put("param_FailCode", Integer.toString(i));
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("MD5:");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("_PN:");
    ((StringBuilder)localObject2).append(paramDownloadInfo);
    ((HashMap)localObject1).put("param_ErrMsg", ((StringBuilder)localObject2).toString());
    StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).collectPerformance("", "UpgradeErr", false, 0L, 0L, (HashMap)localObject1, "", true);
    if (!bool) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(0);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.jdField_c_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadPause");
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    d(a());
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if ("100686848".equals(localDownloadInfo.jdField_c_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = localDownloadInfo;
          i = 1;
          break label54;
        }
      }
    }
    int i = 0;
    label54:
    if (i == 0) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onDownloadUpdate Status:");
      paramList.append(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a());
      QLog.d("UpgradeController", 2, paramList.toString());
    }
    d(a());
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.jdField_c_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadWait");
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    d(a());
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeController
 * JD-Core Version:    0.7.0.1
 */