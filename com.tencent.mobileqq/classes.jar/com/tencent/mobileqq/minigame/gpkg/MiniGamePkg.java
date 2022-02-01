package com.tencent.mobileqq.minigame.gpkg;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgBaseInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.NetworkTimeoutInfo;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.minigame.manager.GamePreConnectManager;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class MiniGamePkg
  extends ApkgBaseInfo
{
  public static final String DEVICE_ORIENTATION_LANDSCAPE = "landscape";
  public static final String DEVICE_ORIENTATION_PORTRAIT = "portrait";
  private static final String NAME_CONFIG_JSON = "game.json";
  public static final String NAME_ENTRY_FILE = "game.js";
  public static final String NAME_OFFLINECONFIG_JSON = "offlineconfig.json";
  public static final String PLUGIN_ENTRY_FILE = "plugin.js";
  private String deviceOrientation;
  public JSONObject mGameConfigJson;
  public NetworkTimeoutInfo networkTimeoutInfo;
  private String openDataPath;
  private boolean showStatusBar;
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
    if (paramMiniGamePkg != null)
    {
      paramMiniGamePkg = paramMiniGamePkg.networkTimeoutInfo;
      if (paramMiniGamePkg != null) {}
    }
    else
    {
      paramMiniGamePkg = new NetworkTimeoutInfo();
    }
    MiniOkHttpClientFactory.init(paramMiniGamePkg.request, paramMiniGamePkg.uploadFile, paramMiniGamePkg.downloadFile);
  }
  
  public static MiniGamePkg loadGamePkgFromFolderPath(String paramString1, String paramString2, MiniAppConfig paramMiniAppConfig, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (new File(paramString1).exists()))
    {
      paramString1 = new MiniGamePkg(paramString1, paramMiniAppConfig);
      paramString1.init(paramString2);
      if (paramString1.networkTimeoutInfo == null) {
        paramString1.networkTimeoutInfo = new NetworkTimeoutInfo();
      }
      if (paramBoolean)
      {
        initOkHttp(paramString1);
        GamePreConnectManager.connectHost(paramString1);
      }
      return paramString1;
    }
    return null;
  }
  
  public String getDeviceOrientation()
  {
    return this.deviceOrientation;
  }
  
  public String getOpenDataPath()
  {
    return this.openDataPath;
  }
  
  public String getRootPath(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    HashMap localHashMap = this.subPackRoots;
    if (localHashMap != null)
    {
      if (localHashMap.containsKey(paramString)) {
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
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getApkgFolderPath());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramString);
      this.mConfigStr = FileUtils.readFileToString(new File(((StringBuilder)localObject).toString(), "game.json"));
      break label77;
      this.mConfigStr = FileUtils.readFileToString(new File(getApkgFolderPath(), "game.json"));
      label77:
      this.mGameConfigJson = new JSONObject(this.mConfigStr);
      localObject = this.mGameConfigJson.optJSONArray("subpackages");
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = this.mGameConfigJson.optJSONArray("subPackages");
      }
      this.subPackRoots = getSubPackRoots(paramString);
      this.networkTimeoutInfo = NetworkTimeoutInfo.parse(this.mGameConfigJson.optJSONObject("networkTimeout"));
      this.deviceOrientation = this.mGameConfigJson.optString("deviceOrientation", "portrait");
      this.openDataPath = this.mGameConfigJson.optString("openDataContext", null);
      this.showStatusBar = this.mGameConfigJson.optBoolean("showStatusBar", false);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean isOrientationLandscape()
  {
    return "landscape".equals(this.deviceOrientation);
  }
  
  public boolean isShowStatusBar()
  {
    return this.showStatusBar;
  }
  
  public boolean isUrlResReady(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.MiniGamePkg
 * JD-Core Version:    0.7.0.1
 */