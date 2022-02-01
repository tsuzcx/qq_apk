package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.utils.StringUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedParserHelper$ProclamationFeedParser
  extends TroopFeedParserHelper.FeedParser
{
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    for (;;)
    {
      int i;
      int j;
      try
      {
        localTroopFeedItem.type = paramJSONObject.getInt("feed_type");
        JSONArray localJSONArray = paramJSONObject.getJSONArray("content");
        localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
        i = 0;
        if (i >= localJSONArray.length()) {
          break label200;
        }
        paramJSONObject = localJSONArray.getJSONObject(i);
        j = paramJSONObject.getInt("type");
        if (j == 0)
        {
          localTroopFeedItem.content = paramJSONObject.getString("value");
        }
        else if (j == 3)
        {
          if (!paramJSONObject.has("pic_url")) {
            break label203;
          }
          localTroopFeedItem.picPath = (paramJSONObject.getString("pic_url") + "/109");
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      if (j == 10)
      {
        localTroopFeedItem.title = paramJSONObject.getString("value");
      }
      else if ((j == 6) && (StringUtil.a(localTroopFeedItem.picPath)) && (paramJSONObject.has("pic_url")))
      {
        localTroopFeedItem.picPath = paramJSONObject.getString("pic_url");
        break label203;
        label200:
        return localTroopFeedItem;
      }
      label203:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedParserHelper.ProclamationFeedParser
 * JD-Core Version:    0.7.0.1
 */