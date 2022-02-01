package com.tencent.mobileqq.ilive.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class LiveRoomList$Room
  extends MessageMicro<Room>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField anchor_name = PBField.initString("");
  public final PBStringField cover_url = PBField.initString("");
  public final PBUInt32Field game_id = PBField.initUInt32(0);
  public final PBUInt32Field game_tag_id = PBField.initUInt32(0);
  public final PBUInt64Field popularity = PBField.initUInt64(0L);
  public final PBRepeatMessageField<LiveRoomList.KV> report_info = PBField.initRepeatMessage(LiveRoomList.KV.class);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBUInt32Field room_type = PBField.initUInt32(0);
  public final PBStringField title = PBField.initString("");
  public final PBUInt64Field video_source = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 56, 64, 72, 82 }, new String[] { "room_id", "cover_url", "title", "popularity", "report_info", "room_type", "video_source", "game_id", "game_tag_id", "anchor_name" }, new Object[] { localLong, "", "", localLong, null, localInteger, localLong, localInteger, localInteger, "" }, Room.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ilive.pb.LiveRoomList.Room
 * JD-Core Version:    0.7.0.1
 */