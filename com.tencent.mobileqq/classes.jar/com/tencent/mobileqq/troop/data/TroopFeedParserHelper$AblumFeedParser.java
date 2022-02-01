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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramJSONObject.getString("album_name"));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131715088));
      ((StringBuilder)localObject).append(paramJSONObject.getString("photo_num"));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131715090));
      localTroopFeedItem.title = ((StringBuilder)localObject).toString();
      localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
      localObject = paramJSONObject.getJSONArray("content");
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        paramJSONObject = ((JSONArray)localObject).getJSONObject(i);
        if (paramJSONObject.getInt("type") == 3)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramJSONObject.getString("pic_url"));
          ((StringBuilder)localObject).append("200");
          localTroopFeedItem.picPath = ((StringBuilder)localObject).toString();
          return localTroopFeedItem;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedParserHelper.AblumFeedParser
 * JD-Core Version:    0.7.0.1
 */