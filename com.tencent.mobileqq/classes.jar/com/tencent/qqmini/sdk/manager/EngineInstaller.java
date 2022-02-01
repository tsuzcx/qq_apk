package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public class EngineInstaller
{
  public static final String LOG_TAG = "EngineInstaller";
  private static final String ROOT_DIR = "/xminilib/";
  private static String SP_NAME = "x_mini_engine";
  private static volatile List<InstalledEngine> sInstalledEngine;
  private static File sRootDir;
  private boolean isWorking = false;
  private List<EngineInstaller.Callback> mCallbacks = new ArrayList();
  
  private static String getInstallLibDir(File paramFile, EngineVersion paramEngineVersion)
  {
    try
    {
      paramFile = new File(paramFile, paramEngineVersion.toFolderName());
      paramEngineVersion = new StringBuilder();
      paramEngineVersion.append("[MiniEng]getInstallLibDir ");
      paramEngineVersion.append(paramFile.getAbsolutePath());
      QMLog.i("EngineInstaller", paramEngineVersion.toString());
      if ((!paramFile.exists()) && (!paramFile.mkdirs()))
      {
        paramEngineVersion = new StringBuilder();
        paramEngineVersion.append("[MiniEng] getInstallLibDir failed, is disk writable? ");
        paramEngineVersion.append(paramFile.getAbsolutePath());
        QMLog.e("EngineInstaller", paramEngineVersion.toString());
        return null;
      }
      paramFile = paramFile.getAbsolutePath();
      return paramFile;
    }
    finally {}
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
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private static File getRootDir()
  {
    if (sRootDir == null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AppLoaderFactory.g().getContext().getFilesDir().getPath());
      ((StringBuilder)localObject).append("/xminilib/");
      localObject = new File(((StringBuilder)localObject).toString());
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MiniEng] dir mk failed ");
        localStringBuilder.append(localObject);
        QMLog.e("EngineInstaller", localStringBuilder.toString());
      }
      sRootDir = (File)localObject;
    }
    return sRootDir;
  }
  
  public static SharedPreferences getSp()
  {
    return AppLoaderFactory.g().getContext().getSharedPreferences(SP_NAME, 0);
  }
  
  private boolean handleUnZipResult(String paramString1, EngineVersion paramEngineVersion, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    if (paramInt == 0) {}
    try
    {
      Thread.sleep(100L);
      updateMessage(1.0F, "正在校验引擎");
    }
    catch (InterruptedException paramString2)
    {
      try
      {
        Thread.sleep(100L);
        label24:
        paramString2 = new StringBuilder();
        paramString2.append("[MiniEng]unZip succeed. url:");
        paramString2.append(paramString1);
        paramString2.append(", version:");
        paramString2.append(paramEngineVersion);
        paramString2.append(",unzipPath:");
        paramString2.append(paramString3);
        QMLog.i("EngineInstaller", paramString2.toString());
        getSp().edit().putBoolean(paramString3, true).commit();
        updateInstalledEngine();
        return true;
        paramString2 = new StringBuilder();
        paramString2.append("[MiniEng]unZip failed. url:");
        paramString2.append(paramString1);
        paramString2.append(", version:");
        paramString2.append(paramEngineVersion);
        paramString2.append(",unzipPath:");
        paramString2.append(paramString3);
        QMLog.i("EngineInstaller", paramString2.toString());
        FileUtils.delete(paramString3, false);
        updateMessage(0.0F, "引擎解压缩失败");
        return paramBoolean;
        paramString2 = paramString2;
      }
      catch (InterruptedException paramString2)
      {
        break label24;
      }
    }
  }
  
  private void installFromAssets(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    try
    {
      updateMessage(0.0F, "正在解压缩本地引擎");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MiniEng] installLocalEngine start url=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",installBasePath=");
      localStringBuilder.append(paramString2);
      QMLog.i("EngineInstaller", localStringBuilder.toString());
      if (TextUtils.isEmpty(paramString2))
      {
        updateMessage(0.0F, "本地引擎安装失败, 目录为空");
        paramString1 = new StringBuilder();
        paramString1.append("[MiniEng] installLocalEngine failed installBasePath=");
        paramString1.append(paramString2);
        QMLog.e("EngineInstaller", paramString1.toString());
        workFinish();
        return;
      }
      paramString1 = new File(paramString2);
      if ((!paramString1.exists()) && (!paramString1.mkdir()))
      {
        updateMessage(0.0F, "本地引擎安装失败, 创建目录失败");
        paramString2 = new StringBuilder();
        paramString2.append("[MiniEng] installLocalEngine failed targetPath=");
        paramString2.append(paramString1);
        QMLog.e("EngineInstaller", paramString2.toString());
        workFinish();
        return;
      }
      BaseLibManager.g().installMiniGameInnerJsLib();
      paramString1 = new StringBuilder();
      paramString1.append("[MiniEng] installLocalEngine finish copied ");
      paramString1.append(paramLong2);
      paramString1.append("<>");
      paramString1.append(paramLong1);
      QMLog.i("EngineInstaller", paramString1.toString());
      if ((paramLong2 != paramLong1) && (paramLong1 >= 0L))
      {
        updateMessage(0.0F, "本地引擎安装失败");
      }
      else
      {
        getSp().edit().putBoolean(paramString2, true).commit();
        updateInstalledEngine();
        updateMessage(1.0F, "本地引擎安装完成");
      }
      workFinish();
      return;
    }
    finally {}
  }
  
  private void installedFromNetwork(BaseLibInfo paramBaseLibInfo, String paramString, long paramLong, File paramFile, EngineVersion paramEngineVersion, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppLoaderFactory.g().getContext().getCacheDir());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(UUID.randomUUID());
    ((StringBuilder)localObject).append(".zip");
    localObject = ((StringBuilder)localObject).toString();
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString, null, (String)localObject, 60, new EngineInstaller.2(this, paramString, paramBaseLibInfo, (String)localObject, paramLong, paramFile, paramEngineVersion, paramBoolean));
    if (paramBaseLibInfo.baseLibType == 2) {
      MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 4, "1");
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
            paramFile = paramFile.listFiles(new EngineInstaller.1());
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
    if (paramInstalledEngine == null) {
      return;
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MiniEng] removeEngine ");
      localStringBuilder.append(paramInstalledEngine);
      QMLog.i("EngineInstaller", localStringBuilder.toString());
      paramInstalledEngine.deleteFiles();
      sInstalledEngine.remove(paramInstalledEngine);
      return;
    }
    finally
    {
      paramInstalledEngine = finally;
      throw paramInstalledEngine;
    }
  }
  
  public static void removeOldEngine(int paramInt)
  {
    try
    {
      if (sInstalledEngine == null)
      {
        QMLog.e("EngineInstaller", "[MiniEng]removeOldEngine null");
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = sInstalledEngine.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (InstalledEngine)((Iterator)localObject2).next();
        if (((InstalledEngine)localObject3).engineType == paramInt) {
          localArrayList.add(localObject3);
        }
      }
      int j = localArrayList.size();
      paramInt = 0;
      int i = 1;
      while ((j > 1) && (paramInt < j))
      {
        localObject2 = (InstalledEngine)localArrayList.get(paramInt);
        if (((InstalledEngine)localObject2).isPersist)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[MiniEng] removeOldEngine ");
          ((StringBuilder)localObject3).append(localObject2);
          ((StringBuilder)localObject3).append(" isPersist, so not deleted");
          QMLog.i("EngineInstaller", ((StringBuilder)localObject3).toString());
        }
        else
        {
          if (i == 0)
          {
            ((InstalledEngine)localObject2).deleteFiles();
            sInstalledEngine.remove(localObject2);
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[MiniEng] removeOldEngine ");
            ((StringBuilder)localObject3).append(localObject2);
            ((StringBuilder)localObject3).append("  is latest, so kept");
            QMLog.i("EngineInstaller", ((StringBuilder)localObject3).toString());
          }
          i = 0;
        }
        paramInt += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public static void removeOutDatedEngine(int paramInt)
  {
    try
    {
      if (sInstalledEngine == null)
      {
        QMLog.e("EngineInstaller", "[MiniEng]removeOutDatedEngine null");
        return;
      }
      Object localObject3 = new ArrayList();
      Object localObject1 = sInstalledEngine.iterator();
      InstalledEngine localInstalledEngine;
      while (((Iterator)localObject1).hasNext())
      {
        localInstalledEngine = (InstalledEngine)((Iterator)localObject1).next();
        if (localInstalledEngine.engineType == paramInt) {
          ((List)localObject3).add(localInstalledEngine);
        }
      }
      localObject1 = null;
      if (paramInt == 2) {
        localObject1 = LocalGameEngine.g().mLocalEngineVersion;
      }
      if (localObject1 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localInstalledEngine = (InstalledEngine)((Iterator)localObject3).next();
          StringBuilder localStringBuilder;
          if (localInstalledEngine.engineVersion.compareTo((EngineVersion)localObject1) < 0)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[MiniEng] removeOutDatedEngine ");
            localStringBuilder.append(localInstalledEngine);
            localStringBuilder.append(" localMinVer:");
            localStringBuilder.append(localObject1);
            localStringBuilder.append(",engineType:");
            localStringBuilder.append(paramInt);
            QMLog.i("EngineInstaller", localStringBuilder.toString());
            localInstalledEngine.deleteFiles();
            sInstalledEngine.remove(localInstalledEngine);
          }
          else if ((localInstalledEngine.isPersist) && (!isCurrentPersistGameEngine(new File(localInstalledEngine.engineDir))))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[MiniEng] removeOutDatedPersistEngine ");
            localStringBuilder.append(localInstalledEngine);
            localStringBuilder.append(" localMinVer:");
            localStringBuilder.append(localObject1);
            localStringBuilder.append(",engineType:");
            localStringBuilder.append(paramInt);
            QMLog.i("EngineInstaller", localStringBuilder.toString());
            localInstalledEngine.deleteFiles();
            sInstalledEngine.remove(localInstalledEngine);
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private static List<InstalledEngine> scanInstalledEngine()
  {
    try
    {
      QMLog.i("EngineInstaller", "[MiniEng] scanInstalledEngine");
      l = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localObject2 = getRootDir();
      if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory()) || (((File)localObject2).listFiles() == null)) {
        break label381;
      }
      localObject2 = ((File)localObject2).listFiles();
      k = localObject2.length;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int i;
        int j;
        try
        {
          long l;
          ArrayList localArrayList;
          int k;
          int m = Integer.parseInt(arrayOfFile.getName());
          File[] arrayOfFile = arrayOfFile.listFiles();
          int n = arrayOfFile.length;
          j = 0;
          if (j >= n) {
            break label481;
          }
          Object localObject3 = arrayOfFile[j];
          try
          {
            Object localObject4 = new InstalledEngine();
            ((InstalledEngine)localObject4).engineType = m;
            ((InstalledEngine)localObject4).engineVersion = EngineVersion.fromFolderName(((File)localObject3).getName());
            if (((InstalledEngine)localObject4).engineVersion != null)
            {
              ((InstalledEngine)localObject4).engineDir = ((File)localObject3).getAbsolutePath();
              ((InstalledEngine)localObject4).isVerify = verifyEngine((InstalledEngine)localObject4);
              if (((InstalledEngine)localObject4).isVerify)
              {
                if (((InstalledEngine)localObject4).engineType == 2)
                {
                  ((InstalledEngine)localObject4).engineName = "MiniGame";
                  ((InstalledEngine)localObject4).isPersist = isPersistGameEngine((File)localObject3);
                }
                else if (((InstalledEngine)localObject4).engineType == 3)
                {
                  ((InstalledEngine)localObject4).engineName = "MiniApp";
                }
                localArrayList.add(localObject4);
                break label474;
              }
              throw new IllegalStateException("engine verify failed");
            }
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("unrecognized engine ");
            ((StringBuilder)localObject4).append(((File)localObject3).getName());
            throw new IllegalStateException(((StringBuilder)localObject4).toString());
          }
          catch (Exception localException2)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[MiniEng]delete ");
            localStringBuilder.append(((File)localObject3).getAbsolutePath());
            localStringBuilder.append(DebugUtil.getPrintableStackTrace(localException2));
            QMLog.i("EngineInstaller", localStringBuilder.toString());
            FileUtils.delete(((File)localObject3).getAbsolutePath(), false);
          }
          label381:
          Collections.sort(localArrayList, Collections.reverseOrder());
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[MiniEng] scanInstalledEngine finish timecost=");
          ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
          ((StringBuilder)localObject2).append(", found ");
          ((StringBuilder)localObject2).append(localArrayList.size());
          QMLog.i("EngineInstaller", ((StringBuilder)localObject2).toString());
          return localArrayList;
        }
        catch (Exception localException1) {}
        localObject1 = finally;
        continue;
        throw localObject1;
        continue;
        label474:
        j += 1;
        continue;
        label481:
        i += 1;
      }
    }
    if (i < k)
    {
      arrayOfFile = localObject2[i];
      if ((!arrayOfFile.exists()) || (!arrayOfFile.isDirectory())) {
        break label481;
      }
      localObject3 = arrayOfFile.listFiles();
      if (localObject3 == null) {
        break label481;
      }
    }
  }
  
  /* Error */
  private boolean unzipEngine(File paramFile, String paramString1, EngineVersion paramEngineVersion, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore 6
    //   5: aload_1
    //   6: aload_3
    //   7: invokestatic 476	com/tencent/qqmini/sdk/manager/EngineInstaller:getInstallLibDir	(Ljava/io/File;Lcom/tencent/qqmini/sdk/manager/EngineVersion;)Ljava/lang/String;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +22 -> 34
    //   15: aload_0
    //   16: invokespecial 41	com/tencent/qqmini/sdk/manager/EngineInstaller:workFinish	()V
    //   19: aload 4
    //   21: iconst_1
    //   22: invokestatic 216	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   25: pop2
    //   26: aload_0
    //   27: invokespecial 41	com/tencent/qqmini/sdk/manager/EngineInstaller:workFinish	()V
    //   30: aload_0
    //   31: monitorexit
    //   32: iconst_0
    //   33: ireturn
    //   34: new 57	java/io/File
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: invokevirtual 91	java/io/File:exists	()Z
    //   45: ifeq +9 -> 54
    //   48: aload_1
    //   49: iconst_0
    //   50: invokestatic 216	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   53: pop2
    //   54: aload_0
    //   55: fconst_1
    //   56: ldc_w 478
    //   59: invokespecial 47	com/tencent/qqmini/sdk/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   62: aload_0
    //   63: aload_2
    //   64: aload_3
    //   65: aload 4
    //   67: iconst_0
    //   68: aload_1
    //   69: aload 4
    //   71: aload_1
    //   72: invokestatic 484	com/tencent/qqmini/sdk/core/utils/ZipUtil:unZipFolder	(Ljava/lang/String;Ljava/lang/String;)I
    //   75: invokespecial 486	com/tencent/qqmini/sdk/manager/EngineInstaller:handleUnZipResult	(Ljava/lang/String;Lcom/tencent/qqmini/sdk/manager/EngineVersion;Ljava/lang/String;ZLjava/lang/String;I)Z
    //   78: istore 7
    //   80: aload 4
    //   82: iconst_1
    //   83: invokestatic 216	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   86: pop2
    //   87: iload 7
    //   89: istore 6
    //   91: iload 7
    //   93: ifeq +37 -> 130
    //   96: iload 5
    //   98: ifeq +14 -> 112
    //   101: aload_0
    //   102: fconst_1
    //   103: ldc_w 488
    //   106: invokespecial 47	com/tencent/qqmini/sdk/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   109: goto +11 -> 120
    //   112: aload_0
    //   113: fconst_1
    //   114: ldc_w 490
    //   117: invokespecial 47	com/tencent/qqmini/sdk/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   120: ldc2_w 176
    //   123: invokestatic 183	java/lang/Thread:sleep	(J)V
    //   126: iload 7
    //   128: istore 6
    //   130: aload_0
    //   131: invokespecial 41	com/tencent/qqmini/sdk/manager/EngineInstaller:workFinish	()V
    //   134: goto +66 -> 200
    //   137: astore_1
    //   138: goto +67 -> 205
    //   141: astore_1
    //   142: new 68	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   149: astore_2
    //   150: aload_2
    //   151: ldc_w 492
    //   154: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_2
    //   159: aload_1
    //   160: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_2
    //   165: aload_1
    //   166: invokestatic 458	com/tencent/qqmini/sdk/utils/DebugUtil:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   169: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: ldc 8
    //   175: aload_2
    //   176: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 99	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_0
    //   183: fconst_0
    //   184: ldc_w 494
    //   187: invokespecial 47	com/tencent/qqmini/sdk/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   190: aload 4
    //   192: iconst_1
    //   193: invokestatic 216	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   196: pop2
    //   197: goto -67 -> 130
    //   200: aload_0
    //   201: monitorexit
    //   202: iload 6
    //   204: ireturn
    //   205: aload 4
    //   207: iconst_1
    //   208: invokestatic 216	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   211: pop2
    //   212: aload_0
    //   213: invokespecial 41	com/tencent/qqmini/sdk/manager/EngineInstaller:workFinish	()V
    //   216: aload_1
    //   217: athrow
    //   218: astore_1
    //   219: aload_0
    //   220: monitorexit
    //   221: goto +5 -> 226
    //   224: aload_1
    //   225: athrow
    //   226: goto -2 -> 224
    //   229: astore_1
    //   230: iload 7
    //   232: istore 6
    //   234: goto -104 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	EngineInstaller
    //   0	237	1	paramFile	File
    //   0	237	2	paramString1	String
    //   0	237	3	paramEngineVersion	EngineVersion
    //   0	237	4	paramString2	String
    //   0	237	5	paramBoolean	boolean
    //   3	230	6	bool1	boolean
    //   78	153	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	11	137	finally
    //   15	19	137	finally
    //   34	54	137	finally
    //   54	80	137	finally
    //   142	190	137	finally
    //   5	11	141	java/lang/Exception
    //   15	19	141	java/lang/Exception
    //   34	54	141	java/lang/Exception
    //   54	80	141	java/lang/Exception
    //   19	30	218	finally
    //   80	87	218	finally
    //   101	109	218	finally
    //   112	120	218	finally
    //   120	126	218	finally
    //   130	134	218	finally
    //   190	197	218	finally
    //   205	218	218	finally
    //   120	126	229	java/lang/InterruptedException
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
  
  private static boolean verifyEngine(InstalledEngine paramInstalledEngine)
  {
    Object localObject = getSp();
    boolean bool = false;
    if (localObject != null) {
      bool = getSp().getBoolean(paramInstalledEngine.engineDir, false);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MiniEng]verifyEngine ");
    ((StringBuilder)localObject).append(paramInstalledEngine.engineDir);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(bool);
    QMLog.i("EngineInstaller", ((StringBuilder)localObject).toString());
    return bool;
  }
  
  private void workAbort()
  {
    try
    {
      Iterator localIterator = this.mCallbacks.iterator();
      while (localIterator.hasNext())
      {
        EngineInstaller.Callback localCallback = (EngineInstaller.Callback)localIterator.next();
        if (localCallback != null) {
          localCallback.onEngineWorkAbort();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
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
    for (;;)
    {
      try
      {
        String str = paramBaseLibInfo.baseLibUrl;
        if (paramCallback != null) {
          addCallback(paramCallback);
        }
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramBaseLibInfo.baseLibVersion)) && (paramBaseLibInfo.baseLibType > 0))
        {
          Object localObject2 = new File(getRootDir(), String.valueOf(paramBaseLibInfo.baseLibType));
          try
          {
            Object localObject3 = new JSONObject(paramBaseLibInfo.baseLibDesc);
            localObject1 = new EngineVersion(paramBaseLibInfo.baseLibVersion);
            long l = ((JSONObject)localObject3).optLong("file_length");
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[MiniEng] installWithCallback ");
            ((StringBuilder)localObject3).append(paramBaseLibInfo);
            QMLog.w("EngineInstaller", ((StringBuilder)localObject3).toString());
            if (getSp() == null)
            {
              QMLog.w("EngineInstaller", "[MiniEng] shared preference not supported");
              workAbort();
              return;
            }
            if (TextUtils.isEmpty(str))
            {
              QMLog.e("EngineInstaller", "[MiniEng] empty engine url");
              workAbort();
              return;
            }
            if (isWorking())
            {
              QMLog.i("EngineInstaller", "[MiniEng] downloading already in progress");
              workAbort();
              return;
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[MiniEng] installWithCallback callback=");
            ((StringBuilder)localObject3).append(paramCallback);
            QMLog.i("EngineInstaller", ((StringBuilder)localObject3).toString());
            if ((paramBaseLibInfo.baseLibType == 2) && (!LocalGameEngine.g().isDisabled()) && (!paramBaseLibInfo.baseLibUrl.startsWith("assets://")))
            {
              paramCallback = LocalGameEngine.g().mLocalEngineVersion;
              if (paramCallback.compareTo((EngineVersion)localObject1) >= 0)
              {
                paramBaseLibInfo = new StringBuilder();
                paramBaseLibInfo.append("[MiniEng] refuse install remote baselib:");
                paramBaseLibInfo.append(localObject1);
                paramBaseLibInfo.append(",local:");
                paramBaseLibInfo.append(paramCallback);
                QMLog.i("EngineInstaller", paramBaseLibInfo.toString());
                workAbort();
                return;
              }
            }
            paramCallback = getInstalledEngine(paramBaseLibInfo.baseLibType);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[MiniEng] engineForType ");
            ((StringBuilder)localObject3).append(paramBaseLibInfo.baseLibType);
            ((StringBuilder)localObject3).append(", size=");
            ((StringBuilder)localObject3).append(paramCallback.size());
            QMLog.i("EngineInstaller", ((StringBuilder)localObject3).toString());
            boolean bool1;
            if (paramCallback.size() > 0)
            {
              paramCallback = (InstalledEngine)paramCallback.get(0);
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("[MiniEng]latest engine for type ");
              ((StringBuilder)localObject3).append(paramBaseLibInfo.baseLibType);
              ((StringBuilder)localObject3).append(",");
              ((StringBuilder)localObject3).append(paramCallback);
              QMLog.i("EngineInstaller", ((StringBuilder)localObject3).toString());
              if (paramCallback.engineVersion.compareTo((EngineVersion)localObject1) >= 0)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("[MiniEng]engine type ");
                ((StringBuilder)localObject2).append(paramBaseLibInfo.baseLibType);
                ((StringBuilder)localObject2).append(" has no update, remote:");
                ((StringBuilder)localObject2).append(localObject1);
                ((StringBuilder)localObject2).append(",latest:");
                ((StringBuilder)localObject2).append(paramCallback);
                QMLog.i("EngineInstaller", ((StringBuilder)localObject2).toString());
                workAbort();
                return;
              }
              bool1 = true;
            }
            else
            {
              bool1 = false;
            }
            workBegin();
            if (bool1)
            {
              paramCallback = new StringBuilder();
              paramCallback.append("更新引擎(");
              paramCallback.append(paramBaseLibInfo.baseLibVersion);
              paramCallback.append(")");
              updateMessage(0.0F, paramCallback.toString());
            }
            else
            {
              paramCallback = new StringBuilder();
              paramCallback.append("下载引擎(");
              paramCallback.append(paramBaseLibInfo.baseLibVersion);
              paramCallback.append(")");
              updateMessage(0.0F, paramCallback.toString());
            }
            paramCallback = new StringBuilder();
            paramCallback.append("[MiniEng] installEngine ");
            paramCallback.append(str);
            QMLog.i("EngineInstaller", paramCallback.toString());
            if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs()))
            {
              paramBaseLibInfo = new StringBuilder();
              paramBaseLibInfo.append("[MiniEng] mkdir failed, is disk writable? ");
              paramBaseLibInfo.append(((File)localObject2).getAbsolutePath());
              QMLog.i("EngineInstaller", paramBaseLibInfo.toString());
              workFinish();
              return;
            }
            paramCallback = null;
            if (paramBaseLibInfo.baseLibType != 2) {
              break label977;
            }
            bool2 = paramBaseLibInfo.baseLibUrl.startsWith("assets://");
            paramBaseLibInfo.baseLibUrl.replace("assets://", "");
            paramCallback = new long[1];
            paramCallback[0] = 0L;
            if (bool2) {
              installFromAssets(str, getInstallLibDir((File)localObject2, (EngineVersion)localObject1), l, paramCallback[0]);
            } else {
              installedFromNetwork(paramBaseLibInfo, str, l, (File)localObject2, (EngineVersion)localObject1, bool1);
            }
            return;
          }
          catch (Exception paramCallback)
          {
            Object localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[MiniEng] refuse installEngine ");
            ((StringBuilder)localObject1).append(paramBaseLibInfo.baseLibDesc);
            ((StringBuilder)localObject1).append(":");
            ((StringBuilder)localObject1).append(paramBaseLibInfo.baseLibVersion);
            ((StringBuilder)localObject1).append(paramBaseLibInfo.baseLibUrl);
            ((StringBuilder)localObject1).append(DebugUtil.getPrintableStackTrace(paramCallback));
            QMLog.w("EngineInstaller", ((StringBuilder)localObject1).toString());
            workAbort();
            return;
          }
        }
        else
        {
          paramCallback = new StringBuilder();
          paramCallback.append("[MiniEng] invalid BaseLibInfo ");
          paramCallback.append(paramBaseLibInfo);
          QMLog.w("EngineInstaller", paramCallback.toString());
          workAbort();
          return;
        }
      }
      finally {}
      label977:
      boolean bool2 = false;
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
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineInstaller
 * JD-Core Version:    0.7.0.1
 */