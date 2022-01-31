package com.tencent.mobileqq.triton.game;

import android.text.TextUtils;
import com.tencent.mobileqq.triton.bridge.TTJSBridge;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.jni.TTNativeModule;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
import com.tencent.mobileqq.triton.sdk.game.GamePluginInfo;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TTNativeModule(name="GameLauncher")
public class GameLauncher
  implements IGameLauncher
{
  private static final String ENABLE_WEBGL_PLUS = "  if (typeof global.enableTTWebglPlus == \"function\" ) {\n    global.enableTTWebglPlus()\n  }";
  private static final int ERROR_FILE_NOT_EXIST = -3;
  private static final int ERROR_GAME_CONFIG_NULL = -2;
  private static final int ERROR_GAME_ID_EMPTY = -4;
  private static final String GAME_ENV_VERSION = "var __wxConfig = __wxConfig || {}; __wxConfig.envVersion = ";
  private static final String GAME_JSON = "var __wxConfig = __wxConfig || {}; __wxConfig.gameJson=";
  public static final String TAG = "GameLauncher";
  public static final String TAG_SUBPACK = "GameLauncher[subpackage]";
  private static final String WINDOW_UNDEFINED = "window = undefined";
  private static Map<String, String> resPathCache = new HashMap();
  private MiniGameInfo mCurrentGame;
  private final Map<String, GamePluginInfo> mGamePluinInfos = new HashMap();
  private TTJSBridge mJSBridge;
  private TTEngine mTritonEngine;
  
  public GameLauncher(TTEngine paramTTEngine, TTJSBridge paramTTJSBridge)
  {
    this.mTritonEngine = paramTTEngine;
    this.mJSBridge = paramTTJSBridge;
  }
  
  public static Map<String, String> getResPathCache()
  {
    return resPathCache;
  }
  
  private int launchMainScript(MiniGameInfo paramMiniGameInfo)
  {
    if (paramMiniGameInfo == null) {
      return -2;
    }
    TTLog.i("GameLauncher", "launch game [" + paramMiniGameInfo.gameId + "] mainContext");
    String str = paramMiniGameInfo.getGamePath() + File.separator + "game.js";
    File localFile = new File(str);
    if (!localFile.exists())
    {
      TTLog.e("GameLauncher", "launch game [" + paramMiniGameInfo.gameId + "] fail, missing game.js");
      return -3;
    }
    return this.mTritonEngine.loadScriptPathWithCodeCache(1, localFile.getAbsolutePath(), getGameDebugPath(str), localFile.getAbsolutePath() + ".cc");
  }
  
  private void launchOpenDataScript(MiniGameInfo paramMiniGameInfo)
  {
    if (paramMiniGameInfo == null) {}
    String str;
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramMiniGameInfo.openDataPath))
      {
        TTLog.i("GameLauncher", "launch game [" + paramMiniGameInfo.gameId + "] openDataContext abort, 游戏未配置开放域");
        return;
      }
      TTLog.i("GameLauncher", "launch game [" + paramMiniGameInfo.gameId + "] openDataContext");
      str = paramMiniGameInfo.gameId;
      Object localObject = paramMiniGameInfo.openDataPath;
      localObject = new File(paramMiniGameInfo.getGamePath() + File.separator + (String)localObject + File.separator + "index.js");
      paramMiniGameInfo = new File(paramMiniGameInfo.getGamePath() + File.separator + "subContext.js");
      if (((File)localObject).exists())
      {
        TTLog.i("GameLauncher", "launch  game [" + str + "] openData from openDataContext/index.js");
        paramMiniGameInfo = (MiniGameInfo)localObject;
      }
      while (this.mTritonEngine.loadScriptPathWithCodeCache(2, paramMiniGameInfo.getAbsolutePath(), getGameDebugPath(paramMiniGameInfo.getAbsolutePath()), paramMiniGameInfo.getAbsolutePath() + ".cc") == -1)
      {
        TTLog.e("GameLauncher", "launch  game [" + str + "] openData fail, entry file empty");
        return;
        if (!paramMiniGameInfo.exists()) {
          break label330;
        }
        TTLog.i("GameLauncher", "launch  game [" + str + "] openData from subContext.js");
      }
    }
    label330:
    TTLog.e("GameLauncher", "launch  game [" + str + "] openData fail,  no entry openData js file");
  }
  
  @TTNativeCall
  public String getBaseEnginePath()
  {
    return this.mTritonEngine.getQQEnv().getBaseEnginePath();
  }
  
  public MiniGameInfo getCurrentGame()
  {
    return this.mCurrentGame;
  }
  
  @TTNativeCall
  public String getGameConfig(String paramString)
  {
    return this.mTritonEngine.getQQEnv().getGameConfig(this.mTritonEngine.getMiniGameInfo(), paramString);
  }
  
  @TTNativeCall
  public String getGameDebugPath(String paramString)
  {
    Object localObject = this.mTritonEngine.getMiniGameInfo();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((MiniGameInfo)localObject).getGamePath())
    {
      String str = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        str = paramString;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          str = paramString;
          if (paramString.startsWith((String)localObject))
          {
            paramString = paramString.substring(((String)localObject).length());
            str = "/game" + paramString;
          }
        }
      }
      return str;
    }
  }
  
  @TTNativeCall
  public String getGamePluginDebugPath(String paramString)
  {
    String str = null;
    if (this.mTritonEngine.getGameLauncher() != null) {}
    for (paramString = this.mTritonEngine.getGameLauncher().getGamePluginInfo(paramString);; paramString = null)
    {
      if (paramString != null) {
        str = "/game_plugin/" + paramString.name + "/" + paramString.version + "/plugin.js";
      }
      return str;
    }
  }
  
  @TTNativeCall
  public String getGamePluginId(String paramString)
  {
    String str = null;
    if (this.mTritonEngine.getGameLauncher() != null) {}
    for (paramString = this.mTritonEngine.getGameLauncher().getGamePluginInfo(paramString);; paramString = null)
    {
      if (paramString != null) {
        str = paramString.id;
      }
      return str;
    }
  }
  
  public GamePluginInfo getGamePluginInfo(String paramString)
  {
    return (GamePluginInfo)this.mGamePluinInfos.get(paramString);
  }
  
  @TTNativeCall
  public String getGamePluginPath(String paramString)
  {
    String str = null;
    if (this.mTritonEngine.getGameLauncher() != null) {}
    for (paramString = this.mTritonEngine.getGameLauncher().getGamePluginInfo(paramString);; paramString = null)
    {
      if (paramString != null) {
        str = paramString.path;
      }
      return str;
    }
  }
  
  @TTNativeCall
  public String getResPath(String paramString1, String paramString2)
  {
    String str = paramString1 + "_" + paramString2;
    if (!resPathCache.containsKey(str))
    {
      if (this.mTritonEngine.getGameLauncher() != null) {}
      for (Object localObject = this.mTritonEngine.getGameLauncher().getCurrentGame();; localObject = null)
      {
        localObject = this.mTritonEngine.getQQEnv().getResPath(paramString1, paramString2, (MiniGameInfo)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          resPathCache.put(str, localObject);
          TTLog.d("GameLauncher", "getResPath() name:" + paramString1 + ",type:" + paramString2 + ",resPath:" + (String)localObject);
        }
        return localObject;
      }
    }
    return (String)resPathCache.get(str);
  }
  
  @TTNativeCall
  public String getTmpFilePath(String paramString)
  {
    if (!resPathCache.containsKey(paramString))
    {
      String str = this.mTritonEngine.getQQEnv().getTmpFilePath(this.mTritonEngine.getMiniGameInfo(), paramString);
      if (!TextUtils.isEmpty(str))
      {
        resPathCache.put(paramString, str);
        TTLog.d("GameRender", "getTmpFilePath() path:" + paramString + ", resPath:" + str);
      }
      return str;
    }
    return (String)resPathCache.get(paramString);
  }
  
  public int launchGame()
  {
    if ((this.mCurrentGame == null) || (TextUtils.isEmpty(this.mCurrentGame.gameId)))
    {
      TTLog.e("GameLauncher", "launch game fail, mCurrentGame null or gameId null");
      if ((this.mTritonEngine != null) && (this.mTritonEngine.getEngineListener() != null)) {
        this.mTritonEngine.getEngineListener().onGameLaunched(-4, 0L);
      }
      return -1;
    }
    GameLauncher.1 local1 = new GameLauncher.1(this);
    this.mJSBridge.runOnJsThread(local1);
    if (this.mTritonEngine.getLifecycleManager() != null) {
      this.mTritonEngine.getLifecycleManager().onGameLaunched();
    }
    return 0;
  }
  
  public boolean launchSubpackage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    label505:
    for (;;)
    {
      try
      {
        MiniGameInfo localMiniGameInfo = this.mTritonEngine.getMiniGameInfo();
        if (localMiniGameInfo == null) {
          break;
        }
        this.mTritonEngine.getQQEnv().reportDC04266(1009, null);
        if (paramString.endsWith(".js")) {
          break label505;
        }
        Object localObject = new StringBuilder().append(paramString);
        String str;
        if (paramString.endsWith(File.separator))
        {
          paramString = "";
          paramString = paramString + "game.js";
          TTLog.i("GameLauncher[subpackage]", "try loadSubPackageEnter subPath:" + paramString);
          str = localMiniGameInfo.getGamePath() + File.separator + paramString;
          if (new File(str).exists())
          {
            localObject = paramString;
            paramString = str;
            if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
              continue;
            }
            paramString = new File(paramString);
            if (paramString.length() != 0L) {
              continue;
            }
            TTLog.i("GameLauncher[subpackage]", "分包入口文件为空文件, entryPath:" + (String)localObject);
            return true;
          }
        }
        else
        {
          paramString = File.separator;
          continue;
        }
        localObject = paramString;
        if (!str.endsWith("game.js"))
        {
          paramString = paramString.substring(0, paramString.lastIndexOf("/") + 1) + "game.js";
          str = localMiniGameInfo.getGamePath() + File.separator + paramString;
          localObject = paramString;
          if (new File(str).exists())
          {
            TTLog.w("GameLauncher[subpackage]", "config entry file not found, switch entryPath to:" + paramString);
            localObject = paramString;
            paramString = str;
            continue;
            if (this.mTritonEngine.loadScriptPathWithCodeCache(1, paramString.getAbsolutePath(), ((GameLauncher)this.mTritonEngine.getGameLauncher()).getGameDebugPath(paramString.getAbsolutePath()), paramString.getAbsolutePath() + ".cc") != -1)
            {
              this.mTritonEngine.getQQEnv().reportDC04266(1010, null);
              break;
            }
            TTLog.e("GameLauncher[subpackage]", "加载分包的启动js失败, entryPath file empty:" + (String)localObject);
            return false;
            TTLog.e("GameLauncher[subpackage]", "加载分包的启动js失败, entryPath file not found:" + (String)localObject);
            return false;
          }
        }
      }
      catch (Throwable paramString)
      {
        TTLog.e("GameLauncher[subpackage]", "加载分包的启动js失败: ", paramString);
        return false;
      }
      paramString = null;
    }
    return true;
  }
  
  public void setCurrentGame(MiniGameInfo paramMiniGameInfo)
  {
    this.mCurrentGame = paramMiniGameInfo;
    this.mGamePluinInfos.clear();
    if ((paramMiniGameInfo != null) && (paramMiniGameInfo.gamePluginInfo != null))
    {
      paramMiniGameInfo = paramMiniGameInfo.gamePluginInfo.iterator();
      while (paramMiniGameInfo.hasNext())
      {
        GamePluginInfo localGamePluginInfo = (GamePluginInfo)paramMiniGameInfo.next();
        this.mGamePluinInfos.put(localGamePluginInfo.name, localGamePluginInfo);
      }
    }
    resPathCache.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.GameLauncher
 * JD-Core Version:    0.7.0.1
 */