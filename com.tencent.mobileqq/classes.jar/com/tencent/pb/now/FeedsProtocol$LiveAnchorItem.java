package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedsProtocol$LiveAnchorItem
  extends MessageMicro<LiveAnchorItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field anchor_type = PBField.initUInt32(0);
  public final PBUInt64Field begin_time = PBField.initUInt64(0L);
  public final PBBytesField id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField location = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field room_id = PBField.initUInt32(0);
  public final PBBytesField room_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField room_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<FeedsProtocol.RichTitleElement> rpt_msg_rich_title = PBField.initRepeatMessage(FeedsProtocol.RichTitleElement.class);
  public final PBUInt32Field sub_room_id = PBField.initUInt32(0);
  public FeedsProtocol.UserInfo user_info = new FeedsProtocol.UserInfo();
  public final PBUInt32Field watch_count = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66, 72, 80, 88, 96 }, new String[] { "id", "user_info", "room_name", "rpt_msg_rich_title", "room_img_url", "location", "watch_count", "jump_url", "anchor_type", "room_id", "sub_room_id", "begin_time" }, new Object[] { localByteStringMicro1, null, localByteStringMicro2, null, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, LiveAnchorItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.LiveAnchorItem
 * JD-Core Version:    0.7.0.1
 */