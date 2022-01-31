package cooperation.qqfav;

import alyu;
import alyv;
import alyw;
import alyy;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public final class QfavHelper
{
  private static SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private static final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public static SharedPreferences a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_AndroidContentSharedPreferences == null) {
        jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("shared_prefs_qfav", 4);
      }
      paramContext = jdField_a_of_type_AndroidContentSharedPreferences;
      return paramContext;
    }
    finally {}
  }
  
  public static ClassLoader a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    try
    {
      localObject = PluginStatic.getOrCreateClassLoader((Context)localObject, "qqfav.apk");
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        BasicClassTypeUtil.setClassLoader(true, (ClassLoader)localObject);
        return localObject;
      }
      catch (Exception localException2)
      {
        break label24;
      }
      localException1 = localException1;
      localObject = null;
    }
    label24:
    return localObject;
  }
  
  public static Object a(String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    for (;;)
    {
      try
      {
        Class localClass = Class.forName(paramString);
        if (localClass == null) {
          QLog.i("qqfavQfavHelper#createInstance", 1, "className =" + paramString + ",cls == null");
        }
        paramArrayOfClass = localClass.getDeclaredConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
        if (paramArrayOfClass != null) {
          break;
        }
        QLog.i("qqfavQfavHelper#createInstance", 4, "className =" + paramString + ",retObj == null");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localObject = a();
        if (localObject != null)
        {
          localObject = ((ClassLoader)localObject).loadClass(paramString);
          continue;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      Object localObject = null;
    }
    return paramArrayOfClass;
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    return (AppRuntime)a("com.qqfav.QfavAppInterface", new Class[] { BaseApplicationImpl.class, String.class }, new Object[] { paramBaseApplicationImpl, "qqfav" });
  }
  
  @TargetApi(9)
  public static void a(Activity paramActivity, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    QQToast localQQToast = new QQToast(paramActivity);
    localQQToast.d(2000);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    if (paramBoolean1)
    {
      localQQToast.b(2);
      localQQToast.a(QQToast.a(2));
      localQQToast.c(2131431555);
      if (!a(paramActivity).getBoolean("pref_first_collection_" + str, true)) {}
    }
    for (;;)
    {
      try
      {
        paramString2 = paramActivity.getString(2131431578);
        if (!paramBoolean2) {
          continue;
        }
        paramString1 = paramActivity.getString(2131431580);
        DialogUtil.b(paramActivity, 230, paramString2, paramString1, 2131432998, 2131431581, new alyu(), null).setMessageCount(null).show();
        if (9 <= Build.VERSION.SDK_INT) {
          continue;
        }
        a(paramActivity).edit().putBoolean("pref_first_collection_" + str, false).commit();
        if (QLog.isColorLevel()) {
          QLog.d("qqfav", 2, "First collection guide shown. Uin=" + str + ", flag=" + a(paramActivity).getBoolean(new StringBuilder().append("pref_first_collection_").append(str).toString(), true));
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("qqfav", 1, "First collection guide error. Uin=" + str + ", flag=" + a(paramActivity).getBoolean(new StringBuilder().append("pref_first_collection_").append(str).toString(), true));
        continue;
      }
      localQQToast.b(paramActivity.getResources().getDimensionPixelSize(2131558448) - (int)(5.0F * paramActivity.getResources().getDisplayMetrics().density));
      return;
      paramString1 = paramActivity.getString(2131431579);
      continue;
      a(paramActivity).edit().putBoolean("pref_first_collection_" + str, false).apply();
      continue;
      localQQToast.b(1);
      localQQToast.a(QQToast.a(1));
      if (paramString2 == null) {
        localQQToast.c(2131431563);
      } else {
        localQQToast.a(paramString2);
      }
    }
  }
  
  public static void a(Context paramContext, OnPluginInstallListener paramOnPluginInstallListener)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getApplication();
    }
    try
    {
      new alyy((Context)localObject, paramOnPluginInstallListener).start();
      return;
    }
    catch (Throwable paramContext)
    {
      do
      {
        paramContext.printStackTrace();
      } while (paramOnPluginInstallListener == null);
      try
      {
        paramOnPluginInstallListener.onInstallError("qqfav.apk", -1);
        return;
      }
      catch (RemoteException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    int i;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      if (!((BaseApplicationImpl)localObject).getSharedPreferences("QfavNeedReupload", i).getBoolean(paramAppRuntime.getAccount() + "QfavNeedReupload", false)) {
        break label100;
      }
      if (QLog.isColorLevel()) {
        QLog.i("qqfav", 2, "reuploadQfavItems: flag=true");
      }
      localObject = new Intent("com.tencent.mobileqq.ACTION_QFAVIPC_BROADCAST");
      ((Intent)localObject).putExtra("nOperation", 5);
      QfavPluginProxyReceiver.a(paramAppRuntime, (Intent)localObject);
    }
    label100:
    while (!QLog.isColorLevel())
    {
      return;
      i = 0;
      break;
    }
    QLog.i("qqfav", 2, "reuploadQfavItems: flag=false");
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 3);
    return QfavPluginProxyActivity.a(paramActivity, paramString, localIntent, -1);
  }
  
  public static boolean a(Activity paramActivity, String paramString, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 6);
    localIntent.putExtra("lId", paramLong);
    return QfavPluginProxyActivity.a(paramActivity, paramString, localIntent, -1);
  }
  
  public static boolean a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    paramIntent.setFlags(paramIntent.getFlags() & 0xFBFFFFFF & 0xDFFFFFFF);
    return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static boolean a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    if (paramIntent == null) {}
    for (paramIntent = new Intent();; paramIntent = new Intent(paramIntent))
    {
      paramIntent.putExtra("nOperation", 2);
      paramIntent.putExtra("bShowProgress", paramBoolean);
      paramIntent.putExtra("begin", System.currentTimeMillis());
      QfavUtil.a(paramString);
      return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localRunningAppProcessInfo.processName != null) && (localRunningAppProcessInfo.processName.endsWith(":qqfav"))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(boolean paramBoolean)
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return true;
    }
    Object localObject2 = new alyv();
    if (paramBoolean) {}
    synchronized (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getApplication(), new alyw((Runnable)localObject2));
      localObject2 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (??? == localObject2) {}
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("qqfav", 2, "wait(sPluginInstalled) qqfav.apk");
        }
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.wait(5000L);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("qqfav", 2, "qqfav.apk, sPluginInstalled = " + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      }
      return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      ??? = localObject2;
    }
  }
  
  public static boolean b(Activity paramActivity, String paramString, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 7);
    return QfavPluginProxyActivity.a(paramActivity, paramString, localIntent, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qqfav.QfavHelper
 * JD-Core Version:    0.7.0.1
 */