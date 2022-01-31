package com.tencent.mobileqq.minigame.manager;

import ajjy;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.oskplayer.util.StorageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mpx;
import org.json.JSONObject;

public class EngineInstaller
{
  public static final String LOG_TAG = "EngineInstaller";
  private static final String ROOT_DIR = "/xminilib/";
  private static String SP_NAME = "x_mini_engine";
  private static volatile List<InstalledEngine> sInstalledEngine;
  private static File sRootDir;
  private boolean isWorking;
  private List<EngineInstaller.Callback> mCallbacks = new ArrayList();
  private AbstractDownloader mDownloader;
  
  public EngineInstaller(AbstractDownloader paramAbstractDownloader)
  {
    this.mDownloader = paramAbstractDownloader;
  }
  
  /* Error */
  private static String getInstallLibDir(File paramFile, EngineVersion paramEngineVersion)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 62	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 68	com/tencent/mobileqq/minigame/manager/EngineVersion:toFolderName	()Ljava/lang/String;
    //   12: invokespecial 71	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_0
    //   16: ldc 8
    //   18: iconst_1
    //   19: new 73	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   26: ldc 76
    //   28: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   35: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: invokevirtual 96	java/io/File:exists	()Z
    //   48: ifne +45 -> 93
    //   51: aload_0
    //   52: invokevirtual 99	java/io/File:mkdirs	()Z
    //   55: ifne +38 -> 93
    //   58: ldc 8
    //   60: iconst_1
    //   61: new 73	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   68: ldc 101
    //   70: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_0
    //   74: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   77: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aconst_null
    //   87: astore_0
    //   88: ldc 2
    //   90: monitorexit
    //   91: aload_0
    //   92: areturn
    //   93: aload_0
    //   94: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   97: astore_0
    //   98: goto -10 -> 88
    //   101: astore_0
    //   102: ldc 2
    //   104: monitorexit
    //   105: aload_0
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramFile	File
    //   0	107	1	paramEngineVersion	EngineVersion
    // Exception table:
    //   from	to	target	type
    //   3	86	101	finally
    //   93	98	101	finally
  }
  
  public static ArrayList<InstalledEngine> getInstalledEngine(int paramInt)
  {
    try
    {
      updateInstalledEngine();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = sInstalledEngine.iterator();
      while (localIterator.hasNext())
      {
        InstalledEngine localInstalledEngine = (InstalledEngine)localIterator.next();
        if (localInstalledEngine.engineType == paramInt) {
          localArrayList.add(localInstalledEngine);
        }
      }
    }
    finally {}
    return localArrayList1;
  }
  
  private static File getRootDir()
  {
    if (sRootDir == null)
    {
      File localFile = new File(BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/xminilib/");
      if ((!localFile.exists()) && (!localFile.mkdirs())) {
        QLog.e("EngineInstaller", 1, "[MiniEng] dir mk failed " + localFile);
      }
      sRootDir = localFile;
    }
    return sRootDir;
  }
  
  public static SharedPreferences getSp()
  {
    return BaseApplication.getContext().getSharedPreferences(SP_NAME, 0);
  }
  
  private void installedFromNetwork(BaseLibInfo paramBaseLibInfo, String paramString, long paramLong, File paramFile, EngineVersion paramEngineVersion, boolean paramBoolean)
  {
    this.mDownloader.setUrl(paramString);
    this.mDownloader.setDownloadListener(new EngineInstaller.1(this, paramBaseLibInfo, paramLong, paramFile, paramString, paramEngineVersion, paramBoolean));
    try
    {
      Thread.sleep(100L);
      label38:
      if (paramBaseLibInfo.baseLibType == 2) {
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 4, "1");
      }
      this.mDownloader.download();
      return;
    }
    catch (InterruptedException paramString)
    {
      break label38;
    }
  }
  
  private static boolean isCurrentPersistGameEngine(File paramFile)
  {
    EngineVersion localEngineVersion = EngineVersion.fromFolderName(paramFile.getName());
    return (localEngineVersion != null) && (localEngineVersion.equals(LocalGameEngine.g().mLocalEngineVersion)) && (isPersistGameEngine(paramFile));
  }
  
  private static boolean isPersistGameEngine(File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile != null)
    {
      bool1 = bool2;
      if (paramFile.exists())
      {
        bool1 = bool2;
        if (paramFile.isDirectory())
        {
          paramFile = paramFile.listFiles(new EngineInstaller.2());
          if (paramFile != null)
          {
            bool1 = bool2;
            if (paramFile.length > 0) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static void removeOldEngine(int paramInt)
  {
    Object localObject2;
    try
    {
      if (sInstalledEngine == null)
      {
        QLog.e("EngineInstaller", 1, "[MiniEng]removeOldEngine null");
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localObject2 = sInstalledEngine.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        InstalledEngine localInstalledEngine = (InstalledEngine)((Iterator)localObject2).next();
        if (localInstalledEngine.engineType == paramInt) {
          localArrayList.add(localInstalledEngine);
        }
      }
      j = localObject1.size();
    }
    finally {}
    int j;
    int i = 0;
    paramInt = 1;
    label100:
    if ((j > 1) && (i < j))
    {
      localObject2 = (InstalledEngine)localObject1.get(i);
      if (((InstalledEngine)localObject2).isPersist)
      {
        QLog.i("EngineInstaller", 1, "[MiniEng] removeOldEngine " + localObject2 + " isPersist, so not deleted");
      }
      else
      {
        if (paramInt == 0)
        {
          ((InstalledEngine)localObject2).deleteFiles();
          sInstalledEngine.remove(localObject2);
          break label232;
        }
        QLog.i("EngineInstaller", 1, "[MiniEng] removeOldEngine " + localObject2 + "  is latest, so kept");
        break label232;
      }
    }
    for (;;)
    {
      i += 1;
      break label100;
      break;
      label232:
      paramInt = 0;
    }
  }
  
  public static void removeOutDatedEngine(int paramInt)
  {
    Object localObject2;
    InstalledEngine localInstalledEngine;
    try
    {
      if (sInstalledEngine == null)
      {
        QLog.e("EngineInstaller", 1, "[MiniEng]removeOutDatedEngine null");
        return;
      }
      localObject2 = new ArrayList();
      Iterator localIterator = sInstalledEngine.iterator();
      while (localIterator.hasNext())
      {
        localInstalledEngine = (InstalledEngine)localIterator.next();
        if (localInstalledEngine.engineType == paramInt) {
          ((List)localObject2).add(localInstalledEngine);
        }
      }
      if (paramInt != 2) {}
    }
    finally {}
    for (EngineVersion localEngineVersion = LocalGameEngine.g().mLocalEngineVersion;; localEngineVersion = null)
    {
      if (localEngineVersion != null)
      {
        QLog.i("EngineInstaller", 1, "[MiniEng] removeOutDatedEngine, localMinVer:" + localEngineVersion);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localInstalledEngine = (InstalledEngine)((Iterator)localObject2).next();
          if ((localInstalledEngine.engineVersion.compareTo(localEngineVersion) < 0) || ((paramInt == 2) && (localInstalledEngine.engineVersion.mMinor.compareTo(localEngineVersion.mMinor) < 0)))
          {
            QLog.i("EngineInstaller", 1, "[MiniEng] removeOutDatedEngine " + localInstalledEngine + " localMinVer:" + localEngineVersion + ",engineType:" + paramInt);
            localInstalledEngine.deleteFiles();
            sInstalledEngine.remove(localInstalledEngine);
          }
          else if ((localInstalledEngine.isPersist) && (!isCurrentPersistGameEngine(new File(localInstalledEngine.engineDir))))
          {
            QLog.i("EngineInstaller", 1, "[MiniEng] removeOutDatedPersistEngine " + localInstalledEngine + " localMinVer:" + localEngineVersion + ",engineType:" + paramInt);
            localInstalledEngine.deleteFiles();
            sInstalledEngine.remove(localInstalledEngine);
          }
        }
        break;
      }
      QLog.w("EngineInstaller", 1, "[MiniEng] removeOutDatedEngine, localMinVer is null");
      break;
    }
  }
  
  /* Error */
  private static List<InstalledEngine> scanInstalledEngine()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 8
    //   5: iconst_1
    //   6: ldc_w 332
    //   9: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: invokestatic 338	java/lang/System:currentTimeMillis	()J
    //   15: lstore 5
    //   17: new 36	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 37	java/util/ArrayList:<init>	()V
    //   24: astore 8
    //   26: invokestatic 340	com/tencent/mobileqq/minigame/manager/EngineInstaller:getRootDir	()Ljava/io/File;
    //   29: astore 9
    //   31: aload 9
    //   33: invokevirtual 96	java/io/File:exists	()Z
    //   36: ifeq +328 -> 364
    //   39: aload 9
    //   41: invokevirtual 250	java/io/File:isDirectory	()Z
    //   44: ifeq +320 -> 364
    //   47: aload 9
    //   49: invokevirtual 343	java/io/File:listFiles	()[Ljava/io/File;
    //   52: astore 9
    //   54: aload 9
    //   56: arraylength
    //   57: istore_2
    //   58: iconst_0
    //   59: istore_0
    //   60: iload_0
    //   61: iload_2
    //   62: if_icmpge +302 -> 364
    //   65: aload 9
    //   67: iload_0
    //   68: aaload
    //   69: astore 10
    //   71: aload 10
    //   73: invokevirtual 96	java/io/File:exists	()Z
    //   76: ifeq +281 -> 357
    //   79: aload 10
    //   81: invokevirtual 250	java/io/File:isDirectory	()Z
    //   84: istore 7
    //   86: iload 7
    //   88: ifeq +269 -> 357
    //   91: aload 10
    //   93: invokevirtual 227	java/io/File:getName	()Ljava/lang/String;
    //   96: invokestatic 348	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   99: istore_3
    //   100: aload 10
    //   102: invokevirtual 343	java/io/File:listFiles	()[Ljava/io/File;
    //   105: astore 10
    //   107: aload 10
    //   109: arraylength
    //   110: istore 4
    //   112: iconst_0
    //   113: istore_1
    //   114: iload_1
    //   115: iload 4
    //   117: if_icmpge +240 -> 357
    //   120: aload 10
    //   122: iload_1
    //   123: aaload
    //   124: astore 11
    //   126: new 128	com/tencent/mobileqq/minigame/manager/InstalledEngine
    //   129: dup
    //   130: invokespecial 349	com/tencent/mobileqq/minigame/manager/InstalledEngine:<init>	()V
    //   133: astore 12
    //   135: aload 12
    //   137: iload_3
    //   138: putfield 132	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineType	I
    //   141: aload 12
    //   143: aload 11
    //   145: invokevirtual 227	java/io/File:getName	()Ljava/lang/String;
    //   148: invokestatic 231	com/tencent/mobileqq/minigame/manager/EngineVersion:fromFolderName	(Ljava/lang/String;)Lcom/tencent/mobileqq/minigame/manager/EngineVersion;
    //   151: putfield 293	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineVersion	Lcom/tencent/mobileqq/minigame/manager/EngineVersion;
    //   154: aload 12
    //   156: getfield 293	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineVersion	Lcom/tencent/mobileqq/minigame/manager/EngineVersion;
    //   159: ifnonnull +91 -> 250
    //   162: new 351	java/lang/IllegalStateException
    //   165: dup
    //   166: new 73	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 353
    //   176: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload 11
    //   181: invokevirtual 227	java/io/File:getName	()Ljava/lang/String;
    //   184: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokespecial 354	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   193: athrow
    //   194: astore 12
    //   196: ldc 8
    //   198: iconst_1
    //   199: new 73	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 356
    //   209: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 11
    //   214: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   217: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload 12
    //   222: invokestatic 362	com/tencent/mobileqq/mini/utils/DebugUtil:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   225: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload 11
    //   236: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   239: iconst_0
    //   240: invokestatic 368	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   243: iload_1
    //   244: iconst_1
    //   245: iadd
    //   246: istore_1
    //   247: goto -133 -> 114
    //   250: aload 12
    //   252: aload 11
    //   254: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   257: putfield 317	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineDir	Ljava/lang/String;
    //   260: aload 12
    //   262: aload 12
    //   264: invokestatic 372	com/tencent/mobileqq/minigame/manager/EngineInstaller:verifyEngine	(Lcom/tencent/mobileqq/minigame/manager/InstalledEngine;)Z
    //   267: putfield 375	com/tencent/mobileqq/minigame/manager/InstalledEngine:isVerify	Z
    //   270: aload 12
    //   272: getfield 375	com/tencent/mobileqq/minigame/manager/InstalledEngine:isVerify	Z
    //   275: ifne +22 -> 297
    //   278: new 351	java/lang/IllegalStateException
    //   281: dup
    //   282: ldc_w 377
    //   285: invokespecial 354	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   288: athrow
    //   289: astore 8
    //   291: ldc 2
    //   293: monitorexit
    //   294: aload 8
    //   296: athrow
    //   297: aload 12
    //   299: getfield 132	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineType	I
    //   302: iconst_2
    //   303: if_icmpne +32 -> 335
    //   306: aload 12
    //   308: ldc_w 379
    //   311: putfield 382	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineName	Ljava/lang/String;
    //   314: aload 12
    //   316: aload 11
    //   318: invokestatic 247	com/tencent/mobileqq/minigame/manager/EngineInstaller:isPersistGameEngine	(Ljava/io/File;)Z
    //   321: putfield 273	com/tencent/mobileqq/minigame/manager/InstalledEngine:isPersist	Z
    //   324: aload 8
    //   326: aload 12
    //   328: invokevirtual 136	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   331: pop
    //   332: goto -89 -> 243
    //   335: aload 12
    //   337: getfield 132	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineType	I
    //   340: iconst_3
    //   341: if_icmpne -17 -> 324
    //   344: aload 12
    //   346: ldc_w 384
    //   349: putfield 382	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineName	Ljava/lang/String;
    //   352: goto -28 -> 324
    //   355: astore 10
    //   357: iload_0
    //   358: iconst_1
    //   359: iadd
    //   360: istore_0
    //   361: goto -301 -> 60
    //   364: aload 8
    //   366: invokestatic 390	java/util/Collections:reverseOrder	()Ljava/util/Comparator;
    //   369: invokestatic 394	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   372: ldc 8
    //   374: iconst_1
    //   375: new 73	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   382: ldc_w 396
    //   385: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokestatic 338	java/lang/System:currentTimeMillis	()J
    //   391: lload 5
    //   393: lsub
    //   394: invokevirtual 399	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   397: ldc_w 401
    //   400: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload 8
    //   405: invokevirtual 402	java/util/ArrayList:size	()I
    //   408: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   411: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: ldc 2
    //   419: monitorexit
    //   420: aload 8
    //   422: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   59	302	0	i	int
    //   113	134	1	j	int
    //   57	6	2	k	int
    //   99	39	3	m	int
    //   110	8	4	n	int
    //   15	377	5	l	long
    //   84	3	7	bool	boolean
    //   24	1	8	localArrayList	ArrayList
    //   289	132	8	localList	List
    //   29	37	9	localObject	Object
    //   69	52	10	arrayOfFile	File[]
    //   355	1	10	localException1	Exception
    //   124	193	11	localFile	File
    //   133	22	12	localInstalledEngine	InstalledEngine
    //   194	151	12	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   126	194	194	java/lang/Exception
    //   250	289	194	java/lang/Exception
    //   297	324	194	java/lang/Exception
    //   324	332	194	java/lang/Exception
    //   335	352	194	java/lang/Exception
    //   3	58	289	finally
    //   71	86	289	finally
    //   91	100	289	finally
    //   100	112	289	finally
    //   126	194	289	finally
    //   196	243	289	finally
    //   250	289	289	finally
    //   297	324	289	finally
    //   324	332	289	finally
    //   335	352	289	finally
    //   364	417	289	finally
    //   91	100	355	java/lang/Exception
  }
  
  /* Error */
  private boolean unzipEngine(File paramFile, String paramString1, EngineVersion paramEngineVersion, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 9
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: aload_3
    //   10: invokestatic 405	com/tencent/mobileqq/minigame/manager/EngineInstaller:getInstallLibDir	(Ljava/io/File;Lcom/tencent/mobileqq/minigame/manager/EngineVersion;)Ljava/lang/String;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +26 -> 41
    //   18: aload_0
    //   19: invokespecial 46	com/tencent/mobileqq/minigame/manager/EngineInstaller:workFinish	()V
    //   22: aload 4
    //   24: iconst_1
    //   25: invokestatic 368	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   28: aload_0
    //   29: invokespecial 46	com/tencent/mobileqq/minigame/manager/EngineInstaller:workFinish	()V
    //   32: iload 9
    //   34: istore 7
    //   36: aload_0
    //   37: monitorexit
    //   38: iload 7
    //   40: ireturn
    //   41: new 62	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 157	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: invokevirtual 96	java/io/File:exists	()Z
    //   52: ifeq +8 -> 60
    //   55: aload_1
    //   56: iconst_0
    //   57: invokestatic 368	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   60: aload_0
    //   61: fconst_1
    //   62: ldc_w 406
    //   65: invokestatic 412	ajjy:a	(I)Ljava/lang/String;
    //   68: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   71: aload 4
    //   73: aload_1
    //   74: invokestatic 417	mpx:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: istore 6
    //   79: iload 6
    //   81: ifne +346 -> 427
    //   84: ldc2_w 193
    //   87: invokestatic 200	java/lang/Thread:sleep	(J)V
    //   90: aload_0
    //   91: fconst_1
    //   92: ldc_w 418
    //   95: invokestatic 412	ajjy:a	(I)Ljava/lang/String;
    //   98: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   101: ldc2_w 193
    //   104: invokestatic 200	java/lang/Thread:sleep	(J)V
    //   107: aload_0
    //   108: aload 4
    //   110: aload_1
    //   111: invokespecial 422	com/tencent/mobileqq/minigame/manager/EngineInstaller:verifyBaselib	(Ljava/lang/String;Ljava/lang/String;)Z
    //   114: istore 8
    //   116: iload 6
    //   118: ifne +105 -> 223
    //   121: iload 8
    //   123: ifeq +100 -> 223
    //   126: ldc 8
    //   128: iconst_1
    //   129: new 73	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   136: ldc_w 424
    //   139: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_2
    //   143: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 426
    //   149: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_3
    //   153: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   156: ldc_w 428
    //   159: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: invokestatic 109	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateInstalledEngine	()V
    //   175: iconst_1
    //   176: istore 7
    //   178: aload 4
    //   180: iconst_1
    //   181: invokestatic 368	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   184: iload 7
    //   186: ifeq +25 -> 211
    //   189: iload 5
    //   191: ifeq +208 -> 399
    //   194: aload_0
    //   195: fconst_1
    //   196: ldc_w 429
    //   199: invokestatic 412	ajjy:a	(I)Ljava/lang/String;
    //   202: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   205: ldc2_w 193
    //   208: invokestatic 200	java/lang/Thread:sleep	(J)V
    //   211: aload_0
    //   212: invokespecial 46	com/tencent/mobileqq/minigame/manager/EngineInstaller:workFinish	()V
    //   215: goto -179 -> 36
    //   218: astore_1
    //   219: aload_0
    //   220: monitorexit
    //   221: aload_1
    //   222: athrow
    //   223: ldc 8
    //   225: iconst_1
    //   226: new 73	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   233: ldc_w 431
    //   236: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_2
    //   240: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc_w 426
    //   246: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_3
    //   250: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   253: ldc_w 428
    //   256: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_1
    //   260: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload_1
    //   270: iconst_0
    //   271: invokestatic 368	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   274: iload 6
    //   276: ifeq +83 -> 359
    //   279: aload_0
    //   280: fconst_0
    //   281: ldc_w 432
    //   284: invokestatic 412	ajjy:a	(I)Ljava/lang/String;
    //   287: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   290: iload 10
    //   292: istore 7
    //   294: goto -116 -> 178
    //   297: astore_1
    //   298: ldc 8
    //   300: iconst_1
    //   301: new 73	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   308: ldc_w 434
    //   311: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload_1
    //   315: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   318: aload_1
    //   319: invokestatic 362	com/tencent/mobileqq/mini/utils/DebugUtil:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   322: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: aload_0
    //   332: fconst_0
    //   333: ldc_w 435
    //   336: invokestatic 412	ajjy:a	(I)Ljava/lang/String;
    //   339: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   342: aload 4
    //   344: iconst_1
    //   345: invokestatic 368	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   348: aload_0
    //   349: invokespecial 46	com/tencent/mobileqq/minigame/manager/EngineInstaller:workFinish	()V
    //   352: iload 9
    //   354: istore 7
    //   356: goto -320 -> 36
    //   359: iload 10
    //   361: istore 7
    //   363: iload 8
    //   365: ifne -187 -> 178
    //   368: aload_0
    //   369: fconst_0
    //   370: ldc_w 436
    //   373: invokestatic 412	ajjy:a	(I)Ljava/lang/String;
    //   376: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   379: iload 10
    //   381: istore 7
    //   383: goto -205 -> 178
    //   386: astore_1
    //   387: aload 4
    //   389: iconst_1
    //   390: invokestatic 368	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   393: aload_0
    //   394: invokespecial 46	com/tencent/mobileqq/minigame/manager/EngineInstaller:workFinish	()V
    //   397: aload_1
    //   398: athrow
    //   399: aload_0
    //   400: fconst_1
    //   401: ldc_w 437
    //   404: invokestatic 412	ajjy:a	(I)Ljava/lang/String;
    //   407: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   410: goto -205 -> 205
    //   413: astore 11
    //   415: goto -325 -> 90
    //   418: astore 11
    //   420: goto -313 -> 107
    //   423: astore_1
    //   424: goto -213 -> 211
    //   427: iconst_1
    //   428: istore 8
    //   430: goto -314 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	this	EngineInstaller
    //   0	433	1	paramFile	File
    //   0	433	2	paramString1	String
    //   0	433	3	paramEngineVersion	EngineVersion
    //   0	433	4	paramString2	String
    //   0	433	5	paramBoolean	boolean
    //   77	198	6	i	int
    //   34	348	7	bool1	boolean
    //   114	315	8	bool2	boolean
    //   4	349	9	bool3	boolean
    //   1	379	10	bool4	boolean
    //   413	1	11	localInterruptedException1	InterruptedException
    //   418	1	11	localInterruptedException2	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   22	32	218	finally
    //   178	184	218	finally
    //   194	205	218	finally
    //   205	211	218	finally
    //   211	215	218	finally
    //   342	352	218	finally
    //   387	399	218	finally
    //   399	410	218	finally
    //   8	14	297	java/lang/Exception
    //   18	22	297	java/lang/Exception
    //   41	60	297	java/lang/Exception
    //   60	79	297	java/lang/Exception
    //   84	90	297	java/lang/Exception
    //   90	101	297	java/lang/Exception
    //   101	107	297	java/lang/Exception
    //   107	116	297	java/lang/Exception
    //   126	175	297	java/lang/Exception
    //   223	274	297	java/lang/Exception
    //   279	290	297	java/lang/Exception
    //   368	379	297	java/lang/Exception
    //   8	14	386	finally
    //   18	22	386	finally
    //   41	60	386	finally
    //   60	79	386	finally
    //   84	90	386	finally
    //   90	101	386	finally
    //   101	107	386	finally
    //   107	116	386	finally
    //   126	175	386	finally
    //   223	274	386	finally
    //   279	290	386	finally
    //   298	342	386	finally
    //   368	379	386	finally
    //   84	90	413	java/lang/InterruptedException
    //   101	107	418	java/lang/InterruptedException
    //   205	211	423	java/lang/InterruptedException
  }
  
  public static void updateInstalledEngine()
  {
    try
    {
      sInstalledEngine = scanInstalledEngine();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void updateMessage(float paramFloat, String paramString)
  {
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext())
    {
      EngineInstaller.Callback localCallback = (EngineInstaller.Callback)localIterator.next();
      if (localCallback != null) {
        localCallback.onMessageUpdate(paramFloat, paramString);
      }
    }
  }
  
  private boolean verifyBaselib(String paramString1, String paramString2)
  {
    long l1 = mpx.a(paramString1);
    if (l1 <= 0L)
    {
      QLog.e("EngineInstaller", 1, "[MiniEng] getUncompressedFileSize error " + paramString1 + ", sz=" + l1);
      return false;
    }
    long l2 = StorageUtil.getDirUsedSpace(paramString2);
    if (l2 <= 0L)
    {
      QLog.e("EngineInstaller", 1, "[MiniEng] getDirUsedSpace error " + paramString2 + ", sz2=" + l2);
      return false;
    }
    if (l1 == l2)
    {
      getSp().edit().putBoolean(paramString2, true).commit();
      return true;
    }
    QLog.e("EngineInstaller", 1, "[MiniEng] verifyBaselib failed sz1=" + l1 + ", sz2=" + l2);
    return false;
  }
  
  private static boolean verifyEngine(InstalledEngine paramInstalledEngine)
  {
    boolean bool = false;
    if (getSp() != null) {
      bool = getSp().getBoolean(paramInstalledEngine.engineDir, false);
    }
    QLog.i("EngineInstaller", 1, "[MiniEng]verifyEngine " + paramInstalledEngine.engineDir + " " + bool);
    return bool;
  }
  
  private void workAbort()
  {
    try
    {
      Iterator localIterator = new ArrayList(this.mCallbacks).iterator();
      while (localIterator.hasNext())
      {
        EngineInstaller.Callback localCallback = (EngineInstaller.Callback)localIterator.next();
        if (localCallback != null) {
          localCallback.onEngineWorkAbort();
        }
      }
    }
    finally {}
  }
  
  private void workBegin()
  {
    try
    {
      this.isWorking = true;
      Iterator localIterator = this.mCallbacks.iterator();
      while (localIterator.hasNext())
      {
        EngineInstaller.Callback localCallback = (EngineInstaller.Callback)localIterator.next();
        if (localCallback != null) {
          localCallback.onEngineWorkBegin();
        }
      }
    }
    finally {}
  }
  
  private void workFinish()
  {
    try
    {
      this.isWorking = false;
      Iterator localIterator = new ArrayList(this.mCallbacks).iterator();
      while (localIterator.hasNext())
      {
        EngineInstaller.Callback localCallback = (EngineInstaller.Callback)localIterator.next();
        if (localCallback != null) {
          localCallback.onEngineWorkFinish();
        }
      }
    }
    finally {}
  }
  
  public void addCallback(EngineInstaller.Callback paramCallback)
  {
    try
    {
      this.mCallbacks.add(paramCallback);
      return;
    }
    finally
    {
      paramCallback = finally;
      throw paramCallback;
    }
  }
  
  public void installWithCallback(BaseLibInfo paramBaseLibInfo, EngineInstaller.Callback paramCallback)
  {
    Object localObject;
    File localFile;
    EngineVersion localEngineVersion;
    long l;
    label246:
    boolean bool1;
    for (;;)
    {
      try
      {
        localObject = paramBaseLibInfo.baseLibUrl;
        if (paramCallback != null) {
          addCallback(paramCallback);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramBaseLibInfo.baseLibVersion)) && (paramBaseLibInfo.baseLibType > 0)) {
          continue;
        }
        QLog.w("EngineInstaller", 1, "[MiniEng] invalid BaseLibInfo " + paramBaseLibInfo);
        workAbort();
      }
      finally
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramBaseLibInfo.baseLibDesc);
          localEngineVersion = new EngineVersion(paramBaseLibInfo.baseLibVersion);
          l = localJSONObject.optLong("file_length");
          QLog.w("EngineInstaller", 1, "[MiniEng] installWithCallback " + paramBaseLibInfo);
          if (AppUtil.isMainProcess()) {
            break label246;
          }
          QLog.w("EngineInstaller", 1, "[MiniEng] download triggered at wrong process");
          workAbort();
        }
        catch (Exception paramCallback)
        {
          QLog.w("EngineInstaller", 1, "[MiniEng] refuse installEngine " + paramBaseLibInfo.baseLibDesc + ":" + paramBaseLibInfo.baseLibVersion + paramBaseLibInfo.baseLibUrl + DebugUtil.getPrintableStackTrace(paramCallback));
          workAbort();
        }
        paramBaseLibInfo = finally;
      }
      return;
      localFile = new File(getRootDir(), String.valueOf(paramBaseLibInfo.baseLibType));
      continue;
      if (getSp() == null)
      {
        QLog.w("EngineInstaller", 1, "[MiniEng] shared preference not supported");
        workAbort();
      }
      else if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("EngineInstaller", 1, "[MiniEng] empty engine url");
        workAbort();
      }
      else if (isWorking())
      {
        QLog.i("EngineInstaller", 1, "[MiniEng] downloading already in progress");
        workAbort();
      }
      else
      {
        bool1 = false;
        QLog.i("EngineInstaller", 1, "[MiniEng] installWithCallback callback=" + paramCallback);
        if ((paramBaseLibInfo.baseLibType == 2) && (!LocalGameEngine.g().isDisabled()) && (!paramBaseLibInfo.baseLibUrl.startsWith("assets://")))
        {
          paramCallback = LocalGameEngine.g().mLocalEngineVersion;
          if (paramCallback.compareTo(localEngineVersion) >= 0)
          {
            QLog.i("EngineInstaller", 1, "[MiniEng] refuse install remote baselib:" + localEngineVersion + ",local:" + paramCallback);
            workAbort();
            continue;
          }
        }
        paramCallback = getInstalledEngine(paramBaseLibInfo.baseLibType);
        QLog.i("EngineInstaller", 1, "[MiniEng] engineForType " + paramBaseLibInfo.baseLibType + ", size=" + paramCallback.size());
        if (paramCallback.size() <= 0) {
          break;
        }
        paramCallback = (InstalledEngine)paramCallback.get(0);
        QLog.i("EngineInstaller", 1, "[MiniEng]latest engine for type " + paramBaseLibInfo.baseLibType + "," + paramCallback);
        if (paramCallback.engineVersion.compareTo(localEngineVersion) < 0) {
          break label1160;
        }
        QLog.i("EngineInstaller", 1, "[MiniEng]engine type " + paramBaseLibInfo.baseLibType + " has no update, remote:" + localEngineVersion + ",latest:" + paramCallback);
        workAbort();
      }
    }
    for (;;)
    {
      for (;;)
      {
        workBegin();
        if (bool1) {
          updateMessage(0.0F, ajjy.a(2131638340) + paramBaseLibInfo.baseLibVersion + ")");
        }
        for (;;)
        {
          QLog.i("EngineInstaller", 1, "[MiniEng] installEngine " + (String)localObject);
          if ((localFile.exists()) || (localFile.mkdirs())) {
            break label780;
          }
          QLog.i("EngineInstaller", 1, "[MiniEng] mkdir failed, is disk writable? " + localFile.getAbsolutePath());
          workFinish();
          break;
          updateMessage(0.0F, ajjy.a(2131638345) + paramBaseLibInfo.baseLibVersion + ")");
        }
        label780:
        boolean bool2 = false;
        paramCallback = null;
        if (paramBaseLibInfo.baseLibType == 2)
        {
          bool2 = paramBaseLibInfo.baseLibUrl.startsWith("assets://");
          paramBaseLibInfo.baseLibUrl.replace("assets://", "");
          paramCallback = new long[1];
          paramCallback[0] = 0L;
        }
        if (!bool2) {
          break label1143;
        }
        try
        {
          updateMessage(0.0F, ajjy.a(2131638341));
          paramBaseLibInfo = getInstallLibDir(localFile, localEngineVersion);
          QLog.i("EngineInstaller", 1, "[MiniEng] installLocalEngine start url=" + (String)localObject + ",installBasePath=" + paramBaseLibInfo);
          if (TextUtils.isEmpty(paramBaseLibInfo))
          {
            updateMessage(0.0F, ajjy.a(2131638352));
            QLog.e("EngineInstaller", 1, "[MiniEng] installLocalEngine failed installBasePath=" + paramBaseLibInfo);
            workFinish();
            break;
          }
        }
        finally {}
      }
      localObject = new File(paramBaseLibInfo);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdir()))
      {
        updateMessage(0.0F, ajjy.a(2131638344));
        QLog.e("EngineInstaller", 1, "[MiniEng] installLocalEngine failed targetPath=" + localObject);
        workFinish();
        break;
      }
      BaseLibManager.g().installInnerBaseLib();
      QLog.i("EngineInstaller", 1, "[MiniEng] installLocalEngine finish copied " + paramCallback[0] + "<>" + l);
      if ((paramCallback[0] == l) || (l < 0L))
      {
        getSp().edit().putBoolean(paramBaseLibInfo, true).commit();
        updateInstalledEngine();
        updateMessage(1.0F, ajjy.a(2131638339));
      }
      for (;;)
      {
        workFinish();
        break;
        updateMessage(0.0F, ajjy.a(2131638350));
      }
      label1143:
      installedFromNetwork(paramBaseLibInfo, (String)localObject, l, localFile, localEngineVersion, bool1);
      break;
      label1160:
      bool1 = true;
    }
  }
  
  public boolean isWorking()
  {
    try
    {
      boolean bool = this.isWorking;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void removeCallback(EngineInstaller.Callback paramCallback)
  {
    try
    {
      this.mCallbacks.remove(paramCallback);
      return;
    }
    finally
    {
      paramCallback = finally;
      throw paramCallback;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineInstaller
 * JD-Core Version:    0.7.0.1
 */