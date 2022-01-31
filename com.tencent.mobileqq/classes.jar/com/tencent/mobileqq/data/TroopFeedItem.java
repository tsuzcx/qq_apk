package com.tencent.mobileqq.data;

import atmo;
import baip;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="id")
public class TroopFeedItem
  extends atmo
{
  public static final int ABLUM_FEED_TYPE = 18;
  public static final String APPID_STORY_PGC_CONTENT = "1105527223";
  public static final String APPID_STORY_PGC_LIVE = "1105600378";
  public static final int COMMON_FEED_TYPE = 99;
  public static final int FILE_FEED_TYPE = 131;
  public static final int GAME_FEED_TYPE = 133;
  public static final int MUSIC_FEED_TYPE = 132;
  public static final int NOTES_FEED_TYPE = 19;
  public static final int PIC_FEED_TYPE = 0;
  public static final int PROCLAMATION_FEED_TYPE = 5;
  public static final int SHARE_FEED_TYPE = 4;
  public static final int VIDEO_FEED_TYPE = 10;
  public static final int VOTE_FEED_TYPE = 12;
  public String content = "";
  public String currentUin;
  public String ex_1 = "";
  public String feedTime = "";
  public String id = "";
  public String linkUrl = "";
  public int orginType;
  public String picPath = "";
  public String publishUin = "";
  public boolean read;
  public long shareExpire;
  public String shareFromUin;
  public String tag = "";
  public String title = "";
  public String troopUin;
  public int type;
  
  public boolean isStoryType()
  {
    return (this.ex_1.equals("1105527223")) || (this.ex_1.equals("1105600378"));
  }
  
  public boolean isVaild()
  {
    if ((baip.a(this.tag)) || (baip.a(this.title))) {}
    while (((this.type == 0) || (this.type == 131)) && (baip.a(this.content))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopFeedItem
 * JD-Core Version:    0.7.0.1
 */