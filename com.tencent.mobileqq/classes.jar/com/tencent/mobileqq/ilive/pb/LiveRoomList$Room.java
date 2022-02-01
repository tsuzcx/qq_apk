package com.tencent.mobileqq.ilive.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class LiveRoomList$Room
  extends MessageMicro<Room>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField cover_url = PBField.initString("");
  public final PBUInt64Field popularity = PBField.initUInt64(0L);
  public final PBRepeatMessageField<LiveRoomList.KV> report_info = PBField.initRepeatMessage(LiveRoomList.KV.class);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBStringField title = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "room_id", "cover_url", "title", "popularity", "report_info" }, new Object[] { localLong, "", "", localLong, null }, Room.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ilive.pb.LiveRoomList.Room
 * JD-Core Version:    0.7.0.1
 */