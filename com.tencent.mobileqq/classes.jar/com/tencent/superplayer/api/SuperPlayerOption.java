package com.tencent.superplayer.api;

import com.tencent.superplayer.utils.LogUtil;
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
  public boolean isPrePlay;
  public long minBufferingPacketDurationMs;
  public long preloadPacketDurationMs;
  
  public static SuperPlayerOption obtain()
  {
    return new SuperPlayerOption();
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
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerOption
 * JD-Core Version:    0.7.0.1
 */