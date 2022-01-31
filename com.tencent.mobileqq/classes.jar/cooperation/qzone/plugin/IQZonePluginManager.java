package cooperation.qzone.plugin;

import amwu;
import amwv;
import amww;
import amwx;
import amwy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.mobileqq.statistics.PluginStatisticsCollector;
import com.tencent.mobileqq.widget.QzoneProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

public abstract class IQZonePluginManager
  extends QZoneRemotePluginManager.Stub
{
  public static void a(Activity paramActivity, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if (paramPluginParams.f != null)
    {
      localObject = Toast.makeText(BaseApplicationImpl.getContext(), paramPluginParams.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    Object localObject = new amwu();
    if ((paramPluginParams.jdField_a_of_type_AndroidAppDialog != null) && (!paramActivity.isFinishing())) {
      new SplashDialogWrapper(paramActivity, paramPluginParams.jdField_a_of_type_AndroidAppDialog, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_a_of_type_Boolean, paramPluginParams.c).show();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramActivity, paramPluginParams, (IQZonePluginManager.OnPluginReadyListener)localObject);
      return;
    }
    ((IQZonePluginManager)((QQAppInterface)localAppRuntime).getManager(174)).a(paramActivity, paramPluginParams, (IQZonePluginManager.OnPluginReadyListener)localObject);
  }
  
  public static void a(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    amwv localamwv = new amwv();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, paramPluginParams, localamwv);
      return;
    }
    ((IQZonePluginManager)((QQAppInterface)localAppRuntime).getManager(174)).a(paramContext, paramPluginParams, localamwv);
  }
  
  public static void b(Activity paramActivity, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if ((paramPluginParams == null) || (paramActivity == null) || (paramPluginParams.jdField_a_of_type_AndroidContentIntent == null)) {}
    for (;;)
    {
      return;
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.setClass(paramActivity, paramPluginParams.jdField_a_of_type_JavaLangClass);
      if (TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
      {
        paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramPluginParams.jdField_a_of_type_JavaLangString);
        paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramPluginParams.jdField_a_of_type_JavaLangString);
      }
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramPluginParams.jdField_a_of_type_JavaLangString);
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
      try
      {
        File localFile = new File(QZonePluginUtils.a(paramActivity), paramPluginParams.jdField_b_of_type_JavaLangString);
        PluginProxyActivity.openActivityForResult(paramActivity, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, localFile.getCanonicalPath(), paramPluginParams.e, paramPluginParams.jdField_a_of_type_AndroidContentIntent, paramPluginParams.jdField_b_of_type_Int);
        if ((paramPluginParams.jdField_a_of_type_AndroidAppDialog != null) && ((paramPluginParams.jdField_a_of_type_AndroidAppDialog instanceof QzoneProgressDialog)) && (paramActivity != null))
        {
          paramActivity.overridePendingTransition(2131034210, 2131034210);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        QLog.e("feilongzou", 1, paramActivity, new Object[0]);
      }
    }
  }
  
  public static void b(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    amww localamww = new amww();
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      b(paramContext, paramPluginParams, localamww);
      return;
    }
    ((IQZonePluginManager)((QQAppInterface)localAppRuntime).getManager(174)).a(paramContext, paramPluginParams, localamww);
  }
  
  private static void b(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    QZonePluginMangerHelper.a(paramContext, new amwy(paramContext, paramPluginParams, paramOnPluginReadyListener));
  }
  
  public static void c(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if ((TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_JavaLangString)))
    {
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramPluginParams.jdField_a_of_type_JavaLangString);
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramPluginParams.jdField_a_of_type_JavaLangString);
    }
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramPluginParams.jdField_a_of_type_JavaLangString);
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
    Object localObject = paramPluginParams.jdField_b_of_type_JavaLangString;
    localObject = new File(QZonePluginUtils.a(paramContext), (String)localObject);
    try
    {
      PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, ((File)localObject).getCanonicalPath(), paramPluginParams.e, paramPluginParams.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PluginDebug", 2, "doLaunchPluginBroadcast", paramContext);
    }
  }
  
  public static void d(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams)
  {
    if ((TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_JavaLangString)))
    {
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramPluginParams.jdField_a_of_type_JavaLangString);
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramPluginParams.jdField_a_of_type_JavaLangString);
    }
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramPluginParams.jdField_a_of_type_JavaLangString);
    paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
    Object localObject = paramPluginParams.jdField_b_of_type_JavaLangString;
    localObject = new File(QZonePluginUtils.a(paramContext), (String)localObject);
    try
    {
      localObject = ((File)localObject).getCanonicalPath();
      if (paramPluginParams.jdField_a_of_type_AndroidContentServiceConnection != null)
      {
        PluginProxyService.bindService(paramContext, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, (String)localObject, paramPluginParams.e, paramPluginParams.jdField_a_of_type_AndroidContentIntent, paramPluginParams.jdField_a_of_type_AndroidContentServiceConnection);
        return;
      }
      ThreadManager.post(new amwx(paramContext, paramPluginParams, (String)localObject), 5, null, false);
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PluginDebug", 2, "doLaunchPluginService", paramContext);
      }
    }
  }
  
  public abstract PluginRecord a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, IQZonePluginManager.PluginParams paramPluginParams, IQZonePluginManager.OnPluginReadyListener paramOnPluginReadyListener);
  
  public abstract void a(OnQZoneLiveSoDownloadListener paramOnQZoneLiveSoDownloadListener, int paramInt);
  
  public abstract boolean a();
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString, OnQZonePluginInstallListner paramOnQZonePluginInstallListner, int paramInt);
  
  public abstract boolean b(String paramString);
  
  public abstract boolean c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.IQZonePluginManager
 * JD-Core Version:    0.7.0.1
 */