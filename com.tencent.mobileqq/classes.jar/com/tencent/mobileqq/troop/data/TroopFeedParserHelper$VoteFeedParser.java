package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.data.TroopFeedItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedParserHelper$VoteFeedParser
  extends TroopFeedParserHelper.FeedParser
{
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    localTroopFeedItem.type = 12;
    for (;;)
    {
      int i;
      try
      {
        localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
        paramJSONObject = paramJSONObject.getJSONObject("vote");
        if (paramJSONObject != null)
        {
          JSONArray localJSONArray = paramJSONObject.getJSONArray("opts");
          i = 0;
          j = 0;
          k = localJSONArray.length();
          if ((i < k) && (j <= 1))
          {
            Object localObject = localJSONArray.getJSONArray(i);
            k = j;
            if (((JSONArray)localObject).length() <= 0) {
              break label181;
            }
            localObject = ((JSONArray)localObject).getJSONObject(0);
            if (j == 0)
            {
              localTroopFeedItem.content = ((JSONObject)localObject).getString("value");
              break label176;
            }
            localTroopFeedItem.ex_1 = ((JSONObject)localObject).getString("value");
            break label176;
          }
          paramJSONObject = paramJSONObject.getJSONArray("title");
          if (paramJSONObject.length() > 0) {
            localTroopFeedItem.title = paramJSONObject.getJSONObject(0).getString("value");
          }
        }
        return localTroopFeedItem;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      label176:
      int k = j + 1;
      label181:
      i += 1;
      int j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedParserHelper.VoteFeedParser
 * JD-Core Version:    0.7.0.1
 */