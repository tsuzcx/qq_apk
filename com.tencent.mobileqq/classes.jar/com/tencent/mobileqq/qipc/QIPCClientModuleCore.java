package com.tencent.mobileqq.qipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class QIPCClientModuleCore
  extends QIPCModule
{
  public static final String ACTION_IS_MODULE_RUNNING = "isrun";
  public static final String NAME = "QIPCClientModuleCore";
  public static final String PARAM_KEY_MODULEID = "module_id";
  
  public QIPCClientModuleCore()
  {
    super("QIPCClientModuleCore");
  }
  
  /* Error */
  public EIPCResult isModuleRunning(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_2
    //   3: ldc 14
    //   5: invokevirtual 30	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   8: astore_1
    //   9: aload_1
    //   10: invokestatic 36	com/tencent/mobileqq/pluginsdk/PluginStatic:getClassLoader	(Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +35 -> 50
    //   18: iconst_1
    //   19: istore_3
    //   20: iload_3
    //   21: istore 4
    //   23: iload_3
    //   24: ifne +16 -> 40
    //   27: getstatic 42	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   30: aconst_null
    //   31: invokevirtual 46	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   34: aload_1
    //   35: invokevirtual 51	mqq/app/AppRuntime:isModuleRunning	(Ljava/lang/String;)Z
    //   38: istore 4
    //   40: iload 4
    //   42: ifeq +24 -> 66
    //   45: aconst_null
    //   46: invokestatic 57	eipc/EIPCResult:createSuccessResult	(Landroid/os/Bundle;)Leipc/EIPCResult;
    //   49: areturn
    //   50: iconst_0
    //   51: istore_3
    //   52: goto -32 -> 20
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 60	java/lang/Exception:printStackTrace	()V
    //   60: iload_3
    //   61: istore 4
    //   63: goto -23 -> 40
    //   66: bipush 154
    //   68: aconst_null
    //   69: invokestatic 64	eipc/EIPCResult:createResult	(ILandroid/os/Bundle;)Leipc/EIPCResult;
    //   72: areturn
    //   73: astore_1
    //   74: goto -18 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	QIPCClientModuleCore
    //   0	77	1	paramString	String
    //   0	77	2	paramBundle	Bundle
    //   1	60	3	bool1	boolean
    //   21	41	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	55	java/lang/Exception
    //   27	40	73	java/lang/Exception
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.name, 2, "action = " + paramString + ", params = " + paramBundle);
    }
    if (TextUtils.equals(paramString, "isrun")) {
      return isModuleRunning(paramString, paramBundle);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCClientModuleCore
 * JD-Core Version:    0.7.0.1
 */