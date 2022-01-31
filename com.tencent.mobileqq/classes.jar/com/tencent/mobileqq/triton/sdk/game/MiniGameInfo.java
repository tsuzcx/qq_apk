package com.tencent.mobileqq.triton.sdk.game;

import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.debug.GameDebugInfo;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class MiniGameInfo
{
  public static final String DEVICE_ORIENTATION_LANDSCAPE = "landscape";
  public static final String DEVICE_ORIENTATION_PORTRAIT = "portrait";
  public GameDebugInfo debugInfo;
  public String deviceOrientation = "portrait";
  public GameConfig gameConfig;
  public JSONObject gameConfigJson;
  public String gameId;
  private String gamePath;
  public List<GamePluginInfo> gamePluginInfo;
  public String openDataPath;
  public JSONObject permissions;
  public HashMap<String, String> subPackRoots = new HashMap();
  public String workersPath;
  
  public MiniGameInfo(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public MiniGameInfo(String paramString1, String paramString2, GameConfig paramGameConfig)
  {
    this(paramString1, paramString2, paramGameConfig, null);
  }
  
  public MiniGameInfo(String paramString1, String paramString2, GameConfig paramGameConfig, GameDebugInfo paramGameDebugInfo)
  {
    this(paramString1, paramString2, paramGameConfig, paramGameDebugInfo, null);
  }
  
  public MiniGameInfo(String paramString1, String paramString2, GameConfig paramGameConfig, GameDebugInfo paramGameDebugInfo, List<GamePluginInfo> paramList)
  {
    this.gameId = paramString1;
    this.gamePath = paramString2;
    this.gameConfig = paramGameConfig;
    this.debugInfo = paramGameDebugInfo;
    this.gamePluginInfo = paramList;
  }
  
  public String getGamePath()
  {
    return this.gamePath;
  }
  
  public boolean isOrientationLandscape()
  {
    return "landscape".equals(this.deviceOrientation);
  }
  
  public boolean needOpenDebugSocket()
  {
    return (!TextUtils.isEmpty(this.gameId)) && (this.debugInfo != null) && (this.debugInfo.isValid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.game.MiniGameInfo
 * JD-Core Version:    0.7.0.1
 */