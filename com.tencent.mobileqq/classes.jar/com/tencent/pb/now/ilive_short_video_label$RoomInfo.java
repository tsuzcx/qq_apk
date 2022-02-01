package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_short_video_label$RoomInfo
  extends MessageMicro<RoomInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField anchor_logo_640 = PBField.initString("");
  public final PBStringField anchor_logo_80 = PBField.initString("");
  public final PBUInt64Field anchor_uin = PBField.initUInt64(0L);
  public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field get_from_room_info_svr_is_seted = PBField.initUInt32(0);
  public final PBStringField nick_name = PBField.initString("");
  public final PBStringField room_cover_url_640 = PBField.initString("");
  public final PBStringField room_cover_url_90 = PBField.initString("");
  public final PBUInt32Field room_id = PBField.initUInt32(0);
  public final PBStringField room_name = PBField.initString("");
  public final PBUInt32Field subroom_id = PBField.initUInt32(0);
  public final PBRepeatMessageField<ilive_short_video_label.RichTitleElement> title_info = PBField.initRepeatMessage(ilive_short_video_label.RichTitleElement.class);
  public final PBUInt32Field total_money = PBField.initUInt32(0);
  public final PBUInt32Field total_people = PBField.initUInt32(0);
  public final PBUInt32Field total_record_people = PBField.initUInt32(0);
  public final PBStringField vid = PBField.initString("");
  public final PBStringField video_cover_url = PBField.initString("");
  public final PBUInt32Field video_end_action_svr_is_seted = PBField.initUInt32(0);
  public final PBUInt32Field video_end_time = PBField.initUInt32(0);
  public final PBUInt32Field video_start_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56, 64, 74, 82, 88, 98, 106, 112, 122, 130, 136, 146, 400, 408 }, new String[] { "room_id", "subroom_id", "anchor_uin", "vid", "room_name", "title_info", "total_people", "total_money", "room_cover_url_90", "video_cover_url", "video_end_time", "room_cover_url_640", "nick_name", "video_start_time", "anchor_logo_80", "anchor_logo_640", "total_record_people", "city", "video_end_action_svr_is_seted", "get_from_room_info_svr_is_seted" }, new Object[] { localInteger, localInteger, Long.valueOf(0L), "", "", null, localInteger, localInteger, "", "", localInteger, "", "", localInteger, "", "", localInteger, localByteStringMicro, localInteger, localInteger }, RoomInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_short_video_label.RoomInfo
 * JD-Core Version:    0.7.0.1
 */