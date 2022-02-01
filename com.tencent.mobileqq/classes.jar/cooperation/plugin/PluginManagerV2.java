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
import com.tencent.mobileqq.pluginsdk.PluginStatic;
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
  private ArrayList<PluginUpdater.OnPluginInfoUpdateListener> jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<String, PluginInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private ArrayList<PluginManagerV2.LaunchState> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<String, OnPluginInstallListener> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public PluginManagerV2(QQAppInterface paramQQAppInterface)
  {
    QLog.d("plugin_tag", 1, "init plugin manager");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    c();
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
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131708279));
      localStringBuilder.append(paramString);
      localStringBuilder.append("（");
      localStringBuilder.append(ByteUnitTransformUtil.a(paramLong));
      localStringBuilder.append(HardCodeUtil.a(2131708276));
      paramString = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("（");
      localStringBuilder.append(ByteUnitTransformUtil.a(paramLong));
      localStringBuilder.append(HardCodeUtil.a(2131708278));
      paramString = localStringBuilder.toString();
    }
    return new AlertDialog.Builder(paramContext).setMessage(paramString).setNegativeButton(HardCodeUtil.a(2131708277), paramOnClickListener2).setPositiveButton(HardCodeUtil.a(2131708281), paramOnClickListener1).create();
  }
  
  private static ProgressDialog a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new ReportProgressDialog(paramContext);
    paramContext.setProgressStyle(1);
    paramContext.setIndeterminate(false);
    paramContext.setTitle(paramString);
    paramContext.setMessage(HardCodeUtil.a(2131708280));
    paramContext.setCancelable(false);
    paramContext.setButton(-2, HardCodeUtil.a(2131708282), new PluginManagerV2.1(paramOnClickListener));
    return paramContext;
  }
  
  private void a(int paramInt, Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("doInstallAndLaunch. confirmCode, pluginId:");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(",");
    ((StringBuilder)localObject1).append(paramPluginParams.b);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(this.c);
    QLog.d("plugin_tag", 1, ((StringBuilder)localObject1).toString());
    if (!a(paramPluginParams))
    {
      if (paramOnPluginReadyListener != null) {
        paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
      }
      return;
    }
    if (paramInt == 0)
    {
      if (paramOnPluginReadyListener != null) {
        paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
      }
      return;
    }
    if (paramInt == 2)
    {
      if (paramOnPluginReadyListener != null)
      {
        localObject1 = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(paramPluginParams.b);
        if ((localObject1 != null) && (((PluginInfo)localObject1).mInstalledPath != null))
        {
          paramPluginParams.d = ((PluginInfo)localObject1).mInstalledPath;
          paramPluginParams.a((PluginBaseInfo)localObject1);
        }
        paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
        a(paramPluginParams);
      }
      return;
    }
    Object localObject2;
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
      localObject1 = this.jdField_a_of_type_CooperationPluginPluginUpdater.b((String)localObject2);
      if (localObject1 == null) {
        localObject1 = "";
      } else {
        localObject1 = ((PluginInfo)localObject1).mName;
      }
      PluginManagerV2.LaunchState localLaunchState = new PluginManagerV2.LaunchState();
      localLaunchState.jdField_a_of_type_AndroidContentContext = paramContext;
      localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
      localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
      localLaunchState.jdField_a_of_type_Boolean = false;
      localLaunchState.jdField_a_of_type_AndroidAppProgressDialog = a(paramContext, (String)localObject1, new PluginManagerV2.CancelDownloadClickListener(this, paramPluginParams.b, null));
      installPlugin((String)localObject2, new PluginManagerV2.PluginInstallForLaunch(this, localLaunchState));
      return;
    }
    if (paramInt == 3)
    {
      localObject1 = paramPluginParams.b;
      localObject2 = new PluginManagerV2.LaunchState();
      ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_AndroidContentContext = paramContext;
      ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
      ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
      ((PluginManagerV2.LaunchState)localObject2).jdField_a_of_type_Boolean = true;
      installPlugin((String)localObject1, new PluginManagerV2.PluginInstallForLaunch(this, (PluginManagerV2.LaunchState)localObject2));
    }
  }
  
  private void a(IPluginManager.PluginParams paramPluginParams)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 67328;
    localMessage.obj = paramPluginParams;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 2500L);
  }
  
  private void a(String paramString, IPluginManager.OnQueryPluginListener paramOnQueryPluginListener)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doQueryPlugin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramOnQueryPluginListener);
      QLog.d("plugin_tag", 2, ((StringBuilder)localObject).toString());
    }
    PluginInfo localPluginInfo = b(paramString);
    Object localObject = localPluginInfo;
    if (localPluginInfo != null) {
      localObject = localPluginInfo.a();
    }
    b();
    paramOnQueryPluginListener.a(paramString, (PluginInfo)localObject, this);
  }
  
  public static boolean a()
  {
    boolean bool1 = ((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.disable_dex2oat.name()) ^ true;
    boolean bool2 = bool1;
    if (bool1)
    {
      boolean bool3 = Dex2Oat.a();
      if ((bool1) && (bool3) && (Build.VERSION.SDK_INT >= 21)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isPluginSupportDex2Oat = ");
        localStringBuilder.append(bool1);
        localStringBuilder.append(", ");
        localStringBuilder.append(bool3);
        QLog.d("plugin_tag", 1, localStringBuilder.toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  private boolean a(IPluginManager.PluginParams paramPluginParams)
  {
    return (this.c) || (BuiltinPluginManager.b(paramPluginParams.b)) || (a(paramPluginParams.b));
  }
  
  private boolean a(String paramString)
  {
    paramString = a(paramString);
    boolean bool = false;
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
    paramString = new StringBuilder();
    paramString.append("isShadowAndHasInstalled ");
    paramString.append(bool);
    QLog.d("plugin_tag", 1, paramString.toString());
    return bool;
  }
  
  private PluginInfo b(String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fetchPlugin :");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("plugin_tag", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject2 == null)
    {
      PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(paramString);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("installed info :");
        ((StringBuilder)localObject1).append(localPluginInfo);
        QLog.d("plugin_tag", 2, ((StringBuilder)localObject1).toString());
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
    else
    {
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
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_a_of_type_CooperationPluginPluginUpdater.b(paramString);
    }
    return localObject2;
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
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "clearOldVersionPlugins");
    }
    File localFile1 = this.jdField_a_of_type_AndroidAppApplication.getDir("plugins", 0);
    File localFile2 = this.jdField_a_of_type_AndroidAppApplication.getDir("NetPlugins", 0);
    try
    {
      FileUtils.deleteDirectory(localFile1.getCanonicalPath());
      FileUtils.deleteDirectory(localFile2.getCanonicalPath());
      return;
    }
    catch (IOException localIOException) {}
  }
  
  private void c(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (paramPluginParams == null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkUpdate:");
    ((StringBuilder)localObject1).append(paramPluginParams.b);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(paramPluginParams.f);
    localObject1 = ((StringBuilder)localObject1).toString();
    boolean bool1 = true;
    QLog.d("plugin_tag", 1, (String)localObject1);
    if (!a(paramPluginParams))
    {
      if (paramOnPluginReadyListener != null) {
        paramOnPluginReadyListener.a(false, paramContext, paramPluginParams);
      }
      return;
    }
    String str2 = paramPluginParams.b;
    PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginPluginUpdater.b(str2);
    if (localPluginInfo == null)
    {
      a(0, paramContext, paramPluginParams, paramOnPluginReadyListener);
      return;
    }
    boolean bool3 = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(str2);
    boolean bool2 = QLog.isColorLevel();
    int j = 2;
    if (bool2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("installed :");
      ((StringBuilder)localObject1).append(bool3);
      QLog.d("plugin_tag", 2, ((StringBuilder)localObject1).toString());
    }
    String str1 = null;
    Object localObject2;
    if (bool3)
    {
      localObject2 = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(str2);
      bool2 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a((PluginInfo)localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("up to day :");
        ((StringBuilder)localObject1).append(bool2);
        QLog.d("plugin_tag", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = localObject2;
      if (bool2)
      {
        int i = j;
        if (a())
        {
          i = j;
          if (Dex2Oat.a(((PluginInfo)localObject2).mFingerPrint)) {
            if (PluginInfoUtil.a(localPluginInfo, this.jdField_a_of_type_AndroidAppApplication))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("systemOTA but running ");
              ((StringBuilder)localObject1).append(str2);
              QLog.d("plugin_tag", 1, ((StringBuilder)localObject1).toString());
              i = j;
            }
            else
            {
              i = 4;
              QLog.d("plugin_tag", 1, "systemOTA runDex2Oat");
            }
          }
        }
        a(i, paramContext, paramPluginParams, paramOnPluginReadyListener);
      }
    }
    else
    {
      localObject1 = null;
    }
    if ((PluginInfoUtil.a(localPluginInfo, this.jdField_a_of_type_AndroidAppApplication)) && (localObject1 != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
      if (paramOnPluginReadyListener != null)
      {
        paramPluginParams.d = ((PluginInfo)localObject1).mInstalledPath;
        paramPluginParams.a((PluginBaseInfo)localObject1);
        paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
        a(paramPluginParams);
      }
      return;
    }
    if ((localPluginInfo.mUpdateType == 0) && (bool3))
    {
      bool1 = false;
      bool2 = false;
    }
    else
    {
      if (localPluginInfo.mInstallType == 1) {
        bool1 = false;
      }
      bool2 = true;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("forceUpdate, deamonInstall：");
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(bool1);
      QLog.d("plugin_tag", 2, ((StringBuilder)localObject2).toString());
    }
    if (bool1)
    {
      a(3, paramContext, paramPluginParams, paramOnPluginReadyListener);
      return;
    }
    if (localObject1 != null) {
      str1 = ((PluginInfo)localObject1).mFingerPrint;
    }
    paramPluginParams = new PluginManagerV2.ConfirmDialogClickListener(this, paramOnPluginReadyListener, bool2, paramContext, paramPluginParams, bool3, str1, null);
    a(paramContext, localPluginInfo.mName, localPluginInfo.mLength, paramPluginParams, paramPluginParams, bool2).show();
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      PluginInfo localPluginInfo = (PluginInfo)localIterator.next();
      if ((localPluginInfo != null) && (localPluginInfo.mState == 1) && (localPluginInfo.startDownloadNetType == 1)) {
        cancelInstall(localPluginInfo.mID);
      }
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doClose");
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      this.jdField_b_of_type_Boolean = true;
      return;
    }
  }
  
  private void f()
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
      bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppApplication)) {
        a(false);
      } else {
        this.jdField_a_of_type_CooperationPluginPluginUpdater.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return;
    }
    finally {}
  }
  
  private void g()
  {
    if (NetworkState.isMobile())
    {
      d();
      return;
    }
    if ((NetworkState.isWifiConn()) && (this.c)) {
      this.jdField_a_of_type_CooperationPluginPluginPreInstaller.b();
    }
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
    if (!a(paramPluginParams))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "not ready");
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        PluginManagerV2.LaunchState localLaunchState;
        if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty())
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "mPendingLaunchStateList not empty");
          }
          localLaunchState = new PluginManagerV2.LaunchState();
          localLaunchState.jdField_a_of_type_AndroidContentContext = paramContext;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
          this.jdField_b_of_type_JavaUtilArrayList.add(localLaunchState);
          return;
        }
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          b();
          localLaunchState = new PluginManagerV2.LaunchState();
          localLaunchState.jdField_a_of_type_AndroidContentContext = paramContext;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
          localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
          this.jdField_b_of_type_JavaUtilArrayList.add(localLaunchState);
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "set mPendingLaunchStateList");
          }
          return;
        }
      }
    }
    c(paramContext, paramPluginParams, paramOnPluginReadyListener);
  }
  
  public void a(PluginInfo paramPluginInfo, OnPluginInstallListener paramOnPluginInstallListener)
  {
    if (paramPluginInfo == null)
    {
      QLog.e("plugin_tag", 1, "plugin info is null!");
      if (paramOnPluginInstallListener != null) {
        paramOnPluginInstallListener.onInstallError("plugin info is null", 1);
      }
      return;
    }
    QLog.d("plugin_tag", 1, "current version is not debug version!");
    if (paramOnPluginInstallListener != null) {
      paramOnPluginInstallListener.onInstallError("current version is not debug version!", 7);
    }
  }
  
  public void a(PluginUpdater.OnPluginInfoUpdateListener paramOnPluginInfoUpdateListener)
  {
    if (paramOnPluginInfoUpdateListener != null) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramOnPluginInfoUpdateListener);
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    ((PluginInfo)localObject).mState = -2;
    ((PluginInfo)localObject).installCode = 4;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dex2oatPlugin.");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("plugin_tag", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(paramString);
    if (localObject == null) {
      return;
    }
    if (PluginInfoUtil.a((PluginInfo)localObject, this.jdField_a_of_type_AndroidAppApplication))
    {
      paramOnPluginInstallListener = new StringBuilder();
      paramOnPluginInstallListener.append("dex2oatPlugin plugin still running ");
      paramOnPluginInstallListener.append(paramString);
      QLog.d("plugin_tag", 1, paramOnPluginInstallListener.toString());
      return;
    }
    if (paramOnPluginInstallListener != null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramOnPluginInstallListener);
    }
    ((PluginInfo)localObject).mState = 5;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
    this.jdField_a_of_type_CooperationPluginPluginInstaller.b((PluginInfo)localObject, this);
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
    paramString1 = new StringBuilder();
    paramString1.append("preDownloadPlugin.");
    paramString1.append(paramString2);
    QLog.d("plugin_tag", 1, paramString1.toString());
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2) != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(" task has already running!");
      QLog.w("plugin_tag", 1, paramString1.toString());
      return;
    }
    paramString1 = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(paramString2);
    if (this.jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(" is up to day!");
      QLog.i("plugin_tag", 1, paramString1.toString());
      if (paramOnPluginDownLoadListener != null) {
        paramOnPluginDownLoadListener.c(paramString2);
      }
      return;
    }
    paramString1 = this.jdField_a_of_type_CooperationPluginPluginUpdater.b(paramString2);
    if (paramString1 == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(" has no new version!");
      QLog.i("plugin_tag", 1, paramString1.toString());
      if (paramOnPluginDownLoadListener != null) {
        paramOnPluginDownLoadListener.c(paramString2);
      }
      return;
    }
    if (PluginInfoUtil.a(paramString1, this.jdField_a_of_type_AndroidAppApplication))
    {
      QLog.d("plugin_tag", 1, "plugin still running");
      if (paramOnPluginDownLoadListener != null) {
        paramOnPluginDownLoadListener.c(paramString2);
      }
      return;
    }
    PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(paramString2);
    if ((localPluginInfo != null) && (localPluginInfo.mState == 2) && (TextUtils.equals(localPluginInfo.mMD5, paramString1.mMD5)))
    {
      if (paramOnPluginDownLoadListener != null) {
        paramOnPluginDownLoadListener.a(true, paramString2);
      }
      return;
    }
    paramString1.mState = 5;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, paramString1);
    if (paramOnPluginDownLoadListener != null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, new PluginManagerV2.OnPluginDownLoadListenerTransfer(paramOnPluginDownLoadListener));
    }
    this.jdField_a_of_type_CooperationPluginPluginDownloader.a(paramString1, this, true);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" recordPluginStartupTime ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", key = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", span = ");
      localStringBuilder.append(paramLong);
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
    paramString1 = this.jdField_a_of_type_CooperationPluginPluginInstaller.a(paramString1);
    if (paramString1 != null)
    {
      if ("pluginApkCost".equals(paramString2))
      {
        paramString1.costApk = paramLong;
        return;
      }
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
      if ("pluginLibCost".equals(paramString2)) {
        paramString1.costLib = paramLong;
      }
    }
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, OnPluginInstallListener paramOnPluginInstallListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 5
    //   3: aload_1
    //   4: invokestatic 608	com/tencent/mobileqq/qshadow/utils/PluginIdUtil:isQPluginId	(Ljava/lang/String;)Z
    //   7: ifne +9 -> 16
    //   10: aload_1
    //   11: invokestatic 612	com/tencent/mobileqq/qshadow/utils/PluginIdUtil:convertQShadowId2QPluginId	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore 5
    //   16: new 189	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   23: astore_1
    //   24: aload_1
    //   25: ldc_w 746
    //   28: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_1
    //   33: aload 5
    //   35: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 51
    //   41: iconst_1
    //   42: aload_1
    //   43: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aconst_null
    //   50: astore_1
    //   51: iload_2
    //   52: ifeq +16 -> 68
    //   55: aload_0
    //   56: getfield 140	cooperation/plugin/PluginManagerV2:jdField_a_of_type_CooperationPluginBuiltinPluginManager	Lcooperation/plugin/BuiltinPluginManager;
    //   59: aload 5
    //   61: invokevirtual 472	cooperation/plugin/BuiltinPluginManager:a	(Ljava/lang/String;)Lcooperation/plugin/PluginInfo;
    //   64: astore_1
    //   65: goto +25 -> 90
    //   68: aload_0
    //   69: getfield 91	cooperation/plugin/PluginManagerV2:jdField_a_of_type_CooperationPluginPluginUpdater	Lcooperation/plugin/PluginUpdater;
    //   72: aload 5
    //   74: invokevirtual 338	cooperation/plugin/PluginUpdater:b	(Ljava/lang/String;)Lcooperation/plugin/PluginInfo;
    //   77: astore 6
    //   79: aload 6
    //   81: ifnull +9 -> 90
    //   84: aload 6
    //   86: invokevirtual 393	cooperation/plugin/PluginInfo:a	()Lcooperation/plugin/PluginInfo;
    //   89: astore_1
    //   90: aload_1
    //   91: ifnonnull +19 -> 110
    //   94: aload 4
    //   96: ifnull +13 -> 109
    //   99: aload 4
    //   101: aload 5
    //   103: iconst_1
    //   104: invokeinterface 653 3 0
    //   109: return
    //   110: aload_1
    //   111: aload_0
    //   112: getfield 69	cooperation/plugin/PluginManagerV2:jdField_a_of_type_AndroidAppApplication	Landroid/app/Application;
    //   115: invokestatic 511	cooperation/plugin/PluginInfoUtil:a	(Lcooperation/plugin/PluginInfo;Landroid/content/Context;)Z
    //   118: ifeq +28 -> 146
    //   121: ldc 51
    //   123: iconst_1
    //   124: ldc_w 517
    //   127: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload 4
    //   132: ifnull +13 -> 145
    //   135: aload 4
    //   137: aload 5
    //   139: iconst_2
    //   140: invokeinterface 653 3 0
    //   145: return
    //   146: aload_0
    //   147: getfield 129	cooperation/plugin/PluginManagerV2:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   150: aload 5
    //   152: invokevirtual 455	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: checkcast 303	cooperation/plugin/PluginInfo
    //   158: astore 6
    //   160: aload 6
    //   162: ifnull +198 -> 360
    //   165: aload 6
    //   167: getfield 447	cooperation/plugin/PluginInfo:mState	I
    //   170: iconst_3
    //   171: if_icmpne +189 -> 360
    //   174: aload_0
    //   175: getfield 69	cooperation/plugin/PluginManagerV2:jdField_a_of_type_AndroidAppApplication	Landroid/app/Application;
    //   178: ldc_w 748
    //   181: iconst_1
    //   182: invokestatic 753	com/tencent/mobileqq/utils/TripleGraySwitchUtil:b	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   185: ifne +175 -> 360
    //   188: new 189	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   195: astore_1
    //   196: aload_1
    //   197: ldc_w 755
    //   200: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_1
    //   205: aload 5
    //   207: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_1
    //   212: ldc_w 757
    //   215: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: ldc 51
    //   221: iconst_1
    //   222: aload_1
    //   223: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_0
    //   230: getfield 131	cooperation/plugin/PluginManagerV2:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   233: aload 5
    //   235: invokevirtual 455	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   238: checkcast 623	com/tencent/mobileqq/pluginsdk/OnPluginInstallListener
    //   241: astore_1
    //   242: aload 4
    //   244: ifnull +56 -> 300
    //   247: aload_1
    //   248: ifnull +52 -> 300
    //   251: new 189	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   258: astore 6
    //   260: aload 6
    //   262: ldc_w 759
    //   265: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 6
    //   271: aload 5
    //   273: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: ldc 51
    //   279: iconst_1
    //   280: aload 6
    //   282: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload_1
    //   289: aload 5
    //   291: iconst_3
    //   292: invokeinterface 653 3 0
    //   297: goto +3 -> 300
    //   300: aload 4
    //   302: ifnull +57 -> 359
    //   305: new 189	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   312: astore_1
    //   313: aload_1
    //   314: ldc_w 761
    //   317: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_1
    //   322: aload 5
    //   324: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: ldc 51
    //   330: iconst_1
    //   331: aload_1
    //   332: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: aload 4
    //   340: aload 5
    //   342: invokeinterface 764 2 0
    //   347: aload_0
    //   348: getfield 131	cooperation/plugin/PluginManagerV2:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   351: aload 5
    //   353: aload 4
    //   355: invokevirtual 666	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   358: pop
    //   359: return
    //   360: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +12 -> 375
    //   366: ldc 51
    //   368: iconst_2
    //   369: ldc_w 766
    //   372: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: aload 4
    //   377: ifnull +15 -> 392
    //   380: aload_0
    //   381: getfield 131	cooperation/plugin/PluginManagerV2:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   384: aload 5
    //   386: aload 4
    //   388: invokevirtual 666	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   391: pop
    //   392: aload_0
    //   393: getfield 124	cooperation/plugin/PluginManagerV2:jdField_a_of_type_CooperationPluginPluginInstaller	Lcooperation/plugin/PluginInstaller;
    //   396: aload 5
    //   398: invokevirtual 301	cooperation/plugin/PluginInstaller:a	(Ljava/lang/String;)Lcooperation/plugin/PluginInfo;
    //   401: astore 4
    //   403: aload 4
    //   405: ifnull +30 -> 435
    //   408: aload_0
    //   409: getfield 91	cooperation/plugin/PluginManagerV2:jdField_a_of_type_CooperationPluginPluginUpdater	Lcooperation/plugin/PluginUpdater;
    //   412: aload 4
    //   414: invokevirtual 460	cooperation/plugin/PluginUpdater:a	(Lcooperation/plugin/PluginInfo;)Z
    //   417: ifeq +18 -> 435
    //   420: aload 4
    //   422: getfield 447	cooperation/plugin/PluginInfo:mState	I
    //   425: iconst_2
    //   426: if_icmpne +9 -> 435
    //   429: aload 4
    //   431: astore_1
    //   432: goto +8 -> 440
    //   435: aload_1
    //   436: iconst_5
    //   437: putfield 447	cooperation/plugin/PluginInfo:mState	I
    //   440: aload_0
    //   441: getfield 129	cooperation/plugin/PluginManagerV2:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   444: aload 5
    //   446: aload_1
    //   447: invokevirtual 666	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   450: pop
    //   451: aload_0
    //   452: aload 5
    //   454: invokespecial 767	cooperation/plugin/PluginManagerV2:b	(Ljava/lang/String;)Z
    //   457: ifne +29 -> 486
    //   460: iload_2
    //   461: ifne +25 -> 486
    //   464: aload_1
    //   465: getfield 447	cooperation/plugin/PluginInfo:mState	I
    //   468: iconst_2
    //   469: if_icmpne +6 -> 475
    //   472: goto +14 -> 486
    //   475: aload_0
    //   476: getfield 108	cooperation/plugin/PluginManagerV2:jdField_a_of_type_CooperationPluginPluginDownloader	Lcooperation/plugin/PluginDownloader;
    //   479: aload_1
    //   480: aload_0
    //   481: iload_3
    //   482: invokevirtual 710	cooperation/plugin/PluginDownloader:a	(Lcooperation/plugin/PluginInfo;Lcooperation/plugin/PluginDownloader$OnPluginDownLoadListener;Z)V
    //   485: return
    //   486: aload_0
    //   487: getfield 124	cooperation/plugin/PluginManagerV2:jdField_a_of_type_CooperationPluginPluginInstaller	Lcooperation/plugin/PluginInstaller;
    //   490: aload_1
    //   491: aload_0
    //   492: invokevirtual 769	cooperation/plugin/PluginInstaller:a	(Lcooperation/plugin/PluginInfo;Lcooperation/plugin/PluginInstaller$OnPluginSetupListener;)V
    //   495: return
    //   496: astore_1
    //   497: return
    //   498: astore_1
    //   499: return
    //   500: astore_1
    //   501: goto -201 -> 300
    //   504: astore_1
    //   505: goto -158 -> 347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	508	0	this	PluginManagerV2
    //   0	508	1	paramString	String
    //   0	508	2	paramBoolean1	boolean
    //   0	508	3	paramBoolean2	boolean
    //   0	508	4	paramOnPluginInstallListener	OnPluginInstallListener
    //   1	452	5	str	String
    //   77	204	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   99	109	496	android/os/RemoteException
    //   135	145	498	android/os/RemoteException
    //   251	297	500	android/os/RemoteException
    //   305	347	504	android/os/RemoteException
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = true;
    if (!paramBoolean) {
      this.jdField_a_of_type_Boolean = false;
    } else {
      this.jdField_a_of_type_CooperationPluginPluginPreInstaller.a();
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator;
      if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "onUpdateFinish. handle pending");
        }
        localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          PluginManagerV2.LaunchState localLaunchState = (PluginManagerV2.LaunchState)localIterator.next();
          c(localLaunchState.jdField_a_of_type_AndroidContentContext, localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, localLaunchState.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener);
        }
        this.jdField_b_of_type_JavaUtilArrayList.clear();
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("plugin_tag", 2, "mPendingLaunchStateList empty");
      }
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((PluginUpdater.OnPluginInfoUpdateListener)localIterator.next()).a(paramBoolean);
        }
        return;
      }
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onDownloadFinish:");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.d("plugin_tag", 1, ((StringBuilder)localObject1).toString());
    localObject1 = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 != null)
    {
      if ((((PluginInfo)localObject1).downloadDuration != 0L) && (!(this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) instanceof PluginManagerV2.OnPluginDownLoadListenerTransfer))) {
        ((PluginInfo)localObject1).downloadDuration = (System.currentTimeMillis() - ((PluginInfo)localObject1).downloadDuration);
      }
      if (paramBoolean)
      {
        ((PluginInfo)localObject1).mState = 2;
        ((PluginInfo)localObject1).mDownloadProgress = 1.0F;
        if ((PluginUpdater.a(this.jdField_a_of_type_AndroidAppApplication)) && (this.jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString) != null))
        {
          localObject2 = this.jdField_a_of_type_CooperationPluginPluginUpdater.a(paramString);
          File localFile = new File(PluginDownloader.a(this.jdField_a_of_type_AndroidAppApplication), ((PluginInfo)localObject1).mID);
          ((PluginInfo)localObject2).mLength = localFile.length();
          ((PluginInfo)localObject2).mMD5 = PluginStatic.encodeFile(localFile.getAbsolutePath());
          this.jdField_a_of_type_CooperationPluginPluginUpdater.a((PluginInfo)localObject2);
        }
        if (!(this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) instanceof PluginManagerV2.OnPluginDownLoadListenerTransfer)) {}
      }
    }
    try
    {
      localObject2 = (PluginManagerV2.OnPluginDownLoadListenerTransfer)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      if (localObject2 != null) {
        ((PluginManagerV2.OnPluginDownLoadListenerTransfer)localObject2).onInstallFinish(paramString);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      this.jdField_a_of_type_CooperationPluginPluginInstaller.b((PluginInfo)localObject1);
      return;
    }
    catch (RemoteException paramString) {}
    if (!TripleGraySwitchUtil.b(this.jdField_a_of_type_AndroidAppApplication, "KEY_DISABLE_SAVE_PLUGIN_INFO", true))
    {
      paramString = new StringBuilder();
      paramString.append("download finish, save plugin info, state: ");
      paramString.append(((PluginInfo)localObject1).mState);
      QLog.d("plugin_tag", 1, paramString.toString());
      this.jdField_a_of_type_CooperationPluginPluginInstaller.b((PluginInfo)localObject1);
    }
    this.jdField_a_of_type_CooperationPluginPluginInstaller.a((PluginInfo)localObject1, this);
    return;
    ((PluginInfo)localObject1).mState = -2;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    Object localObject2 = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    ((PluginInfo)localObject1).installCode = 5;
    if (localObject2 != null) {
      ((OnPluginInstallListener)localObject2).onInstallError(paramString, 5);
    }
    return;
  }
  
  public boolean a(PluginInfo paramPluginInfo)
  {
    this.jdField_a_of_type_CooperationPluginPluginDownloader.a(paramPluginInfo.mID);
    boolean bool = this.jdField_a_of_type_CooperationPluginPluginInstaller.b(paramPluginInfo.mID);
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((PluginUpdater.OnPluginInfoUpdateListener)localIterator.next()).a(paramPluginInfo);
      }
      return bool;
    }
    for (;;)
    {
      throw paramPluginInfo;
    }
  }
  
  public void b()
  {
    QLog.d("plugin_tag", 1, "current version is not debug version!");
  }
  
  public void b(PluginUpdater.OnPluginInfoUpdateListener paramOnPluginInfoUpdateListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramOnPluginInfoUpdateListener);
      return;
    }
  }
  
  public void b(String paramString)
  {
    PluginInfo localPluginInfo = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    OnPluginInstallListener localOnPluginInstallListener = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localPluginInfo != null)
    {
      localPluginInfo.mState = 1;
      localPluginInfo.startDownloadNetType = NetworkState.getNetworkType();
      localPluginInfo.installCode = 0;
      if (!(localOnPluginInstallListener instanceof PluginManagerV2.OnPluginDownLoadListenerTransfer)) {
        localPluginInfo.downloadDuration = System.currentTimeMillis();
      }
    }
    if (localOnPluginInstallListener != null) {}
    try
    {
      localOnPluginInstallListener.onInstallBegin(paramString);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    OnPluginInstallListener localOnPluginInstallListener = (OnPluginInstallListener)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    PluginInfo localPluginInfo = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localPluginInfo != null)
    {
      int i;
      if (paramBoolean) {
        i = 4;
      } else {
        i = -2;
      }
      localPluginInfo.mState = i;
    }
    if ((localOnPluginInstallListener == null) || (paramBoolean)) {}
    try
    {
      localOnPluginInstallListener.onInstallFinish(paramString);
      return;
    }
    catch (RemoteException paramString) {}
    localOnPluginInstallListener.onInstallError(paramString, 7);
    return;
  }
  
  public void c(String paramString)
  {
    Object localObject = (PluginInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if ((localObject != null) && (((PluginInfo)localObject).mState == 1))
    {
      ((PluginInfo)localObject).mState = -1;
      ((PluginInfo)localObject).installCode = 3;
      ((PluginInfo)localObject).downloadDuration = 0L;
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
    if (localObject != null)
    {
      ((PluginInfo)localObject).mState = -2;
      ((PluginInfo)localObject).installCode = 4;
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
    case 67328: 
      PluginReporter.a((IPluginManager.PluginParams)paramMessage.obj);
      return true;
    case 66304: 
      g();
      return true;
    case 66049: 
      f();
      return true;
    case 65537: 
      e();
      return true;
    }
    a(paramMessage.getData().getString("index_for_id"), (IPluginManager.OnQueryPluginListener)paramMessage.obj);
    return true;
  }
  
  public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
  {
    a(paramString, false, false, paramOnPluginInstallListener);
  }
  
  public boolean isPlugininstalled(String paramString)
  {
    String str = paramString;
    if (!PluginIdUtil.isQPluginId(paramString)) {
      str = PluginIdUtil.convertQShadowId2QPluginId(paramString);
    }
    paramString = a(str);
    boolean bool2 = false;
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
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public void setListener(RemotePluginManager paramRemotePluginManager) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2
 * JD-Core Version:    0.7.0.1
 */