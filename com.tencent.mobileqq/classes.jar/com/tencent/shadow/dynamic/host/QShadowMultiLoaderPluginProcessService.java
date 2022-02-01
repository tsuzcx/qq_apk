package com.tencent.shadow.dynamic.host;

import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.core.common.Logger;
import java.util.HashMap;

public class QShadowMultiLoaderPluginProcessService
  extends BasePluginProcessService
{
  static final BasePluginProcessService.ActivityHolder sActivityHolder = new BasePluginProcessService.ActivityHolder();
  private HashMap<String, PluginLoaderImpl> mPluginLoaderMap = new HashMap();
  private final QShadowMultiLoaderPpsBinder mPpsControllerBinder = new QShadowMultiLoaderPpsBinder(this);
  private HashMap<String, Boolean> mRuntimeLoadedMap = new HashMap();
  private HashMap<String, UuidManager> mUuidManagerMap = new HashMap();
  private HashMap<String, String> mUuidMap = new HashMap();
  
  private void addUuidForPlugin(String paramString1, String paramString2)
  {
    String str = (String)this.mUuidMap.get(paramString1);
    if ((str != null) && (!TextUtils.equals(paramString2, str)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Plugin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("已设置过uuid==");
      localStringBuilder.append(str);
      localStringBuilder.append(", 试图设置uuid==");
      localStringBuilder.append(paramString2);
      throw new FailedException(6, localStringBuilder.toString());
    }
    if (str == null) {
      this.mUuidMap.put(paramString1, paramString2);
    }
  }
  
  private UuidManager checkUuidManagerNotNull(String paramString)
  {
    paramString = (UuidManager)this.mUuidManagerMap.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    throw new FailedException(4, "mUuidManager == null");
  }
  
  public static Application.ActivityLifecycleCallbacks getActivityHolder()
  {
    return sActivityHolder;
  }
  
  private boolean isRuntimeLoaded(String paramString)
  {
    paramString = (Boolean)this.mRuntimeLoadedMap.get(paramString);
    return (paramString != null) && (paramString.booleanValue());
  }
  
  private void markRuntimeLoaded(String paramString)
  {
    this.mRuntimeLoadedMap.put(paramString, Boolean.valueOf(true));
  }
  
  public static MultiLoaderPpsController wrapBinder(IBinder paramIBinder)
  {
    return new MultiLoaderPpsController(paramIBinder);
  }
  
  void exit()
  {
    if (this.mLogger.isInfoEnabled()) {
      this.mLogger.info("exit ");
    }
    sActivityHolder.finishAll();
    System.exit(0);
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  IBinder getPluginLoaderForPlugin(String paramString)
  {
    try
    {
      paramString = (IBinder)this.mPluginLoaderMap.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  PpsStatus getPpsStatusForPlugin(String paramString)
  {
    for (;;)
    {
      try
      {
        String str = (String)this.mUuidMap.get(paramString);
        boolean bool3 = isRuntimeLoaded(paramString);
        Object localObject = this.mPluginLoaderMap.get(paramString);
        bool2 = true;
        if (localObject != null)
        {
          bool1 = true;
          if (this.mUuidManagerMap.get(paramString) == null) {
            break label86;
          }
          paramString = new PpsStatus(str, bool3, bool1, bool2);
          return paramString;
        }
      }
      finally {}
      boolean bool1 = false;
      continue;
      label86:
      boolean bool2 = false;
    }
  }
  
  /* Error */
  protected void loadPluginLoaderForPlugin(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 62	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: ldc 169
    //   13: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_3
    //   18: aload_1
    //   19: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_3
    //   24: ldc 171
    //   26: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_3
    //   31: aload_2
    //   32: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore_3
    //   41: aload_0
    //   42: getfield 122	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   45: invokeinterface 127 1 0
    //   50: ifeq +45 -> 95
    //   53: aload_0
    //   54: getfield 122	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   57: astore 4
    //   59: new 62	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   66: astore 5
    //   68: aload 5
    //   70: ldc 173
    //   72: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 5
    //   78: aload_3
    //   79: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 4
    //   85: aload 5
    //   87: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokeinterface 132 2 0
    //   95: aload_0
    //   96: aload_1
    //   97: invokespecial 175	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:checkUuidManagerNotNull	(Ljava/lang/String;)Lcom/tencent/shadow/dynamic/host/UuidManager;
    //   100: astore 4
    //   102: aload_0
    //   103: aload_1
    //   104: aload_2
    //   105: invokespecial 177	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:addUuidForPlugin	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_0
    //   109: getfield 44	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:mPluginLoaderMap	Ljava/util/HashMap;
    //   112: aload_1
    //   113: invokevirtual 52	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: astore 5
    //   118: aload 5
    //   120: ifnonnull +432 -> 552
    //   123: aload 4
    //   125: aload_2
    //   126: invokeinterface 181 2 0
    //   131: astore 5
    //   133: aload_0
    //   134: getfield 122	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   137: invokeinterface 127 1 0
    //   142: ifeq +64 -> 206
    //   145: aload_0
    //   146: getfield 122	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   149: astore 6
    //   151: new 62	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   158: astore 7
    //   160: aload 7
    //   162: ldc 183
    //   164: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 7
    //   170: aload_3
    //   171: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 7
    //   177: ldc 185
    //   179: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 7
    //   185: aload 5
    //   187: getfield 191	com/tencent/shadow/core/common/InstalledApk:apkFilePath	Ljava/lang/String;
    //   190: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 6
    //   196: aload 7
    //   198: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokeinterface 132 2 0
    //   206: new 193	java/io/File
    //   209: dup
    //   210: aload 5
    //   212: getfield 191	com/tencent/shadow/core/common/InstalledApk:apkFilePath	Ljava/lang/String;
    //   215: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;)V
    //   218: astore_3
    //   219: aload_3
    //   220: invokevirtual 198	java/io/File:exists	()Z
    //   223: ifeq +94 -> 317
    //   226: new 200	com/tencent/shadow/dynamic/host/QShadowLoaderImplLoader
    //   229: dup
    //   230: invokespecial 201	com/tencent/shadow/dynamic/host/QShadowLoaderImplLoader:<init>	()V
    //   233: aload 5
    //   235: aload_2
    //   236: aload_0
    //   237: invokevirtual 205	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:getApplicationContext	()Landroid/content/Context;
    //   240: invokevirtual 209	com/tencent/shadow/dynamic/host/QShadowLoaderImplLoader:load	(Lcom/tencent/shadow/core/common/InstalledApk;Ljava/lang/String;Landroid/content/Context;)Lcom/tencent/shadow/dynamic/host/PluginLoaderImpl;
    //   243: astore_2
    //   244: aload_0
    //   245: getfield 122	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   248: invokeinterface 127 1 0
    //   253: ifeq +43 -> 296
    //   256: aload_0
    //   257: getfield 122	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   260: astore_3
    //   261: new 62	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   268: astore 5
    //   270: aload 5
    //   272: ldc 211
    //   274: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 5
    //   280: aload_1
    //   281: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_3
    //   286: aload 5
    //   288: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokeinterface 132 2 0
    //   296: aload_2
    //   297: aload 4
    //   299: invokeinterface 217 2 0
    //   304: aload_0
    //   305: getfield 44	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:mPluginLoaderMap	Ljava/util/HashMap;
    //   308: aload_1
    //   309: aload_2
    //   310: invokevirtual 86	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   313: pop
    //   314: aload_0
    //   315: monitorexit
    //   316: return
    //   317: new 62	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   324: astore_1
    //   325: aload_1
    //   326: aload_3
    //   327: invokevirtual 220	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   330: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_1
    //   335: ldc 222
    //   337: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: new 75	com/tencent/shadow/dynamic/host/FailedException
    //   344: dup
    //   345: iconst_3
    //   346: aload_1
    //   347: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokespecial 82	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   353: athrow
    //   354: astore_1
    //   355: new 62	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   362: astore_2
    //   363: aload_2
    //   364: aload_3
    //   365: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload_2
    //   370: ldc 224
    //   372: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_2
    //   377: aload_1
    //   378: invokevirtual 227	com/tencent/shadow/dynamic/host/NotFoundException:getMessage	()Ljava/lang/String;
    //   381: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: new 75	com/tencent/shadow/dynamic/host/FailedException
    //   388: dup
    //   389: iconst_3
    //   390: aload_2
    //   391: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokespecial 82	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   397: athrow
    //   398: astore_1
    //   399: aload_0
    //   400: getfield 122	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   403: invokeinterface 230 1 0
    //   408: ifeq +15 -> 423
    //   411: aload_0
    //   412: getfield 122	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   415: ldc 232
    //   417: aload_1
    //   418: invokeinterface 236 3 0
    //   423: new 75	com/tencent/shadow/dynamic/host/FailedException
    //   426: dup
    //   427: iconst_5
    //   428: aload_1
    //   429: invokevirtual 237	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   432: invokespecial 82	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   435: athrow
    //   436: aload_0
    //   437: getfield 122	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   440: invokeinterface 230 1 0
    //   445: ifeq +15 -> 460
    //   448: aload_0
    //   449: getfield 122	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   452: ldc 239
    //   454: aload_1
    //   455: invokeinterface 236 3 0
    //   460: aload_1
    //   461: invokevirtual 243	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   464: ifnull +14 -> 478
    //   467: aload_1
    //   468: invokevirtual 243	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   471: invokevirtual 246	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   474: astore_1
    //   475: goto +8 -> 483
    //   478: aload_1
    //   479: invokevirtual 247	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   482: astore_1
    //   483: new 62	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   490: astore_2
    //   491: aload_2
    //   492: ldc 249
    //   494: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload_2
    //   499: aload_1
    //   500: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: new 75	com/tencent/shadow/dynamic/host/FailedException
    //   507: dup
    //   508: iconst_2
    //   509: aload_2
    //   510: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokespecial 82	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   516: athrow
    //   517: aload_1
    //   518: athrow
    //   519: aload_0
    //   520: getfield 122	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   523: invokeinterface 230 1 0
    //   528: ifeq +15 -> 543
    //   531: aload_0
    //   532: getfield 122	com/tencent/shadow/dynamic/host/QShadowMultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   535: ldc 251
    //   537: aload_1
    //   538: invokeinterface 236 3 0
    //   543: new 75	com/tencent/shadow/dynamic/host/FailedException
    //   546: dup
    //   547: aload_1
    //   548: invokespecial 254	com/tencent/shadow/dynamic/host/FailedException:<init>	(Ljava/lang/RuntimeException;)V
    //   551: athrow
    //   552: new 75	com/tencent/shadow/dynamic/host/FailedException
    //   555: dup
    //   556: bipush 8
    //   558: ldc_w 256
    //   561: invokespecial 82	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   564: athrow
    //   565: astore_1
    //   566: aload_0
    //   567: monitorexit
    //   568: aload_1
    //   569: athrow
    //   570: astore_1
    //   571: goto -135 -> 436
    //   574: astore_1
    //   575: goto -58 -> 517
    //   578: astore_1
    //   579: goto -60 -> 519
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	QShadowMultiLoaderPluginProcessService
    //   0	582	1	paramString1	String
    //   0	582	2	paramString2	String
    //   9	356	3	localObject1	Object
    //   57	241	4	localObject2	Object
    //   66	221	5	localObject3	Object
    //   149	46	6	localLogger	Logger
    //   158	39	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   123	206	354	com/tencent/shadow/dynamic/host/NotFoundException
    //   123	206	398	android/os/RemoteException
    //   2	95	565	finally
    //   95	118	565	finally
    //   123	206	565	finally
    //   206	296	565	finally
    //   296	314	565	finally
    //   317	354	565	finally
    //   355	398	565	finally
    //   399	423	565	finally
    //   423	436	565	finally
    //   436	460	565	finally
    //   460	475	565	finally
    //   478	483	565	finally
    //   483	517	565	finally
    //   517	519	565	finally
    //   519	543	565	finally
    //   543	552	565	finally
    //   552	565	565	finally
    //   123	206	570	java/lang/Exception
    //   206	296	570	java/lang/Exception
    //   296	314	570	java/lang/Exception
    //   317	354	570	java/lang/Exception
    //   355	398	570	java/lang/Exception
    //   399	423	570	java/lang/Exception
    //   423	436	570	java/lang/Exception
    //   123	206	574	com/tencent/shadow/dynamic/host/FailedException
    //   206	296	574	com/tencent/shadow/dynamic/host/FailedException
    //   296	314	574	com/tencent/shadow/dynamic/host/FailedException
    //   317	354	574	com/tencent/shadow/dynamic/host/FailedException
    //   355	398	574	com/tencent/shadow/dynamic/host/FailedException
    //   399	423	574	com/tencent/shadow/dynamic/host/FailedException
    //   423	436	574	com/tencent/shadow/dynamic/host/FailedException
    //   123	206	578	java/lang/RuntimeException
    //   206	296	578	java/lang/RuntimeException
    //   296	314	578	java/lang/RuntimeException
    //   317	354	578	java/lang/RuntimeException
    //   355	398	578	java/lang/RuntimeException
    //   399	423	578	java/lang/RuntimeException
    //   423	436	578	java/lang/RuntimeException
  }
  
  void loadRuntimeForPlugin(String paramString1, String paramString2)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pluginKey=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("|uuid=");
      ((StringBuilder)localObject1).append(paramString2);
      localObject1 = ((StringBuilder)localObject1).toString();
      if (this.mLogger.isInfoEnabled())
      {
        localObject2 = this.mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadRuntimeForPlugin:");
        localStringBuilder.append((String)localObject1);
        ((Logger)localObject2).info(localStringBuilder.toString());
      }
      Object localObject2 = checkUuidManagerNotNull(paramString1);
      addUuidForPlugin(paramString1, paramString2);
      boolean bool = isRuntimeLoaded(paramString1);
      if (!bool)
      {
        try
        {
          localObject1 = ((UuidManager)localObject2).getRuntime(paramString2);
          paramString2 = new InstalledApk(((InstalledApk)localObject1).apkFilePath, ((InstalledApk)localObject1).oDexPath, ((InstalledApk)localObject1).libraryPath);
          MultiDynamicContainer.loadContainerApk(paramString1, paramString2);
          markRuntimeLoaded(paramString1);
          DynamicRuntime.saveLastRuntimeInfo(getApplicationContext(), paramString2);
          return;
        }
        catch (RuntimeException paramString1) {}catch (NotFoundException localNotFoundException)
        {
          Log.i("PluginProcessService", "uuidManager.getRuntime new NotFoundException");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("pluginKey=");
          ((StringBuilder)localObject2).append(paramString1);
          ((StringBuilder)localObject2).append(", uuid=");
          ((StringBuilder)localObject2).append(paramString2);
          ((StringBuilder)localObject2).append("的Runtime没有找到。cause:");
          ((StringBuilder)localObject2).append(localNotFoundException.getMessage());
          throw new FailedException(3, ((StringBuilder)localObject2).toString());
        }
        catch (RemoteException paramString1)
        {
          Log.i("PluginProcessService", "uuidManager.getRuntime new FailedException");
          throw new FailedException(5, paramString1.getMessage());
        }
        if (this.mLogger.isErrorEnabled()) {
          this.mLogger.error("loadRuntimeForPlugin发生RuntimeException", paramString1);
        }
        throw new FailedException(paramString1);
      }
      paramString1 = new StringBuilder();
      paramString1.append("重复调用loadRuntime,");
      paramString1.append(localNotFoundException);
      throw new FailedException(7, paramString1.toString());
    }
    finally {}
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.mLogger.isInfoEnabled())
    {
      paramIntent = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBind:");
      localStringBuilder.append(this);
      paramIntent.info(localStringBuilder.toString());
    }
    return this.mPpsControllerBinder;
  }
  
  void setUuidManagerForPlugin(String paramString, UuidManager paramUuidManager)
  {
    try
    {
      if (this.mLogger.isInfoEnabled())
      {
        Logger localLogger = this.mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setUuidManagerForPlugin pluginKey=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", uuidManager==");
        localStringBuilder.append(paramUuidManager);
        localLogger.info(localStringBuilder.toString());
      }
      this.mUuidManagerMap.put(paramString, paramUuidManager);
      paramString = (PluginLoaderImpl)this.mPluginLoaderMap.get(paramString);
      if (paramString != null)
      {
        if (this.mLogger.isInfoEnabled()) {
          this.mLogger.info("更新PluginLoader的uuidManager");
        }
        paramString.setUuidManager(paramUuidManager);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.QShadowMultiLoaderPluginProcessService
 * JD-Core Version:    0.7.0.1
 */