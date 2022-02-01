package com.tencent.superplayer.api;

import com.tencent.superplayer.config.CacheContent;
import com.tencent.superplayer.config.ConfigManager;
import com.tencent.superplayer.utils.LogUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SuperPlayerOption
{
  private static final String TAG = "SuperPlayerOption";
  public boolean accurateSeekOnOpen;
  public SuperPlayerAudioInfo audioFrameOutputOption;
  public long bufferPacketMinTotalDurationMs;
  public boolean enableAudioFrameOutput;
  public boolean enableCodecReuse;
  public Boolean enableDownloadProxy;
  public boolean enableVideoFrameCheck;
  public boolean enableVideoFrameOutput;
  public Map<String, String> httpHeader;
  public boolean isPrePlay;
  public long minBufferingPacketDurationMs;
  public long preloadPacketDurationMs;
  private int sceneId;
  public SuperPlayerDownOption superPlayerDownOption = SuperPlayerDownOption.obtain();
  
  private SuperPlayerOption(int paramInt)
  {
    this.sceneId = paramInt;
    loadConfigFromConfigManager();
  }
  
  private void loadConfigFromConfigManager()
  {
    if (ConfigManager.needLoadConfig(this.sceneId))
    {
      this.enableCodecReuse = ConfigManager.get().getConfig("codecReuse").getBoolean("video_codec_reuse_enable", this.enableCodecReuse);
      this.enableVideoFrameCheck = ConfigManager.get().getConfig("codecReuse").getBoolean("video_frame_check_enable", this.enableVideoFrameCheck);
    }
  }
  
  public static SuperPlayerOption obtain()
  {
    return obtain(0);
  }
  
  public static SuperPlayerOption obtain(int paramInt)
  {
    return new SuperPlayerOption(paramInt);
  }
  
  public String toJsonString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("isPrePlay", this.isPrePlay);
      localJSONObject.put("enableCodecReuse", this.enableCodecReuse);
      localJSONObject.put("accurateSeekOnOpen", this.accurateSeekOnOpen);
      localJSONObject.put("enableVideoFrameCheck", this.enableVideoFrameCheck);
      localJSONObject.put("bufferPacketMinTotalDurationMs", this.bufferPacketMinTotalDurationMs);
      localJSONObject.put("preloadPacketDurationMs", this.preloadPacketDurationMs);
      localJSONObject.put("minBufferingPacketDurationMs", this.minBufferingPacketDurationMs);
      localJSONObject.put("audioFrameOutputOption", this.audioFrameOutputOption);
      localJSONObject.put("superPlayerDownOption", this.superPlayerDownOption.toJsonString());
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        LogUtil.e("SuperPlayerOption", "");
      }
    }
  }
  
  public Map<String, String> toReportMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("isPrePlay", String.valueOf(this.isPrePlay));
    localHashMap.put("enableCodecReuse", String.valueOf(this.enableCodecReuse));
    localHashMap.put("accurateSeekOnOpen", String.valueOf(this.accurateSeekOnOpen));
    localHashMap.put("enableVideoFrameCheck", String.valueOf(this.enableVideoFrameCheck));
    localHashMap.put("bufferPacketMinTotalDurationMs", String.valueOf(this.bufferPacketMinTotalDurationMs));
    localHashMap.put("preloadPacketDurationMs", String.valueOf(this.preloadPacketDurationMs));
    localHashMap.put("minBufferingPacketDurationMs", String.valueOf(this.minBufferingPacketDurationMs));
    localHashMap.put("audioFrameOutputOption", String.valueOf(this.audioFrameOutputOption));
    localHashMap.putAll(this.superPlayerDownOption.toReportMap());
    return localHashMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SuperPlayerOption[").append("\n");
    localStringBuilder.append("isPrePlay:").append(this.isPrePlay).append("\n");
    localStringBuilder.append("enableCodecReuse:").append(this.enableCodecReuse).append("\n");
    localStringBuilder.append("accurateSeekOnOpen:").append(this.accurateSeekOnOpen).append("\n");
    localStringBuilder.append("enableVideoFrameCheck:").append(this.enableVideoFrameCheck).append("\n");
    localStringBuilder.append("bufferPacketMinTotalDurationMs:").append(this.bufferPacketMinTotalDurationMs).append("\n");
    localStringBuilder.append("preloadPacketDurationMs:").append(this.preloadPacketDurationMs).append("\n");
    localStringBuilder.append("minBufferingPacketDurationMs:").append(this.minBufferingPacketDurationMs).append("\n");
    localStringBuilder.append("audioFrameOutputOption:").append(this.audioFrameOutputOption).append("\n");
    localStringBuilder.append("httpHeader:").append(this.httpHeader).append("\n");
    localStringBuilder.append("superPlayerDownOption").append(this.superPlayerDownOption).append("\n");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerOption
 * JD-Core Version:    0.7.0.1
 */