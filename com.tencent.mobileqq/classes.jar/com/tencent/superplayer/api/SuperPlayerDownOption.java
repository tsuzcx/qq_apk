package com.tencent.superplayer.api;

import com.tencent.superplayer.utils.LogUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SuperPlayerDownOption
{
  public static final int BBR = 2;
  public static final int CUBIC_BYTES = 0;
  public static final int GOOGLE_CC = 4;
  public static final int PCC = 3;
  public static final int RENO_BYTES = 1;
  private static final String TAG = "SuperPlayerDownOption";
  public boolean enableP2P = false;
  public boolean enablePcdn = false;
  public boolean enableQuicConnectionMigration = false;
  public boolean enableQuicPlaintext = false;
  public boolean enableUseQuic = false;
  public long preloadDurationMs;
  public long preloadSize;
  public int quicCongestionType = 0;
  public long videoDurationMs;
  
  public static SuperPlayerDownOption obtain()
  {
    return new SuperPlayerDownOption();
  }
  
  public String toJsonString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("videoDurationMs", this.videoDurationMs);
      localJSONObject.put("preloadDurationMs", this.preloadDurationMs);
      localJSONObject.put("preloadSize", this.preloadSize);
      localJSONObject.put("enableP2P", this.enableP2P);
      localJSONObject.put("enableUseQuic", this.enableUseQuic);
      localJSONObject.put("enablePcdn", this.enablePcdn);
      localJSONObject.put("enableQuicPlaintext", this.enableQuicPlaintext);
      localJSONObject.put("quicCongestionType", this.quicCongestionType);
      localJSONObject.put("enableQuicConnectionMigration", this.enableQuicConnectionMigration);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        LogUtil.e("SuperPlayerDownOption", "", localJSONException);
      }
    }
  }
  
  public Map<String, String> toReportMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoDurationMs", String.valueOf(this.videoDurationMs));
    localHashMap.put("preloadDurationMs", String.valueOf(this.preloadDurationMs));
    localHashMap.put("preloadSize", String.valueOf(this.preloadSize));
    localHashMap.put("enableP2P", String.valueOf(this.enableP2P));
    localHashMap.put("enableUseQuic", String.valueOf(this.enableUseQuic));
    localHashMap.put("enableQuicPlaintext", String.valueOf(this.enableQuicPlaintext));
    localHashMap.put("quicCongestionType", String.valueOf(this.quicCongestionType));
    localHashMap.put("enablePcdn", String.valueOf(this.enablePcdn));
    localHashMap.put("enableQuicConnectionMigration", String.valueOf(this.enableQuicConnectionMigration));
    return localHashMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SuperPlayerDownOption[").append("\n");
    localStringBuilder.append("videoDurationMs:").append(this.videoDurationMs).append("\n");
    localStringBuilder.append("preloadDurationMs:").append(this.preloadDurationMs).append("\n");
    localStringBuilder.append("preloadSize:").append(this.preloadSize).append("\n");
    localStringBuilder.append("enableP2P:").append(this.enableP2P).append("\n");
    localStringBuilder.append("enableUseQuic:").append(this.enableUseQuic).append("\n");
    localStringBuilder.append("enablePcdn:").append(this.enablePcdn).append("\n");
    localStringBuilder.append("enableQuicPlaintext:").append(this.enableQuicPlaintext).append("\n");
    localStringBuilder.append("quicCongestionType:").append(this.quicCongestionType).append("\n");
    localStringBuilder.append("enableQuicConnectionMigration:").append(this.enableQuicConnectionMigration).append("\n");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerDownOption
 * JD-Core Version:    0.7.0.1
 */