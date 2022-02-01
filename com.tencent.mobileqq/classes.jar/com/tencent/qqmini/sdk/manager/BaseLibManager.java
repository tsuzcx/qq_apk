package com.tencent.qqmini.sdk.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.core.utils.ZipUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
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
  
  private void deleteOldVersion(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString5)) && (!TextUtils.equals(paramString4, paramString2)) && (!TextUtils.equals(paramString5, paramString3)))
    {
      QMLog.i("miniapp-process_BaseLibManager", "delete last path.");
      paramString2 = getBaseLibDir(paramString4, paramString5);
      if (!paramString2.equals(paramString1))
      {
        paramString1 = new StringBuilder();
        paramString1.append("delete last path. oldUrl : ");
        paramString1.append(paramString4);
        paramString1.append("; version : ");
        paramString1.append(paramString3);
        QMLog.i("miniapp-start", paramString1.toString());
        FileUtils.delete(paramString2, false);
      }
    }
  }
  
  private boolean doUpdateBaseLib(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    return ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib(paramString3, paramBoolean2, paramBoolean1, new BaseLibManager.3(this, paramString2, paramString1));
  }
  
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
  
  public static BaseLibInfo getGameBaseLibInfo()
  {
    Object localObject = WnsConfig.getConfig("qqtriton", "MiniGameBaseLib", "{\"key1\":\"https://d3g.qq.com/sngapp/app/update/20200323171054_1567/lib_1.13.0.00014.zip\",\"key2\":\"\",\"key3\":\"1.4.8\",\"key4\": {\"file_length\": 5591276},\"key5\":2}");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniEng getWnsGameBaseLibInfo ");
    localStringBuilder.append((String)localObject);
    QMLog.i("minigame", localStringBuilder.toString());
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
  
  private void unZipFolder(String paramString1, File paramFile, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, BaseLibManager.UpdateListener paramUpdateListener)
  {
    if (paramFile.exists()) {
      FileUtils.delete(paramString1, false);
    }
    paramFile.mkdir();
    int i = ZipUtil.unZipFolder(paramString2, paramString1);
    boolean bool = true;
    if (i == 0) {
      bool = verifyBaselib(paramFile);
    }
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 7, null, null, null, 0);
    if ((i == 0) && (bool))
    {
      paramFile = new StringBuilder();
      paramFile.append("unZipFolder succeed.url:");
      paramFile.append(paramString3);
      paramFile.append(",version:");
      paramFile.append(paramString4);
      QMLog.i("miniapp-process_BaseLibManager", paramFile.toString());
      StorageUtil.getPreference().edit().putString("downloadUrl", paramString3).apply();
      StorageUtil.getPreference().edit().putString("version", paramString4).apply();
      deleteOldVersion(paramString1, paramString3, paramString4, paramString5, paramString6);
      if (paramUpdateListener != null)
      {
        paramUpdateListener.onUpdateResult(0);
        return;
      }
      notifyUpdateResult(0);
      return;
    }
    QMLog.e("miniapp-process_BaseLibManager", "unZipFolder failed, read last path.");
    FileUtils.delete(paramString1, false);
    if (paramUpdateListener != null) {
      paramUpdateListener.onUpdateResult(1102);
    } else {
      notifyUpdateResult(1102);
    }
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 618, null, null, null, 1102);
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
            QMLog.e("miniapp-start", "配置文件格式异常！！请使用json工具检测");
            break label274;
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
          QMLog.i("miniapp-start", localStringBuilder.toString());
          if ((((File)localObject2).exists()) && (((File)localObject2).isFile()))
          {
            if (((File)localObject2).length() == j) {
              break label274;
            }
            return false;
          }
        }
        else
        {
          QMLog.w("miniapp-start", "BaselibManager--verifyBaselib verify.json is not exist!");
          return true;
        }
      }
      catch (Exception paramFile)
      {
        QMLog.e("miniapp-start", "BaselibManager--verifyBaselib exception.", paramFile);
      }
      return false;
      label274:
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
    QMLog.i("miniapp-process_BaseLibManager", ((StringBuilder)localObject).toString());
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 4, null, null, null, 0);
    localObject = getBaseLibZipPath(paramString1, paramString2);
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString1, null, (String)localObject, 60, new BaseLibManager.4(this, paramUpdateListener, paramString1, paramString2, paramString4, (String)localObject, paramString3));
  }
  
  public void forceUpdateBaseLib(BaseLibManager.UpdateListener paramUpdateListener)
  {
    try
    {
      ThreadManager.getSubThreadHandler().post(new BaseLibManager.2(this, paramUpdateListener));
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
    localBaseLibInfo.baseLibVersion = StorageUtil.getPreference().getString("version", "1.22.0.00008");
    localBaseLibInfo.baseLibUrl = str;
    return localBaseLibInfo;
  }
  
  public String getBaseLibZipPath(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(MiniSDKConst.BASE_LIB_PATH_DIR);
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
        QMLog.i("miniapp-process_BaseLibManager", "[MiniEng] installMiniGameInnerJsLib, inner baseLib already installed, version:1.22.0.00008");
        return str;
      }
      int k = WnsConfig.getConfig("qqminiapp", "mini_app_inner_baselib_retry_count", MINI_APP_INNER_BASELIB_RETRY_COUNT_DEFAULT);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[MiniEng] installMiniGameInnerJsLib, version:1.22.0.00008, totalCount:");
      ((StringBuilder)localObject2).append(k);
      QMLog.i("miniapp-process_BaseLibManager", ((StringBuilder)localObject2).toString());
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
        bool1 = AssetsUtil.copyFileOrDir(AppLoaderFactory.g().getContext(), "mini", str, this.miniGameBaseLibFiles);
        if ((bool1) && (g().isBaseLibDirValid4MiniGame(str))) {
          break;
        }
        localObject2 = new File(str);
        i = j;
        if (((File)localObject2).exists())
        {
          FileUtils.deleteFile((File)localObject2);
          i = j;
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[MiniEng] installMiniGameInnerJsLib success?");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(", from ");
      ((StringBuilder)localObject2).append("mini");
      ((StringBuilder)localObject2).append(" to ");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(", tryCount:");
      ((StringBuilder)localObject2).append(j);
      QMLog.i("miniapp-process_BaseLibManager", ((StringBuilder)localObject2).toString());
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
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    try
    {
      if (QUAUtil.isQQApp())
      {
        bool1 = bool2;
        if (isBaseLibDirValid4MiniApp(paramString))
        {
          bool1 = bool2;
          if (isBaseLibDirValid4MiniGame(paramString)) {
            return true;
          }
        }
      }
      else
      {
        bool1 = isBaseLibDirValid4MiniGame(paramString);
      }
      return bool1;
    }
    catch (Throwable paramString)
    {
      QMLog.e("miniapp-process_BaseLibManager", "isBaseLibDirValid path, exception!", paramString);
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
      QMLog.e("miniapp-process_BaseLibManager", "isBaseLibDirValid4MiniApp path, exception!", paramString);
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
  
  public void updateBaseLib(String paramString, boolean paramBoolean, BaseLibManager.UpdateListener paramUpdateListener)
  {
    try
    {
      this.mListeners.add(paramUpdateListener);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MiniEng] postUpdateBaseLib ");
      localStringBuilder.append(this.isUpdatingBaseLib);
      QMLog.i("miniapp-process_BaseLibManager", localStringBuilder.toString());
      boolean bool = this.isUpdatingBaseLib;
      if (bool) {
        return;
      }
      this.isUpdatingBaseLib = true;
      ThreadManager.getSubThreadHandler().post(new BaseLibManager.1(this, paramBoolean, paramString, paramUpdateListener));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager
 * JD-Core Version:    0.7.0.1
 */