package com.tencent.qqmini.sdk.manager;

import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.AssetsUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class BaseLibManager
{
  private static int MINI_APP_INNER_BASELIB_RETRY_COUNT_DEFAULT = 2;
  public static final int RET_CODE_DOWNLOAD_FAIL = 1101;
  public static final int RET_CODE_NO_UPDATE = 1;
  public static final int RET_CODE_OTHER = 1103;
  public static final int RET_CODE_SUCC = 0;
  public static final int RET_CODE_UNZIP_FAIL = 1102;
  public static final int RET_CODE_UPDATE_CMD_ERROR = 1100;
  private static final String TAG = "miniapp-process_BaseLibManager";
  private static BaseLibManager instance;
  private static byte[] lock = new byte[0];
  private boolean isFirstTimeUpdateBaseLib = false;
  private boolean isUpdatingBaseLib = false;
  private List<BaseLibManager.UpdateListener> mListeners = new ArrayList();
  private List<String> miniAppBaseLibFiles = Arrays.asList(new String[] { "QView.js", "QLogic.js", "QVConsole.js", "QRemoteDebug.js", "QWebview.js" });
  private List<String> miniGameBaseLibFiles = Arrays.asList(new String[] { "QGame.js", "QGameOpenDataContext.js", "QGameWorkerContext.js" });
  
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
  
  public static BaseLibInfo getGameBaseLibInfo()
  {
    Object localObject = WnsConfig.getConfig("qqtriton", "MiniGameBaseLib", "{\"key1\":\"https://d3g.qq.com/sngapp/app/update/20200323171054_1567/lib_1.13.0.00014.zip\",\"key2\":\"\",\"key3\":\"1.4.8\",\"key4\": {\"file_length\": 5591276},\"key5\":2}");
    QMLog.i("minigame", "MiniEng getWnsGameBaseLibInfo " + (String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = BaseLibInfo.fromJSON(new JSONObject((String)localObject));
        return localObject;
      }
      catch (Exception localException)
      {
        QMLog.e("minigame", "MiniEng getWnsGameBaseLibInfo failed", localException);
      }
    }
    return null;
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
          QMLog.e("miniapp-process_BaseLibManager", "isBaseLibDirValid exception!", paramFile);
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
    String str = StorageUtil.getPreference().getString("version", "1.18.0.00132");
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
  
  public static boolean verifyBaselib(File paramFile)
  {
    boolean bool = true;
    if ((paramFile == null) || (!paramFile.exists()) || (paramFile.isFile())) {
      bool = false;
    }
    label74:
    do
    {
      return bool;
      try
      {
        localObject1 = new File(paramFile, "verify.json");
        if ((((File)localObject1).exists()) && (((File)localObject1).isFile())) {
          break label74;
        }
        QMLog.w("miniapp-start", "BaselibManager--verifyBaselib verify.json is not exist!");
        return true;
      }
      catch (Exception paramFile)
      {
        QMLog.e("miniapp-start", "BaselibManager--verifyBaselib exception.", paramFile);
        bool = false;
      }
      return bool;
      localObject1 = new JSONObject(FileUtils.readFileToString((File)localObject1));
    } while (!((JSONObject)localObject1).has("verify_list"));
    Object localObject1 = ((JSONObject)localObject1).getJSONArray("verify_list");
    int i = 0;
    for (;;)
    {
      if (i < ((JSONArray)localObject1).length())
      {
        if (((JSONArray)localObject1).get(i) == null)
        {
          QMLog.e("miniapp-start", "配置文件格式异常！！请使用json工具检测");
          break label273;
        }
        Object localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
        String str = ((JSONObject)localObject2).getString("name");
        int j = ((JSONObject)localObject2).getInt("length");
        localObject2 = new File(paramFile, str);
        QMLog.i("miniapp-start", "BaselibManager--verifyBaselib file: " + str + " config_length=" + j + " local_length=" + ((File)localObject2).length());
        if ((((File)localObject2).exists()) && (((File)localObject2).isFile()))
        {
          long l = ((File)localObject2).length();
          if (l == j) {
            break label273;
          }
        }
        bool = false;
        break;
      }
      bool = true;
      break;
      label273:
      i += 1;
    }
  }
  
  public void doDownloadBaselib(String paramString1, String paramString2, String paramString3, String paramString4, BaseLibManager.UpdateListener paramUpdateListener)
  {
    QMLog.i("miniapp-process_BaseLibManager", "doDownloadBaselib url=" + paramString1 + " version=" + paramString2 + " oldUrl=" + paramString3 + " oldVersion=" + paramString4);
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 4, null, null, null, 0);
    String str = getBaseLibZipPath(paramString1, paramString2);
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString1, null, str, 60, new BaseLibManager.3(this, paramUpdateListener, paramString1, paramString2, paramString4, str, paramString3));
  }
  
  public void forceUpdateBaseLib(BaseLibManager.UpdateListener paramUpdateListener)
  {
    try
    {
      ThreadManager.getSubThreadHandler().post(new BaseLibManager.1(this, paramUpdateListener));
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
    return MiniSDKConst.getAppBaseLibDir(paramString1, paramString2);
  }
  
  public BaseLibInfo getBaseLibInfo()
  {
    BaseLibInfo localBaseLibInfo = new BaseLibInfo();
    String str = StorageUtil.getPreference().getString("downloadUrl", null);
    localBaseLibInfo.baseLibVersion = StorageUtil.getPreference().getString("version", "1.18.0.00132");
    localBaseLibInfo.baseLibUrl = str;
    return localBaseLibInfo;
  }
  
  public String getBaseLibZipPath(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return MiniSDKConst.BASE_LIB_PATH_DIR + File.separator + MD5Utils.toMD5(paramString1) + "_" + paramString2 + ".zip";
  }
  
  public String installMiniGameInnerJsLib()
  {
    for (;;)
    {
      try
      {
        String str = g().getBaseLibDir("mini", "1.18.0.00132");
        if (g().isBaseLibDirValid4MiniGame(str))
        {
          QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] installMiniGameInnerJsLib, inner baseLib already installed, version:1.18.0.00132");
          return str;
        }
        int j = WnsConfig.getConfig("qqminiapp", "mini_app_inner_baselib_retry_count", MINI_APP_INNER_BASELIB_RETRY_COUNT_DEFAULT);
        QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] installMiniGameInnerJsLib, version:1.18.0.00132, totalCount:" + j);
        int i = 0;
        boolean bool;
        if (i < j)
        {
          i += 1;
          bool = AssetsUtil.copyFileOrDir(AppLoaderFactory.g().getContext(), "mini", str, this.miniGameBaseLibFiles);
          if ((bool) && (g().isBaseLibDirValid4MiniGame(str)))
          {
            QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] installMiniGameInnerJsLib success?" + bool + ", from " + "mini" + " to " + str + ", tryCount:" + i);
            if (!bool) {
              str = null;
            }
          }
          else
          {
            File localFile = new File(str);
            if (localFile.exists()) {
              FileUtils.deleteFile(localFile);
            }
          }
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
  
  public boolean isBaseLibDirValid(File paramFile)
  {
    return (isBaseLibDirValid4MiniApp(paramFile)) && (isBaseLibDirValid4MiniGame(paramFile));
  }
  
  public boolean isBaseLibDirValid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        if (QUAUtil.isQQApp())
        {
          if ((isBaseLibDirValid4MiniApp(paramString)) && (isBaseLibDirValid4MiniGame(paramString))) {
            return true;
          }
        }
        else
        {
          boolean bool = isBaseLibDirValid4MiniGame(paramString);
          return bool;
        }
      }
      catch (Throwable paramString)
      {
        QMLog.e("miniapp-process_BaseLibManager", "isBaseLibDirValid path, exception!", paramString);
      }
    }
    return false;
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
      QMLog.e("miniapp-process_BaseLibManager", "isBaseLibDirValid4MiniApp path, exception!", paramString);
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
      QMLog.e("miniapp-process_BaseLibManager", "isBaseLibDirValid4MiniGame path, exception!", paramString);
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
    //   3: getfield 50	com/tencent/qqmini/sdk/manager/BaseLibManager:mListeners	Ljava/util/List;
    //   6: aload_3
    //   7: invokeinterface 484 2 0
    //   12: pop
    //   13: ldc 22
    //   15: new 124	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 486
    //   25: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 52	com/tencent/qqmini/sdk/manager/BaseLibManager:isUpdatingBaseLib	Z
    //   32: invokevirtual 437	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 141	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 52	com/tencent/qqmini/sdk/manager/BaseLibManager:isUpdatingBaseLib	Z
    //   45: istore 4
    //   47: iload 4
    //   49: ifeq +6 -> 55
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: iconst_1
    //   57: putfield 52	com/tencent/qqmini/sdk/manager/BaseLibManager:isUpdatingBaseLib	Z
    //   60: invokestatic 357	com/tencent/qqmini/sdk/core/manager/ThreadManager:getSubThreadHandler	()Landroid/os/Handler;
    //   63: new 488	com/tencent/qqmini/sdk/manager/BaseLibManager$2
    //   66: dup
    //   67: aload_0
    //   68: iload_2
    //   69: aload_1
    //   70: aload_3
    //   71: invokespecial 491	com/tencent/qqmini/sdk/manager/BaseLibManager$2:<init>	(Lcom/tencent/qqmini/sdk/manager/BaseLibManager;ZLjava/lang/String;Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;)V
    //   74: invokevirtual 368	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   77: pop
    //   78: goto -26 -> 52
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	BaseLibManager
    //   0	86	1	paramString	String
    //   0	86	2	paramBoolean	boolean
    //   0	86	3	paramUpdateListener	BaseLibManager.UpdateListener
    //   45	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	47	81	finally
    //   55	78	81	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager
 * JD-Core Version:    0.7.0.1
 */