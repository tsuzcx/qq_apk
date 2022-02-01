package com.tencent.mobileqq.mini.apkg;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.minigame.utils.AssetsUtil;
import com.tencent.open.base.MD5Utils;
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
  private static int MINI_APP_INNER_BASELIB_RETRY_COUNT_DEFAULT = 2;
  public static final int RET_CODE_DOWNLOAD_FAIL = 1101;
  public static final int RET_CODE_NO_UPDATE = 1;
  public static final int RET_CODE_OTHER = 1103;
  public static final int RET_CODE_SUCC = 0;
  public static final int RET_CODE_UNZIP_FAIL = 1102;
  public static final int RET_CODE_UPDATE_CMD_ERROR = 1100;
  private static final String TAG = "miniapp-process_BaseLibManager[MiniEng]";
  private static BaseLibManager instance;
  private static byte[] lock = new byte[0];
  private boolean isFirstTimeUpdateBaseLib = false;
  private boolean isUpdatingBaseLib = false;
  private List<BaseLibManager.UpdateListener> mListeners = new ArrayList();
  private List<String> miniAppBaseLibFiles = Arrays.asList(new String[] { "QView.js", "QLogic.js", "QVConsole.js", "QRemoteDebug.js", "QWebview.js" });
  private List<String> miniGameBaseLibFiles = Arrays.asList(new String[] { "QGame.js", "QGameOpenDataContext.js", "QGameWorkerContext.js" });
  
  public static BaseLibManager g()
  {
    if (instance == null) {
      synchronized (lock)
      {
        if (instance == null) {
          instance = new BaseLibManager();
        }
      }
    }
    return instance;
  }
  
  private boolean isBaseLibDirValid(File paramFile, String[] paramArrayOfString)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (!paramFile.isDirectory()) {
        return false;
      }
      if (paramArrayOfString != null)
      {
        if (paramArrayOfString.length == 0) {
          return false;
        }
        int i = 0;
        try
        {
          while (i < paramArrayOfString.length)
          {
            File localFile = new File(paramFile, paramArrayOfString[i]);
            if (localFile.exists())
            {
              boolean bool = localFile.isDirectory();
              if (bool) {
                return false;
              }
              i += 1;
            }
            else
            {
              return false;
            }
          }
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
    String str = StorageUtil.getPreference().getString("version", "1.22.0.00008");
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static boolean verifyBaselib(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists())) {
      if (paramFile.isFile()) {
        return false;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new File(paramFile, "verify.json");
        if ((((File)localObject1).exists()) && (((File)localObject1).isFile()))
        {
          localObject1 = new JSONObject(FileUtils.readFileToString((File)localObject1));
          if (!((JSONObject)localObject1).has("verify_list")) {
            return true;
          }
          localObject1 = ((JSONObject)localObject1).getJSONArray("verify_list");
          i = 0;
          if (i >= ((JSONArray)localObject1).length()) {
            break;
          }
          if (((JSONArray)localObject1).get(i) == null)
          {
            QLog.e("miniapp-start", 1, "配置文件格式异常！！请使用json工具检测");
            break label271;
          }
          Object localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
          String str = ((JSONObject)localObject2).getString("name");
          int j = ((JSONObject)localObject2).getInt("length");
          localObject2 = new File(paramFile, str);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("BaselibManager--verifyBaselib file: ");
          localStringBuilder.append(str);
          localStringBuilder.append(" config_length=");
          localStringBuilder.append(j);
          localStringBuilder.append(" local_length=");
          localStringBuilder.append(((File)localObject2).length());
          QLog.i("miniapp-start", 1, localStringBuilder.toString());
          if ((((File)localObject2).exists()) && (((File)localObject2).isFile()))
          {
            if (((File)localObject2).length() == j) {
              break label271;
            }
            return false;
          }
        }
        else
        {
          QLog.w("miniapp-process_BaseLibManager[MiniEng]", 1, "BaselibManager--verifyBaselib verify.json is not exist!");
          return true;
        }
      }
      catch (Exception paramFile)
      {
        QLog.e("miniapp-start", 1, "BaselibManager--verifyBaselib exception.", paramFile);
      }
      return false;
      label271:
      i += 1;
    }
    return true;
  }
  
  public void doDownloadBaselib(String paramString1, String paramString2, String paramString3, String paramString4, BaseLibManager.UpdateListener paramUpdateListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doDownloadBaselib url=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" version=");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" oldUrl=");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(" oldVersion=");
    ((StringBuilder)localObject).append(paramString4);
    QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, ((StringBuilder)localObject).toString());
    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 4, null, null, null, 0);
    localObject = getBaseLibZipPath(paramString1, paramString2);
    MiniappDownloadUtil.getInstance().download(paramString1, (String)localObject, true, new BaseLibManager.3(this, paramString1, paramUpdateListener, paramString2, paramString4, (String)localObject, paramString3), Downloader.DownloadMode.StrictMode, null);
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
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(AppLoaderFactory.BASE_LIB_PATH_DIR);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(MD5Utils.toMD5(paramString1));
        localStringBuilder.append("_");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(File.separator);
        paramString1 = localStringBuilder.toString();
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        QLog.e("miniapp-process_BaseLibManager[MiniEng]", 1, "getBaseLibDir exception!", paramString1);
        paramString1 = new StringBuilder();
        paramString1.append(AppLoaderFactory.BASE_LIB_PATH_DIR);
        paramString1.append(File.separator);
        paramString1.append("_");
        paramString1.append(paramString2);
        paramString1.append(File.separator);
        return paramString1.toString();
      }
    }
    return null;
  }
  
  public BaseLibInfo getBaseLibInfo()
  {
    BaseLibInfo localBaseLibInfo = new BaseLibInfo();
    String str = StorageUtil.getPreference().getString("downloadUrl", null);
    localBaseLibInfo.baseLibVersion = StorageUtil.getPreference().getString("version", "1.22.0.00008");
    localBaseLibInfo.baseLibUrl = str;
    return localBaseLibInfo;
  }
  
  public String getBaseLibZipPath(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppLoaderFactory.BASE_LIB_PATH_DIR);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(MD5Utils.toMD5(paramString1));
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(".zip");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public String installMiniGameInnerJsLib()
  {
    try
    {
      String str = g().getBaseLibDir("mini", "1.22.0.00008");
      if (g().isBaseLibDirValid4MiniGame(str))
      {
        QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, "installMiniGameInnerJsLib, inner baseLib already installed, version:1.22.0.00008");
        return str;
      }
      int k = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_inner_baselib_retry_count", MINI_APP_INNER_BASELIB_RETRY_COUNT_DEFAULT);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("installMiniGameInnerJsLib, version:1.22.0.00008, totalCount:");
      ((StringBuilder)localObject2).append(k);
      QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, ((StringBuilder)localObject2).toString());
      boolean bool2 = false;
      int i = 0;
      boolean bool1;
      int j;
      for (;;)
      {
        bool1 = bool2;
        j = i;
        if (i >= k) {
          break;
        }
        j = i + 1;
        bool1 = AssetsUtil.copyFileOrDir(BaseApplicationImpl.getContext(), "mini", str, this.miniGameBaseLibFiles);
        if ((bool1) && (g().isBaseLibDirValid4MiniGame(str))) {
          break;
        }
        localObject2 = new File(str);
        i = j;
        if (((File)localObject2).exists())
        {
          FileUtil.a((File)localObject2);
          i = j;
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("installMiniGameInnerJsLib success? ");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(", from ");
      ((StringBuilder)localObject2).append("mini");
      ((StringBuilder)localObject2).append(" to ");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(", tryCount:");
      ((StringBuilder)localObject2).append(j);
      QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, ((StringBuilder)localObject2).toString());
      if (!bool1) {
        str = null;
      }
      return str;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public boolean isBaseLibDirValid(File paramFile)
  {
    return (isBaseLibDirValid4MiniApp(paramFile)) && (isBaseLibDirValid4MiniGame(paramFile));
  }
  
  public boolean isBaseLibDirValid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      if (isBaseLibDirValid4MiniApp(paramString))
      {
        boolean bool = isBaseLibDirValid4MiniGame(paramString);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramString)
    {
      QLog.e("miniapp-process_BaseLibManager[MiniEng]", 1, "isBaseLibDirValid path, exception!", paramString);
    }
    return false;
  }
  
  public boolean isBaseLibDirValid4MiniApp(File paramFile)
  {
    List localList = this.miniAppBaseLibFiles;
    return isBaseLibDirValid(paramFile, (String[])localList.toArray(new String[localList.size()]));
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
    List localList = this.miniGameBaseLibFiles;
    return isBaseLibDirValid(paramFile, (String[])localList.toArray(new String[localList.size()]));
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
  
  public void updateBaseLib(String paramString, boolean paramBoolean, BaseLibManager.UpdateListener paramUpdateListener)
  {
    try
    {
      this.mListeners.add(paramUpdateListener);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MiniEng] postUpdateBaseLib ");
      localStringBuilder.append(this.isUpdatingBaseLib);
      QLog.i("miniapp-process_BaseLibManager[MiniEng]", 1, localStringBuilder.toString());
      boolean bool = this.isUpdatingBaseLib;
      if (bool) {
        return;
      }
      this.isUpdatingBaseLib = true;
      ThreadManager.excute(new BaseLibManager.2(this, paramBoolean, paramString, paramUpdateListener), 16, null, false);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.BaseLibManager
 * JD-Core Version:    0.7.0.1
 */