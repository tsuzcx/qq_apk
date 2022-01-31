package com.tencent.mobileqq.minigame.gpkg;

import android.text.TextUtils;
import bdnn;
import com.tencent.mobileqq.mini.apkg.ApkgBaseInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.NetworkTimeoutInfo;
import com.tencent.mobileqq.mini.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.minigame.manager.GamePreConnectManager;
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
  public JSONObject mGameConfigJson;
  public NetworkTimeoutInfo networkTimeoutInfo;
  public HashMap<String, String> subPackRoots = new HashMap();
  
  public MiniGamePkg(String paramString, MiniAppConfig paramMiniAppConfig)
  {
    super(paramString, paramMiniAppConfig);
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
    if ((paramMiniGamePkg != null) && (paramMiniGamePkg.networkTimeoutInfo != null)) {}
    for (paramMiniGamePkg = paramMiniGamePkg.networkTimeoutInfo;; paramMiniGamePkg = new NetworkTimeoutInfo())
    {
      MiniOkHttpClientFactory.init(paramMiniGamePkg.request, paramMiniGamePkg.uploadFile, paramMiniGamePkg.downloadFile);
      return;
    }
  }
  
  public static MiniGamePkg loadGamePkgFromFolderPath(String paramString1, String paramString2, MiniAppConfig paramMiniAppConfig, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!new File(paramString1).exists())) {
      paramString1 = null;
    }
    do
    {
      return paramString1;
      paramMiniAppConfig = new MiniGamePkg(paramString1, paramMiniAppConfig);
      paramMiniAppConfig.init(paramString2);
      if (paramMiniAppConfig.networkTimeoutInfo == null) {
        paramMiniAppConfig.networkTimeoutInfo = new NetworkTimeoutInfo();
      }
      paramString1 = paramMiniAppConfig;
    } while (!paramBoolean);
    initOkHttp(paramMiniAppConfig);
    GamePreConnectManager.connectHost(paramMiniAppConfig);
    return paramMiniAppConfig;
  }
  
  public void downloadSubPack(String paramString, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
  {
    GpkgManager.downloadSubPack(this, paramString, paramOnInitGpkgListener);
  }
  
  public String getRootPath(String paramString)
  {
    if (bdnn.a(paramString)) {
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
  
  public boolean isUrlResReady(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.MiniGamePkg
 * JD-Core Version:    0.7.0.1
 */