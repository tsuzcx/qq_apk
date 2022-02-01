package cooperation.qqfav;

import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;

final class QfavHelper$3
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  QfavHelper$3(Runnable paramRunnable) {}
  
  /* Error */
  public void onPluginManagerLoaded(com.tencent.mobileqq.pluginsdk.PluginManagerClient paramPluginManagerClient)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: aload_0
    //   5: getfield 12	cooperation/qqfav/QfavHelper$3:a	Ljava/lang/Runnable;
    //   8: iconst_5
    //   9: aconst_null
    //   10: iconst_0
    //   11: invokestatic 26	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   14: return
    //   15: aload_1
    //   16: ldc 28
    //   18: invokevirtual 34	com/tencent/mobileqq/pluginsdk/PluginManagerClient:isPluginInstalled	(Ljava/lang/String;)Z
    //   21: ifeq +35 -> 56
    //   24: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +11 -> 38
    //   30: ldc 42
    //   32: iconst_2
    //   33: ldc 44
    //   35: invokestatic 48	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: invokestatic 54	cooperation/qqfav/QfavHelper:d	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   41: iconst_1
    //   42: invokevirtual 60	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   45: aload_0
    //   46: getfield 12	cooperation/qqfav/QfavHelper$3:a	Ljava/lang/Runnable;
    //   49: iconst_5
    //   50: aconst_null
    //   51: iconst_0
    //   52: invokestatic 26	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   55: return
    //   56: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +11 -> 70
    //   62: ldc 42
    //   64: iconst_2
    //   65: ldc 62
    //   67: invokestatic 48	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_1
    //   71: ldc 28
    //   73: new 64	cooperation/qqfav/QfavHelper$3$1
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 67	cooperation/qqfav/QfavHelper$3$1:<init>	(Lcooperation/qqfav/QfavHelper$3;)V
    //   81: invokevirtual 71	com/tencent/mobileqq/pluginsdk/PluginManagerClient:installPlugin	(Ljava/lang/String;Lcom/tencent/mobileqq/pluginsdk/OnPluginInstallListener;)V
    //   84: return
    //   85: astore_1
    //   86: return
    //   87: astore_1
    //   88: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	3
    //   0	89	1	paramPluginManagerClient	com.tencent.mobileqq.pluginsdk.PluginManagerClient
    // Exception table:
    //   from	to	target	type
    //   4	14	85	java/lang/Exception
    //   45	55	87	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.QfavHelper.3
 * JD-Core Version:    0.7.0.1
 */