package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.NetworkTimeoutInfo;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class MiniGamePkg
  extends ApkgBaseInfo
{
  private static final String NAME_CONFIG_JSON = "game.json";
  public static final String NAME_ENTRY_FILE = "game.js";
  public static final String NAME_OFFLINECONFIG_JSON = "offlineconfig.json";
  public static final String PLUGIN_ENTRY_FILE = "plugin.js";
  public static final String TAG = "MiniGamePkg";
  public JSONObject mGameConfigJson;
  public NetworkTimeoutInfo networkTimeoutInfo;
  public HashMap<String, String> subPackRoots = new HashMap();
  
  public MiniGamePkg(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    super(paramString, paramMiniAppBaseInfo);
  }
  
  private static HashMap<String, String> getSubPackRoots(JSONArray paramJSONArray)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("name");
          localObject = ((JSONObject)localObject).optString("root");
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            localHashMap.put(str, localObject);
          }
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  private static void initOkHttp(MiniGamePkg paramMiniGamePkg)
  {
    try
    {
      QMLog.e("MiniGamePkg", "loadGamePkgFromFolderPath initNetwork");
      if ((paramMiniGamePkg != null) && (paramMiniGamePkg.networkTimeoutInfo != null)) {}
      for (paramMiniGamePkg = paramMiniGamePkg.networkTimeoutInfo;; paramMiniGamePkg = new NetworkTimeoutInfo())
      {
        SpecialProxy localSpecialProxy = (SpecialProxy)AppLoaderFactory.g().getProxyManager().get(SpecialProxy.class);
        if (localSpecialProxy == null) {
          break;
        }
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("NetworkTimeOutInfo", paramMiniGamePkg);
        localSpecialProxy.sendEventToHost(2, localBundle, null);
        return;
      }
      return;
    }
    catch (Throwable paramMiniGamePkg)
    {
      QMLog.e("MiniGamePkg", "loadGamePkgFromFolderPath initNetwork failed", paramMiniGamePkg);
    }
  }
  
  public static MiniGamePkg loadGamePkgFromFolderPath(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!new File(paramString1).exists())) {
      return null;
    }
    paramString1 = new MiniGamePkg(paramString1, paramMiniAppInfo);
    paramString1.init(paramString2);
    initOkHttp(paramString1);
    return paramString1;
  }
  
  public void downloadSubPack(MiniAppInfo paramMiniAppInfo, String paramString, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
  {
    GpkgManager.downloadSubPack(paramMiniAppInfo, this, paramString, paramOnInitGpkgListener);
  }
  
  public String getRootPath(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    if (this.subPackRoots != null)
    {
      if (this.subPackRoots.containsKey(paramString)) {
        return (String)this.subPackRoots.get(paramString);
      }
      if (this.subPackRoots.containsValue(paramString)) {
        return paramString;
      }
    }
    return "";
  }
  
  public String getWorkerPath(String paramString1, String paramString2)
  {
    return null;
  }
  
  public void init(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        this.mConfigStr = FileUtils.readFileToString(new File(getApkgFolderPath() + "/" + paramString, "game.json"));
        this.mGameConfigJson = new JSONObject(this.mConfigStr);
        JSONArray localJSONArray = this.mGameConfigJson.optJSONArray("subpackages");
        paramString = localJSONArray;
        if (localJSONArray == null) {
          paramString = this.mGameConfigJson.optJSONArray("subPackages");
        }
        this.subPackRoots = getSubPackRoots(paramString);
        this.networkTimeoutInfo = NetworkTimeoutInfo.parse(this.mGameConfigJson.optJSONObject("networkTimeout"));
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      this.mConfigStr = FileUtils.readFileToString(new File(getApkgFolderPath(), "game.json"));
    }
  }
  
  public boolean isUrlResReady(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.MiniGamePkg
 * JD-Core Version:    0.7.0.1
 */