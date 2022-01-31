package com.tencent.mobileqq.mini.apkg;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import apvd;
import bdik;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.minigame.utils.AssetsUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"WrongConstant"})
public class BaseLibManager
{
  public static final String BASE_ENGINE_PATH_DIR;
  private static int MINI_APP_INNER_BASELIB_RETRY_COUNT_DEFAULT = 2;
  public static final String PATH_WXGPKG_ROOT = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/minigame/";
  public static final int RET_CODE_DOWNLOAD_FAIL = 1101;
  public static final int RET_CODE_NO_UPDATE = 1;
  public static final int RET_CODE_OTHER = 1103;
  public static final int RET_CODE_SUCC = 0;
  public static final int RET_CODE_UNZIP_FAIL = 1102;
  public static final int RET_CODE_UPDATE_CMD_ERROR = 1100;
  private static final String TAG = "miniapp-process_BaseLibManager[MiniEng]";
  private static BaseLibManager instance;
  private static byte[] lock;
  private boolean isFirstTimeUpdateBaseLib;
  private boolean isUpdatingBaseLib;
  private List<BaseLibManager.UpdateListener> mListeners = new ArrayList();
  private List<String> miniAppBaseLibFiles = Arrays.asList(new String[] { "QView.js", "QLogic.js", "QVConsole.js", "QRemoteDebug.js", "QWebview.js" });
  private List<String> miniGameBaseLibFiles = Arrays.asList(new String[] { "QGame.js", "QGameOpenDataContext.js", "QGameWorkerContext.js" });
  
  static
  {
    BASE_ENGINE_PATH_DIR = PATH_WXGPKG_ROOT + ".baseengine";
    lock = new byte[0];
  }
  
