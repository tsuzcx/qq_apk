package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedsProtocol$VideoItem
  extends MessageMicro<VideoItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field anchor_type = PBField.initUInt32(0);
  public final PBBytesField id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field live_duration_time = PBField.initUInt32(0);
  public final PBBytesField room_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField room_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<FeedsProtocol.RichTitleElement> rpt_msg_rich_title = PBField.initRepeatMessage(FeedsProtocol.RichTitleElement.class);
  public final PBUInt32Field total_money = PBField.initUInt32(0);
  public final PBUInt32Field total_view = PBField.initUInt32(0);
  public FeedsProtocol.UserInfo user_info = new FeedsProtocol.UserInfo();
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_end_time = PBField.initUInt32(0);
  public final PBUInt64Field video_start_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 72, 80, 90, 96, 104, 112 }, new String[] { "id", "user_info", "vid", "room_name", "rpt_msg_rich_title", "video_cover_url", "room_cover_url", "total_view", "total_money", "video_end_time", "jump_url", "anchor_type", "video_start_time", "live_duration_time" }, new Object[] { localByteStringMicro1, null, localByteStringMicro2, localByteStringMicro3, null, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, VideoItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.VideoItem
 * JD-Core Version:    0.7.0.1
 */