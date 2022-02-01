package cooperation.plugin;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TripleGraySwitchUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import cooperation.plugin.rc.GetQQAppInterfaceDataRemoteCommand;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public final class PluginManagerV2
  extends IPluginManager
  implements Handler.Callback, PluginDownloader.OnPluginDownLoadListener, PluginInstaller.OnPluginSetupListener, PluginUpdater.OnPluginInfoUpdateListener
{
  private Application jdField_a_of_type_AndroidAppApplication;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BuiltinPluginManager jdField_a_of_type_CooperationPluginBuiltinPluginManager;
  private PluginDownloader jdField_a_of_type_CooperationPluginPluginDownloader;
  private PluginInstaller jdField_a_of_type_CooperationPluginPluginInstaller;
  private PluginManagerV2.NetworkReceiver jdField_a_of_type_CooperationPluginPluginManagerV2$NetworkReceiver;
  private PluginPreInstaller jdField_a_of_type_CooperationPluginPluginPreInstaller;
  private PluginUpdater jdField_a_of_type_CooperationPluginPluginUpdater;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<PluginManagerV2.LaunchState> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<String, PluginInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private ConcurrentHashMap<String, OnPluginInstallListener> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public PluginManagerV2(QQAppInterface paramQQAppInterface)
  {
    QLog.d("plugin_tag", 1, "init plugin manager");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    b();
    this.jdField_a_of_type_CooperationPluginPluginUpdater = new PluginUpdater(this.jdField_a_of_type_AndroidAppApplication, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_CooperationPluginPluginPreInstaller = new PluginPreInstaller(this.jdField_a_of_type_AndroidAppApplication, this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_CooperationPluginPluginUpdater.a(this);
    this.jdField_a_of_type_CooperationPluginPluginDownloader = new PluginDownloader(this.jdField_a_of_type_AndroidAppApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    try
    {
      this.jdField_a_of_type_CooperationPluginPluginInstaller = new PluginInstaller(this.jdField_a_of_type_AndroidAppApplication, PluginDownloader.a(this.jdField_a_of_type_AndroidAppApplication).getCanonicalPath());
      label160:
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      this.jdField_a_of_type_CooperationPluginBuiltinPluginManager = BuiltinPluginManager.a(this.jdField_a_of_type_AndroidAppApplication);
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$NetworkReceiver = new PluginManagerV2.NetworkReceiver(this);
      this.jdField_a_of_type_CooperationPluginPluginManagerV2$NetworkReceiver.a();
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      localPluginCommunicationHandler.setCommunicationChannel(new QQPluginCommunicationChannel());
      localPluginCommunicationHandler.register(new GetQQAppInterfaceDataRemoteCommand(paramQQAppInterface));
      paramQQAppInterface = PluginManageHandler.getInstance();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {
        paramQQAppInterface.setPluginManagerProvider(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      }
      QLog.d("plugin_tag", 1, "init plugin manager end");
      return;
    }
    catch (IOException localIOException)
    {
      break label160;
    }
  }
  
  private static AlertDialog a(Context paramContext, String paramString, long paramLong, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramString = HardCodeUtil.a(2131708270) + paramString + "（" + ByteUnitTransformUtil.a(paramLong) + HardCodeUtil.a(2131708267);; paramString = paramString + "（" + ByteUnitTransformUtil.a(paramLong) + HardCodeUtil.a(2131708269)) {
      return new AlertDialog.Builder(paramContext).setMessage(paramString).setNegativeButton(HardCodeUtil.a(2131708268), paramOnClickListener2).setPositiveButton(HardCodeUtil.a(2131708272), paramOnClickListener1).create();
    }
  }
  
  private static ProgressDialog a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new ReportProgressDialog(paramContext);
    paramContext.setProgressStyle(1);
    paramContext.setIndeterminate(false);
    paramContext.setTitle(paramString);
    paramContext.setMessage(HardCodeUtil.a(2131708271));
    paramContext.setCancelable(false);
    paramContext.setButton(-2, HardCodeUtil.a(2131708273), new PluginManagerV2.1(paramOnClickListener));
    return paramContext;
  }
  
  private void a(int paramInt, Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    QLog.d("plugin_tag", 1, "doInstallAndLaunch. confirmCode, pluginId:" + paramInt + "," + paramPluginParams.b + ", " + this.c);
    if ((!this.c) && (!BuiltinPluginManager.b(paramPluginParams.b))) {
      if (paramOnPluginReadyListener != null) {
        paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt != 0) {
            break;
          }
        } while (paramOnPluginReadyListener == null);
        paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
        return;
        if (paramInt != 2) {
          break;
        }
      } while (paramOnPluginReadyListener == null);
      localObject1 = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(paramPluginParams.b);
      if ((localObject1 != null) && (((PluginInfo)localObject1).mInstalledPath != null))
      {
        paramPluginParams.d = ((PluginInfo)localObject1).mInstalledPath;
        paramPluginParams.a((PluginBaseInfo)localObject1);
      }
      paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
      return;
      if (paramInt == 4)
      {
        localObject1 = paramPluginParams.b;
        localObject2 = new PluginManagerV2.LaunchState();
        ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_AndroidContentContext = paramContext;
        ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
        ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
        ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_Boolean = true;
        a((String)localObject1, new PluginManagerV2.PluginInstallForLaunch(this, (PluginManagerV2.LaunchState)localObject2));
        return;
      }
      if (paramInt == 1)
      {
        localObject2 = paramPluginParams.b;
        localObject1 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a((String)localObject2);
        if (localObject1 == null) {}
        for (localObject1 = "";; localObject1 = ((PluginInfo)localObject1).mName)
        {
          PluginManagerV2.LaunchState localLaunchState = new PluginManagerV2.LaunchState();
          localLaunchState.jdField_a_of_type_AndroidContentContext = paramContext;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
          localLaunchState.jdField_a_of_type_Boolean = false;
          localLaunchState.jdField_a_of_type_AndroidAppProgressDialog = a(paramContext, (String)localObject1, new PluginManagerV2.CancelDownloadClickListener(this, paramPluginParams.b, null));
          installPlugin((String)localObject2, new PluginManagerV2.PluginInstallForLaunch(this, localLaunchState));
          return;
        }
      }
    } while (paramInt != 3);
    Object localObject1 = paramPluginParams.b;
    Object localObject2 = new PluginManagerV2.LaunchState();
    ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_AndroidContentContext = paramContext;
    ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
    ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
    ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_Boolean = true;
    installPlugin((String)localObject1, new PluginManagerV2.PluginInstallForLaunch(this, (PluginManagerV2.LaunchState)localObject2));
  }
  
  private void a(String paramString, IPluginManager.OnQueryPluginListener paramOnQueryPluginListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doQueryPlugin: " + paramString + ", " + paramOnQueryPluginListener);
    }
    PluginInfo localPluginInfo2 = b(paramString);
    PluginInfo localPluginInfo1 = localPluginInfo2;
    if (localPluginInfo2 != null) {
      localPluginInfo1 = localPluginInfo2.a();
    }
    b();
    paramOnQueryPluginListener.a(paramString, localPluginInfo1, this);
  }
  
  public static boolean a()
  {
    boolean bool2;
    boolean bool3;
    if (!((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.disable_dex2oat.name()))
    {
      bool1 = true;
      bool2 = bool1;
      if (bool1)
      {
        bool3 = Dex2Oat.a();
        if ((!bool1) || (!bool3) || (Build.VERSION.SDK_INT < 21)) {
          break label106;
        }
      }
    }
    label106:
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("plugin_tag", 1, "isPluginSupportDex2Oat = " + bool1 + ", " + bool3);
        bool2 = bool1;
      }
      return bool2;
      bool1 = false;
      break;
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    paramString = a(paramString);
    if (paramString == null)
    {
      QLog.d("plugin_tag", 1, "noinfo");
      return false;
    }
    if (paramString.mSubType != 1)
    {
      QLog.d("plugin_tag", 1, "noshadow");
      return false;
    }
    if (paramString.mState == 4) {
      bool = true;
    }
    QLog.d("plugin_tag", 1, "isShadowAndHasInstalled " + bool);
    return bool;
  }
  
  private PluginInfo b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "fetchPlugin :" + paramString);
    }
    Object localObject2 = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    Object localObject1;
    if (localObject2 == null)
    {
      PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installed info :" + localPluginInfo);
      }
      localObject1 = localObject2;
      if (localPluginInfo != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_CooperationPluginPluginUpdater.a(localPluginInfo))
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "up to day info");
          }
          localObject1 = localPluginInfo;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString);
      }
      return localObject2;
      int i = ((PluginInfo)localObject2).mState;
      if ((i != -1) && (i != 4))
      {
        localObject1 = localObject2;
        if (i != -2) {}
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        localObject1 = localObject2;
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "clearOldVersionPlugins");
    }
    File localFile1 = this.jdField_a_of_type_AndroidAppApplication.getDir("plugins", 0);
    File localFile2 = this.jdField_a_of_type_AndroidAppApplication.getDir("NetPlugins", 0);
    try
    {
      FileUtils.a(localFile1.getCanonicalPath());
      FileUtils.a(localFile2.getCanonicalPath());
      return;
    }
    catch (IOException localIOException) {}
  }
  
  private boolean b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(66049);
      return true;
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    paramString = this.jdField_a_of_type_CooperationPluginBuiltinPluginManager.a(paramString);
    if (paramString == null) {
      return false;
    }
    return this.jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString);
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      PluginInfo localPluginInfo = (PluginInfo)localIterator.next();
      if ((localPluginInfo != null) && (localPluginInfo.mState == 1) && (localPluginInfo.a == 1)) {
        cancelInstall(localPluginInfo.mID);
      }
    }
  }
  
  private void c(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    int j = 2;
    boolean bool2 = false;
    boolean bool3 = true;
    if (paramPluginParams == null) {}
    PluginInfo localPluginInfo2;
    boolean bool4;
    boolean bool1;
    label309:
    do
    {
      do
      {
        return;
        QLog.d("plugin_tag", 1, "checkUpdate:" + paramPluginParams.b + ", " + paramPluginParams.f);
        if ((this.c) || (BuiltinPluginManager.b(paramPluginParams.b))) {
          break;
        }
      } while (paramOnPluginReadyListener == null);
      paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
      return;
      String str = paramPluginParams.b;
      localPluginInfo2 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a(str);
      if (localPluginInfo2 == null)
      {
        a(0, paramContext, paramPluginParams, paramOnPluginReadyListener);
        return;
      }
      bool4 = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(str);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "installed :" + bool4);
      }
      if (bool4)
      {
        PluginInfo localPluginInfo1 = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(str);
        bool1 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a(localPluginInfo1);
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "up to day :" + bool1);
        }
        localObject = localPluginInfo1;
        if (bool1)
        {
          int i = j;
          if (a())
          {
            i = j;
            if (Dex2Oat.a(localPluginInfo1.mFingerPrint))
            {
              if (!PluginInfoUtil.a(localPluginInfo2, this.jdField_a_of_type_AndroidAppApplication)) {
                break label309;
              }
              QLog.d("plugin_tag", 1, "systemOTA but running " + str);
              i = j;
            }
          }
          for (;;)
          {
            a(i, paramContext, paramPluginParams, paramOnPluginReadyListener);
            return;
            i = 4;
            QLog.d("plugin_tag", 1, "systemOTA runDex2Oat");
          }
        }
      }
      else
      {
        localObject = null;
      }
      if ((!PluginInfoUtil.a(localPluginInfo2, this.jdField_a_of_type_AndroidAppApplication)) || (localObject == null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
    } while (paramOnPluginReadyListener == null);
    paramPluginParams.d = ((PluginInfo)localObject).mInstalledPath;
    paramPluginParams.a((PluginBaseInfo)localObject);
    paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
    return;
    if ((localPluginInfo2.mUpdateType == 0) && (bool4)) {
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "forceUpdate, deamonInstall：" + bool1 + ", " + bool2);
      }
      if (!bool2) {
        break;
      }
      a(3, paramContext, paramPluginParams, paramOnPluginReadyListener);
      return;
      bool1 = bool3;
      if (localPluginInfo2.mInstallType != 1)
      {
        bool2 = true;
        bool1 = bool3;
      }
    }
    if (localObject != null) {}
    for (Object localObject = ((PluginInfo)localObject).mFingerPrint;; localObject = null)
    {
      paramPluginParams = new PluginManagerV2.ConfirmDialogClickListener(this, paramOnPluginReadyListener, bool1, paramContext, paramPluginParams, bool4, (String)localObject, null);
      a(paramContext, localPluginInfo2.mName, localPluginInfo2.mLength, paramPluginParams, paramPluginParams, bool1).show();
      return;
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doClose");
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "getPluginList");
        }
        boolean bool = this.jdField_b_of_type_Boolean;
        if (bool) {
          return;
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          if (!NetworkUtil.g(this.jdField_a_of_type_AndroidAppApplication)) {
            a(false);
          } else {
            this.jdField_a_of_type_CooperationPluginPluginUpdater.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
      }
      finally {}
    }
  }
  
  private void f()
  {
    if (NetworkState.isMobile()) {
      c();
    }
    while ((!NetworkState.isWifiConn()) || (!this.c)) {
      return;
    }
    this.jdField_a_of_type_CooperationPluginPluginPreInstaller.b();
  }
  
  public PluginInfo a(String paramString)
  {
    Object localObject = paramString;
    if (!PluginIdUtil.isQPluginId(paramString)) {
      localObject = PluginIdUtil.convertQShadowId2QPluginId(paramString);
    }
    localObject = b((String)localObject);
    paramString = (String)localObject;
    if (localObject != null) {
      paramString = ((PluginInfo)localObject).a();
    }
    b();
    return paramString;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "setReadyToNetworking");
    }
    b();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localObject != null) && (((PluginInfo)localObject).mState == 1) && (paramInt2 > 0)) {
      ((PluginInfo)localObject).mDownloadProgress = (paramInt1 / paramInt2);
    }
    localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallDownloadProgress(paramString, paramInt1, paramInt2);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void a(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if ((!this.c) && (!BuiltinPluginManager.b(paramPluginParams.b)) && (!a(paramPluginParams.b)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "not ready");
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        PluginManagerV2.LaunchState localLaunchState;
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "mPendingLaunchStateList not empty");
          }
          localLaunchState = new PluginManagerV2.LaunchState();
          localLaunchState.jdField_a_of_type_AndroidContentContext = paramContext;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
          this.jdField_a_of_type_JavaUtilArrayList.add(localLaunchState);
          return;
        }
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          b();
          localLaunchState = new PluginManagerV2.LaunchState();
          localLaunchState.jdField_a_of_type_AndroidContentContext = paramContext;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
          this.jdField_a_of_type_JavaUtilArrayList.add(localLaunchState);
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "set mPendingLaunchStateList");
          }
          return;
        }
      }
    }
    c(paramContext, paramPluginParams, paramOnPluginReadyListener);
  }
  
  public void a(String paramString)
  {
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    ((PluginInfo)localObject).mState = -2;
    localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallError(paramString, 4);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
  {
    QLog.d("plugin_tag", 1, "dex2oatPlugin." + paramString);
    PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(paramString);
    if (localPluginInfo == null) {
      return;
    }
    if (PluginInfoUtil.a(localPluginInfo, this.jdField_a_of_type_AndroidAppApplication))
    {
      QLog.d("plugin_tag", 1, "dex2oatPlugin plugin still running " + paramString);
      return;
    }
    if (paramOnPluginInstallListener != null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramOnPluginInstallListener);
    }
    localPluginInfo.mState = 5;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPluginInfo);
    this.jdField_a_of_type_CooperationPluginPluginInstaller.b(localPluginInfo, this);
  }
  
  public void a(String paramString, OnPluginInstallListener paramOnPluginInstallListener, boolean paramBoolean)
  {
    a(paramString, false, paramBoolean, paramOnPluginInstallListener);
  }
  
  public void a(String paramString1, PluginDownloader.OnPluginDownLoadListener paramOnPluginDownLoadListener, String paramString2)
  {
    paramString2 = paramString1;
    if (!PluginIdUtil.isQPluginId(paramString1)) {
      paramString2 = PluginIdUtil.convertQShadowId2QPluginId(paramString1);
    }
    QLog.d("plugin_tag", 1, "preDownloadPlugin." + paramString2);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2) != null) {
      QLog.w("plugin_tag", 1, paramString2 + " task has already running!");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramString1 = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(paramString2);
            if (!this.jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString1)) {
              break;
            }
            QLog.i("plugin_tag", 1, paramString2 + " is up to day!");
          } while (paramOnPluginDownLoadListener == null);
          paramOnPluginDownLoadListener.c(paramString2);
          return;
          paramString1 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString2);
          if (paramString1 != null) {
            break;
          }
          QLog.i("plugin_tag", 1, paramString2 + " has no new version!");
        } while (paramOnPluginDownLoadListener == null);
        paramOnPluginDownLoadListener.c(paramString2);
        return;
        if (!PluginInfoUtil.a(paramString1, this.jdField_a_of_type_AndroidAppApplication)) {
          break;
        }
        QLog.d("plugin_tag", 1, "plugin still running");
      } while (paramOnPluginDownLoadListener == null);
      paramOnPluginDownLoadListener.c(paramString2);
      return;
      PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(paramString2);
      if ((localPluginInfo == null) || (localPluginInfo.mState != 2) || (!TextUtils.equals(localPluginInfo.mMD5, paramString1.mMD5))) {
        break;
      }
    } while (paramOnPluginDownLoadListener == null);
    paramOnPluginDownLoadListener.a(true, paramString2);
    return;
    paramString1.mState = 5;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, paramString1);
    if (paramOnPluginDownLoadListener != null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, new PluginManagerV2.OnPluginDownLoadListenerTransfer(paramOnPluginDownLoadListener));
    }
    this.jdField_a_of_type_CooperationPluginPluginDownloader.a(paramString1, this, true);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, " recordPluginStartupTime " + paramString1 + ", key = " + paramString2 + ", span = " + paramLong);
    }
    paramString1 = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(paramString1);
    if (paramString1 != null)
    {
      if (!"pluginApkCost".equals(paramString2)) {
        break label81;
      }
      paramString1.costApk = paramLong;
    }
    label81:
    do
    {
      return;
      if ("pluginOatCost".equals(paramString2))
      {
        paramString1.costDex2Oat = paramLong;
        return;
      }
      if ("pluginDownloadCost".equals(paramString2))
      {
        paramString1.costDownload = paramLong;
        return;
      }
    } while (!"pluginLibCost".equals(paramString2));
    paramString1.costLib = paramLong;
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, OnPluginInstallListener paramOnPluginInstallListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 5
    //   3: aload_1
    //   4: invokestatic 573	com/tencent/mobileqq/qshadow/utils/PluginIdUtil:isQPluginId	(Ljava/lang/String;)Z
    //   7: ifne +9 -> 16
    //   10: aload_1
    //   11: invokestatic 577	com/tencent/mobileqq/qshadow/utils/PluginIdUtil:convertQShadowId2QPluginId	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore 5
    //   16: ldc 50
    //   18: iconst_1
    //   19: new 186	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 700
    //   29: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload 5
    //   34: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aconst_null
    //   44: astore_1
    //   45: iload_2
    //   46: ifeq +33 -> 79
    //   49: aload_0
    //   50: getfield 137	cooperation/plugin/PluginManagerV2:jdField_a_of_type_CooperationPluginBuiltinPluginManager	Lcooperation/plugin/BuiltinPluginManager;
    //   53: aload 5
    //   55: invokevirtual 458	cooperation/plugin/BuiltinPluginManager:a	(Ljava/lang/String;)Lcooperation/plugin/PluginInfo;
    //   58: astore_1
    //   59: aload_1
    //   60: ifnonnull +44 -> 104
    //   63: aload 4
    //   65: ifnull +13 -> 78
    //   68: aload 4
    //   70: aload 5
    //   72: iconst_1
    //   73: invokeinterface 612 3 0
    //   78: return
    //   79: aload_0
    //   80: getfield 90	cooperation/plugin/PluginManagerV2:jdField_a_of_type_CooperationPluginPluginUpdater	Lcooperation/plugin/PluginUpdater;
    //   83: aload 5
    //   85: invokevirtual 331	cooperation/plugin/PluginUpdater:a	(Ljava/lang/String;)Lcooperation/plugin/PluginInfo;
    //   88: astore 6
    //   90: aload 6
    //   92: ifnull -33 -> 59
    //   95: aload 6
    //   97: invokevirtual 366	cooperation/plugin/PluginInfo:a	()Lcooperation/plugin/PluginInfo;
    //   100: astore_1
    //   101: goto -42 -> 59
    //   104: aload_1
    //   105: aload_0
    //   106: getfield 68	cooperation/plugin/PluginManagerV2:jdField_a_of_type_AndroidAppApplication	Landroid/app/Application;
    //   109: invokestatic 507	cooperation/plugin/PluginInfoUtil:a	(Lcooperation/plugin/PluginInfo;Landroid/content/Context;)Z
    //   112: ifeq +30 -> 142
    //   115: ldc 50
    //   117: iconst_1
    //   118: ldc_w 513
    //   121: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: aload 4
    //   126: ifnull -48 -> 78
    //   129: aload 4
    //   131: aload 5
    //   133: iconst_2
    //   134: invokeinterface 612 3 0
    //   139: return
    //   140: astore_1
    //   141: return
    //   142: aload_0
    //   143: getfield 128	cooperation/plugin/PluginManagerV2:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   146: aload 5
    //   148: invokevirtual 424	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: checkcast 300	cooperation/plugin/PluginInfo
    //   154: astore 6
    //   156: aload 6
    //   158: ifnull +171 -> 329
    //   161: aload 6
    //   163: getfield 416	cooperation/plugin/PluginInfo:mState	I
    //   166: iconst_3
    //   167: if_icmpne +162 -> 329
    //   170: aload_0
    //   171: getfield 68	cooperation/plugin/PluginManagerV2:jdField_a_of_type_AndroidAppApplication	Landroid/app/Application;
    //   174: ldc_w 702
    //   177: iconst_1
    //   178: invokestatic 707	com/tencent/mobileqq/utils/TripleGraySwitchUtil:b	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   181: ifne +148 -> 329
    //   184: ldc 50
    //   186: iconst_1
    //   187: new 186	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 709
    //   197: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 5
    //   202: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc_w 711
    //   208: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_0
    //   218: getfield 130	cooperation/plugin/PluginManagerV2:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   221: aload 5
    //   223: invokevirtual 424	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   226: checkcast 588	com/tencent/mobileqq/pluginsdk/OnPluginInstallListener
    //   229: astore_1
    //   230: aload 4
    //   232: ifnull +43 -> 275
    //   235: aload_1
    //   236: ifnull +39 -> 275
    //   239: ldc 50
    //   241: iconst_1
    //   242: new 186	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 713
    //   252: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload 5
    //   257: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: aload_1
    //   267: aload 5
    //   269: iconst_3
    //   270: invokeinterface 612 3 0
    //   275: aload 4
    //   277: ifnull -199 -> 78
    //   280: ldc 50
    //   282: iconst_1
    //   283: new 186	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   290: ldc_w 715
    //   293: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload 5
    //   298: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aload 4
    //   309: aload 5
    //   311: invokeinterface 718 2 0
    //   316: aload_0
    //   317: getfield 130	cooperation/plugin/PluginManagerV2:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   320: aload 5
    //   322: aload 4
    //   324: invokevirtual 620	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   327: pop
    //   328: return
    //   329: invokestatic 356	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +12 -> 344
    //   335: ldc 50
    //   337: iconst_2
    //   338: ldc_w 720
    //   341: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: aload 4
    //   346: ifnull +15 -> 361
    //   349: aload_0
    //   350: getfield 130	cooperation/plugin/PluginManagerV2:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   353: aload 5
    //   355: aload 4
    //   357: invokevirtual 620	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   360: pop
    //   361: aload_0
    //   362: getfield 123	cooperation/plugin/PluginManagerV2:jdField_a_of_type_CooperationPluginPluginInstaller	Lcooperation/plugin/PluginInstaller;
    //   365: aload 5
    //   367: invokevirtual 298	cooperation/plugin/PluginInstaller:a	(Ljava/lang/String;)Lcooperation/plugin/PluginInfo;
    //   370: astore 4
    //   372: aload 4
    //   374: ifnull +69 -> 443
    //   377: aload_0
    //   378: getfield 90	cooperation/plugin/PluginManagerV2:jdField_a_of_type_CooperationPluginPluginUpdater	Lcooperation/plugin/PluginUpdater;
    //   381: aload 4
    //   383: invokevirtual 429	cooperation/plugin/PluginUpdater:a	(Lcooperation/plugin/PluginInfo;)Z
    //   386: ifeq +57 -> 443
    //   389: aload 4
    //   391: getfield 416	cooperation/plugin/PluginInfo:mState	I
    //   394: iconst_2
    //   395: if_icmpne +48 -> 443
    //   398: aload 4
    //   400: astore_1
    //   401: aload_0
    //   402: getfield 128	cooperation/plugin/PluginManagerV2:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   405: aload 5
    //   407: aload_1
    //   408: invokevirtual 620	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   411: pop
    //   412: aload_0
    //   413: aload 5
    //   415: invokespecial 721	cooperation/plugin/PluginManagerV2:b	(Ljava/lang/String;)Z
    //   418: ifne +15 -> 433
    //   421: iload_2
    //   422: ifne +11 -> 433
    //   425: aload_1
    //   426: getfield 416	cooperation/plugin/PluginInfo:mState	I
    //   429: iconst_2
    //   430: if_icmpne +21 -> 451
    //   433: aload_0
    //   434: getfield 123	cooperation/plugin/PluginManagerV2:jdField_a_of_type_CooperationPluginPluginInstaller	Lcooperation/plugin/PluginInstaller;
    //   437: aload_1
    //   438: aload_0
    //   439: invokevirtual 723	cooperation/plugin/PluginInstaller:a	(Lcooperation/plugin/PluginInfo;Lcooperation/plugin/PluginInstaller$OnPluginSetupListener;)V
    //   442: return
    //   443: aload_1
    //   444: iconst_5
    //   445: putfield 416	cooperation/plugin/PluginInfo:mState	I
    //   448: goto -47 -> 401
    //   451: aload_0
    //   452: getfield 107	cooperation/plugin/PluginManagerV2:jdField_a_of_type_CooperationPluginPluginDownloader	Lcooperation/plugin/PluginDownloader;
    //   455: aload_1
    //   456: aload_0
    //   457: iload_3
    //   458: invokevirtual 664	cooperation/plugin/PluginDownloader:a	(Lcooperation/plugin/PluginInfo;Lcooperation/plugin/PluginDownloader$OnPluginDownLoadListener;Z)V
    //   461: return
    //   462: astore_1
    //   463: return
    //   464: astore_1
    //   465: goto -149 -> 316
    //   468: astore_1
    //   469: goto -194 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	this	PluginManagerV2
    //   0	472	1	paramString	String
    //   0	472	2	paramBoolean1	boolean
    //   0	472	3	paramBoolean2	boolean
    //   0	472	4	paramOnPluginInstallListener	OnPluginInstallListener
    //   1	413	5	str	String
    //   88	74	6	localPluginInfo	PluginInfo
    // Exception table:
    //   from	to	target	type
    //   129	139	140	android/os/RemoteException
    //   68	78	462	android/os/RemoteException
    //   280	316	464	android/os/RemoteException
    //   239	275	468	android/os/RemoteException
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = true;
    if (!paramBoolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          break label121;
        }
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "onUpdateFinish. handle pending");
        }
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        PluginManagerV2.LaunchState localLaunchState = (PluginManagerV2.LaunchState)localIterator.next();
        c(localLaunchState.jdField_a_of_type_AndroidContentContext, localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener);
      }
      this.jdField_a_of_type_CooperationPluginPluginPreInstaller.a();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    for (;;)
    {
      return;
      label121:
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "mPendingLaunchStateList empty");
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    QLog.d("plugin_tag", 1, "onDownloadFinish:" + paramBoolean);
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null)
    {
      if (!paramBoolean) {
        break label173;
      }
      ((PluginInfo)localObject).mState = 2;
      ((PluginInfo)localObject).mDownloadProgress = 1.0F;
      if (!(this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) instanceof PluginManagerV2.OnPluginDownLoadListenerTransfer)) {
        break label112;
      }
    }
    for (;;)
    {
      label112:
      try
      {
        PluginManagerV2.OnPluginDownLoadListenerTransfer localOnPluginDownLoadListenerTransfer = (PluginManagerV2.OnPluginDownLoadListenerTransfer)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        if (localOnPluginDownLoadListenerTransfer != null) {
          localOnPluginDownLoadListenerTransfer.onInstallFinish(paramString);
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        this.jdField_a_of_type_CooperationPluginPluginInstaller.b((PluginInfo)localObject);
        return;
      }
      catch (RemoteException paramString) {}
      if (!TripleGraySwitchUtil.b(this.jdField_a_of_type_AndroidAppApplication, "KEY_DISABLE_SAVE_PLUGIN_INFO", true))
      {
        QLog.d("plugin_tag", 1, "download finish, save plugin info, state: " + ((PluginInfo)localObject).mState);
        this.jdField_a_of_type_CooperationPluginPluginInstaller.b((PluginInfo)localObject);
      }
      this.jdField_a_of_type_CooperationPluginPluginInstaller.a((PluginInfo)localObject, this);
      return;
      label173:
      ((PluginInfo)localObject).mState = -2;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      if (localObject != null) {
        try
        {
          ((OnPluginInstallListener)localObject).onInstallError(paramString, 5);
          return;
        }
        catch (RemoteException paramString) {}
      }
    }
  }
  
  public boolean a(PluginInfo paramPluginInfo)
  {
    this.jdField_a_of_type_CooperationPluginPluginDownloader.a(paramPluginInfo.mID);
    return this.jdField_a_of_type_CooperationPluginPluginInstaller.b(paramPluginInfo.mID);
  }
  
  public void b(String paramString)
  {
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null)
    {
      ((PluginInfo)localObject).mState = 1;
      ((PluginInfo)localObject).a = NetworkUtil.b(this.jdField_a_of_type_AndroidAppApplication);
    }
    localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallBegin(paramString);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    OnPluginInstallListener localOnPluginInstallListener = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    PluginInfo localPluginInfo = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localPluginInfo != null) {
      if (!paramBoolean) {
        break label70;
      }
    }
    for (int i = 4;; i = -2)
    {
      localPluginInfo.mState = i;
      if ((localOnPluginInstallListener != null) && (!paramBoolean)) {
        break;
      }
      label70:
      try
      {
        localOnPluginInstallListener.onInstallFinish(paramString);
        return;
      }
      catch (RemoteException paramString) {}
    }
    try
    {
      localOnPluginInstallListener.onInstallError(paramString, 7);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void c(String paramString)
  {
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if ((localObject != null) && (((PluginInfo)localObject).mState == 1))
    {
      ((PluginInfo)localObject).mState = -1;
      ((PluginInfo)localObject).a = 0;
    }
    localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallError(paramString, 3);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void cancelInstall(String paramString)
  {
    String str = paramString;
    if (!PluginIdUtil.isQPluginId(paramString)) {
      str = PluginIdUtil.convertQShadowId2QPluginId(paramString);
    }
    this.jdField_a_of_type_CooperationPluginPluginDownloader.a(str);
    this.jdField_a_of_type_CooperationPluginPluginInstaller.b(str);
  }
  
  public void d(String paramString)
  {
    installPlugin(paramString, null);
  }
  
  public void e(String paramString)
  {
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localObject != null) {
      ((PluginInfo)localObject).mState = -2;
    }
    localObject = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallError(paramString, 6);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void f(String paramString)
  {
    paramString = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null) {
      paramString.mState = 3;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 65536: 
      a(paramMessage.getData().getString("index_for_id"), (IPluginManager.OnQueryPluginListener)paramMessage.obj);
      return true;
    case 66049: 
      e();
      return true;
    case 66304: 
      f();
      return true;
    }
    d();
    return true;
  }
  
  public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
  {
    a(paramString, false, false, paramOnPluginInstallListener);
  }
  
  public boolean isPlugininstalled(String paramString)
  {
    boolean bool2 = false;
    String str = paramString;
    if (!PluginIdUtil.isQPluginId(paramString)) {
      str = PluginIdUtil.convertQShadowId2QPluginId(paramString);
    }
    paramString = a(str);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.mState == 4)
      {
        bool1 = bool2;
        if (paramString.mInstalledPath != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isReady()
  {
    return this.c;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65537).sendToTarget();
    this.jdField_a_of_type_CooperationPluginPluginManagerV2$NetworkReceiver.b();
    ??? = PluginCommunicationHandler.getInstance();
    ((PluginCommunicationHandler)???).setCommunicationChannel(null);
    ((PluginCommunicationHandler)???).unregister("common.get_qq_app_interface_data");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public void setListener(RemotePluginManager paramRemotePluginManager) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2
 * JD-Core Version:    0.7.0.1
 */