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
    try
    {
      localTroopFeedItem.type = paramJSONObject.getInt("feed_type");
      JSONArray localJSONArray = paramJSONObject.getJSONArray("content");
      localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
      int i = 0;
      while (i < localJSONArray.length())
      {
        paramJSONObject = localJSONArray.getJSONObject(i);
        int j = paramJSONObject.getInt("type");
        if (j == 0) {
          localTroopFeedItem.content = paramJSONObject.getString("value");
        } else if (j == 3)
        {
          if (paramJSONObject.has("pic_url"))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramJSONObject.getString("pic_url"));
            localStringBuilder.append("/109");
            localTroopFeedItem.picPath = localStringBuilder.toString();
          }
        }
        else if (j == 10) {
          localTroopFeedItem.title = paramJSONObject.getString("value");
        } else if ((j == 6) && (StringUtil.isEmpty(localTroopFeedItem.picPath)) && (paramJSONObject.has("pic_url"))) {
          localTroopFeedItem.picPath = paramJSONObject.getString("pic_url");
        }
        i += 1;
      }
      return localTroopFeedItem;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedParserHelper.ProclamationFeedParser
 * JD-Core Version:    0.7.0.1
 */