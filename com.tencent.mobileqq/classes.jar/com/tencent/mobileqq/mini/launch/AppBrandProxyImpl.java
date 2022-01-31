package com.tencent.mobileqq.mini.launch;

import android.app.Activity;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppBrandProxyImpl
{
  public static final int PROCESS_STATUS_BACKGROUND = 3;
  public static final int PROCESS_STATUS_FOREGROUND = 2;
  public static final int PROCESS_STATUS_START = 1;
  public static final int PROCESS_STATUS_STOP = 4;
  private static final String TAG = "miniapp-process_AppBrandProxy";
  private static byte[] lock = new byte[0];
  private boolean isConnecting;
  private MiniAppConfig mAppConfig;
  private ServiceConnection mConnection = new AppBrandProxyImpl.1(this);
  private Context mContext;
  private int mMiniAppStatus;
  private boolean mNeedSyncStatus;
  private IAppBrandService mService;
  private Bundle mStartBundle;
  private List<Runnable> mTaskAfterConnected = new ArrayList();
  
  public AppBrandProxyImpl(Context paramContext)
  {
    this.mContext = paramContext;
    ensureService();
  }
  
  private void doAfterServiceConnected()
  {
    try
    {
      Object localObject = new ArrayList(this.mTaskAfterConnected);
      this.mTaskAfterConnected.clear();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Runnable localRunnable = (Runnable)((Iterator)localObject).next();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-process_AppBrandProxy", 1, "doAfterServiceConnected exception!", localThrowable);
    }
  }
  
  private void doStartMiniApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver) {}
  
  /* Error */
  private boolean ensureService()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokespecial 122	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:isMainProcess	()Z
    //   8: istore_1
    //   9: iload_1
    //   10: ifeq +9 -> 19
    //   13: iload_2
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 67	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mService	Lcom/tencent/mobileqq/mini/launch/IAppBrandService;
    //   23: ifnull +8 -> 31
    //   26: iconst_1
    //   27: istore_1
    //   28: goto -13 -> 15
    //   31: iload_2
    //   32: istore_1
    //   33: aload_0
    //   34: getfield 73	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:isConnecting	Z
    //   37: ifne -22 -> 15
    //   40: iload_2
    //   41: istore_1
    //   42: aload_0
    //   43: getfield 67	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mService	Lcom/tencent/mobileqq/mini/launch/IAppBrandService;
    //   46: ifnonnull -31 -> 15
    //   49: ldc 17
    //   51: iconst_1
    //   52: ldc 124
    //   54: invokestatic 128	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: new 130	android/content/Intent
    //   60: dup
    //   61: invokespecial 131	android/content/Intent:<init>	()V
    //   64: astore_3
    //   65: aload_3
    //   66: new 133	android/content/ComponentName
    //   69: dup
    //   70: aload_0
    //   71: getfield 59	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mContext	Landroid/content/Context;
    //   74: ldc 135
    //   76: invokespecial 138	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   79: invokevirtual 142	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   82: pop
    //   83: aload_3
    //   84: ldc 144
    //   86: invokestatic 150	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   89: invokevirtual 154	com/tencent/common/app/BaseApplicationImpl:getQQProcessName	()Ljava/lang/String;
    //   92: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   95: pop
    //   96: aload_0
    //   97: iconst_1
    //   98: putfield 73	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:isConnecting	Z
    //   101: aload_0
    //   102: getfield 59	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mContext	Landroid/content/Context;
    //   105: aload_3
    //   106: aload_0
    //   107: getfield 57	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mConnection	Landroid/content/ServiceConnection;
    //   110: iconst_1
    //   111: invokevirtual 164	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   114: pop
    //   115: iload_2
    //   116: istore_1
    //   117: goto -102 -> 15
    //   120: astore_3
    //   121: ldc 17
    //   123: iconst_1
    //   124: ldc 166
    //   126: aload_3
    //   127: invokestatic 168	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   130: iload_2
    //   131: istore_1
    //   132: goto -117 -> 15
    //   135: astore_3
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_3
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	AppBrandProxyImpl
    //   8	124	1	bool1	boolean
    //   1	130	2	bool2	boolean
    //   64	42	3	localIntent	android.content.Intent
    //   120	7	3	localThrowable	Throwable
    //   135	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   101	115	120	java/lang/Throwable
    //   4	9	135	finally
    //   19	26	135	finally
    //   33	40	135	finally
    //   42	101	135	finally
    //   101	115	135	finally
    //   121	130	135	finally
  }
  
  private boolean isMainProcess()
  {
    return "com.tencent.mobileqq".equals(BaseApplicationImpl.getApplication().getQQProcessName());
  }
  
  private void notifyToService()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.mNeedSyncStatus;
        if (!bool) {
          return;
        }
        this.mNeedSyncStatus = false;
        try
        {
          QLog.w("miniapp-process_AppBrandProxy", 1, "Sync Process Status=" + this.mMiniAppStatus);
          String str1 = BaseApplicationImpl.getApplication().getQQProcessName();
          if ((TextUtils.isEmpty(str1)) || (!str1.contains(":mini"))) {
            continue;
          }
          this.mService.onAppStart(str1, this.mAppConfig, this.mStartBundle);
          if (this.mMiniAppStatus != 3) {
            break label132;
          }
          this.mService.onAppBackground(str1, this.mAppConfig, null);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("miniapp-process_AppBrandProxy", 1, "onAppStart exception.", localThrowable);
        }
        continue;
        if (this.mMiniAppStatus != 2) {
          continue;
        }
      }
      finally {}
      label132:
      this.mService.onAppForeground(str2, this.mAppConfig, null);
    }
  }
  
  /* Error */
  public IAppBrandService getService()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mService	Lcom/tencent/mobileqq/mini/launch/IAppBrandService;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 67	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mService	Lcom/tencent/mobileqq/mini/launch/IAppBrandService;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: invokespecial 63	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:ensureService	()Z
    //   22: pop
    //   23: aload_0
    //   24: getfield 67	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mService	Lcom/tencent/mobileqq/mini/launch/IAppBrandService;
    //   27: astore_1
    //   28: goto -14 -> 14
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	AppBrandProxyImpl
    //   13	15	1	localIAppBrandService	IAppBrandService
    //   31	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	31	finally
    //   18	28	31	finally
  }
  
  /* Error */
  public void onAppBackground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_3
    //   4: putfield 189	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mMiniAppStatus	I
    //   7: aload_0
    //   8: invokevirtual 228	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:getService	()Lcom/tencent/mobileqq/mini/launch/IAppBrandService;
    //   11: ifnonnull +14 -> 25
    //   14: ldc 17
    //   16: iconst_1
    //   17: ldc 230
    //   19: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: ldc 17
    //   27: iconst_1
    //   28: ldc 234
    //   30: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 67	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mService	Lcom/tencent/mobileqq/mini/launch/IAppBrandService;
    //   37: aload_1
    //   38: aload_2
    //   39: aload_3
    //   40: invokeinterface 219 4 0
    //   45: goto -23 -> 22
    //   48: astore_1
    //   49: ldc 17
    //   51: iconst_1
    //   52: ldc 236
    //   54: aload_1
    //   55: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   58: goto -36 -> 22
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	AppBrandProxyImpl
    //   0	66	1	paramString	String
    //   0	66	2	paramMiniAppConfig	MiniAppConfig
    //   0	66	3	paramBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   25	45	48	java/lang/Throwable
    //   2	22	61	finally
    //   25	45	61	finally
    //   49	58	61	finally
  }
  
  /* Error */
  public void onAppForeground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_2
    //   4: putfield 189	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mMiniAppStatus	I
    //   7: aload_0
    //   8: invokevirtual 228	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:getService	()Lcom/tencent/mobileqq/mini/launch/IAppBrandService;
    //   11: astore 4
    //   13: aload_0
    //   14: aload_2
    //   15: putfield 208	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mAppConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   18: aload 4
    //   20: ifnonnull +19 -> 39
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield 178	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mNeedSyncStatus	Z
    //   28: ldc 17
    //   30: iconst_1
    //   31: ldc 238
    //   33: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: ldc 17
    //   41: iconst_1
    //   42: ldc 240
    //   44: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_0
    //   48: getfield 67	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mService	Lcom/tencent/mobileqq/mini/launch/IAppBrandService;
    //   51: aload_1
    //   52: aload_2
    //   53: aload_3
    //   54: invokeinterface 224 4 0
    //   59: goto -23 -> 36
    //   62: astore_1
    //   63: ldc 17
    //   65: iconst_1
    //   66: ldc 242
    //   68: aload_1
    //   69: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   72: goto -36 -> 36
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	AppBrandProxyImpl
    //   0	80	1	paramString	String
    //   0	80	2	paramMiniAppConfig	MiniAppConfig
    //   0	80	3	paramBundle	Bundle
    //   11	8	4	localIAppBrandService	IAppBrandService
    // Exception table:
    //   from	to	target	type
    //   39	59	62	java/lang/Throwable
    //   2	18	75	finally
    //   23	36	75	finally
    //   39	59	75	finally
    //   63	72	75	finally
  }
  
  /* Error */
  public void onAppStart(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 189	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mMiniAppStatus	I
    //   6: iconst_1
    //   7: if_icmpge +8 -> 15
    //   10: aload_0
    //   11: iconst_1
    //   12: putfield 189	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mMiniAppStatus	I
    //   15: aload_0
    //   16: invokevirtual 228	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:getService	()Lcom/tencent/mobileqq/mini/launch/IAppBrandService;
    //   19: ifnonnull +24 -> 43
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 178	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mNeedSyncStatus	Z
    //   27: aload_0
    //   28: aload_3
    //   29: putfield 210	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mStartBundle	Landroid/os/Bundle;
    //   32: ldc 17
    //   34: iconst_1
    //   35: ldc 244
    //   37: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: ldc 17
    //   45: iconst_1
    //   46: ldc 246
    //   48: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 67	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mService	Lcom/tencent/mobileqq/mini/launch/IAppBrandService;
    //   55: aload_1
    //   56: aload_2
    //   57: aload_3
    //   58: invokeinterface 216 4 0
    //   63: aload_2
    //   64: ifnull -24 -> 40
    //   67: ldc 17
    //   69: iconst_1
    //   70: ldc 248
    //   72: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_0
    //   76: getfield 67	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mService	Lcom/tencent/mobileqq/mini/launch/IAppBrandService;
    //   79: aload_1
    //   80: aload_2
    //   81: aload_3
    //   82: invokeinterface 224 4 0
    //   87: goto -47 -> 40
    //   90: astore_1
    //   91: ldc 17
    //   93: iconst_1
    //   94: ldc 221
    //   96: aload_1
    //   97: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   100: goto -60 -> 40
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	AppBrandProxyImpl
    //   0	108	1	paramString	String
    //   0	108	2	paramMiniAppConfig	MiniAppConfig
    //   0	108	3	paramBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   43	63	90	java/lang/Throwable
    //   67	87	90	java/lang/Throwable
    //   2	15	103	finally
    //   15	40	103	finally
    //   43	63	103	finally
    //   67	87	103	finally
    //   91	100	103	finally
  }
  
  /* Error */
  public void onAppStop(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_4
    //   4: putfield 189	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mMiniAppStatus	I
    //   7: aload_0
    //   8: invokevirtual 228	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:getService	()Lcom/tencent/mobileqq/mini/launch/IAppBrandService;
    //   11: ifnonnull +14 -> 25
    //   14: ldc 17
    //   16: iconst_1
    //   17: ldc 251
    //   19: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: ldc 17
    //   27: iconst_1
    //   28: ldc 253
    //   30: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 67	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:mService	Lcom/tencent/mobileqq/mini/launch/IAppBrandService;
    //   37: aload_1
    //   38: aload_2
    //   39: aload_3
    //   40: invokeinterface 255 4 0
    //   45: aload_0
    //   46: invokevirtual 258	com/tencent/mobileqq/mini/launch/AppBrandProxyImpl:releaseService	()V
    //   49: goto -27 -> 22
    //   52: astore_1
    //   53: ldc 17
    //   55: iconst_1
    //   56: ldc_w 260
    //   59: aload_1
    //   60: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   63: goto -41 -> 22
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	AppBrandProxyImpl
    //   0	71	1	paramString	String
    //   0	71	2	paramMiniAppConfig	MiniAppConfig
    //   0	71	3	paramBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   25	49	52	java/lang/Throwable
    //   2	22	66	finally
    //   25	49	66	finally
    //   53	63	66	finally
  }
  
  public void preloadPackage(@NonNull MiniAppInfo paramMiniAppInfo)
  {
    IAppBrandService localIAppBrandService = getService();
    paramMiniAppInfo = new AppBrandProxyImpl.4(this, localIAppBrandService, paramMiniAppInfo);
    if (localIAppBrandService != null)
    {
      paramMiniAppInfo.run();
      return;
    }
    this.mTaskAfterConnected.add(paramMiniAppInfo);
  }
  
  protected void releaseService()
  {
    QLog.w("miniapp-process_AppBrandProxy", 1, "releaseService.");
    try
    {
      if (this.mService != null)
      {
        this.mContext.unbindService(this.mConnection);
        this.mService = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("miniapp-process_AppBrandProxy", 1, "exception when releaseService.");
    }
  }
  
  public void sendCmd(String paramString, Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    if (getService() == null)
    {
      QLog.e("miniapp-process_AppBrandProxy", 1, "sendCmd IAppBrandService Connection is Null. cmd=" + paramString);
      this.mTaskAfterConnected.add(new AppBrandProxyImpl.5(this, paramString, paramCmdCallback, paramBundle));
      return;
    }
    try
    {
      this.mService.sendCmd(paramString, paramBundle, paramCmdCallback);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("miniapp-process_AppBrandProxy", 1, "sendCmd exception.", paramString);
    }
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver)
  {
    if (getService() == null)
    {
      QLog.e("miniapp-process_AppBrandProxy", 1, "startMiniApp IAppBrandService Connection is Null.");
      this.mTaskAfterConnected.add(new AppBrandProxyImpl.2(this, paramMiniAppConfig, paramResultReceiver, paramActivity));
      return;
    }
    try
    {
      this.mService.startMiniApp(paramMiniAppConfig, new AppBrandProxyImpl.3(this, new Handler(Looper.getMainLooper()), paramResultReceiver, paramActivity, paramMiniAppConfig));
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.e("miniapp-process_AppBrandProxy", 1, "startMiniApp exception.", paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandProxyImpl
 * JD-Core Version:    0.7.0.1
 */