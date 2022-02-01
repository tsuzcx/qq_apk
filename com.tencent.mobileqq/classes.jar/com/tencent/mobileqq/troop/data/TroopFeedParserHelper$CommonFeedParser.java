package com.tencent.mobileqq.troop.data;

import android.os.Build.VERSION;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedParserHelper$CommonFeedParser
  extends TroopFeedParserHelper.FeedParser
{
  public TroopFeedItem a(JSONObject paramJSONObject)
  {
    TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
    if (localTroopFeedItem == null) {
      return null;
    }
    localTroopFeedItem.type = 99;
    try
    {
      localTroopFeedItem.linkUrl = paramJSONObject.optString("open_url");
      if (paramJSONObject.has("app_id"))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramJSONObject.getLong("app_id"));
        localTroopFeedItem.ex_1 = localStringBuilder.toString();
        if ((!QQStoryManager.o()) && (localTroopFeedItem.isStoryType()))
        {
          if (!QLog.isColorLevel()) {
            break label178;
          }
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("当前系统api：");
          paramJSONObject.append(Build.VERSION.SDK_INT);
          paramJSONObject.append(",低于14");
          QLog.d("TroopFeedParserHelperQ.qqstory.tag_api_limit", 2, paramJSONObject.toString());
          return null;
        }
      }
      paramJSONObject = paramJSONObject.getJSONObject("content");
      localTroopFeedItem.content = paramJSONObject.getString("body");
      localTroopFeedItem.title = paramJSONObject.getString("title");
      localTroopFeedItem.picPath = paramJSONObject.getString("pic_url");
      return localTroopFeedItem;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return null;
    }
    label178:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedParserHelper.CommonFeedParser
 * JD-Core Version:    0.7.0.1
 */