package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.utils.StringUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedParserHelper$PicFeedParser
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
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("content");
        i = 0;
        if (i < paramJSONObject.length())
        {
          localJSONObject = paramJSONObject.getJSONObject(i);
          j = localJSONObject.getInt("type");
          if (j == 5)
          {
            if (localJSONObject.has("file_path")) {
              localTroopFeedItem.linkUrl = localJSONObject.getString("file_path");
            }
            localTroopFeedItem.type = 0;
            boolean bool = localJSONObject.has("sharesize");
            if (bool)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(localJSONObject.getLong("sharesize"));
              localTroopFeedItem.ex_1 = localStringBuilder.toString();
            }
            bool = localJSONObject.has("bus_id");
            if (!bool) {}
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        int i;
        JSONObject localJSONObject;
        int j;
        StringBuilder localStringBuilder;
        paramJSONObject.printStackTrace();
        return null;
      }
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(localJSONObject.getLong("bus_id"));
        localTroopFeedItem.content = localStringBuilder.toString();
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(localJSONObject.getString("bus_id"));
      localTroopFeedItem.content = localStringBuilder.toString();
      if (localJSONObject.has("sharefile"))
      {
        localTroopFeedItem.title = localJSONObject.getString("sharefile");
        continue;
        if ((j == 3) && (localJSONObject.has("pic_id")))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("https://gdynamic.qpic.cn/gdynamic/");
          localStringBuilder.append(localJSONObject.getString("pic_id"));
          localStringBuilder.append("/109");
          localTroopFeedItem.picPath = localStringBuilder.toString();
        }
      }
      i += 1;
    }
    if (!StringUtil.isEmpty(localTroopFeedItem.linkUrl))
    {
      if (StringUtil.isEmpty(localTroopFeedItem.content)) {
        return null;
      }
      return localTroopFeedItem;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedParserHelper.PicFeedParser
 * JD-Core Version:    0.7.0.1
 */