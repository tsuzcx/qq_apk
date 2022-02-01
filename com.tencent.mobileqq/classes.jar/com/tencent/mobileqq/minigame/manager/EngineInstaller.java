package com.tencent.mobileqq.minigame.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import anzj;
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
import nof;
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
          bool1 = bool2;
          if (paramFile.listFiles() != null)
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
    }
    return bool1;
  }
  
  public static void removeEngine(InstalledEngine paramInstalledEngine)
  {
    if (paramInstalledEngine == null) {}
    for (;;)
    {
      return;
      try
      {
        QLog.i("EngineInstaller", 1, "[MiniEng] removeEngine " + paramInstalledEngine);
        paramInstalledEngine.deleteFiles();
        sInstalledEngine.remove(paramInstalledEngine);
      }
      finally {}
    }
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
    //   6: ldc_w 339
    //   9: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: invokestatic 345	java/lang/System:currentTimeMillis	()J
    //   15: lstore 5
    //   17: new 36	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 37	java/util/ArrayList:<init>	()V
    //   24: astore 7
    //   26: invokestatic 347	com/tencent/mobileqq/minigame/manager/EngineInstaller:getRootDir	()Ljava/io/File;
    //   29: astore 8
    //   31: aload 8
    //   33: invokevirtual 96	java/io/File:exists	()Z
    //   36: ifeq +375 -> 411
    //   39: aload 8
    //   41: invokevirtual 250	java/io/File:isDirectory	()Z
    //   44: ifeq +367 -> 411
    //   47: aload 8
    //   49: invokevirtual 254	java/io/File:listFiles	()[Ljava/io/File;
    //   52: ifnull +359 -> 411
    //   55: aload 8
    //   57: invokevirtual 254	java/io/File:listFiles	()[Ljava/io/File;
    //   60: astore 8
    //   62: aload 8
    //   64: arraylength
    //   65: istore_2
    //   66: iconst_0
    //   67: istore_0
    //   68: iload_0
    //   69: iload_2
    //   70: if_icmpge +341 -> 411
    //   73: aload 8
    //   75: iload_0
    //   76: aaload
    //   77: astore 9
    //   79: aload 9
    //   81: invokevirtual 96	java/io/File:exists	()Z
    //   84: ifeq +320 -> 404
    //   87: aload 9
    //   89: invokevirtual 250	java/io/File:isDirectory	()Z
    //   92: ifeq +312 -> 404
    //   95: aload 9
    //   97: invokevirtual 254	java/io/File:listFiles	()[Ljava/io/File;
    //   100: astore 10
    //   102: aload 10
    //   104: ifnull +300 -> 404
    //   107: aload 9
    //   109: invokevirtual 227	java/io/File:getName	()Ljava/lang/String;
    //   112: invokestatic 352	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   115: istore_3
    //   116: aload 9
    //   118: invokevirtual 254	java/io/File:listFiles	()[Ljava/io/File;
    //   121: astore 9
    //   123: aload 9
    //   125: arraylength
    //   126: istore 4
    //   128: iconst_0
    //   129: istore_1
    //   130: iload_1
    //   131: iload 4
    //   133: if_icmpge +271 -> 404
    //   136: aload 9
    //   138: iload_1
    //   139: aaload
    //   140: astore 10
    //   142: ldc_w 353
    //   145: iconst_4
    //   146: new 73	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 355
    //   156: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 10
    //   161: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   164: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: new 128	com/tencent/mobileqq/minigame/manager/InstalledEngine
    //   176: dup
    //   177: invokespecial 359	com/tencent/mobileqq/minigame/manager/InstalledEngine:<init>	()V
    //   180: astore 11
    //   182: aload 11
    //   184: iload_3
    //   185: putfield 132	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineType	I
    //   188: aload 11
    //   190: aload 10
    //   192: invokevirtual 227	java/io/File:getName	()Ljava/lang/String;
    //   195: invokestatic 231	com/tencent/mobileqq/minigame/manager/EngineVersion:fromFolderName	(Ljava/lang/String;)Lcom/tencent/mobileqq/minigame/manager/EngineVersion;
    //   198: putfield 300	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineVersion	Lcom/tencent/mobileqq/minigame/manager/EngineVersion;
    //   201: aload 11
    //   203: getfield 300	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineVersion	Lcom/tencent/mobileqq/minigame/manager/EngineVersion;
    //   206: ifnonnull +91 -> 297
    //   209: new 361	java/lang/IllegalStateException
    //   212: dup
    //   213: new 73	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 363
    //   223: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 10
    //   228: invokevirtual 227	java/io/File:getName	()Ljava/lang/String;
    //   231: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokespecial 364	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   240: athrow
    //   241: astore 11
    //   243: ldc 8
    //   245: iconst_1
    //   246: new 73	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   253: ldc_w 366
    //   256: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload 10
    //   261: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   264: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 11
    //   269: invokestatic 372	com/tencent/mobileqq/mini/utils/DebugUtil:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   272: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload 10
    //   283: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   286: iconst_0
    //   287: invokestatic 378	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   290: iload_1
    //   291: iconst_1
    //   292: iadd
    //   293: istore_1
    //   294: goto -164 -> 130
    //   297: aload 11
    //   299: aload 10
    //   301: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   304: putfield 324	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineDir	Ljava/lang/String;
    //   307: aload 11
    //   309: aload 11
    //   311: invokestatic 382	com/tencent/mobileqq/minigame/manager/EngineInstaller:verifyEngine	(Lcom/tencent/mobileqq/minigame/manager/InstalledEngine;)Z
    //   314: putfield 385	com/tencent/mobileqq/minigame/manager/InstalledEngine:isVerify	Z
    //   317: aload 11
    //   319: getfield 385	com/tencent/mobileqq/minigame/manager/InstalledEngine:isVerify	Z
    //   322: ifne +22 -> 344
    //   325: new 361	java/lang/IllegalStateException
    //   328: dup
    //   329: ldc_w 387
    //   332: invokespecial 364	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   335: athrow
    //   336: astore 7
    //   338: ldc 2
    //   340: monitorexit
    //   341: aload 7
    //   343: athrow
    //   344: aload 11
    //   346: getfield 132	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineType	I
    //   349: iconst_2
    //   350: if_icmpne +32 -> 382
    //   353: aload 11
    //   355: ldc_w 389
    //   358: putfield 392	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineName	Ljava/lang/String;
    //   361: aload 11
    //   363: aload 10
    //   365: invokestatic 247	com/tencent/mobileqq/minigame/manager/EngineInstaller:isPersistGameEngine	(Ljava/io/File;)Z
    //   368: putfield 286	com/tencent/mobileqq/minigame/manager/InstalledEngine:isPersist	Z
    //   371: aload 7
    //   373: aload 11
    //   375: invokevirtual 136	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   378: pop
    //   379: goto -89 -> 290
    //   382: aload 11
    //   384: getfield 132	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineType	I
    //   387: iconst_3
    //   388: if_icmpne -17 -> 371
    //   391: aload 11
    //   393: ldc_w 394
    //   396: putfield 392	com/tencent/mobileqq/minigame/manager/InstalledEngine:engineName	Ljava/lang/String;
    //   399: goto -28 -> 371
    //   402: astore 9
    //   404: iload_0
    //   405: iconst_1
    //   406: iadd
    //   407: istore_0
    //   408: goto -340 -> 68
    //   411: aload 7
    //   413: invokestatic 400	java/util/Collections:reverseOrder	()Ljava/util/Comparator;
    //   416: invokestatic 404	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   419: ldc 8
    //   421: iconst_1
    //   422: new 73	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 406
    //   432: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokestatic 345	java/lang/System:currentTimeMillis	()J
    //   438: lload 5
    //   440: lsub
    //   441: invokevirtual 409	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   444: ldc_w 411
    //   447: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload 7
    //   452: invokevirtual 412	java/util/ArrayList:size	()I
    //   455: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: ldc 2
    //   466: monitorexit
    //   467: aload 7
    //   469: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   67	341	0	i	int
    //   129	165	1	j	int
    //   65	6	2	k	int
    //   115	70	3	m	int
    //   126	8	4	n	int
    //   15	424	5	l	long
    //   24	1	7	localArrayList	ArrayList
    //   336	132	7	localList	List
    //   29	45	8	localObject1	Object
    //   77	60	9	arrayOfFile	File[]
    //   402	1	9	localException1	Exception
    //   100	264	10	localObject2	Object
    //   180	22	11	localInstalledEngine	InstalledEngine
    //   241	151	11	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   173	241	241	java/lang/Exception
    //   297	336	241	java/lang/Exception
    //   344	371	241	java/lang/Exception
    //   371	379	241	java/lang/Exception
    //   382	399	241	java/lang/Exception
    //   3	66	336	finally
    //   79	102	336	finally
    //   107	116	336	finally
    //   116	128	336	finally
    //   142	173	336	finally
    //   173	241	336	finally
    //   243	290	336	finally
    //   297	336	336	finally
    //   344	371	336	finally
    //   371	379	336	finally
    //   382	399	336	finally
    //   411	464	336	finally
    //   107	116	402	java/lang/Exception
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
    //   10: invokestatic 415	com/tencent/mobileqq/minigame/manager/EngineInstaller:getInstallLibDir	(Ljava/io/File;Lcom/tencent/mobileqq/minigame/manager/EngineVersion;)Ljava/lang/String;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +26 -> 41
    //   18: aload_0
    //   19: invokespecial 46	com/tencent/mobileqq/minigame/manager/EngineInstaller:workFinish	()V
    //   22: aload 4
    //   24: iconst_1
    //   25: invokestatic 378	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
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
    //   57: invokestatic 378	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   60: aload_0
    //   61: fconst_1
    //   62: ldc_w 416
    //   65: invokestatic 422	anzj:a	(I)Ljava/lang/String;
    //   68: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   71: aload 4
    //   73: aload_1
    //   74: invokestatic 427	nof:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: istore 6
    //   79: iload 6
    //   81: ifne +346 -> 427
    //   84: ldc2_w 193
    //   87: invokestatic 200	java/lang/Thread:sleep	(J)V
    //   90: aload_0
    //   91: fconst_1
    //   92: ldc_w 428
    //   95: invokestatic 422	anzj:a	(I)Ljava/lang/String;
    //   98: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   101: ldc2_w 193
    //   104: invokestatic 200	java/lang/Thread:sleep	(J)V
    //   107: aload_0
    //   108: aload 4
    //   110: aload_1
    //   111: invokespecial 432	com/tencent/mobileqq/minigame/manager/EngineInstaller:verifyBaselib	(Ljava/lang/String;Ljava/lang/String;)Z
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
    //   136: ldc_w 434
    //   139: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_2
    //   143: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 436
    //   149: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_3
    //   153: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   156: ldc_w 438
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
    //   181: invokestatic 378	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   184: iload 7
    //   186: ifeq +25 -> 211
    //   189: iload 5
    //   191: ifeq +208 -> 399
    //   194: aload_0
    //   195: fconst_1
    //   196: ldc_w 439
    //   199: invokestatic 422	anzj:a	(I)Ljava/lang/String;
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
    //   233: ldc_w 441
    //   236: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_2
    //   240: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc_w 436
    //   246: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_3
    //   250: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   253: ldc_w 438
    //   256: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_1
    //   260: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload_1
    //   270: iconst_0
    //   271: invokestatic 378	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   274: iload 6
    //   276: ifeq +83 -> 359
    //   279: aload_0
    //   280: fconst_0
    //   281: ldc_w 442
    //   284: invokestatic 422	anzj:a	(I)Ljava/lang/String;
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
    //   308: ldc_w 444
    //   311: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload_1
    //   315: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   318: aload_1
    //   319: invokestatic 372	com/tencent/mobileqq/mini/utils/DebugUtil:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   322: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: aload_0
    //   332: fconst_0
    //   333: ldc_w 445
    //   336: invokestatic 422	anzj:a	(I)Ljava/lang/String;
    //   339: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   342: aload 4
    //   344: iconst_1
    //   345: invokestatic 378	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
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
    //   370: ldc_w 446
    //   373: invokestatic 422	anzj:a	(I)Ljava/lang/String;
    //   376: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   379: iload 10
    //   381: istore 7
    //   383: goto -205 -> 178
    //   386: astore_1
    //   387: aload 4
    //   389: iconst_1
    //   390: invokestatic 378	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   393: aload_0
    //   394: invokespecial 46	com/tencent/mobileqq/minigame/manager/EngineInstaller:workFinish	()V
    //   397: aload_1
    //   398: athrow
    //   399: aload_0
    //   400: fconst_1
    //   401: ldc_w 447
    //   404: invokestatic 422	anzj:a	(I)Ljava/lang/String;
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
    long l1 = nof.a(paramString1);
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
          updateMessage(0.0F, anzj.a(2131703024) + paramBaseLibInfo.baseLibVersion + ")");
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
          updateMessage(0.0F, anzj.a(2131703029) + paramBaseLibInfo.baseLibVersion + ")");
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
          updateMessage(0.0F, anzj.a(2131703025));
          paramBaseLibInfo = getInstallLibDir(localFile, localEngineVersion);
          QLog.i("EngineInstaller", 1, "[MiniEng] installLocalEngine start url=" + (String)localObject + ",installBasePath=" + paramBaseLibInfo);
          if (TextUtils.isEmpty(paramBaseLibInfo))
          {
            updateMessage(0.0F, anzj.a(2131703036));
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
        updateMessage(0.0F, anzj.a(2131703028));
        QLog.e("EngineInstaller", 1, "[MiniEng] installLocalEngine failed targetPath=" + localObject);
        workFinish();
        break;
      }
      BaseLibManager.g().installMiniGameInnerJsLib();
      QLog.i("EngineInstaller", 1, "[MiniEng] installLocalEngine finish copied " + paramCallback[0] + "<>" + l);
      if ((paramCallback[0] == l) || (l < 0L))
      {
        getSp().edit().putBoolean(paramBaseLibInfo, true).commit();
        updateInstalledEngine();
        updateMessage(1.0F, anzj.a(2131703023));
      }
      for (;;)
      {
        workFinish();
        break;
        updateMessage(0.0F, anzj.a(2131703034));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineInstaller
 * JD-Core Version:    0.7.0.1
 */