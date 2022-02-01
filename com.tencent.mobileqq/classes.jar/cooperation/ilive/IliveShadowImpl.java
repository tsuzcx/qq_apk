package cooperation.ilive;

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
    if (jdField_a_of_type_CooperationIliveIliveShadowImpl == null) {
      try
      {
        if (jdField_a_of_type_CooperationIliveIliveShadowImpl == null) {
          jdField_a_of_type_CooperationIliveIliveShadowImpl = new IliveShadowImpl();
        }
      }
      finally {}
    }
    return jdField_a_of_type_CooperationIliveIliveShadowImpl;
  }
  
  /* Error */
  private void a(Context paramContext, long paramLong, PluginManager paramPluginManager, Bundle paramBundle, NS_KING_PUBLIC.stAuth paramstAuth, EnterCallback paramEnterCallback)
  {
    // Byte code:
    //   0: ldc 56
    //   2: invokestatic 61	cooperation/ilive/util/ElapseStat:a	(Ljava/lang/String;)V
    //   5: aload 5
    //   7: ldc 63
    //   9: invokevirtual 69	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   12: astore 9
    //   14: aload 9
    //   16: astore 8
    //   18: aload 9
    //   20: ifnonnull +12 -> 32
    //   23: new 65	android/os/Bundle
    //   26: dup
    //   27: invokespecial 70	android/os/Bundle:<init>	()V
    //   30: astore 8
    //   32: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +42 -> 77
    //   38: new 77	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   45: astore 9
    //   47: aload 9
    //   49: ldc 80
    //   51: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 9
    //   57: aload 6
    //   59: getfield 90	NS_KING_PUBLIC/stAuth:sUid	Ljava/lang/String;
    //   62: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: ldc 92
    //   68: iconst_2
    //   69: aload 9
    //   71: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload 8
    //   79: ldc 102
    //   81: aload 6
    //   83: getfield 90	NS_KING_PUBLIC/stAuth:sUid	Ljava/lang/String;
    //   86: invokevirtual 106	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 8
    //   91: ldc 108
    //   93: aload 6
    //   95: getfield 111	NS_KING_PUBLIC/stAuth:sSessionKey	Ljava/lang/String;
    //   98: invokevirtual 106	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload 8
    //   103: ldc 113
    //   105: iconst_0
    //   106: invokevirtual 117	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   109: aload 5
    //   111: ldc 63
    //   113: aload 8
    //   115: invokevirtual 121	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   118: aload 4
    //   120: aload_1
    //   121: lload_2
    //   122: aload 5
    //   124: new 123	cooperation/ilive/IliveShadowImpl$2
    //   127: dup
    //   128: aload_0
    //   129: aload 7
    //   131: lload_2
    //   132: invokespecial 126	cooperation/ilive/IliveShadowImpl$2:<init>	(Lcooperation/ilive/IliveShadowImpl;Lcom/tencent/shadow/dynamic/host/EnterCallback;J)V
    //   135: invokeinterface 132 6 0
    //   140: goto +51 -> 191
    //   143: astore_1
    //   144: goto +5 -> 149
    //   147: astore 4
    //   149: aload_1
    //   150: invokevirtual 135	java/lang/Throwable:printStackTrace	()V
    //   153: new 77	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   160: astore 4
    //   162: aload 4
    //   164: ldc 137
    //   166: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 4
    //   172: aload_1
    //   173: invokevirtual 140	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   176: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: ldc 92
    //   182: iconst_1
    //   183: aload 4
    //   185: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: ldc 56
    //   193: invokestatic 143	cooperation/ilive/util/ElapseStat:b	(Ljava/lang/String;)V
    //   196: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	IliveShadowImpl
    //   0	197	1	paramContext	Context
    //   0	197	2	paramLong	long
    //   0	197	4	paramPluginManager	PluginManager
    //   0	197	5	paramBundle	Bundle
    //   0	197	6	paramstAuth	NS_KING_PUBLIC.stAuth
    //   0	197	7	paramEnterCallback	EnterCallback
    //   16	98	8	localObject1	Object
    //   12	58	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   118	140	143	java/lang/Throwable
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    try
    {
      paramString2 = getPluginManager(paramContext, paramString1, paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enter: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", frameVersion = ");
      localStringBuilder.append("1");
      QLog.i("IliveAuthShadowImpl", 1, localStringBuilder.toString());
      ElapseStat.a("stAuth");
      if (paramString2 != null)
      {
        long l = System.currentTimeMillis();
        paramBundle.putString("hostuid", paramString1);
        paramBundle.putString("hostVersion", "8.7.0");
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
      QLog.e("IliveAuthShadowImpl", 1, "[enter] pluginManager is null !");
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      QLog.e("IliveAuthShadowImpl", 1, "enter exception ", paramContext);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.IliveShadowImpl
 * JD-Core Version:    0.7.0.1
 */