package com.tencent.mobileqq.qqlive.data.room;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class LiveRoomInfo
  implements BaseRoomInfo
{
  public String enterRoomSystemNotice;
  public Bundle extData = new Bundle();
  public int giftFlag;
  public int goodsFlag;
  public long ownerId;
  public String programId;
  public long roomId;
  public String roomLogo;
  public String roomName;
  public int roomType;
  public List<RoomTag> tags = new ArrayList();
  
  public String getProgramId()
  {
    return this.programId;
  }
  
  public long getRoomId()
  {
    return this.roomId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo
 * JD-Core Version:    0.7.0.1
 */