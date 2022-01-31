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
    if (localTroopFeedItem == null) {}
    for (;;)
    {
      return null;
      localTroopFeedItem.type = 99;
      try
      {
        localTroopFeedItem.linkUrl = paramJSONObject.optString("open_url");
        if (paramJSONObject.has("app_id"))
        {
          localTroopFeedItem.ex_1 = ("" + paramJSONObject.getLong("app_id"));
          if ((!QQStoryManager.j()) && (localTroopFeedItem.isStoryType()))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("TroopFeedParserHelperQ.qqstory.tag_api_limit", 2, "当前系统api：" + Build.VERSION.SDK_INT + ",低于14");
            return null;
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
    }
    paramJSONObject = paramJSONObject.getJSONObject("content");
    localTroopFeedItem.content = paramJSONObject.getString("body");
    localTroopFeedItem.title = paramJSONObject.getString("title");
    localTroopFeedItem.picPath = paramJSONObject.getString("pic_url");
    return localTroopFeedItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedParserHelper.CommonFeedParser
 * JD-Core Version:    0.7.0.1
 */