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
  public List<GamePluginInfo> gamePluginInfo;
  public String openDataPath;
  public JSONObject permissions;
  public HashMap<String, String> subPackRoots = new HashMap();
  public int verType;
  public String version;
  public String workersPath;
  
  public MiniGameInfo(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, null);
  }
  
  public MiniGameInfo(String paramString1, String paramString2, int paramInt, GameConfig paramGameConfig)
  {
    this(paramString1, paramString2, paramInt, paramGameConfig, null);
  }
  
  public MiniGameInfo(String paramString1, String paramString2, int paramInt, GameConfig paramGameConfig, GameDebugInfo paramGameDebugInfo)
  {
    this(paramString1, paramString2, paramInt, paramGameConfig, paramGameDebugInfo, null);
  }
  
  public MiniGameInfo(String paramString1, String paramString2, int paramInt, GameConfig paramGameConfig, GameDebugInfo paramGameDebugInfo, List<GamePluginInfo> paramList)
  {
    this.gameId = paramString1;
    this.version = paramString2;
    this.verType = paramInt;
    this.gameConfig = paramGameConfig;
    this.debugInfo = paramGameDebugInfo;
    this.gamePluginInfo = paramList;
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