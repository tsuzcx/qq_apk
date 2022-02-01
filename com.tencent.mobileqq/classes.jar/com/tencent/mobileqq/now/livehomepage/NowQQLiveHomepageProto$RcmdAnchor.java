package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowQQLiveHomepageProto$RcmdAnchor
  extends MessageMicro<RcmdAnchor>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField advertising_sign = PBField.initString("");
  public final PBUInt32Field allow_play = PBField.initUInt32(0);
  public final PBStringField award_pendant_url = PBField.initString("");
  public NowQQLiveHomepageProto.UserExtraInfo extra_info = new NowQQLiveHomepageProto.UserExtraInfo();
  public final PBUInt32Field hall_room_id = PBField.initUInt32(0);
  public final PBStringField icon_url = PBField.initString("");
  public final PBUInt64Field imsdk_tiny_id = PBField.initUInt64(0L);
  public final PBUInt32Field microphone_flag = PBField.initUInt32(0);
  public NowQQLiveHomepageProto.PropInfo propInfo = new NowQQLiveHomepageProto.PropInfo();
  public NowQQLiveHomepageProto.RoomRichTitle rich_title = new NowQQLiveHomepageProto.RoomRichTitle();
  public final PBUInt32Field room_game_type = PBField.initUInt32(0);
  public final PBStringField rtmp_url = PBField.initString("");
  public final PBStringField string_authentication_tag = PBField.initString("");
  public final PBStringField string_description = PBField.initString("");
  public final PBStringField string_head_img_url = PBField.initString("");
  public final PBStringField string_id = PBField.initString("");
  public final PBStringField string_jump_url = PBField.initString("");
  public final PBStringField string_location = PBField.initString("");
  public final PBStringField string_name = PBField.initString("");
  public final PBStringField string_room_img_url = PBField.initString("");
  public final PBUInt32Field uint32_watch_count = PBField.initUInt32(0);
  public final PBStringField union_channel_sign = PBField.initString("");
  public NowQQLiveHomepageProto.UserTag user_tag = new NowQQLiveHomepageProto.UserTag();
  public final PBUInt32Field video_preview = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 66, 74, 82, 90, 98, 104, 114, 120, 130, 138, 144, 152, 162, 168, 178, 186, 192 }, new String[] { "string_name", "string_id", "string_head_img_url", "string_room_img_url", "string_location", "uint32_watch_count", "string_description", "string_jump_url", "string_authentication_tag", "rich_title", "extra_info", "propInfo", "hall_room_id", "award_pendant_url", "microphone_flag", "user_tag", "rtmp_url", "allow_play", "imsdk_tiny_id", "icon_url", "room_game_type", "advertising_sign", "union_channel_sign", "video_preview" }, new Object[] { "", "", "", "", "", localInteger, "", "", "", null, null, null, localInteger, "", localInteger, null, "", localInteger, Long.valueOf(0L), "", localInteger, "", "", localInteger }, RcmdAnchor.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RcmdAnchor
 * JD-Core Version:    0.7.0.1
 */