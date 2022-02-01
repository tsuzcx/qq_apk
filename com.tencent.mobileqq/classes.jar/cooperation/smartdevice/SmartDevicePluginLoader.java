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
  private static SmartDevicePluginLoader jdField_a_of_type_CooperationSmartdeviceSmartDevicePluginLoader;
  private static String jdField_a_of_type_JavaLangString = "SmartDevicePluginLoader";
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity = null;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private IPluginManager.PluginParams jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private IPluginManager.PluginParams jdField_b_of_type_CooperationPluginIPluginManager$PluginParams = null;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
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
    if (jdField_a_of_type_CooperationSmartdeviceSmartDevicePluginLoader == null) {
      jdField_a_of_type_CooperationSmartdeviceSmartDevicePluginLoader = new SmartDevicePluginLoader();
    }
    return jdField_a_of_type_CooperationSmartdeviceSmartDevicePluginLoader;
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
      str = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[SmartDevicePluginLoader] handleFailed errCode:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_b_of_type_CooperationPluginIPluginManager$PluginParams = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    b(paramInt);
    String str = HardCodeUtil.a(2131714089);
    if (-4 == paramInt) {
      str = HardCodeUtil.a(2131714084);
    } else if (-5 == paramInt) {
      str = HardCodeUtil.a(2131714086);
    }
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[SmartDevicePluginLoader] handleFailed errCode:");
      localStringBuilder.append(str);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] queryPluginInfo!");
    }
    int i;
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 30000L) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramPluginBaseInfo == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.isReady())
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] queryPluginInfo is no ready and query it");
        }
        if (i != 0)
        {
          a(-5);
          return;
        }
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
        return;
      }
      a(-1);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[SmartDevicePluginLoader] queryPluginInfo mState : ");
      localStringBuilder.append(paramPluginBaseInfo.mState);
      localStringBuilder.append(" progress:");
      localStringBuilder.append(paramPluginBaseInfo.mDownloadProgress);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
    if ((-2 != paramPluginBaseInfo.mState) && (4 != paramPluginBaseInfo.mState) && (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 5000L))
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
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] install plugin success");
      }
      this.jdField_a_of_type_Boolean = true;
      b(0);
      b();
      return;
    case 3: 
      if (i != 0)
      {
        a(-5);
        return;
      }
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin("qqsmartdevice.apk");
    case 1: 
    case 2: 
      if (i != 0)
      {
        a(-5);
        return;
      }
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    case -1: 
      a(-6);
      return;
    }
    a(-2);
  }
  
  private boolean a(Context paramContext)
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
  
  private void b()
  {
    String str = this.c;
    if ((str != null) && (str.compareToIgnoreCase("openActivity") == 0))
    {
      this.c = null;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader]  launchPluginActivity delay 2 second");
      }
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1002, 2000L);
    }
    str = this.jdField_b_of_type_JavaLangString;
    if ((str != null) && (str.compareToIgnoreCase("launchService") == 0))
    {
      this.jdField_b_of_type_JavaLangString = null;
      if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_b_of_type_CooperationPluginIPluginManager$PluginParams != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader]  launchPluginService:");
        }
        IPluginManager.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_CooperationPluginIPluginManager$PluginParams);
        this.jdField_b_of_type_CooperationPluginIPluginManager$PluginParams = null;
        this.jdField_a_of_type_AndroidContentContext = null;
      }
    }
  }
  
  private void b(int paramInt)
  {
    super.setChanged();
    super.notifyObservers(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    this.jdField_b_of_type_Int = 0;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((!this.jdField_a_of_type_Boolean) && (!a(localQQAppInterface))) {
      PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
    }
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, String paramString1, Intent paramIntent, String paramString2, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, Class<? extends Activity> paramClass)
  {
    boolean bool = a(paramActivity);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("launchPluingActivityForResult.isPluginInstalled end: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d(paramAppRuntime, 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299168));
    if ((bool) && (paramOnDismissListener == null))
    {
      paramAppRuntime = null;
    }
    else
    {
      ((QQProgressDialog)localObject).a(HardCodeUtil.a(2131714082));
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
    this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = new IPluginManager.PluginParams(this.jdField_a_of_type_Int);
    localObject = this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams;
    ((IPluginManager.PluginParams)localObject).jdField_b_of_type_JavaLangString = "qqsmartdevice.apk";
    ((IPluginManager.PluginParams)localObject).e = PluginInfo.e;
    localObject = this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams;
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramString1;
    ((IPluginManager.PluginParams)localObject).f = paramString2;
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangClass = paramClass;
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
    ((IPluginManager.PluginParams)localObject).c = paramInt;
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidAppDialog = paramAppRuntime;
    ((IPluginManager.PluginParams)localObject).d = 10000;
    ((IPluginManager.PluginParams)localObject).g = null;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = a(paramOnDismissListener);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        paramAppRuntime = jdField_a_of_type_JavaLangString;
        paramString1 = new StringBuilder();
        paramString1.append("[SmartDevicePluginLoader] launchPluginActivity: plugin is installed ");
        paramString1.append(this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.f);
        QLog.d(paramAppRuntime, 2, paramString1.toString());
      }
      if (bool)
      {
        IPluginManager.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
        this.jdField_a_of_type_AndroidAppActivity = null;
        this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = null;
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299168));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131714083));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.c = "openActivity";
      b();
      return;
    }
    if (QLog.isColorLevel())
    {
      paramActivity = jdField_a_of_type_JavaLangString;
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("[SmartDevicePluginLoader] launchPluginActivity: waiting for plugin to install ");
      paramAppRuntime.append(this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.f);
      QLog.d(paramActivity, 2, paramAppRuntime.toString());
    }
    this.c = "openActivity";
    PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
  }
  
  public void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), SmartDeviceProxyService.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", true);
    this.jdField_b_of_type_CooperationPluginIPluginManager$PluginParams = new IPluginManager.PluginParams(this.jdField_a_of_type_Int);
    IPluginManager.PluginParams localPluginParams = this.jdField_b_of_type_CooperationPluginIPluginManager$PluginParams;
    localPluginParams.jdField_b_of_type_JavaLangString = "qqsmartdevice.apk";
    localPluginParams.e = PluginInfo.e;
    this.jdField_b_of_type_CooperationPluginIPluginManager$PluginParams.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localPluginParams = this.jdField_b_of_type_CooperationPluginIPluginManager$PluginParams;
    localPluginParams.f = "com.tencent.device.ipc.QQSmartDeviceService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    this.jdField_a_of_type_AndroidContentContext = paramAppRuntime.getApplication();
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] launchPluginService directly");
      }
      IPluginManager.c(paramAppRuntime.getApplication(), this.jdField_b_of_type_CooperationPluginIPluginManager$PluginParams);
      this.jdField_b_of_type_CooperationPluginIPluginManager$PluginParams = null;
      this.jdField_a_of_type_AndroidContentContext = null;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] launchPluginService: waiting for plugin to install ");
    }
    this.jdField_b_of_type_JavaLangString = "launchService";
    PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (IPluginManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a("qqsmartdevice.apk");
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
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 1003: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if (paramMessage != null)
      {
        paramMessage.hide();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      break;
    case 1002: 
      b(0);
      if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams != null))
      {
        if (QLog.isColorLevel())
        {
          paramMessage = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[SmartDevicePluginLoader]  launchPluginActivity:");
          localStringBuilder.append(this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.f);
          QLog.d(paramMessage, 2, localStringBuilder.toString());
        }
        IPluginManager.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
      }
      this.jdField_a_of_type_AndroidAppActivity = null;
      this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = null;
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1003, 600L);
      break;
    case 1001: 
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader]  ACTION_QUERY!");
      }
      a("qqsmartdevice.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin("qqsmartdevice.apk"));
    }
    return true;
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient = paramPluginManagerClient;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] onPluginManagerLoaded SUPPORT_NETWORKING:true");
    }
    paramPluginManagerClient = this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
    int i = 1;
    if (paramPluginManagerClient != null)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramPluginManagerClient = this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin("qqsmartdevice.apk");
      if (paramPluginManagerClient != null)
      {
        if (paramPluginManagerClient.mState == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] plugin is installed");
          }
          this.jdField_a_of_type_Boolean = true;
          b(0);
          b();
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramPluginManagerClient = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[SmartDevicePluginLoader] onPluginManagerLoaded start down or install... retryCount: ");
            localStringBuilder.append(this.jdField_b_of_type_Int);
            QLog.i(paramPluginManagerClient, 2, localStringBuilder.toString());
          }
          int j = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (j + 1);
          if (j < 3) {
            this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin("qqsmartdevice.apk");
          }
        }
      }
      else {
        i = 0;
      }
      if (i == 0) {
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] not support networking");
      }
      this.jdField_a_of_type_Boolean = true;
      b(0);
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.smartdevice.SmartDevicePluginLoader
 * JD-Core Version:    0.7.0.1
 */