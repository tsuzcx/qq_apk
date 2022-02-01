package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.TroopFeedItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedParserHelper$AblumFeedParser
  extends TroopFeedParserHelper.FeedParser
{
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    localTroopFeedItem.type = 18;
    try
    {
      localTroopFeedItem.title = (paramJSONObject.getString("album_name") + HardCodeUtil.a(2131715165) + paramJSONObject.getString("photo_num") + HardCodeUtil.a(2131715167));
      localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
      paramJSONObject = paramJSONObject.getJSONArray("content");
      int i = 0;
      for (;;)
      {
        if (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          if (localJSONObject.getInt("type") == 3) {
            localTroopFeedItem.picPath = (localJSONObject.getString("pic_url") + "200");
          }
        }
        else
        {
          return localTroopFeedItem;
        }
        i += 1;
      }
      return null;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedParserHelper.AblumFeedParser
 * JD-Core Version:    0.7.0.1
 */