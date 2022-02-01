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

public class MultiLoaderPluginProcessService
  extends BasePluginProcessService
{
  static final BasePluginProcessService.ActivityHolder sActivityHolder = new BasePluginProcessService.ActivityHolder();
  private HashMap<String, PluginLoaderImpl> mPluginLoaderMap = new HashMap();
  private final MultiLoaderPpsBinder mPpsControllerBinder = new MultiLoaderPpsBinder(this);
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
  void loadPluginLoaderForPlugin(String paramString1, String paramString2)
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
    //   42: getfield 122	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   45: invokeinterface 127 1 0
    //   50: ifeq +45 -> 95
    //   53: aload_0
    //   54: getfield 122	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
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
    //   97: invokespecial 175	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:checkUuidManagerNotNull	(Ljava/lang/String;)Lcom/tencent/shadow/dynamic/host/UuidManager;
    //   100: astore 4
    //   102: aload_0
    //   103: aload_1
    //   104: aload_2
    //   105: invokespecial 177	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:addUuidForPlugin	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_0
    //   109: getfield 44	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:mPluginLoaderMap	Ljava/util/HashMap;
    //   112: aload_1
    //   113: invokevirtual 52	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: astore 5
    //   118: aload 5
    //   120: ifnonnull +380 -> 500
    //   123: aload 4
    //   125: aload_2
    //   126: invokeinterface 181 2 0
    //   131: astore 5
    //   133: aload_0
    //   134: getfield 122	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   137: invokeinterface 127 1 0
    //   142: ifeq +64 -> 206
    //   145: aload_0
    //   146: getfield 122	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
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
    //   223: ifeq +42 -> 265
    //   226: new 200	com/tencent/shadow/dynamic/host/LoaderImplLoader
    //   229: dup
    //   230: invokespecial 201	com/tencent/shadow/dynamic/host/LoaderImplLoader:<init>	()V
    //   233: aload 5
    //   235: aload_2
    //   236: aload_0
    //   237: invokevirtual 205	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:getApplicationContext	()Landroid/content/Context;
    //   240: invokevirtual 209	com/tencent/shadow/dynamic/host/LoaderImplLoader:load	(Lcom/tencent/shadow/core/common/InstalledApk;Ljava/lang/String;Landroid/content/Context;)Lcom/tencent/shadow/dynamic/host/PluginLoaderImpl;
    //   243: astore_2
    //   244: aload_2
    //   245: aload 4
    //   247: invokeinterface 215 2 0
    //   252: aload_0
    //   253: getfield 44	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:mPluginLoaderMap	Ljava/util/HashMap;
    //   256: aload_1
    //   257: aload_2
    //   258: invokevirtual 86	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   261: pop
    //   262: aload_0
    //   263: monitorexit
    //   264: return
    //   265: new 62	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   272: astore_1
    //   273: aload_1
    //   274: aload_3
    //   275: invokevirtual 218	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   278: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_1
    //   283: ldc 220
    //   285: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: new 75	com/tencent/shadow/dynamic/host/FailedException
    //   292: dup
    //   293: iconst_3
    //   294: aload_1
    //   295: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokespecial 82	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   301: athrow
    //   302: astore_1
    //   303: new 62	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   310: astore_2
    //   311: aload_2
    //   312: aload_3
    //   313: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_2
    //   318: ldc 222
    //   320: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload_2
    //   325: aload_1
    //   326: invokevirtual 225	com/tencent/shadow/dynamic/host/NotFoundException:getMessage	()Ljava/lang/String;
    //   329: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: new 75	com/tencent/shadow/dynamic/host/FailedException
    //   336: dup
    //   337: iconst_3
    //   338: aload_2
    //   339: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokespecial 82	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   345: athrow
    //   346: astore_1
    //   347: aload_0
    //   348: getfield 122	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   351: invokeinterface 228 1 0
    //   356: ifeq +15 -> 371
    //   359: aload_0
    //   360: getfield 122	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   363: ldc 230
    //   365: aload_1
    //   366: invokeinterface 234 3 0
    //   371: new 75	com/tencent/shadow/dynamic/host/FailedException
    //   374: dup
    //   375: iconst_5
    //   376: aload_1
    //   377: invokevirtual 235	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   380: invokespecial 82	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   383: athrow
    //   384: aload_0
    //   385: getfield 122	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   388: invokeinterface 228 1 0
    //   393: ifeq +15 -> 408
    //   396: aload_0
    //   397: getfield 122	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   400: ldc 237
    //   402: aload_1
    //   403: invokeinterface 234 3 0
    //   408: aload_1
    //   409: invokevirtual 241	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   412: ifnull +14 -> 426
    //   415: aload_1
    //   416: invokevirtual 241	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   419: invokevirtual 244	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   422: astore_1
    //   423: goto +8 -> 431
    //   426: aload_1
    //   427: invokevirtual 245	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   430: astore_1
    //   431: new 62	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   438: astore_2
    //   439: aload_2
    //   440: ldc 247
    //   442: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload_2
    //   447: aload_1
    //   448: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: new 75	com/tencent/shadow/dynamic/host/FailedException
    //   455: dup
    //   456: iconst_2
    //   457: aload_2
    //   458: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokespecial 82	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   464: athrow
    //   465: aload_1
    //   466: athrow
    //   467: aload_0
    //   468: getfield 122	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   471: invokeinterface 228 1 0
    //   476: ifeq +15 -> 491
    //   479: aload_0
    //   480: getfield 122	com/tencent/shadow/dynamic/host/MultiLoaderPluginProcessService:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   483: ldc 249
    //   485: aload_1
    //   486: invokeinterface 234 3 0
    //   491: new 75	com/tencent/shadow/dynamic/host/FailedException
    //   494: dup
    //   495: aload_1
    //   496: invokespecial 252	com/tencent/shadow/dynamic/host/FailedException:<init>	(Ljava/lang/RuntimeException;)V
    //   499: athrow
    //   500: new 75	com/tencent/shadow/dynamic/host/FailedException
    //   503: dup
    //   504: bipush 8
    //   506: ldc 254
    //   508: invokespecial 82	com/tencent/shadow/dynamic/host/FailedException:<init>	(ILjava/lang/String;)V
    //   511: athrow
    //   512: astore_1
    //   513: aload_0
    //   514: monitorexit
    //   515: aload_1
    //   516: athrow
    //   517: astore_1
    //   518: goto -134 -> 384
    //   521: astore_1
    //   522: goto -57 -> 465
    //   525: astore_1
    //   526: goto -59 -> 467
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	529	0	this	MultiLoaderPluginProcessService
    //   0	529	1	paramString1	String
    //   0	529	2	paramString2	String
    //   9	304	3	localObject1	Object
    //   57	189	4	localObject2	Object
    //   66	168	5	localObject3	Object
    //   149	46	6	localLogger	Logger
    //   158	39	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   123	206	302	com/tencent/shadow/dynamic/host/NotFoundException
    //   123	206	346	android/os/RemoteException
    //   2	95	512	finally
    //   95	118	512	finally
    //   123	206	512	finally
    //   206	262	512	finally
    //   265	302	512	finally
    //   303	346	512	finally
    //   347	371	512	finally
    //   371	384	512	finally
    //   384	408	512	finally
    //   408	423	512	finally
    //   426	431	512	finally
    //   431	465	512	finally
    //   465	467	512	finally
    //   467	491	512	finally
    //   491	500	512	finally
    //   500	512	512	finally
    //   123	206	517	java/lang/Exception
    //   206	262	517	java/lang/Exception
    //   265	302	517	java/lang/Exception
    //   303	346	517	java/lang/Exception
    //   347	371	517	java/lang/Exception
    //   371	384	517	java/lang/Exception
    //   123	206	521	com/tencent/shadow/dynamic/host/FailedException
    //   206	262	521	com/tencent/shadow/dynamic/host/FailedException
    //   265	302	521	com/tencent/shadow/dynamic/host/FailedException
    //   303	346	521	com/tencent/shadow/dynamic/host/FailedException
    //   347	371	521	com/tencent/shadow/dynamic/host/FailedException
    //   371	384	521	com/tencent/shadow/dynamic/host/FailedException
    //   123	206	525	java/lang/RuntimeException
    //   206	262	525	java/lang/RuntimeException
    //   265	302	525	java/lang/RuntimeException
    //   303	346	525	java/lang/RuntimeException
    //   347	371	525	java/lang/RuntimeException
    //   371	384	525	java/lang/RuntimeException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.MultiLoaderPluginProcessService
 * JD-Core Version:    0.7.0.1
 */