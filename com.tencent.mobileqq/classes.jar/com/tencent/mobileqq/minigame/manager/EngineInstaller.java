package com.tencent.mobileqq.minigame.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.oskplayer.util.StorageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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
  private AbstractDownloader mDownloader;
  
  public EngineInstaller(AbstractDownloader paramAbstractDownloader)
  {
    this.mDownloader = paramAbstractDownloader;
  }
  
  private static String getInstallLibDir(File paramFile, EngineVersion paramEngineVersion)
  {
    try
    {
      paramFile = new File(paramFile, paramEngineVersion.toFolderName());
      paramEngineVersion = new StringBuilder();
      paramEngineVersion.append("[MiniEng]getInstallLibDir ");
      paramEngineVersion.append(paramFile.getAbsolutePath());
      QLog.i("EngineInstaller", 1, paramEngineVersion.toString());
      if ((!paramFile.exists()) && (!paramFile.mkdirs()))
      {
        paramEngineVersion = new StringBuilder();
        paramEngineVersion.append("[MiniEng] getInstallLibDir failed, is disk writable? ");
        paramEngineVersion.append(paramFile.getAbsolutePath());
        QLog.e("EngineInstaller", 1, paramEngineVersion.toString());
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
      ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getFilesDir().getPath());
      ((StringBuilder)localObject).append("/xminilib/");
      localObject = new File(((StringBuilder)localObject).toString());
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MiniEng] dir mk failed ");
        localStringBuilder.append(localObject);
        QLog.e("EngineInstaller", 1, localStringBuilder.toString());
      }
      sRootDir = (File)localObject;
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
    if (paramInstalledEngine == null) {
      return;
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MiniEng] removeEngine ");
      localStringBuilder.append(paramInstalledEngine);
      QLog.i("EngineInstaller", 1, localStringBuilder.toString());
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
        QLog.e("EngineInstaller", 1, "[MiniEng]removeOldEngine null");
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
          QLog.i("EngineInstaller", 1, ((StringBuilder)localObject3).toString());
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
            QLog.i("EngineInstaller", 1, ((StringBuilder)localObject3).toString());
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
        QLog.e("EngineInstaller", 1, "[MiniEng]removeOutDatedEngine null");
        return;
      }
      Object localObject3 = new ArrayList();
      Object localObject1 = sInstalledEngine.iterator();
      Object localObject4;
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (InstalledEngine)((Iterator)localObject1).next();
        if (((InstalledEngine)localObject4).engineType == paramInt) {
          ((List)localObject3).add(localObject4);
        }
      }
      localObject1 = null;
      if (paramInt == 2) {
        localObject1 = LocalGameEngine.g().mLocalEngineVersion;
      }
      if (localObject1 != null)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[MiniEng] removeOutDatedEngine, localMinVer:");
        ((StringBuilder)localObject4).append(localObject1);
        QLog.i("EngineInstaller", 1, ((StringBuilder)localObject4).toString());
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (InstalledEngine)((Iterator)localObject3).next();
          StringBuilder localStringBuilder;
          if ((((InstalledEngine)localObject4).engineVersion.compareTo((EngineVersion)localObject1) >= 0) && ((paramInt != 2) || (((InstalledEngine)localObject4).engineVersion.mMinor.compareTo(((EngineVersion)localObject1).mMinor) >= 0)))
          {
            if ((((InstalledEngine)localObject4).isPersist) && (!isCurrentPersistGameEngine(new File(((InstalledEngine)localObject4).engineDir))))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[MiniEng] removeOutDatedPersistEngine ");
              localStringBuilder.append(localObject4);
              localStringBuilder.append(" localMinVer:");
              localStringBuilder.append(localObject1);
              localStringBuilder.append(",engineType:");
              localStringBuilder.append(paramInt);
              QLog.i("EngineInstaller", 1, localStringBuilder.toString());
              ((InstalledEngine)localObject4).deleteFiles();
              sInstalledEngine.remove(localObject4);
            }
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[MiniEng] removeOutDatedEngine ");
            localStringBuilder.append(localObject4);
            localStringBuilder.append(" localMinVer:");
            localStringBuilder.append(localObject1);
            localStringBuilder.append(",engineType:");
            localStringBuilder.append(paramInt);
            QLog.i("EngineInstaller", 1, localStringBuilder.toString());
            ((InstalledEngine)localObject4).deleteFiles();
            sInstalledEngine.remove(localObject4);
          }
        }
      }
      QLog.w("EngineInstaller", 1, "[MiniEng] removeOutDatedEngine, localMinVer is null");
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
      QLog.i("EngineInstaller", 1, "[MiniEng] scanInstalledEngine");
      l = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localObject2 = getRootDir();
      if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory()) || (((File)localObject2).listFiles() == null)) {
        break label423;
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
            break label524;
          }
          Object localObject3 = arrayOfFile[j];
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("f2: ");
          ((StringBuilder)localObject4).append(((File)localObject3).getAbsolutePath());
          QLog.d("scanInstalledEngine", 4, ((StringBuilder)localObject4).toString());
          try
          {
            localObject4 = new InstalledEngine();
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
                break label517;
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
            QLog.i("EngineInstaller", 1, localStringBuilder.toString());
            FileUtils.delete(((File)localObject3).getAbsolutePath(), false);
          }
          label423:
          Collections.sort(localArrayList, Collections.reverseOrder());
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[MiniEng] scanInstalledEngine finish timecost=");
          ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
          ((StringBuilder)localObject2).append(", found ");
          ((StringBuilder)localObject2).append(localArrayList.size());
          QLog.i("EngineInstaller", 1, ((StringBuilder)localObject2).toString());
          return localArrayList;
        }
        catch (Exception localException1) {}
        localObject1 = finally;
        continue;
        throw localObject1;
        continue;
        label517:
        j += 1;
        continue;
        label524:
        i += 1;
      }
    }
    if (i < k)
    {
      arrayOfFile = localObject2[i];
      if ((!arrayOfFile.exists()) || (!arrayOfFile.isDirectory())) {
        break label524;
      }
      localObject3 = arrayOfFile.listFiles();
      if (localObject3 == null) {
        break label524;
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
    //   3: istore 10
    //   5: iconst_0
    //   6: istore 9
    //   8: aload_1
    //   9: aload_3
    //   10: invokestatic 417	com/tencent/mobileqq/minigame/manager/EngineInstaller:getInstallLibDir	(Ljava/io/File;Lcom/tencent/mobileqq/minigame/manager/EngineVersion;)Ljava/lang/String;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +21 -> 36
    //   18: aload_0
    //   19: invokespecial 46	com/tencent/mobileqq/minigame/manager/EngineInstaller:workFinish	()V
    //   22: aload 4
    //   24: iconst_1
    //   25: invokestatic 396	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   28: aload_0
    //   29: invokespecial 46	com/tencent/mobileqq/minigame/manager/EngineInstaller:workFinish	()V
    //   32: aload_0
    //   33: monitorexit
    //   34: iconst_0
    //   35: ireturn
    //   36: new 62	java/io/File
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 157	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: invokevirtual 96	java/io/File:exists	()Z
    //   47: ifeq +8 -> 55
    //   50: aload_1
    //   51: iconst_0
    //   52: invokestatic 396	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   55: aload_0
    //   56: fconst_1
    //   57: ldc_w 418
    //   60: invokestatic 424	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   63: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   66: aload 4
    //   68: aload_1
    //   69: invokestatic 430	com/tencent/biz/common/util/ZipUtils:unZipFolder	(Ljava/lang/String;Ljava/lang/String;)I
    //   72: istore 6
    //   74: iload 6
    //   76: ifne +423 -> 499
    //   79: ldc2_w 195
    //   82: invokestatic 202	java/lang/Thread:sleep	(J)V
    //   85: aload_0
    //   86: fconst_1
    //   87: ldc_w 431
    //   90: invokestatic 424	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   93: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   96: ldc2_w 195
    //   99: invokestatic 202	java/lang/Thread:sleep	(J)V
    //   102: aload_0
    //   103: aload 4
    //   105: aload_1
    //   106: invokespecial 435	com/tencent/mobileqq/minigame/manager/EngineInstaller:verifyBaselib	(Ljava/lang/String;Ljava/lang/String;)Z
    //   109: istore 8
    //   111: goto +3 -> 114
    //   114: iload 6
    //   116: ifne +85 -> 201
    //   119: iload 8
    //   121: ifeq +80 -> 201
    //   124: new 73	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   131: astore 11
    //   133: aload 11
    //   135: ldc_w 437
    //   138: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 11
    //   144: aload_2
    //   145: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 11
    //   151: ldc_w 439
    //   154: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 11
    //   160: aload_3
    //   161: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 11
    //   167: ldc_w 441
    //   170: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 11
    //   176: aload_1
    //   177: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: ldc 8
    //   183: iconst_1
    //   184: aload 11
    //   186: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: invokestatic 109	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateInstalledEngine	()V
    //   195: iconst_1
    //   196: istore 7
    //   198: goto +123 -> 321
    //   201: new 73	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   208: astore 11
    //   210: aload 11
    //   212: ldc_w 443
    //   215: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 11
    //   221: aload_2
    //   222: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 11
    //   228: ldc_w 439
    //   231: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 11
    //   237: aload_3
    //   238: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 11
    //   244: ldc_w 441
    //   247: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 11
    //   253: aload_1
    //   254: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: ldc 8
    //   260: iconst_1
    //   261: aload 11
    //   263: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 92	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload_1
    //   270: iconst_0
    //   271: invokestatic 396	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   274: iload 6
    //   276: ifeq +21 -> 297
    //   279: aload_0
    //   280: fconst_0
    //   281: ldc_w 444
    //   284: invokestatic 424	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   287: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   290: iload 9
    //   292: istore 7
    //   294: goto +27 -> 321
    //   297: iload 9
    //   299: istore 7
    //   301: iload 8
    //   303: ifne +18 -> 321
    //   306: aload_0
    //   307: fconst_0
    //   308: ldc_w 445
    //   311: invokestatic 424	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   314: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   317: iload 9
    //   319: istore 7
    //   321: aload 4
    //   323: iconst_1
    //   324: invokestatic 396	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   327: iload 7
    //   329: istore 8
    //   331: iload 7
    //   333: ifeq +43 -> 376
    //   336: iload 5
    //   338: ifeq +17 -> 355
    //   341: aload_0
    //   342: fconst_1
    //   343: ldc_w 446
    //   346: invokestatic 424	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   349: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   352: goto +14 -> 366
    //   355: aload_0
    //   356: fconst_1
    //   357: ldc_w 447
    //   360: invokestatic 424	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   363: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   366: ldc2_w 195
    //   369: invokestatic 202	java/lang/Thread:sleep	(J)V
    //   372: iload 7
    //   374: istore 8
    //   376: aload_0
    //   377: invokespecial 46	com/tencent/mobileqq/minigame/manager/EngineInstaller:workFinish	()V
    //   380: goto +73 -> 453
    //   383: astore_1
    //   384: goto +74 -> 458
    //   387: astore_1
    //   388: new 73	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   395: astore_2
    //   396: aload_2
    //   397: ldc_w 449
    //   400: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload_2
    //   405: aload_1
    //   406: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload_2
    //   411: aload_1
    //   412: invokestatic 390	com/tencent/mobileqq/mini/utils/DebugUtil:getPrintableStackTrace	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   415: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: ldc 8
    //   421: iconst_1
    //   422: aload_2
    //   423: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: aload_0
    //   430: fconst_0
    //   431: ldc_w 450
    //   434: invokestatic 424	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   437: invokespecial 52	com/tencent/mobileqq/minigame/manager/EngineInstaller:updateMessage	(FLjava/lang/String;)V
    //   440: aload 4
    //   442: iconst_1
    //   443: invokestatic 396	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   446: iload 10
    //   448: istore 8
    //   450: goto -74 -> 376
    //   453: aload_0
    //   454: monitorexit
    //   455: iload 8
    //   457: ireturn
    //   458: aload 4
    //   460: iconst_1
    //   461: invokestatic 396	com/tencent/mobileqq/mini/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   464: aload_0
    //   465: invokespecial 46	com/tencent/mobileqq/minigame/manager/EngineInstaller:workFinish	()V
    //   468: aload_1
    //   469: athrow
    //   470: astore_1
    //   471: aload_0
    //   472: monitorexit
    //   473: goto +5 -> 478
    //   476: aload_1
    //   477: athrow
    //   478: goto -2 -> 476
    //   481: astore 11
    //   483: goto -398 -> 85
    //   486: astore 11
    //   488: goto -386 -> 102
    //   491: astore_1
    //   492: iload 7
    //   494: istore 8
    //   496: goto -120 -> 376
    //   499: iconst_1
    //   500: istore 8
    //   502: goto -388 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	this	EngineInstaller
    //   0	505	1	paramFile	File
    //   0	505	2	paramString1	String
    //   0	505	3	paramEngineVersion	EngineVersion
    //   0	505	4	paramString2	String
    //   0	505	5	paramBoolean	boolean
    //   72	203	6	i	int
    //   196	297	7	bool1	boolean
    //   109	392	8	bool2	boolean
    //   6	312	9	bool3	boolean
    //   3	444	10	bool4	boolean
    //   131	131	11	localStringBuilder	StringBuilder
    //   481	1	11	localInterruptedException1	InterruptedException
    //   486	1	11	localInterruptedException2	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   8	14	383	finally
    //   18	22	383	finally
    //   36	55	383	finally
    //   55	74	383	finally
    //   79	85	383	finally
    //   85	96	383	finally
    //   96	102	383	finally
    //   102	111	383	finally
    //   124	195	383	finally
    //   201	274	383	finally
    //   279	290	383	finally
    //   306	317	383	finally
    //   388	440	383	finally
    //   8	14	387	java/lang/Exception
    //   18	22	387	java/lang/Exception
    //   36	55	387	java/lang/Exception
    //   55	74	387	java/lang/Exception
    //   79	85	387	java/lang/Exception
    //   85	96	387	java/lang/Exception
    //   96	102	387	java/lang/Exception
    //   102	111	387	java/lang/Exception
    //   124	195	387	java/lang/Exception
    //   201	274	387	java/lang/Exception
    //   279	290	387	java/lang/Exception
    //   306	317	387	java/lang/Exception
    //   22	32	470	finally
    //   321	327	470	finally
    //   341	352	470	finally
    //   355	366	470	finally
    //   366	372	470	finally
    //   376	380	470	finally
    //   440	446	470	finally
    //   458	470	470	finally
    //   79	85	481	java/lang/InterruptedException
    //   96	102	486	java/lang/InterruptedException
    //   366	372	491	java/lang/InterruptedException
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
    long l1 = ZipUtils.getUncompressedFileSize(paramString1);
    if (l1 <= 0L)
    {
      paramString2 = new StringBuilder();
      paramString2.append("[MiniEng] getUncompressedFileSize error ");
      paramString2.append(paramString1);
      paramString2.append(", sz=");
      paramString2.append(l1);
      QLog.e("EngineInstaller", 1, paramString2.toString());
      return false;
    }
    long l2 = StorageUtil.getDirUsedSpace(paramString2);
    if (l2 <= 0L)
    {
      paramString1 = new StringBuilder();
      paramString1.append("[MiniEng] getDirUsedSpace error ");
      paramString1.append(paramString2);
      paramString1.append(", sz2=");
      paramString1.append(l2);
      QLog.e("EngineInstaller", 1, paramString1.toString());
      return false;
    }
    if (l1 == l2)
    {
      getSp().edit().putBoolean(paramString2, true).commit();
      return true;
    }
    paramString1 = new StringBuilder();
    paramString1.append("[MiniEng] verifyBaselib failed sz1=");
    paramString1.append(l1);
    paramString1.append(", sz2=");
    paramString1.append(l2);
    QLog.e("EngineInstaller", 1, paramString1.toString());
    return false;
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
    QLog.i("EngineInstaller", 1, ((StringBuilder)localObject).toString());
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
        Object localObject1 = paramBaseLibInfo.baseLibUrl;
        if (paramCallback != null) {
          addCallback(paramCallback);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramBaseLibInfo.baseLibVersion)) && (paramBaseLibInfo.baseLibType > 0))
        {
          File localFile = new File(getRootDir(), String.valueOf(paramBaseLibInfo.baseLibType));
          try
          {
            Object localObject3 = new JSONObject(paramBaseLibInfo.baseLibDesc);
            Object localObject2 = new EngineVersion(paramBaseLibInfo.baseLibVersion);
            long l = ((JSONObject)localObject3).optLong("file_length", -1L);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[MiniEng] installWithCallback ");
            ((StringBuilder)localObject3).append(paramBaseLibInfo);
            QLog.w("EngineInstaller", 1, ((StringBuilder)localObject3).toString());
            if (!AppUtil.isMainProcess())
            {
              QLog.w("EngineInstaller", 1, "[MiniEng] download triggered at wrong process");
              workAbort();
              return;
            }
            if (getSp() == null)
            {
              QLog.w("EngineInstaller", 1, "[MiniEng] shared preference not supported");
              workAbort();
              return;
            }
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              QLog.e("EngineInstaller", 1, "[MiniEng] empty engine url");
              workAbort();
              return;
            }
            if (isWorking())
            {
              QLog.i("EngineInstaller", 1, "[MiniEng] downloading already in progress");
              workAbort();
              return;
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[MiniEng] installWithCallback callback=");
            ((StringBuilder)localObject3).append(paramCallback);
            QLog.i("EngineInstaller", 1, ((StringBuilder)localObject3).toString());
            if ((paramBaseLibInfo.baseLibType == 2) && (!LocalGameEngine.g().isDisabled()) && (!paramBaseLibInfo.baseLibUrl.startsWith("assets://")))
            {
              paramCallback = LocalGameEngine.g().mLocalEngineVersion;
              if (paramCallback.compareTo((EngineVersion)localObject2) >= 0)
              {
                paramBaseLibInfo = new StringBuilder();
                paramBaseLibInfo.append("[MiniEng] refuse install remote baselib:");
                paramBaseLibInfo.append(localObject2);
                paramBaseLibInfo.append(",local:");
                paramBaseLibInfo.append(paramCallback);
                QLog.i("EngineInstaller", 1, paramBaseLibInfo.toString());
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
            QLog.i("EngineInstaller", 1, ((StringBuilder)localObject3).toString());
            boolean bool1;
            if (paramCallback.size() > 0)
            {
              paramCallback = (InstalledEngine)paramCallback.get(0);
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("[MiniEng]latest engine for type ");
              ((StringBuilder)localObject3).append(paramBaseLibInfo.baseLibType);
              ((StringBuilder)localObject3).append(",");
              ((StringBuilder)localObject3).append(paramCallback);
              QLog.i("EngineInstaller", 1, ((StringBuilder)localObject3).toString());
              if (paramCallback.engineVersion.compareTo((EngineVersion)localObject2) >= 0)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("[MiniEng]engine type ");
                ((StringBuilder)localObject1).append(paramBaseLibInfo.baseLibType);
                ((StringBuilder)localObject1).append(" has no update, remote:");
                ((StringBuilder)localObject1).append(localObject2);
                ((StringBuilder)localObject1).append(",latest:");
                ((StringBuilder)localObject1).append(paramCallback);
                QLog.i("EngineInstaller", 1, ((StringBuilder)localObject1).toString());
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
              paramCallback.append(HardCodeUtil.a(2131902161));
              paramCallback.append(paramBaseLibInfo.baseLibVersion);
              paramCallback.append(")");
              updateMessage(0.0F, paramCallback.toString());
            }
            else
            {
              paramCallback = new StringBuilder();
              paramCallback.append(HardCodeUtil.a(2131902166));
              paramCallback.append(paramBaseLibInfo.baseLibVersion);
              paramCallback.append(")");
              updateMessage(0.0F, paramCallback.toString());
            }
            paramCallback = new StringBuilder();
            paramCallback.append("[MiniEng] installEngine ");
            paramCallback.append((String)localObject1);
            QLog.i("EngineInstaller", 1, paramCallback.toString());
            if ((!localFile.exists()) && (!localFile.mkdirs()))
            {
              paramBaseLibInfo = new StringBuilder();
              paramBaseLibInfo.append("[MiniEng] mkdir failed, is disk writable? ");
              paramBaseLibInfo.append(localFile.getAbsolutePath());
              QLog.i("EngineInstaller", 1, paramBaseLibInfo.toString());
              workFinish();
              return;
            }
            paramCallback = null;
            if (paramBaseLibInfo.baseLibType != 2) {
              break label1359;
            }
            bool2 = paramBaseLibInfo.baseLibUrl.startsWith("assets://");
            paramBaseLibInfo.baseLibUrl.replace("assets://", "");
            paramCallback = new long[1];
            paramCallback[0] = 0L;
            if (bool2) {
              try
              {
                updateMessage(0.0F, HardCodeUtil.a(2131902162));
                paramBaseLibInfo = getInstallLibDir(localFile, (EngineVersion)localObject2);
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("[MiniEng] installLocalEngine start url=");
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append(",installBasePath=");
                ((StringBuilder)localObject2).append(paramBaseLibInfo);
                QLog.i("EngineInstaller", 1, ((StringBuilder)localObject2).toString());
                if (TextUtils.isEmpty(paramBaseLibInfo))
                {
                  updateMessage(0.0F, HardCodeUtil.a(2131902173));
                  paramCallback = new StringBuilder();
                  paramCallback.append("[MiniEng] installLocalEngine failed installBasePath=");
                  paramCallback.append(paramBaseLibInfo);
                  QLog.e("EngineInstaller", 1, paramCallback.toString());
                  workFinish();
                  return;
                }
                localObject1 = new File(paramBaseLibInfo);
                if ((!((File)localObject1).exists()) && (!((File)localObject1).mkdir()))
                {
                  updateMessage(0.0F, HardCodeUtil.a(2131902165));
                  paramBaseLibInfo = new StringBuilder();
                  paramBaseLibInfo.append("[MiniEng] installLocalEngine failed targetPath=");
                  paramBaseLibInfo.append(localObject1);
                  QLog.e("EngineInstaller", 1, paramBaseLibInfo.toString());
                  workFinish();
                  return;
                }
                BaseLibManager.g().installMiniGameInnerJsLib();
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("[MiniEng] installLocalEngine finish copied ");
                ((StringBuilder)localObject1).append(paramCallback[0]);
                ((StringBuilder)localObject1).append("<>");
                ((StringBuilder)localObject1).append(l);
                QLog.i("EngineInstaller", 1, ((StringBuilder)localObject1).toString());
                if ((paramCallback[0] != l) && (l >= 0L))
                {
                  updateMessage(0.0F, HardCodeUtil.a(2131902171));
                }
                else
                {
                  getSp().edit().putBoolean(paramBaseLibInfo, true).commit();
                  updateInstalledEngine();
                  updateMessage(1.0F, HardCodeUtil.a(2131902160));
                }
                workFinish();
              }
              finally {}
            } else {
              installedFromNetwork(paramBaseLibInfo, (String)localObject1, l, localFile, (EngineVersion)localObject2, bool1);
            }
            return;
          }
          catch (Exception paramCallback)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[MiniEng] refuse installEngine ");
            ((StringBuilder)localObject1).append(paramBaseLibInfo.baseLibDesc);
            ((StringBuilder)localObject1).append(":");
            ((StringBuilder)localObject1).append(paramBaseLibInfo.baseLibVersion);
            ((StringBuilder)localObject1).append(paramBaseLibInfo.baseLibUrl);
            ((StringBuilder)localObject1).append(DebugUtil.getPrintableStackTrace(paramCallback));
            QLog.w("EngineInstaller", 1, ((StringBuilder)localObject1).toString());
            workAbort();
            return;
          }
        }
        else
        {
          paramCallback = new StringBuilder();
          paramCallback.append("[MiniEng] invalid BaseLibInfo ");
          paramCallback.append(paramBaseLibInfo);
          QLog.w("EngineInstaller", 1, paramCallback.toString());
          workAbort();
          return;
        }
      }
      finally {}
      label1359:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineInstaller
 * JD-Core Version:    0.7.0.1
 */