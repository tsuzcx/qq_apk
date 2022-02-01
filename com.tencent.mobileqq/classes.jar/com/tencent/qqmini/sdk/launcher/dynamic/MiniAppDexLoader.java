package com.tencent.qqmini.sdk.launcher.dynamic;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

@MiniKeep
public class MiniAppDexLoader
{
  public static final String MAIN_KEY_MINI_APP = "qqminiapp";
  public static final String MINI_APP_GOOGLE_PLAY_LOAD_SO_SWITCH = "mini_app_google_play_load_so_switch";
  public static final String TAG = "minisdk-MiniAppDexLoader";
  private static volatile MiniAppDexLoader instance;
  private static volatile byte[] lock = new byte[0];
  protected Context mContext;
  private MiniDexConfig mDexConfig;
  private String mDexConfigStr;
  private boolean mDexEnable = true;
  private boolean mDexLoaded = false;
  private ClassLoader mNewClassLoader;
  
  public static MiniAppDexLoader g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new MiniAppDexLoader();
      }
      return instance;
    }
  }
  
  private String getDexPath()
  {
    Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "sdk.jar";
    if (new File((String)localObject).exists()) {
      return localObject;
    }
    if (TextUtils.isEmpty(this.mDexConfigStr))
    {
      QMLog.w("minisdk-MiniAppDexLoader", "Dex Config is empty.");
      return null;
    }
    MiniDynamicManager.g().updateDexConfig(this.mDexConfigStr);
    localObject = MiniDynamicManager.g().getValidDexConfig();
    if (localObject != null)
    {
      this.mDexConfig = ((MiniDexConfig)localObject);
      return ((MiniDexConfig)localObject).getDexPath();
    }
    return null;
  }
  
  /* Error */
  public Object create(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 123	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   4: ifnonnull +7 -> 11
    //   7: aload_0
    //   8: invokevirtual 126	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:loadDex	()V
    //   11: ldc 15
    //   13: new 50	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   20: ldc 128
    //   22: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 131	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 123	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   39: ifnull +53 -> 92
    //   42: aload_1
    //   43: aload_0
    //   44: getfield 123	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   47: invokestatic 137	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:on	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lcom/tencent/qqmini/sdk/launcher/dynamic/Reflect;
    //   50: invokevirtual 140	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:create	()Lcom/tencent/qqmini/sdk/launcher/dynamic/Reflect;
    //   53: invokevirtual 144	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:get	()Ljava/lang/Object;
    //   56: astore_2
    //   57: ldc 15
    //   59: new 50	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   66: ldc 128
    //   68: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_1
    //   72: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 146
    //   77: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_2
    //   81: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 131	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_2
    //   91: areturn
    //   92: aload_1
    //   93: aload_0
    //   94: invokevirtual 153	java/lang/Object:getClass	()Ljava/lang/Class;
    //   97: invokevirtual 159	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   100: invokestatic 137	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:on	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lcom/tencent/qqmini/sdk/launcher/dynamic/Reflect;
    //   103: invokevirtual 140	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:create	()Lcom/tencent/qqmini/sdk/launcher/dynamic/Reflect;
    //   106: invokevirtual 144	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:get	()Ljava/lang/Object;
    //   109: astore_2
    //   110: aload_2
    //   111: areturn
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_2
    //   115: ldc 15
    //   117: new 50	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   124: ldc 161
    //   126: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 163
    //   135: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_3
    //   139: invokevirtual 166	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   142: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 97	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_1
    //   152: aload_0
    //   153: invokevirtual 153	java/lang/Object:getClass	()Ljava/lang/Class;
    //   156: invokevirtual 159	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   159: invokestatic 137	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:on	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lcom/tencent/qqmini/sdk/launcher/dynamic/Reflect;
    //   162: invokevirtual 140	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:create	()Lcom/tencent/qqmini/sdk/launcher/dynamic/Reflect;
    //   165: invokevirtual 144	com/tencent/qqmini/sdk/launcher/dynamic/Reflect:get	()Ljava/lang/Object;
    //   168: astore 4
    //   170: aload 4
    //   172: areturn
    //   173: astore 4
    //   175: ldc 15
    //   177: new 50	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   184: ldc 161
    //   186: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_1
    //   190: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 163
    //   195: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: aload_3
    //   202: invokestatic 169	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_2
    //   206: areturn
    //   207: astore_3
    //   208: goto -93 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	MiniAppDexLoader
    //   0	211	1	paramString	String
    //   56	150	2	localObject1	Object
    //   112	90	3	localException1	java.lang.Exception
    //   207	1	3	localException2	java.lang.Exception
    //   168	3	4	localObject2	Object
    //   173	1	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	11	112	java/lang/Exception
    //   11	57	112	java/lang/Exception
    //   92	110	112	java/lang/Exception
    //   151	170	173	java/lang/Throwable
    //   57	90	207	java/lang/Exception
  }
  
  /* Error */
  public java.lang.Class findClass(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 123	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   4: ifnonnull +7 -> 11
    //   7: aload_0
    //   8: invokevirtual 126	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:loadDex	()V
    //   11: ldc 15
    //   13: new 50	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   20: ldc 173
    //   22: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 131	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 123	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   39: ifnull +47 -> 86
    //   42: aload_0
    //   43: getfield 123	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   46: aload_1
    //   47: invokevirtual 178	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   50: astore_2
    //   51: ldc 15
    //   53: new 50	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   60: ldc 173
    //   62: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 180
    //   71: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_2
    //   75: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 131	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_2
    //   85: areturn
    //   86: aload_0
    //   87: invokevirtual 153	java/lang/Object:getClass	()Ljava/lang/Class;
    //   90: invokevirtual 159	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   93: aload_1
    //   94: invokevirtual 178	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   97: astore_2
    //   98: aload_2
    //   99: areturn
    //   100: astore_3
    //   101: aconst_null
    //   102: astore_2
    //   103: ldc 15
    //   105: new 50	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   112: ldc 173
    //   114: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_1
    //   118: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 163
    //   123: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_3
    //   127: invokevirtual 166	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   130: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 97	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: invokevirtual 153	java/lang/Object:getClass	()Ljava/lang/Class;
    //   143: invokevirtual 159	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   146: aload_1
    //   147: invokevirtual 178	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   150: astore 4
    //   152: aload 4
    //   154: areturn
    //   155: astore 4
    //   157: ldc 15
    //   159: new 50	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   166: ldc 173
    //   168: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc 163
    //   177: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: aload_3
    //   184: invokestatic 169	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   187: aload_2
    //   188: areturn
    //   189: astore_3
    //   190: goto -87 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	MiniAppDexLoader
    //   0	193	1	paramString	String
    //   50	138	2	localClass1	java.lang.Class
    //   100	84	3	localException1	java.lang.Exception
    //   189	1	3	localException2	java.lang.Exception
    //   150	3	4	localClass2	java.lang.Class
    //   155	1	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	11	100	java/lang/Exception
    //   11	51	100	java/lang/Exception
    //   86	98	100	java/lang/Exception
    //   139	152	155	java/lang/Throwable
    //   51	84	189	java/lang/Exception
  }
  
  public MiniDexConfig getDexConfig()
  {
    return this.mDexConfig;
  }
  
  public boolean hasNewDex()
  {
    String str = getDexPath();
    if (TextUtils.isEmpty(str)) {
      QMLog.i("minisdk-MiniAppDexLoader", "There's not a dex to be loaded.");
    }
    while (!new File(str).exists()) {
      return false;
    }
    QMLog.i("minisdk-MiniAppDexLoader", "load dexPath : " + str);
    return true;
  }
  
  public void init(Context paramContext, boolean paramBoolean, String paramString)
  {
    this.mContext = paramContext;
    this.mDexEnable = paramBoolean;
    this.mDexConfigStr = paramString;
    QMLog.w("minisdk-MiniAppDexLoader", "enableDex: " + paramBoolean + " dexConfig:" + this.mDexConfigStr);
  }
  
  /* Error */
  public void loadDex()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:mDexEnable	Z
    //   6: ifeq +19 -> 25
    //   9: aload_0
    //   10: getfield 41	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:mDexLoaded	Z
    //   13: ifne +12 -> 25
    //   16: aload_0
    //   17: getfield 191	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:mContext	Landroid/content/Context;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnonnull +6 -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: invokevirtual 200	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:hasNewDex	()Z
    //   32: ifeq +42 -> 74
    //   35: aload_0
    //   36: getfield 123	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   39: ifnonnull +35 -> 74
    //   42: aload_0
    //   43: new 202	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppClassloader
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 183	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:getDexPath	()Ljava/lang/String;
    //   51: aload_0
    //   52: getfield 191	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:mContext	Landroid/content/Context;
    //   55: invokevirtual 208	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   58: getfield 213	android/content/pm/ApplicationInfo:nativeLibraryDir	Ljava/lang/String;
    //   61: aload_0
    //   62: invokevirtual 153	java/lang/Object:getClass	()Ljava/lang/Class;
    //   65: invokevirtual 159	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   68: invokespecial 216	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppClassloader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   71: putfield 123	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   74: invokestatic 221	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   77: invokevirtual 224	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:isMainProcess	()Z
    //   80: ifne +13 -> 93
    //   83: new 226	com/tencent/qqmini/sdk/launcher/MiniCrashHandler
    //   86: dup
    //   87: invokespecial 227	com/tencent/qqmini/sdk/launcher/MiniCrashHandler:<init>	()V
    //   90: invokestatic 233	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   93: aload_0
    //   94: iconst_1
    //   95: putfield 41	com/tencent/qqmini/sdk/launcher/dynamic/MiniAppDexLoader:mDexLoaded	Z
    //   98: goto -73 -> 25
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	MiniAppDexLoader
    //   20	2	1	localContext	Context
    //   101	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	101	finally
    //   28	74	101	finally
    //   74	93	101	finally
    //   93	98	101	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.MiniAppDexLoader
 * JD-Core Version:    0.7.0.1
 */