  private BaseLibManager()
  {
    File localFile = new File(BASE_ENGINE_PATH_DIR);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public static BaseLibManager g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new BaseLibManager();
      }
      return instance;
    }
  }
  
  private List<String> getInnerBaseLibFiles()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.miniAppBaseLibFiles);
    localArrayList.addAll(this.miniGameBaseLibFiles);
    return localArrayList;
  }
  
  private boolean isBaseLibDirValid(File paramFile, String[] paramArrayOfString)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {}
    for (;;)
    {
      return false;
      if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
      {
        int i = 0;
        try
        {
          for (;;)
          {
            if (i >= paramArrayOfString.length) {
              break label77;
            }
            File localFile = new File(paramFile, paramArrayOfString[i]);
            if (!localFile.exists()) {
              break;
            }
            boolean bool = localFile.isDirectory();
            if (bool) {
              break;
            }
            i += 1;
          }
          label77:
          return true;
        }
        catch (Throwable paramFile)
        {
          QLog.e("miniapp-process_BaseLibManager[MiniEng]", 1, "isBaseLibDirValid exception!", paramFile);
        }
      }
    }
    return false;
  }
  
  private Boolean needUpdate(BaseLibInfo paramBaseLibInfo)
  {
    if (paramBaseLibInfo == null) {
      return Boolean.valueOf(false);
    }
    String str = StorageUtil.getPreference().getString("version", "1.13.0.00013");
    return Boolean.valueOf(BaseLibInfo.needUpdateVersion(paramBaseLibInfo.baseLibVersion, str));
  }
  
  private void notifyUpdateResult(int paramInt)
  {
    try
    {
      Object localObject1 = new ArrayList(this.mListeners);
      this.mListeners.clear();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((BaseLibManager.UpdateListener)((Iterator)localObject1).next()).onUpdateResult(paramInt);
      }
      this.isUpdatingBaseLib = false;
    }
    finally {}
  }
  
  private boolean verifyBaselib(File paramFile)
  {
    boolean bool2 = true;
    if ((paramFile == null) || (!paramFile.exists()) || (paramFile.isFile())) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        localObject1 = new File(paramFile, "verify.json");
        bool1 = bool2;
        if (((File)localObject1).exists())
        {
          bool1 = bool2;
          if (((File)localObject1).isFile())
          {
            localObject1 = new JSONObject(FileUtils.readFileToString((File)localObject1));
            bool1 = bool2;
            if (((JSONObject)localObject1).has("verify_list"))
            {
              localObject1 = ((JSONObject)localObject1).getJSONArray("verify_list");
              i = 0;
            }
          }
        }
      }
      catch (Exception paramFile)
      {
        for (;;)
        {
          Object localObject1;
          int i;
          Object localObject2;
          String str;
          int j;
          long l;
          QLog.e("miniapp-start", 1, "ApkgManager--verifyBaselib exception.", paramFile);
          bool1 = false;
          continue;
          bool1 = true;
          continue;
          i += 1;
        }
      }
    }
    if (i < ((JSONArray)localObject1).length())
    {
      if (((JSONArray)localObject1).get(i) == null)
      {
        QLog.e("miniapp-start", 1, "配置文件格式异常！！请使用json工具检测");
        break label290;
      }
      localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
      str = ((JSONObject)localObject2).getString("name");
      j = ((JSONObject)localObject2).getInt("length");
      localObject2 = new File(paramFile, str);
      QLog.i("miniapp-start", 1, "ApkgManager--verifyBaselib file: " + str + " config_length=" + j + " local_length=" + ((File)localObject2).length());
      if ((((File)localObject2).exists()) && (((File)localObject2).isFile()))
      {
        l = ((File)localObject2).length();
        if (l == j) {
          break label290;
        }
      }
      bool1 = false;
      return bool1;
    }
  }
  
  public void doDownloadBaselib(String paramString1, String paramString2, String paramString3, String paramString4, BaseLibManager.UpdateListener paramUpdateListener)
  {
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "doDownloadBaselib url=" + paramString1 + " version=" + paramString2 + " oldUrl=" + paramString3 + " oldVersion=" + paramString4);
    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 4, null, null, null, 0);
    String str = getBaseLibZipPath(paramString1, paramString2);
    MiniappDownloadUtil.getInstance().download(paramString1, str, true, new BaseLibManager.3(this, paramString1, paramUpdateListener, paramString2, paramString4, str, paramString3), Downloader.DownloadMode.StrictMode, null);
  }
  
  public void forceUpdateBaseLib(BaseLibManager.UpdateListener paramUpdateListener)
  {
    try
    {
      ThreadManager.excute(new BaseLibManager.1(this, paramUpdateListener), 16, null, false);
      return;
    }
    finally
    {
      paramUpdateListener = finally;
      throw paramUpdateListener;
    }
  }
  
  public String getBaseLibDir(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    try
    {
      paramString1 = AppLoaderFactory.BASE_LIB_PATH_DIR + File.separator + bdik.d(paramString1) + "_" + paramString2 + File.separator;
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      QLog.e("miniapp-process_BaseLibManager[MiniEng]", 1, "getBaseLibDir exception!", paramString1);
    }
    return AppLoaderFactory.BASE_LIB_PATH_DIR + File.separator + "_" + paramString2 + File.separator;
  }
  
  public BaseLibInfo getBaseLibInfo()
  {
    BaseLibInfo localBaseLibInfo = new BaseLibInfo();
    String str = StorageUtil.getPreference().getString("downloadUrl", null);
    localBaseLibInfo.baseLibVersion = StorageUtil.getPreference().getString("version", "1.13.0.00013");
    localBaseLibInfo.baseLibUrl = str;
    return localBaseLibInfo;
  }
  
  public String getBaseLibZipPath(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return AppLoaderFactory.BASE_LIB_PATH_DIR + File.separator + bdik.d(paramString1) + "_" + paramString2 + ".zip";
  }
  
  public boolean installInnerBaseLib()
  {
    String str = g().getBaseLibDir("mini", "1.13.0.00013");
    if (g().isBaseLibDirValid(str))
    {
      QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng]installInnerBaseLib, inner baseLib already installed, version:1.13.0.00013");
      return true;
    }
    int j = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_inner_baselib_retry_count", MINI_APP_INNER_BASELIB_RETRY_COUNT_DEFAULT);
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng]installInnerBaseLib, version:1.13.0.00013, totalCount:" + j);
    int i = 0;
    while (i < j)
    {
      boolean bool = AssetsUtil.copyFileOrDir(BaseApplicationImpl.getContext(), "mini", str, getInnerBaseLibFiles());
      if ((bool) && (g().isBaseLibDirValid(str)))
      {
        QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng] install inner baseLib success, from mini to " + str + ", tryCount:" + i + ", totalCount:" + j);
        return bool;
      }
      File localFile = new File(str);
      if (localFile.exists()) {
        apvd.a(localFile);
      }
      QLog.w("miniapp-process_BaseLibManager[MiniEng]", 1, "[MiniEng] install inner baseLib fail, from mini to " + str + ", tryCount:" + i + ", totalCount:" + j);
      i += 1;
    }
    return false;
  }
  
  public boolean isBaseLibDirValid(File paramFile)
  {
    return (isBaseLibDirValid4MiniApp(paramFile)) && (isBaseLibDirValid4MiniGame(paramFile));
  }
  
  public boolean isBaseLibDirValid(String paramString)
  {
    boolean bool1 = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      if (isBaseLibDirValid4MiniApp(paramString))
      {
        boolean bool2 = isBaseLibDirValid4MiniGame(paramString);
        if (!bool2) {}
      }
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      return false;
    }
    catch (Throwable paramString)
    {
      QLog.e("miniapp-process_BaseLibManager[MiniEng]", 1, "isBaseLibDirValid path, exception!", paramString);
    }
  }
  
  public boolean isBaseLibDirValid4MiniApp(File paramFile)
  {
    return isBaseLibDirValid(paramFile, (String[])this.miniAppBaseLibFiles.toArray(new String[this.miniAppBaseLibFiles.size()]));
  }
  
  public boolean isBaseLibDirValid4MiniApp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      boolean bool = isBaseLibDirValid4MiniApp(new File(paramString));
      return bool;
    }
    catch (Throwable paramString)
    {
      QLog.e("miniapp-process_BaseLibManager[MiniEng]", 1, "isBaseLibDirValid4MiniApp path, exception!", paramString);
    }
    return false;
  }
  
  public boolean isBaseLibDirValid4MiniGame(File paramFile)
  {
    return isBaseLibDirValid(paramFile, (String[])this.miniGameBaseLibFiles.toArray(new String[this.miniGameBaseLibFiles.size()]));
  }
  
  public boolean isBaseLibDirValid4MiniGame(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      boolean bool = isBaseLibDirValid4MiniGame(new File(paramString));
      return bool;
    }
    catch (Throwable paramString)
    {
      QLog.e("miniapp-process_BaseLibManager[MiniEng]", 1, "isBaseLibDirValid4MiniGame path, exception!", paramString);
    }
    return false;
  }
  
  public boolean isBaseLibExists(String paramString1, String paramString2)
  {
    paramString1 = getBaseLibDir(paramString1, paramString2);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = new File(paramString1 + "soTest/");
      if ((paramString1.exists()) && (paramString1.isDirectory())) {
        return true;
      }
      QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "baselib directory is not exist!");
    }
    return false;
  }
  
  public void updateBaseLib(BaseLibManager.UpdateListener paramUpdateListener)
  {
    try
    {
      updateBaseLib(null, false, paramUpdateListener);
      return;
    }
    finally
    {
      paramUpdateListener = finally;
      throw paramUpdateListener;
    }
  }
  
  /* Error */
  public void updateBaseLib(String paramString, boolean paramBoolean, BaseLibManager.UpdateListener paramUpdateListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	com/tencent/mobileqq/mini/apkg/BaseLibManager:mListeners	Ljava/util/List;
    //   6: aload_3
    //   7: invokeinterface 502 2 0
    //   12: pop
    //   13: ldc 27
    //   15: iconst_1
    //   16: new 44	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 504
    //   26: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: getfield 148	com/tencent/mobileqq/mini/apkg/BaseLibManager:isUpdatingBaseLib	Z
    //   33: invokevirtual 507	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 313	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: getfield 148	com/tencent/mobileqq/mini/apkg/BaseLibManager:isUpdatingBaseLib	Z
    //   46: istore 4
    //   48: iload 4
    //   50: ifeq +6 -> 56
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: iconst_1
    //   58: putfield 148	com/tencent/mobileqq/mini/apkg/BaseLibManager:isUpdatingBaseLib	Z
    //   61: new 509	com/tencent/mobileqq/mini/apkg/BaseLibManager$2
    //   64: dup
    //   65: aload_0
    //   66: iload_2
    //   67: aload_1
    //   68: aload_3
    //   69: invokespecial 512	com/tencent/mobileqq/mini/apkg/BaseLibManager$2:<init>	(Lcom/tencent/mobileqq/mini/apkg/BaseLibManager;ZLjava/lang/String;Lcom/tencent/mobileqq/mini/apkg/BaseLibManager$UpdateListener;)V
    //   72: bipush 16
    //   74: aconst_null
    //   75: iconst_0
    //   76: invokestatic 374	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   79: goto -26 -> 53
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	BaseLibManager
    //   0	87	1	paramString	String
    //   0	87	2	paramBoolean	boolean
    //   0	87	3	paramUpdateListener	BaseLibManager.UpdateListener
    //   46	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	48	82	finally
    //   56	79	82	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.BaseLibManager
 * JD-Core Version:    0.7.0.1
 */