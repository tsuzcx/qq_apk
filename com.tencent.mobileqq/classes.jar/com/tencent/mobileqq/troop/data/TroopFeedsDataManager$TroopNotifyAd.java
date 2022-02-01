package com.tencent.mobileqq.troop.data;

import org.json.JSONObject;

public class TroopFeedsDataManager$TroopNotifyAd
{
  public String a = null;
  public String b = null;
  public String c = null;
  
  public static TroopNotifyAd a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      TroopNotifyAd localTroopNotifyAd = new TroopNotifyAd();
      localTroopNotifyAd.a = paramJSONObject.optString("apurl");
      localTroopNotifyAd.c = paramJSONObject.optString("img");
      localTroopNotifyAd.b = paramJSONObject.optString("rl");
      return localTroopNotifyAd;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotifyAd
 * JD-Core Version:    0.7.0.1
 */