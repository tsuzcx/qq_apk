package com.tencent.mobileqq.qqlive.data.anchor.room;

public class QQLiveAnchorRoomGameInfo
{
  public String icon = "";
  public int id = 0;
  public String name = "";
  public int secondTagId = 0;
  
  public QQLiveAnchorRoomGameInfo() {}
  
  public QQLiveAnchorRoomGameInfo(QQLiveAnchorRoomGameInfo paramQQLiveAnchorRoomGameInfo)
  {
    if (paramQQLiveAnchorRoomGameInfo == null) {
      return;
    }
    this.id = paramQQLiveAnchorRoomGameInfo.id;
    this.name = paramQQLiveAnchorRoomGameInfo.name;
    this.icon = paramQQLiveAnchorRoomGameInfo.icon;
    this.secondTagId = paramQQLiveAnchorRoomGameInfo.secondTagId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo
 * JD-Core Version:    0.7.0.1
 */