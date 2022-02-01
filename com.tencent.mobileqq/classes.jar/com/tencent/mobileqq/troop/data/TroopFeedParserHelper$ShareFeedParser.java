package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.TroopFeedItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedParserHelper$ShareFeedParser
  extends TroopFeedParserHelper.FeedParser
{
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    try
    {
      localObject = paramJSONObject.getJSONArray("content");
      if (((JSONArray)localObject).length() > 0)
      {
        localObject = ((JSONArray)localObject).getJSONObject(0);
        i = ((JSONObject)localObject).getInt("type");
        if (i == 5)
        {
          if (((JSONObject)localObject).has("file_path")) {
            localTroopFeedItem.linkUrl = ((JSONObject)localObject).getString("file_path");
          }
          localTroopFeedItem.type = 131;
          boolean bool = ((JSONObject)localObject).has("sharesize");
          if (bool)
          {
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("");
            paramJSONObject.append(((JSONObject)localObject).getLong("sharesize"));
            localTroopFeedItem.ex_1 = paramJSONObject.toString();
          }
          bool = ((JSONObject)localObject).has("bus_id");
          if (!bool) {}
        }
      }
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject;
      int i;
      label180:
      paramJSONObject.printStackTrace();
      return null;
    }
    try
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("");
      paramJSONObject.append(((JSONObject)localObject).getLong("bus_id"));
      localTroopFeedItem.content = paramJSONObject.toString();
    }
    catch (JSONException paramJSONObject)
    {
      break label180;
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("");
    paramJSONObject.append(((JSONObject)localObject).getString("bus_id"));
    localTroopFeedItem.content = paramJSONObject.toString();
    if (((JSONObject)localObject).has("sharefile")) {
      localTroopFeedItem.title = ((JSONObject)localObject).getString("sharefile");
    }
    if (((JSONObject)localObject).has("shareexpire")) {
      localTroopFeedItem.shareExpire = ((JSONObject)localObject).getLong("shareexpire");
    }
    if (((JSONObject)localObject).has("sharefromuin"))
    {
      localTroopFeedItem.shareFromUin = ((JSONObject)localObject).getString("sharefromuin");
      return localTroopFeedItem;
      if (i == 4)
      {
        localTroopFeedItem.type = 132;
        localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
        localTroopFeedItem.title = ((JSONObject)localObject).getString("musicname");
        localTroopFeedItem.ex_1 = ((JSONObject)localObject).getString("musicid");
        localTroopFeedItem.picPath = ((JSONObject)localObject).getString("pic_url");
      }
    }
    return localTroopFeedItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedParserHelper.ShareFeedParser
 * JD-Core Version:    0.7.0.1
 */