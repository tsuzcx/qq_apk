package com.tencent.mobileqq.minigame.manager;

import android.content.SharedPreferences;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.minigame.utils.GameLog;

public class GameLibVersionManager
{
  private static final String TAG = "GameLibVersionManager";
  private static volatile GameLibVersionManager instance;
  private String gameEngineVersion;
  
  public static GameLibVersionManager g()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new GameLibVersionManager();
      }
      return instance;
    }
    finally {}
  }
  
  private static String getNewestBaseLib(String paramString1, String paramString2)
  {
    boolean bool1 = BaseLibManager.g().isBaseLibDirValid4MiniGame(paramString1);
    boolean bool2 = BaseLibManager.g().isBaseLibDirValid4MiniGame(paramString2);
    if ((bool1) && (bool2))
    {
      localEngineVersion1 = EngineVersion.fromFolderName(paramString1);
      localEngineVersion2 = EngineVersion.fromFolderName(paramString2);
      if ((localEngineVersion1 != null) && (localEngineVersion2 != null)) {
        if (EngineVersion.compareVersion(localEngineVersion1.mMinor, localEngineVersion2.mMinor) < 0) {}
      }
    }
    while (bool1)
    {
      EngineVersion localEngineVersion1;
      EngineVersion localEngineVersion2;
      do
      {
        return paramString1;
        return paramString2;
      } while ((localEngineVersion1 != null) || (localEngineVersion2 == null));
      return paramString2;
    }
    if (bool2) {
      return paramString2;
    }
    return null;
  }
  
  private void setGameEngineVersion(EngineVersion paramEngineVersion)
  {
    if ((paramEngineVersion != null) && (paramEngineVersion.mMinor != null)) {
      this.gameEngineVersion = paramEngineVersion.mMinor.replace("/", "");
    }
  }
  
  public String getGameEngineVersion()
  {
    return this.gameEngineVersion;
  }
  
  public String getGameJsLibPath()
  {
    String str1 = StorageUtil.getPreference().getString("downloadUrl", "mini");
    String str2 = StorageUtil.getPreference().getString("version", "1.13.0.00013");
    str1 = BaseLibManager.g().getBaseLibDir(str1, str2);
    str2 = BaseLibManager.g().getBaseLibDir("mini", "1.13.0.00013");
    str1 = getNewestBaseLib(GameLoadManager.g().getBaseEnginePath(), getNewestBaseLib(str1, str2));
    if (str1 != null) {
      setGameEngineVersion(EngineVersion.fromFolderName(str1));
    }
    GameLog.getInstance().i("GameLibVersionManager", "[MiniEng]getBaseEnginePath, [本次启动使用的小游戏基础库版本]retPath:" + str1);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameLibVersionManager
 * JD-Core Version:    0.7.0.1
 */