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
  private static UpgradeController l;
  public volatile String a;
  public boolean b = true;
  private DownloadInfo c;
  private volatile boolean d;
  private BaseApplicationImpl e;
  private WeakReference<UpgradeController.OnHandleUpgradeFinishListener> f;
  private final ArrayList<UpgradeController.OnStateChangedListener> g = new ArrayList();
  private UpgradeController.AutoDownloadInWifiController h;
  private volatile boolean i;
  private boolean j;
  private WeakReferenceHandler k = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private UpgradeDetailWrapper m;
  private int n;
  private AuthCodeWriter o;
  private boolean p = false;
  
  private UpgradeController()
  {
    a(false);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (((paramInt1 == 12) || (paramInt1 == 2)) && (b() == 4)) {
      return 0;
    }
    Object localObject = this.m;
    if (localObject != null)
    {
      if (((UpgradeDetailWrapper)localObject).b == null) {
        return 1;
      }
      localObject = this.m;
      if ((localObject != null) && (((UpgradeDetailWrapper)localObject).e != null) && (this.m.e.a != null)) {
        localObject = this.m.e.a;
      } else {
        localObject = "新版手Q";
      }
      Bundle localBundle = new Bundle();
      localBundle.putString(DownloadConstants.b, "100686848");
      localBundle.putString(DownloadConstants.j, this.m.b.strNewSoftwareURL);
      localBundle.putString(DownloadConstants.f, this.e.getPackageName());
      localBundle.putInt(DownloadConstants.k, paramInt1);
      if (paramInt1 == 12) {
        localBundle.putBoolean(DownloadConstants.o, true);
      }
      localBundle.putString(DownloadConstants.i, "ANDROIDQQ.QQUPDATE");
      localBundle.putString(DownloadConstants.l, (String)localObject);
      int i1;
      if (paramInt2 != 0)
      {
        localBundle.putString(DownloadConstants.m, "_100686848");
        localBundle.putBoolean(DownloadConstants.y, false);
        i1 = paramInt2;
        if (paramInt1 != 5)
        {
          i1 = paramInt2;
          if (this.m.b.iIncrementUpgrade == 0) {
            i1 = 0;
          }
        }
      }
      else
      {
        localBundle.putBoolean(DownloadConstants.y, true);
        i1 = paramInt2;
      }
      localBundle.putString(DownloadConstants.c, "6633");
      localBundle.putInt(DownloadConstants.e, this.n);
      localBundle.putBoolean(DownloadConstants.g, true);
      localBundle.putBoolean(DownloadConstants.h, true);
      localBundle.putInt(DownloadConstants.n, 1);
      localBundle.putInt(DownloadConstants.C, this.m.b.bGray);
      DownloadApi.a(BaseActivity.sTopActivity, localBundle, "biz_src_jc_update", this.m.d, i1);
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
    if (l == null) {
      l = new UpgradeController();
    }
    return l;
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
    int i2 = paramArrayOfSignature1.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localHashSet.add(paramArrayOfSignature1[i1]);
      i1 += 1;
    }
    paramArrayOfSignature1 = new HashSet();
    i2 = paramArrayOfSignature2.length;
    i1 = 0;
    while (i1 < i2)
    {
      paramArrayOfSignature1.add(paramArrayOfSignature2[i1]);
      i1 += 1;
    }
    return localHashSet.equals(paramArrayOfSignature1);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    Object localObject = a();
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((UpgradeController)localObject).m;
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((UpgradeDetailWrapper)localObject).b != null)
        {
          bool2 = bool3;
          if (((UpgradeDetailWrapper)localObject).b.iUpgradeType > 0)
          {
            bool2 = bool3;
            if (((UpgradeDetailWrapper)localObject).b.bNewSwitch == 1) {
              bool2 = true;
            }
          }
          bool1 = bool2;
          if (bool2) {
            bool1 = ConfigHandler.b(paramQQAppInterface, ((UpgradeDetailWrapper)localObject).b.iNewTimeStamp) ^ true;
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
  
  public static String c(String paramString)
  {
    return URLUtil.a(paramString, "nt", UpgradeConstants.a());
  }
  
  private void c(int paramInt)
  {
    try
    {
      ConfigHandler localConfigHandler = (ConfigHandler)((QQAppInterface)this.e.getRuntime()).getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
      String str = this.e.getPackageName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt);
      this.a = localStringBuilder.toString();
      this.n = paramInt;
      localConfigHandler.a(str, paramInt, this.a);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = UpgradeManager.a(paramQQAppInterface);
    boolean bool2;
    boolean bool1;
    if (paramQQAppInterface.a())
    {
      bool2 = paramQQAppInterface.b(this.m);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("UpgradeController", 2, String.format("needShowDialog needShowInstallDialog=%s", new Object[] { Boolean.valueOf(bool2) }));
        return bool2;
      }
    }
    else
    {
      bool2 = paramQQAppInterface.a(this.m);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("UpgradeController", 2, String.format("needShowDialog needShowDownloadDialog=%s", new Object[] { Boolean.valueOf(bool2) }));
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  private void d(int paramInt)
  {
    if (this.i) {
      return;
    }
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = (UpgradeController.OnHandleUpgradeFinishListener)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (this.m.b != null) {
          ((UpgradeController.OnHandleUpgradeFinishListener)localObject).a(paramInt, this.m, this);
        }
        this.f = null;
      }
    }
  }
  
  private void e(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("invokeStateChangedToListeners:");
      ((StringBuilder)???).append(paramInt);
      QLog.d("UpgradeController", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.g)
    {
      Iterator localIterator = this.g.iterator();
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
  
  public static String k()
  {
    Object localObject2 = a();
    String str = "";
    Object localObject1 = str;
    if (localObject2 != null)
    {
      localObject2 = ((UpgradeController)localObject2).m;
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (((UpgradeDetailWrapper)localObject2).b != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(((UpgradeDetailWrapper)localObject2).b.iUpgradeSdkId);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    return localObject1;
  }
  
  public static String l()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((UpgradeController)localObject).m;
      if ((localObject != null) && (((UpgradeDetailWrapper)localObject).b != null))
      {
        i1 = ((UpgradeDetailWrapper)localObject).b.iTipsType;
        break label37;
      }
    }
    int i1 = 0;
    label37:
    return String.valueOf(i1);
  }
  
  private void m()
  {
    ArrayList localArrayList = new ArrayList();
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = "100686848";
    localDownloadInfo.e = this.e.getPackageName();
    localDownloadInfo.l = "6633";
    localDownloadInfo.n = this.n;
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
  
  private void n()
  {
    try
    {
      if (!c())
      {
        this.h = new UpgradeController.AutoDownloadInWifiController(this);
        this.h.a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void o()
  {
    try
    {
      if (c())
      {
        this.h.b();
        this.h = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void p()
  {
    int i1 = 1;
    d(true);
    Object localObject = (QQAppInterface)this.e.getRuntime();
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X800716C", "0X800716C", 0, 0, "", "", "", "");
    this.b = false;
    if (!NetworkUtil.isWifiConnected(this.e)) {
      i1 = 0;
    }
    ((QQAppInterface)localObject).getPreferences().edit().putInt("APPID_SHOULD_DOWNLOAD", d().b.iUpgradeSdkId);
    localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", Integer.toString(i1));
    ((HashMap)localObject).put("param_ErrMsg", "success");
    StatisticCollector.getInstance(this.e).collectPerformance("", "UpgradeErr", true, 0L, 0L, (HashMap)localObject, "", true);
  }
  
  private void q()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initDownloadEnv: ");
        localStringBuilder.append(this.j);
        QLog.d("UpgradeController", 2, localStringBuilder.toString());
      }
      if (!this.j)
      {
        UpdateManager.b().a(this);
        DownloadApi.a(this);
        this.j = true;
      }
      return;
    }
    finally {}
  }
  
  private void r()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("releaseDownloadEnv: ");
        localStringBuilder.append(this.j);
        QLog.d("UpgradeController", 2, localStringBuilder.toString());
      }
      if (this.j)
      {
        UpdateManager.b().b(this);
        UpdateManager.b().c();
        if (this.o != null)
        {
          DownloadApi.b(this.o);
          this.o = null;
        }
        this.n = 0;
        DownloadApi.b(this);
        this.j = false;
      }
      return;
    }
    finally {}
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
    d(0);
  }
  
  public void a(Context paramContext)
  {
    paramContext = this.c;
    if (paramContext != null) {
      if (paramContext.a() != 4) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramContext = this.c;
        int i2 = 1;
        i1 = i2;
        if (paramContext != null)
        {
          if (this.c.o != 1) {
            break label74;
          }
          i1 = i2;
        }
        a(5, i1);
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
      int i1 = 0;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    int i1 = b();
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, String.format("showUpgradeDialog downloadState=%s", new Object[] { Integer.valueOf(i1) }));
    }
    if (i1 == 4)
    {
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        ThreadManagerV2.getUIHandlerV2().post(new UpgradeController.2(this));
        return;
      }
      BannerManager.a().b(InstallUpgradeBannerProcessor.a, 3000);
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(new UpgradeController.3(this));
      return;
    }
    BannerManager.a().b(UpgradeBannerProcessor.a, 3000);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, String.format("showUpgradeDialog needDesc=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    String str = ConfigHandler.a(this.e);
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
    synchronized (this.g)
    {
      if (!this.g.contains(paramOnStateChangedListener)) {
        this.g.add(paramOnStateChangedListener);
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "onCheckUpdateFailed");
    }
    c(this.m.e.d);
  }
  
  public void a(ArrayList<ApkUpdateDetail> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (ApkUpdateDetail)paramArrayList.get(0);
      if (paramArrayList != null)
      {
        if (this.m.e.d == paramArrayList.versioncode) {
          this.m.d = paramArrayList;
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
    if (this.m.d != null)
    {
      c(this.m.d.versioncode);
      return;
    }
    c(this.m.e.d);
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.c = ((DownloadInfo)paramList.get(0));
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onResult Status:");
      paramList.append(this.c);
      QLog.d("UpgradeController", 2, paramList.toString());
    }
    d(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      UpgradeDetailWrapper localUpgradeDetailWrapper = this.m;
      if ((localUpgradeDetailWrapper != null) && (localUpgradeDetailWrapper.b != null) && (this.m.b.iUpgradeType == 2)) {
        return;
      }
    }
    g();
    this.i = paramBoolean;
    this.k.removeMessages(0);
    r();
    this.e = BaseApplicationImpl.getApplication();
    this.c = null;
    this.b = true;
    if ((paramBoolean) || (this.m == null)) {
      this.m = new UpgradeDetailWrapper(null, null);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.i;
        if (bool) {
          return;
        }
        if (paramString1.equals(this.a))
        {
          if (this.o == null)
          {
            i1 = 1;
            if (paramBoolean)
            {
              if (i1 != 0) {
                m();
              }
              this.o = new AuthCodeWriter(paramString2, this);
              DownloadApi.a(this.o);
            }
            else if (i1 != 0)
            {
              this.m.b = new UpgradeInfo();
              this.m.e = null;
              d(-1);
            }
            this.a = null;
          }
        }
        else {
          return;
        }
      }
      finally {}
      int i1 = 0;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool;
    if (paramInt == this.n) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!bool) && (this.a == null)) {
      c(paramInt);
    }
    return bool;
  }
  
  public boolean a(String paramString, PackageInfo paramPackageInfo)
  {
    Object localObject = this.e.getPackageManager();
    if ((paramPackageInfo.signatures != null) && (paramPackageInfo.signatures.length > 0))
    {
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo(this.e.getPackageName(), 64);
        if (((PackageInfo)localObject).packageName.equals(this.e.getPackageName()))
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
    UpgradeDetailWrapper localUpgradeDetailWrapper = this.m;
    localUpgradeDetailWrapper.b = paramUpgradeInfo;
    localUpgradeDetailWrapper.e = ConfigHandler.a(paramUpgradeInfo);
    if (paramOnHandleUpgradeFinishListener != null)
    {
      if (paramUpgradeInfo == null) {
        return false;
      }
      if (paramUpgradeInfo.iUpgradeType == 0) {
        return false;
      }
      if (this.i) {
        return false;
      }
      if ((QQAppInterface)this.e.getRuntime() == null) {
        return false;
      }
      q();
      this.f = new WeakReference(paramOnHandleUpgradeFinishListener);
      if (QLog.isColorLevel())
      {
        paramOnHandleUpgradeFinishListener = new StringBuilder();
        paramOnHandleUpgradeFinishListener.append("handleUpgradeInfo packageName = ");
        paramOnHandleUpgradeFinishListener.append(this.e.getPackageName());
        paramOnHandleUpgradeFinishListener.append(", bGray = ");
        paramOnHandleUpgradeFinishListener.append(paramUpgradeInfo.bGray);
        paramOnHandleUpgradeFinishListener.append(", versioncode = ");
        paramOnHandleUpgradeFinishListener.append(this.m.e.d);
        QLog.d("UpgradeController", 2, paramOnHandleUpgradeFinishListener.toString());
      }
      paramUpgradeInfo = new ApkUpdateParam(this.e.getPackageName(), paramUpgradeInfo.bGray, this.m.e.d);
      paramOnHandleUpgradeFinishListener = new ArrayList();
      paramOnHandleUpgradeFinishListener.add(paramUpgradeInfo);
      UpdateManager.b().b(paramOnHandleUpgradeFinishListener);
      return true;
    }
    return false;
  }
  
  public int b()
  {
    Object localObject = this.c;
    int i2 = 0;
    int i1 = i2;
    if (localObject != null)
    {
      int i3 = ((DownloadInfo)localObject).a();
      i1 = i2;
      if (i3 != 1) {
        if (i3 != 2)
        {
          if (i3 != 3)
          {
            if (i3 != 4)
            {
              i1 = i2;
              if (i3 != 10) {
                if (i3 != 20) {
                  i1 = i2;
                } else {
                  i1 = 3;
                }
              }
            }
            else
            {
              i1 = 4;
            }
          }
          else {
            i1 = 2;
          }
        }
        else {
          i1 = 1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDownloadState: ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("UpgradeController", 2, ((StringBuilder)localObject).toString());
    }
    return i1;
  }
  
  public void b(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInt));
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    StatisticCollector.getInstance(this.e).collectPerformance("", "UpgradeWritten", bool, 0L, 0L, localHashMap, "", true);
  }
  
  public void b(UpgradeController.OnStateChangedListener paramOnStateChangedListener)
  {
    if (paramOnStateChangedListener == null) {
      return;
    }
    synchronized (this.g)
    {
      if (this.g.contains(paramOnStateChangedListener)) {
        this.g.remove(paramOnStateChangedListener);
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
      ((StringBuilder)localObject).append(this.d);
      QLog.d("UpgradeController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QQAppInterface)this.e.getRuntime();
    if (b() == 4) {
      return;
    }
    if (!this.d)
    {
      ConfigHandler.c((QQAppInterface)localObject, paramBoolean);
      if (paramBoolean)
      {
        n();
        return;
      }
      c(false);
    }
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: new 757	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 759	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 762	java/io/File:exists	()Z
    //   13: ifeq +135 -> 148
    //   16: new 764	java/io/FileInputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 767	java/io/FileInputStream:<init>	(Ljava/io/File;)V
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
    //   37: invokevirtual 771	java/io/FileInputStream:read	([B)I
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
    //   65: invokevirtual 774	java/io/FileInputStream:close	()V
    //   68: iconst_1
    //   69: ireturn
    //   70: aload_3
    //   71: invokevirtual 774	java/io/FileInputStream:close	()V
    //   74: iconst_0
    //   75: ireturn
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual 775	java/io/IOException:printStackTrace	()V
    //   81: iconst_0
    //   82: ireturn
    //   83: astore 4
    //   85: goto +13 -> 98
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_1
    //   91: goto +39 -> 130
    //   94: astore 4
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: astore_1
    //   100: ldc_w 320
    //   103: iconst_1
    //   104: ldc_w 380
    //   107: aload 4
    //   109: invokestatic 777	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_3
    //   113: ifnull +35 -> 148
    //   116: aload_3
    //   117: invokevirtual 774	java/io/FileInputStream:close	()V
    //   120: iconst_1
    //   121: ireturn
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 775	java/io/IOException:printStackTrace	()V
    //   127: iconst_1
    //   128: ireturn
    //   129: astore_3
    //   130: aload_1
    //   131: ifnull +15 -> 146
    //   134: aload_1
    //   135: invokevirtual 774	java/io/FileInputStream:close	()V
    //   138: goto +8 -> 146
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 775	java/io/IOException:printStackTrace	()V
    //   146: aload_3
    //   147: athrow
    //   148: iconst_1
    //   149: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	UpgradeController
    //   0	150	1	paramString	String
    //   54	5	2	i1	int
    //   24	47	3	localFileInputStream	java.io.FileInputStream
    //   88	1	3	localObject1	Object
    //   97	20	3	localObject2	Object
    //   129	18	3	localObject3	Object
    //   30	21	4	arrayOfByte	byte[]
    //   83	1	4	localThrowable1	Throwable
    //   94	14	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   70	74	76	java/io/IOException
    //   27	32	83	java/lang/Throwable
    //   34	41	83	java/lang/Throwable
    //   16	25	88	finally
    //   16	25	94	java/lang/Throwable
    //   64	68	122	java/io/IOException
    //   116	120	122	java/io/IOException
    //   27	32	129	finally
    //   34	41	129	finally
    //   100	112	129	finally
    //   134	138	141	java/io/IOException
  }
  
  void c(boolean paramBoolean)
  {
    if (!this.d)
    {
      this.d = true;
      int i1;
      if ((this.m.d != null) && (this.m.d.updatemethod == 4)) {
        i1 = 12;
      } else {
        i1 = 2;
      }
      a(i1, paramBoolean ^ true);
    }
  }
  
  boolean c()
  {
    return this.h != null;
  }
  
  public UpgradeDetailWrapper d()
  {
    return this.m;
  }
  
  public void d(boolean paramBoolean)
  {
    ThreadManager.post(new UpgradeController.1(this, paramBoolean), 5, null, false);
  }
  
  public void e()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.e.getRuntime();
    Object localObject = this.m;
    if ((localObject != null) && (((UpgradeDetailWrapper)localObject).b != null))
    {
      if (this.m.b.iUpgradeType != 1) {
        return;
      }
      localObject = this.c;
      if ((localObject != null) && (((DownloadInfo)localObject).o == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, "MYAPP has work, do not allow download by wifi");
        }
        ConfigHandler.c(localQQAppInterface, false);
        d(false);
        return;
      }
      if (!this.d) {
        b(ConfigHandler.a(localQQAppInterface, false));
      }
    }
  }
  
  public void f()
  {
    if ((this.d) && (c())) {
      g();
    }
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 318	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +13 -> 18
    //   8: ldc_w 320
    //   11: iconst_2
    //   12: ldc_w 796
    //   15: invokestatic 337	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: getfield 359	com/tencent/mobileqq/upgrade/UpgradeController:d	Z
    //   22: ifeq +21 -> 43
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 359	com/tencent/mobileqq/upgrade/UpgradeController:d	Z
    //   30: aload_0
    //   31: invokevirtual 798	com/tencent/mobileqq/upgrade/UpgradeController:i	()V
    //   34: aload_0
    //   35: invokespecial 800	com/tencent/mobileqq/upgrade/UpgradeController:o	()V
    //   38: ldc 146
    //   40: invokestatic 802	com/tencent/open/downloadnew/DownloadApi:a	(Ljava/lang/String;)V
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
  
  public void h()
  {
    boolean bool = QLog.isColorLevel();
    int i2 = 2;
    if (bool) {
      QLog.d("UpgradeController", 2, "resumeDownload:");
    }
    if (this.c == null) {
      return;
    }
    int i1 = i2;
    if (this.m.d != null)
    {
      i1 = i2;
      if (this.m.d.updatemethod == 4) {
        i1 = 12;
      }
    }
    a(i1, c() ^ true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      paramMessage = this.e;
      if (!this.p) {
        break label75;
      }
      i1 = 2131892304;
    }
    catch (Throwable paramMessage)
    {
      for (;;)
      {
        continue;
        label75:
        int i1 = 2131892303;
      }
    }
    Toast.makeText(paramMessage, i1, 0).show();
    paramMessage = ((QQAppInterface)this.e.getRuntime()).getHandler(Conversation.class);
    if ((paramMessage != null) && (a().b() == 4)) {
      paramMessage.obtainMessage(1134019).sendToTarget();
    }
    return true;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "pauseDownload:");
    }
    a(3, c() ^ true);
  }
  
  public void installSucceed(String paramString1, String paramString2) {}
  
  public boolean j()
  {
    if (b() == 4)
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        String str2 = ((DownloadInfo)localObject).q;
        if (TextUtils.isEmpty(str2))
        {
          QLog.e("UpgradeConfigManager", 1, "checkJacking：  cannot get path to apk");
          return true;
        }
        localObject = this.e.getPackageManager();
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
          if (localStringBuilder.packageName.equals(this.e.getPackageName()))
          {
            String str3 = PluginStatic.encodeFile(str2);
            QQAppInterface localQQAppInterface = (QQAppInterface)this.e.getRuntime();
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
              if (b(str2))
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
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.c)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadCancel");
    }
    this.d = false;
    o();
    this.c = paramDownloadInfo;
    e(b());
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (!"100686848".equals(paramDownloadInfo.c)) {
      return;
    }
    this.c = paramDownloadInfo;
    this.d = false;
    o();
    if (QLog.isColorLevel())
    {
      paramDownloadInfo = new StringBuilder();
      paramDownloadInfo.append("onDownloadError: ");
      paramDownloadInfo.append(paramInt1);
      paramDownloadInfo.append(", ");
      paramDownloadInfo.append(paramString);
      QLog.d("UpgradeController", 2, paramDownloadInfo.toString());
    }
    e(b());
    paramInt2 = paramInt1;
    if (NetworkUtil.isWifiConnected(this.e)) {
      paramInt2 = paramInt1 | 0x1;
    }
    paramDownloadInfo = new HashMap();
    paramDownloadInfo.put("param_FailCode", Integer.toString(paramInt2));
    paramDownloadInfo.put("param_ErrMsg", paramString);
    StatisticCollector.getInstance(this.e).collectPerformance("", "UpgradeErr", false, 0L, 0L, paramDownloadInfo, "", true);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    Object localObject2 = (QQAppInterface)this.e.getRuntime();
    if (!"100686848".equals(paramDownloadInfo.c)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadFinish");
    }
    this.c = paramDownloadInfo;
    this.d = false;
    String str = paramDownloadInfo.q;
    Object localObject1 = str;
    if (TextUtils.isEmpty(str))
    {
      localObject1 = str;
      if (paramDownloadInfo.o == 1)
      {
        paramDownloadInfo = DownloadManager.b().c(paramDownloadInfo);
        localObject1 = str;
        if (paramDownloadInfo != null) {
          localObject1 = paramDownloadInfo.mSavePath;
        }
      }
    }
    paramDownloadInfo = a(this.e, (String)localObject1);
    int i1;
    if (paramDownloadInfo != null)
    {
      i1 = paramDownloadInfo.versionCode;
      paramDownloadInfo = paramDownloadInfo.packageName;
    }
    else
    {
      paramDownloadInfo = "";
      i1 = 0;
    }
    int i2 = ApkUtils.a(this.e);
    str = PluginStatic.encodeFile((String)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upgradeDownloadFinish md5=");
    localStringBuilder.append(str);
    QLog.i("UpgradeController", 1, localStringBuilder.toString());
    if ((this.e.getPackageName().equals(paramDownloadInfo)) && (i2 > 0) && (i1 >= i2))
    {
      if (localObject2 == null) {
        return;
      }
      e(b());
      ((QQAppInterface)localObject2).getPreferences().edit().putLong("YELLOW_BAR_LAST_SHOW", 0L).putString("upgrade_check_md5", str).commit();
      p();
      o();
      return;
    }
    boolean bool = this.c.w;
    if (bool)
    {
      DownloadApi.a("_100686848");
    }
    else
    {
      this.c.w = false;
      a(10, true ^ c());
    }
    o();
    localObject1 = new File((String)localObject1);
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
    localObject1 = new HashMap();
    if (i1 < i2) {
      i1 = 101;
    } else {
      i1 = 9527;
    }
    ((HashMap)localObject1).put("param_FailCode", Integer.toString(i1));
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("MD5:");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("_PN:");
    ((StringBuilder)localObject2).append(paramDownloadInfo);
    ((HashMap)localObject1).put("param_ErrMsg", ((StringBuilder)localObject2).toString());
    StatisticCollector.getInstance(this.e).collectPerformance("", "UpgradeErr", false, 0L, 0L, (HashMap)localObject1, "", true);
    if (!bool) {
      this.k.sendEmptyMessage(0);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.c)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadPause");
    }
    this.c = paramDownloadInfo;
    e(b());
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if ("100686848".equals(localDownloadInfo.c))
        {
          this.c = localDownloadInfo;
          i1 = 1;
          break label54;
        }
      }
    }
    int i1 = 0;
    label54:
    if (i1 == 0) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onDownloadUpdate Status:");
      paramList.append(this.c.a());
      QLog.d("UpgradeController", 2, paramList.toString());
    }
    e(b());
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(paramDownloadInfo.c)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadWait");
    }
    this.c = paramDownloadInfo;
    e(b());
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeController
 * JD-Core Version:    0.7.0.1
 */