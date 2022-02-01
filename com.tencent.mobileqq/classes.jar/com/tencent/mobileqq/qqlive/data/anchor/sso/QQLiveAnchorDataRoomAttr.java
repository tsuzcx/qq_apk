package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;

public class QQLiveAnchorDataRoomAttr
{
  public static final int LIVE_ROOM_TYPE_GAME = 1;
  public static final int LIVE_ROOM_TYPE_NORMAL = 0;
  public String city;
  public String defaultRoomName;
  public boolean enableGif;
  public QQLiveAnchorRoomGameInfo gameInfo;
  public int liveRoomType = 0;
  public String locationAT;
  public String locationNG;
  public String phoneModel;
  public String poster;
  public String poster16v9;
  public String poster3v4;
  public int posterNum;
  public long posterTime;
  public long posterTime16v9;
  public long posterTime3v4;
  public long roomId;
  public String roomName;
  public QQLiveAnchorDataRoomRichTitle tags;
  
  public QQLiveAnchorDataRoomAttr() {}
  
  public QQLiveAnchorDataRoomAttr(QQLiveAnchorDataRoomAttr paramQQLiveAnchorDataRoomAttr)
  {
    if (paramQQLiveAnchorDataRoomAttr == null) {
      return;
    }
    this.roomId = paramQQLiveAnchorDataRoomAttr.roomId;
    this.roomName = paramQQLiveAnchorDataRoomAttr.roomName;
    this.locationNG = paramQQLiveAnchorDataRoomAttr.locationNG;
    this.locationAT = paramQQLiveAnchorDataRoomAttr.locationAT;
    this.city = paramQQLiveAnchorDataRoomAttr.city;
    this.phoneModel = paramQQLiveAnchorDataRoomAttr.phoneModel;
    this.enableGif = paramQQLiveAnchorDataRoomAttr.enableGif;
    this.poster = paramQQLiveAnchorDataRoomAttr.poster;
    this.posterTime = paramQQLiveAnchorDataRoomAttr.posterTime;
    this.poster3v4 = paramQQLiveAnchorDataRoomAttr.poster3v4;
    this.posterTime3v4 = paramQQLiveAnchorDataRoomAttr.posterTime3v4;
    this.poster16v9 = paramQQLiveAnchorDataRoomAttr.poster16v9;
    this.posterTime16v9 = paramQQLiveAnchorDataRoomAttr.posterTime16v9;
    this.defaultRoomName = paramQQLiveAnchorDataRoomAttr.defaultRoomName;
    this.posterNum = paramQQLiveAnchorDataRoomAttr.posterNum;
    this.liveRoomType = paramQQLiveAnchorDataRoomAttr.liveRoomType;
    this.gameInfo = paramQQLiveAnchorDataRoomAttr.gameInfo;
    this.tags = new QQLiveAnchorDataRoomRichTitle(paramQQLiveAnchorDataRoomAttr.tags);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr
 * JD-Core Version:    0.7.0.1
 */