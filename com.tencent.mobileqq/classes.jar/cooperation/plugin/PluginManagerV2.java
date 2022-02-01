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
  private PluginInstaller b;
  private PluginPreInstaller c;
  private PluginUpdater d;
  private PluginDownloader e;
  private BuiltinPluginManager f;
  private ConcurrentHashMap<String, PluginInfo> g;
  private ConcurrentHashMap<String, OnPluginInstallListener> h;
  private ArrayList<PluginUpdater.OnPluginInfoUpdateListener> i;
  private volatile boolean j;
  private boolean k;
  private ArrayList<PluginManagerV2.LaunchState> l = new ArrayList();
  private Object m = new Object();
  private boolean n;
  private Handler o;
  private QQAppInterface p;
  private Application q;
  private PluginManagerV2.NetworkReceiver r;
  
  public PluginManagerV2(QQAppInterface paramQQAppInterface)
  {
    QLog.d("plugin_tag", 1, "init plugin manager");
    this.p = paramQQAppInterface;
    this.q = this.p.getApp();
    this.o = new Handler(ThreadManager.getSubThreadLooper(), this);
    g();
    this.d = new PluginUpdater(this.q, this.o);
    this.c = new PluginPreInstaller(this.q, this, this.p);
    this.d.a(this);
    this.e = new PluginDownloader(this.q, this.p);
    try
    {
      this.b = new PluginInstaller(this.q, PluginDownloader.a(this.q).getCanonicalPath());
      label160:
      this.g = new ConcurrentHashMap();
      this.h = new ConcurrentHashMap();
      this.i = new ArrayList();
      this.f = BuiltinPluginManager.a(this.q);
      this.r = new PluginManagerV2.NetworkReceiver(this);
      this.r.a();
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      localPluginCommunicationHandler.setCommunicationChannel(new QQPluginCommunicationChannel());
      localPluginCommunicationHandler.register(new GetQQAppInterfaceDataRemoteCommand(paramQQAppInterface));
      paramQQAppInterface = PluginManageHandler.getInstance();
      if (this.p.isLogin()) {
        paramQQAppInterface.setPluginManagerProvider(this.p, false);
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
      localStringBuilder.append(HardCodeUtil.a(2131906071));
      localStringBuilder.append(paramString);
      localStringBuilder.append("（");
      localStringBuilder.append(ByteUnitTransformUtil.a(paramLong));
      localStringBuilder.append(HardCodeUtil.a(2131906069));
      paramString = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("（");
      localStringBuilder.append(ByteUnitTransformUtil.a(paramLong));
      localStringBuilder.append(HardCodeUtil.a(2131906070));
      paramString = localStringBuilder.toString();
    }
    return new AlertDialog.Builder(paramContext).setMessage(paramString).setNegativeButton(HardCodeUtil.a(2131898212), paramOnClickListener2).setPositiveButton(HardCodeUtil.a(2131906073), paramOnClickListener1).create();
  }
  
  private static ProgressDialog a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new ReportProgressDialog(paramContext);
    paramContext.setProgressStyle(1);
    paramContext.setIndeterminate(false);
    paramContext.setTitle(paramString);
    paramContext.setMessage(HardCodeUtil.a(2131906072));
    paramContext.setCancelable(false);
    paramContext.setButton(-2, HardCodeUtil.a(2131898212), new PluginManagerV2.1(paramOnClickListener));
    return paramContext;
  }
  
  private void a(int paramInt, Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("doInstallAndLaunch. confirmCode, pluginId:");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(",");
    ((StringBuilder)localObject1).append(paramPluginParams.d);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(this.n);
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
        localObject1 = this.b.c(paramPluginParams.d);
        if ((localObject1 != null) && (((PluginInfo)localObject1).mInstalledPath != null))
        {
          paramPluginParams.f = ((PluginInfo)localObject1).mInstalledPath;
          paramPluginParams.a((PluginBaseInfo)localObject1);
        }
        paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
        b(paramPluginParams);
      }
      return;
    }
    Object localObject2;
    if (paramInt == 4)
    {
      localObject1 = paramPluginParams.d;
      localObject2 = new PluginManagerV2.LaunchState();
      ((PluginManagerV2.LaunchState)localObject2).a = paramContext;
      ((PluginManagerV2.LaunchState)localObject2).c = paramPluginParams;
      ((PluginManagerV2.LaunchState)localObject2).d = paramOnPluginReadyListener;
      ((PluginManagerV2.LaunchState)localObject2).b = true;
      a((String)localObject1, new PluginManagerV2.PluginInstallForLaunch(this, (PluginManagerV2.LaunchState)localObject2));
      return;
    }
    if (paramInt == 1)
    {
      localObject2 = paramPluginParams.d;
      localObject1 = this.d.b((String)localObject2);
      if (localObject1 == null) {
        localObject1 = "";
      } else {
        localObject1 = ((PluginInfo)localObject1).mName;
      }
      PluginManagerV2.LaunchState localLaunchState = new PluginManagerV2.LaunchState();
      localLaunchState.a = paramContext;
      localLaunchState.c = paramPluginParams;
      localLaunchState.d = paramOnPluginReadyListener;
      localLaunchState.b = false;
      localLaunchState.e = a(paramContext, (String)localObject1, new PluginManagerV2.CancelDownloadClickListener(this, paramPluginParams.d, null));
      installPlugin((String)localObject2, new PluginManagerV2.PluginInstallForLaunch(this, localLaunchState));
      return;
    }
    if (paramInt == 3)
    {
      localObject1 = paramPluginParams.d;
      localObject2 = new PluginManagerV2.LaunchState();
      ((PluginManagerV2.LaunchState)localObject2).a = paramContext;
      ((PluginManagerV2.LaunchState)localObject2).c = paramPluginParams;
      ((PluginManagerV2.LaunchState)localObject2).d = paramOnPluginReadyListener;
      ((PluginManagerV2.LaunchState)localObject2).b = true;
      installPlugin((String)localObject1, new PluginManagerV2.PluginInstallForLaunch(this, (PluginManagerV2.LaunchState)localObject2));
    }
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
    PluginInfo localPluginInfo = h(paramString);
    Object localObject = localPluginInfo;
    if (localPluginInfo != null) {
      localObject = localPluginInfo.a();
    }
    f();
    paramOnQueryPluginListener.a(paramString, (PluginInfo)localObject, this);
  }
  
  private boolean a(IPluginManager.PluginParams paramPluginParams)
  {
    return (this.n) || (BuiltinPluginManager.c(paramPluginParams.d)) || (i(paramPluginParams.d));
  }
  
  private void b(IPluginManager.PluginParams paramPluginParams)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 67328;
    localMessage.obj = paramPluginParams;
    this.o.sendMessageDelayed(localMessage, 2500L);
  }
  
  private void c(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (paramPluginParams == null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkUpdate:");
    ((StringBuilder)localObject1).append(paramPluginParams.d);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(paramPluginParams.h);
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
    String str2 = paramPluginParams.d;
    PluginInfo localPluginInfo = this.d.b(str2);
    if (localPluginInfo == null)
    {
      a(0, paramContext, paramPluginParams, paramOnPluginReadyListener);
      return;
    }
    boolean bool3 = this.b.a(str2);
    boolean bool2 = QLog.isColorLevel();
    int i2 = 2;
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
      localObject2 = this.b.c(str2);
      bool2 = this.d.b((PluginInfo)localObject2);
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
        int i1 = i2;
        if (e())
        {
          i1 = i2;
          if (Dex2Oat.a(((PluginInfo)localObject2).mFingerPrint)) {
            if (PluginInfoUtil.a(localPluginInfo, this.q))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("systemOTA but running ");
              ((StringBuilder)localObject1).append(str2);
              QLog.d("plugin_tag", 1, ((StringBuilder)localObject1).toString());
              i1 = i2;
            }
            else
            {
              i1 = 4;
              QLog.d("plugin_tag", 1, "systemOTA runDex2Oat");
            }
          }
        }
        a(i1, paramContext, paramPluginParams, paramOnPluginReadyListener);
      }
    }
    else
    {
      localObject1 = null;
    }
    if ((PluginInfoUtil.a(localPluginInfo, this.q)) && (localObject1 != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "plugin still running");
      }
      if (paramOnPluginReadyListener != null)
      {
        paramPluginParams.f = ((PluginInfo)localObject1).mInstalledPath;
        paramPluginParams.a((PluginBaseInfo)localObject1);
        paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
        b(paramPluginParams);
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
  
  public static boolean e()
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
  
  private boolean f()
  {
    if (!this.j)
    {
      this.o.sendEmptyMessage(66049);
      return true;
    }
    return false;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "clearOldVersionPlugins");
    }
    File localFile1 = this.q.getDir("plugins", 0);
    File localFile2 = this.q.getDir("NetPlugins", 0);
    try
    {
      FileUtils.deleteDirectory(localFile1.getCanonicalPath());
      FileUtils.deleteDirectory(localFile2.getCanonicalPath());
      return;
    }
    catch (IOException localIOException) {}
  }
  
  private PluginInfo h(String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fetchPlugin :");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("plugin_tag", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (PluginInfo)this.g.get(paramString);
    if (localObject2 == null)
    {
      PluginInfo localPluginInfo = this.b.c(paramString);
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
        if (this.d.b(localPluginInfo))
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
      int i1 = ((PluginInfo)localObject2).mState;
      if ((i1 != -1) && (i1 != 4))
      {
        localObject1 = localObject2;
        if (i1 != -2) {}
      }
      else
      {
        this.g.remove(paramString);
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.d.b(paramString);
    }
    return localObject2;
  }
  
  private void h()
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext())
    {
      PluginInfo localPluginInfo = (PluginInfo)localIterator.next();
      if ((localPluginInfo != null) && (localPluginInfo.mState == 1) && (localPluginInfo.startDownloadNetType == 1)) {
        cancelInstall(localPluginInfo.mID);
      }
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doClose");
    }
    this.g.clear();
    synchronized (this.i)
    {
      this.i.clear();
      this.p = null;
      this.k = true;
      return;
    }
  }
  
  private boolean i(String paramString)
  {
    paramString = d(paramString);
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
  
  private void j()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "getPluginList");
      }
      boolean bool = this.k;
      if (bool) {
        return;
      }
      bool = this.j;
      if (bool) {
        return;
      }
      this.j = true;
      if (!NetworkUtil.isNetworkAvailable(this.q)) {
        a(false);
      } else {
        this.d.a(this.p);
      }
      return;
    }
    finally {}
  }
  
  private boolean j(String paramString)
  {
    paramString = this.f.a(paramString);
    if (paramString == null) {
      return false;
    }
    return this.d.b(paramString);
  }
  
  private void k()
  {
    if (NetworkState.isMobile())
    {
      h();
      return;
    }
    if ((NetworkState.isWifiConn()) && (this.n)) {
      this.c.b();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "setReadyToNetworking");
    }
    f();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = (PluginInfo)this.g.get(paramString);
    if ((localObject != null) && (((PluginInfo)localObject).mState == 1) && (paramInt2 > 0)) {
      ((PluginInfo)localObject).mDownloadProgress = (paramInt1 / paramInt2);
    }
    localObject = (OnPluginInstallListener)this.h.get(paramString);
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
      synchronized (this.m)
      {
        PluginManagerV2.LaunchState localLaunchState;
        if (!this.l.isEmpty())
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "mPendingLaunchStateList not empty");
          }
          localLaunchState = new PluginManagerV2.LaunchState();
          localLaunchState.a = paramContext;
          localLaunchState.c = paramPluginParams;
          localLaunchState.d = paramOnPluginReadyListener;
          this.l.add(localLaunchState);
          return;
        }
        synchronized (this.m)
        {
          f();
          localLaunchState = new PluginManagerV2.LaunchState();
          localLaunchState.a = paramContext;
          localLaunchState.c = paramPluginParams;
          localLaunchState.d = paramOnPluginReadyListener;
          this.l.add(localLaunchState);
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
      synchronized (this.i)
      {
        this.i.add(paramOnPluginInfoUpdateListener);
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = (PluginInfo)this.g.get(paramString);
    this.g.remove(paramString);
    ((PluginInfo)localObject).mState = -2;
    ((PluginInfo)localObject).installCode = 4;
    localObject = (OnPluginInstallListener)this.h.remove(paramString);
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
    localObject = this.b.c(paramString);
    if (localObject == null) {
      return;
    }
    if (PluginInfoUtil.a((PluginInfo)localObject, this.q))
    {
      paramOnPluginInstallListener = new StringBuilder();
      paramOnPluginInstallListener.append("dex2oatPlugin plugin still running ");
      paramOnPluginInstallListener.append(paramString);
      QLog.d("plugin_tag", 1, paramOnPluginInstallListener.toString());
      return;
    }
    if (paramOnPluginInstallListener != null) {
      this.h.put(paramString, paramOnPluginInstallListener);
    }
    ((PluginInfo)localObject).mState = 5;
    this.g.put(paramString, localObject);
    this.b.c((PluginInfo)localObject, this);
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
    if (this.g.get(paramString2) != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(" task has already running!");
      QLog.w("plugin_tag", 1, paramString1.toString());
      return;
    }
    paramString1 = this.b.c(paramString2);
    if (this.d.b(paramString1))
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
    paramString1 = this.d.b(paramString2);
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
    if (PluginInfoUtil.a(paramString1, this.q))
    {
      QLog.d("plugin_tag", 1, "plugin still running");
      if (paramOnPluginDownLoadListener != null) {
        paramOnPluginDownLoadListener.c(paramString2);
      }
      return;
    }
    PluginInfo localPluginInfo = this.b.c(paramString2);
    if ((localPluginInfo != null) && (localPluginInfo.mState == 2) && (TextUtils.equals(localPluginInfo.mMD5, paramString1.mMD5)))
    {
      if (paramOnPluginDownLoadListener != null) {
        paramOnPluginDownLoadListener.a(true, paramString2);
      }
      return;
    }
    paramString1.mState = 5;
    this.g.put(paramString2, paramString1);
    if (paramOnPluginDownLoadListener != null) {
      this.h.put(paramString2, new PluginManagerV2.OnPluginDownLoadListenerTransfer(paramOnPluginDownLoadListener));
    }
    this.e.a(paramString1, this, true);
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
    paramString1 = this.b.c(paramString1);
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
    //   4: invokestatic 686	com/tencent/mobileqq/qshadow/utils/PluginIdUtil:isQPluginId	(Ljava/lang/String;)Z
    //   7: ifne +9 -> 16
    //   10: aload_1
    //   11: invokestatic 690	com/tencent/mobileqq/qshadow/utils/PluginIdUtil:convertQShadowId2QPluginId	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore 5
    //   16: new 203	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   23: astore_1
    //   24: aload_1
    //   25: ldc_w 761
    //   28: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_1
    //   33: aload 5
    //   35: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 65
    //   41: iconst_1
    //   42: aload_1
    //   43: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aconst_null
    //   50: astore_1
    //   51: iload_2
    //   52: ifeq +16 -> 68
    //   55: aload_0
    //   56: getfield 154	cooperation/plugin/PluginManagerV2:f	Lcooperation/plugin/BuiltinPluginManager;
    //   59: aload 5
    //   61: invokevirtual 607	cooperation/plugin/BuiltinPluginManager:a	(Ljava/lang/String;)Lcooperation/plugin/PluginInfo;
    //   64: astore_1
    //   65: goto +25 -> 90
    //   68: aload_0
    //   69: getfield 104	cooperation/plugin/PluginManagerV2:d	Lcooperation/plugin/PluginUpdater;
    //   72: aload 5
    //   74: invokevirtual 350	cooperation/plugin/PluginUpdater:b	(Ljava/lang/String;)Lcooperation/plugin/PluginInfo;
    //   77: astore 6
    //   79: aload 6
    //   81: ifnull +9 -> 90
    //   84: aload 6
    //   86: invokevirtual 386	cooperation/plugin/PluginInfo:a	()Lcooperation/plugin/PluginInfo;
    //   89: astore_1
    //   90: aload_1
    //   91: ifnonnull +19 -> 110
    //   94: aload 4
    //   96: ifnull +13 -> 109
    //   99: aload 4
    //   101: aload 5
    //   103: iconst_1
    //   104: invokeinterface 660 3 0
    //   109: return
    //   110: aload_1
    //   111: aload_0
    //   112: getfield 82	cooperation/plugin/PluginManagerV2:q	Landroid/app/Application;
    //   115: invokestatic 446	cooperation/plugin/PluginInfoUtil:a	(Lcooperation/plugin/PluginInfo;Landroid/content/Context;)Z
    //   118: ifeq +28 -> 146
    //   121: ldc 65
    //   123: iconst_1
    //   124: ldc_w 452
    //   127: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload 4
    //   132: ifnull +13 -> 145
    //   135: aload 4
    //   137: aload 5
    //   139: iconst_2
    //   140: invokeinterface 660 3 0
    //   145: return
    //   146: aload_0
    //   147: getfield 143	cooperation/plugin/PluginManagerV2:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   150: aload 5
    //   152: invokevirtual 536	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: checkcast 315	cooperation/plugin/PluginInfo
    //   158: astore 6
    //   160: aload 6
    //   162: ifnull +198 -> 360
    //   165: aload 6
    //   167: getfield 543	cooperation/plugin/PluginInfo:mState	I
    //   170: iconst_3
    //   171: if_icmpne +189 -> 360
    //   174: aload_0
    //   175: getfield 82	cooperation/plugin/PluginManagerV2:q	Landroid/app/Application;
    //   178: ldc_w 763
    //   181: iconst_1
    //   182: invokestatic 768	com/tencent/mobileqq/utils/TripleGraySwitchUtil:b	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   185: ifne +175 -> 360
    //   188: new 203	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   195: astore_1
    //   196: aload_1
    //   197: ldc_w 770
    //   200: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_1
    //   205: aload 5
    //   207: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_1
    //   212: ldc_w 772
    //   215: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: ldc 65
    //   221: iconst_1
    //   222: aload_1
    //   223: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_0
    //   230: getfield 145	cooperation/plugin/PluginManagerV2:h	Ljava/util/concurrent/ConcurrentHashMap;
    //   233: aload 5
    //   235: invokevirtual 536	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   238: checkcast 630	com/tencent/mobileqq/pluginsdk/OnPluginInstallListener
    //   241: astore_1
    //   242: aload 4
    //   244: ifnull +56 -> 300
    //   247: aload_1
    //   248: ifnull +52 -> 300
    //   251: new 203	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   258: astore 6
    //   260: aload 6
    //   262: ldc_w 774
    //   265: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 6
    //   271: aload 5
    //   273: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: ldc 65
    //   279: iconst_1
    //   280: aload 6
    //   282: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload_1
    //   289: aload 5
    //   291: iconst_3
    //   292: invokeinterface 660 3 0
    //   297: goto +3 -> 300
    //   300: aload 4
    //   302: ifnull +57 -> 359
    //   305: new 203	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   312: astore_1
    //   313: aload_1
    //   314: ldc_w 776
    //   317: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_1
    //   322: aload 5
    //   324: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: ldc 65
    //   330: iconst_1
    //   331: aload_1
    //   332: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: aload 4
    //   340: aload 5
    //   342: invokeinterface 779 2 0
    //   347: aload_0
    //   348: getfield 145	cooperation/plugin/PluginManagerV2:h	Ljava/util/concurrent/ConcurrentHashMap;
    //   351: aload 5
    //   353: aload 4
    //   355: invokevirtual 673	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   358: pop
    //   359: return
    //   360: invokestatic 376	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +12 -> 375
    //   366: ldc 65
    //   368: iconst_2
    //   369: ldc_w 781
    //   372: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: aload 4
    //   377: ifnull +15 -> 392
    //   380: aload_0
    //   381: getfield 145	cooperation/plugin/PluginManagerV2:h	Ljava/util/concurrent/ConcurrentHashMap;
    //   384: aload 5
    //   386: aload 4
    //   388: invokevirtual 673	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   391: pop
    //   392: aload_0
    //   393: getfield 138	cooperation/plugin/PluginManagerV2:b	Lcooperation/plugin/PluginInstaller;
    //   396: aload 5
    //   398: invokevirtual 313	cooperation/plugin/PluginInstaller:c	(Ljava/lang/String;)Lcooperation/plugin/PluginInfo;
    //   401: astore 4
    //   403: aload 4
    //   405: ifnull +30 -> 435
    //   408: aload_0
    //   409: getfield 104	cooperation/plugin/PluginManagerV2:d	Lcooperation/plugin/PluginUpdater;
    //   412: aload 4
    //   414: invokevirtual 431	cooperation/plugin/PluginUpdater:b	(Lcooperation/plugin/PluginInfo;)Z
    //   417: ifeq +18 -> 435
    //   420: aload 4
    //   422: getfield 543	cooperation/plugin/PluginInfo:mState	I
    //   425: iconst_2
    //   426: if_icmpne +9 -> 435
    //   429: aload 4
    //   431: astore_1
    //   432: goto +8 -> 440
    //   435: aload_1
    //   436: iconst_5
    //   437: putfield 543	cooperation/plugin/PluginInfo:mState	I
    //   440: aload_0
    //   441: getfield 143	cooperation/plugin/PluginManagerV2:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   444: aload 5
    //   446: aload_1
    //   447: invokevirtual 673	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   450: pop
    //   451: aload_0
    //   452: aload 5
    //   454: invokespecial 783	cooperation/plugin/PluginManagerV2:j	(Ljava/lang/String;)Z
    //   457: ifne +29 -> 486
    //   460: iload_2
    //   461: ifne +25 -> 486
    //   464: aload_1
    //   465: getfield 543	cooperation/plugin/PluginInfo:mState	I
    //   468: iconst_2
    //   469: if_icmpne +6 -> 475
    //   472: goto +14 -> 486
    //   475: aload_0
    //   476: getfield 122	cooperation/plugin/PluginManagerV2:e	Lcooperation/plugin/PluginDownloader;
    //   479: aload_1
    //   480: aload_0
    //   481: iload_3
    //   482: invokevirtual 725	cooperation/plugin/PluginDownloader:a	(Lcooperation/plugin/PluginInfo;Lcooperation/plugin/PluginDownloader$OnPluginDownLoadListener;Z)V
    //   485: return
    //   486: aload_0
    //   487: getfield 138	cooperation/plugin/PluginManagerV2:b	Lcooperation/plugin/PluginInstaller;
    //   490: aload_1
    //   491: aload_0
    //   492: invokevirtual 785	cooperation/plugin/PluginInstaller:a	(Lcooperation/plugin/PluginInfo;Lcooperation/plugin/PluginInstaller$OnPluginSetupListener;)V
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
    this.n = true;
    if (!paramBoolean) {
      this.j = false;
    } else {
      this.c.a();
    }
    synchronized (this.m)
    {
      Iterator localIterator;
      if (!this.l.isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "onUpdateFinish. handle pending");
        }
        localIterator = this.l.iterator();
        while (localIterator.hasNext())
        {
          PluginManagerV2.LaunchState localLaunchState = (PluginManagerV2.LaunchState)localIterator.next();
          c(localLaunchState.a, localLaunchState.c, localLaunchState.d);
        }
        this.l.clear();
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("plugin_tag", 2, "mPendingLaunchStateList empty");
      }
      synchronized (this.i)
      {
        localIterator = this.i.iterator();
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
    localObject1 = (PluginInfo)this.g.get(paramString);
    if (localObject1 != null)
    {
      if ((((PluginInfo)localObject1).downloadDuration != 0L) && (!(this.h.get(paramString) instanceof PluginManagerV2.OnPluginDownLoadListenerTransfer))) {
        ((PluginInfo)localObject1).downloadDuration = (System.currentTimeMillis() - ((PluginInfo)localObject1).downloadDuration);
      }
      if (paramBoolean)
      {
        ((PluginInfo)localObject1).mState = 2;
        ((PluginInfo)localObject1).mDownloadProgress = 1.0F;
        if ((PluginUpdater.b(this.q)) && (this.d.a(paramString) != null))
        {
          localObject2 = this.d.a(paramString);
          File localFile = new File(PluginDownloader.a(this.q), ((PluginInfo)localObject1).mID);
          ((PluginInfo)localObject2).mLength = localFile.length();
          ((PluginInfo)localObject2).mMD5 = PluginStatic.encodeFile(localFile.getAbsolutePath());
          this.d.a((PluginInfo)localObject2);
        }
        if (!(this.h.get(paramString) instanceof PluginManagerV2.OnPluginDownLoadListenerTransfer)) {}
      }
    }
    try
    {
      localObject2 = (PluginManagerV2.OnPluginDownLoadListenerTransfer)this.h.remove(paramString);
      if (localObject2 != null) {
        ((PluginManagerV2.OnPluginDownLoadListenerTransfer)localObject2).onInstallFinish(paramString);
      }
      this.g.remove(paramString);
      this.b.b((PluginInfo)localObject1);
      return;
    }
    catch (RemoteException paramString) {}
    if (!TripleGraySwitchUtil.b(this.q, "KEY_DISABLE_SAVE_PLUGIN_INFO", true))
    {
      paramString = new StringBuilder();
      paramString.append("download finish, save plugin info, state: ");
      paramString.append(((PluginInfo)localObject1).mState);
      QLog.d("plugin_tag", 1, paramString.toString());
      this.b.b((PluginInfo)localObject1);
    }
    this.b.a((PluginInfo)localObject1, this);
    return;
    ((PluginInfo)localObject1).mState = -2;
    this.g.remove(paramString);
    Object localObject2 = (OnPluginInstallListener)this.h.remove(paramString);
    ((PluginInfo)localObject1).installCode = 5;
    if (localObject2 != null) {
      ((OnPluginInstallListener)localObject2).onInstallError(paramString, 5);
    }
    return;
  }
  
  public boolean a(PluginInfo paramPluginInfo)
  {
    this.e.a(paramPluginInfo.mID);
    boolean bool = this.b.b(paramPluginInfo.mID);
    synchronized (this.i)
    {
      Iterator localIterator = this.i.iterator();
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
    synchronized (this.i)
    {
      this.i.remove(paramOnPluginInfoUpdateListener);
      return;
    }
  }
  
  public void b(String paramString)
  {
    PluginInfo localPluginInfo = (PluginInfo)this.g.get(paramString);
    OnPluginInstallListener localOnPluginInstallListener = (OnPluginInstallListener)this.h.get(paramString);
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
    OnPluginInstallListener localOnPluginInstallListener = (OnPluginInstallListener)this.h.remove(paramString);
    PluginInfo localPluginInfo = (PluginInfo)this.g.get(paramString);
    this.g.remove(paramString);
    if (localPluginInfo != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 4;
      } else {
        i1 = -2;
      }
      localPluginInfo.mState = i1;
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
    Object localObject = (PluginInfo)this.g.get(paramString);
    this.g.remove(paramString);
    if ((localObject != null) && (((PluginInfo)localObject).mState == 1))
    {
      ((PluginInfo)localObject).mState = -1;
      ((PluginInfo)localObject).installCode = 3;
      ((PluginInfo)localObject).downloadDuration = 0L;
    }
    localObject = (OnPluginInstallListener)this.h.remove(paramString);
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
    this.e.a(str);
    this.b.b(str);
  }
  
  public PluginInfo d(String paramString)
  {
    Object localObject = paramString;
    if (!PluginIdUtil.isQPluginId(paramString)) {
      localObject = PluginIdUtil.convertQShadowId2QPluginId(paramString);
    }
    localObject = h((String)localObject);
    paramString = (String)localObject;
    if (localObject != null) {
      paramString = ((PluginInfo)localObject).a();
    }
    f();
    return paramString;
  }
  
  public void e(String paramString)
  {
    installPlugin(paramString, null);
  }
  
  public void f(String paramString)
  {
    Object localObject = (PluginInfo)this.g.get(paramString);
    this.g.remove(paramString);
    if (localObject != null)
    {
      ((PluginInfo)localObject).mState = -2;
      ((PluginInfo)localObject).installCode = 4;
    }
    localObject = (OnPluginInstallListener)this.h.remove(paramString);
    if (localObject != null) {}
    try
    {
      ((OnPluginInstallListener)localObject).onInstallError(paramString, 6);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void g(String paramString)
  {
    paramString = (PluginInfo)this.g.get(paramString);
    if (paramString != null) {
      paramString.mState = 3;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.k) {
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
      k();
      return true;
    case 66049: 
      j();
      return true;
    case 65537: 
      i();
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
    paramString = d(str);
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
    return this.n;
  }
  
  public void onDestroy()
  {
    this.o.obtainMessage(65537).sendToTarget();
    this.r.b();
    ??? = PluginCommunicationHandler.getInstance();
    ((PluginCommunicationHandler)???).setCommunicationChannel(null);
    ((PluginCommunicationHandler)???).unregister("common.get_qq_app_interface_data");
    synchronized (this.m)
    {
      this.l.clear();
      return;
    }
  }
  
  public void setListener(RemotePluginManager paramRemotePluginManager) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2
 * JD-Core Version:    0.7.0.1
 */