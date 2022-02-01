package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.TroopFeedItem;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class TroopFeedParserHelper$FeedParser
{
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    TroopFeedItem localTroopFeedItem = new TroopFeedItem();
    try
    {
      localTroopFeedItem.id = paramJSONObject.getString("feed_id");
      localTroopFeedItem.feedTime = paramJSONObject.getString("mod_time");
      localTroopFeedItem.tag = paramJSONObject.getString("tag");
      if (paramJSONObject.has("pub_uin")) {
        localTroopFeedItem.publishUin = paramJSONObject.getString("pub_uin");
      }
      return localTroopFeedItem;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localTroopFeedItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedParserHelper.FeedParser
 * JD-Core Version:    0.7.0.1
 */