package cooperation.ilive;

import NS_KING_PUBLIC.stAuth;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.intervideo.IVLoggerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;
import cooperation.ilive.manager.IliveAuthManager;
import cooperation.ilive.util.ElapseStat;
import cooperation.qqreader.utils.Log;
import java.util.concurrent.ExecutorService;

public class IliveShadowImpl
  implements IShadow
{
  private static IliveShadowImpl jdField_a_of_type_CooperationIliveIliveShadowImpl;
  private PluginManager jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  private IliveShadowImpl.AuthCallback jdField_a_of_type_CooperationIliveIliveShadowImpl$AuthCallback;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  
  private IliveShadowImpl()
  {
    setILoggerFactory();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = ThreadManagerExecutor.getSingleThreadExecutorService(192);
  }
  
  private PluginManager a(Context paramContext, String paramString)
  {
    if (IlivePluginDownloadManager.a().a()) {
      return new DynamicPluginManager(IlivePluginDownloadManager.a().a());
    }
    return new DynamicPluginManager(new IliveCdnPmUpdater());
  }
  
  public static IliveShadowImpl a()
  {
    if (jdField_a_of_type_CooperationIliveIliveShadowImpl == null) {}
    try
    {
      if (jdField_a_of_type_CooperationIliveIliveShadowImpl == null) {
        jdField_a_of_type_CooperationIliveIliveShadowImpl = new IliveShadowImpl();
      }
      return jdField_a_of_type_CooperationIliveIliveShadowImpl;
    }
    finally {}
  }
  
  private void a(Context paramContext, long paramLong, PluginManager paramPluginManager, Bundle paramBundle, stAuth paramstAuth, EnterCallback paramEnterCallback)
  {
    ElapseStat.a("IliveLaunch enterWithAuth");
    Bundle localBundle2 = paramBundle.getBundle("KEY_EXTRAS");
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    if (QLog.isColorLevel()) {
      QLog.e("IliveAuthShadowImpl", 2, "start enterWithAuth  , uid = " + paramstAuth.sUid);
    }
    localBundle1.putString("openID", paramstAuth.sUid);
    localBundle1.putString("token", paramstAuth.sSessionKey);
    localBundle1.putInt("auth_type", 0);
    paramBundle.putBundle("KEY_EXTRAS", localBundle1);
    try
    {
      paramPluginManager.enter(paramContext, paramLong, paramBundle, new IliveShadowImpl.2(this, paramEnterCallback, paramLong));
      ElapseStat.b("IliveLaunch enterWithAuth");
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        QLog.e("IliveAuthShadowImpl", 1, "enterWithAuth exception , e = " + paramContext.getMessage());
      }
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    try
    {
      paramString2 = getPluginManager(paramContext, paramString1, paramString2);
      Log.c("IliveAuthShadowImpl", "enter: " + paramLong + ", frameVersion = " + "1");
      ElapseStat.a("stAuth");
      if (paramString2 != null)
      {
        long l = System.currentTimeMillis();
        paramBundle.putString("hostuid", paramString1);
        paramBundle.putString("hostVersion", "8.5.5");
        paramBundle.putInt("key_frame_version", Integer.valueOf("1").intValue());
        paramBundle.putLong("entryTime", l);
        if (!IlivePluginDownloadManager.a().a())
        {
          paramBundle.putString("pluginZipPath", IlivePluginDownloadManager.a().c());
          paramBundle.putString("pluginZipMD5", IlivePluginDownloadManager.a().d());
        }
        paramBundle.putBoolean("isDebugVersion", false);
        paramBundle.putString("qqVersion", AppSetting.a);
        paramString1 = IliveAuthManager.getInstance().getLocalIliveAuth(false);
        if (paramString1 != null)
        {
          QLog.e("IliveAuthShadowImpl", 1, "[enterWithAuth] use local auth !");
          a(paramContext, paramLong, paramString2, paramBundle, paramString1, paramEnterCallback);
          return;
        }
        QLog.e("IliveAuthShadowImpl", 1, "[enterWithAuth] start request getStAuth");
        this.jdField_a_of_type_CooperationIliveIliveShadowImpl$AuthCallback = new IliveShadowImpl.AuthCallback(this, paramString2, paramLong, paramContext, paramBundle, paramEnterCallback);
        IliveAuthManager.getInstance().getStAuth(this.jdField_a_of_type_CooperationIliveIliveShadowImpl$AuthCallback, true);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      QLog.e("IliveAuthShadowImpl", 1, "enter exception ", paramContext);
      return;
    }
    QLog.e("IliveAuthShadowImpl", 1, "[enter] pluginManager is null !");
  }
  
  public void enter(Context paramContext, long paramLong, String paramString1, String paramString2, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new IliveShadowImpl.1(this, paramContext, paramString1, paramString2, paramLong, paramBundle, paramEnterCallback));
  }
  
  public PluginManager getPluginManager(Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager = a(paramContext, paramString1);
    return this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  }
  
  public boolean hasPluginManager()
  {
    return this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager != null;
  }
  
  public void setILoggerFactory()
  {
    try
    {
      LoggerFactory.setILoggerFactory(IVLoggerFactory.a());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.IliveShadowImpl
 * JD-Core Version:    0.7.0.1
 */