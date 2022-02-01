package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.text.TextUtils;
import org.json.JSONObject;

public class ReadInJoyMedalInfo
{
  public long a = -1L;
  public String b;
  public String c;
  public int d = -1;
  public int e = 0;
  public String f;
  public int g;
  public int h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.a > 0L) {
        localJSONObject.put("medalid", this.a);
      }
      if (this.d > 0) {
        localJSONObject.put("mMedalType", this.d);
      }
      if (this.e > 0) {
        localJSONObject.put("mIsJump", this.e);
      }
      if (this.g > 0) {
        localJSONObject.put("GRID_FEED_ITEM_SIZE", this.g);
      }
      if (this.h > 0) {
        localJSONObject.put("mPicHeight", this.h);
      }
      if (!TextUtils.isEmpty(this.b)) {
        localJSONObject.put("medal_name", this.b);
      }
      if (!TextUtils.isEmpty("medal_url")) {
        localJSONObject.put("medal_url", this.c);
      }
      if (!TextUtils.isEmpty("mJumpUrl")) {
        localJSONObject.put("mJumpUrl", this.f);
      }
      if (!TextUtils.isEmpty("medal_scene")) {
        localJSONObject.put("medal_scene", this.j);
      }
      if (!TextUtils.isEmpty("medal_pos")) {
        localJSONObject.put("medal_pos", this.k);
      }
      if (!TextUtils.isEmpty("channelid")) {
        localJSONObject.put("channelid", this.i);
      }
      if (!TextUtils.isEmpty("feedsid")) {
        localJSONObject.put("feedsid", this.l);
      }
      if (!TextUtils.isEmpty("medal_uin")) {
        localJSONObject.put("medal_uin", this.m);
      }
    }
    catch (Exception localException)
    {
      label254:
      break label254;
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyMedalInfo
 * JD-Core Version:    0.7.0.1
 */