package cooperation.smartdevice;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import cooperation.smartdevice.ipc.SmartDeviceProxyService;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.app.AppRuntime;

public class SmartDevicePluginLoader
  extends Observable
  implements Handler.Callback, PluginManagerHelper.OnPluginManagerLoadedListener
{
  private static String a = "SmartDevicePluginLoader";
  private static SmartDevicePluginLoader b;
  private QQProgressDialog c = null;
  private String d;
  private String e;
  private boolean f = false;
  private MqqWeakReferenceHandler g = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private PluginManagerClient h;
  private long i;
  private int j = 1;
  private IPluginManager.PluginParams k = null;
  private Activity l = null;
  private IPluginManager.PluginParams m = null;
  private Context n = null;
  private int o = 0;
  
  public static AppInterface a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if (paramBaseApplicationImpl != null)
    {
      if (paramString == null) {
        return null;
      }
      for (;;)
      {
        try
        {
          try
          {
            localClass = Class.forName("com.tencent.device.app.SmartDeviceAppInterface");
          }
          catch (Exception paramBaseApplicationImpl) {}catch (NoSuchMethodException paramBaseApplicationImpl) {}catch (InvocationTargetException paramBaseApplicationImpl) {}catch (InstantiationException paramBaseApplicationImpl) {}catch (IllegalAccessException paramBaseApplicationImpl) {}catch (IllegalArgumentException paramBaseApplicationImpl) {}
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          Class localClass;
          ClassLoader localClassLoader;
          continue;
          if (localClassNotFoundException != null) {
            continue;
          }
        }
        try
        {
          localClassLoader = a(paramBaseApplicationImpl);
          localClass = localClassLoader.loadClass("com.tencent.device.app.SmartDeviceAppInterface");
          BasicClassTypeUtil.setClassLoader(true, localClassLoader);
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
      }
      paramBaseApplicationImpl = localClass.getDeclaredConstructor(new Class[] { paramBaseApplicationImpl.getClass(), paramString.getClass() }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
      if ((paramBaseApplicationImpl != null) && ((paramBaseApplicationImpl instanceof AppInterface)))
      {
        paramBaseApplicationImpl = (AppInterface)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
        paramBaseApplicationImpl.printStackTrace();
        return null;
        paramBaseApplicationImpl.printStackTrace();
        return null;
        paramBaseApplicationImpl.printStackTrace();
        return null;
        paramBaseApplicationImpl.printStackTrace();
        return null;
        paramBaseApplicationImpl.printStackTrace();
        return null;
        paramBaseApplicationImpl.printStackTrace();
        return null;
      }
    }
    return null;
    return null;
  }
  
  public static SmartDevicePluginLoader a()
  {
    if (b == null) {
      b = new SmartDevicePluginLoader();
    }
    return b;
  }
  
  public static ClassLoader a(Context paramContext)
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "qqsmartdevice.apk");
  }
  
  private void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      str = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[SmartDevicePluginLoader] handleFailed errCode:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    this.k = null;
    this.l = null;
    this.m = null;
    this.n = null;
    b(paramInt);
    String str = HardCodeUtil.a(2131911620);
    if (-4 == paramInt) {
      str = HardCodeUtil.a(2131911615);
    } else if (-5 == paramInt) {
      str = HardCodeUtil.a(2131911617);
    }
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[SmartDevicePluginLoader] handleFailed errCode:");
      localStringBuilder.append(str);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "[SmartDevicePluginLoader] queryPluginInfo!");
    }
    int i1;
    if (System.currentTimeMillis() - this.i > 30000L) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (paramPluginBaseInfo == null)
    {
      if (!this.h.isReady())
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "[SmartDevicePluginLoader] queryPluginInfo is no ready and query it");
        }
        if (i1 != 0)
        {
          a(-5);
          return;
        }
        this.g.sendEmptyMessageDelayed(1001, 400L);
        return;
      }
      a(-1);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[SmartDevicePluginLoader] queryPluginInfo mState : ");
      localStringBuilder.append(paramPluginBaseInfo.mState);
      localStringBuilder.append(" progress:");
      localStringBuilder.append(paramPluginBaseInfo.mDownloadProgress);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
    if ((-2 != paramPluginBaseInfo.mState) && (4 != paramPluginBaseInfo.mState) && (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) && (System.currentTimeMillis() - this.i > 5000L))
    {
      a(-4);
      return;
    }
    switch (paramPluginBaseInfo.mState)
    {
    default: 
      a(-3);
      return;
    case 4: 
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "[SmartDevicePluginLoader] install plugin success");
      }
      this.f = true;
      b(0);
      c();
      return;
    case 3: 
      if (i1 != 0)
      {
        a(-5);
        return;
      }
      this.g.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 0: 
      this.h.installPlugin("qqsmartdevice.apk");
    case 1: 
    case 2: 
      if (i1 != 0)
      {
        a(-5);
        return;
      }
      this.g.sendEmptyMessageDelayed(1001, 400L);
      return;
    case -1: 
      a(-6);
      return;
    }
    a(-2);
  }
  
  private void b(int paramInt)
  {
    super.setChanged();
    super.notifyObservers(Integer.valueOf(paramInt));
  }
  
  private boolean b(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:smartdevice".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  private void c()
  {
    String str = this.e;
    if ((str != null) && (str.compareToIgnoreCase("openActivity") == 0))
    {
      this.e = null;
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "[SmartDevicePluginLoader]  launchPluginActivity delay 2 second");
      }
      this.g.sendEmptyMessageDelayed(1002, 2000L);
    }
    str = this.d;
    if ((str != null) && (str.compareToIgnoreCase("launchService") == 0))
    {
      this.d = null;
      if ((this.n != null) && (this.m != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "[SmartDevicePluginLoader]  launchPluginService:");
        }
        IPluginManager.c(this.n, this.m);
        this.m = null;
        this.n = null;
      }
    }
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, String paramString1, Intent paramIntent, String paramString2, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, Class<? extends Activity> paramClass)
  {
    boolean bool = b(paramActivity);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("launchPluingActivityForResult.isPluginInstalled end: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d(paramAppRuntime, 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299920));
    if ((bool) && (paramOnDismissListener == null))
    {
      paramAppRuntime = null;
    }
    else
    {
      ((QQProgressDialog)localObject).a(HardCodeUtil.a(2131911613));
      ((QQProgressDialog)localObject).setOnDismissListener(new SmartDevicePluginLoader.1(this, paramOnDismissListener));
      paramAppRuntime = (AppRuntime)localObject;
      if (bool)
      {
        ((QQProgressDialog)localObject).setOnShowListener(new SmartDevicePluginLoader.2(this, (QQProgressDialog)localObject));
        paramAppRuntime = (AppRuntime)localObject;
      }
    }
    paramOnDismissListener = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ((SmartDeviceProxyMgr)paramOnDismissListener.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).b();
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", true);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    this.k = new IPluginManager.PluginParams(this.j);
    localObject = this.k;
    ((IPluginManager.PluginParams)localObject).d = "qqsmartdevice.apk";
    ((IPluginManager.PluginParams)localObject).g = PluginInfo.e;
    localObject = this.k;
    ((IPluginManager.PluginParams)localObject).c = paramString1;
    ((IPluginManager.PluginParams)localObject).h = paramString2;
    ((IPluginManager.PluginParams)localObject).i = paramClass;
    ((IPluginManager.PluginParams)localObject).j = paramIntent;
    ((IPluginManager.PluginParams)localObject).k = paramInt;
    ((IPluginManager.PluginParams)localObject).l = paramAppRuntime;
    ((IPluginManager.PluginParams)localObject).r = 10000;
    ((IPluginManager.PluginParams)localObject).q = null;
    this.l = paramActivity;
    if (!this.f) {
      this.f = a(paramOnDismissListener);
    }
    if (this.f)
    {
      if (QLog.isColorLevel())
      {
        paramAppRuntime = a;
        paramString1 = new StringBuilder();
        paramString1.append("[SmartDevicePluginLoader] launchPluginActivity: plugin is installed ");
        paramString1.append(this.k.h);
        QLog.d(paramAppRuntime, 2, paramString1.toString());
      }
      if (bool)
      {
        IPluginManager.a(this.l, this.k);
        this.l = null;
        this.k = null;
        return;
      }
      if (this.c == null)
      {
        this.c = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299920));
        this.c.a(HardCodeUtil.a(2131911614));
      }
      this.c.show();
      this.e = "openActivity";
      c();
      return;
    }
    if (QLog.isColorLevel())
    {
      paramActivity = a;
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("[SmartDevicePluginLoader] launchPluginActivity: waiting for plugin to install ");
      paramAppRuntime.append(this.k.h);
      QLog.d(paramActivity, 2, paramAppRuntime.toString());
    }
    this.e = "openActivity";
    PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
  }
  
  public void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), SmartDeviceProxyService.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", true);
    this.m = new IPluginManager.PluginParams(this.j);
    IPluginManager.PluginParams localPluginParams = this.m;
    localPluginParams.d = "qqsmartdevice.apk";
    localPluginParams.g = PluginInfo.e;
    this.m.c = paramAppRuntime.getAccount();
    localPluginParams = this.m;
    localPluginParams.h = "com.tencent.device.ipc.QQSmartDeviceService";
    localPluginParams.j = localIntent;
    localPluginParams.o = paramServiceConnection;
    this.n = paramAppRuntime.getApplication();
    if (this.f)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "[SmartDevicePluginLoader] launchPluginService directly");
      }
      IPluginManager.c(paramAppRuntime.getApplication(), this.m);
      this.m = null;
      this.n = null;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "[SmartDevicePluginLoader] launchPluginService: waiting for plugin to install ");
    }
    this.d = "launchService";
    PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (IPluginManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.d("qqsmartdevice.apk");
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        bool1 = bool2;
        if (paramQQAppInterface.mState == 4) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    this.o = 0;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((!this.f) && (!a(localQQAppInterface))) {
      PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 1003: 
      paramMessage = this.c;
      if (paramMessage != null)
      {
        paramMessage.hide();
        this.c = null;
      }
      break;
    case 1002: 
      b(0);
      if ((this.l != null) && (this.k != null))
      {
        if (QLog.isColorLevel())
        {
          paramMessage = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[SmartDevicePluginLoader]  launchPluginActivity:");
          localStringBuilder.append(this.k.h);
          QLog.d(paramMessage, 2, localStringBuilder.toString());
        }
        IPluginManager.a(this.l, this.k);
      }
      this.l = null;
      this.k = null;
      this.g.sendEmptyMessageDelayed(1003, 600L);
      break;
    case 1001: 
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "[SmartDevicePluginLoader]  ACTION_QUERY!");
      }
      a("qqsmartdevice.apk", this.h.queryPlugin("qqsmartdevice.apk"));
    }
    return true;
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    this.h = paramPluginManagerClient;
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "[SmartDevicePluginLoader] onPluginManagerLoaded SUPPORT_NETWORKING:true");
    }
    paramPluginManagerClient = this.h;
    int i1 = 1;
    if (paramPluginManagerClient != null)
    {
      this.i = System.currentTimeMillis();
      paramPluginManagerClient = this.h.queryPlugin("qqsmartdevice.apk");
      if (paramPluginManagerClient != null)
      {
        if (paramPluginManagerClient.mState == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "[SmartDevicePluginLoader] plugin is installed");
          }
          this.f = true;
          b(0);
          c();
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramPluginManagerClient = a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[SmartDevicePluginLoader] onPluginManagerLoaded start down or install... retryCount: ");
            localStringBuilder.append(this.o);
            QLog.i(paramPluginManagerClient, 2, localStringBuilder.toString());
          }
          int i2 = this.o;
          this.o = (i2 + 1);
          if (i2 < 3) {
            this.h.installPlugin("qqsmartdevice.apk");
          }
        }
      }
      else {
        i1 = 0;
      }
      if (i1 == 0) {
        this.g.sendEmptyMessageDelayed(1001, 400L);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "[SmartDevicePluginLoader] not support networking");
      }
      this.f = true;
      b(0);
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.smartdevice.SmartDevicePluginLoader
 * JD-Core Version:    0.7.0.1
 */