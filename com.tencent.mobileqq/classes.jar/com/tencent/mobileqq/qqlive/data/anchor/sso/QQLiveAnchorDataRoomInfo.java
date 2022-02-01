package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import java.util.Arrays;

public class QQLiveAnchorDataRoomInfo
  implements BaseRoomInfo
{
  public int continueLiveStatus;
  public String coverUrl16v9;
  public String coverUrl3v4;
  public QQLiveAnchorRoomGameInfo gameInfo;
  public int giftFlag;
  public long id;
  public int liveRoomType;
  public String name;
  public String poster;
  public String programId;
  public int roomGameType;
  public byte[] roomPrepareNotify;
  public String systemNotice;
  public QQLiveAnchorDataRoomRichTitle tags = new QQLiveAnchorDataRoomRichTitle();
  
  public QQLiveAnchorDataRoomInfo() {}
  
  public QQLiveAnchorDataRoomInfo(QQLiveAnchorDataRoomInfo paramQQLiveAnchorDataRoomInfo)
  {
    if (paramQQLiveAnchorDataRoomInfo == null) {
      return;
    }
    this.id = paramQQLiveAnchorDataRoomInfo.id;
    this.name = paramQQLiveAnchorDataRoomInfo.name;
    this.poster = paramQQLiveAnchorDataRoomInfo.poster;
    this.programId = paramQQLiveAnchorDataRoomInfo.programId;
    this.giftFlag = paramQQLiveAnchorDataRoomInfo.giftFlag;
    this.tags = new QQLiveAnchorDataRoomRichTitle(paramQQLiveAnchorDataRoomInfo.tags);
    this.coverUrl16v9 = paramQQLiveAnchorDataRoomInfo.coverUrl16v9;
    this.coverUrl3v4 = paramQQLiveAnchorDataRoomInfo.coverUrl3v4;
    byte[] arrayOfByte = paramQQLiveAnchorDataRoomInfo.roomPrepareNotify;
    if (arrayOfByte != null) {
      this.roomPrepareNotify = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
    }
    this.roomGameType = paramQQLiveAnchorDataRoomInfo.roomGameType;
    this.systemNotice = paramQQLiveAnchorDataRoomInfo.systemNotice;
    this.continueLiveStatus = paramQQLiveAnchorDataRoomInfo.continueLiveStatus;
    this.liveRoomType = paramQQLiveAnchorDataRoomInfo.liveRoomType;
    this.gameInfo = paramQQLiveAnchorDataRoomInfo.gameInfo;
  }
  
  public String getProgramId()
  {
    return this.programId;
  }
  
  public long getRoomId()
  {
    return this.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo
 * JD-Core Version:    0.7.0.1
 */