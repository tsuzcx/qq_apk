package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowQQLiveHomepageProto$LiveAnchorItem
  extends MessageMicro<LiveAnchorItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66, 74 }, new String[] { "string_name", "string_id", "string_head_img_url", "string_room_img_url", "string_location", "string_description", "uint32_watch_count", "string_jump_url", "rich_title" }, new Object[] { "", "", "", "", "", "", Integer.valueOf(0), "", null }, LiveAnchorItem.class);
  public NowQQLiveHomepageProto.RoomRichTitle rich_title = new NowQQLiveHomepageProto.RoomRichTitle();
  public final PBStringField string_description = PBField.initString("");
  public final PBStringField string_head_img_url = PBField.initString("");
  public final PBStringField string_id = PBField.initString("");
  public final PBStringField string_jump_url = PBField.initString("");
  public final PBStringField string_location = PBField.initString("");
  public final PBStringField string_name = PBField.initString("");
  public final PBStringField string_room_img_url = PBField.initString("");
  public final PBUInt32Field uint32_watch_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.LiveAnchorItem
 * JD-Core Version:    0.7.0.1
 */