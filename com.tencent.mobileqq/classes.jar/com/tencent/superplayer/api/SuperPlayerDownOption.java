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
  public static final int QUIC_DEPEND_ON_PROBE = 1;
  public static final int QUIC_FORCE_ENABLE = 2;
  public static final int QUIC_NOT_ENABLE = 0;
  public static final int RENO_BYTES = 1;
  private static final String TAG = "SuperPlayerDownOption";
  public boolean enableP2P = false;
  public boolean enablePcdn = false;
  public boolean enableQuicConnectionMigration = false;
  public boolean enableQuicPlaintext = false;
  public int quicCongestionType = 0;
  public int quicEnableMode = 0;
  
  public static SuperPlayerDownOption obtain()
  {
    return new SuperPlayerDownOption();
  }
  
  public String toJsonString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("enableP2P", this.enableP2P);
      localJSONObject.put("quicEnableMode", this.quicEnableMode);
      localJSONObject.put("enablePcdn", this.enablePcdn);
      localJSONObject.put("enableQuicPlaintext", this.enableQuicPlaintext);
      localJSONObject.put("quicCongestionType", this.quicCongestionType);
      localJSONObject.put("enableQuicConnectionMigration", this.enableQuicConnectionMigration);
    }
    catch (JSONException localJSONException)
    {
      LogUtil.e("SuperPlayerDownOption", "", localJSONException);
    }
    return localJSONObject.toString();
  }
  
  public Map<String, String> toReportMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("enableP2P", String.valueOf(this.enableP2P));
    localHashMap.put("quicEnableMode", String.valueOf(this.quicEnableMode));
    localHashMap.put("enableQuicPlaintext", String.valueOf(this.enableQuicPlaintext));
    localHashMap.put("quicCongestionType", String.valueOf(this.quicCongestionType));
    localHashMap.put("enablePcdn", String.valueOf(this.enablePcdn));
    localHashMap.put("enableQuicConnectionMigration", String.valueOf(this.enableQuicConnectionMigration));
    return localHashMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SuperPlayerDownOption[");
    localStringBuilder.append("\n");
    localStringBuilder.append("enableP2P:");
    localStringBuilder.append(this.enableP2P);
    localStringBuilder.append("\n");
    localStringBuilder.append("quicEnableMode:");
    localStringBuilder.append(this.quicEnableMode);
    localStringBuilder.append("\n");
    localStringBuilder.append("enablePcdn:");
    localStringBuilder.append(this.enablePcdn);
    localStringBuilder.append("\n");
    localStringBuilder.append("enableQuicPlaintext:");
    localStringBuilder.append(this.enableQuicPlaintext);
    localStringBuilder.append("\n");
    localStringBuilder.append("quicCongestionType:");
    localStringBuilder.append(this.quicCongestionType);
    localStringBuilder.append("\n");
    localStringBuilder.append("enableQuicConnectionMigration:");
    localStringBuilder.append(this.enableQuicConnectionMigration);
    localStringBuilder.append("\n");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerDownOption
 * JD-Core Version:    0.7.0.1
 */