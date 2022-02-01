package com.tencent.mobileqq.hotchat.adapter;

import java.util.Comparator;
import org.json.JSONObject;

class HotChatPostListAdapter$1
  implements Comparator<JSONObject>
{
  HotChatPostListAdapter$1(HotChatPostListAdapter paramHotChatPostListAdapter) {}
  
  public int a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    return Long.valueOf(paramJSONObject2.optLong("time")).compareTo(Long.valueOf(paramJSONObject1.optLong("time")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.adapter.HotChatPostListAdapter.1
 * JD-Core Version:    0.7.0.1
 */